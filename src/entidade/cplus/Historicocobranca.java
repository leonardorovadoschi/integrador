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
@Table(name = "HISTORICOCOBRANCA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Historicocobranca.findAll", query = "SELECT h FROM Historicocobranca h")
    , @NamedQuery(name = "Historicocobranca.findByCodhistoricocobranca", query = "SELECT h FROM Historicocobranca h WHERE h.codhistoricocobranca = :codhistoricocobranca")
    , @NamedQuery(name = "Historicocobranca.findByNomeentidadeorigem", query = "SELECT h FROM Historicocobranca h WHERE h.nomeentidadeorigem = :nomeentidadeorigem")
    , @NamedQuery(name = "Historicocobranca.findByIdentidadeorigem", query = "SELECT h FROM Historicocobranca h WHERE h.identidadeorigem = :identidadeorigem")
    , @NamedQuery(name = "Historicocobranca.findByDatavencimento", query = "SELECT h FROM Historicocobranca h WHERE h.datavencimento = :datavencimento")
    , @NamedQuery(name = "Historicocobranca.findByDatareferencia", query = "SELECT h FROM Historicocobranca h WHERE h.datareferencia = :datareferencia")
    , @NamedQuery(name = "Historicocobranca.findByCoduser", query = "SELECT h FROM Historicocobranca h WHERE h.coduser = :coduser")
    , @NamedQuery(name = "Historicocobranca.findByValor", query = "SELECT h FROM Historicocobranca h WHERE h.valor = :valor")
    , @NamedQuery(name = "Historicocobranca.findByCodclirepasse", query = "SELECT h FROM Historicocobranca h WHERE h.codclirepasse = :codclirepasse")})
public class Historicocobranca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODHISTORICOCOBRANCA")
    private String codhistoricocobranca;
    @Column(name = "NOMEENTIDADEORIGEM")
    private String nomeentidadeorigem;
    @Column(name = "IDENTIDADEORIGEM")
    private String identidadeorigem;
    @Column(name = "DATAVENCIMENTO")
    @Temporal(TemporalType.DATE)
    private Date datavencimento;
    @Column(name = "DATAREFERENCIA")
    @Temporal(TemporalType.DATE)
    private Date datareferencia;
    @Column(name = "CODUSER")
    private String coduser;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALOR")
    private BigDecimal valor;
    @Column(name = "CODCLIREPASSE")
    private String codclirepasse;
    @JoinColumn(name = "CODCR", referencedColumnName = "CODCR")
    @ManyToOne
    private Contareceber codcr;

    public Historicocobranca() {
    }

    public Historicocobranca(String codhistoricocobranca) {
        this.codhistoricocobranca = codhistoricocobranca;
    }

    public String getCodhistoricocobranca() {
        return codhistoricocobranca;
    }

    public void setCodhistoricocobranca(String codhistoricocobranca) {
        this.codhistoricocobranca = codhistoricocobranca;
    }

    public String getNomeentidadeorigem() {
        return nomeentidadeorigem;
    }

    public void setNomeentidadeorigem(String nomeentidadeorigem) {
        this.nomeentidadeorigem = nomeentidadeorigem;
    }

    public String getIdentidadeorigem() {
        return identidadeorigem;
    }

    public void setIdentidadeorigem(String identidadeorigem) {
        this.identidadeorigem = identidadeorigem;
    }

    public Date getDatavencimento() {
        return datavencimento;
    }

    public void setDatavencimento(Date datavencimento) {
        this.datavencimento = datavencimento;
    }

    public Date getDatareferencia() {
        return datareferencia;
    }

    public void setDatareferencia(Date datareferencia) {
        this.datareferencia = datareferencia;
    }

    public String getCoduser() {
        return coduser;
    }

    public void setCoduser(String coduser) {
        this.coduser = coduser;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getCodclirepasse() {
        return codclirepasse;
    }

    public void setCodclirepasse(String codclirepasse) {
        this.codclirepasse = codclirepasse;
    }

    public Contareceber getCodcr() {
        return codcr;
    }

    public void setCodcr(Contareceber codcr) {
        this.codcr = codcr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codhistoricocobranca != null ? codhistoricocobranca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Historicocobranca)) {
            return false;
        }
        Historicocobranca other = (Historicocobranca) object;
        if ((this.codhistoricocobranca == null && other.codhistoricocobranca != null) || (this.codhistoricocobranca != null && !this.codhistoricocobranca.equals(other.codhistoricocobranca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Historicocobranca[ codhistoricocobranca=" + codhistoricocobranca + " ]";
    }
    
}
