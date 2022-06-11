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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ps_admin_filter")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAdminFilter.findAll", query = "SELECT p FROM PsAdminFilter p")
    , @NamedQuery(name = "PsAdminFilter.findById", query = "SELECT p FROM PsAdminFilter p WHERE p.id = :id")
    , @NamedQuery(name = "PsAdminFilter.findByEmployee", query = "SELECT p FROM PsAdminFilter p WHERE p.employee = :employee")
    , @NamedQuery(name = "PsAdminFilter.findByShop", query = "SELECT p FROM PsAdminFilter p WHERE p.shop = :shop")
    , @NamedQuery(name = "PsAdminFilter.findByController", query = "SELECT p FROM PsAdminFilter p WHERE p.controller = :controller")
    , @NamedQuery(name = "PsAdminFilter.findByAction", query = "SELECT p FROM PsAdminFilter p WHERE p.action = :action")
    , @NamedQuery(name = "PsAdminFilter.findByFilterId", query = "SELECT p FROM PsAdminFilter p WHERE p.filterId = :filterId")})
public class PsAdminFilter implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "employee")
    private int employee;
    @Basic(optional = false)
    @Column(name = "shop")
    private int shop;
    @Basic(optional = false)
    @Column(name = "controller")
    private String controller;
    @Basic(optional = false)
    @Column(name = "action")
    private String action;
    @Basic(optional = false)
    @Lob
    @Column(name = "filter")
    private String filter;
    @Basic(optional = false)
    @Column(name = "filter_id")
    private String filterId;

    public PsAdminFilter() {
    }

    public PsAdminFilter(Integer id) {
        this.id = id;
    }

    public PsAdminFilter(Integer id, int employee, int shop, String controller, String action, String filter, String filterId) {
        this.id = id;
        this.employee = employee;
        this.shop = shop;
        this.controller = controller;
        this.action = action;
        this.filter = filter;
        this.filterId = filterId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getEmployee() {
        return employee;
    }

    public void setEmployee(int employee) {
        this.employee = employee;
    }

    public int getShop() {
        return shop;
    }

    public void setShop(int shop) {
        this.shop = shop;
    }

    public String getController() {
        return controller;
    }

    public void setController(String controller) {
        this.controller = controller;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getFilterId() {
        return filterId;
    }

    public void setFilterId(String filterId) {
        this.filterId = filterId;
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
        if (!(object instanceof PsAdminFilter)) {
            return false;
        }
        PsAdminFilter other = (PsAdminFilter) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAdminFilter[ id=" + id + " ]";
    }
    
}
