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
@Table(name = "DOCUMENTOTRANSPORTE", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Documentotransporte.findAll", query = "SELECT d FROM Documentotransporte d")
    , @NamedQuery(name = "Documentotransporte.findByCoddocumentotransporte", query = "SELECT d FROM Documentotransporte d WHERE d.coddocumentotransporte = :coddocumentotransporte")
    , @NamedQuery(name = "Documentotransporte.findByCodtrans", query = "SELECT d FROM Documentotransporte d WHERE d.codtrans = :codtrans")
    , @NamedQuery(name = "Documentotransporte.findByCodempresa", query = "SELECT d FROM Documentotransporte d WHERE d.codempresa = :codempresa")
    , @NamedQuery(name = "Documentotransporte.findByDatautilizacao", query = "SELECT d FROM Documentotransporte d WHERE d.datautilizacao = :datautilizacao")
    , @NamedQuery(name = "Documentotransporte.findByUf", query = "SELECT d FROM Documentotransporte d WHERE d.uf = :uf")
    , @NamedQuery(name = "Documentotransporte.findByModelo", query = "SELECT d FROM Documentotransporte d WHERE d.modelo = :modelo")
    , @NamedQuery(name = "Documentotransporte.findBySerie", query = "SELECT d FROM Documentotransporte d WHERE d.serie = :serie")
    , @NamedQuery(name = "Documentotransporte.findBySubserie", query = "SELECT d FROM Documentotransporte d WHERE d.subserie = :subserie")
    , @NamedQuery(name = "Documentotransporte.findByNumero", query = "SELECT d FROM Documentotransporte d WHERE d.numero = :numero")
    , @NamedQuery(name = "Documentotransporte.findByCodcfop", query = "SELECT d FROM Documentotransporte d WHERE d.codcfop = :codcfop")
    , @NamedQuery(name = "Documentotransporte.findByValortotaldocumento", query = "SELECT d FROM Documentotransporte d WHERE d.valortotaldocumento = :valortotaldocumento")
    , @NamedQuery(name = "Documentotransporte.findByBaseicms", query = "SELECT d FROM Documentotransporte d WHERE d.baseicms = :baseicms")
    , @NamedQuery(name = "Documentotransporte.findByValoricms", query = "SELECT d FROM Documentotransporte d WHERE d.valoricms = :valoricms")
    , @NamedQuery(name = "Documentotransporte.findByValorisento", query = "SELECT d FROM Documentotransporte d WHERE d.valorisento = :valorisento")
    , @NamedQuery(name = "Documentotransporte.findByValoroutros", query = "SELECT d FROM Documentotransporte d WHERE d.valoroutros = :valoroutros")
    , @NamedQuery(name = "Documentotransporte.findByTipofrete", query = "SELECT d FROM Documentotransporte d WHERE d.tipofrete = :tipofrete")
    , @NamedQuery(name = "Documentotransporte.findByFlagtomador", query = "SELECT d FROM Documentotransporte d WHERE d.flagtomador = :flagtomador")
    , @NamedQuery(name = "Documentotransporte.findByCodcli", query = "SELECT d FROM Documentotransporte d WHERE d.codcli = :codcli")
    , @NamedQuery(name = "Documentotransporte.findByCodforn", query = "SELECT d FROM Documentotransporte d WHERE d.codforn = :codforn")
    , @NamedQuery(name = "Documentotransporte.findByCodmoventr", query = "SELECT d FROM Documentotransporte d WHERE d.codmoventr = :codmoventr")
    , @NamedQuery(name = "Documentotransporte.findByChaveacessocteletronica", query = "SELECT d FROM Documentotransporte d WHERE d.chaveacessocteletronica = :chaveacessocteletronica")
    , @NamedQuery(name = "Documentotransporte.findByTipomovimento", query = "SELECT d FROM Documentotransporte d WHERE d.tipomovimento = :tipomovimento")
    , @NamedQuery(name = "Documentotransporte.findByCsticms", query = "SELECT d FROM Documentotransporte d WHERE d.csticms = :csticms")
    , @NamedQuery(name = "Documentotransporte.findByCodmunicipioorigem", query = "SELECT d FROM Documentotransporte d WHERE d.codmunicipioorigem = :codmunicipioorigem")
    , @NamedQuery(name = "Documentotransporte.findByCodmunicipiodestino", query = "SELECT d FROM Documentotransporte d WHERE d.codmunicipiodestino = :codmunicipiodestino")
    , @NamedQuery(name = "Documentotransporte.findByDataemissao", query = "SELECT d FROM Documentotransporte d WHERE d.dataemissao = :dataemissao")
    , @NamedQuery(name = "Documentotransporte.findByCstpis", query = "SELECT d FROM Documentotransporte d WHERE d.cstpis = :cstpis")
    , @NamedQuery(name = "Documentotransporte.findByBasepis", query = "SELECT d FROM Documentotransporte d WHERE d.basepis = :basepis")
    , @NamedQuery(name = "Documentotransporte.findByValorpis", query = "SELECT d FROM Documentotransporte d WHERE d.valorpis = :valorpis")
    , @NamedQuery(name = "Documentotransporte.findByCstcofins", query = "SELECT d FROM Documentotransporte d WHERE d.cstcofins = :cstcofins")
    , @NamedQuery(name = "Documentotransporte.findByBasecofins", query = "SELECT d FROM Documentotransporte d WHERE d.basecofins = :basecofins")
    , @NamedQuery(name = "Documentotransporte.findByValorcofins", query = "SELECT d FROM Documentotransporte d WHERE d.valorcofins = :valorcofins")
    , @NamedQuery(name = "Documentotransporte.findByAliqpis", query = "SELECT d FROM Documentotransporte d WHERE d.aliqpis = :aliqpis")
    , @NamedQuery(name = "Documentotransporte.findByAliqcofins", query = "SELECT d FROM Documentotransporte d WHERE d.aliqcofins = :aliqcofins")})
public class Documentotransporte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODDOCUMENTOTRANSPORTE")
    private String coddocumentotransporte;
    @Column(name = "CODTRANS")
    private String codtrans;
    @Column(name = "CODEMPRESA")
    private Integer codempresa;
    @Column(name = "DATAUTILIZACAO")
    @Temporal(TemporalType.DATE)
    private Date datautilizacao;
    @Column(name = "UF")
    private String uf;
    @Column(name = "MODELO")
    private String modelo;
    @Column(name = "SERIE")
    private String serie;
    @Column(name = "SUBSERIE")
    private Character subserie;
    @Column(name = "NUMERO")
    private Integer numero;
    @Column(name = "CODCFOP")
    private String codcfop;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALORTOTALDOCUMENTO")
    private BigDecimal valortotaldocumento;
    @Column(name = "BASEICMS")
    private BigDecimal baseicms;
    @Column(name = "VALORICMS")
    private BigDecimal valoricms;
    @Column(name = "VALORISENTO")
    private BigDecimal valorisento;
    @Column(name = "VALOROUTROS")
    private BigDecimal valoroutros;
    @Column(name = "TIPOFRETE")
    private Short tipofrete;
    @Column(name = "FLAGTOMADOR")
    private Character flagtomador;
    @Column(name = "CODCLI")
    private String codcli;
    @Column(name = "CODFORN")
    private String codforn;
    @Column(name = "CODMOVENTR")
    private String codmoventr;
    @Column(name = "CHAVEACESSOCTELETRONICA")
    private String chaveacessocteletronica;
    @Column(name = "TIPOMOVIMENTO")
    private Character tipomovimento;
    @Column(name = "CSTICMS")
    private String csticms;
    @Column(name = "CODMUNICIPIOORIGEM")
    private String codmunicipioorigem;
    @Column(name = "CODMUNICIPIODESTINO")
    private String codmunicipiodestino;
    @Column(name = "DATAEMISSAO")
    @Temporal(TemporalType.DATE)
    private Date dataemissao;
    @Column(name = "CSTPIS")
    private String cstpis;
    @Column(name = "BASEPIS")
    private BigDecimal basepis;
    @Column(name = "VALORPIS")
    private BigDecimal valorpis;
    @Column(name = "CSTCOFINS")
    private String cstcofins;
    @Column(name = "BASECOFINS")
    private BigDecimal basecofins;
    @Column(name = "VALORCOFINS")
    private BigDecimal valorcofins;
    @Column(name = "ALIQPIS")
    private BigDecimal aliqpis;
    @Column(name = "ALIQCOFINS")
    private BigDecimal aliqcofins;
    @JoinColumn(name = "CODDOCUMENTO", referencedColumnName = "CODDOCUMENTO")
    @ManyToOne
    private Documento coddocumento;

    public Documentotransporte() {
    }

    public Documentotransporte(String coddocumentotransporte) {
        this.coddocumentotransporte = coddocumentotransporte;
    }

    public String getCoddocumentotransporte() {
        return coddocumentotransporte;
    }

    public void setCoddocumentotransporte(String coddocumentotransporte) {
        this.coddocumentotransporte = coddocumentotransporte;
    }

    public String getCodtrans() {
        return codtrans;
    }

    public void setCodtrans(String codtrans) {
        this.codtrans = codtrans;
    }

    public Integer getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Integer codempresa) {
        this.codempresa = codempresa;
    }

    public Date getDatautilizacao() {
        return datautilizacao;
    }

    public void setDatautilizacao(Date datautilizacao) {
        this.datautilizacao = datautilizacao;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public Character getSubserie() {
        return subserie;
    }

    public void setSubserie(Character subserie) {
        this.subserie = subserie;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCodcfop() {
        return codcfop;
    }

    public void setCodcfop(String codcfop) {
        this.codcfop = codcfop;
    }

    public BigDecimal getValortotaldocumento() {
        return valortotaldocumento;
    }

    public void setValortotaldocumento(BigDecimal valortotaldocumento) {
        this.valortotaldocumento = valortotaldocumento;
    }

    public BigDecimal getBaseicms() {
        return baseicms;
    }

    public void setBaseicms(BigDecimal baseicms) {
        this.baseicms = baseicms;
    }

    public BigDecimal getValoricms() {
        return valoricms;
    }

    public void setValoricms(BigDecimal valoricms) {
        this.valoricms = valoricms;
    }

    public BigDecimal getValorisento() {
        return valorisento;
    }

    public void setValorisento(BigDecimal valorisento) {
        this.valorisento = valorisento;
    }

    public BigDecimal getValoroutros() {
        return valoroutros;
    }

    public void setValoroutros(BigDecimal valoroutros) {
        this.valoroutros = valoroutros;
    }

    public Short getTipofrete() {
        return tipofrete;
    }

    public void setTipofrete(Short tipofrete) {
        this.tipofrete = tipofrete;
    }

    public Character getFlagtomador() {
        return flagtomador;
    }

    public void setFlagtomador(Character flagtomador) {
        this.flagtomador = flagtomador;
    }

    public String getCodcli() {
        return codcli;
    }

    public void setCodcli(String codcli) {
        this.codcli = codcli;
    }

    public String getCodforn() {
        return codforn;
    }

    public void setCodforn(String codforn) {
        this.codforn = codforn;
    }

    public String getCodmoventr() {
        return codmoventr;
    }

    public void setCodmoventr(String codmoventr) {
        this.codmoventr = codmoventr;
    }

    public String getChaveacessocteletronica() {
        return chaveacessocteletronica;
    }

    public void setChaveacessocteletronica(String chaveacessocteletronica) {
        this.chaveacessocteletronica = chaveacessocteletronica;
    }

    public Character getTipomovimento() {
        return tipomovimento;
    }

    public void setTipomovimento(Character tipomovimento) {
        this.tipomovimento = tipomovimento;
    }

    public String getCsticms() {
        return csticms;
    }

    public void setCsticms(String csticms) {
        this.csticms = csticms;
    }

    public String getCodmunicipioorigem() {
        return codmunicipioorigem;
    }

    public void setCodmunicipioorigem(String codmunicipioorigem) {
        this.codmunicipioorigem = codmunicipioorigem;
    }

    public String getCodmunicipiodestino() {
        return codmunicipiodestino;
    }

    public void setCodmunicipiodestino(String codmunicipiodestino) {
        this.codmunicipiodestino = codmunicipiodestino;
    }

    public Date getDataemissao() {
        return dataemissao;
    }

    public void setDataemissao(Date dataemissao) {
        this.dataemissao = dataemissao;
    }

    public String getCstpis() {
        return cstpis;
    }

    public void setCstpis(String cstpis) {
        this.cstpis = cstpis;
    }

    public BigDecimal getBasepis() {
        return basepis;
    }

    public void setBasepis(BigDecimal basepis) {
        this.basepis = basepis;
    }

    public BigDecimal getValorpis() {
        return valorpis;
    }

    public void setValorpis(BigDecimal valorpis) {
        this.valorpis = valorpis;
    }

    public String getCstcofins() {
        return cstcofins;
    }

    public void setCstcofins(String cstcofins) {
        this.cstcofins = cstcofins;
    }

    public BigDecimal getBasecofins() {
        return basecofins;
    }

    public void setBasecofins(BigDecimal basecofins) {
        this.basecofins = basecofins;
    }

    public BigDecimal getValorcofins() {
        return valorcofins;
    }

    public void setValorcofins(BigDecimal valorcofins) {
        this.valorcofins = valorcofins;
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

    public Documento getCoddocumento() {
        return coddocumento;
    }

    public void setCoddocumento(Documento coddocumento) {
        this.coddocumento = coddocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coddocumentotransporte != null ? coddocumentotransporte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documentotransporte)) {
            return false;
        }
        Documentotransporte other = (Documentotransporte) object;
        if ((this.coddocumentotransporte == null && other.coddocumentotransporte != null) || (this.coddocumentotransporte != null && !this.coddocumentotransporte.equals(other.coddocumentotransporte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Documentotransporte[ coddocumentotransporte=" + coddocumentotransporte + " ]";
    }
    
}
