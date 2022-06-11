/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.prestaShop;

import java.io.Serializable;
import java.util.Date;
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
 * @author leo
 */
@Entity
@Table(name = "ps_connections_page")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsConnectionsPage.findAll", query = "SELECT p FROM PsConnectionsPage p")
    , @NamedQuery(name = "PsConnectionsPage.findByIdConnections", query = "SELECT p FROM PsConnectionsPage p WHERE p.psConnectionsPagePK.idConnections = :idConnections")
    , @NamedQuery(name = "PsConnectionsPage.findByIdPage", query = "SELECT p FROM PsConnectionsPage p WHERE p.psConnectionsPagePK.idPage = :idPage")
    , @NamedQuery(name = "PsConnectionsPage.findByTimeStart", query = "SELECT p FROM PsConnectionsPage p WHERE p.psConnectionsPagePK.timeStart = :timeStart")
    , @NamedQuery(name = "PsConnectionsPage.findByTimeEnd", query = "SELECT p FROM PsConnectionsPage p WHERE p.timeEnd = :timeEnd")})
public class PsConnectionsPage implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsConnectionsPagePK psConnectionsPagePK;
    @Column(name = "time_end")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeEnd;

    public PsConnectionsPage() {
    }

    public PsConnectionsPage(PsConnectionsPagePK psConnectionsPagePK) {
        this.psConnectionsPagePK = psConnectionsPagePK;
    }

    public PsConnectionsPage(int idConnections, int idPage, Date timeStart) {
        this.psConnectionsPagePK = new PsConnectionsPagePK(idConnections, idPage, timeStart);
    }

    public PsConnectionsPagePK getPsConnectionsPagePK() {
        return psConnectionsPagePK;
    }

    public void setPsConnectionsPagePK(PsConnectionsPagePK psConnectionsPagePK) {
        this.psConnectionsPagePK = psConnectionsPagePK;
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psConnectionsPagePK != null ? psConnectionsPagePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsConnectionsPage)) {
            return false;
        }
        PsConnectionsPage other = (PsConnectionsPage) object;
        if ((this.psConnectionsPagePK == null && other.psConnectionsPagePK != null) || (this.psConnectionsPagePK != null && !this.psConnectionsPagePK.equals(other.psConnectionsPagePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsConnectionsPage[ psConnectionsPagePK=" + psConnectionsPagePK + " ]";
    }
    
}
