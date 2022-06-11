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
@Table(name = "CLIENTEPRODUTO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clienteproduto.findAll", query = "SELECT c FROM Clienteproduto c")
    , @NamedQuery(name = "Clienteproduto.findByCodcliprod", query = "SELECT c FROM Clienteproduto c WHERE c.codcliprod = :codcliprod")
    , @NamedQuery(name = "Clienteproduto.findByQuantidade", query = "SELECT c FROM Clienteproduto c WHERE c.quantidade = :quantidade")
    , @NamedQuery(name = "Clienteproduto.findByValorfixo", query = "SELECT c FROM Clienteproduto c WHERE c.valorfixo = :valorfixo")})
public class Clienteproduto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCLIPROD")
    private String codcliprod;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "QUANTIDADE")
    private BigDecimal quantidade;
    @Column(name = "VALORFIXO")
    private BigDecimal valorfixo;
    @JoinColumn(name = "CODCLI", referencedColumnName = "CODCLI")
    @ManyToOne(optional = false)
    private Cliente codcli;
    @JoinColumn(name = "CODMOD", referencedColumnName = "CODMOD")
    @ManyToOne(optional = false)
    private OsModalidade codmod;
    @JoinColumn(name = "CODPRECO", referencedColumnName = "CODPRECO")
    @ManyToOne
    private Preco codpreco;
    @JoinColumn(name = "CODPROD", referencedColumnName = "CODPROD")
    @ManyToOne(optional = false)
    private Produto codprod;

    public Clienteproduto() {
    }

    public Clienteproduto(String codcliprod) {
        this.codcliprod = codcliprod;
    }

    public Clienteproduto(String codcliprod, BigDecimal quantidade) {
        this.codcliprod = codcliprod;
        this.quantidade = quantidade;
    }

    public String getCodcliprod() {
        return codcliprod;
    }

    public void setCodcliprod(String codcliprod) {
        this.codcliprod = codcliprod;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorfixo() {
        return valorfixo;
    }

    public void setValorfixo(BigDecimal valorfixo) {
        this.valorfixo = valorfixo;
    }

    public Cliente getCodcli() {
        return codcli;
    }

    public void setCodcli(Cliente codcli) {
        this.codcli = codcli;
    }

    public OsModalidade getCodmod() {
        return codmod;
    }

    public void setCodmod(OsModalidade codmod) {
        this.codmod = codmod;
    }

    public Preco getCodpreco() {
        return codpreco;
    }

    public void setCodpreco(Preco codpreco) {
        this.codpreco = codpreco;
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
        hash += (codcliprod != null ? codcliprod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clienteproduto)) {
            return false;
        }
        Clienteproduto other = (Clienteproduto) object;
        if ((this.codcliprod == null && other.codcliprod != null) || (this.codcliprod != null && !this.codcliprod.equals(other.codcliprod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Clienteproduto[ codcliprod=" + codcliprod + " ]";
    }
    
}
