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
@Table(name = "ps_an_homeslider_slides")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnHomesliderSlides.findAll", query = "SELECT p FROM PsAnHomesliderSlides p")})
public class PsAnHomesliderSlides implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_slide")
    private Integer idSlide;
    @Basic(optional = false)
    @Column(name = "id_parent")
    private int idParent;
    @Basic(optional = false)
    @Column(name = "active")
    private short active;
    @Basic(optional = false)
    @Column(name = "show_button")
    private short showButton;
    @Basic(optional = false)
    @Column(name = "position")
    private int position;

    public PsAnHomesliderSlides() {
    }

    public PsAnHomesliderSlides(Integer idSlide) {
        this.idSlide = idSlide;
    }

    public PsAnHomesliderSlides(Integer idSlide, int idParent, short active, short showButton, int position) {
        this.idSlide = idSlide;
        this.idParent = idParent;
        this.active = active;
        this.showButton = showButton;
        this.position = position;
    }

    public Integer getIdSlide() {
        return idSlide;
    }

    public void setIdSlide(Integer idSlide) {
        this.idSlide = idSlide;
    }

    public int getIdParent() {
        return idParent;
    }

    public void setIdParent(int idParent) {
        this.idParent = idParent;
    }

    public short getActive() {
        return active;
    }

    public void setActive(short active) {
        this.active = active;
    }

    public short getShowButton() {
        return showButton;
    }

    public void setShowButton(short showButton) {
        this.showButton = showButton;
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
        hash += (idSlide != null ? idSlide.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnHomesliderSlides)) {
            return false;
        }
        PsAnHomesliderSlides other = (PsAnHomesliderSlides) object;
        if ((this.idSlide == null && other.idSlide != null) || (this.idSlide != null && !this.idSlide.equals(other.idSlide))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnHomesliderSlides[ idSlide=" + idSlide + " ]";
    }
    
}
