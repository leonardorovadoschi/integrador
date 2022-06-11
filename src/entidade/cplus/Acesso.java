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
@Table(name = "ACESSO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acesso.findAll", query = "SELECT a FROM Acesso a")
    , @NamedQuery(name = "Acesso.findByCodacesso", query = "SELECT a FROM Acesso a WHERE a.codacesso = :codacesso")
    , @NamedQuery(name = "Acesso.findByDatahoraentrada", query = "SELECT a FROM Acesso a WHERE a.datahoraentrada = :datahoraentrada")
    , @NamedQuery(name = "Acesso.findByDatahorasaida", query = "SELECT a FROM Acesso a WHERE a.datahorasaida = :datahorasaida")
    , @NamedQuery(name = "Acesso.findByNomecomputador", query = "SELECT a FROM Acesso a WHERE a.nomecomputador = :nomecomputador")
    , @NamedQuery(name = "Acesso.findByIpcomputador", query = "SELECT a FROM Acesso a WHERE a.ipcomputador = :ipcomputador")
    , @NamedQuery(name = "Acesso.findByNomeusuariocomputador", query = "SELECT a FROM Acesso a WHERE a.nomeusuariocomputador = :nomeusuariocomputador")
    , @NamedQuery(name = "Acesso.findByCoduser", query = "SELECT a FROM Acesso a WHERE a.coduser = :coduser")
    , @NamedQuery(name = "Acesso.findByCodsistema", query = "SELECT a FROM Acesso a WHERE a.codsistema = :codsistema")
    , @NamedQuery(name = "Acesso.findByExe", query = "SELECT a FROM Acesso a WHERE a.exe = :exe")
    , @NamedQuery(name = "Acesso.findByVersaoexe", query = "SELECT a FROM Acesso a WHERE a.versaoexe = :versaoexe")})
public class Acesso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODACESSO")
    private String codacesso;
    @Column(name = "DATAHORAENTRADA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datahoraentrada;
    @Column(name = "DATAHORASAIDA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datahorasaida;
    @Column(name = "NOMECOMPUTADOR")
    private String nomecomputador;
    @Column(name = "IPCOMPUTADOR")
    private String ipcomputador;
    @Column(name = "NOMEUSUARIOCOMPUTADOR")
    private String nomeusuariocomputador;
    @Column(name = "CODUSER")
    private String coduser;
    @Column(name = "CODSISTEMA")
    private String codsistema;
    @Column(name = "EXE")
    private String exe;
    @Column(name = "VERSAOEXE")
    private String versaoexe;

    public Acesso() {
    }

    public Acesso(String codacesso) {
        this.codacesso = codacesso;
    }

    public String getCodacesso() {
        return codacesso;
    }

    public void setCodacesso(String codacesso) {
        this.codacesso = codacesso;
    }

    public Date getDatahoraentrada() {
        return datahoraentrada;
    }

    public void setDatahoraentrada(Date datahoraentrada) {
        this.datahoraentrada = datahoraentrada;
    }

    public Date getDatahorasaida() {
        return datahorasaida;
    }

    public void setDatahorasaida(Date datahorasaida) {
        this.datahorasaida = datahorasaida;
    }

    public String getNomecomputador() {
        return nomecomputador;
    }

    public void setNomecomputador(String nomecomputador) {
        this.nomecomputador = nomecomputador;
    }

    public String getIpcomputador() {
        return ipcomputador;
    }

    public void setIpcomputador(String ipcomputador) {
        this.ipcomputador = ipcomputador;
    }

    public String getNomeusuariocomputador() {
        return nomeusuariocomputador;
    }

    public void setNomeusuariocomputador(String nomeusuariocomputador) {
        this.nomeusuariocomputador = nomeusuariocomputador;
    }

    public String getCoduser() {
        return coduser;
    }

    public void setCoduser(String coduser) {
        this.coduser = coduser;
    }

    public String getCodsistema() {
        return codsistema;
    }

    public void setCodsistema(String codsistema) {
        this.codsistema = codsistema;
    }

    public String getExe() {
        return exe;
    }

    public void setExe(String exe) {
        this.exe = exe;
    }

    public String getVersaoexe() {
        return versaoexe;
    }

    public void setVersaoexe(String versaoexe) {
        this.versaoexe = versaoexe;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codacesso != null ? codacesso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acesso)) {
            return false;
        }
        Acesso other = (Acesso) object;
        if ((this.codacesso == null && other.codacesso != null) || (this.codacesso != null && !this.codacesso.equals(other.codacesso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Acesso[ codacesso=" + codacesso + " ]";
    }
    
}
