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
public class UsuarioacessoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "CODUSER")
    private String coduser;
    @Basic(optional = false)
    @Column(name = "CODSISTEMAACESSO")
    private int codsistemaacesso;

    public UsuarioacessoPK() {
    }

    public UsuarioacessoPK(String coduser, int codsistemaacesso) {
        this.coduser = coduser;
        this.codsistemaacesso = codsistemaacesso;
    }

    public String getCoduser() {
        return coduser;
    }

    public void setCoduser(String coduser) {
        this.coduser = coduser;
    }

    public int getCodsistemaacesso() {
        return codsistemaacesso;
    }

    public void setCodsistemaacesso(int codsistemaacesso) {
        this.codsistemaacesso = codsistemaacesso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coduser != null ? coduser.hashCode() : 0);
        hash += (int) codsistemaacesso;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioacessoPK)) {
            return false;
        }
        UsuarioacessoPK other = (UsuarioacessoPK) object;
        if ((this.coduser == null && other.coduser != null) || (this.coduser != null && !this.coduser.equals(other.coduser))) {
            return false;
        }
        if (this.codsistemaacesso != other.codsistemaacesso) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.UsuarioacessoPK[ coduser=" + coduser + ", codsistemaacesso=" + codsistemaacesso + " ]";
    }
    
}
