/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package integrador.render.produto;

import java.text.NumberFormat;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Fazenda
 */
public class RenderPsProductPeso extends DefaultTableCellRenderer{
    public RenderPsProductPeso() {
        setHorizontalAlignment(SwingConstants.RIGHT);
    }
    @Override
    public void setValue(Object aValue) {
        Object result = null;
        if ((aValue != null) && (aValue instanceof Number)) {
            Number numberValue = (Number) aValue;
            NumberFormat formatter = NumberFormat.getNumberInstance();
            formatter.setMinimumFractionDigits(3);
            result = formatter.format(numberValue.doubleValue() );
        }
        super.setValue(result);
    }
    
}
