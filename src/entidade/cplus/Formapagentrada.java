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
@Table(name = "FORMAPAGENTRADA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Formapagentrada.findAll", query = "SELECT f FROM Formapagentrada f")
    , @NamedQuery(name = "Formapagentrada.findByCodformapagentrada", query = "SELECT f FROM Formapagentrada f WHERE f.codformapagentrada = :codformapagentrada")
    , @NamedQuery(name = "Formapagentrada.findByCodfp", query = "SELECT f FROM Formapagentrada f WHERE f.codfp = :codfp")
    , @NamedQuery(name = "Formapagentrada.findByCodrec", query = "SELECT f FROM Formapagentrada f WHERE f.codrec = :codrec")})
public class Formapagentrada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODFORMAPAGENTRADA")
    private String codformapagentrada;
    @Column(name = "CODFP")
    private String codfp;
    @Column(name = "CODREC")
    private String codrec;

    public Formapagentrada() {
    }

    public Formapagentrada(String codformapagentrada) {
        this.codformapagentrada = codformapagentrada;
    }

    public String getCodformapagentrada() {
        return codformapagentrada;
    }

    public void setCodformapagentrada(String codformapagentrada) {
        this.codformapagentrada = codformapagentrada;
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
        hash += (codformapagentrada != null ? codformapagentrada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Formapagentrada)) {
            return false;
        }
        Formapagentrada other = (Formapagentrada) object;
        if ((this.codformapagentrada == null && other.codformapagentrada != null) || (this.codformapagentrada != null && !this.codformapagentrada.equals(other.codformapagentrada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Formapagentrada[ codformapagentrada=" + codformapagentrada + " ]";
    }
    
}
