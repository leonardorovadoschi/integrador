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
@Table(name = "TMP_SPED_INCONSISTENCIA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TmpSpedInconsistencia.findAll", query = "SELECT t FROM TmpSpedInconsistencia t")
    , @NamedQuery(name = "TmpSpedInconsistencia.findById", query = "SELECT t FROM TmpSpedInconsistencia t WHERE t.id = :id")
    , @NamedQuery(name = "TmpSpedInconsistencia.findByDescinconsistencia", query = "SELECT t FROM TmpSpedInconsistencia t WHERE t.descinconsistencia = :descinconsistencia")})
public class TmpSpedInconsistencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "DESCINCONSISTENCIA")
    private String descinconsistencia;
    @OneToMany(mappedBy = "id")
    private Collection<TmpSpedInconsistenciaitem> tmpSpedInconsistenciaitemCollection;

    public TmpSpedInconsistencia() {
    }

    public TmpSpedInconsistencia(Integer id) {
        this.id = id;
    }

    public TmpSpedInconsistencia(Integer id, String descinconsistencia) {
        this.id = id;
        this.descinconsistencia = descinconsistencia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescinconsistencia() {
        return descinconsistencia;
    }

    public void setDescinconsistencia(String descinconsistencia) {
        this.descinconsistencia = descinconsistencia;
    }

    @XmlTransient
    public Collection<TmpSpedInconsistenciaitem> getTmpSpedInconsistenciaitemCollection() {
        return tmpSpedInconsistenciaitemCollection;
    }

    public void setTmpSpedInconsistenciaitemCollection(Collection<TmpSpedInconsistenciaitem> tmpSpedInconsistenciaitemCollection) {
        this.tmpSpedInconsistenciaitemCollection = tmpSpedInconsistenciaitemCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TmpSpedInconsistencia)) {
            return false;
        }
        TmpSpedInconsistencia other = (TmpSpedInconsistencia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.TmpSpedInconsistencia[ id=" + id + " ]";
    }
    
}
