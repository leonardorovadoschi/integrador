/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prestashop;

import entidade.cplus.Classificacaofiscal;
import entidade.cplus.Movendaprod;
import entidade.cplus.Moventradaprod;
import entidade.cplus.Produtoestoque;
import janela.cplus.FormataCampos;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.ClassificacaofiscalJpaController;
import jpa.cplus.ProdutoestoqueJpaController;
import query.cplus.QueryCplus;

/**
 *
 * @author leo-note
 */
public class Teste {

    public Teste() {
        this.emf = Manager.getManagerCplus();
    }
    private EntityManagerFactory emf = null;

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    private QueryCplus queryCplus;
    private final FormataCampos formatacaoCampos = new FormataCampos();

    public void testeQuery() {
        List<Classificacaofiscal> list = new ClassificacaofiscalJpaController(Manager.getManagerCplus()).findClassificacaofiscalEntities();
        for (Classificacaofiscal c : list) {
            if (c.getDescricao() != null) {
                System.out.println("Estring do banco " + c.getDescricao());
                String limpo = c.getDescricao()
                        .replaceAll("\\p{Cntrl}", " ")
                        .replaceAll("\\s+", " ")
                        .trim();
                System.out.println("Estring do limpa " + limpo);
                try {
                    new ClassificacaofiscalJpaController(Manager.getManagerCplus()).edit(c);
                } catch (Exception ex) {
                   // Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Erro " + ex);
                }
            }         
        }
    }

    private void inventariovelho() {

        List<Produtoestoque> listProdEstoque = new ProdutoestoqueJpaController(Manager.getManagerCplus()).findProdutoestoqueEntities();
        List<Produtoestoque> listProd = new ArrayList<>();
        //verificaDataEmissaoNula();
        for (Produtoestoque prodEstoque : listProdEstoque) {
            int quantidadeEstoque = 0;
            if (formatacaoCampos.comparaDuasDatas(prodEstoque.getLastChange(),
                    formatacaoCampos.dataAtual() /**
             * alteraHoraData(jDateChooserDataInventario.getDate())
             */
            )) {//PRIMEIRA DATA for MENOR ou IGUAL a SEGUNDA DATA vai retornar FALSE
                //aqui sera verificado a quantidade em estoque do dia do relatório
                for (Moventradaprod entradaProd : queryCplus.resultProdutoEntrada(prodEstoque.getProduto().getCodprod(), formatacaoCampos.dataAtual() /**
                         * alteraHoraData(jDateChooserDataInventario.getDate())
                         */
                        , false)) {
                    quantidadeEstoque = quantidadeEstoque + entradaProd.getQuantidade().intValue();
                }
                for (Movendaprod saidaProd : queryCplus.resultProdutoSaida(prodEstoque.getProduto().getCodprod(), formatacaoCampos.dataAtual() /**
                 * alteraHoraData(jDateChooserDataInventario.getDate())
                 */
                )) {
                    quantidadeEstoque = quantidadeEstoque - saidaProd.getQuantidade().intValue();
                }
            } else {
                quantidadeEstoque = prodEstoque.getEstatu().intValue();
            }

            if (quantidadeEstoque > 0) {

                double custoProdutoUnitario;
                double creditoPisCofins;
                double creditoIcms;
                double valorIpiUnitario;
                double valorStUnitario;
                //quantidadeEstoque = prodEstoque.getEstatu().intValue(); 
                double valorProdutos = 0.00;
                double valorTotalIcms = 0.00;
                double valorTotalPisCofins = 0.00;
                double valorTotalIpi = 0.00;
                double valorTotalSt = 0.00;
                int estoqueCompra = 0;
                int incremetEstoque = 0;
                //  queryCplus.resultProdutoEntrada(prodEstoque.getProduto().getCodprod(), true, 10) 
                for (Moventradaprod movProd : queryCplus.resultProdutoEntrada(prodEstoque.getProduto().getCodprod(), formatacaoCampos.dataAtual() /**
                         * alteraHoraData(jDateChooserDataInventario.getDate())
                         */
                        , true)) {
                    estoqueCompra = estoqueCompra
                            + movProd.getQuantidade().intValue();
                    if (quantidadeEstoque >= estoqueCompra) {
                        valorProdutos = valorProdutos + movProd.getValortotal().doubleValue();
                        if (movProd.getValoricms() != null) {
                            valorTotalIcms = valorTotalIcms + movProd.getValoricms().doubleValue();
                        }
                        valorTotalPisCofins = valorTotalPisCofins + movProd.getValorpis().doubleValue() + movProd.getValorcofins().doubleValue();
                        if (movProd.getValorsubsttributaria() != null) {
                            valorTotalSt = valorTotalSt + movProd.getValorsubsttributaria().doubleValue();
                        }
                        if (movProd.getValoripi() != null) {
                            valorTotalIpi = valorTotalIpi + movProd.getValoripi().doubleValue();
                        }
                        incremetEstoque = incremetEstoque + movProd.getQuantidade().intValue();
                    } else {
                        valorProdutos = valorProdutos + ((quantidadeEstoque - incremetEstoque) * movProd.getValorunitario().doubleValue());
                        double valorRestanteIcmsUnitario = movProd.getValoricms().doubleValue() / movProd.getQuantidade().doubleValue();
                        valorTotalIcms = valorTotalIcms + (valorRestanteIcmsUnitario * (quantidadeEstoque - incremetEstoque));
                        double valorRestantePisCofinsUnitario = (movProd.getValorpis().doubleValue() + movProd.getValorcofins().doubleValue()) / (movProd.getQuantidade().doubleValue());
                        valorTotalPisCofins = valorTotalPisCofins + (valorRestantePisCofinsUnitario * (quantidadeEstoque - incremetEstoque));
                        if (movProd.getValorsubsttributaria() != null) {
                            double valorRestanteStUnitario = movProd.getValorsubsttributaria().doubleValue() / movProd.getQuantidade().doubleValue();
                            valorTotalSt = valorTotalSt + (valorRestanteStUnitario * (quantidadeEstoque - incremetEstoque));
                        }
                        if (movProd.getValoripi() != null) {
                            double valorRestanteIpi = movProd.getValoripi().doubleValue() / movProd.getQuantidade().doubleValue();
                            valorTotalIpi = valorTotalIpi + (valorRestanteIpi * (quantidadeEstoque - incremetEstoque));
                        }
                        break;
                    } // } //fim for listagem entrada de compra

                    if ("102".equals(prodEstoque.getProduto().getCfopdentrouf())) {
                        creditoIcms = valorTotalIcms;
                        prodEstoque.getProduto().setPercoutroscustos(new BigDecimal(creditoIcms).setScale(2, RoundingMode.HALF_UP));
                    } else {
                        prodEstoque.getProduto().setPercoutroscustos(BigDecimal.ZERO);
                    }
                    creditoPisCofins = valorTotalPisCofins;
                    prodEstoque.getProduto().setPercoutroscustos2(new BigDecimal(creditoPisCofins).setScale(2, RoundingMode.HALF_UP));

                    valorStUnitario = valorTotalSt;
                    prodEstoque.getProduto().setValorsubsttributaria(new BigDecimal(valorStUnitario).setScale(2, RoundingMode.HALF_UP));

                    valorIpiUnitario = valorTotalIpi;
                    prodEstoque.getProduto().setValoripi(new BigDecimal(valorIpiUnitario).setScale(2, RoundingMode.HALF_UP));

                    creditoIcms = valorTotalIcms / quantidadeEstoque;
                    creditoPisCofins = valorTotalPisCofins / quantidadeEstoque;
                    valorStUnitario = valorTotalSt / quantidadeEstoque;
                    valorIpiUnitario = valorTotalIpi / quantidadeEstoque;
                    custoProdutoUnitario = valorProdutos / quantidadeEstoque;
                    custoProdutoUnitario = custoProdutoUnitario + valorIpiUnitario + valorStUnitario - creditoIcms - creditoPisCofins;
                    prodEstoque.getProduto().setPrecusto(new BigDecimal(custoProdutoUnitario).setScale(2, RoundingMode.HALF_UP));

                    prodEstoque.setEstatu(new BigDecimal(quantidadeEstoque));
                    double custoreal = custoProdutoUnitario + creditoPisCofins;
                    prodEstoque.getProduto().setCustoreal(new BigDecimal(custoreal));
                    listProd.add(prodEstoque);

                }//fim if com estoque maior que zero }//fim for
            }
            // listaProdutosEstoque = listProd;
        }
    }
}
