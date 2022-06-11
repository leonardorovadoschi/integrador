/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package integrador.render.produto;

import entidade.cplus.Produtopreco;
import java.text.NumberFormat;
import java.util.Collection;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author leonardo
 */
public class RenderMargemVenda extends DefaultTableCellRenderer {

    public RenderMargemVenda() {
        setHorizontalAlignment(SwingConstants.RIGHT);
    }

    @Override
    public void setValue(Object aValue) {
        Object result = null;
        //VariavelStatica var = new VariavelStatica();
        if ((aValue != null) && (aValue instanceof Collection)) {
            Collection<Produtopreco> listProdutopreco = (Collection<Produtopreco>) aValue;
            for (Produtopreco preco : listProdutopreco) {
                if ("000000001".equals(preco.getCodpreco().getCodpreco())) {                  
                    Number numberValue = (Number) preco.getMargem();
                    NumberFormat formatter = NumberFormat.getPercentInstance();
                    formatter.setMinimumFractionDigits(3);                                      
                    result = formatter.format(numberValue.doubleValue()/100);
                }
            }
        }
        super.setValue(result);
    }
}
