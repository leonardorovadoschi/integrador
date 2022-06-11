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
@Table(name = "ps_linksmenutop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsLinksmenutop.findAll", query = "SELECT p FROM PsLinksmenutop p")
    , @NamedQuery(name = "PsLinksmenutop.findByIdLinksmenutop", query = "SELECT p FROM PsLinksmenutop p WHERE p.idLinksmenutop = :idLinksmenutop")
    , @NamedQuery(name = "PsLinksmenutop.findByIdShop", query = "SELECT p FROM PsLinksmenutop p WHERE p.idShop = :idShop")
    , @NamedQuery(name = "PsLinksmenutop.findByNewWindow", query = "SELECT p FROM PsLinksmenutop p WHERE p.newWindow = :newWindow")})
public class PsLinksmenutop implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_linksmenutop")
    private Integer idLinksmenutop;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;
    @Basic(optional = false)
    @Column(name = "new_window")
    private boolean newWindow;

    public PsLinksmenutop() {
    }

    public PsLinksmenutop(Integer idLinksmenutop) {
        this.idLinksmenutop = idLinksmenutop;
    }

    public PsLinksmenutop(Integer idLinksmenutop, int idShop, boolean newWindow) {
        this.idLinksmenutop = idLinksmenutop;
        this.idShop = idShop;
        this.newWindow = newWindow;
    }

    public Integer getIdLinksmenutop() {
        return idLinksmenutop;
    }

    public void setIdLinksmenutop(Integer idLinksmenutop) {
        this.idLinksmenutop = idLinksmenutop;
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

    public boolean getNewWindow() {
        return newWindow;
    }

    public void setNewWindow(boolean newWindow) {
        this.newWindow = newWindow;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLinksmenutop != null ? idLinksmenutop.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsLinksmenutop)) {
            return false;
        }
        PsLinksmenutop other = (PsLinksmenutop) object;
        if ((this.idLinksmenutop == null && other.idLinksmenutop != null) || (this.idLinksmenutop != null && !this.idLinksmenutop.equals(other.idLinksmenutop))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsLinksmenutop[ idLinksmenutop=" + idLinksmenutop + " ]";
    }
    
}
