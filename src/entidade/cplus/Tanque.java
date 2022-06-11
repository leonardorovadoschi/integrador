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
@Table(name = "TANQUE", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tanque.findAll", query = "SELECT t FROM Tanque t")
    , @NamedQuery(name = "Tanque.findByCodtanque", query = "SELECT t FROM Tanque t WHERE t.codtanque = :codtanque")
    , @NamedQuery(name = "Tanque.findByNumerotanque", query = "SELECT t FROM Tanque t WHERE t.numerotanque = :numerotanque")
    , @NamedQuery(name = "Tanque.findByNometanque", query = "SELECT t FROM Tanque t WHERE t.nometanque = :nometanque")})
public class Tanque implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODTANQUE")
    private String codtanque;
    @Basic(optional = false)
    @Column(name = "NUMEROTANQUE")
    private int numerotanque;
    @Column(name = "NOMETANQUE")
    private String nometanque;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codtanque")
    private Collection<Bico> bicoCollection;

    public Tanque() {
    }

    public Tanque(String codtanque) {
        this.codtanque = codtanque;
    }

    public Tanque(String codtanque, int numerotanque) {
        this.codtanque = codtanque;
        this.numerotanque = numerotanque;
    }

    public String getCodtanque() {
        return codtanque;
    }

    public void setCodtanque(String codtanque) {
        this.codtanque = codtanque;
    }

    public int getNumerotanque() {
        return numerotanque;
    }

    public void setNumerotanque(int numerotanque) {
        this.numerotanque = numerotanque;
    }

    public String getNometanque() {
        return nometanque;
    }

    public void setNometanque(String nometanque) {
        this.nometanque = nometanque;
    }

    @XmlTransient
    public Collection<Bico> getBicoCollection() {
        return bicoCollection;
    }

    public void setBicoCollection(Collection<Bico> bicoCollection) {
        this.bicoCollection = bicoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codtanque != null ? codtanque.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tanque)) {
            return false;
        }
        Tanque other = (Tanque) object;
        if ((this.codtanque == null && other.codtanque != null) || (this.codtanque != null && !this.codtanque.equals(other.codtanque))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Tanque[ codtanque=" + codtanque + " ]";
    }
    
}
