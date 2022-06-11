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
@Table(name = "ps_required_field")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsRequiredField.findAll", query = "SELECT p FROM PsRequiredField p")
    , @NamedQuery(name = "PsRequiredField.findByIdRequiredField", query = "SELECT p FROM PsRequiredField p WHERE p.idRequiredField = :idRequiredField")
    , @NamedQuery(name = "PsRequiredField.findByObjectName", query = "SELECT p FROM PsRequiredField p WHERE p.objectName = :objectName")
    , @NamedQuery(name = "PsRequiredField.findByFieldName", query = "SELECT p FROM PsRequiredField p WHERE p.fieldName = :fieldName")})
public class PsRequiredField implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_required_field")
    private Integer idRequiredField;
    @Basic(optional = false)
    @Column(name = "object_name")
    private String objectName;
    @Basic(optional = false)
    @Column(name = "field_name")
    private String fieldName;

    public PsRequiredField() {
    }

    public PsRequiredField(Integer idRequiredField) {
        this.idRequiredField = idRequiredField;
    }

    public PsRequiredField(Integer idRequiredField, String objectName, String fieldName) {
        this.idRequiredField = idRequiredField;
        this.objectName = objectName;
        this.fieldName = fieldName;
    }

    public Integer getIdRequiredField() {
        return idRequiredField;
    }

    public void setIdRequiredField(Integer idRequiredField) {
        this.idRequiredField = idRequiredField;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRequiredField != null ? idRequiredField.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsRequiredField)) {
            return false;
        }
        PsRequiredField other = (PsRequiredField) object;
        if ((this.idRequiredField == null && other.idRequiredField != null) || (this.idRequiredField != null && !this.idRequiredField.equals(other.idRequiredField))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsRequiredField[ idRequiredField=" + idRequiredField + " ]";
    }
    
}
