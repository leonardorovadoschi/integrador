/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "ICMSESTADO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Icmsestado.findAll", query = "SELECT i FROM Icmsestado i")
    , @NamedQuery(name = "Icmsestado.findByUforigem", query = "SELECT i FROM Icmsestado i WHERE i.icmsestadoPK.uforigem = :uforigem")
    , @NamedQuery(name = "Icmsestado.findByUfdestino", query = "SELECT i FROM Icmsestado i WHERE i.icmsestadoPK.ufdestino = :ufdestino")
    , @NamedQuery(name = "Icmsestado.findByAliqicms", query = "SELECT i FROM Icmsestado i WHERE i.aliqicms = :aliqicms")})
public class Icmsestado implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected IcmsestadoPK icmsestadoPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ALIQICMS")
    private BigDecimal aliqicms;
    @JoinColumn(name = "UFORIGEM", referencedColumnName = "CODUF", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Uf uf;
    @JoinColumn(name = "UFDESTINO", referencedColumnName = "CODUF", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Uf uf1;

    public Icmsestado() {
    }

    public Icmsestado(IcmsestadoPK icmsestadoPK) {
        this.icmsestadoPK = icmsestadoPK;
    }

    public Icmsestado(String uforigem, String ufdestino) {
        this.icmsestadoPK = new IcmsestadoPK(uforigem, ufdestino);
    }

    public IcmsestadoPK getIcmsestadoPK() {
        return icmsestadoPK;
    }

    public void setIcmsestadoPK(IcmsestadoPK icmsestadoPK) {
        this.icmsestadoPK = icmsestadoPK;
    }

    public BigDecimal getAliqicms() {
        return aliqicms;
    }

    public void setAliqicms(BigDecimal aliqicms) {
        this.aliqicms = aliqicms;
    }

    public Uf getUf() {
        return uf;
    }

    public void setUf(Uf uf) {
        this.uf = uf;
    }

    public Uf getUf1() {
        return uf1;
    }

    public void setUf1(Uf uf1) {
        this.uf1 = uf1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (icmsestadoPK != null ? icmsestadoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Icmsestado)) {
            return false;
        }
        Icmsestado other = (Icmsestado) object;
        if ((this.icmsestadoPK == null && other.icmsestadoPK != null) || (this.icmsestadoPK != null && !this.icmsestadoPK.equals(other.icmsestadoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Icmsestado[ icmsestadoPK=" + icmsestadoPK + " ]";
    }
    
}
