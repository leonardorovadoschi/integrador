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
@Table(name = "ACERTOPRODUTO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acertoproduto.findAll", query = "SELECT a FROM Acertoproduto a")
    , @NamedQuery(name = "Acertoproduto.findByCodacertoproduto", query = "SELECT a FROM Acertoproduto a WHERE a.codacertoproduto = :codacertoproduto")
    , @NamedQuery(name = "Acertoproduto.findByCoduser", query = "SELECT a FROM Acertoproduto a WHERE a.coduser = :coduser")
    , @NamedQuery(name = "Acertoproduto.findByQuantidade", query = "SELECT a FROM Acertoproduto a WHERE a.quantidade = :quantidade")
    , @NamedQuery(name = "Acertoproduto.findByData", query = "SELECT a FROM Acertoproduto a WHERE a.data = :data")
    , @NamedQuery(name = "Acertoproduto.findByEstatu", query = "SELECT a FROM Acertoproduto a WHERE a.estatu = :estatu")})
public class Acertoproduto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODACERTOPRODUTO")
    private String codacertoproduto;
    @Column(name = "CODUSER")
    private String coduser;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "QUANTIDADE")
    private BigDecimal quantidade;
    @Column(name = "DATA")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "ESTATU")
    private BigDecimal estatu;
    @JoinColumn(name = "CODACERTO", referencedColumnName = "CODACERTO")
    @ManyToOne(optional = false)
    private Acerto codacerto;
    @JoinColumn(name = "CODPROD", referencedColumnName = "CODPROD")
    @ManyToOne(optional = false)
    private Produto codprod;

    public Acertoproduto() {
    }

    public Acertoproduto(String codacertoproduto) {
        this.codacertoproduto = codacertoproduto;
    }

    public String getCodacertoproduto() {
        return codacertoproduto;
    }

    public void setCodacertoproduto(String codacertoproduto) {
        this.codacertoproduto = codacertoproduto;
    }

    public String getCoduser() {
        return coduser;
    }

    public void setCoduser(String coduser) {
        this.coduser = coduser;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public BigDecimal getEstatu() {
        return estatu;
    }

    public void setEstatu(BigDecimal estatu) {
        this.estatu = estatu;
    }

    public Acerto getCodacerto() {
        return codacerto;
    }

    public void setCodacerto(Acerto codacerto) {
        this.codacerto = codacerto;
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
        hash += (codacertoproduto != null ? codacertoproduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acertoproduto)) {
            return false;
        }
        Acertoproduto other = (Acertoproduto) object;
        if ((this.codacertoproduto == null && other.codacertoproduto != null) || (this.codacertoproduto != null && !this.codacertoproduto.equals(other.codacertoproduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Acertoproduto[ codacertoproduto=" + codacertoproduto + " ]";
    }
    
}
