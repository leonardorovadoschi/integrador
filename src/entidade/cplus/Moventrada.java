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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "MOVENTRADA", catalog = "", schema = "")
@XmlRootElement

public class Moventrada implements Serializable {

   // @Column(name = "CODFORN")
   /// private String codforn;
    @Column(name = "CODINTERMEDIADOR")
    private String codintermediador;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODMOVENTR")
    private String codmoventr;
    //@Column(name = "CODFORN")
   // private String codforn;
    @Column(name = "CODUSER")
    private String coduser;
    @Column(name = "CODMOVENDAAUX")
    private String codmovendaaux;
    @Column(name = "CODMOVENDA")
    private String codmovenda;
    @Column(name = "DATAEMISSAO")
    @Temporal(TemporalType.DATE)
    private Date dataemissao;
    @Basic(optional = false)
    @Column(name = "DATA")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "NUMNOTA")
    private Integer numnota;
    @Column(name = "SERIENOTA")
    private String serienota;
    @Column(name = "MODELONOTA")
    private String modelonota;
    @Lob
    @Column(name = "OBS")
    private String obs;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "BASEICMS")
    private BigDecimal baseicms;
    @Column(name = "VALORICMS")
    private BigDecimal valoricms;
    @Column(name = "BASESUBSTTRIBUTARIA")
    private BigDecimal basesubsttributaria;
    @Column(name = "VALORSUBSTTRIBUTARIA")
    private BigDecimal valorsubsttributaria;
    @Basic(optional = false)
    @Column(name = "VALORFRETE")
    private BigDecimal valorfrete;
    @Column(name = "VALORSEGURO")
    private BigDecimal valorseguro;
    @Column(name = "VALOROUTRASDESPESAS")
    private BigDecimal valoroutrasdespesas;
    @Column(name = "VALORDESCONTO")
    private BigDecimal valordesconto;
    @Column(name = "VALORACRESCIMO")
    private BigDecimal valoracrescimo;
    @Column(name = "COTACAOMOEDA")
    private BigDecimal cotacaomoeda;
    @Column(name = "NUMTRANSF")
    private Integer numtransf;
    @Column(name = "FLAGFORNCLI")
    private Character flagforncli;
    @Column(name = "FLAGTIPODESCONTO")
    private Character flagtipodesconto;
    @Column(name = "FLAGTIPOACRESCIMO")
    private Character flagtipoacrescimo;
    @Column(name = "HORA")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @Column(name = "FLAGCANCELADA")
    private Character flagcancelada;
    @Column(name = "FLAGEMISSAOPROPRIA")
    private Character flagemissaopropria;
    @Column(name = "CODTRANS")
    private String codtrans;
    @Column(name = "QUANTIDADEVOLUMES")
    private Integer quantidadevolumes;
    @Column(name = "VALORTOTALPRODUTOS")
    private BigDecimal valortotalprodutos;
    @Column(name = "VALORTOTALNOTA")
    private BigDecimal valortotalnota;
    @Column(name = "VALORTOTALIPI")
    private BigDecimal valortotalipi;
    @Lob
    @Column(name = "OBSNOTAFISCAL")
    private String obsnotafiscal;
    @Column(name = "FLAGFRETE")
    private Character flagfrete;
    @Column(name = "ALIQACRESCIMO")
    private BigDecimal aliqacrescimo;
    @Column(name = "ALIQDESCONTO")
    private BigDecimal aliqdesconto;
    @Column(name = "FLAGDELIVERY")
    private Character flagdelivery;
    @Column(name = "DATAFISCAL")
    @Temporal(TemporalType.DATE)
    private Date datafiscal;
    @Column(name = "CODFP")
    private String codfp;
    @Column(name = "VALORTOTALCOFINS")
    private BigDecimal valortotalcofins;
    @Column(name = "VALORTOTALPIS")
    private BigDecimal valortotalpis;
    @Column(name = "VALORTOTALSERVICOS")
    private BigDecimal valortotalservicos;
    @Column(name = "VALORTOTALISS")
    private BigDecimal valortotaliss;
    @Column(name = "FLAGESTOQUELIBERADO")
    private Character flagestoqueliberado;
    @Column(name = "CODUSERLIBERACAOESTOQUE")
    private String coduserliberacaoestoque;
    @Column(name = "DATALIBERACAOESTOQUE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataliberacaoestoque;
    @Column(name = "NUMEROCHAVENFE")
    private String numerochavenfe;
    @Column(name = "NUMEROPROTOCOLONFE")
    private String numeroprotocolonfe;
    @Column(name = "CODMOVENDATROCA")
    private String codmovendatroca;
    @Lob
    @Column(name = "XMLNFEENTRADA")
    private String xmlnfeentrada;
    @Column(name = "CODORDEMPRODUCAO")
    private String codordemproducao;
    @Column(name = "NUMGARANTIA")
    private String numgarantia;
    @Column(name = "VALORABATIMENTONAOTRIBICMS")
    private BigDecimal valorabatimentonaotribicms;
    @Column(name = "VALORABATIMENTONAOTRIBPIS")
    private BigDecimal valorabatimentonaotribpis;
    @Column(name = "VALORABATIMENTONAOTRIBCOFINS")
    private BigDecimal valorabatimentonaotribcofins;
    @Column(name = "VALORABATIMENTONAOTRIBIPI")
    private BigDecimal valorabatimentonaotribipi;
    @Column(name = "TIPOPAGAMENTO")
    private Character tipopagamento;
    @Column(name = "VALORTOTALII")
    private BigDecimal valortotalii;
    @Column(name = "GUID")
    private String guid;
    @Column(name = "VALORSUBSTANTECIPADA")
    private BigDecimal valorsubstantecipada;
    @Column(name = "VALORCONHECIMENTOTRANS")
    private BigDecimal valorconhecimentotrans;
    @Column(name = "CODTRANSREDESPACHO")
    private String codtransredespacho;
    @Column(name = "VALORFRETEREDESPACHO")
    private BigDecimal valorfreteredespacho;
    @Column(name = "CODENTREGAPESSOA")
    private String codentregapessoa;
    @Column(name = "VALORICMSINCENTFISCAL")
    private BigDecimal valoricmsincentfiscal;
    @Column(name = "CODDOCUMENTOREFERENCIADO")
    private String coddocumentoreferenciado;
    @Column(name = "FLAGNFCOMPLEMENTAR")
    private Character flagnfcomplementar;
    @Column(name = "FLAGNFDEVOLUCAO")
    private Character flagnfdevolucao;
    @Column(name = "FLAGENVIOWMS")
    private Character flagenviowms;
    @Column(name = "FLAGNFAJUSTE")
    private Character flagnfajuste;
    @Lob
    @Column(name = "OBSFISCO")
    private String obsfisco;
    @Column(name = "FLAGDOCREFERENCIADO")
    private Character flagdocreferenciado;
    @Column(name = "INDOPERACAO")
    private Character indoperacao;
    @Column(name = "INDPRESENCA")
    private Character indpresenca;
    @Column(name = "IDENTIFICADORDESTINO")
    private Character identificadordestino;
    @Column(name = "VALORFCP")
    private BigDecimal valorfcp;
    @Column(name = "VALORFCPSUBSTTRIBUTARIA")
    private BigDecimal valorfcpsubsttributaria;
    @Column(name = "CODACERTO")
    private String codacerto;
    @Column(name = "VALORICMSDESONERADO")
    private BigDecimal valoricmsdesonerado;
    @JoinColumn(name = "CODCENTROCUSTO", referencedColumnName = "CODCENTROCUSTO")
    @ManyToOne
    private Centrocusto codcentrocusto;
    @JoinColumn(name = "CODCFOP", referencedColumnName = "CODCFOP")
    @ManyToOne
    private Cfop codcfop;
    @JoinColumn(name = "CODCLI", referencedColumnName = "CODCLI")
    @ManyToOne
    private Cliente codcli;
    @JoinColumn(name = "CODEMPRESA", referencedColumnName = "CODEMPRESA")
    @ManyToOne(optional = false)
    private Empresa codempresa;
    @JoinColumn(name = "CODSETORESTOQUE", referencedColumnName = "CODSETORESTOQUE")
    @ManyToOne(optional = false)
    private Setorestoque codsetorestoque;
    @JoinColumn(name = "CODTIPOMOVIMENTO", referencedColumnName = "CODTIPOMOVIMENTO")
    @ManyToOne(optional = false)
    private Tipomovimento codtipomovimento;
    @JoinColumn(name = "CODVENDED", referencedColumnName = "CODVENDED")
    @ManyToOne
    private Vendedor codvended;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codmoventr")
    private Collection<Moventradaprod> moventradaprodCollection;
    @OneToMany(mappedBy = "codmoventr")
    private Collection<Contapagar> contapagarCollection;
    @OneToMany(mappedBy = "codmoventrdevolucao")
    private Collection<Consignacaobaixa> consignacaobaixaCollection;
    @OneToMany(mappedBy = "codmoventr")
    private Collection<Rma> rmaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codmoventr")
    private Collection<Movendadocref> movendadocrefCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codmoventr")
    private Collection<Moventradadocref> moventradadocrefCollection;
    
    @JoinColumn(name = "CODFORN", referencedColumnName = "CODFORN")
    @ManyToOne
    private Fornecedor codForn;
  
    public Fornecedor getCodForn() {
        return codForn;
    }

    public void setCodForn(Fornecedor codForn) {
         Fornecedor oldCodcli = this.codForn;
        this.codForn = codForn;
       // changeSupport.firePropertyChange("codForn", oldCodcli, codForn);
    }

    public Moventrada() {
    }

    public Moventrada(String codmoventr) {
        this.codmoventr = codmoventr;
    }

    public Moventrada(String codmoventr, Date data, BigDecimal valorfrete) {
        this.codmoventr = codmoventr;
        this.data = data;
        this.valorfrete = valorfrete;
    }

    public String getCodmoventr() {
        return codmoventr;
    }

    public void setCodmoventr(String codmoventr) {
        this.codmoventr = codmoventr;
    }

  //  public String getCodforn() {
 //       return codforn;
  //  }

  //  public void setCodforn(String codforn) {
  //      this.codforn = codforn;
  //  }

    public String getCoduser() {
        return coduser;
    }

    public void setCoduser(String coduser) {
        this.coduser = coduser;
    }

    public String getCodmovendaaux() {
        return codmovendaaux;
    }

    public void setCodmovendaaux(String codmovendaaux) {
        this.codmovendaaux = codmovendaaux;
    }

    public String getCodmovenda() {
        return codmovenda;
    }

    public void setCodmovenda(String codmovenda) {
        this.codmovenda = codmovenda;
    }

    public Date getDataemissao() {
        return dataemissao;
    }

    public void setDataemissao(Date dataemissao) {
        this.dataemissao = dataemissao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getNumnota() {
        return numnota;
    }

    public void setNumnota(Integer numnota) {
        this.numnota = numnota;
    }

    public String getSerienota() {
        return serienota;
    }

    public void setSerienota(String serienota) {
        this.serienota = serienota;
    }

    public String getModelonota() {
        return modelonota;
    }

    public void setModelonota(String modelonota) {
        this.modelonota = modelonota;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public BigDecimal getBaseicms() {
        return baseicms;
    }

    public void setBaseicms(BigDecimal baseicms) {
        this.baseicms = baseicms;
    }

    public BigDecimal getValoricms() {
        return valoricms;
    }

    public void setValoricms(BigDecimal valoricms) {
        this.valoricms = valoricms;
    }

    public BigDecimal getBasesubsttributaria() {
        return basesubsttributaria;
    }

    public void setBasesubsttributaria(BigDecimal basesubsttributaria) {
        this.basesubsttributaria = basesubsttributaria;
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

    public BigDecimal getValorseguro() {
        return valorseguro;
    }

    public void setValorseguro(BigDecimal valorseguro) {
        this.valorseguro = valorseguro;
    }

    public BigDecimal getValoroutrasdespesas() {
        return valoroutrasdespesas;
    }

    public void setValoroutrasdespesas(BigDecimal valoroutrasdespesas) {
        this.valoroutrasdespesas = valoroutrasdespesas;
    }

    public BigDecimal getValordesconto() {
        return valordesconto;
    }

    public void setValordesconto(BigDecimal valordesconto) {
        this.valordesconto = valordesconto;
    }

    public BigDecimal getValoracrescimo() {
        return valoracrescimo;
    }

    public void setValoracrescimo(BigDecimal valoracrescimo) {
        this.valoracrescimo = valoracrescimo;
    }

    public BigDecimal getCotacaomoeda() {
        return cotacaomoeda;
    }

    public void setCotacaomoeda(BigDecimal cotacaomoeda) {
        this.cotacaomoeda = cotacaomoeda;
    }

    public Integer getNumtransf() {
        return numtransf;
    }

    public void setNumtransf(Integer numtransf) {
        this.numtransf = numtransf;
    }

    public Character getFlagforncli() {
        return flagforncli;
    }

    public void setFlagforncli(Character flagforncli) {
        this.flagforncli = flagforncli;
    }

    public Character getFlagtipodesconto() {
        return flagtipodesconto;
    }

    public void setFlagtipodesconto(Character flagtipodesconto) {
        this.flagtipodesconto = flagtipodesconto;
    }

    public Character getFlagtipoacrescimo() {
        return flagtipoacrescimo;
    }

    public void setFlagtipoacrescimo(Character flagtipoacrescimo) {
        this.flagtipoacrescimo = flagtipoacrescimo;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Character getFlagcancelada() {
        return flagcancelada;
    }

    public void setFlagcancelada(Character flagcancelada) {
        this.flagcancelada = flagcancelada;
    }

    public Character getFlagemissaopropria() {
        return flagemissaopropria;
    }

    public void setFlagemissaopropria(Character flagemissaopropria) {
        this.flagemissaopropria = flagemissaopropria;
    }

    public String getCodtrans() {
        return codtrans;
    }

    public void setCodtrans(String codtrans) {
        this.codtrans = codtrans;
    }

    public Integer getQuantidadevolumes() {
        return quantidadevolumes;
    }

    public void setQuantidadevolumes(Integer quantidadevolumes) {
        this.quantidadevolumes = quantidadevolumes;
    }

    public BigDecimal getValortotalprodutos() {
        return valortotalprodutos;
    }

    public void setValortotalprodutos(BigDecimal valortotalprodutos) {
        this.valortotalprodutos = valortotalprodutos;
    }

    public BigDecimal getValortotalnota() {
        return valortotalnota;
    }

    public void setValortotalnota(BigDecimal valortotalnota) {
        this.valortotalnota = valortotalnota;
    }

    public BigDecimal getValortotalipi() {
        return valortotalipi;
    }

    public void setValortotalipi(BigDecimal valortotalipi) {
        this.valortotalipi = valortotalipi;
    }

    public String getObsnotafiscal() {
        return obsnotafiscal;
    }

    public void setObsnotafiscal(String obsnotafiscal) {
        this.obsnotafiscal = obsnotafiscal;
    }

    public Character getFlagfrete() {
        return flagfrete;
    }

    public void setFlagfrete(Character flagfrete) {
        this.flagfrete = flagfrete;
    }

    public BigDecimal getAliqacrescimo() {
        return aliqacrescimo;
    }

    public void setAliqacrescimo(BigDecimal aliqacrescimo) {
        this.aliqacrescimo = aliqacrescimo;
    }

    public BigDecimal getAliqdesconto() {
        return aliqdesconto;
    }

    public void setAliqdesconto(BigDecimal aliqdesconto) {
        this.aliqdesconto = aliqdesconto;
    }

    public Character getFlagdelivery() {
        return flagdelivery;
    }

    public void setFlagdelivery(Character flagdelivery) {
        this.flagdelivery = flagdelivery;
    }

    public Date getDatafiscal() {
        return datafiscal;
    }

    public void setDatafiscal(Date datafiscal) {
        this.datafiscal = datafiscal;
    }

    public String getCodfp() {
        return codfp;
    }

    public void setCodfp(String codfp) {
        this.codfp = codfp;
    }

    public BigDecimal getValortotalcofins() {
        return valortotalcofins;
    }

    public void setValortotalcofins(BigDecimal valortotalcofins) {
        this.valortotalcofins = valortotalcofins;
    }

    public BigDecimal getValortotalpis() {
        return valortotalpis;
    }

    public void setValortotalpis(BigDecimal valortotalpis) {
        this.valortotalpis = valortotalpis;
    }

    public BigDecimal getValortotalservicos() {
        return valortotalservicos;
    }

    public void setValortotalservicos(BigDecimal valortotalservicos) {
        this.valortotalservicos = valortotalservicos;
    }

    public BigDecimal getValortotaliss() {
        return valortotaliss;
    }

    public void setValortotaliss(BigDecimal valortotaliss) {
        this.valortotaliss = valortotaliss;
    }

    public Character getFlagestoqueliberado() {
        return flagestoqueliberado;
    }

    public void setFlagestoqueliberado(Character flagestoqueliberado) {
        this.flagestoqueliberado = flagestoqueliberado;
    }

    public String getCoduserliberacaoestoque() {
        return coduserliberacaoestoque;
    }

    public void setCoduserliberacaoestoque(String coduserliberacaoestoque) {
        this.coduserliberacaoestoque = coduserliberacaoestoque;
    }

    public Date getDataliberacaoestoque() {
        return dataliberacaoestoque;
    }

    public void setDataliberacaoestoque(Date dataliberacaoestoque) {
        this.dataliberacaoestoque = dataliberacaoestoque;
    }

    public String getNumerochavenfe() {
        return numerochavenfe;
    }

    public void setNumerochavenfe(String numerochavenfe) {
        this.numerochavenfe = numerochavenfe;
    }

    public String getNumeroprotocolonfe() {
        return numeroprotocolonfe;
    }

    public void setNumeroprotocolonfe(String numeroprotocolonfe) {
        this.numeroprotocolonfe = numeroprotocolonfe;
    }

    public String getCodmovendatroca() {
        return codmovendatroca;
    }

    public void setCodmovendatroca(String codmovendatroca) {
        this.codmovendatroca = codmovendatroca;
    }

    public String getXmlnfeentrada() {
        return xmlnfeentrada;
    }

    public void setXmlnfeentrada(String xmlnfeentrada) {
        this.xmlnfeentrada = xmlnfeentrada;
    }

    public String getCodordemproducao() {
        return codordemproducao;
    }

    public void setCodordemproducao(String codordemproducao) {
        this.codordemproducao = codordemproducao;
    }

    public String getNumgarantia() {
        return numgarantia;
    }

    public void setNumgarantia(String numgarantia) {
        this.numgarantia = numgarantia;
    }

    public BigDecimal getValorabatimentonaotribicms() {
        return valorabatimentonaotribicms;
    }

    public void setValorabatimentonaotribicms(BigDecimal valorabatimentonaotribicms) {
        this.valorabatimentonaotribicms = valorabatimentonaotribicms;
    }

    public BigDecimal getValorabatimentonaotribpis() {
        return valorabatimentonaotribpis;
    }

    public void setValorabatimentonaotribpis(BigDecimal valorabatimentonaotribpis) {
        this.valorabatimentonaotribpis = valorabatimentonaotribpis;
    }

    public BigDecimal getValorabatimentonaotribcofins() {
        return valorabatimentonaotribcofins;
    }

    public void setValorabatimentonaotribcofins(BigDecimal valorabatimentonaotribcofins) {
        this.valorabatimentonaotribcofins = valorabatimentonaotribcofins;
    }

    public BigDecimal getValorabatimentonaotribipi() {
        return valorabatimentonaotribipi;
    }

    public void setValorabatimentonaotribipi(BigDecimal valorabatimentonaotribipi) {
        this.valorabatimentonaotribipi = valorabatimentonaotribipi;
    }

    public Character getTipopagamento() {
        return tipopagamento;
    }

    public void setTipopagamento(Character tipopagamento) {
        this.tipopagamento = tipopagamento;
    }

    public BigDecimal getValortotalii() {
        return valortotalii;
    }

    public void setValortotalii(BigDecimal valortotalii) {
        this.valortotalii = valortotalii;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public BigDecimal getValorsubstantecipada() {
        return valorsubstantecipada;
    }

    public void setValorsubstantecipada(BigDecimal valorsubstantecipada) {
        this.valorsubstantecipada = valorsubstantecipada;
    }

    public BigDecimal getValorconhecimentotrans() {
        return valorconhecimentotrans;
    }

    public void setValorconhecimentotrans(BigDecimal valorconhecimentotrans) {
        this.valorconhecimentotrans = valorconhecimentotrans;
    }

    public String getCodtransredespacho() {
        return codtransredespacho;
    }

    public void setCodtransredespacho(String codtransredespacho) {
        this.codtransredespacho = codtransredespacho;
    }

    public BigDecimal getValorfreteredespacho() {
        return valorfreteredespacho;
    }

    public void setValorfreteredespacho(BigDecimal valorfreteredespacho) {
        this.valorfreteredespacho = valorfreteredespacho;
    }

    public String getCodentregapessoa() {
        return codentregapessoa;
    }

    public void setCodentregapessoa(String codentregapessoa) {
        this.codentregapessoa = codentregapessoa;
    }

    public BigDecimal getValoricmsincentfiscal() {
        return valoricmsincentfiscal;
    }

    public void setValoricmsincentfiscal(BigDecimal valoricmsincentfiscal) {
        this.valoricmsincentfiscal = valoricmsincentfiscal;
    }

    public String getCoddocumentoreferenciado() {
        return coddocumentoreferenciado;
    }

    public void setCoddocumentoreferenciado(String coddocumentoreferenciado) {
        this.coddocumentoreferenciado = coddocumentoreferenciado;
    }

    public Character getFlagnfcomplementar() {
        return flagnfcomplementar;
    }

    public void setFlagnfcomplementar(Character flagnfcomplementar) {
        this.flagnfcomplementar = flagnfcomplementar;
    }

    public Character getFlagnfdevolucao() {
        return flagnfdevolucao;
    }

    public void setFlagnfdevolucao(Character flagnfdevolucao) {
        this.flagnfdevolucao = flagnfdevolucao;
    }

    public Character getFlagenviowms() {
        return flagenviowms;
    }

    public void setFlagenviowms(Character flagenviowms) {
        this.flagenviowms = flagenviowms;
    }

    public Character getFlagnfajuste() {
        return flagnfajuste;
    }

    public void setFlagnfajuste(Character flagnfajuste) {
        this.flagnfajuste = flagnfajuste;
    }

    public String getObsfisco() {
        return obsfisco;
    }

    public void setObsfisco(String obsfisco) {
        this.obsfisco = obsfisco;
    }

    public Character getFlagdocreferenciado() {
        return flagdocreferenciado;
    }

    public void setFlagdocreferenciado(Character flagdocreferenciado) {
        this.flagdocreferenciado = flagdocreferenciado;
    }

    public Character getIndoperacao() {
        return indoperacao;
    }

    public void setIndoperacao(Character indoperacao) {
        this.indoperacao = indoperacao;
    }

    public Character getIndpresenca() {
        return indpresenca;
    }

    public void setIndpresenca(Character indpresenca) {
        this.indpresenca = indpresenca;
    }

    public Character getIdentificadordestino() {
        return identificadordestino;
    }

    public void setIdentificadordestino(Character identificadordestino) {
        this.identificadordestino = identificadordestino;
    }

    public BigDecimal getValorfcp() {
        return valorfcp;
    }

    public void setValorfcp(BigDecimal valorfcp) {
        this.valorfcp = valorfcp;
    }

    public BigDecimal getValorfcpsubsttributaria() {
        return valorfcpsubsttributaria;
    }

    public void setValorfcpsubsttributaria(BigDecimal valorfcpsubsttributaria) {
        this.valorfcpsubsttributaria = valorfcpsubsttributaria;
    }

    public String getCodacerto() {
        return codacerto;
    }

    public void setCodacerto(String codacerto) {
        this.codacerto = codacerto;
    }

    public BigDecimal getValoricmsdesonerado() {
        return valoricmsdesonerado;
    }

    public void setValoricmsdesonerado(BigDecimal valoricmsdesonerado) {
        this.valoricmsdesonerado = valoricmsdesonerado;
    }

    public Centrocusto getCodcentrocusto() {
        return codcentrocusto;
    }

    public void setCodcentrocusto(Centrocusto codcentrocusto) {
        this.codcentrocusto = codcentrocusto;
    }

    public Cfop getCodcfop() {
        return codcfop;
    }

    public void setCodcfop(Cfop codcfop) {
        this.codcfop = codcfop;
    }

    public Cliente getCodcli() {
        return codcli;
    }

    public void setCodcli(Cliente codcli) {
        this.codcli = codcli;
    }

    public Empresa getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Empresa codempresa) {
        this.codempresa = codempresa;
    }

    public Setorestoque getCodsetorestoque() {
        return codsetorestoque;
    }

    public void setCodsetorestoque(Setorestoque codsetorestoque) {
        this.codsetorestoque = codsetorestoque;
    }

    public Tipomovimento getCodtipomovimento() {
        return codtipomovimento;
    }

    public void setCodtipomovimento(Tipomovimento codtipomovimento) {
        this.codtipomovimento = codtipomovimento;
    }

    public Vendedor getCodvended() {
        return codvended;
    }

    public void setCodvended(Vendedor codvended) {
        this.codvended = codvended;
    }

    @XmlTransient
    public Collection<Moventradaprod> getMoventradaprodCollection() {
        return moventradaprodCollection;
    }

    public void setMoventradaprodCollection(Collection<Moventradaprod> moventradaprodCollection) {
        this.moventradaprodCollection = moventradaprodCollection;
    }

    @XmlTransient
    public Collection<Contapagar> getContapagarCollection() {
        return contapagarCollection;
    }

    public void setContapagarCollection(Collection<Contapagar> contapagarCollection) {
        this.contapagarCollection = contapagarCollection;
    }

    @XmlTransient
    public Collection<Consignacaobaixa> getConsignacaobaixaCollection() {
        return consignacaobaixaCollection;
    }

    public void setConsignacaobaixaCollection(Collection<Consignacaobaixa> consignacaobaixaCollection) {
        this.consignacaobaixaCollection = consignacaobaixaCollection;
    }

    @XmlTransient
    public Collection<Rma> getRmaCollection() {
        return rmaCollection;
    }

    public void setRmaCollection(Collection<Rma> rmaCollection) {
        this.rmaCollection = rmaCollection;
    }

    @XmlTransient
    public Collection<Movendadocref> getMovendadocrefCollection() {
        return movendadocrefCollection;
    }

    public void setMovendadocrefCollection(Collection<Movendadocref> movendadocrefCollection) {
        this.movendadocrefCollection = movendadocrefCollection;
    }

    @XmlTransient
    public Collection<Moventradadocref> getMoventradadocrefCollection() {
        return moventradadocrefCollection;
    }

    public void setMoventradadocrefCollection(Collection<Moventradadocref> moventradadocrefCollection) {
        this.moventradadocrefCollection = moventradadocrefCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codmoventr != null ? codmoventr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Moventrada)) {
            return false;
        }
        Moventrada other = (Moventrada) object;
        if ((this.codmoventr == null && other.codmoventr != null) || (this.codmoventr != null && !this.codmoventr.equals(other.codmoventr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Moventrada[ codmoventr=" + codmoventr + " ]";
    }

   // public String getCodforn() {
   //     return codforn;
   // }

  //  public void setCodforn(String codforn) {
  //      this.codforn = codforn;
 //   }

    public String getCodintermediador() {
        return codintermediador;
    }

    public void setCodintermediador(String codintermediador) {
        this.codintermediador = codintermediador;
    }
    
}
