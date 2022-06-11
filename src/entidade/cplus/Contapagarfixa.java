/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "CONTAPAGARFIXA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contapagarfixa.findAll", query = "SELECT c FROM Contapagarfixa c")
    , @NamedQuery(name = "Contapagarfixa.findByCodcpfixa", query = "SELECT c FROM Contapagarfixa c WHERE c.codcpfixa = :codcpfixa")
    , @NamedQuery(name = "Contapagarfixa.findByCodigo", query = "SELECT c FROM Contapagarfixa c WHERE c.codigo = :codigo")
    , @NamedQuery(name = "Contapagarfixa.findByValor", query = "SELECT c FROM Contapagarfixa c WHERE c.valor = :valor")
    , @NamedQuery(name = "Contapagarfixa.findByDia", query = "SELECT c FROM Contapagarfixa c WHERE c.dia = :dia")
    , @NamedQuery(name = "Contapagarfixa.findByHistorico", query = "SELECT c FROM Contapagarfixa c WHERE c.historico = :historico")
    , @NamedQuery(name = "Contapagarfixa.findByLocal", query = "SELECT c FROM Contapagarfixa c WHERE c.local = :local")
    , @NamedQuery(name = "Contapagarfixa.findByCredor", query = "SELECT c FROM Contapagarfixa c WHERE c.credor = :credor")
    , @NamedQuery(name = "Contapagarfixa.findByCodempresa", query = "SELECT c FROM Contapagarfixa c WHERE c.codempresa = :codempresa")})
public class Contapagarfixa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCPFIXA")
    private String codcpfixa;
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private String codigo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALOR")
    private BigDecimal valor;
    @Column(name = "DIA")
    private Short dia;
    @Column(name = "HISTORICO")
    private String historico;
    @Column(name = "LOCAL")
    private String local;
    @Column(name = "CREDOR")
    private String credor;
    @Basic(optional = false)
    @Column(name = "CODEMPRESA")
    private int codempresa;
    @JoinColumn(name = "CODCAIXAS", referencedColumnName = "CODCAIXAS")
    @ManyToOne
    private Caixas codcaixas;
    @JoinColumn(name = "CODCENTROCUSTO", referencedColumnName = "CODCENTROCUSTO")
    @ManyToOne
    private Centrocusto codcentrocusto;
    @JoinColumn(name = "CODFORN", referencedColumnName = "CODFORN")
    @ManyToOne
    private Fornecedor codforn;
    @JoinColumn(name = "CODPC", referencedColumnName = "CODPC")
    @ManyToOne
    private Planoconta codpc;

    public Contapagarfixa() {
    }

    public Contapagarfixa(String codcpfixa) {
        this.codcpfixa = codcpfixa;
    }

    public Contapagarfixa(String codcpfixa, String codigo, int codempresa) {
        this.codcpfixa = codcpfixa;
        this.codigo = codigo;
        this.codempresa = codempresa;
    }

    public String getCodcpfixa() {
        return codcpfixa;
    }

    public void setCodcpfixa(String codcpfixa) {
        this.codcpfixa = codcpfixa;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Short getDia() {
        return dia;
    }

    public void setDia(Short dia) {
        this.dia = dia;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getCredor() {
        return credor;
    }

    public void setCredor(String credor) {
        this.credor = credor;
    }

    public int getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(int codempresa) {
        this.codempresa = codempresa;
    }

    public Caixas getCodcaixas() {
        return codcaixas;
    }

    public void setCodcaixas(Caixas codcaixas) {
        this.codcaixas = codcaixas;
    }

    public Centrocusto getCodcentrocusto() {
        return codcentrocusto;
    }

    public void setCodcentrocusto(Centrocusto codcentrocusto) {
        this.codcentrocusto = codcentrocusto;
    }

    public Fornecedor getCodforn() {
        return codforn;
    }

    public void setCodforn(Fornecedor codforn) {
        this.codforn = codforn;
    }

    public Planoconta getCodpc() {
        return codpc;
    }

    public void setCodpc(Planoconta codpc) {
        this.codpc = codpc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcpfixa != null ? codcpfixa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contapagarfixa)) {
            return false;
        }
        Contapagarfixa other = (Contapagarfixa) object;
        if ((this.codcpfixa == null && other.codcpfixa != null) || (this.codcpfixa != null && !this.codcpfixa.equals(other.codcpfixa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Contapagarfixa[ codcpfixa=" + codcpfixa + " ]";
    }
    
}
