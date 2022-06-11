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
@Table(name = "PRODUTOPERIGOSO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produtoperigoso.findAll", query = "SELECT p FROM Produtoperigoso p")
    , @NamedQuery(name = "Produtoperigoso.findByCodprodutoperigoso", query = "SELECT p FROM Produtoperigoso p WHERE p.codprodutoperigoso = :codprodutoperigoso")
    , @NamedQuery(name = "Produtoperigoso.findByCodigo", query = "SELECT p FROM Produtoperigoso p WHERE p.codigo = :codigo")
    , @NamedQuery(name = "Produtoperigoso.findByCodigoonu", query = "SELECT p FROM Produtoperigoso p WHERE p.codigoonu = :codigoonu")
    , @NamedQuery(name = "Produtoperigoso.findByNomeprodembarque", query = "SELECT p FROM Produtoperigoso p WHERE p.nomeprodembarque = :nomeprodembarque")
    , @NamedQuery(name = "Produtoperigoso.findByCodprodperigosoclasse", query = "SELECT p FROM Produtoperigoso p WHERE p.codprodperigosoclasse = :codprodperigosoclasse")
    , @NamedQuery(name = "Produtoperigoso.findByCodgrupoembalagem", query = "SELECT p FROM Produtoperigoso p WHERE p.codgrupoembalagem = :codgrupoembalagem")
    , @NamedQuery(name = "Produtoperigoso.findByNumerorisco", query = "SELECT p FROM Produtoperigoso p WHERE p.numerorisco = :numerorisco")
    , @NamedQuery(name = "Produtoperigoso.findByQtdeveiculo", query = "SELECT p FROM Produtoperigoso p WHERE p.qtdeveiculo = :qtdeveiculo")
    , @NamedQuery(name = "Produtoperigoso.findByQtdeembalageminterna", query = "SELECT p FROM Produtoperigoso p WHERE p.qtdeembalageminterna = :qtdeembalageminterna")})
public class Produtoperigoso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODPRODUTOPERIGOSO")
    private String codprodutoperigoso;
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "CODIGOONU")
    private String codigoonu;
    @Column(name = "NOMEPRODEMBARQUE")
    private String nomeprodembarque;
    @Basic(optional = false)
    @Column(name = "CODPRODPERIGOSOCLASSE")
    private String codprodperigosoclasse;
    @Basic(optional = false)
    @Column(name = "CODGRUPOEMBALAGEM")
    private String codgrupoembalagem;
    @Column(name = "NUMERORISCO")
    private String numerorisco;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "QTDEVEICULO")
    private BigDecimal qtdeveiculo;
    @Column(name = "QTDEEMBALAGEMINTERNA")
    private String qtdeembalageminterna;
    @OneToMany(mappedBy = "codprodutoperigoso")
    private Collection<Produto> produtoCollection;

    public Produtoperigoso() {
    }

    public Produtoperigoso(String codprodutoperigoso) {
        this.codprodutoperigoso = codprodutoperigoso;
    }

    public Produtoperigoso(String codprodutoperigoso, String codprodperigosoclasse, String codgrupoembalagem) {
        this.codprodutoperigoso = codprodutoperigoso;
        this.codprodperigosoclasse = codprodperigosoclasse;
        this.codgrupoembalagem = codgrupoembalagem;
    }

    public String getCodprodutoperigoso() {
        return codprodutoperigoso;
    }

    public void setCodprodutoperigoso(String codprodutoperigoso) {
        this.codprodutoperigoso = codprodutoperigoso;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigoonu() {
        return codigoonu;
    }

    public void setCodigoonu(String codigoonu) {
        this.codigoonu = codigoonu;
    }

    public String getNomeprodembarque() {
        return nomeprodembarque;
    }

    public void setNomeprodembarque(String nomeprodembarque) {
        this.nomeprodembarque = nomeprodembarque;
    }

    public String getCodprodperigosoclasse() {
        return codprodperigosoclasse;
    }

    public void setCodprodperigosoclasse(String codprodperigosoclasse) {
        this.codprodperigosoclasse = codprodperigosoclasse;
    }

    public String getCodgrupoembalagem() {
        return codgrupoembalagem;
    }

    public void setCodgrupoembalagem(String codgrupoembalagem) {
        this.codgrupoembalagem = codgrupoembalagem;
    }

    public String getNumerorisco() {
        return numerorisco;
    }

    public void setNumerorisco(String numerorisco) {
        this.numerorisco = numerorisco;
    }

    public BigDecimal getQtdeveiculo() {
        return qtdeveiculo;
    }

    public void setQtdeveiculo(BigDecimal qtdeveiculo) {
        this.qtdeveiculo = qtdeveiculo;
    }

    public String getQtdeembalageminterna() {
        return qtdeembalageminterna;
    }

    public void setQtdeembalageminterna(String qtdeembalageminterna) {
        this.qtdeembalageminterna = qtdeembalageminterna;
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
        hash += (codprodutoperigoso != null ? codprodutoperigoso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produtoperigoso)) {
            return false;
        }
        Produtoperigoso other = (Produtoperigoso) object;
        if ((this.codprodutoperigoso == null && other.codprodutoperigoso != null) || (this.codprodutoperigoso != null && !this.codprodutoperigoso.equals(other.codprodutoperigoso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Produtoperigoso[ codprodutoperigoso=" + codprodutoperigoso + " ]";
    }
    
}
