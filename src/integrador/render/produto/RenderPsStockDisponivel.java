/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador.render.produto;

import entidade.prestaShop.PsStockAvailable;
import java.awt.Color;
import java.awt.Component;
import javax.persistence.EntityManagerFactory;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import query.prestaShop.QueryPrestaShop;

/**
 *
 * @author Fazenda
 */
public class RenderPsStockDisponivel extends DefaultTableCellRenderer {

    private EntityManagerFactory emf;
    private int v;

    public RenderPsStockDisponivel(EntityManagerFactory managerPrestaShop) {
        //setHorizontalAlignment(SwingConstants.RIGHT);
        emf = managerPrestaShop;

    }

    @Override
    public void setValue(Object aValue) {
        String nome = "";
        if ((aValue != null) && (aValue instanceof Integer)) {
           // PsProduct psProduct;
           // psProduct = new PsProductJpaController(emf).findPsProduct(Integer.valueOf(aValue.toString()));
            for (PsStockAvailable sa : new QueryPrestaShop().listPsStockAvailable((Integer) aValue, 1)) {
                nome = String.valueOf(sa.getQuantity());
                v = sa.getQuantity();
            }
        }
        super.setValue(nome);
    }

    @Override
    public Component getTableCellRendererComponent(JTable aTable, Object objectValue, boolean aIsSelected, boolean aHasFocus, int aRow, int aColumn) {
        if (objectValue == null) {
            return this;
        }
        Component renderer = super.getTableCellRendererComponent(aTable, objectValue, aIsSelected, aHasFocus, aRow, aColumn);
        if (v < 1) {
            renderer.setForeground(Color.RED);          
        } else {
            renderer.setForeground(Color.BLUE);         
        }
        return this;
    }
}
