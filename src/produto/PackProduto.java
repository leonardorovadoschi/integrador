/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package produto;

import entidade.cplus.Campocustomvalor;
import entidade.cplus.Produto;
import entidade.cplus.Produtocodigo;
import entidade.cplus.Produtoestoque;
import entidade.cplus.Produtopreco;
import entidade.cplus.Unidade;
import entidade.integrador.IntLogs;
import entidade.prestaShop.PsCategoryProduct;
import entidade.prestaShop.PsCategoryProductPK;
import entidade.prestaShop.PsGroup;
import entidade.prestaShop.PsManufacturer;
import entidade.prestaShop.PsManufacturerLang;
import entidade.prestaShop.PsManufacturerLangPK;
import entidade.prestaShop.PsManufacturerShop;
import entidade.prestaShop.PsManufacturerShopPK;
import entidade.prestaShop.PsPack;
import entidade.prestaShop.PsPackPK;
import entidade.prestaShop.PsProduct;
import entidade.prestaShop.PsProductLang;
import entidade.prestaShop.PsProductLangPK;
import entidade.prestaShop.PsProductShop;
import entidade.prestaShop.PsProductShopPK;
import entidade.prestaShop.PsProductTag;
import entidade.prestaShop.PsProductTagPK;
import entidade.prestaShop.PsSpecificPrice;
import entidade.prestaShop.PsStockAvailable;
import entidade.prestaShop.PsTag;
import entidade.prestaShop.PsTagCount;
import entidade.prestaShop.PsTagCountPK;
import entidade.prestaShop.PsTaxRulesGroup;
import janela.cplus.FormataCampos;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import jpa.integrador.IntLogsJpaController;
import jpa.prestaShop.PsCategoryProductJpaController;
import jpa.prestaShop.PsGroupJpaController;
import jpa.prestaShop.PsManufacturerJpaController;
import jpa.prestaShop.PsManufacturerLangJpaController;
import jpa.prestaShop.PsManufacturerShopJpaController;
import jpa.prestaShop.PsPackJpaController;
import jpa.prestaShop.PsProductJpaController;
import jpa.prestaShop.PsProductLangJpaController;
import jpa.prestaShop.PsProductShopJpaController;
import jpa.prestaShop.PsProductTagJpaController;
import jpa.prestaShop.PsSpecificPriceJpaController;
import jpa.prestaShop.PsStockAvailableJpaController;
import jpa.prestaShop.PsTagCountJpaController;
import jpa.prestaShop.PsTagJpaController;
import jpa.prestaShop.exceptions.NonexistentEntityException;
import query.cplus.QueryCplus;
import query.prestaShop.QueryPrestaShop;

/**
 *
 * @author leo
 */
public class PackProduto {

    /**
     * Função encarregada de verificar se o produto será criado ou atualizado
     *
     * @param managerIntegrador
     * @param managerCplus
     * @param managerPrestaShop
     * @param proCplus
     * @return
     */
    public boolean produtoCplusDigimacro(EntityManagerFactory managerIntegrador, EntityManagerFactory managerCplus, EntityManagerFactory managerPrestaShop, Produto proCplus) {
        boolean condicao = true;
        List<PsProduct> listProdSite = new QueryPrestaShop(managerPrestaShop).listagemProdutoSite(proCplus.getCodprod() + "10");
        // List<PsProduct> listProdSite = new QueryPrestaShop(managerPrestaShop).listagemProdutoSite("000001942");
        switch (listProdSite.size()) {
            case 0:
                criarProdutoDigimacro(managerIntegrador, managerCplus, managerPrestaShop, proCplus);
                break;
            case 1:
                for (PsProduct pp : listProdSite) {
                    editaProdutoDigimacro(managerCplus, managerIntegrador, managerPrestaShop, proCplus, pp);
                }
                break;
            default:
                String log = "A pesquisa achou mais que um produto no site com a mesma referencia \n VERIFIQUE \n";
                for (PsProduct pp : listProdSite) {
                    log = log + pp.getReference() + "\n";
                }
                criaLog(managerIntegrador, log, "ERRO PRODUTO");
                break;
        }
        return condicao;
    }

    /**
     * Função que cria um produto no prestaShop
     *
     * @param managerIntegrador
     * @param managerCplus
     * @param managerPrestaShop
     * @param proCplus
     * @return
     */
    private boolean criarProdutoDigimacro(EntityManagerFactory managerIntegrador, EntityManagerFactory managerCplus, EntityManagerFactory managerPrestaShop, Produto proCplus) {
        boolean condicao = true;
        PsProduct pp1 = new PsProduct();
        pp1.setIdSupplier(0);
        pp1.setIdManufacturer(marcaFabricante(managerPrestaShop, managerIntegrador, proCplus));
        pp1.setIdCategoryDefault(categoriaPadrao(managerPrestaShop, proCplus));
        pp1.setIdShopDefault(1);
        pp1.setIdTaxRulesGroup(taxRulesGroup(managerPrestaShop, proCplus));
        pp1.setOnSale(false);
        pp1.setOnlineOnly(false);
        pp1.setEan13(eanCplus(managerCplus, proCplus));
        pp1.setIsbn("");
        pp1.setUpc("");
        pp1.setEcotax(BigDecimal.ZERO);
        pp1.setQuantity(0);
        pp1.setMinimalQuantity(1);
        pp1.setLowStockThreshold(null);
        pp1.setLowStockAlert(false);
        pp1.setPrice(precoPrincipal(managerCplus, proCplus));
        pp1.setWholesalePrice(BigDecimal.ZERO);
        pp1.setUnity("");
        pp1.setUnitPriceRatio(BigDecimal.ZERO);
        pp1.setAdditionalShippingCost(BigDecimal.ZERO);
        pp1.setReference(proCplus.getCodprod() + "10"); //ligaÃ§Ã£o c-plus
        pp1.setSupplierReference("");
        pp1.setLocation("");
        pp1.setWidth(proCplus.getLargura());
        pp1.setHeight(proCplus.getAltura());
        pp1.setDepth(proCplus.getComprimento());
        pp1.setWeight(proCplus.getPesobruto());
        pp1.setOutOfStock(2);
        pp1.setAdditionalDeliveryTimes(true);
        pp1.setQuantityDiscount(false);
        pp1.setCustomizable((short) 0);
        pp1.setUploadableFiles((short) 0);
        pp1.setTextFields((short) 0);
        if (produtoAtivo(proCplus) && quantidadeEstoque(managerCplus, proCplus) > 0) {
            pp1.setActive(true);
            pp1.setIndexed(true);
        } else {
            pp1.setActive(false);
            pp1.setIndexed(false);
        }
        pp1.setRedirectType("301-category");
        pp1.setIdTypeRedirected(0);
        pp1.setAvailableForOrder(true);
        pp1.setAvailableDate(null);
        pp1.setShowCondition(true);
        pp1.setCondition1("new");
        pp1.setShowPrice(true);
        // if ("116".equals(proCplus.getCodsec().getClassificacao())) {
        pp1.setIndexed(true);
        //   pp1.setVisibility("none");
        // } else {
        // pp1.setIndexed(true);
        pp1.setVisibility("both");
        //  }
        pp1.setCacheIsPack(true);//pacote
        pp1.setCacheHasAttachments(false);
        pp1.setIsVirtual(false);
        pp1.setCacheDefaultAttribute(0);
        pp1.setDateAdd(new Date(System.currentTimeMillis()));
        pp1.setDateUpd(new Date(System.currentTimeMillis()));
        pp1.setAdvancedStockManagement(false);
        pp1.setPackStockType(3);
        pp1.setState(1);

        new PsProductJpaController(managerPrestaShop).create(pp1);

        List<PsProduct> listProdSite = new QueryPrestaShop(managerPrestaShop).listagemProdutoSite(proCplus.getCodprod() + "10");
        for (PsProduct pp : listProdSite) {
            String nomeProduto = proCplus.getNomeprodweb() + " " + fatorConversaoInteger(proCplus, managerCplus) + " UN";
            PsProductLang ppl = new PsProductLang();
            ppl.setPsProductLangPK(new PsProductLangPK(pp.getIdProduct(), 1, 2));
            ppl.setDescription(observacao(proCplus, managerCplus));
            ppl.setDescriptionShort(proCplus.getAplicacao());
            ppl.setLinkRewrite(linkRewrite(nomeProduto));
            ppl.setMetaDescription(metaDescription(proCplus));
            ppl.setMetaKeywords("");
            ppl.setMetaTitle(nomeProduto.toLowerCase());
            ppl.setName(nomeProduto);
            ppl.setAvailableNow("Disponível");
            ppl.setAvailableLater("Sem Estoque");
            ppl.setDeliveryInStock("Entrega Imediata");
            ppl.setDeliveryOutStock("Sem Previsão");

            try {
                new PsProductLangJpaController(managerPrestaShop).create(ppl);

                PsProductShop pps = new PsProductShop();
                pps.setPsProductShopPK(new PsProductShopPK(pp.getIdProduct(), 1));
                pps.setIdCategoryDefault(categoriaPadrao(managerPrestaShop, proCplus));
                pps.setIdTaxRulesGroup(taxRulesGroup(managerPrestaShop, proCplus));
                pps.setOnSale(false);
                pps.setOnlineOnly(false);
                pps.setEcotax(BigDecimal.ZERO);
                pps.setMinimalQuantity(1);
                pps.setLowStockThreshold(null);
                pps.setLowStockAlert(false);
                pps.setPrice(precoPrincipal(managerCplus, proCplus));
                pps.setWholesalePrice(BigDecimal.ZERO);
                pps.setUnity("");
                pps.setUnitPriceRatio(BigDecimal.ZERO);
                pps.setAdditionalShippingCost(BigDecimal.ZERO);
                pps.setCustomizable((short) 0);
                pps.setUploadableFiles((short) 0);
                pps.setTextFields((short) 0);

                if (produtoAtivo(proCplus) && quantidadeEstoque(managerCplus, proCplus) > 0) {
                    pps.setActive(true);
                    pps.setIndexed(true);
                } else {
                    pps.setActive(false);
                    pps.setIndexed(false);
                }

                pps.setRedirectType("301-category");
                pps.setIdTypeRedirected(0);
                pps.setAvailableForOrder(true);
                pps.setAvailableDate(null);
                pps.setShowCondition(false);
                pps.setCondition("new");
                pps.setShowPrice(true);
                // if ("116".equals(proCplus.getCodsec().getClassificacao())) {
                pps.setIndexed(true);
                //    pps.setVisibility("none");
                //   } else {
                // pps.setIndexed(pps.getActive());
                pps.setVisibility("both");
                //  }
                pps.setIndexed(pps.getActive());
                pps.setVisibility("both");
                pps.setCacheDefaultAttribute(0);
                pps.setAdvancedStockManagement(false);
                pps.setDateAdd(new Date(System.currentTimeMillis()));
                pps.setDateUpd(new Date(System.currentTimeMillis()));
                pps.setPackStockType(3);
                new PsProductShopJpaController(managerPrestaShop).create(pps);

                PsStockAvailable psSA = new PsStockAvailable();
                psSA.setIdProduct(pp.getIdProduct());
                psSA.setIdProductAttribute(0);
                psSA.setIdShop(1);
                psSA.setIdShopGroup(0);
                psSA.setQuantity(quantidadeEstoque(managerCplus, managerPrestaShop, proCplus, pp));
                psSA.setPhysicalQuantity(quantidadeEstoque(managerCplus, managerPrestaShop, proCplus, pp));
                psSA.setReservedQuantity(0);
                psSA.setDependsOnStock(false);
                psSA.setOutOfStock(false);
                psSA.setLocation("");
                new PsStockAvailableJpaController(managerPrestaShop).create(psSA);

                //PsSpecificPrice psSP = new PsSpecificPrice();
                precoQuntidade(pp, managerPrestaShop, managerIntegrador);
                categoriaProduto(false, pp, proCplus, managerPrestaShop, managerIntegrador);
                gerenciaTags(managerPrestaShop, managerIntegrador, proCplus, pp);
                criarProdutoPack(pp, proCplus, managerPrestaShop, managerIntegrador, managerCplus);

            } catch (Exception ex) {
                criaLog(managerIntegrador, "Houve um erro ao criar PsProductLang ex. " + ex, "ERRO CRIAR");
            }
        }
        return condicao;
    }

    private String linkRewrite(String valor) {
        valor = valor.trim();
        valor = valor.replaceAll("[^a-zA-Z0-9]", " ");//remover todos caracteres especiais       
        valor = valor.replace(" ", "-").toLowerCase();
        valor = valor.replaceAll("\\--", "-");
        valor = valor.replaceAll("\\---", "-");
        return valor;
    }

    public void atualizarPackProdutoCriado(EntityManagerFactory managerIntegrador, EntityManagerFactory managerPrestaShop, PsProduct pp) {
        for (PsPack pak : new QueryPrestaShop(managerPrestaShop).listPackItem(pp.getIdProduct())) {
            BigDecimal preco = BigDecimal.ZERO;
            Integer qunti = 100;
            for (PsPack pak2 : new QueryPrestaShop(managerPrestaShop).listPack(pak.getPsPackPK().getIdProductPack())) {
                PsProduct pr = new PsProductJpaController(managerPrestaShop).findPsProduct(pak2.getPsPackPK().getIdProductItem());
                preco = preco.add(pr.getPrice().multiply(new BigDecimal(pak2.getQuantity())));
                List<PsStockAvailable> listPSSA = new QueryPrestaShop(managerPrestaShop).listPsStockAvailable(pr.getIdProduct(), 1);
                for (PsStockAvailable psSA : listPSSA) {
                    if (psSA.getQuantity() < qunti) {
                        qunti = psSA.getQuantity();
                    }
                }
            }
            PsProduct psP = new PsProductJpaController(managerPrestaShop).findPsProduct(pak.getPsPackPK().getIdProductPack());
            psP.setPrice(preco);
            psP.setOutOfStock(2);
            if (qunti > 0) {
                psP.setActive(true);
                psP.setIndexed(true);
            } else {
                psP.setActive(false);
                psP.setIndexed(false);
            }
            try {
                new PsProductJpaController(managerPrestaShop).edit(psP);

                List<PsProductShop> listPPS = new QueryPrestaShop(managerPrestaShop).listPsProductShop(psP.getIdProduct(), 1);
                for (PsProductShop pps : listPPS) {
                    pps.setPrice(preco);
                    if (qunti > 0) {
                        pps.setActive(true);
                        pps.setIndexed(true);
                    } else {
                        pps.setActive(false);
                        pps.setIndexed(false);
                    }
                    new PsProductShopJpaController(managerPrestaShop).edit(pps);
                }

                List<PsStockAvailable> listPSSA = new QueryPrestaShop(managerPrestaShop).listPsStockAvailable(psP.getIdProduct(), 1);
                for (PsStockAvailable psSA : listPSSA) {
                    psSA.setQuantity(qunti);
                    new PsStockAvailableJpaController(managerPrestaShop).edit(psSA);
                }

            } catch (Exception ex) {
               criaLog(managerIntegrador, "Houve um erro ao atualizar ProdutoPack ex. " + ex, "ERRO EDITAR ");
            }

        }
    }

    /**
     * Função para editar produto no site
     *
     * @param managerIntegrador
     * @param managerPrestaShop
     * @param proCplus
     * @param pp produto prestaShop
     */
    private void editaProdutoDigimacro(EntityManagerFactory managerCplus, EntityManagerFactory managerIntegrador, EntityManagerFactory managerPrestaShop, Produto proCplus, PsProduct pp) {
        //PsProduct pp = new PsProduct();
        // pp.setIdSupplier(0);
        pp.setIdManufacturer(marcaFabricante(managerPrestaShop, managerIntegrador, proCplus));
        pp.setIdCategoryDefault(categoriaPadrao(managerPrestaShop, proCplus));
        // pp.setIdShopDefault(1);
        pp.setIdTaxRulesGroup(taxRulesGroup(managerPrestaShop, proCplus));
        // pp.setOnSale(false);
        // pp.setOnlineOnly(false);
        pp.setEan13(eanCplus(managerCplus, proCplus));
        //pp.setIsbn("");
        // pp.setUpc("");
        // pp.setEcotax(BigDecimal.ZERO);
        //pp.setQuantity(0);
        // pp.setMinimalQuantity(1);
        // pp.setLowStockThreshold(null);
        // pp.setLowStockAlert(false);
        pp.setPrice(precoPrincipal(managerCplus, proCplus));
        //pp.setWholesalePrice(BigDecimal.ZERO);
        //pp.setUnity("");
        //pp.setUnitPriceRatio(BigDecimal.ZERO);
        //pp.setAdditionalShippingCost(BigDecimal.ZERO);
        pp.setReference(proCplus.getCodprod() + "10"); //ligaÃ§Ã£o c-plus
        //pp.setSupplierReference("");
        //pp.setLocation("");
        pp.setWidth(proCplus.getLargura());
        pp.setHeight(proCplus.getAltura());
        pp.setDepth(proCplus.getComprimento());
        pp.setWeight(proCplus.getPesobruto());
        pp.setOutOfStock(2);
        //pp.setAdditionalDeliveryTimes(true);
        //pp.setQuantityDiscount(false);
        // pp.setCustomizable((short) 0);
        // pp.setUploadableFiles((short) 0);
        // pp.setTextFields((short) 0);
        if (produtoAtivo(proCplus) && quantidadeEstoque(managerCplus, managerPrestaShop, proCplus, pp) > 0) {
            pp.setActive(true);
            pp.setIndexed(true);
        } else {
            pp.setActive(false);
            pp.setIndexed(false);
        }
        //pp.setRedirectType("301-category");
        //pp.setIdTypeRedirected(0);
        //pp.setAvailableForOrder(true);
        pp.setAvailableDate(new Date(System.currentTimeMillis()));
        pp.setShowCondition(false);
        pp.setCondition1("new");
        pp.setShowPrice(true);
        //  if ("116".equals(proCplus.getCodsec().getClassificacao())) {
        //pp.setIndexed(false);
        ///     pp.setVisibility("none");
        //   } else {
        // pp.setIndexed(true);
        pp.setVisibility("both");
        //     }
        pp.setCacheIsPack(true);
        //pp.setCacheHasAttachments(false);
        //pp.setIsVirtual(false);
        // pp.setCacheDefaultAttribute(0);
        // pp.setDateAdd(new Date(System.currentTimeMillis()));
        pp.setDateUpd(new Date(System.currentTimeMillis()));
        //pp.setAdvancedStockManagement(false);
        //pp.setPackStockType(3);
        //pp.setState(1);
        try {
            new PsProductJpaController(managerPrestaShop).edit(pp);

            //PsProductLang ppl = new PsProductLang();
            List<PsProductLang> listPPL = new QueryPrestaShop(managerPrestaShop).listPsProductLang(pp.getIdProduct(), 2);
            for (PsProductLang ppl : listPPL) {
                //ppl.setPsProductLangPK(new PsProductLangPK(pp.getIdProduct(), 1, 2));
                String nomeProduto = proCplus.getNomeprodweb() + " " + fatorConversaoInteger(proCplus, managerCplus) + " UN";
                ppl.setDescription(observacao(proCplus, managerCplus));
                ppl.setDescriptionShort(proCplus.getAplicacao());
                ppl.setLinkRewrite(linkRewrite(nomeProduto));
                ppl.setMetaDescription(metaDescription(proCplus));
                ppl.setMetaKeywords("");
                ppl.setMetaTitle(nomeProduto.toLowerCase());
                ppl.setName(nomeProduto);
                ppl.setAvailableNow("Disponível");
                ppl.setAvailableLater("Sem Estoque");
                ppl.setDeliveryInStock("Entrega Imediata");
                ppl.setDeliveryOutStock("Sem Previsão");
                new PsProductLangJpaController(managerPrestaShop).edit(ppl);
            }
            //PsProductShop pps = new PsProductShop();
            List<PsProductShop> listPPS = new QueryPrestaShop(managerPrestaShop).listPsProductShop(pp.getIdProduct(), 1);
            for (PsProductShop pps : listPPS) {
                //pps.setPsProductShopPK(new PsProductShopPK(pp.getIdProduct(), 1));
                pps.setIdCategoryDefault(categoriaPadrao(managerPrestaShop, proCplus));
                pps.setIdTaxRulesGroup(taxRulesGroup(managerPrestaShop, proCplus));
                // pps.setOnSale(false);
                // pps.setOnlineOnly(false);
                // pps.setEcotax(BigDecimal.ZERO);
                // pps.setMinimalQuantity(1);
                // pps.setLowStockThreshold(0);
                // pps.setLowStockAlert(false);
                pps.setPrice(precoPrincipal(managerCplus, proCplus));
                // pps.setWholesalePrice(BigDecimal.ZERO);
                // pps.setUnity("");
                // pps.setUnitPriceRatio(BigDecimal.ZERO);
                // pps.setAdditionalShippingCost(BigDecimal.ZERO);
                // pps.setCustomizable((short) 0);
                // pps.setUploadableFiles((short) 0);
                // pps.setTextFields((short) 0);
                if (produtoAtivo(proCplus) && quantidadeEstoque(managerCplus, managerPrestaShop, proCplus, pp) > 0) {
                    pps.setActive(true);
                    pps.setIndexed(true);
                } else {
                    pps.setActive(false);
                    pps.setIndexed(false);
                }
                // pps.setRedirectType("301-category");
                // pps.setIdTypeRedirected(0);
                // pps.setAvailableForOrder(true);
                // pps.setAvailableDate(null);
                // pps.setShowCondition(false);
                // pps.setCondition("new");
                // pps.setShowPrice(true);
                //  if ("116".equals(proCplus.getCodsec().getClassificacao())) {
                ///    pps.setIndexed(false);
                //    pps.setVisibility("none");
                // } else {
                //pps.setIndexed(pps.getActive());
                pps.setVisibility("both");
                //  }
                pps.setCacheDefaultAttribute(0);
                pps.setAdvancedStockManagement(false);
                //pps.setDateAdd(new Date(System.currentTimeMillis()));
                pps.setDateUpd(new Date(System.currentTimeMillis()));
                //pps.setPackStockType(3);
                new PsProductShopJpaController(managerPrestaShop).edit(pps);
            }
            //PsStockAvailable psSA = new PsStockAvailable();
            List<PsStockAvailable> listPSSA = new QueryPrestaShop(managerPrestaShop).listPsStockAvailable(pp.getIdProduct(), 1);
            for (PsStockAvailable psSA : listPSSA) {
                psSA.setIdProduct(pp.getIdProduct());
                psSA.setIdProductAttribute(0);
                psSA.setIdShop(1);
                psSA.setIdShopGroup(0);
                psSA.setQuantity(quantidadeEstoque(managerCplus, managerPrestaShop, proCplus, pp));
                // psSA.setPhysicalQuantity(editaQuantidadeEstoque(managerCplus, managerPrestaShop, proCplus, pp));
                psSA.setReservedQuantity(0);
                psSA.setDependsOnStock(false);
                psSA.setOutOfStock(false);
                new PsStockAvailableJpaController(managerPrestaShop).edit(psSA);
            }
            //PsSpecificPrice psSP = new PsSpecificPrice();
            precoQuntidade(pp, managerPrestaShop, managerIntegrador);
            categoriaProduto(false, pp, proCplus, managerPrestaShop, managerIntegrador);
            gerenciaTags(managerPrestaShop, managerIntegrador, proCplus, pp);
            criarProdutoPack(pp, proCplus, managerPrestaShop, managerIntegrador, managerCplus);
        } catch (Exception ex) {
            criaLog(managerIntegrador, "Houve um erro ao criar PsProductLang ex. " + ex, "ERRO CRIAR");
        }
    }

    /**
     * Função que relaciona o calculo do icms do Cplus para o site
     *
     * @param managerPrestaShop
     * @param pro
     * @return
     */
    private int taxRulesGroup(EntityManagerFactory managerPrestaShop, Produto pro) {
        int var = 0;
        List<PsTaxRulesGroup> listT = new QueryPrestaShop(managerPrestaShop).listPorNomeCalculoIcms(pro.getCodcalculoicms().getNomecalculoicms());
        for (PsTaxRulesGroup cl : listT) {
            var = cl.getIdTaxRulesGroup();
        }
        return var;
    }

    /**
     * Função para gravar Logs no banco do integrador
     *
     * @param managerIntegracao
     * @param mensagem
     * @param tipoLog
     */
    private void criaLog(EntityManagerFactory managerIntegracao, String mensagem, String tipoLog) {
        IntLogs log = new IntLogs();
        log.setDataExecucao(new Date(System.currentTimeMillis()));
        log.setMensagem(mensagem);
        log.setTipoLog(tipoLog);
        new IntLogsJpaController(managerIntegracao).create(log);
    }

    /**
     * Função para retornar uma String EAN
     *
     * @param managerCplus
     * @param proCplus
     * @return
     */
    private String eanCplus(EntityManagerFactory managerCplus, Produto proCplus) {
        String tex = "";
        List<Produtocodigo> listPrdCod = new QueryCplus(managerCplus).resultEanProduto(proCplus.getCodprod());
        for (Produtocodigo pc : listPrdCod) {
            tex = pc.getCodigo();
        }
        return tex;
    }

    private Integer categoriaPadrao(EntityManagerFactory managerPrestaShop, Produto proCplus) {
        int catId = 2;
        return catId;
    }

    private BigDecimal precoPrincipal(EntityManagerFactory managerCplus, Produto proCplus) {
        BigDecimal preco = BigDecimal.ZERO;
        List<Produtopreco> listPreco = new QueryCplus(managerCplus).listPrecos(proCplus.getCodprod(), "000000001");
        for (Produtopreco pr : listPreco) {
            preco = pr.getPreco().multiply(fatorConversaoBigDecimal(proCplus, managerCplus));
        }
        // preco = preco.multiply(fatorConversaoBigDecimal(proCplus, managerCplus));
        preco = preco.multiply(new BigDecimal("1.11"));
        return preco;
    }

    private boolean produtoAtivo(Produto proCplus) {
        boolean condicao = false;
        if ("N".equals(proCplus.getFlaginativo().toString())) {
            condicao = true;
        }
        return condicao;
    }

    /**
     * palavra.toLowerCase(); // coloca em minusculo
     * palavra.toUpperCase();//coloca em maiusculo
     *
     * @param proCplus
     * @return
     */
    private String metaDescription(Produto proCplus) {
        String text = proCplus.getAplicacao().toLowerCase();
        text = text.replace("<p>", "");
        text = text.replace("<span", "");
        text = text.replace("style=\"", "");
        text = text.replace("font-size:", "");
        text = text.replace(";font-family:", "");
        text = text.replace("Arial;", "");
        text = text.replace("<p></p>", "");
        text = text.replace("</p>", "");

        return text;

    }

    private Integer quantidadeEstoque(EntityManagerFactory managerCplus, Produto proCplus) {
        BigDecimal estoque = BigDecimal.ZERO;
        int stock;
        List<Produtoestoque> listEsroque = new QueryCplus(managerCplus).listTodosEstoques(proCplus.getCodprod());
        for (Produtoestoque est : listEsroque) {
            estoque = est.getEstatu().subtract(est.getReservadoorcamento().subtract(est.getReservadoos()));
        }
        stock = estoque.intValue() / fatorConversaoInteger(proCplus, managerCplus);

        return stock;
    }

    /**
     * Função que verifica as reservas dos pedidos no c-plus e no site
     *
     * @param verificaLegiao
     * @param produto
     * @return BigDecimal
     */
    private Integer quantidadeEstoque(EntityManagerFactory managerCplus, EntityManagerFactory managerPrestaShop, Produto proCplus, PsProduct prodPrestaShop) {
        BigDecimal estoque = BigDecimal.ZERO;
        int stock;
        int reservaSite = 0;
        List<PsStockAvailable> listPSA = new QueryPrestaShop(managerPrestaShop).listEstoqueProduto(prodPrestaShop.getIdProduct());
        for (PsStockAvailable psSA : listPSA) {
            reservaSite = psSA.getReservedQuantity();
        }
        List<Produtoestoque> listEsroque = new QueryCplus(managerCplus).listTodosEstoques(proCplus.getCodprod());
        for (Produtoestoque est : listEsroque) {
            estoque = est.getEstatu().subtract(est.getReservadoorcamento().subtract(est.getReservadoos()));
        }
        stock = (estoque.intValue() - reservaSite) / fatorConversaoInteger(proCplus, managerCplus);
        return stock;
    }

    private void precoQuntidade(PsProduct pp, EntityManagerFactory managerPrestaShop, EntityManagerFactory managerIntegrador) {
        List<BigDecimal> listBigDecimal = new ArrayList<>();
        listBigDecimal.add(new BigDecimal("0.5"));
        listBigDecimal.add(new BigDecimal("1.0"));
        listBigDecimal.add(new BigDecimal("2.0"));
        listBigDecimal.add(new BigDecimal("3.0"));
        for (BigDecimal bd : listBigDecimal) {
            //PsSpecificPrice psSP = new PsSpecificPrice();
            List<PsSpecificPrice> listPSSP = new QueryPrestaShop(managerPrestaShop).listPsSpecificPrice(pp.getIdProduct(), bd.divide(new BigDecimal("100.0"), 3, BigDecimal.ROUND_HALF_UP), 4);
            /*
            if (listPSSP.isEmpty()) {
                PsSpecificPrice psSP = new PsSpecificPrice();
                psSP.setIdSpecificPriceRule(0);
                psSP.setIdCart(0);
                psSP.setIdProduct(pp.getIdProduct());
                psSP.setIdShop(1);
                psSP.setIdShopGroup(0);
                psSP.setIdCurrency(1);
                psSP.setIdCountry(58);
                psSP.setIdGroup(4);
                psSP.setIdCustomer(0);
                psSP.setIdProductAttribute(0);
                psSP.setPrice(new BigDecimal("-1.0"));
                psSP.setFromQuantity(defineQuantidadePreco(pp, bd));
                psSP.setReduction(bd.divide(new BigDecimal("100.0")));
                psSP.setReductionTax(true);
                psSP.setReductionType("percentage");
                psSP.setFrom(new Date(System.currentTimeMillis()));
                psSP.setTo(new FormataCampos().alteraDiaData(new Date(System.currentTimeMillis()), 360));
                new PsSpecificPriceJpaController(managerPrestaShop).create(psSP);
            } else if (listPSSP.size() == 1) {
                for (PsSpecificPrice psSP : listPSSP) {
                    //psSP.setIdSpecificPriceRule(0);
                    // psSP.setIdCart(0);
                    //psSP.setIdProduct(pp.getIdProduct());
                    // psSP.setIdShop(1);
                    // psSP.setIdShopGroup(0);
                    // psSP.setIdCurrency(1);
                    // psSP.setIdCountry(58);
                    // psSP.setIdGroup(4);
                    // psSP.setIdCustomer(0);
                    // psSP.setIdProductAttribute(0);
                    psSP.setPrice(new BigDecimal("-1.0"));
                    psSP.setFromQuantity(defineQuantidadePreco(pp, bd));
                    //psSP.setReduction(bd.divide(new BigDecimal("100.0")));
                    //psSP.setReductionTax(true);
                    //psSP.setReductionType("percentage");
                    //psSP.setFrom(new );
                    psSP.setTo(new FormataCampos().alteraDiaData(new Date(System.currentTimeMillis()), 360));
                    try {
                        new PsSpecificPriceJpaController(managerPrestaShop).edit(psSP);
                    } catch (Exception ex) {
                        criaLog(managerIntegrador, "Houve um erro ao criar PsSpecificPrice ex. " + ex, "ERRO EDITAR");
                    }
                }
            } else {
                for (PsSpecificPrice psSP : listPSSP) {
                    try {
                        new PsSpecificPriceJpaController(managerPrestaShop).destroy(psSP.getIdSpecificPrice());
                    } catch (NonexistentEntityException ex) {
                        criaLog(managerIntegrador, "Houve um erro ao excluir PsSpecificPrice ex. " + ex, "ERRO EXCLUIR");
                    }
                }
            }
             */

            for (PsSpecificPrice psSP : listPSSP) {
                try {
                    new PsSpecificPriceJpaController(managerPrestaShop).destroy(psSP.getIdSpecificPrice());
                } catch (NonexistentEntityException ex) {
                    criaLog(managerIntegrador, "Houve um erro ao excluir PsSpecificPrice ex. " + ex, "ERRO EXCLUIR");
                }
            }
        }
    }

    private void criarProdutoPack(PsProduct pp, Produto proCplus, EntityManagerFactory managerPrestaShop, EntityManagerFactory managerIntegrador, EntityManagerFactory managerCplus) {
        List<PsProduct> listProdPack = new QueryPrestaShop(managerPrestaShop).listagemProdutoSite(proCplus.getCodprod());//sem o 10 no caso
        for (PsProduct prodPack : listProdPack) {
            List<PsPack> listPP = new QueryPrestaShop(managerPrestaShop).listPack(pp.getIdProduct(), prodPack.getIdProduct());
            if (listPP.isEmpty()) {
                PsPack pPack = new PsPack();
                pPack.setQuantity(fatorConversaoInteger(proCplus, managerCplus));
                pPack.setPsPackPK(new PsPackPK(pp.getIdProduct(), prodPack.getIdProduct(), 0));
                try {
                    new PsPackJpaController(managerPrestaShop).create(pPack);
                } catch (Exception ex) {
                    criaLog(managerIntegrador, "Houve um erro ao criar PsPack ex. " + ex, "ERRO CRIAR");
                }
            } else {
                for (PsPack packBanco : listPP) {
                    packBanco.setQuantity(fatorConversaoInteger(proCplus, managerCplus));
                    try {
                        new PsPackJpaController(managerPrestaShop).edit(packBanco);
                    } catch (Exception ex) {
                        criaLog(managerIntegrador, "Houve um erro ao editar PsPack ex. " + ex, "ERRO EDITAR");
                    }
                }
            }
        }
    }

    private int defineQuantidadePreco(PsProduct pp, BigDecimal bd) {
        int quantidade;
        if (pp.getPrice().doubleValue() < 100.00) {
            if (bd.doubleValue() == 0.5) {
                quantidade = 3;
            } else if (bd.doubleValue() == 1.0) {
                quantidade = 5;
            } else if (bd.doubleValue() == 2.0) {
                quantidade = 10;
            } else {
                quantidade = 20;
            }
        } else if (pp.getPrice().doubleValue() < 50.00) {
            if (bd.doubleValue() == 0.5) {
                quantidade = 5;
            } else if (bd.doubleValue() == 1.0) {
                quantidade = 10;
            } else if (bd.doubleValue() == 2.0) {
                quantidade = 20;
            } else {
                quantidade = 40;
            }
        } else if (pp.getPrice().doubleValue() < 30.00) {
            if (bd.doubleValue() == 0.5) {
                quantidade = 10;
            } else if (bd.doubleValue() == 1.0) {
                quantidade = 20;
            } else if (bd.doubleValue() == 2.0) {
                quantidade = 40;
            } else {
                quantidade = 80;
            }
        } else if (pp.getPrice().doubleValue() < 10.00) {
            if (bd.doubleValue() == 0.5) {
                quantidade = 20;
            } else if (bd.doubleValue() == 1.0) {
                quantidade = 40;
            } else if (bd.doubleValue() == 2.0) {
                quantidade = 80;
            } else {
                quantidade = 160;
            }
        } else {
            if (bd.doubleValue() == 0.5) {
                quantidade = 2;
            } else if (bd.doubleValue() == 1.0) {
                quantidade = 3;
            } else if (bd.doubleValue() == 2.0) {
                quantidade = 5;
            } else {
                quantidade = 10;
            }
        }
        return quantidade;
    }

    //categoria original
    private void categoriaProduto(boolean promocao, PsProduct pp, Produto proCplus, EntityManagerFactory managerPrestaShop, EntityManagerFactory managerIntegrador) {
        String sec;
        if (promocao) {
            sec = proCplus.getCodsec().getClassificacao() + ".143";
        } else {
            sec = proCplus.getCodsec().getClassificacao();
        }
        String[] listSecaoIntegrador = sec.split("\\.");
        List<PsCategoryProduct> listPCP = new QueryPrestaShop(managerPrestaShop).listCategoriaProduto(pp.getIdProduct(), 2);
        if (listPCP.isEmpty()) {
            PsCategoryProduct psCP = new PsCategoryProduct();
            psCP.setPsCategoryProductPK(new PsCategoryProductPK(2, pp.getIdProduct()));//categoria default
            try {
                new PsCategoryProductJpaController(managerPrestaShop).create(psCP);
            } catch (Exception ex) {
                criaLog(managerIntegrador, "Houve um erro ao criar PsCategoryProduct ex. " + ex, "ERRO CRIAR");
            }
        }
        for (String secTemp : listSecaoIntegrador) {
            Integer secaoId = Integer.valueOf(secTemp);
            listPCP = new QueryPrestaShop(managerPrestaShop).listCategoriaProduto(pp.getIdProduct(), secaoId);
            if (listPCP.isEmpty()) {
                PsCategoryProduct psCP = new PsCategoryProduct();
                psCP.setPsCategoryProductPK(new PsCategoryProductPK(secaoId, pp.getIdProduct()));
                try {
                    new PsCategoryProductJpaController(managerPrestaShop).create(psCP);
                } catch (Exception ex) {
                    criaLog(managerIntegrador, "Houve um erro ao criar PsCategoryProduct ex. " + ex, "ERRO CRIAR");
                }
            }

        }
        //verifica categoria trocada
        listPCP = new QueryPrestaShop(managerPrestaShop).listCategoriaProduto(pp.getIdProduct());
        boolean condicao;
        for (PsCategoryProduct psCP : listPCP) {
            condicao = true;
            for (String secTemp : listSecaoIntegrador) {
                Integer secaoId = Integer.valueOf(secTemp);
                if (secaoId == psCP.getPsCategoryProductPK().getIdCategory() || 2 == psCP.getPsCategoryProductPK().getIdCategory()) {
                    condicao = false;
                }
            }
            if (condicao) {
                try {
                    new PsCategoryProductJpaController(managerPrestaShop).destroy(psCP.getPsCategoryProductPK());
                } catch (NonexistentEntityException ex) {
                    criaLog(managerIntegrador, "Houve um erro ao excluir PsCategoryProduct ex. " + ex, "ERRO EXCLUIR");
                }
            }
        }
    }

    private Integer fatorConversaoInteger(Produto prodCplus, EntityManagerFactory managerCplus) {
        Integer quantidade = 1;
        for (Unidade un : new QueryCplus(managerCplus).resultPorUnidadeProduto(prodCplus.getUnidade())) {
            if (un.getFatorconversao().intValue() > 1) {
                quantidade = un.getFatorconversao().intValue();
            }
        }
        return quantidade;
    }

    private BigDecimal fatorConversaoBigDecimal(Produto prodCplus, EntityManagerFactory managerCplus) {
        BigDecimal quantidade = BigDecimal.ONE;
        for (Unidade un : new QueryCplus(managerCplus).resultPorUnidadeProduto(prodCplus.getUnidade())) {
            if (un.getFatorconversao().intValue() > 1) {
                quantidade = un.getFatorconversao();
            }
        }
        return quantidade;
    }

    private void gerenciaTags(EntityManagerFactory managerPrestaShop, EntityManagerFactory managerIntegrador, Produto proCplus, PsProduct pp) {
        String nomeProduto = proCplus.getNomeprodweb().trim().toLowerCase();
        String[] listaDePalavras = nomeProduto.split(" ");
        for (int cont = 0; listaDePalavras.length > cont; cont++) {
            if (listaDePalavras[cont].length() > 1) {
                List<PsTag> listTag = new QueryPrestaShop(managerPrestaShop).resultPorNomeTag(listaDePalavras[cont].trim());
                if (listTag.isEmpty()) {
                    PsTag psT = new PsTag();
                    psT.setIdLang(2);
                    psT.setName(listaDePalavras[cont].trim());
                    new PsTagJpaController(managerPrestaShop).create(psT);
                    listTag = new QueryPrestaShop(managerPrestaShop).resultPorNomeTag(listaDePalavras[cont].trim());
                    for (PsTag pT : listTag) {
                        manipulaProductTag(managerPrestaShop, managerIntegrador, pT, pp);
                        manipulaTagCount(managerPrestaShop, managerIntegrador, pT, pp);
                    }
                }
                for (PsTag pT : listTag) {
                    manipulaProductTag(managerPrestaShop, managerIntegrador, pT, pp);
                    manipulaTagCount(managerPrestaShop, managerIntegrador, pT, pp);

                }
            }
        }
        deletaProductTag(managerPrestaShop, managerIntegrador, pp, listaDePalavras);
    }

    private void deletaProductTag(EntityManagerFactory managerPrestaShop, EntityManagerFactory managerIntegrador, PsProduct pp, String[] listaDePalavras) {
        boolean condicao;
        List<PsProductTag> listPsPT = new QueryPrestaShop(managerPrestaShop).resultPsProductTag(pp.getIdProduct());
        for (PsProductTag psPT : listPsPT) {
            int idTag = 0;
            condicao = true;
            for (int cont = 0; listaDePalavras.length > cont; cont++) {
                List<PsTag> listTag = new QueryPrestaShop(managerPrestaShop).resultPorNomeTag(listaDePalavras[cont].trim());
                for (PsTag pT : listTag) {
                    idTag = pT.getIdTag();
                    if (pT.getIdTag() == psPT.getPsProductTagPK().getIdTag());
                    condicao = false;
                }
            }
            if (condicao) {
                try {
                    new PsProductTagJpaController(managerPrestaShop).destroy(new PsProductTagPK(pp.getIdProduct(), idTag));
                } catch (NonexistentEntityException ex) {
                    criaLog(managerIntegrador, "Houve um erro ao excluir PsProductTag ex. " + ex, "ERRO RXCLUIR");
                }
            }
        }
    }

    private void manipulaTagCount(EntityManagerFactory managerPrestaShop, EntityManagerFactory managerIntegrador, PsTag pT, PsProduct pp) {
        for (PsGroup pG : new PsGroupJpaController(managerPrestaShop).findPsGroupEntities()) {
            List<PsTagCount> listPsTC = new QueryPrestaShop(managerPrestaShop).listTagCount(pT.getIdTag(), pG.getIdGroup());
            if (listPsTC.isEmpty()) {
                PsTagCount psTC = new PsTagCount();
                List<PsProductTag> listPPT = new QueryPrestaShop(managerPrestaShop).resultPsProductTag(pp.getIdProduct());
                psTC.setCounter(listPPT.size());
                psTC.setIdLang(2);
                psTC.setIdShop(1);
                psTC.setPsTagCountPK(new PsTagCountPK(pG.getIdGroup(), pT.getIdTag()));
                try {
                    new PsTagCountJpaController(managerPrestaShop).create(psTC);
                } catch (Exception ex) {
                    criaLog(managerIntegrador, "Houve um erro ao criar PsTagCount ex. " + ex, "ERRO CRIAR");
                }
            }
        }

    }

    private void manipulaProductTag(EntityManagerFactory managerPrestaShop, EntityManagerFactory managerIntegrador, PsTag pT, PsProduct pp) {
        List<PsProductTag> listPsPT = new QueryPrestaShop(managerPrestaShop).listProductTag(pT.getIdTag(), pp.getIdProduct());
        if (listPsPT.isEmpty()) {
            PsProductTag psPT = new PsProductTag();
            psPT.setIdLang(2);
            psPT.setPsProductTagPK(new PsProductTagPK(pp.getIdProduct(), pT.getIdTag()));
            try {
                new PsProductTagJpaController(managerPrestaShop).create(psPT);
            } catch (Exception ex) {
                criaLog(managerIntegrador, "Houve um erro ao criar PsProductTag ex. " + ex, "ERRO CRIAR");
            }
        }
    }

    private Integer marcaFabricante(EntityManagerFactory managerPrestaShop, EntityManagerFactory managerIntegrador, Produto proCplus) {
        Integer idManuf = 1;
        List<PsManufacturer> listPM = new QueryPrestaShop(managerPrestaShop).listManufacturer(proCplus.getCodfabricante().getNomefabricante());
        if (listPM.isEmpty()) {
            PsManufacturer psM = new PsManufacturer();
            psM.setName(proCplus.getCodfabricante().getNomefabricante());
            psM.setDateAdd(new Date(System.currentTimeMillis()));
            psM.setDateUpd(new Date(System.currentTimeMillis()));
            psM.setActive(true);
            new PsManufacturerJpaController(managerPrestaShop).create(psM);
            listPM = new QueryPrestaShop(managerPrestaShop).listManufacturer(proCplus.getCodfabricante().getNomefabricante());
        }
        for (PsManufacturer pM : listPM) {
            idManuf = pM.getIdManufacturer();
            pM.setName(proCplus.getCodfabricante().getNomefabricante());
            try {
                new PsManufacturerJpaController(managerPrestaShop).edit(pM);
                List<PsManufacturerShop> listPMS = new QueryPrestaShop(managerPrestaShop).listManufacturerShop(pM.getIdManufacturer());
                if (listPMS.isEmpty()) {
                    PsManufacturerShop pMS = new PsManufacturerShop();
                    pMS.setPsManufacturerShopPK(new PsManufacturerShopPK(pM.getIdManufacturer(), 1));
                    try {
                        new PsManufacturerShopJpaController(managerPrestaShop).create(pMS);
                    } catch (Exception ex) {
                        criaLog(managerIntegrador, "Houve um erro ao criar PsManufacturerShop ex. " + ex, "ERRO CRIAR");
                    }
                }
                List<PsManufacturerLang> listPML = new QueryPrestaShop(managerPrestaShop).listManufacturerLang(pM.getIdManufacturer(), 2);
                if (listPML.isEmpty()) {
                    PsManufacturerLang pML = new PsManufacturerLang();
                    pML.setPsManufacturerLangPK(new PsManufacturerLangPK(pM.getIdManufacturer(), 2));
                    try {
                        new PsManufacturerLangJpaController(managerPrestaShop).create(pML);
                    } catch (Exception ex) {
                        criaLog(managerIntegrador, "Houve um erro ao criar PsManufacturerLang ex. " + ex, "ERRO CRIAR");
                    }
                }
            } catch (Exception ex) {
                criaLog(managerIntegrador, "Houve um erro ao editar PsManufacturerLang ex. " + ex, "ERRO EDITAR");
            }
        }
        return idManuf;
    }

    private String observacao(Produto proCplus, EntityManagerFactory managerCplus) {
        String ob = "";
        if (proCplus != null) {
            ob = proCplus.getObs() + " <p>Part Number: " + partNumber(proCplus, managerCplus) + "</p> <p>NCM: "
                    + new FormataCampos().mascaraNCM(proCplus.getCodclassificacaofiscal().getCodigoclassificacaofiscal()) + " </p>";
        }
        return ob;
    }

    private String partNumber(Produto proCplus, EntityManagerFactory managerCplus) {
        //part Number 000000004
        //complemento Fiscal 000000003
        String codCampoCustomMaster = "000000004";
        String retorno = "";
        for (Campocustomvalor campo : new QueryCplus(managerCplus).listCampoMaster(proCplus.getCodprod(), codCampoCustomMaster)) {
            if (campo.getValor() != null) {
                retorno = campo.getValor();
            }
        }
        return retorno;
    }
}
