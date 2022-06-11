/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "MOVENDAPRODSERIAL", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movendaprodserial.findAll", query = "SELECT m FROM Movendaprodserial m")
    , @NamedQuery(name = "Movendaprodserial.findByCodmovendaprodserial", query = "SELECT m FROM Movendaprodserial m WHERE m.codmovendaprodserial = :codmovendaprodserial")
    , @NamedQuery(name = "Movendaprodserial.findByAltura", query = "SELECT m FROM Movendaprodserial m WHERE m.altura = :altura")
    , @NamedQuery(name = "Movendaprodserial.findByLargura", query = "SELECT m FROM Movendaprodserial m WHERE m.largura = :largura")
    , @NamedQuery(name = "Movendaprodserial.findByGuid", query = "SELECT m FROM Movendaprodserial m WHERE m.guid = :guid")
    , @NamedQuery(name = "Movendaprodserial.findByFlagdevolvido", query = "SELECT m FROM Movendaprodserial m WHERE m.flagdevolvido = :flagdevolvido")})
public class Movendaprodserial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODMOVENDAPRODSERIAL")
    private String codmovendaprodserial;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ALTURA")
    private BigDecimal altura;
    @Column(name = "LARGURA")
    private BigDecimal largura;
    @Column(name = "GUID")
    private String guid;
    @Column(name = "FLAGDEVOLVIDO")
    private Character flagdevolvido;
    @OneToMany(mappedBy = "codmovendaprodserial")
    private Collection<Atendimento> atendimentoCollection;
    @JoinColumn(name = "CODMOVPROD", referencedColumnName = "CODMOVPROD")
    @ManyToOne(optional = false)
    private Movendaprod codmovprod;
    @JoinColumn(name = "CODPRODUTOSERIAL", referencedColumnName = "CODPRODUTOSERIAL")
    @ManyToOne(optional = false)
    private Produtoserial codprodutoserial;

    public Movendaprodserial() {
    }

    public Movendaprodserial(String codmovendaprodserial) {
        this.codmovendaprodserial = codmovendaprodserial;
    }

    public String getCodmovendaprodserial() {
        return codmovendaprodserial;
    }

    public void setCodmovendaprodserial(String codmovendaprodserial) {
        this.codmovendaprodserial = codmovendaprodserial;
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

    public Character getFlagdevolvido() {
        return flagdevolvido;
    }

    public void setFlagdevolvido(Character flagdevolvido) {
        this.flagdevolvido = flagdevolvido;
    }

    @XmlTransient
    public Collection<Atendimento> getAtendimentoCollection() {
        return atendimentoCollection;
    }

    public void setAtendimentoCollection(Collection<Atendimento> atendimentoCollection) {
        this.atendimentoCollection = atendimentoCollection;
    }

    public Movendaprod getCodmovprod() {
        return codmovprod;
    }

    public void setCodmovprod(Movendaprod codmovprod) {
        this.codmovprod = codmovprod;
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
        hash += (codmovendaprodserial != null ? codmovendaprodserial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movendaprodserial)) {
            return false;
        }
        Movendaprodserial other = (Movendaprodserial) object;
        if ((this.codmovendaprodserial == null && other.codmovendaprodserial != null) || (this.codmovendaprodserial != null && !this.codmovendaprodserial.equals(other.codmovendaprodserial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Movendaprodserial[ codmovendaprodserial=" + codmovendaprodserial + " ]";
    }
    
}
