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
@Table(name = "ps_an_productextratabs_labels")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnProductextratabsLabels.findAll", query = "SELECT p FROM PsAnProductextratabsLabels p")})
public class PsAnProductextratabsLabels implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_label")
    private Integer idLabel;
    @Basic(optional = false)
    @Column(name = "special_id_label")
    private String specialIdLabel;
    @Basic(optional = false)
    @Column(name = "active")
    private short active;
    @Basic(optional = false)
    @Column(name = "color")
    private String color;
    @Basic(optional = false)
    @Column(name = "color_background")
    private String colorBackground;
    @Basic(optional = false)
    @Column(name = "relation")
    private int relation;
    @Basic(optional = false)
    @Column(name = "position")
    private int position;

    public PsAnProductextratabsLabels() {
    }

    public PsAnProductextratabsLabels(Integer idLabel) {
        this.idLabel = idLabel;
    }

    public PsAnProductextratabsLabels(Integer idLabel, String specialIdLabel, short active, String color, String colorBackground, int relation, int position) {
        this.idLabel = idLabel;
        this.specialIdLabel = specialIdLabel;
        this.active = active;
        this.color = color;
        this.colorBackground = colorBackground;
        this.relation = relation;
        this.position = position;
    }

    public Integer getIdLabel() {
        return idLabel;
    }

    public void setIdLabel(Integer idLabel) {
        this.idLabel = idLabel;
    }

    public String getSpecialIdLabel() {
        return specialIdLabel;
    }

    public void setSpecialIdLabel(String specialIdLabel) {
        this.specialIdLabel = specialIdLabel;
    }

    public short getActive() {
        return active;
    }

    public void setActive(short active) {
        this.active = active;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColorBackground() {
        return colorBackground;
    }

    public void setColorBackground(String colorBackground) {
        this.colorBackground = colorBackground;
    }

    public int getRelation() {
        return relation;
    }

    public void setRelation(int relation) {
        this.relation = relation;
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
        hash += (idLabel != null ? idLabel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnProductextratabsLabels)) {
            return false;
        }
        PsAnProductextratabsLabels other = (PsAnProductextratabsLabels) object;
        if ((this.idLabel == null && other.idLabel != null) || (this.idLabel != null && !this.idLabel.equals(other.idLabel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnProductextratabsLabels[ idLabel=" + idLabel + " ]";
    }
    
}
