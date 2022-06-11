/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "CONFERENCIAPEDIDO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conferenciapedido.findAll", query = "SELECT c FROM Conferenciapedido c")
    , @NamedQuery(name = "Conferenciapedido.findByCodconferenciapedido", query = "SELECT c FROM Conferenciapedido c WHERE c.codconferenciapedido = :codconferenciapedido")
    , @NamedQuery(name = "Conferenciapedido.findByNumeroconferencia", query = "SELECT c FROM Conferenciapedido c WHERE c.numeroconferencia = :numeroconferencia")
    , @NamedQuery(name = "Conferenciapedido.findByDatacriacao", query = "SELECT c FROM Conferenciapedido c WHERE c.datacriacao = :datacriacao")
    , @NamedQuery(name = "Conferenciapedido.findByCoduser", query = "SELECT c FROM Conferenciapedido c WHERE c.coduser = :coduser")
    , @NamedQuery(name = "Conferenciapedido.findByCodmovenda", query = "SELECT c FROM Conferenciapedido c WHERE c.codmovenda = :codmovenda")
    , @NamedQuery(name = "Conferenciapedido.findByFlagconferido", query = "SELECT c FROM Conferenciapedido c WHERE c.flagconferido = :flagconferido")})
public class Conferenciapedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCONFERENCIAPEDIDO")
    private String codconferenciapedido;
    @Basic(optional = false)
    @Column(name = "NUMEROCONFERENCIA")
    private String numeroconferencia;
    @Column(name = "DATACRIACAO")
    @Temporal(TemporalType.DATE)
    private Date datacriacao;
    @Column(name = "CODUSER")
    private String coduser;
    @Column(name = "CODMOVENDA")
    private String codmovenda;
    @Column(name = "FLAGCONFERIDO")
    private Character flagconferido;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codconferenciapedido")
    private Collection<Conferenciapedidoitens> conferenciapedidoitensCollection;

    public Conferenciapedido() {
    }

    public Conferenciapedido(String codconferenciapedido) {
        this.codconferenciapedido = codconferenciapedido;
    }

    public Conferenciapedido(String codconferenciapedido, String numeroconferencia) {
        this.codconferenciapedido = codconferenciapedido;
        this.numeroconferencia = numeroconferencia;
    }

    public String getCodconferenciapedido() {
        return codconferenciapedido;
    }

    public void setCodconferenciapedido(String codconferenciapedido) {
        this.codconferenciapedido = codconferenciapedido;
    }

    public String getNumeroconferencia() {
        return numeroconferencia;
    }

    public void setNumeroconferencia(String numeroconferencia) {
        this.numeroconferencia = numeroconferencia;
    }

    public Date getDatacriacao() {
        return datacriacao;
    }

    public void setDatacriacao(Date datacriacao) {
        this.datacriacao = datacriacao;
    }

    public String getCoduser() {
        return coduser;
    }

    public void setCoduser(String coduser) {
        this.coduser = coduser;
    }

    public String getCodmovenda() {
        return codmovenda;
    }

    public void setCodmovenda(String codmovenda) {
        this.codmovenda = codmovenda;
    }

    public Character getFlagconferido() {
        return flagconferido;
    }

    public void setFlagconferido(Character flagconferido) {
        this.flagconferido = flagconferido;
    }

    @XmlTransient
    public Collection<Conferenciapedidoitens> getConferenciapedidoitensCollection() {
        return conferenciapedidoitensCollection;
    }

    public void setConferenciapedidoitensCollection(Collection<Conferenciapedidoitens> conferenciapedidoitensCollection) {
        this.conferenciapedidoitensCollection = conferenciapedidoitensCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codconferenciapedido != null ? codconferenciapedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conferenciapedido)) {
            return false;
        }
        Conferenciapedido other = (Conferenciapedido) object;
        if ((this.codconferenciapedido == null && other.codconferenciapedido != null) || (this.codconferenciapedido != null && !this.codconferenciapedido.equals(other.codconferenciapedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Conferenciapedido[ codconferenciapedido=" + codconferenciapedido + " ]";
    }
    
}
