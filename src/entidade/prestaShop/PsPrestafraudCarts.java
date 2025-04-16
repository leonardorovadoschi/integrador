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
@Table(name = "ps_prestafraud_carts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsPrestafraudCarts.findAll", query = "SELECT p FROM PsPrestafraudCarts p")})
public class PsPrestafraudCarts implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsPrestafraudCartsPK psPrestafraudCartsPK;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public PsPrestafraudCarts() {
    }

    public PsPrestafraudCarts(PsPrestafraudCartsPK psPrestafraudCartsPK) {
        this.psPrestafraudCartsPK = psPrestafraudCartsPK;
    }

    public PsPrestafraudCarts(PsPrestafraudCartsPK psPrestafraudCartsPK, Date date) {
        this.psPrestafraudCartsPK = psPrestafraudCartsPK;
        this.date = date;
    }

    public PsPrestafraudCarts(int idCart, int ipAddress) {
        this.psPrestafraudCartsPK = new PsPrestafraudCartsPK(idCart, ipAddress);
    }

    public PsPrestafraudCartsPK getPsPrestafraudCartsPK() {
        return psPrestafraudCartsPK;
    }

    public void setPsPrestafraudCartsPK(PsPrestafraudCartsPK psPrestafraudCartsPK) {
        this.psPrestafraudCartsPK = psPrestafraudCartsPK;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psPrestafraudCartsPK != null ? psPrestafraudCartsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsPrestafraudCarts)) {
            return false;
        }
        PsPrestafraudCarts other = (PsPrestafraudCarts) object;
        if ((this.psPrestafraudCartsPK == null && other.psPrestafraudCartsPK != null) || (this.psPrestafraudCartsPK != null && !this.psPrestafraudCartsPK.equals(other.psPrestafraudCartsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsPrestafraudCarts[ psPrestafraudCartsPK=" + psPrestafraudCartsPK + " ]";
    }
    
}
