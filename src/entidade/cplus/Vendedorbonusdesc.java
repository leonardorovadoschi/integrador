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
@Table(name = "VENDEDORBONUSDESC", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vendedorbonusdesc.findAll", query = "SELECT v FROM Vendedorbonusdesc v")
    , @NamedQuery(name = "Vendedorbonusdesc.findByCodvendedorbonusdesc", query = "SELECT v FROM Vendedorbonusdesc v WHERE v.codvendedorbonusdesc = :codvendedorbonusdesc")
    , @NamedQuery(name = "Vendedorbonusdesc.findByNomeentidadeorigem", query = "SELECT v FROM Vendedorbonusdesc v WHERE v.nomeentidadeorigem = :nomeentidadeorigem")
    , @NamedQuery(name = "Vendedorbonusdesc.findByIdentidadeorigem", query = "SELECT v FROM Vendedorbonusdesc v WHERE v.identidadeorigem = :identidadeorigem")
    , @NamedQuery(name = "Vendedorbonusdesc.findByCodvended", query = "SELECT v FROM Vendedorbonusdesc v WHERE v.codvended = :codvended")
    , @NamedQuery(name = "Vendedorbonusdesc.findByValorbonusdesc", query = "SELECT v FROM Vendedorbonusdesc v WHERE v.valorbonusdesc = :valorbonusdesc")
    , @NamedQuery(name = "Vendedorbonusdesc.findByDatabonusdesc", query = "SELECT v FROM Vendedorbonusdesc v WHERE v.databonusdesc = :databonusdesc")
    , @NamedQuery(name = "Vendedorbonusdesc.findByCodmovprod", query = "SELECT v FROM Vendedorbonusdesc v WHERE v.codmovprod = :codmovprod")
    , @NamedQuery(name = "Vendedorbonusdesc.findByFlagcancelado", query = "SELECT v FROM Vendedorbonusdesc v WHERE v.flagcancelado = :flagcancelado")})
public class Vendedorbonusdesc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODVENDEDORBONUSDESC")
    private String codvendedorbonusdesc;
    @Column(name = "NOMEENTIDADEORIGEM")
    private String nomeentidadeorigem;
    @Column(name = "IDENTIDADEORIGEM")
    private String identidadeorigem;
    @Column(name = "CODVENDED")
    private String codvended;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALORBONUSDESC")
    private BigDecimal valorbonusdesc;
    @Column(name = "DATABONUSDESC")
    @Temporal(TemporalType.DATE)
    private Date databonusdesc;
    @Column(name = "CODMOVPROD")
    private String codmovprod;
    @Column(name = "FLAGCANCELADO")
    private Character flagcancelado;

    public Vendedorbonusdesc() {
    }

    public Vendedorbonusdesc(String codvendedorbonusdesc) {
        this.codvendedorbonusdesc = codvendedorbonusdesc;
    }

    public String getCodvendedorbonusdesc() {
        return codvendedorbonusdesc;
    }

    public void setCodvendedorbonusdesc(String codvendedorbonusdesc) {
        this.codvendedorbonusdesc = codvendedorbonusdesc;
    }

    public String getNomeentidadeorigem() {
        return nomeentidadeorigem;
    }

    public void setNomeentidadeorigem(String nomeentidadeorigem) {
        this.nomeentidadeorigem = nomeentidadeorigem;
    }

    public String getIdentidadeorigem() {
        return identidadeorigem;
    }

    public void setIdentidadeorigem(String identidadeorigem) {
        this.identidadeorigem = identidadeorigem;
    }

    public String getCodvended() {
        return codvended;
    }

    public void setCodvended(String codvended) {
        this.codvended = codvended;
    }

    public BigDecimal getValorbonusdesc() {
        return valorbonusdesc;
    }

    public void setValorbonusdesc(BigDecimal valorbonusdesc) {
        this.valorbonusdesc = valorbonusdesc;
    }

    public Date getDatabonusdesc() {
        return databonusdesc;
    }

    public void setDatabonusdesc(Date databonusdesc) {
        this.databonusdesc = databonusdesc;
    }

    public String getCodmovprod() {
        return codmovprod;
    }

    public void setCodmovprod(String codmovprod) {
        this.codmovprod = codmovprod;
    }

    public Character getFlagcancelado() {
        return flagcancelado;
    }

    public void setFlagcancelado(Character flagcancelado) {
        this.flagcancelado = flagcancelado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codvendedorbonusdesc != null ? codvendedorbonusdesc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendedorbonusdesc)) {
            return false;
        }
        Vendedorbonusdesc other = (Vendedorbonusdesc) object;
        if ((this.codvendedorbonusdesc == null && other.codvendedorbonusdesc != null) || (this.codvendedorbonusdesc != null && !this.codvendedorbonusdesc.equals(other.codvendedorbonusdesc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Vendedorbonusdesc[ codvendedorbonusdesc=" + codvendedorbonusdesc + " ]";
    }
    
}
