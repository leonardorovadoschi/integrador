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
 * @author leo
 */
@Entity
@Table(name = "ps_specific_price_priority")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsSpecificPricePriority.findAll", query = "SELECT p FROM PsSpecificPricePriority p")
    , @NamedQuery(name = "PsSpecificPricePriority.findByIdSpecificPricePriority", query = "SELECT p FROM PsSpecificPricePriority p WHERE p.psSpecificPricePriorityPK.idSpecificPricePriority = :idSpecificPricePriority")
    , @NamedQuery(name = "PsSpecificPricePriority.findByIdProduct", query = "SELECT p FROM PsSpecificPricePriority p WHERE p.psSpecificPricePriorityPK.idProduct = :idProduct")
    , @NamedQuery(name = "PsSpecificPricePriority.findByPriority", query = "SELECT p FROM PsSpecificPricePriority p WHERE p.priority = :priority")})
public class PsSpecificPricePriority implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsSpecificPricePriorityPK psSpecificPricePriorityPK;
    @Basic(optional = false)
    @Column(name = "priority")
    private String priority;

    public PsSpecificPricePriority() {
    }

    public PsSpecificPricePriority(PsSpecificPricePriorityPK psSpecificPricePriorityPK) {
        this.psSpecificPricePriorityPK = psSpecificPricePriorityPK;
    }

    public PsSpecificPricePriority(PsSpecificPricePriorityPK psSpecificPricePriorityPK, String priority) {
        this.psSpecificPricePriorityPK = psSpecificPricePriorityPK;
        this.priority = priority;
    }

    public PsSpecificPricePriority(int idSpecificPricePriority, int idProduct) {
        this.psSpecificPricePriorityPK = new PsSpecificPricePriorityPK(idSpecificPricePriority, idProduct);
    }

    public PsSpecificPricePriorityPK getPsSpecificPricePriorityPK() {
        return psSpecificPricePriorityPK;
    }

    public void setPsSpecificPricePriorityPK(PsSpecificPricePriorityPK psSpecificPricePriorityPK) {
        this.psSpecificPricePriorityPK = psSpecificPricePriorityPK;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psSpecificPricePriorityPK != null ? psSpecificPricePriorityPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsSpecificPricePriority)) {
            return false;
        }
        PsSpecificPricePriority other = (PsSpecificPricePriority) object;
        if ((this.psSpecificPricePriorityPK == null && other.psSpecificPricePriorityPK != null) || (this.psSpecificPricePriorityPK != null && !this.psSpecificPricePriorityPK.equals(other.psSpecificPricePriorityPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsSpecificPricePriority[ psSpecificPricePriorityPK=" + psSpecificPricePriorityPK + " ]";
    }
    
}
