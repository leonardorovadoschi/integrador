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
@Table(name = "PRODUTOPRODUCAO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produtoproducao.findAll", query = "SELECT p FROM Produtoproducao p")
    , @NamedQuery(name = "Produtoproducao.findByCodprodutoproducao", query = "SELECT p FROM Produtoproducao p WHERE p.codprodutoproducao = :codprodutoproducao")
    , @NamedQuery(name = "Produtoproducao.findByQtd", query = "SELECT p FROM Produtoproducao p WHERE p.qtd = :qtd")
    , @NamedQuery(name = "Produtoproducao.findByEtapa", query = "SELECT p FROM Produtoproducao p WHERE p.etapa = :etapa")})
public class Produtoproducao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODPRODUTOPRODUCAO")
    private String codprodutoproducao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "QTD")
    private BigDecimal qtd;
    @Lob
    @Column(name = "OBS")
    private String obs;
    @Column(name = "ETAPA")
    private String etapa;
    @JoinColumn(name = "CODPROD", referencedColumnName = "CODPROD")
    @ManyToOne
    private Produto codprod;
    @JoinColumn(name = "CODPRODPRODUCAO", referencedColumnName = "CODPROD")
    @ManyToOne
    private Produto codprodproducao;

    public Produtoproducao() {
    }

    public Produtoproducao(String codprodutoproducao) {
        this.codprodutoproducao = codprodutoproducao;
    }

    public String getCodprodutoproducao() {
        return codprodutoproducao;
    }

    public void setCodprodutoproducao(String codprodutoproducao) {
        this.codprodutoproducao = codprodutoproducao;
    }

    public BigDecimal getQtd() {
        return qtd;
    }

    public void setQtd(BigDecimal qtd) {
        this.qtd = qtd;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    public Produto getCodprod() {
        return codprod;
    }

    public void setCodprod(Produto codprod) {
        this.codprod = codprod;
    }

    public Produto getCodprodproducao() {
        return codprodproducao;
    }

    public void setCodprodproducao(Produto codprodproducao) {
        this.codprodproducao = codprodproducao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codprodutoproducao != null ? codprodutoproducao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produtoproducao)) {
            return false;
        }
        Produtoproducao other = (Produtoproducao) object;
        if ((this.codprodutoproducao == null && other.codprodutoproducao != null) || (this.codprodutoproducao != null && !this.codprodutoproducao.equals(other.codprodutoproducao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Produtoproducao[ codprodutoproducao=" + codprodutoproducao + " ]";
    }
    
}
