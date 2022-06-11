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
@Table(name = "ps_tab")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsTab.findAll", query = "SELECT p FROM PsTab p")
    , @NamedQuery(name = "PsTab.findByIdTab", query = "SELECT p FROM PsTab p WHERE p.idTab = :idTab")
    , @NamedQuery(name = "PsTab.findByIdParent", query = "SELECT p FROM PsTab p WHERE p.idParent = :idParent")
    , @NamedQuery(name = "PsTab.findByPosition", query = "SELECT p FROM PsTab p WHERE p.position = :position")
    , @NamedQuery(name = "PsTab.findByModule", query = "SELECT p FROM PsTab p WHERE p.module = :module")
    , @NamedQuery(name = "PsTab.findByClassName", query = "SELECT p FROM PsTab p WHERE p.className = :className")
    , @NamedQuery(name = "PsTab.findByActive", query = "SELECT p FROM PsTab p WHERE p.active = :active")
    , @NamedQuery(name = "PsTab.findByHideHostMode", query = "SELECT p FROM PsTab p WHERE p.hideHostMode = :hideHostMode")
    , @NamedQuery(name = "PsTab.findByIcon", query = "SELECT p FROM PsTab p WHERE p.icon = :icon")})
public class PsTab implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tab")
    private Integer idTab;
    @Basic(optional = false)
    @Column(name = "id_parent")
    private int idParent;
    @Basic(optional = false)
    @Column(name = "position")
    private int position;
    @Column(name = "module")
    private String module;
    @Column(name = "class_name")
    private String className;
    @Basic(optional = false)
    @Column(name = "active")
    private boolean active;
    @Basic(optional = false)
    @Column(name = "hide_host_mode")
    private boolean hideHostMode;
    @Column(name = "icon")
    private String icon;

    public PsTab() {
    }

    public PsTab(Integer idTab) {
        this.idTab = idTab;
    }

    public PsTab(Integer idTab, int idParent, int position, boolean active, boolean hideHostMode) {
        this.idTab = idTab;
        this.idParent = idParent;
        this.position = position;
        this.active = active;
        this.hideHostMode = hideHostMode;
    }

    public Integer getIdTab() {
        return idTab;
    }

    public void setIdTab(Integer idTab) {
        this.idTab = idTab;
    }

    public int getIdParent() {
        return idParent;
    }

    public void setIdParent(int idParent) {
        this.idParent = idParent;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean getHideHostMode() {
        return hideHostMode;
    }

    public void setHideHostMode(boolean hideHostMode) {
        this.hideHostMode = hideHostMode;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTab != null ? idTab.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsTab)) {
            return false;
        }
        PsTab other = (PsTab) object;
        if ((this.idTab == null && other.idTab != null) || (this.idTab != null && !this.idTab.equals(other.idTab))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsTab[ idTab=" + idTab + " ]";
    }
    
}
