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
@Table(name = "CONTARECEBERREC", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contareceberrec.findAll", query = "SELECT c FROM Contareceberrec c")
    , @NamedQuery(name = "Contareceberrec.findById", query = "SELECT c FROM Contareceberrec c WHERE c.id = :id")
    , @NamedQuery(name = "Contareceberrec.findByCoduser", query = "SELECT c FROM Contareceberrec c WHERE c.coduser = :coduser")
    , @NamedQuery(name = "Contareceberrec.findByData", query = "SELECT c FROM Contareceberrec c WHERE c.data = :data")
    , @NamedQuery(name = "Contareceberrec.findByValor", query = "SELECT c FROM Contareceberrec c WHERE c.valor = :valor")
    , @NamedQuery(name = "Contareceberrec.findByTipo", query = "SELECT c FROM Contareceberrec c WHERE c.tipo = :tipo")
    , @NamedQuery(name = "Contareceberrec.findByLastChange", query = "SELECT c FROM Contareceberrec c WHERE c.lastChange = :lastChange")
    , @NamedQuery(name = "Contareceberrec.findByCodrec", query = "SELECT c FROM Contareceberrec c WHERE c.codrec = :codrec")
    , @NamedQuery(name = "Contareceberrec.findByLote", query = "SELECT c FROM Contareceberrec c WHERE c.lote = :lote")
    , @NamedQuery(name = "Contareceberrec.findByNumparcelas", query = "SELECT c FROM Contareceberrec c WHERE c.numparcelas = :numparcelas")
    , @NamedQuery(name = "Contareceberrec.findByNumparcelasrecebimento", query = "SELECT c FROM Contareceberrec c WHERE c.numparcelasrecebimento = :numparcelasrecebimento")
    , @NamedQuery(name = "Contareceberrec.findByNumdiasprimeiraparcela", query = "SELECT c FROM Contareceberrec c WHERE c.numdiasprimeiraparcela = :numdiasprimeiraparcela")
    , @NamedQuery(name = "Contareceberrec.findByNumdiasrecebimento", query = "SELECT c FROM Contareceberrec c WHERE c.numdiasrecebimento = :numdiasrecebimento")
    , @NamedQuery(name = "Contareceberrec.findByNumdiasintervalo", query = "SELECT c FROM Contareceberrec c WHERE c.numdiasintervalo = :numdiasintervalo")
    , @NamedQuery(name = "Contareceberrec.findByValortacconvenio", query = "SELECT c FROM Contareceberrec c WHERE c.valortacconvenio = :valortacconvenio")
    , @NamedQuery(name = "Contareceberrec.findByAliqtacconvenio", query = "SELECT c FROM Contareceberrec c WHERE c.aliqtacconvenio = :aliqtacconvenio")
    , @NamedQuery(name = "Contareceberrec.findByAliqconvenio", query = "SELECT c FROM Contareceberrec c WHERE c.aliqconvenio = :aliqconvenio")
    , @NamedQuery(name = "Contareceberrec.findByCodcli", query = "SELECT c FROM Contareceberrec c WHERE c.codcli = :codcli")
    , @NamedQuery(name = "Contareceberrec.findByDatalancamento", query = "SELECT c FROM Contareceberrec c WHERE c.datalancamento = :datalancamento")
    , @NamedQuery(name = "Contareceberrec.findByDatacredito", query = "SELECT c FROM Contareceberrec c WHERE c.datacredito = :datacredito")
    , @NamedQuery(name = "Contareceberrec.findByNomearquivoretorno", query = "SELECT c FROM Contareceberrec c WHERE c.nomearquivoretorno = :nomearquivoretorno")
    , @NamedQuery(name = "Contareceberrec.findByGuiddocumentocaixa", query = "SELECT c FROM Contareceberrec c WHERE c.guiddocumentocaixa = :guiddocumentocaixa")
    , @NamedQuery(name = "Contareceberrec.findByFlagdiasparabloqueio", query = "SELECT c FROM Contareceberrec c WHERE c.flagdiasparabloqueio = :flagdiasparabloqueio")
    , @NamedQuery(name = "Contareceberrec.findByDatarazao", query = "SELECT c FROM Contareceberrec c WHERE c.datarazao = :datarazao")})
public class Contareceberrec implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Column(name = "CODUSER")
    private String coduser;
    @Column(name = "DATA")
    @Temporal(TemporalType.DATE)
    private Date data;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALOR")
    private BigDecimal valor;
    @Column(name = "TIPO")
    private String tipo;
    @Column(name = "LAST_CHANGE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastChange;
    @Column(name = "CODREC")
    private String codrec;
    @Column(name = "LOTE")
    private Integer lote;
    @Column(name = "NUMPARCELAS")
    private Integer numparcelas;
    @Column(name = "NUMPARCELASRECEBIMENTO")
    private Integer numparcelasrecebimento;
    @Column(name = "NUMDIASPRIMEIRAPARCELA")
    private Integer numdiasprimeiraparcela;
    @Column(name = "NUMDIASRECEBIMENTO")
    private Integer numdiasrecebimento;
    @Column(name = "NUMDIASINTERVALO")
    private Integer numdiasintervalo;
    @Column(name = "VALORTACCONVENIO")
    private BigDecimal valortacconvenio;
    @Column(name = "ALIQTACCONVENIO")
    private BigDecimal aliqtacconvenio;
    @Column(name = "ALIQCONVENIO")
    private BigDecimal aliqconvenio;
    @Column(name = "CODCLI")
    private String codcli;
    @Column(name = "DATALANCAMENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datalancamento;
    @Column(name = "DATACREDITO")
    @Temporal(TemporalType.DATE)
    private Date datacredito;
    @Column(name = "NOMEARQUIVORETORNO")
    private String nomearquivoretorno;
    @Column(name = "GUIDDOCUMENTOCAIXA")
    private String guiddocumentocaixa;
    @Column(name = "FLAGDIASPARABLOQUEIO")
    private Character flagdiasparabloqueio;
    @Column(name = "DATARAZAO")
    @Temporal(TemporalType.DATE)
    private Date datarazao;
    @JoinColumn(name = "CODBANCOOCORRENCIA", referencedColumnName = "CODBANCOOCORRENCIA")
    @ManyToOne
    private Bancoocorrencia codbancoocorrencia;
    @JoinColumn(name = "CODCAIXA", referencedColumnName = "CODCAIXA")
    @ManyToOne
    private Caixa codcaixa;
    @JoinColumn(name = "CODCR", referencedColumnName = "CODCR")
    @ManyToOne
    private Contareceber codcr;
    @JoinColumn(name = "CODDOCUMENTOCAIXA", referencedColumnName = "CODDOCUMENTOCAIXA")
    @ManyToOne
    private Documentocaixa coddocumentocaixa;
    @JoinColumn(name = "CODEMPRESA", referencedColumnName = "CODEMPRESA")
    @ManyToOne(optional = false)
    private Empresa codempresa;

    public Contareceberrec() {
    }

    public Contareceberrec(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCoduser() {
        return coduser;
    }

    public void setCoduser(String coduser) {
        this.coduser = coduser;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getLastChange() {
        return lastChange;
    }

    public void setLastChange(Date lastChange) {
        this.lastChange = lastChange;
    }

    public String getCodrec() {
        return codrec;
    }

    public void setCodrec(String codrec) {
        this.codrec = codrec;
    }

    public Integer getLote() {
        return lote;
    }

    public void setLote(Integer lote) {
        this.lote = lote;
    }

    public Integer getNumparcelas() {
        return numparcelas;
    }

    public void setNumparcelas(Integer numparcelas) {
        this.numparcelas = numparcelas;
    }

    public Integer getNumparcelasrecebimento() {
        return numparcelasrecebimento;
    }

    public void setNumparcelasrecebimento(Integer numparcelasrecebimento) {
        this.numparcelasrecebimento = numparcelasrecebimento;
    }

    public Integer getNumdiasprimeiraparcela() {
        return numdiasprimeiraparcela;
    }

    public void setNumdiasprimeiraparcela(Integer numdiasprimeiraparcela) {
        this.numdiasprimeiraparcela = numdiasprimeiraparcela;
    }

    public Integer getNumdiasrecebimento() {
        return numdiasrecebimento;
    }

    public void setNumdiasrecebimento(Integer numdiasrecebimento) {
        this.numdiasrecebimento = numdiasrecebimento;
    }

    public Integer getNumdiasintervalo() {
        return numdiasintervalo;
    }

    public void setNumdiasintervalo(Integer numdiasintervalo) {
        this.numdiasintervalo = numdiasintervalo;
    }

    public BigDecimal getValortacconvenio() {
        return valortacconvenio;
    }

    public void setValortacconvenio(BigDecimal valortacconvenio) {
        this.valortacconvenio = valortacconvenio;
    }

    public BigDecimal getAliqtacconvenio() {
        return aliqtacconvenio;
    }

    public void setAliqtacconvenio(BigDecimal aliqtacconvenio) {
        this.aliqtacconvenio = aliqtacconvenio;
    }

    public BigDecimal getAliqconvenio() {
        return aliqconvenio;
    }

    public void setAliqconvenio(BigDecimal aliqconvenio) {
        this.aliqconvenio = aliqconvenio;
    }

    public String getCodcli() {
        return codcli;
    }

    public void setCodcli(String codcli) {
        this.codcli = codcli;
    }

    public Date getDatalancamento() {
        return datalancamento;
    }

    public void setDatalancamento(Date datalancamento) {
        this.datalancamento = datalancamento;
    }

    public Date getDatacredito() {
        return datacredito;
    }

    public void setDatacredito(Date datacredito) {
        this.datacredito = datacredito;
    }

    public String getNomearquivoretorno() {
        return nomearquivoretorno;
    }

    public void setNomearquivoretorno(String nomearquivoretorno) {
        this.nomearquivoretorno = nomearquivoretorno;
    }

    public String getGuiddocumentocaixa() {
        return guiddocumentocaixa;
    }

    public void setGuiddocumentocaixa(String guiddocumentocaixa) {
        this.guiddocumentocaixa = guiddocumentocaixa;
    }

    public Character getFlagdiasparabloqueio() {
        return flagdiasparabloqueio;
    }

    public void setFlagdiasparabloqueio(Character flagdiasparabloqueio) {
        this.flagdiasparabloqueio = flagdiasparabloqueio;
    }

    public Date getDatarazao() {
        return datarazao;
    }

    public void setDatarazao(Date datarazao) {
        this.datarazao = datarazao;
    }

    public Bancoocorrencia getCodbancoocorrencia() {
        return codbancoocorrencia;
    }

    public void setCodbancoocorrencia(Bancoocorrencia codbancoocorrencia) {
        this.codbancoocorrencia = codbancoocorrencia;
    }

    public Caixa getCodcaixa() {
        return codcaixa;
    }

    public void setCodcaixa(Caixa codcaixa) {
        this.codcaixa = codcaixa;
    }

    public Contareceber getCodcr() {
        return codcr;
    }

    public void setCodcr(Contareceber codcr) {
        this.codcr = codcr;
    }

    public Documentocaixa getCoddocumentocaixa() {
        return coddocumentocaixa;
    }

    public void setCoddocumentocaixa(Documentocaixa coddocumentocaixa) {
        this.coddocumentocaixa = coddocumentocaixa;
    }

    public Empresa getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Empresa codempresa) {
        this.codempresa = codempresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contareceberrec)) {
            return false;
        }
        Contareceberrec other = (Contareceberrec) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Contareceberrec[ id=" + id + " ]";
    }
    
}
