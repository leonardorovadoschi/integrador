/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade.prestaShop;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo-note
 */
@Entity
@Table(name = "ps_anblogcat_shop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnblogcatShop.findAll", query = "SELECT p FROM PsAnblogcatShop p")})
public class PsAnblogcatShop implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsAnblogcatShopPK psAnblogcatShopPK;

    public PsAnblogcatShop() {
    }

    public PsAnblogcatShop(PsAnblogcatShopPK psAnblogcatShopPK) {
        this.psAnblogcatShopPK = psAnblogcatShopPK;
    }

    public PsAnblogcatShop(int idAnblogcat, int idShop) {
        this.psAnblogcatShopPK = new PsAnblogcatShopPK(idAnblogcat, idShop);
    }

    public PsAnblogcatShopPK getPsAnblogcatShopPK() {
        return psAnblogcatShopPK;
    }

    public void setPsAnblogcatShopPK(PsAnblogcatShopPK psAnblogcatShopPK) {
        this.psAnblogcatShopPK = psAnblogcatShopPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psAnblogcatShopPK != null ? psAnblogcatShopPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnblogcatShop)) {
            return false;
        }
        PsAnblogcatShop other = (PsAnblogcatShop) object;
        if ((this.psAnblogcatShopPK == null && other.psAnblogcatShopPK != null) || (this.psAnblogcatShopPK != null && !this.psAnblogcatShopPK.equals(other.psAnblogcatShopPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnblogcatShop[ psAnblogcatShopPK=" + psAnblogcatShopPK + " ]";
    }
    
}
