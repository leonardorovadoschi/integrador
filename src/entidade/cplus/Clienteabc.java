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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "CLIENTEABC", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clienteabc.findAll", query = "SELECT c FROM Clienteabc c")
    , @NamedQuery(name = "Clienteabc.findByCodcli", query = "SELECT c FROM Clienteabc c WHERE c.codcli = :codcli")
    , @NamedQuery(name = "Clienteabc.findByDataultimacompra", query = "SELECT c FROM Clienteabc c WHERE c.dataultimacompra = :dataultimacompra")
    , @NamedQuery(name = "Clienteabc.findByRecencia", query = "SELECT c FROM Clienteabc c WHERE c.recencia = :recencia")
    , @NamedQuery(name = "Clienteabc.findByNumerocompras", query = "SELECT c FROM Clienteabc c WHERE c.numerocompras = :numerocompras")
    , @NamedQuery(name = "Clienteabc.findByTicketmedio", query = "SELECT c FROM Clienteabc c WHERE c.ticketmedio = :ticketmedio")
    , @NamedQuery(name = "Clienteabc.findByRankingrfv", query = "SELECT c FROM Clienteabc c WHERE c.rankingrfv = :rankingrfv")
    , @NamedQuery(name = "Clienteabc.findByValorrfv", query = "SELECT c FROM Clienteabc c WHERE c.valorrfv = :valorrfv")
    , @NamedQuery(name = "Clienteabc.findByClassificacaoabc", query = "SELECT c FROM Clienteabc c WHERE c.classificacaoabc = :classificacaoabc")
    , @NamedQuery(name = "Clienteabc.findByRanking", query = "SELECT c FROM Clienteabc c WHERE c.ranking = :ranking")
    , @NamedQuery(name = "Clienteabc.findByValoracumulado", query = "SELECT c FROM Clienteabc c WHERE c.valoracumulado = :valoracumulado")
    , @NamedQuery(name = "Clienteabc.findByPecsobreacumuladocliente", query = "SELECT c FROM Clienteabc c WHERE c.pecsobreacumuladocliente = :pecsobreacumuladocliente")
    , @NamedQuery(name = "Clienteabc.findByValortotalcompras", query = "SELECT c FROM Clienteabc c WHERE c.valortotalcompras = :valortotalcompras")
    , @NamedQuery(name = "Clienteabc.findByPercsobreacumulado", query = "SELECT c FROM Clienteabc c WHERE c.percsobreacumulado = :percsobreacumulado")
    , @NamedQuery(name = "Clienteabc.findByFrequencia", query = "SELECT c FROM Clienteabc c WHERE c.frequencia = :frequencia")
    , @NamedQuery(name = "Clienteabc.findByPercfrequencia", query = "SELECT c FROM Clienteabc c WHERE c.percfrequencia = :percfrequencia")})
public class Clienteabc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCLI")
    private String codcli;
    @Column(name = "DATAULTIMACOMPRA")
    @Temporal(TemporalType.DATE)
    private Date dataultimacompra;
    @Column(name = "RECENCIA")
    private Integer recencia;
    @Column(name = "NUMEROCOMPRAS")
    private Integer numerocompras;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TICKETMEDIO")
    private BigDecimal ticketmedio;
    @Column(name = "RANKINGRFV")
    private Integer rankingrfv;
    @Column(name = "VALORRFV")
    private Integer valorrfv;
    @Column(name = "CLASSIFICACAOABC")
    private Character classificacaoabc;
    @Column(name = "RANKING")
    private Integer ranking;
    @Column(name = "VALORACUMULADO")
    private BigDecimal valoracumulado;
    @Column(name = "PECSOBREACUMULADOCLIENTE")
    private BigDecimal pecsobreacumuladocliente;
    @Column(name = "VALORTOTALCOMPRAS")
    private BigDecimal valortotalcompras;
    @Column(name = "PERCSOBREACUMULADO")
    private BigDecimal percsobreacumulado;
    @Column(name = "FREQUENCIA")
    private Integer frequencia;
    @Column(name = "PERCFREQUENCIA")
    private BigDecimal percfrequencia;
    @JoinColumn(name = "CODCLI", referencedColumnName = "CODCLI", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Cliente cliente;

    public Clienteabc() {
    }

    public Clienteabc(String codcli) {
        this.codcli = codcli;
    }

    public String getCodcli() {
        return codcli;
    }

    public void setCodcli(String codcli) {
        this.codcli = codcli;
    }

    public Date getDataultimacompra() {
        return dataultimacompra;
    }

    public void setDataultimacompra(Date dataultimacompra) {
        this.dataultimacompra = dataultimacompra;
    }

    public Integer getRecencia() {
        return recencia;
    }

    public void setRecencia(Integer recencia) {
        this.recencia = recencia;
    }

    public Integer getNumerocompras() {
        return numerocompras;
    }

    public void setNumerocompras(Integer numerocompras) {
        this.numerocompras = numerocompras;
    }

    public BigDecimal getTicketmedio() {
        return ticketmedio;
    }

    public void setTicketmedio(BigDecimal ticketmedio) {
        this.ticketmedio = ticketmedio;
    }

    public Integer getRankingrfv() {
        return rankingrfv;
    }

    public void setRankingrfv(Integer rankingrfv) {
        this.rankingrfv = rankingrfv;
    }

    public Integer getValorrfv() {
        return valorrfv;
    }

    public void setValorrfv(Integer valorrfv) {
        this.valorrfv = valorrfv;
    }

    public Character getClassificacaoabc() {
        return classificacaoabc;
    }

    public void setClassificacaoabc(Character classificacaoabc) {
        this.classificacaoabc = classificacaoabc;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public BigDecimal getValoracumulado() {
        return valoracumulado;
    }

    public void setValoracumulado(BigDecimal valoracumulado) {
        this.valoracumulado = valoracumulado;
    }

    public BigDecimal getPecsobreacumuladocliente() {
        return pecsobreacumuladocliente;
    }

    public void setPecsobreacumuladocliente(BigDecimal pecsobreacumuladocliente) {
        this.pecsobreacumuladocliente = pecsobreacumuladocliente;
    }

    public BigDecimal getValortotalcompras() {
        return valortotalcompras;
    }

    public void setValortotalcompras(BigDecimal valortotalcompras) {
        this.valortotalcompras = valortotalcompras;
    }

    public BigDecimal getPercsobreacumulado() {
        return percsobreacumulado;
    }

    public void setPercsobreacumulado(BigDecimal percsobreacumulado) {
        this.percsobreacumulado = percsobreacumulado;
    }

    public Integer getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(Integer frequencia) {
        this.frequencia = frequencia;
    }

    public BigDecimal getPercfrequencia() {
        return percfrequencia;
    }

    public void setPercfrequencia(BigDecimal percfrequencia) {
        this.percfrequencia = percfrequencia;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcli != null ? codcli.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clienteabc)) {
            return false;
        }
        Clienteabc other = (Clienteabc) object;
        if ((this.codcli == null && other.codcli != null) || (this.codcli != null && !this.codcli.equals(other.codcli))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Clienteabc[ codcli=" + codcli + " ]";
    }
    
}
