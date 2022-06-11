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
@Table(name = "ps_shop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsShop.findAll", query = "SELECT p FROM PsShop p")
    , @NamedQuery(name = "PsShop.findByIdShop", query = "SELECT p FROM PsShop p WHERE p.idShop = :idShop")
    , @NamedQuery(name = "PsShop.findByIdShopGroup", query = "SELECT p FROM PsShop p WHERE p.idShopGroup = :idShopGroup")
    , @NamedQuery(name = "PsShop.findByName", query = "SELECT p FROM PsShop p WHERE p.name = :name")
    , @NamedQuery(name = "PsShop.findByIdCategory", query = "SELECT p FROM PsShop p WHERE p.idCategory = :idCategory")
    , @NamedQuery(name = "PsShop.findByThemeName", query = "SELECT p FROM PsShop p WHERE p.themeName = :themeName")
    , @NamedQuery(name = "PsShop.findByActive", query = "SELECT p FROM PsShop p WHERE p.active = :active")
    , @NamedQuery(name = "PsShop.findByDeleted", query = "SELECT p FROM PsShop p WHERE p.deleted = :deleted")})
public class PsShop implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_shop")
    private Integer idShop;
    @Basic(optional = false)
    @Column(name = "id_shop_group")
    private int idShopGroup;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "id_category")
    private int idCategory;
    @Basic(optional = false)
    @Column(name = "theme_name")
    private String themeName;
    @Basic(optional = false)
    @Column(name = "active")
    private boolean active;
    @Basic(optional = false)
    @Column(name = "deleted")
    private boolean deleted;

    public PsShop() {
    }

    public PsShop(Integer idShop) {
        this.idShop = idShop;
    }

    public PsShop(Integer idShop, int idShopGroup, String name, int idCategory, String themeName, boolean active, boolean deleted) {
        this.idShop = idShop;
        this.idShopGroup = idShopGroup;
        this.name = name;
        this.idCategory = idCategory;
        this.themeName = themeName;
        this.active = active;
        this.deleted = deleted;
    }

    public Integer getIdShop() {
        return idShop;
    }

    public void setIdShop(Integer idShop) {
        this.idShop = idShop;
    }

    public int getIdShopGroup() {
        return idShopGroup;
    }

    public void setIdShopGroup(int idShopGroup) {
        this.idShopGroup = idShopGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idShop != null ? idShop.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsShop)) {
            return false;
        }
        PsShop other = (PsShop) object;
        if ((this.idShop == null && other.idShop != null) || (this.idShop != null && !this.idShop.equals(other.idShop))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsShop[ idShop=" + idShop + " ]";
    }
    
}
