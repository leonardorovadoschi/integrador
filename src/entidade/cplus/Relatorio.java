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
import javax.persistence.Lob;
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
@Table(name = "RELATORIO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Relatorio.findAll", query = "SELECT r FROM Relatorio r")
    , @NamedQuery(name = "Relatorio.findById", query = "SELECT r FROM Relatorio r WHERE r.id = :id")
    , @NamedQuery(name = "Relatorio.findByDescricao", query = "SELECT r FROM Relatorio r WHERE r.descricao = :descricao")
    , @NamedQuery(name = "Relatorio.findByNomearquivo", query = "SELECT r FROM Relatorio r WHERE r.nomearquivo = :nomearquivo")
    , @NamedQuery(name = "Relatorio.findByTamanho", query = "SELECT r FROM Relatorio r WHERE r.tamanho = :tamanho")
    , @NamedQuery(name = "Relatorio.findByDatamodificacao", query = "SELECT r FROM Relatorio r WHERE r.datamodificacao = :datamodificacao")
    , @NamedQuery(name = "Relatorio.findByFlagsistema", query = "SELECT r FROM Relatorio r WHERE r.flagsistema = :flagsistema")
    , @NamedQuery(name = "Relatorio.findByCodreport", query = "SELECT r FROM Relatorio r WHERE r.codreport = :codreport")
    , @NamedQuery(name = "Relatorio.findByFlagpadrao", query = "SELECT r FROM Relatorio r WHERE r.flagpadrao = :flagpadrao")
    , @NamedQuery(name = "Relatorio.findByImprimiracentos", query = "SELECT r FROM Relatorio r WHERE r.imprimiracentos = :imprimiracentos")
    , @NamedQuery(name = "Relatorio.findByTipoimpressora", query = "SELECT r FROM Relatorio r WHERE r.tipoimpressora = :tipoimpressora")
    , @NamedQuery(name = "Relatorio.findByCortarpapel", query = "SELECT r FROM Relatorio r WHERE r.cortarpapel = :cortarpapel")
    , @NamedQuery(name = "Relatorio.findByLinhas", query = "SELECT r FROM Relatorio r WHERE r.linhas = :linhas")
    , @NamedQuery(name = "Relatorio.findByParametros", query = "SELECT r FROM Relatorio r WHERE r.parametros = :parametros")
    , @NamedQuery(name = "Relatorio.findByFlagimpressao", query = "SELECT r FROM Relatorio r WHERE r.flagimpressao = :flagimpressao")
    , @NamedQuery(name = "Relatorio.findByComandocorte", query = "SELECT r FROM Relatorio r WHERE r.comandocorte = :comandocorte")})
public class Relatorio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Column(name = "DESCRICAO")
    private String descricao;
    @Column(name = "NOMEARQUIVO")
    private String nomearquivo;
    @Lob
    @Column(name = "TEMPLATE")
    private byte[] template;
    @Column(name = "TAMANHO")
    private Integer tamanho;
    @Column(name = "DATAMODIFICACAO")
    @Temporal(TemporalType.DATE)
    private Date datamodificacao;
    @Column(name = "FLAGSISTEMA")
    private Character flagsistema;
    @Column(name = "CODREPORT")
    private Integer codreport;
    @Column(name = "FLAGPADRAO")
    private Character flagpadrao;
    @Column(name = "IMPRIMIRACENTOS")
    private Character imprimiracentos;
    @Column(name = "TIPOIMPRESSORA")
    private String tipoimpressora;
    @Column(name = "CORTARPAPEL")
    private Character cortarpapel;
    @Column(name = "LINHAS")
    private Integer linhas;
    @Column(name = "PARAMETROS")
    private String parametros;
    @Column(name = "FLAGIMPRESSAO")
    private Character flagimpressao;
    @Column(name = "COMANDOCORTE")
    private String comandocorte;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idrelatorio")
    private Collection<Relatorioacesso> relatorioacessoCollection;
    @JoinColumn(name = "CODSISTEMA", referencedColumnName = "CODSISTEMA")
    @ManyToOne
    private Sistema codsistema;

    public Relatorio() {
    }

    public Relatorio(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNomearquivo() {
        return nomearquivo;
    }

    public void setNomearquivo(String nomearquivo) {
        this.nomearquivo = nomearquivo;
    }

    public byte[] getTemplate() {
        return template;
    }

    public void setTemplate(byte[] template) {
        this.template = template;
    }

    public Integer getTamanho() {
        return tamanho;
    }

    public void setTamanho(Integer tamanho) {
        this.tamanho = tamanho;
    }

    public Date getDatamodificacao() {
        return datamodificacao;
    }

    public void setDatamodificacao(Date datamodificacao) {
        this.datamodificacao = datamodificacao;
    }

    public Character getFlagsistema() {
        return flagsistema;
    }

    public void setFlagsistema(Character flagsistema) {
        this.flagsistema = flagsistema;
    }

    public Integer getCodreport() {
        return codreport;
    }

    public void setCodreport(Integer codreport) {
        this.codreport = codreport;
    }

    public Character getFlagpadrao() {
        return flagpadrao;
    }

    public void setFlagpadrao(Character flagpadrao) {
        this.flagpadrao = flagpadrao;
    }

    public Character getImprimiracentos() {
        return imprimiracentos;
    }

    public void setImprimiracentos(Character imprimiracentos) {
        this.imprimiracentos = imprimiracentos;
    }

    public String getTipoimpressora() {
        return tipoimpressora;
    }

    public void setTipoimpressora(String tipoimpressora) {
        this.tipoimpressora = tipoimpressora;
    }

    public Character getCortarpapel() {
        return cortarpapel;
    }

    public void setCortarpapel(Character cortarpapel) {
        this.cortarpapel = cortarpapel;
    }

    public Integer getLinhas() {
        return linhas;
    }

    public void setLinhas(Integer linhas) {
        this.linhas = linhas;
    }

    public String getParametros() {
        return parametros;
    }

    public void setParametros(String parametros) {
        this.parametros = parametros;
    }

    public Character getFlagimpressao() {
        return flagimpressao;
    }

    public void setFlagimpressao(Character flagimpressao) {
        this.flagimpressao = flagimpressao;
    }

    public String getComandocorte() {
        return comandocorte;
    }

    public void setComandocorte(String comandocorte) {
        this.comandocorte = comandocorte;
    }

    @XmlTransient
    public Collection<Relatorioacesso> getRelatorioacessoCollection() {
        return relatorioacessoCollection;
    }

    public void setRelatorioacessoCollection(Collection<Relatorioacesso> relatorioacessoCollection) {
        this.relatorioacessoCollection = relatorioacessoCollection;
    }

    public Sistema getCodsistema() {
        return codsistema;
    }

    public void setCodsistema(Sistema codsistema) {
        this.codsistema = codsistema;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Relatorio)) {
            return false;
        }
        Relatorio other = (Relatorio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Relatorio[ id=" + id + " ]";
    }
    
}
