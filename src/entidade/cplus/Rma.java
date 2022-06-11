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
@Table(name = "RMA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rma.findAll", query = "SELECT r FROM Rma r")
    , @NamedQuery(name = "Rma.findByCodrma", query = "SELECT r FROM Rma r WHERE r.codrma = :codrma")
    , @NamedQuery(name = "Rma.findByDatavenda", query = "SELECT r FROM Rma r WHERE r.datavenda = :datavenda")
    , @NamedQuery(name = "Rma.findByNumped", query = "SELECT r FROM Rma r WHERE r.numped = :numped")
    , @NamedQuery(name = "Rma.findByNumcupom", query = "SELECT r FROM Rma r WHERE r.numcupom = :numcupom")
    , @NamedQuery(name = "Rma.findByQuantidade", query = "SELECT r FROM Rma r WHERE r.quantidade = :quantidade")
    , @NamedQuery(name = "Rma.findByValor", query = "SELECT r FROM Rma r WHERE r.valor = :valor")
    , @NamedQuery(name = "Rma.findByLoterma", query = "SELECT r FROM Rma r WHERE r.loterma = :loterma")
    , @NamedQuery(name = "Rma.findByDatalancamento", query = "SELECT r FROM Rma r WHERE r.datalancamento = :datalancamento")
    , @NamedQuery(name = "Rma.findByFlagtipo", query = "SELECT r FROM Rma r WHERE r.flagtipo = :flagtipo")
    , @NamedQuery(name = "Rma.findByNumvale", query = "SELECT r FROM Rma r WHERE r.numvale = :numvale")
    , @NamedQuery(name = "Rma.findByCodmovprod", query = "SELECT r FROM Rma r WHERE r.codmovprod = :codmovprod")
    , @NamedQuery(name = "Rma.findByStatus", query = "SELECT r FROM Rma r WHERE r.status = :status")
    , @NamedQuery(name = "Rma.findByQuantidadeenviada", query = "SELECT r FROM Rma r WHERE r.quantidadeenviada = :quantidadeenviada")
    , @NamedQuery(name = "Rma.findByCodempresa", query = "SELECT r FROM Rma r WHERE r.codempresa = :codempresa")
    , @NamedQuery(name = "Rma.findByQuantidaderecebida", query = "SELECT r FROM Rma r WHERE r.quantidaderecebida = :quantidaderecebida")})
public class Rma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODRMA")
    private Integer codrma;
    @Column(name = "DATAVENDA")
    @Temporal(TemporalType.DATE)
    private Date datavenda;
    @Column(name = "NUMPED")
    private Integer numped;
    @Column(name = "NUMCUPOM")
    private Integer numcupom;
    @Column(name = "QUANTIDADE")
    private Integer quantidade;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALOR")
    private BigDecimal valor;
    @Lob
    @Column(name = "OBS")
    private String obs;
    @Column(name = "LOTERMA")
    private Integer loterma;
    @Column(name = "DATALANCAMENTO")
    @Temporal(TemporalType.DATE)
    private Date datalancamento;
    @Column(name = "FLAGTIPO")
    private Character flagtipo;
    @Column(name = "NUMVALE")
    private Integer numvale;
    @Column(name = "CODMOVPROD")
    private String codmovprod;
    @Column(name = "STATUS")
    private Character status;
    @Column(name = "QUANTIDADEENVIADA")
    private Integer quantidadeenviada;
    @Column(name = "CODEMPRESA")
    private Integer codempresa;
    @Column(name = "QUANTIDADERECEBIDA")
    private Integer quantidaderecebida;
    @JoinColumn(name = "CODCLI", referencedColumnName = "CODCLI")
    @ManyToOne
    private Cliente codcli;
    @JoinColumn(name = "CODMOVENTR", referencedColumnName = "CODMOVENTR")
    @ManyToOne
    private Moventrada codmoventr;
    @JoinColumn(name = "CODMOVEPROD", referencedColumnName = "CODMOVEPROD")
    @ManyToOne
    private Moventradaprod codmoveprod;
    @JoinColumn(name = "CODPROD", referencedColumnName = "CODPROD")
    @ManyToOne
    private Produto codprod;
    @JoinColumn(name = "CODREC", referencedColumnName = "CODREC")
    @ManyToOne
    private Recebimento codrec;
    @JoinColumn(name = "CODUSER", referencedColumnName = "CODUSER")
    @ManyToOne
    private Usuario coduser;
    @JoinColumn(name = "CODVENDED", referencedColumnName = "CODVENDED")
    @ManyToOne
    private Vendedor codvended;

    public Rma() {
    }

    public Rma(Integer codrma) {
        this.codrma = codrma;
    }

    public Integer getCodrma() {
        return codrma;
    }

    public void setCodrma(Integer codrma) {
        this.codrma = codrma;
    }

    public Date getDatavenda() {
        return datavenda;
    }

    public void setDatavenda(Date datavenda) {
        this.datavenda = datavenda;
    }

    public Integer getNumped() {
        return numped;
    }

    public void setNumped(Integer numped) {
        this.numped = numped;
    }

    public Integer getNumcupom() {
        return numcupom;
    }

    public void setNumcupom(Integer numcupom) {
        this.numcupom = numcupom;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Integer getLoterma() {
        return loterma;
    }

    public void setLoterma(Integer loterma) {
        this.loterma = loterma;
    }

    public Date getDatalancamento() {
        return datalancamento;
    }

    public void setDatalancamento(Date datalancamento) {
        this.datalancamento = datalancamento;
    }

    public Character getFlagtipo() {
        return flagtipo;
    }

    public void setFlagtipo(Character flagtipo) {
        this.flagtipo = flagtipo;
    }

    public Integer getNumvale() {
        return numvale;
    }

    public void setNumvale(Integer numvale) {
        this.numvale = numvale;
    }

    public String getCodmovprod() {
        return codmovprod;
    }

    public void setCodmovprod(String codmovprod) {
        this.codmovprod = codmovprod;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public Integer getQuantidadeenviada() {
        return quantidadeenviada;
    }

    public void setQuantidadeenviada(Integer quantidadeenviada) {
        this.quantidadeenviada = quantidadeenviada;
    }

    public Integer getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Integer codempresa) {
        this.codempresa = codempresa;
    }

    public Integer getQuantidaderecebida() {
        return quantidaderecebida;
    }

    public void setQuantidaderecebida(Integer quantidaderecebida) {
        this.quantidaderecebida = quantidaderecebida;
    }

    public Cliente getCodcli() {
        return codcli;
    }

    public void setCodcli(Cliente codcli) {
        this.codcli = codcli;
    }

    public Moventrada getCodmoventr() {
        return codmoventr;
    }

    public void setCodmoventr(Moventrada codmoventr) {
        this.codmoventr = codmoventr;
    }

    public Moventradaprod getCodmoveprod() {
        return codmoveprod;
    }

    public void setCodmoveprod(Moventradaprod codmoveprod) {
        this.codmoveprod = codmoveprod;
    }

    public Produto getCodprod() {
        return codprod;
    }

    public void setCodprod(Produto codprod) {
        this.codprod = codprod;
    }

    public Recebimento getCodrec() {
        return codrec;
    }

    public void setCodrec(Recebimento codrec) {
        this.codrec = codrec;
    }

    public Usuario getCoduser() {
        return coduser;
    }

    public void setCoduser(Usuario coduser) {
        this.coduser = coduser;
    }

    public Vendedor getCodvended() {
        return codvended;
    }

    public void setCodvended(Vendedor codvended) {
        this.codvended = codvended;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codrma != null ? codrma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rma)) {
            return false;
        }
        Rma other = (Rma) object;
        if ((this.codrma == null && other.codrma != null) || (this.codrma != null && !this.codrma.equals(other.codrma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Rma[ codrma=" + codrma + " ]";
    }
    
}
