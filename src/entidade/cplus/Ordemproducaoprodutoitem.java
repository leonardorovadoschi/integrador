/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ORDEMPRODUCAOPRODUTOITEM", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordemproducaoprodutoitem.findAll", query = "SELECT o FROM Ordemproducaoprodutoitem o")
    , @NamedQuery(name = "Ordemproducaoprodutoitem.findByCodordemproducaoprodutoitem", query = "SELECT o FROM Ordemproducaoprodutoitem o WHERE o.codordemproducaoprodutoitem = :codordemproducaoprodutoitem")
    , @NamedQuery(name = "Ordemproducaoprodutoitem.findByQuantidade", query = "SELECT o FROM Ordemproducaoprodutoitem o WHERE o.quantidade = :quantidade")
    , @NamedQuery(name = "Ordemproducaoprodutoitem.findByVariacao", query = "SELECT o FROM Ordemproducaoprodutoitem o WHERE o.variacao = :variacao")})
public class Ordemproducaoprodutoitem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODORDEMPRODUCAOPRODUTOITEM")
    private String codordemproducaoprodutoitem;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "QUANTIDADE")
    private BigDecimal quantidade;
    @Column(name = "VARIACAO")
    private BigDecimal variacao;
    @JoinColumn(name = "CODORDEMPRODUCAOPRODUTO", referencedColumnName = "CODORDEMPRODUCAOPRODUTO")
    @ManyToOne
    private Ordemproducaoproduto codordemproducaoproduto;
    @JoinColumn(name = "CODPROD", referencedColumnName = "CODPROD")
    @ManyToOne
    private Produto codprod;

    public Ordemproducaoprodutoitem() {
    }

    public Ordemproducaoprodutoitem(String codordemproducaoprodutoitem) {
        this.codordemproducaoprodutoitem = codordemproducaoprodutoitem;
    }

    public String getCodordemproducaoprodutoitem() {
        return codordemproducaoprodutoitem;
    }

    public void setCodordemproducaoprodutoitem(String codordemproducaoprodutoitem) {
        this.codordemproducaoprodutoitem = codordemproducaoprodutoitem;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getVariacao() {
        return variacao;
    }

    public void setVariacao(BigDecimal variacao) {
        this.variacao = variacao;
    }

    public Ordemproducaoproduto getCodordemproducaoproduto() {
        return codordemproducaoproduto;
    }

    public void setCodordemproducaoproduto(Ordemproducaoproduto codordemproducaoproduto) {
        this.codordemproducaoproduto = codordemproducaoproduto;
    }

    public Produto getCodprod() {
        return codprod;
    }

    public void setCodprod(Produto codprod) {
        this.codprod = codprod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codordemproducaoprodutoitem != null ? codordemproducaoprodutoitem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordemproducaoprodutoitem)) {
            return false;
        }
        Ordemproducaoprodutoitem other = (Ordemproducaoprodutoitem) object;
        if ((this.codordemproducaoprodutoitem == null && other.codordemproducaoprodutoitem != null) || (this.codordemproducaoprodutoitem != null && !this.codordemproducaoprodutoitem.equals(other.codordemproducaoprodutoitem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Ordemproducaoprodutoitem[ codordemproducaoprodutoitem=" + codordemproducaoprodutoitem + " ]";
    }
    
}
