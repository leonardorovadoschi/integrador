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
@Table(name = "ps_alias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAlias.findAll", query = "SELECT p FROM PsAlias p")
    , @NamedQuery(name = "PsAlias.findByIdAlias", query = "SELECT p FROM PsAlias p WHERE p.idAlias = :idAlias")
    , @NamedQuery(name = "PsAlias.findByAlias", query = "SELECT p FROM PsAlias p WHERE p.alias = :alias")
    , @NamedQuery(name = "PsAlias.findBySearch", query = "SELECT p FROM PsAlias p WHERE p.search = :search")
    , @NamedQuery(name = "PsAlias.findByActive", query = "SELECT p FROM PsAlias p WHERE p.active = :active")})
public class PsAlias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_alias")
    private Integer idAlias;
    @Basic(optional = false)
    @Column(name = "alias")
    private String alias;
    @Basic(optional = false)
    @Column(name = "search")
    private String search;
    @Basic(optional = false)
    @Column(name = "active")
    private boolean active;

    public PsAlias() {
    }

    public PsAlias(Integer idAlias) {
        this.idAlias = idAlias;
    }

    public PsAlias(Integer idAlias, String alias, String search, boolean active) {
        this.idAlias = idAlias;
        this.alias = alias;
        this.search = search;
        this.active = active;
    }

    public Integer getIdAlias() {
        return idAlias;
    }

    public void setIdAlias(Integer idAlias) {
        this.idAlias = idAlias;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
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
        hash += (idAlias != null ? idAlias.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAlias)) {
            return false;
        }
        PsAlias other = (PsAlias) object;
        if ((this.idAlias == null && other.idAlias != null) || (this.idAlias != null && !this.idAlias.equals(other.idAlias))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAlias[ idAlias=" + idAlias + " ]";
    }
    
}
