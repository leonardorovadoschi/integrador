/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.prestaShop;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ps_smarty_cache")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsSmartyCache.findAll", query = "SELECT p FROM PsSmartyCache p")
    , @NamedQuery(name = "PsSmartyCache.findByIdSmartyCache", query = "SELECT p FROM PsSmartyCache p WHERE p.idSmartyCache = :idSmartyCache")
    , @NamedQuery(name = "PsSmartyCache.findByName", query = "SELECT p FROM PsSmartyCache p WHERE p.name = :name")
    , @NamedQuery(name = "PsSmartyCache.findByCacheId", query = "SELECT p FROM PsSmartyCache p WHERE p.cacheId = :cacheId")
    , @NamedQuery(name = "PsSmartyCache.findByModified", query = "SELECT p FROM PsSmartyCache p WHERE p.modified = :modified")})
public class PsSmartyCache implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_smarty_cache")
    private String idSmartyCache;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "cache_id")
    private String cacheId;
    @Basic(optional = false)
    @Column(name = "modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modified;
    @Basic(optional = false)
    @Lob
    @Column(name = "content")
    private String content;

    public PsSmartyCache() {
    }

    public PsSmartyCache(String idSmartyCache) {
        this.idSmartyCache = idSmartyCache;
    }

    public PsSmartyCache(String idSmartyCache, String name, Date modified, String content) {
        this.idSmartyCache = idSmartyCache;
        this.name = name;
        this.modified = modified;
        this.content = content;
    }

    public String getIdSmartyCache() {
        return idSmartyCache;
    }

    public void setIdSmartyCache(String idSmartyCache) {
        this.idSmartyCache = idSmartyCache;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCacheId() {
        return cacheId;
    }

    public void setCacheId(String cacheId) {
        this.cacheId = cacheId;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSmartyCache != null ? idSmartyCache.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsSmartyCache)) {
            return false;
        }
        PsSmartyCache other = (PsSmartyCache) object;
        if ((this.idSmartyCache == null && other.idSmartyCache != null) || (this.idSmartyCache != null && !this.idSmartyCache.equals(other.idSmartyCache))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsSmartyCache[ idSmartyCache=" + idSmartyCache + " ]";
    }
    
}
