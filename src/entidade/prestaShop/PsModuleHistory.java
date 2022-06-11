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
@Table(name = "ps_module_history")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsModuleHistory.findAll", query = "SELECT p FROM PsModuleHistory p")
    , @NamedQuery(name = "PsModuleHistory.findById", query = "SELECT p FROM PsModuleHistory p WHERE p.id = :id")
    , @NamedQuery(name = "PsModuleHistory.findByIdEmployee", query = "SELECT p FROM PsModuleHistory p WHERE p.idEmployee = :idEmployee")
    , @NamedQuery(name = "PsModuleHistory.findByIdModule", query = "SELECT p FROM PsModuleHistory p WHERE p.idModule = :idModule")
    , @NamedQuery(name = "PsModuleHistory.findByDateAdd", query = "SELECT p FROM PsModuleHistory p WHERE p.dateAdd = :dateAdd")
    , @NamedQuery(name = "PsModuleHistory.findByDateUpd", query = "SELECT p FROM PsModuleHistory p WHERE p.dateUpd = :dateUpd")})
public class PsModuleHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "id_employee")
    private int idEmployee;
    @Basic(optional = false)
    @Column(name = "id_module")
    private int idModule;
    @Basic(optional = false)
    @Column(name = "date_add")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdd;
    @Basic(optional = false)
    @Column(name = "date_upd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpd;

    public PsModuleHistory() {
    }

    public PsModuleHistory(Integer id) {
        this.id = id;
    }

    public PsModuleHistory(Integer id, int idEmployee, int idModule, Date dateAdd, Date dateUpd) {
        this.id = id;
        this.idEmployee = idEmployee;
        this.idModule = idModule;
        this.dateAdd = dateAdd;
        this.dateUpd = dateUpd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public int getIdModule() {
        return idModule;
    }

    public void setIdModule(int idModule) {
        this.idModule = idModule;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsModuleHistory)) {
            return false;
        }
        PsModuleHistory other = (PsModuleHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsModuleHistory[ id=" + id + " ]";
    }
    
}
