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
import javax.persistence.Lob;
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
@Table(name = "AGENDA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agenda.findAll", query = "SELECT a FROM Agenda a")
    , @NamedQuery(name = "Agenda.findByCodagenda", query = "SELECT a FROM Agenda a WHERE a.codagenda = :codagenda")
    , @NamedQuery(name = "Agenda.findByCoduser", query = "SELECT a FROM Agenda a WHERE a.coduser = :coduser")
    , @NamedQuery(name = "Agenda.findByData", query = "SELECT a FROM Agenda a WHERE a.data = :data")
    , @NamedQuery(name = "Agenda.findByHora", query = "SELECT a FROM Agenda a WHERE a.hora = :hora")
    , @NamedQuery(name = "Agenda.findByDescricao", query = "SELECT a FROM Agenda a WHERE a.descricao = :descricao")
    , @NamedQuery(name = "Agenda.findByEfetuado", query = "SELECT a FROM Agenda a WHERE a.efetuado = :efetuado")
    , @NamedQuery(name = "Agenda.findByConfidencial", query = "SELECT a FROM Agenda a WHERE a.confidencial = :confidencial")})
public class Agenda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODAGENDA")
    private String codagenda;
    @Column(name = "CODUSER")
    private String coduser;
    @Column(name = "DATA")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "HORA")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @Column(name = "DESCRICAO")
    private String descricao;
    @Lob
    @Column(name = "COMPROMISSO")
    private String compromisso;
    @Column(name = "EFETUADO")
    private Character efetuado;
    @Column(name = "CONFIDENCIAL")
    private Character confidencial;

    public Agenda() {
    }

    public Agenda(String codagenda) {
        this.codagenda = codagenda;
    }

    public String getCodagenda() {
        return codagenda;
    }

    public void setCodagenda(String codagenda) {
        this.codagenda = codagenda;
    }

    public String getCoduser() {
        return coduser;
    }

    public void setCoduser(String coduser) {
        this.coduser = coduser;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCompromisso() {
        return compromisso;
    }

    public void setCompromisso(String compromisso) {
        this.compromisso = compromisso;
    }

    public Character getEfetuado() {
        return efetuado;
    }

    public void setEfetuado(Character efetuado) {
        this.efetuado = efetuado;
    }

    public Character getConfidencial() {
        return confidencial;
    }

    public void setConfidencial(Character confidencial) {
        this.confidencial = confidencial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codagenda != null ? codagenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agenda)) {
            return false;
        }
        Agenda other = (Agenda) object;
        if ((this.codagenda == null && other.codagenda != null) || (this.codagenda != null && !this.codagenda.equals(other.codagenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Agenda[ codagenda=" + codagenda + " ]";
    }
    
}
