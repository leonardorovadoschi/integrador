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
@Table(name = "ps_layered_category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsLayeredCategory.findAll", query = "SELECT p FROM PsLayeredCategory p")
    , @NamedQuery(name = "PsLayeredCategory.findByIdLayeredCategory", query = "SELECT p FROM PsLayeredCategory p WHERE p.idLayeredCategory = :idLayeredCategory")
    , @NamedQuery(name = "PsLayeredCategory.findByIdShop", query = "SELECT p FROM PsLayeredCategory p WHERE p.idShop = :idShop")
    , @NamedQuery(name = "PsLayeredCategory.findByIdCategory", query = "SELECT p FROM PsLayeredCategory p WHERE p.idCategory = :idCategory")
    , @NamedQuery(name = "PsLayeredCategory.findByIdValue", query = "SELECT p FROM PsLayeredCategory p WHERE p.idValue = :idValue")
    , @NamedQuery(name = "PsLayeredCategory.findByType", query = "SELECT p FROM PsLayeredCategory p WHERE p.type = :type")
    , @NamedQuery(name = "PsLayeredCategory.findByPosition", query = "SELECT p FROM PsLayeredCategory p WHERE p.position = :position")
    , @NamedQuery(name = "PsLayeredCategory.findByFilterType", query = "SELECT p FROM PsLayeredCategory p WHERE p.filterType = :filterType")
    , @NamedQuery(name = "PsLayeredCategory.findByFilterShowLimit", query = "SELECT p FROM PsLayeredCategory p WHERE p.filterShowLimit = :filterShowLimit")})
public class PsLayeredCategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_layered_category")
    private Integer idLayeredCategory;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;
    @Basic(optional = false)
    @Column(name = "id_category")
    private int idCategory;
    @Column(name = "id_value")
    private Integer idValue;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @Column(name = "position")
    private int position;
    @Basic(optional = false)
    @Column(name = "filter_type")
    private int filterType;
    @Basic(optional = false)
    @Column(name = "filter_show_limit")
    private int filterShowLimit;

    public PsLayeredCategory() {
    }

    public PsLayeredCategory(Integer idLayeredCategory) {
        this.idLayeredCategory = idLayeredCategory;
    }

    public PsLayeredCategory(Integer idLayeredCategory, int idShop, int idCategory, String type, int position, int filterType, int filterShowLimit) {
        this.idLayeredCategory = idLayeredCategory;
        this.idShop = idShop;
        this.idCategory = idCategory;
        this.type = type;
        this.position = position;
        this.filterType = filterType;
        this.filterShowLimit = filterShowLimit;
    }

    public Integer getIdLayeredCategory() {
        return idLayeredCategory;
    }

    public void setIdLayeredCategory(Integer idLayeredCategory) {
        this.idLayeredCategory = idLayeredCategory;
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public Integer getIdValue() {
        return idValue;
    }

    public void setIdValue(Integer idValue) {
        this.idValue = idValue;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getFilterType() {
        return filterType;
    }

    public void setFilterType(int filterType) {
        this.filterType = filterType;
    }

    public int getFilterShowLimit() {
        return filterShowLimit;
    }

    public void setFilterShowLimit(int filterShowLimit) {
        this.filterShowLimit = filterShowLimit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLayeredCategory != null ? idLayeredCategory.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsLayeredCategory)) {
            return false;
        }
        PsLayeredCategory other = (PsLayeredCategory) object;
        if ((this.idLayeredCategory == null && other.idLayeredCategory != null) || (this.idLayeredCategory != null && !this.idLayeredCategory.equals(other.idLayeredCategory))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsLayeredCategory[ idLayeredCategory=" + idLayeredCategory + " ]";
    }
    
}
