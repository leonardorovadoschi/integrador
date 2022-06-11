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
@Table(name = "PENDENCIAFINACEIRA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pendenciafinaceira.findAll", query = "SELECT p FROM Pendenciafinaceira p")
    , @NamedQuery(name = "Pendenciafinaceira.findByCodpendenciafinaceira", query = "SELECT p FROM Pendenciafinaceira p WHERE p.codpendenciafinaceira = :codpendenciafinaceira")
    , @NamedQuery(name = "Pendenciafinaceira.findByDataocorrencia", query = "SELECT p FROM Pendenciafinaceira p WHERE p.dataocorrencia = :dataocorrencia")
    , @NamedQuery(name = "Pendenciafinaceira.findByModalidade", query = "SELECT p FROM Pendenciafinaceira p WHERE p.modalidade = :modalidade")
    , @NamedQuery(name = "Pendenciafinaceira.findByAvalista", query = "SELECT p FROM Pendenciafinaceira p WHERE p.avalista = :avalista")
    , @NamedQuery(name = "Pendenciafinaceira.findByValor", query = "SELECT p FROM Pendenciafinaceira p WHERE p.valor = :valor")
    , @NamedQuery(name = "Pendenciafinaceira.findByContrato", query = "SELECT p FROM Pendenciafinaceira p WHERE p.contrato = :contrato")
    , @NamedQuery(name = "Pendenciafinaceira.findByOrigem", query = "SELECT p FROM Pendenciafinaceira p WHERE p.origem = :origem")
    , @NamedQuery(name = "Pendenciafinaceira.findBySigla", query = "SELECT p FROM Pendenciafinaceira p WHERE p.sigla = :sigla")
    , @NamedQuery(name = "Pendenciafinaceira.findByTipomoeda", query = "SELECT p FROM Pendenciafinaceira p WHERE p.tipomoeda = :tipomoeda")
    , @NamedQuery(name = "Pendenciafinaceira.findBySubjudice", query = "SELECT p FROM Pendenciafinaceira p WHERE p.subjudice = :subjudice")
    , @NamedQuery(name = "Pendenciafinaceira.findBySubjudicedescricao", query = "SELECT p FROM Pendenciafinaceira p WHERE p.subjudicedescricao = :subjudicedescricao")
    , @NamedQuery(name = "Pendenciafinaceira.findByTipoanotacao", query = "SELECT p FROM Pendenciafinaceira p WHERE p.tipoanotacao = :tipoanotacao")
    , @NamedQuery(name = "Pendenciafinaceira.findByTipoanotacaodescricao", query = "SELECT p FROM Pendenciafinaceira p WHERE p.tipoanotacaodescricao = :tipoanotacaodescricao")})
public class Pendenciafinaceira implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODPENDENCIAFINACEIRA")
    private String codpendenciafinaceira;
    @Column(name = "DATAOCORRENCIA")
    @Temporal(TemporalType.DATE)
    private Date dataocorrencia;
    @Column(name = "MODALIDADE")
    private String modalidade;
    @Column(name = "AVALISTA")
    private Character avalista;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALOR")
    private BigDecimal valor;
    @Column(name = "CONTRATO")
    private String contrato;
    @Column(name = "ORIGEM")
    private String origem;
    @Column(name = "SIGLA")
    private String sigla;
    @Column(name = "TIPOMOEDA")
    private String tipomoeda;
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

    public Pendenciafinaceira() {
    }

    public Pendenciafinaceira(String codpendenciafinaceira) {
        this.codpendenciafinaceira = codpendenciafinaceira;
    }

    public String getCodpendenciafinaceira() {
        return codpendenciafinaceira;
    }

    public void setCodpendenciafinaceira(String codpendenciafinaceira) {
        this.codpendenciafinaceira = codpendenciafinaceira;
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

    public Character getAvalista() {
        return avalista;
    }

    public void setAvalista(Character avalista) {
        this.avalista = avalista;
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

    public String getTipomoeda() {
        return tipomoeda;
    }

    public void setTipomoeda(String tipomoeda) {
        this.tipomoeda = tipomoeda;
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
        hash += (codpendenciafinaceira != null ? codpendenciafinaceira.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pendenciafinaceira)) {
            return false;
        }
        Pendenciafinaceira other = (Pendenciafinaceira) object;
        if ((this.codpendenciafinaceira == null && other.codpendenciafinaceira != null) || (this.codpendenciafinaceira != null && !this.codpendenciafinaceira.equals(other.codpendenciafinaceira))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Pendenciafinaceira[ codpendenciafinaceira=" + codpendenciafinaceira + " ]";
    }
    
}
