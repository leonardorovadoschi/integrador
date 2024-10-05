/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador.render.produto;

import entidade.cplus.Localizacao;
import javax.persistence.EntityManagerFactory;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import query.cplus.QueryCplus;

/**
 *
 * @author leonardo
 */
public class RenderLocalizacao extends DefaultTableCellRenderer{
    private EntityManagerFactory emf;

    public RenderLocalizacao(EntityManagerFactory managerCplus) {       
        emf = managerCplus;
        setHorizontalAlignment(SwingConstants.RIGHT);
    }

    @Override
    public void setValue(Object aValue) {
        String nome = "";
        if ((aValue != null) && (aValue instanceof String)) {         
                for(Localizacao valor : new QueryCplus(emf).listLocalizacao(aValue.toString())){                     
                nome = valor.getDescricao();  
                }
        } else {
            nome = "erro";
        }
        super.setValue(nome);
    }
}
