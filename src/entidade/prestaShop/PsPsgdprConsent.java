/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.prestaShop;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ps_psgdpr_consent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsPsgdprConsent.findAll", query = "SELECT p FROM PsPsgdprConsent p")
    , @NamedQuery(name = "PsPsgdprConsent.findByIdGdprConsent", query = "SELECT p FROM PsPsgdprConsent p WHERE p.psPsgdprConsentPK.idGdprConsent = :idGdprConsent")
    , @NamedQuery(name = "PsPsgdprConsent.findByIdModule", query = "SELECT p FROM PsPsgdprConsent p WHERE p.psPsgdprConsentPK.idModule = :idModule")
    , @NamedQuery(name = "PsPsgdprConsent.findByActive", query = "SELECT p FROM PsPsgdprConsent p WHERE p.active = :active")
    , @NamedQuery(name = "PsPsgdprConsent.findByError", query = "SELECT p FROM PsPsgdprConsent p WHERE p.error = :error")
    , @NamedQuery(name = "PsPsgdprConsent.findByDateAdd", query = "SELECT p FROM PsPsgdprConsent p WHERE p.dateAdd = :dateAdd")
    , @NamedQuery(name = "PsPsgdprConsent.findByDateUpd", query = "SELECT p FROM PsPsgdprConsent p WHERE p.dateUpd = :dateUpd")})
public class PsPsgdprConsent implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsPsgdprConsentPK psPsgdprConsentPK;
    @Basic(optional = false)
    @Column(name = "active")
    private int active;
    @Column(name = "error")
    private Integer error;
    @Lob
    @Column(name = "error_message")
    private String errorMessage;
    @Basic(optional = false)
    @Column(name = "date_add")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdd;
    @Basic(optional = false)
    @Column(name = "date_upd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpd;

    public PsPsgdprConsent() {
    }

    public PsPsgdprConsent(PsPsgdprConsentPK psPsgdprConsentPK) {
        this.psPsgdprConsentPK = psPsgdprConsentPK;
    }

    public PsPsgdprConsent(PsPsgdprConsentPK psPsgdprConsentPK, int active, Date dateAdd, Date dateUpd) {
        this.psPsgdprConsentPK = psPsgdprConsentPK;
        this.active = active;
        this.dateAdd = dateAdd;
        this.dateUpd = dateUpd;
    }

    public PsPsgdprConsent(int idGdprConsent, int idModule) {
        this.psPsgdprConsentPK = new PsPsgdprConsentPK(idGdprConsent, idModule);
    }

    public PsPsgdprConsentPK getPsPsgdprConsentPK() {
        return psPsgdprConsentPK;
    }

    public void setPsPsgdprConsentPK(PsPsgdprConsentPK psPsgdprConsentPK) {
        this.psPsgdprConsentPK = psPsgdprConsentPK;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Date getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Date dateAdd) {
        this.dateAdd = dateAdd;
    }

    public Date getDateUpd() {
        return dateUpd;
    }

    public void setDateUpd(Date dateUpd) {
        this.dateUpd = dateUpd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psPsgdprConsentPK != null ? psPsgdprConsentPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsPsgdprConsent)) {
            return false;
        }
        PsPsgdprConsent other = (PsPsgdprConsent) object;
        if ((this.psPsgdprConsentPK == null && other.psPsgdprConsentPK != null) || (this.psPsgdprConsentPK != null && !this.psPsgdprConsentPK.equals(other.psPsgdprConsentPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsPsgdprConsent[ psPsgdprConsentPK=" + psPsgdprConsentPK + " ]";
    }
    
}
