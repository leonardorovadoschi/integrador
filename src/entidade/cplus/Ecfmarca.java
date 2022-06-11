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
@Table(name = "ECFMARCA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ecfmarca.findAll", query = "SELECT e FROM Ecfmarca e")
    , @NamedQuery(name = "Ecfmarca.findByCodecfmarca", query = "SELECT e FROM Ecfmarca e WHERE e.codecfmarca = :codecfmarca")
    , @NamedQuery(name = "Ecfmarca.findByMarca", query = "SELECT e FROM Ecfmarca e WHERE e.marca = :marca")
    , @NamedQuery(name = "Ecfmarca.findByGuid", query = "SELECT e FROM Ecfmarca e WHERE e.guid = :guid")})
public class Ecfmarca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODECFMARCA")
    private String codecfmarca;
    @Column(name = "MARCA")
    private String marca;
    @Column(name = "GUID")
    private String guid;
    @OneToMany(mappedBy = "codecfmarca")
    private Collection<Ecfcodigoid> ecfcodigoidCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codecfmarca")
    private Collection<Ecfmodelo> ecfmodeloCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codecfmarca")
    private Collection<Ecf> ecfCollection;

    public Ecfmarca() {
    }

    public Ecfmarca(String codecfmarca) {
        this.codecfmarca = codecfmarca;
    }

    public String getCodecfmarca() {
        return codecfmarca;
    }

    public void setCodecfmarca(String codecfmarca) {
        this.codecfmarca = codecfmarca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    @XmlTransient
    public Collection<Ecfcodigoid> getEcfcodigoidCollection() {
        return ecfcodigoidCollection;
    }

    public void setEcfcodigoidCollection(Collection<Ecfcodigoid> ecfcodigoidCollection) {
        this.ecfcodigoidCollection = ecfcodigoidCollection;
    }

    @XmlTransient
    public Collection<Ecfmodelo> getEcfmodeloCollection() {
        return ecfmodeloCollection;
    }

    public void setEcfmodeloCollection(Collection<Ecfmodelo> ecfmodeloCollection) {
        this.ecfmodeloCollection = ecfmodeloCollection;
    }

    @XmlTransient
    public Collection<Ecf> getEcfCollection() {
        return ecfCollection;
    }

    public void setEcfCollection(Collection<Ecf> ecfCollection) {
        this.ecfCollection = ecfCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codecfmarca != null ? codecfmarca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ecfmarca)) {
            return false;
        }
        Ecfmarca other = (Ecfmarca) object;
        if ((this.codecfmarca == null && other.codecfmarca != null) || (this.codecfmarca != null && !this.codecfmarca.equals(other.codecfmarca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Ecfmarca[ codecfmarca=" + codecfmarca + " ]";
    }
    
}
