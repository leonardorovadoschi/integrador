/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "LOCALIZACAO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Localizacao.findAll", query = "SELECT l FROM Localizacao l")
    , @NamedQuery(name = "Localizacao.findByCodloc", query = "SELECT l FROM Localizacao l WHERE l.codloc = :codloc")
    , @NamedQuery(name = "Localizacao.findByCodigo", query = "SELECT l FROM Localizacao l WHERE l.codigo = :codigo")
    , @NamedQuery(name = "Localizacao.findByDescricao", query = "SELECT l FROM Localizacao l WHERE l.descricao = :descricao")
    , @NamedQuery(name = "Localizacao.findByRua", query = "SELECT l FROM Localizacao l WHERE l.rua = :rua")
    , @NamedQuery(name = "Localizacao.findByBloco", query = "SELECT l FROM Localizacao l WHERE l.bloco = :bloco")
    , @NamedQuery(name = "Localizacao.findByPrateleira", query = "SELECT l FROM Localizacao l WHERE l.prateleira = :prateleira")
    , @NamedQuery(name = "Localizacao.findByArea", query = "SELECT l FROM Localizacao l WHERE l.area = :area")
    , @NamedQuery(name = "Localizacao.findByClassificacao", query = "SELECT l FROM Localizacao l WHERE l.classificacao = :classificacao")
    , @NamedQuery(name = "Localizacao.findBySecao", query = "SELECT l FROM Localizacao l WHERE l.secao = :secao")
    , @NamedQuery(name = "Localizacao.findByGuid", query = "SELECT l FROM Localizacao l WHERE l.guid = :guid")
    , @NamedQuery(name = "Localizacao.findByGalpao", query = "SELECT l FROM Localizacao l WHERE l.galpao = :galpao")
    , @NamedQuery(name = "Localizacao.findByPallet", query = "SELECT l FROM Localizacao l WHERE l.pallet = :pallet")
    , @NamedQuery(name = "Localizacao.findByTunel", query = "SELECT l FROM Localizacao l WHERE l.tunel = :tunel")
    , @NamedQuery(name = "Localizacao.findByNaturezaendereco", query = "SELECT l FROM Localizacao l WHERE l.naturezaendereco = :naturezaendereco")})
public class Localizacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODLOC")
    private String codloc;
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "DESCRICAO")
    private String descricao;
    @Column(name = "RUA")
    private String rua;
    @Column(name = "BLOCO")
    private String bloco;
    @Column(name = "PRATELEIRA")
    private String prateleira;
    @Column(name = "AREA")
    private String area;
    @Column(name = "CLASSIFICACAO")
    private String classificacao;
    @Column(name = "SECAO")
    private String secao;
    @Column(name = "GUID")
    private String guid;
    @Column(name = "GALPAO")
    private String galpao;
    @Column(name = "PALLET")
    private String pallet;
    @Column(name = "TUNEL")
    private String tunel;
    @Column(name = "NATUREZAENDERECO")
    private String naturezaendereco;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codloc")
    private Collection<Produtolocalizacao> produtolocalizacaoCollection;

    public Localizacao() {
    }

    public Localizacao(String codloc) {
        this.codloc = codloc;
    }

    public Localizacao(String codloc, String codigo) {
        this.codloc = codloc;
        this.codigo = codigo;
    }

    public String getCodloc() {
        return codloc;
    }

    public void setCodloc(String codloc) {
        this.codloc = codloc;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBloco() {
        return bloco;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    public String getPrateleira() {
        return prateleira;
    }

    public void setPrateleira(String prateleira) {
        this.prateleira = prateleira;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public String getSecao() {
        return secao;
    }

    public void setSecao(String secao) {
        this.secao = secao;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getGalpao() {
        return galpao;
    }

    public void setGalpao(String galpao) {
        this.galpao = galpao;
    }

    public String getPallet() {
        return pallet;
    }

    public void setPallet(String pallet) {
        this.pallet = pallet;
    }

    public String getTunel() {
        return tunel;
    }

    public void setTunel(String tunel) {
        this.tunel = tunel;
    }

    public String getNaturezaendereco() {
        return naturezaendereco;
    }

    public void setNaturezaendereco(String naturezaendereco) {
        this.naturezaendereco = naturezaendereco;
    }

    @XmlTransient
    public Collection<Produtolocalizacao> getProdutolocalizacaoCollection() {
        return produtolocalizacaoCollection;
    }

    public void setProdutolocalizacaoCollection(Collection<Produtolocalizacao> produtolocalizacaoCollection) {
        this.produtolocalizacaoCollection = produtolocalizacaoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codloc != null ? codloc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Localizacao)) {
            return false;
        }
        Localizacao other = (Localizacao) object;
        if ((this.codloc == null && other.codloc != null) || (this.codloc != null && !this.codloc.equals(other.codloc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Localizacao[ codloc=" + codloc + " ]";
    }
    
}
