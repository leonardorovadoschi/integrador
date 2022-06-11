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
@Table(name = "ORCAMENTOPRODPHARMA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orcamentoprodpharma.findAll", query = "SELECT o FROM Orcamentoprodpharma o")
    , @NamedQuery(name = "Orcamentoprodpharma.findByCodorcprodpharma", query = "SELECT o FROM Orcamentoprodpharma o WHERE o.codorcprodpharma = :codorcprodpharma")
    , @NamedQuery(name = "Orcamentoprodpharma.findByNomepaciente", query = "SELECT o FROM Orcamentoprodpharma o WHERE o.nomepaciente = :nomepaciente")
    , @NamedQuery(name = "Orcamentoprodpharma.findByEndereco", query = "SELECT o FROM Orcamentoprodpharma o WHERE o.endereco = :endereco")
    , @NamedQuery(name = "Orcamentoprodpharma.findByNumdocumento", query = "SELECT o FROM Orcamentoprodpharma o WHERE o.numdocumento = :numdocumento")
    , @NamedQuery(name = "Orcamentoprodpharma.findByCpf", query = "SELECT o FROM Orcamentoprodpharma o WHERE o.cpf = :cpf")
    , @NamedQuery(name = "Orcamentoprodpharma.findByTelefone", query = "SELECT o FROM Orcamentoprodpharma o WHERE o.telefone = :telefone")
    , @NamedQuery(name = "Orcamentoprodpharma.findByNomemedico", query = "SELECT o FROM Orcamentoprodpharma o WHERE o.nomemedico = :nomemedico")
    , @NamedQuery(name = "Orcamentoprodpharma.findByNumerocrm", query = "SELECT o FROM Orcamentoprodpharma o WHERE o.numerocrm = :numerocrm")
    , @NamedQuery(name = "Orcamentoprodpharma.findByNumeronotificacao", query = "SELECT o FROM Orcamentoprodpharma o WHERE o.numeronotificacao = :numeronotificacao")
    , @NamedQuery(name = "Orcamentoprodpharma.findByDatanotificacao", query = "SELECT o FROM Orcamentoprodpharma o WHERE o.datanotificacao = :datanotificacao")
    , @NamedQuery(name = "Orcamentoprodpharma.findByQuantidadeprescrita", query = "SELECT o FROM Orcamentoprodpharma o WHERE o.quantidadeprescrita = :quantidadeprescrita")
    , @NamedQuery(name = "Orcamentoprodpharma.findByQuantidadedispensada", query = "SELECT o FROM Orcamentoprodpharma o WHERE o.quantidadedispensada = :quantidadedispensada")
    , @NamedQuery(name = "Orcamentoprodpharma.findByNumerocrf", query = "SELECT o FROM Orcamentoprodpharma o WHERE o.numerocrf = :numerocrf")
    , @NamedQuery(name = "Orcamentoprodpharma.findByDatavenda", query = "SELECT o FROM Orcamentoprodpharma o WHERE o.datavenda = :datavenda")
    , @NamedQuery(name = "Orcamentoprodpharma.findByNumerolote", query = "SELECT o FROM Orcamentoprodpharma o WHERE o.numerolote = :numerolote")
    , @NamedQuery(name = "Orcamentoprodpharma.findByTiporeceituario", query = "SELECT o FROM Orcamentoprodpharma o WHERE o.tiporeceituario = :tiporeceituario")
    , @NamedQuery(name = "Orcamentoprodpharma.findByNomeconselho", query = "SELECT o FROM Orcamentoprodpharma o WHERE o.nomeconselho = :nomeconselho")
    , @NamedQuery(name = "Orcamentoprodpharma.findByCodufconselho", query = "SELECT o FROM Orcamentoprodpharma o WHERE o.codufconselho = :codufconselho")
    , @NamedQuery(name = "Orcamentoprodpharma.findByTipocliente", query = "SELECT o FROM Orcamentoprodpharma o WHERE o.tipocliente = :tipocliente")
    , @NamedQuery(name = "Orcamentoprodpharma.findByTipodoccliente", query = "SELECT o FROM Orcamentoprodpharma o WHERE o.tipodoccliente = :tipodoccliente")
    , @NamedQuery(name = "Orcamentoprodpharma.findByOrgaoexpedidor", query = "SELECT o FROM Orcamentoprodpharma o WHERE o.orgaoexpedidor = :orgaoexpedidor")
    , @NamedQuery(name = "Orcamentoprodpharma.findByUfdoccliente", query = "SELECT o FROM Orcamentoprodpharma o WHERE o.ufdoccliente = :ufdoccliente")
    , @NamedQuery(name = "Orcamentoprodpharma.findByTipodocumento", query = "SELECT o FROM Orcamentoprodpharma o WHERE o.tipodocumento = :tipodocumento")
    , @NamedQuery(name = "Orcamentoprodpharma.findByFlaginsumo", query = "SELECT o FROM Orcamentoprodpharma o WHERE o.flaginsumo = :flaginsumo")
    , @NamedQuery(name = "Orcamentoprodpharma.findByCodinsumo", query = "SELECT o FROM Orcamentoprodpharma o WHERE o.codinsumo = :codinsumo")
    , @NamedQuery(name = "Orcamentoprodpharma.findByQuantinsunidadefarma", query = "SELECT o FROM Orcamentoprodpharma o WHERE o.quantinsunidadefarma = :quantinsunidadefarma")
    , @NamedQuery(name = "Orcamentoprodpharma.findByQuantunidadefarma", query = "SELECT o FROM Orcamentoprodpharma o WHERE o.quantunidadefarma = :quantunidadefarma")
    , @NamedQuery(name = "Orcamentoprodpharma.findByUnidademedida", query = "SELECT o FROM Orcamentoprodpharma o WHERE o.unidademedida = :unidademedida")
    , @NamedQuery(name = "Orcamentoprodpharma.findByUnidadefarma", query = "SELECT o FROM Orcamentoprodpharma o WHERE o.unidadefarma = :unidadefarma")
    , @NamedQuery(name = "Orcamentoprodpharma.findByCodorc", query = "SELECT o FROM Orcamentoprodpharma o WHERE o.codorc = :codorc")
    , @NamedQuery(name = "Orcamentoprodpharma.findByIdentidade", query = "SELECT o FROM Orcamentoprodpharma o WHERE o.identidade = :identidade")
    , @NamedQuery(name = "Orcamentoprodpharma.findByNomeprod", query = "SELECT o FROM Orcamentoprodpharma o WHERE o.nomeprod = :nomeprod")
    , @NamedQuery(name = "Orcamentoprodpharma.findByCodcli", query = "SELECT o FROM Orcamentoprodpharma o WHERE o.codcli = :codcli")
    , @NamedQuery(name = "Orcamentoprodpharma.findByIdade", query = "SELECT o FROM Orcamentoprodpharma o WHERE o.idade = :idade")
    , @NamedQuery(name = "Orcamentoprodpharma.findByUnidadeidade", query = "SELECT o FROM Orcamentoprodpharma o WHERE o.unidadeidade = :unidadeidade")
    , @NamedQuery(name = "Orcamentoprodpharma.findBySexo", query = "SELECT o FROM Orcamentoprodpharma o WHERE o.sexo = :sexo")
    , @NamedQuery(name = "Orcamentoprodpharma.findByCid", query = "SELECT o FROM Orcamentoprodpharma o WHERE o.cid = :cid")
    , @NamedQuery(name = "Orcamentoprodpharma.findByCodprodutolote", query = "SELECT o FROM Orcamentoprodpharma o WHERE o.codprodutolote = :codprodutolote")})
public class Orcamentoprodpharma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODORCPRODPHARMA")
    private String codorcprodpharma;
    @Column(name = "NOMEPACIENTE")
    private String nomepaciente;
    @Column(name = "ENDERECO")
    private String endereco;
    @Column(name = "NUMDOCUMENTO")
    private String numdocumento;
    @Column(name = "CPF")
    private String cpf;
    @Column(name = "TELEFONE")
    private String telefone;
    @Column(name = "NOMEMEDICO")
    private String nomemedico;
    @Column(name = "NUMEROCRM")
    private String numerocrm;
    @Column(name = "NUMERONOTIFICACAO")
    private String numeronotificacao;
    @Column(name = "DATANOTIFICACAO")
    @Temporal(TemporalType.DATE)
    private Date datanotificacao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "QUANTIDADEPRESCRITA")
    private BigDecimal quantidadeprescrita;
    @Column(name = "QUANTIDADEDISPENSADA")
    private BigDecimal quantidadedispensada;
    @Column(name = "NUMEROCRF")
    private String numerocrf;
    @Column(name = "DATAVENDA")
    @Temporal(TemporalType.DATE)
    private Date datavenda;
    @Column(name = "NUMEROLOTE")
    private String numerolote;
    @Column(name = "TIPORECEITUARIO")
    private Character tiporeceituario;
    @Column(name = "NOMECONSELHO")
    private String nomeconselho;
    @Column(name = "CODUFCONSELHO")
    private String codufconselho;
    @Column(name = "TIPOCLIENTE")
    private Character tipocliente;
    @Column(name = "TIPODOCCLIENTE")
    private String tipodoccliente;
    @Column(name = "ORGAOEXPEDIDOR")
    private String orgaoexpedidor;
    @Column(name = "UFDOCCLIENTE")
    private String ufdoccliente;
    @Column(name = "TIPODOCUMENTO")
    private String tipodocumento;
    @Column(name = "FLAGINSUMO")
    private Character flaginsumo;
    @Column(name = "CODINSUMO")
    private String codinsumo;
    @Column(name = "QUANTINSUNIDADEFARMA")
    private BigDecimal quantinsunidadefarma;
    @Column(name = "QUANTUNIDADEFARMA")
    private BigDecimal quantunidadefarma;
    @Column(name = "UNIDADEMEDIDA")
    private Character unidademedida;
    @Column(name = "UNIDADEFARMA")
    private Character unidadefarma;
    @Column(name = "CODORC")
    private String codorc;
    @Column(name = "IDENTIDADE")
    private String identidade;
    @Column(name = "NOMEPROD")
    private String nomeprod;
    @Column(name = "CODCLI")
    private String codcli;
    @Column(name = "IDADE")
    private Integer idade;
    @Column(name = "UNIDADEIDADE")
    private Character unidadeidade;
    @Column(name = "SEXO")
    private Character sexo;
    @Column(name = "CID")
    private String cid;
    @Column(name = "CODPRODUTOLOTE")
    private String codprodutolote;
    @JoinColumn(name = "CODORCPROD", referencedColumnName = "CODORCPROD")
    @ManyToOne(optional = false)
    private Orcamentoprod codorcprod;

    public Orcamentoprodpharma() {
    }

    public Orcamentoprodpharma(String codorcprodpharma) {
        this.codorcprodpharma = codorcprodpharma;
    }

    public String getCodorcprodpharma() {
        return codorcprodpharma;
    }

    public void setCodorcprodpharma(String codorcprodpharma) {
        this.codorcprodpharma = codorcprodpharma;
    }

    public String getNomepaciente() {
        return nomepaciente;
    }

    public void setNomepaciente(String nomepaciente) {
        this.nomepaciente = nomepaciente;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumdocumento() {
        return numdocumento;
    }

    public void setNumdocumento(String numdocumento) {
        this.numdocumento = numdocumento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNomemedico() {
        return nomemedico;
    }

    public void setNomemedico(String nomemedico) {
        this.nomemedico = nomemedico;
    }

    public String getNumerocrm() {
        return numerocrm;
    }

    public void setNumerocrm(String numerocrm) {
        this.numerocrm = numerocrm;
    }

    public String getNumeronotificacao() {
        return numeronotificacao;
    }

    public void setNumeronotificacao(String numeronotificacao) {
        this.numeronotificacao = numeronotificacao;
    }

    public Date getDatanotificacao() {
        return datanotificacao;
    }

    public void setDatanotificacao(Date datanotificacao) {
        this.datanotificacao = datanotificacao;
    }

    public BigDecimal getQuantidadeprescrita() {
        return quantidadeprescrita;
    }

    public void setQuantidadeprescrita(BigDecimal quantidadeprescrita) {
        this.quantidadeprescrita = quantidadeprescrita;
    }

    public BigDecimal getQuantidadedispensada() {
        return quantidadedispensada;
    }

    public void setQuantidadedispensada(BigDecimal quantidadedispensada) {
        this.quantidadedispensada = quantidadedispensada;
    }

    public String getNumerocrf() {
        return numerocrf;
    }

    public void setNumerocrf(String numerocrf) {
        this.numerocrf = numerocrf;
    }

    public Date getDatavenda() {
        return datavenda;
    }

    public void setDatavenda(Date datavenda) {
        this.datavenda = datavenda;
    }

    public String getNumerolote() {
        return numerolote;
    }

    public void setNumerolote(String numerolote) {
        this.numerolote = numerolote;
    }

    public Character getTiporeceituario() {
        return tiporeceituario;
    }

    public void setTiporeceituario(Character tiporeceituario) {
        this.tiporeceituario = tiporeceituario;
    }

    public String getNomeconselho() {
        return nomeconselho;
    }

    public void setNomeconselho(String nomeconselho) {
        this.nomeconselho = nomeconselho;
    }

    public String getCodufconselho() {
        return codufconselho;
    }

    public void setCodufconselho(String codufconselho) {
        this.codufconselho = codufconselho;
    }

    public Character getTipocliente() {
        return tipocliente;
    }

    public void setTipocliente(Character tipocliente) {
        this.tipocliente = tipocliente;
    }

    public String getTipodoccliente() {
        return tipodoccliente;
    }

    public void setTipodoccliente(String tipodoccliente) {
        this.tipodoccliente = tipodoccliente;
    }

    public String getOrgaoexpedidor() {
        return orgaoexpedidor;
    }

    public void setOrgaoexpedidor(String orgaoexpedidor) {
        this.orgaoexpedidor = orgaoexpedidor;
    }

    public String getUfdoccliente() {
        return ufdoccliente;
    }

    public void setUfdoccliente(String ufdoccliente) {
        this.ufdoccliente = ufdoccliente;
    }

    public String getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(String tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    public Character getFlaginsumo() {
        return flaginsumo;
    }

    public void setFlaginsumo(Character flaginsumo) {
        this.flaginsumo = flaginsumo;
    }

    public String getCodinsumo() {
        return codinsumo;
    }

    public void setCodinsumo(String codinsumo) {
        this.codinsumo = codinsumo;
    }

    public BigDecimal getQuantinsunidadefarma() {
        return quantinsunidadefarma;
    }

    public void setQuantinsunidadefarma(BigDecimal quantinsunidadefarma) {
        this.quantinsunidadefarma = quantinsunidadefarma;
    }

    public BigDecimal getQuantunidadefarma() {
        return quantunidadefarma;
    }

    public void setQuantunidadefarma(BigDecimal quantunidadefarma) {
        this.quantunidadefarma = quantunidadefarma;
    }

    public Character getUnidademedida() {
        return unidademedida;
    }

    public void setUnidademedida(Character unidademedida) {
        this.unidademedida = unidademedida;
    }

    public Character getUnidadefarma() {
        return unidadefarma;
    }

    public void setUnidadefarma(Character unidadefarma) {
        this.unidadefarma = unidadefarma;
    }

    public String getCodorc() {
        return codorc;
    }

    public void setCodorc(String codorc) {
        this.codorc = codorc;
    }

    public String getIdentidade() {
        return identidade;
    }

    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }

    public String getNomeprod() {
        return nomeprod;
    }

    public void setNomeprod(String nomeprod) {
        this.nomeprod = nomeprod;
    }

    public String getCodcli() {
        return codcli;
    }

    public void setCodcli(String codcli) {
        this.codcli = codcli;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Character getUnidadeidade() {
        return unidadeidade;
    }

    public void setUnidadeidade(Character unidadeidade) {
        this.unidadeidade = unidadeidade;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCodprodutolote() {
        return codprodutolote;
    }

    public void setCodprodutolote(String codprodutolote) {
        this.codprodutolote = codprodutolote;
    }

    public Orcamentoprod getCodorcprod() {
        return codorcprod;
    }

    public void setCodorcprod(Orcamentoprod codorcprod) {
        this.codorcprod = codorcprod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codorcprodpharma != null ? codorcprodpharma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orcamentoprodpharma)) {
            return false;
        }
        Orcamentoprodpharma other = (Orcamentoprodpharma) object;
        if ((this.codorcprodpharma == null && other.codorcprodpharma != null) || (this.codorcprodpharma != null && !this.codorcprodpharma.equals(other.codorcprodpharma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Orcamentoprodpharma[ codorcprodpharma=" + codorcprodpharma + " ]";
    }
    
}
