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
@Table(name = "VENDEDORSECAO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vendedorsecao.findAll", query = "SELECT v FROM Vendedorsecao v")
    , @NamedQuery(name = "Vendedorsecao.findByCodvendedorsecao", query = "SELECT v FROM Vendedorsecao v WHERE v.codvendedorsecao = :codvendedorsecao")
    , @NamedQuery(name = "Vendedorsecao.findByAliquotacomissao", query = "SELECT v FROM Vendedorsecao v WHERE v.aliquotacomissao = :aliquotacomissao")})
public class Vendedorsecao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODVENDEDORSECAO")
    private String codvendedorsecao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ALIQUOTACOMISSAO")
    private BigDecimal aliquotacomissao;
    @JoinColumn(name = "CODSEC", referencedColumnName = "CODSEC")
    @ManyToOne(optional = false)
    private Secao codsec;
    @JoinColumn(name = "CODVENDED", referencedColumnName = "CODVENDED")
    @ManyToOne(optional = false)
    private Vendedor codvended;

    public Vendedorsecao() {
    }

    public Vendedorsecao(String codvendedorsecao) {
        this.codvendedorsecao = codvendedorsecao;
    }

    public String getCodvendedorsecao() {
        return codvendedorsecao;
    }

    public void setCodvendedorsecao(String codvendedorsecao) {
        this.codvendedorsecao = codvendedorsecao;
    }

    public BigDecimal getAliquotacomissao() {
        return aliquotacomissao;
    }

    public void setAliquotacomissao(BigDecimal aliquotacomissao) {
        this.aliquotacomissao = aliquotacomissao;
    }

    public Secao getCodsec() {
        return codsec;
    }

    public void setCodsec(Secao codsec) {
        this.codsec = codsec;
    }

    public Vendedor getCodvended() {
        return codvended;
    }

    public void setCodvended(Vendedor codvended) {
        this.codvended = codvended;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codvendedorsecao != null ? codvendedorsecao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendedorsecao)) {
            return false;
        }
        Vendedorsecao other = (Vendedorsecao) object;
        if ((this.codvendedorsecao == null && other.codvendedorsecao != null) || (this.codvendedorsecao != null && !this.codvendedorsecao.equals(other.codvendedorsecao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Vendedorsecao[ codvendedorsecao=" + codvendedorsecao + " ]";
    }
    
}
