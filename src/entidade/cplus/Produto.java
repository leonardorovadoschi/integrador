/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "PRODUTO", catalog = "", schema = "")

public class Produto implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    //@Column(name = "CODFABRICANTE")
    //private String codfabricante;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODPROD")
    private String codprod;
    @Column(name = "CODITEMGRADEDETALHEH")
    private String coditemgradedetalheh;
    @Column(name = "CODITEMGRADEDETALHEV")
    private String coditemgradedetalhev;
    //@Column(name = "CODFABRICANTE")
    
    @JoinColumn(name = "CODFABRICANTE", referencedColumnName = "CODFABRICANTE")
    @ManyToOne
    private Fabricante codfabricante;
    
    
    
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "CODUSER")
    private String coduser;
    @Column(name = "CODLOC")
    private String codloc;

    @Basic(optional = false)
    @Column(name = "NOMEPROD")
    private String nomeprod;
    @Lob
    @Column(name = "OBS")
    private String obs;
    @Basic(optional = false)
    @Column(name = "FLAGINATIVO")
    private Character flaginativo;
    @Column(name = "DATREAJ")
    @Temporal(TemporalType.DATE)
    private Date datreaj;
    @Column(name = "UNIDADE")
    private String unidade;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "PRECUSTO")
    private BigDecimal precusto;
    @Basic(optional = false)
    @Column(name = "CUSTOMEDIO")
    private BigDecimal customedio;
    @Column(name = "OUTROS")
    private BigDecimal outros;
    @Column(name = "CUSTOREAL")
    private BigDecimal custoreal;
    @Column(name = "LAST_CHANGE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastChange;
    @Column(name = "PESOBRUTO")
    private BigDecimal pesobruto;
    @Column(name = "PESOLIQUIDO")
    private BigDecimal pesoliquido;
    @Column(name = "COMISSAO")
    private BigDecimal comissao;
    @Column(name = "FLAGCONTROLAESTOQUE")
    private Character flagcontrolaestoque;
    @Column(name = "FLAGSERVICO")
    private Character flagservico;
    @Column(name = "FLAGNAOVENDER")
    private Character flagnaovender;
    @Column(name = "FLAGLANCACOMPOSICAO")
    private Character flaglancacomposicao;
    @Column(name = "DESCMAXIMO")
    private BigDecimal descmaximo;
    @Column(name = "FLAGVENDECOMPOSICAO")
    private Character flagvendecomposicao;
    @Column(name = "NOMEPRODCURTO")
    private String nomeprodcurto;
    @Column(name = "FLAGTIPOCOMISSAO")
    private Character flagtipocomissao;
    @Column(name = "FLAGUSACOMISSAO")
    private Character flagusacomissao;
    @Column(name = "PRAZOGARANTIA")
    private Integer prazogarantia;
    @Column(name = "PERCOUTROSCUSTOS")
    private BigDecimal percoutroscustos;
    @Column(name = "VALOUTROSCUSTOS")
    private BigDecimal valoutroscustos;
    @Column(name = "TOTOUTROSCUSTOS")
    private BigDecimal totoutroscustos;
    @Column(name = "CODIGORECEITA")
    private Integer codigoreceita;
    @Column(name = "VALIDADE")
    private Integer validade;
    @Column(name = "FLAGSOLICITACOMPLEMENTO")
    private Character flagsolicitacomplemento;
    @Column(name = "FLAGGERASERIAL")
    private Character flaggeraserial;
    @Column(name = "PRAZOENTREGA")
    private Integer prazoentrega;
    @Column(name = "PARCELAMENTOSJ")
    private Integer parcelamentosj;
    @Column(name = "PERCOUTROSCUSTOS2")
    private BigDecimal percoutroscustos2;
    @Column(name = "PERCOUTROSCUSTOS3")
    private BigDecimal percoutroscustos3;
    @Column(name = "PERCOUTROSCUSTOS4")
    private BigDecimal percoutroscustos4;
    @Column(name = "PERCOUTROSCUSTOS5")
    private BigDecimal percoutroscustos5;
    @Column(name = "PERCOUTROSCUSTOS6")
    private BigDecimal percoutroscustos6;
    @Column(name = "APLICACAO")
    private String aplicacao;
    @Column(name = "DATCAD")
    @Temporal(TemporalType.DATE)
    private Date datcad;
    @Column(name = "NOMEPRODWEB")
    private String nomeprodweb;
    @Column(name = "QTDEEMBALAGEM")
    private BigDecimal qtdeembalagem;
    @Column(name = "FLAGUSAGRADE")
    private Character flagusagrade;
    @Column(name = "FLAGNAOSAITABELA")
    private Character flagnaosaitabela;
    @Column(name = "FLAGORIGEMPRODUTO")
    private Character flagorigemproduto;
    @Column(name = "FLAGCOMPOSTO")
    private Character flagcomposto;
    @Column(name = "CODIGOINTERNO")
    private String codigointerno;
    @Column(name = "FLAGCONTROLAVALIDADE")
    private Character flagcontrolavalidade;
    @Column(name = "FLAGCONTROLALOTE")
    private Character flagcontrolalote;
    @Column(name = "FLAGCONTROLASERIAL")
    private Character flagcontrolaserial;
    @Column(name = "QUANTIDADEEMBALAGEM")
    private BigDecimal quantidadeembalagem;
    @Column(name = "TIPOITEM")
    private String tipoitem;
    @Column(name = "CSTIPIENTRADA")
    private String cstipientrada;
    @Column(name = "CSTIPISAIDA")
    private String cstipisaida;
    @Column(name = "FLAGPRODUCAO")
    private Character flagproducao;
    @Lob
    @Column(name = "DESCRICAOWEB")
    private String descricaoweb;
    @Column(name = "DESCRICAOIPEM")
    private String descricaoipem;
    @Column(name = "DESCRICAOEMBALAGEM")
    private String descricaoembalagem;
    @Column(name = "CFOPDENTROUF")
    private String cfopdentrouf;
    @Column(name = "CFOPFORAUF")
    private String cfopforauf;
    @Column(name = "FLAGCALCULAPIS")
    private Character flagcalculapis;
    @Column(name = "FLAGCALCULACOFINS")
    private Character flagcalculacofins;
    @Column(name = "PESOESPECIFICO")
    private BigDecimal pesoespecifico;
    @Column(name = "LITRAGEM")
    private BigDecimal litragem;
    @Column(name = "VALORIPI")
    private BigDecimal valoripi;
    @Column(name = "VALORSUBSTTRIBUTARIA")
    private BigDecimal valorsubsttributaria;
    @Column(name = "VALORFRETE")
    private BigDecimal valorfrete;
    @Column(name = "VALOROUTRASDESP")
    private BigDecimal valoroutrasdesp;
    @Column(name = "FLAGALIQICMSINTERNA")
    private Character flagaliqicmsinterna;
    @Column(name = "CLASSIFICACAOABC")
    private Character classificacaoabc;
    @Column(name = "RANKING")
    private Integer ranking;
    @Column(name = "CODUNIDADECOMPRA")
    private String codunidadecompra;
    @Column(name = "CODMOD")
    private String codmod;
    @Column(name = "SERIALSEQUENCIA")
    private Integer serialsequencia;
    @Column(name = "SERIALCARACTERES")
    private String serialcaracteres;
    @Column(name = "COTACAOATUAL")
    private BigDecimal cotacaoatual;
    @Column(name = "ALTURA")
    private BigDecimal altura;
    @Column(name = "LARGURA")
    private BigDecimal largura;
    @Column(name = "COMPRIMENTO")
    private BigDecimal comprimento;
    @Column(name = "CSTPISENTRADA")
    private String cstpisentrada;
    @Column(name = "CSTPISSAIDA")
    private String cstpissaida;
    @Column(name = "CSTCOFINSENTRADA")
    private String cstcofinsentrada;
    @Column(name = "CSTCOFINSSAIDA")
    private String cstcofinssaida;
    @Column(name = "ALIQPIS")
    private BigDecimal aliqpis;
    @Column(name = "ALIQCOFINS")
    private BigDecimal aliqcofins;
    @Column(name = "GUID")
    private String guid;
    @Lob
    @Column(name = "OBSSITE")
    private String obssite;
    @Column(name = "CODBALANCAINFOEXTRA")
    private String codbalancainfoextra;
    @Column(name = "CODBALANCAIMAGEM")
    private String codbalancaimagem;
    @Column(name = "CODBALANCANUTRICIONAL")
    private String codbalancanutricional;
    @Column(name = "FUNDAMENTOLEGAL")
    private String fundamentolegal;
    @Column(name = "CODNATUREZARECEITA")
    private String codnaturezareceita;
    @Column(name = "CREDITOPRESUMIDO")
    private Integer creditopresumido;
    @Column(name = "FLAGFARMACIAMANIPULACAO")
    private Character flagfarmaciamanipulacao;
    @Column(name = "FLAGENVIOWMS")
    private Character flagenviowms;
    @Column(name = "LIBERACAOESTADO")
    private String liberacaoestado;
    @Column(name = "PREDOLAR")
    private BigDecimal predolar;
    @Column(name = "CODENQUADRAMENTOIPI")
    private String codenquadramentoipi;
    @Column(name = "QUANTIDADEEMBALAGEMMST")
    private BigDecimal quantidadeembalagemmst;
    @Column(name = "FUNDAMENTOLEGALICMS")
    private String fundamentolegalicms;
    @Column(name = "QTDMAXWMS")
    private BigDecimal qtdmaxwms;
    @Column(name = "QTDMINWMS")
    private BigDecimal qtdminwms;
    @Column(name = "FLAGARREDONDA")
    private Character flagarredonda;
    @Column(name = "FLAGUSAREDUCAOBASEICMSSTPROD")
    private Character flagusareducaobaseicmsstprod;
    @Column(name = "RAIO")
    private BigDecimal raio;
    @Column(name = "CUBAGEM")
    private BigDecimal cubagem;
    @Column(name = "DENSIDADE")
    private BigDecimal densidade;
    @Column(name = "PESOCUBADO")
    private BigDecimal pesocubado;
    @Column(name = "VALORFCPSUBSTTRIBUTARIA")
    private BigDecimal valorfcpsubsttributaria;
    @Column(name = "FLAGLOTERASTREAVEL")
    private Character flagloterastreavel;
    @Column(name = "QUANTIDADETRIBUTAVEL")
    private BigDecimal quantidadetributavel;
    @Column(name = "QUANTIDADETRIBUTAVELEXP")
    private BigDecimal quantidadetributavelexp;
    @Column(name = "VALORDESCONTO")
    private BigDecimal valordesconto;
    @Lob
    @Column(name = "OBSFISCALCONTABIL")
    private String obsfiscalcontabil;
    @Column(name = "FLAGALTPAF")
    private Character flagaltpaf;
    @Column(name = "PERCVOL")
    private BigDecimal percvol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codprod")
    private Collection<Moventradaprodcomp> moventradaprodcompCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codprod")
    private Collection<Itemped> itempedCollection;
    @OneToMany(mappedBy = "codprod")
    private Collection<Moventradaprod> moventradaprodCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produto")
    private Collection<Fornproduto> fornprodutoCollection;
    @OneToMany(mappedBy = "codprod")
    private Collection<Reajusteproduto> reajusteprodutoCollection;
    @OneToMany(mappedBy = "codprod")
    private Collection<Ordemproducaoprodutoitem> ordemproducaoprodutoitemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codprod")
    private Collection<Pedidoitem> pedidoitemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codprod")
    private Collection<Produtopreco> produtoprecoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codprod")
    private Collection<Composicao> composicaoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produto")
    private Collection<Produtoestoque> produtoestoqueCollection;
    @OneToMany(mappedBy = "codprod")
    private Collection<OsRequisicao> osRequisicaoCollection;
    @OneToMany(mappedBy = "codprod")
    private Collection<Rma> rmaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codprod")
    private Collection<OsProdserv> osProdservCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codprod")
    private Collection<Produtolocalizacao> produtolocalizacaoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codprod")
    private Collection<Produtohistorico> produtohistoricoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codprod")
    private Collection<Acertoproduto> acertoprodutoCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "produto")
    private Produtopharma produtopharma;
    @OneToMany(mappedBy = "codprod")
    private Collection<Produtolote> produtoloteCollection;
    @OneToMany(mappedBy = "codprod")
    private Collection<Cotacaoproduto> cotacaoprodutoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codprod")
    private Collection<Produtoassociado> produtoassociadoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codprodassociado")
    private Collection<Produtoassociado> produtoassociadoCollection1;
    @OneToMany(mappedBy = "codprod")
    private Collection<Movendaprod> movendaprodCollection;
    @OneToMany(mappedBy = "codprod")
    private Collection<Promocaoproduto> promocaoprodutoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codprod")
    private Collection<Movendaprodcomp> movendaprodcompCollection;
    @JoinColumn(name = "CODPRODUTOANP", referencedColumnName = "CODPRODUTOANP")
    @ManyToOne
    private Produtoanp codprodutoanp;
    @JoinColumn(name = "CODCLASSIFICACAOFISCAL", referencedColumnName = "CODCLASSIFICACAOFISCAL")
    @ManyToOne
    private Classificacaofiscal codclassificacaofiscal;
    @JoinColumn(name = "CODCALCULOICMS", referencedColumnName = "CODCALCULOICMS")
    @ManyToOne
    private Calculoicms codcalculoicms;
    @JoinColumn(name = "CODCALCULOISS", referencedColumnName = "CODCALCULOISS")
    @ManyToOne
    private Calculoiss codcalculoiss;
    @JoinColumn(name = "CODFORN", referencedColumnName = "CODFORN")
    @ManyToOne
    private Fornecedor codforn;
    @JoinColumn(name = "CODGTINTRIBUTAVEL", referencedColumnName = "CODGTINTRIBUTAVEL")
    @ManyToOne
    private Gtintributavel codgtintributavel;
    @JoinColumn(name = "CODMENSAGEM", referencedColumnName = "CODMENSAGEM")
    @ManyToOne
    private Mensagem codmensagem;
    @JoinColumn(name = "CODMOEDA", referencedColumnName = "CODMOEDA")
    @ManyToOne
    private Moeda codmoeda;
    @JoinColumn(name = "CODPRODGRADE", referencedColumnName = "CODPRODGRADE")
    @ManyToOne
    private Produtograde codprodgrade;
    @JoinColumn(name = "CODPRODUTOPERIGOSO", referencedColumnName = "CODPRODUTOPERIGOSO")
    @ManyToOne
    private Produtoperigoso codprodutoperigoso;
    @JoinColumn(name = "CODUNIDADE", referencedColumnName = "CODUNIDADE")
    @ManyToOne
    private Unidade codunidade;
    @JoinColumn(name = "CODSEC", referencedColumnName = "CODSEC")
    @ManyToOne
    private Secao codsec;
    @JoinColumn(name = "CODTRIBUTACAOECF", referencedColumnName = "CODTRIBUTACAOECF")
    @ManyToOne
    private Tributacaoecf codtributacaoecf;
    @JoinColumn(name = "CODREGRACFOP", referencedColumnName = "CODREGRACFOP")
    @ManyToOne
    private Regracfop codregracfop;
    @OneToMany(mappedBy = "codprod")
    private Collection<Produtocaracteristica> produtocaracteristicaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codprod")
    private Collection<Produtocodigo> produtocodigoCollection;
    @OneToMany(mappedBy = "codprod")
    private Collection<AcertoProdloteproduto> acertoProdloteprodutoCollection;
    @OneToMany(mappedBy = "codprod")
    private Collection<Historicobuscapreco> historicobuscaprecoCollection;
    @OneToMany(mappedBy = "codprod")
    private Collection<Produtoprecoescalonado> produtoprecoescalonadoCollection;
    @OneToMany(mappedBy = "codprod")
    private Collection<Orcamentoprod> orcamentoprodCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codprod")
    private Collection<Relacionado> relacionadoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codprod")
    private Collection<Produtofoto> produtofotoCollection;
    @OneToMany(mappedBy = "codprod")
    private Collection<Contratocobrancaproduto> contratocobrancaprodutoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codprod")
    private Collection<Movendaproddevolucaocompra> movendaproddevolucaocompraCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codprod")
    private Collection<Clienteproduto> clienteprodutoCollection;
    @OneToMany(mappedBy = "codprod")
    private Collection<Producaoitem> producaoitemCollection;
    @OneToMany(mappedBy = "codprod")
    private Collection<Nfceletronicapafecfprod> nfceletronicapafecfprodCollection;
    @OneToMany(mappedBy = "codprod")
    private Collection<Produtoproducao> produtoproducaoCollection;
    @OneToMany(mappedBy = "codprodproducao")
    private Collection<Produtoproducao> produtoproducaoCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codprod")
    private Collection<Produtofci> produtofciCollection;
    @OneToMany(mappedBy = "codprod")
    private Collection<AcertoProdfciproduto> acertoProdfciprodutoCollection;

    public Produto() {
    }

    public Produto(String codprod) {
        this.codprod = codprod;
    }

    public Produto(String codprod, String codigo, String nomeprod, Character flaginativo, BigDecimal precusto, BigDecimal customedio) {
        this.codprod = codprod;
        this.codigo = codigo;
        this.nomeprod = nomeprod;
        this.flaginativo = flaginativo;
        this.precusto = precusto;
        this.customedio = customedio;
    }

    public String getCodprod() {
        return codprod;
    }

    public void setCodprod(String codprod) {
        String oldCodprod = this.codprod;
        this.codprod = codprod;
        changeSupport.firePropertyChange("codprod", oldCodprod, codprod);
    }

    public String getCoditemgradedetalheh() {
        return coditemgradedetalheh;
    }

    public void setCoditemgradedetalheh(String coditemgradedetalheh) {
        String oldCoditemgradedetalheh = this.coditemgradedetalheh;
        this.coditemgradedetalheh = coditemgradedetalheh;
        changeSupport.firePropertyChange("coditemgradedetalheh", oldCoditemgradedetalheh, coditemgradedetalheh);
    }

    public String getCoditemgradedetalhev() {
        return coditemgradedetalhev;
    }

    public void setCoditemgradedetalhev(String coditemgradedetalhev) {
        String oldCoditemgradedetalhev = this.coditemgradedetalhev;
        this.coditemgradedetalhev = coditemgradedetalhev;
        changeSupport.firePropertyChange("coditemgradedetalhev", oldCoditemgradedetalhev, coditemgradedetalhev);
    }

   // public String getCodfabricante() {
   //     return codfabricante;
  //  }

  //  public void setCodfabricante(String codfabricante) {
  //      this.codfabricante = codfabricante;
  //  }
    public Fabricante getCodfabricante() {
        return codfabricante;
    }

    public void setCodfabricante(Fabricante codfabricante) {
        Fabricante oldCodfabricante = this.codfabricante;
        this.codfabricante = codfabricante;
        changeSupport.firePropertyChange("codfabricante", oldCodfabricante, codfabricante);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        String oldCodigo = this.codigo;
        this.codigo = codigo;
        changeSupport.firePropertyChange("codigo", oldCodigo, codigo);
    }

    public String getCoduser() {
        return coduser;
    }

    public void setCoduser(String coduser) {
        String oldCoduser = this.coduser;
        this.coduser = coduser;
        changeSupport.firePropertyChange("coduser", oldCoduser, coduser);
    }

    public String getCodloc() {
        return codloc;
    }

    public void setCodloc(String codloc) {
        String oldCodloc = this.codloc;
        this.codloc = codloc;
        changeSupport.firePropertyChange("codloc", oldCodloc, codloc);
    }

    public String getNomeprod() {
        return nomeprod;
    }

    public void setNomeprod(String nomeprod) {
        String oldNomeprod = this.nomeprod;
        this.nomeprod = nomeprod;
        changeSupport.firePropertyChange("nomeprod", oldNomeprod, nomeprod);
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        String oldObs = this.obs;
        this.obs = obs;
        changeSupport.firePropertyChange("obs", oldObs, obs);
    }

    public Character getFlaginativo() {
        return flaginativo;
    }

    public void setFlaginativo(Character flaginativo) {
        Character oldFlaginativo = this.flaginativo;
        this.flaginativo = flaginativo;
        changeSupport.firePropertyChange("flaginativo", oldFlaginativo, flaginativo);
    }

    public Date getDatreaj() {
        return datreaj;
    }

    public void setDatreaj(Date datreaj) {
        Date oldDatreaj = this.datreaj;
        this.datreaj = datreaj;
        changeSupport.firePropertyChange("datreaj", oldDatreaj, datreaj);
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        String oldUnidade = this.unidade;
        this.unidade = unidade;
        changeSupport.firePropertyChange("unidade", oldUnidade, unidade);
    }

    public BigDecimal getPrecusto() {
        return precusto;
    }

    public void setPrecusto(BigDecimal precusto) {
        BigDecimal oldPrecusto = this.precusto;
        this.precusto = precusto;
        changeSupport.firePropertyChange("precusto", oldPrecusto, precusto);
    }

    public BigDecimal getCustomedio() {
        return customedio;
    }

    public void setCustomedio(BigDecimal customedio) {
        BigDecimal oldCustomedio = this.customedio;
        this.customedio = customedio;
        changeSupport.firePropertyChange("customedio", oldCustomedio, customedio);
    }

    public BigDecimal getOutros() {
        return outros;
    }

    public void setOutros(BigDecimal outros) {
        BigDecimal oldOutros = this.outros;
        this.outros = outros;
        changeSupport.firePropertyChange("outros", oldOutros, outros);
    }

    public BigDecimal getCustoreal() {
        return custoreal;
    }

    public void setCustoreal(BigDecimal custoreal) {
        BigDecimal oldCustoreal = this.custoreal;
        this.custoreal = custoreal;
        changeSupport.firePropertyChange("custoreal", oldCustoreal, custoreal);
    }

    public Date getLastChange() {
        return lastChange;
    }

    public void setLastChange(Date lastChange) {
        Date oldLastChange = this.lastChange;
        this.lastChange = lastChange;
        changeSupport.firePropertyChange("lastChange", oldLastChange, lastChange);
    }

    public BigDecimal getPesobruto() {
        return pesobruto;
    }

    public void setPesobruto(BigDecimal pesobruto) {
        BigDecimal oldPesobruto = this.pesobruto;
        this.pesobruto = pesobruto;
        changeSupport.firePropertyChange("pesobruto", oldPesobruto, pesobruto);
    }

    public BigDecimal getPesoliquido() {
        return pesoliquido;
    }

    public void setPesoliquido(BigDecimal pesoliquido) {
        BigDecimal oldPesoliquido = this.pesoliquido;
        this.pesoliquido = pesoliquido;
        changeSupport.firePropertyChange("pesoliquido", oldPesoliquido, pesoliquido);
    }

    public BigDecimal getComissao() {
        return comissao;
    }

    public void setComissao(BigDecimal comissao) {
        BigDecimal oldComissao = this.comissao;
        this.comissao = comissao;
        changeSupport.firePropertyChange("comissao", oldComissao, comissao);
    }

    public Character getFlagcontrolaestoque() {
        return flagcontrolaestoque;
    }

    public void setFlagcontrolaestoque(Character flagcontrolaestoque) {
        Character oldFlagcontrolaestoque = this.flagcontrolaestoque;
        this.flagcontrolaestoque = flagcontrolaestoque;
        changeSupport.firePropertyChange("flagcontrolaestoque", oldFlagcontrolaestoque, flagcontrolaestoque);
    }

    public Character getFlagservico() {
        return flagservico;
    }

    public void setFlagservico(Character flagservico) {
        Character oldFlagservico = this.flagservico;
        this.flagservico = flagservico;
        changeSupport.firePropertyChange("flagservico", oldFlagservico, flagservico);
    }

    public Character getFlagnaovender() {
        return flagnaovender;
    }

    public void setFlagnaovender(Character flagnaovender) {
        Character oldFlagnaovender = this.flagnaovender;
        this.flagnaovender = flagnaovender;
        changeSupport.firePropertyChange("flagnaovender", oldFlagnaovender, flagnaovender);
    }

    public Character getFlaglancacomposicao() {
        return flaglancacomposicao;
    }

    public void setFlaglancacomposicao(Character flaglancacomposicao) {
        Character oldFlaglancacomposicao = this.flaglancacomposicao;
        this.flaglancacomposicao = flaglancacomposicao;
        changeSupport.firePropertyChange("flaglancacomposicao", oldFlaglancacomposicao, flaglancacomposicao);
    }

    public BigDecimal getDescmaximo() {
        return descmaximo;
    }

    public void setDescmaximo(BigDecimal descmaximo) {
        BigDecimal oldDescmaximo = this.descmaximo;
        this.descmaximo = descmaximo;
        changeSupport.firePropertyChange("descmaximo", oldDescmaximo, descmaximo);
    }

    public Character getFlagvendecomposicao() {
        return flagvendecomposicao;
    }

    public void setFlagvendecomposicao(Character flagvendecomposicao) {
        Character oldFlagvendecomposicao = this.flagvendecomposicao;
        this.flagvendecomposicao = flagvendecomposicao;
        changeSupport.firePropertyChange("flagvendecomposicao", oldFlagvendecomposicao, flagvendecomposicao);
    }

    public String getNomeprodcurto() {
        return nomeprodcurto;
    }

    public void setNomeprodcurto(String nomeprodcurto) {
        String oldNomeprodcurto = this.nomeprodcurto;
        this.nomeprodcurto = nomeprodcurto;
        changeSupport.firePropertyChange("nomeprodcurto", oldNomeprodcurto, nomeprodcurto);
    }

    public Character getFlagtipocomissao() {
        return flagtipocomissao;
    }

    public void setFlagtipocomissao(Character flagtipocomissao) {
        Character oldFlagtipocomissao = this.flagtipocomissao;
        this.flagtipocomissao = flagtipocomissao;
        changeSupport.firePropertyChange("flagtipocomissao", oldFlagtipocomissao, flagtipocomissao);
    }

    public Character getFlagusacomissao() {
        return flagusacomissao;
    }

    public void setFlagusacomissao(Character flagusacomissao) {
        Character oldFlagusacomissao = this.flagusacomissao;
        this.flagusacomissao = flagusacomissao;
        changeSupport.firePropertyChange("flagusacomissao", oldFlagusacomissao, flagusacomissao);
    }

    public Integer getPrazogarantia() {
        return prazogarantia;
    }

    public void setPrazogarantia(Integer prazogarantia) {
        Integer oldPrazogarantia = this.prazogarantia;
        this.prazogarantia = prazogarantia;
        changeSupport.firePropertyChange("prazogarantia", oldPrazogarantia, prazogarantia);
    }

    public BigDecimal getPercoutroscustos() {
        return percoutroscustos;
    }

    public void setPercoutroscustos(BigDecimal percoutroscustos) {
        BigDecimal oldPercoutroscustos = this.percoutroscustos;
        this.percoutroscustos = percoutroscustos;
        changeSupport.firePropertyChange("percoutroscustos", oldPercoutroscustos, percoutroscustos);
    }

    public BigDecimal getValoutroscustos() {
        return valoutroscustos;
    }

    public void setValoutroscustos(BigDecimal valoutroscustos) {
        BigDecimal oldValoutroscustos = this.valoutroscustos;
        this.valoutroscustos = valoutroscustos;
        changeSupport.firePropertyChange("valoutroscustos", oldValoutroscustos, valoutroscustos);
    }

    public BigDecimal getTotoutroscustos() {
        return totoutroscustos;
    }

    public void setTotoutroscustos(BigDecimal totoutroscustos) {
        BigDecimal oldTotoutroscustos = this.totoutroscustos;
        this.totoutroscustos = totoutroscustos;
        changeSupport.firePropertyChange("totoutroscustos", oldTotoutroscustos, totoutroscustos);
    }

    public Integer getCodigoreceita() {
        return codigoreceita;
    }

    public void setCodigoreceita(Integer codigoreceita) {
        Integer oldCodigoreceita = this.codigoreceita;
        this.codigoreceita = codigoreceita;
        changeSupport.firePropertyChange("codigoreceita", oldCodigoreceita, codigoreceita);
    }

    public Integer getValidade() {
        return validade;
    }

    public void setValidade(Integer validade) {
        Integer oldValidade = this.validade;
        this.validade = validade;
        changeSupport.firePropertyChange("validade", oldValidade, validade);
    }

    public Character getFlagsolicitacomplemento() {
        return flagsolicitacomplemento;
    }

    public void setFlagsolicitacomplemento(Character flagsolicitacomplemento) {
        Character oldFlagsolicitacomplemento = this.flagsolicitacomplemento;
        this.flagsolicitacomplemento = flagsolicitacomplemento;
        changeSupport.firePropertyChange("flagsolicitacomplemento", oldFlagsolicitacomplemento, flagsolicitacomplemento);
    }

    public Character getFlaggeraserial() {
        return flaggeraserial;
    }

    public void setFlaggeraserial(Character flaggeraserial) {
        Character oldFlaggeraserial = this.flaggeraserial;
        this.flaggeraserial = flaggeraserial;
        changeSupport.firePropertyChange("flaggeraserial", oldFlaggeraserial, flaggeraserial);
    }

    public Integer getPrazoentrega() {
        return prazoentrega;
    }

    public void setPrazoentrega(Integer prazoentrega) {
        Integer oldPrazoentrega = this.prazoentrega;
        this.prazoentrega = prazoentrega;
        changeSupport.firePropertyChange("prazoentrega", oldPrazoentrega, prazoentrega);
    }

    public Integer getParcelamentosj() {
        return parcelamentosj;
    }

    public void setParcelamentosj(Integer parcelamentosj) {
        Integer oldParcelamentosj = this.parcelamentosj;
        this.parcelamentosj = parcelamentosj;
        changeSupport.firePropertyChange("parcelamentosj", oldParcelamentosj, parcelamentosj);
    }

    public BigDecimal getPercoutroscustos2() {
        return percoutroscustos2;
    }

    public void setPercoutroscustos2(BigDecimal percoutroscustos2) {
        BigDecimal oldPercoutroscustos2 = this.percoutroscustos2;
        this.percoutroscustos2 = percoutroscustos2;
        changeSupport.firePropertyChange("percoutroscustos2", oldPercoutroscustos2, percoutroscustos2);
    }

    public BigDecimal getPercoutroscustos3() {
        return percoutroscustos3;
    }

    public void setPercoutroscustos3(BigDecimal percoutroscustos3) {
        BigDecimal oldPercoutroscustos3 = this.percoutroscustos3;
        this.percoutroscustos3 = percoutroscustos3;
        changeSupport.firePropertyChange("percoutroscustos3", oldPercoutroscustos3, percoutroscustos3);
    }

    public BigDecimal getPercoutroscustos4() {
        return percoutroscustos4;
    }

    public void setPercoutroscustos4(BigDecimal percoutroscustos4) {
        BigDecimal oldPercoutroscustos4 = this.percoutroscustos4;
        this.percoutroscustos4 = percoutroscustos4;
        changeSupport.firePropertyChange("percoutroscustos4", oldPercoutroscustos4, percoutroscustos4);
    }

    public BigDecimal getPercoutroscustos5() {
        return percoutroscustos5;
    }

    public void setPercoutroscustos5(BigDecimal percoutroscustos5) {
        BigDecimal oldPercoutroscustos5 = this.percoutroscustos5;
        this.percoutroscustos5 = percoutroscustos5;
        changeSupport.firePropertyChange("percoutroscustos5", oldPercoutroscustos5, percoutroscustos5);
    }

    public BigDecimal getPercoutroscustos6() {
        return percoutroscustos6;
    }

    public void setPercoutroscustos6(BigDecimal percoutroscustos6) {
        BigDecimal oldPercoutroscustos6 = this.percoutroscustos6;
        this.percoutroscustos6 = percoutroscustos6;
        changeSupport.firePropertyChange("percoutroscustos6", oldPercoutroscustos6, percoutroscustos6);
    }

    public String getAplicacao() {
        return aplicacao;
    }

    public void setAplicacao(String aplicacao) {
        String oldAplicacao = this.aplicacao;
        this.aplicacao = aplicacao;
        changeSupport.firePropertyChange("aplicacao", oldAplicacao, aplicacao);
    }

    public Date getDatcad() {
        return datcad;
    }

    public void setDatcad(Date datcad) {
        Date oldDatcad = this.datcad;
        this.datcad = datcad;
        changeSupport.firePropertyChange("datcad", oldDatcad, datcad);
    }

    public String getNomeprodweb() {
        return nomeprodweb;
    }

    public void setNomeprodweb(String nomeprodweb) {
        String oldNomeprodweb = this.nomeprodweb;
        this.nomeprodweb = nomeprodweb;
        changeSupport.firePropertyChange("nomeprodweb", oldNomeprodweb, nomeprodweb);
    }

    public BigDecimal getQtdeembalagem() {
        return qtdeembalagem;
    }

    public void setQtdeembalagem(BigDecimal qtdeembalagem) {
        BigDecimal oldQtdeembalagem = this.qtdeembalagem;
        this.qtdeembalagem = qtdeembalagem;
        changeSupport.firePropertyChange("qtdeembalagem", oldQtdeembalagem, qtdeembalagem);
    }

    public Character getFlagusagrade() {
        return flagusagrade;
    }

    public void setFlagusagrade(Character flagusagrade) {
        Character oldFlagusagrade = this.flagusagrade;
        this.flagusagrade = flagusagrade;
        changeSupport.firePropertyChange("flagusagrade", oldFlagusagrade, flagusagrade);
    }

    public Character getFlagnaosaitabela() {
        return flagnaosaitabela;
    }

    public void setFlagnaosaitabela(Character flagnaosaitabela) {
        Character oldFlagnaosaitabela = this.flagnaosaitabela;
        this.flagnaosaitabela = flagnaosaitabela;
        changeSupport.firePropertyChange("flagnaosaitabela", oldFlagnaosaitabela, flagnaosaitabela);
    }

    public Character getFlagorigemproduto() {
        return flagorigemproduto;
    }

    public void setFlagorigemproduto(Character flagorigemproduto) {
        Character oldFlagorigemproduto = this.flagorigemproduto;
        this.flagorigemproduto = flagorigemproduto;
        changeSupport.firePropertyChange("flagorigemproduto", oldFlagorigemproduto, flagorigemproduto);
    }

    public Character getFlagcomposto() {
        return flagcomposto;
    }

    public void setFlagcomposto(Character flagcomposto) {
        Character oldFlagcomposto = this.flagcomposto;
        this.flagcomposto = flagcomposto;
        changeSupport.firePropertyChange("flagcomposto", oldFlagcomposto, flagcomposto);
    }

    public String getCodigointerno() {
        return codigointerno;
    }

    public void setCodigointerno(String codigointerno) {
        String oldCodigointerno = this.codigointerno;
        this.codigointerno = codigointerno;
        changeSupport.firePropertyChange("codigointerno", oldCodigointerno, codigointerno);
    }

    public Character getFlagcontrolavalidade() {
        return flagcontrolavalidade;
    }

    public void setFlagcontrolavalidade(Character flagcontrolavalidade) {
        Character oldFlagcontrolavalidade = this.flagcontrolavalidade;
        this.flagcontrolavalidade = flagcontrolavalidade;
        changeSupport.firePropertyChange("flagcontrolavalidade", oldFlagcontrolavalidade, flagcontrolavalidade);
    }

    public Character getFlagcontrolalote() {
        return flagcontrolalote;
    }

    public void setFlagcontrolalote(Character flagcontrolalote) {
        Character oldFlagcontrolalote = this.flagcontrolalote;
        this.flagcontrolalote = flagcontrolalote;
        changeSupport.firePropertyChange("flagcontrolalote", oldFlagcontrolalote, flagcontrolalote);
    }

    public Character getFlagcontrolaserial() {
        return flagcontrolaserial;
    }

    public void setFlagcontrolaserial(Character flagcontrolaserial) {
        Character oldFlagcontrolaserial = this.flagcontrolaserial;
        this.flagcontrolaserial = flagcontrolaserial;
        changeSupport.firePropertyChange("flagcontrolaserial", oldFlagcontrolaserial, flagcontrolaserial);
    }

    public BigDecimal getQuantidadeembalagem() {
        return quantidadeembalagem;
    }

    public void setQuantidadeembalagem(BigDecimal quantidadeembalagem) {
        BigDecimal oldQuantidadeembalagem = this.quantidadeembalagem;
        this.quantidadeembalagem = quantidadeembalagem;
        changeSupport.firePropertyChange("quantidadeembalagem", oldQuantidadeembalagem, quantidadeembalagem);
    }

    public String getTipoitem() {
        return tipoitem;
    }

    public void setTipoitem(String tipoitem) {
        String oldTipoitem = this.tipoitem;
        this.tipoitem = tipoitem;
        changeSupport.firePropertyChange("tipoitem", oldTipoitem, tipoitem);
    }

    public String getCstipientrada() {
        return cstipientrada;
    }

    public void setCstipientrada(String cstipientrada) {
        String oldCstipientrada = this.cstipientrada;
        this.cstipientrada = cstipientrada;
        changeSupport.firePropertyChange("cstipientrada", oldCstipientrada, cstipientrada);
    }

    public String getCstipisaida() {
        return cstipisaida;
    }

    public void setCstipisaida(String cstipisaida) {
        String oldCstipisaida = this.cstipisaida;
        this.cstipisaida = cstipisaida;
        changeSupport.firePropertyChange("cstipisaida", oldCstipisaida, cstipisaida);
    }

    public Character getFlagproducao() {
        return flagproducao;
    }

    public void setFlagproducao(Character flagproducao) {
        Character oldFlagproducao = this.flagproducao;
        this.flagproducao = flagproducao;
        changeSupport.firePropertyChange("flagproducao", oldFlagproducao, flagproducao);
    }

    public String getDescricaoweb() {
        return descricaoweb;
    }

    public void setDescricaoweb(String descricaoweb) {
        String oldDescricaoweb = this.descricaoweb;
        this.descricaoweb = descricaoweb;
        changeSupport.firePropertyChange("descricaoweb", oldDescricaoweb, descricaoweb);
    }

    public String getDescricaoipem() {
        return descricaoipem;
    }

    public void setDescricaoipem(String descricaoipem) {
        String oldDescricaoipem = this.descricaoipem;
        this.descricaoipem = descricaoipem;
        changeSupport.firePropertyChange("descricaoipem", oldDescricaoipem, descricaoipem);
    }

    public String getDescricaoembalagem() {
        return descricaoembalagem;
    }

    public void setDescricaoembalagem(String descricaoembalagem) {
        String oldDescricaoembalagem = this.descricaoembalagem;
        this.descricaoembalagem = descricaoembalagem;
        changeSupport.firePropertyChange("descricaoembalagem", oldDescricaoembalagem, descricaoembalagem);
    }

    public String getCfopdentrouf() {
        return cfopdentrouf;
    }

    public void setCfopdentrouf(String cfopdentrouf) {
        String oldCfopdentrouf = this.cfopdentrouf;
        this.cfopdentrouf = cfopdentrouf;
        changeSupport.firePropertyChange("cfopdentrouf", oldCfopdentrouf, cfopdentrouf);
    }

    public String getCfopforauf() {
        return cfopforauf;
    }

    public void setCfopforauf(String cfopforauf) {
        String oldCfopforauf = this.cfopforauf;
        this.cfopforauf = cfopforauf;
        changeSupport.firePropertyChange("cfopforauf", oldCfopforauf, cfopforauf);
    }

    public Character getFlagcalculapis() {
        return flagcalculapis;
    }

    public void setFlagcalculapis(Character flagcalculapis) {
        Character oldFlagcalculapis = this.flagcalculapis;
        this.flagcalculapis = flagcalculapis;
        changeSupport.firePropertyChange("flagcalculapis", oldFlagcalculapis, flagcalculapis);
    }

    public Character getFlagcalculacofins() {
        return flagcalculacofins;
    }

    public void setFlagcalculacofins(Character flagcalculacofins) {
        Character oldFlagcalculacofins = this.flagcalculacofins;
        this.flagcalculacofins = flagcalculacofins;
        changeSupport.firePropertyChange("flagcalculacofins", oldFlagcalculacofins, flagcalculacofins);
    }

    public BigDecimal getPesoespecifico() {
        return pesoespecifico;
    }

    public void setPesoespecifico(BigDecimal pesoespecifico) {
        BigDecimal oldPesoespecifico = this.pesoespecifico;
        this.pesoespecifico = pesoespecifico;
        changeSupport.firePropertyChange("pesoespecifico", oldPesoespecifico, pesoespecifico);
    }

    public BigDecimal getLitragem() {
        return litragem;
    }

    public void setLitragem(BigDecimal litragem) {
        BigDecimal oldLitragem = this.litragem;
        this.litragem = litragem;
        changeSupport.firePropertyChange("litragem", oldLitragem, litragem);
    }

    public BigDecimal getValoripi() {
        return valoripi;
    }

    public void setValoripi(BigDecimal valoripi) {
        BigDecimal oldValoripi = this.valoripi;
        this.valoripi = valoripi;
        changeSupport.firePropertyChange("valoripi", oldValoripi, valoripi);
    }

    public BigDecimal getValorsubsttributaria() {
        return valorsubsttributaria;
    }

    public void setValorsubsttributaria(BigDecimal valorsubsttributaria) {
        BigDecimal oldValorsubsttributaria = this.valorsubsttributaria;
        this.valorsubsttributaria = valorsubsttributaria;
        changeSupport.firePropertyChange("valorsubsttributaria", oldValorsubsttributaria, valorsubsttributaria);
    }

    public BigDecimal getValorfrete() {
        return valorfrete;
    }

    public void setValorfrete(BigDecimal valorfrete) {
        BigDecimal oldValorfrete = this.valorfrete;
        this.valorfrete = valorfrete;
        changeSupport.firePropertyChange("valorfrete", oldValorfrete, valorfrete);
    }

    public BigDecimal getValoroutrasdesp() {
        return valoroutrasdesp;
    }

    public void setValoroutrasdesp(BigDecimal valoroutrasdesp) {
        BigDecimal oldValoroutrasdesp = this.valoroutrasdesp;
        this.valoroutrasdesp = valoroutrasdesp;
        changeSupport.firePropertyChange("valoroutrasdesp", oldValoroutrasdesp, valoroutrasdesp);
    }

    public Character getFlagaliqicmsinterna() {
        return flagaliqicmsinterna;
    }

    public void setFlagaliqicmsinterna(Character flagaliqicmsinterna) {
        Character oldFlagaliqicmsinterna = this.flagaliqicmsinterna;
        this.flagaliqicmsinterna = flagaliqicmsinterna;
        changeSupport.firePropertyChange("flagaliqicmsinterna", oldFlagaliqicmsinterna, flagaliqicmsinterna);
    }

    public Character getClassificacaoabc() {
        return classificacaoabc;
    }

    public void setClassificacaoabc(Character classificacaoabc) {
        Character oldClassificacaoabc = this.classificacaoabc;
        this.classificacaoabc = classificacaoabc;
        changeSupport.firePropertyChange("classificacaoabc", oldClassificacaoabc, classificacaoabc);
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        Integer oldRanking = this.ranking;
        this.ranking = ranking;
        changeSupport.firePropertyChange("ranking", oldRanking, ranking);
    }

    public String getCodunidadecompra() {
        return codunidadecompra;
    }

    public void setCodunidadecompra(String codunidadecompra) {
        String oldCodunidadecompra = this.codunidadecompra;
        this.codunidadecompra = codunidadecompra;
        changeSupport.firePropertyChange("codunidadecompra", oldCodunidadecompra, codunidadecompra);
    }

    public String getCodmod() {
        return codmod;
    }

    public void setCodmod(String codmod) {
        String oldCodmod = this.codmod;
        this.codmod = codmod;
        changeSupport.firePropertyChange("codmod", oldCodmod, codmod);
    }

    public Integer getSerialsequencia() {
        return serialsequencia;
    }

    public void setSerialsequencia(Integer serialsequencia) {
        Integer oldSerialsequencia = this.serialsequencia;
        this.serialsequencia = serialsequencia;
        changeSupport.firePropertyChange("serialsequencia", oldSerialsequencia, serialsequencia);
    }

    public String getSerialcaracteres() {
        return serialcaracteres;
    }

    public void setSerialcaracteres(String serialcaracteres) {
        String oldSerialcaracteres = this.serialcaracteres;
        this.serialcaracteres = serialcaracteres;
        changeSupport.firePropertyChange("serialcaracteres", oldSerialcaracteres, serialcaracteres);
    }

    public BigDecimal getCotacaoatual() {
        return cotacaoatual;
    }

    public void setCotacaoatual(BigDecimal cotacaoatual) {
        BigDecimal oldCotacaoatual = this.cotacaoatual;
        this.cotacaoatual = cotacaoatual;
        changeSupport.firePropertyChange("cotacaoatual", oldCotacaoatual, cotacaoatual);
    }

    public BigDecimal getAltura() {
        return altura;
    }

    public void setAltura(BigDecimal altura) {
        BigDecimal oldAltura = this.altura;
        this.altura = altura;
        changeSupport.firePropertyChange("altura", oldAltura, altura);
    }

    public BigDecimal getLargura() {
        return largura;
    }

    public void setLargura(BigDecimal largura) {
        BigDecimal oldLargura = this.largura;
        this.largura = largura;
        changeSupport.firePropertyChange("largura", oldLargura, largura);
    }

    public BigDecimal getComprimento() {
        return comprimento;
    }

    public void setComprimento(BigDecimal comprimento) {
        BigDecimal oldComprimento = this.comprimento;
        this.comprimento = comprimento;
        changeSupport.firePropertyChange("comprimento", oldComprimento, comprimento);
    }

    public String getCstpisentrada() {
        return cstpisentrada;
    }

    public void setCstpisentrada(String cstpisentrada) {
        String oldCstpisentrada = this.cstpisentrada;
        this.cstpisentrada = cstpisentrada;
        changeSupport.firePropertyChange("cstpisentrada", oldCstpisentrada, cstpisentrada);
    }

    public String getCstpissaida() {
        return cstpissaida;
    }

    public void setCstpissaida(String cstpissaida) {
        String oldCstpissaida = this.cstpissaida;
        this.cstpissaida = cstpissaida;
        changeSupport.firePropertyChange("cstpissaida", oldCstpissaida, cstpissaida);
    }

    public String getCstcofinsentrada() {
        return cstcofinsentrada;
    }

    public void setCstcofinsentrada(String cstcofinsentrada) {
        String oldCstcofinsentrada = this.cstcofinsentrada;
        this.cstcofinsentrada = cstcofinsentrada;
        changeSupport.firePropertyChange("cstcofinsentrada", oldCstcofinsentrada, cstcofinsentrada);
    }

    public String getCstcofinssaida() {
        return cstcofinssaida;
    }

    public void setCstcofinssaida(String cstcofinssaida) {
        String oldCstcofinssaida = this.cstcofinssaida;
        this.cstcofinssaida = cstcofinssaida;
        changeSupport.firePropertyChange("cstcofinssaida", oldCstcofinssaida, cstcofinssaida);
    }

    public BigDecimal getAliqpis() {
        return aliqpis;
    }

    public void setAliqpis(BigDecimal aliqpis) {
        BigDecimal oldAliqpis = this.aliqpis;
        this.aliqpis = aliqpis;
        changeSupport.firePropertyChange("aliqpis", oldAliqpis, aliqpis);
    }

    public BigDecimal getAliqcofins() {
        return aliqcofins;
    }

    public void setAliqcofins(BigDecimal aliqcofins) {
        BigDecimal oldAliqcofins = this.aliqcofins;
        this.aliqcofins = aliqcofins;
        changeSupport.firePropertyChange("aliqcofins", oldAliqcofins, aliqcofins);
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        String oldGuid = this.guid;
        this.guid = guid;
        changeSupport.firePropertyChange("guid", oldGuid, guid);
    }

    public String getObssite() {
        return obssite;
    }

    public void setObssite(String obssite) {
        String oldObssite = this.obssite;
        this.obssite = obssite;
        changeSupport.firePropertyChange("obssite", oldObssite, obssite);
    }

    public String getCodbalancainfoextra() {
        return codbalancainfoextra;
    }

    public void setCodbalancainfoextra(String codbalancainfoextra) {
        String oldCodbalancainfoextra = this.codbalancainfoextra;
        this.codbalancainfoextra = codbalancainfoextra;
        changeSupport.firePropertyChange("codbalancainfoextra", oldCodbalancainfoextra, codbalancainfoextra);
    }

    public String getCodbalancaimagem() {
        return codbalancaimagem;
    }

    public void setCodbalancaimagem(String codbalancaimagem) {
        String oldCodbalancaimagem = this.codbalancaimagem;
        this.codbalancaimagem = codbalancaimagem;
        changeSupport.firePropertyChange("codbalancaimagem", oldCodbalancaimagem, codbalancaimagem);
    }

    public String getCodbalancanutricional() {
        return codbalancanutricional;
    }

    public void setCodbalancanutricional(String codbalancanutricional) {
        String oldCodbalancanutricional = this.codbalancanutricional;
        this.codbalancanutricional = codbalancanutricional;
        changeSupport.firePropertyChange("codbalancanutricional", oldCodbalancanutricional, codbalancanutricional);
    }

    public String getFundamentolegal() {
        return fundamentolegal;
    }

    public void setFundamentolegal(String fundamentolegal) {
        String oldFundamentolegal = this.fundamentolegal;
        this.fundamentolegal = fundamentolegal;
        changeSupport.firePropertyChange("fundamentolegal", oldFundamentolegal, fundamentolegal);
    }

    public String getCodnaturezareceita() {
        return codnaturezareceita;
    }

    public void setCodnaturezareceita(String codnaturezareceita) {
        String oldCodnaturezareceita = this.codnaturezareceita;
        this.codnaturezareceita = codnaturezareceita;
        changeSupport.firePropertyChange("codnaturezareceita", oldCodnaturezareceita, codnaturezareceita);
    }

    public Integer getCreditopresumido() {
        return creditopresumido;
    }

    public void setCreditopresumido(Integer creditopresumido) {
        Integer oldCreditopresumido = this.creditopresumido;
        this.creditopresumido = creditopresumido;
        changeSupport.firePropertyChange("creditopresumido", oldCreditopresumido, creditopresumido);
    }

    public Character getFlagfarmaciamanipulacao() {
        return flagfarmaciamanipulacao;
    }

    public void setFlagfarmaciamanipulacao(Character flagfarmaciamanipulacao) {
        Character oldFlagfarmaciamanipulacao = this.flagfarmaciamanipulacao;
        this.flagfarmaciamanipulacao = flagfarmaciamanipulacao;
        changeSupport.firePropertyChange("flagfarmaciamanipulacao", oldFlagfarmaciamanipulacao, flagfarmaciamanipulacao);
    }

    public Character getFlagenviowms() {
        return flagenviowms;
    }

    public void setFlagenviowms(Character flagenviowms) {
        Character oldFlagenviowms = this.flagenviowms;
        this.flagenviowms = flagenviowms;
        changeSupport.firePropertyChange("flagenviowms", oldFlagenviowms, flagenviowms);
    }

    public String getLiberacaoestado() {
        return liberacaoestado;
    }

    public void setLiberacaoestado(String liberacaoestado) {
        String oldLiberacaoestado = this.liberacaoestado;
        this.liberacaoestado = liberacaoestado;
        changeSupport.firePropertyChange("liberacaoestado", oldLiberacaoestado, liberacaoestado);
    }

    public BigDecimal getPredolar() {
        return predolar;
    }

    public void setPredolar(BigDecimal predolar) {
        BigDecimal oldPredolar = this.predolar;
        this.predolar = predolar;
        changeSupport.firePropertyChange("predolar", oldPredolar, predolar);
    }

    public String getCodenquadramentoipi() {
        return codenquadramentoipi;
    }

    public void setCodenquadramentoipi(String codenquadramentoipi) {
        String oldCodenquadramentoipi = this.codenquadramentoipi;
        this.codenquadramentoipi = codenquadramentoipi;
        changeSupport.firePropertyChange("codenquadramentoipi", oldCodenquadramentoipi, codenquadramentoipi);
    }

    public BigDecimal getQuantidadeembalagemmst() {
        return quantidadeembalagemmst;
    }

    public void setQuantidadeembalagemmst(BigDecimal quantidadeembalagemmst) {
        BigDecimal oldQuantidadeembalagemmst = this.quantidadeembalagemmst;
        this.quantidadeembalagemmst = quantidadeembalagemmst;
        changeSupport.firePropertyChange("quantidadeembalagemmst", oldQuantidadeembalagemmst, quantidadeembalagemmst);
    }

    public String getFundamentolegalicms() {
        return fundamentolegalicms;
    }

    public void setFundamentolegalicms(String fundamentolegalicms) {
        String oldFundamentolegalicms = this.fundamentolegalicms;
        this.fundamentolegalicms = fundamentolegalicms;
        changeSupport.firePropertyChange("fundamentolegalicms", oldFundamentolegalicms, fundamentolegalicms);
    }

    public BigDecimal getQtdmaxwms() {
        return qtdmaxwms;
    }

    public void setQtdmaxwms(BigDecimal qtdmaxwms) {
        BigDecimal oldQtdmaxwms = this.qtdmaxwms;
        this.qtdmaxwms = qtdmaxwms;
        changeSupport.firePropertyChange("qtdmaxwms", oldQtdmaxwms, qtdmaxwms);
    }

    public BigDecimal getQtdminwms() {
        return qtdminwms;
    }

    public void setQtdminwms(BigDecimal qtdminwms) {
        BigDecimal oldQtdminwms = this.qtdminwms;
        this.qtdminwms = qtdminwms;
        changeSupport.firePropertyChange("qtdminwms", oldQtdminwms, qtdminwms);
    }

    public Character getFlagarredonda() {
        return flagarredonda;
    }

    public void setFlagarredonda(Character flagarredonda) {
        Character oldFlagarredonda = this.flagarredonda;
        this.flagarredonda = flagarredonda;
        changeSupport.firePropertyChange("flagarredonda", oldFlagarredonda, flagarredonda);
    }

    public Character getFlagusareducaobaseicmsstprod() {
        return flagusareducaobaseicmsstprod;
    }

    public void setFlagusareducaobaseicmsstprod(Character flagusareducaobaseicmsstprod) {
        Character oldFlagusareducaobaseicmsstprod = this.flagusareducaobaseicmsstprod;
        this.flagusareducaobaseicmsstprod = flagusareducaobaseicmsstprod;
        changeSupport.firePropertyChange("flagusareducaobaseicmsstprod", oldFlagusareducaobaseicmsstprod, flagusareducaobaseicmsstprod);
    }

    public BigDecimal getRaio() {
        return raio;
    }

    public void setRaio(BigDecimal raio) {
        BigDecimal oldRaio = this.raio;
        this.raio = raio;
        changeSupport.firePropertyChange("raio", oldRaio, raio);
    }

    public BigDecimal getCubagem() {
        return cubagem;
    }

    public void setCubagem(BigDecimal cubagem) {
        BigDecimal oldCubagem = this.cubagem;
        this.cubagem = cubagem;
        changeSupport.firePropertyChange("cubagem", oldCubagem, cubagem);
    }

    public BigDecimal getDensidade() {
        return densidade;
    }

    public void setDensidade(BigDecimal densidade) {
        BigDecimal oldDensidade = this.densidade;
        this.densidade = densidade;
        changeSupport.firePropertyChange("densidade", oldDensidade, densidade);
    }

    public BigDecimal getPesocubado() {
        return pesocubado;
    }

    public void setPesocubado(BigDecimal pesocubado) {
        BigDecimal oldPesocubado = this.pesocubado;
        this.pesocubado = pesocubado;
        changeSupport.firePropertyChange("pesocubado", oldPesocubado, pesocubado);
    }

    public BigDecimal getValorfcpsubsttributaria() {
        return valorfcpsubsttributaria;
    }

    public void setValorfcpsubsttributaria(BigDecimal valorfcpsubsttributaria) {
        BigDecimal oldValorfcpsubsttributaria = this.valorfcpsubsttributaria;
        this.valorfcpsubsttributaria = valorfcpsubsttributaria;
        changeSupport.firePropertyChange("valorfcpsubsttributaria", oldValorfcpsubsttributaria, valorfcpsubsttributaria);
    }

    public Character getFlagloterastreavel() {
        return flagloterastreavel;
    }

    public void setFlagloterastreavel(Character flagloterastreavel) {
        Character oldFlagloterastreavel = this.flagloterastreavel;
        this.flagloterastreavel = flagloterastreavel;
        changeSupport.firePropertyChange("flagloterastreavel", oldFlagloterastreavel, flagloterastreavel);
    }

    public BigDecimal getQuantidadetributavel() {
        return quantidadetributavel;
    }

    public void setQuantidadetributavel(BigDecimal quantidadetributavel) {
        BigDecimal oldQuantidadetributavel = this.quantidadetributavel;
        this.quantidadetributavel = quantidadetributavel;
        changeSupport.firePropertyChange("quantidadetributavel", oldQuantidadetributavel, quantidadetributavel);
    }

    public BigDecimal getQuantidadetributavelexp() {
        return quantidadetributavelexp;
    }

    public void setQuantidadetributavelexp(BigDecimal quantidadetributavelexp) {
        BigDecimal oldQuantidadetributavelexp = this.quantidadetributavelexp;
        this.quantidadetributavelexp = quantidadetributavelexp;
        changeSupport.firePropertyChange("quantidadetributavelexp", oldQuantidadetributavelexp, quantidadetributavelexp);
    }

    public BigDecimal getValordesconto() {
        return valordesconto;
    }

    public void setValordesconto(BigDecimal valordesconto) {
        BigDecimal oldValordesconto = this.valordesconto;
        this.valordesconto = valordesconto;
        changeSupport.firePropertyChange("valordesconto", oldValordesconto, valordesconto);
    }

    public String getObsfiscalcontabil() {
        return obsfiscalcontabil;
    }

    public void setObsfiscalcontabil(String obsfiscalcontabil) {
        String oldObsfiscalcontabil = this.obsfiscalcontabil;
        this.obsfiscalcontabil = obsfiscalcontabil;
        changeSupport.firePropertyChange("obsfiscalcontabil", oldObsfiscalcontabil, obsfiscalcontabil);
    }

    public Character getFlagaltpaf() {
        return flagaltpaf;
    }

    public void setFlagaltpaf(Character flagaltpaf) {
        Character oldFlagaltpaf = this.flagaltpaf;
        this.flagaltpaf = flagaltpaf;
        changeSupport.firePropertyChange("flagaltpaf", oldFlagaltpaf, flagaltpaf);
    }

    public BigDecimal getPercvol() {
        return percvol;
    }

    public void setPercvol(BigDecimal percvol) {
        BigDecimal oldPercvol = this.percvol;
        this.percvol = percvol;
        changeSupport.firePropertyChange("percvol", oldPercvol, percvol);
    }

    @XmlTransient
    public Collection<Moventradaprodcomp> getMoventradaprodcompCollection() {
        return moventradaprodcompCollection;
    }

    public void setMoventradaprodcompCollection(Collection<Moventradaprodcomp> moventradaprodcompCollection) {
        this.moventradaprodcompCollection = moventradaprodcompCollection;
    }

    @XmlTransient
    public Collection<Itemped> getItempedCollection() {
        return itempedCollection;
    }

    public void setItempedCollection(Collection<Itemped> itempedCollection) {
        this.itempedCollection = itempedCollection;
    }

    @XmlTransient
    public Collection<Moventradaprod> getMoventradaprodCollection() {
        return moventradaprodCollection;
    }

    public void setMoventradaprodCollection(Collection<Moventradaprod> moventradaprodCollection) {
        this.moventradaprodCollection = moventradaprodCollection;
    }

    @XmlTransient
    public Collection<Fornproduto> getFornprodutoCollection() {
        return fornprodutoCollection;
    }

    public void setFornprodutoCollection(Collection<Fornproduto> fornprodutoCollection) {
        this.fornprodutoCollection = fornprodutoCollection;
    }

    @XmlTransient
    public Collection<Reajusteproduto> getReajusteprodutoCollection() {
        return reajusteprodutoCollection;
    }

    public void setReajusteprodutoCollection(Collection<Reajusteproduto> reajusteprodutoCollection) {
        this.reajusteprodutoCollection = reajusteprodutoCollection;
    }

    @XmlTransient
    public Collection<Ordemproducaoprodutoitem> getOrdemproducaoprodutoitemCollection() {
        return ordemproducaoprodutoitemCollection;
    }

    public void setOrdemproducaoprodutoitemCollection(Collection<Ordemproducaoprodutoitem> ordemproducaoprodutoitemCollection) {
        this.ordemproducaoprodutoitemCollection = ordemproducaoprodutoitemCollection;
    }

    @XmlTransient
    public Collection<Pedidoitem> getPedidoitemCollection() {
        return pedidoitemCollection;
    }

    public void setPedidoitemCollection(Collection<Pedidoitem> pedidoitemCollection) {
        this.pedidoitemCollection = pedidoitemCollection;
    }

    @XmlTransient
    public Collection<Produtopreco> getProdutoprecoCollection() {
        return produtoprecoCollection;
    }

    public void setProdutoprecoCollection(Collection<Produtopreco> produtoprecoCollection) {
        this.produtoprecoCollection = produtoprecoCollection;
    }

    @XmlTransient
    public Collection<Composicao> getComposicaoCollection() {
        return composicaoCollection;
    }

    public void setComposicaoCollection(Collection<Composicao> composicaoCollection) {
        this.composicaoCollection = composicaoCollection;
    }

    @XmlTransient
    public Collection<Produtoestoque> getProdutoestoqueCollection() {
        return produtoestoqueCollection;
    }

    public void setProdutoestoqueCollection(Collection<Produtoestoque> produtoestoqueCollection) {
        this.produtoestoqueCollection = produtoestoqueCollection;
    }

    @XmlTransient
    public Collection<OsRequisicao> getOsRequisicaoCollection() {
        return osRequisicaoCollection;
    }

    public void setOsRequisicaoCollection(Collection<OsRequisicao> osRequisicaoCollection) {
        this.osRequisicaoCollection = osRequisicaoCollection;
    }

    @XmlTransient
    public Collection<Rma> getRmaCollection() {
        return rmaCollection;
    }

    public void setRmaCollection(Collection<Rma> rmaCollection) {
        this.rmaCollection = rmaCollection;
    }

    @XmlTransient
    public Collection<OsProdserv> getOsProdservCollection() {
        return osProdservCollection;
    }

    public void setOsProdservCollection(Collection<OsProdserv> osProdservCollection) {
        this.osProdservCollection = osProdservCollection;
    }

    @XmlTransient
    public Collection<Produtolocalizacao> getProdutolocalizacaoCollection() {
        return produtolocalizacaoCollection;
    }

    public void setProdutolocalizacaoCollection(Collection<Produtolocalizacao> produtolocalizacaoCollection) {
        this.produtolocalizacaoCollection = produtolocalizacaoCollection;
    }

    @XmlTransient
    public Collection<Produtohistorico> getProdutohistoricoCollection() {
        return produtohistoricoCollection;
    }

    public void setProdutohistoricoCollection(Collection<Produtohistorico> produtohistoricoCollection) {
        this.produtohistoricoCollection = produtohistoricoCollection;
    }

    @XmlTransient
    public Collection<Acertoproduto> getAcertoprodutoCollection() {
        return acertoprodutoCollection;
    }

    public void setAcertoprodutoCollection(Collection<Acertoproduto> acertoprodutoCollection) {
        this.acertoprodutoCollection = acertoprodutoCollection;
    }

    public Produtopharma getProdutopharma() {
        return produtopharma;
    }

    public void setProdutopharma(Produtopharma produtopharma) {
        this.produtopharma = produtopharma;
    }

    @XmlTransient
    public Collection<Produtolote> getProdutoloteCollection() {
        return produtoloteCollection;
    }

    public void setProdutoloteCollection(Collection<Produtolote> produtoloteCollection) {
        this.produtoloteCollection = produtoloteCollection;
    }

    @XmlTransient
    public Collection<Cotacaoproduto> getCotacaoprodutoCollection() {
        return cotacaoprodutoCollection;
    }

    public void setCotacaoprodutoCollection(Collection<Cotacaoproduto> cotacaoprodutoCollection) {
        this.cotacaoprodutoCollection = cotacaoprodutoCollection;
    }

    @XmlTransient
    public Collection<Produtoassociado> getProdutoassociadoCollection() {
        return produtoassociadoCollection;
    }

    public void setProdutoassociadoCollection(Collection<Produtoassociado> produtoassociadoCollection) {
        this.produtoassociadoCollection = produtoassociadoCollection;
    }

    @XmlTransient
    public Collection<Produtoassociado> getProdutoassociadoCollection1() {
        return produtoassociadoCollection1;
    }

    public void setProdutoassociadoCollection1(Collection<Produtoassociado> produtoassociadoCollection1) {
        this.produtoassociadoCollection1 = produtoassociadoCollection1;
    }

    @XmlTransient
    public Collection<Movendaprod> getMovendaprodCollection() {
        return movendaprodCollection;
    }

    public void setMovendaprodCollection(Collection<Movendaprod> movendaprodCollection) {
        this.movendaprodCollection = movendaprodCollection;
    }

    @XmlTransient
    public Collection<Promocaoproduto> getPromocaoprodutoCollection() {
        return promocaoprodutoCollection;
    }

    public void setPromocaoprodutoCollection(Collection<Promocaoproduto> promocaoprodutoCollection) {
        this.promocaoprodutoCollection = promocaoprodutoCollection;
    }

    @XmlTransient
    public Collection<Movendaprodcomp> getMovendaprodcompCollection() {
        return movendaprodcompCollection;
    }

    public void setMovendaprodcompCollection(Collection<Movendaprodcomp> movendaprodcompCollection) {
        this.movendaprodcompCollection = movendaprodcompCollection;
    }

    public Produtoanp getCodprodutoanp() {
        return codprodutoanp;
    }

    public void setCodprodutoanp(Produtoanp codprodutoanp) {
        Produtoanp oldCodprodutoanp = this.codprodutoanp;
        this.codprodutoanp = codprodutoanp;
        changeSupport.firePropertyChange("codprodutoanp", oldCodprodutoanp, codprodutoanp);
    }

    public Classificacaofiscal getCodclassificacaofiscal() {
        return codclassificacaofiscal;
    }

    public void setCodclassificacaofiscal(Classificacaofiscal codclassificacaofiscal) {
        Classificacaofiscal oldCodclassificacaofiscal = this.codclassificacaofiscal;
        this.codclassificacaofiscal = codclassificacaofiscal;
        changeSupport.firePropertyChange("codclassificacaofiscal", oldCodclassificacaofiscal, codclassificacaofiscal);
    }

    public Calculoicms getCodcalculoicms() {
        return codcalculoicms;
    }

    public void setCodcalculoicms(Calculoicms codcalculoicms) {
        Calculoicms oldCodcalculoicms = this.codcalculoicms;
        this.codcalculoicms = codcalculoicms;
        changeSupport.firePropertyChange("codcalculoicms", oldCodcalculoicms, codcalculoicms);
    }

    public Calculoiss getCodcalculoiss() {
        return codcalculoiss;
    }

    public void setCodcalculoiss(Calculoiss codcalculoiss) {
        Calculoiss oldCodcalculoiss = this.codcalculoiss;
        this.codcalculoiss = codcalculoiss;
        changeSupport.firePropertyChange("codcalculoiss", oldCodcalculoiss, codcalculoiss);
    }

    public Fornecedor getCodforn() {
        return codforn;
    }

    public void setCodforn(Fornecedor codforn) {
        Fornecedor oldCodforn = this.codforn;
        this.codforn = codforn;
        changeSupport.firePropertyChange("codforn", oldCodforn, codforn);
    }

    public Gtintributavel getCodgtintributavel() {
        return codgtintributavel;
    }

    public void setCodgtintributavel(Gtintributavel codgtintributavel) {
        Gtintributavel oldCodgtintributavel = this.codgtintributavel;
        this.codgtintributavel = codgtintributavel;
        changeSupport.firePropertyChange("codgtintributavel", oldCodgtintributavel, codgtintributavel);
    }

    public Mensagem getCodmensagem() {
        return codmensagem;
    }

    public void setCodmensagem(Mensagem codmensagem) {
        Mensagem oldCodmensagem = this.codmensagem;
        this.codmensagem = codmensagem;
        changeSupport.firePropertyChange("codmensagem", oldCodmensagem, codmensagem);
    }

    public Moeda getCodmoeda() {
        return codmoeda;
    }

    public void setCodmoeda(Moeda codmoeda) {
        Moeda oldCodmoeda = this.codmoeda;
        this.codmoeda = codmoeda;
        changeSupport.firePropertyChange("codmoeda", oldCodmoeda, codmoeda);
    }

    public Produtograde getCodprodgrade() {
        return codprodgrade;
    }

    public void setCodprodgrade(Produtograde codprodgrade) {
        Produtograde oldCodprodgrade = this.codprodgrade;
        this.codprodgrade = codprodgrade;
        changeSupport.firePropertyChange("codprodgrade", oldCodprodgrade, codprodgrade);
    }

    public Produtoperigoso getCodprodutoperigoso() {
        return codprodutoperigoso;
    }

    public void setCodprodutoperigoso(Produtoperigoso codprodutoperigoso) {
        Produtoperigoso oldCodprodutoperigoso = this.codprodutoperigoso;
        this.codprodutoperigoso = codprodutoperigoso;
        changeSupport.firePropertyChange("codprodutoperigoso", oldCodprodutoperigoso, codprodutoperigoso);
    }

    public Unidade getCodunidade() {
        return codunidade;
    }

    public void setCodunidade(Unidade codunidade) {
        Unidade oldCodunidade = this.codunidade;
        this.codunidade = codunidade;
        changeSupport.firePropertyChange("codunidade", oldCodunidade, codunidade);
    }

    public Secao getCodsec() {
        return codsec;
    }

    public void setCodsec(Secao codsec) {
        Secao oldCodsec = this.codsec;
        this.codsec = codsec;
        changeSupport.firePropertyChange("codsec", oldCodsec, codsec);
    }

    public Tributacaoecf getCodtributacaoecf() {
        return codtributacaoecf;
    }

    public void setCodtributacaoecf(Tributacaoecf codtributacaoecf) {
        Tributacaoecf oldCodtributacaoecf = this.codtributacaoecf;
        this.codtributacaoecf = codtributacaoecf;
        changeSupport.firePropertyChange("codtributacaoecf", oldCodtributacaoecf, codtributacaoecf);
    }

    public Regracfop getCodregracfop() {
        return codregracfop;
    }

    public void setCodregracfop(Regracfop codregracfop) {
        Regracfop oldCodregracfop = this.codregracfop;
        this.codregracfop = codregracfop;
        changeSupport.firePropertyChange("codregracfop", oldCodregracfop, codregracfop);
    }

    @XmlTransient
    public Collection<Produtocaracteristica> getProdutocaracteristicaCollection() {
        return produtocaracteristicaCollection;
    }

    public void setProdutocaracteristicaCollection(Collection<Produtocaracteristica> produtocaracteristicaCollection) {
        this.produtocaracteristicaCollection = produtocaracteristicaCollection;
    }

    @XmlTransient
    public Collection<Produtocodigo> getProdutocodigoCollection() {
        return produtocodigoCollection;
    }

    public void setProdutocodigoCollection(Collection<Produtocodigo> produtocodigoCollection) {
        this.produtocodigoCollection = produtocodigoCollection;
    }

    @XmlTransient
    public Collection<AcertoProdloteproduto> getAcertoProdloteprodutoCollection() {
        return acertoProdloteprodutoCollection;
    }

    public void setAcertoProdloteprodutoCollection(Collection<AcertoProdloteproduto> acertoProdloteprodutoCollection) {
        this.acertoProdloteprodutoCollection = acertoProdloteprodutoCollection;
    }

    @XmlTransient
    public Collection<Historicobuscapreco> getHistoricobuscaprecoCollection() {
        return historicobuscaprecoCollection;
    }

    public void setHistoricobuscaprecoCollection(Collection<Historicobuscapreco> historicobuscaprecoCollection) {
        this.historicobuscaprecoCollection = historicobuscaprecoCollection;
    }

    @XmlTransient
    public Collection<Produtoprecoescalonado> getProdutoprecoescalonadoCollection() {
        return produtoprecoescalonadoCollection;
    }

    public void setProdutoprecoescalonadoCollection(Collection<Produtoprecoescalonado> produtoprecoescalonadoCollection) {
        this.produtoprecoescalonadoCollection = produtoprecoescalonadoCollection;
    }

    @XmlTransient
    public Collection<Orcamentoprod> getOrcamentoprodCollection() {
        return orcamentoprodCollection;
    }

    public void setOrcamentoprodCollection(Collection<Orcamentoprod> orcamentoprodCollection) {
        this.orcamentoprodCollection = orcamentoprodCollection;
    }

    @XmlTransient
    public Collection<Relacionado> getRelacionadoCollection() {
        return relacionadoCollection;
    }

    public void setRelacionadoCollection(Collection<Relacionado> relacionadoCollection) {
        this.relacionadoCollection = relacionadoCollection;
    }

    @XmlTransient
    public Collection<Produtofoto> getProdutofotoCollection() {
        return produtofotoCollection;
    }

    public void setProdutofotoCollection(Collection<Produtofoto> produtofotoCollection) {
        this.produtofotoCollection = produtofotoCollection;
    }

    @XmlTransient
    public Collection<Contratocobrancaproduto> getContratocobrancaprodutoCollection() {
        return contratocobrancaprodutoCollection;
    }

    public void setContratocobrancaprodutoCollection(Collection<Contratocobrancaproduto> contratocobrancaprodutoCollection) {
        this.contratocobrancaprodutoCollection = contratocobrancaprodutoCollection;
    }

    @XmlTransient
    public Collection<Movendaproddevolucaocompra> getMovendaproddevolucaocompraCollection() {
        return movendaproddevolucaocompraCollection;
    }

    public void setMovendaproddevolucaocompraCollection(Collection<Movendaproddevolucaocompra> movendaproddevolucaocompraCollection) {
        this.movendaproddevolucaocompraCollection = movendaproddevolucaocompraCollection;
    }

    @XmlTransient
    public Collection<Clienteproduto> getClienteprodutoCollection() {
        return clienteprodutoCollection;
    }

    public void setClienteprodutoCollection(Collection<Clienteproduto> clienteprodutoCollection) {
        this.clienteprodutoCollection = clienteprodutoCollection;
    }

    @XmlTransient
    public Collection<Producaoitem> getProducaoitemCollection() {
        return producaoitemCollection;
    }

    public void setProducaoitemCollection(Collection<Producaoitem> producaoitemCollection) {
        this.producaoitemCollection = producaoitemCollection;
    }

    @XmlTransient
    public Collection<Nfceletronicapafecfprod> getNfceletronicapafecfprodCollection() {
        return nfceletronicapafecfprodCollection;
    }

    public void setNfceletronicapafecfprodCollection(Collection<Nfceletronicapafecfprod> nfceletronicapafecfprodCollection) {
        this.nfceletronicapafecfprodCollection = nfceletronicapafecfprodCollection;
    }

    @XmlTransient
    public Collection<Produtoproducao> getProdutoproducaoCollection() {
        return produtoproducaoCollection;
    }

    public void setProdutoproducaoCollection(Collection<Produtoproducao> produtoproducaoCollection) {
        this.produtoproducaoCollection = produtoproducaoCollection;
    }

    @XmlTransient
    public Collection<Produtoproducao> getProdutoproducaoCollection1() {
        return produtoproducaoCollection1;
    }

    public void setProdutoproducaoCollection1(Collection<Produtoproducao> produtoproducaoCollection1) {
        this.produtoproducaoCollection1 = produtoproducaoCollection1;
    }

    @XmlTransient
    public Collection<Produtofci> getProdutofciCollection() {
        return produtofciCollection;
    }

    public void setProdutofciCollection(Collection<Produtofci> produtofciCollection) {
        this.produtofciCollection = produtofciCollection;
    }

    @XmlTransient
    public Collection<AcertoProdfciproduto> getAcertoProdfciprodutoCollection() {
        return acertoProdfciprodutoCollection;
    }

    public void setAcertoProdfciprodutoCollection(Collection<AcertoProdfciproduto> acertoProdfciprodutoCollection) {
        this.acertoProdfciprodutoCollection = acertoProdfciprodutoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codprod != null ? codprod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.codprod == null && other.codprod != null) || (this.codprod != null && !this.codprod.equals(other.codprod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Produto[ codprod=" + codprod + " ]";
    }

  //  public String getCodfabricante() {
   //     return codfabricante;
   // }

   // public void setCodfabricante(String codfabricante) {
  //      this.codfabricante = codfabricante;
   // }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
