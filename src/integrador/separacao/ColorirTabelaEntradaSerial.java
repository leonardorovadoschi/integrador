/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador.separacao;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author leonardo
 */
public class ColorirTabelaEntradaSerial implements TableCellRenderer {

    public static final DefaultTableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();
    int line;
    String valor;
    int coluna;
    int coluna1;
    int quant;
    int quant1;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        Component renderer = DEFAULT_RENDERER.getTableCellRendererComponent(
                table, value, isSelected, hasFocus, row, column);
        ((JLabel) renderer).setOpaque(true);
        Color foreground = null, background = null;

        //******************************************************************
        coluna = table.getColumnModel().getColumnIndex("Quantidade");
        coluna1 = table.getColumnModel().getColumnIndex("Completo");
        quant = (int) table.getValueAt(row, coluna);
        quant1 = (int) table.getValueAt(row, coluna1);

        if (quant == quant1) {
            foreground = Color.BLACK;
            background = Color.GREEN;
        } else {
            foreground = Color.BLACK;
            background = Color.RED;
        }
        /**
         * valor = String.valueOf(value); if (isSelected) { foreground =
         * Color.WHITE; background = Color.CYAN; } else if (row % 2 == 0) {
         * foreground = Color.ORANGE; background = Color.MAGENTA; } switch
         * (valor) { case "PAR": foreground = new Color(251, 173, 48);
         * background = new Color(213, 230, 239); break; case "IMPAR":
         * foreground = new Color(250, 0, 0); background = new Color(184, 207,
         * 229); break;
         *
         * }
         */
        //******************************************************************
        renderer.setForeground(foreground);
        renderer.setBackground(background);
        return renderer;
    }

}
