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
 * @author leo
 */
@Entity
@Table(name = "ps_group_shop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsGroupShop.findAll", query = "SELECT p FROM PsGroupShop p")
    , @NamedQuery(name = "PsGroupShop.findByIdGroup", query = "SELECT p FROM PsGroupShop p WHERE p.psGroupShopPK.idGroup = :idGroup")
    , @NamedQuery(name = "PsGroupShop.findByIdShop", query = "SELECT p FROM PsGroupShop p WHERE p.psGroupShopPK.idShop = :idShop")})
public class PsGroupShop implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsGroupShopPK psGroupShopPK;

    public PsGroupShop() {
    }

    public PsGroupShop(PsGroupShopPK psGroupShopPK) {
        this.psGroupShopPK = psGroupShopPK;
    }

    public PsGroupShop(int idGroup, int idShop) {
        this.psGroupShopPK = new PsGroupShopPK(idGroup, idShop);
    }

    public PsGroupShopPK getPsGroupShopPK() {
        return psGroupShopPK;
    }

    public void setPsGroupShopPK(PsGroupShopPK psGroupShopPK) {
        this.psGroupShopPK = psGroupShopPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psGroupShopPK != null ? psGroupShopPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsGroupShop)) {
            return false;
        }
        PsGroupShop other = (PsGroupShop) object;
        if ((this.psGroupShopPK == null && other.psGroupShopPK != null) || (this.psGroupShopPK != null && !this.psGroupShopPK.equals(other.psGroupShopPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsGroupShop[ psGroupShopPK=" + psGroupShopPK + " ]";
    }
    
}
