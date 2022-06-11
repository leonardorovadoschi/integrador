/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pedido;

import entidade.cplus.Contareceber;
import entidade.cplus.Movenda;
import entidade.cplus.Movendaprod;
import entidade.cplus.Movendaprodserial;
import entidade.cplus.Unidade;
import entidade.integrador.IntLogs;
import entidade.prestaShop.PsOrderDetail;
import entidade.prestaShop.PsOrderHistory;
import entidade.prestaShop.PsOrderInvoice;
import entidade.prestaShop.PsOrderInvoicePayment;
import entidade.prestaShop.PsOrderInvoicePaymentPK;
import entidade.prestaShop.PsOrderPayment;
import entidade.prestaShop.PsOrders;
import entidade.prestaShop.PsStockAvailable;
import query.cplus.QueryCplus;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import jpa.integrador.IntLogsJpaController;
import jpa.prestaShop.PsOrderHistoryJpaController;
import jpa.prestaShop.PsOrderInvoiceJpaController;
import jpa.prestaShop.PsOrderInvoicePaymentJpaController;
import jpa.prestaShop.PsOrderPaymentJpaController;
import jpa.prestaShop.PsOrdersJpaController;
import jpa.prestaShop.PsProductJpaController;
import jpa.prestaShop.PsStockAvailableJpaController;
import query.prestaShop.QueryPrestaShop;

/**
 *
 * @author leo
 */
public class AtualizaPedidoCplusDigimacro {

    boolean condicaoErro;

    private boolean isCondicaoErro() {
        return condicaoErro;
    }

    private void setCondicaoErro(boolean condicaoErro) {
        this.condicaoErro = condicaoErro;
    }

    /**
     * Função que cuida da atualização do pedido, faz as operações no integrador
     * e no Magento
     *
     * @param managerIntegracao
     * @param managerDigimacro seria da loja em que vai ser atualizado
     * @param managerCplus
     * @param order
     * @return false se houve erros
     */
    public boolean atualizarPedido(EntityManagerFactory managerIntegracao, EntityManagerFactory managerDigimacro, EntityManagerFactory managerCplus, PsOrders order) {
        setCondicaoErro(true);
        List<Movenda> listmovenda = new QueryCplus(managerCplus).resultMovendaPorEntregaTelefone(order.getReference(), 'N');
        if (listmovenda.size() == 1) {
            for (Movenda movenda : listmovenda) {
                if (pedidoSeparado(movenda, managerCplus)) {//if que verifica se pedido já foi separado    
                    criaLog(new Date(System.currentTimeMillis()), ", Pedido Atualizado Nº Pedido: " + movenda.getNumped(), "Edição", managerIntegracao);
                    atualizaPedido(true, managerCplus, managerDigimacro, managerIntegracao, order, movenda);
                } else {//fim if que verifica se o pedido já foi separado
                    criaLog(new Date(System.currentTimeMillis()), ", Pedido não Separado Nº pedido: " + movenda.getNumped(), "Erro Edição", managerIntegracao);
                    atualizaPedido(false, managerCplus, managerDigimacro, managerIntegracao, order, movenda);
                }
            }//fim for movenda
        } else if (listmovenda.size() > 1) {
            for (Movenda movenda : listmovenda) {
                criaLog(new Date(System.currentTimeMillis()), ", Existe mais que um pedido com o memo ENTREGATELEFONE, pedido C-Plus: " + movenda.getNumped(), "Erro Atualização Pedido", managerIntegracao);
            }
        }
        return isCondicaoErro();
    }

    private String mensagemInvoice(Contareceber contaCplus) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String mens = "";
        if (contaCplus.getDatpag() != null) {
            mens = "Fatura Nº " + contaCplus.getNumdoc() + ", Quitada: " + simpleDateFormat.format(contaCplus.getDatpag());
        } else {
            if (contaCplus.getNossonumero() == null) {
                mens = "Fatura Nº " + contaCplus.getNumdoc() + ", Vencimento: " + simpleDateFormat.format(contaCplus.getDatvenc());
            } else {
                if ("000003".equals(contaCplus.getCodcontabancaria().getCodigo())) {//referente a cobrança sicredi
                    CalculoBoletoSicredi cbs = new CalculoBoletoSicredi();
                    cbs.atualizandoCalculos(contaCplus);
                    mens = "Fatura Nº " + contaCplus.getNumdoc() + ", Vencimento: " + simpleDateFormat.format(contaCplus.getDatvenc()) + " <br/><br/>"
                            + "Nosso Número: " + cbs.getNossoNumeroCompleto() + " <br/><br/>"
                            + "Linha Digitável: <br/>" + cbs.getLinhaDigitalizavel() + " <br/><br/>"
                            + "<p><a title=\"boleto sicredi\" href=\"https://si-web.sicredi.com.br/boletoweb/BoletoWeb.servicos.Index.task\" target=\"_blank\"><span style=\"font-size: medium;\">2&ordm; Via do Boleto</span></a></p>"
                            + "CPF/CNPJ do Beneficiário: 14097248/0001-27 <br/>CPF/CNPJ do Pagador: " + contaCplus.getCodcli().getCnpj() + " <br/>Nosso Número: " + cbs.getNossoNumeroCompleto() + " <br/><br/>";
                } else if ("000002".equals(contaCplus.getCodcontabancaria().getCodigo())) {//referente cobrança banco do brasil
                    mens = "Nº Documento: " + contaCplus.getNumdoc() + ", Vencimento: " + simpleDateFormat.format(contaCplus.getDatvenc()) + " <br/><br/>"
                            + "<p><a title=\"boleto sicredi\" href=\"https://www63.bb.com.br/portalbb/boleto/boletos/hc21e,802,3322,10343.bbx?_ga=2.141079474.1457188320.1534447224-369634774.1533134572\" target=\"_blank\"><span style=\"font-size: medium;\">2&ordm; Via do Boleto</span></a></p>"
                            + "CPF/CNPJ do Cedente: 14.097.248/0001-27 <br/>CPF/CNPJ do Sacado: " + contaCplus.getCodcli().getCnpj() + " <br/>Nosso Número: " + contaCplus.getNossonumero().toString() + " <br/><br/>";
                }
            }
        }
        return mens;
    }

    private Integer calculaState(Contareceber contasReceber) {
        int valor;
        if ("Y".equals(contasReceber.getFlagpago().toString())) {
            valor = 2;
        } else {
            valor = 1;
        }
        return valor;
    }

    private void atualizaPedido(boolean separado, EntityManagerFactory managerCplus, EntityManagerFactory managerDigimacro, EntityManagerFactory managerIntegracao, PsOrders order, Movenda movenda) {
        int currentState;
        if (separado) {
            if (order.getCurrentState() != 5) {
                currentState = 5;
                order.setCurrentState(currentState);
                psOrderHistory(currentState, order, managerDigimacro, managerIntegracao);
            }
        } else {
            if (order.getCurrentState() != 4) {
                currentState = 4;
                order.setCurrentState(currentState);
                psOrderHistory(currentState, order, managerDigimacro, managerIntegracao);
            }
        }
        try {
            new PsOrdersJpaController(managerDigimacro).edit(order);
            atualizaReservas(managerDigimacro, managerIntegracao, order);
            orderInvoice(order, movenda, managerCplus, managerDigimacro, managerIntegracao);

        } catch (jpa.prestaShop.exceptions.IllegalOrphanException ex) {
            setCondicaoErro(false);
            criaLog(order.getDateUpd(), ", SalesFlatOrdert " + order.getReference() + " " + ex, "Erro Edição", managerIntegracao);
        } catch (Exception ex) {
            setCondicaoErro(false);
            criaLog(order.getDateAdd(), ", SalesFlatOrdert " + order.getReference() + " " + ex, "Erro Edição", managerIntegracao);
        }
    }

    private String mensagemEntrega(EntityManagerFactory managerCplus, PsOrders order) {
        String mensagem = "Seriais Dos Produtos: <br/>";
        QueryCplus querySerial = new QueryCplus(managerCplus);
        List<Movendaprod> listProdSaida = querySerial.listMovendaProdEntregaTelefone(order.getReference());
        for (Movendaprod prod : listProdSaida) {
            mensagem = mensagem + prod.getCodprod().getNomeprod() + ": <br/>";
            int contSerial = 0;
            for (Movendaprodserial ser : querySerial.listagemSaidaSerialPorMovProduto(prod.getCodmovprod())) {
                contSerial++;
                if (contSerial == 1) {
                    mensagem = mensagem + ser.getCodprodutoserial().getSerial();
                } else {
                    mensagem = mensagem + ", " + ser.getCodprodutoserial().getSerial();
                }
                if (contSerial > 5) {
                    contSerial = 0;
                    mensagem = mensagem + " <br/>";
                }
            }
            mensagem = mensagem + " <br/> <br/>";
        }
        return mensagem;
    }

    private boolean pedidoSeparado(Movenda movenda, EntityManagerFactory managerCplus) {
        boolean condicao = false;
        List<Movendaprod> listMovendaProd = new QueryCplus(managerCplus).listMovendaProd(movenda.getCodmovenda());
        int quanMovendaProd = 0;
        for (Movendaprod prod : listMovendaProd) {
            quanMovendaProd = quanMovendaProd + quantidadeSaida(prod, managerCplus);
        }
        List<Movendaprodserial> listSerial = new QueryCplus(managerCplus).listSerialSaida(movenda.getCodmovenda());
        if (quanMovendaProd == listSerial.size()) {
            condicao = true;
        }
        return condicao;
    }

    private int quantidadeSaida(Movendaprod movendaProd, EntityManagerFactory managerCplus) {
        int quantidade = movendaProd.getQuantidade().intValue();
        for (Unidade un : new QueryCplus(managerCplus).resultPorUnidadeProduto(movendaProd.getCodprod().getUnidade())) {
            if (un.getFatorconversao().intValue() > 1) {
                quantidade = quantidade / un.getFatorconversao().intValue();
            }
        }

        return quantidade;
    }

    private void criaLog(Date dataExecucao, String mensagem, String tipoLog, EntityManagerFactory managerIntegracao) {
        IntLogs log = new IntLogs();
        log.setDataExecucao(dataExecucao);

        log.setMensagem(mensagem);
        log.setTipoLog(tipoLog);
        new IntLogsJpaController(managerIntegracao).create(log);
    }

    private void psOrderHistory(Integer currentState, PsOrders order, EntityManagerFactory managerDigimacro, EntityManagerFactory managerIntegracao) {
        PsOrderHistory orderHistory = new PsOrderHistory();
        orderHistory.setDateAdd(new Date(System.currentTimeMillis()));
        orderHistory.setIdEmployee(1);
        orderHistory.setIdOrder(order.getIdOrder());
        orderHistory.setIdOrderState(currentState);
        new PsOrderHistoryJpaController(managerDigimacro).create(orderHistory);

    }

    private void orderInvoice(PsOrders order, Movenda movenda, EntityManagerFactory managerCplus, EntityManagerFactory managerDigimacro, EntityManagerFactory managerIntegracao) {     
        List<PsOrderInvoice> lOi = new QueryPrestaShop(managerDigimacro).listOsOrderInvoic(order.getIdOrder());
        if (lOi.isEmpty()) {
            PsOrderInvoice oi = new PsOrderInvoice();
            oi.setIdOrder(order.getIdOrder());
            oi.setNumber(1);
            oi.setDeliveryNumber(1);
            oi.setDeliveryDate(new Date(System.currentTimeMillis()));
            oi.setTotalDiscountTaxExcl(order.getTotalDiscountsTaxExcl());
            oi.setTotalDiscountTaxIncl(order.getTotalDiscountsTaxIncl());
            oi.setTotalPaidTaxExcl(order.getTotalPaidTaxExcl());
            oi.setTotalPaidTaxIncl(order.getTotalPaidTaxIncl());
            oi.setTotalProducts(order.getTotalProducts());
            oi.setTotalProductsWt(order.getTotalProductsWt());
            oi.setTotalShippingTaxExcl(order.getTotalShippingTaxExcl());
            oi.setTotalShippingTaxIncl(order.getTotalShippingTaxIncl());
            oi.setShippingTaxComputationMethod(0);
            oi.setTotalWrappingTaxExcl(order.getTotalWrappingTaxExcl());
            oi.setTotalWrappingTaxIncl(order.getTotalWrappingTaxIncl());
            oi.setShopAddress("Lajeado - RS");
            oi.setNote("");
            oi.setDateAdd(new Date(System.currentTimeMillis()));
            new PsOrderInvoiceJpaController(managerDigimacro).create(oi);          
        }
        for (PsOrderInvoice oi : new QueryPrestaShop(managerDigimacro).listOsOrderInvoic(order.getIdOrder())) {
            List<PsOrderPayment> listOP = new QueryPrestaShop(managerDigimacro).listPsOrderPayment(order.getReference());
            if (listOP.isEmpty()) {
                PsOrderPayment op = new PsOrderPayment();
                op.setOrderReference(order.getReference());
                op.setDateAdd(new Date(System.currentTimeMillis()));
                op.setIdCurrency(1);
                op.setAmount(order.getTotalPaidTaxIncl());
                op.setPaymentMethod("Pagamento");
                op.setConversionRate(BigDecimal.ONE);
                op.setTransactionId("");
                op.setCardNumber("");
                op.setCardBrand("");
                op.setCardExpiration("");
                op.setCardHolder("");
                new PsOrderPaymentJpaController(managerDigimacro).create(op);
            }
            listOP = new QueryPrestaShop(managerDigimacro).listPsOrderPayment(order.getReference());
            for (PsOrderPayment op : listOP) {
                PsOrderInvoicePayment oip = new PsOrderInvoicePayment();
                oip.setPsOrderInvoicePaymentPK(new PsOrderInvoicePaymentPK(oi.getIdOrderInvoice(), op.getIdOrderPayment()));
                oip.setIdOrder(order.getIdOrder());
                try {
                    new PsOrderInvoicePaymentJpaController(managerDigimacro).edit(oip);
                } catch (Exception ex) {
                    criaLog(oi.getDateAdd(), ", PsOrderInvoicePayment " + order.getReference() + " " + ex, "Erro Criar", managerIntegracao);
                }
            }
        }
    }

    private void atualizaReservas(EntityManagerFactory managerDigimacro, EntityManagerFactory managerIntegracao, PsOrders order) {
        for (PsOrderDetail item : new QueryPrestaShop(managerDigimacro).listPsOrderDetail(order.getIdOrder())) {
            int idProduct = new PsProductJpaController(managerDigimacro).findPsProduct(item.getProductId()).getIdProduct();
            for (PsStockAvailable sa : new QueryPrestaShop(managerDigimacro).listEstoqueProduto(idProduct)) {
                int novo = sa.getReservedQuantity() - item.getProductQuantity();
                if (novo > 0) {
                    sa.setReservedQuantity(novo);
                    try {
                        new PsStockAvailableJpaController(managerDigimacro).edit(sa);
                    } catch (Exception ex) {
                        criaLog(new Date(System.currentTimeMillis()), ", PsStockAvailable " + order.getReference() + " " + ex, "Erro Editar", managerIntegracao);
                    }
                }
            }
        }
    }
}
