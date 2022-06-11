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
public class WcplusEmpresaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "CODWCPLUS")
    private int codwcplus;
    @Basic(optional = false)
    @Column(name = "CODEMPRESA")
    private int codempresa;

    public WcplusEmpresaPK() {
    }

    public WcplusEmpresaPK(int codwcplus, int codempresa) {
        this.codwcplus = codwcplus;
        this.codempresa = codempresa;
    }

    public int getCodwcplus() {
        return codwcplus;
    }

    public void setCodwcplus(int codwcplus) {
        this.codwcplus = codwcplus;
    }

    public int getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(int codempresa) {
        this.codempresa = codempresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codwcplus;
        hash += (int) codempresa;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WcplusEmpresaPK)) {
            return false;
        }
        WcplusEmpresaPK other = (WcplusEmpresaPK) object;
        if (this.codwcplus != other.codwcplus) {
            return false;
        }
        if (this.codempresa != other.codempresa) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.WcplusEmpresaPK[ codwcplus=" + codwcplus + ", codempresa=" + codempresa + " ]";
    }
    
}
