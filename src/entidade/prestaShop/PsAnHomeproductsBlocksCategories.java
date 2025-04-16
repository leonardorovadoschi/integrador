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
@Table(name = "ps_an_homeproducts_blocks_categories")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnHomeproductsBlocksCategories.findAll", query = "SELECT p FROM PsAnHomeproductsBlocksCategories p")})
public class PsAnHomeproductsBlocksCategories implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsAnHomeproductsBlocksCategoriesPK psAnHomeproductsBlocksCategoriesPK;

    public PsAnHomeproductsBlocksCategories() {
    }

    public PsAnHomeproductsBlocksCategories(PsAnHomeproductsBlocksCategoriesPK psAnHomeproductsBlocksCategoriesPK) {
        this.psAnHomeproductsBlocksCategoriesPK = psAnHomeproductsBlocksCategoriesPK;
    }

    public PsAnHomeproductsBlocksCategories(int idBlock, int idCategory) {
        this.psAnHomeproductsBlocksCategoriesPK = new PsAnHomeproductsBlocksCategoriesPK(idBlock, idCategory);
    }

    public PsAnHomeproductsBlocksCategoriesPK getPsAnHomeproductsBlocksCategoriesPK() {
        return psAnHomeproductsBlocksCategoriesPK;
    }

    public void setPsAnHomeproductsBlocksCategoriesPK(PsAnHomeproductsBlocksCategoriesPK psAnHomeproductsBlocksCategoriesPK) {
        this.psAnHomeproductsBlocksCategoriesPK = psAnHomeproductsBlocksCategoriesPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psAnHomeproductsBlocksCategoriesPK != null ? psAnHomeproductsBlocksCategoriesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnHomeproductsBlocksCategories)) {
            return false;
        }
        PsAnHomeproductsBlocksCategories other = (PsAnHomeproductsBlocksCategories) object;
        if ((this.psAnHomeproductsBlocksCategoriesPK == null && other.psAnHomeproductsBlocksCategoriesPK != null) || (this.psAnHomeproductsBlocksCategoriesPK != null && !this.psAnHomeproductsBlocksCategoriesPK.equals(other.psAnHomeproductsBlocksCategoriesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnHomeproductsBlocksCategories[ psAnHomeproductsBlocksCategoriesPK=" + psAnHomeproductsBlocksCategoriesPK + " ]";
    }
    
}
