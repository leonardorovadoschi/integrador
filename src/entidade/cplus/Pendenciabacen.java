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
@Table(name = "PENDENCIABACEN", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pendenciabacen.findAll", query = "SELECT p FROM Pendenciabacen p")
    , @NamedQuery(name = "Pendenciabacen.findByCodpendenciabacen", query = "SELECT p FROM Pendenciabacen p WHERE p.codpendenciabacen = :codpendenciabacen")
    , @NamedQuery(name = "Pendenciabacen.findByTotalchequessemfundo", query = "SELECT p FROM Pendenciabacen p WHERE p.totalchequessemfundo = :totalchequessemfundo")
    , @NamedQuery(name = "Pendenciabacen.findByDataocorrenciaantiga", query = "SELECT p FROM Pendenciabacen p WHERE p.dataocorrenciaantiga = :dataocorrenciaantiga")
    , @NamedQuery(name = "Pendenciabacen.findByDataocorrenciarecente", query = "SELECT p FROM Pendenciabacen p WHERE p.dataocorrenciarecente = :dataocorrenciarecente")
    , @NamedQuery(name = "Pendenciabacen.findByAlineacheque", query = "SELECT p FROM Pendenciabacen p WHERE p.alineacheque = :alineacheque")
    , @NamedQuery(name = "Pendenciabacen.findByAgencia", query = "SELECT p FROM Pendenciabacen p WHERE p.agencia = :agencia")
    , @NamedQuery(name = "Pendenciabacen.findByNomebanco", query = "SELECT p FROM Pendenciabacen p WHERE p.nomebanco = :nomebanco")
    , @NamedQuery(name = "Pendenciabacen.findByDataocorrencia", query = "SELECT p FROM Pendenciabacen p WHERE p.dataocorrencia = :dataocorrencia")
    , @NamedQuery(name = "Pendenciabacen.findByNumerocheque", query = "SELECT p FROM Pendenciabacen p WHERE p.numerocheque = :numerocheque")
    , @NamedQuery(name = "Pendenciabacen.findByQuantidadeccfbanco", query = "SELECT p FROM Pendenciabacen p WHERE p.quantidadeccfbanco = :quantidadeccfbanco")
    , @NamedQuery(name = "Pendenciabacen.findByValor", query = "SELECT p FROM Pendenciabacen p WHERE p.valor = :valor")
    , @NamedQuery(name = "Pendenciabacen.findByCidade", query = "SELECT p FROM Pendenciabacen p WHERE p.cidade = :cidade")
    , @NamedQuery(name = "Pendenciabacen.findByUf", query = "SELECT p FROM Pendenciabacen p WHERE p.uf = :uf")
    , @NamedQuery(name = "Pendenciabacen.findByBanco", query = "SELECT p FROM Pendenciabacen p WHERE p.banco = :banco")})
public class Pendenciabacen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODPENDENCIABACEN")
    private String codpendenciabacen;
    @Column(name = "TOTALCHEQUESSEMFUNDO")
    private Integer totalchequessemfundo;
    @Column(name = "DATAOCORRENCIAANTIGA")
    @Temporal(TemporalType.DATE)
    private Date dataocorrenciaantiga;
    @Column(name = "DATAOCORRENCIARECENTE")
    @Temporal(TemporalType.DATE)
    private Date dataocorrenciarecente;
    @Column(name = "ALINEACHEQUE")
    private String alineacheque;
    @Column(name = "AGENCIA")
    private String agencia;
    @Column(name = "NOMEBANCO")
    private String nomebanco;
    @Column(name = "DATAOCORRENCIA")
    @Temporal(TemporalType.DATE)
    private Date dataocorrencia;
    @Column(name = "NUMEROCHEQUE")
    private String numerocheque;
    @Column(name = "QUANTIDADECCFBANCO")
    private String quantidadeccfbanco;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALOR")
    private BigDecimal valor;
    @Column(name = "CIDADE")
    private String cidade;
    @Column(name = "UF")
    private String uf;
    @Column(name = "BANCO")
    private String banco;
    @JoinColumn(name = "CODCONSULTASERASA", referencedColumnName = "CODCONSULTASERASA")
    @ManyToOne
    private Consultaserasa codconsultaserasa;

    public Pendenciabacen() {
    }

    public Pendenciabacen(String codpendenciabacen) {
        this.codpendenciabacen = codpendenciabacen;
    }

    public String getCodpendenciabacen() {
        return codpendenciabacen;
    }

    public void setCodpendenciabacen(String codpendenciabacen) {
        this.codpendenciabacen = codpendenciabacen;
    }

    public Integer getTotalchequessemfundo() {
        return totalchequessemfundo;
    }

    public void setTotalchequessemfundo(Integer totalchequessemfundo) {
        this.totalchequessemfundo = totalchequessemfundo;
    }

    public Date getDataocorrenciaantiga() {
        return dataocorrenciaantiga;
    }

    public void setDataocorrenciaantiga(Date dataocorrenciaantiga) {
        this.dataocorrenciaantiga = dataocorrenciaantiga;
    }

    public Date getDataocorrenciarecente() {
        return dataocorrenciarecente;
    }

    public void setDataocorrenciarecente(Date dataocorrenciarecente) {
        this.dataocorrenciarecente = dataocorrenciarecente;
    }

    public String getAlineacheque() {
        return alineacheque;
    }

    public void setAlineacheque(String alineacheque) {
        this.alineacheque = alineacheque;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNomebanco() {
        return nomebanco;
    }

    public void setNomebanco(String nomebanco) {
        this.nomebanco = nomebanco;
    }

    public Date getDataocorrencia() {
        return dataocorrencia;
    }

    public void setDataocorrencia(Date dataocorrencia) {
        this.dataocorrencia = dataocorrencia;
    }

    public String getNumerocheque() {
        return numerocheque;
    }

    public void setNumerocheque(String numerocheque) {
        this.numerocheque = numerocheque;
    }

    public String getQuantidadeccfbanco() {
        return quantidadeccfbanco;
    }

    public void setQuantidadeccfbanco(String quantidadeccfbanco) {
        this.quantidadeccfbanco = quantidadeccfbanco;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
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
        hash += (codpendenciabacen != null ? codpendenciabacen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pendenciabacen)) {
            return false;
        }
        Pendenciabacen other = (Pendenciabacen) object;
        if ((this.codpendenciabacen == null && other.codpendenciabacen != null) || (this.codpendenciabacen != null && !this.codpendenciabacen.equals(other.codpendenciabacen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Pendenciabacen[ codpendenciabacen=" + codpendenciabacen + " ]";
    }
    
}
