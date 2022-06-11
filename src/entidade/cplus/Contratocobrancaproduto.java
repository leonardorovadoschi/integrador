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
@Table(name = "CONTRATOCOBRANCAPRODUTO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contratocobrancaproduto.findAll", query = "SELECT c FROM Contratocobrancaproduto c")
    , @NamedQuery(name = "Contratocobrancaproduto.findByCodcontratocobrancaproduto", query = "SELECT c FROM Contratocobrancaproduto c WHERE c.codcontratocobrancaproduto = :codcontratocobrancaproduto")
    , @NamedQuery(name = "Contratocobrancaproduto.findByValortotal", query = "SELECT c FROM Contratocobrancaproduto c WHERE c.valortotal = :valortotal")
    , @NamedQuery(name = "Contratocobrancaproduto.findByDatavalidadeinicial", query = "SELECT c FROM Contratocobrancaproduto c WHERE c.datavalidadeinicial = :datavalidadeinicial")
    , @NamedQuery(name = "Contratocobrancaproduto.findByDatavalidadefinal", query = "SELECT c FROM Contratocobrancaproduto c WHERE c.datavalidadefinal = :datavalidadefinal")
    , @NamedQuery(name = "Contratocobrancaproduto.findByComplemento", query = "SELECT c FROM Contratocobrancaproduto c WHERE c.complemento = :complemento")
    , @NamedQuery(name = "Contratocobrancaproduto.findByNomeentidadeorigem", query = "SELECT c FROM Contratocobrancaproduto c WHERE c.nomeentidadeorigem = :nomeentidadeorigem")
    , @NamedQuery(name = "Contratocobrancaproduto.findByIdentidadeorigem", query = "SELECT c FROM Contratocobrancaproduto c WHERE c.identidadeorigem = :identidadeorigem")
    , @NamedQuery(name = "Contratocobrancaproduto.findByDatacadastro", query = "SELECT c FROM Contratocobrancaproduto c WHERE c.datacadastro = :datacadastro")
    , @NamedQuery(name = "Contratocobrancaproduto.findByFlagativo", query = "SELECT c FROM Contratocobrancaproduto c WHERE c.flagativo = :flagativo")
    , @NamedQuery(name = "Contratocobrancaproduto.findByFlagcobrancasuspensa", query = "SELECT c FROM Contratocobrancaproduto c WHERE c.flagcobrancasuspensa = :flagcobrancasuspensa")
    , @NamedQuery(name = "Contratocobrancaproduto.findByCodmovprod", query = "SELECT c FROM Contratocobrancaproduto c WHERE c.codmovprod = :codmovprod")
    , @NamedQuery(name = "Contratocobrancaproduto.findByFlagtipo", query = "SELECT c FROM Contratocobrancaproduto c WHERE c.flagtipo = :flagtipo")
    , @NamedQuery(name = "Contratocobrancaproduto.findByDatainiciorepasse", query = "SELECT c FROM Contratocobrancaproduto c WHERE c.datainiciorepasse = :datainiciorepasse")
    , @NamedQuery(name = "Contratocobrancaproduto.findByFlagcancelado", query = "SELECT c FROM Contratocobrancaproduto c WHERE c.flagcancelado = :flagcancelado")
    , @NamedQuery(name = "Contratocobrancaproduto.findByCodusercadastro", query = "SELECT c FROM Contratocobrancaproduto c WHERE c.codusercadastro = :codusercadastro")
    , @NamedQuery(name = "Contratocobrancaproduto.findByMotivosuspensao", query = "SELECT c FROM Contratocobrancaproduto c WHERE c.motivosuspensao = :motivosuspensao")
    , @NamedQuery(name = "Contratocobrancaproduto.findByMotivobloqueio", query = "SELECT c FROM Contratocobrancaproduto c WHERE c.motivobloqueio = :motivobloqueio")
    , @NamedQuery(name = "Contratocobrancaproduto.findByFlagbloqueiaservico", query = "SELECT c FROM Contratocobrancaproduto c WHERE c.flagbloqueiaservico = :flagbloqueiaservico")
    , @NamedQuery(name = "Contratocobrancaproduto.findByDatacancelamento", query = "SELECT c FROM Contratocobrancaproduto c WHERE c.datacancelamento = :datacancelamento")
    , @NamedQuery(name = "Contratocobrancaproduto.findByMotivocancelamento", query = "SELECT c FROM Contratocobrancaproduto c WHERE c.motivocancelamento = :motivocancelamento")
    , @NamedQuery(name = "Contratocobrancaproduto.findByCodusercancelamento", query = "SELECT c FROM Contratocobrancaproduto c WHERE c.codusercancelamento = :codusercancelamento")
    , @NamedQuery(name = "Contratocobrancaproduto.findByFlagrepasseliberado", query = "SELECT c FROM Contratocobrancaproduto c WHERE c.flagrepasseliberado = :flagrepasseliberado")
    , @NamedQuery(name = "Contratocobrancaproduto.findByDataliberacaorepasse", query = "SELECT c FROM Contratocobrancaproduto c WHERE c.dataliberacaorepasse = :dataliberacaorepasse")
    , @NamedQuery(name = "Contratocobrancaproduto.findByCoduserliberacao", query = "SELECT c FROM Contratocobrancaproduto c WHERE c.coduserliberacao = :coduserliberacao")
    , @NamedQuery(name = "Contratocobrancaproduto.findByCodclirepasse", query = "SELECT c FROM Contratocobrancaproduto c WHERE c.codclirepasse = :codclirepasse")
    , @NamedQuery(name = "Contratocobrancaproduto.findByCodprodutoserial", query = "SELECT c FROM Contratocobrancaproduto c WHERE c.codprodutoserial = :codprodutoserial")
    , @NamedQuery(name = "Contratocobrancaproduto.findByDatacarencia", query = "SELECT c FROM Contratocobrancaproduto c WHERE c.datacarencia = :datacarencia")
    , @NamedQuery(name = "Contratocobrancaproduto.findByQuantidade", query = "SELECT c FROM Contratocobrancaproduto c WHERE c.quantidade = :quantidade")
    , @NamedQuery(name = "Contratocobrancaproduto.findByValorrepasse", query = "SELECT c FROM Contratocobrancaproduto c WHERE c.valorrepasse = :valorrepasse")
    , @NamedQuery(name = "Contratocobrancaproduto.findByLucro", query = "SELECT c FROM Contratocobrancaproduto c WHERE c.lucro = :lucro")})
public class Contratocobrancaproduto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCONTRATOCOBRANCAPRODUTO")
    private String codcontratocobrancaproduto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALORTOTAL")
    private BigDecimal valortotal;
    @Column(name = "DATAVALIDADEINICIAL")
    @Temporal(TemporalType.DATE)
    private Date datavalidadeinicial;
    @Column(name = "DATAVALIDADEFINAL")
    @Temporal(TemporalType.DATE)
    private Date datavalidadefinal;
    @Column(name = "COMPLEMENTO")
    private String complemento;
    @Column(name = "NOMEENTIDADEORIGEM")
    private String nomeentidadeorigem;
    @Column(name = "IDENTIDADEORIGEM")
    private String identidadeorigem;
    @Column(name = "DATACADASTRO")
    @Temporal(TemporalType.DATE)
    private Date datacadastro;
    @Column(name = "FLAGATIVO")
    private String flagativo;
    @Column(name = "FLAGCOBRANCASUSPENSA")
    private Character flagcobrancasuspensa;
    @Column(name = "CODMOVPROD")
    private String codmovprod;
    @Column(name = "FLAGTIPO")
    private Character flagtipo;
    @Column(name = "DATAINICIOREPASSE")
    @Temporal(TemporalType.DATE)
    private Date datainiciorepasse;
    @Column(name = "FLAGCANCELADO")
    private Character flagcancelado;
    @Column(name = "CODUSERCADASTRO")
    private String codusercadastro;
    @Column(name = "MOTIVOSUSPENSAO")
    private String motivosuspensao;
    @Column(name = "MOTIVOBLOQUEIO")
    private String motivobloqueio;
    @Column(name = "FLAGBLOQUEIASERVICO")
    private Character flagbloqueiaservico;
    @Column(name = "DATACANCELAMENTO")
    @Temporal(TemporalType.DATE)
    private Date datacancelamento;
    @Column(name = "MOTIVOCANCELAMENTO")
    private String motivocancelamento;
    @Column(name = "CODUSERCANCELAMENTO")
    private String codusercancelamento;
    @Column(name = "FLAGREPASSELIBERADO")
    private Character flagrepasseliberado;
    @Column(name = "DATALIBERACAOREPASSE")
    @Temporal(TemporalType.DATE)
    private Date dataliberacaorepasse;
    @Column(name = "CODUSERLIBERACAO")
    private String coduserliberacao;
    @Column(name = "CODCLIREPASSE")
    private String codclirepasse;
    @Column(name = "CODPRODUTOSERIAL")
    private String codprodutoserial;
    @Column(name = "DATACARENCIA")
    @Temporal(TemporalType.DATE)
    private Date datacarencia;
    @Column(name = "QUANTIDADE")
    private Integer quantidade;
    @Column(name = "VALORREPASSE")
    private BigDecimal valorrepasse;
    @Column(name = "LUCRO")
    private BigDecimal lucro;
    @JoinColumn(name = "CODCONTRATOCOBRANCA", referencedColumnName = "CODCONTRATOCOBRANCA")
    @ManyToOne
    private Contratocobranca codcontratocobranca;
    @JoinColumn(name = "CODPROD", referencedColumnName = "CODPROD")
    @ManyToOne
    private Produto codprod;

    public Contratocobrancaproduto() {
    }

    public Contratocobrancaproduto(String codcontratocobrancaproduto) {
        this.codcontratocobrancaproduto = codcontratocobrancaproduto;
    }

    public String getCodcontratocobrancaproduto() {
        return codcontratocobrancaproduto;
    }

    public void setCodcontratocobrancaproduto(String codcontratocobrancaproduto) {
        this.codcontratocobrancaproduto = codcontratocobrancaproduto;
    }

    public BigDecimal getValortotal() {
        return valortotal;
    }

    public void setValortotal(BigDecimal valortotal) {
        this.valortotal = valortotal;
    }

    public Date getDatavalidadeinicial() {
        return datavalidadeinicial;
    }

    public void setDatavalidadeinicial(Date datavalidadeinicial) {
        this.datavalidadeinicial = datavalidadeinicial;
    }

    public Date getDatavalidadefinal() {
        return datavalidadefinal;
    }

    public void setDatavalidadefinal(Date datavalidadefinal) {
        this.datavalidadefinal = datavalidadefinal;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
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

    public Date getDatacadastro() {
        return datacadastro;
    }

    public void setDatacadastro(Date datacadastro) {
        this.datacadastro = datacadastro;
    }

    public String getFlagativo() {
        return flagativo;
    }

    public void setFlagativo(String flagativo) {
        this.flagativo = flagativo;
    }

    public Character getFlagcobrancasuspensa() {
        return flagcobrancasuspensa;
    }

    public void setFlagcobrancasuspensa(Character flagcobrancasuspensa) {
        this.flagcobrancasuspensa = flagcobrancasuspensa;
    }

    public String getCodmovprod() {
        return codmovprod;
    }

    public void setCodmovprod(String codmovprod) {
        this.codmovprod = codmovprod;
    }

    public Character getFlagtipo() {
        return flagtipo;
    }

    public void setFlagtipo(Character flagtipo) {
        this.flagtipo = flagtipo;
    }

    public Date getDatainiciorepasse() {
        return datainiciorepasse;
    }

    public void setDatainiciorepasse(Date datainiciorepasse) {
        this.datainiciorepasse = datainiciorepasse;
    }

    public Character getFlagcancelado() {
        return flagcancelado;
    }

    public void setFlagcancelado(Character flagcancelado) {
        this.flagcancelado = flagcancelado;
    }

    public String getCodusercadastro() {
        return codusercadastro;
    }

    public void setCodusercadastro(String codusercadastro) {
        this.codusercadastro = codusercadastro;
    }

    public String getMotivosuspensao() {
        return motivosuspensao;
    }

    public void setMotivosuspensao(String motivosuspensao) {
        this.motivosuspensao = motivosuspensao;
    }

    public String getMotivobloqueio() {
        return motivobloqueio;
    }

    public void setMotivobloqueio(String motivobloqueio) {
        this.motivobloqueio = motivobloqueio;
    }

    public Character getFlagbloqueiaservico() {
        return flagbloqueiaservico;
    }

    public void setFlagbloqueiaservico(Character flagbloqueiaservico) {
        this.flagbloqueiaservico = flagbloqueiaservico;
    }

    public Date getDatacancelamento() {
        return datacancelamento;
    }

    public void setDatacancelamento(Date datacancelamento) {
        this.datacancelamento = datacancelamento;
    }

    public String getMotivocancelamento() {
        return motivocancelamento;
    }

    public void setMotivocancelamento(String motivocancelamento) {
        this.motivocancelamento = motivocancelamento;
    }

    public String getCodusercancelamento() {
        return codusercancelamento;
    }

    public void setCodusercancelamento(String codusercancelamento) {
        this.codusercancelamento = codusercancelamento;
    }

    public Character getFlagrepasseliberado() {
        return flagrepasseliberado;
    }

    public void setFlagrepasseliberado(Character flagrepasseliberado) {
        this.flagrepasseliberado = flagrepasseliberado;
    }

    public Date getDataliberacaorepasse() {
        return dataliberacaorepasse;
    }

    public void setDataliberacaorepasse(Date dataliberacaorepasse) {
        this.dataliberacaorepasse = dataliberacaorepasse;
    }

    public String getCoduserliberacao() {
        return coduserliberacao;
    }

    public void setCoduserliberacao(String coduserliberacao) {
        this.coduserliberacao = coduserliberacao;
    }

    public String getCodclirepasse() {
        return codclirepasse;
    }

    public void setCodclirepasse(String codclirepasse) {
        this.codclirepasse = codclirepasse;
    }

    public String getCodprodutoserial() {
        return codprodutoserial;
    }

    public void setCodprodutoserial(String codprodutoserial) {
        this.codprodutoserial = codprodutoserial;
    }

    public Date getDatacarencia() {
        return datacarencia;
    }

    public void setDatacarencia(Date datacarencia) {
        this.datacarencia = datacarencia;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorrepasse() {
        return valorrepasse;
    }

    public void setValorrepasse(BigDecimal valorrepasse) {
        this.valorrepasse = valorrepasse;
    }

    public BigDecimal getLucro() {
        return lucro;
    }

    public void setLucro(BigDecimal lucro) {
        this.lucro = lucro;
    }

    public Contratocobranca getCodcontratocobranca() {
        return codcontratocobranca;
    }

    public void setCodcontratocobranca(Contratocobranca codcontratocobranca) {
        this.codcontratocobranca = codcontratocobranca;
    }

    public Produto getCodprod() {
        return codprod;
    }

    public void setCodprod(Produto codprod) {
        this.codprod = codprod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcontratocobrancaproduto != null ? codcontratocobrancaproduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contratocobrancaproduto)) {
            return false;
        }
        Contratocobrancaproduto other = (Contratocobrancaproduto) object;
        if ((this.codcontratocobrancaproduto == null && other.codcontratocobrancaproduto != null) || (this.codcontratocobrancaproduto != null && !this.codcontratocobrancaproduto.equals(other.codcontratocobrancaproduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Contratocobrancaproduto[ codcontratocobrancaproduto=" + codcontratocobrancaproduto + " ]";
    }
    
}
