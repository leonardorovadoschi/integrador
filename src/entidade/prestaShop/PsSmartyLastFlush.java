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
 * @author leo
 */
@Entity
@Table(name = "ps_smarty_last_flush")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsSmartyLastFlush.findAll", query = "SELECT p FROM PsSmartyLastFlush p")
    , @NamedQuery(name = "PsSmartyLastFlush.findByType", query = "SELECT p FROM PsSmartyLastFlush p WHERE p.type = :type")
    , @NamedQuery(name = "PsSmartyLastFlush.findByLastFlush", query = "SELECT p FROM PsSmartyLastFlush p WHERE p.lastFlush = :lastFlush")})
public class PsSmartyLastFlush implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @Column(name = "last_flush")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastFlush;

    public PsSmartyLastFlush() {
    }

    public PsSmartyLastFlush(String type) {
        this.type = type;
    }

    public PsSmartyLastFlush(String type, Date lastFlush) {
        this.type = type;
        this.lastFlush = lastFlush;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getLastFlush() {
        return lastFlush;
    }

    public void setLastFlush(Date lastFlush) {
        this.lastFlush = lastFlush;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (type != null ? type.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsSmartyLastFlush)) {
            return false;
        }
        PsSmartyLastFlush other = (PsSmartyLastFlush) object;
        if ((this.type == null && other.type != null) || (this.type != null && !this.type.equals(other.type))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsSmartyLastFlush[ type=" + type + " ]";
    }
    
}
