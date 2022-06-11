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
import javax.persistence.Lob;
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
@Table(name = "NFCELETRONICALOTE", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nfceletronicalote.findAll", query = "SELECT n FROM Nfceletronicalote n")
    , @NamedQuery(name = "Nfceletronicalote.findByCodnfceletronicalote", query = "SELECT n FROM Nfceletronicalote n WHERE n.codnfceletronicalote = :codnfceletronicalote")
    , @NamedQuery(name = "Nfceletronicalote.findByNumerolote", query = "SELECT n FROM Nfceletronicalote n WHERE n.numerolote = :numerolote")
    , @NamedQuery(name = "Nfceletronicalote.findByCodempresa", query = "SELECT n FROM Nfceletronicalote n WHERE n.codempresa = :codempresa")
    , @NamedQuery(name = "Nfceletronicalote.findByNumerorecibo", query = "SELECT n FROM Nfceletronicalote n WHERE n.numerorecibo = :numerorecibo")
    , @NamedQuery(name = "Nfceletronicalote.findByFlagstatus", query = "SELECT n FROM Nfceletronicalote n WHERE n.flagstatus = :flagstatus")
    , @NamedQuery(name = "Nfceletronicalote.findByDescricaoretornolote", query = "SELECT n FROM Nfceletronicalote n WHERE n.descricaoretornolote = :descricaoretornolote")
    , @NamedQuery(name = "Nfceletronicalote.findByCodigoretornolote", query = "SELECT n FROM Nfceletronicalote n WHERE n.codigoretornolote = :codigoretornolote")
    , @NamedQuery(name = "Nfceletronicalote.findByData", query = "SELECT n FROM Nfceletronicalote n WHERE n.data = :data")
    , @NamedQuery(name = "Nfceletronicalote.findByHora", query = "SELECT n FROM Nfceletronicalote n WHERE n.hora = :hora")
    , @NamedQuery(name = "Nfceletronicalote.findByDatahorarecebidosefaz", query = "SELECT n FROM Nfceletronicalote n WHERE n.datahorarecebidosefaz = :datahorarecebidosefaz")
    , @NamedQuery(name = "Nfceletronicalote.findByFlagmorto", query = "SELECT n FROM Nfceletronicalote n WHERE n.flagmorto = :flagmorto")})
public class Nfceletronicalote implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODNFCELETRONICALOTE")
    private String codnfceletronicalote;
    @Basic(optional = false)
    @Column(name = "NUMEROLOTE")
    private int numerolote;
    @Basic(optional = false)
    @Column(name = "CODEMPRESA")
    private int codempresa;
    @Column(name = "NUMERORECIBO")
    private String numerorecibo;
    @Lob
    @Column(name = "XMLRETORNO")
    private String xmlretorno;
    @Column(name = "FLAGSTATUS")
    private Character flagstatus;
    @Column(name = "DESCRICAORETORNOLOTE")
    private String descricaoretornolote;
    @Column(name = "CODIGORETORNOLOTE")
    private String codigoretornolote;
    @Column(name = "DATA")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "HORA")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @Column(name = "DATAHORARECEBIDOSEFAZ")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datahorarecebidosefaz;
    @Column(name = "FLAGMORTO")
    private Character flagmorto;

    public Nfceletronicalote() {
    }

    public Nfceletronicalote(String codnfceletronicalote) {
        this.codnfceletronicalote = codnfceletronicalote;
    }

    public Nfceletronicalote(String codnfceletronicalote, int numerolote, int codempresa) {
        this.codnfceletronicalote = codnfceletronicalote;
        this.numerolote = numerolote;
        this.codempresa = codempresa;
    }

    public String getCodnfceletronicalote() {
        return codnfceletronicalote;
    }

    public void setCodnfceletronicalote(String codnfceletronicalote) {
        this.codnfceletronicalote = codnfceletronicalote;
    }

    public int getNumerolote() {
        return numerolote;
    }

    public void setNumerolote(int numerolote) {
        this.numerolote = numerolote;
    }

    public int getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(int codempresa) {
        this.codempresa = codempresa;
    }

    public String getNumerorecibo() {
        return numerorecibo;
    }

    public void setNumerorecibo(String numerorecibo) {
        this.numerorecibo = numerorecibo;
    }

    public String getXmlretorno() {
        return xmlretorno;
    }

    public void setXmlretorno(String xmlretorno) {
        this.xmlretorno = xmlretorno;
    }

    public Character getFlagstatus() {
        return flagstatus;
    }

    public void setFlagstatus(Character flagstatus) {
        this.flagstatus = flagstatus;
    }

    public String getDescricaoretornolote() {
        return descricaoretornolote;
    }

    public void setDescricaoretornolote(String descricaoretornolote) {
        this.descricaoretornolote = descricaoretornolote;
    }

    public String getCodigoretornolote() {
        return codigoretornolote;
    }

    public void setCodigoretornolote(String codigoretornolote) {
        this.codigoretornolote = codigoretornolote;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Date getDatahorarecebidosefaz() {
        return datahorarecebidosefaz;
    }

    public void setDatahorarecebidosefaz(Date datahorarecebidosefaz) {
        this.datahorarecebidosefaz = datahorarecebidosefaz;
    }

    public Character getFlagmorto() {
        return flagmorto;
    }

    public void setFlagmorto(Character flagmorto) {
        this.flagmorto = flagmorto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codnfceletronicalote != null ? codnfceletronicalote.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nfceletronicalote)) {
            return false;
        }
        Nfceletronicalote other = (Nfceletronicalote) object;
        if ((this.codnfceletronicalote == null && other.codnfceletronicalote != null) || (this.codnfceletronicalote != null && !this.codnfceletronicalote.equals(other.codnfceletronicalote))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Nfceletronicalote[ codnfceletronicalote=" + codnfceletronicalote + " ]";
    }
    
}
