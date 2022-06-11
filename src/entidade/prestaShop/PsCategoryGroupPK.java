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
public class PsCategoryGroupPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_category")
    private int idCategory;
    @Basic(optional = false)
    @Column(name = "id_group")
    private int idGroup;

    public PsCategoryGroupPK() {
    }

    public PsCategoryGroupPK(int idCategory, int idGroup) {
        this.idCategory = idCategory;
        this.idGroup = idGroup;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public int getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCategory;
        hash += (int) idGroup;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCategoryGroupPK)) {
            return false;
        }
        PsCategoryGroupPK other = (PsCategoryGroupPK) object;
        if (this.idCategory != other.idCategory) {
            return false;
        }
        if (this.idGroup != other.idGroup) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCategoryGroupPK[ idCategory=" + idCategory + ", idGroup=" + idGroup + " ]";
    }
    
}
