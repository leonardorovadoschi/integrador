/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "FORNPRODUTO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fornproduto.findAll", query = "SELECT f FROM Fornproduto f")
    , @NamedQuery(name = "Fornproduto.findByCodforn", query = "SELECT f FROM Fornproduto f WHERE f.fornprodutoPK.codforn = :codforn")
    , @NamedQuery(name = "Fornproduto.findByCodprod", query = "SELECT f FROM Fornproduto f WHERE f.fornprodutoPK.codprod = :codprod")
    , @NamedQuery(name = "Fornproduto.findByCustoreal", query = "SELECT f FROM Fornproduto f WHERE f.custoreal = :custoreal")
    , @NamedQuery(name = "Fornproduto.findByDatatu", query = "SELECT f FROM Fornproduto f WHERE f.datatu = :datatu")
    , @NamedQuery(name = "Fornproduto.findByCodigoproduto", query = "SELECT f FROM Fornproduto f WHERE f.codigoproduto = :codigoproduto")
    , @NamedQuery(name = "Fornproduto.findByAliqicms", query = "SELECT f FROM Fornproduto f WHERE f.aliqicms = :aliqicms")
    , @NamedQuery(name = "Fornproduto.findByAliqipi", query = "SELECT f FROM Fornproduto f WHERE f.aliqipi = :aliqipi")
    , @NamedQuery(name = "Fornproduto.findByCst", query = "SELECT f FROM Fornproduto f WHERE f.cst = :cst")
    , @NamedQuery(name = "Fornproduto.findByMargem", query = "SELECT f FROM Fornproduto f WHERE f.margem = :margem")
    , @NamedQuery(name = "Fornproduto.findByOutros", query = "SELECT f FROM Fornproduto f WHERE f.outros = :outros")
    , @NamedQuery(name = "Fornproduto.findByPrevenda", query = "SELECT f FROM Fornproduto f WHERE f.prevenda = :prevenda")
    , @NamedQuery(name = "Fornproduto.findByQuantidadeembalagem", query = "SELECT f FROM Fornproduto f WHERE f.quantidadeembalagem = :quantidadeembalagem")
    , @NamedQuery(name = "Fornproduto.findByNomeproduto", query = "SELECT f FROM Fornproduto f WHERE f.nomeproduto = :nomeproduto")
    , @NamedQuery(name = "Fornproduto.findByOperacao", query = "SELECT f FROM Fornproduto f WHERE f.operacao = :operacao")})
public class Fornproduto implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FornprodutoPK fornprodutoPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CUSTOREAL")
    private BigDecimal custoreal;
    @Column(name = "DATATU")
    @Temporal(TemporalType.DATE)
    private Date datatu;
    @Column(name = "CODIGOPRODUTO")
    private String codigoproduto;
    @Column(name = "ALIQICMS")
    private BigDecimal aliqicms;
    @Column(name = "ALIQIPI")
    private BigDecimal aliqipi;
    @Column(name = "CST")
    private String cst;
    @Column(name = "MARGEM")
    private BigDecimal margem;
    @Column(name = "OUTROS")
    private BigDecimal outros;
    @Column(name = "PREVENDA")
    private BigDecimal prevenda;
    @Column(name = "QUANTIDADEEMBALAGEM")
    private BigDecimal quantidadeembalagem;
    @Column(name = "NOMEPRODUTO")
    private String nomeproduto;
    @Column(name = "OPERACAO")
    private Character operacao;
    @JoinColumn(name = "CODPROD", referencedColumnName = "CODPROD", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Produto produto;

    public Fornproduto() {
    }

    public Fornproduto(FornprodutoPK fornprodutoPK) {
        this.fornprodutoPK = fornprodutoPK;
    }

    public Fornproduto(String codforn, String codprod) {
        this.fornprodutoPK = new FornprodutoPK(codforn, codprod);
    }

    public FornprodutoPK getFornprodutoPK() {
        return fornprodutoPK;
    }

    public void setFornprodutoPK(FornprodutoPK fornprodutoPK) {
        this.fornprodutoPK = fornprodutoPK;
    }

    public BigDecimal getCustoreal() {
        return custoreal;
    }

    public void setCustoreal(BigDecimal custoreal) {
        this.custoreal = custoreal;
    }

    public Date getDatatu() {
        return datatu;
    }

    public void setDatatu(Date datatu) {
        this.datatu = datatu;
    }

    public String getCodigoproduto() {
        return codigoproduto;
    }

    public void setCodigoproduto(String codigoproduto) {
        this.codigoproduto = codigoproduto;
    }

    public BigDecimal getAliqicms() {
        return aliqicms;
    }

    public void setAliqicms(BigDecimal aliqicms) {
        this.aliqicms = aliqicms;
    }

    public BigDecimal getAliqipi() {
        return aliqipi;
    }

    public void setAliqipi(BigDecimal aliqipi) {
        this.aliqipi = aliqipi;
    }

    public String getCst() {
        return cst;
    }

    public void setCst(String cst) {
        this.cst = cst;
    }

    public BigDecimal getMargem() {
        return margem;
    }

    public void setMargem(BigDecimal margem) {
        this.margem = margem;
    }

    public BigDecimal getOutros() {
        return outros;
    }

    public void setOutros(BigDecimal outros) {
        this.outros = outros;
    }

    public BigDecimal getPrevenda() {
        return prevenda;
    }

    public void setPrevenda(BigDecimal prevenda) {
        this.prevenda = prevenda;
    }

    public BigDecimal getQuantidadeembalagem() {
        return quantidadeembalagem;
    }

    public void setQuantidadeembalagem(BigDecimal quantidadeembalagem) {
        this.quantidadeembalagem = quantidadeembalagem;
    }

    public String getNomeproduto() {
        return nomeproduto;
    }

    public void setNomeproduto(String nomeproduto) {
        this.nomeproduto = nomeproduto;
    }

    public Character getOperacao() {
        return operacao;
    }

    public void setOperacao(Character operacao) {
        this.operacao = operacao;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fornprodutoPK != null ? fornprodutoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fornproduto)) {
            return false;
        }
        Fornproduto other = (Fornproduto) object;
        if ((this.fornprodutoPK == null && other.fornprodutoPK != null) || (this.fornprodutoPK != null && !this.fornprodutoPK.equals(other.fornprodutoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Fornproduto[ fornprodutoPK=" + fornprodutoPK + " ]";
    }
    
}
