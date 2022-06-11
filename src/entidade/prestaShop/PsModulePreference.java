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
@Table(name = "ps_module_preference")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsModulePreference.findAll", query = "SELECT p FROM PsModulePreference p")
    , @NamedQuery(name = "PsModulePreference.findByIdModulePreference", query = "SELECT p FROM PsModulePreference p WHERE p.idModulePreference = :idModulePreference")
    , @NamedQuery(name = "PsModulePreference.findByIdEmployee", query = "SELECT p FROM PsModulePreference p WHERE p.idEmployee = :idEmployee")
    , @NamedQuery(name = "PsModulePreference.findByModule", query = "SELECT p FROM PsModulePreference p WHERE p.module = :module")
    , @NamedQuery(name = "PsModulePreference.findByInterest", query = "SELECT p FROM PsModulePreference p WHERE p.interest = :interest")
    , @NamedQuery(name = "PsModulePreference.findByFavorite", query = "SELECT p FROM PsModulePreference p WHERE p.favorite = :favorite")})
public class PsModulePreference implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_module_preference")
    private Integer idModulePreference;
    @Basic(optional = false)
    @Column(name = "id_employee")
    private int idEmployee;
    @Basic(optional = false)
    @Column(name = "module")
    private String module;
    @Column(name = "interest")
    private Boolean interest;
    @Column(name = "favorite")
    private Boolean favorite;

    public PsModulePreference() {
    }

    public PsModulePreference(Integer idModulePreference) {
        this.idModulePreference = idModulePreference;
    }

    public PsModulePreference(Integer idModulePreference, int idEmployee, String module) {
        this.idModulePreference = idModulePreference;
        this.idEmployee = idEmployee;
        this.module = module;
    }

    public Integer getIdModulePreference() {
        return idModulePreference;
    }

    public void setIdModulePreference(Integer idModulePreference) {
        this.idModulePreference = idModulePreference;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public Boolean getInterest() {
        return interest;
    }

    public void setInterest(Boolean interest) {
        this.interest = interest;
    }

    public Boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idModulePreference != null ? idModulePreference.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsModulePreference)) {
            return false;
        }
        PsModulePreference other = (PsModulePreference) object;
        if ((this.idModulePreference == null && other.idModulePreference != null) || (this.idModulePreference != null && !this.idModulePreference.equals(other.idModulePreference))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsModulePreference[ idModulePreference=" + idModulePreference + " ]";
    }
    
}
