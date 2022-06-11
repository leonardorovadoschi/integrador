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
import javax.persistence.Lob;
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
@Table(name = "MOVENDAPRODDEVOLUCAOCOMPRA", catalog = "", schema = "")

public class Movendaproddevolucaocompra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODMOVENDAPRODDEVOLUCAOCOMPRA")
    private String codmovendaproddevolucaocompra;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "QUANTIDADE")
    private BigDecimal quantidade;
    @Column(name = "VALORCUSTO")
    private BigDecimal valorcusto;
    @Column(name = "DATASAIDA")
    @Temporal(TemporalType.DATE)
    private Date datasaida;
    @Column(name = "QUANTIDADERETORNADA")
    private BigDecimal quantidaderetornada;
    @Column(name = "DATAPREVISTADEVOLUCAO")
    @Temporal(TemporalType.DATE)
    private Date dataprevistadevolucao;
    @Column(name = "VALORRETORNADO")
    private BigDecimal valorretornado;
    @Lob
    @Column(name = "HISTORICO")
    private String historico;
    @Column(name = "MOTIVODEVOLUCAO")
    private String motivodevolucao;
    @JoinColumn(name = "CODFORN", referencedColumnName = "CODFORN")
    @ManyToOne
    private Fornecedor codforn;
    @JoinColumn(name = "CODMOVPROD", referencedColumnName = "CODMOVPROD")
    @ManyToOne
    private Movendaprod codmovprod;
    @JoinColumn(name = "CODPROD", referencedColumnName = "CODPROD")
    @ManyToOne(optional = false)
    private Produto codprod;
    @JoinColumn(name = "CODUSER", referencedColumnName = "CODUSER")
    @ManyToOne
    private Usuario coduser;

    public Movendaproddevolucaocompra() {
    }

    public Movendaproddevolucaocompra(String codmovendaproddevolucaocompra) {
        this.codmovendaproddevolucaocompra = codmovendaproddevolucaocompra;
    }

    public String getCodmovendaproddevolucaocompra() {
        return codmovendaproddevolucaocompra;
    }

    public void setCodmovendaproddevolucaocompra(String codmovendaproddevolucaocompra) {
        this.codmovendaproddevolucaocompra = codmovendaproddevolucaocompra;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorcusto() {
        return valorcusto;
    }

    public void setValorcusto(BigDecimal valorcusto) {
        this.valorcusto = valorcusto;
    }

    public Date getDatasaida() {
        return datasaida;
    }

    public void setDatasaida(Date datasaida) {
        this.datasaida = datasaida;
    }

    public BigDecimal getQuantidaderetornada() {
        return quantidaderetornada;
    }

    public void setQuantidaderetornada(BigDecimal quantidaderetornada) {
        this.quantidaderetornada = quantidaderetornada;
    }

    public Date getDataprevistadevolucao() {
        return dataprevistadevolucao;
    }

    public void setDataprevistadevolucao(Date dataprevistadevolucao) {
        this.dataprevistadevolucao = dataprevistadevolucao;
    }

    public BigDecimal getValorretornado() {
        return valorretornado;
    }

    public void setValorretornado(BigDecimal valorretornado) {
        this.valorretornado = valorretornado;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public String getMotivodevolucao() {
        return motivodevolucao;
    }

    public void setMotivodevolucao(String motivodevolucao) {
        this.motivodevolucao = motivodevolucao;
    }

    public Fornecedor getCodforn() {
        return codforn;
    }

    public void setCodforn(Fornecedor codforn) {
        this.codforn = codforn;
    }

    public Movendaprod getCodmovprod() {
        return codmovprod;
    }

    public void setCodmovprod(Movendaprod codmovprod) {
        this.codmovprod = codmovprod;
    }

    public Produto getCodprod() {
        return codprod;
    }

    public void setCodprod(Produto codprod) {
        this.codprod = codprod;
    }

    public Usuario getCoduser() {
        return coduser;
    }

    public void setCoduser(Usuario coduser) {
        this.coduser = coduser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codmovendaproddevolucaocompra != null ? codmovendaproddevolucaocompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movendaproddevolucaocompra)) {
            return false;
        }
        Movendaproddevolucaocompra other = (Movendaproddevolucaocompra) object;
        if ((this.codmovendaproddevolucaocompra == null && other.codmovendaproddevolucaocompra != null) || (this.codmovendaproddevolucaocompra != null && !this.codmovendaproddevolucaocompra.equals(other.codmovendaproddevolucaocompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Movendaproddevolucaocompra[ codmovendaproddevolucaocompra=" + codmovendaproddevolucaocompra + " ]";
    }
    
}
