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
@Table(name = "REGRACFOPITEM", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Regracfopitem.findAll", query = "SELECT r FROM Regracfopitem r")
    , @NamedQuery(name = "Regracfopitem.findByCodregracfopitem", query = "SELECT r FROM Regracfopitem r WHERE r.codregracfopitem = :codregracfopitem")})
public class Regracfopitem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODREGRACFOPITEM")
    private String codregracfopitem;
    @JoinColumn(name = "CODCFOP", referencedColumnName = "CODCFOP")
    @ManyToOne(optional = false)
    private Cfop codcfop;
    @JoinColumn(name = "CODCLASSIFICACAOFISCAL", referencedColumnName = "CODCLASSIFICACAOFISCAL")
    @ManyToOne
    private Classificacaofiscal codclassificacaofiscal;
    @JoinColumn(name = "CODREGRACFOP", referencedColumnName = "CODREGRACFOP")
    @ManyToOne(optional = false)
    private Regracfop codregracfop;
    @JoinColumn(name = "CODTIPOMOVIMENTO", referencedColumnName = "CODTIPOMOVIMENTO")
    @ManyToOne
    private Tipomovimento codtipomovimento;
    @JoinColumn(name = "CODUF", referencedColumnName = "CODUF")
    @ManyToOne(optional = false)
    private Uf coduf;

    public Regracfopitem() {
    }

    public Regracfopitem(String codregracfopitem) {
        this.codregracfopitem = codregracfopitem;
    }

    public String getCodregracfopitem() {
        return codregracfopitem;
    }

    public void setCodregracfopitem(String codregracfopitem) {
        this.codregracfopitem = codregracfopitem;
    }

    public Cfop getCodcfop() {
        return codcfop;
    }

    public void setCodcfop(Cfop codcfop) {
        this.codcfop = codcfop;
    }

    public Classificacaofiscal getCodclassificacaofiscal() {
        return codclassificacaofiscal;
    }

    public void setCodclassificacaofiscal(Classificacaofiscal codclassificacaofiscal) {
        this.codclassificacaofiscal = codclassificacaofiscal;
    }

    public Regracfop getCodregracfop() {
        return codregracfop;
    }

    public void setCodregracfop(Regracfop codregracfop) {
        this.codregracfop = codregracfop;
    }

    public Tipomovimento getCodtipomovimento() {
        return codtipomovimento;
    }

    public void setCodtipomovimento(Tipomovimento codtipomovimento) {
        this.codtipomovimento = codtipomovimento;
    }

    public Uf getCoduf() {
        return coduf;
    }

    public void setCoduf(Uf coduf) {
        this.coduf = coduf;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codregracfopitem != null ? codregracfopitem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Regracfopitem)) {
            return false;
        }
        Regracfopitem other = (Regracfopitem) object;
        if ((this.codregracfopitem == null && other.codregracfopitem != null) || (this.codregracfopitem != null && !this.codregracfopitem.equals(other.codregracfopitem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Regracfopitem[ codregracfopitem=" + codregracfopitem + " ]";
    }
    
}
