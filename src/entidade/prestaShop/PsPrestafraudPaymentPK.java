/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade.prestaShop;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author leo-note
 */
@Embeddable
public class PsPrestafraudPaymentPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_module")
    private int idModule;
    @Basic(optional = false)
    @Column(name = "id_prestafraud_payment_type")
    private int idPrestafraudPaymentType;

    public PsPrestafraudPaymentPK() {
    }

    public PsPrestafraudPaymentPK(int idModule, int idPrestafraudPaymentType) {
        this.idModule = idModule;
        this.idPrestafraudPaymentType = idPrestafraudPaymentType;
    }

    public int getIdModule() {
        return idModule;
    }

    public void setIdModule(int idModule) {
        this.idModule = idModule;
    }

    public int getIdPrestafraudPaymentType() {
        return idPrestafraudPaymentType;
    }

    public void setIdPrestafraudPaymentType(int idPrestafraudPaymentType) {
        this.idPrestafraudPaymentType = idPrestafraudPaymentType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idModule;
        hash += (int) idPrestafraudPaymentType;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsPrestafraudPaymentPK)) {
            return false;
        }
        PsPrestafraudPaymentPK other = (PsPrestafraudPaymentPK) object;
        if (this.idModule != other.idModule) {
            return false;
        }
        if (this.idPrestafraudPaymentType != other.idPrestafraudPaymentType) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsPrestafraudPaymentPK[ idModule=" + idModule + ", idPrestafraudPaymentType=" + idPrestafraudPaymentType + " ]";
    }
    
}
