/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package integrador.render;

import java.awt.Color;
import java.awt.Component;
import java.math.BigDecimal;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author leonardo
 */
public class RenderSerialSaidaGreenRedOld extends DefaultTableCellRenderer{
    public RenderSerialSaidaGreenRedOld() {

    }

    @Override
    public Component getTableCellRendererComponent(JTable aTable, Object objectValue, boolean aIsSelected, boolean aHasFocus, int aRow, int aColumn) {      
        if (objectValue == null) {
            return this;
        }        
        Component renderer = super.getTableCellRendererComponent(aTable, objectValue, aIsSelected, aHasFocus, aRow, aColumn);        
        int coluna = aTable.getColumnModel().getColumnIndex("Quantidade");
        int quantidade = new BigDecimal(aTable.getValueAt(aRow, coluna).toString()).intValue();
        coluna = aTable.getColumnModel().getColumnIndex("Quant Conferida"); 
        int quantidadeConferida;
        if(aTable.getValueAt(aRow, coluna) == null){
            quantidadeConferida = new BigDecimal("0.00").intValue();
        }else{
            quantidadeConferida = new BigDecimal(aTable.getValueAt(aRow, coluna).toString()).intValue();
        }      
        if (quantidadeConferida == quantidade ) {       
            renderer.setBackground(Color.green);
            renderer.setForeground(Color.black);
        } else {
            renderer.setBackground(Color.white);
            renderer.setForeground(Color.red);
        }
        return this;
    }
}
