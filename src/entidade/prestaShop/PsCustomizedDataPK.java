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
public class PsCustomizedDataPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_customization")
    private int idCustomization;
    @Basic(optional = false)
    @Column(name = "type")
    private boolean type;
    @Basic(optional = false)
    @Column(name = "index")
    private int index;

    public PsCustomizedDataPK() {
    }

    public PsCustomizedDataPK(int idCustomization, boolean type, int index) {
        this.idCustomization = idCustomization;
        this.type = type;
        this.index = index;
    }

    public int getIdCustomization() {
        return idCustomization;
    }

    public void setIdCustomization(int idCustomization) {
        this.idCustomization = idCustomization;
    }

    public boolean getType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCustomization;
        hash += (type ? 1 : 0);
        hash += (int) index;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCustomizedDataPK)) {
            return false;
        }
        PsCustomizedDataPK other = (PsCustomizedDataPK) object;
        if (this.idCustomization != other.idCustomization) {
            return false;
        }
        if (this.type != other.type) {
            return false;
        }
        if (this.index != other.index) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCustomizedDataPK[ idCustomization=" + idCustomization + ", type=" + type + ", index=" + index + " ]";
    }
    
}
