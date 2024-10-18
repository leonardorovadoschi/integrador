/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador.fornecedores;

import entidade.cplus.Calculoicmsestado;
import entidade.cplus.Produto;
import entidade.integrador.ProdFornecedor;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.swing.JOptionPane;
import jpa.cplus.ProdutoJpaController;
import query.cplus.QueryCplus;

/**
 *
 * @author leonardo
 */
public class ManipulaFornecedores {

    /**
     * Funï¿½ï¿½o que recebe uma string do tivo R$ 1.000,00 e converte em
     * BigDecimal
     *
     * @param preco
     * @return
     */
    public BigDecimal ajustaPrecoString(String preco) {
        String precoSt = preco.replace("R$", "");
        String textValue = precoSt.trim();
        int virgula = precoSt.split(",").length;
        int ponto = precoSt.split(".").length;
        if (virgula > 0) {
            textValue = textValue.replace(".", "");
            textValue = textValue.replaceAll(",", ".");
        }
        if (virgula == 0 && ponto == 0) {
            double valor = new Double(textValue);
            textValue = String.valueOf(valor);
        }
        if (textValue.equals("")) {
            return BigDecimal.ZERO;
        } else {
            BigDecimal bdValue = BigDecimal.ZERO;
            try {
                bdValue = new BigDecimal(textValue);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Alguns dos campos de valores\n Não São Válido" + ex);
            }
            //round half up the number using the scale given by the configuration
            bdValue = bdValue.setScale(4, RoundingMode.HALF_UP);
            return bdValue;
        }
    }

    public String previsaoEntrega(String estadoUf) {
        String retorno;
        switch (estadoUf) {
            case "PR":
                retorno = "4 dias (úteis).";
                break;
            case "ES":
                retorno = "6 dias (úteis).";
                break;
            case "RJ":
                retorno = "5 dias (úteis).";
                break;
            case "SC":
                retorno = "3 dias (úteis).";
                break;
            case "SP":
                retorno = "5 dias (úteis).";
                break;
            default:
                retorno = "Sem Previsão.";
        }
        return retorno;
    }

    public String previsaoEntregaLegiao(String estadoUf) {
        String retorno;
        switch (estadoUf) {
            case "PR":
                retorno = "4 dias (úteis) Para Postagem";
                break;
            case "ES":
                retorno = "6 dias (úteis) Para Postagem";
                break;
            case "RJ":
                retorno = "5 dias (úteis) Para Postagem";
                break;
            case "SC":
                retorno = "3 dias (úteis) Para Postagem";
                break;
            case "SP":
                retorno = "5 dias (úteis) Para Postagem";
                break;
            default:
                retorno = "Sem Previsão";
        }
        return retorno;
    }

    /**
     * Funï¿½ï¿½o que devolve o custo do produto sem st
     *
     * @param porcentagemSt
     * @param precoComSt
     * @return valor sem st
     */
    public BigDecimal precoComStParaSemSt(BigDecimal porcentagemSt, BigDecimal precoComSt) {
        double precoSemSt;
        double aliqSt = porcentagemSt.doubleValue();
        double aliqTotal = (aliqSt / 100) + 1.00;
        precoSemSt = precoComSt.doubleValue() / aliqTotal;
        return new BigDecimal(precoSemSt);
    }

    /**
     * funï¿½ï¿½o que devolve o preï¿½o com st
     *
     * @param porcentagemSt
     * @param precoSemSt
     * @return
     */
    public BigDecimal precoSemStParaComSt(BigDecimal porcentagemSt, BigDecimal precoSemSt) {
        double precoComSt;
        double aliqSt = porcentagemSt.doubleValue();
        double aliqTotal = (aliqSt / 100) + 1.00;
        precoComSt = precoSemSt.doubleValue() * aliqTotal;
        return new BigDecimal(precoComSt);
    }

    public BigDecimal precoCustoRs(ProdFornecedor proAllnations) {
        double aliqSt = proAllnations.getPorcentagemStRs().doubleValue() / 100;
        double aliqOutrosCustos = proAllnations.getPorcentagemOutrosCustos().doubleValue() / 100;
        double aliqTotal = (aliqOutrosCustos + aliqSt) + 1;
        double valortotal = proAllnations.getPrecoCusto().doubleValue() * aliqTotal;
        return new BigDecimal(valortotal).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal calculaPorcentagemCusto(BigDecimal custoSemSt, ProdFornecedor prodFornecedor, EntityManagerFactory managerCplus) {
        QueryCplus queryCplus = new QueryCplus();
        //int quantidadeEstoque = 0;
        double aliqPisCofins = 9.25;
        double aliqIcmsEntrada;
        double aliqIcmsSaida = 0.00;
        double custoProdutoUnitario;
        // double custoMedioProdutoUnitario;
        double creditoPisCofins;
        double creditoIcms;
        double valorIpiUnitario;
        double valorStUnitario;
        double debitoPisCofin;
        double debitoIcms;
        double porcentagemLugro = 1.10;//porcentagem com multiplicaï¿½ï¿½o de soma
        double valorUnitarioComTributosComLucro;
        double diferencaPisCofins;
        double diferencaIcms;
        double porcentagemCusto = 0.00;
        boolean condicaoSt = false;
        boolean condicaoIcms = false;
        boolean condicao = false;
        do {
            Produto prodCplus = new ProdutoJpaController(managerCplus).findProduto(prodFornecedor.getReferenceCplus());
            custoProdutoUnitario = custoSemSt.doubleValue();
            List<Calculoicmsestado> listIcmsEstado = queryCplus.listcalculoIcmsEstadol("RS", "RS", "5405", prodCplus.getCodcalculoicms().getCodcalculoicms());
            if (listIcmsEstado.size() == 1) {
                creditoPisCofins = (custoProdutoUnitario * aliqPisCofins) / 100.00;
                valorIpiUnitario = 0.00;
                valorStUnitario = (custoSemSt.doubleValue() * calculoPrcentagemSubstituicao(prodFornecedor, managerCplus).doubleValue()) / 100;
                valorUnitarioComTributosComLucro = (valorIpiUnitario + valorStUnitario + custoProdutoUnitario) * porcentagemLugro;
                debitoPisCofin = (valorUnitarioComTributosComLucro * aliqPisCofins) / 100.00;
                diferencaPisCofins = debitoPisCofin - creditoPisCofins;
                //soma valor tributos com lucro
                valorUnitarioComTributosComLucro = (valorIpiUnitario + valorStUnitario + custoProdutoUnitario + diferencaPisCofins) * porcentagemLugro;
                debitoPisCofin = (valorUnitarioComTributosComLucro * aliqPisCofins) / 100.00;
                diferencaPisCofins = debitoPisCofin - creditoPisCofins;
                porcentagemCusto = (diferencaPisCofins / custoProdutoUnitario) * 100.00;

            } else {
                condicaoSt = true;
            }
            listIcmsEstado = queryCplus.listcalculoIcmsEstadol("RS", "RS", "5102", prodCplus.getCodcalculoicms().getCodcalculoicms());
            if (listIcmsEstado.size() == 1) {
                aliqIcmsEntrada = localizaCalculoIcmsEntrada(prodFornecedor, managerCplus).getAliqicms().doubleValue();
                creditoIcms = (custoProdutoUnitario * aliqIcmsEntrada) / 100.00;
                creditoPisCofins = (custoProdutoUnitario * aliqPisCofins) / 100.00;
                valorIpiUnitario = 0.00;
                valorUnitarioComTributosComLucro = (custoProdutoUnitario + valorIpiUnitario) * porcentagemLugro;
                for (Calculoicmsestado icmsEstado : listIcmsEstado) {
                    double aliqIcms = 0.00;
                    double aliqReducaoIcms = 0.00;
                    if (icmsEstado.getAliqicms() != null) {
                        aliqIcms = icmsEstado.getAliqicms().doubleValue();
                    }
                    if (icmsEstado.getAliqreducaobaseicms() != null) {
                        aliqReducaoIcms = icmsEstado.getAliqreducaobaseicms().doubleValue();
                    }
                    aliqIcmsSaida = (aliqIcms * (100 - aliqReducaoIcms)) / 100;
                }
                debitoIcms = (valorUnitarioComTributosComLucro * aliqIcmsSaida) / 100.00;
                debitoPisCofin = (valorUnitarioComTributosComLucro * aliqPisCofins) / 100.00;
                diferencaIcms = debitoIcms - creditoIcms;
                diferencaPisCofins = debitoPisCofin - creditoPisCofins;
                //soma valor tributos 
                valorUnitarioComTributosComLucro = (custoProdutoUnitario + valorIpiUnitario + diferencaIcms + diferencaPisCofins) * porcentagemLugro;
                debitoIcms = (valorUnitarioComTributosComLucro * aliqIcmsSaida) / 100.00;
                debitoPisCofin = (valorUnitarioComTributosComLucro * aliqPisCofins) / 100.00;
                diferencaIcms = debitoIcms - creditoIcms;
                diferencaPisCofins = debitoPisCofin - creditoPisCofins;
                porcentagemCusto = ((diferencaIcms + diferencaPisCofins) / custoProdutoUnitario) * 100.00;

            } else {
                condicaoIcms = true;
                //JOptionPane.showMessageDialog(null, "Nï¿½o foi possi encontrar o calculo de ICMS verifique no C-Plus!!!\n lista de resultados: " + listIcmsEstado.size());
            }

            if (condicaoIcms == true && condicaoSt == true) {
                JOptionPane.showMessageDialog(null, "Você deve configurar o calculo de icms de RS para RS com cfop 5102 ou 5405 no C-plus para proseguir!!!\n "
                        + "cod calculo Icms: " + new ProdutoJpaController(managerCplus).findProduto(prodFornecedor.getReferenceCplus()).getCodcalculoicms().getCodcalculoicms()+ "\n "
                        + "Nome Fornecedor: " + prodFornecedor.getDescricao() + "\n Nome C-plus: " + prodCplus.getNomeprod());
            } else {
                condicao = true;
            }
        } while (condicao == false);
        return new BigDecimal(porcentagemCusto).setScale(2, RoundingMode.HALF_UP);
    }

    private Calculoicmsestado localizaCalculoIcmsSaida(ProdFornecedor produtosAllnations, EntityManagerFactory managerCplus) {
        QueryCplus queryCplus = new QueryCplus();
        Calculoicmsestado retorno = null;
        boolean condicao = false;
        do {
            List<Calculoicmsestado> listCalculoIcmsEstado = queryCplus.listcalculoIcmsEstadol("RS", "RS", "5405", new ProdutoJpaController(managerCplus).findProduto(produtosAllnations.getReferenceCplus()).getCodcalculoicms().getCodcalculoicms());
            if (listCalculoIcmsEstado.isEmpty()) {
                listCalculoIcmsEstado = queryCplus.listcalculoIcmsEstadol("RS", "RS", "5102", new ProdutoJpaController(managerCplus).findProduto(produtosAllnations.getReferenceCplus()).getCodcalculoicms().getCodcalculoicms());
                if (listCalculoIcmsEstado.size() == 1) {
                    for (Calculoicmsestado icmsEstado : listCalculoIcmsEstado) {
                        condicao = true;
                        retorno = icmsEstado;
                    }
                }
            } else if (listCalculoIcmsEstado.size() == 1) {
                for (Calculoicmsestado icmsEstado : listCalculoIcmsEstado) {
                    condicao = true;
                    retorno = icmsEstado;
                }
            } else {
                JOptionPane.showMessageDialog(null,
                        "Vocï¿½ deve configurar o calculo de icms de RS para RS com cfop 5102 ou 5405 no C-plus para proseguir!!!\n "
                        + "cod calculo Icms: " +new ProdutoJpaController(managerCplus).findProduto(produtosAllnations.getReferenceCplus()).getCodcalculoicms().getCodcalculoicms() + "\n "
                        + "Nome Produto: " + produtosAllnations.getDescricao() + ", EAN: " + produtosAllnations.getEan());
            }
        } while (condicao == false);
        return retorno;
    }

    private Calculoicmsestado localizaCalculoIcmsEntrada(ProdFornecedor prodFornecedor, EntityManagerFactory managerCplus) {
        QueryCplus queryCplus = new QueryCplus();
        Calculoicmsestado retorno = null;
        boolean condicao = false;

        do {
            Produto prodCplus = new ProdutoJpaController(managerCplus).findProduto(prodFornecedor.getReferenceCplus());
            List<Calculoicmsestado> listCalculoIcmsEstado = queryCplus.listcalculoIcmsEstadol("ES", "RS", "2403", prodCplus.getCodcalculoicms().getCodcalculoicms());
            if (listCalculoIcmsEstado.isEmpty()) {
                listCalculoIcmsEstado = queryCplus.listcalculoIcmsEstadol("ES", "RS", "2102", prodCplus.getCodcalculoicms().getCodcalculoicms());
                if (listCalculoIcmsEstado.size() == 1) {
                    for (Calculoicmsestado icmsEstado : listCalculoIcmsEstado) {
                        condicao = true;
                        retorno = icmsEstado;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Vocï¿½ deve configurar o calculo de icms de ES para RS com cfop 2102 ou 2403 no C-plus para proseguir!!!\n "
                            + "cod calculo Icms: " + new ProdutoJpaController(managerCplus).findProduto(prodFornecedor.getReferenceCplus()).getCodcalculoicms().getCodcalculoicms()+ "\n "
                            + "Nome Fornecedor: " + prodFornecedor.getDescricao() + "\n Nome C-plus: " + prodCplus.getNomeprod());

                }
            } else if (listCalculoIcmsEstado.size() == 1) {
                for (Calculoicmsestado icmsEstado : listCalculoIcmsEstado) {
                    condicao = true;
                    retorno = icmsEstado;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Vocï¿½ deve configurar o calculo de icms de ES para RS com cfop 2102 ou 2403 no C-plus para proseguir!!!\n "
                        + "cod calculo Icms: " + new ProdutoJpaController(managerCplus).findProduto(prodFornecedor.getReferenceCplus()).getCodcalculoicms().getCodcalculoicms() + "\n "
                        + "Nome Fornecedor: " + prodFornecedor.getDescricao() + "\n Nome C-plus: " + prodCplus.getNomeprod());

            }
        } while (condicao == false);
        return retorno;
    }

    public BigDecimal calculoPrcentagemSubstituicao(ProdFornecedor produtosAllnations, EntityManagerFactory managerCplus) {
        double total;
        double aliqIcms;
        Calculoicmsestado icmsEstado = localizaCalculoIcmsEntrada(produtosAllnations, managerCplus);
        if ("Y".equals(icmsEstado.getFlagcalculasubsttributaria().toString())) {
            if (icmsEstado.getAliqicms() != null) {
                aliqIcms = icmsEstado.getAliqicms().doubleValue();
            } else {
                aliqIcms = 0.00;
            }

            double aliqReducaoIcms;
            if (icmsEstado.getAliqreducaobaseicms() != null) {
                aliqReducaoIcms = icmsEstado.getAliqreducaobaseicms().doubleValue();
            } else {
                aliqReducaoIcms = 0.00;
            }
            double aliqIcmsDestino;
            if (icmsEstado.getCodufdestino().getAliquotainterna1() != null) {
                aliqIcmsDestino = icmsEstado.getCodufdestino().getAliquotainterna1().doubleValue();
            } else {
                aliqIcmsDestino = 0.00;
            }
            double aliqReducaoIcmsDestino;
            if (icmsEstado.getAliqreducaobasesubsttributaria() != null) {
                aliqReducaoIcmsDestino = icmsEstado.getAliqreducaobasesubsttributaria().doubleValue();
            } else {
                aliqReducaoIcmsDestino = 0.00;
            }
            double aliqSubstituicao;
            if (icmsEstado.getAliqlucro() != null) {
                aliqSubstituicao = icmsEstado.getAliqlucro().doubleValue();
            } else {
                aliqSubstituicao = 0.00;
            }

            double icmsLocal;
            double icmsdestino;
            double substituicao;

            icmsLocal = (aliqIcms * (100 - aliqReducaoIcms)) / 100;
            icmsdestino = (aliqIcmsDestino * (100 - aliqReducaoIcmsDestino)) / 100;
            substituicao = ((aliqSubstituicao * icmsdestino) / 100) + icmsdestino;

            total = substituicao - icmsLocal;
            if (total < 0.00) {
                total = 0.00;
            }
        } else {
            total = 0.00;
        }

        return new BigDecimal(total).setScale(2, RoundingMode.HALF_UP);
    }
}
