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
@Table(name = "MOVENDAPRODLOTE", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movendaprodlote.findAll", query = "SELECT m FROM Movendaprodlote m")
    , @NamedQuery(name = "Movendaprodlote.findByCodmovendaprodlote", query = "SELECT m FROM Movendaprodlote m WHERE m.codmovendaprodlote = :codmovendaprodlote")
    , @NamedQuery(name = "Movendaprodlote.findByQuantidade", query = "SELECT m FROM Movendaprodlote m WHERE m.quantidade = :quantidade")
    , @NamedQuery(name = "Movendaprodlote.findByGuid", query = "SELECT m FROM Movendaprodlote m WHERE m.guid = :guid")
    , @NamedQuery(name = "Movendaprodlote.findByQuantidadedevolvida", query = "SELECT m FROM Movendaprodlote m WHERE m.quantidadedevolvida = :quantidadedevolvida")})
public class Movendaprodlote implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODMOVENDAPRODLOTE")
    private String codmovendaprodlote;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "QUANTIDADE")
    private BigDecimal quantidade;
    @Column(name = "GUID")
    private String guid;
    @Column(name = "QUANTIDADEDEVOLVIDA")
    private BigDecimal quantidadedevolvida;
    @JoinColumn(name = "CODMOVPROD", referencedColumnName = "CODMOVPROD")
    @ManyToOne(optional = false)
    private Movendaprod codmovprod;
    @JoinColumn(name = "CODPRODUTOLOTE", referencedColumnName = "CODPRODUTOLOTE")
    @ManyToOne(optional = false)
    private Produtolote codprodutolote;

    public Movendaprodlote() {
    }

    public Movendaprodlote(String codmovendaprodlote) {
        this.codmovendaprodlote = codmovendaprodlote;
    }

    public String getCodmovendaprodlote() {
        return codmovendaprodlote;
    }

    public void setCodmovendaprodlote(String codmovendaprodlote) {
        this.codmovendaprodlote = codmovendaprodlote;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public BigDecimal getQuantidadedevolvida() {
        return quantidadedevolvida;
    }

    public void setQuantidadedevolvida(BigDecimal quantidadedevolvida) {
        this.quantidadedevolvida = quantidadedevolvida;
    }

    public Movendaprod getCodmovprod() {
        return codmovprod;
    }

    public void setCodmovprod(Movendaprod codmovprod) {
        this.codmovprod = codmovprod;
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
        hash += (codmovendaprodlote != null ? codmovendaprodlote.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movendaprodlote)) {
            return false;
        }
        Movendaprodlote other = (Movendaprodlote) object;
        if ((this.codmovendaprodlote == null && other.codmovendaprodlote != null) || (this.codmovendaprodlote != null && !this.codmovendaprodlote.equals(other.codmovendaprodlote))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Movendaprodlote[ codmovendaprodlote=" + codmovendaprodlote + " ]";
    }
    
}
