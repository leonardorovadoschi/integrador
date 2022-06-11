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
  * Apresentar um {link da} em uma célula da tabela, colocando o 
  * Nome completo no celular, e fornecendo seu ticker Yahoo  
  * (Incluindo sufixo para o {link hirondelle.stocks.quotes.Exchange}) como dica de ferramenta. 
  */
public class RenderNumeroInteiro extends DefaultTableCellRenderer{
    public RenderNumeroInteiro() { 
     setHorizontalAlignment(SwingConstants.CENTER);  
   }
   @Override public void setValue(Object aValue) {
     Object result = aValue;
     if ((aValue != null ) && (aValue instanceof Number)) {
       Number numberValue = (Number)aValue;
       NumberFormat formatter = NumberFormat.getNumberInstance();
       formatter.setMaximumFractionDigits(0);
       result = formatter.format(numberValue.doubleValue());
     } 
     super .setValue(result);
   }   
}
