/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "OS_STATUSHISTORICO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OsStatushistorico.findAll", query = "SELECT o FROM OsStatushistorico o")
    , @NamedQuery(name = "OsStatushistorico.findByCodstatushistorico", query = "SELECT o FROM OsStatushistorico o WHERE o.codstatushistorico = :codstatushistorico")
    , @NamedQuery(name = "OsStatushistorico.findByData", query = "SELECT o FROM OsStatushistorico o WHERE o.data = :data")})
public class OsStatushistorico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODSTATUSHISTORICO")
    private String codstatushistorico;
    @Column(name = "DATA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @JoinColumn(name = "CODOS", referencedColumnName = "CODOS")
    @ManyToOne(optional = false)
    private OsOrdemservico codos;
    @JoinColumn(name = "CODSTATUS", referencedColumnName = "CODSTATUS")
    @ManyToOne
    private OsStatus codstatus;

    public OsStatushistorico() {
    }

    public OsStatushistorico(String codstatushistorico) {
        this.codstatushistorico = codstatushistorico;
    }

    public String getCodstatushistorico() {
        return codstatushistorico;
    }

    public void setCodstatushistorico(String codstatushistorico) {
        this.codstatushistorico = codstatushistorico;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public OsOrdemservico getCodos() {
        return codos;
    }

    public void setCodos(OsOrdemservico codos) {
        this.codos = codos;
    }

    public OsStatus getCodstatus() {
        return codstatus;
    }

    public void setCodstatus(OsStatus codstatus) {
        this.codstatus = codstatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codstatushistorico != null ? codstatushistorico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OsStatushistorico)) {
            return false;
        }
        OsStatushistorico other = (OsStatushistorico) object;
        if ((this.codstatushistorico == null && other.codstatushistorico != null) || (this.codstatushistorico != null && !this.codstatushistorico.equals(other.codstatushistorico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.OsStatushistorico[ codstatushistorico=" + codstatushistorico + " ]";
    }
    
}
