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
@Table(name = "ps_webservice_account_shop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsWebserviceAccountShop.findAll", query = "SELECT p FROM PsWebserviceAccountShop p")
    , @NamedQuery(name = "PsWebserviceAccountShop.findByIdWebserviceAccount", query = "SELECT p FROM PsWebserviceAccountShop p WHERE p.psWebserviceAccountShopPK.idWebserviceAccount = :idWebserviceAccount")
    , @NamedQuery(name = "PsWebserviceAccountShop.findByIdShop", query = "SELECT p FROM PsWebserviceAccountShop p WHERE p.psWebserviceAccountShopPK.idShop = :idShop")})
public class PsWebserviceAccountShop implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsWebserviceAccountShopPK psWebserviceAccountShopPK;

    public PsWebserviceAccountShop() {
    }

    public PsWebserviceAccountShop(PsWebserviceAccountShopPK psWebserviceAccountShopPK) {
        this.psWebserviceAccountShopPK = psWebserviceAccountShopPK;
    }

    public PsWebserviceAccountShop(int idWebserviceAccount, int idShop) {
        this.psWebserviceAccountShopPK = new PsWebserviceAccountShopPK(idWebserviceAccount, idShop);
    }

    public PsWebserviceAccountShopPK getPsWebserviceAccountShopPK() {
        return psWebserviceAccountShopPK;
    }

    public void setPsWebserviceAccountShopPK(PsWebserviceAccountShopPK psWebserviceAccountShopPK) {
        this.psWebserviceAccountShopPK = psWebserviceAccountShopPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psWebserviceAccountShopPK != null ? psWebserviceAccountShopPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsWebserviceAccountShop)) {
            return false;
        }
        PsWebserviceAccountShop other = (PsWebserviceAccountShop) object;
        if ((this.psWebserviceAccountShopPK == null && other.psWebserviceAccountShopPK != null) || (this.psWebserviceAccountShopPK != null && !this.psWebserviceAccountShopPK.equals(other.psWebserviceAccountShopPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsWebserviceAccountShop[ psWebserviceAccountShopPK=" + psWebserviceAccountShopPK + " ]";
    }
    
}
