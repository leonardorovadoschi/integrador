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
@Table(name = "REQUISICAO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Requisicao.findAll", query = "SELECT r FROM Requisicao r")
    , @NamedQuery(name = "Requisicao.findByCodrequisicao", query = "SELECT r FROM Requisicao r WHERE r.codrequisicao = :codrequisicao")
    , @NamedQuery(name = "Requisicao.findByCodempresarequisitante", query = "SELECT r FROM Requisicao r WHERE r.codempresarequisitante = :codempresarequisitante")
    , @NamedQuery(name = "Requisicao.findByCodempresarequisitada", query = "SELECT r FROM Requisicao r WHERE r.codempresarequisitada = :codempresarequisitada")
    , @NamedQuery(name = "Requisicao.findByCodsetorestoquerequisitado", query = "SELECT r FROM Requisicao r WHERE r.codsetorestoquerequisitado = :codsetorestoquerequisitado")
    , @NamedQuery(name = "Requisicao.findByCodsetorestoquerequisitante", query = "SELECT r FROM Requisicao r WHERE r.codsetorestoquerequisitante = :codsetorestoquerequisitante")
    , @NamedQuery(name = "Requisicao.findByIdentidadeorigem", query = "SELECT r FROM Requisicao r WHERE r.identidadeorigem = :identidadeorigem")
    , @NamedQuery(name = "Requisicao.findByNomeentidadeorigem", query = "SELECT r FROM Requisicao r WHERE r.nomeentidadeorigem = :nomeentidadeorigem")
    , @NamedQuery(name = "Requisicao.findByCodprod", query = "SELECT r FROM Requisicao r WHERE r.codprod = :codprod")
    , @NamedQuery(name = "Requisicao.findByQuantidade", query = "SELECT r FROM Requisicao r WHERE r.quantidade = :quantidade")
    , @NamedQuery(name = "Requisicao.findByDatarequisicao", query = "SELECT r FROM Requisicao r WHERE r.datarequisicao = :datarequisicao")
    , @NamedQuery(name = "Requisicao.findByCoduserrequisicao", query = "SELECT r FROM Requisicao r WHERE r.coduserrequisicao = :coduserrequisicao")
    , @NamedQuery(name = "Requisicao.findByStatus", query = "SELECT r FROM Requisicao r WHERE r.status = :status")
    , @NamedQuery(name = "Requisicao.findByDataliberacao", query = "SELECT r FROM Requisicao r WHERE r.dataliberacao = :dataliberacao")
    , @NamedQuery(name = "Requisicao.findByCoduserliberacao", query = "SELECT r FROM Requisicao r WHERE r.coduserliberacao = :coduserliberacao")
    , @NamedQuery(name = "Requisicao.findByTipo", query = "SELECT r FROM Requisicao r WHERE r.tipo = :tipo")
    , @NamedQuery(name = "Requisicao.findByLoterequisicao", query = "SELECT r FROM Requisicao r WHERE r.loterequisicao = :loterequisicao")
    , @NamedQuery(name = "Requisicao.findByFlagcancelamento", query = "SELECT r FROM Requisicao r WHERE r.flagcancelamento = :flagcancelamento")
    , @NamedQuery(name = "Requisicao.findByNumdoc", query = "SELECT r FROM Requisicao r WHERE r.numdoc = :numdoc")})
public class Requisicao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODREQUISICAO")
    private String codrequisicao;
    @Column(name = "CODEMPRESAREQUISITANTE")
    private Integer codempresarequisitante;
    @Column(name = "CODEMPRESAREQUISITADA")
    private Integer codempresarequisitada;
    @Column(name = "CODSETORESTOQUEREQUISITADO")
    private String codsetorestoquerequisitado;
    @Column(name = "CODSETORESTOQUEREQUISITANTE")
    private String codsetorestoquerequisitante;
    @Column(name = "IDENTIDADEORIGEM")
    private String identidadeorigem;
    @Column(name = "NOMEENTIDADEORIGEM")
    private String nomeentidadeorigem;
    @Column(name = "CODPROD")
    private String codprod;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "QUANTIDADE")
    private BigDecimal quantidade;
    @Column(name = "DATAREQUISICAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datarequisicao;
    @Column(name = "CODUSERREQUISICAO")
    private String coduserrequisicao;
    @Column(name = "STATUS")
    private Character status;
    @Column(name = "DATALIBERACAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataliberacao;
    @Column(name = "CODUSERLIBERACAO")
    private String coduserliberacao;
    @Column(name = "TIPO")
    private Character tipo;
    @Column(name = "LOTEREQUISICAO")
    private String loterequisicao;
    @Column(name = "FLAGCANCELAMENTO")
    private Character flagcancelamento;
    @Column(name = "NUMDOC")
    private Integer numdoc;

    public Requisicao() {
    }

    public Requisicao(String codrequisicao) {
        this.codrequisicao = codrequisicao;
    }

    public String getCodrequisicao() {
        return codrequisicao;
    }

    public void setCodrequisicao(String codrequisicao) {
        this.codrequisicao = codrequisicao;
    }

    public Integer getCodempresarequisitante() {
        return codempresarequisitante;
    }

    public void setCodempresarequisitante(Integer codempresarequisitante) {
        this.codempresarequisitante = codempresarequisitante;
    }

    public Integer getCodempresarequisitada() {
        return codempresarequisitada;
    }

    public void setCodempresarequisitada(Integer codempresarequisitada) {
        this.codempresarequisitada = codempresarequisitada;
    }

    public String getCodsetorestoquerequisitado() {
        return codsetorestoquerequisitado;
    }

    public void setCodsetorestoquerequisitado(String codsetorestoquerequisitado) {
        this.codsetorestoquerequisitado = codsetorestoquerequisitado;
    }

    public String getCodsetorestoquerequisitante() {
        return codsetorestoquerequisitante;
    }

    public void setCodsetorestoquerequisitante(String codsetorestoquerequisitante) {
        this.codsetorestoquerequisitante = codsetorestoquerequisitante;
    }

    public String getIdentidadeorigem() {
        return identidadeorigem;
    }

    public void setIdentidadeorigem(String identidadeorigem) {
        this.identidadeorigem = identidadeorigem;
    }

    public String getNomeentidadeorigem() {
        return nomeentidadeorigem;
    }

    public void setNomeentidadeorigem(String nomeentidadeorigem) {
        this.nomeentidadeorigem = nomeentidadeorigem;
    }

    public String getCodprod() {
        return codprod;
    }

    public void setCodprod(String codprod) {
        this.codprod = codprod;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public Date getDatarequisicao() {
        return datarequisicao;
    }

    public void setDatarequisicao(Date datarequisicao) {
        this.datarequisicao = datarequisicao;
    }

    public String getCoduserrequisicao() {
        return coduserrequisicao;
    }

    public void setCoduserrequisicao(String coduserrequisicao) {
        this.coduserrequisicao = coduserrequisicao;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public Date getDataliberacao() {
        return dataliberacao;
    }

    public void setDataliberacao(Date dataliberacao) {
        this.dataliberacao = dataliberacao;
    }

    public String getCoduserliberacao() {
        return coduserliberacao;
    }

    public void setCoduserliberacao(String coduserliberacao) {
        this.coduserliberacao = coduserliberacao;
    }

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

    public String getLoterequisicao() {
        return loterequisicao;
    }

    public void setLoterequisicao(String loterequisicao) {
        this.loterequisicao = loterequisicao;
    }

    public Character getFlagcancelamento() {
        return flagcancelamento;
    }

    public void setFlagcancelamento(Character flagcancelamento) {
        this.flagcancelamento = flagcancelamento;
    }

    public Integer getNumdoc() {
        return numdoc;
    }

    public void setNumdoc(Integer numdoc) {
        this.numdoc = numdoc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codrequisicao != null ? codrequisicao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Requisicao)) {
            return false;
        }
        Requisicao other = (Requisicao) object;
        if ((this.codrequisicao == null && other.codrequisicao != null) || (this.codrequisicao != null && !this.codrequisicao.equals(other.codrequisicao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Requisicao[ codrequisicao=" + codrequisicao + " ]";
    }
    
}
