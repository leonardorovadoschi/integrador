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
@Table(name = "BICONSULTACENARIO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Biconsultacenario.findAll", query = "SELECT b FROM Biconsultacenario b")
    , @NamedQuery(name = "Biconsultacenario.findByCodbiconsultacenario", query = "SELECT b FROM Biconsultacenario b WHERE b.codbiconsultacenario = :codbiconsultacenario")
    , @NamedQuery(name = "Biconsultacenario.findByCodbiconsulta", query = "SELECT b FROM Biconsultacenario b WHERE b.codbiconsulta = :codbiconsulta")
    , @NamedQuery(name = "Biconsultacenario.findByNomebiconsultacenario", query = "SELECT b FROM Biconsultacenario b WHERE b.nomebiconsultacenario = :nomebiconsultacenario")
    , @NamedQuery(name = "Biconsultacenario.findByDataultimaalteracao", query = "SELECT b FROM Biconsultacenario b WHERE b.dataultimaalteracao = :dataultimaalteracao")
    , @NamedQuery(name = "Biconsultacenario.findByCoduser", query = "SELECT b FROM Biconsultacenario b WHERE b.coduser = :coduser")
    , @NamedQuery(name = "Biconsultacenario.findByFlagsistema", query = "SELECT b FROM Biconsultacenario b WHERE b.flagsistema = :flagsistema")})
public class Biconsultacenario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODBICONSULTACENARIO")
    private String codbiconsultacenario;
    @Basic(optional = false)
    @Column(name = "CODBICONSULTA")
    private String codbiconsulta;
    @Column(name = "NOMEBICONSULTACENARIO")
    private String nomebiconsultacenario;
    @Column(name = "DATAULTIMAALTERACAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataultimaalteracao;
    @Column(name = "CODUSER")
    private String coduser;
    @Column(name = "FLAGSISTEMA")
    private Character flagsistema;
    @Lob
    @Column(name = "DESCRICAO")
    private String descricao;
    @Lob
    @Column(name = "CONTEUDOARQUIVOINI")
    private String conteudoarquivoini;

    public Biconsultacenario() {
    }

    public Biconsultacenario(String codbiconsultacenario) {
        this.codbiconsultacenario = codbiconsultacenario;
    }

    public Biconsultacenario(String codbiconsultacenario, String codbiconsulta) {
        this.codbiconsultacenario = codbiconsultacenario;
        this.codbiconsulta = codbiconsulta;
    }

    public String getCodbiconsultacenario() {
        return codbiconsultacenario;
    }

    public void setCodbiconsultacenario(String codbiconsultacenario) {
        this.codbiconsultacenario = codbiconsultacenario;
    }

    public String getCodbiconsulta() {
        return codbiconsulta;
    }

    public void setCodbiconsulta(String codbiconsulta) {
        this.codbiconsulta = codbiconsulta;
    }

    public String getNomebiconsultacenario() {
        return nomebiconsultacenario;
    }

    public void setNomebiconsultacenario(String nomebiconsultacenario) {
        this.nomebiconsultacenario = nomebiconsultacenario;
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

    public Character getFlagsistema() {
        return flagsistema;
    }

    public void setFlagsistema(Character flagsistema) {
        this.flagsistema = flagsistema;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
        hash += (codbiconsultacenario != null ? codbiconsultacenario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Biconsultacenario)) {
            return false;
        }
        Biconsultacenario other = (Biconsultacenario) object;
        if ((this.codbiconsultacenario == null && other.codbiconsultacenario != null) || (this.codbiconsultacenario != null && !this.codbiconsultacenario.equals(other.codbiconsultacenario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Biconsultacenario[ codbiconsultacenario=" + codbiconsultacenario + " ]";
    }
    
}
