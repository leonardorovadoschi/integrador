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
@Table(name = "FORMAPAGPARCELA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Formapagparcela.findAll", query = "SELECT f FROM Formapagparcela f")
    , @NamedQuery(name = "Formapagparcela.findByCodformapagparcela", query = "SELECT f FROM Formapagparcela f WHERE f.codformapagparcela = :codformapagparcela")
    , @NamedQuery(name = "Formapagparcela.findByCodfp", query = "SELECT f FROM Formapagparcela f WHERE f.codfp = :codfp")
    , @NamedQuery(name = "Formapagparcela.findByCodrec", query = "SELECT f FROM Formapagparcela f WHERE f.codrec = :codrec")})
public class Formapagparcela implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODFORMAPAGPARCELA")
    private String codformapagparcela;
    @Column(name = "CODFP")
    private String codfp;
    @Column(name = "CODREC")
    private String codrec;

    public Formapagparcela() {
    }

    public Formapagparcela(String codformapagparcela) {
        this.codformapagparcela = codformapagparcela;
    }

    public String getCodformapagparcela() {
        return codformapagparcela;
    }

    public void setCodformapagparcela(String codformapagparcela) {
        this.codformapagparcela = codformapagparcela;
    }

    public String getCodfp() {
        return codfp;
    }

    public void setCodfp(String codfp) {
        this.codfp = codfp;
    }

    public String getCodrec() {
        return codrec;
    }

    public void setCodrec(String codrec) {
        this.codrec = codrec;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codformapagparcela != null ? codformapagparcela.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Formapagparcela)) {
            return false;
        }
        Formapagparcela other = (Formapagparcela) object;
        if ((this.codformapagparcela == null && other.codformapagparcela != null) || (this.codformapagparcela != null && !this.codformapagparcela.equals(other.codformapagparcela))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Formapagparcela[ codformapagparcela=" + codformapagparcela + " ]";
    }
    
}
