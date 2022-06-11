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
@Table(name = "ITEMPED", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Itemped.findAll", query = "SELECT i FROM Itemped i")
    , @NamedQuery(name = "Itemped.findByTotreceb", query = "SELECT i FROM Itemped i WHERE i.totreceb = :totreceb")
    , @NamedQuery(name = "Itemped.findByReceb", query = "SELECT i FROM Itemped i WHERE i.receb = :receb")
    , @NamedQuery(name = "Itemped.findByVlunitario", query = "SELECT i FROM Itemped i WHERE i.vlunitario = :vlunitario")
    , @NamedQuery(name = "Itemped.findByQuantidade", query = "SELECT i FROM Itemped i WHERE i.quantidade = :quantidade")
    , @NamedQuery(name = "Itemped.findByCoditemped", query = "SELECT i FROM Itemped i WHERE i.coditemped = :coditemped")
    , @NamedQuery(name = "Itemped.findByIpi", query = "SELECT i FROM Itemped i WHERE i.ipi = :ipi")
    , @NamedQuery(name = "Itemped.findByCodmoeda", query = "SELECT i FROM Itemped i WHERE i.codmoeda = :codmoeda")
    , @NamedQuery(name = "Itemped.findByEncargos", query = "SELECT i FROM Itemped i WHERE i.encargos = :encargos")
    , @NamedQuery(name = "Itemped.findByIcms", query = "SELECT i FROM Itemped i WHERE i.icms = :icms")})
public class Itemped implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TOTRECEB")
    private BigDecimal totreceb;
    @Column(name = "RECEB")
    private BigDecimal receb;
    @Column(name = "VLUNITARIO")
    private BigDecimal vlunitario;
    @Column(name = "QUANTIDADE")
    private BigDecimal quantidade;
    @Id
    @Basic(optional = false)
    @Column(name = "CODITEMPED")
    private String coditemped;
    @Column(name = "IPI")
    private BigDecimal ipi;
    @Column(name = "CODMOEDA")
    private String codmoeda;
    @Column(name = "ENCARGOS")
    private BigDecimal encargos;
    @Column(name = "ICMS")
    private BigDecimal icms;
    @JoinColumn(name = "CODPED", referencedColumnName = "CODPED")
    @ManyToOne(optional = false)
    private Pedido codped;
    @JoinColumn(name = "CODPROD", referencedColumnName = "CODPROD")
    @ManyToOne(optional = false)
    private Produto codprod;

    public Itemped() {
    }

    public Itemped(String coditemped) {
        this.coditemped = coditemped;
    }

    public BigDecimal getTotreceb() {
        return totreceb;
    }

    public void setTotreceb(BigDecimal totreceb) {
        this.totreceb = totreceb;
    }

    public BigDecimal getReceb() {
        return receb;
    }

    public void setReceb(BigDecimal receb) {
        this.receb = receb;
    }

    public BigDecimal getVlunitario() {
        return vlunitario;
    }

    public void setVlunitario(BigDecimal vlunitario) {
        this.vlunitario = vlunitario;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public String getCoditemped() {
        return coditemped;
    }

    public void setCoditemped(String coditemped) {
        this.coditemped = coditemped;
    }

    public BigDecimal getIpi() {
        return ipi;
    }

    public void setIpi(BigDecimal ipi) {
        this.ipi = ipi;
    }

    public String getCodmoeda() {
        return codmoeda;
    }

    public void setCodmoeda(String codmoeda) {
        this.codmoeda = codmoeda;
    }

    public BigDecimal getEncargos() {
        return encargos;
    }

    public void setEncargos(BigDecimal encargos) {
        this.encargos = encargos;
    }

    public BigDecimal getIcms() {
        return icms;
    }

    public void setIcms(BigDecimal icms) {
        this.icms = icms;
    }

    public Pedido getCodped() {
        return codped;
    }

    public void setCodped(Pedido codped) {
        this.codped = codped;
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
        hash += (coditemped != null ? coditemped.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Itemped)) {
            return false;
        }
        Itemped other = (Itemped) object;
        if ((this.coditemped == null && other.coditemped != null) || (this.coditemped != null && !this.coditemped.equals(other.coditemped))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Itemped[ coditemped=" + coditemped + " ]";
    }
    
}
