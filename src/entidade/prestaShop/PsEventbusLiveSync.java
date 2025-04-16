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
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "ps_eventbus_live_sync")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsEventbusLiveSync.findAll", query = "SELECT p FROM PsEventbusLiveSync p")})
public class PsEventbusLiveSync implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "shop_content")
    private String shopContent;
    @Basic(optional = false)
    @Column(name = "last_change_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastChangeAt;

    public PsEventbusLiveSync() {
    }

    public PsEventbusLiveSync(String shopContent) {
        this.shopContent = shopContent;
    }

    public PsEventbusLiveSync(String shopContent, Date lastChangeAt) {
        this.shopContent = shopContent;
        this.lastChangeAt = lastChangeAt;
    }

    public String getShopContent() {
        return shopContent;
    }

    public void setShopContent(String shopContent) {
        this.shopContent = shopContent;
    }

    public Date getLastChangeAt() {
        return lastChangeAt;
    }

    public void setLastChangeAt(Date lastChangeAt) {
        this.lastChangeAt = lastChangeAt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shopContent != null ? shopContent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsEventbusLiveSync)) {
            return false;
        }
        PsEventbusLiveSync other = (PsEventbusLiveSync) object;
        if ((this.shopContent == null && other.shopContent != null) || (this.shopContent != null && !this.shopContent.equals(other.shopContent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsEventbusLiveSync[ shopContent=" + shopContent + " ]";
    }
    
}
