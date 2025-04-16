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
@Table(name = "ps_an_advantages")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnAdvantages.findAll", query = "SELECT p FROM PsAnAdvantages p")})
public class PsAnAdvantages implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_advantage")
    private Integer idAdvantage;
    @Basic(optional = false)
    @Column(name = "image")
    private String image;
    @Basic(optional = false)
    @Column(name = "active")
    private short active;
    @Basic(optional = false)
    @Column(name = "position")
    private int position;
    @Basic(optional = false)
    @Column(name = "width")
    private int width;
    @Basic(optional = false)
    @Column(name = "height")
    private int height;

    public PsAnAdvantages() {
    }

    public PsAnAdvantages(Integer idAdvantage) {
        this.idAdvantage = idAdvantage;
    }

    public PsAnAdvantages(Integer idAdvantage, String image, short active, int position, int width, int height) {
        this.idAdvantage = idAdvantage;
        this.image = image;
        this.active = active;
        this.position = position;
        this.width = width;
        this.height = height;
    }

    public Integer getIdAdvantage() {
        return idAdvantage;
    }

    public void setIdAdvantage(Integer idAdvantage) {
        this.idAdvantage = idAdvantage;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAdvantage != null ? idAdvantage.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnAdvantages)) {
            return false;
        }
        PsAnAdvantages other = (PsAnAdvantages) object;
        if ((this.idAdvantage == null && other.idAdvantage != null) || (this.idAdvantage != null && !this.idAdvantage.equals(other.idAdvantage))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnAdvantages[ idAdvantage=" + idAdvantage + " ]";
    }
    
}
