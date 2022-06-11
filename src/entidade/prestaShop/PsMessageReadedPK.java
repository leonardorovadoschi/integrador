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
public class PsMessageReadedPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_message")
    private int idMessage;
    @Basic(optional = false)
    @Column(name = "id_employee")
    private int idEmployee;

    public PsMessageReadedPK() {
    }

    public PsMessageReadedPK(int idMessage, int idEmployee) {
        this.idMessage = idMessage;
        this.idEmployee = idEmployee;
    }

    public int getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(int idMessage) {
        this.idMessage = idMessage;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idMessage;
        hash += (int) idEmployee;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsMessageReadedPK)) {
            return false;
        }
        PsMessageReadedPK other = (PsMessageReadedPK) object;
        if (this.idMessage != other.idMessage) {
            return false;
        }
        if (this.idEmployee != other.idEmployee) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsMessageReadedPK[ idMessage=" + idMessage + ", idEmployee=" + idEmployee + " ]";
    }
    
}
