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
@Table(name = "PRODUTOESTOQUE", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produtoestoque.findAll", query = "SELECT p FROM Produtoestoque p")
    , @NamedQuery(name = "Produtoestoque.findByCodprod", query = "SELECT p FROM Produtoestoque p WHERE p.produtoestoquePK.codprod = :codprod")
    , @NamedQuery(name = "Produtoestoque.findByCodempresa", query = "SELECT p FROM Produtoestoque p WHERE p.produtoestoquePK.codempresa = :codempresa")
    , @NamedQuery(name = "Produtoestoque.findByCodsetorestoque", query = "SELECT p FROM Produtoestoque p WHERE p.produtoestoquePK.codsetorestoque = :codsetorestoque")
    , @NamedQuery(name = "Produtoestoque.findByEstatu", query = "SELECT p FROM Produtoestoque p WHERE p.estatu = :estatu")
    , @NamedQuery(name = "Produtoestoque.findByLastChange", query = "SELECT p FROM Produtoestoque p WHERE p.lastChange = :lastChange")
    , @NamedQuery(name = "Produtoestoque.findByReservadoorcamento", query = "SELECT p FROM Produtoestoque p WHERE p.reservadoorcamento = :reservadoorcamento")
    , @NamedQuery(name = "Produtoestoque.findByReservadoos", query = "SELECT p FROM Produtoestoque p WHERE p.reservadoos = :reservadoos")
    , @NamedQuery(name = "Produtoestoque.findByQtdemin", query = "SELECT p FROM Produtoestoque p WHERE p.qtdemin = :qtdemin")
    , @NamedQuery(name = "Produtoestoque.findByQtdeideal", query = "SELECT p FROM Produtoestoque p WHERE p.qtdeideal = :qtdeideal")
    , @NamedQuery(name = "Produtoestoque.findByDatconf", query = "SELECT p FROM Produtoestoque p WHERE p.datconf = :datconf")
    , @NamedQuery(name = "Produtoestoque.findByGuid", query = "SELECT p FROM Produtoestoque p WHERE p.guid = :guid")})
public class Produtoestoque implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProdutoestoquePK produtoestoquePK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ESTATU")
    private BigDecimal estatu;
    @Column(name = "LAST_CHANGE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastChange;
    @Column(name = "RESERVADOORCAMENTO")
    private BigDecimal reservadoorcamento;
    @Column(name = "RESERVADOOS")
    private BigDecimal reservadoos;
    @Column(name = "QTDEMIN")
    private BigDecimal qtdemin;
    @Column(name = "QTDEIDEAL")
    private BigDecimal qtdeideal;
    @Column(name = "DATCONF")
    @Temporal(TemporalType.DATE)
    private Date datconf;
    @Column(name = "GUID")
    private String guid;
    @JoinColumn(name = "CODEMPRESA", referencedColumnName = "CODEMPRESA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Empresa empresa;
    @JoinColumn(name = "CODPROD", referencedColumnName = "CODPROD", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Produto produto;
    @JoinColumn(name = "CODSETORESTOQUE", referencedColumnName = "CODSETORESTOQUE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Setorestoque setorestoque;

    public Produtoestoque() {
    }

    public Produtoestoque(ProdutoestoquePK produtoestoquePK) {
        this.produtoestoquePK = produtoestoquePK;
    }

    public Produtoestoque(String codprod, int codempresa, String codsetorestoque) {
        this.produtoestoquePK = new ProdutoestoquePK(codprod, codempresa, codsetorestoque);
    }

    public ProdutoestoquePK getProdutoestoquePK() {
        return produtoestoquePK;
    }

    public void setProdutoestoquePK(ProdutoestoquePK produtoestoquePK) {
        this.produtoestoquePK = produtoestoquePK;
    }

    public BigDecimal getEstatu() {
        return estatu;
    }

    public void setEstatu(BigDecimal estatu) {
        this.estatu = estatu;
    }

    public Date getLastChange() {
        return lastChange;
    }

    public void setLastChange(Date lastChange) {
        this.lastChange = lastChange;
    }

    public BigDecimal getReservadoorcamento() {
        return reservadoorcamento;
    }

    public void setReservadoorcamento(BigDecimal reservadoorcamento) {
        this.reservadoorcamento = reservadoorcamento;
    }

    public BigDecimal getReservadoos() {
        return reservadoos;
    }

    public void setReservadoos(BigDecimal reservadoos) {
        this.reservadoos = reservadoos;
    }

    public BigDecimal getQtdemin() {
        return qtdemin;
    }

    public void setQtdemin(BigDecimal qtdemin) {
        this.qtdemin = qtdemin;
    }

    public BigDecimal getQtdeideal() {
        return qtdeideal;
    }

    public void setQtdeideal(BigDecimal qtdeideal) {
        this.qtdeideal = qtdeideal;
    }

    public Date getDatconf() {
        return datconf;
    }

    public void setDatconf(Date datconf) {
        this.datconf = datconf;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Setorestoque getSetorestoque() {
        return setorestoque;
    }

    public void setSetorestoque(Setorestoque setorestoque) {
        this.setorestoque = setorestoque;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (produtoestoquePK != null ? produtoestoquePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produtoestoque)) {
            return false;
        }
        Produtoestoque other = (Produtoestoque) object;
        if ((this.produtoestoquePK == null && other.produtoestoquePK != null) || (this.produtoestoquePK != null && !this.produtoestoquePK.equals(other.produtoestoquePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Produtoestoque[ produtoestoquePK=" + produtoestoquePK + " ]";
    }
    
}
