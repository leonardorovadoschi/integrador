/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "LOCALIZACAO", catalog = "", schema = "")
@XmlRootElement

public class Localizacao implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

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
        String oldCodloc = this.codloc;
        this.codloc = codloc;
        changeSupport.firePropertyChange("codloc", oldCodloc, codloc);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        String oldCodigo = this.codigo;
        this.codigo = codigo;
        changeSupport.firePropertyChange("codigo", oldCodigo, codigo);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        String oldDescricao = this.descricao;
        this.descricao = descricao;
        changeSupport.firePropertyChange("descricao", oldDescricao, descricao);
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        String oldRua = this.rua;
        this.rua = rua;
        changeSupport.firePropertyChange("rua", oldRua, rua);
    }

    public String getBloco() {
        return bloco;
    }

    public void setBloco(String bloco) {
        String oldBloco = this.bloco;
        this.bloco = bloco;
        changeSupport.firePropertyChange("bloco", oldBloco, bloco);
    }

    public String getPrateleira() {
        return prateleira;
    }

    public void setPrateleira(String prateleira) {
        String oldPrateleira = this.prateleira;
        this.prateleira = prateleira;
        changeSupport.firePropertyChange("prateleira", oldPrateleira, prateleira);
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        String oldArea = this.area;
        this.area = area;
        changeSupport.firePropertyChange("area", oldArea, area);
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        String oldClassificacao = this.classificacao;
        this.classificacao = classificacao;
        changeSupport.firePropertyChange("classificacao", oldClassificacao, classificacao);
    }

    public String getSecao() {
        return secao;
    }

    public void setSecao(String secao) {
        String oldSecao = this.secao;
        this.secao = secao;
        changeSupport.firePropertyChange("secao", oldSecao, secao);
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        String oldGuid = this.guid;
        this.guid = guid;
        changeSupport.firePropertyChange("guid", oldGuid, guid);
    }

    public String getGalpao() {
        return galpao;
    }

    public void setGalpao(String galpao) {
        String oldGalpao = this.galpao;
        this.galpao = galpao;
        changeSupport.firePropertyChange("galpao", oldGalpao, galpao);
    }

    public String getPallet() {
        return pallet;
    }

    public void setPallet(String pallet) {
        String oldPallet = this.pallet;
        this.pallet = pallet;
        changeSupport.firePropertyChange("pallet", oldPallet, pallet);
    }

    public String getTunel() {
        return tunel;
    }

    public void setTunel(String tunel) {
        String oldTunel = this.tunel;
        this.tunel = tunel;
        changeSupport.firePropertyChange("tunel", oldTunel, tunel);
    }

    public String getNaturezaendereco() {
        return naturezaendereco;
    }

    public void setNaturezaendereco(String naturezaendereco) {
        String oldNaturezaendereco = this.naturezaendereco;
        this.naturezaendereco = naturezaendereco;
        changeSupport.firePropertyChange("naturezaendereco", oldNaturezaendereco, naturezaendereco);
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

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
