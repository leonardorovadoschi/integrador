/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integrador.render;

import janela.cplus.FormataCampos;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import prestashop.ConfiguracaoNoBD;

/**
 *
 * @author leo-note
 */
public class ConfTabelaOrderDetail extends DefaultTableCellRenderer {

    public ConfTabelaOrderDetail() {
       
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        //Color foreground = null;
        Color background = null;
        //colorir linha impar
        if (row % 2 == 0) {
           // foreground = Color.BLACK;
            background = new FormataCampos().stringParaColor(ConfiguracaoNoBD.getValorLinhaImpar());
        }
         //colorir linha selecionada
        if (table.isRowSelected(row)) {
                background = new FormataCampos().stringParaColor(ConfiguracaoNoBD.getValorLinhaSelecionada());
        }
        label.setHorizontalAlignment(SwingConstants.LEFT);
        label.setForeground(Color.BLACK);
        //configuração por coluna 
        if(column == 2){
            label.setHorizontalAlignment(SwingConstants.CENTER);
            //setFont(new Font("Arial", 2, 13));//altera a fonte da letra
        }
        if(column == 3){
            label.setHorizontalAlignment(SwingConstants.RIGHT);
            //setFont(new Font("Arial", 3, 12));//altera a fonte da letra
        }
        if(column == 4){
            label.setHorizontalAlignment(SwingConstants.RIGHT);
        }
        if(column == 5){
            label.setHorizontalAlignment(SwingConstants.RIGHT);
        }
        if(column == 6){
            label.setHorizontalAlignment(SwingConstants.RIGHT);
        }  
        if(column == 7){
            label.setHorizontalAlignment(SwingConstants.RIGHT);
        }
        if(column == 8){
            label.setHorizontalAlignment(SwingConstants.RIGHT);
        }  
        //label.setForeground(foreground);
        label.setBackground(background);
        return label;
    }

}
