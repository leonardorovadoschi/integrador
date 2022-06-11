/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pedido;

import entidade.prestaShop.PsOrders;
import java.math.BigDecimal;

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

    public BigDecimal valorTotalPredido(PsOrders order) {       
        return order.getTotalPaidTaxIncl();
    }
}
