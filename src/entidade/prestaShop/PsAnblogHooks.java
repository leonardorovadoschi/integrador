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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo-note
 */
@Entity
@Table(name = "ps_anblog_hooks")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnblogHooks.findAll", query = "SELECT p FROM PsAnblogHooks p")})
public class PsAnblogHooks implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @Column(name = "id_hook")
    private int idHook;
    @Basic(optional = false)
    @Column(name = "post_count")
    private int postCount;
    @Basic(optional = false)
    @Column(name = "status")
    private int status;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;

    public PsAnblogHooks() {
    }

    public PsAnblogHooks(String id) {
        this.id = id;
    }

    public PsAnblogHooks(String id, int idHook, int postCount, int status, int idShop) {
        this.id = id;
        this.idHook = idHook;
        this.postCount = postCount;
        this.status = status;
        this.idShop = idShop;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIdHook() {
        return idHook;
    }

    public void setIdHook(int idHook) {
        this.idHook = idHook;
    }

    public int getPostCount() {
        return postCount;
    }

    public void setPostCount(int postCount) {
        this.postCount = postCount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnblogHooks)) {
            return false;
        }
        PsAnblogHooks other = (PsAnblogHooks) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnblogHooks[ id=" + id + " ]";
    }
    
}
