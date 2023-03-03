/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pedido;

import acesso.ConexaoPrestaShop;
import entidade.prestaShop.PsCustomer;
import entidade.prestaShop.PsGroup;
import entidade.prestaShop.PsOrderDetail;
import entidade.prestaShop.PsOrders;
import entidade.prestaShop.PsPack;
import entidade.prestaShop.PsProduct;
import entidade.prestaShop.PsSpecificPrice;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import jpa.prestaShop.PsCustomerJpaController;
import jpa.prestaShop.PsGroupJpaController;
import jpa.prestaShop.PsProductJpaController;
import query.prestaShop.QueryPrestaShop;

/**
 *
 * @author leo
 */
public class ValoresOrder {

    public BigDecimal valorUnitario(BigDecimal valorUnitario) {
        // double total = valorTotalItem.doubleValue();
        // double quan = quantidadeItem.doubleValue();

        return valorUnitario.setScale(2, BigDecimal.ROUND_HALF_DOWN);
        // return new BigDecimal(valorFinal).setScale(var.casas_decimais_ARREDONDAMENTO, BigDecimal.ROUND_HALF_UP);
    }

    public BigDecimal valorTotalItem(BigDecimal valorUnitario, Integer quantidade) {
        return valorUnitario.multiply(new BigDecimal(quantidade)).setScale(2, BigDecimal.ROUND_HALF_DOWN);
    }
    
    public BigDecimal valorTotalDesconto (EntityManagerFactory managerPrestaShop, PsOrders order){
        BigDecimal valTotal;
        BigDecimal valDesconto = BigDecimal.ZERO;
        BigDecimal totProd = totalProdutos(managerPrestaShop, order);
        if ("custompaymentmethod_3".equals(order.getModule())) { //se o metodo de pagamento for com desconto
            //valTotal = valTotal.add(valorDescontoFormaPagamento());
            valTotal = totProd.multiply(new BigDecimal("0.985")).setScale(2, BigDecimal.ROUND_HALF_UP);
            //editar o valor da commission
           // Connection conn = new ConexaoPrestaShop().getConnection();
            valDesconto = totProd.subtract(valTotal).setScale(2, BigDecimal.ROUND_HALF_UP);
            //new ConexaoPrestaShop().editaPsOrderCommission(conn, order.getIdOrder(), valDesconto.doubleValue());
            //new ConexaoPrestaShop().closeConnection();
            //valTotal = valTotal.subtract(order.getTotalDiscountsTaxIncl()).setScale(2, BigDecimal.ROUND_HALF_UP);
        } 
        valDesconto = valDesconto.add(order.getTotalDiscountsTaxIncl()).setScale(2, BigDecimal.ROUND_HALF_UP);
        return valDesconto;
    }
    
    public BigDecimal valorTotalComDesconto(EntityManagerFactory managerPrestaShop, PsOrders order){
        return totalProdutos(managerPrestaShop, order).subtract(valorTotalDesconto(managerPrestaShop, order));
    }
    
    public BigDecimal valorTotalComDescontoSemPacote(EntityManagerFactory managerPrestaShop, PsOrders order){
       BigDecimal valTotal;
        BigDecimal valDesconto = BigDecimal.ZERO;
        BigDecimal totProd = totalProdutosSemPacote(managerPrestaShop, order);
        if ("custompaymentmethod_3".equals(order.getModule())) { //se o metodo de pagamento for com desconto
            //valTotal = valTotal.add(valorDescontoFormaPagamento());
            valTotal = totProd.multiply(new BigDecimal("0.985")).setScale(2, BigDecimal.ROUND_HALF_UP);
            //editar o valor da commission
           // Connection conn = new ConexaoPrestaShop().getConnection();
            valDesconto = totProd.subtract(valTotal).setScale(2, BigDecimal.ROUND_HALF_UP);
            //new ConexaoPrestaShop().editaPsOrderCommission(conn, order.getIdOrder(), valDesconto.doubleValue());
            //new ConexaoPrestaShop().closeConnection();
            //valTotal = valTotal.subtract(order.getTotalDiscountsTaxIncl()).setScale(2, BigDecimal.ROUND_HALF_UP);
        } 
        valDesconto = valDesconto.add(order.getTotalDiscountsTaxIncl()).setScale(2, BigDecimal.ROUND_HALF_UP);
        valTotal = totProd.subtract(valDesconto);
        return valTotal;
    }
    
    public BigDecimal totalProdutosSemPacote(EntityManagerFactory managerPrestaShop, PsOrders order){
        BigDecimal totProd =  BigDecimal.ZERO;
        for (PsOrderDetail od : new QueryPrestaShop(managerPrestaShop).listOrderDetail(order.getIdOrder())) {
           totProd = totProd.add(od.getTotalPriceTaxIncl());
           // totPeso = totPeso.add(od.getProductWeight());
        }
        return totProd;
    }

    /**
     * Função que manda o total dos itens incluido os itens do Pacote de produtos obs: o valor quando a pacote 
     * pode ser diferente do total de produtos no site
     * @param managerPrestaShop
     * @param order
     * @return 
     */
    public BigDecimal totalProdutos(EntityManagerFactory managerPrestaShop, PsOrders order) {
        BigDecimal totProd = BigDecimal.ZERO;
        for (PsOrderDetail orderItem : new QueryPrestaShop(managerPrestaShop).listPsOrderDetail(order.getIdOrder())) {
            if (new PsProductJpaController(managerPrestaShop).findPsProduct(orderItem.getProductId()).getCacheIsPack()) {
                //for (PsPack psP : new QueryPrestaShop(managerPrestaShop).listPack(new PsProductJpaController(managerPrestaShop).findPsProduct(orderItem.getProductId()).getIdProduct())) {
                PsCustomer C = new PsCustomerJpaController(managerPrestaShop).findPsCustomer(order.getIdCustomer());
                PsGroup G = new PsGroupJpaController(managerPrestaShop).findPsGroup(C.getIdDefaultGroup());
                BigDecimal descPac = BigDecimal.ZERO;
                List<PsSpecificPrice> listPric = new QueryPrestaShop(managerPrestaShop).listPsSpecificPrice(orderItem.getProductId(), G.getIdGroup());
                if (listPric.isEmpty()) {
                    listPric = new QueryPrestaShop(managerPrestaShop).listPsSpecificPrice(orderItem.getProductId(), 0);// para todos os grupos
                }
                for (PsSpecificPrice specificPrice : listPric) {
                    if ("percentage".equals(specificPrice.getReductionType())) {
                        descPac = specificPrice.getReduction();
                    }
                }
                int quantPack = orderItem.getProductQuantity();// tem que receber o valor fora do pacote
                for (PsPack psP : new QueryPrestaShop(managerPrestaShop).listPack(orderItem.getProductId())) {
                    PsProduct P = new PsProductJpaController(managerPrestaShop).findPsProduct(psP.getPsPackPK().getIdProductItem());
                    BigDecimal precUni = P.getPrice();
                    int quanProdutosPack = psP.getQuantity();//quantidade de produtos que tem no pacote
                    BigDecimal quantidade = new BigDecimal(quantPack * quanProdutosPack);//é a quantidade do pacote x quantidade de pacote comprado
                    BigDecimal redGrup = G.getReduction().divide(new BigDecimal("100.00"), BigDecimal.ROUND_HALF_UP);
                    precUni = precUni.multiply(BigDecimal.ONE.subtract(redGrup)); //redução do grupo
                    precUni = precUni.multiply((BigDecimal.ONE.subtract(descPac))).setScale(2, BigDecimal.ROUND_HALF_UP); //redução do pacote de produto
                    orderItem.setProductId(psP.getPsPackPK().getIdProductItem());
                    orderItem.setEcotax(BigDecimal.ZERO);
                    orderItem.setProductQuantity(quantidade.intValue());
                    orderItem.setUnitPriceTaxIncl(precUni);
                    orderItem.setTotalPriceTaxIncl(precUni.multiply(quantidade));
                    totProd =  totProd.add(orderItem.getTotalPriceTaxIncl());
                }
            } else {             
                 totProd =  totProd.add(orderItem.getTotalPriceTaxIncl());               
            }
        }//for order item
        return totProd;
    }

    public BigDecimal valorTotalPredido(PsOrders order) {
        return order.getTotalPaidTaxIncl();
    }
}
