/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.prestaShop;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ps_referrer_cache")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsReferrerCache.findAll", query = "SELECT p FROM PsReferrerCache p")
    , @NamedQuery(name = "PsReferrerCache.findByIdConnectionsSource", query = "SELECT p FROM PsReferrerCache p WHERE p.psReferrerCachePK.idConnectionsSource = :idConnectionsSource")
    , @NamedQuery(name = "PsReferrerCache.findByIdReferrer", query = "SELECT p FROM PsReferrerCache p WHERE p.psReferrerCachePK.idReferrer = :idReferrer")})
public class PsReferrerCache implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsReferrerCachePK psReferrerCachePK;

    public PsReferrerCache() {
    }

    public PsReferrerCache(PsReferrerCachePK psReferrerCachePK) {
        this.psReferrerCachePK = psReferrerCachePK;
    }

    public PsReferrerCache(int idConnectionsSource, int idReferrer) {
        this.psReferrerCachePK = new PsReferrerCachePK(idConnectionsSource, idReferrer);
    }

    public PsReferrerCachePK getPsReferrerCachePK() {
        return psReferrerCachePK;
    }

    public void setPsReferrerCachePK(PsReferrerCachePK psReferrerCachePK) {
        this.psReferrerCachePK = psReferrerCachePK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psReferrerCachePK != null ? psReferrerCachePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsReferrerCache)) {
            return false;
        }
        PsReferrerCache other = (PsReferrerCache) object;
        if ((this.psReferrerCachePK == null && other.psReferrerCachePK != null) || (this.psReferrerCachePK != null && !this.psReferrerCachePK.equals(other.psReferrerCachePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsReferrerCache[ psReferrerCachePK=" + psReferrerCachePK + " ]";
    }
    
}
