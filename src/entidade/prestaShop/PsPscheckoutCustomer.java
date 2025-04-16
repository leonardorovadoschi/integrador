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
@Table(name = "ps_pscheckout_customer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsPscheckoutCustomer.findAll", query = "SELECT p FROM PsPscheckoutCustomer p")})
public class PsPscheckoutCustomer implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsPscheckoutCustomerPK psPscheckoutCustomerPK;

    public PsPscheckoutCustomer() {
    }

    public PsPscheckoutCustomer(PsPscheckoutCustomerPK psPscheckoutCustomerPK) {
        this.psPscheckoutCustomerPK = psPscheckoutCustomerPK;
    }

    public PsPscheckoutCustomer(int idCustomer, String paypalCustomerId) {
        this.psPscheckoutCustomerPK = new PsPscheckoutCustomerPK(idCustomer, paypalCustomerId);
    }

    public PsPscheckoutCustomerPK getPsPscheckoutCustomerPK() {
        return psPscheckoutCustomerPK;
    }

    public void setPsPscheckoutCustomerPK(PsPscheckoutCustomerPK psPscheckoutCustomerPK) {
        this.psPscheckoutCustomerPK = psPscheckoutCustomerPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psPscheckoutCustomerPK != null ? psPscheckoutCustomerPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsPscheckoutCustomer)) {
            return false;
        }
        PsPscheckoutCustomer other = (PsPscheckoutCustomer) object;
        if ((this.psPscheckoutCustomerPK == null && other.psPscheckoutCustomerPK != null) || (this.psPscheckoutCustomerPK != null && !this.psPscheckoutCustomerPK.equals(other.psPscheckoutCustomerPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsPscheckoutCustomer[ psPscheckoutCustomerPK=" + psPscheckoutCustomerPK + " ]";
    }
    
}
