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
@Table(name = "PRODUTOANP", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produtoanp.findAll", query = "SELECT p FROM Produtoanp p")
    , @NamedQuery(name = "Produtoanp.findByCodprodutoanp", query = "SELECT p FROM Produtoanp p WHERE p.codprodutoanp = :codprodutoanp")
    , @NamedQuery(name = "Produtoanp.findByCodigo", query = "SELECT p FROM Produtoanp p WHERE p.codigo = :codigo")
    , @NamedQuery(name = "Produtoanp.findByDescricao", query = "SELECT p FROM Produtoanp p WHERE p.descricao = :descricao")
    , @NamedQuery(name = "Produtoanp.findByAliqglp", query = "SELECT p FROM Produtoanp p WHERE p.aliqglp = :aliqglp")
    , @NamedQuery(name = "Produtoanp.findByAliqgnn", query = "SELECT p FROM Produtoanp p WHERE p.aliqgnn = :aliqgnn")
    , @NamedQuery(name = "Produtoanp.findByAliqgni", query = "SELECT p FROM Produtoanp p WHERE p.aliqgni = :aliqgni")
    , @NamedQuery(name = "Produtoanp.findByValorpartida", query = "SELECT p FROM Produtoanp p WHERE p.valorpartida = :valorpartida")})
public class Produtoanp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODPRODUTOANP")
    private String codprodutoanp;
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private String codigo;
    @Basic(optional = false)
    @Column(name = "DESCRICAO")
    private String descricao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ALIQGLP")
    private BigDecimal aliqglp;
    @Column(name = "ALIQGNN")
    private BigDecimal aliqgnn;
    @Column(name = "ALIQGNI")
    private BigDecimal aliqgni;
    @Column(name = "VALORPARTIDA")
    private BigDecimal valorpartida;
    @OneToMany(mappedBy = "codprodutoanp")
    private Collection<Produto> produtoCollection;

    public Produtoanp() {
    }

    public Produtoanp(String codprodutoanp) {
        this.codprodutoanp = codprodutoanp;
    }

    public Produtoanp(String codprodutoanp, String codigo, String descricao) {
        this.codprodutoanp = codprodutoanp;
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodprodutoanp() {
        return codprodutoanp;
    }

    public void setCodprodutoanp(String codprodutoanp) {
        this.codprodutoanp = codprodutoanp;
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

    public BigDecimal getAliqglp() {
        return aliqglp;
    }

    public void setAliqglp(BigDecimal aliqglp) {
        this.aliqglp = aliqglp;
    }

    public BigDecimal getAliqgnn() {
        return aliqgnn;
    }

    public void setAliqgnn(BigDecimal aliqgnn) {
        this.aliqgnn = aliqgnn;
    }

    public BigDecimal getAliqgni() {
        return aliqgni;
    }

    public void setAliqgni(BigDecimal aliqgni) {
        this.aliqgni = aliqgni;
    }

    public BigDecimal getValorpartida() {
        return valorpartida;
    }

    public void setValorpartida(BigDecimal valorpartida) {
        this.valorpartida = valorpartida;
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
        hash += (codprodutoanp != null ? codprodutoanp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produtoanp)) {
            return false;
        }
        Produtoanp other = (Produtoanp) object;
        if ((this.codprodutoanp == null && other.codprodutoanp != null) || (this.codprodutoanp != null && !this.codprodutoanp.equals(other.codprodutoanp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Produtoanp[ codprodutoanp=" + codprodutoanp + " ]";
    }
    
}
