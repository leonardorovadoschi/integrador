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
@Table(name = "ps_category_group")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsCategoryGroup.findAll", query = "SELECT p FROM PsCategoryGroup p")
    , @NamedQuery(name = "PsCategoryGroup.findByIdCategory", query = "SELECT p FROM PsCategoryGroup p WHERE p.psCategoryGroupPK.idCategory = :idCategory")
    , @NamedQuery(name = "PsCategoryGroup.findByIdGroup", query = "SELECT p FROM PsCategoryGroup p WHERE p.psCategoryGroupPK.idGroup = :idGroup")})
public class PsCategoryGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsCategoryGroupPK psCategoryGroupPK;

    public PsCategoryGroup() {
    }

    public PsCategoryGroup(PsCategoryGroupPK psCategoryGroupPK) {
        this.psCategoryGroupPK = psCategoryGroupPK;
    }

    public PsCategoryGroup(int idCategory, int idGroup) {
        this.psCategoryGroupPK = new PsCategoryGroupPK(idCategory, idGroup);
    }

    public PsCategoryGroupPK getPsCategoryGroupPK() {
        return psCategoryGroupPK;
    }

    public void setPsCategoryGroupPK(PsCategoryGroupPK psCategoryGroupPK) {
        this.psCategoryGroupPK = psCategoryGroupPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psCategoryGroupPK != null ? psCategoryGroupPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCategoryGroup)) {
            return false;
        }
        PsCategoryGroup other = (PsCategoryGroup) object;
        if ((this.psCategoryGroupPK == null && other.psCategoryGroupPK != null) || (this.psCategoryGroupPK != null && !this.psCategoryGroupPK.equals(other.psCategoryGroupPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCategoryGroup[ psCategoryGroupPK=" + psCategoryGroupPK + " ]";
    }
    
}
