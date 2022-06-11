/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
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
@Table(name = "MDFELETRONICOEVENTO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mdfeletronicoevento.findAll", query = "SELECT m FROM Mdfeletronicoevento m")
    , @NamedQuery(name = "Mdfeletronicoevento.findByCodmdfeletronicoevento", query = "SELECT m FROM Mdfeletronicoevento m WHERE m.codmdfeletronicoevento = :codmdfeletronicoevento")
    , @NamedQuery(name = "Mdfeletronicoevento.findByData", query = "SELECT m FROM Mdfeletronicoevento m WHERE m.data = :data")
    , @NamedQuery(name = "Mdfeletronicoevento.findByCodigoretorno", query = "SELECT m FROM Mdfeletronicoevento m WHERE m.codigoretorno = :codigoretorno")
    , @NamedQuery(name = "Mdfeletronicoevento.findByDescricaoretorno", query = "SELECT m FROM Mdfeletronicoevento m WHERE m.descricaoretorno = :descricaoretorno")
    , @NamedQuery(name = "Mdfeletronicoevento.findByNumeroprotocolo", query = "SELECT m FROM Mdfeletronicoevento m WHERE m.numeroprotocolo = :numeroprotocolo")
    , @NamedQuery(name = "Mdfeletronicoevento.findByDigestvalue", query = "SELECT m FROM Mdfeletronicoevento m WHERE m.digestvalue = :digestvalue")
    , @NamedQuery(name = "Mdfeletronicoevento.findByDatahorarecebimento", query = "SELECT m FROM Mdfeletronicoevento m WHERE m.datahorarecebimento = :datahorarecebimento")
    , @NamedQuery(name = "Mdfeletronicoevento.findByNumseqevento", query = "SELECT m FROM Mdfeletronicoevento m WHERE m.numseqevento = :numseqevento")
    , @NamedQuery(name = "Mdfeletronicoevento.findByStatus", query = "SELECT m FROM Mdfeletronicoevento m WHERE m.status = :status")})
public class Mdfeletronicoevento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODMDFELETRONICOEVENTO")
    private Integer codmdfeletronicoevento;
    @Basic(optional = false)
    @Column(name = "DATA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Lob
    @Column(name = "XMLSIGN")
    private String xmlsign;
    @Lob
    @Column(name = "XMLRET")
    private String xmlret;
    @Column(name = "CODIGORETORNO")
    private String codigoretorno;
    @Column(name = "DESCRICAORETORNO")
    private String descricaoretorno;
    @Column(name = "NUMEROPROTOCOLO")
    private String numeroprotocolo;
    @Column(name = "DIGESTVALUE")
    private String digestvalue;
    @Column(name = "DATAHORARECEBIMENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datahorarecebimento;
    @Basic(optional = false)
    @Column(name = "NUMSEQEVENTO")
    private short numseqevento;
    @Column(name = "STATUS")
    private String status;
    @JoinColumn(name = "CODMDFELETRONICO", referencedColumnName = "CODMDFELETRONICO")
    @ManyToOne(optional = false)
    private Mdfeletronico codmdfeletronico;
    @JoinColumn(name = "CODMDFELETRONICOTIPOEVENTO", referencedColumnName = "CODMDFELETRONICOTIPOEVENTO")
    @ManyToOne(optional = false)
    private Mdfeletronicotipoevento codmdfeletronicotipoevento;

    public Mdfeletronicoevento() {
    }

    public Mdfeletronicoevento(Integer codmdfeletronicoevento) {
        this.codmdfeletronicoevento = codmdfeletronicoevento;
    }

    public Mdfeletronicoevento(Integer codmdfeletronicoevento, Date data, short numseqevento) {
        this.codmdfeletronicoevento = codmdfeletronicoevento;
        this.data = data;
        this.numseqevento = numseqevento;
    }

    public Integer getCodmdfeletronicoevento() {
        return codmdfeletronicoevento;
    }

    public void setCodmdfeletronicoevento(Integer codmdfeletronicoevento) {
        this.codmdfeletronicoevento = codmdfeletronicoevento;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getXmlsign() {
        return xmlsign;
    }

    public void setXmlsign(String xmlsign) {
        this.xmlsign = xmlsign;
    }

    public String getXmlret() {
        return xmlret;
    }

    public void setXmlret(String xmlret) {
        this.xmlret = xmlret;
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

    public String getNumeroprotocolo() {
        return numeroprotocolo;
    }

    public void setNumeroprotocolo(String numeroprotocolo) {
        this.numeroprotocolo = numeroprotocolo;
    }

    public String getDigestvalue() {
        return digestvalue;
    }

    public void setDigestvalue(String digestvalue) {
        this.digestvalue = digestvalue;
    }

    public Date getDatahorarecebimento() {
        return datahorarecebimento;
    }

    public void setDatahorarecebimento(Date datahorarecebimento) {
        this.datahorarecebimento = datahorarecebimento;
    }

    public short getNumseqevento() {
        return numseqevento;
    }

    public void setNumseqevento(short numseqevento) {
        this.numseqevento = numseqevento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Mdfeletronico getCodmdfeletronico() {
        return codmdfeletronico;
    }

    public void setCodmdfeletronico(Mdfeletronico codmdfeletronico) {
        this.codmdfeletronico = codmdfeletronico;
    }

    public Mdfeletronicotipoevento getCodmdfeletronicotipoevento() {
        return codmdfeletronicotipoevento;
    }

    public void setCodmdfeletronicotipoevento(Mdfeletronicotipoevento codmdfeletronicotipoevento) {
        this.codmdfeletronicotipoevento = codmdfeletronicotipoevento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codmdfeletronicoevento != null ? codmdfeletronicoevento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mdfeletronicoevento)) {
            return false;
        }
        Mdfeletronicoevento other = (Mdfeletronicoevento) object;
        if ((this.codmdfeletronicoevento == null && other.codmdfeletronicoevento != null) || (this.codmdfeletronicoevento != null && !this.codmdfeletronicoevento.equals(other.codmdfeletronicoevento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Mdfeletronicoevento[ codmdfeletronicoevento=" + codmdfeletronicoevento + " ]";
    }
    
}
