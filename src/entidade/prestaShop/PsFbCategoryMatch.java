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
@Table(name = "ps_fb_category_match")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsFbCategoryMatch.findAll", query = "SELECT p FROM PsFbCategoryMatch p")})
public class PsFbCategoryMatch implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsFbCategoryMatchPK psFbCategoryMatchPK;
    @Basic(optional = false)
    @Column(name = "google_category_id")
    private int googleCategoryId;
    @Basic(optional = false)
    @Column(name = "google_category_name")
    private String googleCategoryName;
    @Basic(optional = false)
    @Column(name = "google_category_parent_id")
    private int googleCategoryParentId;
    @Basic(optional = false)
    @Column(name = "google_category_parent_name")
    private String googleCategoryParentName;
    @Column(name = "is_parent_category")
    private Boolean isParentCategory;

    public PsFbCategoryMatch() {
    }

    public PsFbCategoryMatch(PsFbCategoryMatchPK psFbCategoryMatchPK) {
        this.psFbCategoryMatchPK = psFbCategoryMatchPK;
    }

    public PsFbCategoryMatch(PsFbCategoryMatchPK psFbCategoryMatchPK, int googleCategoryId, String googleCategoryName, int googleCategoryParentId, String googleCategoryParentName) {
        this.psFbCategoryMatchPK = psFbCategoryMatchPK;
        this.googleCategoryId = googleCategoryId;
        this.googleCategoryName = googleCategoryName;
        this.googleCategoryParentId = googleCategoryParentId;
        this.googleCategoryParentName = googleCategoryParentName;
    }

    public PsFbCategoryMatch(int idCategory, int idShop) {
        this.psFbCategoryMatchPK = new PsFbCategoryMatchPK(idCategory, idShop);
    }

    public PsFbCategoryMatchPK getPsFbCategoryMatchPK() {
        return psFbCategoryMatchPK;
    }

    public void setPsFbCategoryMatchPK(PsFbCategoryMatchPK psFbCategoryMatchPK) {
        this.psFbCategoryMatchPK = psFbCategoryMatchPK;
    }

    public int getGoogleCategoryId() {
        return googleCategoryId;
    }

    public void setGoogleCategoryId(int googleCategoryId) {
        this.googleCategoryId = googleCategoryId;
    }

    public String getGoogleCategoryName() {
        return googleCategoryName;
    }

    public void setGoogleCategoryName(String googleCategoryName) {
        this.googleCategoryName = googleCategoryName;
    }

    public int getGoogleCategoryParentId() {
        return googleCategoryParentId;
    }

    public void setGoogleCategoryParentId(int googleCategoryParentId) {
        this.googleCategoryParentId = googleCategoryParentId;
    }

    public String getGoogleCategoryParentName() {
        return googleCategoryParentName;
    }

    public void setGoogleCategoryParentName(String googleCategoryParentName) {
        this.googleCategoryParentName = googleCategoryParentName;
    }

    public Boolean getIsParentCategory() {
        return isParentCategory;
    }

    public void setIsParentCategory(Boolean isParentCategory) {
        this.isParentCategory = isParentCategory;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psFbCategoryMatchPK != null ? psFbCategoryMatchPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsFbCategoryMatch)) {
            return false;
        }
        PsFbCategoryMatch other = (PsFbCategoryMatch) object;
        if ((this.psFbCategoryMatchPK == null && other.psFbCategoryMatchPK != null) || (this.psFbCategoryMatchPK != null && !this.psFbCategoryMatchPK.equals(other.psFbCategoryMatchPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsFbCategoryMatch[ psFbCategoryMatchPK=" + psFbCategoryMatchPK + " ]";
    }
    
}
