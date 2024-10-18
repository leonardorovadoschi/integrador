/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pedido;

import entidade.cplus.Contareceber;
import entidade.cplus.Movenda;
import entidade.cplus.Movendaprod;
import entidade.cplus.Nfceletronica;
import entidade.cplus.Orcamento;
import entidade.cplus.Orcamentoprod;
import entidade.cplus.Produto;
import entidade.cplus.Produtoestoque;
import entidade.cplus.Unidade;
import entidade.prestaShop.PsOrderDetail;
import entidade.prestaShop.PsOrders;
import entidade.prestaShop.PsPack;
import janela.cplus.FormataCampos;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import jpa.cplus.ClienteJpaController;
import jpa.cplus.ContareceberJpaController;
import jpa.cplus.MovendaJpaController;
import jpa.cplus.MovendaprodJpaController;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.prestaShop.PsProductJpaController;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import query.cplus.QueryCplus;
import query.integrador.QueryIntegrador;
import query.prestaShop.QueryPrestaShop;

/**
 *
 * @author leo
 */
public class ManutencaoVenda {

    public void alteraValorProdutos(QueryCplus queryCplus, Movenda movenda, PsOrders order, EntityManagerFactory managerCplus, EntityManagerFactory managerPrestaShop, EntityManagerFactory managerIntegrador) {
        for (Movendaprod movProdCplus : movenda.getMovendaprodCollection()) {
            for (PsOrderDetail item : new QueryPrestaShop(managerPrestaShop).listPsOrderDetail(order.getIdOrder())) {
                if (movProdCplus.getCodprod().getCodprod().equals(new PsProductJpaController(managerPrestaShop).findPsProduct(item.getProductId()).getReference())) {

                    //prodCplus.setValortotal(item.getTotalPriceTaxIncl());

                    //prodCplus.setValorunitario(item.getUnitPriceTaxIncl());
                   // BigDecimal quanConvertida = new BigDecimal(item.getProductQuantity()).multiply(fatorConversaoBigDecimal(movProdCplus.getCodprod(), managerCplus));
                   //BigDecimal valUni = item.getTotalPriceTaxIncl().divide(quanConvertida, 2, BigDecimal.ROUND_HALF_DOWN);
                    BigDecimal valUni = item.getUnitPriceTaxIncl().divide(movProdCplus.getQuantidade(), 2 , RoundingMode.HALF_UP);
                    //valUni = new ValoresOrder().valorUnitario(valUni);
                    //BigDecimal valorTotal = new ValoresOrder().valorTotalItem(valUni, quanConvertida.intValue());
                    //BigDecimal valorTotal = item.getTotalPriceTaxIncl();
                    movProdCplus.setValorunitario(valUni);
                    movProdCplus.setValortotal(item.getTotalPriceTaxIncl());
                }
            }
            try {
                new MovendaprodJpaController(managerCplus).edit(movProdCplus);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao editar!!!\n" + ex);
            }
        }
        editaMovenda(queryCplus, movenda, new ValoresOrder().valorTotalPredido(order), managerCplus, managerIntegrador);
    }
       

    private void editaMovenda(QueryCplus queryCplus, Movenda movenda, BigDecimal valorTotalPedido, EntityManagerFactory managerCplus, EntityManagerFactory managerIntegrador) {
        movenda.setValortotalnota(valorTotalPedido);
        movenda.setCodcli(new ClienteJpaController(managerCplus).findCliente(new QueryIntegrador().valorConfiguracao("cliente_CODIGO_PARA_CUPOM")));
        try {
            new MovendaJpaController(managerCplus).edit(movenda);
            for (Contareceber cr : queryCplus.resultReceberPorVenda(movenda.getCodmovenda())) {
                cr.setValor(valorTotalPedido);
                new ContareceberJpaController(managerCplus).edit(cr);
            }
        } catch (NonexistentEntityException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar total pedido!!!\n" + ex);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar total pedido!!!\n" + ex);
        }
    }

    public List<Orcamentoprod> imprimirOrcamento(PsOrders order, EntityManagerFactory managerCplus, EntityManagerFactory managerPrestaShop) {
        List<Orcamento> lidtOrcamento = new QueryCplus(managerCplus).listOrcamentoEntregaTelefone(order.getReference());
        List<Orcamentoprod> listMov = new ArrayList<>();
        for (Orcamento orc : lidtOrcamento) {
            //List<SalesFlatOrderItem> listProduto = new PedidoProdutoIntegradorJpaController(managerIntegracao).codigoPedido(pedidoIntegrador.getIdPedido());
            for (Orcamentoprod orcProd : orc.getOrcamentoprodCollection()) {
                for (PsOrderDetail item : new QueryPrestaShop(managerPrestaShop).listPsOrderDetail(order.getIdOrder())) {
                    if (new PsProductJpaController(managerPrestaShop).findPsProduct(item.getProductId()).getCacheIsPack()) {
                        for (PsPack psP : new QueryPrestaShop(managerPrestaShop).listPack(new PsProductJpaController(managerPrestaShop).findPsProduct(item.getProductId()).getIdProduct())) {
                            item.setProductId(psP.getPsPackPK().getIdProductItem());
                        }
                    }
                    if (orcProd.getCodprod().getCodprod().equals(new PsProductJpaController(managerPrestaShop).findPsProduct(item.getProductId()).getReference())) {
                        orcProd.setValorunitario(item.getUnitPriceTaxIncl());
                        //double precoTotalLiquido = precoUnitarioLiquido * quantidadeItem;
                        orcProd.setValortotal(item.getTotalPriceTaxIncl());
                        for (Produtoestoque estoque : orcProd.getCodprod().getProdutoestoqueCollection()) {
                            orcProd.setValorii(estoque.getEstatu().subtract(estoque.getReservadoorcamento()));
                        }
                        listMov.add(orcProd);
                        //valorTotalPedido = valorTotalPedido + precoTotalLiquido;
                    }
                }
            }
            orc.setValortotal(order.getTotalPaidTaxIncl());
        }
        return listMov;
    }

    public List<Movendaprod> listaRelatorio(Movenda moVenda, Nfceletronica nfc) {
        List<Movendaprod> listMov = new ArrayList<>();
        InputStream is = new ByteArrayInputStream(nfc.getXmlnfceletronicaaut().getBytes());
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db;
        try {
            db = dbf.newDocumentBuilder();

            Document xmlRespostaARequisicao = db.parse(is);
            Element raiz = xmlRespostaARequisicao.getDocumentElement();

            moVenda.setIdentrega(nfc.getCodnfceletronica()); // referente ao numero do cumpom
            moVenda.setEntregareferencia(nfc.getChaveacessonfceletronica()); //referente a chave de acesso
            moVenda.setNumpedcliente(formatString(nfc.getNumeroprotocolonfceletronica(), "#### #### #### #### #### #### #### #### #### #### ####")); //referente ao numero do protocolo
            moVenda.setEntregaendereco(new FormataCampos().dataStringSoHora(nfc.getDatahorarecebimento(), 0));
            moVenda.setDataemissao(nfc.getDatahoraemissao());
            moVenda.setNumtransf(moVenda.getMovendaprodCollection().size());

            NodeList list = raiz.getElementsByTagName("infAdic");
            for (int i = 0; i < list.getLength(); i++) {
                Element endElement = (Element) list.item(i);
                moVenda.setMotivocancelamento(getChildTagValue(endElement, "infCpl"));//equivale a informações comprementares
            }
            list = raiz.getElementsByTagName("infNFeSupl");
            for (int i = 0; i < list.getLength(); i++) {
                Element endElement = (Element) list.item(i);
                moVenda.setObsnotafiscal(getChildTagValue(endElement, "qrCode"));//equivale a informações QR-code
            }
        } catch (ParserConfigurationException ex) {
            JOptionPane.showMessageDialog(null, "Erro de leitura XML da NFC-e/n" + ex);
        } catch (SAXException | IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro de leitura XML da NFC-e/n" + ex);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro de leitura XML da NFC-e/n" + ex);
        }
        for (Movendaprod movProd : moVenda.getMovendaprodCollection()) {
            listMov.add(movProd);
        }
        return listMov;
    }

    private static String getChildTagValue(Element elem, String tagName) throws Exception {
        NodeList children = elem.getElementsByTagName(tagName);
        String result = null;
        //children, a tag pai que estamos lendo,
        // por exemplo a tag 
        if (children == null) {
            return result;
        }
        //child, a tag que queremos recuperar o valor, por exemplo
        //a tag 
        Element child = (Element) children.item(0);

        if (child == null) {
            return result;
        }
        //recuperamos o texto contido na tagName   
        result = child.getTextContent();

        return result;
    }

    private static String formatString(String string, String mask) {

        return string;
    }

}
