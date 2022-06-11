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
 * @author leo
 */
@Entity
@Table(name = "ps_country")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsCountry.findAll", query = "SELECT p FROM PsCountry p")
    , @NamedQuery(name = "PsCountry.findByIdCountry", query = "SELECT p FROM PsCountry p WHERE p.idCountry = :idCountry")
    , @NamedQuery(name = "PsCountry.findByIdZone", query = "SELECT p FROM PsCountry p WHERE p.idZone = :idZone")
    , @NamedQuery(name = "PsCountry.findByIdCurrency", query = "SELECT p FROM PsCountry p WHERE p.idCurrency = :idCurrency")
    , @NamedQuery(name = "PsCountry.findByIsoCode", query = "SELECT p FROM PsCountry p WHERE p.isoCode = :isoCode")
    , @NamedQuery(name = "PsCountry.findByCallPrefix", query = "SELECT p FROM PsCountry p WHERE p.callPrefix = :callPrefix")
    , @NamedQuery(name = "PsCountry.findByActive", query = "SELECT p FROM PsCountry p WHERE p.active = :active")
    , @NamedQuery(name = "PsCountry.findByContainsStates", query = "SELECT p FROM PsCountry p WHERE p.containsStates = :containsStates")
    , @NamedQuery(name = "PsCountry.findByNeedIdentificationNumber", query = "SELECT p FROM PsCountry p WHERE p.needIdentificationNumber = :needIdentificationNumber")
    , @NamedQuery(name = "PsCountry.findByNeedZipCode", query = "SELECT p FROM PsCountry p WHERE p.needZipCode = :needZipCode")
    , @NamedQuery(name = "PsCountry.findByZipCodeFormat", query = "SELECT p FROM PsCountry p WHERE p.zipCodeFormat = :zipCodeFormat")
    , @NamedQuery(name = "PsCountry.findByDisplayTaxLabel", query = "SELECT p FROM PsCountry p WHERE p.displayTaxLabel = :displayTaxLabel")})
public class PsCountry implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_country")
    private Integer idCountry;
    @Basic(optional = false)
    @Column(name = "id_zone")
    private int idZone;
    @Basic(optional = false)
    @Column(name = "id_currency")
    private int idCurrency;
    @Basic(optional = false)
    @Column(name = "iso_code")
    private String isoCode;
    @Basic(optional = false)
    @Column(name = "call_prefix")
    private int callPrefix;
    @Basic(optional = false)
    @Column(name = "active")
    private boolean active;
    @Basic(optional = false)
    @Column(name = "contains_states")
    private boolean containsStates;
    @Basic(optional = false)
    @Column(name = "need_identification_number")
    private boolean needIdentificationNumber;
    @Basic(optional = false)
    @Column(name = "need_zip_code")
    private boolean needZipCode;
    @Basic(optional = false)
    @Column(name = "zip_code_format")
    private String zipCodeFormat;
    @Basic(optional = false)
    @Column(name = "display_tax_label")
    private boolean displayTaxLabel;

    public PsCountry() {
    }

    public PsCountry(Integer idCountry) {
        this.idCountry = idCountry;
    }

    public PsCountry(Integer idCountry, int idZone, int idCurrency, String isoCode, int callPrefix, boolean active, boolean containsStates, boolean needIdentificationNumber, boolean needZipCode, String zipCodeFormat, boolean displayTaxLabel) {
        this.idCountry = idCountry;
        this.idZone = idZone;
        this.idCurrency = idCurrency;
        this.isoCode = isoCode;
        this.callPrefix = callPrefix;
        this.active = active;
        this.containsStates = containsStates;
        this.needIdentificationNumber = needIdentificationNumber;
        this.needZipCode = needZipCode;
        this.zipCodeFormat = zipCodeFormat;
        this.displayTaxLabel = displayTaxLabel;
    }

    public Integer getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(Integer idCountry) {
        this.idCountry = idCountry;
    }

    public int getIdZone() {
        return idZone;
    }

    public void setIdZone(int idZone) {
        this.idZone = idZone;
    }

    public int getIdCurrency() {
        return idCurrency;
    }

    public void setIdCurrency(int idCurrency) {
        this.idCurrency = idCurrency;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    public int getCallPrefix() {
        return callPrefix;
    }

    public void setCallPrefix(int callPrefix) {
        this.callPrefix = callPrefix;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean getContainsStates() {
        return containsStates;
    }

    public void setContainsStates(boolean containsStates) {
        this.containsStates = containsStates;
    }

    public boolean getNeedIdentificationNumber() {
        return needIdentificationNumber;
    }

    public void setNeedIdentificationNumber(boolean needIdentificationNumber) {
        this.needIdentificationNumber = needIdentificationNumber;
    }

    public boolean getNeedZipCode() {
        return needZipCode;
    }

    public void setNeedZipCode(boolean needZipCode) {
        this.needZipCode = needZipCode;
    }

    public String getZipCodeFormat() {
        return zipCodeFormat;
    }

    public void setZipCodeFormat(String zipCodeFormat) {
        this.zipCodeFormat = zipCodeFormat;
    }

    public boolean getDisplayTaxLabel() {
        return displayTaxLabel;
    }

    public void setDisplayTaxLabel(boolean displayTaxLabel) {
        this.displayTaxLabel = displayTaxLabel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCountry != null ? idCountry.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCountry)) {
            return false;
        }
        PsCountry other = (PsCountry) object;
        if ((this.idCountry == null && other.idCountry != null) || (this.idCountry != null && !this.idCountry.equals(other.idCountry))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCountry[ idCountry=" + idCountry + " ]";
    }
    
}
