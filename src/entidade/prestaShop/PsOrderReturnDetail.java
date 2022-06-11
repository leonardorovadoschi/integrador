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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ps_order_return_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsOrderReturnDetail.findAll", query = "SELECT p FROM PsOrderReturnDetail p")
    , @NamedQuery(name = "PsOrderReturnDetail.findByIdOrderReturn", query = "SELECT p FROM PsOrderReturnDetail p WHERE p.psOrderReturnDetailPK.idOrderReturn = :idOrderReturn")
    , @NamedQuery(name = "PsOrderReturnDetail.findByIdOrderDetail", query = "SELECT p FROM PsOrderReturnDetail p WHERE p.psOrderReturnDetailPK.idOrderDetail = :idOrderDetail")
    , @NamedQuery(name = "PsOrderReturnDetail.findByIdCustomization", query = "SELECT p FROM PsOrderReturnDetail p WHERE p.psOrderReturnDetailPK.idCustomization = :idCustomization")
    , @NamedQuery(name = "PsOrderReturnDetail.findByProductQuantity", query = "SELECT p FROM PsOrderReturnDetail p WHERE p.productQuantity = :productQuantity")})
public class PsOrderReturnDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsOrderReturnDetailPK psOrderReturnDetailPK;
    @Basic(optional = false)
    @Column(name = "product_quantity")
    private int productQuantity;

    public PsOrderReturnDetail() {
    }

    public PsOrderReturnDetail(PsOrderReturnDetailPK psOrderReturnDetailPK) {
        this.psOrderReturnDetailPK = psOrderReturnDetailPK;
    }

    public PsOrderReturnDetail(PsOrderReturnDetailPK psOrderReturnDetailPK, int productQuantity) {
        this.psOrderReturnDetailPK = psOrderReturnDetailPK;
        this.productQuantity = productQuantity;
    }

    public PsOrderReturnDetail(int idOrderReturn, int idOrderDetail, int idCustomization) {
        this.psOrderReturnDetailPK = new PsOrderReturnDetailPK(idOrderReturn, idOrderDetail, idCustomization);
    }

    public PsOrderReturnDetailPK getPsOrderReturnDetailPK() {
        return psOrderReturnDetailPK;
    }

    public void setPsOrderReturnDetailPK(PsOrderReturnDetailPK psOrderReturnDetailPK) {
        this.psOrderReturnDetailPK = psOrderReturnDetailPK;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psOrderReturnDetailPK != null ? psOrderReturnDetailPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsOrderReturnDetail)) {
            return false;
        }
        PsOrderReturnDetail other = (PsOrderReturnDetail) object;
        if ((this.psOrderReturnDetailPK == null && other.psOrderReturnDetailPK != null) || (this.psOrderReturnDetailPK != null && !this.psOrderReturnDetailPK.equals(other.psOrderReturnDetailPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsOrderReturnDetail[ psOrderReturnDetailPK=" + psOrderReturnDetailPK + " ]";
    }
    
}
