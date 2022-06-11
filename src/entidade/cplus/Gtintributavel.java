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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "GTINTRIBUTAVEL", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gtintributavel.findAll", query = "SELECT g FROM Gtintributavel g")
    , @NamedQuery(name = "Gtintributavel.findByCodgtintributavel", query = "SELECT g FROM Gtintributavel g WHERE g.codgtintributavel = :codgtintributavel")
    , @NamedQuery(name = "Gtintributavel.findByGtin", query = "SELECT g FROM Gtintributavel g WHERE g.gtin = :gtin")})
public class Gtintributavel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODGTINTRIBUTAVEL")
    private String codgtintributavel;
    @Basic(optional = false)
    @Column(name = "GTIN")
    private String gtin;
    @JoinColumn(name = "CODUNIDADE", referencedColumnName = "CODUNIDADE")
    @ManyToOne(optional = false)
    private Unidade codunidade;
    @OneToMany(mappedBy = "codgtintributavel")
    private Collection<Produto> produtoCollection;

    public Gtintributavel() {
    }

    public Gtintributavel(String codgtintributavel) {
        this.codgtintributavel = codgtintributavel;
    }

    public Gtintributavel(String codgtintributavel, String gtin) {
        this.codgtintributavel = codgtintributavel;
        this.gtin = gtin;
    }

    public String getCodgtintributavel() {
        return codgtintributavel;
    }

    public void setCodgtintributavel(String codgtintributavel) {
        this.codgtintributavel = codgtintributavel;
    }

    public String getGtin() {
        return gtin;
    }

    public void setGtin(String gtin) {
        this.gtin = gtin;
    }

    public Unidade getCodunidade() {
        return codunidade;
    }

    public void setCodunidade(Unidade codunidade) {
        this.codunidade = codunidade;
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
        hash += (codgtintributavel != null ? codgtintributavel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gtintributavel)) {
            return false;
        }
        Gtintributavel other = (Gtintributavel) object;
        if ((this.codgtintributavel == null && other.codgtintributavel != null) || (this.codgtintributavel != null && !this.codgtintributavel.equals(other.codgtintributavel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Gtintributavel[ codgtintributavel=" + codgtintributavel + " ]";
    }
    
}
