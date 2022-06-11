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
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author leo
 */
@Embeddable
public class PsConnectionsPagePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_connections")
    private int idConnections;
    @Basic(optional = false)
    @Column(name = "id_page")
    private int idPage;
    @Basic(optional = false)
    @Column(name = "time_start")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeStart;

    public PsConnectionsPagePK() {
    }

    public PsConnectionsPagePK(int idConnections, int idPage, Date timeStart) {
        this.idConnections = idConnections;
        this.idPage = idPage;
        this.timeStart = timeStart;
    }

    public int getIdConnections() {
        return idConnections;
    }

    public void setIdConnections(int idConnections) {
        this.idConnections = idConnections;
    }

    public int getIdPage() {
        return idPage;
    }

    public void setIdPage(int idPage) {
        this.idPage = idPage;
    }

    public Date getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idConnections;
        hash += (int) idPage;
        hash += (timeStart != null ? timeStart.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsConnectionsPagePK)) {
            return false;
        }
        PsConnectionsPagePK other = (PsConnectionsPagePK) object;
        if (this.idConnections != other.idConnections) {
            return false;
        }
        if (this.idPage != other.idPage) {
            return false;
        }
        if ((this.timeStart == null && other.timeStart != null) || (this.timeStart != null && !this.timeStart.equals(other.timeStart))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsConnectionsPagePK[ idConnections=" + idConnections + ", idPage=" + idPage + ", timeStart=" + timeStart + " ]";
    }
    
}
