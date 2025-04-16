/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade.prestaShop;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo-note
 */
@Entity
@Table(name = "ps_prestafraud_orders")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsPrestafraudOrders.findAll", query = "SELECT p FROM PsPrestafraudOrders p")})
public class PsPrestafraudOrders implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_order")
    private Integer idOrder;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "scoring")
    private BigDecimal scoring;
    @Column(name = "comment")
    private String comment;

    public PsPrestafraudOrders() {
    }

    public PsPrestafraudOrders(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public BigDecimal getScoring() {
        return scoring;
    }

    public void setScoring(BigDecimal scoring) {
        this.scoring = scoring;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrder != null ? idOrder.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsPrestafraudOrders)) {
            return false;
        }
        PsPrestafraudOrders other = (PsPrestafraudOrders) object;
        if ((this.idOrder == null && other.idOrder != null) || (this.idOrder != null && !this.idOrder.equals(other.idOrder))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsPrestafraudOrders[ idOrder=" + idOrder + " ]";
    }
    
}
