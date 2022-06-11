/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "PRODUTOFOTO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produtofoto.findAll", query = "SELECT p FROM Produtofoto p")
    , @NamedQuery(name = "Produtofoto.findByCodprodfoto", query = "SELECT p FROM Produtofoto p WHERE p.codprodfoto = :codprodfoto")
    , @NamedQuery(name = "Produtofoto.findByFlagprincipal", query = "SELECT p FROM Produtofoto p WHERE p.flagprincipal = :flagprincipal")
    , @NamedQuery(name = "Produtofoto.findByGuid", query = "SELECT p FROM Produtofoto p WHERE p.guid = :guid")
    , @NamedQuery(name = "Produtofoto.findByLastChange", query = "SELECT p FROM Produtofoto p WHERE p.lastChange = :lastChange")})
public class Produtofoto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODPRODFOTO")
    private String codprodfoto;
    @Column(name = "FLAGPRINCIPAL")
    private Character flagprincipal;
    @Lob
    @Column(name = "FOTO")
    private byte[] foto;
    @Column(name = "GUID")
    private String guid;
    @Column(name = "LAST_CHANGE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastChange;
    @JoinColumn(name = "CODPROD", referencedColumnName = "CODPROD")
    @ManyToOne(optional = false)
    private Produto codprod;

    public Produtofoto() {
    }

    public Produtofoto(String codprodfoto) {
        this.codprodfoto = codprodfoto;
    }

    public String getCodprodfoto() {
        return codprodfoto;
    }

    public void setCodprodfoto(String codprodfoto) {
        this.codprodfoto = codprodfoto;
    }

    public Character getFlagprincipal() {
        return flagprincipal;
    }

    public void setFlagprincipal(Character flagprincipal) {
        this.flagprincipal = flagprincipal;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Date getLastChange() {
        return lastChange;
    }

    public void setLastChange(Date lastChange) {
        this.lastChange = lastChange;
    }

    public Produto getCodprod() {
        return codprod;
    }

    public void setCodprod(Produto codprod) {
        this.codprod = codprod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codprodfoto != null ? codprodfoto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produtofoto)) {
            return false;
        }
        Produtofoto other = (Produtofoto) object;
        if ((this.codprodfoto == null && other.codprodfoto != null) || (this.codprodfoto != null && !this.codprodfoto.equals(other.codprodfoto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Produtofoto[ codprodfoto=" + codprodfoto + " ]";
    }
    
}
