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
 * @author leo
 */
@Embeddable
public class PsImageShopPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_image")
    private int idImage;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;

    public PsImageShopPK() {
    }

    public PsImageShopPK(int idImage, int idShop) {
        this.idImage = idImage;
        this.idShop = idShop;
    }

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idImage;
        hash += (int) idShop;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsImageShopPK)) {
            return false;
        }
        PsImageShopPK other = (PsImageShopPK) object;
        if (this.idImage != other.idImage) {
            return false;
        }
        if (this.idShop != other.idShop) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsImageShopPK[ idImage=" + idImage + ", idShop=" + idShop + " ]";
    }
    
}
