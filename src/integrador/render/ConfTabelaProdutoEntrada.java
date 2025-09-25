/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador.render;

import janela.cplus.FormataCampos;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import prestashop.ConfiguracaoNoBD;

/**
 *
 * @author leonardo
 */
public class ConfTabelaProdutoEntrada extends DefaultTableCellRenderer{
    
    public ConfTabelaProdutoEntrada() {
       
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
        if(column == 1){
            label.setHorizontalAlignment(SwingConstants.RIGHT);
            //setFont(new Font("Arial", 2, 13));//altera a fonte da letra
        }
        if(column == 2){
            label.setHorizontalAlignment(SwingConstants.RIGHT);
            //setFont(new Font("Arial", 2, 13));//altera a fonte da letra
        }
        if(column == 3){
            label.setHorizontalAlignment(SwingConstants.RIGHT);
            //setFont(new Font("Arial", 2, 13));//altera a fonte da letra
        }
        if(column == 4){
            label.setHorizontalAlignment(SwingConstants.RIGHT);
            //setFont(new Font("Arial", 2, 13));//altera a fonte da letra
        }
        if(column == 5){
            label.setHorizontalAlignment(SwingConstants.RIGHT);
            //setFont(new Font("Arial", 3, 12));//altera a fonte da letra
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
         if(column == 9){
            label.setHorizontalAlignment(SwingConstants.RIGHT);
        } 
        //label.setForeground(foreground);
        label.setBackground(background);
        return label;
    }
}
