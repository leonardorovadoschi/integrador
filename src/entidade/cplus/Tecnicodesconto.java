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
@Table(name = "TECNICODESCONTO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tecnicodesconto.findAll", query = "SELECT t FROM Tecnicodesconto t")
    , @NamedQuery(name = "Tecnicodesconto.findByCodtecnicodesconto", query = "SELECT t FROM Tecnicodesconto t WHERE t.codtecnicodesconto = :codtecnicodesconto")
    , @NamedQuery(name = "Tecnicodesconto.findByCodcomissaotecnico", query = "SELECT t FROM Tecnicodesconto t WHERE t.codcomissaotecnico = :codcomissaotecnico")
    , @NamedQuery(name = "Tecnicodesconto.findByCodmoveprod", query = "SELECT t FROM Tecnicodesconto t WHERE t.codmoveprod = :codmoveprod")
    , @NamedQuery(name = "Tecnicodesconto.findByCodmovprod", query = "SELECT t FROM Tecnicodesconto t WHERE t.codmovprod = :codmovprod")
    , @NamedQuery(name = "Tecnicodesconto.findByData", query = "SELECT t FROM Tecnicodesconto t WHERE t.data = :data")
    , @NamedQuery(name = "Tecnicodesconto.findByValbasecalculo", query = "SELECT t FROM Tecnicodesconto t WHERE t.valbasecalculo = :valbasecalculo")
    , @NamedQuery(name = "Tecnicodesconto.findByValdesconto", query = "SELECT t FROM Tecnicodesconto t WHERE t.valdesconto = :valdesconto")
    , @NamedQuery(name = "Tecnicodesconto.findByFlagdescontado", query = "SELECT t FROM Tecnicodesconto t WHERE t.flagdescontado = :flagdescontado")})
public class Tecnicodesconto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODTECNICODESCONTO")
    private String codtecnicodesconto;
    @Column(name = "CODCOMISSAOTECNICO")
    private String codcomissaotecnico;
    @Column(name = "CODMOVEPROD")
    private String codmoveprod;
    @Column(name = "CODMOVPROD")
    private String codmovprod;
    @Column(name = "DATA")
    @Temporal(TemporalType.DATE)
    private Date data;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALBASECALCULO")
    private BigDecimal valbasecalculo;
    @Column(name = "VALDESCONTO")
    private BigDecimal valdesconto;
    @Column(name = "FLAGDESCONTADO")
    private Character flagdescontado;

    public Tecnicodesconto() {
    }

    public Tecnicodesconto(String codtecnicodesconto) {
        this.codtecnicodesconto = codtecnicodesconto;
    }

    public String getCodtecnicodesconto() {
        return codtecnicodesconto;
    }

    public void setCodtecnicodesconto(String codtecnicodesconto) {
        this.codtecnicodesconto = codtecnicodesconto;
    }

    public String getCodcomissaotecnico() {
        return codcomissaotecnico;
    }

    public void setCodcomissaotecnico(String codcomissaotecnico) {
        this.codcomissaotecnico = codcomissaotecnico;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public BigDecimal getValbasecalculo() {
        return valbasecalculo;
    }

    public void setValbasecalculo(BigDecimal valbasecalculo) {
        this.valbasecalculo = valbasecalculo;
    }

    public BigDecimal getValdesconto() {
        return valdesconto;
    }

    public void setValdesconto(BigDecimal valdesconto) {
        this.valdesconto = valdesconto;
    }

    public Character getFlagdescontado() {
        return flagdescontado;
    }

    public void setFlagdescontado(Character flagdescontado) {
        this.flagdescontado = flagdescontado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codtecnicodesconto != null ? codtecnicodesconto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tecnicodesconto)) {
            return false;
        }
        Tecnicodesconto other = (Tecnicodesconto) object;
        if ((this.codtecnicodesconto == null && other.codtecnicodesconto != null) || (this.codtecnicodesconto != null && !this.codtecnicodesconto.equals(other.codtecnicodesconto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Tecnicodesconto[ codtecnicodesconto=" + codtecnicodesconto + " ]";
    }
    
}
