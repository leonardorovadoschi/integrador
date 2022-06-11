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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "ps_smarty_lazy_cache")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsSmartyLazyCache.findAll", query = "SELECT p FROM PsSmartyLazyCache p")
    , @NamedQuery(name = "PsSmartyLazyCache.findByTemplateHash", query = "SELECT p FROM PsSmartyLazyCache p WHERE p.psSmartyLazyCachePK.templateHash = :templateHash")
    , @NamedQuery(name = "PsSmartyLazyCache.findByCacheId", query = "SELECT p FROM PsSmartyLazyCache p WHERE p.psSmartyLazyCachePK.cacheId = :cacheId")
    , @NamedQuery(name = "PsSmartyLazyCache.findByCompileId", query = "SELECT p FROM PsSmartyLazyCache p WHERE p.psSmartyLazyCachePK.compileId = :compileId")
    , @NamedQuery(name = "PsSmartyLazyCache.findByFilepath", query = "SELECT p FROM PsSmartyLazyCache p WHERE p.filepath = :filepath")
    , @NamedQuery(name = "PsSmartyLazyCache.findByLastUpdate", query = "SELECT p FROM PsSmartyLazyCache p WHERE p.lastUpdate = :lastUpdate")})
public class PsSmartyLazyCache implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsSmartyLazyCachePK psSmartyLazyCachePK;
    @Basic(optional = false)
    @Column(name = "filepath")
    private String filepath;
    @Basic(optional = false)
    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;

    public PsSmartyLazyCache() {
    }

    public PsSmartyLazyCache(PsSmartyLazyCachePK psSmartyLazyCachePK) {
        this.psSmartyLazyCachePK = psSmartyLazyCachePK;
    }

    public PsSmartyLazyCache(PsSmartyLazyCachePK psSmartyLazyCachePK, String filepath, Date lastUpdate) {
        this.psSmartyLazyCachePK = psSmartyLazyCachePK;
        this.filepath = filepath;
        this.lastUpdate = lastUpdate;
    }

    public PsSmartyLazyCache(String templateHash, String cacheId, String compileId) {
        this.psSmartyLazyCachePK = new PsSmartyLazyCachePK(templateHash, cacheId, compileId);
    }

    public PsSmartyLazyCachePK getPsSmartyLazyCachePK() {
        return psSmartyLazyCachePK;
    }

    public void setPsSmartyLazyCachePK(PsSmartyLazyCachePK psSmartyLazyCachePK) {
        this.psSmartyLazyCachePK = psSmartyLazyCachePK;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psSmartyLazyCachePK != null ? psSmartyLazyCachePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsSmartyLazyCache)) {
            return false;
        }
        PsSmartyLazyCache other = (PsSmartyLazyCache) object;
        if ((this.psSmartyLazyCachePK == null && other.psSmartyLazyCachePK != null) || (this.psSmartyLazyCachePK != null && !this.psSmartyLazyCachePK.equals(other.psSmartyLazyCachePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsSmartyLazyCache[ psSmartyLazyCachePK=" + psSmartyLazyCachePK + " ]";
    }
    
}
