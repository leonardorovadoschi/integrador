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
@Table(name = "CONSULTASPC", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consultaspc.findAll", query = "SELECT c FROM Consultaspc c")
    , @NamedQuery(name = "Consultaspc.findByCodconsultaspc", query = "SELECT c FROM Consultaspc c WHERE c.codconsultaspc = :codconsultaspc")
    , @NamedQuery(name = "Consultaspc.findByData", query = "SELECT c FROM Consultaspc c WHERE c.data = :data")
    , @NamedQuery(name = "Consultaspc.findByHora", query = "SELECT c FROM Consultaspc c WHERE c.hora = :hora")
    , @NamedQuery(name = "Consultaspc.findByObs", query = "SELECT c FROM Consultaspc c WHERE c.obs = :obs")
    , @NamedQuery(name = "Consultaspc.findByNomecli", query = "SELECT c FROM Consultaspc c WHERE c.nomecli = :nomecli")
    , @NamedQuery(name = "Consultaspc.findByCodcli", query = "SELECT c FROM Consultaspc c WHERE c.codcli = :codcli")
    , @NamedQuery(name = "Consultaspc.findByStatus", query = "SELECT c FROM Consultaspc c WHERE c.status = :status")
    , @NamedQuery(name = "Consultaspc.findByFlagcli", query = "SELECT c FROM Consultaspc c WHERE c.flagcli = :flagcli")
    , @NamedQuery(name = "Consultaspc.findByCpf", query = "SELECT c FROM Consultaspc c WHERE c.cpf = :cpf")
    , @NamedQuery(name = "Consultaspc.findByTerminal", query = "SELECT c FROM Consultaspc c WHERE c.terminal = :terminal")
    , @NamedQuery(name = "Consultaspc.findByDatanasc", query = "SELECT c FROM Consultaspc c WHERE c.datanasc = :datanasc")
    , @NamedQuery(name = "Consultaspc.findByNumdoc", query = "SELECT c FROM Consultaspc c WHERE c.numdoc = :numdoc")
    , @NamedQuery(name = "Consultaspc.findByDdd", query = "SELECT c FROM Consultaspc c WHERE c.ddd = :ddd")
    , @NamedQuery(name = "Consultaspc.findByTelefone", query = "SELECT c FROM Consultaspc c WHERE c.telefone = :telefone")
    , @NamedQuery(name = "Consultaspc.findByCoduf", query = "SELECT c FROM Consultaspc c WHERE c.coduf = :coduf")
    , @NamedQuery(name = "Consultaspc.findByNumconsulta", query = "SELECT c FROM Consultaspc c WHERE c.numconsulta = :numconsulta")})
public class Consultaspc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCONSULTASPC")
    private String codconsultaspc;
    @Column(name = "DATA")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "HORA")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @Column(name = "OBS")
    private String obs;
    @Column(name = "NOMECLI")
    private String nomecli;
    @Column(name = "CODCLI")
    private String codcli;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "FLAGCLI")
    private Character flagcli;
    @Column(name = "CPF")
    private String cpf;
    @Column(name = "TERMINAL")
    private String terminal;
    @Column(name = "DATANASC")
    @Temporal(TemporalType.DATE)
    private Date datanasc;
    @Column(name = "NUMDOC")
    private String numdoc;
    @Column(name = "DDD")
    private String ddd;
    @Column(name = "TELEFONE")
    private String telefone;
    @Column(name = "CODUF")
    private String coduf;
    @Column(name = "NUMCONSULTA")
    private String numconsulta;
    @JoinColumn(name = "CODCONSSPCNATUREZAOP", referencedColumnName = "CODCONSSPCNATUREZAOP")
    @ManyToOne
    private Consultaspcnaturezaoperacao codconsspcnaturezaop;
    @JoinColumn(name = "CODCONSULTPDOC", referencedColumnName = "CODCONSULTPDOC")
    @ManyToOne
    private Consultaspctipodocumento codconsultpdoc;

    public Consultaspc() {
    }

    public Consultaspc(String codconsultaspc) {
        this.codconsultaspc = codconsultaspc;
    }

    public String getCodconsultaspc() {
        return codconsultaspc;
    }

    public void setCodconsultaspc(String codconsultaspc) {
        this.codconsultaspc = codconsultaspc;
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

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getNomecli() {
        return nomecli;
    }

    public void setNomecli(String nomecli) {
        this.nomecli = nomecli;
    }

    public String getCodcli() {
        return codcli;
    }

    public void setCodcli(String codcli) {
        this.codcli = codcli;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Character getFlagcli() {
        return flagcli;
    }

    public void setFlagcli(Character flagcli) {
        this.flagcli = flagcli;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public Date getDatanasc() {
        return datanasc;
    }

    public void setDatanasc(Date datanasc) {
        this.datanasc = datanasc;
    }

    public String getNumdoc() {
        return numdoc;
    }

    public void setNumdoc(String numdoc) {
        this.numdoc = numdoc;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCoduf() {
        return coduf;
    }

    public void setCoduf(String coduf) {
        this.coduf = coduf;
    }

    public String getNumconsulta() {
        return numconsulta;
    }

    public void setNumconsulta(String numconsulta) {
        this.numconsulta = numconsulta;
    }

    public Consultaspcnaturezaoperacao getCodconsspcnaturezaop() {
        return codconsspcnaturezaop;
    }

    public void setCodconsspcnaturezaop(Consultaspcnaturezaoperacao codconsspcnaturezaop) {
        this.codconsspcnaturezaop = codconsspcnaturezaop;
    }

    public Consultaspctipodocumento getCodconsultpdoc() {
        return codconsultpdoc;
    }

    public void setCodconsultpdoc(Consultaspctipodocumento codconsultpdoc) {
        this.codconsultpdoc = codconsultpdoc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codconsultaspc != null ? codconsultaspc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consultaspc)) {
            return false;
        }
        Consultaspc other = (Consultaspc) object;
        if ((this.codconsultaspc == null && other.codconsultaspc != null) || (this.codconsultaspc != null && !this.codconsultaspc.equals(other.codconsultaspc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Consultaspc[ codconsultaspc=" + codconsultaspc + " ]";
    }
    
}
