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
@Table(name = "ACERTO_PRODFCIPRODUTO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AcertoProdfciproduto.findAll", query = "SELECT a FROM AcertoProdfciproduto a")
    , @NamedQuery(name = "AcertoProdfciproduto.findById", query = "SELECT a FROM AcertoProdfciproduto a WHERE a.id = :id")
    , @NamedQuery(name = "AcertoProdfciproduto.findByCodacertoProdfci", query = "SELECT a FROM AcertoProdfciproduto a WHERE a.codacertoProdfci = :codacertoProdfci")
    , @NamedQuery(name = "AcertoProdfciproduto.findByFci", query = "SELECT a FROM AcertoProdfciproduto a WHERE a.fci = :fci")
    , @NamedQuery(name = "AcertoProdfciproduto.findByQuantidade", query = "SELECT a FROM AcertoProdfciproduto a WHERE a.quantidade = :quantidade")
    , @NamedQuery(name = "AcertoProdfciproduto.findByCoduser", query = "SELECT a FROM AcertoProdfciproduto a WHERE a.coduser = :coduser")
    , @NamedQuery(name = "AcertoProdfciproduto.findByDataentrada", query = "SELECT a FROM AcertoProdfciproduto a WHERE a.dataentrada = :dataentrada")
    , @NamedQuery(name = "AcertoProdfciproduto.findByCodprodutofci", query = "SELECT a FROM AcertoProdfciproduto a WHERE a.codprodutofci = :codprodutofci")})
public class AcertoProdfciproduto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Column(name = "CODACERTO_PRODFCI")
    private String codacertoProdfci;
    @Column(name = "FCI")
    private String fci;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "QUANTIDADE")
    private BigDecimal quantidade;
    @Column(name = "CODUSER")
    private String coduser;
    @Column(name = "DATAENTRADA")
    @Temporal(TemporalType.DATE)
    private Date dataentrada;
    @Column(name = "CODPRODUTOFCI")
    private String codprodutofci;
    @JoinColumn(name = "CODPROD", referencedColumnName = "CODPROD")
    @ManyToOne
    private Produto codprod;

    public AcertoProdfciproduto() {
    }

    public AcertoProdfciproduto(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodacertoProdfci() {
        return codacertoProdfci;
    }

    public void setCodacertoProdfci(String codacertoProdfci) {
        this.codacertoProdfci = codacertoProdfci;
    }

    public String getFci() {
        return fci;
    }

    public void setFci(String fci) {
        this.fci = fci;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public String getCoduser() {
        return coduser;
    }

    public void setCoduser(String coduser) {
        this.coduser = coduser;
    }

    public Date getDataentrada() {
        return dataentrada;
    }

    public void setDataentrada(Date dataentrada) {
        this.dataentrada = dataentrada;
    }

    public String getCodprodutofci() {
        return codprodutofci;
    }

    public void setCodprodutofci(String codprodutofci) {
        this.codprodutofci = codprodutofci;
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
        if (!(object instanceof AcertoProdfciproduto)) {
            return false;
        }
        AcertoProdfciproduto other = (AcertoProdfciproduto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.AcertoProdfciproduto[ id=" + id + " ]";
    }
    
}
