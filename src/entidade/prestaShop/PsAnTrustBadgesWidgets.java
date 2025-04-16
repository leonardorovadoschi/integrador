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
 * @author leo-note
 */
@Entity
@Table(name = "ps_an_trust_badges_widgets")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnTrustBadgesWidgets.findAll", query = "SELECT p FROM PsAnTrustBadgesWidgets p")})
public class PsAnTrustBadgesWidgets implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_widget")
    private Integer idWidget;
    @Basic(optional = false)
    @Column(name = "active")
    private short active;
    @Basic(optional = false)
    @Column(name = "position")
    private int position;
    @Basic(optional = false)
    @Column(name = "hook")
    private String hook;
    @Basic(optional = false)
    @Column(name = "class")
    private String class1;

    public PsAnTrustBadgesWidgets() {
    }

    public PsAnTrustBadgesWidgets(Integer idWidget) {
        this.idWidget = idWidget;
    }

    public PsAnTrustBadgesWidgets(Integer idWidget, short active, int position, String hook, String class1) {
        this.idWidget = idWidget;
        this.active = active;
        this.position = position;
        this.hook = hook;
        this.class1 = class1;
    }

    public Integer getIdWidget() {
        return idWidget;
    }

    public void setIdWidget(Integer idWidget) {
        this.idWidget = idWidget;
    }

    public short getActive() {
        return active;
    }

    public void setActive(short active) {
        this.active = active;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getHook() {
        return hook;
    }

    public void setHook(String hook) {
        this.hook = hook;
    }

    public String getClass1() {
        return class1;
    }

    public void setClass1(String class1) {
        this.class1 = class1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idWidget != null ? idWidget.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnTrustBadgesWidgets)) {
            return false;
        }
        PsAnTrustBadgesWidgets other = (PsAnTrustBadgesWidgets) object;
        if ((this.idWidget == null && other.idWidget != null) || (this.idWidget != null && !this.idWidget.equals(other.idWidget))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnTrustBadgesWidgets[ idWidget=" + idWidget + " ]";
    }
    
}
