/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
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
@Table(name = "TINTASUVINILCORRGB", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tintasuvinilcorrgb.findAll", query = "SELECT t FROM Tintasuvinilcorrgb t")
    , @NamedQuery(name = "Tintasuvinilcorrgb.findByCodtintasuvinilcorrgb", query = "SELECT t FROM Tintasuvinilcorrgb t WHERE t.codtintasuvinilcorrgb = :codtintasuvinilcorrgb")
    , @NamedQuery(name = "Tintasuvinilcorrgb.findByR", query = "SELECT t FROM Tintasuvinilcorrgb t WHERE t.r = :r")
    , @NamedQuery(name = "Tintasuvinilcorrgb.findByG", query = "SELECT t FROM Tintasuvinilcorrgb t WHERE t.g = :g")
    , @NamedQuery(name = "Tintasuvinilcorrgb.findByB", query = "SELECT t FROM Tintasuvinilcorrgb t WHERE t.b = :b")})
public class Tintasuvinilcorrgb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODTINTASUVINILCORRGB")
    private String codtintasuvinilcorrgb;
    @Column(name = "R")
    private Integer r;
    @Column(name = "G")
    private Integer g;
    @Column(name = "B")
    private Integer b;

    public Tintasuvinilcorrgb() {
    }

    public Tintasuvinilcorrgb(String codtintasuvinilcorrgb) {
        this.codtintasuvinilcorrgb = codtintasuvinilcorrgb;
    }

    public String getCodtintasuvinilcorrgb() {
        return codtintasuvinilcorrgb;
    }

    public void setCodtintasuvinilcorrgb(String codtintasuvinilcorrgb) {
        this.codtintasuvinilcorrgb = codtintasuvinilcorrgb;
    }

    public Integer getR() {
        return r;
    }

    public void setR(Integer r) {
        this.r = r;
    }

    public Integer getG() {
        return g;
    }

    public void setG(Integer g) {
        this.g = g;
    }

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codtintasuvinilcorrgb != null ? codtintasuvinilcorrgb.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tintasuvinilcorrgb)) {
            return false;
        }
        Tintasuvinilcorrgb other = (Tintasuvinilcorrgb) object;
        if ((this.codtintasuvinilcorrgb == null && other.codtintasuvinilcorrgb != null) || (this.codtintasuvinilcorrgb != null && !this.codtintasuvinilcorrgb.equals(other.codtintasuvinilcorrgb))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Tintasuvinilcorrgb[ codtintasuvinilcorrgb=" + codtintasuvinilcorrgb + " ]";
    }
    
}
