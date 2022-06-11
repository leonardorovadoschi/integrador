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
@Table(name = "MDFELETRONICOLOCAL", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mdfeletronicolocal.findAll", query = "SELECT m FROM Mdfeletronicolocal m")
    , @NamedQuery(name = "Mdfeletronicolocal.findByCodmdfeletronicolocal", query = "SELECT m FROM Mdfeletronicolocal m WHERE m.codmdfeletronicolocal = :codmdfeletronicolocal")
    , @NamedQuery(name = "Mdfeletronicolocal.findByCodigoibge", query = "SELECT m FROM Mdfeletronicolocal m WHERE m.codigoibge = :codigoibge")
    , @NamedQuery(name = "Mdfeletronicolocal.findByCarga", query = "SELECT m FROM Mdfeletronicolocal m WHERE m.carga = :carga")})
public class Mdfeletronicolocal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODMDFELETRONICOLOCAL")
    private String codmdfeletronicolocal;
    @Basic(optional = false)
    @Column(name = "CODIGOIBGE")
    private String codigoibge;
    @Column(name = "CARGA")
    private Character carga;
    @JoinColumn(name = "CODMDFELETRONICO", referencedColumnName = "CODMDFELETRONICO")
    @ManyToOne(optional = false)
    private Mdfeletronico codmdfeletronico;
    @JoinColumn(name = "CODMDFELETRONICOCARGAPOSTERIOR", referencedColumnName = "CODMDFELETRONICOCARGAPOSTERIOR")
    @ManyToOne
    private Mdfeletronicocargaposterior codmdfeletronicocargaposterior;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codmdfeletronicolocal")
    private Collection<Mdfeletroniconf> mdfeletroniconfCollection;

    public Mdfeletronicolocal() {
    }

    public Mdfeletronicolocal(String codmdfeletronicolocal) {
        this.codmdfeletronicolocal = codmdfeletronicolocal;
    }

    public Mdfeletronicolocal(String codmdfeletronicolocal, String codigoibge) {
        this.codmdfeletronicolocal = codmdfeletronicolocal;
        this.codigoibge = codigoibge;
    }

    public String getCodmdfeletronicolocal() {
        return codmdfeletronicolocal;
    }

    public void setCodmdfeletronicolocal(String codmdfeletronicolocal) {
        this.codmdfeletronicolocal = codmdfeletronicolocal;
    }

    public String getCodigoibge() {
        return codigoibge;
    }

    public void setCodigoibge(String codigoibge) {
        this.codigoibge = codigoibge;
    }

    public Character getCarga() {
        return carga;
    }

    public void setCarga(Character carga) {
        this.carga = carga;
    }

    public Mdfeletronico getCodmdfeletronico() {
        return codmdfeletronico;
    }

    public void setCodmdfeletronico(Mdfeletronico codmdfeletronico) {
        this.codmdfeletronico = codmdfeletronico;
    }

    public Mdfeletronicocargaposterior getCodmdfeletronicocargaposterior() {
        return codmdfeletronicocargaposterior;
    }

    public void setCodmdfeletronicocargaposterior(Mdfeletronicocargaposterior codmdfeletronicocargaposterior) {
        this.codmdfeletronicocargaposterior = codmdfeletronicocargaposterior;
    }

    @XmlTransient
    public Collection<Mdfeletroniconf> getMdfeletroniconfCollection() {
        return mdfeletroniconfCollection;
    }

    public void setMdfeletroniconfCollection(Collection<Mdfeletroniconf> mdfeletroniconfCollection) {
        this.mdfeletroniconfCollection = mdfeletroniconfCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codmdfeletronicolocal != null ? codmdfeletronicolocal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mdfeletronicolocal)) {
            return false;
        }
        Mdfeletronicolocal other = (Mdfeletronicolocal) object;
        if ((this.codmdfeletronicolocal == null && other.codmdfeletronicolocal != null) || (this.codmdfeletronicolocal != null && !this.codmdfeletronicolocal.equals(other.codmdfeletronicolocal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Mdfeletronicolocal[ codmdfeletronicolocal=" + codmdfeletronicolocal + " ]";
    }
    
}
