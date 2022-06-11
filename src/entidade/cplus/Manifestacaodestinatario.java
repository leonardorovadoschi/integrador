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
@Table(name = "MANIFESTACAODESTINATARIO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Manifestacaodestinatario.findAll", query = "SELECT m FROM Manifestacaodestinatario m")
    , @NamedQuery(name = "Manifestacaodestinatario.findByCodmanifestacaodestinatario", query = "SELECT m FROM Manifestacaodestinatario m WHERE m.codmanifestacaodestinatario = :codmanifestacaodestinatario")
    , @NamedQuery(name = "Manifestacaodestinatario.findByIdentidade", query = "SELECT m FROM Manifestacaodestinatario m WHERE m.identidade = :identidade")
    , @NamedQuery(name = "Manifestacaodestinatario.findByNomeentidade", query = "SELECT m FROM Manifestacaodestinatario m WHERE m.nomeentidade = :nomeentidade")
    , @NamedQuery(name = "Manifestacaodestinatario.findByChaveacesso", query = "SELECT m FROM Manifestacaodestinatario m WHERE m.chaveacesso = :chaveacesso")
    , @NamedQuery(name = "Manifestacaodestinatario.findByTipoevento", query = "SELECT m FROM Manifestacaodestinatario m WHERE m.tipoevento = :tipoevento")
    , @NamedQuery(name = "Manifestacaodestinatario.findByStatusmde", query = "SELECT m FROM Manifestacaodestinatario m WHERE m.statusmde = :statusmde")
    , @NamedQuery(name = "Manifestacaodestinatario.findByJustificativa", query = "SELECT m FROM Manifestacaodestinatario m WHERE m.justificativa = :justificativa")
    , @NamedQuery(name = "Manifestacaodestinatario.findByDatahora", query = "SELECT m FROM Manifestacaodestinatario m WHERE m.datahora = :datahora")
    , @NamedQuery(name = "Manifestacaodestinatario.findByCodigostatus", query = "SELECT m FROM Manifestacaodestinatario m WHERE m.codigostatus = :codigostatus")
    , @NamedQuery(name = "Manifestacaodestinatario.findByDescricaostatus", query = "SELECT m FROM Manifestacaodestinatario m WHERE m.descricaostatus = :descricaostatus")})
public class Manifestacaodestinatario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODMANIFESTACAODESTINATARIO")
    private String codmanifestacaodestinatario;
    @Column(name = "IDENTIDADE")
    private String identidade;
    @Column(name = "NOMEENTIDADE")
    private String nomeentidade;
    @Column(name = "CHAVEACESSO")
    private String chaveacesso;
    @Column(name = "TIPOEVENTO")
    private String tipoevento;
    @Column(name = "STATUSMDE")
    private String statusmde;
    @Column(name = "JUSTIFICATIVA")
    private String justificativa;
    @Basic(optional = false)
    @Column(name = "DATAHORA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datahora;
    @Column(name = "CODIGOSTATUS")
    private Integer codigostatus;
    @Column(name = "DESCRICAOSTATUS")
    private String descricaostatus;
    @Lob
    @Column(name = "XMLSIGN")
    private String xmlsign;
    @Lob
    @Column(name = "XMLRET")
    private String xmlret;
    @JoinColumn(name = "CODEMPRESA", referencedColumnName = "CODEMPRESA")
    @ManyToOne
    private Empresa codempresa;

    public Manifestacaodestinatario() {
    }

    public Manifestacaodestinatario(String codmanifestacaodestinatario) {
        this.codmanifestacaodestinatario = codmanifestacaodestinatario;
    }

    public Manifestacaodestinatario(String codmanifestacaodestinatario, Date datahora) {
        this.codmanifestacaodestinatario = codmanifestacaodestinatario;
        this.datahora = datahora;
    }

    public String getCodmanifestacaodestinatario() {
        return codmanifestacaodestinatario;
    }

    public void setCodmanifestacaodestinatario(String codmanifestacaodestinatario) {
        this.codmanifestacaodestinatario = codmanifestacaodestinatario;
    }

    public String getIdentidade() {
        return identidade;
    }

    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }

    public String getNomeentidade() {
        return nomeentidade;
    }

    public void setNomeentidade(String nomeentidade) {
        this.nomeentidade = nomeentidade;
    }

    public String getChaveacesso() {
        return chaveacesso;
    }

    public void setChaveacesso(String chaveacesso) {
        this.chaveacesso = chaveacesso;
    }

    public String getTipoevento() {
        return tipoevento;
    }

    public void setTipoevento(String tipoevento) {
        this.tipoevento = tipoevento;
    }

    public String getStatusmde() {
        return statusmde;
    }

    public void setStatusmde(String statusmde) {
        this.statusmde = statusmde;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public Date getDatahora() {
        return datahora;
    }

    public void setDatahora(Date datahora) {
        this.datahora = datahora;
    }

    public Integer getCodigostatus() {
        return codigostatus;
    }

    public void setCodigostatus(Integer codigostatus) {
        this.codigostatus = codigostatus;
    }

    public String getDescricaostatus() {
        return descricaostatus;
    }

    public void setDescricaostatus(String descricaostatus) {
        this.descricaostatus = descricaostatus;
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

    public Empresa getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Empresa codempresa) {
        this.codempresa = codempresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codmanifestacaodestinatario != null ? codmanifestacaodestinatario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Manifestacaodestinatario)) {
            return false;
        }
        Manifestacaodestinatario other = (Manifestacaodestinatario) object;
        if ((this.codmanifestacaodestinatario == null && other.codmanifestacaodestinatario != null) || (this.codmanifestacaodestinatario != null && !this.codmanifestacaodestinatario.equals(other.codmanifestacaodestinatario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Manifestacaodestinatario[ codmanifestacaodestinatario=" + codmanifestacaodestinatario + " ]";
    }
    
}
