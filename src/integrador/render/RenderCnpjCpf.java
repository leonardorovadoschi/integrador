/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador.render;

import java.text.ParseException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author leonardo
 */
public class RenderCnpjCpf extends DefaultTableCellRenderer {

    public RenderCnpjCpf() {
        // setHorizontalAlignment(SwingConstants.RIGHT);
    }

    @Override
    public void setValue(Object aValue) {
        Object result = aValue;
        if ((aValue != null) && (aValue instanceof String)) {
            aValue = aValue.toString().replaceAll("[^0-9]", "");
            if (aValue.toString().length() == 14) {             
                try {
                    MaskFormatter cnpj = new MaskFormatter("##.###.###/####-##");
                    cnpj.setValueContainsLiteralCharacters(false);
                    result = cnpj.valueToString(aValue.toString());
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Erro no Cell Render CNPJ\n" + ex);
                }
            } else if (aValue.toString().length() == 11) {
                try {
                    MaskFormatter cpf = new MaskFormatter("###.###.###-##");
                    cpf.setValueContainsLiteralCharacters(false);
                    result = cpf.valueToString(aValue.toString());
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Erro no Cell Render CPF\n" + ex);
                }
            }
        }
        super.setValue(result);
    }
}
