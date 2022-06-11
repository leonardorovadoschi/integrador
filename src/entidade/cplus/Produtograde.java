/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
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
@Table(name = "PRODUTOGRADE", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produtograde.findAll", query = "SELECT p FROM Produtograde p")
    , @NamedQuery(name = "Produtograde.findByCodprodgrade", query = "SELECT p FROM Produtograde p WHERE p.codprodgrade = :codprodgrade")
    , @NamedQuery(name = "Produtograde.findByNomeprodutograde", query = "SELECT p FROM Produtograde p WHERE p.nomeprodutograde = :nomeprodutograde")
    , @NamedQuery(name = "Produtograde.findByCoditemgradev", query = "SELECT p FROM Produtograde p WHERE p.coditemgradev = :coditemgradev")
    , @NamedQuery(name = "Produtograde.findByCoditemgradeh", query = "SELECT p FROM Produtograde p WHERE p.coditemgradeh = :coditemgradeh")})
public class Produtograde implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODPRODGRADE")
    private String codprodgrade;
    @Column(name = "NOMEPRODUTOGRADE")
    private String nomeprodutograde;
    @Column(name = "CODITEMGRADEV")
    private String coditemgradev;
    @Column(name = "CODITEMGRADEH")
    private String coditemgradeh;
    @OneToMany(mappedBy = "codprodgrade")
    private Collection<Produto> produtoCollection;

    public Produtograde() {
    }

    public Produtograde(String codprodgrade) {
        this.codprodgrade = codprodgrade;
    }

    public String getCodprodgrade() {
        return codprodgrade;
    }

    public void setCodprodgrade(String codprodgrade) {
        this.codprodgrade = codprodgrade;
    }

    public String getNomeprodutograde() {
        return nomeprodutograde;
    }

    public void setNomeprodutograde(String nomeprodutograde) {
        this.nomeprodutograde = nomeprodutograde;
    }

    public String getCoditemgradev() {
        return coditemgradev;
    }

    public void setCoditemgradev(String coditemgradev) {
        this.coditemgradev = coditemgradev;
    }

    public String getCoditemgradeh() {
        return coditemgradeh;
    }

    public void setCoditemgradeh(String coditemgradeh) {
        this.coditemgradeh = coditemgradeh;
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
        hash += (codprodgrade != null ? codprodgrade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produtograde)) {
            return false;
        }
        Produtograde other = (Produtograde) object;
        if ((this.codprodgrade == null && other.codprodgrade != null) || (this.codprodgrade != null && !this.codprodgrade.equals(other.codprodgrade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Produtograde[ codprodgrade=" + codprodgrade + " ]";
    }
    
}
