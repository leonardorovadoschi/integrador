/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import javax.persistence.Column;
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
@Table(name = "USUARIOACESSO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarioacesso.findAll", query = "SELECT u FROM Usuarioacesso u")
    , @NamedQuery(name = "Usuarioacesso.findByCoduser", query = "SELECT u FROM Usuarioacesso u WHERE u.usuarioacessoPK.coduser = :coduser")
    , @NamedQuery(name = "Usuarioacesso.findByCodsistemaacesso", query = "SELECT u FROM Usuarioacesso u WHERE u.usuarioacessoPK.codsistemaacesso = :codsistemaacesso")
    , @NamedQuery(name = "Usuarioacesso.findByFlagacesso", query = "SELECT u FROM Usuarioacesso u WHERE u.flagacesso = :flagacesso")})
public class Usuarioacesso implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsuarioacessoPK usuarioacessoPK;
    @Column(name = "FLAGACESSO")
    private Character flagacesso;

    public Usuarioacesso() {
    }

    public Usuarioacesso(UsuarioacessoPK usuarioacessoPK) {
        this.usuarioacessoPK = usuarioacessoPK;
    }

    public Usuarioacesso(String coduser, int codsistemaacesso) {
        this.usuarioacessoPK = new UsuarioacessoPK(coduser, codsistemaacesso);
    }

    public UsuarioacessoPK getUsuarioacessoPK() {
        return usuarioacessoPK;
    }

    public void setUsuarioacessoPK(UsuarioacessoPK usuarioacessoPK) {
        this.usuarioacessoPK = usuarioacessoPK;
    }

    public Character getFlagacesso() {
        return flagacesso;
    }

    public void setFlagacesso(Character flagacesso) {
        this.flagacesso = flagacesso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioacessoPK != null ? usuarioacessoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarioacesso)) {
            return false;
        }
        Usuarioacesso other = (Usuarioacesso) object;
        if ((this.usuarioacessoPK == null && other.usuarioacessoPK != null) || (this.usuarioacessoPK != null && !this.usuarioacessoPK.equals(other.usuarioacessoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Usuarioacesso[ usuarioacessoPK=" + usuarioacessoPK + " ]";
    }
    
}
