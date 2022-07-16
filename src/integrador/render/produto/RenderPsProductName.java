/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador.render.produto;

import entidade.prestaShop.PsProductLang;
import javax.persistence.EntityManagerFactory;
import javax.swing.table.DefaultTableCellRenderer;
import query.prestaShop.QueryPrestaShop;

/**
 *
 * @author Fazenda
 */
public class RenderPsProductName extends DefaultTableCellRenderer {

    private EntityManagerFactory emf;

    public RenderPsProductName(EntityManagerFactory managerPrestaShop) {
        //setHorizontalAlignment(SwingConstants.RIGHT);
        emf = managerPrestaShop;
    }

    @Override
    public void setValue(Object aValue) {
        String nome = "";
        if ((aValue != null) && (aValue instanceof Integer)) {
            // int in = (Integer) aValue;
            //PsProductLang lan = new QueryPrestaShop(emf).psProductLang((Integer) aValue, 2);
           for (PsProductLang lan : new QueryPrestaShop(emf).listPsProductLang((Integer) aValue, 2)) {
                nome = lan.getName();
            }
        }
        super.setValue(nome);
    }
}
