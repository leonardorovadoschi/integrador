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
import javax.persistence.Lob;
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
@Table(name = "ORDEMCOLETAPROD", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordemcoletaprod.findAll", query = "SELECT o FROM Ordemcoletaprod o")
    , @NamedQuery(name = "Ordemcoletaprod.findByCodordcoletaprod", query = "SELECT o FROM Ordemcoletaprod o WHERE o.codordcoletaprod = :codordcoletaprod")
    , @NamedQuery(name = "Ordemcoletaprod.findByCodprod", query = "SELECT o FROM Ordemcoletaprod o WHERE o.codprod = :codprod")
    , @NamedQuery(name = "Ordemcoletaprod.findByQuantidade", query = "SELECT o FROM Ordemcoletaprod o WHERE o.quantidade = :quantidade")
    , @NamedQuery(name = "Ordemcoletaprod.findByQuantidadeconf", query = "SELECT o FROM Ordemcoletaprod o WHERE o.quantidadeconf = :quantidadeconf")
    , @NamedQuery(name = "Ordemcoletaprod.findByDivergencia", query = "SELECT o FROM Ordemcoletaprod o WHERE o.divergencia = :divergencia")
    , @NamedQuery(name = "Ordemcoletaprod.findByNumped", query = "SELECT o FROM Ordemcoletaprod o WHERE o.numped = :numped")
    , @NamedQuery(name = "Ordemcoletaprod.findByGuid", query = "SELECT o FROM Ordemcoletaprod o WHERE o.guid = :guid")})
public class Ordemcoletaprod implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODORDCOLETAPROD")
    private String codordcoletaprod;
    @Basic(optional = false)
    @Column(name = "CODPROD")
    private String codprod;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "QUANTIDADE")
    private BigDecimal quantidade;
    @Column(name = "QUANTIDADECONF")
    private BigDecimal quantidadeconf;
    @Column(name = "DIVERGENCIA")
    private BigDecimal divergencia;
    @Lob
    @Column(name = "COMPLEMENTO")
    private String complemento;
    @Column(name = "NUMPED")
    private Integer numped;
    @Basic(optional = false)
    @Column(name = "GUID")
    private String guid;
    @JoinColumn(name = "CODORDCOLETA", referencedColumnName = "CODORDCOLETA")
    @ManyToOne(optional = false)
    private Ordemcoleta codordcoleta;

    public Ordemcoletaprod() {
    }

    public Ordemcoletaprod(String codordcoletaprod) {
        this.codordcoletaprod = codordcoletaprod;
    }

    public Ordemcoletaprod(String codordcoletaprod, String codprod, String guid) {
        this.codordcoletaprod = codordcoletaprod;
        this.codprod = codprod;
        this.guid = guid;
    }

    public String getCodordcoletaprod() {
        return codordcoletaprod;
    }

    public void setCodordcoletaprod(String codordcoletaprod) {
        this.codordcoletaprod = codordcoletaprod;
    }

    public String getCodprod() {
        return codprod;
    }

    public void setCodprod(String codprod) {
        this.codprod = codprod;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getQuantidadeconf() {
        return quantidadeconf;
    }

    public void setQuantidadeconf(BigDecimal quantidadeconf) {
        this.quantidadeconf = quantidadeconf;
    }

    public BigDecimal getDivergencia() {
        return divergencia;
    }

    public void setDivergencia(BigDecimal divergencia) {
        this.divergencia = divergencia;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Integer getNumped() {
        return numped;
    }

    public void setNumped(Integer numped) {
        this.numped = numped;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Ordemcoleta getCodordcoleta() {
        return codordcoleta;
    }

    public void setCodordcoleta(Ordemcoleta codordcoleta) {
        this.codordcoleta = codordcoleta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codordcoletaprod != null ? codordcoletaprod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordemcoletaprod)) {
            return false;
        }
        Ordemcoletaprod other = (Ordemcoletaprod) object;
        if ((this.codordcoletaprod == null && other.codordcoletaprod != null) || (this.codordcoletaprod != null && !this.codordcoletaprod.equals(other.codordcoletaprod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Ordemcoletaprod[ codordcoletaprod=" + codordcoletaprod + " ]";
    }
    
}
