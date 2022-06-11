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
@Table(name = "ps_condition")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsCondition.findAll", query = "SELECT p FROM PsCondition p")
    , @NamedQuery(name = "PsCondition.findByIdCondition", query = "SELECT p FROM PsCondition p WHERE p.psConditionPK.idCondition = :idCondition")
    , @NamedQuery(name = "PsCondition.findByIdPsCondition", query = "SELECT p FROM PsCondition p WHERE p.psConditionPK.idPsCondition = :idPsCondition")
    , @NamedQuery(name = "PsCondition.findByType", query = "SELECT p FROM PsCondition p WHERE p.type = :type")
    , @NamedQuery(name = "PsCondition.findByOperator", query = "SELECT p FROM PsCondition p WHERE p.operator = :operator")
    , @NamedQuery(name = "PsCondition.findByValue", query = "SELECT p FROM PsCondition p WHERE p.value = :value")
    , @NamedQuery(name = "PsCondition.findByResult", query = "SELECT p FROM PsCondition p WHERE p.result = :result")
    , @NamedQuery(name = "PsCondition.findByCalculationType", query = "SELECT p FROM PsCondition p WHERE p.calculationType = :calculationType")
    , @NamedQuery(name = "PsCondition.findByCalculationDetail", query = "SELECT p FROM PsCondition p WHERE p.calculationDetail = :calculationDetail")
    , @NamedQuery(name = "PsCondition.findByValidated", query = "SELECT p FROM PsCondition p WHERE p.validated = :validated")
    , @NamedQuery(name = "PsCondition.findByDateAdd", query = "SELECT p FROM PsCondition p WHERE p.dateAdd = :dateAdd")
    , @NamedQuery(name = "PsCondition.findByDateUpd", query = "SELECT p FROM PsCondition p WHERE p.dateUpd = :dateUpd")})
public class PsCondition implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsConditionPK psConditionPK;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;
    @Lob
    @Column(name = "request")
    private String request;
    @Column(name = "operator")
    private String operator;
    @Column(name = "value")
    private String value;
    @Column(name = "result")
    private String result;
    @Column(name = "calculation_type")
    private String calculationType;
    @Column(name = "calculation_detail")
    private String calculationDetail;
    @Basic(optional = false)
    @Column(name = "validated")
    private boolean validated;
    @Basic(optional = false)
    @Column(name = "date_add")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdd;
    @Basic(optional = false)
    @Column(name = "date_upd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpd;

    public PsCondition() {
    }

    public PsCondition(PsConditionPK psConditionPK) {
        this.psConditionPK = psConditionPK;
    }

    public PsCondition(PsConditionPK psConditionPK, String type, boolean validated, Date dateAdd, Date dateUpd) {
        this.psConditionPK = psConditionPK;
        this.type = type;
        this.validated = validated;
        this.dateAdd = dateAdd;
        this.dateUpd = dateUpd;
    }

    public PsCondition(int idCondition, int idPsCondition) {
        this.psConditionPK = new PsConditionPK(idCondition, idPsCondition);
    }

    public PsConditionPK getPsConditionPK() {
        return psConditionPK;
    }

    public void setPsConditionPK(PsConditionPK psConditionPK) {
        this.psConditionPK = psConditionPK;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getCalculationType() {
        return calculationType;
    }

    public void setCalculationType(String calculationType) {
        this.calculationType = calculationType;
    }

    public String getCalculationDetail() {
        return calculationDetail;
    }

    public void setCalculationDetail(String calculationDetail) {
        this.calculationDetail = calculationDetail;
    }

    public boolean getValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
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
        hash += (psConditionPK != null ? psConditionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCondition)) {
            return false;
        }
        PsCondition other = (PsCondition) object;
        if ((this.psConditionPK == null && other.psConditionPK != null) || (this.psConditionPK != null && !this.psConditionPK.equals(other.psConditionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCondition[ psConditionPK=" + psConditionPK + " ]";
    }
    
}
