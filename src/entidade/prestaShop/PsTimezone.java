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
@Table(name = "ps_timezone")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsTimezone.findAll", query = "SELECT p FROM PsTimezone p")
    , @NamedQuery(name = "PsTimezone.findByIdTimezone", query = "SELECT p FROM PsTimezone p WHERE p.idTimezone = :idTimezone")
    , @NamedQuery(name = "PsTimezone.findByName", query = "SELECT p FROM PsTimezone p WHERE p.name = :name")})
public class PsTimezone implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_timezone")
    private Integer idTimezone;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    public PsTimezone() {
    }

    public PsTimezone(Integer idTimezone) {
        this.idTimezone = idTimezone;
    }

    public PsTimezone(Integer idTimezone, String name) {
        this.idTimezone = idTimezone;
        this.name = name;
    }

    public Integer getIdTimezone() {
        return idTimezone;
    }

    public void setIdTimezone(Integer idTimezone) {
        this.idTimezone = idTimezone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTimezone != null ? idTimezone.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsTimezone)) {
            return false;
        }
        PsTimezone other = (PsTimezone) object;
        if ((this.idTimezone == null && other.idTimezone != null) || (this.idTimezone != null && !this.idTimezone.equals(other.idTimezone))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsTimezone[ idTimezone=" + idTimezone + " ]";
    }
    
}
