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
import javax.persistence.JoinColumn;
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
@Table(name = "MDFELETRONICO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mdfeletronico.findAll", query = "SELECT m FROM Mdfeletronico m")
    , @NamedQuery(name = "Mdfeletronico.findByCodmdfeletronico", query = "SELECT m FROM Mdfeletronico m WHERE m.codmdfeletronico = :codmdfeletronico")
    , @NamedQuery(name = "Mdfeletronico.findByNumero", query = "SELECT m FROM Mdfeletronico m WHERE m.numero = :numero")
    , @NamedQuery(name = "Mdfeletronico.findBySerie", query = "SELECT m FROM Mdfeletronico m WHERE m.serie = :serie")
    , @NamedQuery(name = "Mdfeletronico.findByChaveacesso", query = "SELECT m FROM Mdfeletronico m WHERE m.chaveacesso = :chaveacesso")
    , @NamedQuery(name = "Mdfeletronico.findByAmbiente", query = "SELECT m FROM Mdfeletronico m WHERE m.ambiente = :ambiente")
    , @NamedQuery(name = "Mdfeletronico.findByTipoemissao", query = "SELECT m FROM Mdfeletronico m WHERE m.tipoemissao = :tipoemissao")
    , @NamedQuery(name = "Mdfeletronico.findByStatus", query = "SELECT m FROM Mdfeletronico m WHERE m.status = :status")
    , @NamedQuery(name = "Mdfeletronico.findByDescricaoretorno", query = "SELECT m FROM Mdfeletronico m WHERE m.descricaoretorno = :descricaoretorno")
    , @NamedQuery(name = "Mdfeletronico.findByObsfisco", query = "SELECT m FROM Mdfeletronico m WHERE m.obsfisco = :obsfisco")
    , @NamedQuery(name = "Mdfeletronico.findByObscontribuinte", query = "SELECT m FROM Mdfeletronico m WHERE m.obscontribuinte = :obscontribuinte")
    , @NamedQuery(name = "Mdfeletronico.findByCodigoretorno", query = "SELECT m FROM Mdfeletronico m WHERE m.codigoretorno = :codigoretorno")
    , @NamedQuery(name = "Mdfeletronico.findByDatahoraviagem", query = "SELECT m FROM Mdfeletronico m WHERE m.datahoraviagem = :datahoraviagem")
    , @NamedQuery(name = "Mdfeletronico.findByDatahoraemissao", query = "SELECT m FROM Mdfeletronico m WHERE m.datahoraemissao = :datahoraemissao")
    , @NamedQuery(name = "Mdfeletronico.findByModalidade", query = "SELECT m FROM Mdfeletronico m WHERE m.modalidade = :modalidade")
    , @NamedQuery(name = "Mdfeletronico.findByTipoemitente", query = "SELECT m FROM Mdfeletronico m WHERE m.tipoemitente = :tipoemitente")
    , @NamedQuery(name = "Mdfeletronico.findByDataencerramento", query = "SELECT m FROM Mdfeletronico m WHERE m.dataencerramento = :dataencerramento")
    , @NamedQuery(name = "Mdfeletronico.findByUnidademedida", query = "SELECT m FROM Mdfeletronico m WHERE m.unidademedida = :unidademedida")
    , @NamedQuery(name = "Mdfeletronico.findByJustificativacancelamento", query = "SELECT m FROM Mdfeletronico m WHERE m.justificativacancelamento = :justificativacancelamento")
    , @NamedQuery(name = "Mdfeletronico.findByCodigoibgeencerramento", query = "SELECT m FROM Mdfeletronico m WHERE m.codigoibgeencerramento = :codigoibgeencerramento")
    , @NamedQuery(name = "Mdfeletronico.findByMensagemauto", query = "SELECT m FROM Mdfeletronico m WHERE m.mensagemauto = :mensagemauto")
    , @NamedQuery(name = "Mdfeletronico.findByFlagmdfecargaposterior", query = "SELECT m FROM Mdfeletronico m WHERE m.flagmdfecargaposterior = :flagmdfecargaposterior")})
public class Mdfeletronico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODMDFELETRONICO")
    private String codmdfeletronico;
    @Column(name = "NUMERO")
    private Integer numero;
    @Column(name = "SERIE")
    private Integer serie;
    @Column(name = "CHAVEACESSO")
    private String chaveacesso;
    @Column(name = "AMBIENTE")
    private Integer ambiente;
    @Column(name = "TIPOEMISSAO")
    private Integer tipoemissao;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "DESCRICAORETORNO")
    private String descricaoretorno;
    @Column(name = "OBSFISCO")
    private String obsfisco;
    @Column(name = "OBSCONTRIBUINTE")
    private String obscontribuinte;
    @Column(name = "CODIGORETORNO")
    private String codigoretorno;
    @Column(name = "DATAHORAVIAGEM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datahoraviagem;
    @Column(name = "DATAHORAEMISSAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datahoraemissao;
    @Column(name = "MODALIDADE")
    private Character modalidade;
    @Column(name = "TIPOEMITENTE")
    private Character tipoemitente;
    @Column(name = "DATAENCERRAMENTO")
    @Temporal(TemporalType.DATE)
    private Date dataencerramento;
    @Column(name = "UNIDADEMEDIDA")
    private String unidademedida;
    @Column(name = "JUSTIFICATIVACANCELAMENTO")
    private String justificativacancelamento;
    @Column(name = "CODIGOIBGEENCERRAMENTO")
    private String codigoibgeencerramento;
    @Column(name = "MENSAGEMAUTO")
    private String mensagemauto;
    @Basic(optional = false)
    @Column(name = "FLAGMDFECARGAPOSTERIOR")
    private Character flagmdfecargaposterior;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codmdfeletronico")
    private Collection<Mdfeletronicocargaposterior> mdfeletronicocargaposteriorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codmdfeletronico")
    private Collection<Mdfeletronicoveiculo> mdfeletronicoveiculoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codmdfeletronico")
    private Collection<Mdfeletronicolocal> mdfeletronicolocalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codmdfeletronico")
    private Collection<Mdfeletronicoevento> mdfeletronicoeventoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codmdfeletronico")
    private Collection<Mdfeletronicopercurso> mdfeletronicopercursoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codmdfeletronico")
    private Collection<Mdfeletroniconf> mdfeletroniconfCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codmdfeletronico")
    private Collection<Mdfeletronicocondutor> mdfeletronicocondutorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codmdfeletronico")
    private Collection<Mdfeletronicolacre> mdfeletronicolacreCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codmdfeletronico")
    private Collection<Mdfeletronicoautorizadoxml> mdfeletronicoautorizadoxmlCollection;
    @JoinColumn(name = "CODEMPRESA", referencedColumnName = "CODEMPRESA")
    @ManyToOne(optional = false)
    private Empresa codempresa;
    @JoinColumn(name = "CODEMPRESATIPODOCUMENTO", referencedColumnName = "CODEMPRESATIPODOCUMENTO")
    @ManyToOne
    private Empresatipodocumento codempresatipodocumento;
    @JoinColumn(name = "CODUFFIM", referencedColumnName = "CODUF")
    @ManyToOne(optional = false)
    private Uf coduffim;
    @JoinColumn(name = "CODUFINICIO", referencedColumnName = "CODUF")
    @ManyToOne(optional = false)
    private Uf codufinicio;

    public Mdfeletronico() {
    }

    public Mdfeletronico(String codmdfeletronico) {
        this.codmdfeletronico = codmdfeletronico;
    }

    public Mdfeletronico(String codmdfeletronico, Character flagmdfecargaposterior) {
        this.codmdfeletronico = codmdfeletronico;
        this.flagmdfecargaposterior = flagmdfecargaposterior;
    }

    public String getCodmdfeletronico() {
        return codmdfeletronico;
    }

    public void setCodmdfeletronico(String codmdfeletronico) {
        this.codmdfeletronico = codmdfeletronico;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getSerie() {
        return serie;
    }

    public void setSerie(Integer serie) {
        this.serie = serie;
    }

    public String getChaveacesso() {
        return chaveacesso;
    }

    public void setChaveacesso(String chaveacesso) {
        this.chaveacesso = chaveacesso;
    }

    public Integer getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(Integer ambiente) {
        this.ambiente = ambiente;
    }

    public Integer getTipoemissao() {
        return tipoemissao;
    }

    public void setTipoemissao(Integer tipoemissao) {
        this.tipoemissao = tipoemissao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescricaoretorno() {
        return descricaoretorno;
    }

    public void setDescricaoretorno(String descricaoretorno) {
        this.descricaoretorno = descricaoretorno;
    }

    public String getObsfisco() {
        return obsfisco;
    }

    public void setObsfisco(String obsfisco) {
        this.obsfisco = obsfisco;
    }

    public String getObscontribuinte() {
        return obscontribuinte;
    }

    public void setObscontribuinte(String obscontribuinte) {
        this.obscontribuinte = obscontribuinte;
    }

    public String getCodigoretorno() {
        return codigoretorno;
    }

    public void setCodigoretorno(String codigoretorno) {
        this.codigoretorno = codigoretorno;
    }

    public Date getDatahoraviagem() {
        return datahoraviagem;
    }

    public void setDatahoraviagem(Date datahoraviagem) {
        this.datahoraviagem = datahoraviagem;
    }

    public Date getDatahoraemissao() {
        return datahoraemissao;
    }

    public void setDatahoraemissao(Date datahoraemissao) {
        this.datahoraemissao = datahoraemissao;
    }

    public Character getModalidade() {
        return modalidade;
    }

    public void setModalidade(Character modalidade) {
        this.modalidade = modalidade;
    }

    public Character getTipoemitente() {
        return tipoemitente;
    }

    public void setTipoemitente(Character tipoemitente) {
        this.tipoemitente = tipoemitente;
    }

    public Date getDataencerramento() {
        return dataencerramento;
    }

    public void setDataencerramento(Date dataencerramento) {
        this.dataencerramento = dataencerramento;
    }

    public String getUnidademedida() {
        return unidademedida;
    }

    public void setUnidademedida(String unidademedida) {
        this.unidademedida = unidademedida;
    }

    public String getJustificativacancelamento() {
        return justificativacancelamento;
    }

    public void setJustificativacancelamento(String justificativacancelamento) {
        this.justificativacancelamento = justificativacancelamento;
    }

    public String getCodigoibgeencerramento() {
        return codigoibgeencerramento;
    }

    public void setCodigoibgeencerramento(String codigoibgeencerramento) {
        this.codigoibgeencerramento = codigoibgeencerramento;
    }

    public String getMensagemauto() {
        return mensagemauto;
    }

    public void setMensagemauto(String mensagemauto) {
        this.mensagemauto = mensagemauto;
    }

    public Character getFlagmdfecargaposterior() {
        return flagmdfecargaposterior;
    }

    public void setFlagmdfecargaposterior(Character flagmdfecargaposterior) {
        this.flagmdfecargaposterior = flagmdfecargaposterior;
    }

    @XmlTransient
    public Collection<Mdfeletronicocargaposterior> getMdfeletronicocargaposteriorCollection() {
        return mdfeletronicocargaposteriorCollection;
    }

    public void setMdfeletronicocargaposteriorCollection(Collection<Mdfeletronicocargaposterior> mdfeletronicocargaposteriorCollection) {
        this.mdfeletronicocargaposteriorCollection = mdfeletronicocargaposteriorCollection;
    }

    @XmlTransient
    public Collection<Mdfeletronicoveiculo> getMdfeletronicoveiculoCollection() {
        return mdfeletronicoveiculoCollection;
    }

    public void setMdfeletronicoveiculoCollection(Collection<Mdfeletronicoveiculo> mdfeletronicoveiculoCollection) {
        this.mdfeletronicoveiculoCollection = mdfeletronicoveiculoCollection;
    }

    @XmlTransient
    public Collection<Mdfeletronicolocal> getMdfeletronicolocalCollection() {
        return mdfeletronicolocalCollection;
    }

    public void setMdfeletronicolocalCollection(Collection<Mdfeletronicolocal> mdfeletronicolocalCollection) {
        this.mdfeletronicolocalCollection = mdfeletronicolocalCollection;
    }

    @XmlTransient
    public Collection<Mdfeletronicoevento> getMdfeletronicoeventoCollection() {
        return mdfeletronicoeventoCollection;
    }

    public void setMdfeletronicoeventoCollection(Collection<Mdfeletronicoevento> mdfeletronicoeventoCollection) {
        this.mdfeletronicoeventoCollection = mdfeletronicoeventoCollection;
    }

    @XmlTransient
    public Collection<Mdfeletronicopercurso> getMdfeletronicopercursoCollection() {
        return mdfeletronicopercursoCollection;
    }

    public void setMdfeletronicopercursoCollection(Collection<Mdfeletronicopercurso> mdfeletronicopercursoCollection) {
        this.mdfeletronicopercursoCollection = mdfeletronicopercursoCollection;
    }

    @XmlTransient
    public Collection<Mdfeletroniconf> getMdfeletroniconfCollection() {
        return mdfeletroniconfCollection;
    }

    public void setMdfeletroniconfCollection(Collection<Mdfeletroniconf> mdfeletroniconfCollection) {
        this.mdfeletroniconfCollection = mdfeletroniconfCollection;
    }

    @XmlTransient
    public Collection<Mdfeletronicocondutor> getMdfeletronicocondutorCollection() {
        return mdfeletronicocondutorCollection;
    }

    public void setMdfeletronicocondutorCollection(Collection<Mdfeletronicocondutor> mdfeletronicocondutorCollection) {
        this.mdfeletronicocondutorCollection = mdfeletronicocondutorCollection;
    }

    @XmlTransient
    public Collection<Mdfeletronicolacre> getMdfeletronicolacreCollection() {
        return mdfeletronicolacreCollection;
    }

    public void setMdfeletronicolacreCollection(Collection<Mdfeletronicolacre> mdfeletronicolacreCollection) {
        this.mdfeletronicolacreCollection = mdfeletronicolacreCollection;
    }

    @XmlTransient
    public Collection<Mdfeletronicoautorizadoxml> getMdfeletronicoautorizadoxmlCollection() {
        return mdfeletronicoautorizadoxmlCollection;
    }

    public void setMdfeletronicoautorizadoxmlCollection(Collection<Mdfeletronicoautorizadoxml> mdfeletronicoautorizadoxmlCollection) {
        this.mdfeletronicoautorizadoxmlCollection = mdfeletronicoautorizadoxmlCollection;
    }

    public Empresa getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Empresa codempresa) {
        this.codempresa = codempresa;
    }

    public Empresatipodocumento getCodempresatipodocumento() {
        return codempresatipodocumento;
    }

    public void setCodempresatipodocumento(Empresatipodocumento codempresatipodocumento) {
        this.codempresatipodocumento = codempresatipodocumento;
    }

    public Uf getCoduffim() {
        return coduffim;
    }

    public void setCoduffim(Uf coduffim) {
        this.coduffim = coduffim;
    }

    public Uf getCodufinicio() {
        return codufinicio;
    }

    public void setCodufinicio(Uf codufinicio) {
        this.codufinicio = codufinicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codmdfeletronico != null ? codmdfeletronico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mdfeletronico)) {
            return false;
        }
        Mdfeletronico other = (Mdfeletronico) object;
        if ((this.codmdfeletronico == null && other.codmdfeletronico != null) || (this.codmdfeletronico != null && !this.codmdfeletronico.equals(other.codmdfeletronico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Mdfeletronico[ codmdfeletronico=" + codmdfeletronico + " ]";
    }
    
}
