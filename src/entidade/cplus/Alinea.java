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
@Table(name = "ALINEA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alinea.findAll", query = "SELECT a FROM Alinea a")
    , @NamedQuery(name = "Alinea.findByCodalinea", query = "SELECT a FROM Alinea a WHERE a.codalinea = :codalinea")
    , @NamedQuery(name = "Alinea.findByCodigo", query = "SELECT a FROM Alinea a WHERE a.codigo = :codigo")
    , @NamedQuery(name = "Alinea.findByNomealinea", query = "SELECT a FROM Alinea a WHERE a.nomealinea = :nomealinea")
    , @NamedQuery(name = "Alinea.findByFlagreapresenta", query = "SELECT a FROM Alinea a WHERE a.flagreapresenta = :flagreapresenta")})
public class Alinea implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODALINEA")
    private String codalinea;
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "NOMEALINEA")
    private String nomealinea;
    @Column(name = "FLAGREAPRESENTA")
    private Character flagreapresenta;
    @OneToMany(mappedBy = "codalinea")
    private Collection<Cheques> chequesCollection;

    public Alinea() {
    }

    public Alinea(String codalinea) {
        this.codalinea = codalinea;
    }

    public Alinea(String codalinea, String codigo) {
        this.codalinea = codalinea;
        this.codigo = codigo;
    }

    public String getCodalinea() {
        return codalinea;
    }

    public void setCodalinea(String codalinea) {
        this.codalinea = codalinea;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomealinea() {
        return nomealinea;
    }

    public void setNomealinea(String nomealinea) {
        this.nomealinea = nomealinea;
    }

    public Character getFlagreapresenta() {
        return flagreapresenta;
    }

    public void setFlagreapresenta(Character flagreapresenta) {
        this.flagreapresenta = flagreapresenta;
    }

    @XmlTransient
    public Collection<Cheques> getChequesCollection() {
        return chequesCollection;
    }

    public void setChequesCollection(Collection<Cheques> chequesCollection) {
        this.chequesCollection = chequesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codalinea != null ? codalinea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alinea)) {
            return false;
        }
        Alinea other = (Alinea) object;
        if ((this.codalinea == null && other.codalinea != null) || (this.codalinea != null && !this.codalinea.equals(other.codalinea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Alinea[ codalinea=" + codalinea + " ]";
    }
    
}
