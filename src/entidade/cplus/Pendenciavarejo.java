/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "PENDENCIAVAREJO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pendenciavarejo.findAll", query = "SELECT p FROM Pendenciavarejo p")
    , @NamedQuery(name = "Pendenciavarejo.findByCodpendenciavarejo", query = "SELECT p FROM Pendenciavarejo p WHERE p.codpendenciavarejo = :codpendenciavarejo")
    , @NamedQuery(name = "Pendenciavarejo.findByCodigocompensacaobanco", query = "SELECT p FROM Pendenciavarejo p WHERE p.codigocompensacaobanco = :codigocompensacaobanco")
    , @NamedQuery(name = "Pendenciavarejo.findByNumeroagencia", query = "SELECT p FROM Pendenciavarejo p WHERE p.numeroagencia = :numeroagencia")
    , @NamedQuery(name = "Pendenciavarejo.findBySigla", query = "SELECT p FROM Pendenciavarejo p WHERE p.sigla = :sigla")
    , @NamedQuery(name = "Pendenciavarejo.findByNumerolojafilial", query = "SELECT p FROM Pendenciavarejo p WHERE p.numerolojafilial = :numerolojafilial")})
public class Pendenciavarejo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODPENDENCIAVAREJO")
    private String codpendenciavarejo;
    @Column(name = "CODIGOCOMPENSACAOBANCO")
    private String codigocompensacaobanco;
    @Column(name = "NUMEROAGENCIA")
    private String numeroagencia;
    @Column(name = "SIGLA")
    private String sigla;
    @Column(name = "NUMEROLOJAFILIAL")
    private String numerolojafilial;
    @JoinColumn(name = "CODCONSULTASERASA", referencedColumnName = "CODCONSULTASERASA")
    @ManyToOne
    private Consultaserasa codconsultaserasa;

    public Pendenciavarejo() {
    }

    public Pendenciavarejo(String codpendenciavarejo) {
        this.codpendenciavarejo = codpendenciavarejo;
    }

    public String getCodpendenciavarejo() {
        return codpendenciavarejo;
    }

    public void setCodpendenciavarejo(String codpendenciavarejo) {
        this.codpendenciavarejo = codpendenciavarejo;
    }

    public String getCodigocompensacaobanco() {
        return codigocompensacaobanco;
    }

    public void setCodigocompensacaobanco(String codigocompensacaobanco) {
        this.codigocompensacaobanco = codigocompensacaobanco;
    }

    public String getNumeroagencia() {
        return numeroagencia;
    }

    public void setNumeroagencia(String numeroagencia) {
        this.numeroagencia = numeroagencia;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNumerolojafilial() {
        return numerolojafilial;
    }

    public void setNumerolojafilial(String numerolojafilial) {
        this.numerolojafilial = numerolojafilial;
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
        hash += (codpendenciavarejo != null ? codpendenciavarejo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pendenciavarejo)) {
            return false;
        }
        Pendenciavarejo other = (Pendenciavarejo) object;
        if ((this.codpendenciavarejo == null && other.codpendenciavarejo != null) || (this.codpendenciavarejo != null && !this.codpendenciavarejo.equals(other.codpendenciavarejo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Pendenciavarejo[ codpendenciavarejo=" + codpendenciavarejo + " ]";
    }
    
}
