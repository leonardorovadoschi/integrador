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
@Table(name = "CLIENTECARACTERISTICA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clientecaracteristica.findAll", query = "SELECT c FROM Clientecaracteristica c")
    , @NamedQuery(name = "Clientecaracteristica.findByCodclientecaracteristica", query = "SELECT c FROM Clientecaracteristica c WHERE c.codclientecaracteristica = :codclientecaracteristica")
    , @NamedQuery(name = "Clientecaracteristica.findByDatacaracteristica", query = "SELECT c FROM Clientecaracteristica c WHERE c.datacaracteristica = :datacaracteristica")
    , @NamedQuery(name = "Clientecaracteristica.findByGuid", query = "SELECT c FROM Clientecaracteristica c WHERE c.guid = :guid")})
public class Clientecaracteristica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCLIENTECARACTERISTICA")
    private String codclientecaracteristica;
    @Column(name = "DATACARACTERISTICA")
    @Temporal(TemporalType.DATE)
    private Date datacaracteristica;
    @Column(name = "GUID")
    private String guid;
    @JoinColumn(name = "CODCARACTERISTICAPESSOA", referencedColumnName = "CODCARACTERISTICAPESSOA")
    @ManyToOne(optional = false)
    private Caracteristicapessoa codcaracteristicapessoa;
    @JoinColumn(name = "CODCLI", referencedColumnName = "CODCLI")
    @ManyToOne
    private Cliente codcli;

    public Clientecaracteristica() {
    }

    public Clientecaracteristica(String codclientecaracteristica) {
        this.codclientecaracteristica = codclientecaracteristica;
    }

    public String getCodclientecaracteristica() {
        return codclientecaracteristica;
    }

    public void setCodclientecaracteristica(String codclientecaracteristica) {
        this.codclientecaracteristica = codclientecaracteristica;
    }

    public Date getDatacaracteristica() {
        return datacaracteristica;
    }

    public void setDatacaracteristica(Date datacaracteristica) {
        this.datacaracteristica = datacaracteristica;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Caracteristicapessoa getCodcaracteristicapessoa() {
        return codcaracteristicapessoa;
    }

    public void setCodcaracteristicapessoa(Caracteristicapessoa codcaracteristicapessoa) {
        this.codcaracteristicapessoa = codcaracteristicapessoa;
    }

    public Cliente getCodcli() {
        return codcli;
    }

    public void setCodcli(Cliente codcli) {
        this.codcli = codcli;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codclientecaracteristica != null ? codclientecaracteristica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientecaracteristica)) {
            return false;
        }
        Clientecaracteristica other = (Clientecaracteristica) object;
        if ((this.codclientecaracteristica == null && other.codclientecaracteristica != null) || (this.codclientecaracteristica != null && !this.codclientecaracteristica.equals(other.codclientecaracteristica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Clientecaracteristica[ codclientecaracteristica=" + codclientecaracteristica + " ]";
    }
    
}
