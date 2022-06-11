/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package integrador.webservice;

import entidade.prestaShop.PsOrders;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 *
 * @author leona
 */
public class WebOrders {
    
    public PsOrders xmlParaEntidade(Document document, ClienteWebService ws){
        //document = ws.getFuncao(getSchemaOpt);
                            Element elemento = document.getDocumentElement();
                            NodeList listNode = elemento.getElementsByTagName("order");
                            PsOrders psOrders = new PsOrders();
                            for (int i = 0; i < listNode.getLength(); i++) {
                                Element endElement = (Element) listNode.item(i);
                                
                               // PsOrders psOrders = new PsOrders();
                                psOrders.setIdOrder(Integer.valueOf(ws.obterValorObjeto(endElement, "id")));
                                psOrders.setIdAddressDelivery(Integer.valueOf(ws.obterValorObjeto(endElement, "id_address_delivery")));
                                psOrders.setIdAddressInvoice(Integer.valueOf(ws.obterValorObjeto(endElement, "id_address_invoice")));
                                psOrders.setIdCart(Integer.valueOf(ws.obterValorObjeto(endElement, "id_cart")));
                                psOrders.setIdCurrency(Integer.valueOf(ws.obterValorObjeto(endElement, "id_currency")));
                                psOrders.setIdLang(Integer.valueOf(ws.obterValorObjeto(endElement, "id_lang")));
                                psOrders.setIdCustomer(Integer.valueOf(ws.obterValorObjeto(endElement, "id_customer")));
                                psOrders.setIdCarrier(Integer.valueOf(ws.obterValorObjeto(endElement, "id_carrier")));
                                psOrders.setCurrentState(Integer.valueOf(ws.obterValorObjeto(endElement, "current_state")));
                                psOrders.setModule(ws.obterValorObjeto(endElement, "module"));
                                
                                System.out.println("Id: " + ws.obterValorObjeto(endElement, "id"));
                                System.out.println("id_customer: " + ws.obterValorObjeto(endElement, "id_customer"));
                                System.out.println("id_address_invoice: " + ws.obterValorObjeto(endElement, "id_address_invoice"));
                            }
                            return psOrders;
    }
}
