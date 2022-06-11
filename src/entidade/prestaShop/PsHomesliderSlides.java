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
@Table(name = "ps_homeslider_slides")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsHomesliderSlides.findAll", query = "SELECT p FROM PsHomesliderSlides p")
    , @NamedQuery(name = "PsHomesliderSlides.findByIdHomesliderSlides", query = "SELECT p FROM PsHomesliderSlides p WHERE p.idHomesliderSlides = :idHomesliderSlides")
    , @NamedQuery(name = "PsHomesliderSlides.findByPosition", query = "SELECT p FROM PsHomesliderSlides p WHERE p.position = :position")
    , @NamedQuery(name = "PsHomesliderSlides.findByActive", query = "SELECT p FROM PsHomesliderSlides p WHERE p.active = :active")})
public class PsHomesliderSlides implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_homeslider_slides")
    private Integer idHomesliderSlides;
    @Basic(optional = false)
    @Column(name = "position")
    private int position;
    @Basic(optional = false)
    @Column(name = "active")
    private boolean active;

    public PsHomesliderSlides() {
    }

    public PsHomesliderSlides(Integer idHomesliderSlides) {
        this.idHomesliderSlides = idHomesliderSlides;
    }

    public PsHomesliderSlides(Integer idHomesliderSlides, int position, boolean active) {
        this.idHomesliderSlides = idHomesliderSlides;
        this.position = position;
        this.active = active;
    }

    public Integer getIdHomesliderSlides() {
        return idHomesliderSlides;
    }

    public void setIdHomesliderSlides(Integer idHomesliderSlides) {
        this.idHomesliderSlides = idHomesliderSlides;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHomesliderSlides != null ? idHomesliderSlides.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsHomesliderSlides)) {
            return false;
        }
        PsHomesliderSlides other = (PsHomesliderSlides) object;
        if ((this.idHomesliderSlides == null && other.idHomesliderSlides != null) || (this.idHomesliderSlides != null && !this.idHomesliderSlides.equals(other.idHomesliderSlides))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsHomesliderSlides[ idHomesliderSlides=" + idHomesliderSlides + " ]";
    }
    
}
