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
@Table(name = "MOVENTRADAPRODLOTE", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Moventradaprodlote.findAll", query = "SELECT m FROM Moventradaprodlote m")
    , @NamedQuery(name = "Moventradaprodlote.findByCodmoventradaprodlote", query = "SELECT m FROM Moventradaprodlote m WHERE m.codmoventradaprodlote = :codmoventradaprodlote")
    , @NamedQuery(name = "Moventradaprodlote.findByQuantidade", query = "SELECT m FROM Moventradaprodlote m WHERE m.quantidade = :quantidade")
    , @NamedQuery(name = "Moventradaprodlote.findByGuid", query = "SELECT m FROM Moventradaprodlote m WHERE m.guid = :guid")})
public class Moventradaprodlote implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODMOVENTRADAPRODLOTE")
    private String codmoventradaprodlote;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "QUANTIDADE")
    private BigDecimal quantidade;
    @Column(name = "GUID")
    private String guid;
    @JoinColumn(name = "CODMOVEPROD", referencedColumnName = "CODMOVEPROD")
    @ManyToOne(optional = false)
    private Moventradaprod codmoveprod;
    @JoinColumn(name = "CODPRODUTOLOTE", referencedColumnName = "CODPRODUTOLOTE")
    @ManyToOne(optional = false)
    private Produtolote codprodutolote;

    public Moventradaprodlote() {
    }

    public Moventradaprodlote(String codmoventradaprodlote) {
        this.codmoventradaprodlote = codmoventradaprodlote;
    }

    public String getCodmoventradaprodlote() {
        return codmoventradaprodlote;
    }

    public void setCodmoventradaprodlote(String codmoventradaprodlote) {
        this.codmoventradaprodlote = codmoventradaprodlote;
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

    public Moventradaprod getCodmoveprod() {
        return codmoveprod;
    }

    public void setCodmoveprod(Moventradaprod codmoveprod) {
        this.codmoveprod = codmoveprod;
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
        hash += (codmoventradaprodlote != null ? codmoventradaprodlote.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Moventradaprodlote)) {
            return false;
        }
        Moventradaprodlote other = (Moventradaprodlote) object;
        if ((this.codmoventradaprodlote == null && other.codmoventradaprodlote != null) || (this.codmoventradaprodlote != null && !this.codmoventradaprodlote.equals(other.codmoventradaprodlote))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Moventradaprodlote[ codmoventradaprodlote=" + codmoventradaprodlote + " ]";
    }
    
}
