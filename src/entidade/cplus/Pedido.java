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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "PEDIDO", catalog = "", schema = "")
@XmlRootElement

public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODPED")
    private String codped;
   // @Column(name = "CODFORN")
    //private String codforn;
    
    @JoinColumn(name = "CODFORN", referencedColumnName = "CODFORN")
    @ManyToOne
    private Fornecedor codForn;
    
    @Column(name = "DATA")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "PRAZOPAG")
    private String prazopag;
    @Column(name = "PREVISAO")
    private Short previsao;
    @Lob
    @Column(name = "OBS")
    private String obs;
    @Column(name = "CODMOEDA")
    private String codmoeda;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "COTACAOMOEDA")
    private BigDecimal cotacaomoeda;
    @Column(name = "FRETE")
    private BigDecimal frete;
    @Column(name = "BASEICMS")
    private BigDecimal baseicms;
    @Column(name = "VALORICMS")
    private BigDecimal valoricms;
    @Column(name = "BASESUBSTTRIBUTARIA")
    private BigDecimal basesubsttributaria;
    @Column(name = "VALORSUBSTTRIBUTARIA")
    private BigDecimal valorsubsttributaria;
    @Column(name = "VALORSEGURO")
    private BigDecimal valorseguro;
    @Column(name = "VALOROUTRASDESPESAS")
    private BigDecimal valoroutrasdespesas;
    @Column(name = "VALORDESCONTO")
    private BigDecimal valordesconto;
    @Column(name = "VALORACRESCIMO")
    private BigDecimal valoracrescimo;
    @Column(name = "ALIQACRESCIMO")
    private BigDecimal aliqacrescimo;
    @Column(name = "ALIQDESCONTO")
    private BigDecimal aliqdesconto;
    @Column(name = "FLAGTIPODESCONTO")
    private Character flagtipodesconto;
    @Column(name = "FLAGTIPOACRESCIMO")
    private Character flagtipoacrescimo;
    @Column(name = "VALORTOTALNOTA")
    private BigDecimal valortotalnota;
    @Column(name = "VALORTOTALPRODUTOS")
    private BigDecimal valortotalprodutos;
    @Column(name = "VALORTOTALIPI")
    private BigDecimal valortotalipi;
    @Column(name = "VALORFRETE")
    private BigDecimal valorfrete;
    @Column(name = "CODTIPOMOVIMENTO")
    private String codtipomovimento;
    @Column(name = "FLAGFRETE")
    private Character flagfrete;
    @Column(name = "FLAGTIPOISS")
    private Character flagtipoiss;
    @Column(name = "FLAGTIPOIPI")
    private Character flagtipoipi;
    @Column(name = "HORA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hora;
    @Column(name = "STATUS")
    private Character status;
    @Column(name = "DATACONFIRMACAO")
    @Temporal(TemporalType.DATE)
    private Date dataconfirmacao;
    @Column(name = "CODUSERCONFIRMACAO")
    private String coduserconfirmacao;
    @Column(name = "VALORTOTALCOFINS")
    private BigDecimal valortotalcofins;
    @Column(name = "VALORTOTALPIS")
    private BigDecimal valortotalpis;
    @Column(name = "VALORTOTALSERVICOS")
    private BigDecimal valortotalservicos;
    @Column(name = "VALORTOTALISS")
    private BigDecimal valortotaliss;
    @Column(name = "VALORSUBSTANTECIPADA")
    private BigDecimal valorsubstantecipada;
    @Column(name = "VALORCONHECIMENTOTRANS")
    private BigDecimal valorconhecimentotrans;
    @Column(name = "CODTRANSREDESPACHO")
    private String codtransredespacho;
    @Column(name = "VALORFRETEREDESPACHO")
    private BigDecimal valorfreteredespacho;
    @Column(name = "VALORFCP")
    private BigDecimal valorfcp;
    @Column(name = "VALORFCPSUBSTTRIBUTARIA")
    private BigDecimal valorfcpsubsttributaria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codped")
    private Collection<Itemped> itempedCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codped")
    private Collection<Pedidoitem> pedidoitemCollection;
    @JoinColumn(name = "CODCENTROCUSTO", referencedColumnName = "CODCENTROCUSTO")
    @ManyToOne
    private Centrocusto codcentrocusto;
    @JoinColumn(name = "CODCFOP", referencedColumnName = "CODCFOP")
    @ManyToOne
    private Cfop codcfop;
    @JoinColumn(name = "CODEMPRESA", referencedColumnName = "CODEMPRESA")
    @ManyToOne(optional = false)
    private Empresa codempresa;
    @JoinColumn(name = "CODFP", referencedColumnName = "CODFP")
    @ManyToOne
    private Formapag codfp;
    @JoinColumn(name = "CODSETORESTOQUE", referencedColumnName = "CODSETORESTOQUE")
    @ManyToOne
    private Setorestoque codsetorestoque;
    @JoinColumn(name = "CODTRANS", referencedColumnName = "CODTRANS")
    @ManyToOne
    private Transportadora codtrans;
    @JoinColumn(name = "CODUSER", referencedColumnName = "CODUSER")
    @ManyToOne
    private Usuario coduser;

    public Pedido() {
    }

    public Pedido(String codped) {
        this.codped = codped;
    }

    public String getCodped() {
        return codped;
    }

    public void setCodped(String codped) {
        this.codped = codped;
    }

    /*public String getCodforn() {
        return codforn;
    }

    public void setCodforn(String codforn) {
        this.codforn = codforn;
    }
    */
    public Fornecedor getCodForn() {
        return codForn;
    }

    public void setCodForn(Fornecedor codForn) {
        this.codForn = codForn;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getPrazopag() {
        return prazopag;
    }

    public void setPrazopag(String prazopag) {
        this.prazopag = prazopag;
    }

    public Short getPrevisao() {
        return previsao;
    }

    public void setPrevisao(Short previsao) {
        this.previsao = previsao;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getCodmoeda() {
        return codmoeda;
    }

    public void setCodmoeda(String codmoeda) {
        this.codmoeda = codmoeda;
    }

    public BigDecimal getCotacaomoeda() {
        return cotacaomoeda;
    }

    public void setCotacaomoeda(BigDecimal cotacaomoeda) {
        this.cotacaomoeda = cotacaomoeda;
    }

    public BigDecimal getFrete() {
        return frete;
    }

    public void setFrete(BigDecimal frete) {
        this.frete = frete;
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

    public BigDecimal getValortotalnota() {
        return valortotalnota;
    }

    public void setValortotalnota(BigDecimal valortotalnota) {
        this.valortotalnota = valortotalnota;
    }

    public BigDecimal getValortotalprodutos() {
        return valortotalprodutos;
    }

    public void setValortotalprodutos(BigDecimal valortotalprodutos) {
        this.valortotalprodutos = valortotalprodutos;
    }

    public BigDecimal getValortotalipi() {
        return valortotalipi;
    }

    public void setValortotalipi(BigDecimal valortotalipi) {
        this.valortotalipi = valortotalipi;
    }

    public BigDecimal getValorfrete() {
        return valorfrete;
    }

    public void setValorfrete(BigDecimal valorfrete) {
        this.valorfrete = valorfrete;
    }

    public String getCodtipomovimento() {
        return codtipomovimento;
    }

    public void setCodtipomovimento(String codtipomovimento) {
        this.codtipomovimento = codtipomovimento;
    }

    public Character getFlagfrete() {
        return flagfrete;
    }

    public void setFlagfrete(Character flagfrete) {
        this.flagfrete = flagfrete;
    }

    public Character getFlagtipoiss() {
        return flagtipoiss;
    }

    public void setFlagtipoiss(Character flagtipoiss) {
        this.flagtipoiss = flagtipoiss;
    }

    public Character getFlagtipoipi() {
        return flagtipoipi;
    }

    public void setFlagtipoipi(Character flagtipoipi) {
        this.flagtipoipi = flagtipoipi;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public Date getDataconfirmacao() {
        return dataconfirmacao;
    }

    public void setDataconfirmacao(Date dataconfirmacao) {
        this.dataconfirmacao = dataconfirmacao;
    }

    public String getCoduserconfirmacao() {
        return coduserconfirmacao;
    }

    public void setCoduserconfirmacao(String coduserconfirmacao) {
        this.coduserconfirmacao = coduserconfirmacao;
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

    @XmlTransient
    public Collection<Itemped> getItempedCollection() {
        return itempedCollection;
    }

    public void setItempedCollection(Collection<Itemped> itempedCollection) {
        this.itempedCollection = itempedCollection;
    }

    @XmlTransient
    public Collection<Pedidoitem> getPedidoitemCollection() {
        return pedidoitemCollection;
    }

    public void setPedidoitemCollection(Collection<Pedidoitem> pedidoitemCollection) {
        this.pedidoitemCollection = pedidoitemCollection;
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

    public Empresa getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Empresa codempresa) {
        this.codempresa = codempresa;
    }

    public Formapag getCodfp() {
        return codfp;
    }

    public void setCodfp(Formapag codfp) {
        this.codfp = codfp;
    }

    public Setorestoque getCodsetorestoque() {
        return codsetorestoque;
    }

    public void setCodsetorestoque(Setorestoque codsetorestoque) {
        this.codsetorestoque = codsetorestoque;
    }

    public Transportadora getCodtrans() {
        return codtrans;
    }

    public void setCodtrans(Transportadora codtrans) {
        this.codtrans = codtrans;
    }

    public Usuario getCoduser() {
        return coduser;
    }

    public void setCoduser(Usuario coduser) {
        this.coduser = coduser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codped != null ? codped.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.codped == null && other.codped != null) || (this.codped != null && !this.codped.equals(other.codped))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Pedido[ codped=" + codped + " ]";
    }
    
}
