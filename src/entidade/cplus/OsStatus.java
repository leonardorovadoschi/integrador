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
@Table(name = "OS_STATUS", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OsStatus.findAll", query = "SELECT o FROM OsStatus o")
    , @NamedQuery(name = "OsStatus.findByCodstatus", query = "SELECT o FROM OsStatus o WHERE o.codstatus = :codstatus")
    , @NamedQuery(name = "OsStatus.findByCodigo", query = "SELECT o FROM OsStatus o WHERE o.codigo = :codigo")
    , @NamedQuery(name = "OsStatus.findByStatus", query = "SELECT o FROM OsStatus o WHERE o.status = :status")
    , @NamedQuery(name = "OsStatus.findByCor", query = "SELECT o FROM OsStatus o WHERE o.cor = :cor")})
public class OsStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODSTATUS")
    private String codstatus;
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "COR")
    private Integer cor;
    @OneToMany(mappedBy = "codstatus")
    private Collection<OsLaudo> osLaudoCollection;
    @OneToMany(mappedBy = "codstatus")
    private Collection<OsStatushistorico> osStatushistoricoCollection;

    public OsStatus() {
    }

    public OsStatus(String codstatus) {
        this.codstatus = codstatus;
    }

    public OsStatus(String codstatus, String codigo) {
        this.codstatus = codstatus;
        this.codigo = codigo;
    }

    public String getCodstatus() {
        return codstatus;
    }

    public void setCodstatus(String codstatus) {
        this.codstatus = codstatus;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCor() {
        return cor;
    }

    public void setCor(Integer cor) {
        this.cor = cor;
    }

    @XmlTransient
    public Collection<OsLaudo> getOsLaudoCollection() {
        return osLaudoCollection;
    }

    public void setOsLaudoCollection(Collection<OsLaudo> osLaudoCollection) {
        this.osLaudoCollection = osLaudoCollection;
    }

    @XmlTransient
    public Collection<OsStatushistorico> getOsStatushistoricoCollection() {
        return osStatushistoricoCollection;
    }

    public void setOsStatushistoricoCollection(Collection<OsStatushistorico> osStatushistoricoCollection) {
        this.osStatushistoricoCollection = osStatushistoricoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codstatus != null ? codstatus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OsStatus)) {
            return false;
        }
        OsStatus other = (OsStatus) object;
        if ((this.codstatus == null && other.codstatus != null) || (this.codstatus != null && !this.codstatus.equals(other.codstatus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.OsStatus[ codstatus=" + codstatus + " ]";
    }
    
}
