/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "PRODUTOSERIAL", catalog = "", schema = "")

public class Produtoserial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODPRODUTOSERIAL")
    private String codprodutoserial;
    
    @JoinColumn(name = "CODPROD", referencedColumnName = "CODPROD")
    @ManyToOne
    private Produto codprod;
    
    @Column(name = "SERIAL")
    private String serial;
    @Column(name = "DATAENTRADA")
    @Temporal(TemporalType.DATE)
    private Date dataentrada;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ALTURA")
    private BigDecimal altura;
    @Column(name = "LARGURA")
    private BigDecimal largura;
    @OneToMany(mappedBy = "codprodutoserial")
    private Collection<Consignacaobaixa> consignacaobaixaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codprodutoserial")
    private Collection<Moventradaprodserial> moventradaprodserialCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codprodutoserial")
    private Collection<OsProdservserial> osProdservserialCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codprodutoserial")
    private Collection<Movendaprodserial> movendaprodserialCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codprodutoserial")
    private Collection<Orcamentoprodserial> orcamentoprodserialCollection;

    public Produtoserial() {
    }

    public Produtoserial(String codprodutoserial) {
        this.codprodutoserial = codprodutoserial;
    }

    public String getCodprodutoserial() {
        return codprodutoserial;
    }

    public void setCodprodutoserial(String codprodutoserial) {
        this.codprodutoserial = codprodutoserial;
    }

     public Produto getCodprod() {
        return codprod;
    }

    public void setCodprod(Produto codprod) {
        Produto oldCodprod = this.codprod;
        this.codprod = codprod;
  //      changeSupport.firePropertyChange("codprod", oldCodprod, codprod);
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public Date getDataentrada() {
        return dataentrada;
    }

    public void setDataentrada(Date dataentrada) {
        this.dataentrada = dataentrada;
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

    @XmlTransient
    public Collection<Consignacaobaixa> getConsignacaobaixaCollection() {
        return consignacaobaixaCollection;
    }

    public void setConsignacaobaixaCollection(Collection<Consignacaobaixa> consignacaobaixaCollection) {
        this.consignacaobaixaCollection = consignacaobaixaCollection;
    }

    @XmlTransient
    public Collection<Moventradaprodserial> getMoventradaprodserialCollection() {
        return moventradaprodserialCollection;
    }

    public void setMoventradaprodserialCollection(Collection<Moventradaprodserial> moventradaprodserialCollection) {
        this.moventradaprodserialCollection = moventradaprodserialCollection;
    }

    @XmlTransient
    public Collection<OsProdservserial> getOsProdservserialCollection() {
        return osProdservserialCollection;
    }

    public void setOsProdservserialCollection(Collection<OsProdservserial> osProdservserialCollection) {
        this.osProdservserialCollection = osProdservserialCollection;
    }

    @XmlTransient
    public Collection<Movendaprodserial> getMovendaprodserialCollection() {
        return movendaprodserialCollection;
    }

    public void setMovendaprodserialCollection(Collection<Movendaprodserial> movendaprodserialCollection) {
        this.movendaprodserialCollection = movendaprodserialCollection;
    }

    @XmlTransient
    public Collection<Orcamentoprodserial> getOrcamentoprodserialCollection() {
        return orcamentoprodserialCollection;
    }

    public void setOrcamentoprodserialCollection(Collection<Orcamentoprodserial> orcamentoprodserialCollection) {
        this.orcamentoprodserialCollection = orcamentoprodserialCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codprodutoserial != null ? codprodutoserial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produtoserial)) {
            return false;
        }
        Produtoserial other = (Produtoserial) object;
        if ((this.codprodutoserial == null && other.codprodutoserial != null) || (this.codprodutoserial != null && !this.codprodutoserial.equals(other.codprodutoserial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Produtoserial[ codprodutoserial=" + codprodutoserial + " ]";
    }
    
}
