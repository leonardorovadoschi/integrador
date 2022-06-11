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
import javax.persistence.Table;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ORCAMENTOPRODLOTE", catalog = "", schema = "")

public class Orcamentoprodlote implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODORCAMENTOPRODLOTE")
    private String codorcamentoprodlote;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "QUANTIDADE")
    private BigDecimal quantidade;
    @JoinColumn(name = "CODORCPROD", referencedColumnName = "CODORCPROD")
    @ManyToOne(optional = false)
    private Orcamentoprod codorcprod;
    @JoinColumn(name = "CODPRODUTOLOTE", referencedColumnName = "CODPRODUTOLOTE")
    @ManyToOne(optional = false)
    private Produtolote codprodutolote;

    public Orcamentoprodlote() {
    }

    public Orcamentoprodlote(String codorcamentoprodlote) {
        this.codorcamentoprodlote = codorcamentoprodlote;
    }

    public String getCodorcamentoprodlote() {
        return codorcamentoprodlote;
    }

    public void setCodorcamentoprodlote(String codorcamentoprodlote) {
        this.codorcamentoprodlote = codorcamentoprodlote;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public Orcamentoprod getCodorcprod() {
        return codorcprod;
    }

    public void setCodorcprod(Orcamentoprod codorcprod) {
        this.codorcprod = codorcprod;
    }

    public Produtolote getCodprodutolote() {
        return codprodutolote;
    }

    public void setCodprodutolote(Produtolote codprodutolote) {
        this.codprodutolote = codprodutolote;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codorcamentoprodlote != null ? codorcamentoprodlote.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orcamentoprodlote)) {
            return false;
        }
        Orcamentoprodlote other = (Orcamentoprodlote) object;
        if ((this.codorcamentoprodlote == null && other.codorcamentoprodlote != null) || (this.codorcamentoprodlote != null && !this.codorcamentoprodlote.equals(other.codorcamentoprodlote))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Orcamentoprodlote[ codorcamentoprodlote=" + codorcamentoprodlote + " ]";
    }
    
}
