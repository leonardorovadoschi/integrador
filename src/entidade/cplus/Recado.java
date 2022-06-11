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
@Table(name = "RECADO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recado.findAll", query = "SELECT r FROM Recado r")
    , @NamedQuery(name = "Recado.findByCodrecado", query = "SELECT r FROM Recado r WHERE r.codrecado = :codrecado")
    , @NamedQuery(name = "Recado.findByCoduserinc", query = "SELECT r FROM Recado r WHERE r.coduserinc = :coduserinc")
    , @NamedQuery(name = "Recado.findByCoduser", query = "SELECT r FROM Recado r WHERE r.coduser = :coduser")
    , @NamedQuery(name = "Recado.findByData", query = "SELECT r FROM Recado r WHERE r.data = :data")
    , @NamedQuery(name = "Recado.findByHora", query = "SELECT r FROM Recado r WHERE r.hora = :hora")
    , @NamedQuery(name = "Recado.findByNome", query = "SELECT r FROM Recado r WHERE r.nome = :nome")
    , @NamedQuery(name = "Recado.findByEmpresa", query = "SELECT r FROM Recado r WHERE r.empresa = :empresa")
    , @NamedQuery(name = "Recado.findByTelefone", query = "SELECT r FROM Recado r WHERE r.telefone = :telefone")
    , @NamedQuery(name = "Recado.findByFlagok", query = "SELECT r FROM Recado r WHERE r.flagok = :flagok")
    , @NamedQuery(name = "Recado.findByDataok", query = "SELECT r FROM Recado r WHERE r.dataok = :dataok")
    , @NamedQuery(name = "Recado.findByCtrlrecado", query = "SELECT r FROM Recado r WHERE r.ctrlrecado = :ctrlrecado")})
public class Recado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODRECADO")
    private String codrecado;
    @Column(name = "CODUSERINC")
    private String coduserinc;
    @Column(name = "CODUSER")
    private String coduser;
    @Basic(optional = false)
    @Column(name = "DATA")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "HORA")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "EMPRESA")
    private String empresa;
    @Column(name = "TELEFONE")
    private String telefone;
    @Lob
    @Column(name = "RECADO")
    private String recado;
    @Column(name = "FLAGOK")
    private Character flagok;
    @Column(name = "DATAOK")
    @Temporal(TemporalType.DATE)
    private Date dataok;
    @Column(name = "CTRLRECADO")
    private String ctrlrecado;

    public Recado() {
    }

    public Recado(String codrecado) {
        this.codrecado = codrecado;
    }

    public Recado(String codrecado, Date data) {
        this.codrecado = codrecado;
        this.data = data;
    }

    public String getCodrecado() {
        return codrecado;
    }

    public void setCodrecado(String codrecado) {
        this.codrecado = codrecado;
    }

    public String getCoduserinc() {
        return coduserinc;
    }

    public void setCoduserinc(String coduserinc) {
        this.coduserinc = coduserinc;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRecado() {
        return recado;
    }

    public void setRecado(String recado) {
        this.recado = recado;
    }

    public Character getFlagok() {
        return flagok;
    }

    public void setFlagok(Character flagok) {
        this.flagok = flagok;
    }

    public Date getDataok() {
        return dataok;
    }

    public void setDataok(Date dataok) {
        this.dataok = dataok;
    }

    public String getCtrlrecado() {
        return ctrlrecado;
    }

    public void setCtrlrecado(String ctrlrecado) {
        this.ctrlrecado = ctrlrecado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codrecado != null ? codrecado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recado)) {
            return false;
        }
        Recado other = (Recado) object;
        if ((this.codrecado == null && other.codrecado != null) || (this.codrecado != null && !this.codrecado.equals(other.codrecado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Recado[ codrecado=" + codrecado + " ]";
    }
    
}
