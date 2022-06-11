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
public class PsTagCountPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_group")
    private int idGroup;
    @Basic(optional = false)
    @Column(name = "id_tag")
    private int idTag;

    public PsTagCountPK() {
    }

    public PsTagCountPK(int idGroup, int idTag) {
        this.idGroup = idGroup;
        this.idTag = idTag;
    }

    public int getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
    }

    public int getIdTag() {
        return idTag;
    }

    public void setIdTag(int idTag) {
        this.idTag = idTag;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idGroup;
        hash += (int) idTag;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsTagCountPK)) {
            return false;
        }
        PsTagCountPK other = (PsTagCountPK) object;
        if (this.idGroup != other.idGroup) {
            return false;
        }
        if (this.idTag != other.idTag) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsTagCountPK[ idGroup=" + idGroup + ", idTag=" + idTag + " ]";
    }
    
}
