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
@Table(name = "ps_employee_shop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsEmployeeShop.findAll", query = "SELECT p FROM PsEmployeeShop p")
    , @NamedQuery(name = "PsEmployeeShop.findByIdEmployee", query = "SELECT p FROM PsEmployeeShop p WHERE p.psEmployeeShopPK.idEmployee = :idEmployee")
    , @NamedQuery(name = "PsEmployeeShop.findByIdShop", query = "SELECT p FROM PsEmployeeShop p WHERE p.psEmployeeShopPK.idShop = :idShop")})
public class PsEmployeeShop implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsEmployeeShopPK psEmployeeShopPK;

    public PsEmployeeShop() {
    }

    public PsEmployeeShop(PsEmployeeShopPK psEmployeeShopPK) {
        this.psEmployeeShopPK = psEmployeeShopPK;
    }

    public PsEmployeeShop(int idEmployee, int idShop) {
        this.psEmployeeShopPK = new PsEmployeeShopPK(idEmployee, idShop);
    }

    public PsEmployeeShopPK getPsEmployeeShopPK() {
        return psEmployeeShopPK;
    }

    public void setPsEmployeeShopPK(PsEmployeeShopPK psEmployeeShopPK) {
        this.psEmployeeShopPK = psEmployeeShopPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psEmployeeShopPK != null ? psEmployeeShopPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsEmployeeShop)) {
            return false;
        }
        PsEmployeeShop other = (PsEmployeeShop) object;
        if ((this.psEmployeeShopPK == null && other.psEmployeeShopPK != null) || (this.psEmployeeShopPK != null && !this.psEmployeeShopPK.equals(other.psEmployeeShopPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsEmployeeShop[ psEmployeeShopPK=" + psEmployeeShopPK + " ]";
    }
    
}
