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
@Table(name = "CONSIGNACAOBAIXA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consignacaobaixa.findAll", query = "SELECT c FROM Consignacaobaixa c")
    , @NamedQuery(name = "Consignacaobaixa.findByCodconsignacaobaixa", query = "SELECT c FROM Consignacaobaixa c WHERE c.codconsignacaobaixa = :codconsignacaobaixa")
    , @NamedQuery(name = "Consignacaobaixa.findByCodmovendabaixa", query = "SELECT c FROM Consignacaobaixa c WHERE c.codmovendabaixa = :codmovendabaixa")
    , @NamedQuery(name = "Consignacaobaixa.findByQuantidadebaixa", query = "SELECT c FROM Consignacaobaixa c WHERE c.quantidadebaixa = :quantidadebaixa")
    , @NamedQuery(name = "Consignacaobaixa.findByFlagtipo", query = "SELECT c FROM Consignacaobaixa c WHERE c.flagtipo = :flagtipo")})
public class Consignacaobaixa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCONSIGNACAOBAIXA")
    private String codconsignacaobaixa;
    @Column(name = "CODMOVENDABAIXA")
    private String codmovendabaixa;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "QUANTIDADEBAIXA")
    private BigDecimal quantidadebaixa;
    @Column(name = "FLAGTIPO")
    private Character flagtipo;
    @JoinColumn(name = "CODMOVPROD", referencedColumnName = "CODMOVPROD")
    @ManyToOne
    private Movendaprod codmovprod;
    @JoinColumn(name = "CODMOVENTRDEVOLUCAO", referencedColumnName = "CODMOVENTR")
    @ManyToOne
    private Moventrada codmoventrdevolucao;
    @JoinColumn(name = "CODPRODUTOLOTE", referencedColumnName = "CODPRODUTOLOTE")
    @ManyToOne
    private Produtolote codprodutolote;
    @JoinColumn(name = "CODPRODUTOSERIAL", referencedColumnName = "CODPRODUTOSERIAL")
    @ManyToOne
    private Produtoserial codprodutoserial;

    public Consignacaobaixa() {
    }

    public Consignacaobaixa(String codconsignacaobaixa) {
        this.codconsignacaobaixa = codconsignacaobaixa;
    }

    public String getCodconsignacaobaixa() {
        return codconsignacaobaixa;
    }

    public void setCodconsignacaobaixa(String codconsignacaobaixa) {
        this.codconsignacaobaixa = codconsignacaobaixa;
    }

    public String getCodmovendabaixa() {
        return codmovendabaixa;
    }

    public void setCodmovendabaixa(String codmovendabaixa) {
        this.codmovendabaixa = codmovendabaixa;
    }

    public BigDecimal getQuantidadebaixa() {
        return quantidadebaixa;
    }

    public void setQuantidadebaixa(BigDecimal quantidadebaixa) {
        this.quantidadebaixa = quantidadebaixa;
    }

    public Character getFlagtipo() {
        return flagtipo;
    }

    public void setFlagtipo(Character flagtipo) {
        this.flagtipo = flagtipo;
    }

    public Movendaprod getCodmovprod() {
        return codmovprod;
    }

    public void setCodmovprod(Movendaprod codmovprod) {
        this.codmovprod = codmovprod;
    }

    public Moventrada getCodmoventrdevolucao() {
        return codmoventrdevolucao;
    }

    public void setCodmoventrdevolucao(Moventrada codmoventrdevolucao) {
        this.codmoventrdevolucao = codmoventrdevolucao;
    }

    public Produtolote getCodprodutolote() {
        return codprodutolote;
    }

    public void setCodprodutolote(Produtolote codprodutolote) {
        this.codprodutolote = codprodutolote;
    }

    public Produtoserial getCodprodutoserial() {
        return codprodutoserial;
    }

    public void setCodprodutoserial(Produtoserial codprodutoserial) {
        this.codprodutoserial = codprodutoserial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codconsignacaobaixa != null ? codconsignacaobaixa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consignacaobaixa)) {
            return false;
        }
        Consignacaobaixa other = (Consignacaobaixa) object;
        if ((this.codconsignacaobaixa == null && other.codconsignacaobaixa != null) || (this.codconsignacaobaixa != null && !this.codconsignacaobaixa.equals(other.codconsignacaobaixa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Consignacaobaixa[ codconsignacaobaixa=" + codconsignacaobaixa + " ]";
    }
    
}
