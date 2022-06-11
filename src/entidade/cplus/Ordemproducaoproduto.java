/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ORDEMPRODUCAOPRODUTO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordemproducaoproduto.findAll", query = "SELECT o FROM Ordemproducaoproduto o")
    , @NamedQuery(name = "Ordemproducaoproduto.findByCodordemproducaoproduto", query = "SELECT o FROM Ordemproducaoproduto o WHERE o.codordemproducaoproduto = :codordemproducaoproduto")
    , @NamedQuery(name = "Ordemproducaoproduto.findByCodprod", query = "SELECT o FROM Ordemproducaoproduto o WHERE o.codprod = :codprod")
    , @NamedQuery(name = "Ordemproducaoproduto.findByQtd", query = "SELECT o FROM Ordemproducaoproduto o WHERE o.qtd = :qtd")
    , @NamedQuery(name = "Ordemproducaoproduto.findByQuantidadefinal", query = "SELECT o FROM Ordemproducaoproduto o WHERE o.quantidadefinal = :quantidadefinal")})
public class Ordemproducaoproduto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODORDEMPRODUCAOPRODUTO")
    private String codordemproducaoproduto;
    @Column(name = "CODPROD")
    private String codprod;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "QTD")
    private BigDecimal qtd;
    @Lob
    @Column(name = "OBS")
    private String obs;
    @Column(name = "QUANTIDADEFINAL")
    private BigDecimal quantidadefinal;
    @OneToMany(mappedBy = "codordemproducaoproduto")
    private Collection<Ordemproducaoprodutoitem> ordemproducaoprodutoitemCollection;
    @JoinColumn(name = "CODORDEMPRODUCAO", referencedColumnName = "CODORDEMPRODUCAO")
    @ManyToOne
    private Ordemproducao codordemproducao;

    public Ordemproducaoproduto() {
    }

    public Ordemproducaoproduto(String codordemproducaoproduto) {
        this.codordemproducaoproduto = codordemproducaoproduto;
    }

    public String getCodordemproducaoproduto() {
        return codordemproducaoproduto;
    }

    public void setCodordemproducaoproduto(String codordemproducaoproduto) {
        this.codordemproducaoproduto = codordemproducaoproduto;
    }

    public String getCodprod() {
        return codprod;
    }

    public void setCodprod(String codprod) {
        this.codprod = codprod;
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

    public BigDecimal getQuantidadefinal() {
        return quantidadefinal;
    }

    public void setQuantidadefinal(BigDecimal quantidadefinal) {
        this.quantidadefinal = quantidadefinal;
    }

    @XmlTransient
    public Collection<Ordemproducaoprodutoitem> getOrdemproducaoprodutoitemCollection() {
        return ordemproducaoprodutoitemCollection;
    }

    public void setOrdemproducaoprodutoitemCollection(Collection<Ordemproducaoprodutoitem> ordemproducaoprodutoitemCollection) {
        this.ordemproducaoprodutoitemCollection = ordemproducaoprodutoitemCollection;
    }

    public Ordemproducao getCodordemproducao() {
        return codordemproducao;
    }

    public void setCodordemproducao(Ordemproducao codordemproducao) {
        this.codordemproducao = codordemproducao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codordemproducaoproduto != null ? codordemproducaoproduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordemproducaoproduto)) {
            return false;
        }
        Ordemproducaoproduto other = (Ordemproducaoproduto) object;
        if ((this.codordemproducaoproduto == null && other.codordemproducaoproduto != null) || (this.codordemproducaoproduto != null && !this.codordemproducaoproduto.equals(other.codordemproducaoproduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Ordemproducaoproduto[ codordemproducaoproduto=" + codordemproducaoproduto + " ]";
    }
    
}
