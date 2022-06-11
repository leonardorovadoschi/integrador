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
@Table(name = "PEDIDOENTRADA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedidoentrada.findAll", query = "SELECT p FROM Pedidoentrada p")
    , @NamedQuery(name = "Pedidoentrada.findByCodpedidoentrada", query = "SELECT p FROM Pedidoentrada p WHERE p.codpedidoentrada = :codpedidoentrada")
    , @NamedQuery(name = "Pedidoentrada.findByQuantidadeentrada", query = "SELECT p FROM Pedidoentrada p WHERE p.quantidadeentrada = :quantidadeentrada")
    , @NamedQuery(name = "Pedidoentrada.findByData", query = "SELECT p FROM Pedidoentrada p WHERE p.data = :data")
    , @NamedQuery(name = "Pedidoentrada.findByCoduser", query = "SELECT p FROM Pedidoentrada p WHERE p.coduser = :coduser")})
public class Pedidoentrada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODPEDIDOENTRADA")
    private String codpedidoentrada;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "QUANTIDADEENTRADA")
    private BigDecimal quantidadeentrada;
    @Column(name = "DATA")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "CODUSER")
    private String coduser;
    @JoinColumn(name = "CODMOVEPROD", referencedColumnName = "CODMOVEPROD")
    @ManyToOne(optional = false)
    private Moventradaprod codmoveprod;
    @JoinColumn(name = "CODPEDIDOITEM", referencedColumnName = "CODPEDIDOITEM")
    @ManyToOne(optional = false)
    private Pedidoitem codpedidoitem;

    public Pedidoentrada() {
    }

    public Pedidoentrada(String codpedidoentrada) {
        this.codpedidoentrada = codpedidoentrada;
    }

    public String getCodpedidoentrada() {
        return codpedidoentrada;
    }

    public void setCodpedidoentrada(String codpedidoentrada) {
        this.codpedidoentrada = codpedidoentrada;
    }

    public BigDecimal getQuantidadeentrada() {
        return quantidadeentrada;
    }

    public void setQuantidadeentrada(BigDecimal quantidadeentrada) {
        this.quantidadeentrada = quantidadeentrada;
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

    public Moventradaprod getCodmoveprod() {
        return codmoveprod;
    }

    public void setCodmoveprod(Moventradaprod codmoveprod) {
        this.codmoveprod = codmoveprod;
    }

    public Pedidoitem getCodpedidoitem() {
        return codpedidoitem;
    }

    public void setCodpedidoitem(Pedidoitem codpedidoitem) {
        this.codpedidoitem = codpedidoitem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codpedidoentrada != null ? codpedidoentrada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedidoentrada)) {
            return false;
        }
        Pedidoentrada other = (Pedidoentrada) object;
        if ((this.codpedidoentrada == null && other.codpedidoentrada != null) || (this.codpedidoentrada != null && !this.codpedidoentrada.equals(other.codpedidoentrada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Pedidoentrada[ codpedidoentrada=" + codpedidoentrada + " ]";
    }
    
}
