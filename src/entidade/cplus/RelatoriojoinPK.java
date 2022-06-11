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
public class RelatoriojoinPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "NOMETABELA1")
    private String nometabela1;
    @Basic(optional = false)
    @Column(name = "NOMETABELA2")
    private String nometabela2;

    public RelatoriojoinPK() {
    }

    public RelatoriojoinPK(String nometabela1, String nometabela2) {
        this.nometabela1 = nometabela1;
        this.nometabela2 = nometabela2;
    }

    public String getNometabela1() {
        return nometabela1;
    }

    public void setNometabela1(String nometabela1) {
        this.nometabela1 = nometabela1;
    }

    public String getNometabela2() {
        return nometabela2;
    }

    public void setNometabela2(String nometabela2) {
        this.nometabela2 = nometabela2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nometabela1 != null ? nometabela1.hashCode() : 0);
        hash += (nometabela2 != null ? nometabela2.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RelatoriojoinPK)) {
            return false;
        }
        RelatoriojoinPK other = (RelatoriojoinPK) object;
        if ((this.nometabela1 == null && other.nometabela1 != null) || (this.nometabela1 != null && !this.nometabela1.equals(other.nometabela1))) {
            return false;
        }
        if ((this.nometabela2 == null && other.nometabela2 != null) || (this.nometabela2 != null && !this.nometabela2.equals(other.nometabela2))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.RelatoriojoinPK[ nometabela1=" + nometabela1 + ", nometabela2=" + nometabela2 + " ]";
    }
    
}
