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
@Table(name = "ps_hook_alias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsHookAlias.findAll", query = "SELECT p FROM PsHookAlias p")
    , @NamedQuery(name = "PsHookAlias.findByIdHookAlias", query = "SELECT p FROM PsHookAlias p WHERE p.idHookAlias = :idHookAlias")
    , @NamedQuery(name = "PsHookAlias.findByAlias", query = "SELECT p FROM PsHookAlias p WHERE p.alias = :alias")
    , @NamedQuery(name = "PsHookAlias.findByName", query = "SELECT p FROM PsHookAlias p WHERE p.name = :name")})
public class PsHookAlias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_hook_alias")
    private Integer idHookAlias;
    @Basic(optional = false)
    @Column(name = "alias")
    private String alias;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    public PsHookAlias() {
    }

    public PsHookAlias(Integer idHookAlias) {
        this.idHookAlias = idHookAlias;
    }

    public PsHookAlias(Integer idHookAlias, String alias, String name) {
        this.idHookAlias = idHookAlias;
        this.alias = alias;
        this.name = name;
    }

    public Integer getIdHookAlias() {
        return idHookAlias;
    }

    public void setIdHookAlias(Integer idHookAlias) {
        this.idHookAlias = idHookAlias;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
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
        hash += (idHookAlias != null ? idHookAlias.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsHookAlias)) {
            return false;
        }
        PsHookAlias other = (PsHookAlias) object;
        if ((this.idHookAlias == null && other.idHookAlias != null) || (this.idHookAlias != null && !this.idHookAlias.equals(other.idHookAlias))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsHookAlias[ idHookAlias=" + idHookAlias + " ]";
    }
    
}
