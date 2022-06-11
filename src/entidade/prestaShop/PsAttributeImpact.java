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
@Table(name = "ps_attribute_impact")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAttributeImpact.findAll", query = "SELECT p FROM PsAttributeImpact p")
    , @NamedQuery(name = "PsAttributeImpact.findByIdAttributeImpact", query = "SELECT p FROM PsAttributeImpact p WHERE p.idAttributeImpact = :idAttributeImpact")
    , @NamedQuery(name = "PsAttributeImpact.findByIdProduct", query = "SELECT p FROM PsAttributeImpact p WHERE p.idProduct = :idProduct")
    , @NamedQuery(name = "PsAttributeImpact.findByIdAttribute", query = "SELECT p FROM PsAttributeImpact p WHERE p.idAttribute = :idAttribute")
    , @NamedQuery(name = "PsAttributeImpact.findByWeight", query = "SELECT p FROM PsAttributeImpact p WHERE p.weight = :weight")
    , @NamedQuery(name = "PsAttributeImpact.findByPrice", query = "SELECT p FROM PsAttributeImpact p WHERE p.price = :price")})
public class PsAttributeImpact implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_attribute_impact")
    private Integer idAttributeImpact;
    @Basic(optional = false)
    @Column(name = "id_product")
    private int idProduct;
    @Basic(optional = false)
    @Column(name = "id_attribute")
    private int idAttribute;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "weight")
    private BigDecimal weight;
    @Basic(optional = false)
    @Column(name = "price")
    private BigDecimal price;

    public PsAttributeImpact() {
    }

    public PsAttributeImpact(Integer idAttributeImpact) {
        this.idAttributeImpact = idAttributeImpact;
    }

    public PsAttributeImpact(Integer idAttributeImpact, int idProduct, int idAttribute, BigDecimal weight, BigDecimal price) {
        this.idAttributeImpact = idAttributeImpact;
        this.idProduct = idProduct;
        this.idAttribute = idAttribute;
        this.weight = weight;
        this.price = price;
    }

    public Integer getIdAttributeImpact() {
        return idAttributeImpact;
    }

    public void setIdAttributeImpact(Integer idAttributeImpact) {
        this.idAttributeImpact = idAttributeImpact;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdAttribute() {
        return idAttribute;
    }

    public void setIdAttribute(int idAttribute) {
        this.idAttribute = idAttribute;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAttributeImpact != null ? idAttributeImpact.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAttributeImpact)) {
            return false;
        }
        PsAttributeImpact other = (PsAttributeImpact) object;
        if ((this.idAttributeImpact == null && other.idAttributeImpact != null) || (this.idAttributeImpact != null && !this.idAttributeImpact.equals(other.idAttributeImpact))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAttributeImpact[ idAttributeImpact=" + idAttributeImpact + " ]";
    }
    
}
