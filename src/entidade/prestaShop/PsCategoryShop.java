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
@Table(name = "ps_category_shop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsCategoryShop.findAll", query = "SELECT p FROM PsCategoryShop p")
    , @NamedQuery(name = "PsCategoryShop.findByIdCategory", query = "SELECT p FROM PsCategoryShop p WHERE p.psCategoryShopPK.idCategory = :idCategory")
    , @NamedQuery(name = "PsCategoryShop.findByIdShop", query = "SELECT p FROM PsCategoryShop p WHERE p.psCategoryShopPK.idShop = :idShop")
    , @NamedQuery(name = "PsCategoryShop.findByPosition", query = "SELECT p FROM PsCategoryShop p WHERE p.position = :position")})
public class PsCategoryShop implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsCategoryShopPK psCategoryShopPK;
    @Basic(optional = false)
    @Column(name = "position")
    private int position;

    public PsCategoryShop() {
    }

    public PsCategoryShop(PsCategoryShopPK psCategoryShopPK) {
        this.psCategoryShopPK = psCategoryShopPK;
    }

    public PsCategoryShop(PsCategoryShopPK psCategoryShopPK, int position) {
        this.psCategoryShopPK = psCategoryShopPK;
        this.position = position;
    }

    public PsCategoryShop(int idCategory, int idShop) {
        this.psCategoryShopPK = new PsCategoryShopPK(idCategory, idShop);
    }

    public PsCategoryShopPK getPsCategoryShopPK() {
        return psCategoryShopPK;
    }

    public void setPsCategoryShopPK(PsCategoryShopPK psCategoryShopPK) {
        this.psCategoryShopPK = psCategoryShopPK;
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
        hash += (psCategoryShopPK != null ? psCategoryShopPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCategoryShop)) {
            return false;
        }
        PsCategoryShop other = (PsCategoryShop) object;
        if ((this.psCategoryShopPK == null && other.psCategoryShopPK != null) || (this.psCategoryShopPK != null && !this.psCategoryShopPK.equals(other.psCategoryShopPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCategoryShop[ psCategoryShopPK=" + psCategoryShopPK + " ]";
    }
    
}
