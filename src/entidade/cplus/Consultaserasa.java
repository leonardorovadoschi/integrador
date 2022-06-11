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
@Table(name = "CONSULTASERASA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consultaserasa.findAll", query = "SELECT c FROM Consultaserasa c")
    , @NamedQuery(name = "Consultaserasa.findByCodconsultaserasa", query = "SELECT c FROM Consultaserasa c WHERE c.codconsultaserasa = :codconsultaserasa")
    , @NamedQuery(name = "Consultaserasa.findByCpfCnpj", query = "SELECT c FROM Consultaserasa c WHERE c.cpfCnpj = :cpfCnpj")
    , @NamedQuery(name = "Consultaserasa.findByDataconsulta", query = "SELECT c FROM Consultaserasa c WHERE c.dataconsulta = :dataconsulta")
    , @NamedQuery(name = "Consultaserasa.findByNomecli", query = "SELECT c FROM Consultaserasa c WHERE c.nomecli = :nomecli")
    , @NamedQuery(name = "Consultaserasa.findByNomemae", query = "SELECT c FROM Consultaserasa c WHERE c.nomemae = :nomemae")
    , @NamedQuery(name = "Consultaserasa.findByDtnasc", query = "SELECT c FROM Consultaserasa c WHERE c.dtnasc = :dtnasc")
    , @NamedQuery(name = "Consultaserasa.findByTotalocorrencias", query = "SELECT c FROM Consultaserasa c WHERE c.totalocorrencias = :totalocorrencias")
    , @NamedQuery(name = "Consultaserasa.findByNomefantasia", query = "SELECT c FROM Consultaserasa c WHERE c.nomefantasia = :nomefantasia")
    , @NamedQuery(name = "Consultaserasa.findByDatafundacao", query = "SELECT c FROM Consultaserasa c WHERE c.datafundacao = :datafundacao")
    , @NamedQuery(name = "Consultaserasa.findBySituacaorfb", query = "SELECT c FROM Consultaserasa c WHERE c.situacaorfb = :situacaorfb")
    , @NamedQuery(name = "Consultaserasa.findBySituacaodescricaorfb", query = "SELECT c FROM Consultaserasa c WHERE c.situacaodescricaorfb = :situacaodescricaorfb")
    , @NamedQuery(name = "Consultaserasa.findByDatasituacaorfb", query = "SELECT c FROM Consultaserasa c WHERE c.datasituacaorfb = :datasituacaorfb")
    , @NamedQuery(name = "Consultaserasa.findByEstado", query = "SELECT c FROM Consultaserasa c WHERE c.estado = :estado")
    , @NamedQuery(name = "Consultaserasa.findByItemadicional1", query = "SELECT c FROM Consultaserasa c WHERE c.itemadicional1 = :itemadicional1")
    , @NamedQuery(name = "Consultaserasa.findByItemadicional2", query = "SELECT c FROM Consultaserasa c WHERE c.itemadicional2 = :itemadicional2")
    , @NamedQuery(name = "Consultaserasa.findByBanco", query = "SELECT c FROM Consultaserasa c WHERE c.banco = :banco")
    , @NamedQuery(name = "Consultaserasa.findByAgencia", query = "SELECT c FROM Consultaserasa c WHERE c.agencia = :agencia")
    , @NamedQuery(name = "Consultaserasa.findByContacorrente", query = "SELECT c FROM Consultaserasa c WHERE c.contacorrente = :contacorrente")
    , @NamedQuery(name = "Consultaserasa.findByChequeini", query = "SELECT c FROM Consultaserasa c WHERE c.chequeini = :chequeini")
    , @NamedQuery(name = "Consultaserasa.findByChequefim", query = "SELECT c FROM Consultaserasa c WHERE c.chequefim = :chequefim")
    , @NamedQuery(name = "Consultaserasa.findByFlagtipoconsulta", query = "SELECT c FROM Consultaserasa c WHERE c.flagtipoconsulta = :flagtipoconsulta")})
public class Consultaserasa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCONSULTASERASA")
    private String codconsultaserasa;
    @Column(name = "CPF_CNPJ")
    private String cpfCnpj;
    @Column(name = "DATACONSULTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataconsulta;
    @Column(name = "NOMECLI")
    private String nomecli;
    @Column(name = "NOMEMAE")
    private String nomemae;
    @Column(name = "DTNASC")
    @Temporal(TemporalType.DATE)
    private Date dtnasc;
    @Column(name = "TOTALOCORRENCIAS")
    private Integer totalocorrencias;
    @Column(name = "NOMEFANTASIA")
    private String nomefantasia;
    @Column(name = "DATAFUNDACAO")
    @Temporal(TemporalType.DATE)
    private Date datafundacao;
    @Column(name = "SITUACAORFB")
    private Integer situacaorfb;
    @Column(name = "SITUACAODESCRICAORFB")
    private String situacaodescricaorfb;
    @Column(name = "DATASITUACAORFB")
    @Temporal(TemporalType.DATE)
    private Date datasituacaorfb;
    @Lob
    @Column(name = "XMLRETORNO")
    private String xmlretorno;
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "ITEMADICIONAL1")
    private String itemadicional1;
    @Column(name = "ITEMADICIONAL2")
    private String itemadicional2;
    @Column(name = "BANCO")
    private String banco;
    @Column(name = "AGENCIA")
    private String agencia;
    @Column(name = "CONTACORRENTE")
    private String contacorrente;
    @Column(name = "CHEQUEINI")
    private String chequeini;
    @Column(name = "CHEQUEFIM")
    private String chequefim;
    @Column(name = "FLAGTIPOCONSULTA")
    private Integer flagtipoconsulta;
    @OneToMany(mappedBy = "codconsultaserasa")
    private Collection<Pendenciabacen> pendenciabacenCollection;
    @OneToMany(mappedBy = "codconsultaserasa")
    private Collection<Pendenciavarejo> pendenciavarejoCollection;
    @OneToMany(mappedBy = "codconsultaserasa")
    private Collection<Pendenciafinaceira> pendenciafinaceiraCollection;
    @OneToMany(mappedBy = "codconsultaserasa")
    private Collection<Pendenciasinternas> pendenciasinternasCollection;
    @OneToMany(mappedBy = "codconsultaserasa")
    private Collection<Historicoserasa> historicoserasaCollection;
    @OneToMany(mappedBy = "codconsultaserasa")
    private Collection<Alertadocumento> alertadocumentoCollection;

    public Consultaserasa() {
    }

    public Consultaserasa(String codconsultaserasa) {
        this.codconsultaserasa = codconsultaserasa;
    }

    public String getCodconsultaserasa() {
        return codconsultaserasa;
    }

    public void setCodconsultaserasa(String codconsultaserasa) {
        this.codconsultaserasa = codconsultaserasa;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public Date getDataconsulta() {
        return dataconsulta;
    }

    public void setDataconsulta(Date dataconsulta) {
        this.dataconsulta = dataconsulta;
    }

    public String getNomecli() {
        return nomecli;
    }

    public void setNomecli(String nomecli) {
        this.nomecli = nomecli;
    }

    public String getNomemae() {
        return nomemae;
    }

    public void setNomemae(String nomemae) {
        this.nomemae = nomemae;
    }

    public Date getDtnasc() {
        return dtnasc;
    }

    public void setDtnasc(Date dtnasc) {
        this.dtnasc = dtnasc;
    }

    public Integer getTotalocorrencias() {
        return totalocorrencias;
    }

    public void setTotalocorrencias(Integer totalocorrencias) {
        this.totalocorrencias = totalocorrencias;
    }

    public String getNomefantasia() {
        return nomefantasia;
    }

    public void setNomefantasia(String nomefantasia) {
        this.nomefantasia = nomefantasia;
    }

    public Date getDatafundacao() {
        return datafundacao;
    }

    public void setDatafundacao(Date datafundacao) {
        this.datafundacao = datafundacao;
    }

    public Integer getSituacaorfb() {
        return situacaorfb;
    }

    public void setSituacaorfb(Integer situacaorfb) {
        this.situacaorfb = situacaorfb;
    }

    public String getSituacaodescricaorfb() {
        return situacaodescricaorfb;
    }

    public void setSituacaodescricaorfb(String situacaodescricaorfb) {
        this.situacaodescricaorfb = situacaodescricaorfb;
    }

    public Date getDatasituacaorfb() {
        return datasituacaorfb;
    }

    public void setDatasituacaorfb(Date datasituacaorfb) {
        this.datasituacaorfb = datasituacaorfb;
    }

    public String getXmlretorno() {
        return xmlretorno;
    }

    public void setXmlretorno(String xmlretorno) {
        this.xmlretorno = xmlretorno;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getItemadicional1() {
        return itemadicional1;
    }

    public void setItemadicional1(String itemadicional1) {
        this.itemadicional1 = itemadicional1;
    }

    public String getItemadicional2() {
        return itemadicional2;
    }

    public void setItemadicional2(String itemadicional2) {
        this.itemadicional2 = itemadicional2;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getContacorrente() {
        return contacorrente;
    }

    public void setContacorrente(String contacorrente) {
        this.contacorrente = contacorrente;
    }

    public String getChequeini() {
        return chequeini;
    }

    public void setChequeini(String chequeini) {
        this.chequeini = chequeini;
    }

    public String getChequefim() {
        return chequefim;
    }

    public void setChequefim(String chequefim) {
        this.chequefim = chequefim;
    }

    public Integer getFlagtipoconsulta() {
        return flagtipoconsulta;
    }

    public void setFlagtipoconsulta(Integer flagtipoconsulta) {
        this.flagtipoconsulta = flagtipoconsulta;
    }

    @XmlTransient
    public Collection<Pendenciabacen> getPendenciabacenCollection() {
        return pendenciabacenCollection;
    }

    public void setPendenciabacenCollection(Collection<Pendenciabacen> pendenciabacenCollection) {
        this.pendenciabacenCollection = pendenciabacenCollection;
    }

    @XmlTransient
    public Collection<Pendenciavarejo> getPendenciavarejoCollection() {
        return pendenciavarejoCollection;
    }

    public void setPendenciavarejoCollection(Collection<Pendenciavarejo> pendenciavarejoCollection) {
        this.pendenciavarejoCollection = pendenciavarejoCollection;
    }

    @XmlTransient
    public Collection<Pendenciafinaceira> getPendenciafinaceiraCollection() {
        return pendenciafinaceiraCollection;
    }

    public void setPendenciafinaceiraCollection(Collection<Pendenciafinaceira> pendenciafinaceiraCollection) {
        this.pendenciafinaceiraCollection = pendenciafinaceiraCollection;
    }

    @XmlTransient
    public Collection<Pendenciasinternas> getPendenciasinternasCollection() {
        return pendenciasinternasCollection;
    }

    public void setPendenciasinternasCollection(Collection<Pendenciasinternas> pendenciasinternasCollection) {
        this.pendenciasinternasCollection = pendenciasinternasCollection;
    }

    @XmlTransient
    public Collection<Historicoserasa> getHistoricoserasaCollection() {
        return historicoserasaCollection;
    }

    public void setHistoricoserasaCollection(Collection<Historicoserasa> historicoserasaCollection) {
        this.historicoserasaCollection = historicoserasaCollection;
    }

    @XmlTransient
    public Collection<Alertadocumento> getAlertadocumentoCollection() {
        return alertadocumentoCollection;
    }

    public void setAlertadocumentoCollection(Collection<Alertadocumento> alertadocumentoCollection) {
        this.alertadocumentoCollection = alertadocumentoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codconsultaserasa != null ? codconsultaserasa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consultaserasa)) {
            return false;
        }
        Consultaserasa other = (Consultaserasa) object;
        if ((this.codconsultaserasa == null && other.codconsultaserasa != null) || (this.codconsultaserasa != null && !this.codconsultaserasa.equals(other.codconsultaserasa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Consultaserasa[ codconsultaserasa=" + codconsultaserasa + " ]";
    }
    
}
