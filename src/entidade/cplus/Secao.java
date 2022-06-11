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
@Table(name = "SECAO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Secao.findAll", query = "SELECT s FROM Secao s")
    , @NamedQuery(name = "Secao.findByNomesecao", query = "SELECT s FROM Secao s WHERE s.nomesecao = :nomesecao")
    , @NamedQuery(name = "Secao.findByCodigo", query = "SELECT s FROM Secao s WHERE s.codigo = :codigo")
    , @NamedQuery(name = "Secao.findByCodsec", query = "SELECT s FROM Secao s WHERE s.codsec = :codsec")
    , @NamedQuery(name = "Secao.findByComissao", query = "SELECT s FROM Secao s WHERE s.comissao = :comissao")
    , @NamedQuery(name = "Secao.findByClassificacao", query = "SELECT s FROM Secao s WHERE s.classificacao = :classificacao")
    , @NamedQuery(name = "Secao.findByTipo", query = "SELECT s FROM Secao s WHERE s.tipo = :tipo")
    , @NamedQuery(name = "Secao.findByDescontomaximo", query = "SELECT s FROM Secao s WHERE s.descontomaximo = :descontomaximo")
    , @NamedQuery(name = "Secao.findByMargemlucro", query = "SELECT s FROM Secao s WHERE s.margemlucro = :margemlucro")
    , @NamedQuery(name = "Secao.findByDescontomaximousuario", query = "SELECT s FROM Secao s WHERE s.descontomaximousuario = :descontomaximousuario")
    , @NamedQuery(name = "Secao.findByGuid", query = "SELECT s FROM Secao s WHERE s.guid = :guid")})
public class Secao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "NOMESECAO")
    private String nomesecao;
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private String codigo;
    @Id
    @Basic(optional = false)
    @Column(name = "CODSEC")
    private String codsec;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "COMISSAO")
    private BigDecimal comissao;
    @Column(name = "CLASSIFICACAO")
    private String classificacao;
    @Column(name = "TIPO")
    private Character tipo;
    @Column(name = "DESCONTOMAXIMO")
    private BigDecimal descontomaximo;
    @Column(name = "MARGEMLUCRO")
    private BigDecimal margemlucro;
    @Column(name = "DESCONTOMAXIMOUSUARIO")
    private BigDecimal descontomaximousuario;
    @Column(name = "GUID")
    private String guid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codsec")
    private Collection<Vendedorsecao> vendedorsecaoCollection;
    @OneToMany(mappedBy = "codsec")
    private Collection<Produto> produtoCollection;

    public Secao() {
    }

    public Secao(String codsec) {
        this.codsec = codsec;
    }

    public Secao(String codsec, String nomesecao, String codigo) {
        this.codsec = codsec;
        this.nomesecao = nomesecao;
        this.codigo = codigo;
    }

    public String getNomesecao() {
        return nomesecao;
    }

    public void setNomesecao(String nomesecao) {
        this.nomesecao = nomesecao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodsec() {
        return codsec;
    }

    public void setCodsec(String codsec) {
        this.codsec = codsec;
    }

    public BigDecimal getComissao() {
        return comissao;
    }

    public void setComissao(BigDecimal comissao) {
        this.comissao = comissao;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getDescontomaximo() {
        return descontomaximo;
    }

    public void setDescontomaximo(BigDecimal descontomaximo) {
        this.descontomaximo = descontomaximo;
    }

    public BigDecimal getMargemlucro() {
        return margemlucro;
    }

    public void setMargemlucro(BigDecimal margemlucro) {
        this.margemlucro = margemlucro;
    }

    public BigDecimal getDescontomaximousuario() {
        return descontomaximousuario;
    }

    public void setDescontomaximousuario(BigDecimal descontomaximousuario) {
        this.descontomaximousuario = descontomaximousuario;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    @XmlTransient
    public Collection<Vendedorsecao> getVendedorsecaoCollection() {
        return vendedorsecaoCollection;
    }

    public void setVendedorsecaoCollection(Collection<Vendedorsecao> vendedorsecaoCollection) {
        this.vendedorsecaoCollection = vendedorsecaoCollection;
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
        hash += (codsec != null ? codsec.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Secao)) {
            return false;
        }
        Secao other = (Secao) object;
        if ((this.codsec == null && other.codsec != null) || (this.codsec != null && !this.codsec.equals(other.codsec))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Secao[ codsec=" + codsec + " ]";
    }
    
}
