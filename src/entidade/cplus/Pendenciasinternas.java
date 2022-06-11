/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "PENDENCIASINTERNAS", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pendenciasinternas.findAll", query = "SELECT p FROM Pendenciasinternas p")
    , @NamedQuery(name = "Pendenciasinternas.findByCodpendenciainternas", query = "SELECT p FROM Pendenciasinternas p WHERE p.codpendenciainternas = :codpendenciainternas")
    , @NamedQuery(name = "Pendenciasinternas.findByDataocorrencia", query = "SELECT p FROM Pendenciasinternas p WHERE p.dataocorrencia = :dataocorrencia")
    , @NamedQuery(name = "Pendenciasinternas.findByModalidade", query = "SELECT p FROM Pendenciasinternas p WHERE p.modalidade = :modalidade")
    , @NamedQuery(name = "Pendenciasinternas.findByAvalista", query = "SELECT p FROM Pendenciasinternas p WHERE p.avalista = :avalista")
    , @NamedQuery(name = "Pendenciasinternas.findByTipomoeda", query = "SELECT p FROM Pendenciasinternas p WHERE p.tipomoeda = :tipomoeda")
    , @NamedQuery(name = "Pendenciasinternas.findByValor", query = "SELECT p FROM Pendenciasinternas p WHERE p.valor = :valor")
    , @NamedQuery(name = "Pendenciasinternas.findByContrato", query = "SELECT p FROM Pendenciasinternas p WHERE p.contrato = :contrato")
    , @NamedQuery(name = "Pendenciasinternas.findByOrigem", query = "SELECT p FROM Pendenciasinternas p WHERE p.origem = :origem")
    , @NamedQuery(name = "Pendenciasinternas.findBySigla", query = "SELECT p FROM Pendenciasinternas p WHERE p.sigla = :sigla")
    , @NamedQuery(name = "Pendenciasinternas.findBySubjudice", query = "SELECT p FROM Pendenciasinternas p WHERE p.subjudice = :subjudice")
    , @NamedQuery(name = "Pendenciasinternas.findBySubjudicedescricao", query = "SELECT p FROM Pendenciasinternas p WHERE p.subjudicedescricao = :subjudicedescricao")
    , @NamedQuery(name = "Pendenciasinternas.findByTipoanotacao", query = "SELECT p FROM Pendenciasinternas p WHERE p.tipoanotacao = :tipoanotacao")
    , @NamedQuery(name = "Pendenciasinternas.findByTipoanotacaodescricao", query = "SELECT p FROM Pendenciasinternas p WHERE p.tipoanotacaodescricao = :tipoanotacaodescricao")})
public class Pendenciasinternas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODPENDENCIAINTERNAS")
    private String codpendenciainternas;
    @Column(name = "DATAOCORRENCIA")
    @Temporal(TemporalType.DATE)
    private Date dataocorrencia;
    @Column(name = "MODALIDADE")
    private String modalidade;
    @Column(name = "AVALISTA")
    private String avalista;
    @Column(name = "TIPOMOEDA")
    private String tipomoeda;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALOR")
    private BigDecimal valor;
    @Column(name = "CONTRATO")
    private String contrato;
    @Column(name = "ORIGEM")
    private String origem;
    @Column(name = "SIGLA")
    private String sigla;
    @Column(name = "SUBJUDICE")
    private String subjudice;
    @Column(name = "SUBJUDICEDESCRICAO")
    private String subjudicedescricao;
    @Column(name = "TIPOANOTACAO")
    private String tipoanotacao;
    @Column(name = "TIPOANOTACAODESCRICAO")
    private String tipoanotacaodescricao;
    @JoinColumn(name = "CODCONSULTASERASA", referencedColumnName = "CODCONSULTASERASA")
    @ManyToOne
    private Consultaserasa codconsultaserasa;

    public Pendenciasinternas() {
    }

    public Pendenciasinternas(String codpendenciainternas) {
        this.codpendenciainternas = codpendenciainternas;
    }

    public String getCodpendenciainternas() {
        return codpendenciainternas;
    }

    public void setCodpendenciainternas(String codpendenciainternas) {
        this.codpendenciainternas = codpendenciainternas;
    }

    public Date getDataocorrencia() {
        return dataocorrencia;
    }

    public void setDataocorrencia(Date dataocorrencia) {
        this.dataocorrencia = dataocorrencia;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public String getAvalista() {
        return avalista;
    }

    public void setAvalista(String avalista) {
        this.avalista = avalista;
    }

    public String getTipomoeda() {
        return tipomoeda;
    }

    public void setTipomoeda(String tipomoeda) {
        this.tipomoeda = tipomoeda;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getContrato() {
        return contrato;
    }

    public void setContrato(String contrato) {
        this.contrato = contrato;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getSubjudice() {
        return subjudice;
    }

    public void setSubjudice(String subjudice) {
        this.subjudice = subjudice;
    }

    public String getSubjudicedescricao() {
        return subjudicedescricao;
    }

    public void setSubjudicedescricao(String subjudicedescricao) {
        this.subjudicedescricao = subjudicedescricao;
    }

    public String getTipoanotacao() {
        return tipoanotacao;
    }

    public void setTipoanotacao(String tipoanotacao) {
        this.tipoanotacao = tipoanotacao;
    }

    public String getTipoanotacaodescricao() {
        return tipoanotacaodescricao;
    }

    public void setTipoanotacaodescricao(String tipoanotacaodescricao) {
        this.tipoanotacaodescricao = tipoanotacaodescricao;
    }

    public Consultaserasa getCodconsultaserasa() {
        return codconsultaserasa;
    }

    public void setCodconsultaserasa(Consultaserasa codconsultaserasa) {
        this.codconsultaserasa = codconsultaserasa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codpendenciainternas != null ? codpendenciainternas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pendenciasinternas)) {
            return false;
        }
        Pendenciasinternas other = (Pendenciasinternas) object;
        if ((this.codpendenciainternas == null && other.codpendenciainternas != null) || (this.codpendenciainternas != null && !this.codpendenciainternas.equals(other.codpendenciainternas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Pendenciasinternas[ codpendenciainternas=" + codpendenciainternas + " ]";
    }
    
}
