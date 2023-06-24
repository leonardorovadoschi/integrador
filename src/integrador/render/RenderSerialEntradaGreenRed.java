/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador.render;

import java.awt.Color;
import java.awt.Component;
import java.math.BigDecimal;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author leonardo
 */
public class RenderSerialEntradaGreenRed implements TableCellRenderer {

    public static final DefaultTableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        Component renderer = DEFAULT_RENDERER.getTableCellRendererComponent(
                table, value, isSelected, hasFocus, row, column);
        ((JLabel) renderer).setOpaque(true);
        Color foreground, background;
        foreground = Color.WHITE;
        background = Color.black;
        if (isSelected) {
            foreground = Color.yellow;
            background = Color.green;
        } else {
           if (row % 2 == 0) {
        foreground = Color.blue;
        background = Color.white;
      } else {
        foreground = Color.white;
        background = Color.blue;
      } 
        }       
        int coluna = table.getColumnModel().getColumnIndex("Quantidade");
            int quantidade = new BigDecimal(table.getValueAt(row, coluna).toString()).intValue();
            coluna = table.getColumnModel().getColumnIndex("Seriais Entrada");
            int quantidadeConferida;
            if (table.getValueAt(row, coluna) == null) {
                quantidadeConferida = new BigDecimal("0.00").intValue();
            } else {
                quantidadeConferida = new BigDecimal(table.getValueAt(row, coluna).toString()).intValue();
            }
            if (quantidadeConferida == quantidade) {
                renderer.setBackground(Color.green);
                renderer.setForeground(Color.black);
            } else {
                renderer.setBackground(Color.white);
                renderer.setForeground(Color.red);
            }
        renderer.setForeground(foreground);
        renderer.setBackground(background);
        return renderer;
    }
}
