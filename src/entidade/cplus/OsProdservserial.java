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
@Table(name = "OS_PRODSERVSERIAL", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OsProdservserial.findAll", query = "SELECT o FROM OsProdservserial o")
    , @NamedQuery(name = "OsProdservserial.findByCodprodservserial", query = "SELECT o FROM OsProdservserial o WHERE o.codprodservserial = :codprodservserial")
    , @NamedQuery(name = "OsProdservserial.findByAltura", query = "SELECT o FROM OsProdservserial o WHERE o.altura = :altura")
    , @NamedQuery(name = "OsProdservserial.findByLargura", query = "SELECT o FROM OsProdservserial o WHERE o.largura = :largura")})
public class OsProdservserial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODPRODSERVSERIAL")
    private String codprodservserial;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ALTURA")
    private BigDecimal altura;
    @Column(name = "LARGURA")
    private BigDecimal largura;
    @JoinColumn(name = "CODPRODSERV", referencedColumnName = "CODPRODSERV")
    @ManyToOne
    private OsProdserv codprodserv;
    @JoinColumn(name = "CODPRODUTOSERIAL", referencedColumnName = "CODPRODUTOSERIAL")
    @ManyToOne(optional = false)
    private Produtoserial codprodutoserial;

    public OsProdservserial() {
    }

    public OsProdservserial(String codprodservserial) {
        this.codprodservserial = codprodservserial;
    }

    public String getCodprodservserial() {
        return codprodservserial;
    }

    public void setCodprodservserial(String codprodservserial) {
        this.codprodservserial = codprodservserial;
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

    public OsProdserv getCodprodserv() {
        return codprodserv;
    }

    public void setCodprodserv(OsProdserv codprodserv) {
        this.codprodserv = codprodserv;
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
        hash += (codprodservserial != null ? codprodservserial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OsProdservserial)) {
            return false;
        }
        OsProdservserial other = (OsProdservserial) object;
        if ((this.codprodservserial == null && other.codprodservserial != null) || (this.codprodservserial != null && !this.codprodservserial.equals(other.codprodservserial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.OsProdservserial[ codprodservserial=" + codprodservserial + " ]";
    }
    
}
