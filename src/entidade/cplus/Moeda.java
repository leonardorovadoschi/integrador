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
@Table(name = "MOEDA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Moeda.findAll", query = "SELECT m FROM Moeda m")
    , @NamedQuery(name = "Moeda.findByCodmoeda", query = "SELECT m FROM Moeda m WHERE m.codmoeda = :codmoeda")
    , @NamedQuery(name = "Moeda.findByNomemoeda", query = "SELECT m FROM Moeda m WHERE m.nomemoeda = :nomemoeda")
    , @NamedQuery(name = "Moeda.findByCotacao", query = "SELECT m FROM Moeda m WHERE m.cotacao = :cotacao")
    , @NamedQuery(name = "Moeda.findByCodigo", query = "SELECT m FROM Moeda m WHERE m.codigo = :codigo")})
public class Moeda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODMOEDA")
    private String codmoeda;
    @Column(name = "NOMEMOEDA")
    private String nomemoeda;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "COTACAO")
    private BigDecimal cotacao;
    @Column(name = "CODIGO")
    private String codigo;
    @OneToMany(mappedBy = "codmoeda")
    private Collection<Produtopreco> produtoprecoCollection;
    @OneToMany(mappedBy = "codmoeda")
    private Collection<Produto> produtoCollection;

    public Moeda() {
    }

    public Moeda(String codmoeda) {
        this.codmoeda = codmoeda;
    }

    public String getCodmoeda() {
        return codmoeda;
    }

    public void setCodmoeda(String codmoeda) {
        this.codmoeda = codmoeda;
    }

    public String getNomemoeda() {
        return nomemoeda;
    }

    public void setNomemoeda(String nomemoeda) {
        this.nomemoeda = nomemoeda;
    }

    public BigDecimal getCotacao() {
        return cotacao;
    }

    public void setCotacao(BigDecimal cotacao) {
        this.cotacao = cotacao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @XmlTransient
    public Collection<Produtopreco> getProdutoprecoCollection() {
        return produtoprecoCollection;
    }

    public void setProdutoprecoCollection(Collection<Produtopreco> produtoprecoCollection) {
        this.produtoprecoCollection = produtoprecoCollection;
    }

    @XmlTransient
    public Collection<Produto> getProdutoCollection() {
        return produtoCollection;
    }

    public void setProdutoCollection(Collection<Produto> produtoCollection) {
        this.produtoCollection = produtoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codmoeda != null ? codmoeda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Moeda)) {
            return false;
        }
        Moeda other = (Moeda) object;
        if ((this.codmoeda == null && other.codmoeda != null) || (this.codmoeda != null && !this.codmoeda.equals(other.codmoeda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Moeda[ codmoeda=" + codmoeda + " ]";
    }
    
}
