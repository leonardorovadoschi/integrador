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
@Table(name = "ps_product_group_reduction_cache")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsProductGroupReductionCache.findAll", query = "SELECT p FROM PsProductGroupReductionCache p")
    , @NamedQuery(name = "PsProductGroupReductionCache.findByIdProduct", query = "SELECT p FROM PsProductGroupReductionCache p WHERE p.psProductGroupReductionCachePK.idProduct = :idProduct")
    , @NamedQuery(name = "PsProductGroupReductionCache.findByIdGroup", query = "SELECT p FROM PsProductGroupReductionCache p WHERE p.psProductGroupReductionCachePK.idGroup = :idGroup")
    , @NamedQuery(name = "PsProductGroupReductionCache.findByReduction", query = "SELECT p FROM PsProductGroupReductionCache p WHERE p.reduction = :reduction")})
public class PsProductGroupReductionCache implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsProductGroupReductionCachePK psProductGroupReductionCachePK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "reduction")
    private BigDecimal reduction;

    public PsProductGroupReductionCache() {
    }

    public PsProductGroupReductionCache(PsProductGroupReductionCachePK psProductGroupReductionCachePK) {
        this.psProductGroupReductionCachePK = psProductGroupReductionCachePK;
    }

    public PsProductGroupReductionCache(PsProductGroupReductionCachePK psProductGroupReductionCachePK, BigDecimal reduction) {
        this.psProductGroupReductionCachePK = psProductGroupReductionCachePK;
        this.reduction = reduction;
    }

    public PsProductGroupReductionCache(int idProduct, int idGroup) {
        this.psProductGroupReductionCachePK = new PsProductGroupReductionCachePK(idProduct, idGroup);
    }

    public PsProductGroupReductionCachePK getPsProductGroupReductionCachePK() {
        return psProductGroupReductionCachePK;
    }

    public void setPsProductGroupReductionCachePK(PsProductGroupReductionCachePK psProductGroupReductionCachePK) {
        this.psProductGroupReductionCachePK = psProductGroupReductionCachePK;
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
        hash += (psProductGroupReductionCachePK != null ? psProductGroupReductionCachePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsProductGroupReductionCache)) {
            return false;
        }
        PsProductGroupReductionCache other = (PsProductGroupReductionCache) object;
        if ((this.psProductGroupReductionCachePK == null && other.psProductGroupReductionCachePK != null) || (this.psProductGroupReductionCachePK != null && !this.psProductGroupReductionCachePK.equals(other.psProductGroupReductionCachePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsProductGroupReductionCache[ psProductGroupReductionCachePK=" + psProductGroupReductionCachePK + " ]";
    }
    
}
