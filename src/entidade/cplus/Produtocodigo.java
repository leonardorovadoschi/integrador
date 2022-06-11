/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "PRODUTOCODIGO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produtocodigo.findAll", query = "SELECT p FROM Produtocodigo p")
    , @NamedQuery(name = "Produtocodigo.findById", query = "SELECT p FROM Produtocodigo p WHERE p.id = :id")
    , @NamedQuery(name = "Produtocodigo.findByCodigo", query = "SELECT p FROM Produtocodigo p WHERE p.codigo = :codigo")
    , @NamedQuery(name = "Produtocodigo.findByLastChange", query = "SELECT p FROM Produtocodigo p WHERE p.lastChange = :lastChange")
    , @NamedQuery(name = "Produtocodigo.findByCodtipocodigo", query = "SELECT p FROM Produtocodigo p WHERE p.codtipocodigo = :codtipocodigo")
    , @NamedQuery(name = "Produtocodigo.findByFatorconversao", query = "SELECT p FROM Produtocodigo p WHERE p.fatorconversao = :fatorconversao")})
public class Produtocodigo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "LAST_CHANGE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastChange;
    @Column(name = "CODTIPOCODIGO")
    private String codtipocodigo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "FATORCONVERSAO")
    private BigDecimal fatorconversao;
    @JoinColumn(name = "CODPROD", referencedColumnName = "CODPROD")
    @ManyToOne(optional = false)
    private Produto codprod;

    public Produtocodigo() {
    }

    public Produtocodigo(String id) {
        this.id = id;
    }

    public Produtocodigo(String id, String codigo) {
        this.id = id;
        this.codigo = codigo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getLastChange() {
        return lastChange;
    }

    public void setLastChange(Date lastChange) {
        this.lastChange = lastChange;
    }

    public String getCodtipocodigo() {
        return codtipocodigo;
    }

    public void setCodtipocodigo(String codtipocodigo) {
        this.codtipocodigo = codtipocodigo;
    }

    public BigDecimal getFatorconversao() {
        return fatorconversao;
    }

    public void setFatorconversao(BigDecimal fatorconversao) {
        this.fatorconversao = fatorconversao;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produtocodigo)) {
            return false;
        }
        Produtocodigo other = (Produtocodigo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Produtocodigo[ id=" + id + " ]";
    }
    
}
