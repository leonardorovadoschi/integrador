/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package integrador.render.produto;

import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author leonardo
 */
public class RenderAllAtivo extends DefaultTableCellRenderer{
     public RenderAllAtivo() {
        //setHorizontalAlignment(SwingConstants.RIGHT);
    }
    @Override
    public void setValue(Object aValue) {
        Object result = aValue;       
        if ((aValue != null) && (aValue instanceof Number)) {
             Number valor = (Number)aValue;
           if(valor.intValue() == 1){
               result = "Ativado";
           }else{
               result = "Desativado";
           }
        }
        super.setValue(result);
    }
}
