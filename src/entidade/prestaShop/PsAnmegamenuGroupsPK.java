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
 * @author leo-note
 */
@Embeddable
public class PsAnmegamenuGroupsPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_group")
    private int idGroup;
    @Basic(optional = false)
    @Column(name = "id_anmenu")
    private int idAnmenu;

    public PsAnmegamenuGroupsPK() {
    }

    public PsAnmegamenuGroupsPK(int idGroup, int idAnmenu) {
        this.idGroup = idGroup;
        this.idAnmenu = idAnmenu;
    }

    public int getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
    }

    public int getIdAnmenu() {
        return idAnmenu;
    }

    public void setIdAnmenu(int idAnmenu) {
        this.idAnmenu = idAnmenu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idGroup;
        hash += (int) idAnmenu;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnmegamenuGroupsPK)) {
            return false;
        }
        PsAnmegamenuGroupsPK other = (PsAnmegamenuGroupsPK) object;
        if (this.idGroup != other.idGroup) {
            return false;
        }
        if (this.idAnmenu != other.idAnmenu) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnmegamenuGroupsPK[ idGroup=" + idGroup + ", idAnmenu=" + idAnmenu + " ]";
    }
    
}
