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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "ps_tax_rules_group")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsTaxRulesGroup.findAll", query = "SELECT p FROM PsTaxRulesGroup p")
    , @NamedQuery(name = "PsTaxRulesGroup.findByIdTaxRulesGroup", query = "SELECT p FROM PsTaxRulesGroup p WHERE p.idTaxRulesGroup = :idTaxRulesGroup")
    , @NamedQuery(name = "PsTaxRulesGroup.findByName", query = "SELECT p FROM PsTaxRulesGroup p WHERE p.name = :name")
    , @NamedQuery(name = "PsTaxRulesGroup.findByActive", query = "SELECT p FROM PsTaxRulesGroup p WHERE p.active = :active")
    , @NamedQuery(name = "PsTaxRulesGroup.findByDeleted", query = "SELECT p FROM PsTaxRulesGroup p WHERE p.deleted = :deleted")
    , @NamedQuery(name = "PsTaxRulesGroup.findByDateAdd", query = "SELECT p FROM PsTaxRulesGroup p WHERE p.dateAdd = :dateAdd")
    , @NamedQuery(name = "PsTaxRulesGroup.findByDateUpd", query = "SELECT p FROM PsTaxRulesGroup p WHERE p.dateUpd = :dateUpd")})
public class PsTaxRulesGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tax_rules_group")
    private Integer idTaxRulesGroup;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "active")
    private int active;
    @Basic(optional = false)
    @Column(name = "deleted")
    private boolean deleted;
    @Basic(optional = false)
    @Column(name = "date_add")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdd;
    @Basic(optional = false)
    @Column(name = "date_upd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpd;

    public PsTaxRulesGroup() {
    }

    public PsTaxRulesGroup(Integer idTaxRulesGroup) {
        this.idTaxRulesGroup = idTaxRulesGroup;
    }

    public PsTaxRulesGroup(Integer idTaxRulesGroup, String name, int active, boolean deleted, Date dateAdd, Date dateUpd) {
        this.idTaxRulesGroup = idTaxRulesGroup;
        this.name = name;
        this.active = active;
        this.deleted = deleted;
        this.dateAdd = dateAdd;
        this.dateUpd = dateUpd;
    }

    public Integer getIdTaxRulesGroup() {
        return idTaxRulesGroup;
    }

    public void setIdTaxRulesGroup(Integer idTaxRulesGroup) {
        this.idTaxRulesGroup = idTaxRulesGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
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
        hash += (idTaxRulesGroup != null ? idTaxRulesGroup.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsTaxRulesGroup)) {
            return false;
        }
        PsTaxRulesGroup other = (PsTaxRulesGroup) object;
        if ((this.idTaxRulesGroup == null && other.idTaxRulesGroup != null) || (this.idTaxRulesGroup != null && !this.idTaxRulesGroup.equals(other.idTaxRulesGroup))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsTaxRulesGroup[ idTaxRulesGroup=" + idTaxRulesGroup + " ]";
    }
    
}
