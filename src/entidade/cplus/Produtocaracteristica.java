/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "PRODUTOCARACTERISTICA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produtocaracteristica.findAll", query = "SELECT p FROM Produtocaracteristica p")
    , @NamedQuery(name = "Produtocaracteristica.findByCodprodutocaracteristica", query = "SELECT p FROM Produtocaracteristica p WHERE p.codprodutocaracteristica = :codprodutocaracteristica")
    , @NamedQuery(name = "Produtocaracteristica.findByCodcaracteristica", query = "SELECT p FROM Produtocaracteristica p WHERE p.codcaracteristica = :codcaracteristica")
    , @NamedQuery(name = "Produtocaracteristica.findByDatacaracteristica", query = "SELECT p FROM Produtocaracteristica p WHERE p.datacaracteristica = :datacaracteristica")})
public class Produtocaracteristica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODPRODUTOCARACTERISTICA")
    private String codprodutocaracteristica;
    @Column(name = "CODCARACTERISTICA")
    private String codcaracteristica;
    @Column(name = "DATACARACTERISTICA")
    @Temporal(TemporalType.DATE)
    private Date datacaracteristica;
    @JoinColumn(name = "CODPROD", referencedColumnName = "CODPROD")
    @ManyToOne
    private Produto codprod;

    public Produtocaracteristica() {
    }

    public Produtocaracteristica(String codprodutocaracteristica) {
        this.codprodutocaracteristica = codprodutocaracteristica;
    }

    public String getCodprodutocaracteristica() {
        return codprodutocaracteristica;
    }

    public void setCodprodutocaracteristica(String codprodutocaracteristica) {
        this.codprodutocaracteristica = codprodutocaracteristica;
    }

    public String getCodcaracteristica() {
        return codcaracteristica;
    }

    public void setCodcaracteristica(String codcaracteristica) {
        this.codcaracteristica = codcaracteristica;
    }

    public Date getDatacaracteristica() {
        return datacaracteristica;
    }

    public void setDatacaracteristica(Date datacaracteristica) {
        this.datacaracteristica = datacaracteristica;
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
        hash += (codprodutocaracteristica != null ? codprodutocaracteristica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produtocaracteristica)) {
            return false;
        }
        Produtocaracteristica other = (Produtocaracteristica) object;
        if ((this.codprodutocaracteristica == null && other.codprodutocaracteristica != null) || (this.codprodutocaracteristica != null && !this.codprodutocaracteristica.equals(other.codprodutocaracteristica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Produtocaracteristica[ codprodutocaracteristica=" + codprodutocaracteristica + " ]";
    }
    
}
