/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador.render;

import entidade.prestaShop.PsCustomer;
import integrador.webservice.ClienteWebService;
import integrador.webservice.PrestaShopWebserviceException;
import integrador.webservice.WebCustomer;
import java.util.HashMap;
import javax.persistence.EntityManagerFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import org.w3c.dom.Document;
import query.integrador.QueryIntegrador;

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
           String shopUrl = new QueryIntegrador(emf).valorConfiguracao("shopURL");
           String key = new QueryIntegrador(emf).valorConfiguracao("shopKEY");
           ClienteWebService ws = new ClienteWebService(shopUrl, key, false);      
           try {
                HashMap<String, Object> getSchemaOpt = new HashMap();
                getSchemaOpt.put("url", shopUrl + "/api/customers/" + aValue.toString());
                Document document;
                document = ws.getFuncao(getSchemaOpt);
                PsCustomer psCustomer;
                psCustomer = new WebCustomer().xmlParaEntidade(document, ws);
                // psOrders = new PsOrdersJpaController(managerPrestaShop).findPsOrders(cod);
                nome = psCustomer.getFirstname() + " " + psCustomer.getLastname();
            } catch (PrestaShopWebserviceException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao consultar Web Service: \n" + ex);
            }
            
            
            //PsCustomer valor;
            //valor = new PsCustomerJpaController(emf).findPsCustomer(Integer.valueOf(aValue.toString()));          
           //     nome = valor.getFirstname() + " " + valor.getLastname();
            }       
        super.setValue(nome);
    }
    
}
