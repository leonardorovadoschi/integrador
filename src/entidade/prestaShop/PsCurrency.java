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
@Table(name = "ps_currency")
@XmlRootElement

public class PsCurrency implements Serializable {
    @Basic(optional = false)
    @Column(name = "deleted")
    private short deleted;
    @Basic(optional = false)
    @Column(name = "active")
    private short active;
    @Basic(optional = false)
    @Column(name = "unofficial")
    private short unofficial;
    @Basic(optional = false)
    @Column(name = "modified")
    private short modified;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_currency")
    private Integer idCurrency;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "iso_code")
    private String isoCode;
    @Column(name = "numeric_iso_code")
    private String numericIsoCode;
    @Basic(optional = false)
    @Column(name = "precision")
    private int precision;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "conversion_rate")
    private BigDecimal conversionRate;

    public PsCurrency() {
    }

    public PsCurrency(Integer idCurrency) {
        this.idCurrency = idCurrency;
    }

    public PsCurrency(Integer idCurrency, String name, String isoCode, int precision, BigDecimal conversionRate, short deleted, short active) {
        this.idCurrency = idCurrency;
        this.name = name;
        this.isoCode = isoCode;
        this.precision = precision;
        this.conversionRate = conversionRate;
        this.deleted = deleted;
        this.active = active;
    }

    public Integer getIdCurrency() {
        return idCurrency;
    }

    public void setIdCurrency(Integer idCurrency) {
        this.idCurrency = idCurrency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    public String getNumericIsoCode() {
        return numericIsoCode;
    }

    public void setNumericIsoCode(String numericIsoCode) {
        this.numericIsoCode = numericIsoCode;
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    public BigDecimal getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(BigDecimal conversionRate) {
        this.conversionRate = conversionRate;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCurrency != null ? idCurrency.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCurrency)) {
            return false;
        }
        PsCurrency other = (PsCurrency) object;
        if ((this.idCurrency == null && other.idCurrency != null) || (this.idCurrency != null && !this.idCurrency.equals(other.idCurrency))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCurrency[ idCurrency=" + idCurrency + " ]";
    }

    public short getDeleted() {
        return deleted;
    }

    public void setDeleted(short deleted) {
        this.deleted = deleted;
    }

    public short getActive() {
        return active;
    }

    public void setActive(short active) {
        this.active = active;
    }

    public short getUnofficial() {
        return unofficial;
    }

    public void setUnofficial(short unofficial) {
        this.unofficial = unofficial;
    }

    public short getModified() {
        return modified;
    }

    public void setModified(short modified) {
        this.modified = modified;
    }
    
}
