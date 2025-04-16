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
@Table(name = "ps_prestafraud_payment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsPrestafraudPayment.findAll", query = "SELECT p FROM PsPrestafraudPayment p")})
public class PsPrestafraudPayment implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsPrestafraudPaymentPK psPrestafraudPaymentPK;

    public PsPrestafraudPayment() {
    }

    public PsPrestafraudPayment(PsPrestafraudPaymentPK psPrestafraudPaymentPK) {
        this.psPrestafraudPaymentPK = psPrestafraudPaymentPK;
    }

    public PsPrestafraudPayment(int idModule, int idPrestafraudPaymentType) {
        this.psPrestafraudPaymentPK = new PsPrestafraudPaymentPK(idModule, idPrestafraudPaymentType);
    }

    public PsPrestafraudPaymentPK getPsPrestafraudPaymentPK() {
        return psPrestafraudPaymentPK;
    }

    public void setPsPrestafraudPaymentPK(PsPrestafraudPaymentPK psPrestafraudPaymentPK) {
        this.psPrestafraudPaymentPK = psPrestafraudPaymentPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psPrestafraudPaymentPK != null ? psPrestafraudPaymentPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsPrestafraudPayment)) {
            return false;
        }
        PsPrestafraudPayment other = (PsPrestafraudPayment) object;
        if ((this.psPrestafraudPaymentPK == null && other.psPrestafraudPaymentPK != null) || (this.psPrestafraudPaymentPK != null && !this.psPrestafraudPaymentPK.equals(other.psPrestafraudPaymentPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsPrestafraudPayment[ psPrestafraudPaymentPK=" + psPrestafraudPaymentPK + " ]";
    }
    
}
