/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador.render;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author leonardo
 */
public class RenderDataEHora extends DefaultTableCellRenderer{
    @Override public void setValue(Object aValue) {
     Object result = aValue;
     if ((aValue != null ) && (aValue instanceof Date)) {
         SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
          Date data = (Date)aValue;
                    
       result = sdf.format(data);
     } 
     super .setValue(result);
   }   
}
