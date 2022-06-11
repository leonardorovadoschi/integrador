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
@Table(name = "ps_range_weight")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsRangeWeight.findAll", query = "SELECT p FROM PsRangeWeight p")
    , @NamedQuery(name = "PsRangeWeight.findByIdRangeWeight", query = "SELECT p FROM PsRangeWeight p WHERE p.idRangeWeight = :idRangeWeight")
    , @NamedQuery(name = "PsRangeWeight.findByIdCarrier", query = "SELECT p FROM PsRangeWeight p WHERE p.idCarrier = :idCarrier")
    , @NamedQuery(name = "PsRangeWeight.findByDelimiter1", query = "SELECT p FROM PsRangeWeight p WHERE p.delimiter1 = :delimiter1")
    , @NamedQuery(name = "PsRangeWeight.findByDelimiter2", query = "SELECT p FROM PsRangeWeight p WHERE p.delimiter2 = :delimiter2")})
public class PsRangeWeight implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_range_weight")
    private Integer idRangeWeight;
    @Basic(optional = false)
    @Column(name = "id_carrier")
    private int idCarrier;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "delimiter1")
    private BigDecimal delimiter1;
    @Basic(optional = false)
    @Column(name = "delimiter2")
    private BigDecimal delimiter2;

    public PsRangeWeight() {
    }

    public PsRangeWeight(Integer idRangeWeight) {
        this.idRangeWeight = idRangeWeight;
    }

    public PsRangeWeight(Integer idRangeWeight, int idCarrier, BigDecimal delimiter1, BigDecimal delimiter2) {
        this.idRangeWeight = idRangeWeight;
        this.idCarrier = idCarrier;
        this.delimiter1 = delimiter1;
        this.delimiter2 = delimiter2;
    }

    public Integer getIdRangeWeight() {
        return idRangeWeight;
    }

    public void setIdRangeWeight(Integer idRangeWeight) {
        this.idRangeWeight = idRangeWeight;
    }

    public int getIdCarrier() {
        return idCarrier;
    }

    public void setIdCarrier(int idCarrier) {
        this.idCarrier = idCarrier;
    }

    public BigDecimal getDelimiter1() {
        return delimiter1;
    }

    public void setDelimiter1(BigDecimal delimiter1) {
        this.delimiter1 = delimiter1;
    }

    public BigDecimal getDelimiter2() {
        return delimiter2;
    }

    public void setDelimiter2(BigDecimal delimiter2) {
        this.delimiter2 = delimiter2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRangeWeight != null ? idRangeWeight.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsRangeWeight)) {
            return false;
        }
        PsRangeWeight other = (PsRangeWeight) object;
        if ((this.idRangeWeight == null && other.idRangeWeight != null) || (this.idRangeWeight != null && !this.idRangeWeight.equals(other.idRangeWeight))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsRangeWeight[ idRangeWeight=" + idRangeWeight + " ]";
    }
    
}
