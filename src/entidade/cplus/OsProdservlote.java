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
@Table(name = "OS_PRODSERVLOTE", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OsProdservlote.findAll", query = "SELECT o FROM OsProdservlote o")
    , @NamedQuery(name = "OsProdservlote.findByCodprodservlote", query = "SELECT o FROM OsProdservlote o WHERE o.codprodservlote = :codprodservlote")
    , @NamedQuery(name = "OsProdservlote.findByQuantidade", query = "SELECT o FROM OsProdservlote o WHERE o.quantidade = :quantidade")})
public class OsProdservlote implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODPRODSERVLOTE")
    private String codprodservlote;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "QUANTIDADE")
    private BigDecimal quantidade;
    @JoinColumn(name = "CODPRODSERV", referencedColumnName = "CODPRODSERV")
    @ManyToOne(optional = false)
    private OsProdserv codprodserv;
    @JoinColumn(name = "CODPRODUTOLOTE", referencedColumnName = "CODPRODUTOLOTE")
    @ManyToOne(optional = false)
    private Produtolote codprodutolote;

    public OsProdservlote() {
    }

    public OsProdservlote(String codprodservlote) {
        this.codprodservlote = codprodservlote;
    }

    public String getCodprodservlote() {
        return codprodservlote;
    }

    public void setCodprodservlote(String codprodservlote) {
        this.codprodservlote = codprodservlote;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public OsProdserv getCodprodserv() {
        return codprodserv;
    }

    public void setCodprodserv(OsProdserv codprodserv) {
        this.codprodserv = codprodserv;
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
        hash += (codprodservlote != null ? codprodservlote.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OsProdservlote)) {
            return false;
        }
        OsProdservlote other = (OsProdservlote) object;
        if ((this.codprodservlote == null && other.codprodservlote != null) || (this.codprodservlote != null && !this.codprodservlote.equals(other.codprodservlote))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.OsProdservlote[ codprodservlote=" + codprodservlote + " ]";
    }
    
}
