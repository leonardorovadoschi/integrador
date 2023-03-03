/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package query.prestaShop;

import entidade.prestaShop.PsAddress;
import entidade.prestaShop.PsCarrier;
import entidade.prestaShop.PsCart;
import entidade.prestaShop.PsCartCartRule;
import entidade.prestaShop.PsCartProduct;
import entidade.prestaShop.PsCartRule;
import entidade.prestaShop.PsCategoryLang;
import entidade.prestaShop.PsCategoryProduct;
import entidade.prestaShop.PsCustomPaymentMethodLang;
import entidade.prestaShop.PsCustomer;
import entidade.prestaShop.PsCustomerGroup;
import entidade.prestaShop.PsManufacturer;
import entidade.prestaShop.PsManufacturerLang;
import entidade.prestaShop.PsManufacturerShop;
import entidade.prestaShop.PsMessage;
import entidade.prestaShop.PsModuloCpf;
import entidade.prestaShop.PsOrderCarrier;
import entidade.prestaShop.PsOrderCartRule;
import entidade.prestaShop.PsOrderDetail;
import entidade.prestaShop.PsOrderInvoice;
import entidade.prestaShop.PsOrderPayment;
import entidade.prestaShop.PsOrderStateLang;
import entidade.prestaShop.PsOrders;
import entidade.prestaShop.PsPack;
import entidade.prestaShop.PsProduct;
import entidade.prestaShop.PsProductCarrier;
import entidade.prestaShop.PsProductLang;
import entidade.prestaShop.PsProductShop;
import entidade.prestaShop.PsProductTag;
import entidade.prestaShop.PsSpecificPrice;
import entidade.prestaShop.PsState;
import entidade.prestaShop.PsStockAvailable;
import entidade.prestaShop.PsTag;
import entidade.prestaShop.PsTagCount;
import entidade.prestaShop.PsTaxLang;
import entidade.prestaShop.PsTaxRulesGroup;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author leo
 */
public class QueryPrestaShop implements Serializable {

    public QueryPrestaShop(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<PsProduct> listProductNome(String nome) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p FROM PsProduct p LEFT JOIN PsProductLang pl ON pl.idProduct = p.idProduct WHERE pl.name LIKE :nome");
        query.setParameter("nome", "%" + nome + "%");
        return query.getResultList();
    }

    public List<PsProduct> listProductNomeOuEan(String nomeProduto) {
        if (!"".equals(nomeProduto)) {
            nomeProduto = nomeProduto.trim();
            String[] listPalavras = nomeProduto.split(" ");

            String querCodigo = "";
            if (listPalavras.length < 2) {
                querCodigo = "p.ean13 LIKE :codigo";
            }

            String quer = "";
            for (int cont = 0; listPalavras.length > cont; cont++) {
                if (cont == 0) {
                    String querOr = "";
                    if (listPalavras.length < 2) {
                        querOr = " OR";
                    }
                    quer = querOr + " pl.name LIKE :nomeProd" + cont;
                } else {
                    quer = quer + " AND pl.name LIKE :nomeProd" + cont;
                }
            }

            quer = quer + " ORDER BY sa.quantity DESC";

            EntityManager em = getEntityManager();
            Query query = em.createQuery("SELECT p FROM PsProductLang pl INNER JOIN PsProduct p ON p.idProduct = pl.psProductLangPK.idProduct INNER JOIN PsStockAvailable sa ON sa.idProduct = p.idProduct WHERE " + querCodigo + quer);
            if (listPalavras.length < 2) {
                query.setParameter("codigo", "%" + nomeProduto.trim() + "%");//primeiro parametro 
            }
            for (int cont = 0; listPalavras.length > cont; cont++) {
                query.setParameter("nomeProd" + cont, "%" + listPalavras[cont].trim() + "%");//primeiro parametro 
            }
            return query.getResultList();
        } else {
            return null;
        }
    }

    public List<PsOrderCarrier> listPsOrderCarrier(Integer idOrder) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsOrderCarrier c WHERE c.idOrder = :idOrder");
        query.setParameter("idOrder", idOrder);
        return query.getResultList();
    }
    
    public List<PsOrderCartRule> listPsOrderCartRule(Integer idOrder) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsOrderCartRule c WHERE c.idOrder = :idOrder");
        query.setParameter("idOrder", idOrder);
        return query.getResultList();
    }
    
    public List<PsCart> listCartMenorData(Date dataUp) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsCart c WHERE c.dateUpd < :dataUp");
        query.setParameter("dataUp", dataUp);
        return query.getResultList();
    }
    
    public List<PsCartProduct> listCarProduct(Integer idCart) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsCartProduct c WHERE c.psCartProductPK.idCart = :idCart");
        query.setParameter("idCart", idCart);
        return query.getResultList();
    }
    
    public List<PsCartCartRule> listCartCartRule(Integer idCart) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsCartCartRule c WHERE c.psCartCartRulePK.idCart =:idCart");
        query.setParameter("idCart", idCart);
        return query.getResultList();
    }
    
     public List<PsCartRule> listCartRule(Integer idCartRule) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsCartRule c WHERE c.idCartRule =:idCartRule");
        query.setParameter("idCartRule", idCartRule);
        return query.getResultList();
    }
         
    /**
     * FunÁ„o que retorna a referencia entre Produto C-plus com o campo
     * regferencia no site
     *
     * @param referencia
     * @return
     */
    public List<PsProduct> listagemProdutoSite(String referencia) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsProduct c WHERE c.reference = :referencia");
        // Query query = em.createQuery("SELECT sa FROM PsStockAvailable sa WHERE sa.quantity :referencia");
        query.setParameter("referencia", referencia);
        return query.getResultList();
    }

    /**
     * Pesquisa o nome da seÁ„o em PsCategoryLang
     *
     * @param nome
     * @return
     */
    public List<PsCategoryLang> listCategoriaPorNome(String nome) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsCategoryLang c WHERE c.psCategoryLangPK.idCategory =:nome");
        query.setParameter("nome", nome);
        return query.getResultList();
    }

    /**
     * FunÁ„o que retorna uma lista de Taxa do site pelo nome do calculo do
     * icms do cplus
     *
     * @param nomeCalculoIcms
     * @return
     */
    public List<PsTaxRulesGroup> listPorNomeCalculoIcms(String nomeCalculoIcms) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsTaxRulesGroup c WHERE c.name =:nomeCalculoIcms");
        query.setParameter("nomeCalculoIcms", nomeCalculoIcms);
        return query.getResultList();
    }

    /**
     * Fun√ß√£o que retorna cliente site pelo e-mail
     *
     * @param email
     * @return
     */
    public List<PsCustomer> listClienteEmail(String email) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsCustomer c WHERE c.email =:email");
        query.setParameter("email", email);
        return query.getResultList();
    }

    /**
     * Fun√ß√£o que retorna o estado cadastrado no site
     *
     * @param id_pais
     * @param estado
     * @return
     */
    public List<PsState> listEstado(int id_pais, String estado) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsState c WHERE c.idCountry =:id_pais AND c.isoCode =:estado");
        query.setParameter("id_pais", id_pais);
        query.setParameter("estado", estado);
        return query.getResultList();
    }

    /**
     * Fun√ß√£o que retorna o endere√ßo co campo address1
     *
     * @param deletado
     * @param idCustomer
     * @param endereco
     * @return
     */
    public List<PsAddress> listEndereco(Boolean deletado, Integer idCustomer, String endereco) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsAddress c WHERE c.address1 =:endereco AND c.idCustomer =:idCustomer AND c.deleted =:deletado");
        query.setParameter("endereco", endereco);
        query.setParameter("idCustomer", idCustomer);
        query.setParameter("deletado", deletado);
        return query.getResultList();
    }

    /**
     * Fun√ß√£o que retorna a lista de grupo no site
     *
     * @param idCustomer
     * @return
     */
    public List<PsCustomerGroup> listCustomerGroup(Integer idCustomer) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsCustomerGroup c WHERE c.psCustomerGroupPK.idCustomer =:idCustomer");
        query.setParameter("idCustomer", idCustomer);
        return query.getResultList();
    }

    /**
     * Fun√ß√£o que retorna o endere√ßo do cliente
     *
     * @param deletado
     * @param idCustomer
     * @return
     */
    public List<PsAddress> listAddress(boolean deletado, Integer idCustomer) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsAddress c WHERE c.idCustomer =:idCustomer AND c.deleted =:deletado");
        query.setParameter("idCustomer", idCustomer);
        query.setParameter("deletado", deletado);
        return query.getResultList();
    }

    public List<PsModuloCpf> listModuloCpf(Integer idCustomer) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsModuloCpf c WHERE c.idCustomer.idCustomer =:idCustomer");
        query.setParameter("idCustomer", idCustomer);
        return query.getResultList();
    }

    /**
     * Retorna lista de Taxas cadastradas no PS
     *
     * @param nomeCalculoIcms
     * @return
     */
    public List<PsTaxLang> resulTaxLang(String nomeCalculoIcms) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsTaxLang c WHERE c.name =:nomeCalculoIcms");
        query.setParameter("nomeCalculoIcms", nomeCalculoIcms);
        return query.getResultList();
    }

    public List<PsTaxRulesGroup> resulTaxRulesGroup(String nomeCalculoIcms) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsTaxRulesGroup c WHERE c.name =:nomeCalculoIcms");
        query.setParameter("nomeCalculoIcms", nomeCalculoIcms);
        return query.getResultList();
    }

    public List<PsStockAvailable> listEstoqueProduto(Integer idProduct) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsStockAvailable c WHERE c.idProduct =:idProduct");
        query.setParameter("idProduct", idProduct);
        return query.getResultList();
    }

    public List<PsCategoryProduct> listCategoriaProduto(Integer idProduct, Integer idCategory) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsCategoryProduct c WHERE c.psCategoryProductPK.idProduct =:idProduct AND c.psCategoryProductPK.idCategory =:idCategory");
        query.setParameter("idProduct", idProduct);
        query.setParameter("idCategory", idCategory);
        return query.getResultList();
    }

    public List<PsCategoryProduct> listCategoriaProduto(Integer idProduct) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsCategoryProduct c WHERE c.psCategoryProductPK.idProduct =:idProduct");
        query.setParameter("idProduct", idProduct);
        return query.getResultList();
    }

    public List<PsProductLang> listPsProductLang(Integer idProduct, Integer idLang) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsProductLang c WHERE c.psProductLangPK.idProduct =:idProduct AND c.psProductLangPK.idLang =:idLang");
        query.setParameter("idProduct", idProduct);
        query.setParameter("idLang", idLang);
        return query.getResultList();
    }

    public List<PsProductShop> listPsProductShop(Integer idProduct, Integer idShop) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsProductShop c WHERE c.psProductShopPK.idProduct =:idProduct AND c.psProductShopPK.idShop =:idShop");
        query.setParameter("idProduct", idProduct);
        query.setParameter("idShop", idShop);
        return query.getResultList();
    }

    public List<PsStockAvailable> listPsStockAvailable(Integer idProduct, Integer idShop) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsStockAvailable c WHERE c.idProduct =:idProduct AND c.idShop =:idShop");
        query.setParameter("idProduct", idProduct);
        query.setParameter("idShop", idShop);
        return query.getResultList();
    }

    public List<PsSpecificPrice> listPsSpecificPrice(Integer idProduct, BigDecimal reduction, Integer idGroup) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsSpecificPrice c WHERE c.idProduct =:idProduct AND c.reduction =:reduction AND c.idGroup =:idGroup");
        query.setParameter("idProduct", idProduct);
        query.setParameter("reduction", reduction);
        query.setParameter("idGroup", idGroup);
        return query.getResultList();
    }

    public List<PsTag> resultPorNomeTag(String nomeTag) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsTag c WHERE c.name =:nomeTag");
        query.setParameter("nomeTag", nomeTag);
        return query.getResultList();
    }

    public List<PsProductTag> listProductTag(Integer idTag, Integer idProduct) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsProductTag c WHERE c.psProductTagPK.idTag =:idTag AND c.psProductTagPK.idProduct =:idProduct");
        query.setParameter("idTag", idTag);
        query.setParameter("idProduct", idProduct);
        return query.getResultList();
    }

    public List<PsTagCount> listTagCount(Integer idTag, Integer IdGroup) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsTagCount c WHERE c.psTagCountPK.idTag =:idTag AND c.psTagCountPK.idGroup =:IdGroup");
        query.setParameter("idTag", idTag);
        query.setParameter("IdGroup", IdGroup);
        return query.getResultList();
    }

    public List<PsProductTag> resultPsProductTag(Integer idProduct) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsProductTag c WHERE c.psProductTagPK.idProduct =:idProduct");
        query.setParameter("idProduct", idProduct);
        return query.getResultList();
    }

    public List<PsManufacturer> listManufacturer(String nomeFabricante) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsManufacturer c WHERE c.name =:nomeFabricante");
        query.setParameter("nomeFabricante", nomeFabricante);
        return query.getResultList();
    }

    public List<PsManufacturerShop> listManufacturerShop(Integer idManufacturer) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsManufacturerShop c WHERE c.psManufacturerShopPK.idManufacturer =:idManufacturer");
        query.setParameter("idManufacturer", idManufacturer);
        return query.getResultList();
    }

    public List<PsManufacturerLang> listManufacturerLang(Integer idManufacturer, Integer idLang) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsManufacturerLang c WHERE c.psManufacturerLangPK.idManufacturer =:idManufacturer AND c.psManufacturerLangPK.idLang =:idLang");
        query.setParameter("idManufacturer", idManufacturer);
        query.setParameter("idLang", idLang);
        return query.getResultList();
    }

    public List<PsOrders> listPsOrders(Integer idOrder) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsOrders c WHERE c.idOrder =:idOrder");
        query.setParameter("idOrder", idOrder);
        return query.getResultList();
    }

    public Iterable<PsOrderDetail> listPsOrderDetail(Integer idOrder) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsOrderDetail c WHERE c.idOrder =:idOrder");
        query.setParameter("idOrder", idOrder);
        return query.getResultList();
    }

    public Iterable<PsPack> listPack(Integer idProductPack) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsPack c WHERE c.psPackPK.idProductPack =:idProductPack");
        query.setParameter("idProductPack", idProductPack);
        return query.getResultList();
    }

    public List<PsPack> listPack(Integer idProductPack, Integer idProductItem) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsPack c WHERE c.psPackPK.idProductItem =:idProductItem AND c.psPackPK.idProductPack =:idProductPack");
        query.setParameter("idProductItem", idProductItem);
        query.setParameter("idProductPack", idProductPack);
        return query.getResultList();
    }

    public List<PsOrders> listPsOrders(Integer currentState, Date dataInicial, Date dataFinal) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsOrders c WHERE c.currentState =:currentState AND c.dateAdd BETWEEN :dataInicial AND :dataFinal");
        query.setParameter("currentState", currentState);
        query.setParameter("dataInicial", dataInicial);
        query.setParameter("dataFinal", dataFinal);
        return query.getResultList();
    }

    public List<PsOrders> listPsOrdersAdd(Date dataInicial, Date dataFinal) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsOrders c WHERE c.dateAdd BETWEEN :dataInicial AND :dataFinal");
        query.setParameter("dataInicial", dataInicial);
        query.setParameter("dataFinal", dataFinal);
        return query.getResultList();
    }

    public List<PsOrders> listPsOrdersUpd(Date dataInicial, Date dataFinal) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsOrders c WHERE c.dateUpd BETWEEN :dataInicial AND :dataFinal");
        query.setParameter("dataInicial", dataInicial);
        query.setParameter("dataFinal", dataFinal);
        return query.getResultList();
    }

    public List<PsCustomer> listCustomer(Integer idCustomer) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsCustomer c WHERE c.idCustomer =:idCustomer");
        query.setParameter("idCustomer", idCustomer);
        return query.getResultList();
    }

    public Iterable<PsCustomer> listCustomerDataAdd(Date dataInicial, Date dataFinal) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsCustomer c WHERE c.dateAdd BETWEEN :dataInicial AND :dataFinal");
        query.setParameter("dataInicial", dataInicial);
        query.setParameter("dataFinal", dataFinal);
        return query.getResultList();
    }

    public Iterable<PsCustomer> listCustomerDataUpd(Date dataInicial, Date dataFinal) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsCustomer c WHERE c.dateUpd BETWEEN :dataInicial AND :dataFinal");
        query.setParameter("dataInicial", dataInicial);
        query.setParameter("dataFinal", dataFinal);
        return query.getResultList();
    }

    public Iterable<PsOrderStateLang> lisPsOrderStateLang(Integer idOrderState, Integer idLang) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsOrderStateLang c WHERE c.psOrderStateLangPK.idOrderState =:idOrderState AND c.psOrderStateLangPK.idLang =:idLang");
        query.setParameter("idOrderState", idOrderState);
        query.setParameter("idLang", idLang);
        return query.getResultList();
    }

    public Iterable<PsCarrier> listPsCarrier(Integer idCarrier) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsCarrier c WHERE c.idCarrier =:idCarrier");
        query.setParameter("idCarrier", idCarrier);
        return query.getResultList();
    }

    public List<PsOrders> listPsOrdersState(int currentState) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsOrders c WHERE c.currentState =:currentState ");
        query.setParameter("currentState ", currentState);
        return query.getResultList();
    }

    public List<PsOrders> listPsOrdersState(List<Integer> listCurrentState) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsOrders c WHERE c.currentState IN :currentState");
        query.setParameter("currentState", listCurrentState);
        return query.getResultList();
    }

    public List<PsProductCarrier> listPsProductCarrier(Integer idProduct) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsProductCarrier c WHERE c.psProductCarrierPK.idProduct =:idProduct ");
        query.setParameter("idProduct", idProduct);
        return query.getResultList();
    }

    public List<PsCarrier> listCarrier(boolean active) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsCarrier c WHERE c.active =:active");
        query.setParameter("active", active);
        return query.getResultList();
    }

    public List<PsProductCarrier> listPsProductCarrier(Integer idProduct, Integer idCarrierReference) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsProductCarrier c WHERE c.psProductCarrierPK.idProduct =:idProduct AND c.psProductCarrierPK.idCarrierReference =:idCarrierReference");
        query.setParameter("idProduct", idProduct);
        query.setParameter("idCarrierReference", idCarrierReference);
        return query.getResultList();
    }

    public List<PsOrders> listPsOrders(int currentState, int currentState2, Date dataInicial, Date dataFinal) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsOrders c WHERE c.currentState =:currentState OR c.currentState =:currentState2 AND c.dateAdd BETWEEN :dataInicial AND :dataFinal");
        query.setParameter("currentState", currentState);
        query.setParameter("currentState2", currentState2);
        query.setParameter("dataInicial", dataInicial);
        query.setParameter("dataFinal", dataFinal);
        return query.getResultList();
    }

    public List<PsOrderInvoice> listOsOrderInvoic(Integer idOrder) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsOrderInvoice c WHERE c.idOrder =:idOrder");
        query.setParameter("idOrder", idOrder);
        return query.getResultList();
    }

    public List<PsOrderPayment> listPsOrderPayment(String orderReference) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsOrderPayment c WHERE c.orderReference =:orderReference");
        query.setParameter("orderReference", orderReference);
        return query.getResultList();
    }

    public List<PsCustomPaymentMethodLang> listCustomPagament() {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsCustomPaymentMethodLang c WHERE c.psCustomPaymentMethodLangPK.idLang =:id");
        query.setParameter("id", 2);
        return query.getResultList();
    }

    public List<PsOrders> listPsOrders(List<Integer> listCurrentState, Date dataInicial, Date dataFinal) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsOrders c WHERE c.currentState IN :currentState AND c.dateAdd BETWEEN :dataInicial AND :dataFinal");
        query.setParameter("currentState", listCurrentState);
       // query.setParameter("currentState2", currentState2);
        //  query.setParameter("currentState3", currentState3);
        query.setParameter("dataInicial", dataInicial);
        query.setParameter("dataFinal", dataFinal);
        return query.getResultList();
    }

    public List<PsOrders> listPsOrders(String reference) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsOrders c WHERE c.reference =:reference");
        query.setParameter("reference", reference);
        return query.getResultList();
    }

    public List<PsProduct> lisProdutoCachIsPack(boolean cacheIsPack) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsProduct c WHERE c.cacheIsPack =:cacheIsPack");
        query.setParameter("cacheIsPack", cacheIsPack);
        return query.getResultList();
    }

    public List<PsProduct> listPsProduct(String reference) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsProduct c WHERE c.reference =:reference");
        query.setParameter("reference", reference);
        return query.getResultList();
    }
    
    public List<PsOrderDetail> listOrderDetail(Integer idOrder) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsOrderDetail c WHERE c.idOrder =:idOrder");
        query.setParameter("idOrder", idOrder);
        return query.getResultList();
    }

    public List<PsMessage> listPsMessage(Integer idOrder) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsMessage c WHERE c.idOrder =:idOrder");
        query.setParameter("idOrder", idOrder);
        return query.getResultList();
    }

    /**
     * FunÁ„o especifica para produtos relacionados
     *
     * @param nameLike + "%"
     * @return
     */
    public List<PsProductLang> listPsProductLang(String nameLike) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsProductLang c WHERE c.name like :nameLike");
        query.setParameter("nameLike", nameLike + "%");
        return query.getResultList();
    }

    public List<PsSpecificPrice> listPsSpecificPrice(Integer idProduct, String reducionTipe, int idGroup) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsSpecificPrice c WHERE c.idProduct =:idProduct AND c.reductionType =:reducionTipe AND c.idGroup =:idGroup");
        query.setParameter("idProduct", idProduct);
        query.setParameter("reducionTipe", reducionTipe);
        query.setParameter("idGroup", idGroup);
        return query.getResultList();
    }

    public List<PsSpecificPrice> listPsSpecificPrice(Integer idProduct, int idGroup) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsSpecificPrice c WHERE c.idProduct =:idProduct AND c.idGroup =:idGroup ORDER BY c.fromQuantity ASC");
        query.setParameter("idProduct", idProduct);
        //query.setParameter("reducionTipe", reducionTipe);
        query.setParameter("idGroup", idGroup);
        return query.getResultList();
    }

    public Iterable<PsOrderStateLang> listPsOrderStateLang(int idLang) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsOrderStateLang c WHERE c.psOrderStateLangPK.idLang = :idLang ORDER BY c.psOrderStateLangPK.idOrderState");
        query.setParameter("idLang", idLang);
        return query.getResultList();
    }

    public Iterable<PsPack> listPackItem(Integer idProductItem) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM PsPack c WHERE c.psPackPK.idProductItem =:idProductItem");
        query.setParameter("idProductItem", idProductItem);
        return query.getResultList();
    }

}
