/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
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
@Table(name = "NFCELETRONICA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nfceletronica.findAll", query = "SELECT n FROM Nfceletronica n")
    , @NamedQuery(name = "Nfceletronica.findByCodnfceletronica", query = "SELECT n FROM Nfceletronica n WHERE n.codnfceletronica = :codnfceletronica")
    , @NamedQuery(name = "Nfceletronica.findByChaveacessonfceletronica", query = "SELECT n FROM Nfceletronica n WHERE n.chaveacessonfceletronica = :chaveacessonfceletronica")
    , @NamedQuery(name = "Nfceletronica.findByStatusnfceletronica", query = "SELECT n FROM Nfceletronica n WHERE n.statusnfceletronica = :statusnfceletronica")
    , @NamedQuery(name = "Nfceletronica.findByDescricaoretornonfceletronica", query = "SELECT n FROM Nfceletronica n WHERE n.descricaoretornonfceletronica = :descricaoretornonfceletronica")
    , @NamedQuery(name = "Nfceletronica.findByNumeroprotocolonfceletronica", query = "SELECT n FROM Nfceletronica n WHERE n.numeroprotocolonfceletronica = :numeroprotocolonfceletronica")
    , @NamedQuery(name = "Nfceletronica.findByNumerorecibonfceletronica", query = "SELECT n FROM Nfceletronica n WHERE n.numerorecibonfceletronica = :numerorecibonfceletronica")
    , @NamedQuery(name = "Nfceletronica.findByDatahorarecebimento", query = "SELECT n FROM Nfceletronica n WHERE n.datahorarecebimento = :datahorarecebimento")
    , @NamedQuery(name = "Nfceletronica.findByDatahoraemissao", query = "SELECT n FROM Nfceletronica n WHERE n.datahoraemissao = :datahoraemissao")
    , @NamedQuery(name = "Nfceletronica.findByCodigoretornonfceletronica", query = "SELECT n FROM Nfceletronica n WHERE n.codigoretornonfceletronica = :codigoretornonfceletronica")
    , @NamedQuery(name = "Nfceletronica.findByJustificativa", query = "SELECT n FROM Nfceletronica n WHERE n.justificativa = :justificativa")
    , @NamedQuery(name = "Nfceletronica.findByAmbiente", query = "SELECT n FROM Nfceletronica n WHERE n.ambiente = :ambiente")
    , @NamedQuery(name = "Nfceletronica.findByIndicadorformapagto", query = "SELECT n FROM Nfceletronica n WHERE n.indicadorformapagto = :indicadorformapagto")
    , @NamedQuery(name = "Nfceletronica.findByIndicadorfrete", query = "SELECT n FROM Nfceletronica n WHERE n.indicadorfrete = :indicadorfrete")
    , @NamedQuery(name = "Nfceletronica.findByGuid", query = "SELECT n FROM Nfceletronica n WHERE n.guid = :guid")
    , @NamedQuery(name = "Nfceletronica.findByDigestvalue", query = "SELECT n FROM Nfceletronica n WHERE n.digestvalue = :digestvalue")
    , @NamedQuery(name = "Nfceletronica.findByFormatodanfe", query = "SELECT n FROM Nfceletronica n WHERE n.formatodanfe = :formatodanfe")
    , @NamedQuery(name = "Nfceletronica.findByTipoemissao", query = "SELECT n FROM Nfceletronica n WHERE n.tipoemissao = :tipoemissao")
    , @NamedQuery(name = "Nfceletronica.findByDigitoverificadorchave", query = "SELECT n FROM Nfceletronica n WHERE n.digitoverificadorchave = :digitoverificadorchave")
    , @NamedQuery(name = "Nfceletronica.findByNumerolote", query = "SELECT n FROM Nfceletronica n WHERE n.numerolote = :numerolote")
    , @NamedQuery(name = "Nfceletronica.findBySerie", query = "SELECT n FROM Nfceletronica n WHERE n.serie = :serie")
    , @NamedQuery(name = "Nfceletronica.findByNumeroserie", query = "SELECT n FROM Nfceletronica n WHERE n.numeroserie = :numeroserie")
    , @NamedQuery(name = "Nfceletronica.findByValornota", query = "SELECT n FROM Nfceletronica n WHERE n.valornota = :valornota")
    , @NamedQuery(name = "Nfceletronica.findByNumeroprotocolocancelamento", query = "SELECT n FROM Nfceletronica n WHERE n.numeroprotocolocancelamento = :numeroprotocolocancelamento")
    , @NamedQuery(name = "Nfceletronica.findByDatahoracancelamento", query = "SELECT n FROM Nfceletronica n WHERE n.datahoracancelamento = :datahoracancelamento")
    , @NamedQuery(name = "Nfceletronica.findByDatahoraentradacontingencia", query = "SELECT n FROM Nfceletronica n WHERE n.datahoraentradacontingencia = :datahoraentradacontingencia")
    , @NamedQuery(name = "Nfceletronica.findByDatahoraemissaoepec", query = "SELECT n FROM Nfceletronica n WHERE n.datahoraemissaoepec = :datahoraemissaoepec")
    , @NamedQuery(name = "Nfceletronica.findByDatahorarecebimentoepec", query = "SELECT n FROM Nfceletronica n WHERE n.datahorarecebimentoepec = :datahorarecebimentoepec")
    , @NamedQuery(name = "Nfceletronica.findByNumeroprotocoloepec", query = "SELECT n FROM Nfceletronica n WHERE n.numeroprotocoloepec = :numeroprotocoloepec")
    , @NamedQuery(name = "Nfceletronica.findByCodempresa", query = "SELECT n FROM Nfceletronica n WHERE n.codempresa = :codempresa")
    , @NamedQuery(name = "Nfceletronica.findByCodigonf", query = "SELECT n FROM Nfceletronica n WHERE n.codigonf = :codigonf")
    , @NamedQuery(name = "Nfceletronica.findByCodigoestadoemissor", query = "SELECT n FROM Nfceletronica n WHERE n.codigoestadoemissor = :codigoestadoemissor")
    , @NamedQuery(name = "Nfceletronica.findByIndpresenca", query = "SELECT n FROM Nfceletronica n WHERE n.indpresenca = :indpresenca")
    , @NamedQuery(name = "Nfceletronica.findByFlagtrataserviconfce", query = "SELECT n FROM Nfceletronica n WHERE n.flagtrataserviconfce = :flagtrataserviconfce")})
public class Nfceletronica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODNFCELETRONICA")
    private String codnfceletronica;
    @Column(name = "CHAVEACESSONFCELETRONICA")
    private String chaveacessonfceletronica;
    @Column(name = "STATUSNFCELETRONICA")
    private String statusnfceletronica;
    @Column(name = "DESCRICAORETORNONFCELETRONICA")
    private String descricaoretornonfceletronica;
    @Column(name = "NUMEROPROTOCOLONFCELETRONICA")
    private String numeroprotocolonfceletronica;
    @Column(name = "NUMERORECIBONFCELETRONICA")
    private String numerorecibonfceletronica;
    @Column(name = "DATAHORARECEBIMENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datahorarecebimento;
    @Column(name = "DATAHORAEMISSAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datahoraemissao;
    @Column(name = "CODIGORETORNONFCELETRONICA")
    private String codigoretornonfceletronica;
    @Column(name = "JUSTIFICATIVA")
    private String justificativa;
    @Lob
    @Column(name = "XMLNFCELETRONICA")
    private String xmlnfceletronica;
    @Lob
    @Column(name = "XMLNFCELETRONICARET")
    private String xmlnfceletronicaret;
    @Lob
    @Column(name = "XMLNFCELETRONICACANCELAMENTORET")
    private String xmlnfceletronicacancelamentoret;
    @Lob
    @Column(name = "XMLNFCELETRONICASIGN")
    private String xmlnfceletronicasign;
    @Lob
    @Column(name = "XMLNFCELETRONICAAUT")
    private String xmlnfceletronicaaut;
    @Column(name = "AMBIENTE")
    private Character ambiente;
    @Column(name = "INDICADORFORMAPAGTO")
    private Character indicadorformapagto;
    @Column(name = "INDICADORFRETE")
    private Character indicadorfrete;
    @Column(name = "GUID")
    private String guid;
    @Column(name = "DIGESTVALUE")
    private String digestvalue;
    @Column(name = "FORMATODANFE")
    private Character formatodanfe;
    @Column(name = "TIPOEMISSAO")
    private Character tipoemissao;
    @Column(name = "DIGITOVERIFICADORCHAVE")
    private Character digitoverificadorchave;
    @Column(name = "NUMEROLOTE")
    private Short numerolote;
    @Column(name = "SERIE")
    private Short serie;
    @Column(name = "NUMEROSERIE")
    private Integer numeroserie;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALORNOTA")
    private BigDecimal valornota;
    @Column(name = "NUMEROPROTOCOLOCANCELAMENTO")
    private String numeroprotocolocancelamento;
    @Column(name = "DATAHORACANCELAMENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datahoracancelamento;
    @Column(name = "DATAHORAENTRADACONTINGENCIA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datahoraentradacontingencia;
    @Lob
    @Column(name = "XMLDESTINATARIONFCE")
    private String xmldestinatarionfce;
    @Lob
    @Column(name = "XMLDESTINATARIOCANC")
    private String xmldestinatariocanc;
    @Lob
    @Column(name = "XMLNFCELETRONICAEPEC")
    private String xmlnfceletronicaepec;
    @Lob
    @Column(name = "XMLNFCELETRONICAEPECRET")
    private String xmlnfceletronicaepecret;
    @Column(name = "DATAHORAEMISSAOEPEC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datahoraemissaoepec;
    @Column(name = "DATAHORARECEBIMENTOEPEC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datahorarecebimentoepec;
    @Column(name = "NUMEROPROTOCOLOEPEC")
    private String numeroprotocoloepec;
    @Column(name = "CODEMPRESA")
    private Integer codempresa;
    @Column(name = "CODIGONF")
    private String codigonf;
    @Column(name = "CODIGOESTADOEMISSOR")
    private String codigoestadoemissor;
    @Lob
    @Column(name = "XMLNFCELETRONICAEDITADO")
    private String xmlnfceletronicaeditado;
    @Column(name = "INDPRESENCA")
    private Character indpresenca;
    @Column(name = "FLAGTRATASERVICONFCE")
    private Character flagtrataserviconfce;
    @OneToMany(mappedBy = "codnfceletronica")
    private Collection<Nfceletronicapafecf> nfceletronicapafecfCollection;
    @JoinColumn(name = "CODMOVENDA", referencedColumnName = "CODMOVENDA")
    @ManyToOne
    private Movenda codmovenda;

    public Nfceletronica() {
    }

    public Nfceletronica(String codnfceletronica) {
        this.codnfceletronica = codnfceletronica;
    }

    public String getCodnfceletronica() {
        return codnfceletronica;
    }

    public void setCodnfceletronica(String codnfceletronica) {
        this.codnfceletronica = codnfceletronica;
    }

    public String getChaveacessonfceletronica() {
        return chaveacessonfceletronica;
    }

    public void setChaveacessonfceletronica(String chaveacessonfceletronica) {
        this.chaveacessonfceletronica = chaveacessonfceletronica;
    }

    public String getStatusnfceletronica() {
        return statusnfceletronica;
    }

    public void setStatusnfceletronica(String statusnfceletronica) {
        this.statusnfceletronica = statusnfceletronica;
    }

    public String getDescricaoretornonfceletronica() {
        return descricaoretornonfceletronica;
    }

    public void setDescricaoretornonfceletronica(String descricaoretornonfceletronica) {
        this.descricaoretornonfceletronica = descricaoretornonfceletronica;
    }

    public String getNumeroprotocolonfceletronica() {
        return numeroprotocolonfceletronica;
    }

    public void setNumeroprotocolonfceletronica(String numeroprotocolonfceletronica) {
        this.numeroprotocolonfceletronica = numeroprotocolonfceletronica;
    }

    public String getNumerorecibonfceletronica() {
        return numerorecibonfceletronica;
    }

    public void setNumerorecibonfceletronica(String numerorecibonfceletronica) {
        this.numerorecibonfceletronica = numerorecibonfceletronica;
    }

    public Date getDatahorarecebimento() {
        return datahorarecebimento;
    }

    public void setDatahorarecebimento(Date datahorarecebimento) {
        this.datahorarecebimento = datahorarecebimento;
    }

    public Date getDatahoraemissao() {
        return datahoraemissao;
    }

    public void setDatahoraemissao(Date datahoraemissao) {
        this.datahoraemissao = datahoraemissao;
    }

    public String getCodigoretornonfceletronica() {
        return codigoretornonfceletronica;
    }

    public void setCodigoretornonfceletronica(String codigoretornonfceletronica) {
        this.codigoretornonfceletronica = codigoretornonfceletronica;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public String getXmlnfceletronica() {
        return xmlnfceletronica;
    }

    public void setXmlnfceletronica(String xmlnfceletronica) {
        this.xmlnfceletronica = xmlnfceletronica;
    }

    public String getXmlnfceletronicaret() {
        return xmlnfceletronicaret;
    }

    public void setXmlnfceletronicaret(String xmlnfceletronicaret) {
        this.xmlnfceletronicaret = xmlnfceletronicaret;
    }

    public String getXmlnfceletronicacancelamentoret() {
        return xmlnfceletronicacancelamentoret;
    }

    public void setXmlnfceletronicacancelamentoret(String xmlnfceletronicacancelamentoret) {
        this.xmlnfceletronicacancelamentoret = xmlnfceletronicacancelamentoret;
    }

    public String getXmlnfceletronicasign() {
        return xmlnfceletronicasign;
    }

    public void setXmlnfceletronicasign(String xmlnfceletronicasign) {
        this.xmlnfceletronicasign = xmlnfceletronicasign;
    }

    public String getXmlnfceletronicaaut() {
        return xmlnfceletronicaaut;
    }

    public void setXmlnfceletronicaaut(String xmlnfceletronicaaut) {
        this.xmlnfceletronicaaut = xmlnfceletronicaaut;
    }

    public Character getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(Character ambiente) {
        this.ambiente = ambiente;
    }

    public Character getIndicadorformapagto() {
        return indicadorformapagto;
    }

    public void setIndicadorformapagto(Character indicadorformapagto) {
        this.indicadorformapagto = indicadorformapagto;
    }

    public Character getIndicadorfrete() {
        return indicadorfrete;
    }

    public void setIndicadorfrete(Character indicadorfrete) {
        this.indicadorfrete = indicadorfrete;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getDigestvalue() {
        return digestvalue;
    }

    public void setDigestvalue(String digestvalue) {
        this.digestvalue = digestvalue;
    }

    public Character getFormatodanfe() {
        return formatodanfe;
    }

    public void setFormatodanfe(Character formatodanfe) {
        this.formatodanfe = formatodanfe;
    }

    public Character getTipoemissao() {
        return tipoemissao;
    }

    public void setTipoemissao(Character tipoemissao) {
        this.tipoemissao = tipoemissao;
    }

    public Character getDigitoverificadorchave() {
        return digitoverificadorchave;
    }

    public void setDigitoverificadorchave(Character digitoverificadorchave) {
        this.digitoverificadorchave = digitoverificadorchave;
    }

    public Short getNumerolote() {
        return numerolote;
    }

    public void setNumerolote(Short numerolote) {
        this.numerolote = numerolote;
    }

    public Short getSerie() {
        return serie;
    }

    public void setSerie(Short serie) {
        this.serie = serie;
    }

    public Integer getNumeroserie() {
        return numeroserie;
    }

    public void setNumeroserie(Integer numeroserie) {
        this.numeroserie = numeroserie;
    }

    public BigDecimal getValornota() {
        return valornota;
    }

    public void setValornota(BigDecimal valornota) {
        this.valornota = valornota;
    }

    public String getNumeroprotocolocancelamento() {
        return numeroprotocolocancelamento;
    }

    public void setNumeroprotocolocancelamento(String numeroprotocolocancelamento) {
        this.numeroprotocolocancelamento = numeroprotocolocancelamento;
    }

    public Date getDatahoracancelamento() {
        return datahoracancelamento;
    }

    public void setDatahoracancelamento(Date datahoracancelamento) {
        this.datahoracancelamento = datahoracancelamento;
    }

    public Date getDatahoraentradacontingencia() {
        return datahoraentradacontingencia;
    }

    public void setDatahoraentradacontingencia(Date datahoraentradacontingencia) {
        this.datahoraentradacontingencia = datahoraentradacontingencia;
    }

    public String getXmldestinatarionfce() {
        return xmldestinatarionfce;
    }

    public void setXmldestinatarionfce(String xmldestinatarionfce) {
        this.xmldestinatarionfce = xmldestinatarionfce;
    }

    public String getXmldestinatariocanc() {
        return xmldestinatariocanc;
    }

    public void setXmldestinatariocanc(String xmldestinatariocanc) {
        this.xmldestinatariocanc = xmldestinatariocanc;
    }

    public String getXmlnfceletronicaepec() {
        return xmlnfceletronicaepec;
    }

    public void setXmlnfceletronicaepec(String xmlnfceletronicaepec) {
        this.xmlnfceletronicaepec = xmlnfceletronicaepec;
    }

    public String getXmlnfceletronicaepecret() {
        return xmlnfceletronicaepecret;
    }

    public void setXmlnfceletronicaepecret(String xmlnfceletronicaepecret) {
        this.xmlnfceletronicaepecret = xmlnfceletronicaepecret;
    }

    public Date getDatahoraemissaoepec() {
        return datahoraemissaoepec;
    }

    public void setDatahoraemissaoepec(Date datahoraemissaoepec) {
        this.datahoraemissaoepec = datahoraemissaoepec;
    }

    public Date getDatahorarecebimentoepec() {
        return datahorarecebimentoepec;
    }

    public void setDatahorarecebimentoepec(Date datahorarecebimentoepec) {
        this.datahorarecebimentoepec = datahorarecebimentoepec;
    }

    public String getNumeroprotocoloepec() {
        return numeroprotocoloepec;
    }

    public void setNumeroprotocoloepec(String numeroprotocoloepec) {
        this.numeroprotocoloepec = numeroprotocoloepec;
    }

    public Integer getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Integer codempresa) {
        this.codempresa = codempresa;
    }

    public String getCodigonf() {
        return codigonf;
    }

    public void setCodigonf(String codigonf) {
        this.codigonf = codigonf;
    }

    public String getCodigoestadoemissor() {
        return codigoestadoemissor;
    }

    public void setCodigoestadoemissor(String codigoestadoemissor) {
        this.codigoestadoemissor = codigoestadoemissor;
    }

    public String getXmlnfceletronicaeditado() {
        return xmlnfceletronicaeditado;
    }

    public void setXmlnfceletronicaeditado(String xmlnfceletronicaeditado) {
        this.xmlnfceletronicaeditado = xmlnfceletronicaeditado;
    }

    public Character getIndpresenca() {
        return indpresenca;
    }

    public void setIndpresenca(Character indpresenca) {
        this.indpresenca = indpresenca;
    }

    public Character getFlagtrataserviconfce() {
        return flagtrataserviconfce;
    }

    public void setFlagtrataserviconfce(Character flagtrataserviconfce) {
        this.flagtrataserviconfce = flagtrataserviconfce;
    }

    @XmlTransient
    public Collection<Nfceletronicapafecf> getNfceletronicapafecfCollection() {
        return nfceletronicapafecfCollection;
    }

    public void setNfceletronicapafecfCollection(Collection<Nfceletronicapafecf> nfceletronicapafecfCollection) {
        this.nfceletronicapafecfCollection = nfceletronicapafecfCollection;
    }

    public Movenda getCodmovenda() {
        return codmovenda;
    }

    public void setCodmovenda(Movenda codmovenda) {
        this.codmovenda = codmovenda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codnfceletronica != null ? codnfceletronica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nfceletronica)) {
            return false;
        }
        Nfceletronica other = (Nfceletronica) object;
        if ((this.codnfceletronica == null && other.codnfceletronica != null) || (this.codnfceletronica != null && !this.codnfceletronica.equals(other.codnfceletronica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Nfceletronica[ codnfceletronica=" + codnfceletronica + " ]";
    }
    
}
