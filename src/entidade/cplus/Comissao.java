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
@Table(name = "COMISSAO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comissao.findAll", query = "SELECT c FROM Comissao c")
    , @NamedQuery(name = "Comissao.findByCodcomissao", query = "SELECT c FROM Comissao c WHERE c.codcomissao = :codcomissao")
    , @NamedQuery(name = "Comissao.findByNomeentidadeorigem", query = "SELECT c FROM Comissao c WHERE c.nomeentidadeorigem = :nomeentidadeorigem")
    , @NamedQuery(name = "Comissao.findByIdentidadeorigem", query = "SELECT c FROM Comissao c WHERE c.identidadeorigem = :identidadeorigem")
    , @NamedQuery(name = "Comissao.findByCodvended", query = "SELECT c FROM Comissao c WHERE c.codvended = :codvended")
    , @NamedQuery(name = "Comissao.findByValorbasecomissao", query = "SELECT c FROM Comissao c WHERE c.valorbasecomissao = :valorbasecomissao")
    , @NamedQuery(name = "Comissao.findByFlagtipocomissao", query = "SELECT c FROM Comissao c WHERE c.flagtipocomissao = :flagtipocomissao")
    , @NamedQuery(name = "Comissao.findByAliqcomissao", query = "SELECT c FROM Comissao c WHERE c.aliqcomissao = :aliqcomissao")
    , @NamedQuery(name = "Comissao.findByValorcomissao", query = "SELECT c FROM Comissao c WHERE c.valorcomissao = :valorcomissao")
    , @NamedQuery(name = "Comissao.findByFlagquitada", query = "SELECT c FROM Comissao c WHERE c.flagquitada = :flagquitada")
    , @NamedQuery(name = "Comissao.findByFlagaliquota", query = "SELECT c FROM Comissao c WHERE c.flagaliquota = :flagaliquota")
    , @NamedQuery(name = "Comissao.findByDatacomissao", query = "SELECT c FROM Comissao c WHERE c.datacomissao = :datacomissao")
    , @NamedQuery(name = "Comissao.findByDataquitacao", query = "SELECT c FROM Comissao c WHERE c.dataquitacao = :dataquitacao")
    , @NamedQuery(name = "Comissao.findByDatadesconto", query = "SELECT c FROM Comissao c WHERE c.datadesconto = :datadesconto")
    , @NamedQuery(name = "Comissao.findByDatacancelamento", query = "SELECT c FROM Comissao c WHERE c.datacancelamento = :datacancelamento")
    , @NamedQuery(name = "Comissao.findByDataquitacaodesconto", query = "SELECT c FROM Comissao c WHERE c.dataquitacaodesconto = :dataquitacaodesconto")
    , @NamedQuery(name = "Comissao.findByCodmoveprod", query = "SELECT c FROM Comissao c WHERE c.codmoveprod = :codmoveprod")
    , @NamedQuery(name = "Comissao.findByLotequitacao", query = "SELECT c FROM Comissao c WHERE c.lotequitacao = :lotequitacao")})
public class Comissao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCOMISSAO")
    private Integer codcomissao;
    @Column(name = "NOMEENTIDADEORIGEM")
    private String nomeentidadeorigem;
    @Column(name = "IDENTIDADEORIGEM")
    private String identidadeorigem;
    @Column(name = "CODVENDED")
    private String codvended;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALORBASECOMISSAO")
    private BigDecimal valorbasecomissao;
    @Column(name = "FLAGTIPOCOMISSAO")
    private Character flagtipocomissao;
    @Column(name = "ALIQCOMISSAO")
    private BigDecimal aliqcomissao;
    @Column(name = "VALORCOMISSAO")
    private BigDecimal valorcomissao;
    @Column(name = "FLAGQUITADA")
    private Character flagquitada;
    @Column(name = "FLAGALIQUOTA")
    private Character flagaliquota;
    @Column(name = "DATACOMISSAO")
    @Temporal(TemporalType.DATE)
    private Date datacomissao;
    @Column(name = "DATAQUITACAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataquitacao;
    @Column(name = "DATADESCONTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datadesconto;
    @Column(name = "DATACANCELAMENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datacancelamento;
    @Column(name = "DATAQUITACAODESCONTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataquitacaodesconto;
    @Column(name = "CODMOVEPROD")
    private String codmoveprod;
    @Column(name = "LOTEQUITACAO")
    private Integer lotequitacao;
    @JoinColumn(name = "CODMOVPROD", referencedColumnName = "CODMOVPROD")
    @ManyToOne
    private Movendaprod codmovprod;

    public Comissao() {
    }

    public Comissao(Integer codcomissao) {
        this.codcomissao = codcomissao;
    }

    public Integer getCodcomissao() {
        return codcomissao;
    }

    public void setCodcomissao(Integer codcomissao) {
        this.codcomissao = codcomissao;
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

    public String getCodvended() {
        return codvended;
    }

    public void setCodvended(String codvended) {
        this.codvended = codvended;
    }

    public BigDecimal getValorbasecomissao() {
        return valorbasecomissao;
    }

    public void setValorbasecomissao(BigDecimal valorbasecomissao) {
        this.valorbasecomissao = valorbasecomissao;
    }

    public Character getFlagtipocomissao() {
        return flagtipocomissao;
    }

    public void setFlagtipocomissao(Character flagtipocomissao) {
        this.flagtipocomissao = flagtipocomissao;
    }

    public BigDecimal getAliqcomissao() {
        return aliqcomissao;
    }

    public void setAliqcomissao(BigDecimal aliqcomissao) {
        this.aliqcomissao = aliqcomissao;
    }

    public BigDecimal getValorcomissao() {
        return valorcomissao;
    }

    public void setValorcomissao(BigDecimal valorcomissao) {
        this.valorcomissao = valorcomissao;
    }

    public Character getFlagquitada() {
        return flagquitada;
    }

    public void setFlagquitada(Character flagquitada) {
        this.flagquitada = flagquitada;
    }

    public Character getFlagaliquota() {
        return flagaliquota;
    }

    public void setFlagaliquota(Character flagaliquota) {
        this.flagaliquota = flagaliquota;
    }

    public Date getDatacomissao() {
        return datacomissao;
    }

    public void setDatacomissao(Date datacomissao) {
        this.datacomissao = datacomissao;
    }

    public Date getDataquitacao() {
        return dataquitacao;
    }

    public void setDataquitacao(Date dataquitacao) {
        this.dataquitacao = dataquitacao;
    }

    public Date getDatadesconto() {
        return datadesconto;
    }

    public void setDatadesconto(Date datadesconto) {
        this.datadesconto = datadesconto;
    }

    public Date getDatacancelamento() {
        return datacancelamento;
    }

    public void setDatacancelamento(Date datacancelamento) {
        this.datacancelamento = datacancelamento;
    }

    public Date getDataquitacaodesconto() {
        return dataquitacaodesconto;
    }

    public void setDataquitacaodesconto(Date dataquitacaodesconto) {
        this.dataquitacaodesconto = dataquitacaodesconto;
    }

    public String getCodmoveprod() {
        return codmoveprod;
    }

    public void setCodmoveprod(String codmoveprod) {
        this.codmoveprod = codmoveprod;
    }

    public Integer getLotequitacao() {
        return lotequitacao;
    }

    public void setLotequitacao(Integer lotequitacao) {
        this.lotequitacao = lotequitacao;
    }

    public Movendaprod getCodmovprod() {
        return codmovprod;
    }

    public void setCodmovprod(Movendaprod codmovprod) {
        this.codmovprod = codmovprod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcomissao != null ? codcomissao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comissao)) {
            return false;
        }
        Comissao other = (Comissao) object;
        if ((this.codcomissao == null && other.codcomissao != null) || (this.codcomissao != null && !this.codcomissao.equals(other.codcomissao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Comissao[ codcomissao=" + codcomissao + " ]";
    }
    
}
