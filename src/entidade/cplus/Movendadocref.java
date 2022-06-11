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
@Table(name = "MOVENDADOCREF", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movendadocref.findAll", query = "SELECT m FROM Movendadocref m")
    , @NamedQuery(name = "Movendadocref.findByCodmovendadocref", query = "SELECT m FROM Movendadocref m WHERE m.codmovendadocref = :codmovendadocref")})
public class Movendadocref implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODMOVENDADOCREF")
    private String codmovendadocref;
    @JoinColumn(name = "CODMOVENDA", referencedColumnName = "CODMOVENDA")
    @ManyToOne(optional = false)
    private Movenda codmovenda;
    @JoinColumn(name = "CODMOVENTR", referencedColumnName = "CODMOVENTR")
    @ManyToOne(optional = false)
    private Moventrada codmoventr;

    public Movendadocref() {
    }

    public Movendadocref(String codmovendadocref) {
        this.codmovendadocref = codmovendadocref;
    }

    public String getCodmovendadocref() {
        return codmovendadocref;
    }

    public void setCodmovendadocref(String codmovendadocref) {
        this.codmovendadocref = codmovendadocref;
    }

    public Movenda getCodmovenda() {
        return codmovenda;
    }

    public void setCodmovenda(Movenda codmovenda) {
        this.codmovenda = codmovenda;
    }

    public Moventrada getCodmoventr() {
        return codmoventr;
    }

    public void setCodmoventr(Moventrada codmoventr) {
        this.codmoventr = codmoventr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codmovendadocref != null ? codmovendadocref.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movendadocref)) {
            return false;
        }
        Movendadocref other = (Movendadocref) object;
        if ((this.codmovendadocref == null && other.codmovendadocref != null) || (this.codmovendadocref != null && !this.codmovendadocref.equals(other.codmovendadocref))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Movendadocref[ codmovendadocref=" + codmovendadocref + " ]";
    }
    
}
