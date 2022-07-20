/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package integrador.render;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Fazenda
 */
public class RenderCorEstoquePs extends DefaultTableCellRenderer{
    
    @Override
    public Component getTableCellRendererComponent(JTable aTable, Object objectValue, boolean aIsSelected, boolean aHasFocus, int aRow, int aColumn) {
        if (objectValue == null) {
            return this;
        }
        Component renderer = super.getTableCellRendererComponent(aTable, objectValue, aIsSelected, aHasFocus, aRow, aColumn);
        Integer value = (Integer) objectValue;
        if (value < 1) {
            renderer.setForeground(Color.RED);
        } else {
            renderer.setForeground(Color.BLUE);
        }
        return this;
    }
}
