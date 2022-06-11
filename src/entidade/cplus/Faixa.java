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
@Table(name = "FAIXA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Faixa.findAll", query = "SELECT f FROM Faixa f")
    , @NamedQuery(name = "Faixa.findByCodfaixa", query = "SELECT f FROM Faixa f WHERE f.codfaixa = :codfaixa")
    , @NamedQuery(name = "Faixa.findByValorinicial", query = "SELECT f FROM Faixa f WHERE f.valorinicial = :valorinicial")
    , @NamedQuery(name = "Faixa.findByValorfinal", query = "SELECT f FROM Faixa f WHERE f.valorfinal = :valorfinal")})
public class Faixa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODFAIXA")
    private String codfaixa;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "VALORINICIAL")
    private BigDecimal valorinicial;
    @Basic(optional = false)
    @Column(name = "VALORFINAL")
    private BigDecimal valorfinal;

    public Faixa() {
    }

    public Faixa(String codfaixa) {
        this.codfaixa = codfaixa;
    }

    public Faixa(String codfaixa, BigDecimal valorinicial, BigDecimal valorfinal) {
        this.codfaixa = codfaixa;
        this.valorinicial = valorinicial;
        this.valorfinal = valorfinal;
    }

    public String getCodfaixa() {
        return codfaixa;
    }

    public void setCodfaixa(String codfaixa) {
        this.codfaixa = codfaixa;
    }

    public BigDecimal getValorinicial() {
        return valorinicial;
    }

    public void setValorinicial(BigDecimal valorinicial) {
        this.valorinicial = valorinicial;
    }

    public BigDecimal getValorfinal() {
        return valorfinal;
    }

    public void setValorfinal(BigDecimal valorfinal) {
        this.valorfinal = valorfinal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codfaixa != null ? codfaixa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Faixa)) {
            return false;
        }
        Faixa other = (Faixa) object;
        if ((this.codfaixa == null && other.codfaixa != null) || (this.codfaixa != null && !this.codfaixa.equals(other.codfaixa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Faixa[ codfaixa=" + codfaixa + " ]";
    }
    
}
