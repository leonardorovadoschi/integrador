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
@Table(name = "ps_lang_shop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsLangShop.findAll", query = "SELECT p FROM PsLangShop p")
    , @NamedQuery(name = "PsLangShop.findByIdLang", query = "SELECT p FROM PsLangShop p WHERE p.psLangShopPK.idLang = :idLang")
    , @NamedQuery(name = "PsLangShop.findByIdShop", query = "SELECT p FROM PsLangShop p WHERE p.psLangShopPK.idShop = :idShop")})
public class PsLangShop implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsLangShopPK psLangShopPK;

    public PsLangShop() {
    }

    public PsLangShop(PsLangShopPK psLangShopPK) {
        this.psLangShopPK = psLangShopPK;
    }

    public PsLangShop(int idLang, int idShop) {
        this.psLangShopPK = new PsLangShopPK(idLang, idShop);
    }

    public PsLangShopPK getPsLangShopPK() {
        return psLangShopPK;
    }

    public void setPsLangShopPK(PsLangShopPK psLangShopPK) {
        this.psLangShopPK = psLangShopPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psLangShopPK != null ? psLangShopPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsLangShop)) {
            return false;
        }
        PsLangShop other = (PsLangShop) object;
        if ((this.psLangShopPK == null && other.psLangShopPK != null) || (this.psLangShopPK != null && !this.psLangShopPK.equals(other.psLangShopPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsLangShop[ psLangShopPK=" + psLangShopPK + " ]";
    }
    
}
