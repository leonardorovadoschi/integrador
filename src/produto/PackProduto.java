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
import java.math.RoundingMode;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
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
import prestashop.Manager;
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
     * @param proCplus
     * @return
     */
    public boolean produtoCplusDigimacro(Produto proCplus) {
        boolean condicao = true;
        List<PsProduct> listProdSite = new QueryPrestaShop().listagemProdutoSite(proCplus.getCodprod() + "10");
        // List<PsProduct> listProdSite = new QueryPrestaShop(managerPrestaShop).listagemProdutoSite("000001942");
        switch (listProdSite.size()) {
            case 0:
                criarProdutoDigimacro(proCplus);
                break;
            case 1:
                for (PsProduct pp : listProdSite) {
                    editaProdutoDigimacro(proCplus, pp);
                }
                break;
            default:
                String log = "A pesquisa achou mais que um produto no site com a mesma referencia \n VERIFIQUE \n";
                for (PsProduct pp : listProdSite) {
                    log = log + pp.getReference() + "\n";
                }
                criaLog(log, "ERRO PRODUTO");
                break;
        }
        return condicao;
    }

    /**
     * Função que cria um produto no prestaShop
     *   
     * @param proCplus
     * @return
     */
    private boolean criarProdutoDigimacro(Produto proCplus) {
        boolean condicao = true;
        PsProduct pp1 = new PsProduct();
        pp1.setIdSupplier(0);
        pp1.setIdManufacturer(marcaFabricante(proCplus));
        pp1.setIdCategoryDefault(categoriaPadrao(proCplus));
        pp1.setIdShopDefault(1);
        pp1.setIdTaxRulesGroup(taxRulesGroup(proCplus));
        pp1.setOnSale(false);
        pp1.setOnlineOnly(false);
        pp1.setEan13(eanCplus(proCplus));
        pp1.setIsbn("");
        pp1.setUpc("");
        pp1.setEcotax(BigDecimal.ZERO);
        pp1.setQuantity(0);
        pp1.setMinimalQuantity(1);
        pp1.setLowStockThreshold(null);
        pp1.setLowStockAlert(false);
        pp1.setPrice(precoPrincipal(proCplus));
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
        if (produtoAtivo(proCplus) && quantidadeEstoque(proCplus) > 0) {
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

        new PsProductJpaController(Manager.getManagerPrestaShop()).create(pp1);

        List<PsProduct> listProdSite = new QueryPrestaShop().listagemProdutoSite(proCplus.getCodprod() + "10");
        for (PsProduct pp : listProdSite) {
            String nomeProduto = proCplus.getNomeprodweb() + " " + fatorConversaoInteger(proCplus) + " UN";
            PsProductLang ppl = new PsProductLang();
            ppl.setPsProductLangPK(new PsProductLangPK(pp.getIdProduct(), 1, 2));
            ppl.setDescription(observacao(proCplus));
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
                new PsProductLangJpaController(Manager.getManagerPrestaShop()).create(ppl);

                PsProductShop pps = new PsProductShop();
                pps.setPsProductShopPK(new PsProductShopPK(pp.getIdProduct(), 1));
                pps.setIdCategoryDefault(categoriaPadrao(proCplus));
                pps.setIdTaxRulesGroup(taxRulesGroup( proCplus));
                pps.setOnSale(false);
                pps.setOnlineOnly(false);
                pps.setEcotax(BigDecimal.ZERO);
                pps.setMinimalQuantity(1);
                pps.setLowStockThreshold(null);
                pps.setLowStockAlert(false);
                pps.setPrice(precoPrincipal(proCplus));
                pps.setWholesalePrice(BigDecimal.ZERO);
                pps.setUnity("");
                pps.setUnitPriceRatio(BigDecimal.ZERO);
                pps.setAdditionalShippingCost(BigDecimal.ZERO);
                pps.setCustomizable((short) 0);
                pps.setUploadableFiles((short) 0);
                pps.setTextFields((short) 0);

                if (produtoAtivo(proCplus) && quantidadeEstoque(proCplus) > 0) {
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
                new PsProductShopJpaController(Manager.getManagerPrestaShop()).create(pps);

                PsStockAvailable psSA = new PsStockAvailable();
                psSA.setIdProduct(pp.getIdProduct());
                psSA.setIdProductAttribute(0);
                psSA.setIdShop(1);
                psSA.setIdShopGroup(0);
                psSA.setQuantity(quantidadeEstoque(proCplus, pp));
                psSA.setPhysicalQuantity(quantidadeEstoque(proCplus, pp));
                psSA.setReservedQuantity(0);
                psSA.setDependsOnStock(false);
                psSA.setOutOfStock(false);
                psSA.setLocation("");
                new PsStockAvailableJpaController(Manager.getManagerPrestaShop()).create(psSA);

                //PsSpecificPrice psSP = new PsSpecificPrice();
                precoQuntidade(pp);
                categoriaProduto(false, pp, proCplus);
                gerenciaTags(proCplus, pp);
                criarProdutoPack(pp, proCplus);

            } catch (Exception ex) {
                criaLog("Houve um erro ao criar PsProductLang ex. " + ex, "ERRO CRIAR");
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

    public void atualizarPackProdutoCriado (PsProduct pp) {
        for (PsPack pak : new QueryPrestaShop().listPackItem(pp.getIdProduct())) {
            BigDecimal preco = BigDecimal.ZERO;
            Integer qunti = 100;
            for (PsPack pak2 : new QueryPrestaShop().listPack(pak.getPsPackPK().getIdProductPack())) {
                PsProduct pr = new PsProductJpaController(Manager.getManagerPrestaShop()).findPsProduct(pak2.getPsPackPK().getIdProductItem());
                preco = preco.add(pr.getPrice().multiply(new BigDecimal(pak2.getQuantity())));
                List<PsStockAvailable> listPSSA = new QueryPrestaShop().listPsStockAvailable(pr.getIdProduct(), 1);
                for (PsStockAvailable psSA : listPSSA) {
                    if (psSA.getQuantity() < qunti) {
                        qunti = psSA.getQuantity();
                    }
                }
            }
            PsProduct psP = new PsProductJpaController(Manager.getManagerPrestaShop()).findPsProduct(pak.getPsPackPK().getIdProductPack());
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
                new PsProductJpaController(Manager.getManagerPrestaShop()).edit(psP);

                List<PsProductShop> listPPS = new QueryPrestaShop().listPsProductShop(psP.getIdProduct(), 1);
                for (PsProductShop pps : listPPS) {
                    pps.setPrice(preco);
                    if (qunti > 0) {
                        pps.setActive(true);
                        pps.setIndexed(true);
                    } else {
                        pps.setActive(false);
                        pps.setIndexed(false);
                    }
                    new PsProductShopJpaController(Manager.getManagerPrestaShop()).edit(pps);
                }

                List<PsStockAvailable> listPSSA = new QueryPrestaShop().listPsStockAvailable(psP.getIdProduct(), 1);
                for (PsStockAvailable psSA : listPSSA) {
                    psSA.setQuantity(qunti);
                    new PsStockAvailableJpaController(Manager.getManagerPrestaShop()).edit(psSA);
                }

            } catch (Exception ex) {
               criaLog("Houve um erro ao atualizar ProdutoPack ex. " + ex, "ERRO EDITAR ");
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
    private void editaProdutoDigimacro(Produto proCplus, PsProduct pp) {
        
        pp.setIdManufacturer(marcaFabricante(proCplus));
        pp.setIdCategoryDefault(categoriaPadrao(proCplus));
        // pp.setIdShopDefault(1);
        pp.setIdTaxRulesGroup(taxRulesGroup(proCplus));
        
        pp.setEan13(eanCplus(proCplus));
        
        pp.setPrice(precoPrincipal( proCplus));
        
        pp.setReference(proCplus.getCodprod() + "10"); //ligaÃ§Ã£o c-plus
        
        pp.setWidth(proCplus.getLargura());
        pp.setHeight(proCplus.getAltura());
        pp.setDepth(proCplus.getComprimento());
        pp.setWeight(proCplus.getPesobruto());
        pp.setOutOfStock(2);
       
        if (produtoAtivo(proCplus) && quantidadeEstoque(proCplus, pp) > 0) {
            pp.setActive(true);
            pp.setIndexed(true);
        } else {
            pp.setActive(false);
            pp.setIndexed(false);
        }
        
        pp.setAvailableDate(new Date(System.currentTimeMillis()));
        pp.setShowCondition(false);
        pp.setCondition1("new");
        pp.setShowPrice(true);
        
        pp.setVisibility("both");
        //     }
        pp.setCacheIsPack(true);
        
        pp.setDateUpd(new Date(System.currentTimeMillis()));
        
        try {
            new PsProductJpaController(Manager.getManagerPrestaShop()).edit(pp);

            //PsProductLang ppl = new PsProductLang();
            List<PsProductLang> listPPL = new QueryPrestaShop().listPsProductLang(pp.getIdProduct(), 2);
            for (PsProductLang ppl : listPPL) {
                //ppl.setPsProductLangPK(new PsProductLangPK(pp.getIdProduct(), 1, 2));
                String nomeProduto = proCplus.getNomeprodweb() + " " + fatorConversaoInteger(proCplus) + " UN";
                ppl.setDescription(observacao(proCplus));
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
                new PsProductLangJpaController(Manager.getManagerPrestaShop()).edit(ppl);
            }
            //PsProductShop pps = new PsProductShop();
            List<PsProductShop> listPPS = new QueryPrestaShop().listPsProductShop(pp.getIdProduct(), 1);
            for (PsProductShop pps : listPPS) {
                //pps.setPsProductShopPK(new PsProductShopPK(pp.getIdProduct(), 1));
                pps.setIdCategoryDefault(categoriaPadrao(proCplus));
                pps.setIdTaxRulesGroup(taxRulesGroup(proCplus));
               
                pps.setPrice(precoPrincipal( proCplus));
                
                if (produtoAtivo(proCplus) && quantidadeEstoque(proCplus, pp) > 0) {
                    pps.setActive(true);
                    pps.setIndexed(true);
                } else {
                    pps.setActive(false);
                    pps.setIndexed(false);
                }
               
                pps.setVisibility("both");
                //  }
                pps.setCacheDefaultAttribute(0);
                pps.setAdvancedStockManagement(false);
                //pps.setDateAdd(new Date(System.currentTimeMillis()));
                pps.setDateUpd(new Date(System.currentTimeMillis()));
                //pps.setPackStockType(3);
                new PsProductShopJpaController(Manager.getManagerPrestaShop()).edit(pps);
            }
            //PsStockAvailable psSA = new PsStockAvailable();
            List<PsStockAvailable> listPSSA = new QueryPrestaShop().listPsStockAvailable(pp.getIdProduct(), 1);
            for (PsStockAvailable psSA : listPSSA) {
                psSA.setIdProduct(pp.getIdProduct());
                psSA.setIdProductAttribute(0);
                psSA.setIdShop(1);
                psSA.setIdShopGroup(0);
                psSA.setQuantity(quantidadeEstoque(proCplus, pp));
                // psSA.setPhysicalQuantity(editaQuantidadeEstoque(managerCplus, managerPrestaShop, proCplus, pp));
                psSA.setReservedQuantity(0);
                psSA.setDependsOnStock(false);
                psSA.setOutOfStock(false);
                new PsStockAvailableJpaController(Manager.getManagerPrestaShop()).edit(psSA);
            }
            //PsSpecificPrice psSP = new PsSpecificPrice();
            precoQuntidade(pp);
            categoriaProduto(false, pp, proCplus);
            gerenciaTags(proCplus, pp);
            criarProdutoPack(pp, proCplus);
        } catch (Exception ex) {
            criaLog("Houve um erro ao criar PsProductLang ex. " + ex, "ERRO CRIAR");
        }
    }

    /**
     * Função que relaciona o calculo do icms do Cplus para o site
     *
     * @param managerPrestaShop
     * @param pro
     * @return
     */
    private int taxRulesGroup(Produto pro) {
        int var = 0;
        List<PsTaxRulesGroup> listT = new QueryPrestaShop().listPorNomeCalculoIcms(pro.getCodcalculoicms().getNomecalculoicms());
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
    private void criaLog(String mensagem, String tipoLog) {
        IntLogs log = new IntLogs();
        log.setDataExecucao(new Date(System.currentTimeMillis()));
        log.setMensagem(mensagem);
        log.setTipoLog(tipoLog);
        new IntLogsJpaController(Manager.getManagerIntegrador()).create(log);
    }

    /**
     * Função para retornar uma String EAN
     *
     * @param managerCplus
     * @param proCplus
     * @return
     */
    private String eanCplus(Produto proCplus) {
        String tex = "";
        List<Produtocodigo> listPrdCod = new QueryCplus().resultEanProduto(proCplus.getCodprod());
        for (Produtocodigo pc : listPrdCod) {
            tex = pc.getCodigo();
        }
        return tex;
    }

    private Integer categoriaPadrao(Produto proCplus) {
        int catId = 2;
        return catId;
    }

    private BigDecimal precoPrincipal(Produto proCplus) {
        BigDecimal preco = BigDecimal.ZERO;
        List<Produtopreco> listPreco = new QueryCplus().listPrecos(proCplus.getCodprod(), "000000001");
        for (Produtopreco pr : listPreco) {
            preco = pr.getPreco().multiply(fatorConversaoBigDecimal(proCplus));
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

    private Integer quantidadeEstoque( Produto proCplus) {
        BigDecimal estoque = BigDecimal.ZERO;
        int stock;
        List<Produtoestoque> listEsroque = new QueryCplus().listEstoquesPorProd(proCplus.getCodprod());
        for (Produtoestoque est : listEsroque) {
            estoque = est.getEstatu().subtract(est.getReservadoorcamento().subtract(est.getReservadoos()));
        }
        stock = estoque.intValue() / fatorConversaoInteger(proCplus);

        return stock;
    }

    /**
     * Função que verifica as reservas dos pedidos no c-plus e no site
     *
     * @param verificaLegiao
     * @param produto
     * @return BigDecimal
     */
    private Integer quantidadeEstoque(Produto proCplus, PsProduct prodPrestaShop) {
        BigDecimal estoque = BigDecimal.ZERO;
        int stock;
        int reservaSite = 0;
        List<PsStockAvailable> listPSA = new QueryPrestaShop().listEstoqueProduto(prodPrestaShop.getIdProduct());
        for (PsStockAvailable psSA : listPSA) {
            reservaSite = psSA.getReservedQuantity();
        }
        List<Produtoestoque> listEsroque = new QueryCplus().listEstoquesPorProd(proCplus.getCodprod());
        for (Produtoestoque est : listEsroque) {
            estoque = est.getEstatu().subtract(est.getReservadoorcamento().subtract(est.getReservadoos()));
        }
        stock = (estoque.intValue() - reservaSite) / fatorConversaoInteger(proCplus);
        return stock;
    }

    private void precoQuntidade(PsProduct pp) {
        List<BigDecimal> listBigDecimal = new ArrayList<>();
        listBigDecimal.add(new BigDecimal("0.5"));
        listBigDecimal.add(new BigDecimal("1.0"));
        listBigDecimal.add(new BigDecimal("2.0"));
        listBigDecimal.add(new BigDecimal("3.0"));
        for (BigDecimal bd : listBigDecimal) {
            //PsSpecificPrice psSP = new PsSpecificPrice();
            List<PsSpecificPrice> listPSSP = new QueryPrestaShop().listPsSpecificPrice(pp.getIdProduct(), bd.divide(new BigDecimal("100.0"), 3, RoundingMode.HALF_UP), 4);          
            for (PsSpecificPrice psSP : listPSSP) {
                try {
                    new PsSpecificPriceJpaController(Manager.getManagerPrestaShop()).destroy(psSP.getIdSpecificPrice());
                } catch (NonexistentEntityException ex) {
                    criaLog("Houve um erro ao excluir PsSpecificPrice ex. " + ex, "ERRO EXCLUIR");
                }
            }
        }
    }

    private void criarProdutoPack(PsProduct pp, Produto proCplus) {
        List<PsProduct> listProdPack = new QueryPrestaShop().listagemProdutoSite(proCplus.getCodprod());//sem o 10 no caso
        for (PsProduct prodPack : listProdPack) {
            List<PsPack> listPP = new QueryPrestaShop().listPack(pp.getIdProduct(), prodPack.getIdProduct());
            if (listPP.isEmpty()) {
                PsPack pPack = new PsPack();
                pPack.setQuantity(fatorConversaoInteger(proCplus));
                pPack.setPsPackPK(new PsPackPK(pp.getIdProduct(), prodPack.getIdProduct(), 0));
                try {
                    new PsPackJpaController(Manager.getManagerPrestaShop()).create(pPack);
                } catch (Exception ex) {
                    criaLog( "Houve um erro ao criar PsPack ex. " + ex, "ERRO CRIAR");
                }
            } else {
                for (PsPack packBanco : listPP) {
                    packBanco.setQuantity(fatorConversaoInteger(proCplus));
                    try {
                        new PsPackJpaController(Manager.getManagerPrestaShop()).edit(packBanco);
                    } catch (Exception ex) {
                        criaLog("Houve um erro ao editar PsPack ex. " + ex, "ERRO EDITAR");
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
    private void categoriaProduto(boolean promocao, PsProduct pp, Produto proCplus) {
        String sec;
        if (promocao) {
            sec = proCplus.getCodsec().getClassificacao() + ".143";
        } else {
            sec = proCplus.getCodsec().getClassificacao();
        }
        String[] listSecaoIntegrador = sec.split("\\.");
        List<PsCategoryProduct> listPCP = new QueryPrestaShop().listCategoriaProduto(pp.getIdProduct(), 2);
        if (listPCP.isEmpty()) {
            PsCategoryProduct psCP = new PsCategoryProduct();
            psCP.setPsCategoryProductPK(new PsCategoryProductPK(2, pp.getIdProduct()));//categoria default
            try {
                new PsCategoryProductJpaController(Manager.getManagerPrestaShop()).create(psCP);
            } catch (Exception ex) {
                criaLog("Houve um erro ao criar PsCategoryProduct ex. " + ex, "ERRO CRIAR");
            }
        }
        for (String secTemp : listSecaoIntegrador) {
            Integer secaoId = Integer.valueOf(secTemp);
            listPCP = new QueryPrestaShop().listCategoriaProduto(pp.getIdProduct(), secaoId);
            if (listPCP.isEmpty()) {
                PsCategoryProduct psCP = new PsCategoryProduct();
                psCP.setPsCategoryProductPK(new PsCategoryProductPK(secaoId, pp.getIdProduct()));
                try {
                    new PsCategoryProductJpaController(Manager.getManagerPrestaShop()).create(psCP);
                } catch (Exception ex) {
                    criaLog("Houve um erro ao criar PsCategoryProduct ex. " + ex, "ERRO CRIAR");
                }
            }

        }
        //verifica categoria trocada
        listPCP = new QueryPrestaShop().listCategoriaProduto(pp.getIdProduct());
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
                    new PsCategoryProductJpaController(Manager.getManagerPrestaShop()).destroy(psCP.getPsCategoryProductPK());
                } catch (NonexistentEntityException ex) {
                    criaLog("Houve um erro ao excluir PsCategoryProduct ex. " + ex, "ERRO EXCLUIR");
                }
            }
        }
    }

    private Integer fatorConversaoInteger(Produto prodCplus) {
        Integer quantidade = 1;
        for (Unidade un : new QueryCplus().resultPorUnidadeProduto(prodCplus.getUnidade())) {
            if (un.getFatorconversao().intValue() > 1) {
                quantidade = un.getFatorconversao().intValue();
            }
        }
        return quantidade;
    }

    private BigDecimal fatorConversaoBigDecimal(Produto prodCplus) {
        BigDecimal quantidade = BigDecimal.ONE;
        for (Unidade un : new QueryCplus().resultPorUnidadeProduto(prodCplus.getUnidade())) {
            if (un.getFatorconversao().intValue() > 1) {
                quantidade = un.getFatorconversao();
            }
        }
        return quantidade;
    }

    private void gerenciaTags(Produto proCplus, PsProduct pp) {
        String nomeProduto = proCplus.getNomeprodweb().trim().toLowerCase();
        String[] listaDePalavras = nomeProduto.split(" ");
        for (int cont = 0; listaDePalavras.length > cont; cont++) {
            if (listaDePalavras[cont].length() > 1) {
                List<PsTag> listTag = new QueryPrestaShop().resultPorNomeTag(listaDePalavras[cont].trim());
                if (listTag.isEmpty()) {
                    PsTag psT = new PsTag();
                    psT.setIdLang(2);
                    psT.setName(listaDePalavras[cont].trim());
                    new PsTagJpaController(Manager.getManagerPrestaShop()).create(psT);
                    listTag = new QueryPrestaShop().resultPorNomeTag(listaDePalavras[cont].trim());
                    for (PsTag pT : listTag) {
                        manipulaProductTag(pT, pp);
                        manipulaTagCount(pT, pp);
                    }
                }
                for (PsTag pT : listTag) {
                    manipulaProductTag(pT, pp);
                    manipulaTagCount(pT, pp);

                }
            }
        }
        deletaProductTag(pp, listaDePalavras);
    }

    private void deletaProductTag(PsProduct pp, String[] listaDePalavras) {
        boolean condicao;
        List<PsProductTag> listPsPT = new QueryPrestaShop().resultPsProductTag(pp.getIdProduct());
        for (PsProductTag psPT : listPsPT) {
            int idTag = 0;
            condicao = true;
            for (int cont = 0; listaDePalavras.length > cont; cont++) {
                List<PsTag> listTag = new QueryPrestaShop().resultPorNomeTag(listaDePalavras[cont].trim());
                for (PsTag pT : listTag) {
                    idTag = pT.getIdTag();
                    if (pT.getIdTag() == psPT.getPsProductTagPK().getIdTag());
                    condicao = false;
                }
            }
            if (condicao) {
                try {
                    new PsProductTagJpaController(Manager.getManagerPrestaShop()).destroy(new PsProductTagPK(pp.getIdProduct(), idTag));
                } catch (NonexistentEntityException ex) {
                    criaLog("Houve um erro ao excluir PsProductTag ex. " + ex, "ERRO RXCLUIR");
                }
            }
        }
    }

    private void manipulaTagCount(PsTag pT, PsProduct pp) {
        for (PsGroup pG : new PsGroupJpaController(Manager.getManagerPrestaShop()).findPsGroupEntities()) {
            List<PsTagCount> listPsTC = new QueryPrestaShop().listTagCount(pT.getIdTag(), pG.getIdGroup());
            if (listPsTC.isEmpty()) {
                PsTagCount psTC = new PsTagCount();
                List<PsProductTag> listPPT = new QueryPrestaShop().resultPsProductTag(pp.getIdProduct());
                psTC.setCounter(listPPT.size());
                psTC.setIdLang(2);
                psTC.setIdShop(1);
                psTC.setPsTagCountPK(new PsTagCountPK(pG.getIdGroup(), pT.getIdTag()));
                try {
                    new PsTagCountJpaController(Manager.getManagerPrestaShop()).create(psTC);
                } catch (Exception ex) {
                    criaLog( "Houve um erro ao criar PsTagCount ex. " + ex, "ERRO CRIAR");
                }
            }
        }

    }

    private void manipulaProductTag(PsTag pT, PsProduct pp) {
        List<PsProductTag> listPsPT = new QueryPrestaShop().listProductTag(pT.getIdTag(), pp.getIdProduct());
        if (listPsPT.isEmpty()) {
            PsProductTag psPT = new PsProductTag();
            psPT.setIdLang(2);
            psPT.setPsProductTagPK(new PsProductTagPK(pp.getIdProduct(), pT.getIdTag()));
            try {
                new PsProductTagJpaController(Manager.getManagerPrestaShop()).create(psPT);
            } catch (Exception ex) {
                criaLog("Houve um erro ao criar PsProductTag ex. " + ex, "ERRO CRIAR");
            }
        }
    }

    private Integer marcaFabricante(Produto proCplus) {
        Integer idManuf = 1;
        List<PsManufacturer> listPM = new QueryPrestaShop().listManufacturer(proCplus.getCodfabricante().getNomefabricante());
        if (listPM.isEmpty()) {
            PsManufacturer psM = new PsManufacturer();
            psM.setName(proCplus.getCodfabricante().getNomefabricante());
            psM.setDateAdd(new Date(System.currentTimeMillis()));
            psM.setDateUpd(new Date(System.currentTimeMillis()));
            psM.setActive(true);
            new PsManufacturerJpaController(Manager.getManagerPrestaShop()).create(psM);
            listPM = new QueryPrestaShop().listManufacturer(proCplus.getCodfabricante().getNomefabricante());
        }
        for (PsManufacturer pM : listPM) {
            idManuf = pM.getIdManufacturer();
            pM.setName(proCplus.getCodfabricante().getNomefabricante());
            try {
                new PsManufacturerJpaController(Manager.getManagerPrestaShop()).edit(pM);
                List<PsManufacturerShop> listPMS = new QueryPrestaShop().listManufacturerShop(pM.getIdManufacturer());
                if (listPMS.isEmpty()) {
                    PsManufacturerShop pMS = new PsManufacturerShop();
                    pMS.setPsManufacturerShopPK(new PsManufacturerShopPK(pM.getIdManufacturer(), 1));
                    try {
                        new PsManufacturerShopJpaController(Manager.getManagerPrestaShop()).create(pMS);
                    } catch (Exception ex) {
                        criaLog("Houve um erro ao criar PsManufacturerShop ex. " + ex, "ERRO CRIAR");
                    }
                }
                List<PsManufacturerLang> listPML = new QueryPrestaShop().listManufacturerLang(pM.getIdManufacturer(), 2);
                if (listPML.isEmpty()) {
                    PsManufacturerLang pML = new PsManufacturerLang();
                    pML.setPsManufacturerLangPK(new PsManufacturerLangPK(pM.getIdManufacturer(), 2));
                    try {
                        new PsManufacturerLangJpaController(Manager.getManagerPrestaShop()).create(pML);
                    } catch (Exception ex) {
                        criaLog( "Houve um erro ao criar PsManufacturerLang ex. " + ex, "ERRO CRIAR");
                    }
                }
            } catch (Exception ex) {
                criaLog("Houve um erro ao editar PsManufacturerLang ex. " + ex, "ERRO EDITAR");
            }
        }
        return idManuf;
    }

    private String observacao(Produto proCplus) {
        String ob = "";
        if (proCplus != null) {
            ob = proCplus.getObs() + " <p>Part Number: " + partNumber(proCplus) + "</p> <p>NCM: "
                    + new FormataCampos().mascaraNCM(proCplus.getCodclassificacaofiscal().getCodigoclassificacaofiscal()) + " </p>";
        }
        return ob;
    }

    private String partNumber(Produto proCplus) {
        //part Number 000000004
        //complemento Fiscal 000000003
        String codCampoCustomMaster = "000000004";
        String retorno = "";
        for (Campocustomvalor campo : new QueryCplus().listCampoMaster(proCplus.getCodprod(), codCampoCustomMaster)) {
            if (campo.getValor() != null) {
                retorno = campo.getValor();
            }
        }
        return retorno;
    }
}
