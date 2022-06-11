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
public class IcmsestadoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "UFORIGEM")
    private String uforigem;
    @Basic(optional = false)
    @Column(name = "UFDESTINO")
    private String ufdestino;

    public IcmsestadoPK() {
    }

    public IcmsestadoPK(String uforigem, String ufdestino) {
        this.uforigem = uforigem;
        this.ufdestino = ufdestino;
    }

    public String getUforigem() {
        return uforigem;
    }

    public void setUforigem(String uforigem) {
        this.uforigem = uforigem;
    }

    public String getUfdestino() {
        return ufdestino;
    }

    public void setUfdestino(String ufdestino) {
        this.ufdestino = ufdestino;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uforigem != null ? uforigem.hashCode() : 0);
        hash += (ufdestino != null ? ufdestino.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IcmsestadoPK)) {
            return false;
        }
        IcmsestadoPK other = (IcmsestadoPK) object;
        if ((this.uforigem == null && other.uforigem != null) || (this.uforigem != null && !this.uforigem.equals(other.uforigem))) {
            return false;
        }
        if ((this.ufdestino == null && other.ufdestino != null) || (this.ufdestino != null && !this.ufdestino.equals(other.ufdestino))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.IcmsestadoPK[ uforigem=" + uforigem + ", ufdestino=" + ufdestino + " ]";
    }
    
}
