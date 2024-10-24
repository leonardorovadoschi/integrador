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
public class ConfTabelaProduto extends DefaultTableCellRenderer {

    public ConfTabelaProduto() {

    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        Color foreground = null;
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
            case 4:
                label.setHorizontalAlignment(SwingConstants.RIGHT);//Alinhamento Direita
                setFont(new Font("Arial", 3, 13));//altera a fonte e tamanho da letra
                break;
            case 5:
                label.setHorizontalAlignment(SwingConstants.RIGHT);//Alinhamento Direita
                setFont(new Font("Arial", 3, 13));//altera a fonte e tamanho da letra
                String valor = String.valueOf(value)
                        .replace("(?:[^\\d\\,])", "") //Remove todos os caracteres não numerais e nem a vírgula
                        .replace(",", "");// Substitui a vírgula pelo ponto
                if (Double.valueOf(valor) < 10.0) {
                    label.setForeground(Color.RED);
                }
                break;
            case 6:
                label.setHorizontalAlignment(SwingConstants.RIGHT);
                String inte = value.toString();
                int in = Integer.parseInt(inte);
                if (in < 1) {
                    label.setForeground(Color.RED);
                }
                break;
            case 7:
                label.setHorizontalAlignment(SwingConstants.CENTER);
                break;
            case 9:
                label.setHorizontalAlignment(SwingConstants.RIGHT);
                break;
            case 10:
                label.setHorizontalAlignment(SwingConstants.RIGHT);
                break;
        }
        //label.setForeground(foreground);
        label.setBackground(background);
        return label;
    }

}
