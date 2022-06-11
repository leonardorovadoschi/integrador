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
@Table(name = "REAJUSTEPRODUTOPRECO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reajusteprodutopreco.findAll", query = "SELECT r FROM Reajusteprodutopreco r")
    , @NamedQuery(name = "Reajusteprodutopreco.findByCodreajusteprodutopreco", query = "SELECT r FROM Reajusteprodutopreco r WHERE r.codreajusteprodutopreco = :codreajusteprodutopreco")
    , @NamedQuery(name = "Reajusteprodutopreco.findByMargem", query = "SELECT r FROM Reajusteprodutopreco r WHERE r.margem = :margem")
    , @NamedQuery(name = "Reajusteprodutopreco.findByPreco", query = "SELECT r FROM Reajusteprodutopreco r WHERE r.preco = :preco")
    , @NamedQuery(name = "Reajusteprodutopreco.findByMargempadrao", query = "SELECT r FROM Reajusteprodutopreco r WHERE r.margempadrao = :margempadrao")
    , @NamedQuery(name = "Reajusteprodutopreco.findByCoduf", query = "SELECT r FROM Reajusteprodutopreco r WHERE r.coduf = :coduf")
    , @NamedQuery(name = "Reajusteprodutopreco.findByFlagprodutoprecoexpafv", query = "SELECT r FROM Reajusteprodutopreco r WHERE r.flagprodutoprecoexpafv = :flagprodutoprecoexpafv")})
public class Reajusteprodutopreco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODREAJUSTEPRODUTOPRECO")
    private Integer codreajusteprodutopreco;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MARGEM")
    private BigDecimal margem;
    @Column(name = "PRECO")
    private BigDecimal preco;
    @Column(name = "MARGEMPADRAO")
    private BigDecimal margempadrao;
    @Column(name = "CODUF")
    private String coduf;
    @Column(name = "FLAGPRODUTOPRECOEXPAFV")
    private Character flagprodutoprecoexpafv;
    @JoinColumn(name = "CODPRECO", referencedColumnName = "CODPRECO")
    @ManyToOne
    private Preco codpreco;
    @JoinColumn(name = "CODREAJUSTEPRODUTO", referencedColumnName = "CODREAJUSTEPRODUTO")
    @ManyToOne
    private Reajusteproduto codreajusteproduto;

    public Reajusteprodutopreco() {
    }

    public Reajusteprodutopreco(Integer codreajusteprodutopreco) {
        this.codreajusteprodutopreco = codreajusteprodutopreco;
    }

    public Integer getCodreajusteprodutopreco() {
        return codreajusteprodutopreco;
    }

    public void setCodreajusteprodutopreco(Integer codreajusteprodutopreco) {
        this.codreajusteprodutopreco = codreajusteprodutopreco;
    }

    public BigDecimal getMargem() {
        return margem;
    }

    public void setMargem(BigDecimal margem) {
        this.margem = margem;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public BigDecimal getMargempadrao() {
        return margempadrao;
    }

    public void setMargempadrao(BigDecimal margempadrao) {
        this.margempadrao = margempadrao;
    }

    public String getCoduf() {
        return coduf;
    }

    public void setCoduf(String coduf) {
        this.coduf = coduf;
    }

    public Character getFlagprodutoprecoexpafv() {
        return flagprodutoprecoexpafv;
    }

    public void setFlagprodutoprecoexpafv(Character flagprodutoprecoexpafv) {
        this.flagprodutoprecoexpafv = flagprodutoprecoexpafv;
    }

    public Preco getCodpreco() {
        return codpreco;
    }

    public void setCodpreco(Preco codpreco) {
        this.codpreco = codpreco;
    }

    public Reajusteproduto getCodreajusteproduto() {
        return codreajusteproduto;
    }

    public void setCodreajusteproduto(Reajusteproduto codreajusteproduto) {
        this.codreajusteproduto = codreajusteproduto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codreajusteprodutopreco != null ? codreajusteprodutopreco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reajusteprodutopreco)) {
            return false;
        }
        Reajusteprodutopreco other = (Reajusteprodutopreco) object;
        if ((this.codreajusteprodutopreco == null && other.codreajusteprodutopreco != null) || (this.codreajusteprodutopreco != null && !this.codreajusteprodutopreco.equals(other.codreajusteprodutopreco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Reajusteprodutopreco[ codreajusteprodutopreco=" + codreajusteprodutopreco + " ]";
    }
    
}
