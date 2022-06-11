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
@Table(name = "ps_gender")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsGender.findAll", query = "SELECT p FROM PsGender p")
    , @NamedQuery(name = "PsGender.findByIdGender", query = "SELECT p FROM PsGender p WHERE p.idGender = :idGender")
    , @NamedQuery(name = "PsGender.findByType", query = "SELECT p FROM PsGender p WHERE p.type = :type")})
public class PsGender implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_gender")
    private Integer idGender;
    @Basic(optional = false)
    @Column(name = "type")
    private boolean type;

    public PsGender() {
    }

    public PsGender(Integer idGender) {
        this.idGender = idGender;
    }

    public PsGender(Integer idGender, boolean type) {
        this.idGender = idGender;
        this.type = type;
    }

    public Integer getIdGender() {
        return idGender;
    }

    public void setIdGender(Integer idGender) {
        this.idGender = idGender;
    }

    public boolean getType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGender != null ? idGender.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsGender)) {
            return false;
        }
        PsGender other = (PsGender) object;
        if ((this.idGender == null && other.idGender != null) || (this.idGender != null && !this.idGender.equals(other.idGender))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsGender[ idGender=" + idGender + " ]";
    }
    
}
