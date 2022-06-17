/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador.webservice;

import entidade.prestaShop.PsSpecificPrice;
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
 * @author leo
 */
public class WebSpecificPrice {
    public PsSpecificPrice xmlParaEntidade(Document document, ClienteWebService ws) {
        Element elemento = document.getDocumentElement();
        NodeList listNode = elemento.getElementsByTagName("specific_price");
        PsSpecificPrice psSpecificPrice = null;
        for (int i = 0; i < listNode.getLength(); i++) {
            Element endElement = (Element) listNode.item(i);
            psSpecificPrice = new PsSpecificPrice();
            psSpecificPrice.setIdSpecificPrice(Integer.valueOf(ws.obterValorObjeto(endElement, "id")));
            psSpecificPrice.setIdShopGroup(Integer.valueOf(ws.obterValorObjeto(endElement, "id_shop_group")));
            psSpecificPrice.setIdShop(Integer.valueOf(ws.obterValorObjeto(endElement, "id_shop")));
            psSpecificPrice.setIdCart(Integer.valueOf(ws.obterValorObjeto(endElement, "id_cart")));
            psSpecificPrice.setIdProduct(Integer.valueOf(ws.obterValorObjeto(endElement, "id_product")));
            psSpecificPrice.setIdProductAttribute(Integer.valueOf(ws.obterValorObjeto(endElement, "id_product_attribute")));
            psSpecificPrice.setIdCurrency(Integer.valueOf(ws.obterValorObjeto(endElement, "id_currency")));
            psSpecificPrice.setIdCountry(Integer.valueOf(ws.obterValorObjeto(endElement, "id_country")));
            psSpecificPrice.setIdGroup(Integer.valueOf(ws.obterValorObjeto(endElement, "id_group")));
            psSpecificPrice.setIdCustomer(Integer.valueOf(ws.obterValorObjeto(endElement, "id_customer")));
            psSpecificPrice.setIdSpecificPriceRule(Integer.valueOf(ws.obterValorObjeto(endElement, "id_specific_price_rule")));
            psSpecificPrice.setPrice(new BigDecimal(ws.obterValorObjeto(endElement, "price")));
            psSpecificPrice.setFromQuantity(Integer.valueOf(ws.obterValorObjeto(endElement, "from_quantity")));
            psSpecificPrice.setReduction(new BigDecimal(ws.obterValorObjeto(endElement, "reduction")));
            psSpecificPrice.setReductionTax(Boolean.valueOf(ws.obterValorObjeto(endElement, "reduction_tax")));
            psSpecificPrice.setReductionType(ws.obterValorObjeto(endElement, "reduction_type"));
            psSpecificPrice.setFrom(dataWebService(ws.obterValorObjeto(endElement, "from")));
            psSpecificPrice.setTo(dataWebService(ws.obterValorObjeto(endElement, "to")));           
        }
        return psSpecificPrice;
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
}
