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
 * @author leo
 */
@Entity
@Table(name = "ps_carrier_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsCarrierLang.findAll", query = "SELECT p FROM PsCarrierLang p")
    , @NamedQuery(name = "PsCarrierLang.findByIdCarrier", query = "SELECT p FROM PsCarrierLang p WHERE p.psCarrierLangPK.idCarrier = :idCarrier")
    , @NamedQuery(name = "PsCarrierLang.findByIdShop", query = "SELECT p FROM PsCarrierLang p WHERE p.psCarrierLangPK.idShop = :idShop")
    , @NamedQuery(name = "PsCarrierLang.findByIdLang", query = "SELECT p FROM PsCarrierLang p WHERE p.psCarrierLangPK.idLang = :idLang")
    , @NamedQuery(name = "PsCarrierLang.findByDelay", query = "SELECT p FROM PsCarrierLang p WHERE p.delay = :delay")})
public class PsCarrierLang implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsCarrierLangPK psCarrierLangPK;
    @Column(name = "delay")
    private String delay;

    public PsCarrierLang() {
    }

    public PsCarrierLang(PsCarrierLangPK psCarrierLangPK) {
        this.psCarrierLangPK = psCarrierLangPK;
    }

    public PsCarrierLang(int idCarrier, int idShop, int idLang) {
        this.psCarrierLangPK = new PsCarrierLangPK(idCarrier, idShop, idLang);
    }

    public PsCarrierLangPK getPsCarrierLangPK() {
        return psCarrierLangPK;
    }

    public void setPsCarrierLangPK(PsCarrierLangPK psCarrierLangPK) {
        this.psCarrierLangPK = psCarrierLangPK;
    }

    public String getDelay() {
        return delay;
    }

    public void setDelay(String delay) {
        this.delay = delay;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psCarrierLangPK != null ? psCarrierLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCarrierLang)) {
            return false;
        }
        PsCarrierLang other = (PsCarrierLang) object;
        if ((this.psCarrierLangPK == null && other.psCarrierLangPK != null) || (this.psCarrierLangPK != null && !this.psCarrierLangPK.equals(other.psCarrierLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCarrierLang[ psCarrierLangPK=" + psCarrierLangPK + " ]";
    }
    
}
