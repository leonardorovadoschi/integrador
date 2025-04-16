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
 * @author leo-note
 */
@Entity
@Table(name = "ps_an_homeproducts_blocks_products")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnHomeproductsBlocksProducts.findAll", query = "SELECT p FROM PsAnHomeproductsBlocksProducts p")})
public class PsAnHomeproductsBlocksProducts implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsAnHomeproductsBlocksProductsPK psAnHomeproductsBlocksProductsPK;
    @Basic(optional = false)
    @Column(name = "position")
    private int position;

    public PsAnHomeproductsBlocksProducts() {
    }

    public PsAnHomeproductsBlocksProducts(PsAnHomeproductsBlocksProductsPK psAnHomeproductsBlocksProductsPK) {
        this.psAnHomeproductsBlocksProductsPK = psAnHomeproductsBlocksProductsPK;
    }

    public PsAnHomeproductsBlocksProducts(PsAnHomeproductsBlocksProductsPK psAnHomeproductsBlocksProductsPK, int position) {
        this.psAnHomeproductsBlocksProductsPK = psAnHomeproductsBlocksProductsPK;
        this.position = position;
    }

    public PsAnHomeproductsBlocksProducts(int idBlock, int idProduct) {
        this.psAnHomeproductsBlocksProductsPK = new PsAnHomeproductsBlocksProductsPK(idBlock, idProduct);
    }

    public PsAnHomeproductsBlocksProductsPK getPsAnHomeproductsBlocksProductsPK() {
        return psAnHomeproductsBlocksProductsPK;
    }

    public void setPsAnHomeproductsBlocksProductsPK(PsAnHomeproductsBlocksProductsPK psAnHomeproductsBlocksProductsPK) {
        this.psAnHomeproductsBlocksProductsPK = psAnHomeproductsBlocksProductsPK;
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
        hash += (psAnHomeproductsBlocksProductsPK != null ? psAnHomeproductsBlocksProductsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnHomeproductsBlocksProducts)) {
            return false;
        }
        PsAnHomeproductsBlocksProducts other = (PsAnHomeproductsBlocksProducts) object;
        if ((this.psAnHomeproductsBlocksProductsPK == null && other.psAnHomeproductsBlocksProductsPK != null) || (this.psAnHomeproductsBlocksProductsPK != null && !this.psAnHomeproductsBlocksProductsPK.equals(other.psAnHomeproductsBlocksProductsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnHomeproductsBlocksProducts[ psAnHomeproductsBlocksProductsPK=" + psAnHomeproductsBlocksProductsPK + " ]";
    }
    
}
