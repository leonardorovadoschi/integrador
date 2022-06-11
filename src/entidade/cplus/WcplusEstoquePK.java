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
public class WcplusEstoquePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "CODWCPLUS")
    private int codwcplus;
    @Basic(optional = false)
    @Column(name = "CODSETORESTOQUE")
    private String codsetorestoque;

    public WcplusEstoquePK() {
    }

    public WcplusEstoquePK(int codwcplus, String codsetorestoque) {
        this.codwcplus = codwcplus;
        this.codsetorestoque = codsetorestoque;
    }

    public int getCodwcplus() {
        return codwcplus;
    }

    public void setCodwcplus(int codwcplus) {
        this.codwcplus = codwcplus;
    }

    public String getCodsetorestoque() {
        return codsetorestoque;
    }

    public void setCodsetorestoque(String codsetorestoque) {
        this.codsetorestoque = codsetorestoque;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codwcplus;
        hash += (codsetorestoque != null ? codsetorestoque.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WcplusEstoquePK)) {
            return false;
        }
        WcplusEstoquePK other = (WcplusEstoquePK) object;
        if (this.codwcplus != other.codwcplus) {
            return false;
        }
        if ((this.codsetorestoque == null && other.codsetorestoque != null) || (this.codsetorestoque != null && !this.codsetorestoque.equals(other.codsetorestoque))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.WcplusEstoquePK[ codwcplus=" + codwcplus + ", codsetorestoque=" + codsetorestoque + " ]";
    }
    
}
