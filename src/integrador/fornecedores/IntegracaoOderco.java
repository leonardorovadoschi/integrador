/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador.fornecedores;


import entidade.cplus.Produto;
import entidade.integrador.IntLogs;
import entidade.integrador.ProdFornecedor;
import query.integrador.QueryIntegrador;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import jpa.integrador.IntLogsJpaController;
import jpa.integrador.ProdFornecedorJpaController;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import query.cplus.QueryCplus;

/**
 *
 * @author leo
 */
public class IntegracaoOderco {
   
    public void integracaoOderco(EntityManagerFactory managerIntegrador, EntityManagerFactory managerCplus, EntityManagerFactory managerDigimacro) {
        ManipulaFornecedores utilitario = new ManipulaFornecedores();
        
        try {         
            String txt = new QueryIntegrador(managerIntegrador).valorConfiguracao("caminho_ARQUIVO_TXT_ODERCO");          
            File is = new File(txt);         
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document xmlRespostaARequisicao = db.parse(is);
            Element raiz = xmlRespostaARequisicao.getDocumentElement();
            NodeList list = raiz.getElementsByTagName("produto");
            List<ProdutoOderco> listProdOderco = new ArrayList<>();
            for (int i = 0; i < list.getLength(); i++) {
                ProdutoOderco prod = new ProdutoOderco();
                Element endElement = (Element) list.item(i);
                prod.setCodigo(getChildTagValue(endElement, "codigo"));
                prod.setMarca(getChildTagValue(endElement, "marca"));
                prod.setCategoria(getChildTagValue(endElement, "categoria"));
                prod.setTitulo(getChildTagValue(endElement, "titulo"));
                prod.setNome_nota(getChildTagValue(endElement, "nome_nota"));
                prod.setUnidade(getChildTagValue(endElement, "unidade"));
                prod.setMultiplo(Integer.parseInt(getChildTagValue(endElement, "multiplo")));
                prod.setPreco_RS(new BigDecimal(getChildTagValue(endElement, "preco_RS")));
                prod.setDescricao_tecnica(getChildTagValue(endElement, "descricao_tecnica"));
                prod.setEstoque(getChildTagValue(endElement, "estoque"));
                prod.setPeso(new BigDecimal(getChildTagValue(endElement, "peso")));
                prod.setAltura(new BigDecimal(getChildTagValue(endElement, "altura")));
                prod.setLargura(new BigDecimal(getChildTagValue(endElement, "largura")));
                prod.setComprimento(new BigDecimal(getChildTagValue(endElement, "comprimento")));
                prod.setNcm(getChildTagValue(endElement, "ncm"));
                prod.setCodigobarras(getChildTagValue(endElement, "codigobarras"));
                prod.setOrigem(Integer.parseInt(getChildTagValue(endElement, "origem")));
                prod.setFaturamento(Integer.parseInt(getChildTagValue(endElement, "faturamento")));
                prod.setPpb(getChildTagValue(endElement, "ppb"));
                prod.setMpdobem(getChildTagValue(endElement, "mpdobem"));
                prod.setFoto(getChildTagValue(endElement, "foto"));
                prod.setTempo_garantia(getChildTagValue(endElement, "tempo_garantia"));
                prod.setFoto_g(getChildTagValue(endElement, "foto_g"));

                if (!"".equals(prod.getCodigobarras()) && prod.getCodigobarras() != null) {
                    listProdOderco.add(prod);
                    atualizaProdutosOderco(utilitario, prod, managerIntegrador, managerCplus, managerDigimacro); 
                }
            }
            removeProdutosInexistentes(listProdOderco, managerIntegrador, managerDigimacro);
        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(null,"Erro na conexão \n"+ ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"Erro de leitura XML \n"+ ex);
        } catch (ParserConfigurationException | SAXException ex) {
            JOptionPane.showMessageDialog(null,"Erro de Parse \n"+ ex);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Erro de importar /n"+ ex);
        }
    }
    
    public static String getChildTagValue(Element elem, String tagName) throws Exception {
	NodeList children = elem.getElementsByTagName(tagName);
	String result = null;
	 //children, a tag pai que estamos lendo,
	 // por exemplo a tag 
	if (children == null) {
		return result;
	}	
	Element child = (Element) children.item(0);

	if (child == null) {
		return result;
	}
	 //recuperamos o texto contido na tagName   
	result = child.getTextContent();

	return result;
}
    
    private void removeProdutosInexistentes(List<ProdutoOderco> listProOder, EntityManagerFactory managerIntegracao, EntityManagerFactory managerDigimacro) {
        // ManipulaFornecedores utilitario = new ManipulaFornecedores();
        List<ProdFornecedor> listAllIntegrador = new QueryIntegrador(managerIntegracao).listaProdFornecedor("ODERCO");
        for (ProdFornecedor proIntegrador : listAllIntegrador) {
            boolean remover = true;

            for (ProdutoOderco produtoOderco : listProOder) {
                // if (produtoAllnations.getCodigo() == null ? proIntegrador.getCodigo() == null : produtoAllnations.getCodigo().equals(proIntegrador.getCodigo())) {
                String estado;
                if (produtoOderco.getFaturamento() == 1) {
                    estado = "PR";
                } else {
                    estado = "ES";
                }
                if (proIntegrador.getEan().equals(produtoOderco.getCodigobarras()) && proIntegrador.getEstoque().equals(estado)) {
                    // if (produtoAllnations.getEan().equals(proIntegrador.getEan()) && "ALL NATIONS".equals(proIntegrador.getDepartamento()) && ("Sim".equals(produtoAllnations.getDisponivelEs()) || "Sim".equals(produtoAllnations.getDisponivelRj()) || "Sim".equals(produtoAllnations.getDisponivelSc()))) {
                    remover = false;
                    // }
                }
            }
            if (remover) {
                if (proIntegrador.getDisponivel() == 1) {
                    proIntegrador.setDisponivel(0);
                    try {
                        new ProdFornecedorJpaController(managerIntegracao).edit(proIntegrador);
                        
                        criaLog(managerIntegracao, new Date(System.currentTimeMillis()), " Não existe mais na lista All Nations: " + proIntegrador.getDescricao(), "Informar");
                        // System.out.println("Nï¿½o existe mais na lista: " + proIntegrador.getDescricao());
                    } catch (Exception ex) {
                        criaLog(managerIntegracao, new Date(System.currentTimeMillis()), ", Erro na tabela ProdutosAllnations no integrador " + proIntegrador.getDescricao() + "  " + ex, "Erro Ediï¿½ï¿½o");
                    }
                }
            }
        }
    }
    
     private void criarProdutosAllnationsIntegrador(ManipulaFornecedores utilitario, ProdutoOderco prod, EntityManagerFactory managerIntegrador, EntityManagerFactory managerCplus, EntityManagerFactory managerDigimacro) {
        List<Produto> listProdIntegrador = new QueryCplus(managerCplus).listProdutoEan(prod.getCodigobarras());
        for (Produto prodInt : listProdIntegrador) {
            ProdFornecedor proFornecedor = new ProdFornecedor();
            String estado;
            if (prod.getFaturamento() == 1) {
                estado = "PR";
            } else {
                estado = "ES";
            }
            proFornecedor.setCodigoFornecedor(prod.getCodigo());
            proFornecedor.setNomeFornecedor("ODERCO");
            proFornecedor.setDescricao(prod.getTitulo());
            proFornecedor.setReferenceCplus(prodInt.getCodprod());
            proFornecedor.setAtivo(0);

            proFornecedor.setDisponivel(1);
            proFornecedor.setEstoque(estado);

            BigDecimal precoUnitario = prod.getPreco_RS().divide(new BigDecimal(prod.getMultiplo()));
            if (prod.getFaturamento() == 1) {
                proFornecedor.setPrecoCustoComSt(precoUnitario.setScale(2, RoundingMode.UP));
                proFornecedor.setPorcentagemStRs(utilitario.calculoPrcentagemSubstituicao(proFornecedor, managerCplus));
                BigDecimal precoCusto = utilitario.precoComStParaSemSt(proFornecedor.getPorcentagemStRs(), proFornecedor.getPrecoCustoComSt());
                proFornecedor.setPrecoCusto(precoCusto);
                proFornecedor.setPorcentagemOutrosCustos(utilitario.calculaPorcentagemCusto(precoCusto, proFornecedor, managerCplus));
                proFornecedor.setValorStRs(proFornecedor.getPrecoCustoComSt().subtract(precoCusto));
                proFornecedor.setValorCustoRs(utilitario.precoCustoRs(proFornecedor));
            } else {
                proFornecedor.setPorcentagemStRs(utilitario.calculoPrcentagemSubstituicao(proFornecedor, managerCplus));
                BigDecimal precoCusto = precoUnitario.setScale(2, RoundingMode.UP);;
                proFornecedor.setPrecoCusto(precoCusto);
                proFornecedor.setPrecoCustoComSt(utilitario.precoSemStParaComSt(proFornecedor.getPorcentagemStRs(), precoCusto));
                proFornecedor.setPorcentagemOutrosCustos(utilitario.calculaPorcentagemCusto(precoCusto, proFornecedor, managerCplus));
                proFornecedor.setValorStRs(proFornecedor.getPrecoCustoComSt().subtract(precoCusto));
                proFornecedor.setValorCustoRs(utilitario.precoCustoRs(proFornecedor));
            }
            proFornecedor.setSubcategoria(utilitario.previsaoEntrega(estado));

            proFornecedor.setEan(prod.getCodigobarras());
            proFornecedor.setFabricante(prod.getMarca());
            proFornecedor.setUltimaImportacao(new Date(System.currentTimeMillis()));
            proFornecedor.setNcm(prod.getNcm());
            try {
                new ProdFornecedorJpaController(managerIntegrador).create(proFornecedor);

            } catch (Exception ex) {
                criaLog(managerIntegrador, new Date(System.currentTimeMillis()), ", Erro na tabela ProdutosAllnations no integrador " + prod.getTitulo() + "  " + ex, "Erro Edição");
            }
        }
    }
    

    private void atualizaProdutosOderco(ManipulaFornecedores utilitario, ProdutoOderco prod, EntityManagerFactory managerIntegrador, EntityManagerFactory managerCplus, EntityManagerFactory managerDigimacro) {
        String estado;
        if (prod.getFaturamento() == 1) {
            estado = "PR";
        } else {
            estado = "ES";
        }
        List<ProdFornecedor> listProdutoIntegrador = new QueryIntegrador(managerIntegrador).resultEanEEstoque(prod.getCodigobarras(), estado, "ODERCO");
        if (listProdutoIntegrador.isEmpty()) {
            if (prod.getPreco_RS().doubleValue() > 0.00 && "S".equals(prod.getEstoque())) {
               criarProdutosAllnationsIntegrador(utilitario, prod, managerIntegrador, managerCplus, managerDigimacro);
            }
        } else if (listProdutoIntegrador.size() == 1) {
            for (ProdFornecedor proFornecedor : listProdutoIntegrador) {
                BigDecimal precoCusto;
                if (prod.getPreco_RS().doubleValue() > 0.00 && "S".equals(prod.getEstoque())) {
                    proFornecedor.setCodigoFornecedor(prod.getCodigo());
                    proFornecedor.setNomeFornecedor("ODERCO");
                    proFornecedor.setDescricao(prod.getTitulo());
                    proFornecedor.setDisponivel(1);
                    BigDecimal precoUnitario = prod.getPreco_RS().divide(new BigDecimal(prod.getMultiplo()));
                    if (prod.getFaturamento() == 1) {
                        proFornecedor.setPrecoCustoComSt(precoUnitario.setScale(2, RoundingMode.UP));
                        proFornecedor.setPorcentagemStRs(utilitario.calculoPrcentagemSubstituicao(proFornecedor, managerCplus));
                        precoCusto = utilitario.precoComStParaSemSt(proFornecedor.getPorcentagemStRs(), proFornecedor.getPrecoCustoComSt());
                        proFornecedor.setPrecoCusto(precoCusto);
                        proFornecedor.setPorcentagemOutrosCustos(utilitario.calculaPorcentagemCusto(precoCusto, proFornecedor, managerCplus));
                        proFornecedor.setValorStRs(proFornecedor.getPrecoCustoComSt().subtract(precoCusto));
                        proFornecedor.setValorCustoRs(utilitario.precoCustoRs(proFornecedor));
                        //proAllIntegrador.setSubcategoria(utilitario.previsaoEntrega("PR"));
                    } else {
                        proFornecedor.setPorcentagemStRs(utilitario.calculoPrcentagemSubstituicao(proFornecedor, managerCplus));
                        precoCusto = precoUnitario.setScale(2, RoundingMode.UP);
                        proFornecedor.setPrecoCusto(precoCusto);
                        proFornecedor.setPrecoCustoComSt(utilitario.precoSemStParaComSt(proFornecedor.getPorcentagemStRs(), precoCusto));
                        proFornecedor.setPorcentagemOutrosCustos(utilitario.calculaPorcentagemCusto(precoCusto, proFornecedor, managerCplus));
                        proFornecedor.setValorStRs(proFornecedor.getPrecoCustoComSt().subtract(precoCusto));
                        proFornecedor.setValorCustoRs(utilitario.precoCustoRs(proFornecedor));
                    }
                    proFornecedor.setEan(prod.getCodigobarras());
                    proFornecedor.setFabricante(prod.getMarca());
                    proFornecedor.setUltimaImportacao(new Date(System.currentTimeMillis()));
                    proFornecedor.setNcm(prod.getNcm());
                    //proAllIntegrador.setPartNumber(prodAll.getPARTNUMBER());

                    try {
                        new ProdFornecedorJpaController(managerIntegrador).edit(proFornecedor);
                       
                    } catch (Exception ex) {
                        criaLog(managerIntegrador, new Date(System.currentTimeMillis()), ", Erro na tabela ProdutosAllnations no integrador " + prod.getTitulo() + "  " + ex, "Erro Ediï¿½ï¿½o");
                    }

                } else {
                    proFornecedor.setDisponivel(0);
                    try {
                        new ProdFornecedorJpaController(managerIntegrador).edit(proFornecedor);
                        
                    } catch (Exception ex) {
                        criaLog(managerIntegrador, new Date(System.currentTimeMillis()), ", Erro na tabela ProdutosAllnations no integrador " + prod.getTitulo() + "  " + ex, "Erro Ediï¿½ï¿½o");
                    }
                    // }
                }
            }
        }

    }

  
   private void criaLog(EntityManagerFactory managerIntegracao, Date dataExecucao, String mensagem, String tipoLog) {
        IntLogs log = new IntLogs();
        log.setDataExecucao(dataExecucao);

        log.setMensagem(mensagem);
        log.setTipoLog(tipoLog);
        new IntLogsJpaController(managerIntegracao).create(log);
    }
    
}
