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
@Table(name = "PRODUCAOITEM", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producaoitem.findAll", query = "SELECT p FROM Producaoitem p")
    , @NamedQuery(name = "Producaoitem.findByCodproducaoitem", query = "SELECT p FROM Producaoitem p WHERE p.codproducaoitem = :codproducaoitem")
    , @NamedQuery(name = "Producaoitem.findByQuantidade", query = "SELECT p FROM Producaoitem p WHERE p.quantidade = :quantidade")
    , @NamedQuery(name = "Producaoitem.findByFlagatualizacusto", query = "SELECT p FROM Producaoitem p WHERE p.flagatualizacusto = :flagatualizacusto")})
public class Producaoitem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODPRODUCAOITEM")
    private String codproducaoitem;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "QUANTIDADE")
    private BigDecimal quantidade;
    @Column(name = "FLAGATUALIZACUSTO")
    private Character flagatualizacusto;
    @JoinColumn(name = "CODPROD", referencedColumnName = "CODPROD")
    @ManyToOne
    private Produto codprod;

    public Producaoitem() {
    }

    public Producaoitem(String codproducaoitem) {
        this.codproducaoitem = codproducaoitem;
    }

    public String getCodproducaoitem() {
        return codproducaoitem;
    }

    public void setCodproducaoitem(String codproducaoitem) {
        this.codproducaoitem = codproducaoitem;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public Character getFlagatualizacusto() {
        return flagatualizacusto;
    }

    public void setFlagatualizacusto(Character flagatualizacusto) {
        this.flagatualizacusto = flagatualizacusto;
    }

    public Produto getCodprod() {
        return codprod;
    }

    public void setCodprod(Produto codprod) {
        this.codprod = codprod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codproducaoitem != null ? codproducaoitem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producaoitem)) {
            return false;
        }
        Producaoitem other = (Producaoitem) object;
        if ((this.codproducaoitem == null && other.codproducaoitem != null) || (this.codproducaoitem != null && !this.codproducaoitem.equals(other.codproducaoitem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Producaoitem[ codproducaoitem=" + codproducaoitem + " ]";
    }
    
}
