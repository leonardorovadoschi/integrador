/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package produto;

import acesso.ConexaoPrestaShop;
import entidade.cplus.Calculoicmsestado;
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
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManagerFactory;
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
     * Fun√ß√£o encarregada de verificar se o produto ser√° criado ou atualizado
     *
     * @param managerIntegrador
     * @param managerCplus
     * @param managerPrestaShop
     * @param proCplus
     * @return
     */
    public boolean produtoCplusDigimacro(EntityManagerFactory managerIntegrador, EntityManagerFactory managerCplus, EntityManagerFactory managerPrestaShop, Produto proCplus) {
        boolean condicao = true;
        promo = false;
        List<PsProduct> listProdSite = new QueryPrestaShop(managerPrestaShop).listagemProdutoSite(proCplus.getCodprod());
        // List<PsProduct> listProdSite = new QueryPrestaShop(managerPrestaShop).listagemProdutoSite("000001942");
        switch (listProdSite.size()) {
            case 0:
                criarProdutoDigimacro(managerIntegrador, managerCplus, managerPrestaShop, proCplus);
                if (fatorConversao(proCplus, managerCplus) > 1) {
                    new PackProduto().produtoCplusDigimacro(managerIntegrador, managerCplus, managerPrestaShop, proCplus);
                }
                break;
            case 1:
                for (PsProduct pp : listProdSite) {
                    editaProdutoDigimacro(managerCplus, managerIntegrador, managerPrestaShop, proCplus, pp);
                    if (fatorConversao(proCplus, managerCplus) > 1) {
                        new PackProduto().produtoCplusDigimacro(managerIntegrador, managerCplus, managerPrestaShop, proCplus);
                    }
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

    public boolean produtoCplusDigimacroEstoque(EntityManagerFactory managerIntegrador, EntityManagerFactory managerCplus, EntityManagerFactory managerPrestaShop, Produto proCplus) {
        boolean condicao = true;
        promo = false;
        List<PsProduct> listProdSite = new QueryPrestaShop(managerPrestaShop).listagemProdutoSite(proCplus.getCodprod());
        if (listProdSite.size() == 1) {
            for (PsProduct pp : listProdSite) {
                editaProdutoDigimacro(managerCplus, managerIntegrador, managerPrestaShop, proCplus, pp);
                if (fatorConversao(proCplus, managerCplus) > 1) {
                    new PackProduto().produtoCplusDigimacro(managerIntegrador, managerCplus, managerPrestaShop, proCplus);
                }
            }
        } else if (listProdSite.size() > 1) {
            String log = "A pesquisa achou mais que um produto no site com a mesma referencia \n VERIFIQUE \n";
            for (PsProduct pp : listProdSite) {
                log = log + pp.getReference() + "\n";
            }
            criaLog(managerIntegrador, log, "ERRO PRODUTO");
        }
        return condicao;
    }

    /**
     * Fun√ß√£o que cria um produto no prestaShop
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
        pp1.setLowStockThreshold(0);
        pp1.setLowStockAlert(true);
        pp1.setPrice(precoPrincipal(managerCplus, proCplus));
        //pp1.setWholesalePrice(proCplus.getCustoreal());
        pp1.setWholesalePrice(BigDecimal.ZERO);
        pp1.setUnity("");
        pp1.setUnitPriceRatio(BigDecimal.ZERO);
        pp1.setAdditionalShippingCost(BigDecimal.ZERO);
        pp1.setReference(proCplus.getCodprod()); //liga√ß√£o c-plus
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
        if (produtoAtivo(proCplus) && quanEstoqeuCplus(managerCplus, proCplus) > 0) {
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
        if ("116".equals(proCplus.getCodsec().getClassificacao())) {
            pp1.setIndexed(false);
            pp1.setVisibility("none");
        } else {
            // pp1.setIndexed(true);
            pp1.setVisibility("both");
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

        new PsProductJpaController(managerPrestaShop).create(pp1);

        List<PsProduct> listProdSite = new QueryPrestaShop(managerPrestaShop).listagemProdutoSite(proCplus.getCodprod());
        for (PsProduct pp : listProdSite) {
            produtoLang(pp, proCplus, managerPrestaShop, managerIntegrador, managerCplus);
            produtoShop(pp, proCplus, managerPrestaShop, managerIntegrador, managerCplus);
            produtoStockAvailable(pp, proCplus, managerPrestaShop, managerIntegrador, managerCplus);
            try {
                if (fatorConversao(proCplus, managerCplus) == 1) {
                    precoQuntidade(proCplus, pp, managerPrestaShop, managerIntegrador, managerCplus);
                    gerenciaTags(managerPrestaShop, managerIntegrador, proCplus, pp);
                    categoriaProduto(promo, pp, proCplus, managerPrestaShop, managerIntegrador);                    
                }else{
                    categoriaProdutoPack(pp, proCplus, managerPrestaShop, managerIntegrador);
                }
                produtoTransportadora(pp, managerPrestaShop, managerIntegrador);
            } catch (Exception ex) {
                criaLog(managerIntegrador, "Houve um erro ao criar PsProductLang ex. " + ex, "ERRO CRIAR");
            }
        }
        return condicao;
    }

    private String linkRewrite(Produto prod) {
        String valor = "";
        if (prod.getNomeprodweb() == null || "".equals(prod.getNomeprodweb())) {
            JOptionPane.showMessageDialog(null, "Houve um erro na execuÁ„o automatica! \n" + prod.getNomeprod());
        } else {
            valor = prod.getNomeprodweb().toLowerCase();
            valor = valor.trim();
            //valor = Normalizer.normalize(valor, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");//remover acentuaÁ„o     
            valor = valor.replaceAll("[^a-zA-Z1-9 ]", "");//remover todos caracteres especiais e letras maiusculas
            valor = valor.replace(" ", "-").toLowerCase();
            valor = valor.replaceAll("\\--", "-");
            valor = valor.replaceAll("\\---", "-");
        }
        return valor;
    }

    /**
     * FunÁ„o para editar produto no site
     *
     * @param managerIntegrador
     * @param managerPrestaShop
     * @param proCplus
     * @param pp produto prestaShop
     */
    private void editaProdutoDigimacro(EntityManagerFactory managerCplus, EntityManagerFactory managerIntegrador, EntityManagerFactory managerPrestaShop, Produto proCplus, PsProduct pp) {
        pp.setIdManufacturer(marcaFabricante(managerPrestaShop, managerIntegrador, proCplus));
        pp.setIdCategoryDefault(categoriaPadrao(managerPrestaShop, proCplus));
        pp.setIdTaxRulesGroup(taxRulesGroup(managerPrestaShop, proCplus));
        pp.setEan13(eanCplus(managerCplus, proCplus));
        pp.setPrice(precoPrincipal(managerCplus, proCplus));
        pp.setReference(proCplus.getCodprod());
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
        if (produtoAtivo(proCplus) && quanEstoqeuCplus(managerCplus, proCplus) > 0) {
            pp.setActive(true);
            pp.setIndexed(true);
        } else {
            ///////////////////////////////////////////////////////////////
            if (sobEncomendaAtivo(managerIntegrador, proCplus)) {
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
        pp.setShowPrice(true);
        if (fatorConversao(proCplus, managerCplus) > 1) {
            pp.setVisibility("none");
        } else {
            pp.setVisibility("both");
        }
        pp.setDateUpd(new Date(System.currentTimeMillis()));
        //pp.setWholesalePrice(proCplus.getCustoreal());
        pp.setWholesalePrice(BigDecimal.ZERO);
        try {
            new PsProductJpaController(managerPrestaShop).edit(pp);
            produtoLang(pp, proCplus, managerPrestaShop, managerIntegrador, managerCplus);
            produtoShop(pp, proCplus, managerPrestaShop, managerIntegrador, managerCplus);
            produtoStockAvailable(pp, proCplus, managerPrestaShop, managerIntegrador, managerCplus);
            if (fatorConversao(proCplus, managerCplus) == 1) {
                precoQuntidade(proCplus, pp, managerPrestaShop, managerIntegrador, managerCplus);
                gerenciaTags(managerPrestaShop, managerIntegrador, proCplus, pp);
                categoriaProduto(promo, pp, proCplus, managerPrestaShop, managerIntegrador);
            }else{
                categoriaProdutoPack(pp, proCplus, managerPrestaShop, managerIntegrador);
            }
            //categoriaProduto(promo, pp, proCplus, managerPrestaShop, managerIntegrador);
            produtoTransportadora(pp, managerPrestaShop, managerIntegrador);
        } catch (Exception ex) {
            criaLog(managerIntegrador, "Houve um erro ao criar PsProductLang ex. " + ex, "ERRO EDITAR");
        }
    }

    private void produtoLang(PsProduct pp, Produto proCplus, EntityManagerFactory managerPrestaShop, EntityManagerFactory managerIntegrador, EntityManagerFactory managerCplus) {
        List<PsProductLang> listPPL = new QueryPrestaShop(managerPrestaShop).listPsProductLang(pp.getIdProduct(), 2);
        if (listPPL.isEmpty()) {
            PsProductLang ppl = new PsProductLang();
            ppl.setPsProductLangPK(new PsProductLangPK(pp.getIdProduct(), 1, 2));
            ppl.setDescription(observacao(proCplus, managerCplus));
            ppl.setDescriptionShort(tamanhoString(proCplus.getAplicacao(), 799));
            ppl.setLinkRewrite(linkRewrite(proCplus));
            ppl.setMetaDescription(tamanhoString(metaDescription(proCplus), 160));
            //ppl.setMetaDescription("");
            ppl.setMetaKeywords("");
            ppl.setMetaTitle(linkRewrite(proCplus));
            ppl.setName(proCplus.getNomeprodweb());
            ppl.setAvailableNow("DisponÌel");
            ppl.setAvailableLater("Sem Estoque");
            ppl.setDeliveryInStock("Entrega Imediata");
            ppl.setDeliveryOutStock("Sem Previs„o");
            try {
                new PsProductLangJpaController(managerPrestaShop).create(ppl);
            } catch (Exception ex) {
                criaLog(managerIntegrador, "Houve um erro ao criar PsProductLang ex. " + ex, "ERRO CRIAR");
            }
        } else {
            for (PsProductLang ppl : listPPL) {
                //ppl.setPsProductLangPK(new PsProductLangPK(pp.getIdProduct(), 1, 2));
                ppl.setDescription(observacao(proCplus, managerCplus));
                ppl.setDescriptionShort(tamanhoString(proCplus.getAplicacao(), 799));
                ppl.setLinkRewrite(linkRewrite(proCplus));
                ppl.setMetaDescription(tamanhoString(metaDescription(proCplus), 160));
                // ppl.setMetaDescription("");
                ppl.setMetaKeywords("");
                ppl.setMetaTitle(linkRewrite(proCplus));
                ppl.setName(proCplus.getNomeprodweb());
                ppl.setAvailableNow("DisponÌvel");
                ppl.setAvailableLater("Sem Estoque");
                ppl.setDeliveryInStock("Entrega Imediata");
                ppl.setDeliveryOutStock("Sem Previs„o");
                try {
                    new PsProductLangJpaController(managerPrestaShop).edit(ppl);
                    //////////////////////
                    produtoRelacionado(managerPrestaShop, ppl, pp);
                } catch (Exception ex) {
                    criaLog(managerIntegrador, "Houve um erro ao editar PsProductLang Produto: " + ppl.getName() + " ex. " + ex, "ERRO EDITAR");
                }
            }
        }
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

    /**
     * Fun√ß√£o que relaciona o calculo do icms do Cplus para o site
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

    private boolean taxaProdutosICMSDfifenciada(EntityManagerFactory managerCplus, EntityManagerFactory managerPrestaShop, Produto pro) {
        List<PsTaxRulesGroup> listT = new QueryPrestaShop(managerPrestaShop).listPorNomeCalculoIcms(pro.getCodcalculoicms().getNomecalculoicms());
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
     * FunÁ„o para gravar Logs no banco do integrador
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
     * FunÁ„o para retornar uma String EAN
     *
     * @param managerCplus
     * @param proCplus
     * @return
     */
    private String eanCplus(EntityManagerFactory managerCplus, Produto proCplus) {
        String tex = "";
        List<Produtocodigo> listPrdCod = new QueryCplus(managerCplus).resultEanProduto(proCplus.getCodprod());
        for (Produtocodigo pc : listPrdCod) {
            if (pc.getCodigo().length() < 14) {
                tex = pc.getCodigo();
            }
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
            preco = pr.getPreco().multiply(new BigDecimal("1.11"));
        }
        return preco.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    private BigDecimal precoPrincipalDiferenciado(EntityManagerFactory managerCplus, Produto proCplus) {
        BigDecimal preco = BigDecimal.ZERO;
        List<Produtopreco> listPreco = new QueryCplus(managerCplus).listPrecos(proCplus.getCodprod(), "000000001");
        for (Produtopreco pr : listPreco) {
            preco = pr.getPreco().multiply(new BigDecimal("1.18"));
        }
        return preco.setScale(2, BigDecimal.ROUND_HALF_UP);
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

    private Integer quanEstoquePrestaShop(EntityManagerFactory managerPrestaShop, PsProduct proPrestaShop) {
        //Integer estoque = 0;
        int stock = 0;
        //  List<PsStockAvailable> listEsroque = new QueryPrestaShop(managerPrestaShop).listEstoqueProduto(proPrestaShop.getIdProduct());
        for (PsStockAvailable est : new QueryPrestaShop(managerPrestaShop).listEstoqueProduto(proPrestaShop.getIdProduct())) {
            stock = est.getPhysicalQuantity();
        }

        return stock;
    }

    private Integer quanEstoqeuCplus(EntityManagerFactory managerCplus, Produto proCplus) {
        BigDecimal estoque = BigDecimal.ZERO;
        int stock;
        List<Produtoestoque> listEsroque = new QueryCplus(managerCplus).listTodosEstoques(proCplus.getCodprod());
        for (Produtoestoque est : listEsroque) {
            estoque = est.getEstatu().subtract(est.getReservadoorcamento().subtract(est.getReservadoos()));
        }
        stock = estoque.intValue();
        return stock;
    }

    /**
     * Fun√ß√£o que verifica as reservas dos pedidos no c-plus e no site
     *
     * @param verificaLegiao
     * @param produto
     * @return BigDecimal
     */
    private Integer EstoqueCplusMenosReservaSit(EntityManagerFactory managerCplus, EntityManagerFactory managerPrestaShop, Produto proCplus, PsProduct prodPrestaShop) {
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
        stock = estoque.intValue() - reservaSite;
        return stock;
    }

    private void precoQuntidade(Produto pro, PsProduct pp, EntityManagerFactory managerPrestaShop, EntityManagerFactory managerIntegrador, EntityManagerFactory managerCplus) {
        precoQuantidadeJuridica(pp, managerPrestaShop, managerIntegrador);
        precoQuantidadeJuridicaDiferenciada(pro, pp, managerPrestaShop, managerIntegrador, managerCplus);

    }

    private void precoQuantidadeJuridicaDiferenciada(Produto pro, PsProduct pp, EntityManagerFactory managerPrestaShop, EntityManagerFactory managerIntegrador, EntityManagerFactory managerCplus) {
        /*
        BigDecimal precoDiferenciado = precoPrincipalDiferenciado(managerCplus, pro);
        if (taxaProdutosICMSDfifenciada(managerCplus, managerPrestaShop, pro)) {
            List<PsSpecificPrice> listPSSPdif = new QueryPrestaShop(managerPrestaShop).listPsSpecificPrice(pp.getIdProduct(), "amount", 7);
            if (listPSSPdif.isEmpty()) {
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
                //
                List<Calculoicmsestado> listCalculoIcmsEstado = new QueryCplus(managerCplus).listcalculoIcmsEstadol("RS", "RS", "5102", pro.getCodcalculoicms().getCodcalculoicms());
                psSP.setPrice(precoDiferenciado);
                for (Calculoicmsestado cst : listCalculoIcmsEstado) {
                    if ("20".equals(cst.getCodsituacaotributariadif())) {
                        psSP.setPrice(precoPrincipal(managerCplus, pro));
                    }
                }

                // psSP.setPrice(precoPrincipalDiferenciado(managerCplus, pro));
                //
                psSP.setFromQuantity(1);
                psSP.setReduction(BigDecimal.ZERO);
                psSP.setReductionTax(true);
                psSP.setReductionType("amount");
                psSP.setFrom(new Date(System.currentTimeMillis()));
                psSP.setTo(new FormataCampos().alteraDiaData(new Date(System.currentTimeMillis()), 360));
                new PsSpecificPriceJpaController(managerPrestaShop).create(psSP);
            } else if (listPSSPdif.size() == 1) {
                for (PsSpecificPrice psSP : listPSSPdif) {
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
                    //
                    List<Calculoicmsestado> listCalculoIcmsEstado = new QueryCplus(managerCplus).listcalculoIcmsEstadol("RS", "RS", "5102", pro.getCodcalculoicms().getCodcalculoicms());
                    psSP.setPrice(precoDiferenciado);
                    for (Calculoicmsestado cst : listCalculoIcmsEstado) {
                        if ("20".equals(cst.getCodsituacaotributariadif())) {
                            psSP.setPrice(precoPrincipal(managerCplus, pro));
                        }
                    }
                    //
                    // psSP.setFromQuantity(1);
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
            }
        }
        */
        
        List<BigDecimal> listBigDecimal = new ArrayList<>();
        listBigDecimal.add(new BigDecimal("0.5"));
        listBigDecimal.add(new BigDecimal("1.0"));
        listBigDecimal.add(new BigDecimal("2.0"));
        listBigDecimal.add(new BigDecimal("3.0"));
        for (BigDecimal bd : listBigDecimal) {
            //PsSpecificPrice psSP = new PsSpecificPrice();
            List<PsSpecificPrice> listPSSP = new QueryPrestaShop(managerPrestaShop).listPsSpecificPrice(pp.getIdProduct(), bd.divide(new BigDecimal("100.0"), 7 ,BigDecimal.ROUND_HALF_UP), 7);
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
                psSP.setReduction(bd.divide(new BigDecimal("100.0"), 7 ,BigDecimal.ROUND_HALF_UP));
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
        }
    }

    private void precoQuantidadeJuridica(PsProduct pp, EntityManagerFactory managerPrestaShop, EntityManagerFactory managerIntegrador) {
        List<BigDecimal> listBigDecimal = new ArrayList<>();
        listBigDecimal.add(new BigDecimal("0.5"));
        listBigDecimal.add(new BigDecimal("1.0"));
        listBigDecimal.add(new BigDecimal("2.0"));
        listBigDecimal.add(new BigDecimal("3.0"));
        for (BigDecimal bd : listBigDecimal) {
            //PsSpecificPrice psSP = new PsSpecificPrice();
            List<PsSpecificPrice> listPSSP = new QueryPrestaShop(managerPrestaShop).listPsSpecificPrice(pp.getIdProduct(), bd.divide(new BigDecimal("100.0"), 4 ,BigDecimal.ROUND_HALF_UP), 4);
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
                psSP.setReduction(bd.divide(new BigDecimal("100.0"), 4 ,BigDecimal.ROUND_HALF_UP));
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
    
    private void categoriaProdutoPack(PsProduct pp, Produto proCplus, EntityManagerFactory managerPrestaShop, EntityManagerFactory managerIntegrador) {
        //String[] listSecaoIntegrador = proCplus.getCodsec().getClassificacao().split("\\.");
        String[] listSecaoIntegrador = "116".split("\\.");
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

    private Integer fatorConversao(Produto prodCplus, EntityManagerFactory managerCplus) {
        Integer quantidade = 1;
        for (Unidade un : new QueryCplus(managerCplus).resultPorUnidadeProduto(prodCplus.getUnidade())) {
            if (un.getFatorconversao().intValue() > 1) {
                quantidade = un.getFatorconversao().intValue();
            }
        }
        return quantidade;
    }

    private void gerenciaTags(EntityManagerFactory managerPrestaShop, EntityManagerFactory managerIntegrador, Produto proCplus, PsProduct pp) {
        String nomeProduto = proCplus.getNomeprodweb().trim().toLowerCase();
        nomeProduto = nomeProduto.replace("\"", "");
        nomeProduto = nomeProduto.replace("/", "");
        nomeProduto = nomeProduto.replace("+", "");
        nomeProduto = nomeProduto.replace(",", "");
        nomeProduto = nomeProduto.replace("$", "");
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
        String nomeFabricante = proCplus.getCodfabricante().getNomefabricante();
        if (nomeFabricante != null && !"".equals(nomeFabricante)) {
            List<PsManufacturer> listPM = new QueryPrestaShop(managerPrestaShop).listManufacturer(nomeFabricante);
            if (listPM.isEmpty()) {
                PsManufacturer psM = new PsManufacturer();
                psM.setName(nomeFabricante);
                psM.setDateAdd(new Date(System.currentTimeMillis()));
                psM.setDateUpd(new Date(System.currentTimeMillis()));
                psM.setActive(true);
                new PsManufacturerJpaController(managerPrestaShop).create(psM);
                listPM = new QueryPrestaShop(managerPrestaShop).listManufacturer(nomeFabricante);
            }
            for (PsManufacturer pM : listPM) {
                idManuf = pM.getIdManufacturer();
                pM.setName(nomeFabricante);
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
        } 
        return idManuf;
    }

    private void produtoTransportadora(PsProduct pp, EntityManagerFactory managerPrestaShop, EntityManagerFactory managerIntegrador) {
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

    private boolean emPromocao(PsProductShop pp, Produto proCplus, EntityManagerFactory managerCplus) {
        boolean condicao = false;
        double precoCplus = precoPrincipal(managerCplus, proCplus).doubleValue();
        double precoPrestaShop = pp.getPrice().setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
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

    private void produtoShop(PsProduct pp, Produto proCplus, EntityManagerFactory managerPrestaShop, EntityManagerFactory managerIntegrador, EntityManagerFactory managerCplus) {
        List<PsProductShop> listPPS = new QueryPrestaShop(managerPrestaShop).listPsProductShop(pp.getIdProduct(), 1);
        if (listPPS.isEmpty()) {
            PsProductShop pps = new PsProductShop();
            pps.setPsProductShopPK(new PsProductShopPK(pp.getIdProduct(), 1));
            pps.setIdCategoryDefault(categoriaPadrao(managerPrestaShop, proCplus));
            pps.setIdTaxRulesGroup(taxRulesGroup(managerPrestaShop, proCplus));
            pps.setOnSale(false);
            pps.setOnlineOnly(false);
            pps.setEcotax(BigDecimal.ZERO);
            pps.setMinimalQuantity(1);
            pps.setLowStockThreshold(0);
            pps.setLowStockAlert(true);
            pps.setPrice(precoPrincipal(managerCplus, proCplus));
            pps.setWholesalePrice(proCplus.getCustoreal());
            pps.setUnity("");
            pps.setUnitPriceRatio(BigDecimal.ZERO);
            pps.setAdditionalShippingCost(BigDecimal.ZERO);
            pps.setCustomizable((short) 0);
            pps.setUploadableFiles((short) 0);
            pps.setTextFields((short) 0);
            if (produtoAtivo(proCplus) && quanEstoqeuCplus(managerCplus, proCplus) > 0) {
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
            if ("116".equals(proCplus.getCodsec().getClassificacao())) {
                pps.setIndexed(false);
                pps.setVisibility("none");
            } else {
                // pps.setIndexed(pps.getActive());
                pps.setVisibility("both");
            }
            pps.setIndexed(pps.getActive());
            pps.setVisibility("both");
            pps.setCacheDefaultAttribute(0);
            pps.setAdvancedStockManagement(false);
            pps.setDateAdd(new Date(System.currentTimeMillis()));
            pps.setDateUpd(new Date(System.currentTimeMillis()));
            pps.setPackStockType(3);
            try {
                new PsProductShopJpaController(managerPrestaShop).create(pps);
            } catch (Exception ex) {
                criaLog(managerIntegrador, "Houve um erro ao editar PsProductShop ex. " + ex, "ERRO EDITAR");
            }
        } else {
            for (PsProductShop pps : listPPS) {
                pps.setIdCategoryDefault(categoriaPadrao(managerPrestaShop, proCplus));
                pps.setIdTaxRulesGroup(taxRulesGroup(managerPrestaShop, proCplus));
                if (pps.getOnSale() == false && emPromocao(pps, proCplus, managerCplus)) {
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
                pps.setPrice(precoPrincipal(managerCplus, proCplus));
                if (produtoAtivo(proCplus) && quanEstoqeuCplus(managerCplus, proCplus) > 0) {
                    pps.setActive(true);
                    pps.setIndexed(true);
                } else {
                    /////////////////////////////////////////////////////////////////////////////////////////////
                    if (sobEncomendaAtivo(managerIntegrador, proCplus)) {
                        pps.setActive(true);
                        pps.setIndexed(true);
                    } else {
                        pps.setActive(false);
                        pps.setIndexed(false);
                    }
                }
                if (fatorConversao(proCplus, managerCplus) > 1) {
                    pps.setIndexed(false);
                    pps.setVisibility("none");
                } else {
                    //pps.setIndexed(pps.getActive());
                    pps.setVisibility("both");
                }
                pps.setCacheDefaultAttribute(0);
                pps.setAdvancedStockManagement(false);
                if (quanEstoquePrestaShop(managerPrestaShop, pp) == 0 && quanEstoqeuCplus(managerCplus, proCplus) > 0) {
                    pps.setDateAdd(new Date(System.currentTimeMillis()));
                    pps.setDateUpd(new Date(System.currentTimeMillis()));
                }
                pps.setWholesalePrice(proCplus.getCustoreal());
                try {
                    new PsProductShopJpaController(managerPrestaShop).edit(pps);
                } catch (Exception ex) {
                    criaLog(managerIntegrador, "Houve um erro ao editar PsProductShop ex. " + ex, "ERRO EDITAR");
                }
            }
        }
    }

    private void produtoStockAvailable(PsProduct pp, Produto proCplus, EntityManagerFactory managerPrestaShop, EntityManagerFactory managerIntegrador, EntityManagerFactory managerCplus) {
        List<PsStockAvailable> listPSSA = new QueryPrestaShop(managerPrestaShop).listPsStockAvailable(pp.getIdProduct(), 1);
        if (listPSSA.isEmpty()) {
            PsStockAvailable psSA = new PsStockAvailable();
            psSA.setIdProduct(pp.getIdProduct());
            psSA.setIdProductAttribute(0);
            psSA.setIdShop(1);
            psSA.setIdShopGroup(0);
            psSA.setQuantity(quanEstoqeuCplus(managerCplus, proCplus));
            psSA.setPhysicalQuantity(quanEstoqeuCplus(managerCplus, proCplus));
            psSA.setReservedQuantity(0);
            psSA.setDependsOnStock(false);
            psSA.setOutOfStock(false);
            psSA.setLocation("");
            new PsStockAvailableJpaController(managerPrestaShop).create(psSA);
        } else {
            for (PsStockAvailable psSA : listPSSA) {
                psSA.setIdProduct(pp.getIdProduct());
                psSA.setIdProductAttribute(0);
                psSA.setIdShop(1);
                psSA.setIdShopGroup(0);
                int reservaPrestaShop = reservaPrestaShop(managerCplus, managerPrestaShop, pp);
                int quantidadeCplus = quanEstoqeuCplus(managerCplus, proCplus);
                // if (psSA.getQuantity() < 1 && quantidadeCplus > 0) {
                //    for (PsProductLang lang : new QueryPrestaShop(managerPrestaShop).listPsProductLang(pp.getIdProduct(), 2)) {
                //       criaLog(managerIntegrador, "O produto: " + lang.getName() + " Terminou!", "ERRO COMPRAR");
                //     }
                //  }
                psSA.setReservedQuantity(reservaPrestaShop);
                //psSA.setQuantity(EstoqueCplusMenosReservaSite(managerCplus, managerPrestaShop, proCplus, pp));
                psSA.setQuantity(quantidadeCplus - reservaPrestaShop);
                psSA.setPhysicalQuantity(quantidadeCplus);
                psSA.setDependsOnStock(false);
                psSA.setOutOfStock(false);
                try {
                    new PsStockAvailableJpaController(managerPrestaShop).edit(psSA);
                } catch (Exception ex) {
                    criaLog(managerIntegrador, "Houve um erro ao editar PsStockAvailable ex. " + ex, "ERRO EDITAR");
                }
            }
        }
    }

    private Integer reservaPrestaShop(EntityManagerFactory managerCplus, EntityManagerFactory managerPrestaShop, PsProduct pp) {
        int quantReserved = 0;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(10);
        List<PsOrders> listPsOrders = new QueryPrestaShop(managerPrestaShop).listPsOrdersState(list);
        for (PsOrders order : listPsOrders) {
            List<Movenda> listMovenda = new QueryCplus(managerCplus).resultMovendaPorEntregaTelefone(order.getReference());
            if (listMovenda.isEmpty()) {
                for (PsOrderDetail prodDetail : new QueryPrestaShop(managerPrestaShop).listOrderDetail(order.getIdOrder())) {
                    if (prodDetail.getProductId() == pp.getIdProduct()) {
                        quantReserved = quantReserved + prodDetail.getProductQuantity();
                    }
                }
            }
        }
        return quantReserved;
    }

    private void produtoRelacionado(EntityManagerFactory managerPrestaShop, PsProductLang ppl, PsProduct pp) {
        String[] listNome = ppl.getName().split(" ");
        int cont = 0;
        Connection conn = new ConexaoPrestaShop().getConnection();
        for (PsProductLang prod : new QueryPrestaShop(managerPrestaShop).listPsProductLang(listNome[0])) {
            if (ppl.getPsProductLangPK().getIdProduct() != prod.getPsProductLangPK().getIdProduct()) {
                if (quanEstoquePrestaShop(managerPrestaShop, new PsProductJpaController(managerPrestaShop).findPsProduct(prod.getPsProductLangPK().getIdProduct())) > 0) {
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

    private boolean sobEncomendaAtivo(EntityManagerFactory managerIntegrador, Produto proCplus) {
        List<ProdFornecedor> listFor = new QueryIntegrador(managerIntegrador).listProdFornecedor(proCplus.getCodprod());
        boolean condicao = false;
        for (ProdFornecedor pro : listFor) {
            if (pro.getAtivo() == 1 && pro.getDisponivel() == 1) {
               // Se for usar encomenda condicao = true;
            }
        }
        return condicao;
    }
}
