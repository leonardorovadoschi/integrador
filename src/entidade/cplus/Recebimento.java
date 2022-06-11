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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "RECEBIMENTO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recebimento.findAll", query = "SELECT r FROM Recebimento r")
    , @NamedQuery(name = "Recebimento.findByCodrec", query = "SELECT r FROM Recebimento r WHERE r.codrec = :codrec")
    , @NamedQuery(name = "Recebimento.findByCodigo", query = "SELECT r FROM Recebimento r WHERE r.codigo = :codigo")
    , @NamedQuery(name = "Recebimento.findByRecebimento", query = "SELECT r FROM Recebimento r WHERE r.recebimento = :recebimento")
    , @NamedQuery(name = "Recebimento.findByFixo", query = "SELECT r FROM Recebimento r WHERE r.fixo = :fixo")
    , @NamedQuery(name = "Recebimento.findByFlagtipo", query = "SELECT r FROM Recebimento r WHERE r.flagtipo = :flagtipo")
    , @NamedQuery(name = "Recebimento.findByStatus", query = "SELECT r FROM Recebimento r WHERE r.status = :status")
    , @NamedQuery(name = "Recebimento.findByMensagem", query = "SELECT r FROM Recebimento r WHERE r.mensagem = :mensagem")
    , @NamedQuery(name = "Recebimento.findByNomeecf", query = "SELECT r FROM Recebimento r WHERE r.nomeecf = :nomeecf")
    , @NamedQuery(name = "Recebimento.findByTef", query = "SELECT r FROM Recebimento r WHERE r.tef = :tef")
    , @NamedQuery(name = "Recebimento.findByPercdesconto", query = "SELECT r FROM Recebimento r WHERE r.percdesconto = :percdesconto")
    , @NamedQuery(name = "Recebimento.findByCodcli", query = "SELECT r FROM Recebimento r WHERE r.codcli = :codcli")
    , @NamedQuery(name = "Recebimento.findByCodsituacaoadministrativa", query = "SELECT r FROM Recebimento r WHERE r.codsituacaoadministrativa = :codsituacaoadministrativa")
    , @NamedQuery(name = "Recebimento.findByTipocobra", query = "SELECT r FROM Recebimento r WHERE r.tipocobra = :tipocobra")
    , @NamedQuery(name = "Recebimento.findByFlaglancacaixafechamento", query = "SELECT r FROM Recebimento r WHERE r.flaglancacaixafechamento = :flaglancacaixafechamento")
    , @NamedQuery(name = "Recebimento.findByFlagnaolancamovimento", query = "SELECT r FROM Recebimento r WHERE r.flagnaolancamovimento = :flagnaolancamovimento")
    , @NamedQuery(name = "Recebimento.findByFlagnaobloqueia", query = "SELECT r FROM Recebimento r WHERE r.flagnaobloqueia = :flagnaobloqueia")
    , @NamedQuery(name = "Recebimento.findByFlagnuncalancacaixa", query = "SELECT r FROM Recebimento r WHERE r.flagnuncalancacaixa = :flagnuncalancacaixa")
    , @NamedQuery(name = "Recebimento.findByTipocartao", query = "SELECT r FROM Recebimento r WHERE r.tipocartao = :tipocartao")
    , @NamedQuery(name = "Recebimento.findByFlagtroco", query = "SELECT r FROM Recebimento r WHERE r.flagtroco = :flagtroco")
    , @NamedQuery(name = "Recebimento.findByBandeira", query = "SELECT r FROM Recebimento r WHERE r.bandeira = :bandeira")
    , @NamedQuery(name = "Recebimento.findByCnpjcredenciadoracartao", query = "SELECT r FROM Recebimento r WHERE r.cnpjcredenciadoracartao = :cnpjcredenciadoracartao")
    , @NamedQuery(name = "Recebimento.findByFlagredetef", query = "SELECT r FROM Recebimento r WHERE r.flagredetef = :flagredetef")
    , @NamedQuery(name = "Recebimento.findByDescricaocurta", query = "SELECT r FROM Recebimento r WHERE r.descricaocurta = :descricaocurta")})
public class Recebimento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODREC")
    private String codrec;
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private String codigo;
    @Basic(optional = false)
    @Column(name = "RECEBIMENTO")
    private String recebimento;
    @Basic(optional = false)
    @Column(name = "FIXO")
    private Character fixo;
    @Column(name = "FLAGTIPO")
    private Character flagtipo;
    @Column(name = "STATUS")
    private Character status;
    @Column(name = "MENSAGEM")
    private String mensagem;
    @Column(name = "NOMEECF")
    private String nomeecf;
    @Column(name = "TEF")
    private Integer tef;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PERCDESCONTO")
    private BigDecimal percdesconto;
    @Column(name = "CODCLI")
    private String codcli;
    @Column(name = "CODSITUACAOADMINISTRATIVA")
    private String codsituacaoadministrativa;
    @Column(name = "TIPOCOBRA")
    private String tipocobra;
    @Column(name = "FLAGLANCACAIXAFECHAMENTO")
    private Character flaglancacaixafechamento;
    @Column(name = "FLAGNAOLANCAMOVIMENTO")
    private Character flagnaolancamovimento;
    @Column(name = "FLAGNAOBLOQUEIA")
    private Character flagnaobloqueia;
    @Column(name = "FLAGNUNCALANCACAIXA")
    private Character flagnuncalancacaixa;
    @Column(name = "TIPOCARTAO")
    private Character tipocartao;
    @Column(name = "FLAGTROCO")
    private Character flagtroco;
    @Column(name = "BANDEIRA")
    private Short bandeira;
    @Column(name = "CNPJCREDENCIADORACARTAO")
    private String cnpjcredenciadoracartao;
    @Column(name = "FLAGREDETEF")
    private Short flagredetef;
    @Column(name = "DESCRICAOCURTA")
    private String descricaocurta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codrec")
    private Collection<Orcamentorec> orcamentorecCollection;
    @OneToMany(mappedBy = "codrec")
    private Collection<Rma> rmaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codrec")
    private Collection<Movendarec> movendarecCollection;
    @JoinColumn(name = "CODCENTROCUSTO", referencedColumnName = "CODCENTROCUSTO")
    @ManyToOne
    private Centrocusto codcentrocusto;
    @JoinColumn(name = "CODCONTABANCARIA", referencedColumnName = "CODCONTABANCARIA")
    @ManyToOne
    private Contabancaria codcontabancaria;
    @JoinColumn(name = "CODPC", referencedColumnName = "CODPC")
    @ManyToOne
    private Planoconta codpc;
    @OneToMany(mappedBy = "codrec")
    private Collection<Caixausuario> caixausuarioCollection;
    @OneToMany(mappedBy = "codrec")
    private Collection<Conferenciacaixaitem> conferenciacaixaitemCollection;
    @OneToMany(mappedBy = "codrec")
    private Collection<Movimentocaixa> movimentocaixaCollection;

    public Recebimento() {
    }

    public Recebimento(String codrec) {
        this.codrec = codrec;
    }

    public Recebimento(String codrec, String codigo, String recebimento, Character fixo) {
        this.codrec = codrec;
        this.codigo = codigo;
        this.recebimento = recebimento;
        this.fixo = fixo;
    }

    public String getCodrec() {
        return codrec;
    }

    public void setCodrec(String codrec) {
        this.codrec = codrec;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getRecebimento() {
        return recebimento;
    }

    public void setRecebimento(String recebimento) {
        this.recebimento = recebimento;
    }

    public Character getFixo() {
        return fixo;
    }

    public void setFixo(Character fixo) {
        this.fixo = fixo;
    }

    public Character getFlagtipo() {
        return flagtipo;
    }

    public void setFlagtipo(Character flagtipo) {
        this.flagtipo = flagtipo;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getNomeecf() {
        return nomeecf;
    }

    public void setNomeecf(String nomeecf) {
        this.nomeecf = nomeecf;
    }

    public Integer getTef() {
        return tef;
    }

    public void setTef(Integer tef) {
        this.tef = tef;
    }

    public BigDecimal getPercdesconto() {
        return percdesconto;
    }

    public void setPercdesconto(BigDecimal percdesconto) {
        this.percdesconto = percdesconto;
    }

    public String getCodcli() {
        return codcli;
    }

    public void setCodcli(String codcli) {
        this.codcli = codcli;
    }

    public String getCodsituacaoadministrativa() {
        return codsituacaoadministrativa;
    }

    public void setCodsituacaoadministrativa(String codsituacaoadministrativa) {
        this.codsituacaoadministrativa = codsituacaoadministrativa;
    }

    public String getTipocobra() {
        return tipocobra;
    }

    public void setTipocobra(String tipocobra) {
        this.tipocobra = tipocobra;
    }

    public Character getFlaglancacaixafechamento() {
        return flaglancacaixafechamento;
    }

    public void setFlaglancacaixafechamento(Character flaglancacaixafechamento) {
        this.flaglancacaixafechamento = flaglancacaixafechamento;
    }

    public Character getFlagnaolancamovimento() {
        return flagnaolancamovimento;
    }

    public void setFlagnaolancamovimento(Character flagnaolancamovimento) {
        this.flagnaolancamovimento = flagnaolancamovimento;
    }

    public Character getFlagnaobloqueia() {
        return flagnaobloqueia;
    }

    public void setFlagnaobloqueia(Character flagnaobloqueia) {
        this.flagnaobloqueia = flagnaobloqueia;
    }

    public Character getFlagnuncalancacaixa() {
        return flagnuncalancacaixa;
    }

    public void setFlagnuncalancacaixa(Character flagnuncalancacaixa) {
        this.flagnuncalancacaixa = flagnuncalancacaixa;
    }

    public Character getTipocartao() {
        return tipocartao;
    }

    public void setTipocartao(Character tipocartao) {
        this.tipocartao = tipocartao;
    }

    public Character getFlagtroco() {
        return flagtroco;
    }

    public void setFlagtroco(Character flagtroco) {
        this.flagtroco = flagtroco;
    }

    public Short getBandeira() {
        return bandeira;
    }

    public void setBandeira(Short bandeira) {
        this.bandeira = bandeira;
    }

    public String getCnpjcredenciadoracartao() {
        return cnpjcredenciadoracartao;
    }

    public void setCnpjcredenciadoracartao(String cnpjcredenciadoracartao) {
        this.cnpjcredenciadoracartao = cnpjcredenciadoracartao;
    }

    public Short getFlagredetef() {
        return flagredetef;
    }

    public void setFlagredetef(Short flagredetef) {
        this.flagredetef = flagredetef;
    }

    public String getDescricaocurta() {
        return descricaocurta;
    }

    public void setDescricaocurta(String descricaocurta) {
        this.descricaocurta = descricaocurta;
    }

    @XmlTransient
    public Collection<Orcamentorec> getOrcamentorecCollection() {
        return orcamentorecCollection;
    }

    public void setOrcamentorecCollection(Collection<Orcamentorec> orcamentorecCollection) {
        this.orcamentorecCollection = orcamentorecCollection;
    }

    @XmlTransient
    public Collection<Rma> getRmaCollection() {
        return rmaCollection;
    }

    public void setRmaCollection(Collection<Rma> rmaCollection) {
        this.rmaCollection = rmaCollection;
    }

    @XmlTransient
    public Collection<Movendarec> getMovendarecCollection() {
        return movendarecCollection;
    }

    public void setMovendarecCollection(Collection<Movendarec> movendarecCollection) {
        this.movendarecCollection = movendarecCollection;
    }

    public Centrocusto getCodcentrocusto() {
        return codcentrocusto;
    }

    public void setCodcentrocusto(Centrocusto codcentrocusto) {
        this.codcentrocusto = codcentrocusto;
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
    public Collection<Caixausuario> getCaixausuarioCollection() {
        return caixausuarioCollection;
    }

    public void setCaixausuarioCollection(Collection<Caixausuario> caixausuarioCollection) {
        this.caixausuarioCollection = caixausuarioCollection;
    }

    @XmlTransient
    public Collection<Conferenciacaixaitem> getConferenciacaixaitemCollection() {
        return conferenciacaixaitemCollection;
    }

    public void setConferenciacaixaitemCollection(Collection<Conferenciacaixaitem> conferenciacaixaitemCollection) {
        this.conferenciacaixaitemCollection = conferenciacaixaitemCollection;
    }

    @XmlTransient
    public Collection<Movimentocaixa> getMovimentocaixaCollection() {
        return movimentocaixaCollection;
    }

    public void setMovimentocaixaCollection(Collection<Movimentocaixa> movimentocaixaCollection) {
        this.movimentocaixaCollection = movimentocaixaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codrec != null ? codrec.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recebimento)) {
            return false;
        }
        Recebimento other = (Recebimento) object;
        if ((this.codrec == null && other.codrec != null) || (this.codrec != null && !this.codrec.equals(other.codrec))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Recebimento[ codrec=" + codrec + " ]";
    }
    
}
