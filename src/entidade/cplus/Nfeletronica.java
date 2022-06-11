/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
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
@Table(name = "NFELETRONICA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nfeletronica.findAll", query = "SELECT n FROM Nfeletronica n")
    , @NamedQuery(name = "Nfeletronica.findByIdentidadeorigem", query = "SELECT n FROM Nfeletronica n WHERE n.identidadeorigem = :identidadeorigem")
    , @NamedQuery(name = "Nfeletronica.findByNomeentidadeorigem", query = "SELECT n FROM Nfeletronica n WHERE n.nomeentidadeorigem = :nomeentidadeorigem")
    , @NamedQuery(name = "Nfeletronica.findByChaveacessonfeletronica", query = "SELECT n FROM Nfeletronica n WHERE n.chaveacessonfeletronica = :chaveacessonfeletronica")
    , @NamedQuery(name = "Nfeletronica.findByStatusnfeletronica", query = "SELECT n FROM Nfeletronica n WHERE n.statusnfeletronica = :statusnfeletronica")
    , @NamedQuery(name = "Nfeletronica.findByDescricaoretornonfeletronica", query = "SELECT n FROM Nfeletronica n WHERE n.descricaoretornonfeletronica = :descricaoretornonfeletronica")
    , @NamedQuery(name = "Nfeletronica.findByNumeroprotocolonfeletronica", query = "SELECT n FROM Nfeletronica n WHERE n.numeroprotocolonfeletronica = :numeroprotocolonfeletronica")
    , @NamedQuery(name = "Nfeletronica.findByDatahorarecebimento", query = "SELECT n FROM Nfeletronica n WHERE n.datahorarecebimento = :datahorarecebimento")
    , @NamedQuery(name = "Nfeletronica.findByCodigoretornonfeletronica", query = "SELECT n FROM Nfeletronica n WHERE n.codigoretornonfeletronica = :codigoretornonfeletronica")
    , @NamedQuery(name = "Nfeletronica.findByJustificativa", query = "SELECT n FROM Nfeletronica n WHERE n.justificativa = :justificativa")
    , @NamedQuery(name = "Nfeletronica.findByCodnfeletronica", query = "SELECT n FROM Nfeletronica n WHERE n.codnfeletronica = :codnfeletronica")
    , @NamedQuery(name = "Nfeletronica.findByEmail", query = "SELECT n FROM Nfeletronica n WHERE n.email = :email")
    , @NamedQuery(name = "Nfeletronica.findByAmbiente", query = "SELECT n FROM Nfeletronica n WHERE n.ambiente = :ambiente")
    , @NamedQuery(name = "Nfeletronica.findByDigestvalue", query = "SELECT n FROM Nfeletronica n WHERE n.digestvalue = :digestvalue")
    , @NamedQuery(name = "Nfeletronica.findByDataemail", query = "SELECT n FROM Nfeletronica n WHERE n.dataemail = :dataemail")
    , @NamedQuery(name = "Nfeletronica.findByCodigosefaz", query = "SELECT n FROM Nfeletronica n WHERE n.codigosefaz = :codigosefaz")
    , @NamedQuery(name = "Nfeletronica.findByMensagemsefaz", query = "SELECT n FROM Nfeletronica n WHERE n.mensagemsefaz = :mensagemsefaz")})
public class Nfeletronica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "IDENTIDADEORIGEM")
    private String identidadeorigem;
    @Basic(optional = false)
    @Column(name = "NOMEENTIDADEORIGEM")
    private String nomeentidadeorigem;
    @Column(name = "CHAVEACESSONFELETRONICA")
    private String chaveacessonfeletronica;
    @Column(name = "STATUSNFELETRONICA")
    private String statusnfeletronica;
    @Column(name = "DESCRICAORETORNONFELETRONICA")
    private String descricaoretornonfeletronica;
    @Column(name = "NUMEROPROTOCOLONFELETRONICA")
    private String numeroprotocolonfeletronica;
    @Column(name = "DATAHORARECEBIMENTO")
    private String datahorarecebimento;
    @Column(name = "CODIGORETORNONFELETRONICA")
    private String codigoretornonfeletronica;
    @Column(name = "JUSTIFICATIVA")
    private String justificativa;
    @Lob
    @Column(name = "XMLNFELETRONICA")
    private String xmlnfeletronica;
    @Lob
    @Column(name = "XMLNFELETRONICARET")
    private String xmlnfeletronicaret;
    @Lob
    @Column(name = "XMLNFELETRONICACANCELAMENTO")
    private String xmlnfeletronicacancelamento;
    @Lob
    @Column(name = "XMLNFELETRONICACANCELAMENTORET")
    private String xmlnfeletronicacancelamentoret;
    @Id
    @Basic(optional = false)
    @Column(name = "CODNFELETRONICA")
    private String codnfeletronica;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "AMBIENTE")
    private Character ambiente;
    @Column(name = "DIGESTVALUE")
    private String digestvalue;
    @Column(name = "DATAEMAIL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataemail;
    @Lob
    @Column(name = "XMLNFELETRONICASIGN")
    private String xmlnfeletronicasign;
    @Lob
    @Column(name = "XMLNFELETRONICASIGN_ULTIMA")
    private String xmlnfeletronicasignUltima;
    @Lob
    @Column(name = "XMLDESTINATARIONFE")
    private String xmldestinatarionfe;
    @Lob
    @Column(name = "XMLDESTINATARIOCANCELAMENTO")
    private String xmldestinatariocancelamento;
    @Lob
    @Column(name = "EMAILCCDANFE")
    private String emailccdanfe;
    @Column(name = "CODIGOSEFAZ")
    private String codigosefaz;
    @Column(name = "MENSAGEMSEFAZ")
    private String mensagemsefaz;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codnfeletronica")
    private Collection<Cceletronica> cceletronicaCollection;

    public Nfeletronica() {
    }

    public Nfeletronica(String codnfeletronica) {
        this.codnfeletronica = codnfeletronica;
    }

    public Nfeletronica(String codnfeletronica, String identidadeorigem, String nomeentidadeorigem) {
        this.codnfeletronica = codnfeletronica;
        this.identidadeorigem = identidadeorigem;
        this.nomeentidadeorigem = nomeentidadeorigem;
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

    public String getChaveacessonfeletronica() {
        return chaveacessonfeletronica;
    }

    public void setChaveacessonfeletronica(String chaveacessonfeletronica) {
        this.chaveacessonfeletronica = chaveacessonfeletronica;
    }

    public String getStatusnfeletronica() {
        return statusnfeletronica;
    }

    public void setStatusnfeletronica(String statusnfeletronica) {
        this.statusnfeletronica = statusnfeletronica;
    }

    public String getDescricaoretornonfeletronica() {
        return descricaoretornonfeletronica;
    }

    public void setDescricaoretornonfeletronica(String descricaoretornonfeletronica) {
        this.descricaoretornonfeletronica = descricaoretornonfeletronica;
    }

    public String getNumeroprotocolonfeletronica() {
        return numeroprotocolonfeletronica;
    }

    public void setNumeroprotocolonfeletronica(String numeroprotocolonfeletronica) {
        this.numeroprotocolonfeletronica = numeroprotocolonfeletronica;
    }

    public String getDatahorarecebimento() {
        return datahorarecebimento;
    }

    public void setDatahorarecebimento(String datahorarecebimento) {
        this.datahorarecebimento = datahorarecebimento;
    }

    public String getCodigoretornonfeletronica() {
        return codigoretornonfeletronica;
    }

    public void setCodigoretornonfeletronica(String codigoretornonfeletronica) {
        this.codigoretornonfeletronica = codigoretornonfeletronica;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public String getXmlnfeletronica() {
        return xmlnfeletronica;
    }

    public void setXmlnfeletronica(String xmlnfeletronica) {
        this.xmlnfeletronica = xmlnfeletronica;
    }

    public String getXmlnfeletronicaret() {
        return xmlnfeletronicaret;
    }

    public void setXmlnfeletronicaret(String xmlnfeletronicaret) {
        this.xmlnfeletronicaret = xmlnfeletronicaret;
    }

    public String getXmlnfeletronicacancelamento() {
        return xmlnfeletronicacancelamento;
    }

    public void setXmlnfeletronicacancelamento(String xmlnfeletronicacancelamento) {
        this.xmlnfeletronicacancelamento = xmlnfeletronicacancelamento;
    }

    public String getXmlnfeletronicacancelamentoret() {
        return xmlnfeletronicacancelamentoret;
    }

    public void setXmlnfeletronicacancelamentoret(String xmlnfeletronicacancelamentoret) {
        this.xmlnfeletronicacancelamentoret = xmlnfeletronicacancelamentoret;
    }

    public String getCodnfeletronica() {
        return codnfeletronica;
    }

    public void setCodnfeletronica(String codnfeletronica) {
        this.codnfeletronica = codnfeletronica;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Character getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(Character ambiente) {
        this.ambiente = ambiente;
    }

    public String getDigestvalue() {
        return digestvalue;
    }

    public void setDigestvalue(String digestvalue) {
        this.digestvalue = digestvalue;
    }

    public Date getDataemail() {
        return dataemail;
    }

    public void setDataemail(Date dataemail) {
        this.dataemail = dataemail;
    }

    public String getXmlnfeletronicasign() {
        return xmlnfeletronicasign;
    }

    public void setXmlnfeletronicasign(String xmlnfeletronicasign) {
        this.xmlnfeletronicasign = xmlnfeletronicasign;
    }

    public String getXmlnfeletronicasignUltima() {
        return xmlnfeletronicasignUltima;
    }

    public void setXmlnfeletronicasignUltima(String xmlnfeletronicasignUltima) {
        this.xmlnfeletronicasignUltima = xmlnfeletronicasignUltima;
    }

    public String getXmldestinatarionfe() {
        return xmldestinatarionfe;
    }

    public void setXmldestinatarionfe(String xmldestinatarionfe) {
        this.xmldestinatarionfe = xmldestinatarionfe;
    }

    public String getXmldestinatariocancelamento() {
        return xmldestinatariocancelamento;
    }

    public void setXmldestinatariocancelamento(String xmldestinatariocancelamento) {
        this.xmldestinatariocancelamento = xmldestinatariocancelamento;
    }

    public String getEmailccdanfe() {
        return emailccdanfe;
    }

    public void setEmailccdanfe(String emailccdanfe) {
        this.emailccdanfe = emailccdanfe;
    }

    public String getCodigosefaz() {
        return codigosefaz;
    }

    public void setCodigosefaz(String codigosefaz) {
        this.codigosefaz = codigosefaz;
    }

    public String getMensagemsefaz() {
        return mensagemsefaz;
    }

    public void setMensagemsefaz(String mensagemsefaz) {
        this.mensagemsefaz = mensagemsefaz;
    }

    @XmlTransient
    public Collection<Cceletronica> getCceletronicaCollection() {
        return cceletronicaCollection;
    }

    public void setCceletronicaCollection(Collection<Cceletronica> cceletronicaCollection) {
        this.cceletronicaCollection = cceletronicaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codnfeletronica != null ? codnfeletronica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nfeletronica)) {
            return false;
        }
        Nfeletronica other = (Nfeletronica) object;
        if ((this.codnfeletronica == null && other.codnfeletronica != null) || (this.codnfeletronica != null && !this.codnfeletronica.equals(other.codnfeletronica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Nfeletronica[ codnfeletronica=" + codnfeletronica + " ]";
    }
    
}
