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
@Table(name = "MOVENTRADAPRODSERIAL", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Moventradaprodserial.findAll", query = "SELECT m FROM Moventradaprodserial m")
    , @NamedQuery(name = "Moventradaprodserial.findByCodmoventradaprodserial", query = "SELECT m FROM Moventradaprodserial m WHERE m.codmoventradaprodserial = :codmoventradaprodserial")
    , @NamedQuery(name = "Moventradaprodserial.findByAltura", query = "SELECT m FROM Moventradaprodserial m WHERE m.altura = :altura")
    , @NamedQuery(name = "Moventradaprodserial.findByLargura", query = "SELECT m FROM Moventradaprodserial m WHERE m.largura = :largura")
    , @NamedQuery(name = "Moventradaprodserial.findByGuid", query = "SELECT m FROM Moventradaprodserial m WHERE m.guid = :guid")})
public class Moventradaprodserial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODMOVENTRADAPRODSERIAL")
    private String codmoventradaprodserial;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ALTURA")
    private BigDecimal altura;
    @Column(name = "LARGURA")
    private BigDecimal largura;
    @Column(name = "GUID")
    private String guid;
    @JoinColumn(name = "CODMOVEPROD", referencedColumnName = "CODMOVEPROD")
    @ManyToOne
    private Moventradaprod codmoveprod;
    @JoinColumn(name = "CODPRODUTOSERIAL", referencedColumnName = "CODPRODUTOSERIAL")
    @ManyToOne(optional = false)
    private Produtoserial codprodutoserial;

    public Moventradaprodserial() {
    }

    public Moventradaprodserial(String codmoventradaprodserial) {
        this.codmoventradaprodserial = codmoventradaprodserial;
    }

    public String getCodmoventradaprodserial() {
        return codmoventradaprodserial;
    }

    public void setCodmoventradaprodserial(String codmoventradaprodserial) {
        this.codmoventradaprodserial = codmoventradaprodserial;
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

    public Produtoserial getCodprodutoserial() {
        return codprodutoserial;
    }

    public void setCodprodutoserial(Produtoserial codprodutoserial) {
        this.codprodutoserial = codprodutoserial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codmoventradaprodserial != null ? codmoventradaprodserial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Moventradaprodserial)) {
            return false;
        }
        Moventradaprodserial other = (Moventradaprodserial) object;
        if ((this.codmoventradaprodserial == null && other.codmoventradaprodserial != null) || (this.codmoventradaprodserial != null && !this.codmoventradaprodserial.equals(other.codmoventradaprodserial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Moventradaprodserial[ codmoventradaprodserial=" + codmoventradaprodserial + " ]";
    }
    
}
