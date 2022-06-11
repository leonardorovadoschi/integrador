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
public class PsReferrerCachePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_connections_source")
    private int idConnectionsSource;
    @Basic(optional = false)
    @Column(name = "id_referrer")
    private int idReferrer;

    public PsReferrerCachePK() {
    }

    public PsReferrerCachePK(int idConnectionsSource, int idReferrer) {
        this.idConnectionsSource = idConnectionsSource;
        this.idReferrer = idReferrer;
    }

    public int getIdConnectionsSource() {
        return idConnectionsSource;
    }

    public void setIdConnectionsSource(int idConnectionsSource) {
        this.idConnectionsSource = idConnectionsSource;
    }

    public int getIdReferrer() {
        return idReferrer;
    }

    public void setIdReferrer(int idReferrer) {
        this.idReferrer = idReferrer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idConnectionsSource;
        hash += (int) idReferrer;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsReferrerCachePK)) {
            return false;
        }
        PsReferrerCachePK other = (PsReferrerCachePK) object;
        if (this.idConnectionsSource != other.idConnectionsSource) {
            return false;
        }
        if (this.idReferrer != other.idReferrer) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsReferrerCachePK[ idConnectionsSource=" + idConnectionsSource + ", idReferrer=" + idReferrer + " ]";
    }
    
}
