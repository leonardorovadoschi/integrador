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
@Table(name = "MOVENDADEVOLUCAO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movendadevolucao.findAll", query = "SELECT m FROM Movendadevolucao m")
    , @NamedQuery(name = "Movendadevolucao.findByCodmovendadevolucao", query = "SELECT m FROM Movendadevolucao m WHERE m.codmovendadevolucao = :codmovendadevolucao")
    , @NamedQuery(name = "Movendadevolucao.findByCodmoveprod", query = "SELECT m FROM Movendadevolucao m WHERE m.codmoveprod = :codmoveprod")
    , @NamedQuery(name = "Movendadevolucao.findByCodmovprod", query = "SELECT m FROM Movendadevolucao m WHERE m.codmovprod = :codmovprod")
    , @NamedQuery(name = "Movendadevolucao.findByQuantidadedevolucao", query = "SELECT m FROM Movendadevolucao m WHERE m.quantidadedevolucao = :quantidadedevolucao")
    , @NamedQuery(name = "Movendadevolucao.findByData", query = "SELECT m FROM Movendadevolucao m WHERE m.data = :data")
    , @NamedQuery(name = "Movendadevolucao.findByCoduser", query = "SELECT m FROM Movendadevolucao m WHERE m.coduser = :coduser")})
public class Movendadevolucao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODMOVENDADEVOLUCAO")
    private String codmovendadevolucao;
    @Basic(optional = false)
    @Column(name = "CODMOVEPROD")
    private String codmoveprod;
    @Basic(optional = false)
    @Column(name = "CODMOVPROD")
    private String codmovprod;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "QUANTIDADEDEVOLUCAO")
    private BigDecimal quantidadedevolucao;
    @Column(name = "DATA")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "CODUSER")
    private String coduser;

    public Movendadevolucao() {
    }

    public Movendadevolucao(String codmovendadevolucao) {
        this.codmovendadevolucao = codmovendadevolucao;
    }

    public Movendadevolucao(String codmovendadevolucao, String codmoveprod, String codmovprod) {
        this.codmovendadevolucao = codmovendadevolucao;
        this.codmoveprod = codmoveprod;
        this.codmovprod = codmovprod;
    }

    public String getCodmovendadevolucao() {
        return codmovendadevolucao;
    }

    public void setCodmovendadevolucao(String codmovendadevolucao) {
        this.codmovendadevolucao = codmovendadevolucao;
    }

    public String getCodmoveprod() {
        return codmoveprod;
    }

    public void setCodmoveprod(String codmoveprod) {
        this.codmoveprod = codmoveprod;
    }

    public String getCodmovprod() {
        return codmovprod;
    }

    public void setCodmovprod(String codmovprod) {
        this.codmovprod = codmovprod;
    }

    public BigDecimal getQuantidadedevolucao() {
        return quantidadedevolucao;
    }

    public void setQuantidadedevolucao(BigDecimal quantidadedevolucao) {
        this.quantidadedevolucao = quantidadedevolucao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getCoduser() {
        return coduser;
    }

    public void setCoduser(String coduser) {
        this.coduser = coduser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codmovendadevolucao != null ? codmovendadevolucao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movendadevolucao)) {
            return false;
        }
        Movendadevolucao other = (Movendadevolucao) object;
        if ((this.codmovendadevolucao == null && other.codmovendadevolucao != null) || (this.codmovendadevolucao != null && !this.codmovendadevolucao.equals(other.codmovendadevolucao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Movendadevolucao[ codmovendadevolucao=" + codmovendadevolucao + " ]";
    }
    
}
