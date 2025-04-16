/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade.prestaShop;

import java.io.Serializable;
import javax.persistence.Column;
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
@Table(name = "ps_product_attribute_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsProductAttributeLang.findAll", query = "SELECT p FROM PsProductAttributeLang p")})
public class PsProductAttributeLang implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsProductAttributeLangPK psProductAttributeLangPK;
    @Column(name = "available_now")
    private String availableNow;
    @Column(name = "available_later")
    private String availableLater;

    public PsProductAttributeLang() {
    }

    public PsProductAttributeLang(PsProductAttributeLangPK psProductAttributeLangPK) {
        this.psProductAttributeLangPK = psProductAttributeLangPK;
    }

    public PsProductAttributeLang(int idProductAttribute, int idLang) {
        this.psProductAttributeLangPK = new PsProductAttributeLangPK(idProductAttribute, idLang);
    }

    public PsProductAttributeLangPK getPsProductAttributeLangPK() {
        return psProductAttributeLangPK;
    }

    public void setPsProductAttributeLangPK(PsProductAttributeLangPK psProductAttributeLangPK) {
        this.psProductAttributeLangPK = psProductAttributeLangPK;
    }

    public String getAvailableNow() {
        return availableNow;
    }

    public void setAvailableNow(String availableNow) {
        this.availableNow = availableNow;
    }

    public String getAvailableLater() {
        return availableLater;
    }

    public void setAvailableLater(String availableLater) {
        this.availableLater = availableLater;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psProductAttributeLangPK != null ? psProductAttributeLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsProductAttributeLang)) {
            return false;
        }
        PsProductAttributeLang other = (PsProductAttributeLang) object;
        if ((this.psProductAttributeLangPK == null && other.psProductAttributeLangPK != null) || (this.psProductAttributeLangPK != null && !this.psProductAttributeLangPK.equals(other.psProductAttributeLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsProductAttributeLang[ psProductAttributeLangPK=" + psProductAttributeLangPK + " ]";
    }
    
}
