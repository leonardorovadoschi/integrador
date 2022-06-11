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
@Table(name = "ALERTADOCUMENTO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alertadocumento.findAll", query = "SELECT a FROM Alertadocumento a")
    , @NamedQuery(name = "Alertadocumento.findByCodalertadocumento", query = "SELECT a FROM Alertadocumento a WHERE a.codalertadocumento = :codalertadocumento")
    , @NamedQuery(name = "Alertadocumento.findByMensagem", query = "SELECT a FROM Alertadocumento a WHERE a.mensagem = :mensagem")
    , @NamedQuery(name = "Alertadocumento.findByDdd1", query = "SELECT a FROM Alertadocumento a WHERE a.ddd1 = :ddd1")
    , @NamedQuery(name = "Alertadocumento.findByFone1", query = "SELECT a FROM Alertadocumento a WHERE a.fone1 = :fone1")
    , @NamedQuery(name = "Alertadocumento.findByDdd2", query = "SELECT a FROM Alertadocumento a WHERE a.ddd2 = :ddd2")
    , @NamedQuery(name = "Alertadocumento.findByFone2", query = "SELECT a FROM Alertadocumento a WHERE a.fone2 = :fone2")
    , @NamedQuery(name = "Alertadocumento.findByDdd3", query = "SELECT a FROM Alertadocumento a WHERE a.ddd3 = :ddd3")
    , @NamedQuery(name = "Alertadocumento.findByFone3", query = "SELECT a FROM Alertadocumento a WHERE a.fone3 = :fone3")
    , @NamedQuery(name = "Alertadocumento.findByNumeromensagem", query = "SELECT a FROM Alertadocumento a WHERE a.numeromensagem = :numeromensagem")
    , @NamedQuery(name = "Alertadocumento.findByTotalmensagens", query = "SELECT a FROM Alertadocumento a WHERE a.totalmensagens = :totalmensagens")
    , @NamedQuery(name = "Alertadocumento.findByTipodocumento", query = "SELECT a FROM Alertadocumento a WHERE a.tipodocumento = :tipodocumento")
    , @NamedQuery(name = "Alertadocumento.findByNumerodocumento", query = "SELECT a FROM Alertadocumento a WHERE a.numerodocumento = :numerodocumento")
    , @NamedQuery(name = "Alertadocumento.findByMotivoocorrencia", query = "SELECT a FROM Alertadocumento a WHERE a.motivoocorrencia = :motivoocorrencia")
    , @NamedQuery(name = "Alertadocumento.findByDataocorrencia", query = "SELECT a FROM Alertadocumento a WHERE a.dataocorrencia = :dataocorrencia")
    , @NamedQuery(name = "Alertadocumento.findByOutrosdados", query = "SELECT a FROM Alertadocumento a WHERE a.outrosdados = :outrosdados")})
public class Alertadocumento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODALERTADOCUMENTO")
    private String codalertadocumento;
    @Column(name = "MENSAGEM")
    private String mensagem;
    @Column(name = "DDD1")
    private String ddd1;
    @Column(name = "FONE1")
    private String fone1;
    @Column(name = "DDD2")
    private String ddd2;
    @Column(name = "FONE2")
    private String fone2;
    @Column(name = "DDD3")
    private String ddd3;
    @Column(name = "FONE3")
    private String fone3;
    @Column(name = "NUMEROMENSAGEM")
    private Integer numeromensagem;
    @Column(name = "TOTALMENSAGENS")
    private Integer totalmensagens;
    @Column(name = "TIPODOCUMENTO")
    private String tipodocumento;
    @Column(name = "NUMERODOCUMENTO")
    private String numerodocumento;
    @Column(name = "MOTIVOOCORRENCIA")
    private String motivoocorrencia;
    @Column(name = "DATAOCORRENCIA")
    @Temporal(TemporalType.DATE)
    private Date dataocorrencia;
    @Column(name = "OUTROSDADOS")
    private String outrosdados;
    @JoinColumn(name = "CODCONSULTASERASA", referencedColumnName = "CODCONSULTASERASA")
    @ManyToOne
    private Consultaserasa codconsultaserasa;

    public Alertadocumento() {
    }

    public Alertadocumento(String codalertadocumento) {
        this.codalertadocumento = codalertadocumento;
    }

    public String getCodalertadocumento() {
        return codalertadocumento;
    }

    public void setCodalertadocumento(String codalertadocumento) {
        this.codalertadocumento = codalertadocumento;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getDdd1() {
        return ddd1;
    }

    public void setDdd1(String ddd1) {
        this.ddd1 = ddd1;
    }

    public String getFone1() {
        return fone1;
    }

    public void setFone1(String fone1) {
        this.fone1 = fone1;
    }

    public String getDdd2() {
        return ddd2;
    }

    public void setDdd2(String ddd2) {
        this.ddd2 = ddd2;
    }

    public String getFone2() {
        return fone2;
    }

    public void setFone2(String fone2) {
        this.fone2 = fone2;
    }

    public String getDdd3() {
        return ddd3;
    }

    public void setDdd3(String ddd3) {
        this.ddd3 = ddd3;
    }

    public String getFone3() {
        return fone3;
    }

    public void setFone3(String fone3) {
        this.fone3 = fone3;
    }

    public Integer getNumeromensagem() {
        return numeromensagem;
    }

    public void setNumeromensagem(Integer numeromensagem) {
        this.numeromensagem = numeromensagem;
    }

    public Integer getTotalmensagens() {
        return totalmensagens;
    }

    public void setTotalmensagens(Integer totalmensagens) {
        this.totalmensagens = totalmensagens;
    }

    public String getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(String tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    public String getNumerodocumento() {
        return numerodocumento;
    }

    public void setNumerodocumento(String numerodocumento) {
        this.numerodocumento = numerodocumento;
    }

    public String getMotivoocorrencia() {
        return motivoocorrencia;
    }

    public void setMotivoocorrencia(String motivoocorrencia) {
        this.motivoocorrencia = motivoocorrencia;
    }

    public Date getDataocorrencia() {
        return dataocorrencia;
    }

    public void setDataocorrencia(Date dataocorrencia) {
        this.dataocorrencia = dataocorrencia;
    }

    public String getOutrosdados() {
        return outrosdados;
    }

    public void setOutrosdados(String outrosdados) {
        this.outrosdados = outrosdados;
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
        hash += (codalertadocumento != null ? codalertadocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alertadocumento)) {
            return false;
        }
        Alertadocumento other = (Alertadocumento) object;
        if ((this.codalertadocumento == null && other.codalertadocumento != null) || (this.codalertadocumento != null && !this.codalertadocumento.equals(other.codalertadocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Alertadocumento[ codalertadocumento=" + codalertadocumento + " ]";
    }
    
}
