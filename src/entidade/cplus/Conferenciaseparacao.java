/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "CONFERENCIASEPARACAO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conferenciaseparacao.findAll", query = "SELECT c FROM Conferenciaseparacao c")
    , @NamedQuery(name = "Conferenciaseparacao.findByCodconferenciaseparacao", query = "SELECT c FROM Conferenciaseparacao c WHERE c.codconferenciaseparacao = :codconferenciaseparacao")
    , @NamedQuery(name = "Conferenciaseparacao.findByCodigoimpressao", query = "SELECT c FROM Conferenciaseparacao c WHERE c.codigoimpressao = :codigoimpressao")
    , @NamedQuery(name = "Conferenciaseparacao.findByFlagconferido", query = "SELECT c FROM Conferenciaseparacao c WHERE c.flagconferido = :flagconferido")
    , @NamedQuery(name = "Conferenciaseparacao.findByZona", query = "SELECT c FROM Conferenciaseparacao c WHERE c.zona = :zona")})
public class Conferenciaseparacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCONFERENCIASEPARACAO")
    private String codconferenciaseparacao;
    @Basic(optional = false)
    @Column(name = "CODIGOIMPRESSAO")
    private String codigoimpressao;
    @Basic(optional = false)
    @Column(name = "FLAGCONFERIDO")
    private Character flagconferido;
    @Basic(optional = false)
    @Column(name = "ZONA")
    private String zona;
    @JoinColumn(name = "CODMOVENDA", referencedColumnName = "CODMOVENDA")
    @ManyToOne(optional = false)
    private Movenda codmovenda;

    public Conferenciaseparacao() {
    }

    public Conferenciaseparacao(String codconferenciaseparacao) {
        this.codconferenciaseparacao = codconferenciaseparacao;
    }

    public Conferenciaseparacao(String codconferenciaseparacao, String codigoimpressao, Character flagconferido, String zona) {
        this.codconferenciaseparacao = codconferenciaseparacao;
        this.codigoimpressao = codigoimpressao;
        this.flagconferido = flagconferido;
        this.zona = zona;
    }

    public String getCodconferenciaseparacao() {
        return codconferenciaseparacao;
    }

    public void setCodconferenciaseparacao(String codconferenciaseparacao) {
        this.codconferenciaseparacao = codconferenciaseparacao;
    }

    public String getCodigoimpressao() {
        return codigoimpressao;
    }

    public void setCodigoimpressao(String codigoimpressao) {
        this.codigoimpressao = codigoimpressao;
    }

    public Character getFlagconferido() {
        return flagconferido;
    }

    public void setFlagconferido(Character flagconferido) {
        this.flagconferido = flagconferido;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public Movenda getCodmovenda() {
        return codmovenda;
    }

    public void setCodmovenda(Movenda codmovenda) {
        this.codmovenda = codmovenda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codconferenciaseparacao != null ? codconferenciaseparacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conferenciaseparacao)) {
            return false;
        }
        Conferenciaseparacao other = (Conferenciaseparacao) object;
        if ((this.codconferenciaseparacao == null && other.codconferenciaseparacao != null) || (this.codconferenciaseparacao != null && !this.codconferenciaseparacao.equals(other.codconferenciaseparacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Conferenciaseparacao[ codconferenciaseparacao=" + codconferenciaseparacao + " ]";
    }
    
}
