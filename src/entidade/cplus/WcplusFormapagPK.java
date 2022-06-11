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
public class WcplusFormapagPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "CODWCPLUS")
    private int codwcplus;
    @Basic(optional = false)
    @Column(name = "CHAVEPAGAMENTO")
    private String chavepagamento;

    public WcplusFormapagPK() {
    }

    public WcplusFormapagPK(int codwcplus, String chavepagamento) {
        this.codwcplus = codwcplus;
        this.chavepagamento = chavepagamento;
    }

    public int getCodwcplus() {
        return codwcplus;
    }

    public void setCodwcplus(int codwcplus) {
        this.codwcplus = codwcplus;
    }

    public String getChavepagamento() {
        return chavepagamento;
    }

    public void setChavepagamento(String chavepagamento) {
        this.chavepagamento = chavepagamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codwcplus;
        hash += (chavepagamento != null ? chavepagamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WcplusFormapagPK)) {
            return false;
        }
        WcplusFormapagPK other = (WcplusFormapagPK) object;
        if (this.codwcplus != other.codwcplus) {
            return false;
        }
        if ((this.chavepagamento == null && other.chavepagamento != null) || (this.chavepagamento != null && !this.chavepagamento.equals(other.chavepagamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.WcplusFormapagPK[ codwcplus=" + codwcplus + ", chavepagamento=" + chavepagamento + " ]";
    }
    
}
