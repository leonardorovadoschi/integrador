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
@Table(name = "COMISSAOTECNICO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comissaotecnico.findAll", query = "SELECT c FROM Comissaotecnico c")
    , @NamedQuery(name = "Comissaotecnico.findByCodcomissaotecnico", query = "SELECT c FROM Comissaotecnico c WHERE c.codcomissaotecnico = :codcomissaotecnico")
    , @NamedQuery(name = "Comissaotecnico.findByCodmovenda", query = "SELECT c FROM Comissaotecnico c WHERE c.codmovenda = :codmovenda")
    , @NamedQuery(name = "Comissaotecnico.findByCodmovprod", query = "SELECT c FROM Comissaotecnico c WHERE c.codmovprod = :codmovprod")
    , @NamedQuery(name = "Comissaotecnico.findByCodtec", query = "SELECT c FROM Comissaotecnico c WHERE c.codtec = :codtec")
    , @NamedQuery(name = "Comissaotecnico.findByCoduser", query = "SELECT c FROM Comissaotecnico c WHERE c.coduser = :coduser")
    , @NamedQuery(name = "Comissaotecnico.findByData", query = "SELECT c FROM Comissaotecnico c WHERE c.data = :data")
    , @NamedQuery(name = "Comissaotecnico.findByValbasecalculo", query = "SELECT c FROM Comissaotecnico c WHERE c.valbasecalculo = :valbasecalculo")
    , @NamedQuery(name = "Comissaotecnico.findByValcomissao", query = "SELECT c FROM Comissaotecnico c WHERE c.valcomissao = :valcomissao")})
public class Comissaotecnico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCOMISSAOTECNICO")
    private String codcomissaotecnico;
    @Column(name = "CODMOVENDA")
    private String codmovenda;
    @Column(name = "CODMOVPROD")
    private String codmovprod;
    @Column(name = "CODTEC")
    private String codtec;
    @Column(name = "CODUSER")
    private String coduser;
    @Column(name = "DATA")
    @Temporal(TemporalType.DATE)
    private Date data;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALBASECALCULO")
    private BigDecimal valbasecalculo;
    @Column(name = "VALCOMISSAO")
    private BigDecimal valcomissao;

    public Comissaotecnico() {
    }

    public Comissaotecnico(String codcomissaotecnico) {
        this.codcomissaotecnico = codcomissaotecnico;
    }

    public String getCodcomissaotecnico() {
        return codcomissaotecnico;
    }

    public void setCodcomissaotecnico(String codcomissaotecnico) {
        this.codcomissaotecnico = codcomissaotecnico;
    }

    public String getCodmovenda() {
        return codmovenda;
    }

    public void setCodmovenda(String codmovenda) {
        this.codmovenda = codmovenda;
    }

    public String getCodmovprod() {
        return codmovprod;
    }

    public void setCodmovprod(String codmovprod) {
        this.codmovprod = codmovprod;
    }

    public String getCodtec() {
        return codtec;
    }

    public void setCodtec(String codtec) {
        this.codtec = codtec;
    }

    public String getCoduser() {
        return coduser;
    }

    public void setCoduser(String coduser) {
        this.coduser = coduser;
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

    public BigDecimal getValcomissao() {
        return valcomissao;
    }

    public void setValcomissao(BigDecimal valcomissao) {
        this.valcomissao = valcomissao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcomissaotecnico != null ? codcomissaotecnico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comissaotecnico)) {
            return false;
        }
        Comissaotecnico other = (Comissaotecnico) object;
        if ((this.codcomissaotecnico == null && other.codcomissaotecnico != null) || (this.codcomissaotecnico != null && !this.codcomissaotecnico.equals(other.codcomissaotecnico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Comissaotecnico[ codcomissaotecnico=" + codcomissaotecnico + " ]";
    }
    
}
