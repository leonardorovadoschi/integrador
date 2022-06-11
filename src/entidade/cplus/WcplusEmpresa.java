/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

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
@Table(name = "WCPLUS_EMPRESA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WcplusEmpresa.findAll", query = "SELECT w FROM WcplusEmpresa w")
    , @NamedQuery(name = "WcplusEmpresa.findByCodwcplus", query = "SELECT w FROM WcplusEmpresa w WHERE w.wcplusEmpresaPK.codwcplus = :codwcplus")
    , @NamedQuery(name = "WcplusEmpresa.findByCodempresa", query = "SELECT w FROM WcplusEmpresa w WHERE w.wcplusEmpresaPK.codempresa = :codempresa")})
public class WcplusEmpresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected WcplusEmpresaPK wcplusEmpresaPK;

    public WcplusEmpresa() {
    }

    public WcplusEmpresa(WcplusEmpresaPK wcplusEmpresaPK) {
        this.wcplusEmpresaPK = wcplusEmpresaPK;
    }

    public WcplusEmpresa(int codwcplus, int codempresa) {
        this.wcplusEmpresaPK = new WcplusEmpresaPK(codwcplus, codempresa);
    }

    public WcplusEmpresaPK getWcplusEmpresaPK() {
        return wcplusEmpresaPK;
    }

    public void setWcplusEmpresaPK(WcplusEmpresaPK wcplusEmpresaPK) {
        this.wcplusEmpresaPK = wcplusEmpresaPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (wcplusEmpresaPK != null ? wcplusEmpresaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WcplusEmpresa)) {
            return false;
        }
        WcplusEmpresa other = (WcplusEmpresa) object;
        if ((this.wcplusEmpresaPK == null && other.wcplusEmpresaPK != null) || (this.wcplusEmpresaPK != null && !this.wcplusEmpresaPK.equals(other.wcplusEmpresaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.WcplusEmpresa[ wcplusEmpresaPK=" + wcplusEmpresaPK + " ]";
    }
    
}
