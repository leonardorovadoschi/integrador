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
@Table(name = "NFCELETRONICAPAFECFPROD", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nfceletronicapafecfprod.findAll", query = "SELECT n FROM Nfceletronicapafecfprod n")
    , @NamedQuery(name = "Nfceletronicapafecfprod.findByCodnfceletronicapafecfprod", query = "SELECT n FROM Nfceletronicapafecfprod n WHERE n.codnfceletronicapafecfprod = :codnfceletronicapafecfprod")
    , @NamedQuery(name = "Nfceletronicapafecfprod.findByGuid", query = "SELECT n FROM Nfceletronicapafecfprod n WHERE n.guid = :guid")
    , @NamedQuery(name = "Nfceletronicapafecfprod.findByNumeroitem", query = "SELECT n FROM Nfceletronicapafecfprod n WHERE n.numeroitem = :numeroitem")
    , @NamedQuery(name = "Nfceletronicapafecfprod.findByQuantidade", query = "SELECT n FROM Nfceletronicapafecfprod n WHERE n.quantidade = :quantidade")
    , @NamedQuery(name = "Nfceletronicapafecfprod.findByValorunitario", query = "SELECT n FROM Nfceletronicapafecfprod n WHERE n.valorunitario = :valorunitario")
    , @NamedQuery(name = "Nfceletronicapafecfprod.findByValordescontoitem", query = "SELECT n FROM Nfceletronicapafecfprod n WHERE n.valordescontoitem = :valordescontoitem")
    , @NamedQuery(name = "Nfceletronicapafecfprod.findByValoracrescimoitem", query = "SELECT n FROM Nfceletronicapafecfprod n WHERE n.valoracrescimoitem = :valoracrescimoitem")
    , @NamedQuery(name = "Nfceletronicapafecfprod.findByValortotal", query = "SELECT n FROM Nfceletronicapafecfprod n WHERE n.valortotal = :valortotal")
    , @NamedQuery(name = "Nfceletronicapafecfprod.findByFlagaltpaf", query = "SELECT n FROM Nfceletronicapafecfprod n WHERE n.flagaltpaf = :flagaltpaf")})
public class Nfceletronicapafecfprod implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODNFCELETRONICAPAFECFPROD")
    private String codnfceletronicapafecfprod;
    @Column(name = "GUID")
    private String guid;
    @Column(name = "NUMEROITEM")
    private Short numeroitem;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "QUANTIDADE")
    private BigDecimal quantidade;
    @Column(name = "VALORUNITARIO")
    private BigDecimal valorunitario;
    @Column(name = "VALORDESCONTOITEM")
    private BigDecimal valordescontoitem;
    @Column(name = "VALORACRESCIMOITEM")
    private BigDecimal valoracrescimoitem;
    @Column(name = "VALORTOTAL")
    private BigDecimal valortotal;
    @Column(name = "FLAGALTPAF")
    private Character flagaltpaf;
    @JoinColumn(name = "CODNFCELETRONICAPAFECF", referencedColumnName = "CODNFCELETRONICAPAFECF")
    @ManyToOne
    private Nfceletronicapafecf codnfceletronicapafecf;
    @JoinColumn(name = "CODPROD", referencedColumnName = "CODPROD")
    @ManyToOne
    private Produto codprod;

    public Nfceletronicapafecfprod() {
    }

    public Nfceletronicapafecfprod(String codnfceletronicapafecfprod) {
        this.codnfceletronicapafecfprod = codnfceletronicapafecfprod;
    }

    public String getCodnfceletronicapafecfprod() {
        return codnfceletronicapafecfprod;
    }

    public void setCodnfceletronicapafecfprod(String codnfceletronicapafecfprod) {
        this.codnfceletronicapafecfprod = codnfceletronicapafecfprod;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Short getNumeroitem() {
        return numeroitem;
    }

    public void setNumeroitem(Short numeroitem) {
        this.numeroitem = numeroitem;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorunitario() {
        return valorunitario;
    }

    public void setValorunitario(BigDecimal valorunitario) {
        this.valorunitario = valorunitario;
    }

    public BigDecimal getValordescontoitem() {
        return valordescontoitem;
    }

    public void setValordescontoitem(BigDecimal valordescontoitem) {
        this.valordescontoitem = valordescontoitem;
    }

    public BigDecimal getValoracrescimoitem() {
        return valoracrescimoitem;
    }

    public void setValoracrescimoitem(BigDecimal valoracrescimoitem) {
        this.valoracrescimoitem = valoracrescimoitem;
    }

    public BigDecimal getValortotal() {
        return valortotal;
    }

    public void setValortotal(BigDecimal valortotal) {
        this.valortotal = valortotal;
    }

    public Character getFlagaltpaf() {
        return flagaltpaf;
    }

    public void setFlagaltpaf(Character flagaltpaf) {
        this.flagaltpaf = flagaltpaf;
    }

    public Nfceletronicapafecf getCodnfceletronicapafecf() {
        return codnfceletronicapafecf;
    }

    public void setCodnfceletronicapafecf(Nfceletronicapafecf codnfceletronicapafecf) {
        this.codnfceletronicapafecf = codnfceletronicapafecf;
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
        hash += (codnfceletronicapafecfprod != null ? codnfceletronicapafecfprod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nfceletronicapafecfprod)) {
            return false;
        }
        Nfceletronicapafecfprod other = (Nfceletronicapafecfprod) object;
        if ((this.codnfceletronicapafecfprod == null && other.codnfceletronicapafecfprod != null) || (this.codnfceletronicapafecfprod != null && !this.codnfceletronicapafecfprod.equals(other.codnfceletronicapafecfprod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Nfceletronicapafecfprod[ codnfceletronicapafecfprod=" + codnfceletronicapafecfprod + " ]";
    }
    
}
