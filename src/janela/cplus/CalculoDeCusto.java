/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package janela.cplus;

import entidade.cplus.Calculoicmsestado;
import entidade.cplus.Moventradaprod;
import entidade.cplus.Produto;
import entidade.cplus.Produtoestoque;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import query.cplus.QueryCplus;

/**
 *
 * @author Fazenda
 */
public class CalculoDeCusto {

    public BigDecimal custoMediouUniComIpi(List<Calculoicmsestado> listIcmsEstado, Produto prod, EntityManagerFactory managerCplus) {
        //boolean condicaoIcms = true;
        BigDecimal quanCompra = BigDecimal.ZERO;
        BigDecimal valorProdutos = BigDecimal.ZERO;
        BigDecimal valorTotalIcms = BigDecimal.ZERO;
        BigDecimal valorTotalPisCofins = BigDecimal.ZERO;
        BigDecimal valorTotalIpi = BigDecimal.ZERO;
        BigDecimal valorTotalSt = BigDecimal.ZERO;
        BigDecimal incremetEstoque = BigDecimal.ZERO;
        BigDecimal quantidadeEstoque = quantidadeEstoque(prod, managerCplus);
        BigDecimal custoMedioUnitario;
        BigDecimal creditoIcms;
        BigDecimal debitoIcms;
        BigDecimal diferencaIcms;
        BigDecimal aliqIcmsVenda = BigDecimal.ZERO;
        BigDecimal creditoPisCofins;
        BigDecimal debitoPisCofin;
        BigDecimal diferencaPisCofins;
        BigDecimal valorIpiUnitario;
        //BigDecimal valorStUnitario;
        BigDecimal valorVenda;
        BigDecimal porcentagemCusto = BigDecimal.ZERO;
        BigDecimal porcentagemLugro = new BigDecimal("1.10");
        BigDecimal aliqPisCofins = new BigDecimal("0.0925");
        
        if(quantidadeEstoque.intValue() > 0){
        for (Moventradaprod movProd : new QueryCplus(managerCplus).resultProdutoEntrada(prod.getCodprod(), true, 10)) {
            quanCompra = quanCompra.add(movProd.getQuantidade());
            if (quantidadeEstoque.intValue() >= quanCompra.intValue()) { //estoque maior que quantidade de compra
                valorProdutos = valorProdutos.add(movProd.getValortotal());
                valorTotalIcms = valorTotalIcms.add(movProd.getValoricms());
               // valorTotalPisCofins = valorTotalPisCofins.add(movProd.getValorpis()).add(movProd.getValorcofins());
                valorTotalPisCofins = valorProdutos.multiply(aliqPisCofins).setScale( 4, RoundingMode.HALF_UP);
                if (movProd.getValorsubsttributaria() != null) {
                    valorTotalSt = valorTotalSt.add(movProd.getValorsubsttributaria());
                }
                if (movProd.getValoripi() != null) {
                    valorTotalIpi = valorTotalIpi.add(movProd.getValoripi());
                }
                incremetEstoque = incremetEstoque.add(movProd.getQuantidade());
            } else { //estoque igual a quantidade de compra
                BigDecimal qunRest = quantidadeEstoque.subtract(incremetEstoque);
                valorProdutos = valorProdutos.add(qunRest.multiply(movProd.getValorunitario()));
                BigDecimal valorRestanteIcmsUnitario = movProd.getValoricms().divide(movProd.getQuantidade(), 4, RoundingMode.HALF_UP);
                valorTotalIcms = valorTotalIcms.add(valorRestanteIcmsUnitario.multiply(qunRest));              
                valorTotalPisCofins = valorProdutos.multiply(aliqPisCofins).setScale( 4, RoundingMode.HALF_UP);
               // if (movProd.getValorsubsttributaria() != null) {
                    //BigDecimal valorRestanteStUnitario = movProd.getValorsubsttributaria().divide(movProd.getQuantidade(), 4, RoundingMode.HALF_UP);
                    //valorTotalSt = valorTotalSt.add(valorRestanteStUnitario.multiply(qunRest));
               // }
                if (movProd.getValoripi() != null) {
                    BigDecimal valorRestanteIpi = movProd.getValoripi().divide(movProd.getQuantidade(), 4, RoundingMode.HALF_UP);
                    valorTotalIpi = valorTotalIpi.add(valorRestanteIpi.multiply(qunRest));
                }
                break;
            }
        }//fim for listagem entrada de compra
        custoMedioUnitario = valorProdutos.divide(quantidadeEstoque, 4, RoundingMode.HALF_UP);
        creditoIcms = valorTotalIcms.divide(quantidadeEstoque, 4, RoundingMode.HALF_UP);
        creditoPisCofins = valorTotalPisCofins.divide(quantidadeEstoque, 4, RoundingMode.HALF_UP);
        valorIpiUnitario = valorTotalIpi.divide(quantidadeEstoque, 4, RoundingMode.HALF_UP);
        //valorStUnitario = valorTotalSt.divide(quantidadeEstoque, 4, RoundingMode.HALF_UP);
        // System.out.println("quantidadeEstoque: "+ quantidadeEstoque.doubleValue());
        //List<Calculoicmsestado> listIcmsEstado = new QueryCplus(managerCplus).listcalculoIcmsEstadol("RS", "RS", "5102", prod.getCodcalculoicms().getCodcalculoicms());
        if (listIcmsEstado.size() == 1) {                              
                 for (Calculoicmsestado icmsEstado : listIcmsEstado) {                  
                    if (icmsEstado.getAliqicms() != null) {
                        aliqIcmsVenda = icmsEstado.getAliqicms();
                        aliqIcmsVenda = aliqIcmsVenda.divide(new BigDecimal("100.00"), 4, RoundingMode.HALF_UP);//=0,17%
                       // System.out.println("aliqIcmsVenda: "+ aliqIcmsVenda.doubleValue());
                    }
                    if (icmsEstado.getAliqreducaobaseicms() != null) {
                       if(icmsEstado.getAliqreducaobaseicms().doubleValue() > 0.00){
                        aliqIcmsVenda = aliqIcmsVenda.multiply(new BigDecimal("100.00").subtract(icmsEstado.getAliqreducaobaseicms()));
                        aliqIcmsVenda = aliqIcmsVenda.divide(new BigDecimal("100.00"), 4, RoundingMode.HALF_UP); //=17,00%
                        aliqIcmsVenda = aliqIcmsVenda.divide(new BigDecimal("100.00"), 4, RoundingMode.HALF_UP);//=0,17%
                       // System.out.println("aliqIcmsVenda: "+ aliqIcmsVenda.doubleValue());
                       }
                    }
                    if (icmsEstado.getAliqdiferimento() != null && icmsEstado.getAliqdiferimento().doubleValue() > 0.00) {
                        aliqIcmsVenda = new BigDecimal("0.12");
                        //System.out.println("aliqIcmsVenda: "+ aliqIcmsVenda.doubleValue());
                    } 
                }   
                 valorVenda = valorIpiUnitario.add(custoMedioUnitario).multiply(porcentagemLugro).setScale( 4, RoundingMode.HALF_UP);
                 debitoPisCofin = valorVenda.multiply(aliqPisCofins).setScale( 4, RoundingMode.HALF_UP);
                 debitoIcms = valorVenda.multiply(aliqIcmsVenda);
                diferencaPisCofins = debitoPisCofin.subtract(creditoPisCofins);               
                diferencaIcms = debitoIcms.subtract(creditoIcms);
                //soma valor tributos com lucro                                           
                valorVenda = valorVenda.add(diferencaIcms).add(diferencaPisCofins);
                debitoPisCofin = valorVenda.multiply(aliqPisCofins).setScale( 4, RoundingMode.HALF_UP);
                debitoIcms = valorVenda.multiply(aliqIcmsVenda).setScale( 4, RoundingMode.HALF_UP);
                diferencaPisCofins = debitoPisCofin.subtract(creditoPisCofins);               
                diferencaIcms = debitoIcms.subtract(creditoIcms);               
                porcentagemCusto = (diferencaPisCofins.add(diferencaIcms)).divide(valorIpiUnitario.add(custoMedioUnitario) , 4, RoundingMode.HALF_UP).multiply(new BigDecimal("100.00"));     
               // System.out.println("custoMedioUnitario: "+ custoMedioUnitario.doubleValue());
               // System.out.println("valorVenda: "+ valorVenda.doubleValue());
                //System.out.println("valorIpiUnitario: "+ valorIpiUnitario.doubleValue());
                //System.out.println("debitoPisCofin : "+ debitoPisCofin .doubleValue());
                //System.out.println("creditoPisCofins : "+ creditoPisCofins .doubleValue());
                //System.out.println("diferencaPisCofins: "+ diferencaPisCofins.doubleValue());
               // System.out.println("debitoIcms: "+ debitoIcms.doubleValue());
               // System.out.println("creditoIcms: "+ creditoIcms.doubleValue());                
               // System.out.println("diferencaIcms: "+ diferencaIcms.doubleValue());
                //System.out.println("porcentagemCusto: "+ porcentagemCusto.doubleValue());
            }                   
        }
        return porcentagemCusto;
    }
  

    private BigDecimal quantidadeEstoque(Produto prod, EntityManagerFactory managerCplus) {
        BigDecimal qntEstoque = BigDecimal.ZERO;
        for (Produtoestoque estoque : new QueryCplus(managerCplus).listEstoquesPorProd(prod.getCodprod())) {
            qntEstoque = estoque.getEstatu().subtract(estoque.getReservadoorcamento().subtract(estoque.getReservadoos()));
        }
        return qntEstoque;
    }
}
