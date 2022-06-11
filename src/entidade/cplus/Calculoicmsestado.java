/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "CALCULOICMSESTADO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calculoicmsestado.findAll", query = "SELECT c FROM Calculoicmsestado c")
    , @NamedQuery(name = "Calculoicmsestado.findByCodcalculoicmsestado", query = "SELECT c FROM Calculoicmsestado c WHERE c.codcalculoicmsestado = :codcalculoicmsestado")
    , @NamedQuery(name = "Calculoicmsestado.findByCodsituacaotributaria", query = "SELECT c FROM Calculoicmsestado c WHERE c.codsituacaotributaria = :codsituacaotributaria")
    , @NamedQuery(name = "Calculoicmsestado.findByAliqreducaobaseicms", query = "SELECT c FROM Calculoicmsestado c WHERE c.aliqreducaobaseicms = :aliqreducaobaseicms")
    , @NamedQuery(name = "Calculoicmsestado.findByAliqicms", query = "SELECT c FROM Calculoicmsestado c WHERE c.aliqicms = :aliqicms")
    , @NamedQuery(name = "Calculoicmsestado.findByFlagcalculasubsttributaria", query = "SELECT c FROM Calculoicmsestado c WHERE c.flagcalculasubsttributaria = :flagcalculasubsttributaria")
    , @NamedQuery(name = "Calculoicmsestado.findByAliqlucro", query = "SELECT c FROM Calculoicmsestado c WHERE c.aliqlucro = :aliqlucro")
    , @NamedQuery(name = "Calculoicmsestado.findByFlagtiposubsttributaria", query = "SELECT c FROM Calculoicmsestado c WHERE c.flagtiposubsttributaria = :flagtiposubsttributaria")
    , @NamedQuery(name = "Calculoicmsestado.findByAliqlucrodistribuidor", query = "SELECT c FROM Calculoicmsestado c WHERE c.aliqlucrodistribuidor = :aliqlucrodistribuidor")
    , @NamedQuery(name = "Calculoicmsestado.findByAliqicmsmicroempresa", query = "SELECT c FROM Calculoicmsestado c WHERE c.aliqicmsmicroempresa = :aliqicmsmicroempresa")
    , @NamedQuery(name = "Calculoicmsestado.findByFlagintegracaofiscal", query = "SELECT c FROM Calculoicmsestado c WHERE c.flagintegracaofiscal = :flagintegracaofiscal")
    , @NamedQuery(name = "Calculoicmsestado.findByFlagtipomvaclassificacao", query = "SELECT c FROM Calculoicmsestado c WHERE c.flagtipomvaclassificacao = :flagtipomvaclassificacao")
    , @NamedQuery(name = "Calculoicmsestado.findByAliqreducaobasesubsttribdif", query = "SELECT c FROM Calculoicmsestado c WHERE c.aliqreducaobasesubsttribdif = :aliqreducaobasesubsttribdif")
    , @NamedQuery(name = "Calculoicmsestado.findByAliqlucrodif", query = "SELECT c FROM Calculoicmsestado c WHERE c.aliqlucrodif = :aliqlucrodif")
    , @NamedQuery(name = "Calculoicmsestado.findByAliqicmsdiferenciada", query = "SELECT c FROM Calculoicmsestado c WHERE c.aliqicmsdiferenciada = :aliqicmsdiferenciada")
    , @NamedQuery(name = "Calculoicmsestado.findByAliqreducaobasesubsttributaria", query = "SELECT c FROM Calculoicmsestado c WHERE c.aliqreducaobasesubsttributaria = :aliqreducaobasesubsttributaria")
    , @NamedQuery(name = "Calculoicmsestado.findByFlagusamvaclassificacaofiscal", query = "SELECT c FROM Calculoicmsestado c WHERE c.flagusamvaclassificacaofiscal = :flagusamvaclassificacaofiscal")
    , @NamedQuery(name = "Calculoicmsestado.findByCodsituacaotributariadif", query = "SELECT c FROM Calculoicmsestado c WHERE c.codsituacaotributariadif = :codsituacaotributariadif")
    , @NamedQuery(name = "Calculoicmsestado.findByCstpis", query = "SELECT c FROM Calculoicmsestado c WHERE c.cstpis = :cstpis")
    , @NamedQuery(name = "Calculoicmsestado.findByCstcofins", query = "SELECT c FROM Calculoicmsestado c WHERE c.cstcofins = :cstcofins")
    , @NamedQuery(name = "Calculoicmsestado.findByAliqpis", query = "SELECT c FROM Calculoicmsestado c WHERE c.aliqpis = :aliqpis")
    , @NamedQuery(name = "Calculoicmsestado.findByAliqcofins", query = "SELECT c FROM Calculoicmsestado c WHERE c.aliqcofins = :aliqcofins")
    , @NamedQuery(name = "Calculoicmsestado.findByCsosn", query = "SELECT c FROM Calculoicmsestado c WHERE c.csosn = :csosn")
    , @NamedQuery(name = "Calculoicmsestado.findByCsosndiferenciada", query = "SELECT c FROM Calculoicmsestado c WHERE c.csosndiferenciada = :csosndiferenciada")
    , @NamedQuery(name = "Calculoicmsestado.findByFlagintegracaofiscalbaseicms", query = "SELECT c FROM Calculoicmsestado c WHERE c.flagintegracaofiscalbaseicms = :flagintegracaofiscalbaseicms")
    , @NamedQuery(name = "Calculoicmsestado.findByFlagintegracaofiscalbaseipi", query = "SELECT c FROM Calculoicmsestado c WHERE c.flagintegracaofiscalbaseipi = :flagintegracaofiscalbaseipi")
    , @NamedQuery(name = "Calculoicmsestado.findByFlagintegracaofiscalvaloripi", query = "SELECT c FROM Calculoicmsestado c WHERE c.flagintegracaofiscalvaloripi = :flagintegracaofiscalvaloripi")
    , @NamedQuery(name = "Calculoicmsestado.findByFlagcofinsporquantidade", query = "SELECT c FROM Calculoicmsestado c WHERE c.flagcofinsporquantidade = :flagcofinsporquantidade")
    , @NamedQuery(name = "Calculoicmsestado.findByFlagpisporquantidade", query = "SELECT c FROM Calculoicmsestado c WHERE c.flagpisporquantidade = :flagpisporquantidade")
    , @NamedQuery(name = "Calculoicmsestado.findByAliqreducaobaseicmsdif", query = "SELECT c FROM Calculoicmsestado c WHERE c.aliqreducaobaseicmsdif = :aliqreducaobaseicmsdif")
    , @NamedQuery(name = "Calculoicmsestado.findByCstpisdif", query = "SELECT c FROM Calculoicmsestado c WHERE c.cstpisdif = :cstpisdif")
    , @NamedQuery(name = "Calculoicmsestado.findByAliqpisdif", query = "SELECT c FROM Calculoicmsestado c WHERE c.aliqpisdif = :aliqpisdif")
    , @NamedQuery(name = "Calculoicmsestado.findByCstcofinsdif", query = "SELECT c FROM Calculoicmsestado c WHERE c.cstcofinsdif = :cstcofinsdif")
    , @NamedQuery(name = "Calculoicmsestado.findByAliqcofinsdif", query = "SELECT c FROM Calculoicmsestado c WHERE c.aliqcofinsdif = :aliqcofinsdif")
    , @NamedQuery(name = "Calculoicmsestado.findByAliqicmsincentfiscal", query = "SELECT c FROM Calculoicmsestado c WHERE c.aliqicmsincentfiscal = :aliqicmsincentfiscal")
    , @NamedQuery(name = "Calculoicmsestado.findByAliqicmsincentfiscaldif", query = "SELECT c FROM Calculoicmsestado c WHERE c.aliqicmsincentfiscaldif = :aliqicmsincentfiscaldif")
    , @NamedQuery(name = "Calculoicmsestado.findByAliqdiferimento", query = "SELECT c FROM Calculoicmsestado c WHERE c.aliqdiferimento = :aliqdiferimento")
    , @NamedQuery(name = "Calculoicmsestado.findByAliqdiferimentodif", query = "SELECT c FROM Calculoicmsestado c WHERE c.aliqdiferimentodif = :aliqdiferimentodif")
    , @NamedQuery(name = "Calculoicmsestado.findByAliqfcp", query = "SELECT c FROM Calculoicmsestado c WHERE c.aliqfcp = :aliqfcp")
    , @NamedQuery(name = "Calculoicmsestado.findByAliqfcpdif", query = "SELECT c FROM Calculoicmsestado c WHERE c.aliqfcpdif = :aliqfcpdif")
    , @NamedQuery(name = "Calculoicmsestado.findByCodbeneficiofiscal", query = "SELECT c FROM Calculoicmsestado c WHERE c.codbeneficiofiscal = :codbeneficiofiscal")
    , @NamedQuery(name = "Calculoicmsestado.findByCodbeneficiofiscaldif", query = "SELECT c FROM Calculoicmsestado c WHERE c.codbeneficiofiscaldif = :codbeneficiofiscaldif")})
public class Calculoicmsestado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCALCULOICMSESTADO")
    private String codcalculoicmsestado;
    @Column(name = "CODSITUACAOTRIBUTARIA")
    private String codsituacaotributaria;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ALIQREDUCAOBASEICMS")
    private BigDecimal aliqreducaobaseicms;
    @Column(name = "ALIQICMS")
    private BigDecimal aliqicms;
    @Column(name = "FLAGCALCULASUBSTTRIBUTARIA")
    private Character flagcalculasubsttributaria;
    @Column(name = "ALIQLUCRO")
    private BigDecimal aliqlucro;
    @Column(name = "FLAGTIPOSUBSTTRIBUTARIA")
    private Character flagtiposubsttributaria;
    @Column(name = "ALIQLUCRODISTRIBUIDOR")
    private BigDecimal aliqlucrodistribuidor;
    @Column(name = "ALIQICMSMICROEMPRESA")
    private BigDecimal aliqicmsmicroempresa;
    @Column(name = "FLAGINTEGRACAOFISCAL")
    private Character flagintegracaofiscal;
    @Column(name = "FLAGTIPOMVACLASSIFICACAO")
    private Character flagtipomvaclassificacao;
    @Column(name = "ALIQREDUCAOBASESUBSTTRIBDIF")
    private BigDecimal aliqreducaobasesubsttribdif;
    @Column(name = "ALIQLUCRODIF")
    private BigDecimal aliqlucrodif;
    @Column(name = "ALIQICMSDIFERENCIADA")
    private BigDecimal aliqicmsdiferenciada;
    @Column(name = "ALIQREDUCAOBASESUBSTTRIBUTARIA")
    private BigDecimal aliqreducaobasesubsttributaria;
    @Column(name = "FLAGUSAMVACLASSIFICACAOFISCAL")
    private Character flagusamvaclassificacaofiscal;
    @Column(name = "CODSITUACAOTRIBUTARIADIF")
    private String codsituacaotributariadif;
    @Column(name = "CSTPIS")
    private String cstpis;
    @Column(name = "CSTCOFINS")
    private String cstcofins;
    @Column(name = "ALIQPIS")
    private BigDecimal aliqpis;
    @Column(name = "ALIQCOFINS")
    private BigDecimal aliqcofins;
    @Column(name = "CSOSN")
    private String csosn;
    @Column(name = "CSOSNDIFERENCIADA")
    private String csosndiferenciada;
    @Column(name = "FLAGINTEGRACAOFISCALBASEICMS")
    private Character flagintegracaofiscalbaseicms;
    @Column(name = "FLAGINTEGRACAOFISCALBASEIPI")
    private Character flagintegracaofiscalbaseipi;
    @Column(name = "FLAGINTEGRACAOFISCALVALORIPI")
    private Character flagintegracaofiscalvaloripi;
    @Column(name = "FLAGCOFINSPORQUANTIDADE")
    private Character flagcofinsporquantidade;
    @Column(name = "FLAGPISPORQUANTIDADE")
    private Character flagpisporquantidade;
    @Column(name = "ALIQREDUCAOBASEICMSDIF")
    private BigDecimal aliqreducaobaseicmsdif;
    @Column(name = "CSTPISDIF")
    private String cstpisdif;
    @Column(name = "ALIQPISDIF")
    private BigDecimal aliqpisdif;
    @Column(name = "CSTCOFINSDIF")
    private String cstcofinsdif;
    @Column(name = "ALIQCOFINSDIF")
    private BigDecimal aliqcofinsdif;
    @Column(name = "ALIQICMSINCENTFISCAL")
    private BigDecimal aliqicmsincentfiscal;
    @Column(name = "ALIQICMSINCENTFISCALDIF")
    private BigDecimal aliqicmsincentfiscaldif;
    @Column(name = "ALIQDIFERIMENTO")
    private BigDecimal aliqdiferimento;
    @Column(name = "ALIQDIFERIMENTODIF")
    private BigDecimal aliqdiferimentodif;
    @Column(name = "ALIQFCP")
    private BigDecimal aliqfcp;
    @Column(name = "ALIQFCPDIF")
    private BigDecimal aliqfcpdif;
    @Column(name = "CODBENEFICIOFISCAL")
    private String codbeneficiofiscal;
    @Column(name = "CODBENEFICIOFISCALDIF")
    private String codbeneficiofiscaldif;
    @JoinColumn(name = "CODCALCULOICMS", referencedColumnName = "CODCALCULOICMS")
    @ManyToOne(optional = false)
    private Calculoicms codcalculoicms;
    @JoinColumn(name = "CODCFOP", referencedColumnName = "CODCFOP")
    @ManyToOne
    private Cfop codcfop;
    @JoinColumn(name = "CODMENSAGEM", referencedColumnName = "CODMENSAGEM")
    @ManyToOne
    private Mensagem codmensagem;
    @JoinColumn(name = "CODIGOMOTIVODESO", referencedColumnName = "CODIGOMOTIVO")
    @ManyToOne
    private Motivodesoneracao codigomotivodeso;
    @JoinColumn(name = "CODIGOMOTIVODESODIF", referencedColumnName = "CODIGOMOTIVO")
    @ManyToOne
    private Motivodesoneracao codigomotivodesodif;
    @JoinColumn(name = "CODPRECO", referencedColumnName = "CODPRECO")
    @ManyToOne
    private Preco codpreco;
    @JoinColumn(name = "CODPRECODISTRIBUIDOR", referencedColumnName = "CODPRECO")
    @ManyToOne
    private Preco codprecodistribuidor;
    @JoinColumn(name = "CODUFDESTINO", referencedColumnName = "CODUF")
    @ManyToOne(optional = false)
    private Uf codufdestino;
    @JoinColumn(name = "CODUFORIGEM", referencedColumnName = "CODUF")
    @ManyToOne(optional = false)
    private Uf coduforigem;

    public Calculoicmsestado() {
    }

    public Calculoicmsestado(String codcalculoicmsestado) {
        this.codcalculoicmsestado = codcalculoicmsestado;
    }

    public String getCodcalculoicmsestado() {
        return codcalculoicmsestado;
    }

    public void setCodcalculoicmsestado(String codcalculoicmsestado) {
        this.codcalculoicmsestado = codcalculoicmsestado;
    }

    public String getCodsituacaotributaria() {
        return codsituacaotributaria;
    }

    public void setCodsituacaotributaria(String codsituacaotributaria) {
        this.codsituacaotributaria = codsituacaotributaria;
    }

    public BigDecimal getAliqreducaobaseicms() {
        return aliqreducaobaseicms;
    }

    public void setAliqreducaobaseicms(BigDecimal aliqreducaobaseicms) {
        this.aliqreducaobaseicms = aliqreducaobaseicms;
    }

    public BigDecimal getAliqicms() {
        return aliqicms;
    }

    public void setAliqicms(BigDecimal aliqicms) {
        this.aliqicms = aliqicms;
    }

    public Character getFlagcalculasubsttributaria() {
        return flagcalculasubsttributaria;
    }

    public void setFlagcalculasubsttributaria(Character flagcalculasubsttributaria) {
        this.flagcalculasubsttributaria = flagcalculasubsttributaria;
    }

    public BigDecimal getAliqlucro() {
        return aliqlucro;
    }

    public void setAliqlucro(BigDecimal aliqlucro) {
        this.aliqlucro = aliqlucro;
    }

    public Character getFlagtiposubsttributaria() {
        return flagtiposubsttributaria;
    }

    public void setFlagtiposubsttributaria(Character flagtiposubsttributaria) {
        this.flagtiposubsttributaria = flagtiposubsttributaria;
    }

    public BigDecimal getAliqlucrodistribuidor() {
        return aliqlucrodistribuidor;
    }

    public void setAliqlucrodistribuidor(BigDecimal aliqlucrodistribuidor) {
        this.aliqlucrodistribuidor = aliqlucrodistribuidor;
    }

    public BigDecimal getAliqicmsmicroempresa() {
        return aliqicmsmicroempresa;
    }

    public void setAliqicmsmicroempresa(BigDecimal aliqicmsmicroempresa) {
        this.aliqicmsmicroempresa = aliqicmsmicroempresa;
    }

    public Character getFlagintegracaofiscal() {
        return flagintegracaofiscal;
    }

    public void setFlagintegracaofiscal(Character flagintegracaofiscal) {
        this.flagintegracaofiscal = flagintegracaofiscal;
    }

    public Character getFlagtipomvaclassificacao() {
        return flagtipomvaclassificacao;
    }

    public void setFlagtipomvaclassificacao(Character flagtipomvaclassificacao) {
        this.flagtipomvaclassificacao = flagtipomvaclassificacao;
    }

    public BigDecimal getAliqreducaobasesubsttribdif() {
        return aliqreducaobasesubsttribdif;
    }

    public void setAliqreducaobasesubsttribdif(BigDecimal aliqreducaobasesubsttribdif) {
        this.aliqreducaobasesubsttribdif = aliqreducaobasesubsttribdif;
    }

    public BigDecimal getAliqlucrodif() {
        return aliqlucrodif;
    }

    public void setAliqlucrodif(BigDecimal aliqlucrodif) {
        this.aliqlucrodif = aliqlucrodif;
    }

    public BigDecimal getAliqicmsdiferenciada() {
        return aliqicmsdiferenciada;
    }

    public void setAliqicmsdiferenciada(BigDecimal aliqicmsdiferenciada) {
        this.aliqicmsdiferenciada = aliqicmsdiferenciada;
    }

    public BigDecimal getAliqreducaobasesubsttributaria() {
        return aliqreducaobasesubsttributaria;
    }

    public void setAliqreducaobasesubsttributaria(BigDecimal aliqreducaobasesubsttributaria) {
        this.aliqreducaobasesubsttributaria = aliqreducaobasesubsttributaria;
    }

    public Character getFlagusamvaclassificacaofiscal() {
        return flagusamvaclassificacaofiscal;
    }

    public void setFlagusamvaclassificacaofiscal(Character flagusamvaclassificacaofiscal) {
        this.flagusamvaclassificacaofiscal = flagusamvaclassificacaofiscal;
    }

    public String getCodsituacaotributariadif() {
        return codsituacaotributariadif;
    }

    public void setCodsituacaotributariadif(String codsituacaotributariadif) {
        this.codsituacaotributariadif = codsituacaotributariadif;
    }

    public String getCstpis() {
        return cstpis;
    }

    public void setCstpis(String cstpis) {
        this.cstpis = cstpis;
    }

    public String getCstcofins() {
        return cstcofins;
    }

    public void setCstcofins(String cstcofins) {
        this.cstcofins = cstcofins;
    }

    public BigDecimal getAliqpis() {
        return aliqpis;
    }

    public void setAliqpis(BigDecimal aliqpis) {
        this.aliqpis = aliqpis;
    }

    public BigDecimal getAliqcofins() {
        return aliqcofins;
    }

    public void setAliqcofins(BigDecimal aliqcofins) {
        this.aliqcofins = aliqcofins;
    }

    public String getCsosn() {
        return csosn;
    }

    public void setCsosn(String csosn) {
        this.csosn = csosn;
    }

    public String getCsosndiferenciada() {
        return csosndiferenciada;
    }

    public void setCsosndiferenciada(String csosndiferenciada) {
        this.csosndiferenciada = csosndiferenciada;
    }

    public Character getFlagintegracaofiscalbaseicms() {
        return flagintegracaofiscalbaseicms;
    }

    public void setFlagintegracaofiscalbaseicms(Character flagintegracaofiscalbaseicms) {
        this.flagintegracaofiscalbaseicms = flagintegracaofiscalbaseicms;
    }

    public Character getFlagintegracaofiscalbaseipi() {
        return flagintegracaofiscalbaseipi;
    }

    public void setFlagintegracaofiscalbaseipi(Character flagintegracaofiscalbaseipi) {
        this.flagintegracaofiscalbaseipi = flagintegracaofiscalbaseipi;
    }

    public Character getFlagintegracaofiscalvaloripi() {
        return flagintegracaofiscalvaloripi;
    }

    public void setFlagintegracaofiscalvaloripi(Character flagintegracaofiscalvaloripi) {
        this.flagintegracaofiscalvaloripi = flagintegracaofiscalvaloripi;
    }

    public Character getFlagcofinsporquantidade() {
        return flagcofinsporquantidade;
    }

    public void setFlagcofinsporquantidade(Character flagcofinsporquantidade) {
        this.flagcofinsporquantidade = flagcofinsporquantidade;
    }

    public Character getFlagpisporquantidade() {
        return flagpisporquantidade;
    }

    public void setFlagpisporquantidade(Character flagpisporquantidade) {
        this.flagpisporquantidade = flagpisporquantidade;
    }

    public BigDecimal getAliqreducaobaseicmsdif() {
        return aliqreducaobaseicmsdif;
    }

    public void setAliqreducaobaseicmsdif(BigDecimal aliqreducaobaseicmsdif) {
        this.aliqreducaobaseicmsdif = aliqreducaobaseicmsdif;
    }

    public String getCstpisdif() {
        return cstpisdif;
    }

    public void setCstpisdif(String cstpisdif) {
        this.cstpisdif = cstpisdif;
    }

    public BigDecimal getAliqpisdif() {
        return aliqpisdif;
    }

    public void setAliqpisdif(BigDecimal aliqpisdif) {
        this.aliqpisdif = aliqpisdif;
    }

    public String getCstcofinsdif() {
        return cstcofinsdif;
    }

    public void setCstcofinsdif(String cstcofinsdif) {
        this.cstcofinsdif = cstcofinsdif;
    }

    public BigDecimal getAliqcofinsdif() {
        return aliqcofinsdif;
    }

    public void setAliqcofinsdif(BigDecimal aliqcofinsdif) {
        this.aliqcofinsdif = aliqcofinsdif;
    }

    public BigDecimal getAliqicmsincentfiscal() {
        return aliqicmsincentfiscal;
    }

    public void setAliqicmsincentfiscal(BigDecimal aliqicmsincentfiscal) {
        this.aliqicmsincentfiscal = aliqicmsincentfiscal;
    }

    public BigDecimal getAliqicmsincentfiscaldif() {
        return aliqicmsincentfiscaldif;
    }

    public void setAliqicmsincentfiscaldif(BigDecimal aliqicmsincentfiscaldif) {
        this.aliqicmsincentfiscaldif = aliqicmsincentfiscaldif;
    }

    public BigDecimal getAliqdiferimento() {
        return aliqdiferimento;
    }

    public void setAliqdiferimento(BigDecimal aliqdiferimento) {
        this.aliqdiferimento = aliqdiferimento;
    }

    public BigDecimal getAliqdiferimentodif() {
        return aliqdiferimentodif;
    }

    public void setAliqdiferimentodif(BigDecimal aliqdiferimentodif) {
        this.aliqdiferimentodif = aliqdiferimentodif;
    }

    public BigDecimal getAliqfcp() {
        return aliqfcp;
    }

    public void setAliqfcp(BigDecimal aliqfcp) {
        this.aliqfcp = aliqfcp;
    }

    public BigDecimal getAliqfcpdif() {
        return aliqfcpdif;
    }

    public void setAliqfcpdif(BigDecimal aliqfcpdif) {
        this.aliqfcpdif = aliqfcpdif;
    }

    public String getCodbeneficiofiscal() {
        return codbeneficiofiscal;
    }

    public void setCodbeneficiofiscal(String codbeneficiofiscal) {
        this.codbeneficiofiscal = codbeneficiofiscal;
    }

    public String getCodbeneficiofiscaldif() {
        return codbeneficiofiscaldif;
    }

    public void setCodbeneficiofiscaldif(String codbeneficiofiscaldif) {
        this.codbeneficiofiscaldif = codbeneficiofiscaldif;
    }

    public Calculoicms getCodcalculoicms() {
        return codcalculoicms;
    }

    public void setCodcalculoicms(Calculoicms codcalculoicms) {
        this.codcalculoicms = codcalculoicms;
    }

    public Cfop getCodcfop() {
        return codcfop;
    }

    public void setCodcfop(Cfop codcfop) {
        this.codcfop = codcfop;
    }

    public Mensagem getCodmensagem() {
        return codmensagem;
    }

    public void setCodmensagem(Mensagem codmensagem) {
        this.codmensagem = codmensagem;
    }

    public Motivodesoneracao getCodigomotivodeso() {
        return codigomotivodeso;
    }

    public void setCodigomotivodeso(Motivodesoneracao codigomotivodeso) {
        this.codigomotivodeso = codigomotivodeso;
    }

    public Motivodesoneracao getCodigomotivodesodif() {
        return codigomotivodesodif;
    }

    public void setCodigomotivodesodif(Motivodesoneracao codigomotivodesodif) {
        this.codigomotivodesodif = codigomotivodesodif;
    }

    public Preco getCodpreco() {
        return codpreco;
    }

    public void setCodpreco(Preco codpreco) {
        this.codpreco = codpreco;
    }

    public Preco getCodprecodistribuidor() {
        return codprecodistribuidor;
    }

    public void setCodprecodistribuidor(Preco codprecodistribuidor) {
        this.codprecodistribuidor = codprecodistribuidor;
    }

    public Uf getCodufdestino() {
        return codufdestino;
    }

    public void setCodufdestino(Uf codufdestino) {
        this.codufdestino = codufdestino;
    }

    public Uf getCoduforigem() {
        return coduforigem;
    }

    public void setCoduforigem(Uf coduforigem) {
        this.coduforigem = coduforigem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcalculoicmsestado != null ? codcalculoicmsestado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calculoicmsestado)) {
            return false;
        }
        Calculoicmsestado other = (Calculoicmsestado) object;
        if ((this.codcalculoicmsestado == null && other.codcalculoicmsestado != null) || (this.codcalculoicmsestado != null && !this.codcalculoicmsestado.equals(other.codcalculoicmsestado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Calculoicmsestado[ codcalculoicmsestado=" + codcalculoicmsestado + " ]";
    }
    
}
