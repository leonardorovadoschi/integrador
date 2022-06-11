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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "CONFERENCIACAIXA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conferenciacaixa.findAll", query = "SELECT c FROM Conferenciacaixa c")
    , @NamedQuery(name = "Conferenciacaixa.findByCodconferenciacaixa", query = "SELECT c FROM Conferenciacaixa c WHERE c.codconferenciacaixa = :codconferenciacaixa")
    , @NamedQuery(name = "Conferenciacaixa.findByCodigo", query = "SELECT c FROM Conferenciacaixa c WHERE c.codigo = :codigo")
    , @NamedQuery(name = "Conferenciacaixa.findByStatusconferencia", query = "SELECT c FROM Conferenciacaixa c WHERE c.statusconferencia = :statusconferencia")
    , @NamedQuery(name = "Conferenciacaixa.findByDataconferencia", query = "SELECT c FROM Conferenciacaixa c WHERE c.dataconferencia = :dataconferencia")
    , @NamedQuery(name = "Conferenciacaixa.findByCodterminal", query = "SELECT c FROM Conferenciacaixa c WHERE c.codterminal = :codterminal")
    , @NamedQuery(name = "Conferenciacaixa.findByCodusuariodigitacao", query = "SELECT c FROM Conferenciacaixa c WHERE c.codusuariodigitacao = :codusuariodigitacao")
    , @NamedQuery(name = "Conferenciacaixa.findByCodusuariocaixa", query = "SELECT c FROM Conferenciacaixa c WHERE c.codusuariocaixa = :codusuariocaixa")})
public class Conferenciacaixa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCONFERENCIACAIXA")
    private String codconferenciacaixa;
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "STATUSCONFERENCIA")
    private Character statusconferencia;
    @Column(name = "DATACONFERENCIA")
    @Temporal(TemporalType.DATE)
    private Date dataconferencia;
    @Column(name = "CODTERMINAL")
    private String codterminal;
    @Column(name = "CODUSUARIODIGITACAO")
    private String codusuariodigitacao;
    @Column(name = "CODUSUARIOCAIXA")
    private String codusuariocaixa;
    @Lob
    @Column(name = "OCORRENCIAS")
    private String ocorrencias;
    @OneToMany(mappedBy = "codconferenciacaixa")
    private Collection<Conferenciacaixaitem> conferenciacaixaitemCollection;

    public Conferenciacaixa() {
    }

    public Conferenciacaixa(String codconferenciacaixa) {
        this.codconferenciacaixa = codconferenciacaixa;
    }

    public String getCodconferenciacaixa() {
        return codconferenciacaixa;
    }

    public void setCodconferenciacaixa(String codconferenciacaixa) {
        this.codconferenciacaixa = codconferenciacaixa;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Character getStatusconferencia() {
        return statusconferencia;
    }

    public void setStatusconferencia(Character statusconferencia) {
        this.statusconferencia = statusconferencia;
    }

    public Date getDataconferencia() {
        return dataconferencia;
    }

    public void setDataconferencia(Date dataconferencia) {
        this.dataconferencia = dataconferencia;
    }

    public String getCodterminal() {
        return codterminal;
    }

    public void setCodterminal(String codterminal) {
        this.codterminal = codterminal;
    }

    public String getCodusuariodigitacao() {
        return codusuariodigitacao;
    }

    public void setCodusuariodigitacao(String codusuariodigitacao) {
        this.codusuariodigitacao = codusuariodigitacao;
    }

    public String getCodusuariocaixa() {
        return codusuariocaixa;
    }

    public void setCodusuariocaixa(String codusuariocaixa) {
        this.codusuariocaixa = codusuariocaixa;
    }

    public String getOcorrencias() {
        return ocorrencias;
    }

    public void setOcorrencias(String ocorrencias) {
        this.ocorrencias = ocorrencias;
    }

    @XmlTransient
    public Collection<Conferenciacaixaitem> getConferenciacaixaitemCollection() {
        return conferenciacaixaitemCollection;
    }

    public void setConferenciacaixaitemCollection(Collection<Conferenciacaixaitem> conferenciacaixaitemCollection) {
        this.conferenciacaixaitemCollection = conferenciacaixaitemCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codconferenciacaixa != null ? codconferenciacaixa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conferenciacaixa)) {
            return false;
        }
        Conferenciacaixa other = (Conferenciacaixa) object;
        if ((this.codconferenciacaixa == null && other.codconferenciacaixa != null) || (this.codconferenciacaixa != null && !this.codconferenciacaixa.equals(other.codconferenciacaixa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Conferenciacaixa[ codconferenciacaixa=" + codconferenciacaixa + " ]";
    }
    
}
