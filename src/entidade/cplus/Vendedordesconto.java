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
@Table(name = "VENDEDORDESCONTO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vendedordesconto.findAll", query = "SELECT v FROM Vendedordesconto v")
    , @NamedQuery(name = "Vendedordesconto.findByCodvendedordesconto", query = "SELECT v FROM Vendedordesconto v WHERE v.codvendedordesconto = :codvendedordesconto")
    , @NamedQuery(name = "Vendedordesconto.findByData", query = "SELECT v FROM Vendedordesconto v WHERE v.data = :data")
    , @NamedQuery(name = "Vendedordesconto.findByHora", query = "SELECT v FROM Vendedordesconto v WHERE v.hora = :hora")
    , @NamedQuery(name = "Vendedordesconto.findByValordesconto", query = "SELECT v FROM Vendedordesconto v WHERE v.valordesconto = :valordesconto")
    , @NamedQuery(name = "Vendedordesconto.findByFlagdescontado", query = "SELECT v FROM Vendedordesconto v WHERE v.flagdescontado = :flagdescontado")})
public class Vendedordesconto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODVENDEDORDESCONTO")
    private String codvendedordesconto;
    @Column(name = "DATA")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "HORA")
    @Temporal(TemporalType.TIME)
    private Date hora;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALORDESCONTO")
    private BigDecimal valordesconto;
    @Column(name = "FLAGDESCONTADO")
    private Character flagdescontado;
    @JoinColumn(name = "CODMOVPROD", referencedColumnName = "CODMOVPROD")
    @ManyToOne
    private Movendaprod codmovprod;
    @JoinColumn(name = "CODMOVEPROD", referencedColumnName = "CODMOVEPROD")
    @ManyToOne
    private Moventradaprod codmoveprod;
    @JoinColumn(name = "CODVENDEDORCOMISSAO", referencedColumnName = "CODVENDEDORCOMISSAO")
    @ManyToOne
    private Vendedorcomissao codvendedorcomissao;

    public Vendedordesconto() {
    }

    public Vendedordesconto(String codvendedordesconto) {
        this.codvendedordesconto = codvendedordesconto;
    }

    public String getCodvendedordesconto() {
        return codvendedordesconto;
    }

    public void setCodvendedordesconto(String codvendedordesconto) {
        this.codvendedordesconto = codvendedordesconto;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public BigDecimal getValordesconto() {
        return valordesconto;
    }

    public void setValordesconto(BigDecimal valordesconto) {
        this.valordesconto = valordesconto;
    }

    public Character getFlagdescontado() {
        return flagdescontado;
    }

    public void setFlagdescontado(Character flagdescontado) {
        this.flagdescontado = flagdescontado;
    }

    public Movendaprod getCodmovprod() {
        return codmovprod;
    }

    public void setCodmovprod(Movendaprod codmovprod) {
        this.codmovprod = codmovprod;
    }

    public Moventradaprod getCodmoveprod() {
        return codmoveprod;
    }

    public void setCodmoveprod(Moventradaprod codmoveprod) {
        this.codmoveprod = codmoveprod;
    }

    public Vendedorcomissao getCodvendedorcomissao() {
        return codvendedorcomissao;
    }

    public void setCodvendedorcomissao(Vendedorcomissao codvendedorcomissao) {
        this.codvendedorcomissao = codvendedorcomissao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codvendedordesconto != null ? codvendedordesconto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendedordesconto)) {
            return false;
        }
        Vendedordesconto other = (Vendedordesconto) object;
        if ((this.codvendedordesconto == null && other.codvendedordesconto != null) || (this.codvendedordesconto != null && !this.codvendedordesconto.equals(other.codvendedordesconto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Vendedordesconto[ codvendedordesconto=" + codvendedordesconto + " ]";
    }
    
}
