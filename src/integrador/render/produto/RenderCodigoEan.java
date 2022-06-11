/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package integrador.render.produto;

import entidade.cplus.Produtocodigo;
import java.util.Collection;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author leonardo
 */
public class RenderCodigoEan extends DefaultTableCellRenderer{
    public RenderCodigoEan() {
       // setHorizontalAlignment(SwingConstants.CENTER);
    }

    @Override
    public void setValue(Object aValue) {
        Object result = null;
        //VariavelStatica var = new VariavelStatica();
        if ((aValue != null) && (aValue instanceof Collection)) {
            Collection<Produtocodigo> listProdutoestoque = (Collection<Produtocodigo>) aValue;                  
                for (Produtocodigo ean : listProdutoestoque) {                                      
                        if ("000000002".equals(ean.getCodtipocodigo())) {
                                                                               
                            result = (String) ean.getCodigo();
                        }                   
                }
            
        }
        super.setValue(result);
    }
}
