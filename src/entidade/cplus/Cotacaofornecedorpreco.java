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
import javax.persistence.Lob;
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
@Table(name = "COTACAOFORNECEDORPRECO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cotacaofornecedorpreco.findAll", query = "SELECT c FROM Cotacaofornecedorpreco c")
    , @NamedQuery(name = "Cotacaofornecedorpreco.findByCodcotacaofornecedorpreco", query = "SELECT c FROM Cotacaofornecedorpreco c WHERE c.codcotacaofornecedorpreco = :codcotacaofornecedorpreco")
    , @NamedQuery(name = "Cotacaofornecedorpreco.findByValorunitario", query = "SELECT c FROM Cotacaofornecedorpreco c WHERE c.valorunitario = :valorunitario")
    , @NamedQuery(name = "Cotacaofornecedorpreco.findByAliqipi", query = "SELECT c FROM Cotacaofornecedorpreco c WHERE c.aliqipi = :aliqipi")
    , @NamedQuery(name = "Cotacaofornecedorpreco.findByCodforn", query = "SELECT c FROM Cotacaofornecedorpreco c WHERE c.codforn = :codforn")
    , @NamedQuery(name = "Cotacaofornecedorpreco.findByPrazoentrega", query = "SELECT c FROM Cotacaofornecedorpreco c WHERE c.prazoentrega = :prazoentrega")})
public class Cotacaofornecedorpreco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCOTACAOFORNECEDORPRECO")
    private String codcotacaofornecedorpreco;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALORUNITARIO")
    private BigDecimal valorunitario;
    @Column(name = "ALIQIPI")
    private BigDecimal aliqipi;
    @Column(name = "CODFORN")
    private String codforn;
    @Column(name = "PRAZOENTREGA")
    private Integer prazoentrega;
    @Lob
    @Column(name = "OBS")
    private String obs;
    @JoinColumn(name = "CODCOTACAOPRODUTO", referencedColumnName = "CODCOTACAOPRODUTO")
    @ManyToOne
    private Cotacaoproduto codcotacaoproduto;

    public Cotacaofornecedorpreco() {
    }

    public Cotacaofornecedorpreco(String codcotacaofornecedorpreco) {
        this.codcotacaofornecedorpreco = codcotacaofornecedorpreco;
    }

    public String getCodcotacaofornecedorpreco() {
        return codcotacaofornecedorpreco;
    }

    public void setCodcotacaofornecedorpreco(String codcotacaofornecedorpreco) {
        this.codcotacaofornecedorpreco = codcotacaofornecedorpreco;
    }

    public BigDecimal getValorunitario() {
        return valorunitario;
    }

    public void setValorunitario(BigDecimal valorunitario) {
        this.valorunitario = valorunitario;
    }

    public BigDecimal getAliqipi() {
        return aliqipi;
    }

    public void setAliqipi(BigDecimal aliqipi) {
        this.aliqipi = aliqipi;
    }

    public String getCodforn() {
        return codforn;
    }

    public void setCodforn(String codforn) {
        this.codforn = codforn;
    }

    public Integer getPrazoentrega() {
        return prazoentrega;
    }

    public void setPrazoentrega(Integer prazoentrega) {
        this.prazoentrega = prazoentrega;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Cotacaoproduto getCodcotacaoproduto() {
        return codcotacaoproduto;
    }

    public void setCodcotacaoproduto(Cotacaoproduto codcotacaoproduto) {
        this.codcotacaoproduto = codcotacaoproduto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcotacaofornecedorpreco != null ? codcotacaofornecedorpreco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cotacaofornecedorpreco)) {
            return false;
        }
        Cotacaofornecedorpreco other = (Cotacaofornecedorpreco) object;
        if ((this.codcotacaofornecedorpreco == null && other.codcotacaofornecedorpreco != null) || (this.codcotacaofornecedorpreco != null && !this.codcotacaofornecedorpreco.equals(other.codcotacaofornecedorpreco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Cotacaofornecedorpreco[ codcotacaofornecedorpreco=" + codcotacaofornecedorpreco + " ]";
    }
    
}
