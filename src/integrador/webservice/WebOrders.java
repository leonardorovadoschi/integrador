/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador.webservice;

import entidade.prestaShop.PsOrders;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.EntityManagerFactory;
import javax.swing.JOptionPane;
import jpa.prestaShop.PsOrdersJpaController;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 *
 * @author leona
 */
public class WebOrders {

    public PsOrders xmlParaEntidade(Document document, ClienteWebService ws, EntityManagerFactory managerPrestaShop) {
        //document = ws.getFuncao(getSchemaOpt);
        Element elemento = document.getDocumentElement();
        NodeList listNode = elemento.getElementsByTagName("order");
        PsOrders psOrders = null;
        String teste = "";
        for (int i = 0; i < listNode.getLength(); i++) {
            Element endElement = (Element) listNode.item(i);
            psOrders = new PsOrdersJpaController(managerPrestaShop).findPsOrders(Integer.valueOf(ws.obterValorObjeto(endElement, "id")));
            System.out.println("Id: " + ws.obterValorObjeto(endElement, "id"));
            System.out.println("id_customer: " + ws.obterValorObjeto(endElement, "id_customer"));
            System.out.println("id_address_invoice: " + ws.obterValorObjeto(endElement, "id_address_invoice"));

            // PsOrders psOrders = new PsOrders();
            // psOrders.setIdOrder(Integer.valueOf(ws.obterValorObjeto(endElement, "id")));
            psOrders.setIdAddressDelivery(Integer.valueOf(ws.obterValorObjeto(endElement, "id_address_delivery")));
            psOrders.setIdAddressInvoice(Integer.valueOf(ws.obterValorObjeto(endElement, "id_address_invoice")));
            psOrders.setIdCart(Integer.valueOf(ws.obterValorObjeto(endElement, "id_cart")));
            psOrders.setIdCurrency(Integer.valueOf(ws.obterValorObjeto(endElement, "id_currency")));
            psOrders.setIdLang(Integer.valueOf(ws.obterValorObjeto(endElement, "id_lang")));
            psOrders.setIdCustomer(Integer.valueOf(ws.obterValorObjeto(endElement, "id_customer")));
            psOrders.setIdCarrier(Integer.valueOf(ws.obterValorObjeto(endElement, "id_carrier")));
            psOrders.setCurrentState(Integer.valueOf(ws.obterValorObjeto(endElement, "current_state")));
            psOrders.setModule(ws.obterValorObjeto(endElement, "module"));
            ///  System.out.println("Id: " + ws.obterValorObjeto(endElement, "recyclable"));
            psOrders.setRecyclable(Boolean.valueOf(ws.obterValorObjeto(endElement, "recyclable")));
            psOrders.setGift(Boolean.valueOf(ws.obterValorObjeto(endElement, "gift")));
            teste = ws.obterValorObjeto(endElement, "gift_message");
            if (!"".equals(teste)) {
                psOrders.setGiftMessage(teste);
            }
            // psOrders.setGiftMessage(gif);
            psOrders.setMobileTheme(Boolean.valueOf(ws.obterValorObjeto(endElement, "mobile_theme")));
            teste = ws.obterValorObjeto(endElement, "shipping_number");
            if (!"".equals(teste)) {
                psOrders.setShippingNumber(teste);
            }
            psOrders.setTotalDiscounts(bigDecimal(ws.obterValorObjeto(endElement, "total_discounts")));
            //System.out.println("total_discounts_tax_incl: " + ws.obterValorObjeto(endElement, "total_discounts_tax_incl"));
            psOrders.setTotalDiscountsTaxIncl(bigDecimal(ws.obterValorObjeto(endElement, "total_discounts_tax_incl")));
            psOrders.setTotalDiscountsTaxExcl(bigDecimal(ws.obterValorObjeto(endElement, "total_discounts_tax_excl")));
            psOrders.setTotalPaid(bigDecimal(ws.obterValorObjeto(endElement, "total_paid")));
            psOrders.setTotalPaidTaxIncl(bigDecimal(ws.obterValorObjeto(endElement, "total_paid_tax_incl")));
            psOrders.setTotalPaidReal(bigDecimal(ws.obterValorObjeto(endElement, "total_paid_real")));
            psOrders.setTotalProducts(bigDecimal(ws.obterValorObjeto(endElement, "total_products")));
            psOrders.setTotalProductsWt(bigDecimal(ws.obterValorObjeto(endElement, "total_products_wt")));
            psOrders.setTotalShipping(bigDecimal(ws.obterValorObjeto(endElement, "total_shipping")));
            psOrders.setTotalShippingTaxIncl(bigDecimal(ws.obterValorObjeto(endElement, "total_shipping_tax_incl")));
            psOrders.setTotalShippingTaxExcl(bigDecimal(ws.obterValorObjeto(endElement, "total_shipping_tax_excl")));
            teste = ws.obterValorObjeto(endElement, "Carrier_tax_rate");
            if (!"".equals(teste)) {
                psOrders.setCarrierTaxRate(bigDecimal(teste));
            }
            psOrders.setTotalWrapping(bigDecimal(ws.obterValorObjeto(endElement, "total_wrapping")));
            psOrders.setTotalWrappingTaxIncl(bigDecimal(ws.obterValorObjeto(endElement, "total_wrapping_tax_incl")));
            psOrders.setTotalWrappingTaxExcl(bigDecimal(ws.obterValorObjeto(endElement, "total_wrapping_tax_excl")));
            psOrders.setRoundMode(Boolean.valueOf(ws.obterValorObjeto(endElement, "round_mode")));
            psOrders.setRoundType(Boolean.valueOf(ws.obterValorObjeto(endElement, "round_type")));
            psOrders.setInvoiceNumber(Integer.valueOf(ws.obterValorObjeto(endElement, "invoice_number")));
            psOrders.setDeliveryNumber(Integer.valueOf(ws.obterValorObjeto(endElement, "delivery_number")));
            teste = ws.obterValorObjeto(endElement, "invoice_date");
            if (!"".equals(teste) && !"0000-00-00 00:00:00".equals(teste)) {
                psOrders.setInvoiceDate(dataWebService(teste));
            }
            teste = ws.obterValorObjeto(endElement, "delivery_date");
            if (!"".equals(teste)&& !"0000-00-00 00:00:00".equals(teste)) {
                psOrders.setDeliveryDate(dataWebService(teste));
            }
            psOrders.setValid(Integer.valueOf(ws.obterValorObjeto(endElement, "valid")));
            psOrders.setDateAdd(dataWebService(ws.obterValorObjeto(endElement, "date_add")));
            psOrders.setDateUpd(dataWebService(ws.obterValorObjeto(endElement, "date_upd")));         
        }
        return psOrders;
    }

    private BigDecimal bigDecimal(String valor) {
        BigDecimal big = BigDecimal.ZERO;
        if (valor != null && !"".equals(valor)) {
            big = new BigDecimal(valor);
        }
        return big;
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
