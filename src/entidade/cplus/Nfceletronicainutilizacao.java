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
@Table(name = "NFCELETRONICAINUTILIZACAO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nfceletronicainutilizacao.findAll", query = "SELECT n FROM Nfceletronicainutilizacao n")
    , @NamedQuery(name = "Nfceletronicainutilizacao.findByCodnfceletronicainutilizacao", query = "SELECT n FROM Nfceletronicainutilizacao n WHERE n.codnfceletronicainutilizacao = :codnfceletronicainutilizacao")
    , @NamedQuery(name = "Nfceletronicainutilizacao.findByCodempresa", query = "SELECT n FROM Nfceletronicainutilizacao n WHERE n.codempresa = :codempresa")
    , @NamedQuery(name = "Nfceletronicainutilizacao.findByDatainutilizacao", query = "SELECT n FROM Nfceletronicainutilizacao n WHERE n.datainutilizacao = :datainutilizacao")
    , @NamedQuery(name = "Nfceletronicainutilizacao.findBySerie", query = "SELECT n FROM Nfceletronicainutilizacao n WHERE n.serie = :serie")
    , @NamedQuery(name = "Nfceletronicainutilizacao.findByFaixaini", query = "SELECT n FROM Nfceletronicainutilizacao n WHERE n.faixaini = :faixaini")
    , @NamedQuery(name = "Nfceletronicainutilizacao.findByFaixafin", query = "SELECT n FROM Nfceletronicainutilizacao n WHERE n.faixafin = :faixafin")
    , @NamedQuery(name = "Nfceletronicainutilizacao.findByJustificativa", query = "SELECT n FROM Nfceletronicainutilizacao n WHERE n.justificativa = :justificativa")
    , @NamedQuery(name = "Nfceletronicainutilizacao.findByStatusinutilizacao", query = "SELECT n FROM Nfceletronicainutilizacao n WHERE n.statusinutilizacao = :statusinutilizacao")
    , @NamedQuery(name = "Nfceletronicainutilizacao.findByCodigoretorno", query = "SELECT n FROM Nfceletronicainutilizacao n WHERE n.codigoretorno = :codigoretorno")
    , @NamedQuery(name = "Nfceletronicainutilizacao.findByDescricaoretorno", query = "SELECT n FROM Nfceletronicainutilizacao n WHERE n.descricaoretorno = :descricaoretorno")
    , @NamedQuery(name = "Nfceletronicainutilizacao.findByNumeroprotocolo", query = "SELECT n FROM Nfceletronicainutilizacao n WHERE n.numeroprotocolo = :numeroprotocolo")
    , @NamedQuery(name = "Nfceletronicainutilizacao.findByDatahorarecebidosefaz", query = "SELECT n FROM Nfceletronicainutilizacao n WHERE n.datahorarecebidosefaz = :datahorarecebidosefaz")
    , @NamedQuery(name = "Nfceletronicainutilizacao.findByAmbiente", query = "SELECT n FROM Nfceletronicainutilizacao n WHERE n.ambiente = :ambiente")
    , @NamedQuery(name = "Nfceletronicainutilizacao.findByChaveid", query = "SELECT n FROM Nfceletronicainutilizacao n WHERE n.chaveid = :chaveid")})
public class Nfceletronicainutilizacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODNFCELETRONICAINUTILIZACAO")
    private String codnfceletronicainutilizacao;
    @Column(name = "CODEMPRESA")
    private Integer codempresa;
    @Column(name = "DATAINUTILIZACAO")
    @Temporal(TemporalType.DATE)
    private Date datainutilizacao;
    @Column(name = "SERIE")
    private Short serie;
    @Column(name = "FAIXAINI")
    private Integer faixaini;
    @Column(name = "FAIXAFIN")
    private Integer faixafin;
    @Column(name = "JUSTIFICATIVA")
    private String justificativa;
    @Column(name = "STATUSINUTILIZACAO")
    private String statusinutilizacao;
    @Column(name = "CODIGORETORNO")
    private String codigoretorno;
    @Column(name = "DESCRICAORETORNO")
    private String descricaoretorno;
    @Column(name = "NUMEROPROTOCOLO")
    private String numeroprotocolo;
    @Column(name = "DATAHORARECEBIDOSEFAZ")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datahorarecebidosefaz;
    @Column(name = "AMBIENTE")
    private Character ambiente;
    @Lob
    @Column(name = "XMLINUTSIGN")
    private String xmlinutsign;
    @Lob
    @Column(name = "XMLINUTRET")
    private String xmlinutret;
    @Column(name = "CHAVEID")
    private String chaveid;

    public Nfceletronicainutilizacao() {
    }

    public Nfceletronicainutilizacao(String codnfceletronicainutilizacao) {
        this.codnfceletronicainutilizacao = codnfceletronicainutilizacao;
    }

    public String getCodnfceletronicainutilizacao() {
        return codnfceletronicainutilizacao;
    }

    public void setCodnfceletronicainutilizacao(String codnfceletronicainutilizacao) {
        this.codnfceletronicainutilizacao = codnfceletronicainutilizacao;
    }

    public Integer getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Integer codempresa) {
        this.codempresa = codempresa;
    }

    public Date getDatainutilizacao() {
        return datainutilizacao;
    }

    public void setDatainutilizacao(Date datainutilizacao) {
        this.datainutilizacao = datainutilizacao;
    }

    public Short getSerie() {
        return serie;
    }

    public void setSerie(Short serie) {
        this.serie = serie;
    }

    public Integer getFaixaini() {
        return faixaini;
    }

    public void setFaixaini(Integer faixaini) {
        this.faixaini = faixaini;
    }

    public Integer getFaixafin() {
        return faixafin;
    }

    public void setFaixafin(Integer faixafin) {
        this.faixafin = faixafin;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public String getStatusinutilizacao() {
        return statusinutilizacao;
    }

    public void setStatusinutilizacao(String statusinutilizacao) {
        this.statusinutilizacao = statusinutilizacao;
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

    public Date getDatahorarecebidosefaz() {
        return datahorarecebidosefaz;
    }

    public void setDatahorarecebidosefaz(Date datahorarecebidosefaz) {
        this.datahorarecebidosefaz = datahorarecebidosefaz;
    }

    public Character getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(Character ambiente) {
        this.ambiente = ambiente;
    }

    public String getXmlinutsign() {
        return xmlinutsign;
    }

    public void setXmlinutsign(String xmlinutsign) {
        this.xmlinutsign = xmlinutsign;
    }

    public String getXmlinutret() {
        return xmlinutret;
    }

    public void setXmlinutret(String xmlinutret) {
        this.xmlinutret = xmlinutret;
    }

    public String getChaveid() {
        return chaveid;
    }

    public void setChaveid(String chaveid) {
        this.chaveid = chaveid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codnfceletronicainutilizacao != null ? codnfceletronicainutilizacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nfceletronicainutilizacao)) {
            return false;
        }
        Nfceletronicainutilizacao other = (Nfceletronicainutilizacao) object;
        if ((this.codnfceletronicainutilizacao == null && other.codnfceletronicainutilizacao != null) || (this.codnfceletronicainutilizacao != null && !this.codnfceletronicainutilizacao.equals(other.codnfceletronicainutilizacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Nfceletronicainutilizacao[ codnfceletronicainutilizacao=" + codnfceletronicainutilizacao + " ]";
    }
    
}
