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
public class PsEventbusIncrementalSyncPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @Column(name = "id_object")
    private String idObject;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;
    @Basic(optional = false)
    @Column(name = "lang_iso")
    private String langIso;

    public PsEventbusIncrementalSyncPK() {
    }

    public PsEventbusIncrementalSyncPK(String type, String idObject, int idShop, String langIso) {
        this.type = type;
        this.idObject = idObject;
        this.idShop = idShop;
        this.langIso = langIso;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIdObject() {
        return idObject;
    }

    public void setIdObject(String idObject) {
        this.idObject = idObject;
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
        hash += (idObject != null ? idObject.hashCode() : 0);
        hash += (int) idShop;
        hash += (langIso != null ? langIso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsEventbusIncrementalSyncPK)) {
            return false;
        }
        PsEventbusIncrementalSyncPK other = (PsEventbusIncrementalSyncPK) object;
        if ((this.type == null && other.type != null) || (this.type != null && !this.type.equals(other.type))) {
            return false;
        }
        if ((this.idObject == null && other.idObject != null) || (this.idObject != null && !this.idObject.equals(other.idObject))) {
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
        return "entidade.prestaShop.PsEventbusIncrementalSyncPK[ type=" + type + ", idObject=" + idObject + ", idShop=" + idShop + ", langIso=" + langIso + " ]";
    }
    
}
