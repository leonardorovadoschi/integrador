/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package produto;

import acesso.ConexaoPrestaShop;
import entidade.cplus.Campocustomvalor;
import entidade.cplus.Movenda;
import entidade.cplus.Produto;
import entidade.cplus.Produtocodigo;
import entidade.cplus.Produtoestoque;
import entidade.cplus.Produtopreco;
import entidade.cplus.Unidade;
import entidade.integrador.IntLogs;
import entidade.integrador.ProdFornecedor;
import entidade.prestaShop.PsAccessory;
import entidade.prestaShop.PsCategoryProduct;
import entidade.prestaShop.PsCategoryProductPK;
import entidade.prestaShop.PsGroup;
import entidade.prestaShop.PsManufacturer;
import entidade.prestaShop.PsManufacturerLang;
import entidade.prestaShop.PsManufacturerLangPK;
import entidade.prestaShop.PsManufacturerShop;
import entidade.prestaShop.PsManufacturerShopPK;
import entidade.prestaShop.PsOrderDetail;
import entidade.prestaShop.PsOrders;
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
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import jpa.integrador.IntLogsJpaController;
import jpa.prestaShop.PsCategoryProductJpaController;
import jpa.prestaShop.PsGroupJpaController;
import jpa.prestaShop.PsManufacturerJpaController;
import jpa.prestaShop.PsManufacturerLangJpaController;
import jpa.prestaShop.PsManufacturerShopJpaController;
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
import query.integrador.QueryIntegrador;
import query.prestaShop.QueryPrestaShop;

/**
 *
 * @author leo
 */
public class ProdutoCplusDigimacro {

    boolean promo;

    /**
     * Função encarregada de verificar se o produto será criado ou atualizado   
     * @param proCplus
     * @return
     */
    public boolean produtoCplusDigimacro(Produto proCplus) {
        boolean condicao = true;
        promo = false;
        List<PsProduct> listProdSite = new QueryPrestaShop().listagemProdutoSite(proCplus.getCodprod());
        // List<PsProduct> listProdSite = new QueryPrestaShop(managerPrestaShop).listagemProdutoSite("000001942");
        switch (listProdSite.size()) {
            case 0:
                if (produtoAtivo(proCplus) && EstoqueCplus(proCplus) > 0) {
                    criarProdutoSite(proCplus);
                    if (fatorConversao(proCplus) > 1) {
                        new PackProduto().produtoCplusDigimacro(proCplus);
                    }
                }
                break;
            case 1:
                for (PsProduct pp : listProdSite) {
                    editaProdutoSite(proCplus, pp);
                    if (fatorConversao(proCplus) > 1) {
                        new PackProduto().produtoCplusDigimacro(proCplus);
                    }
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

    public boolean produtoCplusDigimacroEstoque(Produto proCplus) {
        boolean condicao = true;
        promo = false;
        List<PsProduct> listProdSite = new QueryPrestaShop().listagemProdutoSite(proCplus.getCodprod());
        if (listProdSite.size() == 1) {
            for (PsProduct pp : listProdSite) {
                editaProdutoSite(proCplus, pp);
                if (fatorConversao(proCplus) > 1) {
                    new PackProduto().produtoCplusDigimacro(proCplus);
                }
            }
        } else if (listProdSite.size() > 1) {
            String log = "A pesquisa achou mais que um produto no site com a mesma referencia \n VERIFIQUE \n";
            for (PsProduct pp : listProdSite) {
                log = log + pp.getReference() + "\n";
            }
            criaLog(log, "ERRO PRODUTO");
        }
        return condicao;
    }

    /**
     * Funçao que cria um produto no prestaShop
     *
     * @param managerIntegrador
     * @param managerCplus
     * @param managerPrestaShop
     * @param proCplus
     * @return
     */
    private boolean criarProdutoSite(Produto proCplus) {
        boolean condicao = true;
        PsProduct pp1 = new PsProduct();
        pp1.setIdSupplier(0);
        pp1.setIdManufacturer(marcaFabricante(proCplus));
        pp1.setIdCategoryDefault(categoriaPadrao(proCplus));
        pp1.setIdShopDefault(1);
        pp1.setIdTaxRulesGroup(taxRulesGroup(proCplus));
        pp1.setOnSale(false);
        pp1.setLowStockThreshold(EstoqueMinimoCplus(proCplus));
        //pp1.setOnlineOnly(false);
        pp1.setEan13(eanCplus(proCplus));
        pp1.setIsbn("");
        pp1.setUpc("");
        pp1.setEcotax(BigDecimal.ZERO);
        pp1.setQuantity(0);
        pp1.setMinimalQuantity(1);
        pp1.setLowStockThreshold(0);
        pp1.setLowStockAlert(true);
        pp1.setPrice(precoPrincipal(proCplus));
        //pp1.setWholesalePrice(proCplus.getCustoreal());
        pp1.setWholesalePrice(BigDecimal.ZERO);
        pp1.setUnity("");
        pp1.setUnitPriceRatio(BigDecimal.ZERO);
        pp1.setAdditionalShippingCost(BigDecimal.ZERO);
        pp1.setReference(proCplus.getCodprod()); //ligaÃ§Ã£o c-plus
        pp1.setSupplierReference("");
        pp1.setLocation("");
        if (proCplus.getLargura() != null) {
            pp1.setWidth(proCplus.getLargura());
        } else {
            pp1.setWidth(BigDecimal.ZERO);
        }
        if (proCplus.getAltura() != null) {
            pp1.setHeight(proCplus.getAltura());
        } else {
            pp1.setHeight(BigDecimal.ZERO);
        }
        if (proCplus.getComprimento() != null) {
            pp1.setDepth(proCplus.getComprimento());
        } else {
            pp1.setDepth(BigDecimal.ZERO);
        }
        pp1.setWeight(proCplus.getPesobruto());
        pp1.setOutOfStock(2);
        pp1.setAdditionalDeliveryTimes(true);
        pp1.setQuantityDiscount(false);
        pp1.setCustomizable((short) 0);
        pp1.setUploadableFiles((short) 0);
        pp1.setTextFields((short) 0);
        if (produtoAtivo(proCplus) && quanEstoqeuCplus(proCplus) > 0) {
            pp1.setActive(true);
            pp1.setIndexed(true);
        } else {
            pp1.setActive(false);
            pp1.setIndexed(false);
        }
        pp1.setRedirectType("301-category");
        pp1.setIdTypeRedirected(0);
        //pp1.setAvailableForOrder(true);
        pp1.setAvailableDate(null);
        pp1.setShowCondition(true);
        pp1.setCondition1("new");
        //pp1.setShowPrice(true);
        if ("116".equals(proCplus.getCodsec().getClassificacao()) || fatorConversao(proCplus) > 1) {
            //pp1.setIndexed(false);
            pp1.setVisibility("none");
            pp1.setShowPrice(false);
            pp1.setOnlineOnly(true);
            pp1.setAvailableForOrder(false);

        } else {
            // pp1.setIndexed(true);
            pp1.setVisibility("both");
            pp1.setShowPrice(true);
            pp1.setOnlineOnly(false);
            pp1.setAvailableForOrder(true);
        }
        pp1.setCacheIsPack(false);
        pp1.setCacheHasAttachments(false);
        pp1.setIsVirtual(false);
        pp1.setCacheDefaultAttribute(0);
        pp1.setDateAdd(new Date(System.currentTimeMillis()));
        pp1.setDateUpd(new Date(System.currentTimeMillis()));
        pp1.setAdvancedStockManagement(false);
        pp1.setPackStockType(3);
        pp1.setState(1);
        // pp1.setDepth(BigDecimal.ZERO);

        new PsProductJpaController(Manager.getManagerPrestaShop()).create(pp1);

        List<PsProduct> listProdSite = new QueryPrestaShop().listagemProdutoSite(proCplus.getCodprod());
        for (PsProduct pp : listProdSite) {
            produtoLang(pp, proCplus);
            produtoShop(pp, proCplus);
            produtoStockAvailable(pp, proCplus);
            try {
                if (fatorConversao(proCplus) == 1) {
                    precoQuntidade(proCplus, pp);
                    gerenciaTags(proCplus, pp);
                    categoriaProduto(promo, pp, proCplus);
                } else {
                    categoriaProdutoPack(pp, proCplus);
                }
                produtoTransportadora(pp);
            } catch (Exception ex) {
                criaLog( "Houve um erro ao criar PsProductLang ex. " + ex, "ERRO CRIAR");
            }
        }
        return condicao;
    }

    private String linkRewrite(Produto prod) {
        String valor = "";
        if (prod.getNomeprodweb() == null || "".equals(prod.getNomeprodweb())) {
            JOptionPane.showMessageDialog(null, "Houve um erro na execução automatica! \n" + prod.getNomeprod());
        } else {
            valor = prod.getNomeprodweb().toLowerCase();
            valor = valor.trim();
            //valor = Normalizer.normalize(valor, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");//remover acentuação     
            valor = valor.replaceAll("[^a-zA-Z1-9 ]", "");//remover todos caracteres especiais e letras maiusculas
            valor = valor.replace(" ", "-").toLowerCase();
            valor = valor.replaceAll("\\--", "-");
            valor = valor.replaceAll("\\---", "-");
        }
        return valor;
    }

    /**
     * Função para editar produto no site
     * @param proCplus
     * @param pp produto prestaShop
     */
    private void editaProdutoSite(Produto proCplus, PsProduct pp) {
        pp.setIdManufacturer(marcaFabricante(proCplus));
        pp.setIdCategoryDefault(categoriaPadrao( proCplus));
        pp.setIdTaxRulesGroup(taxRulesGroup(proCplus));
        pp.setEan13(eanCplus(proCplus));
        pp.setPrice(precoPrincipal(proCplus));
        pp.setReference(proCplus.getCodprod());
        pp.setLowStockThreshold(EstoqueMinimoCplus(proCplus));
        if (proCplus.getLargura() != null) {
            pp.setWidth(proCplus.getLargura());
        } else {
            pp.setWidth(BigDecimal.ZERO);
        }
        if (proCplus.getAltura() != null) {
            pp.setHeight(proCplus.getAltura());
        } else {
            pp.setHeight(BigDecimal.ZERO);
        }
        if (proCplus.getComprimento() != null) {
            pp.setDepth(proCplus.getComprimento());
        } else {
            pp.setDepth(BigDecimal.ZERO);
        }
        pp.setWeight(proCplus.getPesobruto());
        pp.setOutOfStock(2);
        if (produtoAtivo(proCplus) && quanEstoqeuCplus(proCplus) > 0) {
            pp.setActive(true);
            pp.setIndexed(true);
        } else {
            ///////////////////////////////////////////////////////////////
            if (sobEncomendaAtivo(proCplus)) {
                pp.setActive(true);
                pp.setIndexed(true);
            } else {
                pp.setActive(false);
                pp.setIndexed(false);
            }
        }
        pp.setAvailableDate(new Date(System.currentTimeMillis()));
        pp.setShowCondition(false);
        pp.setCondition1("new");
        //pp.setShowPrice(true);
        if ("116".equals(proCplus.getCodsec().getClassificacao())) {
            //pp.setIndexed(false);
            pp.setVisibility("none");
            pp.setShowPrice(false);
            pp.setOnlineOnly(true);
            pp.setAvailableForOrder(true);
        } else {
            // pp1.setIndexed(true);
            pp.setVisibility("both");
            pp.setShowPrice(true);
            pp.setOnlineOnly(false);
            pp.setAvailableForOrder(false);
        }
        //if (fatorConversao(proCplus, managerCplus) > 1) {
        //    pp.setVisibility("none");
        //} else {
        //    pp.setVisibility("both");
        //}
        pp.setDateUpd(new Date(System.currentTimeMillis()));
        //pp.setWholesalePrice(proCplus.getCustoreal());
        pp.setWholesalePrice(BigDecimal.ZERO);
        try {
            new PsProductJpaController(Manager.getManagerPrestaShop()).edit(pp);
            produtoLang(pp, proCplus);
            produtoShop(pp, proCplus);
            produtoStockAvailable(pp, proCplus);
            if (fatorConversao(proCplus) == 1) {
                precoQuntidade(proCplus, pp);
                gerenciaTags(proCplus, pp);
                categoriaProduto(promo, pp, proCplus);
                new PackProduto().atualizarPackProdutoCriado(pp);
            } else {
                categoriaProdutoPack(pp, proCplus);
            }          
            produtoTransportadora(pp);           
        } catch (Exception ex) {
            criaLog("Houve um erro ao criar PsProductLang ex. " + ex, "ERRO EDITAR");
        }
    }

    private void produtoLang(PsProduct pp, Produto proCplus) {
        List<PsProductLang> listPPL = new QueryPrestaShop().listPsProductLang(pp.getIdProduct(), 2);
        if (listPPL.isEmpty()) {
            PsProductLang ppl = new PsProductLang();
            ppl.setPsProductLangPK(new PsProductLangPK(pp.getIdProduct(), 1, 2));
            ppl.setDescription(observacao(proCplus));
            ppl.setDescriptionShort(tamanhoString(proCplus.getAplicacao(), 799));
            ppl.setLinkRewrite(linkRewrite(proCplus));
            ppl.setMetaDescription(tamanhoString(metaDescription(proCplus), 160));
            //ppl.setMetaDescription("");
            ppl.setMetaKeywords("");
            ppl.setMetaTitle(linkRewrite(proCplus));
            ppl.setName(proCplus.getNomeprodweb());
            ppl.setAvailableNow("Disponíel");
            ppl.setAvailableLater("Sem Estoque");
            ppl.setDeliveryInStock("Entrega Imediata");
            ppl.setDeliveryOutStock("Sem Previsão");
            try {
                new PsProductLangJpaController(Manager.getManagerPrestaShop()).create(ppl);
            } catch (Exception ex) {
                criaLog("Houve um erro ao criar PsProductLang ex. " + ex, "ERRO CRIAR");
            }
        } else {
            for (PsProductLang ppl : listPPL) {
                //ppl.setPsProductLangPK(new PsProductLangPK(pp.getIdProduct(), 1, 2));
                ppl.setDescription(observacao(proCplus));
                ppl.setDescriptionShort(tamanhoString(proCplus.getAplicacao(), 799));
                ppl.setLinkRewrite(linkRewrite(proCplus));
                ppl.setMetaDescription(tamanhoString(metaDescription(proCplus), 160));
                // ppl.setMetaDescription("");
                ppl.setMetaKeywords("");
                ppl.setMetaTitle(linkRewrite(proCplus));
                ppl.setName(proCplus.getNomeprodweb());
                ppl.setAvailableNow("Disponível");
                ppl.setAvailableLater("Sem Estoque");
                ppl.setDeliveryInStock("Entrega Imediata");
                ppl.setDeliveryOutStock("Sem Previsão");
                try {
                    new PsProductLangJpaController(Manager.getManagerPrestaShop()).edit(ppl);
                    //////////////////////
                    produtoRelacionado(ppl, pp);
                } catch (Exception ex) {
                    criaLog( "Houve um erro ao editar PsProductLang Produto: " + ppl.getName() + " ex. " + ex, "ERRO EDITAR");
                }
            }
        }
    }

    private String observacao(Produto proCplus) {
        String ob = "";
        if (proCplus != null) {
            ob = proCplus.getObs() + " <p>EAN: " + eanCplus(proCplus) + "</p>"
                    + " <p>Part Number: " + partNumber(proCplus) + "</p> <p>NCM: "
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

    /**
     * Função que relaciona o calculo do icms do Cplus para o site
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

    private boolean taxaProdutosICMSDfifenciada(Produto pro) {
        List<PsTaxRulesGroup> listT = new QueryPrestaShop().listPorNomeCalculoIcms(pro.getCodcalculoicms().getNomecalculoicms());
        boolean condicao = false;
        for (PsTaxRulesGroup cl : listT) {
            String[] names = cl.getName().split("-");
            for (int count = 1; count < names.length; count++) {
                if ("ISENTO".equals(names[count])) {
                    condicao = true;
                }
            }
        }
        return condicao;
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
            if (pc.getCodigo().length() < 14) {
                tex = pc.getCodigo();
            }
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
            preco = pr.getPreco().multiply(new BigDecimal("1.11"));
        }
        return preco.setScale(2, RoundingMode.HALF_UP);
    }

    /**
     * Caso produto for ativo, retorna verdadeiro
     *
     * @param proCplus
     * @return
     */
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
        String text = "";
        if (proCplus.getAplicacao() != null) {
            text = proCplus.getAplicacao().toLowerCase();
            text = text.replace("<", " ");
            text = text.replace(">", " ");
            text = text.replace(":", "");
            text = text.replace(";", "");
            text = text.replace("/", "");
            text = text.replace("", "");
            text = text.replace("<p>", "");
            text = text.replace("span", "");
            text = text.replace("style=\"", "");
            text = text.replace("font-size", "");
            text = text.replace("font-family", "");
            text = text.replace("Arial", "");

        }
        return text;

    }

    private Integer quanEstoquePrestaShop(PsProduct proPrestaShop) {
        //Integer estoque = 0;
        int stock = 0;
        //  List<PsStockAvailable> listEsroque = new QueryPrestaShop(managerPrestaShop).listEstoqueProduto(proPrestaShop.getIdProduct());
        for (PsStockAvailable est : new QueryPrestaShop().listEstoqueProduto(proPrestaShop.getIdProduct())) {
            stock = est.getPhysicalQuantity();
        }

        return stock;
    }

    private Integer quanEstoqeuCplus(Produto proCplus) {
        BigDecimal estoque = BigDecimal.ZERO;
        int stock;
        List<Produtoestoque> listEsroque = new QueryCplus().listEstoquesPorProd(proCplus.getCodprod());
        for (Produtoestoque est : listEsroque) {
            estoque = est.getEstatu().subtract(est.getReservadoorcamento().subtract(est.getReservadoos()));
        }
        stock = estoque.intValue();
        return stock;
    }

    /**
     * Função que verifica as reservas dos pedidos no c-plus e no site
     * @param produto
     * @return BigDecimal
     */
    private Integer EstoqueCplus(Produto proCplus) {
        BigDecimal estoque = BigDecimal.ZERO;
        List<Produtoestoque> listEsroque = new QueryCplus().listEstoquesPorProd(proCplus.getCodprod());
        for (Produtoestoque est : listEsroque) {
            estoque = est.getEstatu().subtract(est.getReservadoorcamento().subtract(est.getReservadoos()));
        }
        return estoque.intValue();
    }
    
    private Integer EstoqueMinimoCplus(Produto proCplus) {
        BigDecimal estoque = BigDecimal.ZERO;
        List<Produtoestoque> listEsroque = new QueryCplus().listEstoquesPorProd(proCplus.getCodprod());
        for (Produtoestoque est : listEsroque) {
            estoque = est.getQtdemin();
        }
        return estoque.intValue();
    }

    private void precoQuntidade(Produto pro, PsProduct pp) {
        precoQuantidadeJuridica(pp);
        precoQuantidadeJuridicaDiferenciada(pro, pp);

    }

    private void precoQuantidadeJuridicaDiferenciada(Produto pro, PsProduct pp) {
        
      List<BigDecimal> listBigDecimal = new ArrayList<>();
        listBigDecimal.add(new BigDecimal("0.5"));
        listBigDecimal.add(new BigDecimal("1.0"));
        listBigDecimal.add(new BigDecimal("2.0"));
        listBigDecimal.add(new BigDecimal("3.0"));
        for (BigDecimal bd : listBigDecimal) {
            //PsSpecificPrice psSP = new PsSpecificPrice();
            List<PsSpecificPrice> listPSSP = new QueryPrestaShop().listPsSpecificPrice(pp.getIdProduct(), bd.divide(new BigDecimal("100.0"), 7, RoundingMode.HALF_UP), 7);
            if (listPSSP.isEmpty()) {
                PsSpecificPrice psSP = new PsSpecificPrice();
                psSP.setIdSpecificPriceRule(0);
                psSP.setIdCart(0);
                psSP.setIdProduct(pp.getIdProduct());
                psSP.setIdShop(1);
                psSP.setIdShopGroup(0);
                psSP.setIdCurrency(1);
                psSP.setIdCountry(58);
                psSP.setIdGroup(7);
                psSP.setIdCustomer(0);
                psSP.setIdProductAttribute(0);
                psSP.setPrice(new BigDecimal("-1.0"));
                //psSP.setPrice(precoDiferenciado.multiply(new BigDecimal("0.9")));
                psSP.setFromQuantity(defineQuantidadePreco(pp, bd));
                psSP.setReduction(bd.divide(new BigDecimal("100.0"), 7, RoundingMode.HALF_UP));
                psSP.setReductionTax(true);
                psSP.setReductionType("percentage");
                psSP.setFrom(new Date(System.currentTimeMillis()));
                psSP.setTo(new FormataCampos().alteraDiaData(new Date(System.currentTimeMillis()), 360));
                new PsSpecificPriceJpaController(Manager.getManagerPrestaShop()).create(psSP);
            } else if (listPSSP.size() == 1) {
                for (PsSpecificPrice psSP : listPSSP) {
                    //psSP.setIdSpecificPriceRule(0);
                    // psSP.setIdCart(0);
                    //psSP.setIdProduct(pp.getIdProduct());
                    // psSP.setIdShop(1);
                    // psSP.setIdShopGroup(0);
                    // psSP.setIdCurrency(1);
                    // psSP.setIdCountry(58);
                    // psSP.setIdGroup(7);
                    // psSP.setIdCustomer(0);
                    // psSP.setIdProductAttribute(0);
                    psSP.setPrice(new BigDecimal("-1.0"));
                    //psSP.setPrice(precoDiferenciado.multiply(new BigDecimal("0.9")));
                    psSP.setFromQuantity(defineQuantidadePreco(pp, bd));
                    //psSP.setReduction(bd.divide(new BigDecimal("100.0")));
                    //psSP.setReductionTax(true);
                    //psSP.setReductionType("percentage");
                    //psSP.setFrom(new );
                    psSP.setTo(new FormataCampos().alteraDiaData(new Date(System.currentTimeMillis()), 360));
                    try {
                        new PsSpecificPriceJpaController(Manager.getManagerPrestaShop()).edit(psSP);
                    } catch (Exception ex) {
                        criaLog("Houve um erro ao criar PsSpecificPrice ex. " + ex, "ERRO EDITAR");
                    }
                }
            } else {
                for (PsSpecificPrice psSP : listPSSP) {
                    try {
                        new PsSpecificPriceJpaController(Manager.getManagerPrestaShop()).destroy(psSP.getIdSpecificPrice());
                    } catch (NonexistentEntityException ex) {
                        criaLog("Houve um erro ao excluir PsSpecificPrice ex. " + ex, "ERRO EXCLUIR");
                    }
                }
            }
        }
    }

    private void precoQuantidadeJuridica(PsProduct pp) {
        List<BigDecimal> listBigDecimal = new ArrayList<>();
        listBigDecimal.add(new BigDecimal("0.5"));
        listBigDecimal.add(new BigDecimal("1.0"));
        listBigDecimal.add(new BigDecimal("2.0"));
        listBigDecimal.add(new BigDecimal("3.0"));
        for (BigDecimal bd : listBigDecimal) {
            //PsSpecificPrice psSP = new PsSpecificPrice();
            List<PsSpecificPrice> listPSSP = new QueryPrestaShop().listPsSpecificPrice(pp.getIdProduct(), bd.divide(new BigDecimal("100.0"), 4, RoundingMode.HALF_UP), 4);
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
                psSP.setReduction(bd.divide(new BigDecimal("100.0"), 4, RoundingMode.HALF_UP));
                psSP.setReductionTax(true);
                psSP.setReductionType("percentage");
                psSP.setFrom(new Date(System.currentTimeMillis()));
                psSP.setTo(new FormataCampos().alteraDiaData(new Date(System.currentTimeMillis()), 360));
                new PsSpecificPriceJpaController(Manager.getManagerPrestaShop()).create(psSP);
            } else if (listPSSP.size() == 1) {
                for (PsSpecificPrice psSP : listPSSP) {
                   
                    psSP.setPrice(new BigDecimal("-1.0"));
                    psSP.setFromQuantity(defineQuantidadePreco(pp, bd));

                    psSP.setTo(new FormataCampos().alteraDiaData(new Date(System.currentTimeMillis()), 360));
                    try {
                        new PsSpecificPriceJpaController(Manager.getManagerPrestaShop()).edit(psSP);
                    } catch (Exception ex) {
                        criaLog("Houve um erro ao criar PsSpecificPrice ex. " + ex, "ERRO EDITAR");
                    }
                }
            } else {
                for (PsSpecificPrice psSP : listPSSP) {
                    try {
                        new PsSpecificPriceJpaController(Manager.getManagerPrestaShop()).destroy(psSP.getIdSpecificPrice());
                    } catch (NonexistentEntityException ex) {
                        criaLog("Houve um erro ao excluir PsSpecificPrice ex. " + ex, "ERRO EXCLUIR");
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

    private void categoriaProdutoPack(PsProduct pp, Produto proCplus) {
        //String[] listSecaoIntegrador = proCplus.getCodsec().getClassificacao().split("\\.");
        String[] listSecaoIntegrador = "116".split("\\.");
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

    private Integer fatorConversao(Produto prodCplus) {
        Integer quantidade = 1;
        for (Unidade un : new QueryCplus().resultPorUnidadeProduto(prodCplus.getUnidade())) {
            if (un.getFatorconversao().intValue() > 1) {
                quantidade = un.getFatorconversao().intValue();
            }
        }
        return quantidade;
    }

    private void gerenciaTags(Produto proCplus, PsProduct pp) {
        String nomeProduto = proCplus.getNomeprodweb().trim().toLowerCase();
        nomeProduto = nomeProduto.replace("\"", "");
        nomeProduto = nomeProduto.replace("/", "");
        nomeProduto = nomeProduto.replace("+", "");
        nomeProduto = nomeProduto.replace(",", "");
        nomeProduto = nomeProduto.replace("$", "");
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
                    criaLog("Houve um erro ao criar PsTagCount ex. " + ex, "ERRO CRIAR");
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
        String nomeFabricante = proCplus.getCodfabricante().getNomefabricante();
        if (nomeFabricante != null && !"".equals(nomeFabricante)) {
            List<PsManufacturer> listPM = new QueryPrestaShop().listManufacturer(nomeFabricante);
            if (listPM.isEmpty()) {
                PsManufacturer psM = new PsManufacturer();
                psM.setName(nomeFabricante);
                psM.setDateAdd(new Date(System.currentTimeMillis()));
                psM.setDateUpd(new Date(System.currentTimeMillis()));
                psM.setActive(true);
                new PsManufacturerJpaController(Manager.getManagerPrestaShop()).create(psM);
                listPM = new QueryPrestaShop().listManufacturer(nomeFabricante);
            }
            for (PsManufacturer pM : listPM) {
                idManuf = pM.getIdManufacturer();
                pM.setName(nomeFabricante);
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
                            criaLog("Houve um erro ao criar PsManufacturerLang ex. " + ex, "ERRO CRIAR");
                        }
                    }
                } catch (Exception ex) {
                    criaLog( "Houve um erro ao editar PsManufacturerLang ex. " + ex, "ERRO EDITAR");
                }
            }
        }
        return idManuf;
    }

    private void produtoTransportadora(PsProduct pp) {
        /**
         * //List<PsCarrier> carrier = new
         * QueryPrestaShop(managerPrestaShop).listCarrier(true); for(PsCarrier
         * carrier :new QueryPrestaShop(managerPrestaShop).listCarrier(true)){
         * List<PsProductCarrier> productCarrier = new
         * QueryPrestaShop(managerPrestaShop).listPsProductCarrier(pp.getIdProduct(),
         * carrier.getIdReference()); if(productCarrier.isEmpty()){
         * PsProductCarrier pc = new PsProductCarrier();
         * pc.setPsProductCarrierPK(new PsProductCarrierPK(pp.getIdProduct(),
         * carrier.getIdReference(), 1)); try { new
         * PsProductCarrierJpaController(managerPrestaShop).create(pc); } catch
         * (Exception ex) { criaLog(managerIntegrador, "Houve um erro ao criar
         * PsProductCarrier ex. " + ex, "ERRO CRIAR"); } }
         *
         * }
         */
    }

    private String tamanhoString(String str, int tamanhoString) {
        String str2 = "";
        if (str != null) {
            for (int cont = 0; cont < str.length(); cont++) {
                if (cont < tamanhoString) {
                    str2 = str2 + str.charAt(cont);
                }
            }
        }
        return str2;
    }

    private boolean emPromocao(PsProductShop pp, Produto proCplus) {
        boolean condicao = false;
        double precoCplus = precoPrincipal(proCplus).doubleValue();
        double precoPrestaShop = pp.getPrice().setScale(2, RoundingMode.HALF_UP).doubleValue();
        if (precoCplus < precoPrestaShop) {
            condicao = true;
        }
        return condicao;
    }

    private boolean tirarPrecoPromocao(PsProductShop entity) {
        boolean condicao = false;
        Integer numDias = 0;
        Calendar dataAtualCal = Calendar.getInstance();
        dataAtualCal.setTime(new java.util.Date(System.currentTimeMillis()));
        String diaAtualStr = String.format("%02d", dataAtualCal.get(Calendar.DAY_OF_MONTH));
        String mesAtualStr = String.format("%02d", dataAtualCal.get(Calendar.MONTH));
        String anoAtualStr = String.format("%04d", dataAtualCal.get(Calendar.YEAR));
        Calendar dataBancoCal = Calendar.getInstance();
        int totalDataAtual = Integer.valueOf(anoAtualStr + mesAtualStr + diaAtualStr);

        if (entity.getAvailableDate() == null) {
            dataBancoCal.setTime(new java.util.Date(System.currentTimeMillis()));
        } else {
            dataBancoCal.setTime(entity.getAvailableDate());
        }
        //dataBancoCal.setTime(entity.getAvailableDate());
        String diaBancoStr = String.format("%02d", dataBancoCal.get(Calendar.DAY_OF_MONTH));
        String mesBancoStr = String.format("%02d", dataBancoCal.get(Calendar.MONTH));
        String anoBancoStr = String.format("%04d", dataBancoCal.get(Calendar.YEAR));
        int totalDataBanco = Integer.valueOf(anoBancoStr + mesBancoStr + diaBancoStr);

        numDias = totalDataAtual - totalDataBanco;
        if (numDias > 10) {
            condicao = true;
        }
        return condicao;
    }

    private void produtoShop(PsProduct pp, Produto proCplus) {
        List<PsProductShop> listPPS = new QueryPrestaShop().listPsProductShop(pp.getIdProduct(), 1);
        if (listPPS.isEmpty()) {
            PsProductShop pps = new PsProductShop();
            pps.setPsProductShopPK(new PsProductShopPK(pp.getIdProduct(), 1));
            pps.setIdCategoryDefault(categoriaPadrao( proCplus));
            pps.setIdTaxRulesGroup(taxRulesGroup(proCplus));
            pps.setOnSale(false);
            pps.setLowStockThreshold(EstoqueMinimoCplus(proCplus));
            //pps.setOnlineOnly(false);
            pps.setEcotax(BigDecimal.ZERO);
            pps.setMinimalQuantity(1);
            pps.setLowStockThreshold(0);
            pps.setLowStockAlert(true);
            pps.setPrice(precoPrincipal( proCplus));
            pps.setWholesalePrice(proCplus.getCustoreal());
            pps.setUnity("");
            pps.setUnitPriceRatio(BigDecimal.ZERO);
            pps.setAdditionalShippingCost(BigDecimal.ZERO);
            pps.setCustomizable((short) 0);
            pps.setUploadableFiles((short) 0);
            pps.setTextFields((short) 0);
            if (produtoAtivo(proCplus) && quanEstoqeuCplus(proCplus) > 0) {
                pps.setActive(true);
                pps.setIndexed(true);
            } else {
                pps.setActive(false);
                pps.setIndexed(false);
            }
            pps.setRedirectType("301-category");
            pps.setIdTypeRedirected(0);
            //pps.setAvailableForOrder(true);
            pps.setAvailableDate(null);
            pps.setShowCondition(false);
            pps.setCondition("new");
            //pps.setShowPrice(true);
            if ("116".equals(proCplus.getCodsec().getClassificacao()) || fatorConversao(proCplus) > 1) {
                pps.setShowPrice(false);
                //pps.setIndexed(false);
                pps.setVisibility("none");
                pps.setOnlineOnly(true);
                pps.setAvailableForOrder(false);
            } else {
                //pps.setIndexed(pps.getActive());
                pps.setVisibility("both");
                pps.setShowPrice(true);
                pps.setOnlineOnly(false);
                pps.setAvailableForOrder(true);
            }
            pps.setIndexed(pps.getActive());
            //pps.setVisibility("both");
            pps.setCacheDefaultAttribute(0);
            pps.setAdvancedStockManagement(false);
            pps.setDateAdd(new Date(System.currentTimeMillis()));
            pps.setDateUpd(new Date(System.currentTimeMillis()));
            pps.setPackStockType(3);
            try {
                new PsProductShopJpaController(Manager.getManagerPrestaShop()).create(pps);
            } catch (Exception ex) {
                criaLog("Houve um erro ao editar PsProductShop ex. " + ex, "ERRO EDITAR");
            }
        } else {
            for (PsProductShop pps : listPPS) {
                pps.setIdCategoryDefault(categoriaPadrao( proCplus));
                pps.setIdTaxRulesGroup(taxRulesGroup( proCplus));
                pps.setLowStockThreshold(EstoqueMinimoCplus(proCplus));
                if (pps.getOnSale() == false && emPromocao(pps, proCplus)) {
                    pps.setOnSale(true);
                    pps.setAvailableDate(new Date(System.currentTimeMillis()));
                } else if (pps.getOnSale() && tirarPrecoPromocao(pps)) {
                    pps.setOnSale(false);
                }
                if (pps.getOnSale()) {
                    promo = true;
                } else {
                    promo = false;
                }
                pps.setPrice(precoPrincipal(proCplus));
                if (produtoAtivo(proCplus) && quanEstoqeuCplus(proCplus) > 0) {
                    pps.setActive(true);
                    pps.setIndexed(true);
                } else {
                    /////////////////////////////////////////////////////////////////////////////////////////////
                    if (sobEncomendaAtivo(proCplus)) {
                        pps.setActive(true);
                        pps.setIndexed(true);
                    } else {
                        pps.setActive(false);
                        pps.setIndexed(false);
                    }
                }
               
                if ("116".equals(proCplus.getCodsec().getClassificacao()) || fatorConversao(proCplus) > 1) {
                    pps.setShowPrice(false);
                    pps.setIndexed(false);
                    pps.setVisibility("none");
                    pps.setOnlineOnly(true);
                    pps.setAvailableForOrder(false);
                } else {
                    //pps.setIndexed(pps.getActive());
                    pps.setVisibility("both");
                    pps.setShowPrice(true);
                    pps.setOnlineOnly(false);
                    pps.setAvailableForOrder(true);
                }
                pps.setCacheDefaultAttribute(0);
                pps.setAdvancedStockManagement(false);
                if (quanEstoquePrestaShop( pp) == 0 && quanEstoqeuCplus( proCplus) > 0) {
                    pps.setDateAdd(new Date(System.currentTimeMillis()));
                    pps.setDateUpd(new Date(System.currentTimeMillis()));
                }
                pps.setWholesalePrice(proCplus.getCustoreal());
                try {
                    new PsProductShopJpaController(Manager.getManagerPrestaShop()).edit(pps);
                } catch (Exception ex) {
                    criaLog( "Houve um erro ao editar PsProductShop ex. " + ex, "ERRO EDITAR");
                }
            }
        }
    }

    private void produtoStockAvailable(PsProduct pp, Produto proCplus) {
        List<PsStockAvailable> listPSSA = new QueryPrestaShop().listPsStockAvailable(pp.getIdProduct(), 1);
        if (listPSSA.isEmpty()) {
            PsStockAvailable psSA = new PsStockAvailable();
            psSA.setIdProduct(pp.getIdProduct());
            psSA.setIdProductAttribute(0);
            psSA.setIdShop(1);
            psSA.setIdShopGroup(0);
            psSA.setQuantity(quanEstoqeuCplus(proCplus));
            psSA.setPhysicalQuantity(quanEstoqeuCplus(proCplus));
            psSA.setReservedQuantity(0);
            psSA.setDependsOnStock(false);
            psSA.setOutOfStock(false);
            psSA.setLocation("");
            new PsStockAvailableJpaController(Manager.getManagerPrestaShop()).create(psSA);
        } else {
            for (PsStockAvailable psSA : listPSSA) {
                psSA.setIdProduct(pp.getIdProduct());
                psSA.setIdProductAttribute(0);
                psSA.setIdShop(1);
                psSA.setIdShopGroup(0);
                int reservaPrestaShop = reservaPrestaShop(pp);
                int quantidadeCplus = quanEstoqeuCplus(proCplus);
               
                psSA.setReservedQuantity(reservaPrestaShop);
                //psSA.setQuantity(EstoqueCplusMenosReservaSite(managerCplus, managerPrestaShop, proCplus, pp));
                psSA.setQuantity(quantidadeCplus - reservaPrestaShop);
                psSA.setPhysicalQuantity(quantidadeCplus);
                psSA.setDependsOnStock(false);
                psSA.setOutOfStock(false);
                try {
                    new PsStockAvailableJpaController(Manager.getManagerPrestaShop()).edit(psSA);
                } catch (Exception ex) {
                    criaLog("Houve um erro ao editar PsStockAvailable ex. " + ex, "ERRO EDITAR");
                }
            }
        }
    }

    private Integer reservaPrestaShop(PsProduct pp) {
        int quantReserved = 0;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(10);
        List<PsOrders> listPsOrders = new QueryPrestaShop().listPsOrdersState(list);
        for (PsOrders order : listPsOrders) {
            List<Movenda> listMovenda = new QueryCplus().resultMovendaPorEntregaTelefone(order.getReference());
            if (listMovenda.isEmpty()) {
                for (PsOrderDetail prodDetail : new QueryPrestaShop().listOrderDetail(order.getIdOrder())) {
                    if (prodDetail.getProductId() == pp.getIdProduct()) {
                        quantReserved = quantReserved + prodDetail.getProductQuantity();
                    }
                }
            }
        }
        return quantReserved;
    }

    private void produtoRelacionado(PsProductLang ppl, PsProduct pp) {
        String[] listNome = ppl.getName().split(" ");
        int cont = 0;
        Connection conn = new ConexaoPrestaShop().getConnection();
        for (PsProductLang prod : new QueryPrestaShop().listPsProductLang(listNome[0])) {
            if (ppl.getPsProductLangPK().getIdProduct() != prod.getPsProductLangPK().getIdProduct()) {
                if (quanEstoquePrestaShop( new PsProductJpaController(Manager.getManagerPrestaShop()).findPsProduct(prod.getPsProductLangPK().getIdProduct())) > 0) {
                    List<PsAccessory> listAcessory = new ConexaoPrestaShop().listPsAcessory(conn, ppl.getPsProductLangPK().getIdProduct(), prod.getPsProductLangPK().getIdProduct());
                    if (listAcessory.isEmpty()) {
                        if (cont < 10) {
                            new ConexaoPrestaShop().criaPsAccessory(conn, ppl.getPsProductLangPK().getIdProduct(), prod.getPsProductLangPK().getIdProduct());
                        }
                    }
                    cont++;
                }
            }
        }
        new ConexaoPrestaShop().closeConnection();
    }

    private boolean sobEncomendaAtivo(Produto proCplus) {
        List<ProdFornecedor> listFor = new QueryIntegrador().listProdFornecedor(proCplus.getCodprod());
        boolean condicao = false;
        for (ProdFornecedor pro : listFor) {
            if (pro.getAtivo() == 1 && pro.getDisponivel() == 1) {
                // Se for usar encomenda condicao = true;
            }
        }
        return condicao;
    }
}
