/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "NFSELETRONICA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nfseletronica.findAll", query = "SELECT n FROM Nfseletronica n")
    , @NamedQuery(name = "Nfseletronica.findByCodnfseletronica", query = "SELECT n FROM Nfseletronica n WHERE n.codnfseletronica = :codnfseletronica")
    , @NamedQuery(name = "Nfseletronica.findByCodigoverificacao", query = "SELECT n FROM Nfseletronica n WHERE n.codigoverificacao = :codigoverificacao")
    , @NamedQuery(name = "Nfseletronica.findByDataemissaonfse", query = "SELECT n FROM Nfseletronica n WHERE n.dataemissaonfse = :dataemissaonfse")
    , @NamedQuery(name = "Nfseletronica.findByDataemissaorps", query = "SELECT n FROM Nfseletronica n WHERE n.dataemissaorps = :dataemissaorps")
    , @NamedQuery(name = "Nfseletronica.findByHoraemissaorps", query = "SELECT n FROM Nfseletronica n WHERE n.horaemissaorps = :horaemissaorps")
    , @NamedQuery(name = "Nfseletronica.findBySerierps", query = "SELECT n FROM Nfseletronica n WHERE n.serierps = :serierps")
    , @NamedQuery(name = "Nfseletronica.findByNumerorps", query = "SELECT n FROM Nfseletronica n WHERE n.numerorps = :numerorps")
    , @NamedQuery(name = "Nfseletronica.findByNumerolote", query = "SELECT n FROM Nfseletronica n WHERE n.numerolote = :numerolote")
    , @NamedQuery(name = "Nfseletronica.findByNumeronota", query = "SELECT n FROM Nfseletronica n WHERE n.numeronota = :numeronota")
    , @NamedQuery(name = "Nfseletronica.findByStatuslote", query = "SELECT n FROM Nfseletronica n WHERE n.statuslote = :statuslote")
    , @NamedQuery(name = "Nfseletronica.findByStatusnota", query = "SELECT n FROM Nfseletronica n WHERE n.statusnota = :statusnota")
    , @NamedQuery(name = "Nfseletronica.findByIdentificador", query = "SELECT n FROM Nfseletronica n WHERE n.identificador = :identificador")
    , @NamedQuery(name = "Nfseletronica.findByCodmovenda", query = "SELECT n FROM Nfseletronica n WHERE n.codmovenda = :codmovenda")
    , @NamedQuery(name = "Nfseletronica.findByCoddocumento", query = "SELECT n FROM Nfseletronica n WHERE n.coddocumento = :coddocumento")
    , @NamedQuery(name = "Nfseletronica.findByCodempresatipodocumento", query = "SELECT n FROM Nfseletronica n WHERE n.codempresatipodocumento = :codempresatipodocumento")
    , @NamedQuery(name = "Nfseletronica.findByCodempresa", query = "SELECT n FROM Nfseletronica n WHERE n.codempresa = :codempresa")
    , @NamedQuery(name = "Nfseletronica.findByTiporps", query = "SELECT n FROM Nfseletronica n WHERE n.tiporps = :tiporps")
    , @NamedQuery(name = "Nfseletronica.findByGuid", query = "SELECT n FROM Nfseletronica n WHERE n.guid = :guid")
    , @NamedQuery(name = "Nfseletronica.findByAmbiente", query = "SELECT n FROM Nfseletronica n WHERE n.ambiente = :ambiente")
    , @NamedQuery(name = "Nfseletronica.findByChaveacessonfseletronica", query = "SELECT n FROM Nfseletronica n WHERE n.chaveacessonfseletronica = :chaveacessonfseletronica")})
public class Nfseletronica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODNFSELETRONICA")
    private Integer codnfseletronica;
    @Column(name = "CODIGOVERIFICACAO")
    private String codigoverificacao;
    @Column(name = "DATAEMISSAONFSE")
    @Temporal(TemporalType.DATE)
    private Date dataemissaonfse;
    @Column(name = "DATAEMISSAORPS")
    @Temporal(TemporalType.DATE)
    private Date dataemissaorps;
    @Column(name = "HORAEMISSAORPS")
    @Temporal(TemporalType.TIME)
    private Date horaemissaorps;
    @Column(name = "SERIERPS")
    private String serierps;
    @Column(name = "NUMERORPS")
    private BigInteger numerorps;
    @Column(name = "NUMEROLOTE")
    private BigInteger numerolote;
    @Column(name = "NUMERONOTA")
    private BigInteger numeronota;
    @Column(name = "STATUSLOTE")
    private String statuslote;
    @Column(name = "STATUSNOTA")
    private String statusnota;
    @Column(name = "IDENTIFICADOR")
    private String identificador;
    @Lob
    @Column(name = "XMLNOTA")
    private String xmlnota;
    @Lob
    @Column(name = "PDFNOTA")
    private byte[] pdfnota;
    @Column(name = "CODMOVENDA")
    private String codmovenda;
    @Column(name = "CODDOCUMENTO")
    private String coddocumento;
    @Column(name = "CODEMPRESATIPODOCUMENTO")
    private String codempresatipodocumento;
    @Basic(optional = false)
    @Column(name = "CODEMPRESA")
    private int codempresa;
    @Column(name = "TIPORPS")
    private Character tiporps;
    @Lob
    @Column(name = "MENSAGEMRETORNO")
    private String mensagemretorno;
    @Column(name = "GUID")
    private String guid;
    @Column(name = "AMBIENTE")
    private Character ambiente;
    @Column(name = "CHAVEACESSONFSELETRONICA")
    private String chaveacessonfseletronica;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codnfseletronica")
    private Collection<Nfseletronicaerros> nfseletronicaerrosCollection;

    public Nfseletronica() {
    }

    public Nfseletronica(Integer codnfseletronica) {
        this.codnfseletronica = codnfseletronica;
    }

    public Nfseletronica(Integer codnfseletronica, int codempresa) {
        this.codnfseletronica = codnfseletronica;
        this.codempresa = codempresa;
    }

    public Integer getCodnfseletronica() {
        return codnfseletronica;
    }

    public void setCodnfseletronica(Integer codnfseletronica) {
        this.codnfseletronica = codnfseletronica;
    }

    public String getCodigoverificacao() {
        return codigoverificacao;
    }

    public void setCodigoverificacao(String codigoverificacao) {
        this.codigoverificacao = codigoverificacao;
    }

    public Date getDataemissaonfse() {
        return dataemissaonfse;
    }

    public void setDataemissaonfse(Date dataemissaonfse) {
        this.dataemissaonfse = dataemissaonfse;
    }

    public Date getDataemissaorps() {
        return dataemissaorps;
    }

    public void setDataemissaorps(Date dataemissaorps) {
        this.dataemissaorps = dataemissaorps;
    }

    public Date getHoraemissaorps() {
        return horaemissaorps;
    }

    public void setHoraemissaorps(Date horaemissaorps) {
        this.horaemissaorps = horaemissaorps;
    }

    public String getSerierps() {
        return serierps;
    }

    public void setSerierps(String serierps) {
        this.serierps = serierps;
    }

    public BigInteger getNumerorps() {
        return numerorps;
    }

    public void setNumerorps(BigInteger numerorps) {
        this.numerorps = numerorps;
    }

    public BigInteger getNumerolote() {
        return numerolote;
    }

    public void setNumerolote(BigInteger numerolote) {
        this.numerolote = numerolote;
    }

    public BigInteger getNumeronota() {
        return numeronota;
    }

    public void setNumeronota(BigInteger numeronota) {
        this.numeronota = numeronota;
    }

    public String getStatuslote() {
        return statuslote;
    }

    public void setStatuslote(String statuslote) {
        this.statuslote = statuslote;
    }

    public String getStatusnota() {
        return statusnota;
    }

    public void setStatusnota(String statusnota) {
        this.statusnota = statusnota;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getXmlnota() {
        return xmlnota;
    }

    public void setXmlnota(String xmlnota) {
        this.xmlnota = xmlnota;
    }

    public byte[] getPdfnota() {
        return pdfnota;
    }

    public void setPdfnota(byte[] pdfnota) {
        this.pdfnota = pdfnota;
    }

    public String getCodmovenda() {
        return codmovenda;
    }

    public void setCodmovenda(String codmovenda) {
        this.codmovenda = codmovenda;
    }

    public String getCoddocumento() {
        return coddocumento;
    }

    public void setCoddocumento(String coddocumento) {
        this.coddocumento = coddocumento;
    }

    public String getCodempresatipodocumento() {
        return codempresatipodocumento;
    }

    public void setCodempresatipodocumento(String codempresatipodocumento) {
        this.codempresatipodocumento = codempresatipodocumento;
    }

    public int getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(int codempresa) {
        this.codempresa = codempresa;
    }

    public Character getTiporps() {
        return tiporps;
    }

    public void setTiporps(Character tiporps) {
        this.tiporps = tiporps;
    }

    public String getMensagemretorno() {
        return mensagemretorno;
    }

    public void setMensagemretorno(String mensagemretorno) {
        this.mensagemretorno = mensagemretorno;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Character getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(Character ambiente) {
        this.ambiente = ambiente;
    }

    public String getChaveacessonfseletronica() {
        return chaveacessonfseletronica;
    }

    public void setChaveacessonfseletronica(String chaveacessonfseletronica) {
        this.chaveacessonfseletronica = chaveacessonfseletronica;
    }

    @XmlTransient
    public Collection<Nfseletronicaerros> getNfseletronicaerrosCollection() {
        return nfseletronicaerrosCollection;
    }

    public void setNfseletronicaerrosCollection(Collection<Nfseletronicaerros> nfseletronicaerrosCollection) {
        this.nfseletronicaerrosCollection = nfseletronicaerrosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codnfseletronica != null ? codnfseletronica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nfseletronica)) {
            return false;
        }
        Nfseletronica other = (Nfseletronica) object;
        if ((this.codnfseletronica == null && other.codnfseletronica != null) || (this.codnfseletronica != null && !this.codnfseletronica.equals(other.codnfseletronica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Nfseletronica[ codnfseletronica=" + codnfseletronica + " ]";
    }
    
}
