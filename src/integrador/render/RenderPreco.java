/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador.render;

import java.text.NumberFormat;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *Classe que recebe valor Bigdecimal e converte para valor moeda nas tabelas
 * @author leonardo
 */
public class RenderPreco extends DefaultTableCellRenderer{
   
   public RenderPreco() { 
     setHorizontalAlignment(SwingConstants.RIGHT);  
   }
   @Override public void setValue(Object aValue) {
     Object result = aValue;
     if ((aValue != null ) && (aValue instanceof Number)) {
       Number numberValue = (Number)aValue;
       NumberFormat formatter = NumberFormat.getCurrencyInstance();
       result = formatter.format(numberValue.doubleValue());
     } 
     super .setValue(result);
   }   
}
