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
@Table(name = "ps_meta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsMeta.findAll", query = "SELECT p FROM PsMeta p")
    , @NamedQuery(name = "PsMeta.findByIdMeta", query = "SELECT p FROM PsMeta p WHERE p.idMeta = :idMeta")
    , @NamedQuery(name = "PsMeta.findByPage", query = "SELECT p FROM PsMeta p WHERE p.page = :page")
    , @NamedQuery(name = "PsMeta.findByConfigurable", query = "SELECT p FROM PsMeta p WHERE p.configurable = :configurable")})
public class PsMeta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_meta")
    private Integer idMeta;
    @Basic(optional = false)
    @Column(name = "page")
    private String page;
    @Basic(optional = false)
    @Column(name = "configurable")
    private boolean configurable;

    public PsMeta() {
    }

    public PsMeta(Integer idMeta) {
        this.idMeta = idMeta;
    }

    public PsMeta(Integer idMeta, String page, boolean configurable) {
        this.idMeta = idMeta;
        this.page = page;
        this.configurable = configurable;
    }

    public Integer getIdMeta() {
        return idMeta;
    }

    public void setIdMeta(Integer idMeta) {
        this.idMeta = idMeta;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public boolean getConfigurable() {
        return configurable;
    }

    public void setConfigurable(boolean configurable) {
        this.configurable = configurable;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMeta != null ? idMeta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsMeta)) {
            return false;
        }
        PsMeta other = (PsMeta) object;
        if ((this.idMeta == null && other.idMeta != null) || (this.idMeta != null && !this.idMeta.equals(other.idMeta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsMeta[ idMeta=" + idMeta + " ]";
    }
    
}
