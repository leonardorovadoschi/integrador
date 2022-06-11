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
@Table(name = "TINTASUVINILBASE", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tintasuvinilbase.findAll", query = "SELECT t FROM Tintasuvinilbase t")
    , @NamedQuery(name = "Tintasuvinilbase.findByCodtintasuvinilbase", query = "SELECT t FROM Tintasuvinilbase t WHERE t.codtintasuvinilbase = :codtintasuvinilbase")
    , @NamedQuery(name = "Tintasuvinilbase.findByNomebase", query = "SELECT t FROM Tintasuvinilbase t WHERE t.nomebase = :nomebase")
    , @NamedQuery(name = "Tintasuvinilbase.findByBase", query = "SELECT t FROM Tintasuvinilbase t WHERE t.base = :base")
    , @NamedQuery(name = "Tintasuvinilbase.findByVolume", query = "SELECT t FROM Tintasuvinilbase t WHERE t.volume = :volume")
    , @NamedQuery(name = "Tintasuvinilbase.findByCodprod", query = "SELECT t FROM Tintasuvinilbase t WHERE t.codprod = :codprod")})
public class Tintasuvinilbase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODTINTASUVINILBASE")
    private String codtintasuvinilbase;
    @Column(name = "NOMEBASE")
    private String nomebase;
    @Column(name = "BASE")
    private String base;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VOLUME")
    private BigDecimal volume;
    @Column(name = "CODPROD")
    private String codprod;

    public Tintasuvinilbase() {
    }

    public Tintasuvinilbase(String codtintasuvinilbase) {
        this.codtintasuvinilbase = codtintasuvinilbase;
    }

    public String getCodtintasuvinilbase() {
        return codtintasuvinilbase;
    }

    public void setCodtintasuvinilbase(String codtintasuvinilbase) {
        this.codtintasuvinilbase = codtintasuvinilbase;
    }

    public String getNomebase() {
        return nomebase;
    }

    public void setNomebase(String nomebase) {
        this.nomebase = nomebase;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public String getCodprod() {
        return codprod;
    }

    public void setCodprod(String codprod) {
        this.codprod = codprod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codtintasuvinilbase != null ? codtintasuvinilbase.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tintasuvinilbase)) {
            return false;
        }
        Tintasuvinilbase other = (Tintasuvinilbase) object;
        if ((this.codtintasuvinilbase == null && other.codtintasuvinilbase != null) || (this.codtintasuvinilbase != null && !this.codtintasuvinilbase.equals(other.codtintasuvinilbase))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Tintasuvinilbase[ codtintasuvinilbase=" + codtintasuvinilbase + " ]";
    }
    
}
