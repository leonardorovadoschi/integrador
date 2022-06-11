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
@Table(name = "TIPOLOGRADOURO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipologradouro.findAll", query = "SELECT t FROM Tipologradouro t")
    , @NamedQuery(name = "Tipologradouro.findByCodtipologradouro", query = "SELECT t FROM Tipologradouro t WHERE t.codtipologradouro = :codtipologradouro")
    , @NamedQuery(name = "Tipologradouro.findByCodigo", query = "SELECT t FROM Tipologradouro t WHERE t.codigo = :codigo")
    , @NamedQuery(name = "Tipologradouro.findByTipologradouro", query = "SELECT t FROM Tipologradouro t WHERE t.tipologradouro = :tipologradouro")})
public class Tipologradouro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODTIPOLOGRADOURO")
    private String codtipologradouro;
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "TIPOLOGRADOURO")
    private String tipologradouro;
    @OneToMany(mappedBy = "codtipologradouro")
    private Collection<Cep> cepCollection;

    public Tipologradouro() {
    }

    public Tipologradouro(String codtipologradouro) {
        this.codtipologradouro = codtipologradouro;
    }

    public Tipologradouro(String codtipologradouro, String codigo) {
        this.codtipologradouro = codtipologradouro;
        this.codigo = codigo;
    }

    public String getCodtipologradouro() {
        return codtipologradouro;
    }

    public void setCodtipologradouro(String codtipologradouro) {
        this.codtipologradouro = codtipologradouro;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipologradouro() {
        return tipologradouro;
    }

    public void setTipologradouro(String tipologradouro) {
        this.tipologradouro = tipologradouro;
    }

    @XmlTransient
    public Collection<Cep> getCepCollection() {
        return cepCollection;
    }

    public void setCepCollection(Collection<Cep> cepCollection) {
        this.cepCollection = cepCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codtipologradouro != null ? codtipologradouro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipologradouro)) {
            return false;
        }
        Tipologradouro other = (Tipologradouro) object;
        if ((this.codtipologradouro == null && other.codtipologradouro != null) || (this.codtipologradouro != null && !this.codtipologradouro.equals(other.codtipologradouro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Tipologradouro[ codtipologradouro=" + codtipologradouro + " ]";
    }
    
}
