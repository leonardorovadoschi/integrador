/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package integrador.render;

import entidade.cplus.Nfceletronica;
import java.util.Collection;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author leonardo
 */
public class RenderNumeroNFCe extends DefaultTableCellRenderer {
    
     public RenderNumeroNFCe() {
        setHorizontalAlignment(SwingConstants.RIGHT);
    }
     
      @Override
    public void setValue(Object aValue) {
        Object result = null;
        if ((aValue != null) && (aValue instanceof Collection)) {
            Collection<Nfceletronica> listNFCe = (Collection<Nfceletronica>) aValue;
            for(Nfceletronica nfce : listNFCe){
                if(!"".equals(nfce.getCodnfceletronica())){
                    int i = Integer.parseInt(nfce.getCodnfceletronica());
                    result = i;
                }else{
                    result = 0;
                }
            }
        }
        super.setValue(result);
    }
}
