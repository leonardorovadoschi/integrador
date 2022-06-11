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
@Table(name = "ps_layered_filter")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsLayeredFilter.findAll", query = "SELECT p FROM PsLayeredFilter p")
    , @NamedQuery(name = "PsLayeredFilter.findByIdLayeredFilter", query = "SELECT p FROM PsLayeredFilter p WHERE p.idLayeredFilter = :idLayeredFilter")
    , @NamedQuery(name = "PsLayeredFilter.findByName", query = "SELECT p FROM PsLayeredFilter p WHERE p.name = :name")
    , @NamedQuery(name = "PsLayeredFilter.findByNCategories", query = "SELECT p FROM PsLayeredFilter p WHERE p.nCategories = :nCategories")
    , @NamedQuery(name = "PsLayeredFilter.findByDateAdd", query = "SELECT p FROM PsLayeredFilter p WHERE p.dateAdd = :dateAdd")})
public class PsLayeredFilter implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_layered_filter")
    private Integer idLayeredFilter;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Lob
    @Column(name = "filters")
    private String filters;
    @Basic(optional = false)
    @Column(name = "n_categories")
    private int nCategories;
    @Basic(optional = false)
    @Column(name = "date_add")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdd;

    public PsLayeredFilter() {
    }

    public PsLayeredFilter(Integer idLayeredFilter) {
        this.idLayeredFilter = idLayeredFilter;
    }

    public PsLayeredFilter(Integer idLayeredFilter, String name, int nCategories, Date dateAdd) {
        this.idLayeredFilter = idLayeredFilter;
        this.name = name;
        this.nCategories = nCategories;
        this.dateAdd = dateAdd;
    }

    public Integer getIdLayeredFilter() {
        return idLayeredFilter;
    }

    public void setIdLayeredFilter(Integer idLayeredFilter) {
        this.idLayeredFilter = idLayeredFilter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilters() {
        return filters;
    }

    public void setFilters(String filters) {
        this.filters = filters;
    }

    public int getNCategories() {
        return nCategories;
    }

    public void setNCategories(int nCategories) {
        this.nCategories = nCategories;
    }

    public Date getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Date dateAdd) {
        this.dateAdd = dateAdd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLayeredFilter != null ? idLayeredFilter.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsLayeredFilter)) {
            return false;
        }
        PsLayeredFilter other = (PsLayeredFilter) object;
        if ((this.idLayeredFilter == null && other.idLayeredFilter != null) || (this.idLayeredFilter != null && !this.idLayeredFilter.equals(other.idLayeredFilter))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsLayeredFilter[ idLayeredFilter=" + idLayeredFilter + " ]";
    }
    
}
