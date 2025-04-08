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
 * @author leonardo
 */
public class ConfTabelaMovendaProd extends DefaultTableCellRenderer {

    public ConfTabelaMovendaProd() {
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
            case 0:
                label.setHorizontalAlignment(SwingConstants.RIGHT);
                // setFont(new Font("Arial", 3, 13));//altera a fonte e tamanho da letra 
                break;
            case 2://quant
                label.setHorizontalAlignment(SwingConstants.CENTER);
                break;
            case 3://CFOP
                label.setHorizontalAlignment(SwingConstants.CENTER);//Alinhamento Direita          
                break;
            case 4://Origem
                label.setHorizontalAlignment(SwingConstants.CENTER);
                break;
            case 5://Val.Unit
                label.setHorizontalAlignment(SwingConstants.RIGHT);
                break;
            case 6://Val Total
                label.setHorizontalAlignment(SwingConstants.RIGHT);
                break;
            case 7://CST
                label.setHorizontalAlignment(SwingConstants.CENTER);
                break;
            case 8://Base ICMS
                label.setHorizontalAlignment(SwingConstants.RIGHT);
                break;
            case 9://Ali ICMS
                label.setHorizontalAlignment(SwingConstants.RIGHT);
                break;
            case 10://Val ICMS
                label.setHorizontalAlignment(SwingConstants.RIGHT);
                break;
            case 11://CST PIS
                label.setHorizontalAlignment(SwingConstants.CENTER);
                break;
            case 12://Base PIS
                label.setHorizontalAlignment(SwingConstants.RIGHT);
                break;
            case 13://Aliq PIS
                label.setHorizontalAlignment(SwingConstants.RIGHT);
                break;
            case 14://Val PIS
                label.setHorizontalAlignment(SwingConstants.RIGHT);
                break;
                case 15://CST COFINS
                label.setHorizontalAlignment(SwingConstants.CENTER);
                break;
            case 16://Base COFINS
                label.setHorizontalAlignment(SwingConstants.RIGHT);
                break;
            case 17://Aliq COFINS
                label.setHorizontalAlignment(SwingConstants.RIGHT);
                break;
            case 18://Val COFINS
                label.setHorizontalAlignment(SwingConstants.RIGHT);
                break;
            
        }
        //label.setForeground(foreground);
        label.setBackground(background);
        return label;
    }

}
