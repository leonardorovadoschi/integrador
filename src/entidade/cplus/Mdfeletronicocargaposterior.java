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
@Table(name = "MDFELETRONICOCARGAPOSTERIOR", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mdfeletronicocargaposterior.findAll", query = "SELECT m FROM Mdfeletronicocargaposterior m")
    , @NamedQuery(name = "Mdfeletronicocargaposterior.findByCodmdfeletronicocargaposterior", query = "SELECT m FROM Mdfeletronicocargaposterior m WHERE m.codmdfeletronicocargaposterior = :codmdfeletronicocargaposterior")
    , @NamedQuery(name = "Mdfeletronicocargaposterior.findByCodigoibge", query = "SELECT m FROM Mdfeletronicocargaposterior m WHERE m.codigoibge = :codigoibge")
    , @NamedQuery(name = "Mdfeletronicocargaposterior.findByNumseqevento", query = "SELECT m FROM Mdfeletronicocargaposterior m WHERE m.numseqevento = :numseqevento")})
public class Mdfeletronicocargaposterior implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODMDFELETRONICOCARGAPOSTERIOR")
    private String codmdfeletronicocargaposterior;
    @Basic(optional = false)
    @Column(name = "CODIGOIBGE")
    private String codigoibge;
    @Basic(optional = false)
    @Column(name = "NUMSEQEVENTO")
    private int numseqevento;
    @JoinColumn(name = "CODMDFELETRONICO", referencedColumnName = "CODMDFELETRONICO")
    @ManyToOne(optional = false)
    private Mdfeletronico codmdfeletronico;
    @OneToMany(mappedBy = "codmdfeletronicocargaposterior")
    private Collection<Mdfeletronicolocal> mdfeletronicolocalCollection;

    public Mdfeletronicocargaposterior() {
    }

    public Mdfeletronicocargaposterior(String codmdfeletronicocargaposterior) {
        this.codmdfeletronicocargaposterior = codmdfeletronicocargaposterior;
    }

    public Mdfeletronicocargaposterior(String codmdfeletronicocargaposterior, String codigoibge, int numseqevento) {
        this.codmdfeletronicocargaposterior = codmdfeletronicocargaposterior;
        this.codigoibge = codigoibge;
        this.numseqevento = numseqevento;
    }

    public String getCodmdfeletronicocargaposterior() {
        return codmdfeletronicocargaposterior;
    }

    public void setCodmdfeletronicocargaposterior(String codmdfeletronicocargaposterior) {
        this.codmdfeletronicocargaposterior = codmdfeletronicocargaposterior;
    }

    public String getCodigoibge() {
        return codigoibge;
    }

    public void setCodigoibge(String codigoibge) {
        this.codigoibge = codigoibge;
    }

    public int getNumseqevento() {
        return numseqevento;
    }

    public void setNumseqevento(int numseqevento) {
        this.numseqevento = numseqevento;
    }

    public Mdfeletronico getCodmdfeletronico() {
        return codmdfeletronico;
    }

    public void setCodmdfeletronico(Mdfeletronico codmdfeletronico) {
        this.codmdfeletronico = codmdfeletronico;
    }

    @XmlTransient
    public Collection<Mdfeletronicolocal> getMdfeletronicolocalCollection() {
        return mdfeletronicolocalCollection;
    }

    public void setMdfeletronicolocalCollection(Collection<Mdfeletronicolocal> mdfeletronicolocalCollection) {
        this.mdfeletronicolocalCollection = mdfeletronicolocalCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codmdfeletronicocargaposterior != null ? codmdfeletronicocargaposterior.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mdfeletronicocargaposterior)) {
            return false;
        }
        Mdfeletronicocargaposterior other = (Mdfeletronicocargaposterior) object;
        if ((this.codmdfeletronicocargaposterior == null && other.codmdfeletronicocargaposterior != null) || (this.codmdfeletronicocargaposterior != null && !this.codmdfeletronicocargaposterior.equals(other.codmdfeletronicocargaposterior))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Mdfeletronicocargaposterior[ codmdfeletronicocargaposterior=" + codmdfeletronicocargaposterior + " ]";
    }
    
}
