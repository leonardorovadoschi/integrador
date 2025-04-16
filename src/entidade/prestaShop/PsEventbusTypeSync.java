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
@Table(name = "ps_eventbus_type_sync")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsEventbusTypeSync.findAll", query = "SELECT p FROM PsEventbusTypeSync p")})
public class PsEventbusTypeSync implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsEventbusTypeSyncPK psEventbusTypeSyncPK;
    @Basic(optional = false)
    @Column(name = "offset")
    private int offset;
    @Basic(optional = false)
    @Column(name = "full_sync_finished")
    private boolean fullSyncFinished;
    @Basic(optional = false)
    @Column(name = "last_sync_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastSyncDate;

    public PsEventbusTypeSync() {
    }

    public PsEventbusTypeSync(PsEventbusTypeSyncPK psEventbusTypeSyncPK) {
        this.psEventbusTypeSyncPK = psEventbusTypeSyncPK;
    }

    public PsEventbusTypeSync(PsEventbusTypeSyncPK psEventbusTypeSyncPK, int offset, boolean fullSyncFinished, Date lastSyncDate) {
        this.psEventbusTypeSyncPK = psEventbusTypeSyncPK;
        this.offset = offset;
        this.fullSyncFinished = fullSyncFinished;
        this.lastSyncDate = lastSyncDate;
    }

    public PsEventbusTypeSync(String type, int idShop, String langIso) {
        this.psEventbusTypeSyncPK = new PsEventbusTypeSyncPK(type, idShop, langIso);
    }

    public PsEventbusTypeSyncPK getPsEventbusTypeSyncPK() {
        return psEventbusTypeSyncPK;
    }

    public void setPsEventbusTypeSyncPK(PsEventbusTypeSyncPK psEventbusTypeSyncPK) {
        this.psEventbusTypeSyncPK = psEventbusTypeSyncPK;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public boolean getFullSyncFinished() {
        return fullSyncFinished;
    }

    public void setFullSyncFinished(boolean fullSyncFinished) {
        this.fullSyncFinished = fullSyncFinished;
    }

    public Date getLastSyncDate() {
        return lastSyncDate;
    }

    public void setLastSyncDate(Date lastSyncDate) {
        this.lastSyncDate = lastSyncDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psEventbusTypeSyncPK != null ? psEventbusTypeSyncPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsEventbusTypeSync)) {
            return false;
        }
        PsEventbusTypeSync other = (PsEventbusTypeSync) object;
        if ((this.psEventbusTypeSyncPK == null && other.psEventbusTypeSyncPK != null) || (this.psEventbusTypeSyncPK != null && !this.psEventbusTypeSyncPK.equals(other.psEventbusTypeSyncPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsEventbusTypeSync[ psEventbusTypeSyncPK=" + psEventbusTypeSyncPK + " ]";
    }
    
}
