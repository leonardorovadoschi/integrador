/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador.render;

import entidade.prestaShop.PsCustomer;
import javax.persistence.EntityManagerFactory;
import javax.swing.table.DefaultTableCellRenderer;
import jpa.prestaShop.PsCustomerJpaController;

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
            PsCustomer valor;
            valor = new PsCustomerJpaController(emf).findPsCustomer(Integer.valueOf(aValue.toString()));          
                nome = valor.getFirstname() + " " + valor.getLastname();
            }       
        super.setValue(nome);
    }
    
}
