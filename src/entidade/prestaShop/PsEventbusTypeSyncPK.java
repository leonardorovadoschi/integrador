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
public class PsEventbusTypeSyncPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;
    @Basic(optional = false)
    @Column(name = "lang_iso")
    private String langIso;

    public PsEventbusTypeSyncPK() {
    }

    public PsEventbusTypeSyncPK(String type, int idShop, String langIso) {
        this.type = type;
        this.idShop = idShop;
        this.langIso = langIso;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

    public String getLangIso() {
        return langIso;
    }

    public void setLangIso(String langIso) {
        this.langIso = langIso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (type != null ? type.hashCode() : 0);
        hash += (int) idShop;
        hash += (langIso != null ? langIso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsEventbusTypeSyncPK)) {
            return false;
        }
        PsEventbusTypeSyncPK other = (PsEventbusTypeSyncPK) object;
        if ((this.type == null && other.type != null) || (this.type != null && !this.type.equals(other.type))) {
            return false;
        }
        if (this.idShop != other.idShop) {
            return false;
        }
        if ((this.langIso == null && other.langIso != null) || (this.langIso != null && !this.langIso.equals(other.langIso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsEventbusTypeSyncPK[ type=" + type + ", idShop=" + idShop + ", langIso=" + langIso + " ]";
    }
    
}
