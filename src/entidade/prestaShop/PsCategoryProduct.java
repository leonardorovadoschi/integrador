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
@Table(name = "ps_category_product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsCategoryProduct.findAll", query = "SELECT p FROM PsCategoryProduct p")
    , @NamedQuery(name = "PsCategoryProduct.findByIdCategory", query = "SELECT p FROM PsCategoryProduct p WHERE p.psCategoryProductPK.idCategory = :idCategory")
    , @NamedQuery(name = "PsCategoryProduct.findByIdProduct", query = "SELECT p FROM PsCategoryProduct p WHERE p.psCategoryProductPK.idProduct = :idProduct")
    , @NamedQuery(name = "PsCategoryProduct.findByPosition", query = "SELECT p FROM PsCategoryProduct p WHERE p.position = :position")})
public class PsCategoryProduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsCategoryProductPK psCategoryProductPK;
    @Basic(optional = false)
    @Column(name = "position")
    private int position;

    public PsCategoryProduct() {
    }

    public PsCategoryProduct(PsCategoryProductPK psCategoryProductPK) {
        this.psCategoryProductPK = psCategoryProductPK;
    }

    public PsCategoryProduct(PsCategoryProductPK psCategoryProductPK, int position) {
        this.psCategoryProductPK = psCategoryProductPK;
        this.position = position;
    }

    public PsCategoryProduct(int idCategory, int idProduct) {
        this.psCategoryProductPK = new PsCategoryProductPK(idCategory, idProduct);
    }

    public PsCategoryProductPK getPsCategoryProductPK() {
        return psCategoryProductPK;
    }

    public void setPsCategoryProductPK(PsCategoryProductPK psCategoryProductPK) {
        this.psCategoryProductPK = psCategoryProductPK;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psCategoryProductPK != null ? psCategoryProductPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCategoryProduct)) {
            return false;
        }
        PsCategoryProduct other = (PsCategoryProduct) object;
        if ((this.psCategoryProductPK == null && other.psCategoryProductPK != null) || (this.psCategoryProductPK != null && !this.psCategoryProductPK.equals(other.psCategoryProductPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCategoryProduct[ psCategoryProductPK=" + psCategoryProductPK + " ]";
    }
    
}
