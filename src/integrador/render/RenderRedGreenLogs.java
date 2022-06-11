/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador.render;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

 
public class RenderRedGreenLogs extends DefaultTableCellRenderer{
   public RenderRedGreenLogs () {
     setHorizontalAlignment(SwingConstants.CENTER); 
     
   }
  
   @Override
 public Component getTableCellRendererComponent(JTable aTable, Object objectValue, boolean aIsSelected, boolean aHasFocus, int aRow, int aColumn
   ) {  
   
     if (objectValue == null ) return this ;
     Component renderer = super.getTableCellRendererComponent(aTable, objectValue, aIsSelected, aHasFocus, aRow, aColumn);
     String value = (String)objectValue;
     if (value.contains("Erro") || value.contains("ERRO")) {     
          renderer.setForeground(Color.red);
     }
     else {      
       renderer.setForeground(Color.GREEN);     
     }    
     return this ;
   }
  
}
