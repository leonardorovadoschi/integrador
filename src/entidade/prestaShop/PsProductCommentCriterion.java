/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade.prestaShop;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "ps_product_comment_criterion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsProductCommentCriterion.findAll", query = "SELECT p FROM PsProductCommentCriterion p")})
public class PsProductCommentCriterion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_product_comment_criterion")
    private Integer idProductCommentCriterion;
    @Basic(optional = false)
    @Column(name = "id_product_comment_criterion_type")
    private boolean idProductCommentCriterionType;
    @Basic(optional = false)
    @Column(name = "active")
    private boolean active;

    public PsProductCommentCriterion() {
    }

    public PsProductCommentCriterion(Integer idProductCommentCriterion) {
        this.idProductCommentCriterion = idProductCommentCriterion;
    }

    public PsProductCommentCriterion(Integer idProductCommentCriterion, boolean idProductCommentCriterionType, boolean active) {
        this.idProductCommentCriterion = idProductCommentCriterion;
        this.idProductCommentCriterionType = idProductCommentCriterionType;
        this.active = active;
    }

    public Integer getIdProductCommentCriterion() {
        return idProductCommentCriterion;
    }

    public void setIdProductCommentCriterion(Integer idProductCommentCriterion) {
        this.idProductCommentCriterion = idProductCommentCriterion;
    }

    public boolean getIdProductCommentCriterionType() {
        return idProductCommentCriterionType;
    }

    public void setIdProductCommentCriterionType(boolean idProductCommentCriterionType) {
        this.idProductCommentCriterionType = idProductCommentCriterionType;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProductCommentCriterion != null ? idProductCommentCriterion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsProductCommentCriterion)) {
            return false;
        }
        PsProductCommentCriterion other = (PsProductCommentCriterion) object;
        if ((this.idProductCommentCriterion == null && other.idProductCommentCriterion != null) || (this.idProductCommentCriterion != null && !this.idProductCommentCriterion.equals(other.idProductCommentCriterion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsProductCommentCriterion[ idProductCommentCriterion=" + idProductCommentCriterion + " ]";
    }
    
}
