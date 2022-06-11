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
@Table(name = "ps_tax_rule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsTaxRule.findAll", query = "SELECT p FROM PsTaxRule p")
    , @NamedQuery(name = "PsTaxRule.findByIdTaxRule", query = "SELECT p FROM PsTaxRule p WHERE p.idTaxRule = :idTaxRule")
    , @NamedQuery(name = "PsTaxRule.findByIdTaxRulesGroup", query = "SELECT p FROM PsTaxRule p WHERE p.idTaxRulesGroup = :idTaxRulesGroup")
    , @NamedQuery(name = "PsTaxRule.findByIdCountry", query = "SELECT p FROM PsTaxRule p WHERE p.idCountry = :idCountry")
    , @NamedQuery(name = "PsTaxRule.findByIdState", query = "SELECT p FROM PsTaxRule p WHERE p.idState = :idState")
    , @NamedQuery(name = "PsTaxRule.findByZipcodeFrom", query = "SELECT p FROM PsTaxRule p WHERE p.zipcodeFrom = :zipcodeFrom")
    , @NamedQuery(name = "PsTaxRule.findByZipcodeTo", query = "SELECT p FROM PsTaxRule p WHERE p.zipcodeTo = :zipcodeTo")
    , @NamedQuery(name = "PsTaxRule.findByIdTax", query = "SELECT p FROM PsTaxRule p WHERE p.idTax = :idTax")
    , @NamedQuery(name = "PsTaxRule.findByBehavior", query = "SELECT p FROM PsTaxRule p WHERE p.behavior = :behavior")
    , @NamedQuery(name = "PsTaxRule.findByDescription", query = "SELECT p FROM PsTaxRule p WHERE p.description = :description")})
public class PsTaxRule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tax_rule")
    private Integer idTaxRule;
    @Basic(optional = false)
    @Column(name = "id_tax_rules_group")
    private int idTaxRulesGroup;
    @Basic(optional = false)
    @Column(name = "id_country")
    private int idCountry;
    @Basic(optional = false)
    @Column(name = "id_state")
    private int idState;
    @Basic(optional = false)
    @Column(name = "zipcode_from")
    private String zipcodeFrom;
    @Basic(optional = false)
    @Column(name = "zipcode_to")
    private String zipcodeTo;
    @Basic(optional = false)
    @Column(name = "id_tax")
    private int idTax;
    @Basic(optional = false)
    @Column(name = "behavior")
    private int behavior;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;

    public PsTaxRule() {
    }

    public PsTaxRule(Integer idTaxRule) {
        this.idTaxRule = idTaxRule;
    }

    public PsTaxRule(Integer idTaxRule, int idTaxRulesGroup, int idCountry, int idState, String zipcodeFrom, String zipcodeTo, int idTax, int behavior, String description) {
        this.idTaxRule = idTaxRule;
        this.idTaxRulesGroup = idTaxRulesGroup;
        this.idCountry = idCountry;
        this.idState = idState;
        this.zipcodeFrom = zipcodeFrom;
        this.zipcodeTo = zipcodeTo;
        this.idTax = idTax;
        this.behavior = behavior;
        this.description = description;
    }

    public Integer getIdTaxRule() {
        return idTaxRule;
    }

    public void setIdTaxRule(Integer idTaxRule) {
        this.idTaxRule = idTaxRule;
    }

    public int getIdTaxRulesGroup() {
        return idTaxRulesGroup;
    }

    public void setIdTaxRulesGroup(int idTaxRulesGroup) {
        this.idTaxRulesGroup = idTaxRulesGroup;
    }

    public int getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(int idCountry) {
        this.idCountry = idCountry;
    }

    public int getIdState() {
        return idState;
    }

    public void setIdState(int idState) {
        this.idState = idState;
    }

    public String getZipcodeFrom() {
        return zipcodeFrom;
    }

    public void setZipcodeFrom(String zipcodeFrom) {
        this.zipcodeFrom = zipcodeFrom;
    }

    public String getZipcodeTo() {
        return zipcodeTo;
    }

    public void setZipcodeTo(String zipcodeTo) {
        this.zipcodeTo = zipcodeTo;
    }

    public int getIdTax() {
        return idTax;
    }

    public void setIdTax(int idTax) {
        this.idTax = idTax;
    }

    public int getBehavior() {
        return behavior;
    }

    public void setBehavior(int behavior) {
        this.behavior = behavior;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTaxRule != null ? idTaxRule.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsTaxRule)) {
            return false;
        }
        PsTaxRule other = (PsTaxRule) object;
        if ((this.idTaxRule == null && other.idTaxRule != null) || (this.idTaxRule != null && !this.idTaxRule.equals(other.idTaxRule))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsTaxRule[ idTaxRule=" + idTaxRule + " ]";
    }
    
}
