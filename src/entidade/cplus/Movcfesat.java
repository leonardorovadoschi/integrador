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
import javax.persistence.Lob;
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
@Table(name = "MOVCFESAT", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movcfesat.findAll", query = "SELECT m FROM Movcfesat m")
    , @NamedQuery(name = "Movcfesat.findByCodmovcfesat", query = "SELECT m FROM Movcfesat m WHERE m.codmovcfesat = :codmovcfesat")
    , @NamedQuery(name = "Movcfesat.findByGuid", query = "SELECT m FROM Movcfesat m WHERE m.guid = :guid")
    , @NamedQuery(name = "Movcfesat.findByChaveacessocfeletronico", query = "SELECT m FROM Movcfesat m WHERE m.chaveacessocfeletronico = :chaveacessocfeletronico")
    , @NamedQuery(name = "Movcfesat.findByDvchave", query = "SELECT m FROM Movcfesat m WHERE m.dvchave = :dvchave")
    , @NamedQuery(name = "Movcfesat.findByVersaoschema", query = "SELECT m FROM Movcfesat m WHERE m.versaoschema = :versaoschema")
    , @NamedQuery(name = "Movcfesat.findByVersaosb", query = "SELECT m FROM Movcfesat m WHERE m.versaosb = :versaosb")
    , @NamedQuery(name = "Movcfesat.findByNf", query = "SELECT m FROM Movcfesat m WHERE m.nf = :nf")
    , @NamedQuery(name = "Movcfesat.findByNseriesat", query = "SELECT m FROM Movcfesat m WHERE m.nseriesat = :nseriesat")
    , @NamedQuery(name = "Movcfesat.findByCfe", query = "SELECT m FROM Movcfesat m WHERE m.cfe = :cfe")
    , @NamedQuery(name = "Movcfesat.findByDatahoraemissao", query = "SELECT m FROM Movcfesat m WHERE m.datahoraemissao = :datahoraemissao")
    , @NamedQuery(name = "Movcfesat.findByNumerocaixa", query = "SELECT m FROM Movcfesat m WHERE m.numerocaixa = :numerocaixa")
    , @NamedQuery(name = "Movcfesat.findByCodigoretorno", query = "SELECT m FROM Movcfesat m WHERE m.codigoretorno = :codigoretorno")
    , @NamedQuery(name = "Movcfesat.findByDescricaoretorno", query = "SELECT m FROM Movcfesat m WHERE m.descricaoretorno = :descricaoretorno")
    , @NamedQuery(name = "Movcfesat.findByDigestvalue", query = "SELECT m FROM Movcfesat m WHERE m.digestvalue = :digestvalue")
    , @NamedQuery(name = "Movcfesat.findByStatuscfe", query = "SELECT m FROM Movcfesat m WHERE m.statuscfe = :statuscfe")
    , @NamedQuery(name = "Movcfesat.findByValorcfe", query = "SELECT m FROM Movcfesat m WHERE m.valorcfe = :valorcfe")
    , @NamedQuery(name = "Movcfesat.findByDatahoracancelamento", query = "SELECT m FROM Movcfesat m WHERE m.datahoracancelamento = :datahoracancelamento")
    , @NamedQuery(name = "Movcfesat.findByNumerosessao", query = "SELECT m FROM Movcfesat m WHERE m.numerosessao = :numerosessao")
    , @NamedQuery(name = "Movcfesat.findByNumerosessaocanc", query = "SELECT m FROM Movcfesat m WHERE m.numerosessaocanc = :numerosessaocanc")
    , @NamedQuery(name = "Movcfesat.findByQrcodesign", query = "SELECT m FROM Movcfesat m WHERE m.qrcodesign = :qrcodesign")
    , @NamedQuery(name = "Movcfesat.findByQrcodesigncanc", query = "SELECT m FROM Movcfesat m WHERE m.qrcodesigncanc = :qrcodesigncanc")
    , @NamedQuery(name = "Movcfesat.findByAmbiente", query = "SELECT m FROM Movcfesat m WHERE m.ambiente = :ambiente")
    , @NamedQuery(name = "Movcfesat.findByCnpjcpfdestinatario", query = "SELECT m FROM Movcfesat m WHERE m.cnpjcpfdestinatario = :cnpjcpfdestinatario")
    , @NamedQuery(name = "Movcfesat.findByObsfisco", query = "SELECT m FROM Movcfesat m WHERE m.obsfisco = :obsfisco")
    , @NamedQuery(name = "Movcfesat.findByObsfiscocanc", query = "SELECT m FROM Movcfesat m WHERE m.obsfiscocanc = :obsfiscocanc")
    , @NamedQuery(name = "Movcfesat.findByCodempresa", query = "SELECT m FROM Movcfesat m WHERE m.codempresa = :codempresa")
    , @NamedQuery(name = "Movcfesat.findByMensagemsefaz", query = "SELECT m FROM Movcfesat m WHERE m.mensagemsefaz = :mensagemsefaz")})
public class Movcfesat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODMOVCFESAT")
    private String codmovcfesat;
    @Lob
    @Column(name = "XMLCFELETRONICO")
    private String xmlcfeletronico;
    @Lob
    @Column(name = "XMLCFELETRONICOAUT")
    private String xmlcfeletronicoaut;
    @Lob
    @Column(name = "XMLCFELETRONICOCANCAUT")
    private String xmlcfeletronicocancaut;
    @Column(name = "GUID")
    private String guid;
    @Column(name = "CHAVEACESSOCFELETRONICO")
    private String chaveacessocfeletronico;
    @Column(name = "DVCHAVE")
    private Character dvchave;
    @Column(name = "VERSAOSCHEMA")
    private String versaoschema;
    @Column(name = "VERSAOSB")
    private String versaosb;
    @Column(name = "NF")
    private String nf;
    @Column(name = "NSERIESAT")
    private String nseriesat;
    @Column(name = "CFE")
    private String cfe;
    @Column(name = "DATAHORAEMISSAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datahoraemissao;
    @Column(name = "NUMEROCAIXA")
    private Short numerocaixa;
    @Column(name = "CODIGORETORNO")
    private String codigoretorno;
    @Column(name = "DESCRICAORETORNO")
    private String descricaoretorno;
    @Column(name = "DIGESTVALUE")
    private String digestvalue;
    @Column(name = "STATUSCFE")
    private String statuscfe;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALORCFE")
    private BigDecimal valorcfe;
    @Column(name = "DATAHORACANCELAMENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datahoracancelamento;
    @Column(name = "NUMEROSESSAO")
    private String numerosessao;
    @Column(name = "NUMEROSESSAOCANC")
    private String numerosessaocanc;
    @Column(name = "QRCODESIGN")
    private String qrcodesign;
    @Column(name = "QRCODESIGNCANC")
    private String qrcodesigncanc;
    @Column(name = "AMBIENTE")
    private Character ambiente;
    @Column(name = "CNPJCPFDESTINATARIO")
    private String cnpjcpfdestinatario;
    @Column(name = "OBSFISCO")
    private String obsfisco;
    @Column(name = "OBSFISCOCANC")
    private String obsfiscocanc;
    @Column(name = "CODEMPRESA")
    private Integer codempresa;
    @Column(name = "MENSAGEMSEFAZ")
    private String mensagemsefaz;
    @JoinColumn(name = "CODMOVENDA", referencedColumnName = "CODMOVENDA")
    @ManyToOne
    private Movenda codmovenda;

    public Movcfesat() {
    }

    public Movcfesat(String codmovcfesat) {
        this.codmovcfesat = codmovcfesat;
    }

    public String getCodmovcfesat() {
        return codmovcfesat;
    }

    public void setCodmovcfesat(String codmovcfesat) {
        this.codmovcfesat = codmovcfesat;
    }

    public String getXmlcfeletronico() {
        return xmlcfeletronico;
    }

    public void setXmlcfeletronico(String xmlcfeletronico) {
        this.xmlcfeletronico = xmlcfeletronico;
    }

    public String getXmlcfeletronicoaut() {
        return xmlcfeletronicoaut;
    }

    public void setXmlcfeletronicoaut(String xmlcfeletronicoaut) {
        this.xmlcfeletronicoaut = xmlcfeletronicoaut;
    }

    public String getXmlcfeletronicocancaut() {
        return xmlcfeletronicocancaut;
    }

    public void setXmlcfeletronicocancaut(String xmlcfeletronicocancaut) {
        this.xmlcfeletronicocancaut = xmlcfeletronicocancaut;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getChaveacessocfeletronico() {
        return chaveacessocfeletronico;
    }

    public void setChaveacessocfeletronico(String chaveacessocfeletronico) {
        this.chaveacessocfeletronico = chaveacessocfeletronico;
    }

    public Character getDvchave() {
        return dvchave;
    }

    public void setDvchave(Character dvchave) {
        this.dvchave = dvchave;
    }

    public String getVersaoschema() {
        return versaoschema;
    }

    public void setVersaoschema(String versaoschema) {
        this.versaoschema = versaoschema;
    }

    public String getVersaosb() {
        return versaosb;
    }

    public void setVersaosb(String versaosb) {
        this.versaosb = versaosb;
    }

    public String getNf() {
        return nf;
    }

    public void setNf(String nf) {
        this.nf = nf;
    }

    public String getNseriesat() {
        return nseriesat;
    }

    public void setNseriesat(String nseriesat) {
        this.nseriesat = nseriesat;
    }

    public String getCfe() {
        return cfe;
    }

    public void setCfe(String cfe) {
        this.cfe = cfe;
    }

    public Date getDatahoraemissao() {
        return datahoraemissao;
    }

    public void setDatahoraemissao(Date datahoraemissao) {
        this.datahoraemissao = datahoraemissao;
    }

    public Short getNumerocaixa() {
        return numerocaixa;
    }

    public void setNumerocaixa(Short numerocaixa) {
        this.numerocaixa = numerocaixa;
    }

    public String getCodigoretorno() {
        return codigoretorno;
    }

    public void setCodigoretorno(String codigoretorno) {
        this.codigoretorno = codigoretorno;
    }

    public String getDescricaoretorno() {
        return descricaoretorno;
    }

    public void setDescricaoretorno(String descricaoretorno) {
        this.descricaoretorno = descricaoretorno;
    }

    public String getDigestvalue() {
        return digestvalue;
    }

    public void setDigestvalue(String digestvalue) {
        this.digestvalue = digestvalue;
    }

    public String getStatuscfe() {
        return statuscfe;
    }

    public void setStatuscfe(String statuscfe) {
        this.statuscfe = statuscfe;
    }

    public BigDecimal getValorcfe() {
        return valorcfe;
    }

    public void setValorcfe(BigDecimal valorcfe) {
        this.valorcfe = valorcfe;
    }

    public Date getDatahoracancelamento() {
        return datahoracancelamento;
    }

    public void setDatahoracancelamento(Date datahoracancelamento) {
        this.datahoracancelamento = datahoracancelamento;
    }

    public String getNumerosessao() {
        return numerosessao;
    }

    public void setNumerosessao(String numerosessao) {
        this.numerosessao = numerosessao;
    }

    public String getNumerosessaocanc() {
        return numerosessaocanc;
    }

    public void setNumerosessaocanc(String numerosessaocanc) {
        this.numerosessaocanc = numerosessaocanc;
    }

    public String getQrcodesign() {
        return qrcodesign;
    }

    public void setQrcodesign(String qrcodesign) {
        this.qrcodesign = qrcodesign;
    }

    public String getQrcodesigncanc() {
        return qrcodesigncanc;
    }

    public void setQrcodesigncanc(String qrcodesigncanc) {
        this.qrcodesigncanc = qrcodesigncanc;
    }

    public Character getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(Character ambiente) {
        this.ambiente = ambiente;
    }

    public String getCnpjcpfdestinatario() {
        return cnpjcpfdestinatario;
    }

    public void setCnpjcpfdestinatario(String cnpjcpfdestinatario) {
        this.cnpjcpfdestinatario = cnpjcpfdestinatario;
    }

    public String getObsfisco() {
        return obsfisco;
    }

    public void setObsfisco(String obsfisco) {
        this.obsfisco = obsfisco;
    }

    public String getObsfiscocanc() {
        return obsfiscocanc;
    }

    public void setObsfiscocanc(String obsfiscocanc) {
        this.obsfiscocanc = obsfiscocanc;
    }

    public Integer getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Integer codempresa) {
        this.codempresa = codempresa;
    }

    public String getMensagemsefaz() {
        return mensagemsefaz;
    }

    public void setMensagemsefaz(String mensagemsefaz) {
        this.mensagemsefaz = mensagemsefaz;
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
        hash += (codmovcfesat != null ? codmovcfesat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movcfesat)) {
            return false;
        }
        Movcfesat other = (Movcfesat) object;
        if ((this.codmovcfesat == null && other.codmovcfesat != null) || (this.codmovcfesat != null && !this.codmovcfesat.equals(other.codmovcfesat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Movcfesat[ codmovcfesat=" + codmovcfesat + " ]";
    }
    
}
