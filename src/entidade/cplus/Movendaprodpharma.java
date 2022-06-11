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
@Table(name = "MOVENDAPRODPHARMA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movendaprodpharma.findAll", query = "SELECT m FROM Movendaprodpharma m")
    , @NamedQuery(name = "Movendaprodpharma.findByNomepaciente", query = "SELECT m FROM Movendaprodpharma m WHERE m.nomepaciente = :nomepaciente")
    , @NamedQuery(name = "Movendaprodpharma.findByEndereco", query = "SELECT m FROM Movendaprodpharma m WHERE m.endereco = :endereco")
    , @NamedQuery(name = "Movendaprodpharma.findByIdentidade", query = "SELECT m FROM Movendaprodpharma m WHERE m.identidade = :identidade")
    , @NamedQuery(name = "Movendaprodpharma.findByCpf", query = "SELECT m FROM Movendaprodpharma m WHERE m.cpf = :cpf")
    , @NamedQuery(name = "Movendaprodpharma.findByTelefone", query = "SELECT m FROM Movendaprodpharma m WHERE m.telefone = :telefone")
    , @NamedQuery(name = "Movendaprodpharma.findByNomemedico", query = "SELECT m FROM Movendaprodpharma m WHERE m.nomemedico = :nomemedico")
    , @NamedQuery(name = "Movendaprodpharma.findByNumerocrm", query = "SELECT m FROM Movendaprodpharma m WHERE m.numerocrm = :numerocrm")
    , @NamedQuery(name = "Movendaprodpharma.findByNumeronotificacao", query = "SELECT m FROM Movendaprodpharma m WHERE m.numeronotificacao = :numeronotificacao")
    , @NamedQuery(name = "Movendaprodpharma.findByDatanotificacao", query = "SELECT m FROM Movendaprodpharma m WHERE m.datanotificacao = :datanotificacao")
    , @NamedQuery(name = "Movendaprodpharma.findByQuantidadeprescrita", query = "SELECT m FROM Movendaprodpharma m WHERE m.quantidadeprescrita = :quantidadeprescrita")
    , @NamedQuery(name = "Movendaprodpharma.findByQuantidadedispensada", query = "SELECT m FROM Movendaprodpharma m WHERE m.quantidadedispensada = :quantidadedispensada")
    , @NamedQuery(name = "Movendaprodpharma.findByNumerocrf", query = "SELECT m FROM Movendaprodpharma m WHERE m.numerocrf = :numerocrf")
    , @NamedQuery(name = "Movendaprodpharma.findByDatavenda", query = "SELECT m FROM Movendaprodpharma m WHERE m.datavenda = :datavenda")
    , @NamedQuery(name = "Movendaprodpharma.findByNumerolote", query = "SELECT m FROM Movendaprodpharma m WHERE m.numerolote = :numerolote")
    , @NamedQuery(name = "Movendaprodpharma.findByTiporeceituario", query = "SELECT m FROM Movendaprodpharma m WHERE m.tiporeceituario = :tiporeceituario")
    , @NamedQuery(name = "Movendaprodpharma.findByNomeconselho", query = "SELECT m FROM Movendaprodpharma m WHERE m.nomeconselho = :nomeconselho")
    , @NamedQuery(name = "Movendaprodpharma.findByCodufconselho", query = "SELECT m FROM Movendaprodpharma m WHERE m.codufconselho = :codufconselho")
    , @NamedQuery(name = "Movendaprodpharma.findByTipodoccliente", query = "SELECT m FROM Movendaprodpharma m WHERE m.tipodoccliente = :tipodoccliente")
    , @NamedQuery(name = "Movendaprodpharma.findByOrgaoexpedidor", query = "SELECT m FROM Movendaprodpharma m WHERE m.orgaoexpedidor = :orgaoexpedidor")
    , @NamedQuery(name = "Movendaprodpharma.findByUfdoccliente", query = "SELECT m FROM Movendaprodpharma m WHERE m.ufdoccliente = :ufdoccliente")
    , @NamedQuery(name = "Movendaprodpharma.findByCodmovprodpharma", query = "SELECT m FROM Movendaprodpharma m WHERE m.codmovprodpharma = :codmovprodpharma")
    , @NamedQuery(name = "Movendaprodpharma.findByTipocliente", query = "SELECT m FROM Movendaprodpharma m WHERE m.tipocliente = :tipocliente")
    , @NamedQuery(name = "Movendaprodpharma.findByTipodocumento", query = "SELECT m FROM Movendaprodpharma m WHERE m.tipodocumento = :tipodocumento")
    , @NamedQuery(name = "Movendaprodpharma.findByFlaginsumo", query = "SELECT m FROM Movendaprodpharma m WHERE m.flaginsumo = :flaginsumo")
    , @NamedQuery(name = "Movendaprodpharma.findByCodinsumo", query = "SELECT m FROM Movendaprodpharma m WHERE m.codinsumo = :codinsumo")
    , @NamedQuery(name = "Movendaprodpharma.findByQuantinsunidadefarma", query = "SELECT m FROM Movendaprodpharma m WHERE m.quantinsunidadefarma = :quantinsunidadefarma")
    , @NamedQuery(name = "Movendaprodpharma.findByQuantunidadefarma", query = "SELECT m FROM Movendaprodpharma m WHERE m.quantunidadefarma = :quantunidadefarma")
    , @NamedQuery(name = "Movendaprodpharma.findByUnidademedida", query = "SELECT m FROM Movendaprodpharma m WHERE m.unidademedida = :unidademedida")
    , @NamedQuery(name = "Movendaprodpharma.findByUnidadefarma", query = "SELECT m FROM Movendaprodpharma m WHERE m.unidadefarma = :unidadefarma")
    , @NamedQuery(name = "Movendaprodpharma.findByCodmovenda", query = "SELECT m FROM Movendaprodpharma m WHERE m.codmovenda = :codmovenda")
    , @NamedQuery(name = "Movendaprodpharma.findByNomeprod", query = "SELECT m FROM Movendaprodpharma m WHERE m.nomeprod = :nomeprod")
    , @NamedQuery(name = "Movendaprodpharma.findByCodcli", query = "SELECT m FROM Movendaprodpharma m WHERE m.codcli = :codcli")
    , @NamedQuery(name = "Movendaprodpharma.findByIdade", query = "SELECT m FROM Movendaprodpharma m WHERE m.idade = :idade")
    , @NamedQuery(name = "Movendaprodpharma.findByUnidadeidade", query = "SELECT m FROM Movendaprodpharma m WHERE m.unidadeidade = :unidadeidade")
    , @NamedQuery(name = "Movendaprodpharma.findBySexo", query = "SELECT m FROM Movendaprodpharma m WHERE m.sexo = :sexo")
    , @NamedQuery(name = "Movendaprodpharma.findByCid", query = "SELECT m FROM Movendaprodpharma m WHERE m.cid = :cid")
    , @NamedQuery(name = "Movendaprodpharma.findByCodprodutolote", query = "SELECT m FROM Movendaprodpharma m WHERE m.codprodutolote = :codprodutolote")
    , @NamedQuery(name = "Movendaprodpharma.findByGuid", query = "SELECT m FROM Movendaprodpharma m WHERE m.guid = :guid")})
public class Movendaprodpharma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "NOMEPACIENTE")
    private String nomepaciente;
    @Column(name = "ENDERECO")
    private String endereco;
    @Column(name = "IDENTIDADE")
    private String identidade;
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
    @Column(name = "TIPODOCCLIENTE")
    private String tipodoccliente;
    @Column(name = "ORGAOEXPEDIDOR")
    private String orgaoexpedidor;
    @Column(name = "UFDOCCLIENTE")
    private String ufdoccliente;
    @Id
    @Basic(optional = false)
    @Column(name = "CODMOVPRODPHARMA")
    private String codmovprodpharma;
    @Column(name = "TIPOCLIENTE")
    private Character tipocliente;
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
    @Column(name = "CODMOVENDA")
    private String codmovenda;
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
    @Column(name = "GUID")
    private String guid;
    @JoinColumn(name = "CODMOVPROD", referencedColumnName = "CODMOVPROD")
    @ManyToOne(optional = false)
    private Movendaprod codmovprod;

    public Movendaprodpharma() {
    }

    public Movendaprodpharma(String codmovprodpharma) {
        this.codmovprodpharma = codmovprodpharma;
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

    public String getIdentidade() {
        return identidade;
    }

    public void setIdentidade(String identidade) {
        this.identidade = identidade;
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

    public String getCodmovprodpharma() {
        return codmovprodpharma;
    }

    public void setCodmovprodpharma(String codmovprodpharma) {
        this.codmovprodpharma = codmovprodpharma;
    }

    public Character getTipocliente() {
        return tipocliente;
    }

    public void setTipocliente(Character tipocliente) {
        this.tipocliente = tipocliente;
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

    public String getCodmovenda() {
        return codmovenda;
    }

    public void setCodmovenda(String codmovenda) {
        this.codmovenda = codmovenda;
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

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Movendaprod getCodmovprod() {
        return codmovprod;
    }

    public void setCodmovprod(Movendaprod codmovprod) {
        this.codmovprod = codmovprod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codmovprodpharma != null ? codmovprodpharma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movendaprodpharma)) {
            return false;
        }
        Movendaprodpharma other = (Movendaprodpharma) object;
        if ((this.codmovprodpharma == null && other.codmovprodpharma != null) || (this.codmovprodpharma != null && !this.codmovprodpharma.equals(other.codmovprodpharma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Movendaprodpharma[ codmovprodpharma=" + codmovprodpharma + " ]";
    }
    
}
