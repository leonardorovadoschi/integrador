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
@Table(name = "ps_image_shop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsImageShop.findAll", query = "SELECT p FROM PsImageShop p")
    , @NamedQuery(name = "PsImageShop.findByIdProduct", query = "SELECT p FROM PsImageShop p WHERE p.idProduct = :idProduct")
    , @NamedQuery(name = "PsImageShop.findByIdImage", query = "SELECT p FROM PsImageShop p WHERE p.psImageShopPK.idImage = :idImage")
    , @NamedQuery(name = "PsImageShop.findByIdShop", query = "SELECT p FROM PsImageShop p WHERE p.psImageShopPK.idShop = :idShop")
    , @NamedQuery(name = "PsImageShop.findByCover", query = "SELECT p FROM PsImageShop p WHERE p.cover = :cover")})
public class PsImageShop implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsImageShopPK psImageShopPK;
    @Basic(optional = false)
    @Column(name = "id_product")
    private int idProduct;
    @Column(name = "cover")
    private Boolean cover;

    public PsImageShop() {
    }

    public PsImageShop(PsImageShopPK psImageShopPK) {
        this.psImageShopPK = psImageShopPK;
    }

    public PsImageShop(PsImageShopPK psImageShopPK, int idProduct) {
        this.psImageShopPK = psImageShopPK;
        this.idProduct = idProduct;
    }

    public PsImageShop(int idImage, int idShop) {
        this.psImageShopPK = new PsImageShopPK(idImage, idShop);
    }

    public PsImageShopPK getPsImageShopPK() {
        return psImageShopPK;
    }

    public void setPsImageShopPK(PsImageShopPK psImageShopPK) {
        this.psImageShopPK = psImageShopPK;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public Boolean getCover() {
        return cover;
    }

    public void setCover(Boolean cover) {
        this.cover = cover;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psImageShopPK != null ? psImageShopPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsImageShop)) {
            return false;
        }
        PsImageShop other = (PsImageShop) object;
        if ((this.psImageShopPK == null && other.psImageShopPK != null) || (this.psImageShopPK != null && !this.psImageShopPK.equals(other.psImageShopPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsImageShop[ psImageShopPK=" + psImageShopPK + " ]";
    }
    
}
