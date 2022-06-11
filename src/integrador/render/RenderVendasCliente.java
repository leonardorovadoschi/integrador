/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador.render;

import entidade.cplus.Movenda;
import java.util.Collection;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author leo
 */
public class RenderVendasCliente extends DefaultTableCellRenderer{
    
    public RenderVendasCliente() {

    }

    @Override
    public void setValue(Object aValue) {
        Object result = null;
        //VariavelStatica var = new VariavelStatica();
        if ((aValue != null) && (aValue instanceof Collection)) {
            Collection<Movenda> list = (Collection<Movenda>) aValue;                  
                //for (Produtopreco preco : listProdutopreco) {                                      
                        //if ("000000005".equals(preco.getCodpreco().getCodpreco())) {
                           // result = preco.getPreco();
                             Number numberValue = (Number)list.size();
                             //NumberFormat formatter = NumberFormat.getCurrencyInstance();
                             //result = formatter.format(numberValue.doubleValue());
                             result = numberValue;
                       // }
                    
               // }
            
        }
        super.setValue(result);
    }
}
