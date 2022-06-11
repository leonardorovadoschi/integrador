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
@Table(name = "SATMARCA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Satmarca.findAll", query = "SELECT s FROM Satmarca s")
    , @NamedQuery(name = "Satmarca.findByCodsatmarca", query = "SELECT s FROM Satmarca s WHERE s.codsatmarca = :codsatmarca")
    , @NamedQuery(name = "Satmarca.findByMarca", query = "SELECT s FROM Satmarca s WHERE s.marca = :marca")
    , @NamedQuery(name = "Satmarca.findByGuid", query = "SELECT s FROM Satmarca s WHERE s.guid = :guid")
    , @NamedQuery(name = "Satmarca.findByFlagsat", query = "SELECT s FROM Satmarca s WHERE s.flagsat = :flagsat")
    , @NamedQuery(name = "Satmarca.findByFlagmfe", query = "SELECT s FROM Satmarca s WHERE s.flagmfe = :flagmfe")})
public class Satmarca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODSATMARCA")
    private String codsatmarca;
    @Column(name = "MARCA")
    private String marca;
    @Column(name = "GUID")
    private String guid;
    @Column(name = "FLAGSAT")
    private Character flagsat;
    @Column(name = "FLAGMFE")
    private Character flagmfe;
    @OneToMany(mappedBy = "codsatmarca")
    private Collection<Sat> satCollection;

    public Satmarca() {
    }

    public Satmarca(String codsatmarca) {
        this.codsatmarca = codsatmarca;
    }

    public String getCodsatmarca() {
        return codsatmarca;
    }

    public void setCodsatmarca(String codsatmarca) {
        this.codsatmarca = codsatmarca;
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

    public Character getFlagsat() {
        return flagsat;
    }

    public void setFlagsat(Character flagsat) {
        this.flagsat = flagsat;
    }

    public Character getFlagmfe() {
        return flagmfe;
    }

    public void setFlagmfe(Character flagmfe) {
        this.flagmfe = flagmfe;
    }

    @XmlTransient
    public Collection<Sat> getSatCollection() {
        return satCollection;
    }

    public void setSatCollection(Collection<Sat> satCollection) {
        this.satCollection = satCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codsatmarca != null ? codsatmarca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Satmarca)) {
            return false;
        }
        Satmarca other = (Satmarca) object;
        if ((this.codsatmarca == null && other.codsatmarca != null) || (this.codsatmarca != null && !this.codsatmarca.equals(other.codsatmarca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Satmarca[ codsatmarca=" + codsatmarca + " ]";
    }
    
}
