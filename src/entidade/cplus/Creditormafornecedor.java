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
@Table(name = "CREDITORMAFORNECEDOR", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Creditormafornecedor.findAll", query = "SELECT c FROM Creditormafornecedor c")
    , @NamedQuery(name = "Creditormafornecedor.findByCodcrediforn", query = "SELECT c FROM Creditormafornecedor c WHERE c.codcrediforn = :codcrediforn")
    , @NamedQuery(name = "Creditormafornecedor.findByCodforn", query = "SELECT c FROM Creditormafornecedor c WHERE c.codforn = :codforn")
    , @NamedQuery(name = "Creditormafornecedor.findByData", query = "SELECT c FROM Creditormafornecedor c WHERE c.data = :data")
    , @NamedQuery(name = "Creditormafornecedor.findByValor", query = "SELECT c FROM Creditormafornecedor c WHERE c.valor = :valor")
    , @NamedQuery(name = "Creditormafornecedor.findByObservacao", query = "SELECT c FROM Creditormafornecedor c WHERE c.observacao = :observacao")
    , @NamedQuery(name = "Creditormafornecedor.findByFlagbaixado", query = "SELECT c FROM Creditormafornecedor c WHERE c.flagbaixado = :flagbaixado")
    , @NamedQuery(name = "Creditormafornecedor.findByDatabaixa", query = "SELECT c FROM Creditormafornecedor c WHERE c.databaixa = :databaixa")})
public class Creditormafornecedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCREDIFORN")
    private String codcrediforn;
    @Column(name = "CODFORN")
    private String codforn;
    @Column(name = "DATA")
    @Temporal(TemporalType.DATE)
    private Date data;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALOR")
    private BigDecimal valor;
    @Column(name = "OBSERVACAO")
    private String observacao;
    @Column(name = "FLAGBAIXADO")
    private Character flagbaixado;
    @Column(name = "DATABAIXA")
    @Temporal(TemporalType.DATE)
    private Date databaixa;

    public Creditormafornecedor() {
    }

    public Creditormafornecedor(String codcrediforn) {
        this.codcrediforn = codcrediforn;
    }

    public String getCodcrediforn() {
        return codcrediforn;
    }

    public void setCodcrediforn(String codcrediforn) {
        this.codcrediforn = codcrediforn;
    }

    public String getCodforn() {
        return codforn;
    }

    public void setCodforn(String codforn) {
        this.codforn = codforn;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Character getFlagbaixado() {
        return flagbaixado;
    }

    public void setFlagbaixado(Character flagbaixado) {
        this.flagbaixado = flagbaixado;
    }

    public Date getDatabaixa() {
        return databaixa;
    }

    public void setDatabaixa(Date databaixa) {
        this.databaixa = databaixa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcrediforn != null ? codcrediforn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Creditormafornecedor)) {
            return false;
        }
        Creditormafornecedor other = (Creditormafornecedor) object;
        if ((this.codcrediforn == null && other.codcrediforn != null) || (this.codcrediforn != null && !this.codcrediforn.equals(other.codcrediforn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Creditormafornecedor[ codcrediforn=" + codcrediforn + " ]";
    }
    
}
