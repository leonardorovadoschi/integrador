/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package integrador.render;

import entidade.cplus.Moventradaprodserial;
import java.util.Collection;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author leonardo
 */
public class RenderSerialEntradaOld extends DefaultTableCellRenderer{
    public RenderSerialEntradaOld() {
        setHorizontalAlignment(SwingConstants.CENTER);
    }
    @Override
    public void setValue(Object aValue) {       
        String nome ="";
        if ((aValue != null) && (aValue instanceof Collection)) {
            Collection<Moventradaprodserial> list =  (Collection<Moventradaprodserial>) aValue;
         
               nome = String.valueOf(list.size());                          
        }
        super.setValue(nome);
    }
}
