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
@Table(name = "OS_PRODSERV", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OsProdserv.findAll", query = "SELECT o FROM OsProdserv o")
    , @NamedQuery(name = "OsProdserv.findByCodprodserv", query = "SELECT o FROM OsProdserv o WHERE o.codprodserv = :codprodserv")
    , @NamedQuery(name = "OsProdserv.findByQuantidade", query = "SELECT o FROM OsProdserv o WHERE o.quantidade = :quantidade")
    , @NamedQuery(name = "OsProdserv.findByTipo", query = "SELECT o FROM OsProdserv o WHERE o.tipo = :tipo")
    , @NamedQuery(name = "OsProdserv.findByBkpPrevenda", query = "SELECT o FROM OsProdserv o WHERE o.bkpPrevenda = :bkpPrevenda")
    , @NamedQuery(name = "OsProdserv.findByCodtec", query = "SELECT o FROM OsProdserv o WHERE o.codtec = :codtec")
    , @NamedQuery(name = "OsProdserv.findByCodvended", query = "SELECT o FROM OsProdserv o WHERE o.codvended = :codvended")
    , @NamedQuery(name = "OsProdserv.findByStatus", query = "SELECT o FROM OsProdserv o WHERE o.status = :status")
    , @NamedQuery(name = "OsProdserv.findByBkpPercdesconto", query = "SELECT o FROM OsProdserv o WHERE o.bkpPercdesconto = :bkpPercdesconto")
    , @NamedQuery(name = "OsProdserv.findByComplemento", query = "SELECT o FROM OsProdserv o WHERE o.complemento = :complemento")
    , @NamedQuery(name = "OsProdserv.findByFlagreservado", query = "SELECT o FROM OsProdserv o WHERE o.flagreservado = :flagreservado")
    , @NamedQuery(name = "OsProdserv.findByValorunitario", query = "SELECT o FROM OsProdserv o WHERE o.valorunitario = :valorunitario")
    , @NamedQuery(name = "OsProdserv.findByFlagtipodescontoitem", query = "SELECT o FROM OsProdserv o WHERE o.flagtipodescontoitem = :flagtipodescontoitem")
    , @NamedQuery(name = "OsProdserv.findByAliqdescontoitem", query = "SELECT o FROM OsProdserv o WHERE o.aliqdescontoitem = :aliqdescontoitem")
    , @NamedQuery(name = "OsProdserv.findByValordescontoitem", query = "SELECT o FROM OsProdserv o WHERE o.valordescontoitem = :valordescontoitem")
    , @NamedQuery(name = "OsProdserv.findByFlagtipoacrescimoitem", query = "SELECT o FROM OsProdserv o WHERE o.flagtipoacrescimoitem = :flagtipoacrescimoitem")
    , @NamedQuery(name = "OsProdserv.findByAliqacrescimoitem", query = "SELECT o FROM OsProdserv o WHERE o.aliqacrescimoitem = :aliqacrescimoitem")
    , @NamedQuery(name = "OsProdserv.findByValoracrescimoitem", query = "SELECT o FROM OsProdserv o WHERE o.valoracrescimoitem = :valoracrescimoitem")
    , @NamedQuery(name = "OsProdserv.findByValortotal", query = "SELECT o FROM OsProdserv o WHERE o.valortotal = :valortotal")
    , @NamedQuery(name = "OsProdserv.findByQtdeimpresso", query = "SELECT o FROM OsProdserv o WHERE o.qtdeimpresso = :qtdeimpresso")
    , @NamedQuery(name = "OsProdserv.findByCodprodgarantia", query = "SELECT o FROM OsProdserv o WHERE o.codprodgarantia = :codprodgarantia")
    , @NamedQuery(name = "OsProdserv.findByFlagitemcancelado", query = "SELECT o FROM OsProdserv o WHERE o.flagitemcancelado = :flagitemcancelado")
    , @NamedQuery(name = "OsProdserv.findByNumeroitem", query = "SELECT o FROM OsProdserv o WHERE o.numeroitem = :numeroitem")
    , @NamedQuery(name = "OsProdserv.findByDatainclusao", query = "SELECT o FROM OsProdserv o WHERE o.datainclusao = :datainclusao")
    , @NamedQuery(name = "OsProdserv.findByCodigoproduto", query = "SELECT o FROM OsProdserv o WHERE o.codigoproduto = :codigoproduto")
    , @NamedQuery(name = "OsProdserv.findByDescricaoproduto", query = "SELECT o FROM OsProdserv o WHERE o.descricaoproduto = :descricaoproduto")
    , @NamedQuery(name = "OsProdserv.findByUnidade", query = "SELECT o FROM OsProdserv o WHERE o.unidade = :unidade")
    , @NamedQuery(name = "OsProdserv.findByTipotributacao", query = "SELECT o FROM OsProdserv o WHERE o.tipotributacao = :tipotributacao")
    , @NamedQuery(name = "OsProdserv.findByAliqtributacao", query = "SELECT o FROM OsProdserv o WHERE o.aliqtributacao = :aliqtributacao")
    , @NamedQuery(name = "OsProdserv.findByNumos", query = "SELECT o FROM OsProdserv o WHERE o.numos = :numos")
    , @NamedQuery(name = "OsProdserv.findByFlagaltpaf", query = "SELECT o FROM OsProdserv o WHERE o.flagaltpaf = :flagaltpaf")})
public class OsProdserv implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODPRODSERV")
    private String codprodserv;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "QUANTIDADE")
    private BigDecimal quantidade;
    @Column(name = "TIPO")
    private Character tipo;
    @Column(name = "BKP_PREVENDA")
    private BigDecimal bkpPrevenda;
    @Column(name = "CODTEC")
    private String codtec;
    @Column(name = "CODVENDED")
    private String codvended;
    @Column(name = "STATUS")
    private Character status;
    @Column(name = "BKP_PERCDESCONTO")
    private BigDecimal bkpPercdesconto;
    @Column(name = "COMPLEMENTO")
    private String complemento;
    @Column(name = "FLAGRESERVADO")
    private Character flagreservado;
    @Column(name = "VALORUNITARIO")
    private BigDecimal valorunitario;
    @Column(name = "FLAGTIPODESCONTOITEM")
    private Character flagtipodescontoitem;
    @Column(name = "ALIQDESCONTOITEM")
    private BigDecimal aliqdescontoitem;
    @Column(name = "VALORDESCONTOITEM")
    private BigDecimal valordescontoitem;
    @Column(name = "FLAGTIPOACRESCIMOITEM")
    private Character flagtipoacrescimoitem;
    @Column(name = "ALIQACRESCIMOITEM")
    private BigDecimal aliqacrescimoitem;
    @Column(name = "VALORACRESCIMOITEM")
    private BigDecimal valoracrescimoitem;
    @Column(name = "VALORTOTAL")
    private BigDecimal valortotal;
    @Column(name = "QTDEIMPRESSO")
    private BigDecimal qtdeimpresso;
    @Column(name = "CODPRODGARANTIA")
    private String codprodgarantia;
    @Column(name = "FLAGITEMCANCELADO")
    private Character flagitemcancelado;
    @Column(name = "NUMEROITEM")
    private Short numeroitem;
    @Column(name = "DATAINCLUSAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datainclusao;
    @Column(name = "CODIGOPRODUTO")
    private String codigoproduto;
    @Column(name = "DESCRICAOPRODUTO")
    private String descricaoproduto;
    @Column(name = "UNIDADE")
    private String unidade;
    @Column(name = "TIPOTRIBUTACAO")
    private Character tipotributacao;
    @Column(name = "ALIQTRIBUTACAO")
    private BigDecimal aliqtributacao;
    @Column(name = "NUMOS")
    private Integer numos;
    @Column(name = "FLAGALTPAF")
    private Character flagaltpaf;
    @JoinColumn(name = "CODOS", referencedColumnName = "CODOS")
    @ManyToOne(optional = false)
    private OsOrdemservico codos;
    @JoinColumn(name = "CODPRECO", referencedColumnName = "CODPRECO")
    @ManyToOne
    private Preco codpreco;
    @JoinColumn(name = "CODPROD", referencedColumnName = "CODPROD")
    @ManyToOne(optional = false)
    private Produto codprod;
    @OneToMany(mappedBy = "codprodserv")
    private Collection<OsProdservserial> osProdservserialCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codprodserv")
    private Collection<OsProdservlote> osProdservloteCollection;

    public OsProdserv() {
    }

    public OsProdserv(String codprodserv) {
        this.codprodserv = codprodserv;
    }

    public String getCodprodserv() {
        return codprodserv;
    }

    public void setCodprodserv(String codprodserv) {
        this.codprodserv = codprodserv;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getBkpPrevenda() {
        return bkpPrevenda;
    }

    public void setBkpPrevenda(BigDecimal bkpPrevenda) {
        this.bkpPrevenda = bkpPrevenda;
    }

    public String getCodtec() {
        return codtec;
    }

    public void setCodtec(String codtec) {
        this.codtec = codtec;
    }

    public String getCodvended() {
        return codvended;
    }

    public void setCodvended(String codvended) {
        this.codvended = codvended;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public BigDecimal getBkpPercdesconto() {
        return bkpPercdesconto;
    }

    public void setBkpPercdesconto(BigDecimal bkpPercdesconto) {
        this.bkpPercdesconto = bkpPercdesconto;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Character getFlagreservado() {
        return flagreservado;
    }

    public void setFlagreservado(Character flagreservado) {
        this.flagreservado = flagreservado;
    }

    public BigDecimal getValorunitario() {
        return valorunitario;
    }

    public void setValorunitario(BigDecimal valorunitario) {
        this.valorunitario = valorunitario;
    }

    public Character getFlagtipodescontoitem() {
        return flagtipodescontoitem;
    }

    public void setFlagtipodescontoitem(Character flagtipodescontoitem) {
        this.flagtipodescontoitem = flagtipodescontoitem;
    }

    public BigDecimal getAliqdescontoitem() {
        return aliqdescontoitem;
    }

    public void setAliqdescontoitem(BigDecimal aliqdescontoitem) {
        this.aliqdescontoitem = aliqdescontoitem;
    }

    public BigDecimal getValordescontoitem() {
        return valordescontoitem;
    }

    public void setValordescontoitem(BigDecimal valordescontoitem) {
        this.valordescontoitem = valordescontoitem;
    }

    public Character getFlagtipoacrescimoitem() {
        return flagtipoacrescimoitem;
    }

    public void setFlagtipoacrescimoitem(Character flagtipoacrescimoitem) {
        this.flagtipoacrescimoitem = flagtipoacrescimoitem;
    }

    public BigDecimal getAliqacrescimoitem() {
        return aliqacrescimoitem;
    }

    public void setAliqacrescimoitem(BigDecimal aliqacrescimoitem) {
        this.aliqacrescimoitem = aliqacrescimoitem;
    }

    public BigDecimal getValoracrescimoitem() {
        return valoracrescimoitem;
    }

    public void setValoracrescimoitem(BigDecimal valoracrescimoitem) {
        this.valoracrescimoitem = valoracrescimoitem;
    }

    public BigDecimal getValortotal() {
        return valortotal;
    }

    public void setValortotal(BigDecimal valortotal) {
        this.valortotal = valortotal;
    }

    public BigDecimal getQtdeimpresso() {
        return qtdeimpresso;
    }

    public void setQtdeimpresso(BigDecimal qtdeimpresso) {
        this.qtdeimpresso = qtdeimpresso;
    }

    public String getCodprodgarantia() {
        return codprodgarantia;
    }

    public void setCodprodgarantia(String codprodgarantia) {
        this.codprodgarantia = codprodgarantia;
    }

    public Character getFlagitemcancelado() {
        return flagitemcancelado;
    }

    public void setFlagitemcancelado(Character flagitemcancelado) {
        this.flagitemcancelado = flagitemcancelado;
    }

    public Short getNumeroitem() {
        return numeroitem;
    }

    public void setNumeroitem(Short numeroitem) {
        this.numeroitem = numeroitem;
    }

    public Date getDatainclusao() {
        return datainclusao;
    }

    public void setDatainclusao(Date datainclusao) {
        this.datainclusao = datainclusao;
    }

    public String getCodigoproduto() {
        return codigoproduto;
    }

    public void setCodigoproduto(String codigoproduto) {
        this.codigoproduto = codigoproduto;
    }

    public String getDescricaoproduto() {
        return descricaoproduto;
    }

    public void setDescricaoproduto(String descricaoproduto) {
        this.descricaoproduto = descricaoproduto;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public Character getTipotributacao() {
        return tipotributacao;
    }

    public void setTipotributacao(Character tipotributacao) {
        this.tipotributacao = tipotributacao;
    }

    public BigDecimal getAliqtributacao() {
        return aliqtributacao;
    }

    public void setAliqtributacao(BigDecimal aliqtributacao) {
        this.aliqtributacao = aliqtributacao;
    }

    public Integer getNumos() {
        return numos;
    }

    public void setNumos(Integer numos) {
        this.numos = numos;
    }

    public Character getFlagaltpaf() {
        return flagaltpaf;
    }

    public void setFlagaltpaf(Character flagaltpaf) {
        this.flagaltpaf = flagaltpaf;
    }

    public OsOrdemservico getCodos() {
        return codos;
    }

    public void setCodos(OsOrdemservico codos) {
        this.codos = codos;
    }

    public Preco getCodpreco() {
        return codpreco;
    }

    public void setCodpreco(Preco codpreco) {
        this.codpreco = codpreco;
    }

    public Produto getCodprod() {
        return codprod;
    }

    public void setCodprod(Produto codprod) {
        this.codprod = codprod;
    }

    @XmlTransient
    public Collection<OsProdservserial> getOsProdservserialCollection() {
        return osProdservserialCollection;
    }

    public void setOsProdservserialCollection(Collection<OsProdservserial> osProdservserialCollection) {
        this.osProdservserialCollection = osProdservserialCollection;
    }

    @XmlTransient
    public Collection<OsProdservlote> getOsProdservloteCollection() {
        return osProdservloteCollection;
    }

    public void setOsProdservloteCollection(Collection<OsProdservlote> osProdservloteCollection) {
        this.osProdservloteCollection = osProdservloteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codprodserv != null ? codprodserv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OsProdserv)) {
            return false;
        }
        OsProdserv other = (OsProdserv) object;
        if ((this.codprodserv == null && other.codprodserv != null) || (this.codprodserv != null && !this.codprodserv.equals(other.codprodserv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.OsProdserv[ codprodserv=" + codprodserv + " ]";
    }
    
}
