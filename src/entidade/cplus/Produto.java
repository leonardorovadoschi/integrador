/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

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
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "PRODUTO", catalog = "", schema = "")

public class Produto implements Serializable {

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
        this.codprod = codprod;
    }

    public String getCoditemgradedetalheh() {
        return coditemgradedetalheh;
    }

    public void setCoditemgradedetalheh(String coditemgradedetalheh) {
        this.coditemgradedetalheh = coditemgradedetalheh;
    }

    public String getCoditemgradedetalhev() {
        return coditemgradedetalhev;
    }

    public void setCoditemgradedetalhev(String coditemgradedetalhev) {
        this.coditemgradedetalhev = coditemgradedetalhev;
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
        this.codfabricante = codfabricante;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCoduser() {
        return coduser;
    }

    public void setCoduser(String coduser) {
        this.coduser = coduser;
    }

    public String getCodloc() {
        return codloc;
    }

    public void setCodloc(String codloc) {
        this.codloc = codloc;
    }

    public String getNomeprod() {
        return nomeprod;
    }

    public void setNomeprod(String nomeprod) {
        this.nomeprod = nomeprod;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Character getFlaginativo() {
        return flaginativo;
    }

    public void setFlaginativo(Character flaginativo) {
        this.flaginativo = flaginativo;
    }

    public Date getDatreaj() {
        return datreaj;
    }

    public void setDatreaj(Date datreaj) {
        this.datreaj = datreaj;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public BigDecimal getPrecusto() {
        return precusto;
    }

    public void setPrecusto(BigDecimal precusto) {
        this.precusto = precusto;
    }

    public BigDecimal getCustomedio() {
        return customedio;
    }

    public void setCustomedio(BigDecimal customedio) {
        this.customedio = customedio;
    }

    public BigDecimal getOutros() {
        return outros;
    }

    public void setOutros(BigDecimal outros) {
        this.outros = outros;
    }

    public BigDecimal getCustoreal() {
        return custoreal;
    }

    public void setCustoreal(BigDecimal custoreal) {
        this.custoreal = custoreal;
    }

    public Date getLastChange() {
        return lastChange;
    }

    public void setLastChange(Date lastChange) {
        this.lastChange = lastChange;
    }

    public BigDecimal getPesobruto() {
        return pesobruto;
    }

    public void setPesobruto(BigDecimal pesobruto) {
        this.pesobruto = pesobruto;
    }

    public BigDecimal getPesoliquido() {
        return pesoliquido;
    }

    public void setPesoliquido(BigDecimal pesoliquido) {
        this.pesoliquido = pesoliquido;
    }

    public BigDecimal getComissao() {
        return comissao;
    }

    public void setComissao(BigDecimal comissao) {
        this.comissao = comissao;
    }

    public Character getFlagcontrolaestoque() {
        return flagcontrolaestoque;
    }

    public void setFlagcontrolaestoque(Character flagcontrolaestoque) {
        this.flagcontrolaestoque = flagcontrolaestoque;
    }

    public Character getFlagservico() {
        return flagservico;
    }

    public void setFlagservico(Character flagservico) {
        this.flagservico = flagservico;
    }

    public Character getFlagnaovender() {
        return flagnaovender;
    }

    public void setFlagnaovender(Character flagnaovender) {
        this.flagnaovender = flagnaovender;
    }

    public Character getFlaglancacomposicao() {
        return flaglancacomposicao;
    }

    public void setFlaglancacomposicao(Character flaglancacomposicao) {
        this.flaglancacomposicao = flaglancacomposicao;
    }

    public BigDecimal getDescmaximo() {
        return descmaximo;
    }

    public void setDescmaximo(BigDecimal descmaximo) {
        this.descmaximo = descmaximo;
    }

    public Character getFlagvendecomposicao() {
        return flagvendecomposicao;
    }

    public void setFlagvendecomposicao(Character flagvendecomposicao) {
        this.flagvendecomposicao = flagvendecomposicao;
    }

    public String getNomeprodcurto() {
        return nomeprodcurto;
    }

    public void setNomeprodcurto(String nomeprodcurto) {
        this.nomeprodcurto = nomeprodcurto;
    }

    public Character getFlagtipocomissao() {
        return flagtipocomissao;
    }

    public void setFlagtipocomissao(Character flagtipocomissao) {
        this.flagtipocomissao = flagtipocomissao;
    }

    public Character getFlagusacomissao() {
        return flagusacomissao;
    }

    public void setFlagusacomissao(Character flagusacomissao) {
        this.flagusacomissao = flagusacomissao;
    }

    public Integer getPrazogarantia() {
        return prazogarantia;
    }

    public void setPrazogarantia(Integer prazogarantia) {
        this.prazogarantia = prazogarantia;
    }

    public BigDecimal getPercoutroscustos() {
        return percoutroscustos;
    }

    public void setPercoutroscustos(BigDecimal percoutroscustos) {
        this.percoutroscustos = percoutroscustos;
    }

    public BigDecimal getValoutroscustos() {
        return valoutroscustos;
    }

    public void setValoutroscustos(BigDecimal valoutroscustos) {
        this.valoutroscustos = valoutroscustos;
    }

    public BigDecimal getTotoutroscustos() {
        return totoutroscustos;
    }

    public void setTotoutroscustos(BigDecimal totoutroscustos) {
        this.totoutroscustos = totoutroscustos;
    }

    public Integer getCodigoreceita() {
        return codigoreceita;
    }

    public void setCodigoreceita(Integer codigoreceita) {
        this.codigoreceita = codigoreceita;
    }

    public Integer getValidade() {
        return validade;
    }

    public void setValidade(Integer validade) {
        this.validade = validade;
    }

    public Character getFlagsolicitacomplemento() {
        return flagsolicitacomplemento;
    }

    public void setFlagsolicitacomplemento(Character flagsolicitacomplemento) {
        this.flagsolicitacomplemento = flagsolicitacomplemento;
    }

    public Character getFlaggeraserial() {
        return flaggeraserial;
    }

    public void setFlaggeraserial(Character flaggeraserial) {
        this.flaggeraserial = flaggeraserial;
    }

    public Integer getPrazoentrega() {
        return prazoentrega;
    }

    public void setPrazoentrega(Integer prazoentrega) {
        this.prazoentrega = prazoentrega;
    }

    public Integer getParcelamentosj() {
        return parcelamentosj;
    }

    public void setParcelamentosj(Integer parcelamentosj) {
        this.parcelamentosj = parcelamentosj;
    }

    public BigDecimal getPercoutroscustos2() {
        return percoutroscustos2;
    }

    public void setPercoutroscustos2(BigDecimal percoutroscustos2) {
        this.percoutroscustos2 = percoutroscustos2;
    }

    public BigDecimal getPercoutroscustos3() {
        return percoutroscustos3;
    }

    public void setPercoutroscustos3(BigDecimal percoutroscustos3) {
        this.percoutroscustos3 = percoutroscustos3;
    }

    public BigDecimal getPercoutroscustos4() {
        return percoutroscustos4;
    }

    public void setPercoutroscustos4(BigDecimal percoutroscustos4) {
        this.percoutroscustos4 = percoutroscustos4;
    }

    public BigDecimal getPercoutroscustos5() {
        return percoutroscustos5;
    }

    public void setPercoutroscustos5(BigDecimal percoutroscustos5) {
        this.percoutroscustos5 = percoutroscustos5;
    }

    public BigDecimal getPercoutroscustos6() {
        return percoutroscustos6;
    }

    public void setPercoutroscustos6(BigDecimal percoutroscustos6) {
        this.percoutroscustos6 = percoutroscustos6;
    }

    public String getAplicacao() {
        return aplicacao;
    }

    public void setAplicacao(String aplicacao) {
        this.aplicacao = aplicacao;
    }

    public Date getDatcad() {
        return datcad;
    }

    public void setDatcad(Date datcad) {
        this.datcad = datcad;
    }

    public String getNomeprodweb() {
        return nomeprodweb;
    }

    public void setNomeprodweb(String nomeprodweb) {
        this.nomeprodweb = nomeprodweb;
    }

    public BigDecimal getQtdeembalagem() {
        return qtdeembalagem;
    }

    public void setQtdeembalagem(BigDecimal qtdeembalagem) {
        this.qtdeembalagem = qtdeembalagem;
    }

    public Character getFlagusagrade() {
        return flagusagrade;
    }

    public void setFlagusagrade(Character flagusagrade) {
        this.flagusagrade = flagusagrade;
    }

    public Character getFlagnaosaitabela() {
        return flagnaosaitabela;
    }

    public void setFlagnaosaitabela(Character flagnaosaitabela) {
        this.flagnaosaitabela = flagnaosaitabela;
    }

    public Character getFlagorigemproduto() {
        return flagorigemproduto;
    }

    public void setFlagorigemproduto(Character flagorigemproduto) {
        this.flagorigemproduto = flagorigemproduto;
    }

    public Character getFlagcomposto() {
        return flagcomposto;
    }

    public void setFlagcomposto(Character flagcomposto) {
        this.flagcomposto = flagcomposto;
    }

    public String getCodigointerno() {
        return codigointerno;
    }

    public void setCodigointerno(String codigointerno) {
        this.codigointerno = codigointerno;
    }

    public Character getFlagcontrolavalidade() {
        return flagcontrolavalidade;
    }

    public void setFlagcontrolavalidade(Character flagcontrolavalidade) {
        this.flagcontrolavalidade = flagcontrolavalidade;
    }

    public Character getFlagcontrolalote() {
        return flagcontrolalote;
    }

    public void setFlagcontrolalote(Character flagcontrolalote) {
        this.flagcontrolalote = flagcontrolalote;
    }

    public Character getFlagcontrolaserial() {
        return flagcontrolaserial;
    }

    public void setFlagcontrolaserial(Character flagcontrolaserial) {
        this.flagcontrolaserial = flagcontrolaserial;
    }

    public BigDecimal getQuantidadeembalagem() {
        return quantidadeembalagem;
    }

    public void setQuantidadeembalagem(BigDecimal quantidadeembalagem) {
        this.quantidadeembalagem = quantidadeembalagem;
    }

    public String getTipoitem() {
        return tipoitem;
    }

    public void setTipoitem(String tipoitem) {
        this.tipoitem = tipoitem;
    }

    public String getCstipientrada() {
        return cstipientrada;
    }

    public void setCstipientrada(String cstipientrada) {
        this.cstipientrada = cstipientrada;
    }

    public String getCstipisaida() {
        return cstipisaida;
    }

    public void setCstipisaida(String cstipisaida) {
        this.cstipisaida = cstipisaida;
    }

    public Character getFlagproducao() {
        return flagproducao;
    }

    public void setFlagproducao(Character flagproducao) {
        this.flagproducao = flagproducao;
    }

    public String getDescricaoweb() {
        return descricaoweb;
    }

    public void setDescricaoweb(String descricaoweb) {
        this.descricaoweb = descricaoweb;
    }

    public String getDescricaoipem() {
        return descricaoipem;
    }

    public void setDescricaoipem(String descricaoipem) {
        this.descricaoipem = descricaoipem;
    }

    public String getDescricaoembalagem() {
        return descricaoembalagem;
    }

    public void setDescricaoembalagem(String descricaoembalagem) {
        this.descricaoembalagem = descricaoembalagem;
    }

    public String getCfopdentrouf() {
        return cfopdentrouf;
    }

    public void setCfopdentrouf(String cfopdentrouf) {
        this.cfopdentrouf = cfopdentrouf;
    }

    public String getCfopforauf() {
        return cfopforauf;
    }

    public void setCfopforauf(String cfopforauf) {
        this.cfopforauf = cfopforauf;
    }

    public Character getFlagcalculapis() {
        return flagcalculapis;
    }

    public void setFlagcalculapis(Character flagcalculapis) {
        this.flagcalculapis = flagcalculapis;
    }

    public Character getFlagcalculacofins() {
        return flagcalculacofins;
    }

    public void setFlagcalculacofins(Character flagcalculacofins) {
        this.flagcalculacofins = flagcalculacofins;
    }

    public BigDecimal getPesoespecifico() {
        return pesoespecifico;
    }

    public void setPesoespecifico(BigDecimal pesoespecifico) {
        this.pesoespecifico = pesoespecifico;
    }

    public BigDecimal getLitragem() {
        return litragem;
    }

    public void setLitragem(BigDecimal litragem) {
        this.litragem = litragem;
    }

    public BigDecimal getValoripi() {
        return valoripi;
    }

    public void setValoripi(BigDecimal valoripi) {
        this.valoripi = valoripi;
    }

    public BigDecimal getValorsubsttributaria() {
        return valorsubsttributaria;
    }

    public void setValorsubsttributaria(BigDecimal valorsubsttributaria) {
        this.valorsubsttributaria = valorsubsttributaria;
    }

    public BigDecimal getValorfrete() {
        return valorfrete;
    }

    public void setValorfrete(BigDecimal valorfrete) {
        this.valorfrete = valorfrete;
    }

    public BigDecimal getValoroutrasdesp() {
        return valoroutrasdesp;
    }

    public void setValoroutrasdesp(BigDecimal valoroutrasdesp) {
        this.valoroutrasdesp = valoroutrasdesp;
    }

    public Character getFlagaliqicmsinterna() {
        return flagaliqicmsinterna;
    }

    public void setFlagaliqicmsinterna(Character flagaliqicmsinterna) {
        this.flagaliqicmsinterna = flagaliqicmsinterna;
    }

    public Character getClassificacaoabc() {
        return classificacaoabc;
    }

    public void setClassificacaoabc(Character classificacaoabc) {
        this.classificacaoabc = classificacaoabc;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public String getCodunidadecompra() {
        return codunidadecompra;
    }

    public void setCodunidadecompra(String codunidadecompra) {
        this.codunidadecompra = codunidadecompra;
    }

    public String getCodmod() {
        return codmod;
    }

    public void setCodmod(String codmod) {
        this.codmod = codmod;
    }

    public Integer getSerialsequencia() {
        return serialsequencia;
    }

    public void setSerialsequencia(Integer serialsequencia) {
        this.serialsequencia = serialsequencia;
    }

    public String getSerialcaracteres() {
        return serialcaracteres;
    }

    public void setSerialcaracteres(String serialcaracteres) {
        this.serialcaracteres = serialcaracteres;
    }

    public BigDecimal getCotacaoatual() {
        return cotacaoatual;
    }

    public void setCotacaoatual(BigDecimal cotacaoatual) {
        this.cotacaoatual = cotacaoatual;
    }

    public BigDecimal getAltura() {
        return altura;
    }

    public void setAltura(BigDecimal altura) {
        this.altura = altura;
    }

    public BigDecimal getLargura() {
        return largura;
    }

    public void setLargura(BigDecimal largura) {
        this.largura = largura;
    }

    public BigDecimal getComprimento() {
        return comprimento;
    }

    public void setComprimento(BigDecimal comprimento) {
        this.comprimento = comprimento;
    }

    public String getCstpisentrada() {
        return cstpisentrada;
    }

    public void setCstpisentrada(String cstpisentrada) {
        this.cstpisentrada = cstpisentrada;
    }

    public String getCstpissaida() {
        return cstpissaida;
    }

    public void setCstpissaida(String cstpissaida) {
        this.cstpissaida = cstpissaida;
    }

    public String getCstcofinsentrada() {
        return cstcofinsentrada;
    }

    public void setCstcofinsentrada(String cstcofinsentrada) {
        this.cstcofinsentrada = cstcofinsentrada;
    }

    public String getCstcofinssaida() {
        return cstcofinssaida;
    }

    public void setCstcofinssaida(String cstcofinssaida) {
        this.cstcofinssaida = cstcofinssaida;
    }

    public BigDecimal getAliqpis() {
        return aliqpis;
    }

    public void setAliqpis(BigDecimal aliqpis) {
        this.aliqpis = aliqpis;
    }

    public BigDecimal getAliqcofins() {
        return aliqcofins;
    }

    public void setAliqcofins(BigDecimal aliqcofins) {
        this.aliqcofins = aliqcofins;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getObssite() {
        return obssite;
    }

    public void setObssite(String obssite) {
        this.obssite = obssite;
    }

    public String getCodbalancainfoextra() {
        return codbalancainfoextra;
    }

    public void setCodbalancainfoextra(String codbalancainfoextra) {
        this.codbalancainfoextra = codbalancainfoextra;
    }

    public String getCodbalancaimagem() {
        return codbalancaimagem;
    }

    public void setCodbalancaimagem(String codbalancaimagem) {
        this.codbalancaimagem = codbalancaimagem;
    }

    public String getCodbalancanutricional() {
        return codbalancanutricional;
    }

    public void setCodbalancanutricional(String codbalancanutricional) {
        this.codbalancanutricional = codbalancanutricional;
    }

    public String getFundamentolegal() {
        return fundamentolegal;
    }

    public void setFundamentolegal(String fundamentolegal) {
        this.fundamentolegal = fundamentolegal;
    }

    public String getCodnaturezareceita() {
        return codnaturezareceita;
    }

    public void setCodnaturezareceita(String codnaturezareceita) {
        this.codnaturezareceita = codnaturezareceita;
    }

    public Integer getCreditopresumido() {
        return creditopresumido;
    }

    public void setCreditopresumido(Integer creditopresumido) {
        this.creditopresumido = creditopresumido;
    }

    public Character getFlagfarmaciamanipulacao() {
        return flagfarmaciamanipulacao;
    }

    public void setFlagfarmaciamanipulacao(Character flagfarmaciamanipulacao) {
        this.flagfarmaciamanipulacao = flagfarmaciamanipulacao;
    }

    public Character getFlagenviowms() {
        return flagenviowms;
    }

    public void setFlagenviowms(Character flagenviowms) {
        this.flagenviowms = flagenviowms;
    }

    public String getLiberacaoestado() {
        return liberacaoestado;
    }

    public void setLiberacaoestado(String liberacaoestado) {
        this.liberacaoestado = liberacaoestado;
    }

    public BigDecimal getPredolar() {
        return predolar;
    }

    public void setPredolar(BigDecimal predolar) {
        this.predolar = predolar;
    }

    public String getCodenquadramentoipi() {
        return codenquadramentoipi;
    }

    public void setCodenquadramentoipi(String codenquadramentoipi) {
        this.codenquadramentoipi = codenquadramentoipi;
    }

    public BigDecimal getQuantidadeembalagemmst() {
        return quantidadeembalagemmst;
    }

    public void setQuantidadeembalagemmst(BigDecimal quantidadeembalagemmst) {
        this.quantidadeembalagemmst = quantidadeembalagemmst;
    }

    public String getFundamentolegalicms() {
        return fundamentolegalicms;
    }

    public void setFundamentolegalicms(String fundamentolegalicms) {
        this.fundamentolegalicms = fundamentolegalicms;
    }

    public BigDecimal getQtdmaxwms() {
        return qtdmaxwms;
    }

    public void setQtdmaxwms(BigDecimal qtdmaxwms) {
        this.qtdmaxwms = qtdmaxwms;
    }

    public BigDecimal getQtdminwms() {
        return qtdminwms;
    }

    public void setQtdminwms(BigDecimal qtdminwms) {
        this.qtdminwms = qtdminwms;
    }

    public Character getFlagarredonda() {
        return flagarredonda;
    }

    public void setFlagarredonda(Character flagarredonda) {
        this.flagarredonda = flagarredonda;
    }

    public Character getFlagusareducaobaseicmsstprod() {
        return flagusareducaobaseicmsstprod;
    }

    public void setFlagusareducaobaseicmsstprod(Character flagusareducaobaseicmsstprod) {
        this.flagusareducaobaseicmsstprod = flagusareducaobaseicmsstprod;
    }

    public BigDecimal getRaio() {
        return raio;
    }

    public void setRaio(BigDecimal raio) {
        this.raio = raio;
    }

    public BigDecimal getCubagem() {
        return cubagem;
    }

    public void setCubagem(BigDecimal cubagem) {
        this.cubagem = cubagem;
    }

    public BigDecimal getDensidade() {
        return densidade;
    }

    public void setDensidade(BigDecimal densidade) {
        this.densidade = densidade;
    }

    public BigDecimal getPesocubado() {
        return pesocubado;
    }

    public void setPesocubado(BigDecimal pesocubado) {
        this.pesocubado = pesocubado;
    }

    public BigDecimal getValorfcpsubsttributaria() {
        return valorfcpsubsttributaria;
    }

    public void setValorfcpsubsttributaria(BigDecimal valorfcpsubsttributaria) {
        this.valorfcpsubsttributaria = valorfcpsubsttributaria;
    }

    public Character getFlagloterastreavel() {
        return flagloterastreavel;
    }

    public void setFlagloterastreavel(Character flagloterastreavel) {
        this.flagloterastreavel = flagloterastreavel;
    }

    public BigDecimal getQuantidadetributavel() {
        return quantidadetributavel;
    }

    public void setQuantidadetributavel(BigDecimal quantidadetributavel) {
        this.quantidadetributavel = quantidadetributavel;
    }

    public BigDecimal getQuantidadetributavelexp() {
        return quantidadetributavelexp;
    }

    public void setQuantidadetributavelexp(BigDecimal quantidadetributavelexp) {
        this.quantidadetributavelexp = quantidadetributavelexp;
    }

    public BigDecimal getValordesconto() {
        return valordesconto;
    }

    public void setValordesconto(BigDecimal valordesconto) {
        this.valordesconto = valordesconto;
    }

    public String getObsfiscalcontabil() {
        return obsfiscalcontabil;
    }

    public void setObsfiscalcontabil(String obsfiscalcontabil) {
        this.obsfiscalcontabil = obsfiscalcontabil;
    }

    public Character getFlagaltpaf() {
        return flagaltpaf;
    }

    public void setFlagaltpaf(Character flagaltpaf) {
        this.flagaltpaf = flagaltpaf;
    }

    public BigDecimal getPercvol() {
        return percvol;
    }

    public void setPercvol(BigDecimal percvol) {
        this.percvol = percvol;
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
        this.codprodutoanp = codprodutoanp;
    }

    public Classificacaofiscal getCodclassificacaofiscal() {
        return codclassificacaofiscal;
    }

    public void setCodclassificacaofiscal(Classificacaofiscal codclassificacaofiscal) {
        this.codclassificacaofiscal = codclassificacaofiscal;
    }

    public Calculoicms getCodcalculoicms() {
        return codcalculoicms;
    }

    public void setCodcalculoicms(Calculoicms codcalculoicms) {
        this.codcalculoicms = codcalculoicms;
    }

    public Calculoiss getCodcalculoiss() {
        return codcalculoiss;
    }

    public void setCodcalculoiss(Calculoiss codcalculoiss) {
        this.codcalculoiss = codcalculoiss;
    }

    public Fornecedor getCodforn() {
        return codforn;
    }

    public void setCodforn(Fornecedor codforn) {
        this.codforn = codforn;
    }

    public Gtintributavel getCodgtintributavel() {
        return codgtintributavel;
    }

    public void setCodgtintributavel(Gtintributavel codgtintributavel) {
        this.codgtintributavel = codgtintributavel;
    }

    public Mensagem getCodmensagem() {
        return codmensagem;
    }

    public void setCodmensagem(Mensagem codmensagem) {
        this.codmensagem = codmensagem;
    }

    public Moeda getCodmoeda() {
        return codmoeda;
    }

    public void setCodmoeda(Moeda codmoeda) {
        this.codmoeda = codmoeda;
    }

    public Produtograde getCodprodgrade() {
        return codprodgrade;
    }

    public void setCodprodgrade(Produtograde codprodgrade) {
        this.codprodgrade = codprodgrade;
    }

    public Produtoperigoso getCodprodutoperigoso() {
        return codprodutoperigoso;
    }

    public void setCodprodutoperigoso(Produtoperigoso codprodutoperigoso) {
        this.codprodutoperigoso = codprodutoperigoso;
    }

    public Unidade getCodunidade() {
        return codunidade;
    }

    public void setCodunidade(Unidade codunidade) {
        this.codunidade = codunidade;
    }

    public Secao getCodsec() {
        return codsec;
    }

    public void setCodsec(Secao codsec) {
        this.codsec = codsec;
    }

    public Tributacaoecf getCodtributacaoecf() {
        return codtributacaoecf;
    }

    public void setCodtributacaoecf(Tributacaoecf codtributacaoecf) {
        this.codtributacaoecf = codtributacaoecf;
    }

    public Regracfop getCodregracfop() {
        return codregracfop;
    }

    public void setCodregracfop(Regracfop codregracfop) {
        this.codregracfop = codregracfop;
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
    
}
