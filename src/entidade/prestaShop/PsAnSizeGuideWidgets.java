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
@Table(name = "ps_an_size_guide_widgets")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnSizeGuideWidgets.findAll", query = "SELECT p FROM PsAnSizeGuideWidgets p")})
public class PsAnSizeGuideWidgets implements Serializable {
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
    @Column(name = "relation")
    private int relation;
    @Basic(optional = false)
    @Column(name = "show_on")
    private int showOn;

    public PsAnSizeGuideWidgets() {
    }

    public PsAnSizeGuideWidgets(Integer idWidget) {
        this.idWidget = idWidget;
    }

    public PsAnSizeGuideWidgets(Integer idWidget, short active, int position, int relation, int showOn) {
        this.idWidget = idWidget;
        this.active = active;
        this.position = position;
        this.relation = relation;
        this.showOn = showOn;
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

    public int getRelation() {
        return relation;
    }

    public void setRelation(int relation) {
        this.relation = relation;
    }

    public int getShowOn() {
        return showOn;
    }

    public void setShowOn(int showOn) {
        this.showOn = showOn;
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
        if (!(object instanceof PsAnSizeGuideWidgets)) {
            return false;
        }
        PsAnSizeGuideWidgets other = (PsAnSizeGuideWidgets) object;
        if ((this.idWidget == null && other.idWidget != null) || (this.idWidget != null && !this.idWidget.equals(other.idWidget))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnSizeGuideWidgets[ idWidget=" + idWidget + " ]";
    }
    
}
