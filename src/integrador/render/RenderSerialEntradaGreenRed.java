/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package integrador.render;

import entidade.cplus.Moventradaprodserial;
import java.awt.Color;
import java.awt.Component;
import java.math.BigDecimal;
import java.util.Collection;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author leonardo
 */
public class RenderSerialEntradaGreenRed extends DefaultTableCellRenderer {

    public RenderSerialEntradaGreenRed() {

    }

    @Override
    public Component getTableCellRendererComponent(JTable aTable, Object objectValue, boolean aIsSelected, boolean aHasFocus, int aRow, int aColumn) {      
        if (objectValue == null) {
            return this;
        }        
        Component renderer = super.getTableCellRendererComponent(aTable, objectValue, aIsSelected, aHasFocus, aRow, aColumn);        
        int coluna = aTable.getColumnModel().getColumnIndex("Seriais Entrada");
        Collection<Moventradaprodserial> list =  (Collection<Moventradaprodserial>) aTable.getValueAt(aRow, coluna);
        coluna = aTable.getColumnModel().getColumnIndex("Quantidade");
        int quantidade = new BigDecimal(aTable.getValueAt(aRow, coluna).toString()).intValue();
        if (list.size() == quantidade ) {       
            renderer.setBackground(Color.green);
            renderer.setForeground(Color.black);        
        } else {
            renderer.setBackground(Color.white);
            renderer.setForeground(Color.red);
        }
        return this;
    }
}
