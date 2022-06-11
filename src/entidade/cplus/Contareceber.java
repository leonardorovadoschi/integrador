/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "CONTARECEBER", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contareceber.findAll", query = "SELECT c FROM Contareceber c")
    , @NamedQuery(name = "Contareceber.findByCodcr", query = "SELECT c FROM Contareceber c WHERE c.codcr = :codcr")
    , @NamedQuery(name = "Contareceber.findByCodmovenda", query = "SELECT c FROM Contareceber c WHERE c.codmovenda = :codmovenda")
    , @NamedQuery(name = "Contareceber.findByCoduser", query = "SELECT c FROM Contareceber c WHERE c.coduser = :coduser")
    , @NamedQuery(name = "Contareceber.findByCodrec", query = "SELECT c FROM Contareceber c WHERE c.codrec = :codrec")
    , @NamedQuery(name = "Contareceber.findByNumdoc", query = "SELECT c FROM Contareceber c WHERE c.numdoc = :numdoc")
    , @NamedQuery(name = "Contareceber.findByDevedor", query = "SELECT c FROM Contareceber c WHERE c.devedor = :devedor")
    , @NamedQuery(name = "Contareceber.findByFlagcli", query = "SELECT c FROM Contareceber c WHERE c.flagcli = :flagcli")
    , @NamedQuery(name = "Contareceber.findByValor", query = "SELECT c FROM Contareceber c WHERE c.valor = :valor")
    , @NamedQuery(name = "Contareceber.findByDatentr", query = "SELECT c FROM Contareceber c WHERE c.datentr = :datentr")
    , @NamedQuery(name = "Contareceber.findByDatvenc", query = "SELECT c FROM Contareceber c WHERE c.datvenc = :datvenc")
    , @NamedQuery(name = "Contareceber.findByOrigem", query = "SELECT c FROM Contareceber c WHERE c.origem = :origem")
    , @NamedQuery(name = "Contareceber.findByLocal", query = "SELECT c FROM Contareceber c WHERE c.local = :local")
    , @NamedQuery(name = "Contareceber.findByParcela", query = "SELECT c FROM Contareceber c WHERE c.parcela = :parcela")
    , @NamedQuery(name = "Contareceber.findByAvisos", query = "SELECT c FROM Contareceber c WHERE c.avisos = :avisos")
    , @NamedQuery(name = "Contareceber.findByTipocobra", query = "SELECT c FROM Contareceber c WHERE c.tipocobra = :tipocobra")
    , @NamedQuery(name = "Contareceber.findByDatcobra", query = "SELECT c FROM Contareceber c WHERE c.datcobra = :datcobra")
    , @NamedQuery(name = "Contareceber.findByTotpago", query = "SELECT c FROM Contareceber c WHERE c.totpago = :totpago")
    , @NamedQuery(name = "Contareceber.findByFlagpago", query = "SELECT c FROM Contareceber c WHERE c.flagpago = :flagpago")
    , @NamedQuery(name = "Contareceber.findByDatpag", query = "SELECT c FROM Contareceber c WHERE c.datpag = :datpag")
    , @NamedQuery(name = "Contareceber.findByValorpg", query = "SELECT c FROM Contareceber c WHERE c.valorpg = :valorpg")
    , @NamedQuery(name = "Contareceber.findByJuros", query = "SELECT c FROM Contareceber c WHERE c.juros = :juros")
    , @NamedQuery(name = "Contareceber.findByTaxa", query = "SELECT c FROM Contareceber c WHERE c.taxa = :taxa")
    , @NamedQuery(name = "Contareceber.findByNossonumero", query = "SELECT c FROM Contareceber c WHERE c.nossonumero = :nossonumero")
    , @NamedQuery(name = "Contareceber.findByDataremessa", query = "SELECT c FROM Contareceber c WHERE c.dataremessa = :dataremessa")
    , @NamedQuery(name = "Contareceber.findByDescatevenc", query = "SELECT c FROM Contareceber c WHERE c.descatevenc = :descatevenc")
    , @NamedQuery(name = "Contareceber.findByDispjuros", query = "SELECT c FROM Contareceber c WHERE c.dispjuros = :dispjuros")
    , @NamedQuery(name = "Contareceber.findByLastChange", query = "SELECT c FROM Contareceber c WHERE c.lastChange = :lastChange")
    , @NamedQuery(name = "Contareceber.findByDatvencfixa", query = "SELECT c FROM Contareceber c WHERE c.datvencfixa = :datvencfixa")
    , @NamedQuery(name = "Contareceber.findByLocalfixa", query = "SELECT c FROM Contareceber c WHERE c.localfixa = :localfixa")
    , @NamedQuery(name = "Contareceber.findByValorfixa", query = "SELECT c FROM Contareceber c WHERE c.valorfixa = :valorfixa")
    , @NamedQuery(name = "Contareceber.findByFlagcancelada", query = "SELECT c FROM Contareceber c WHERE c.flagcancelada = :flagcancelada")
    , @NamedQuery(name = "Contareceber.findByMotivocancelamento", query = "SELECT c FROM Contareceber c WHERE c.motivocancelamento = :motivocancelamento")
    , @NamedQuery(name = "Contareceber.findByFlag9", query = "SELECT c FROM Contareceber c WHERE c.flag9 = :flag9")
    , @NamedQuery(name = "Contareceber.findByFlagtipoemissaocobranca", query = "SELECT c FROM Contareceber c WHERE c.flagtipoemissaocobranca = :flagtipoemissaocobranca")
    , @NamedQuery(name = "Contareceber.findByDatalancamento", query = "SELECT c FROM Contareceber c WHERE c.datalancamento = :datalancamento")
    , @NamedQuery(name = "Contareceber.findByTaxapaga", query = "SELECT c FROM Contareceber c WHERE c.taxapaga = :taxapaga")
    , @NamedQuery(name = "Contareceber.findByFlagtipomulta", query = "SELECT c FROM Contareceber c WHERE c.flagtipomulta = :flagtipomulta")
    , @NamedQuery(name = "Contareceber.findByAliqmulta", query = "SELECT c FROM Contareceber c WHERE c.aliqmulta = :aliqmulta")
    , @NamedQuery(name = "Contareceber.findByValormulta", query = "SELECT c FROM Contareceber c WHERE c.valormulta = :valormulta")
    , @NamedQuery(name = "Contareceber.findByRefercontafixa", query = "SELECT c FROM Contareceber c WHERE c.refercontafixa = :refercontafixa")
    , @NamedQuery(name = "Contareceber.findByFlagrenegociada", query = "SELECT c FROM Contareceber c WHERE c.flagrenegociada = :flagrenegociada")
    , @NamedQuery(name = "Contareceber.findByCodforn", query = "SELECT c FROM Contareceber c WHERE c.codforn = :codforn")
    , @NamedQuery(name = "Contareceber.findByCodfornvenda", query = "SELECT c FROM Contareceber c WHERE c.codfornvenda = :codfornvenda")
    , @NamedQuery(name = "Contareceber.findByCodmoventr", query = "SELECT c FROM Contareceber c WHERE c.codmoventr = :codmoventr")
    , @NamedQuery(name = "Contareceber.findByDatvencoriginal", query = "SELECT c FROM Contareceber c WHERE c.datvencoriginal = :datvencoriginal")
    , @NamedQuery(name = "Contareceber.findByGuid", query = "SELECT c FROM Contareceber c WHERE c.guid = :guid")
    , @NamedQuery(name = "Contareceber.findByFlagboletoonline", query = "SELECT c FROM Contareceber c WHERE c.flagboletoonline = :flagboletoonline")
    , @NamedQuery(name = "Contareceber.findByDispmulta", query = "SELECT c FROM Contareceber c WHERE c.dispmulta = :dispmulta")
    , @NamedQuery(name = "Contareceber.findByDatcanc", query = "SELECT c FROM Contareceber c WHERE c.datcanc = :datcanc")
    , @NamedQuery(name = "Contareceber.findByCodusuariocancelamento", query = "SELECT c FROM Contareceber c WHERE c.codusuariocancelamento = :codusuariocancelamento")})
public class Contareceber implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCR")
    private String codcr;
    @Column(name = "CODMOVENDA")
    private String codmovenda;
    @Column(name = "CODUSER")
    private String coduser;
    @Column(name = "CODREC")
    private String codrec;
    @Column(name = "NUMDOC")
    private String numdoc;
    @Column(name = "DEVEDOR")
    private String devedor;
    @Basic(optional = false)
    @Column(name = "FLAGCLI")
    private Character flagcli;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "VALOR")
    private BigDecimal valor;
    @Column(name = "DATENTR")
    @Temporal(TemporalType.DATE)
    private Date datentr;
    @Column(name = "DATVENC")
    @Temporal(TemporalType.DATE)
    private Date datvenc;
    @Column(name = "ORIGEM")
    private String origem;
    @Column(name = "LOCAL")
    private String local;
    @Column(name = "PARCELA")
    private String parcela;
    @Lob
    @Column(name = "OBS")
    private byte[] obs;
    @Column(name = "AVISOS")
    private Short avisos;
    @Column(name = "TIPOCOBRA")
    private String tipocobra;
    @Column(name = "DATCOBRA")
    @Temporal(TemporalType.DATE)
    private Date datcobra;
    @Column(name = "TOTPAGO")
    private BigDecimal totpago;
    @Column(name = "FLAGPAGO")
    private Character flagpago;
    @Column(name = "DATPAG")
    @Temporal(TemporalType.DATE)
    private Date datpag;
    @Column(name = "VALORPG")
    private BigDecimal valorpg;
    @Column(name = "JUROS")
    private BigDecimal juros;
    @Column(name = "TAXA")
    private BigDecimal taxa;
    @Column(name = "NOSSONUMERO")
    private BigInteger nossonumero;
    @Column(name = "DATAREMESSA")
    @Temporal(TemporalType.DATE)
    private Date dataremessa;
    @Column(name = "DESCATEVENC")
    private BigDecimal descatevenc;
    @Column(name = "DISPJUROS")
    private Character dispjuros;
    @Column(name = "LAST_CHANGE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastChange;
    @Column(name = "DATVENCFIXA")
    @Temporal(TemporalType.DATE)
    private Date datvencfixa;
    @Column(name = "LOCALFIXA")
    private String localfixa;
    @Column(name = "VALORFIXA")
    private BigDecimal valorfixa;
    @Column(name = "FLAGCANCELADA")
    private Character flagcancelada;
    @Column(name = "MOTIVOCANCELAMENTO")
    private String motivocancelamento;
    @Column(name = "FLAG9")
    private Character flag9;
    @Column(name = "FLAGTIPOEMISSAOCOBRANCA")
    private Character flagtipoemissaocobranca;
    @Column(name = "DATALANCAMENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datalancamento;
    @Column(name = "TAXAPAGA")
    private BigDecimal taxapaga;
    @Column(name = "FLAGTIPOMULTA")
    private Character flagtipomulta;
    @Column(name = "ALIQMULTA")
    private BigDecimal aliqmulta;
    @Column(name = "VALORMULTA")
    private BigDecimal valormulta;
    @Column(name = "REFERCONTAFIXA")
    private String refercontafixa;
    @Column(name = "FLAGRENEGOCIADA")
    private Character flagrenegociada;
    @Column(name = "CODFORN")
    private String codforn;
    @Column(name = "CODFORNVENDA")
    private String codfornvenda;
    @Column(name = "CODMOVENTR")
    private String codmoventr;
    @Column(name = "DATVENCORIGINAL")
    @Temporal(TemporalType.DATE)
    private Date datvencoriginal;
    @Column(name = "GUID")
    private String guid;
    @Column(name = "FLAGBOLETOONLINE")
    private Character flagboletoonline;
    @Column(name = "DISPMULTA")
    private Character dispmulta;
    @Column(name = "DATCANC")
    @Temporal(TemporalType.DATE)
    private Date datcanc;
    @Column(name = "CODUSUARIOCANCELAMENTO")
    private String codusuariocancelamento;
    @OneToMany(mappedBy = "codcr")
    private Collection<Historicocobranca> historicocobrancaCollection;
    @OneToMany(mappedBy = "codcr")
    private Collection<Recebimentos> recebimentosCollection;
    @OneToMany(mappedBy = "codcr")
    private Collection<Contareceberrec> contareceberrecCollection;
    @JoinColumn(name = "CODCLI", referencedColumnName = "CODCLI")
    @ManyToOne
    private Cliente codcli;
    @JoinColumn(name = "CODATEND", referencedColumnName = "CODATEND")
    @ManyToOne
    private Atendimento codatend;
    @JoinColumn(name = "CODCAIXAS", referencedColumnName = "CODCAIXAS")
    @ManyToOne
    private Caixas codcaixas;
    @JoinColumn(name = "CODCENTROCUSTO", referencedColumnName = "CODCENTROCUSTO")
    @ManyToOne
    private Centrocusto codcentrocusto;
    @JoinColumn(name = "CODCLIVENDA", referencedColumnName = "CODCLI")
    @ManyToOne
    private Cliente codclivenda;
    @JoinColumn(name = "CODCONHECIMENTOTRANSPORTE", referencedColumnName = "CODCONHECIMENTOTRANSPORTE")
    @ManyToOne
    private Conhecimentotransporte codconhecimentotransporte;
    @JoinColumn(name = "CODCONTABANCARIA", referencedColumnName = "CODCONTABANCARIA")
    @ManyToOne
    private Contabancaria codcontabancaria;
    @JoinColumn(name = "CODCRFIXA", referencedColumnName = "CODCRFIXA")
    @ManyToOne
    private Contareceberfixa codcrfixa;
    @JoinColumn(name = "CODEMPRESA", referencedColumnName = "CODEMPRESA")
    @ManyToOne
    private Empresa codempresa;
    @JoinColumn(name = "CODPC", referencedColumnName = "CODPC")
    @ManyToOne
    private Planoconta codpc;
    @JoinColumn(name = "CODRENEGOCIACAO", referencedColumnName = "CODRENEGOCIACAO")
    @ManyToOne
    private Renegociacao codrenegociacao;
    @JoinColumn(name = "CODSITUACAOADMINISTRATIVA", referencedColumnName = "CODSITUACAOADMINISTRATIVA")
    @ManyToOne
    private Situacaoadministrativa codsituacaoadministrativa;
    @OneToMany(mappedBy = "codcr")
    private Collection<Lancacartao> lancacartaoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codcr")
    private Collection<Historicocarteira> historicocarteiraCollection;

    public Contareceber() {
    }

    public Contareceber(String codcr) {
        this.codcr = codcr;
    }

    public Contareceber(String codcr, Character flagcli, BigDecimal valor) {
        this.codcr = codcr;
        this.flagcli = flagcli;
        this.valor = valor;
    }

    public String getCodcr() {
        return codcr;
    }

    public void setCodcr(String codcr) {
        this.codcr = codcr;
    }

    public String getCodmovenda() {
        return codmovenda;
    }

    public void setCodmovenda(String codmovenda) {
        this.codmovenda = codmovenda;
    }

    public String getCoduser() {
        return coduser;
    }

    public void setCoduser(String coduser) {
        this.coduser = coduser;
    }

    public String getCodrec() {
        return codrec;
    }

    public void setCodrec(String codrec) {
        this.codrec = codrec;
    }

    public String getNumdoc() {
        return numdoc;
    }

    public void setNumdoc(String numdoc) {
        this.numdoc = numdoc;
    }

    public String getDevedor() {
        return devedor;
    }

    public void setDevedor(String devedor) {
        this.devedor = devedor;
    }

    public Character getFlagcli() {
        return flagcli;
    }

    public void setFlagcli(Character flagcli) {
        this.flagcli = flagcli;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getDatentr() {
        return datentr;
    }

    public void setDatentr(Date datentr) {
        this.datentr = datentr;
    }

    public Date getDatvenc() {
        return datvenc;
    }

    public void setDatvenc(Date datvenc) {
        this.datvenc = datvenc;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getParcela() {
        return parcela;
    }

    public void setParcela(String parcela) {
        this.parcela = parcela;
    }

    public byte[] getObs() {
        return obs;
    }

    public void setObs(byte[] obs) {
        this.obs = obs;
    }

    public Short getAvisos() {
        return avisos;
    }

    public void setAvisos(Short avisos) {
        this.avisos = avisos;
    }

    public String getTipocobra() {
        return tipocobra;
    }

    public void setTipocobra(String tipocobra) {
        this.tipocobra = tipocobra;
    }

    public Date getDatcobra() {
        return datcobra;
    }

    public void setDatcobra(Date datcobra) {
        this.datcobra = datcobra;
    }

    public BigDecimal getTotpago() {
        return totpago;
    }

    public void setTotpago(BigDecimal totpago) {
        this.totpago = totpago;
    }

    public Character getFlagpago() {
        return flagpago;
    }

    public void setFlagpago(Character flagpago) {
        this.flagpago = flagpago;
    }

    public Date getDatpag() {
        return datpag;
    }

    public void setDatpag(Date datpag) {
        this.datpag = datpag;
    }

    public BigDecimal getValorpg() {
        return valorpg;
    }

    public void setValorpg(BigDecimal valorpg) {
        this.valorpg = valorpg;
    }

    public BigDecimal getJuros() {
        return juros;
    }

    public void setJuros(BigDecimal juros) {
        this.juros = juros;
    }

    public BigDecimal getTaxa() {
        return taxa;
    }

    public void setTaxa(BigDecimal taxa) {
        this.taxa = taxa;
    }

    public BigInteger getNossonumero() {
        return nossonumero;
    }

    public void setNossonumero(BigInteger nossonumero) {
        this.nossonumero = nossonumero;
    }

    public Date getDataremessa() {
        return dataremessa;
    }

    public void setDataremessa(Date dataremessa) {
        this.dataremessa = dataremessa;
    }

    public BigDecimal getDescatevenc() {
        return descatevenc;
    }

    public void setDescatevenc(BigDecimal descatevenc) {
        this.descatevenc = descatevenc;
    }

    public Character getDispjuros() {
        return dispjuros;
    }

    public void setDispjuros(Character dispjuros) {
        this.dispjuros = dispjuros;
    }

    public Date getLastChange() {
        return lastChange;
    }

    public void setLastChange(Date lastChange) {
        this.lastChange = lastChange;
    }

    public Date getDatvencfixa() {
        return datvencfixa;
    }

    public void setDatvencfixa(Date datvencfixa) {
        this.datvencfixa = datvencfixa;
    }

    public String getLocalfixa() {
        return localfixa;
    }

    public void setLocalfixa(String localfixa) {
        this.localfixa = localfixa;
    }

    public BigDecimal getValorfixa() {
        return valorfixa;
    }

    public void setValorfixa(BigDecimal valorfixa) {
        this.valorfixa = valorfixa;
    }

    public Character getFlagcancelada() {
        return flagcancelada;
    }

    public void setFlagcancelada(Character flagcancelada) {
        this.flagcancelada = flagcancelada;
    }

    public String getMotivocancelamento() {
        return motivocancelamento;
    }

    public void setMotivocancelamento(String motivocancelamento) {
        this.motivocancelamento = motivocancelamento;
    }

    public Character getFlag9() {
        return flag9;
    }

    public void setFlag9(Character flag9) {
        this.flag9 = flag9;
    }

    public Character getFlagtipoemissaocobranca() {
        return flagtipoemissaocobranca;
    }

    public void setFlagtipoemissaocobranca(Character flagtipoemissaocobranca) {
        this.flagtipoemissaocobranca = flagtipoemissaocobranca;
    }

    public Date getDatalancamento() {
        return datalancamento;
    }

    public void setDatalancamento(Date datalancamento) {
        this.datalancamento = datalancamento;
    }

    public BigDecimal getTaxapaga() {
        return taxapaga;
    }

    public void setTaxapaga(BigDecimal taxapaga) {
        this.taxapaga = taxapaga;
    }

    public Character getFlagtipomulta() {
        return flagtipomulta;
    }

    public void setFlagtipomulta(Character flagtipomulta) {
        this.flagtipomulta = flagtipomulta;
    }

    public BigDecimal getAliqmulta() {
        return aliqmulta;
    }

    public void setAliqmulta(BigDecimal aliqmulta) {
        this.aliqmulta = aliqmulta;
    }

    public BigDecimal getValormulta() {
        return valormulta;
    }

    public void setValormulta(BigDecimal valormulta) {
        this.valormulta = valormulta;
    }

    public String getRefercontafixa() {
        return refercontafixa;
    }

    public void setRefercontafixa(String refercontafixa) {
        this.refercontafixa = refercontafixa;
    }

    public Character getFlagrenegociada() {
        return flagrenegociada;
    }

    public void setFlagrenegociada(Character flagrenegociada) {
        this.flagrenegociada = flagrenegociada;
    }

    public String getCodforn() {
        return codforn;
    }

    public void setCodforn(String codforn) {
        this.codforn = codforn;
    }

    public String getCodfornvenda() {
        return codfornvenda;
    }

    public void setCodfornvenda(String codfornvenda) {
        this.codfornvenda = codfornvenda;
    }

    public String getCodmoventr() {
        return codmoventr;
    }

    public void setCodmoventr(String codmoventr) {
        this.codmoventr = codmoventr;
    }

    public Date getDatvencoriginal() {
        return datvencoriginal;
    }

    public void setDatvencoriginal(Date datvencoriginal) {
        this.datvencoriginal = datvencoriginal;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Character getFlagboletoonline() {
        return flagboletoonline;
    }

    public void setFlagboletoonline(Character flagboletoonline) {
        this.flagboletoonline = flagboletoonline;
    }

    public Character getDispmulta() {
        return dispmulta;
    }

    public void setDispmulta(Character dispmulta) {
        this.dispmulta = dispmulta;
    }

    public Date getDatcanc() {
        return datcanc;
    }

    public void setDatcanc(Date datcanc) {
        this.datcanc = datcanc;
    }

    public String getCodusuariocancelamento() {
        return codusuariocancelamento;
    }

    public void setCodusuariocancelamento(String codusuariocancelamento) {
        this.codusuariocancelamento = codusuariocancelamento;
    }

    @XmlTransient
    public Collection<Historicocobranca> getHistoricocobrancaCollection() {
        return historicocobrancaCollection;
    }

    public void setHistoricocobrancaCollection(Collection<Historicocobranca> historicocobrancaCollection) {
        this.historicocobrancaCollection = historicocobrancaCollection;
    }

    @XmlTransient
    public Collection<Recebimentos> getRecebimentosCollection() {
        return recebimentosCollection;
    }

    public void setRecebimentosCollection(Collection<Recebimentos> recebimentosCollection) {
        this.recebimentosCollection = recebimentosCollection;
    }

    @XmlTransient
    public Collection<Contareceberrec> getContareceberrecCollection() {
        return contareceberrecCollection;
    }

    public void setContareceberrecCollection(Collection<Contareceberrec> contareceberrecCollection) {
        this.contareceberrecCollection = contareceberrecCollection;
    }

    public Cliente getCodcli() {
        return codcli;
    }

    public void setCodcli(Cliente codcli) {
        this.codcli = codcli;
    }

    public Atendimento getCodatend() {
        return codatend;
    }

    public void setCodatend(Atendimento codatend) {
        this.codatend = codatend;
    }

    public Caixas getCodcaixas() {
        return codcaixas;
    }

    public void setCodcaixas(Caixas codcaixas) {
        this.codcaixas = codcaixas;
    }

    public Centrocusto getCodcentrocusto() {
        return codcentrocusto;
    }

    public void setCodcentrocusto(Centrocusto codcentrocusto) {
        this.codcentrocusto = codcentrocusto;
    }

    public Cliente getCodclivenda() {
        return codclivenda;
    }

    public void setCodclivenda(Cliente codclivenda) {
        this.codclivenda = codclivenda;
    }

    public Conhecimentotransporte getCodconhecimentotransporte() {
        return codconhecimentotransporte;
    }

    public void setCodconhecimentotransporte(Conhecimentotransporte codconhecimentotransporte) {
        this.codconhecimentotransporte = codconhecimentotransporte;
    }

    public Contabancaria getCodcontabancaria() {
        return codcontabancaria;
    }

    public void setCodcontabancaria(Contabancaria codcontabancaria) {
        this.codcontabancaria = codcontabancaria;
    }

    public Contareceberfixa getCodcrfixa() {
        return codcrfixa;
    }

    public void setCodcrfixa(Contareceberfixa codcrfixa) {
        this.codcrfixa = codcrfixa;
    }

    public Empresa getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Empresa codempresa) {
        this.codempresa = codempresa;
    }

    public Planoconta getCodpc() {
        return codpc;
    }

    public void setCodpc(Planoconta codpc) {
        this.codpc = codpc;
    }

    public Renegociacao getCodrenegociacao() {
        return codrenegociacao;
    }

    public void setCodrenegociacao(Renegociacao codrenegociacao) {
        this.codrenegociacao = codrenegociacao;
    }

    public Situacaoadministrativa getCodsituacaoadministrativa() {
        return codsituacaoadministrativa;
    }

    public void setCodsituacaoadministrativa(Situacaoadministrativa codsituacaoadministrativa) {
        this.codsituacaoadministrativa = codsituacaoadministrativa;
    }

    @XmlTransient
    public Collection<Lancacartao> getLancacartaoCollection() {
        return lancacartaoCollection;
    }

    public void setLancacartaoCollection(Collection<Lancacartao> lancacartaoCollection) {
        this.lancacartaoCollection = lancacartaoCollection;
    }

    @XmlTransient
    public Collection<Historicocarteira> getHistoricocarteiraCollection() {
        return historicocarteiraCollection;
    }

    public void setHistoricocarteiraCollection(Collection<Historicocarteira> historicocarteiraCollection) {
        this.historicocarteiraCollection = historicocarteiraCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcr != null ? codcr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contareceber)) {
            return false;
        }
        Contareceber other = (Contareceber) object;
        if ((this.codcr == null && other.codcr != null) || (this.codcr != null && !this.codcr.equals(other.codcr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Contareceber[ codcr=" + codcr + " ]";
    }
    
}
