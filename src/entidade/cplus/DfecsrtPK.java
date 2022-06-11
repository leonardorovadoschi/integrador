/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author leo
 */
@Embeddable
public class DfecsrtPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "UF")
    private String uf;
    @Basic(optional = false)
    @Column(name = "IDHASH")
    private short idhash;

    public DfecsrtPK() {
    }

    public DfecsrtPK(String uf, short idhash) {
        this.uf = uf;
        this.idhash = idhash;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public short getIdhash() {
        return idhash;
    }

    public void setIdhash(short idhash) {
        this.idhash = idhash;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uf != null ? uf.hashCode() : 0);
        hash += (int) idhash;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DfecsrtPK)) {
            return false;
        }
        DfecsrtPK other = (DfecsrtPK) object;
        if ((this.uf == null && other.uf != null) || (this.uf != null && !this.uf.equals(other.uf))) {
            return false;
        }
        if (this.idhash != other.idhash) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.DfecsrtPK[ uf=" + uf + ", idhash=" + idhash + " ]";
    }
    
}
