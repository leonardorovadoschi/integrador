/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade.prestaShop;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo-note
 */
@Entity
@Table(name = "ps_eventbus_incremental_sync")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsEventbusIncrementalSync.findAll", query = "SELECT p FROM PsEventbusIncrementalSync p")})
public class PsEventbusIncrementalSync implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsEventbusIncrementalSyncPK psEventbusIncrementalSyncPK;
    @Basic(optional = false)
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
    @Column(name = "action")
    private String action;

    public PsEventbusIncrementalSync() {
    }

    public PsEventbusIncrementalSync(PsEventbusIncrementalSyncPK psEventbusIncrementalSyncPK) {
        this.psEventbusIncrementalSyncPK = psEventbusIncrementalSyncPK;
    }

    public PsEventbusIncrementalSync(PsEventbusIncrementalSyncPK psEventbusIncrementalSyncPK, Date createdAt, String action) {
        this.psEventbusIncrementalSyncPK = psEventbusIncrementalSyncPK;
        this.createdAt = createdAt;
        this.action = action;
    }

    public PsEventbusIncrementalSync(String type, String idObject, int idShop, String langIso) {
        this.psEventbusIncrementalSyncPK = new PsEventbusIncrementalSyncPK(type, idObject, idShop, langIso);
    }

    public PsEventbusIncrementalSyncPK getPsEventbusIncrementalSyncPK() {
        return psEventbusIncrementalSyncPK;
    }

    public void setPsEventbusIncrementalSyncPK(PsEventbusIncrementalSyncPK psEventbusIncrementalSyncPK) {
        this.psEventbusIncrementalSyncPK = psEventbusIncrementalSyncPK;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psEventbusIncrementalSyncPK != null ? psEventbusIncrementalSyncPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsEventbusIncrementalSync)) {
            return false;
        }
        PsEventbusIncrementalSync other = (PsEventbusIncrementalSync) object;
        if ((this.psEventbusIncrementalSyncPK == null && other.psEventbusIncrementalSyncPK != null) || (this.psEventbusIncrementalSyncPK != null && !this.psEventbusIncrementalSyncPK.equals(other.psEventbusIncrementalSyncPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsEventbusIncrementalSync[ psEventbusIncrementalSyncPK=" + psEventbusIncrementalSyncPK + " ]";
    }
    
}
