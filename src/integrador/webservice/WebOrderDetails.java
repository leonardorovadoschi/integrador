/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package integrador.webservice;

import entidade.prestaShop.PsCustomer;
import entidade.prestaShop.PsOrderDetail;
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
public class WebOrderDetails {
    public PsOrderDetail xmlParaEntidade(Document document, ClienteWebService ws){
      PsOrderDetail psOrderDetail = null  ;
        Element elemento = document.getDocumentElement();
        NodeList listNode = elemento.getElementsByTagName("order_detail");
        String teste = "";
        for (int i = 0; i < listNode.getLength(); i++) {
            Element endElement = (Element) listNode.item(i);
            psOrderDetail = new PsOrderDetail();
            psOrderDetail.setIdOrderDetail(Integer.valueOf(ws.obterValorObjeto(endElement, "id")));
            psOrderDetail.setIdOrder(Integer.valueOf(ws.obterValorObjeto(endElement, "id_order")));
            psOrderDetail.setProductId(Integer.valueOf(ws.obterValorObjeto(endElement, "product_id")));
            psOrderDetail.setProductAttributeId(Integer.valueOf(ws.obterValorObjeto(endElement, "product_attribute_id")));
            psOrderDetail.setProductQuantityReinjected(Integer.valueOf(ws.obterValorObjeto(endElement, "product_quantity_reinjected")));
            psOrderDetail.setGroupReduction(bigDecimal(ws.obterValorObjeto(endElement, "group_reduction")));
            psOrderDetail.setDiscountQuantityApplied(Boolean.valueOf(ws.obterValorObjeto(endElement, "discount_quantity_applied")));
            teste = ws.obterValorObjeto(endElement, "download_deadline");
            if (!"".equals(teste) && !"0000-00-00 00:00:00".equals(teste)) {    psOrderDetail.setDownloadDeadline(dataWebService(teste)); }
            psOrderDetail.setIdOrderInvoice(Integer.valueOf(ws.obterValorObjeto(endElement, "id_order_invoice")));
            psOrderDetail.setIdWarehouse(Integer.valueOf(ws.obterValorObjeto(endElement, "id_warehouse")));
            psOrderDetail.setIdShop(Integer.valueOf(ws.obterValorObjeto(endElement, "id_shop")));
            psOrderDetail.setIdCustomization(Integer.valueOf(ws.obterValorObjeto(endElement, "id_customization")));
            psOrderDetail.setProductName(ws.obterValorObjeto(endElement, "product_name"));
            psOrderDetail.setProductQuantity(Integer.valueOf(ws.obterValorObjeto(endElement, "product_quantity")));
            psOrderDetail.setProductQuantityInStock(Integer.valueOf(ws.obterValorObjeto(endElement, "product_quantity_in_stock")));
            psOrderDetail.setProductQuantityReturn(Integer.valueOf(ws.obterValorObjeto(endElement, "product_quantity_return")));
            psOrderDetail.setProductQuantityRefunded(Integer.valueOf(ws.obterValorObjeto(endElement, "product_quantity_refunded")));
            psOrderDetail.setProductPrice(bigDecimal(ws.obterValorObjeto(endElement, "product_price")));
            psOrderDetail.setReductionPercent(bigDecimal(ws.obterValorObjeto(endElement, "reduction_percent")));
            psOrderDetail.setReductionAmount(bigDecimal(ws.obterValorObjeto(endElement, "reduction_amount")));
            psOrderDetail.setReductionAmountTaxIncl(bigDecimal(ws.obterValorObjeto(endElement, "reduction_amount_tax_incl")));
            psOrderDetail.setReductionAmountTaxExcl(bigDecimal(ws.obterValorObjeto(endElement, "reduction_amount_tax_excl")));
            psOrderDetail.setProductQuantityDiscount(bigDecimal(ws.obterValorObjeto(endElement, "product_quantity_discount")));
            psOrderDetail.setProductEan13(ws.obterValorObjeto(endElement, "product_ean13"));
            psOrderDetail.setProductReference(ws.obterValorObjeto(endElement, "product_reference"));
            teste = ws.obterValorObjeto(endElement, "product_supplier_reference");
            if (!"".equals(teste)) {    psOrderDetail.setProductSupplierReference(teste);  }
           psOrderDetail.setProductWeight(bigDecimal(ws.obterValorObjeto(endElement, "product_weight")));
           psOrderDetail.setTaxComputationMethod(Boolean.valueOf(ws.obterValorObjeto(endElement, "tax_computation_method")));
           psOrderDetail.setIdTaxRulesGroup(Integer.valueOf(ws.obterValorObjeto(endElement, "id_tax_rules_group")));
           psOrderDetail.setEcotax(bigDecimal(ws.obterValorObjeto(endElement, "ecotax")));
           psOrderDetail.setEcotaxTaxRate(bigDecimal(ws.obterValorObjeto(endElement, "ecotax_tax_rate")));
           psOrderDetail.setDownloadNb(Integer.valueOf(ws.obterValorObjeto(endElement, "download_nb")));
           psOrderDetail.setUnitPriceTaxIncl(bigDecimal(ws.obterValorObjeto(endElement, "unit_price_tax_incl")));
           psOrderDetail.setUnitPriceTaxExcl(bigDecimal(ws.obterValorObjeto(endElement, "unit_price_tax_excl")));
           psOrderDetail.setTotalPriceTaxIncl(bigDecimal(ws.obterValorObjeto(endElement, "total_price_tax_incl")));
           psOrderDetail.setTotalPriceTaxExcl(bigDecimal(ws.obterValorObjeto(endElement, "total_price_tax_excl")));
           psOrderDetail.setTotalShippingPriceTaxExcl(bigDecimal(ws.obterValorObjeto(endElement, "total_shipping_price_tax_excl")));
           psOrderDetail.setTotalShippingPriceTaxIncl(bigDecimal(ws.obterValorObjeto(endElement, "total_shipping_price_tax_incl")));
           psOrderDetail.setPurchaseSupplierPrice(bigDecimal(ws.obterValorObjeto(endElement, "purchase_supplier_price")));
           psOrderDetail.setOriginalProductPrice(bigDecimal(ws.obterValorObjeto(endElement, "original_product_price")));
           psOrderDetail.setOriginalWholesalePrice(bigDecimal(ws.obterValorObjeto(endElement, "original_wholesale_price")));
          
        }
      return psOrderDetail;
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
}
