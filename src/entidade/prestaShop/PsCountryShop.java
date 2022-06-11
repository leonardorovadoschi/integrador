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
@Table(name = "ps_country_shop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsCountryShop.findAll", query = "SELECT p FROM PsCountryShop p")
    , @NamedQuery(name = "PsCountryShop.findByIdCountry", query = "SELECT p FROM PsCountryShop p WHERE p.psCountryShopPK.idCountry = :idCountry")
    , @NamedQuery(name = "PsCountryShop.findByIdShop", query = "SELECT p FROM PsCountryShop p WHERE p.psCountryShopPK.idShop = :idShop")})
public class PsCountryShop implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsCountryShopPK psCountryShopPK;

    public PsCountryShop() {
    }

    public PsCountryShop(PsCountryShopPK psCountryShopPK) {
        this.psCountryShopPK = psCountryShopPK;
    }

    public PsCountryShop(int idCountry, int idShop) {
        this.psCountryShopPK = new PsCountryShopPK(idCountry, idShop);
    }

    public PsCountryShopPK getPsCountryShopPK() {
        return psCountryShopPK;
    }

    public void setPsCountryShopPK(PsCountryShopPK psCountryShopPK) {
        this.psCountryShopPK = psCountryShopPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psCountryShopPK != null ? psCountryShopPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCountryShop)) {
            return false;
        }
        PsCountryShop other = (PsCountryShop) object;
        if ((this.psCountryShopPK == null && other.psCountryShopPK != null) || (this.psCountryShopPK != null && !this.psCountryShopPK.equals(other.psCountryShopPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCountryShop[ psCountryShopPK=" + psCountryShopPK + " ]";
    }
    
}
