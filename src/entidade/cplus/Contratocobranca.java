/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "CONTRATOCOBRANCA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contratocobranca.findAll", query = "SELECT c FROM Contratocobranca c")
    , @NamedQuery(name = "Contratocobranca.findByCodcontratocobranca", query = "SELECT c FROM Contratocobranca c WHERE c.codcontratocobranca = :codcontratocobranca")
    , @NamedQuery(name = "Contratocobranca.findByCodigo", query = "SELECT c FROM Contratocobranca c WHERE c.codigo = :codigo")
    , @NamedQuery(name = "Contratocobranca.findByNumdiavencimento", query = "SELECT c FROM Contratocobranca c WHERE c.numdiavencimento = :numdiavencimento")
    , @NamedQuery(name = "Contratocobranca.findByFlagtipomovimento", query = "SELECT c FROM Contratocobranca c WHERE c.flagtipomovimento = :flagtipomovimento")
    , @NamedQuery(name = "Contratocobranca.findByDatacadastro", query = "SELECT c FROM Contratocobranca c WHERE c.datacadastro = :datacadastro")
    , @NamedQuery(name = "Contratocobranca.findByValorcobranca", query = "SELECT c FROM Contratocobranca c WHERE c.valorcobranca = :valorcobranca")
    , @NamedQuery(name = "Contratocobranca.findByCoduser", query = "SELECT c FROM Contratocobranca c WHERE c.coduser = :coduser")
    , @NamedQuery(name = "Contratocobranca.findByDatavencimento", query = "SELECT c FROM Contratocobranca c WHERE c.datavencimento = :datavencimento")
    , @NamedQuery(name = "Contratocobranca.findByNomeentidadeorigem", query = "SELECT c FROM Contratocobranca c WHERE c.nomeentidadeorigem = :nomeentidadeorigem")
    , @NamedQuery(name = "Contratocobranca.findByIdentidadeorigem", query = "SELECT c FROM Contratocobranca c WHERE c.identidadeorigem = :identidadeorigem")
    , @NamedQuery(name = "Contratocobranca.findByDataemissao", query = "SELECT c FROM Contratocobranca c WHERE c.dataemissao = :dataemissao")
    , @NamedQuery(name = "Contratocobranca.findByCodpc", query = "SELECT c FROM Contratocobranca c WHERE c.codpc = :codpc")
    , @NamedQuery(name = "Contratocobranca.findByDataliberacao", query = "SELECT c FROM Contratocobranca c WHERE c.dataliberacao = :dataliberacao")
    , @NamedQuery(name = "Contratocobranca.findByCoduserliberacao", query = "SELECT c FROM Contratocobranca c WHERE c.coduserliberacao = :coduserliberacao")
    , @NamedQuery(name = "Contratocobranca.findByFlagrevenda", query = "SELECT c FROM Contratocobranca c WHERE c.flagrevenda = :flagrevenda")
    , @NamedQuery(name = "Contratocobranca.findByFlagexcluido", query = "SELECT c FROM Contratocobranca c WHERE c.flagexcluido = :flagexcluido")
    , @NamedQuery(name = "Contratocobranca.findByCodclifinanceiro", query = "SELECT c FROM Contratocobranca c WHERE c.codclifinanceiro = :codclifinanceiro")
    , @NamedQuery(name = "Contratocobranca.findByCodcentrocusto", query = "SELECT c FROM Contratocobranca c WHERE c.codcentrocusto = :codcentrocusto")
    , @NamedQuery(name = "Contratocobranca.findByFlagliberado", query = "SELECT c FROM Contratocobranca c WHERE c.flagliberado = :flagliberado")
    , @NamedQuery(name = "Contratocobranca.findByFlagdestino", query = "SELECT c FROM Contratocobranca c WHERE c.flagdestino = :flagdestino")})
public class Contratocobranca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCONTRATOCOBRANCA")
    private String codcontratocobranca;
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "NUMDIAVENCIMENTO")
    private Integer numdiavencimento;
    @Column(name = "FLAGTIPOMOVIMENTO")
    private Character flagtipomovimento;
    @Column(name = "DATACADASTRO")
    @Temporal(TemporalType.DATE)
    private Date datacadastro;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALORCOBRANCA")
    private BigDecimal valorcobranca;
    @Column(name = "CODUSER")
    private String coduser;
    @Column(name = "DATAVENCIMENTO")
    @Temporal(TemporalType.DATE)
    private Date datavencimento;
    @Column(name = "NOMEENTIDADEORIGEM")
    private String nomeentidadeorigem;
    @Column(name = "IDENTIDADEORIGEM")
    private String identidadeorigem;
    @Column(name = "DATAEMISSAO")
    @Temporal(TemporalType.DATE)
    private Date dataemissao;
    @Column(name = "CODPC")
    private String codpc;
    @Column(name = "DATALIBERACAO")
    @Temporal(TemporalType.DATE)
    private Date dataliberacao;
    @Column(name = "CODUSERLIBERACAO")
    private String coduserliberacao;
    @Column(name = "FLAGREVENDA")
    private Character flagrevenda;
    @Column(name = "FLAGEXCLUIDO")
    private Character flagexcluido;
    @Column(name = "CODCLIFINANCEIRO")
    private String codclifinanceiro;
    @Column(name = "CODCENTROCUSTO")
    private String codcentrocusto;
    @Column(name = "FLAGLIBERADO")
    private Character flagliberado;
    @Column(name = "FLAGDESTINO")
    private Character flagdestino;
    @JoinColumn(name = "CODCLI", referencedColumnName = "CODCLI")
    @ManyToOne
    private Cliente codcli;
    @JoinColumn(name = "CODCONTABANCARIA", referencedColumnName = "CODCONTABANCARIA")
    @ManyToOne
    private Contabancaria codcontabancaria;
    @JoinColumn(name = "CODEMPRESA", referencedColumnName = "CODEMPRESA")
    @ManyToOne
    private Empresa codempresa;
    @JoinColumn(name = "CODFP", referencedColumnName = "CODFP")
    @ManyToOne
    private Formapag codfp;
    @OneToMany(mappedBy = "codcontratocobranca")
    private Collection<Contratocobrancaproduto> contratocobrancaprodutoCollection;

    public Contratocobranca() {
    }

    public Contratocobranca(String codcontratocobranca) {
        this.codcontratocobranca = codcontratocobranca;
    }

    public String getCodcontratocobranca() {
        return codcontratocobranca;
    }

    public void setCodcontratocobranca(String codcontratocobranca) {
        this.codcontratocobranca = codcontratocobranca;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getNumdiavencimento() {
        return numdiavencimento;
    }

    public void setNumdiavencimento(Integer numdiavencimento) {
        this.numdiavencimento = numdiavencimento;
    }

    public Character getFlagtipomovimento() {
        return flagtipomovimento;
    }

    public void setFlagtipomovimento(Character flagtipomovimento) {
        this.flagtipomovimento = flagtipomovimento;
    }

    public Date getDatacadastro() {
        return datacadastro;
    }

    public void setDatacadastro(Date datacadastro) {
        this.datacadastro = datacadastro;
    }

    public BigDecimal getValorcobranca() {
        return valorcobranca;
    }

    public void setValorcobranca(BigDecimal valorcobranca) {
        this.valorcobranca = valorcobranca;
    }

    public String getCoduser() {
        return coduser;
    }

    public void setCoduser(String coduser) {
        this.coduser = coduser;
    }

    public Date getDatavencimento() {
        return datavencimento;
    }

    public void setDatavencimento(Date datavencimento) {
        this.datavencimento = datavencimento;
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

    public Date getDataemissao() {
        return dataemissao;
    }

    public void setDataemissao(Date dataemissao) {
        this.dataemissao = dataemissao;
    }

    public String getCodpc() {
        return codpc;
    }

    public void setCodpc(String codpc) {
        this.codpc = codpc;
    }

    public Date getDataliberacao() {
        return dataliberacao;
    }

    public void setDataliberacao(Date dataliberacao) {
        this.dataliberacao = dataliberacao;
    }

    public String getCoduserliberacao() {
        return coduserliberacao;
    }

    public void setCoduserliberacao(String coduserliberacao) {
        this.coduserliberacao = coduserliberacao;
    }

    public Character getFlagrevenda() {
        return flagrevenda;
    }

    public void setFlagrevenda(Character flagrevenda) {
        this.flagrevenda = flagrevenda;
    }

    public Character getFlagexcluido() {
        return flagexcluido;
    }

    public void setFlagexcluido(Character flagexcluido) {
        this.flagexcluido = flagexcluido;
    }

    public String getCodclifinanceiro() {
        return codclifinanceiro;
    }

    public void setCodclifinanceiro(String codclifinanceiro) {
        this.codclifinanceiro = codclifinanceiro;
    }

    public String getCodcentrocusto() {
        return codcentrocusto;
    }

    public void setCodcentrocusto(String codcentrocusto) {
        this.codcentrocusto = codcentrocusto;
    }

    public Character getFlagliberado() {
        return flagliberado;
    }

    public void setFlagliberado(Character flagliberado) {
        this.flagliberado = flagliberado;
    }

    public Character getFlagdestino() {
        return flagdestino;
    }

    public void setFlagdestino(Character flagdestino) {
        this.flagdestino = flagdestino;
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

    public Empresa getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Empresa codempresa) {
        this.codempresa = codempresa;
    }

    public Formapag getCodfp() {
        return codfp;
    }

    public void setCodfp(Formapag codfp) {
        this.codfp = codfp;
    }

    @XmlTransient
    public Collection<Contratocobrancaproduto> getContratocobrancaprodutoCollection() {
        return contratocobrancaprodutoCollection;
    }

    public void setContratocobrancaprodutoCollection(Collection<Contratocobrancaproduto> contratocobrancaprodutoCollection) {
        this.contratocobrancaprodutoCollection = contratocobrancaprodutoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcontratocobranca != null ? codcontratocobranca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contratocobranca)) {
            return false;
        }
        Contratocobranca other = (Contratocobranca) object;
        if ((this.codcontratocobranca == null && other.codcontratocobranca != null) || (this.codcontratocobranca != null && !this.codcontratocobranca.equals(other.codcontratocobranca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Contratocobranca[ codcontratocobranca=" + codcontratocobranca + " ]";
    }
    
}
