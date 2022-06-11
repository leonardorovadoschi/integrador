/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.prestaShop;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ps_quick_access")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsQuickAccess.findAll", query = "SELECT p FROM PsQuickAccess p")
    , @NamedQuery(name = "PsQuickAccess.findByIdQuickAccess", query = "SELECT p FROM PsQuickAccess p WHERE p.idQuickAccess = :idQuickAccess")
    , @NamedQuery(name = "PsQuickAccess.findByNewWindow", query = "SELECT p FROM PsQuickAccess p WHERE p.newWindow = :newWindow")
    , @NamedQuery(name = "PsQuickAccess.findByLink", query = "SELECT p FROM PsQuickAccess p WHERE p.link = :link")})
public class PsQuickAccess implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_quick_access")
    private Integer idQuickAccess;
    @Basic(optional = false)
    @Column(name = "new_window")
    private boolean newWindow;
    @Basic(optional = false)
    @Column(name = "link")
    private String link;

    public PsQuickAccess() {
    }

    public PsQuickAccess(Integer idQuickAccess) {
        this.idQuickAccess = idQuickAccess;
    }

    public PsQuickAccess(Integer idQuickAccess, boolean newWindow, String link) {
        this.idQuickAccess = idQuickAccess;
        this.newWindow = newWindow;
        this.link = link;
    }

    public Integer getIdQuickAccess() {
        return idQuickAccess;
    }

    public void setIdQuickAccess(Integer idQuickAccess) {
        this.idQuickAccess = idQuickAccess;
    }

    public boolean getNewWindow() {
        return newWindow;
    }

    public void setNewWindow(boolean newWindow) {
        this.newWindow = newWindow;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idQuickAccess != null ? idQuickAccess.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsQuickAccess)) {
            return false;
        }
        PsQuickAccess other = (PsQuickAccess) object;
        if ((this.idQuickAccess == null && other.idQuickAccess != null) || (this.idQuickAccess != null && !this.idQuickAccess.equals(other.idQuickAccess))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsQuickAccess[ idQuickAccess=" + idQuickAccess + " ]";
    }
    
}
