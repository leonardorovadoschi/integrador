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
@Table(name = "ORCAMENTOPRODSERIAL", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orcamentoprodserial.findAll", query = "SELECT o FROM Orcamentoprodserial o")
    , @NamedQuery(name = "Orcamentoprodserial.findByCodorcprodser", query = "SELECT o FROM Orcamentoprodserial o WHERE o.codorcprodser = :codorcprodser")
    , @NamedQuery(name = "Orcamentoprodserial.findByAltura", query = "SELECT o FROM Orcamentoprodserial o WHERE o.altura = :altura")
    , @NamedQuery(name = "Orcamentoprodserial.findByLargura", query = "SELECT o FROM Orcamentoprodserial o WHERE o.largura = :largura")})
public class Orcamentoprodserial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODORCPRODSER")
    private String codorcprodser;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ALTURA")
    private BigDecimal altura;
    @Column(name = "LARGURA")
    private BigDecimal largura;
    @JoinColumn(name = "CODORCPROD", referencedColumnName = "CODORCPROD")
    @ManyToOne
    private Orcamentoprod codorcprod;
    @JoinColumn(name = "CODPRODUTOSERIAL", referencedColumnName = "CODPRODUTOSERIAL")
    @ManyToOne(optional = false)
    private Produtoserial codprodutoserial;

    public Orcamentoprodserial() {
    }

    public Orcamentoprodserial(String codorcprodser) {
        this.codorcprodser = codorcprodser;
    }

    public String getCodorcprodser() {
        return codorcprodser;
    }

    public void setCodorcprodser(String codorcprodser) {
        this.codorcprodser = codorcprodser;
    }

    public BigDecimal getAltura() {
        return altura;
    }

    public void setAltura(BigDecimal altura) {
        this.altura = altura;
    }

    public BigDecimal getLargura() {
        return largura;
    }

    public void setLargura(BigDecimal largura) {
        this.largura = largura;
    }

    public Orcamentoprod getCodorcprod() {
        return codorcprod;
    }

    public void setCodorcprod(Orcamentoprod codorcprod) {
        this.codorcprod = codorcprod;
    }

    public Produtoserial getCodprodutoserial() {
        return codprodutoserial;
    }

    public void setCodprodutoserial(Produtoserial codprodutoserial) {
        this.codprodutoserial = codprodutoserial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codorcprodser != null ? codorcprodser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orcamentoprodserial)) {
            return false;
        }
        Orcamentoprodserial other = (Orcamentoprodserial) object;
        if ((this.codorcprodser == null && other.codorcprodser != null) || (this.codorcprodser != null && !this.codorcprodser.equals(other.codorcprodser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Orcamentoprodserial[ codorcprodser=" + codorcprodser + " ]";
    }
    
}
