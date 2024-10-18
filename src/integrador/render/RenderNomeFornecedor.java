/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador.render;

import entidade.cplus.Fornecedor;
import javax.persistence.EntityManagerFactory;
import javax.swing.table.DefaultTableCellRenderer;
import jpa.cplus.FornecedorJpaController;
import query.cplus.QueryCplus;

/**
 *
 * @author leo
 */
public class RenderNomeFornecedor extends DefaultTableCellRenderer {
private EntityManagerFactory emf;
    
    public RenderNomeFornecedor(EntityManagerFactory managerPrestaShop) {
        //setHorizontalAlignment(SwingConstants.RIGHT);
        emf = managerPrestaShop;  
    }

    @Override
    public void setValue(Object aValue) {
        String nome = "";
        if ((aValue != null) && ( aValue instanceof String)) {                     
            for(Fornecedor valor : new QueryCplus().resultFornecedor(aValue.toString())){
           // valor = new FornecedorJpaController(emf).findFornecedor(aValue.toString());          
                nome = valor.getNomeforn();
            }
            }       
        super.setValue(nome);
    }  
}
