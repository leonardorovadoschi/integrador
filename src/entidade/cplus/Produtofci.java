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
@Table(name = "PRODUTOFCI", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produtofci.findAll", query = "SELECT p FROM Produtofci p")
    , @NamedQuery(name = "Produtofci.findByCodprodutofci", query = "SELECT p FROM Produtofci p WHERE p.codprodutofci = :codprodutofci")
    , @NamedQuery(name = "Produtofci.findByCodigo", query = "SELECT p FROM Produtofci p WHERE p.codigo = :codigo")
    , @NamedQuery(name = "Produtofci.findByFci", query = "SELECT p FROM Produtofci p WHERE p.fci = :fci")
    , @NamedQuery(name = "Produtofci.findByDataentrada", query = "SELECT p FROM Produtofci p WHERE p.dataentrada = :dataentrada")
    , @NamedQuery(name = "Produtofci.findByCi", query = "SELECT p FROM Produtofci p WHERE p.ci = :ci")})
public class Produtofci implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODPRODUTOFCI")
    private String codprodutofci;
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private String codigo;
    @Basic(optional = false)
    @Column(name = "FCI")
    private String fci;
    @Column(name = "DATAENTRADA")
    @Temporal(TemporalType.DATE)
    private Date dataentrada;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CI")
    private BigDecimal ci;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codprodutofci")
    private Collection<Movendaprodfci> movendaprodfciCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codprodutofci")
    private Collection<Moventradaprodfci> moventradaprodfciCollection;
    @JoinColumn(name = "CODPROD", referencedColumnName = "CODPROD")
    @ManyToOne(optional = false)
    private Produto codprod;

    public Produtofci() {
    }

    public Produtofci(String codprodutofci) {
        this.codprodutofci = codprodutofci;
    }

    public Produtofci(String codprodutofci, String codigo, String fci) {
        this.codprodutofci = codprodutofci;
        this.codigo = codigo;
        this.fci = fci;
    }

    public String getCodprodutofci() {
        return codprodutofci;
    }

    public void setCodprodutofci(String codprodutofci) {
        this.codprodutofci = codprodutofci;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFci() {
        return fci;
    }

    public void setFci(String fci) {
        this.fci = fci;
    }

    public Date getDataentrada() {
        return dataentrada;
    }

    public void setDataentrada(Date dataentrada) {
        this.dataentrada = dataentrada;
    }

    public BigDecimal getCi() {
        return ci;
    }

    public void setCi(BigDecimal ci) {
        this.ci = ci;
    }

    @XmlTransient
    public Collection<Movendaprodfci> getMovendaprodfciCollection() {
        return movendaprodfciCollection;
    }

    public void setMovendaprodfciCollection(Collection<Movendaprodfci> movendaprodfciCollection) {
        this.movendaprodfciCollection = movendaprodfciCollection;
    }

    @XmlTransient
    public Collection<Moventradaprodfci> getMoventradaprodfciCollection() {
        return moventradaprodfciCollection;
    }

    public void setMoventradaprodfciCollection(Collection<Moventradaprodfci> moventradaprodfciCollection) {
        this.moventradaprodfciCollection = moventradaprodfciCollection;
    }

    public Produto getCodprod() {
        return codprod;
    }

    public void setCodprod(Produto codprod) {
        this.codprod = codprod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codprodutofci != null ? codprodutofci.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produtofci)) {
            return false;
        }
        Produtofci other = (Produtofci) object;
        if ((this.codprodutofci == null && other.codprodutofci != null) || (this.codprodutofci != null && !this.codprodutofci.equals(other.codprodutofci))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Produtofci[ codprodutofci=" + codprodutofci + " ]";
    }
    
}
