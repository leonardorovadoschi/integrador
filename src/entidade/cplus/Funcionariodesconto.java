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
@Table(name = "FUNCIONARIODESCONTO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcionariodesconto.findAll", query = "SELECT f FROM Funcionariodesconto f")
    , @NamedQuery(name = "Funcionariodesconto.findByCodfuncionariodesconto", query = "SELECT f FROM Funcionariodesconto f WHERE f.codfuncionariodesconto = :codfuncionariodesconto")
    , @NamedQuery(name = "Funcionariodesconto.findByData", query = "SELECT f FROM Funcionariodesconto f WHERE f.data = :data")
    , @NamedQuery(name = "Funcionariodesconto.findByHistorico", query = "SELECT f FROM Funcionariodesconto f WHERE f.historico = :historico")
    , @NamedQuery(name = "Funcionariodesconto.findByValor", query = "SELECT f FROM Funcionariodesconto f WHERE f.valor = :valor")
    , @NamedQuery(name = "Funcionariodesconto.findByFlagdescontado", query = "SELECT f FROM Funcionariodesconto f WHERE f.flagdescontado = :flagdescontado")
    , @NamedQuery(name = "Funcionariodesconto.findByDataparaquitacao", query = "SELECT f FROM Funcionariodesconto f WHERE f.dataparaquitacao = :dataparaquitacao")
    , @NamedQuery(name = "Funcionariodesconto.findByDataquitacao", query = "SELECT f FROM Funcionariodesconto f WHERE f.dataquitacao = :dataquitacao")})
public class Funcionariodesconto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODFUNCIONARIODESCONTO")
    private String codfuncionariodesconto;
    @Column(name = "DATA")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "HISTORICO")
    private String historico;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALOR")
    private BigDecimal valor;
    @Column(name = "FLAGDESCONTADO")
    private Character flagdescontado;
    @Column(name = "DATAPARAQUITACAO")
    @Temporal(TemporalType.DATE)
    private Date dataparaquitacao;
    @Column(name = "DATAQUITACAO")
    @Temporal(TemporalType.DATE)
    private Date dataquitacao;
    @JoinColumn(name = "CODFUNCIONARIO", referencedColumnName = "CODFUNCIONARIO")
    @ManyToOne
    private Funcionario codfuncionario;

    public Funcionariodesconto() {
    }

    public Funcionariodesconto(String codfuncionariodesconto) {
        this.codfuncionariodesconto = codfuncionariodesconto;
    }

    public String getCodfuncionariodesconto() {
        return codfuncionariodesconto;
    }

    public void setCodfuncionariodesconto(String codfuncionariodesconto) {
        this.codfuncionariodesconto = codfuncionariodesconto;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Character getFlagdescontado() {
        return flagdescontado;
    }

    public void setFlagdescontado(Character flagdescontado) {
        this.flagdescontado = flagdescontado;
    }

    public Date getDataparaquitacao() {
        return dataparaquitacao;
    }

    public void setDataparaquitacao(Date dataparaquitacao) {
        this.dataparaquitacao = dataparaquitacao;
    }

    public Date getDataquitacao() {
        return dataquitacao;
    }

    public void setDataquitacao(Date dataquitacao) {
        this.dataquitacao = dataquitacao;
    }

    public Funcionario getCodfuncionario() {
        return codfuncionario;
    }

    public void setCodfuncionario(Funcionario codfuncionario) {
        this.codfuncionario = codfuncionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codfuncionariodesconto != null ? codfuncionariodesconto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionariodesconto)) {
            return false;
        }
        Funcionariodesconto other = (Funcionariodesconto) object;
        if ((this.codfuncionariodesconto == null && other.codfuncionariodesconto != null) || (this.codfuncionariodesconto != null && !this.codfuncionariodesconto.equals(other.codfuncionariodesconto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Funcionariodesconto[ codfuncionariodesconto=" + codfuncionariodesconto + " ]";
    }
    
}
