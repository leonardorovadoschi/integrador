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
@Table(name = "MOVENTRADADOCREF", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Moventradadocref.findAll", query = "SELECT m FROM Moventradadocref m")
    , @NamedQuery(name = "Moventradadocref.findByCodmoventradadocref", query = "SELECT m FROM Moventradadocref m WHERE m.codmoventradadocref = :codmoventradadocref")})
public class Moventradadocref implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODMOVENTRADADOCREF")
    private String codmoventradadocref;
    @JoinColumn(name = "CODMOVENDA", referencedColumnName = "CODMOVENDA")
    @ManyToOne(optional = false)
    private Movenda codmovenda;
    @JoinColumn(name = "CODMOVENTR", referencedColumnName = "CODMOVENTR")
    @ManyToOne(optional = false)
    private Moventrada codmoventr;

    public Moventradadocref() {
    }

    public Moventradadocref(String codmoventradadocref) {
        this.codmoventradadocref = codmoventradadocref;
    }

    public String getCodmoventradadocref() {
        return codmoventradadocref;
    }

    public void setCodmoventradadocref(String codmoventradadocref) {
        this.codmoventradadocref = codmoventradadocref;
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
        hash += (codmoventradadocref != null ? codmoventradadocref.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Moventradadocref)) {
            return false;
        }
        Moventradadocref other = (Moventradadocref) object;
        if ((this.codmoventradadocref == null && other.codmoventradadocref != null) || (this.codmoventradadocref != null && !this.codmoventradadocref.equals(other.codmoventradadocref))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Moventradadocref[ codmoventradadocref=" + codmoventradadocref + " ]";
    }
    
}
