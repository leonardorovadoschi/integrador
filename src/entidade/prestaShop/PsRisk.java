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
@Table(name = "ps_risk")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsRisk.findAll", query = "SELECT p FROM PsRisk p")
    , @NamedQuery(name = "PsRisk.findByIdRisk", query = "SELECT p FROM PsRisk p WHERE p.idRisk = :idRisk")
    , @NamedQuery(name = "PsRisk.findByPercent", query = "SELECT p FROM PsRisk p WHERE p.percent = :percent")
    , @NamedQuery(name = "PsRisk.findByColor", query = "SELECT p FROM PsRisk p WHERE p.color = :color")})
public class PsRisk implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_risk")
    private Integer idRisk;
    @Basic(optional = false)
    @Column(name = "percent")
    private short percent;
    @Column(name = "color")
    private String color;

    public PsRisk() {
    }

    public PsRisk(Integer idRisk) {
        this.idRisk = idRisk;
    }

    public PsRisk(Integer idRisk, short percent) {
        this.idRisk = idRisk;
        this.percent = percent;
    }

    public Integer getIdRisk() {
        return idRisk;
    }

    public void setIdRisk(Integer idRisk) {
        this.idRisk = idRisk;
    }

    public short getPercent() {
        return percent;
    }

    public void setPercent(short percent) {
        this.percent = percent;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRisk != null ? idRisk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsRisk)) {
            return false;
        }
        PsRisk other = (PsRisk) object;
        if ((this.idRisk == null && other.idRisk != null) || (this.idRisk != null && !this.idRisk.equals(other.idRisk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsRisk[ idRisk=" + idRisk + " ]";
    }
    
}
