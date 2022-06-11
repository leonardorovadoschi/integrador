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
@Table(name = "ORCAMENTOVENDA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orcamentovenda.findAll", query = "SELECT o FROM Orcamentovenda o")
    , @NamedQuery(name = "Orcamentovenda.findByCodorcamentovenda", query = "SELECT o FROM Orcamentovenda o WHERE o.codorcamentovenda = :codorcamentovenda")
    , @NamedQuery(name = "Orcamentovenda.findByQuantidadevenda", query = "SELECT o FROM Orcamentovenda o WHERE o.quantidadevenda = :quantidadevenda")
    , @NamedQuery(name = "Orcamentovenda.findByData", query = "SELECT o FROM Orcamentovenda o WHERE o.data = :data")
    , @NamedQuery(name = "Orcamentovenda.findByCoduser", query = "SELECT o FROM Orcamentovenda o WHERE o.coduser = :coduser")})
public class Orcamentovenda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODORCAMENTOVENDA")
    private String codorcamentovenda;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "QUANTIDADEVENDA")
    private BigDecimal quantidadevenda;
    @Column(name = "DATA")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "CODUSER")
    private String coduser;
    @JoinColumn(name = "CODMOVPROD", referencedColumnName = "CODMOVPROD")
    @ManyToOne
    private Movendaprod codmovprod;
    @JoinColumn(name = "CODORCPROD", referencedColumnName = "CODORCPROD")
    @ManyToOne(optional = false)
    private Orcamentoprod codorcprod;

    public Orcamentovenda() {
    }

    public Orcamentovenda(String codorcamentovenda) {
        this.codorcamentovenda = codorcamentovenda;
    }

    public String getCodorcamentovenda() {
        return codorcamentovenda;
    }

    public void setCodorcamentovenda(String codorcamentovenda) {
        this.codorcamentovenda = codorcamentovenda;
    }

    public BigDecimal getQuantidadevenda() {
        return quantidadevenda;
    }

    public void setQuantidadevenda(BigDecimal quantidadevenda) {
        this.quantidadevenda = quantidadevenda;
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

    public Movendaprod getCodmovprod() {
        return codmovprod;
    }

    public void setCodmovprod(Movendaprod codmovprod) {
        this.codmovprod = codmovprod;
    }

    public Orcamentoprod getCodorcprod() {
        return codorcprod;
    }

    public void setCodorcprod(Orcamentoprod codorcprod) {
        this.codorcprod = codorcprod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codorcamentovenda != null ? codorcamentovenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orcamentovenda)) {
            return false;
        }
        Orcamentovenda other = (Orcamentovenda) object;
        if ((this.codorcamentovenda == null && other.codorcamentovenda != null) || (this.codorcamentovenda != null && !this.codorcamentovenda.equals(other.codorcamentovenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Orcamentovenda[ codorcamentovenda=" + codorcamentovenda + " ]";
    }
    
}
