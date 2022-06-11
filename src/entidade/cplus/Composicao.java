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
@Table(name = "COMPOSICAO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Composicao.findAll", query = "SELECT c FROM Composicao c")
    , @NamedQuery(name = "Composicao.findByRefercodprod", query = "SELECT c FROM Composicao c WHERE c.refercodprod = :refercodprod")
    , @NamedQuery(name = "Composicao.findByQuantidade", query = "SELECT c FROM Composicao c WHERE c.quantidade = :quantidade")
    , @NamedQuery(name = "Composicao.findByCodcomposicao", query = "SELECT c FROM Composicao c WHERE c.codcomposicao = :codcomposicao")})
public class Composicao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "REFERCODPROD")
    private String refercodprod;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "QUANTIDADE")
    private BigDecimal quantidade;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCOMPOSICAO")
    private String codcomposicao;
    @JoinColumn(name = "CODPROD", referencedColumnName = "CODPROD")
    @ManyToOne(optional = false)
    private Produto codprod;

    public Composicao() {
    }

    public Composicao(String codcomposicao) {
        this.codcomposicao = codcomposicao;
    }

    public Composicao(String codcomposicao, String refercodprod) {
        this.codcomposicao = codcomposicao;
        this.refercodprod = refercodprod;
    }

    public String getRefercodprod() {
        return refercodprod;
    }

    public void setRefercodprod(String refercodprod) {
        this.refercodprod = refercodprod;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public String getCodcomposicao() {
        return codcomposicao;
    }

    public void setCodcomposicao(String codcomposicao) {
        this.codcomposicao = codcomposicao;
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
        hash += (codcomposicao != null ? codcomposicao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Composicao)) {
            return false;
        }
        Composicao other = (Composicao) object;
        if ((this.codcomposicao == null && other.codcomposicao != null) || (this.codcomposicao != null && !this.codcomposicao.equals(other.codcomposicao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Composicao[ codcomposicao=" + codcomposicao + " ]";
    }
    
}
