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
@Table(name = "CLASSIFICACAOFISCALUF", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Classificacaofiscaluf.findAll", query = "SELECT c FROM Classificacaofiscaluf c")
    , @NamedQuery(name = "Classificacaofiscaluf.findByCodclassificacaofiscaluf", query = "SELECT c FROM Classificacaofiscaluf c WHERE c.codclassificacaofiscaluf = :codclassificacaofiscaluf")
    , @NamedQuery(name = "Classificacaofiscaluf.findByCoduf", query = "SELECT c FROM Classificacaofiscaluf c WHERE c.coduf = :coduf")
    , @NamedQuery(name = "Classificacaofiscaluf.findByAliqmva", query = "SELECT c FROM Classificacaofiscaluf c WHERE c.aliqmva = :aliqmva")
    , @NamedQuery(name = "Classificacaofiscaluf.findByAliqicmsinterna", query = "SELECT c FROM Classificacaofiscaluf c WHERE c.aliqicmsinterna = :aliqicmsinterna")
    , @NamedQuery(name = "Classificacaofiscaluf.findByAliqfcp", query = "SELECT c FROM Classificacaofiscaluf c WHERE c.aliqfcp = :aliqfcp")})
public class Classificacaofiscaluf implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCLASSIFICACAOFISCALUF")
    private String codclassificacaofiscaluf;
    @Column(name = "CODUF")
    private String coduf;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ALIQMVA")
    private BigDecimal aliqmva;
    @Column(name = "ALIQICMSINTERNA")
    private BigDecimal aliqicmsinterna;
    @Column(name = "ALIQFCP")
    private BigDecimal aliqfcp;
    @JoinColumn(name = "CODCLASSIFICACAOFISCAL", referencedColumnName = "CODCLASSIFICACAOFISCAL")
    @ManyToOne
    private Classificacaofiscal codclassificacaofiscal;

    public Classificacaofiscaluf() {
    }

    public Classificacaofiscaluf(String codclassificacaofiscaluf) {
        this.codclassificacaofiscaluf = codclassificacaofiscaluf;
    }

    public String getCodclassificacaofiscaluf() {
        return codclassificacaofiscaluf;
    }

    public void setCodclassificacaofiscaluf(String codclassificacaofiscaluf) {
        this.codclassificacaofiscaluf = codclassificacaofiscaluf;
    }

    public String getCoduf() {
        return coduf;
    }

    public void setCoduf(String coduf) {
        this.coduf = coduf;
    }

    public BigDecimal getAliqmva() {
        return aliqmva;
    }

    public void setAliqmva(BigDecimal aliqmva) {
        this.aliqmva = aliqmva;
    }

    public BigDecimal getAliqicmsinterna() {
        return aliqicmsinterna;
    }

    public void setAliqicmsinterna(BigDecimal aliqicmsinterna) {
        this.aliqicmsinterna = aliqicmsinterna;
    }

    public BigDecimal getAliqfcp() {
        return aliqfcp;
    }

    public void setAliqfcp(BigDecimal aliqfcp) {
        this.aliqfcp = aliqfcp;
    }

    public Classificacaofiscal getCodclassificacaofiscal() {
        return codclassificacaofiscal;
    }

    public void setCodclassificacaofiscal(Classificacaofiscal codclassificacaofiscal) {
        this.codclassificacaofiscal = codclassificacaofiscal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codclassificacaofiscaluf != null ? codclassificacaofiscaluf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Classificacaofiscaluf)) {
            return false;
        }
        Classificacaofiscaluf other = (Classificacaofiscaluf) object;
        if ((this.codclassificacaofiscaluf == null && other.codclassificacaofiscaluf != null) || (this.codclassificacaofiscaluf != null && !this.codclassificacaofiscaluf.equals(other.codclassificacaofiscaluf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Classificacaofiscaluf[ codclassificacaofiscaluf=" + codclassificacaofiscaluf + " ]";
    }
    
}
