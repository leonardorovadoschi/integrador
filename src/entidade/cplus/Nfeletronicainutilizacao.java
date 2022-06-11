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
@Table(name = "NFELETRONICAINUTILIZACAO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nfeletronicainutilizacao.findAll", query = "SELECT n FROM Nfeletronicainutilizacao n")
    , @NamedQuery(name = "Nfeletronicainutilizacao.findByCodnfeletronicainutilizacao", query = "SELECT n FROM Nfeletronicainutilizacao n WHERE n.codnfeletronicainutilizacao = :codnfeletronicainutilizacao")
    , @NamedQuery(name = "Nfeletronicainutilizacao.findByNumnota", query = "SELECT n FROM Nfeletronicainutilizacao n WHERE n.numnota = :numnota")
    , @NamedQuery(name = "Nfeletronicainutilizacao.findBySerienota", query = "SELECT n FROM Nfeletronicainutilizacao n WHERE n.serienota = :serienota")
    , @NamedQuery(name = "Nfeletronicainutilizacao.findByDatainutilizacao", query = "SELECT n FROM Nfeletronicainutilizacao n WHERE n.datainutilizacao = :datainutilizacao")
    , @NamedQuery(name = "Nfeletronicainutilizacao.findByStatusinutilizacao", query = "SELECT n FROM Nfeletronicainutilizacao n WHERE n.statusinutilizacao = :statusinutilizacao")
    , @NamedQuery(name = "Nfeletronicainutilizacao.findByCodigoretorno", query = "SELECT n FROM Nfeletronicainutilizacao n WHERE n.codigoretorno = :codigoretorno")
    , @NamedQuery(name = "Nfeletronicainutilizacao.findByDescricaoretorno", query = "SELECT n FROM Nfeletronicainutilizacao n WHERE n.descricaoretorno = :descricaoretorno")
    , @NamedQuery(name = "Nfeletronicainutilizacao.findByNumeroprotocolo", query = "SELECT n FROM Nfeletronicainutilizacao n WHERE n.numeroprotocolo = :numeroprotocolo")
    , @NamedQuery(name = "Nfeletronicainutilizacao.findByJustificativa", query = "SELECT n FROM Nfeletronicainutilizacao n WHERE n.justificativa = :justificativa")
    , @NamedQuery(name = "Nfeletronicainutilizacao.findByCodempresa", query = "SELECT n FROM Nfeletronicainutilizacao n WHERE n.codempresa = :codempresa")
    , @NamedQuery(name = "Nfeletronicainutilizacao.findByNumnotafinal", query = "SELECT n FROM Nfeletronicainutilizacao n WHERE n.numnotafinal = :numnotafinal")})
public class Nfeletronicainutilizacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODNFELETRONICAINUTILIZACAO")
    private String codnfeletronicainutilizacao;
    @Column(name = "NUMNOTA")
    private Integer numnota;
    @Column(name = "SERIENOTA")
    private String serienota;
    @Column(name = "DATAINUTILIZACAO")
    @Temporal(TemporalType.DATE)
    private Date datainutilizacao;
    @Column(name = "STATUSINUTILIZACAO")
    private String statusinutilizacao;
    @Column(name = "CODIGORETORNO")
    private String codigoretorno;
    @Column(name = "DESCRICAORETORNO")
    private String descricaoretorno;
    @Column(name = "NUMEROPROTOCOLO")
    private String numeroprotocolo;
    @Column(name = "JUSTIFICATIVA")
    private String justificativa;
    @Column(name = "CODEMPRESA")
    private Integer codempresa;
    @Lob
    @Column(name = "XMLINUTSIGN")
    private String xmlinutsign;
    @Lob
    @Column(name = "XMLINUTRET")
    private String xmlinutret;
    @Column(name = "NUMNOTAFINAL")
    private Integer numnotafinal;

    public Nfeletronicainutilizacao() {
    }

    public Nfeletronicainutilizacao(String codnfeletronicainutilizacao) {
        this.codnfeletronicainutilizacao = codnfeletronicainutilizacao;
    }

    public String getCodnfeletronicainutilizacao() {
        return codnfeletronicainutilizacao;
    }

    public void setCodnfeletronicainutilizacao(String codnfeletronicainutilizacao) {
        this.codnfeletronicainutilizacao = codnfeletronicainutilizacao;
    }

    public Integer getNumnota() {
        return numnota;
    }

    public void setNumnota(Integer numnota) {
        this.numnota = numnota;
    }

    public String getSerienota() {
        return serienota;
    }

    public void setSerienota(String serienota) {
        this.serienota = serienota;
    }

    public Date getDatainutilizacao() {
        return datainutilizacao;
    }

    public void setDatainutilizacao(Date datainutilizacao) {
        this.datainutilizacao = datainutilizacao;
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

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public Integer getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Integer codempresa) {
        this.codempresa = codempresa;
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

    public Integer getNumnotafinal() {
        return numnotafinal;
    }

    public void setNumnotafinal(Integer numnotafinal) {
        this.numnotafinal = numnotafinal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codnfeletronicainutilizacao != null ? codnfeletronicainutilizacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nfeletronicainutilizacao)) {
            return false;
        }
        Nfeletronicainutilizacao other = (Nfeletronicainutilizacao) object;
        if ((this.codnfeletronicainutilizacao == null && other.codnfeletronicainutilizacao != null) || (this.codnfeletronicainutilizacao != null && !this.codnfeletronicainutilizacao.equals(other.codnfeletronicainutilizacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Nfeletronicainutilizacao[ codnfeletronicainutilizacao=" + codnfeletronicainutilizacao + " ]";
    }
    
}
