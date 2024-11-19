/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
public class ConfTabelaSaidasPrestaShop extends DefaultTableCellRenderer{

    public ConfTabelaSaidasPrestaShop() {
    }
     @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
       // Color foreground = null;
        Color background = null;

        //colorir linha impar
        if (row % 2 == 0) {
            //foreground = Color.BLACK;
            background = new FormataCampos().stringParaColor(ConfiguracaoNoBD.getValorLinhaImpar());
        }
        //colorir linha selecionada
        if (table.isRowSelected(row)) {
                background = new FormataCampos().stringParaColor(ConfiguracaoNoBD.getValorLinhaSelecionada());
        }
        //mantem o alinhamento default
        label.setHorizontalAlignment(SwingConstants.LEFT);
        label.setForeground(Color.BLACK);
        switch (column) {
            //configuração por coluna 
            case 1:
                label.setHorizontalAlignment(SwingConstants.RIGHT); 
                setFont(new Font("Arial", 3, 13));//altera a fonte e tamanho da letra 
                break;
            case 4:
                label.setHorizontalAlignment(SwingConstants.RIGHT);//Alinhamento Direita          
                break;
            case 5:
                label.setHorizontalAlignment(SwingConstants.RIGHT);
                setFont(new Font("Arial", 3, 13));//altera a fonte e tamanho da letra                
                break;
            case 6:
                label.setHorizontalAlignment(SwingConstants.RIGHT);
                break;           
        }
        //label.setForeground(foreground);
        label.setBackground(background);
        return label;
    }
}
