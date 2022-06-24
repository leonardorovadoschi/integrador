/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package integrador.webservice;

import entidade.prestaShop.PsProduct;
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
public class WebProducts {
    public PsProduct xmlParaEntidade(Document document, ClienteWebService ws) {
        Element elemento = document.getDocumentElement();
        NodeList listNode = elemento.getElementsByTagName("product");
        PsProduct psProduct = null;
        String teste = "";
        for (int i = 0; i < listNode.getLength(); i++) {
            if(i == 0){
            Element endElement = (Element) listNode.item(i);
            psProduct = new PsProduct();
            psProduct.setIdProduct(Integer.valueOf(ws.obterValorObjeto(endElement, "id")));
            psProduct.setIdManufacturer(Integer.valueOf(ws.obterValorObjeto(endElement, "id_manufacturer")));
            psProduct.setIdSupplier(Integer.valueOf(ws.obterValorObjeto(endElement, "id_supplier")));
            psProduct.setIdCategoryDefault(Integer.valueOf(ws.obterValorObjeto(endElement, "id_category_default")));
           // psProduct.set(Integer.valueOf(ws.obterValorObjeto(endElement, "new")));
            psProduct.setCacheDefaultAttribute(Integer.valueOf(ws.obterValorObjeto(endElement, "cache_default_attribute")));
            psProduct.setIdTaxRulesGroup(Integer.valueOf(ws.obterValorObjeto(endElement, "id_tax_rules_group")));
            psProduct.setQuantity(Integer.valueOf(ws.obterValorObjeto(endElement, "quantity")));
            psProduct.setIdShopDefault(Integer.valueOf(ws.obterValorObjeto(endElement, "id_shop_default")));
            psProduct.setReference(ws.obterValorObjeto(endElement, "reference"));
            psProduct.setSupplierReference(ws.obterValorObjeto(endElement, "supplier_reference"));
            psProduct.setWidth(bigDecimal(ws.obterValorObjeto(endElement, "width")));
            psProduct.setHeight(bigDecimal(ws.obterValorObjeto(endElement, "height")));
            psProduct.setDepth(bigDecimal(ws.obterValorObjeto(endElement, "depth")));
            psProduct.setWeight(bigDecimal(ws.obterValorObjeto(endElement, "weight")));
            psProduct.setQuantityDiscount(Boolean.valueOf(ws.obterValorObjeto(endElement, "quantity_discount")));
            psProduct.setEan13(ws.obterValorObjeto(endElement, "ean13"));
            psProduct.setCacheIsPack(Boolean.valueOf(ws.obterValorObjeto(endElement, "cache_is_pack")));
            psProduct.setCacheHasAttachments(Boolean.valueOf(ws.obterValorObjeto(endElement, "cache_has_attachments")));
            psProduct.setIsVirtual(Boolean.valueOf(ws.obterValorObjeto(endElement, "is_virtual")));
            psProduct.setState(Integer.valueOf(ws.obterValorObjeto(endElement, "state")));
            psProduct.setAdditionalDeliveryTimes(Boolean.valueOf(ws.obterValorObjeto(endElement, "additional_delivery_times")));
            psProduct.setOnSale(Boolean.valueOf(ws.obterValorObjeto(endElement, "on_sale")));
            psProduct.setOnlineOnly(Boolean.valueOf(ws.obterValorObjeto(endElement, "online_only")));
            psProduct.setEcotax(bigDecimal(ws.obterValorObjeto(endElement, "ecotax")));
            psProduct.setMinimalQuantity(Integer.valueOf(ws.obterValorObjeto(endElement, "minimal_quantity")));
            psProduct.setLowStockThreshold(Integer.valueOf(ws.obterValorObjeto(endElement, "low_stock_threshold")));
            psProduct.setLowStockAlert(Boolean.valueOf(ws.obterValorObjeto(endElement, "low_stock_aler")));
            psProduct.setPrice(bigDecimal(ws.obterValorObjeto(endElement, "price")));
            psProduct.setWholesalePrice(bigDecimal(ws.obterValorObjeto(endElement, "wholesale_price")));
            psProduct.setUnitPriceRatio(bigDecimal(ws.obterValorObjeto(endElement, "unit_price_ratio")));
            psProduct.setAdditionalShippingCost(bigDecimal(ws.obterValorObjeto(endElement, "additional_shipping_cost")));
            psProduct.setCustomizable(Short.valueOf(ws.obterValorObjeto(endElement, "customizable")));
            psProduct.setTextFields(Short.valueOf(ws.obterValorObjeto(endElement, "text_fields")));
            psProduct.setUploadableFiles(Short.valueOf(ws.obterValorObjeto(endElement, "uploadable_files")));
            psProduct.setActive(Boolean.valueOf(ws.obterValorObjeto(endElement, "active")));
            psProduct.setRedirectType(ws.obterValorObjeto(endElement, "redirect_type"));
            psProduct.setIdTypeRedirected(Integer.valueOf(ws.obterValorObjeto(endElement, "id_type_redirected")));
            psProduct.setAvailableForOrder(Boolean.valueOf(ws.obterValorObjeto(endElement, "available_for_order")));
            psProduct.setAvailableDate(dataModWebService(ws.obterValorObjeto(endElement, "available_date")));
            psProduct.setShowCondition(Boolean.valueOf(ws.obterValorObjeto(endElement, "show_condition")));
            psProduct.setCondition1(ws.obterValorObjeto(endElement, "condition"));
            psProduct.setShowPrice(Boolean.valueOf(ws.obterValorObjeto(endElement, "show_price")));
            psProduct.setIndexed(Boolean.valueOf(ws.obterValorObjeto(endElement, "indexed")));
            psProduct.setVisibility(ws.obterValorObjeto(endElement, "visibility"));
            psProduct.setAdvancedStockManagement(Boolean.valueOf(ws.obterValorObjeto(endElement, "advanced_stock_management")));
            psProduct.setDateAdd(dataWebService(ws.obterValorObjeto(endElement, "date_add")));
            psProduct.setDateUpd(dataWebService(ws.obterValorObjeto(endElement, "date_upd")));
            psProduct.setPackStockType(Integer.valueOf(ws.obterValorObjeto(endElement, "pack_stock_type")));
            }
        } 
        
        return psProduct;
    }
    
     private BigDecimal bigDecimal(String valor) {
        BigDecimal big = BigDecimal.ZERO;
        if (valor != null && !"".equals(valor)) {
            big = new BigDecimal(valor);
        }
        return big;
    }

      private Date dataModWebService(String dataString) {
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
}
