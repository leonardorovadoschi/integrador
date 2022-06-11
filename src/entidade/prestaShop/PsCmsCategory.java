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
@Table(name = "ps_cms_category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsCmsCategory.findAll", query = "SELECT p FROM PsCmsCategory p")
    , @NamedQuery(name = "PsCmsCategory.findByIdCmsCategory", query = "SELECT p FROM PsCmsCategory p WHERE p.idCmsCategory = :idCmsCategory")
    , @NamedQuery(name = "PsCmsCategory.findByIdParent", query = "SELECT p FROM PsCmsCategory p WHERE p.idParent = :idParent")
    , @NamedQuery(name = "PsCmsCategory.findByLevelDepth", query = "SELECT p FROM PsCmsCategory p WHERE p.levelDepth = :levelDepth")
    , @NamedQuery(name = "PsCmsCategory.findByActive", query = "SELECT p FROM PsCmsCategory p WHERE p.active = :active")
    , @NamedQuery(name = "PsCmsCategory.findByDateAdd", query = "SELECT p FROM PsCmsCategory p WHERE p.dateAdd = :dateAdd")
    , @NamedQuery(name = "PsCmsCategory.findByDateUpd", query = "SELECT p FROM PsCmsCategory p WHERE p.dateUpd = :dateUpd")
    , @NamedQuery(name = "PsCmsCategory.findByPosition", query = "SELECT p FROM PsCmsCategory p WHERE p.position = :position")})
public class PsCmsCategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cms_category")
    private Integer idCmsCategory;
    @Basic(optional = false)
    @Column(name = "id_parent")
    private int idParent;
    @Basic(optional = false)
    @Column(name = "level_depth")
    private short levelDepth;
    @Basic(optional = false)
    @Column(name = "active")
    private boolean active;
    @Basic(optional = false)
    @Column(name = "date_add")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdd;
    @Basic(optional = false)
    @Column(name = "date_upd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpd;
    @Basic(optional = false)
    @Column(name = "position")
    private int position;

    public PsCmsCategory() {
    }

    public PsCmsCategory(Integer idCmsCategory) {
        this.idCmsCategory = idCmsCategory;
    }

    public PsCmsCategory(Integer idCmsCategory, int idParent, short levelDepth, boolean active, Date dateAdd, Date dateUpd, int position) {
        this.idCmsCategory = idCmsCategory;
        this.idParent = idParent;
        this.levelDepth = levelDepth;
        this.active = active;
        this.dateAdd = dateAdd;
        this.dateUpd = dateUpd;
        this.position = position;
    }

    public Integer getIdCmsCategory() {
        return idCmsCategory;
    }

    public void setIdCmsCategory(Integer idCmsCategory) {
        this.idCmsCategory = idCmsCategory;
    }

    public int getIdParent() {
        return idParent;
    }

    public void setIdParent(int idParent) {
        this.idParent = idParent;
    }

    public short getLevelDepth() {
        return levelDepth;
    }

    public void setLevelDepth(short levelDepth) {
        this.levelDepth = levelDepth;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCmsCategory != null ? idCmsCategory.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCmsCategory)) {
            return false;
        }
        PsCmsCategory other = (PsCmsCategory) object;
        if ((this.idCmsCategory == null && other.idCmsCategory != null) || (this.idCmsCategory != null && !this.idCmsCategory.equals(other.idCmsCategory))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCmsCategory[ idCmsCategory=" + idCmsCategory + " ]";
    }
    
}
