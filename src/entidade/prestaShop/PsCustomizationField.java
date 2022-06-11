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
@Table(name = "ps_customization_field")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsCustomizationField.findAll", query = "SELECT p FROM PsCustomizationField p")
    , @NamedQuery(name = "PsCustomizationField.findByIdCustomizationField", query = "SELECT p FROM PsCustomizationField p WHERE p.idCustomizationField = :idCustomizationField")
    , @NamedQuery(name = "PsCustomizationField.findByIdProduct", query = "SELECT p FROM PsCustomizationField p WHERE p.idProduct = :idProduct")
    , @NamedQuery(name = "PsCustomizationField.findByType", query = "SELECT p FROM PsCustomizationField p WHERE p.type = :type")
    , @NamedQuery(name = "PsCustomizationField.findByRequired", query = "SELECT p FROM PsCustomizationField p WHERE p.required = :required")
    , @NamedQuery(name = "PsCustomizationField.findByIsModule", query = "SELECT p FROM PsCustomizationField p WHERE p.isModule = :isModule")
    , @NamedQuery(name = "PsCustomizationField.findByIsDeleted", query = "SELECT p FROM PsCustomizationField p WHERE p.isDeleted = :isDeleted")})
public class PsCustomizationField implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_customization_field")
    private Integer idCustomizationField;
    @Basic(optional = false)
    @Column(name = "id_product")
    private int idProduct;
    @Basic(optional = false)
    @Column(name = "type")
    private boolean type;
    @Basic(optional = false)
    @Column(name = "required")
    private boolean required;
    @Basic(optional = false)
    @Column(name = "is_module")
    private boolean isModule;
    @Basic(optional = false)
    @Column(name = "is_deleted")
    private boolean isDeleted;

    public PsCustomizationField() {
    }

    public PsCustomizationField(Integer idCustomizationField) {
        this.idCustomizationField = idCustomizationField;
    }

    public PsCustomizationField(Integer idCustomizationField, int idProduct, boolean type, boolean required, boolean isModule, boolean isDeleted) {
        this.idCustomizationField = idCustomizationField;
        this.idProduct = idProduct;
        this.type = type;
        this.required = required;
        this.isModule = isModule;
        this.isDeleted = isDeleted;
    }

    public Integer getIdCustomizationField() {
        return idCustomizationField;
    }

    public void setIdCustomizationField(Integer idCustomizationField) {
        this.idCustomizationField = idCustomizationField;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public boolean getType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public boolean getRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public boolean getIsModule() {
        return isModule;
    }

    public void setIsModule(boolean isModule) {
        this.isModule = isModule;
    }

    public boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCustomizationField != null ? idCustomizationField.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCustomizationField)) {
            return false;
        }
        PsCustomizationField other = (PsCustomizationField) object;
        if ((this.idCustomizationField == null && other.idCustomizationField != null) || (this.idCustomizationField != null && !this.idCustomizationField.equals(other.idCustomizationField))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCustomizationField[ idCustomizationField=" + idCustomizationField + " ]";
    }
    
}
