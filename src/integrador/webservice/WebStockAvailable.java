/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador.webservice;

import entidade.prestaShop.PsStockAvailable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 *
 * @author leo
 */
public class WebStockAvailable {

    public PsStockAvailable xmlParaEntidade(Document document, ClienteWebService ws) {
        Element elemento = document.getDocumentElement();
        NodeList listNode = elemento.getElementsByTagName("stock_available");
        PsStockAvailable psStockAvailable = null;
       // String teste = "";
        for (int i = 0; i < listNode.getLength(); i++) {
            Element endElement = (Element) listNode.item(i);
            psStockAvailable = new PsStockAvailable();
            psStockAvailable.setIdStockAvailable(Integer.valueOf(ws.obterValorObjeto(endElement, "id")));
            psStockAvailable.setIdProduct(Integer.valueOf(ws.obterValorObjeto(endElement, "id_product")));
            psStockAvailable.setIdProductAttribute(Integer.valueOf(ws.obterValorObjeto(endElement, "id_product_attribute")));
            psStockAvailable.setIdShop(Integer.valueOf(ws.obterValorObjeto(endElement, "id_shop")));
            psStockAvailable.setIdShopGroup(Integer.valueOf(ws.obterValorObjeto(endElement, "id_shop_group")));
            psStockAvailable.setQuantity(Integer.valueOf(ws.obterValorObjeto(endElement, "quantity")));
            psStockAvailable.setDependsOnStock(Boolean.valueOf(ws.obterValorObjeto(endElement, "depends_on_stock")));
            psStockAvailable.setOutOfStock(Boolean.valueOf(ws.obterValorObjeto(endElement, "out_of_stock")));
            
        }       
        return psStockAvailable;
    }
    
}
