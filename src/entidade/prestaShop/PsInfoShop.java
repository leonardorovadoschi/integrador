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
@Table(name = "ps_info_shop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsInfoShop.findAll", query = "SELECT p FROM PsInfoShop p")
    , @NamedQuery(name = "PsInfoShop.findByIdInfo", query = "SELECT p FROM PsInfoShop p WHERE p.psInfoShopPK.idInfo = :idInfo")
    , @NamedQuery(name = "PsInfoShop.findByIdShop", query = "SELECT p FROM PsInfoShop p WHERE p.psInfoShopPK.idShop = :idShop")})
public class PsInfoShop implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsInfoShopPK psInfoShopPK;

    public PsInfoShop() {
    }

    public PsInfoShop(PsInfoShopPK psInfoShopPK) {
        this.psInfoShopPK = psInfoShopPK;
    }

    public PsInfoShop(int idInfo, int idShop) {
        this.psInfoShopPK = new PsInfoShopPK(idInfo, idShop);
    }

    public PsInfoShopPK getPsInfoShopPK() {
        return psInfoShopPK;
    }

    public void setPsInfoShopPK(PsInfoShopPK psInfoShopPK) {
        this.psInfoShopPK = psInfoShopPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psInfoShopPK != null ? psInfoShopPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsInfoShop)) {
            return false;
        }
        PsInfoShop other = (PsInfoShop) object;
        if ((this.psInfoShopPK == null && other.psInfoShopPK != null) || (this.psInfoShopPK != null && !this.psInfoShopPK.equals(other.psInfoShopPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsInfoShop[ psInfoShopPK=" + psInfoShopPK + " ]";
    }
    
}
