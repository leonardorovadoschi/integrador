/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.prestaShop;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author leo
 */
public class PsAccessory{
     private int idProduct_1;
     private int idProduct_2;

    public int getIdProduct_1() {
        return idProduct_1;
    }

    public void setIdProduct_1(int idProduct_1) {
        this.idProduct_1 = idProduct_1;
    }

    public int getIdProduct_2() {
        return idProduct_2;
    }

    public void setIdProduct_2(int idProduct_2) {
        this.idProduct_2 = idProduct_2;
    }
     
     
}
        

/**
@Entity
@Table(name = "ps_accessory")
public class PsAccessory implements Serializable {  
    private static final long serialVersionUID = 1L;
  
    @EmbeddedId
    protected PsAccessoryPK psAccessoryPK;
    
    public PsAccessory() {
    }

    public PsAccessory(PsAccessoryPK psAccessoryPK) {
        this.psAccessoryPK = psAccessoryPK;
    }

    public PsAccessory(int idProfile, int idAuthorizationRole) {
        this.psAccessoryPK = new PsAccessoryPK(idProfile, idAuthorizationRole);
    }

    public PsAccessoryPK getPsAccessoryPK() {
        return psAccessoryPK;
    }

    public void setPsAccessoryPK(PsAccessoryPK psAccessoryPK) {
        this.psAccessoryPK = psAccessoryPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psAccessoryPK != null ? psAccessoryPK.hashCode() : 0);
        return hash;
    }

    @Override

        public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAccessory)) {
            return false;
        }
        PsAccessory other = (PsAccessory) object;
        if ((this.psAccessoryPK == null && other.psAccessoryPK != null) || (this.psAccessoryPK != null && !this.psAccessoryPK.equals(other.psAccessoryPK))) {
            return false;
        }
        return true;
    }
    
     @Override
    public String toString() {
        return "entidade.prestaShop.PsAccessory[ psAccessoryPK=" + psAccessoryPK + " ]";
    }
    
} */
