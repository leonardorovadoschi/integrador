/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "FORMAPAG", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Formapag.findAll", query = "SELECT f FROM Formapag f")
    , @NamedQuery(name = "Formapag.findByCodfp", query = "SELECT f FROM Formapag f WHERE f.codfp = :codfp")
    , @NamedQuery(name = "Formapag.findByCodigo", query = "SELECT f FROM Formapag f WHERE f.codigo = :codigo")
    , @NamedQuery(name = "Formapag.findByDescricao", query = "SELECT f FROM Formapag f WHERE f.descricao = :descricao")
    , @NamedQuery(name = "Formapag.findByFlagdiamensalfixoparcelas", query = "SELECT f FROM Formapag f WHERE f.flagdiamensalfixoparcelas = :flagdiamensalfixoparcelas")
    , @NamedQuery(name = "Formapag.findByNumparcelas", query = "SELECT f FROM Formapag f WHERE f.numparcelas = :numparcelas")
    , @NamedQuery(name = "Formapag.findByIntervaloparcelas", query = "SELECT f FROM Formapag f WHERE f.intervaloparcelas = :intervaloparcelas")
    , @NamedQuery(name = "Formapag.findByNumdiasentrada", query = "SELECT f FROM Formapag f WHERE f.numdiasentrada = :numdiasentrada")
    , @NamedQuery(name = "Formapag.findByAliqdesconto", query = "SELECT f FROM Formapag f WHERE f.aliqdesconto = :aliqdesconto")
    , @NamedQuery(name = "Formapag.findByAliqjuros", query = "SELECT f FROM Formapag f WHERE f.aliqjuros = :aliqjuros")
    , @NamedQuery(name = "Formapag.findByFlagafv", query = "SELECT f FROM Formapag f WHERE f.flagafv = :flagafv")
    , @NamedQuery(name = "Formapag.findByFlaglojavirtual", query = "SELECT f FROM Formapag f WHERE f.flaglojavirtual = :flaglojavirtual")
    , @NamedQuery(name = "Formapag.findByAliqentrada", query = "SELECT f FROM Formapag f WHERE f.aliqentrada = :aliqentrada")
    , @NamedQuery(name = "Formapag.findByFlagativo", query = "SELECT f FROM Formapag f WHERE f.flagativo = :flagativo")
    , @NamedQuery(name = "Formapag.findByFlagfreteprimeiropagamento", query = "SELECT f FROM Formapag f WHERE f.flagfreteprimeiropagamento = :flagfreteprimeiropagamento")
    , @NamedQuery(name = "Formapag.findByClassificacao", query = "SELECT f FROM Formapag f WHERE f.classificacao = :classificacao")
    , @NamedQuery(name = "Formapag.findByTipo", query = "SELECT f FROM Formapag f WHERE f.tipo = :tipo")
    , @NamedQuery(name = "Formapag.findByNumdiasprimeiraparcela", query = "SELECT f FROM Formapag f WHERE f.numdiasprimeiraparcela = :numdiasprimeiraparcela")
    , @NamedQuery(name = "Formapag.findByFlagpermitiralterar", query = "SELECT f FROM Formapag f WHERE f.flagpermitiralterar = :flagpermitiralterar")
    , @NamedQuery(name = "Formapag.findByIntervaloultimaparcela", query = "SELECT f FROM Formapag f WHERE f.intervaloultimaparcela = :intervaloultimaparcela")
    , @NamedQuery(name = "Formapag.findByFlagdescontoatevencimento", query = "SELECT f FROM Formapag f WHERE f.flagdescontoatevencimento = :flagdescontoatevencimento")
    , @NamedQuery(name = "Formapag.findByIntervalos", query = "SELECT f FROM Formapag f WHERE f.intervalos = :intervalos")
    , @NamedQuery(name = "Formapag.findByFlagalteravalorentrada", query = "SELECT f FROM Formapag f WHERE f.flagalteravalorentrada = :flagalteravalorentrada")
    , @NamedQuery(name = "Formapag.findByIntervalopenultima", query = "SELECT f FROM Formapag f WHERE f.intervalopenultima = :intervalopenultima")
    , @NamedQuery(name = "Formapag.findByFlagtipo", query = "SELECT f FROM Formapag f WHERE f.flagtipo = :flagtipo")
    , @NamedQuery(name = "Formapag.findByGuid", query = "SELECT f FROM Formapag f WHERE f.guid = :guid")
    , @NamedQuery(name = "Formapag.findByLiberacaoestado", query = "SELECT f FROM Formapag f WHERE f.liberacaoestado = :liberacaoestado")
    , @NamedQuery(name = "Formapag.findByValorminvenda", query = "SELECT f FROM Formapag f WHERE f.valorminvenda = :valorminvenda")})
public class Formapag implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODFP")
    private String codfp;
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "DESCRICAO")
    private String descricao;
    @Column(name = "FLAGDIAMENSALFIXOPARCELAS")
    private Character flagdiamensalfixoparcelas;
    @Column(name = "NUMPARCELAS")
    private Integer numparcelas;
    @Column(name = "INTERVALOPARCELAS")
    private Integer intervaloparcelas;
    @Column(name = "NUMDIASENTRADA")
    private Integer numdiasentrada;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ALIQDESCONTO")
    private BigDecimal aliqdesconto;
    @Column(name = "ALIQJUROS")
    private BigDecimal aliqjuros;
    @Column(name = "FLAGAFV")
    private Character flagafv;
    @Column(name = "FLAGLOJAVIRTUAL")
    private Character flaglojavirtual;
    @Column(name = "ALIQENTRADA")
    private BigDecimal aliqentrada;
    @Column(name = "FLAGATIVO")
    private Character flagativo;
    @Column(name = "FLAGFRETEPRIMEIROPAGAMENTO")
    private Character flagfreteprimeiropagamento;
    @Column(name = "CLASSIFICACAO")
    private String classificacao;
    @Column(name = "TIPO")
    private Character tipo;
    @Column(name = "NUMDIASPRIMEIRAPARCELA")
    private Integer numdiasprimeiraparcela;
    @Column(name = "FLAGPERMITIRALTERAR")
    private Character flagpermitiralterar;
    @Column(name = "INTERVALOULTIMAPARCELA")
    private Integer intervaloultimaparcela;
    @Column(name = "FLAGDESCONTOATEVENCIMENTO")
    private Character flagdescontoatevencimento;
    @Column(name = "INTERVALOS")
    private String intervalos;
    @Column(name = "FLAGALTERAVALORENTRADA")
    private Character flagalteravalorentrada;
    @Column(name = "INTERVALOPENULTIMA")
    private Integer intervalopenultima;
    @Column(name = "FLAGTIPO")
    private Character flagtipo;
    @Column(name = "GUID")
    private String guid;
    @Column(name = "LIBERACAOESTADO")
    private String liberacaoestado;
    @Column(name = "VALORMINVENDA")
    private BigDecimal valorminvenda;
    @OneToMany(mappedBy = "codfp")
    private Collection<Documento> documentoCollection;
    @OneToMany(mappedBy = "codfp")
    private Collection<Fornecedor> fornecedorCollection;
    @OneToMany(mappedBy = "codfp")
    private Collection<Contratocobranca> contratocobrancaCollection;
    @OneToMany(mappedBy = "codfp")
    private Collection<Orcamento> orcamentoCollection;
    @OneToMany(mappedBy = "codfp")
    private Collection<Promocao> promocaoCollection;
    @OneToMany(mappedBy = "codfp")
    private Collection<Pedido> pedidoCollection;
    @OneToMany(mappedBy = "codfp")
    private Collection<Cliente> clienteCollection;

    public Formapag() {
    }

    public Formapag(String codfp) {
        this.codfp = codfp;
    }

    public String getCodfp() {
        return codfp;
    }

    public void setCodfp(String codfp) {
        this.codfp = codfp;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Character getFlagdiamensalfixoparcelas() {
        return flagdiamensalfixoparcelas;
    }

    public void setFlagdiamensalfixoparcelas(Character flagdiamensalfixoparcelas) {
        this.flagdiamensalfixoparcelas = flagdiamensalfixoparcelas;
    }

    public Integer getNumparcelas() {
        return numparcelas;
    }

    public void setNumparcelas(Integer numparcelas) {
        this.numparcelas = numparcelas;
    }

    public Integer getIntervaloparcelas() {
        return intervaloparcelas;
    }

    public void setIntervaloparcelas(Integer intervaloparcelas) {
        this.intervaloparcelas = intervaloparcelas;
    }

    public Integer getNumdiasentrada() {
        return numdiasentrada;
    }

    public void setNumdiasentrada(Integer numdiasentrada) {
        this.numdiasentrada = numdiasentrada;
    }

    public BigDecimal getAliqdesconto() {
        return aliqdesconto;
    }

    public void setAliqdesconto(BigDecimal aliqdesconto) {
        this.aliqdesconto = aliqdesconto;
    }

    public BigDecimal getAliqjuros() {
        return aliqjuros;
    }

    public void setAliqjuros(BigDecimal aliqjuros) {
        this.aliqjuros = aliqjuros;
    }

    public Character getFlagafv() {
        return flagafv;
    }

    public void setFlagafv(Character flagafv) {
        this.flagafv = flagafv;
    }

    public Character getFlaglojavirtual() {
        return flaglojavirtual;
    }

    public void setFlaglojavirtual(Character flaglojavirtual) {
        this.flaglojavirtual = flaglojavirtual;
    }

    public BigDecimal getAliqentrada() {
        return aliqentrada;
    }

    public void setAliqentrada(BigDecimal aliqentrada) {
        this.aliqentrada = aliqentrada;
    }

    public Character getFlagativo() {
        return flagativo;
    }

    public void setFlagativo(Character flagativo) {
        this.flagativo = flagativo;
    }

    public Character getFlagfreteprimeiropagamento() {
        return flagfreteprimeiropagamento;
    }

    public void setFlagfreteprimeiropagamento(Character flagfreteprimeiropagamento) {
        this.flagfreteprimeiropagamento = flagfreteprimeiropagamento;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

    public Integer getNumdiasprimeiraparcela() {
        return numdiasprimeiraparcela;
    }

    public void setNumdiasprimeiraparcela(Integer numdiasprimeiraparcela) {
        this.numdiasprimeiraparcela = numdiasprimeiraparcela;
    }

    public Character getFlagpermitiralterar() {
        return flagpermitiralterar;
    }

    public void setFlagpermitiralterar(Character flagpermitiralterar) {
        this.flagpermitiralterar = flagpermitiralterar;
    }

    public Integer getIntervaloultimaparcela() {
        return intervaloultimaparcela;
    }

    public void setIntervaloultimaparcela(Integer intervaloultimaparcela) {
        this.intervaloultimaparcela = intervaloultimaparcela;
    }

    public Character getFlagdescontoatevencimento() {
        return flagdescontoatevencimento;
    }

    public void setFlagdescontoatevencimento(Character flagdescontoatevencimento) {
        this.flagdescontoatevencimento = flagdescontoatevencimento;
    }

    public String getIntervalos() {
        return intervalos;
    }

    public void setIntervalos(String intervalos) {
        this.intervalos = intervalos;
    }

    public Character getFlagalteravalorentrada() {
        return flagalteravalorentrada;
    }

    public void setFlagalteravalorentrada(Character flagalteravalorentrada) {
        this.flagalteravalorentrada = flagalteravalorentrada;
    }

    public Integer getIntervalopenultima() {
        return intervalopenultima;
    }

    public void setIntervalopenultima(Integer intervalopenultima) {
        this.intervalopenultima = intervalopenultima;
    }

    public Character getFlagtipo() {
        return flagtipo;
    }

    public void setFlagtipo(Character flagtipo) {
        this.flagtipo = flagtipo;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getLiberacaoestado() {
        return liberacaoestado;
    }

    public void setLiberacaoestado(String liberacaoestado) {
        this.liberacaoestado = liberacaoestado;
    }

    public BigDecimal getValorminvenda() {
        return valorminvenda;
    }

    public void setValorminvenda(BigDecimal valorminvenda) {
        this.valorminvenda = valorminvenda;
    }

    @XmlTransient
    public Collection<Documento> getDocumentoCollection() {
        return documentoCollection;
    }

    public void setDocumentoCollection(Collection<Documento> documentoCollection) {
        this.documentoCollection = documentoCollection;
    }

    @XmlTransient
    public Collection<Fornecedor> getFornecedorCollection() {
        return fornecedorCollection;
    }

    public void setFornecedorCollection(Collection<Fornecedor> fornecedorCollection) {
        this.fornecedorCollection = fornecedorCollection;
    }

    @XmlTransient
    public Collection<Contratocobranca> getContratocobrancaCollection() {
        return contratocobrancaCollection;
    }

    public void setContratocobrancaCollection(Collection<Contratocobranca> contratocobrancaCollection) {
        this.contratocobrancaCollection = contratocobrancaCollection;
    }

    @XmlTransient
    public Collection<Orcamento> getOrcamentoCollection() {
        return orcamentoCollection;
    }

    public void setOrcamentoCollection(Collection<Orcamento> orcamentoCollection) {
        this.orcamentoCollection = orcamentoCollection;
    }

    @XmlTransient
    public Collection<Promocao> getPromocaoCollection() {
        return promocaoCollection;
    }

    public void setPromocaoCollection(Collection<Promocao> promocaoCollection) {
        this.promocaoCollection = promocaoCollection;
    }

    @XmlTransient
    public Collection<Pedido> getPedidoCollection() {
        return pedidoCollection;
    }

    public void setPedidoCollection(Collection<Pedido> pedidoCollection) {
        this.pedidoCollection = pedidoCollection;
    }

    @XmlTransient
    public Collection<Cliente> getClienteCollection() {
        return clienteCollection;
    }

    public void setClienteCollection(Collection<Cliente> clienteCollection) {
        this.clienteCollection = clienteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codfp != null ? codfp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Formapag)) {
            return false;
        }
        Formapag other = (Formapag) object;
        if ((this.codfp == null && other.codfp != null) || (this.codfp != null && !this.codfp.equals(other.codfp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Formapag[ codfp=" + codfp + " ]";
    }
    
}
