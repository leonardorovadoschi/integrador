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
@Table(name = "MDFELETRONICOTIPOEVENTO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mdfeletronicotipoevento.findAll", query = "SELECT m FROM Mdfeletronicotipoevento m")
    , @NamedQuery(name = "Mdfeletronicotipoevento.findByCodmdfeletronicotipoevento", query = "SELECT m FROM Mdfeletronicotipoevento m WHERE m.codmdfeletronicotipoevento = :codmdfeletronicotipoevento")
    , @NamedQuery(name = "Mdfeletronicotipoevento.findByCodigoevento", query = "SELECT m FROM Mdfeletronicotipoevento m WHERE m.codigoevento = :codigoevento")
    , @NamedQuery(name = "Mdfeletronicotipoevento.findByDescricao", query = "SELECT m FROM Mdfeletronicotipoevento m WHERE m.descricao = :descricao")})
public class Mdfeletronicotipoevento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODMDFELETRONICOTIPOEVENTO")
    private String codmdfeletronicotipoevento;
    @Column(name = "CODIGOEVENTO")
    private String codigoevento;
    @Column(name = "DESCRICAO")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codmdfeletronicotipoevento")
    private Collection<Mdfeletronicoevento> mdfeletronicoeventoCollection;

    public Mdfeletronicotipoevento() {
    }

    public Mdfeletronicotipoevento(String codmdfeletronicotipoevento) {
        this.codmdfeletronicotipoevento = codmdfeletronicotipoevento;
    }

    public String getCodmdfeletronicotipoevento() {
        return codmdfeletronicotipoevento;
    }

    public void setCodmdfeletronicotipoevento(String codmdfeletronicotipoevento) {
        this.codmdfeletronicotipoevento = codmdfeletronicotipoevento;
    }

    public String getCodigoevento() {
        return codigoevento;
    }

    public void setCodigoevento(String codigoevento) {
        this.codigoevento = codigoevento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public Collection<Mdfeletronicoevento> getMdfeletronicoeventoCollection() {
        return mdfeletronicoeventoCollection;
    }

    public void setMdfeletronicoeventoCollection(Collection<Mdfeletronicoevento> mdfeletronicoeventoCollection) {
        this.mdfeletronicoeventoCollection = mdfeletronicoeventoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codmdfeletronicotipoevento != null ? codmdfeletronicotipoevento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mdfeletronicotipoevento)) {
            return false;
        }
        Mdfeletronicotipoevento other = (Mdfeletronicotipoevento) object;
        if ((this.codmdfeletronicotipoevento == null && other.codmdfeletronicotipoevento != null) || (this.codmdfeletronicotipoevento != null && !this.codmdfeletronicotipoevento.equals(other.codmdfeletronicotipoevento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Mdfeletronicotipoevento[ codmdfeletronicotipoevento=" + codmdfeletronicotipoevento + " ]";
    }
    
}
