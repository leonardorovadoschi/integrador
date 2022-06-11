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
@Table(name = "ps_category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsCategory.findAll", query = "SELECT p FROM PsCategory p")
    , @NamedQuery(name = "PsCategory.findByIdCategory", query = "SELECT p FROM PsCategory p WHERE p.idCategory = :idCategory")
    , @NamedQuery(name = "PsCategory.findByIdParent", query = "SELECT p FROM PsCategory p WHERE p.idParent = :idParent")
    , @NamedQuery(name = "PsCategory.findByIdShopDefault", query = "SELECT p FROM PsCategory p WHERE p.idShopDefault = :idShopDefault")
    , @NamedQuery(name = "PsCategory.findByLevelDepth", query = "SELECT p FROM PsCategory p WHERE p.levelDepth = :levelDepth")
    , @NamedQuery(name = "PsCategory.findByNleft", query = "SELECT p FROM PsCategory p WHERE p.nleft = :nleft")
    , @NamedQuery(name = "PsCategory.findByNright", query = "SELECT p FROM PsCategory p WHERE p.nright = :nright")
    , @NamedQuery(name = "PsCategory.findByActive", query = "SELECT p FROM PsCategory p WHERE p.active = :active")
    , @NamedQuery(name = "PsCategory.findByDateAdd", query = "SELECT p FROM PsCategory p WHERE p.dateAdd = :dateAdd")
    , @NamedQuery(name = "PsCategory.findByDateUpd", query = "SELECT p FROM PsCategory p WHERE p.dateUpd = :dateUpd")
    , @NamedQuery(name = "PsCategory.findByPosition", query = "SELECT p FROM PsCategory p WHERE p.position = :position")
    , @NamedQuery(name = "PsCategory.findByIsRootCategory", query = "SELECT p FROM PsCategory p WHERE p.isRootCategory = :isRootCategory")})
public class PsCategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_category")
    private Integer idCategory;
    @Basic(optional = false)
    @Column(name = "id_parent")
    private int idParent;
    @Basic(optional = false)
    @Column(name = "id_shop_default")
    private int idShopDefault;
    @Basic(optional = false)
    @Column(name = "level_depth")
    private short levelDepth;
    @Basic(optional = false)
    @Column(name = "nleft")
    private int nleft;
    @Basic(optional = false)
    @Column(name = "nright")
    private int nright;
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
    @Basic(optional = false)
    @Column(name = "is_root_category")
    private boolean isRootCategory;

    public PsCategory() {
    }

    public PsCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public PsCategory(Integer idCategory, int idParent, int idShopDefault, short levelDepth, int nleft, int nright, boolean active, Date dateAdd, Date dateUpd, int position, boolean isRootCategory) {
        this.idCategory = idCategory;
        this.idParent = idParent;
        this.idShopDefault = idShopDefault;
        this.levelDepth = levelDepth;
        this.nleft = nleft;
        this.nright = nright;
        this.active = active;
        this.dateAdd = dateAdd;
        this.dateUpd = dateUpd;
        this.position = position;
        this.isRootCategory = isRootCategory;
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public int getIdParent() {
        return idParent;
    }

    public void setIdParent(int idParent) {
        this.idParent = idParent;
    }

    public int getIdShopDefault() {
        return idShopDefault;
    }

    public void setIdShopDefault(int idShopDefault) {
        this.idShopDefault = idShopDefault;
    }

    public short getLevelDepth() {
        return levelDepth;
    }

    public void setLevelDepth(short levelDepth) {
        this.levelDepth = levelDepth;
    }

    public int getNleft() {
        return nleft;
    }

    public void setNleft(int nleft) {
        this.nleft = nleft;
    }

    public int getNright() {
        return nright;
    }

    public void setNright(int nright) {
        this.nright = nright;
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

    public boolean getIsRootCategory() {
        return isRootCategory;
    }

    public void setIsRootCategory(boolean isRootCategory) {
        this.isRootCategory = isRootCategory;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategory != null ? idCategory.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCategory)) {
            return false;
        }
        PsCategory other = (PsCategory) object;
        if ((this.idCategory == null && other.idCategory != null) || (this.idCategory != null && !this.idCategory.equals(other.idCategory))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCategory[ idCategory=" + idCategory + " ]";
    }
    
}
