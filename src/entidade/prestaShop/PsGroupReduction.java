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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ps_group_reduction")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsGroupReduction.findAll", query = "SELECT p FROM PsGroupReduction p")
    , @NamedQuery(name = "PsGroupReduction.findByIdGroupReduction", query = "SELECT p FROM PsGroupReduction p WHERE p.idGroupReduction = :idGroupReduction")
    , @NamedQuery(name = "PsGroupReduction.findByIdGroup", query = "SELECT p FROM PsGroupReduction p WHERE p.idGroup = :idGroup")
    , @NamedQuery(name = "PsGroupReduction.findByIdCategory", query = "SELECT p FROM PsGroupReduction p WHERE p.idCategory = :idCategory")
    , @NamedQuery(name = "PsGroupReduction.findByReduction", query = "SELECT p FROM PsGroupReduction p WHERE p.reduction = :reduction")})
public class PsGroupReduction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_group_reduction")
    private Integer idGroupReduction;
    @Basic(optional = false)
    @Column(name = "id_group")
    private int idGroup;
    @Basic(optional = false)
    @Column(name = "id_category")
    private int idCategory;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "reduction")
    private BigDecimal reduction;

    public PsGroupReduction() {
    }

    public PsGroupReduction(Integer idGroupReduction) {
        this.idGroupReduction = idGroupReduction;
    }

    public PsGroupReduction(Integer idGroupReduction, int idGroup, int idCategory, BigDecimal reduction) {
        this.idGroupReduction = idGroupReduction;
        this.idGroup = idGroup;
        this.idCategory = idCategory;
        this.reduction = reduction;
    }

    public Integer getIdGroupReduction() {
        return idGroupReduction;
    }

    public void setIdGroupReduction(Integer idGroupReduction) {
        this.idGroupReduction = idGroupReduction;
    }

    public int getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public BigDecimal getReduction() {
        return reduction;
    }

    public void setReduction(BigDecimal reduction) {
        this.reduction = reduction;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGroupReduction != null ? idGroupReduction.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsGroupReduction)) {
            return false;
        }
        PsGroupReduction other = (PsGroupReduction) object;
        if ((this.idGroupReduction == null && other.idGroupReduction != null) || (this.idGroupReduction != null && !this.idGroupReduction.equals(other.idGroupReduction))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsGroupReduction[ idGroupReduction=" + idGroupReduction + " ]";
    }
    
}
