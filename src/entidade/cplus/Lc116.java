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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "LC116", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lc116.findAll", query = "SELECT l FROM Lc116 l")
    , @NamedQuery(name = "Lc116.findByCodlc116", query = "SELECT l FROM Lc116 l WHERE l.codlc116 = :codlc116")
    , @NamedQuery(name = "Lc116.findByCodigolistaservico", query = "SELECT l FROM Lc116 l WHERE l.codigolistaservico = :codigolistaservico")
    , @NamedQuery(name = "Lc116.findByDescricao", query = "SELECT l FROM Lc116 l WHERE l.descricao = :descricao")
    , @NamedQuery(name = "Lc116.findByAliqnac", query = "SELECT l FROM Lc116 l WHERE l.aliqnac = :aliqnac")
    , @NamedQuery(name = "Lc116.findByAliqimp", query = "SELECT l FROM Lc116 l WHERE l.aliqimp = :aliqimp")})
public class Lc116 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODLC116")
    private String codlc116;
    @Column(name = "CODIGOLISTASERVICO")
    private String codigolistaservico;
    @Column(name = "DESCRICAO")
    private String descricao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ALIQNAC")
    private BigDecimal aliqnac;
    @Column(name = "ALIQIMP")
    private BigDecimal aliqimp;

    public Lc116() {
    }

    public Lc116(String codlc116) {
        this.codlc116 = codlc116;
    }

    public String getCodlc116() {
        return codlc116;
    }

    public void setCodlc116(String codlc116) {
        this.codlc116 = codlc116;
    }

    public String getCodigolistaservico() {
        return codigolistaservico;
    }

    public void setCodigolistaservico(String codigolistaservico) {
        this.codigolistaservico = codigolistaservico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getAliqnac() {
        return aliqnac;
    }

    public void setAliqnac(BigDecimal aliqnac) {
        this.aliqnac = aliqnac;
    }

    public BigDecimal getAliqimp() {
        return aliqimp;
    }

    public void setAliqimp(BigDecimal aliqimp) {
        this.aliqimp = aliqimp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codlc116 != null ? codlc116.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lc116)) {
            return false;
        }
        Lc116 other = (Lc116) object;
        if ((this.codlc116 == null && other.codlc116 != null) || (this.codlc116 != null && !this.codlc116.equals(other.codlc116))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Lc116[ codlc116=" + codlc116 + " ]";
    }
    
}
