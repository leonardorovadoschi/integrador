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
@Table(name = "ps_customer_group")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsCustomerGroup.findAll", query = "SELECT p FROM PsCustomerGroup p")
    , @NamedQuery(name = "PsCustomerGroup.findByIdCustomer", query = "SELECT p FROM PsCustomerGroup p WHERE p.psCustomerGroupPK.idCustomer = :idCustomer")
    , @NamedQuery(name = "PsCustomerGroup.findByIdGroup", query = "SELECT p FROM PsCustomerGroup p WHERE p.psCustomerGroupPK.idGroup = :idGroup")})
public class PsCustomerGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsCustomerGroupPK psCustomerGroupPK;

    public PsCustomerGroup() {
    }

    public PsCustomerGroup(PsCustomerGroupPK psCustomerGroupPK) {
        this.psCustomerGroupPK = psCustomerGroupPK;
    }

    public PsCustomerGroup(int idCustomer, int idGroup) {
        this.psCustomerGroupPK = new PsCustomerGroupPK(idCustomer, idGroup);
    }

    public PsCustomerGroupPK getPsCustomerGroupPK() {
        return psCustomerGroupPK;
    }

    public void setPsCustomerGroupPK(PsCustomerGroupPK psCustomerGroupPK) {
        this.psCustomerGroupPK = psCustomerGroupPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psCustomerGroupPK != null ? psCustomerGroupPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCustomerGroup)) {
            return false;
        }
        PsCustomerGroup other = (PsCustomerGroup) object;
        if ((this.psCustomerGroupPK == null && other.psCustomerGroupPK != null) || (this.psCustomerGroupPK != null && !this.psCustomerGroupPK.equals(other.psCustomerGroupPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCustomerGroup[ psCustomerGroupPK=" + psCustomerGroupPK + " ]";
    }
    
}
