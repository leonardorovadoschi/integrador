/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "ITEMGRADE", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Itemgrade.findAll", query = "SELECT i FROM Itemgrade i")
    , @NamedQuery(name = "Itemgrade.findByCoditemgrade", query = "SELECT i FROM Itemgrade i WHERE i.coditemgrade = :coditemgrade")
    , @NamedQuery(name = "Itemgrade.findByCodigo", query = "SELECT i FROM Itemgrade i WHERE i.codigo = :codigo")
    , @NamedQuery(name = "Itemgrade.findByDescricao", query = "SELECT i FROM Itemgrade i WHERE i.descricao = :descricao")})
public class Itemgrade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODITEMGRADE")
    private String coditemgrade;
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "DESCRICAO")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coditemgrade")
    private Collection<Itemgradedetalhe> itemgradedetalheCollection;

    public Itemgrade() {
    }

    public Itemgrade(String coditemgrade) {
        this.coditemgrade = coditemgrade;
    }

    public Itemgrade(String coditemgrade, String codigo) {
        this.coditemgrade = coditemgrade;
        this.codigo = codigo;
    }

    public String getCoditemgrade() {
        return coditemgrade;
    }

    public void setCoditemgrade(String coditemgrade) {
        this.coditemgrade = coditemgrade;
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

    @XmlTransient
    public Collection<Itemgradedetalhe> getItemgradedetalheCollection() {
        return itemgradedetalheCollection;
    }

    public void setItemgradedetalheCollection(Collection<Itemgradedetalhe> itemgradedetalheCollection) {
        this.itemgradedetalheCollection = itemgradedetalheCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coditemgrade != null ? coditemgrade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Itemgrade)) {
            return false;
        }
        Itemgrade other = (Itemgrade) object;
        if ((this.coditemgrade == null && other.coditemgrade != null) || (this.coditemgrade != null && !this.coditemgrade.equals(other.coditemgrade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Itemgrade[ coditemgrade=" + coditemgrade + " ]";
    }
    
}
