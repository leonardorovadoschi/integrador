/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.prestaShop;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author leo
 */
@Embeddable
public class PsSmartyLazyCachePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "template_hash")
    private String templateHash;
    @Basic(optional = false)
    @Column(name = "cache_id")
    private String cacheId;
    @Basic(optional = false)
    @Column(name = "compile_id")
    private String compileId;

    public PsSmartyLazyCachePK() {
    }

    public PsSmartyLazyCachePK(String templateHash, String cacheId, String compileId) {
        this.templateHash = templateHash;
        this.cacheId = cacheId;
        this.compileId = compileId;
    }

    public String getTemplateHash() {
        return templateHash;
    }

    public void setTemplateHash(String templateHash) {
        this.templateHash = templateHash;
    }

    public String getCacheId() {
        return cacheId;
    }

    public void setCacheId(String cacheId) {
        this.cacheId = cacheId;
    }

    public String getCompileId() {
        return compileId;
    }

    public void setCompileId(String compileId) {
        this.compileId = compileId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (templateHash != null ? templateHash.hashCode() : 0);
        hash += (cacheId != null ? cacheId.hashCode() : 0);
        hash += (compileId != null ? compileId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsSmartyLazyCachePK)) {
            return false;
        }
        PsSmartyLazyCachePK other = (PsSmartyLazyCachePK) object;
        if ((this.templateHash == null && other.templateHash != null) || (this.templateHash != null && !this.templateHash.equals(other.templateHash))) {
            return false;
        }
        if ((this.cacheId == null && other.cacheId != null) || (this.cacheId != null && !this.cacheId.equals(other.cacheId))) {
            return false;
        }
        if ((this.compileId == null && other.compileId != null) || (this.compileId != null && !this.compileId.equals(other.compileId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsSmartyLazyCachePK[ templateHash=" + templateHash + ", cacheId=" + cacheId + ", compileId=" + compileId + " ]";
    }
    
}
