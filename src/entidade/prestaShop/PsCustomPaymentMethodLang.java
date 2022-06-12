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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Fazenda
 */
@Entity
@Table(name = "ps_custom_payment_method_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsCustomPaymentMethodLang.findAll", query = "SELECT p FROM PsCustomPaymentMethodLang p"),
    @NamedQuery(name = "PsCustomPaymentMethodLang.findByIdCustomPaymentMethod", query = "SELECT p FROM PsCustomPaymentMethodLang p WHERE p.psCustomPaymentMethodLangPK.idCustomPaymentMethod = :idCustomPaymentMethod"),
    @NamedQuery(name = "PsCustomPaymentMethodLang.findByIdLang", query = "SELECT p FROM PsCustomPaymentMethodLang p WHERE p.psCustomPaymentMethodLangPK.idLang = :idLang"),
    @NamedQuery(name = "PsCustomPaymentMethodLang.findByNameMessageField", query = "SELECT p FROM PsCustomPaymentMethodLang p WHERE p.nameMessageField = :nameMessageField"),
    @NamedQuery(name = "PsCustomPaymentMethodLang.findByErrorMessageField", query = "SELECT p FROM PsCustomPaymentMethodLang p WHERE p.errorMessageField = :errorMessageField")})
public class PsCustomPaymentMethodLang implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsCustomPaymentMethodLangPK psCustomPaymentMethodLangPK;
    @Basic(optional = false)
    @Lob
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Lob
    @Column(name = "details")
    private String details;
    @Basic(optional = false)
    @Lob
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Lob
    @Column(name = "description_short")
    private String descriptionShort;
    @Basic(optional = false)
    @Column(name = "name_message_field")
    private String nameMessageField;
    @Basic(optional = false)
    @Column(name = "error_message_field")
    private String errorMessageField;

    public PsCustomPaymentMethodLang() {
    }

    public PsCustomPaymentMethodLang(PsCustomPaymentMethodLangPK psCustomPaymentMethodLangPK) {
        this.psCustomPaymentMethodLangPK = psCustomPaymentMethodLangPK;
    }

    public PsCustomPaymentMethodLang(PsCustomPaymentMethodLangPK psCustomPaymentMethodLangPK, String name, String details, String description, String descriptionShort, String nameMessageField, String errorMessageField) {
        this.psCustomPaymentMethodLangPK = psCustomPaymentMethodLangPK;
        this.name = name;
        this.details = details;
        this.description = description;
        this.descriptionShort = descriptionShort;
        this.nameMessageField = nameMessageField;
        this.errorMessageField = errorMessageField;
    }

    public PsCustomPaymentMethodLang(int idCustomPaymentMethod, int idLang) {
        this.psCustomPaymentMethodLangPK = new PsCustomPaymentMethodLangPK(idCustomPaymentMethod, idLang);
    }

    public PsCustomPaymentMethodLangPK getPsCustomPaymentMethodLangPK() {
        return psCustomPaymentMethodLangPK;
    }

    public void setPsCustomPaymentMethodLangPK(PsCustomPaymentMethodLangPK psCustomPaymentMethodLangPK) {
        this.psCustomPaymentMethodLangPK = psCustomPaymentMethodLangPK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionShort() {
        return descriptionShort;
    }

    public void setDescriptionShort(String descriptionShort) {
        this.descriptionShort = descriptionShort;
    }

    public String getNameMessageField() {
        return nameMessageField;
    }

    public void setNameMessageField(String nameMessageField) {
        this.nameMessageField = nameMessageField;
    }

    public String getErrorMessageField() {
        return errorMessageField;
    }

    public void setErrorMessageField(String errorMessageField) {
        this.errorMessageField = errorMessageField;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psCustomPaymentMethodLangPK != null ? psCustomPaymentMethodLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCustomPaymentMethodLang)) {
            return false;
        }
        PsCustomPaymentMethodLang other = (PsCustomPaymentMethodLang) object;
        if ((this.psCustomPaymentMethodLangPK == null && other.psCustomPaymentMethodLangPK != null) || (this.psCustomPaymentMethodLangPK != null && !this.psCustomPaymentMethodLangPK.equals(other.psCustomPaymentMethodLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCustomPaymentMethodLang[ psCustomPaymentMethodLangPK=" + psCustomPaymentMethodLangPK + " ]";
    }
    
}
