/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package integrador.render.produto;

import entidade.cplus.Produtoestoque;
import java.text.NumberFormat;
import java.util.Collection;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author leonardo
 */
public class RenderEstoqueAtual extends DefaultTableCellRenderer{
     public RenderEstoqueAtual() {
        setHorizontalAlignment(SwingConstants.CENTER);
    }

    @Override
    public void setValue(Object aValue) {
        Object result = null;
        //VariavelStatica var = new VariavelStatica();
        if ((aValue != null) && (aValue instanceof Collection)) {
            Collection<Produtoestoque> listProdutoestoque = (Collection<Produtoestoque>) aValue;                  
                for (Produtoestoque estoque : listProdutoestoque) {                                      
                        if ("000000001".equals(estoque.getSetorestoque().getCodsetorestoque())) {
                           // result = preco.getPreco();
                             Number numberValue = (Number)estoque.getEstatu();
                             NumberFormat formatter = NumberFormat.getIntegerInstance();
                             result = formatter.format(numberValue.doubleValue());
                        }                   
                }
            
        }
        super.setValue(result);
    }
}
