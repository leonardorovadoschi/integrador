/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "CAMPOCUSTOMMASTER", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Campocustommaster.findAll", query = "SELECT c FROM Campocustommaster c")
    , @NamedQuery(name = "Campocustommaster.findByCodcampocustommaster", query = "SELECT c FROM Campocustommaster c WHERE c.codcampocustommaster = :codcampocustommaster")
    , @NamedQuery(name = "Campocustommaster.findByNomecampocustommaster", query = "SELECT c FROM Campocustommaster c WHERE c.nomecampocustommaster = :nomecampocustommaster")
    , @NamedQuery(name = "Campocustommaster.findByNomeentidade", query = "SELECT c FROM Campocustommaster c WHERE c.nomeentidade = :nomeentidade")
    , @NamedQuery(name = "Campocustommaster.findByNomeidentidade", query = "SELECT c FROM Campocustommaster c WHERE c.nomeidentidade = :nomeidentidade")
    , @NamedQuery(name = "Campocustommaster.findByTamanho", query = "SELECT c FROM Campocustommaster c WHERE c.tamanho = :tamanho")
    , @NamedQuery(name = "Campocustommaster.findByFlagtipocampo", query = "SELECT c FROM Campocustommaster c WHERE c.flagtipocampo = :flagtipocampo")
    , @NamedQuery(name = "Campocustommaster.findByOrdenacao", query = "SELECT c FROM Campocustommaster c WHERE c.ordenacao = :ordenacao")
    , @NamedQuery(name = "Campocustommaster.findByFlagobrigatorio", query = "SELECT c FROM Campocustommaster c WHERE c.flagobrigatorio = :flagobrigatorio")
    , @NamedQuery(name = "Campocustommaster.findByFlaglista", query = "SELECT c FROM Campocustommaster c WHERE c.flaglista = :flaglista")})
public class Campocustommaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCAMPOCUSTOMMASTER")
    private String codcampocustommaster;
    @Column(name = "NOMECAMPOCUSTOMMASTER")
    private String nomecampocustommaster;
    @Column(name = "NOMEENTIDADE")
    private String nomeentidade;
    @Column(name = "NOMEIDENTIDADE")
    private String nomeidentidade;
    @Column(name = "TAMANHO")
    private Integer tamanho;
    @Column(name = "FLAGTIPOCAMPO")
    private Character flagtipocampo;
    @Column(name = "ORDENACAO")
    private Integer ordenacao;
    @Column(name = "FLAGOBRIGATORIO")
    private Character flagobrigatorio;
    @Column(name = "FLAGLISTA")
    private Character flaglista;
    @OneToMany(mappedBy = "codcampocustommaster")
    private Collection<Campocustomvalor> campocustomvalorCollection;
    @OneToMany(mappedBy = "codcampocustommaster")
    private Collection<Campocustomlista> campocustomlistaCollection;

    public Campocustommaster() {
    }

    public Campocustommaster(String codcampocustommaster) {
        this.codcampocustommaster = codcampocustommaster;
    }

    public String getCodcampocustommaster() {
        return codcampocustommaster;
    }

    public void setCodcampocustommaster(String codcampocustommaster) {
        this.codcampocustommaster = codcampocustommaster;
    }

    public String getNomecampocustommaster() {
        return nomecampocustommaster;
    }

    public void setNomecampocustommaster(String nomecampocustommaster) {
        this.nomecampocustommaster = nomecampocustommaster;
    }

    public String getNomeentidade() {
        return nomeentidade;
    }

    public void setNomeentidade(String nomeentidade) {
        this.nomeentidade = nomeentidade;
    }

    public String getNomeidentidade() {
        return nomeidentidade;
    }

    public void setNomeidentidade(String nomeidentidade) {
        this.nomeidentidade = nomeidentidade;
    }

    public Integer getTamanho() {
        return tamanho;
    }

    public void setTamanho(Integer tamanho) {
        this.tamanho = tamanho;
    }

    public Character getFlagtipocampo() {
        return flagtipocampo;
    }

    public void setFlagtipocampo(Character flagtipocampo) {
        this.flagtipocampo = flagtipocampo;
    }

    public Integer getOrdenacao() {
        return ordenacao;
    }

    public void setOrdenacao(Integer ordenacao) {
        this.ordenacao = ordenacao;
    }

    public Character getFlagobrigatorio() {
        return flagobrigatorio;
    }

    public void setFlagobrigatorio(Character flagobrigatorio) {
        this.flagobrigatorio = flagobrigatorio;
    }

    public Character getFlaglista() {
        return flaglista;
    }

    public void setFlaglista(Character flaglista) {
        this.flaglista = flaglista;
    }

    @XmlTransient
    public Collection<Campocustomvalor> getCampocustomvalorCollection() {
        return campocustomvalorCollection;
    }

    public void setCampocustomvalorCollection(Collection<Campocustomvalor> campocustomvalorCollection) {
        this.campocustomvalorCollection = campocustomvalorCollection;
    }

    @XmlTransient
    public Collection<Campocustomlista> getCampocustomlistaCollection() {
        return campocustomlistaCollection;
    }

    public void setCampocustomlistaCollection(Collection<Campocustomlista> campocustomlistaCollection) {
        this.campocustomlistaCollection = campocustomlistaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcampocustommaster != null ? codcampocustommaster.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Campocustommaster)) {
            return false;
        }
        Campocustommaster other = (Campocustommaster) object;
        if ((this.codcampocustommaster == null && other.codcampocustommaster != null) || (this.codcampocustommaster != null && !this.codcampocustommaster.equals(other.codcampocustommaster))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Campocustommaster[ codcampocustommaster=" + codcampocustommaster + " ]";
    }
    
}
