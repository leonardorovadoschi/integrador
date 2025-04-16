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
@Table(name = "ps_anproducttabs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnproducttabs.findAll", query = "SELECT p FROM PsAnproducttabs p")})
public class PsAnproducttabs implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_anproducttabs")
    private Integer idAnproducttabs;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @Column(name = "position")
    private int position;

    public PsAnproducttabs() {
    }

    public PsAnproducttabs(Integer idAnproducttabs) {
        this.idAnproducttabs = idAnproducttabs;
    }

    public PsAnproducttabs(Integer idAnproducttabs, String name, String type, int position) {
        this.idAnproducttabs = idAnproducttabs;
        this.name = name;
        this.type = type;
        this.position = position;
    }

    public Integer getIdAnproducttabs() {
        return idAnproducttabs;
    }

    public void setIdAnproducttabs(Integer idAnproducttabs) {
        this.idAnproducttabs = idAnproducttabs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        hash += (idAnproducttabs != null ? idAnproducttabs.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnproducttabs)) {
            return false;
        }
        PsAnproducttabs other = (PsAnproducttabs) object;
        if ((this.idAnproducttabs == null && other.idAnproducttabs != null) || (this.idAnproducttabs != null && !this.idAnproducttabs.equals(other.idAnproducttabs))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnproducttabs[ idAnproducttabs=" + idAnproducttabs + " ]";
    }
    
}
