/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package integrador.webservice;

import entidade.prestaShop.PsCustomer;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 *
 * @author Fazenda
 */
public class WebCustomer {  
    
    private Date birthdayWebService(String dataString) {
        Date data;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            data = sdf.parse(dataString.replace("/", ""));
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Alguns dos campos de datas\n Não São Válidos" + ex);
            data = dataAtual();
        }
        return data;
    }
    
    private Date dataWebService(String dataString) {
        Date data;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            data = sdf.parse(dataString.replace("/", ""));
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Alguns dos campos de datas\n Não São Válidos" + ex);
            data = dataAtual();
        }
        return data;
    }

    private Date dataAtual() {
        Date data = new Date(System.currentTimeMillis());
        return data;
    }
    
    private BigDecimal bigDecimal(String valor) {
        BigDecimal big = BigDecimal.ZERO;
        if (valor != null && !"".equals(valor)) {
            big = new BigDecimal(valor);
        }
        return big;
    }
    
    public PsCustomer xmlParaEntidade(Document document, ClienteWebService ws){
        PsCustomer psCustomer = null;
        Element elemento = document.getDocumentElement();
        NodeList listNode = elemento.getElementsByTagName("customer");
        String teste = "";
        for (int i = 0; i < listNode.getLength(); i++) {
            Element endElement = (Element) listNode.item(i);
            psCustomer = new PsCustomer();
            psCustomer.setNewsletter(Boolean.valueOf(ws.obterValorObjeto(endElement, "newsletter")));
            psCustomer.setOptin(Boolean.valueOf(ws.obterValorObjeto(endElement, "optin")));
            psCustomer.setShowPublicPrices(Boolean.valueOf(ws.obterValorObjeto(endElement, "show_public_prices")));
            psCustomer.setActive(Boolean.valueOf(ws.obterValorObjeto(endElement, "active")));
            //psCustomer.setTipo(ws.obterValorObjeto(endElement, "tipo"));
            teste = ws.obterValorObjeto(endElement, "cpf_cnpj");
            if(!"".equals(teste)){    psCustomer.setCpfCnpj(teste);  }
            teste = ws.obterValorObjeto(endElement, "rg_ie");
            if(!"".equals(teste)){    psCustomer.setRgIe(teste);  }      
            psCustomer.setIdCustomer(Integer.valueOf(ws.obterValorObjeto(endElement, "id")));
            psCustomer.setIdShopGroup(Integer.valueOf(ws.obterValorObjeto(endElement, "id_shop_group")));
            psCustomer.setIdShop(Integer.valueOf(ws.obterValorObjeto(endElement, "id_shop")));
            psCustomer.setIdGender(Integer.valueOf(ws.obterValorObjeto(endElement, "id_gender")));
            psCustomer.setIdDefaultGroup(Integer.valueOf(ws.obterValorObjeto(endElement, "id_default_group")));
            psCustomer.setIdLang(Integer.valueOf(ws.obterValorObjeto(endElement, "id_lang")));
            psCustomer.setIdRisk(Integer.valueOf(ws.obterValorObjeto(endElement, "id_risk")));
            psCustomer.setCompany(ws.obterValorObjeto(endElement, "company"));
            psCustomer.setSiret(ws.obterValorObjeto(endElement, "siret"));
            teste = ws.obterValorObjeto(endElement, "ape");
            if(!"".equals(teste)){    psCustomer.setApe(teste);  }          
            psCustomer.setFirstname(ws.obterValorObjeto(endElement, "firstname"));
            psCustomer.setLastname(ws.obterValorObjeto(endElement, "lastname"));
            psCustomer.setEmail(ws.obterValorObjeto(endElement, "email"));
            psCustomer.setPasswd(ws.obterValorObjeto(endElement, "passwd"));
            psCustomer.setLastPasswdGen(dataWebService(ws.obterValorObjeto(endElement, "last_passwd_gen")));
            psCustomer.setBirthday(birthdayWebService(ws.obterValorObjeto(endElement, "birthday")));
            teste = ws.obterValorObjeto(endElement, "ip_registration_newsletter");
            if(!"".equals(teste)){    psCustomer.setIpRegistrationNewsletter(teste);  }
            psCustomer.setNewsletterDateAdd(dataWebService(ws.obterValorObjeto(endElement, "newsletter_date_add")));
            teste = ws.obterValorObjeto(endElement, "website");
            if(!"".equals(teste)){    psCustomer.setWebsite(teste);  }           
            psCustomer.setOutstandingAllowAmount(bigDecimal(ws.obterValorObjeto(endElement, "outstanding_allow_amount")));
            psCustomer.setMaxPaymentDays(Integer.valueOf(ws.obterValorObjeto(endElement, "max_payment_days")));
            psCustomer.setSecureKey(ws.obterValorObjeto(endElement, "secure_key"));
            psCustomer.setNote(ws.obterValorObjeto(endElement, "note"));
            psCustomer.setIsGuest(Boolean.valueOf(ws.obterValorObjeto(endElement, "is_guest")));
            psCustomer.setDeleted(Boolean.valueOf(ws.obterValorObjeto(endElement, "deleted")));
            psCustomer.setDateAdd(dataWebService(ws.obterValorObjeto(endElement, "date_add")));
            psCustomer.setDateUpd(dataWebService(ws.obterValorObjeto(endElement, "date_upd")));
            teste = ws.obterValorObjeto(endElement, "reset_password_validity");
            if(!"".equals(teste)){    psCustomer.setResetPasswordToken(teste);  }
             if (!"".equals(teste) && !"0000-00-00 00:00:00".equals(teste)) {     psCustomer.setResetPasswordValidity(dataWebService(teste)); }          
        }
        return psCustomer;
    }    

}
