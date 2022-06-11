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
@Table(name = "WCPLUS_ESTOQUE", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WcplusEstoque.findAll", query = "SELECT w FROM WcplusEstoque w")
    , @NamedQuery(name = "WcplusEstoque.findByCodwcplus", query = "SELECT w FROM WcplusEstoque w WHERE w.wcplusEstoquePK.codwcplus = :codwcplus")
    , @NamedQuery(name = "WcplusEstoque.findByCodsetorestoque", query = "SELECT w FROM WcplusEstoque w WHERE w.wcplusEstoquePK.codsetorestoque = :codsetorestoque")})
public class WcplusEstoque implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected WcplusEstoquePK wcplusEstoquePK;

    public WcplusEstoque() {
    }

    public WcplusEstoque(WcplusEstoquePK wcplusEstoquePK) {
        this.wcplusEstoquePK = wcplusEstoquePK;
    }

    public WcplusEstoque(int codwcplus, String codsetorestoque) {
        this.wcplusEstoquePK = new WcplusEstoquePK(codwcplus, codsetorestoque);
    }

    public WcplusEstoquePK getWcplusEstoquePK() {
        return wcplusEstoquePK;
    }

    public void setWcplusEstoquePK(WcplusEstoquePK wcplusEstoquePK) {
        this.wcplusEstoquePK = wcplusEstoquePK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (wcplusEstoquePK != null ? wcplusEstoquePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WcplusEstoque)) {
            return false;
        }
        WcplusEstoque other = (WcplusEstoque) object;
        if ((this.wcplusEstoquePK == null && other.wcplusEstoquePK != null) || (this.wcplusEstoquePK != null && !this.wcplusEstoquePK.equals(other.wcplusEstoquePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.WcplusEstoque[ wcplusEstoquePK=" + wcplusEstoquePK + " ]";
    }
    
}
