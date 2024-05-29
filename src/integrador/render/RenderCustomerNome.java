/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador.render;

import entidade.prestaShop.PsCustomer;
import javax.persistence.EntityManagerFactory;
import javax.swing.table.DefaultTableCellRenderer;
import query.prestaShop.QueryPrestaShop;

/**
 *
 * @author leonardo
 */
public class RenderCustomerNome extends DefaultTableCellRenderer {

   // public QueryPrestaShop(EntityManagerFactory emf) {
    //   this.emf = emf;
    // }
    private EntityManagerFactory emf;

    public RenderCustomerNome(EntityManagerFactory managerPrestaShop) {
        //setHorizontalAlignment(SwingConstants.RIGHT);
        emf = managerPrestaShop;
    }

    @Override
    public void setValue(Object aValue) {
        String nome = "";
        if ((aValue != null) && (aValue instanceof Integer)) {         
                for(PsCustomer valor : new QueryPrestaShop(emf).listCustomer(Integer.valueOf(aValue.toString()))){                     
                nome = valor.getFirstname() + " " + valor.getLastname();  
                }
        } else {
            nome = "ID cliente nulo";
        }
        super.setValue(nome);
    }

}
