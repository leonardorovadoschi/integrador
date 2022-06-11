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
@Table(name = "PRODUCAOSTATUS", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producaostatus.findAll", query = "SELECT p FROM Producaostatus p")
    , @NamedQuery(name = "Producaostatus.findByCodproducaostatus", query = "SELECT p FROM Producaostatus p WHERE p.codproducaostatus = :codproducaostatus")
    , @NamedQuery(name = "Producaostatus.findByCodigo", query = "SELECT p FROM Producaostatus p WHERE p.codigo = :codigo")
    , @NamedQuery(name = "Producaostatus.findByNomeproducaostatus", query = "SELECT p FROM Producaostatus p WHERE p.nomeproducaostatus = :nomeproducaostatus")})
public class Producaostatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODPRODUCAOSTATUS")
    private String codproducaostatus;
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "NOMEPRODUCAOSTATUS")
    private String nomeproducaostatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codproducaostatus")
    private Collection<Producaohistorico> producaohistoricoCollection;

    public Producaostatus() {
    }

    public Producaostatus(String codproducaostatus) {
        this.codproducaostatus = codproducaostatus;
    }

    public String getCodproducaostatus() {
        return codproducaostatus;
    }

    public void setCodproducaostatus(String codproducaostatus) {
        this.codproducaostatus = codproducaostatus;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomeproducaostatus() {
        return nomeproducaostatus;
    }

    public void setNomeproducaostatus(String nomeproducaostatus) {
        this.nomeproducaostatus = nomeproducaostatus;
    }

    @XmlTransient
    public Collection<Producaohistorico> getProducaohistoricoCollection() {
        return producaohistoricoCollection;
    }

    public void setProducaohistoricoCollection(Collection<Producaohistorico> producaohistoricoCollection) {
        this.producaohistoricoCollection = producaohistoricoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codproducaostatus != null ? codproducaostatus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producaostatus)) {
            return false;
        }
        Producaostatus other = (Producaostatus) object;
        if ((this.codproducaostatus == null && other.codproducaostatus != null) || (this.codproducaostatus != null && !this.codproducaostatus.equals(other.codproducaostatus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Producaostatus[ codproducaostatus=" + codproducaostatus + " ]";
    }
    
}
