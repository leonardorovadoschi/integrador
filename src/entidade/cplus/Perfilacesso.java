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
@Table(name = "PERFILACESSO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Perfilacesso.findAll", query = "SELECT p FROM Perfilacesso p")
    , @NamedQuery(name = "Perfilacesso.findByCodsistemaacesso", query = "SELECT p FROM Perfilacesso p WHERE p.perfilacessoPK.codsistemaacesso = :codsistemaacesso")
    , @NamedQuery(name = "Perfilacesso.findByFlagacesso", query = "SELECT p FROM Perfilacesso p WHERE p.flagacesso = :flagacesso")
    , @NamedQuery(name = "Perfilacesso.findByCodperfilusuario", query = "SELECT p FROM Perfilacesso p WHERE p.perfilacessoPK.codperfilusuario = :codperfilusuario")
    , @NamedQuery(name = "Perfilacesso.findByGuid", query = "SELECT p FROM Perfilacesso p WHERE p.guid = :guid")})
public class Perfilacesso implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PerfilacessoPK perfilacessoPK;
    @Column(name = "FLAGACESSO")
    private Character flagacesso;
    @Column(name = "GUID")
    private String guid;

    public Perfilacesso() {
    }

    public Perfilacesso(PerfilacessoPK perfilacessoPK) {
        this.perfilacessoPK = perfilacessoPK;
    }

    public Perfilacesso(int codsistemaacesso, String codperfilusuario) {
        this.perfilacessoPK = new PerfilacessoPK(codsistemaacesso, codperfilusuario);
    }

    public PerfilacessoPK getPerfilacessoPK() {
        return perfilacessoPK;
    }

    public void setPerfilacessoPK(PerfilacessoPK perfilacessoPK) {
        this.perfilacessoPK = perfilacessoPK;
    }

    public Character getFlagacesso() {
        return flagacesso;
    }

    public void setFlagacesso(Character flagacesso) {
        this.flagacesso = flagacesso;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perfilacessoPK != null ? perfilacessoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perfilacesso)) {
            return false;
        }
        Perfilacesso other = (Perfilacesso) object;
        if ((this.perfilacessoPK == null && other.perfilacessoPK != null) || (this.perfilacessoPK != null && !this.perfilacessoPK.equals(other.perfilacessoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Perfilacesso[ perfilacessoPK=" + perfilacessoPK + " ]";
    }
    
}
