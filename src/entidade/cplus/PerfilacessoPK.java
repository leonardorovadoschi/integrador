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
public class PerfilacessoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "CODSISTEMAACESSO")
    private int codsistemaacesso;
    @Basic(optional = false)
    @Column(name = "CODPERFILUSUARIO")
    private String codperfilusuario;

    public PerfilacessoPK() {
    }

    public PerfilacessoPK(int codsistemaacesso, String codperfilusuario) {
        this.codsistemaacesso = codsistemaacesso;
        this.codperfilusuario = codperfilusuario;
    }

    public int getCodsistemaacesso() {
        return codsistemaacesso;
    }

    public void setCodsistemaacesso(int codsistemaacesso) {
        this.codsistemaacesso = codsistemaacesso;
    }

    public String getCodperfilusuario() {
        return codperfilusuario;
    }

    public void setCodperfilusuario(String codperfilusuario) {
        this.codperfilusuario = codperfilusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codsistemaacesso;
        hash += (codperfilusuario != null ? codperfilusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerfilacessoPK)) {
            return false;
        }
        PerfilacessoPK other = (PerfilacessoPK) object;
        if (this.codsistemaacesso != other.codsistemaacesso) {
            return false;
        }
        if ((this.codperfilusuario == null && other.codperfilusuario != null) || (this.codperfilusuario != null && !this.codperfilusuario.equals(other.codperfilusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.PerfilacessoPK[ codsistemaacesso=" + codsistemaacesso + ", codperfilusuario=" + codperfilusuario + " ]";
    }
    
}
