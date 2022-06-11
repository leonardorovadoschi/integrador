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
@Table(name = "ps_tab_module_preference")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsTabModulePreference.findAll", query = "SELECT p FROM PsTabModulePreference p")
    , @NamedQuery(name = "PsTabModulePreference.findByIdTabModulePreference", query = "SELECT p FROM PsTabModulePreference p WHERE p.idTabModulePreference = :idTabModulePreference")
    , @NamedQuery(name = "PsTabModulePreference.findByIdEmployee", query = "SELECT p FROM PsTabModulePreference p WHERE p.idEmployee = :idEmployee")
    , @NamedQuery(name = "PsTabModulePreference.findByIdTab", query = "SELECT p FROM PsTabModulePreference p WHERE p.idTab = :idTab")
    , @NamedQuery(name = "PsTabModulePreference.findByModule", query = "SELECT p FROM PsTabModulePreference p WHERE p.module = :module")})
public class PsTabModulePreference implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tab_module_preference")
    private Integer idTabModulePreference;
    @Basic(optional = false)
    @Column(name = "id_employee")
    private int idEmployee;
    @Basic(optional = false)
    @Column(name = "id_tab")
    private int idTab;
    @Basic(optional = false)
    @Column(name = "module")
    private String module;

    public PsTabModulePreference() {
    }

    public PsTabModulePreference(Integer idTabModulePreference) {
        this.idTabModulePreference = idTabModulePreference;
    }

    public PsTabModulePreference(Integer idTabModulePreference, int idEmployee, int idTab, String module) {
        this.idTabModulePreference = idTabModulePreference;
        this.idEmployee = idEmployee;
        this.idTab = idTab;
        this.module = module;
    }

    public Integer getIdTabModulePreference() {
        return idTabModulePreference;
    }

    public void setIdTabModulePreference(Integer idTabModulePreference) {
        this.idTabModulePreference = idTabModulePreference;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public int getIdTab() {
        return idTab;
    }

    public void setIdTab(int idTab) {
        this.idTab = idTab;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTabModulePreference != null ? idTabModulePreference.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsTabModulePreference)) {
            return false;
        }
        PsTabModulePreference other = (PsTabModulePreference) object;
        if ((this.idTabModulePreference == null && other.idTabModulePreference != null) || (this.idTabModulePreference != null && !this.idTabModulePreference.equals(other.idTabModulePreference))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsTabModulePreference[ idTabModulePreference=" + idTabModulePreference + " ]";
    }
    
}
