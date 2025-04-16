/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade.prestaShop;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo-note
 */
@Entity
@Table(name = "ps_pscheckout_purchase_unit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsPscheckoutPurchaseUnit.findAll", query = "SELECT p FROM PsPscheckoutPurchaseUnit p")})
public class PsPscheckoutPurchaseUnit implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsPscheckoutPurchaseUnitPK psPscheckoutPurchaseUnitPK;
    @Basic(optional = false)
    @Column(name = "checksum")
    private String checksum;
    @Lob
    @Column(name = "items")
    private String items;

    public PsPscheckoutPurchaseUnit() {
    }

    public PsPscheckoutPurchaseUnit(PsPscheckoutPurchaseUnitPK psPscheckoutPurchaseUnitPK) {
        this.psPscheckoutPurchaseUnitPK = psPscheckoutPurchaseUnitPK;
    }

    public PsPscheckoutPurchaseUnit(PsPscheckoutPurchaseUnitPK psPscheckoutPurchaseUnitPK, String checksum) {
        this.psPscheckoutPurchaseUnitPK = psPscheckoutPurchaseUnitPK;
        this.checksum = checksum;
    }

    public PsPscheckoutPurchaseUnit(String idOrder, String referenceId) {
        this.psPscheckoutPurchaseUnitPK = new PsPscheckoutPurchaseUnitPK(idOrder, referenceId);
    }

    public PsPscheckoutPurchaseUnitPK getPsPscheckoutPurchaseUnitPK() {
        return psPscheckoutPurchaseUnitPK;
    }

    public void setPsPscheckoutPurchaseUnitPK(PsPscheckoutPurchaseUnitPK psPscheckoutPurchaseUnitPK) {
        this.psPscheckoutPurchaseUnitPK = psPscheckoutPurchaseUnitPK;
    }

    public String getChecksum() {
        return checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psPscheckoutPurchaseUnitPK != null ? psPscheckoutPurchaseUnitPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsPscheckoutPurchaseUnit)) {
            return false;
        }
        PsPscheckoutPurchaseUnit other = (PsPscheckoutPurchaseUnit) object;
        if ((this.psPscheckoutPurchaseUnitPK == null && other.psPscheckoutPurchaseUnitPK != null) || (this.psPscheckoutPurchaseUnitPK != null && !this.psPscheckoutPurchaseUnitPK.equals(other.psPscheckoutPurchaseUnitPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsPscheckoutPurchaseUnit[ psPscheckoutPurchaseUnitPK=" + psPscheckoutPurchaseUnitPK + " ]";
    }
    
}
