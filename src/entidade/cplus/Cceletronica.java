/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "CCELETRONICA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cceletronica.findAll", query = "SELECT c FROM Cceletronica c")
    , @NamedQuery(name = "Cceletronica.findByCodcceletronica", query = "SELECT c FROM Cceletronica c WHERE c.codcceletronica = :codcceletronica")
    , @NamedQuery(name = "Cceletronica.findByCodigoretornocceletronica", query = "SELECT c FROM Cceletronica c WHERE c.codigoretornocceletronica = :codigoretornocceletronica")
    , @NamedQuery(name = "Cceletronica.findByDescricaoretornocceletronica", query = "SELECT c FROM Cceletronica c WHERE c.descricaoretornocceletronica = :descricaoretornocceletronica")
    , @NamedQuery(name = "Cceletronica.findByAmbiente", query = "SELECT c FROM Cceletronica c WHERE c.ambiente = :ambiente")
    , @NamedQuery(name = "Cceletronica.findByDhevento", query = "SELECT c FROM Cceletronica c WHERE c.dhevento = :dhevento")
    , @NamedQuery(name = "Cceletronica.findByNseqevento", query = "SELECT c FROM Cceletronica c WHERE c.nseqevento = :nseqevento")
    , @NamedQuery(name = "Cceletronica.findByCorrecao", query = "SELECT c FROM Cceletronica c WHERE c.correcao = :correcao")
    , @NamedQuery(name = "Cceletronica.findByNumeroprotocolocceletronica", query = "SELECT c FROM Cceletronica c WHERE c.numeroprotocolocceletronica = :numeroprotocolocceletronica")
    , @NamedQuery(name = "Cceletronica.findByTitulo", query = "SELECT c FROM Cceletronica c WHERE c.titulo = :titulo")
    , @NamedQuery(name = "Cceletronica.findByStatuscceletronica", query = "SELECT c FROM Cceletronica c WHERE c.statuscceletronica = :statuscceletronica")
    , @NamedQuery(name = "Cceletronica.findByDigestvalue", query = "SELECT c FROM Cceletronica c WHERE c.digestvalue = :digestvalue")})
public class Cceletronica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCCELETRONICA")
    private String codcceletronica;
    @Column(name = "CODIGORETORNOCCELETRONICA")
    private String codigoretornocceletronica;
    @Column(name = "DESCRICAORETORNOCCELETRONICA")
    private String descricaoretornocceletronica;
    @Lob
    @Column(name = "XMLCCELETRONICA")
    private String xmlcceletronica;
    @Lob
    @Column(name = "XMLDESTINATARIO")
    private String xmldestinatario;
    @Column(name = "AMBIENTE")
    private Character ambiente;
    @Column(name = "DHEVENTO")
    private String dhevento;
    @Column(name = "NSEQEVENTO")
    private Short nseqevento;
    @Column(name = "CORRECAO")
    private String correcao;
    @Column(name = "NUMEROPROTOCOLOCCELETRONICA")
    private String numeroprotocolocceletronica;
    @Column(name = "TITULO")
    private String titulo;
    @Column(name = "STATUSCCELETRONICA")
    private String statuscceletronica;
    @Column(name = "DIGESTVALUE")
    private String digestvalue;
    @Lob
    @Column(name = "XMLCCELETRONICARET")
    private String xmlcceletronicaret;
    @JoinColumn(name = "CODNFELETRONICA", referencedColumnName = "CODNFELETRONICA")
    @ManyToOne(optional = false)
    private Nfeletronica codnfeletronica;

    public Cceletronica() {
    }

    public Cceletronica(String codcceletronica) {
        this.codcceletronica = codcceletronica;
    }

    public String getCodcceletronica() {
        return codcceletronica;
    }

    public void setCodcceletronica(String codcceletronica) {
        this.codcceletronica = codcceletronica;
    }

    public String getCodigoretornocceletronica() {
        return codigoretornocceletronica;
    }

    public void setCodigoretornocceletronica(String codigoretornocceletronica) {
        this.codigoretornocceletronica = codigoretornocceletronica;
    }

    public String getDescricaoretornocceletronica() {
        return descricaoretornocceletronica;
    }

    public void setDescricaoretornocceletronica(String descricaoretornocceletronica) {
        this.descricaoretornocceletronica = descricaoretornocceletronica;
    }

    public String getXmlcceletronica() {
        return xmlcceletronica;
    }

    public void setXmlcceletronica(String xmlcceletronica) {
        this.xmlcceletronica = xmlcceletronica;
    }

    public String getXmldestinatario() {
        return xmldestinatario;
    }

    public void setXmldestinatario(String xmldestinatario) {
        this.xmldestinatario = xmldestinatario;
    }

    public Character getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(Character ambiente) {
        this.ambiente = ambiente;
    }

    public String getDhevento() {
        return dhevento;
    }

    public void setDhevento(String dhevento) {
        this.dhevento = dhevento;
    }

    public Short getNseqevento() {
        return nseqevento;
    }

    public void setNseqevento(Short nseqevento) {
        this.nseqevento = nseqevento;
    }

    public String getCorrecao() {
        return correcao;
    }

    public void setCorrecao(String correcao) {
        this.correcao = correcao;
    }

    public String getNumeroprotocolocceletronica() {
        return numeroprotocolocceletronica;
    }

    public void setNumeroprotocolocceletronica(String numeroprotocolocceletronica) {
        this.numeroprotocolocceletronica = numeroprotocolocceletronica;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getStatuscceletronica() {
        return statuscceletronica;
    }

    public void setStatuscceletronica(String statuscceletronica) {
        this.statuscceletronica = statuscceletronica;
    }

    public String getDigestvalue() {
        return digestvalue;
    }

    public void setDigestvalue(String digestvalue) {
        this.digestvalue = digestvalue;
    }

    public String getXmlcceletronicaret() {
        return xmlcceletronicaret;
    }

    public void setXmlcceletronicaret(String xmlcceletronicaret) {
        this.xmlcceletronicaret = xmlcceletronicaret;
    }

    public Nfeletronica getCodnfeletronica() {
        return codnfeletronica;
    }

    public void setCodnfeletronica(Nfeletronica codnfeletronica) {
        this.codnfeletronica = codnfeletronica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcceletronica != null ? codcceletronica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cceletronica)) {
            return false;
        }
        Cceletronica other = (Cceletronica) object;
        if ((this.codcceletronica == null && other.codcceletronica != null) || (this.codcceletronica != null && !this.codcceletronica.equals(other.codcceletronica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Cceletronica[ codcceletronica=" + codcceletronica + " ]";
    }
    
}
