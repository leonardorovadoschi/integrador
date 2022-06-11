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
@Table(name = "RELATORIOCENARIO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Relatoriocenario.findAll", query = "SELECT r FROM Relatoriocenario r")
    , @NamedQuery(name = "Relatoriocenario.findByCodrelatoriocenario", query = "SELECT r FROM Relatoriocenario r WHERE r.codrelatoriocenario = :codrelatoriocenario")
    , @NamedQuery(name = "Relatoriocenario.findByNomerelatoriocenario", query = "SELECT r FROM Relatoriocenario r WHERE r.nomerelatoriocenario = :nomerelatoriocenario")
    , @NamedQuery(name = "Relatoriocenario.findByDataultimaalteracao", query = "SELECT r FROM Relatoriocenario r WHERE r.dataultimaalteracao = :dataultimaalteracao")
    , @NamedQuery(name = "Relatoriocenario.findByCoduser", query = "SELECT r FROM Relatoriocenario r WHERE r.coduser = :coduser")
    , @NamedQuery(name = "Relatoriocenario.findByCodreport", query = "SELECT r FROM Relatoriocenario r WHERE r.codreport = :codreport")
    , @NamedQuery(name = "Relatoriocenario.findByFlagsistema", query = "SELECT r FROM Relatoriocenario r WHERE r.flagsistema = :flagsistema")})
public class Relatoriocenario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODRELATORIOCENARIO")
    private String codrelatoriocenario;
    @Column(name = "NOMERELATORIOCENARIO")
    private String nomerelatoriocenario;
    @Column(name = "DATAULTIMAALTERACAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataultimaalteracao;
    @Column(name = "CODUSER")
    private String coduser;
    @Column(name = "CODREPORT")
    private Integer codreport;
    @Column(name = "FLAGSISTEMA")
    private Character flagsistema;
    @Lob
    @Column(name = "CONTEUDOARQUIVOINI")
    private String conteudoarquivoini;

    public Relatoriocenario() {
    }

    public Relatoriocenario(String codrelatoriocenario) {
        this.codrelatoriocenario = codrelatoriocenario;
    }

    public String getCodrelatoriocenario() {
        return codrelatoriocenario;
    }

    public void setCodrelatoriocenario(String codrelatoriocenario) {
        this.codrelatoriocenario = codrelatoriocenario;
    }

    public String getNomerelatoriocenario() {
        return nomerelatoriocenario;
    }

    public void setNomerelatoriocenario(String nomerelatoriocenario) {
        this.nomerelatoriocenario = nomerelatoriocenario;
    }

    public Date getDataultimaalteracao() {
        return dataultimaalteracao;
    }

    public void setDataultimaalteracao(Date dataultimaalteracao) {
        this.dataultimaalteracao = dataultimaalteracao;
    }

    public String getCoduser() {
        return coduser;
    }

    public void setCoduser(String coduser) {
        this.coduser = coduser;
    }

    public Integer getCodreport() {
        return codreport;
    }

    public void setCodreport(Integer codreport) {
        this.codreport = codreport;
    }

    public Character getFlagsistema() {
        return flagsistema;
    }

    public void setFlagsistema(Character flagsistema) {
        this.flagsistema = flagsistema;
    }

    public String getConteudoarquivoini() {
        return conteudoarquivoini;
    }

    public void setConteudoarquivoini(String conteudoarquivoini) {
        this.conteudoarquivoini = conteudoarquivoini;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codrelatoriocenario != null ? codrelatoriocenario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Relatoriocenario)) {
            return false;
        }
        Relatoriocenario other = (Relatoriocenario) object;
        if ((this.codrelatoriocenario == null && other.codrelatoriocenario != null) || (this.codrelatoriocenario != null && !this.codrelatoriocenario.equals(other.codrelatoriocenario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Relatoriocenario[ codrelatoriocenario=" + codrelatoriocenario + " ]";
    }
    
}
