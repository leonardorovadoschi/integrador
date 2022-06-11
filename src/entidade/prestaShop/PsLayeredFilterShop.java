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
@Table(name = "ps_layered_filter_shop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsLayeredFilterShop.findAll", query = "SELECT p FROM PsLayeredFilterShop p")
    , @NamedQuery(name = "PsLayeredFilterShop.findByIdLayeredFilter", query = "SELECT p FROM PsLayeredFilterShop p WHERE p.psLayeredFilterShopPK.idLayeredFilter = :idLayeredFilter")
    , @NamedQuery(name = "PsLayeredFilterShop.findByIdShop", query = "SELECT p FROM PsLayeredFilterShop p WHERE p.psLayeredFilterShopPK.idShop = :idShop")})
public class PsLayeredFilterShop implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsLayeredFilterShopPK psLayeredFilterShopPK;

    public PsLayeredFilterShop() {
    }

    public PsLayeredFilterShop(PsLayeredFilterShopPK psLayeredFilterShopPK) {
        this.psLayeredFilterShopPK = psLayeredFilterShopPK;
    }

    public PsLayeredFilterShop(int idLayeredFilter, int idShop) {
        this.psLayeredFilterShopPK = new PsLayeredFilterShopPK(idLayeredFilter, idShop);
    }

    public PsLayeredFilterShopPK getPsLayeredFilterShopPK() {
        return psLayeredFilterShopPK;
    }

    public void setPsLayeredFilterShopPK(PsLayeredFilterShopPK psLayeredFilterShopPK) {
        this.psLayeredFilterShopPK = psLayeredFilterShopPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psLayeredFilterShopPK != null ? psLayeredFilterShopPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsLayeredFilterShop)) {
            return false;
        }
        PsLayeredFilterShop other = (PsLayeredFilterShop) object;
        if ((this.psLayeredFilterShopPK == null && other.psLayeredFilterShopPK != null) || (this.psLayeredFilterShopPK != null && !this.psLayeredFilterShopPK.equals(other.psLayeredFilterShopPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsLayeredFilterShop[ psLayeredFilterShopPK=" + psLayeredFilterShopPK + " ]";
    }
    
}
