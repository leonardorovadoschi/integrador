/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "CONTARECEBERFIXA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contareceberfixa.findAll", query = "SELECT c FROM Contareceberfixa c")
    , @NamedQuery(name = "Contareceberfixa.findByCodcrfixa", query = "SELECT c FROM Contareceberfixa c WHERE c.codcrfixa = :codcrfixa")
    , @NamedQuery(name = "Contareceberfixa.findByCodigo", query = "SELECT c FROM Contareceberfixa c WHERE c.codigo = :codigo")
    , @NamedQuery(name = "Contareceberfixa.findByValor", query = "SELECT c FROM Contareceberfixa c WHERE c.valor = :valor")
    , @NamedQuery(name = "Contareceberfixa.findByDia", query = "SELECT c FROM Contareceberfixa c WHERE c.dia = :dia")
    , @NamedQuery(name = "Contareceberfixa.findByHistorico", query = "SELECT c FROM Contareceberfixa c WHERE c.historico = :historico")
    , @NamedQuery(name = "Contareceberfixa.findByLocal", query = "SELECT c FROM Contareceberfixa c WHERE c.local = :local")
    , @NamedQuery(name = "Contareceberfixa.findByTipocobra", query = "SELECT c FROM Contareceberfixa c WHERE c.tipocobra = :tipocobra")
    , @NamedQuery(name = "Contareceberfixa.findByDevedor", query = "SELECT c FROM Contareceberfixa c WHERE c.devedor = :devedor")
    , @NamedQuery(name = "Contareceberfixa.findByCodempresa", query = "SELECT c FROM Contareceberfixa c WHERE c.codempresa = :codempresa")
    , @NamedQuery(name = "Contareceberfixa.findByCodsituacaoadministrativa", query = "SELECT c FROM Contareceberfixa c WHERE c.codsituacaoadministrativa = :codsituacaoadministrativa")
    , @NamedQuery(name = "Contareceberfixa.findByValorcomissao", query = "SELECT c FROM Contareceberfixa c WHERE c.valorcomissao = :valorcomissao")
    , @NamedQuery(name = "Contareceberfixa.findByDescatevenc", query = "SELECT c FROM Contareceberfixa c WHERE c.descatevenc = :descatevenc")})
public class Contareceberfixa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCRFIXA")
    private String codcrfixa;
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
    @Column(name = "TIPOCOBRA")
    private String tipocobra;
    @Column(name = "DEVEDOR")
    private String devedor;
    @Basic(optional = false)
    @Column(name = "CODEMPRESA")
    private int codempresa;
    @Column(name = "CODSITUACAOADMINISTRATIVA")
    private String codsituacaoadministrativa;
    @Lob
    @Column(name = "OBS")
    private String obs;
    @Column(name = "VALORCOMISSAO")
    private BigDecimal valorcomissao;
    @Column(name = "DESCATEVENC")
    private BigDecimal descatevenc;
    @JoinColumn(name = "CODCLI", referencedColumnName = "CODCLI")
    @ManyToOne
    private Cliente codcli;
    @JoinColumn(name = "CODCONTABANCARIA", referencedColumnName = "CODCONTABANCARIA")
    @ManyToOne
    private Contabancaria codcontabancaria;
    @JoinColumn(name = "CODPC", referencedColumnName = "CODPC")
    @ManyToOne
    private Planoconta codpc;
    @OneToMany(mappedBy = "codcrfixa")
    private Collection<Contareceber> contareceberCollection;

    public Contareceberfixa() {
    }

    public Contareceberfixa(String codcrfixa) {
        this.codcrfixa = codcrfixa;
    }

    public Contareceberfixa(String codcrfixa, String codigo, int codempresa) {
        this.codcrfixa = codcrfixa;
        this.codigo = codigo;
        this.codempresa = codempresa;
    }

    public String getCodcrfixa() {
        return codcrfixa;
    }

    public void setCodcrfixa(String codcrfixa) {
        this.codcrfixa = codcrfixa;
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

    public String getTipocobra() {
        return tipocobra;
    }

    public void setTipocobra(String tipocobra) {
        this.tipocobra = tipocobra;
    }

    public String getDevedor() {
        return devedor;
    }

    public void setDevedor(String devedor) {
        this.devedor = devedor;
    }

    public int getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(int codempresa) {
        this.codempresa = codempresa;
    }

    public String getCodsituacaoadministrativa() {
        return codsituacaoadministrativa;
    }

    public void setCodsituacaoadministrativa(String codsituacaoadministrativa) {
        this.codsituacaoadministrativa = codsituacaoadministrativa;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public BigDecimal getValorcomissao() {
        return valorcomissao;
    }

    public void setValorcomissao(BigDecimal valorcomissao) {
        this.valorcomissao = valorcomissao;
    }

    public BigDecimal getDescatevenc() {
        return descatevenc;
    }

    public void setDescatevenc(BigDecimal descatevenc) {
        this.descatevenc = descatevenc;
    }

    public Cliente getCodcli() {
        return codcli;
    }

    public void setCodcli(Cliente codcli) {
        this.codcli = codcli;
    }

    public Contabancaria getCodcontabancaria() {
        return codcontabancaria;
    }

    public void setCodcontabancaria(Contabancaria codcontabancaria) {
        this.codcontabancaria = codcontabancaria;
    }

    public Planoconta getCodpc() {
        return codpc;
    }

    public void setCodpc(Planoconta codpc) {
        this.codpc = codpc;
    }

    @XmlTransient
    public Collection<Contareceber> getContareceberCollection() {
        return contareceberCollection;
    }

    public void setContareceberCollection(Collection<Contareceber> contareceberCollection) {
        this.contareceberCollection = contareceberCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcrfixa != null ? codcrfixa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contareceberfixa)) {
            return false;
        }
        Contareceberfixa other = (Contareceberfixa) object;
        if ((this.codcrfixa == null && other.codcrfixa != null) || (this.codcrfixa != null && !this.codcrfixa.equals(other.codcrfixa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Contareceberfixa[ codcrfixa=" + codcrfixa + " ]";
    }
    
}
