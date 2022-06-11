/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "UNIDADE", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Unidade.findAll", query = "SELECT u FROM Unidade u")
    , @NamedQuery(name = "Unidade.findByCodunidade", query = "SELECT u FROM Unidade u WHERE u.codunidade = :codunidade")
    , @NamedQuery(name = "Unidade.findByCodigo", query = "SELECT u FROM Unidade u WHERE u.codigo = :codigo")
    , @NamedQuery(name = "Unidade.findByUnidade", query = "SELECT u FROM Unidade u WHERE u.unidade = :unidade")
    , @NamedQuery(name = "Unidade.findByFlagquantidadeunitaria", query = "SELECT u FROM Unidade u WHERE u.flagquantidadeunitaria = :flagquantidadeunitaria")
    , @NamedQuery(name = "Unidade.findByFatorconversao", query = "SELECT u FROM Unidade u WHERE u.fatorconversao = :fatorconversao")
    , @NamedQuery(name = "Unidade.findByGuid", query = "SELECT u FROM Unidade u WHERE u.guid = :guid")})
public class Unidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODUNIDADE")
    private String codunidade;
    @Column(name = "CODIGO")
    private String codigo;
    @Basic(optional = false)
    @Column(name = "UNIDADE")
    private String unidade;
    @Column(name = "FLAGQUANTIDADEUNITARIA")
    private Character flagquantidadeunitaria;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "FATORCONVERSAO")
    private BigDecimal fatorconversao;
    @Column(name = "GUID")
    private String guid;
    @OneToMany(mappedBy = "codunidade")
    private Collection<Classificacaofiscal> classificacaofiscalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codunidade")
    private Collection<Gtintributavel> gtintributavelCollection;
    @OneToMany(mappedBy = "codunidade")
    private Collection<Produto> produtoCollection;

    public Unidade() {
    }

    public Unidade(String codunidade) {
        this.codunidade = codunidade;
    }

    public Unidade(String codunidade, String unidade) {
        this.codunidade = codunidade;
        this.unidade = unidade;
    }

    public String getCodunidade() {
        return codunidade;
    }

    public void setCodunidade(String codunidade) {
        this.codunidade = codunidade;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public Character getFlagquantidadeunitaria() {
        return flagquantidadeunitaria;
    }

    public void setFlagquantidadeunitaria(Character flagquantidadeunitaria) {
        this.flagquantidadeunitaria = flagquantidadeunitaria;
    }

    public BigDecimal getFatorconversao() {
        return fatorconversao;
    }

    public void setFatorconversao(BigDecimal fatorconversao) {
        this.fatorconversao = fatorconversao;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    @XmlTransient
    public Collection<Classificacaofiscal> getClassificacaofiscalCollection() {
        return classificacaofiscalCollection;
    }

    public void setClassificacaofiscalCollection(Collection<Classificacaofiscal> classificacaofiscalCollection) {
        this.classificacaofiscalCollection = classificacaofiscalCollection;
    }

    @XmlTransient
    public Collection<Gtintributavel> getGtintributavelCollection() {
        return gtintributavelCollection;
    }

    public void setGtintributavelCollection(Collection<Gtintributavel> gtintributavelCollection) {
        this.gtintributavelCollection = gtintributavelCollection;
    }

    @XmlTransient
    public Collection<Produto> getProdutoCollection() {
        return produtoCollection;
    }

    public void setProdutoCollection(Collection<Produto> produtoCollection) {
        this.produtoCollection = produtoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codunidade != null ? codunidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unidade)) {
            return false;
        }
        Unidade other = (Unidade) object;
        if ((this.codunidade == null && other.codunidade != null) || (this.codunidade != null && !this.codunidade.equals(other.codunidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Unidade[ codunidade=" + codunidade + " ]";
    }
    
}
