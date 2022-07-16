/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package integrador.render.produto;

import entidade.prestaShop.PsProduct;
import entidade.prestaShop.PsStockAvailable;
import javax.persistence.EntityManagerFactory;
import javax.swing.table.DefaultTableCellRenderer;
import jpa.prestaShop.PsProductJpaController;
import query.prestaShop.QueryPrestaShop;

/**
 *
 * @author Fazenda
 */
public class RenderPsStockDisponivel  extends DefaultTableCellRenderer{
    private EntityManagerFactory emf;
    public RenderPsStockDisponivel(EntityManagerFactory managerPrestaShop) {
        //setHorizontalAlignment(SwingConstants.RIGHT);
        emf = managerPrestaShop;  
    }

    @Override
    public void setValue(Object aValue) {
        String nome = "";
        if ((aValue != null) && (aValue instanceof Integer)) {                     
            PsProduct psProduct;
            psProduct = new PsProductJpaController(emf).findPsProduct(Integer.valueOf(aValue.toString()));
            for(PsStockAvailable sa : new QueryPrestaShop(emf).listPsStockAvailable(psProduct.getIdProduct(), 1))
                nome = String.valueOf(sa.getQuantity());
            }       
        super.setValue(nome);
    }
}
