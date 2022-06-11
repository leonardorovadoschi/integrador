/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.util.Collection;
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
@Table(name = "FORNECEDOR", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fornecedor.findAll", query = "SELECT f FROM Fornecedor f")
    , @NamedQuery(name = "Fornecedor.findByCodforn", query = "SELECT f FROM Fornecedor f WHERE f.codforn = :codforn")
    , @NamedQuery(name = "Fornecedor.findByCodigo", query = "SELECT f FROM Fornecedor f WHERE f.codigo = :codigo")
    , @NamedQuery(name = "Fornecedor.findByNomeforn", query = "SELECT f FROM Fornecedor f WHERE f.nomeforn = :nomeforn")
    , @NamedQuery(name = "Fornecedor.findByEndereco", query = "SELECT f FROM Fornecedor f WHERE f.endereco = :endereco")
    , @NamedQuery(name = "Fornecedor.findByBairro", query = "SELECT f FROM Fornecedor f WHERE f.bairro = :bairro")
    , @NamedQuery(name = "Fornecedor.findByCidade", query = "SELECT f FROM Fornecedor f WHERE f.cidade = :cidade")
    , @NamedQuery(name = "Fornecedor.findByEstado", query = "SELECT f FROM Fornecedor f WHERE f.estado = :estado")
    , @NamedQuery(name = "Fornecedor.findByCep", query = "SELECT f FROM Fornecedor f WHERE f.cep = :cep")
    , @NamedQuery(name = "Fornecedor.findByTelefone", query = "SELECT f FROM Fornecedor f WHERE f.telefone = :telefone")
    , @NamedQuery(name = "Fornecedor.findByFax", query = "SELECT f FROM Fornecedor f WHERE f.fax = :fax")
    , @NamedQuery(name = "Fornecedor.findByInscr", query = "SELECT f FROM Fornecedor f WHERE f.inscr = :inscr")
    , @NamedQuery(name = "Fornecedor.findByRefban", query = "SELECT f FROM Fornecedor f WHERE f.refban = :refban")
    , @NamedQuery(name = "Fornecedor.findByCnpj", query = "SELECT f FROM Fornecedor f WHERE f.cnpj = :cnpj")
    , @NamedQuery(name = "Fornecedor.findByContato", query = "SELECT f FROM Fornecedor f WHERE f.contato = :contato")
    , @NamedQuery(name = "Fornecedor.findByDatcad", query = "SELECT f FROM Fornecedor f WHERE f.datcad = :datcad")
    , @NamedQuery(name = "Fornecedor.findByMicro", query = "SELECT f FROM Fornecedor f WHERE f.micro = :micro")
    , @NamedQuery(name = "Fornecedor.findByEmail", query = "SELECT f FROM Fornecedor f WHERE f.email = :email")
    , @NamedQuery(name = "Fornecedor.findByWeb", query = "SELECT f FROM Fornecedor f WHERE f.web = :web")
    , @NamedQuery(name = "Fornecedor.findByFlagfisica", query = "SELECT f FROM Fornecedor f WHERE f.flagfisica = :flagfisica")
    , @NamedQuery(name = "Fornecedor.findBySenha", query = "SELECT f FROM Fornecedor f WHERE f.senha = :senha")
    , @NamedQuery(name = "Fornecedor.findByFlagusaaliqicmsdiferenciada", query = "SELECT f FROM Fornecedor f WHERE f.flagusaaliqicmsdiferenciada = :flagusaaliqicmsdiferenciada")
    , @NamedQuery(name = "Fornecedor.findByNumerologradouro", query = "SELECT f FROM Fornecedor f WHERE f.numerologradouro = :numerologradouro")
    , @NamedQuery(name = "Fornecedor.findByComplementologradouro", query = "SELECT f FROM Fornecedor f WHERE f.complementologradouro = :complementologradouro")
    , @NamedQuery(name = "Fornecedor.findByInscrmun", query = "SELECT f FROM Fornecedor f WHERE f.inscrmun = :inscrmun")
    , @NamedQuery(name = "Fornecedor.findByCodigointegracaofiscal", query = "SELECT f FROM Fornecedor f WHERE f.codigointegracaofiscal = :codigointegracaofiscal")
    , @NamedQuery(name = "Fornecedor.findByEmaildanfe", query = "SELECT f FROM Fornecedor f WHERE f.emaildanfe = :emaildanfe")
    , @NamedQuery(name = "Fornecedor.findByBloqueado", query = "SELECT f FROM Fornecedor f WHERE f.bloqueado = :bloqueado")
    , @NamedQuery(name = "Fornecedor.findByMotivobloqueio", query = "SELECT f FROM Fornecedor f WHERE f.motivobloqueio = :motivobloqueio")
    , @NamedQuery(name = "Fornecedor.findByGuid", query = "SELECT f FROM Fornecedor f WHERE f.guid = :guid")
    , @NamedQuery(name = "Fornecedor.findByFlagfrete", query = "SELECT f FROM Fornecedor f WHERE f.flagfrete = :flagfrete")
    , @NamedQuery(name = "Fornecedor.findByIndiedest", query = "SELECT f FROM Fornecedor f WHERE f.indiedest = :indiedest")
    , @NamedQuery(name = "Fornecedor.findByIdentidade", query = "SELECT f FROM Fornecedor f WHERE f.identidade = :identidade")
    , @NamedQuery(name = "Fornecedor.findByRazaosocial", query = "SELECT f FROM Fornecedor f WHERE f.razaosocial = :razaosocial")
    , @NamedQuery(name = "Fornecedor.findByFlagtransfer", query = "SELECT f FROM Fornecedor f WHERE f.flagtransfer = :flagtransfer")
    , @NamedQuery(name = "Fornecedor.findByCodchamadadevedora", query = "SELECT f FROM Fornecedor f WHERE f.codchamadadevedora = :codchamadadevedora")
    , @NamedQuery(name = "Fornecedor.findByCodhistoricopadrao", query = "SELECT f FROM Fornecedor f WHERE f.codhistoricopadrao = :codhistoricopadrao")
    , @NamedQuery(name = "Fornecedor.findByCodigointegracaofiscaldev", query = "SELECT f FROM Fornecedor f WHERE f.codigointegracaofiscaldev = :codigointegracaofiscaldev")})
public class Fornecedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODFORN")
    private String codforn;
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private String codigo;
    @Basic(optional = false)
    @Column(name = "NOMEFORN")
    private String nomeforn;
    @Column(name = "ENDERECO")
    private String endereco;
    @Column(name = "BAIRRO")
    private String bairro;
    @Column(name = "CIDADE")
    private String cidade;
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "CEP")
    private String cep;
    @Column(name = "TELEFONE")
    private String telefone;
    @Column(name = "FAX")
    private String fax;
    @Column(name = "INSCR")
    private String inscr;
    @Column(name = "REFBAN")
    private String refban;
    @Column(name = "CNPJ")
    private String cnpj;
    @Column(name = "CONTATO")
    private String contato;
    @Column(name = "DATCAD")
    @Temporal(TemporalType.DATE)
    private Date datcad;
    @Lob
    @Column(name = "OBS")
    private String obs;
    @Column(name = "MICRO")
    private Character micro;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "WEB")
    private String web;
    @Column(name = "FLAGFISICA")
    private Character flagfisica;
    @Column(name = "SENHA")
    private String senha;
    @Column(name = "FLAGUSAALIQICMSDIFERENCIADA")
    private Character flagusaaliqicmsdiferenciada;
    @Column(name = "NUMEROLOGRADOURO")
    private String numerologradouro;
    @Column(name = "COMPLEMENTOLOGRADOURO")
    private String complementologradouro;
    @Column(name = "INSCRMUN")
    private String inscrmun;
    @Column(name = "CODIGOINTEGRACAOFISCAL")
    private String codigointegracaofiscal;
    @Column(name = "EMAILDANFE")
    private String emaildanfe;
    @Column(name = "BLOQUEADO")
    private Character bloqueado;
    @Column(name = "MOTIVOBLOQUEIO")
    private String motivobloqueio;
    @Column(name = "GUID")
    private String guid;
    @Lob
    @Column(name = "EMAILCCDANFE")
    private String emailccdanfe;
    @Column(name = "FLAGFRETE")
    private Character flagfrete;
    @Column(name = "INDIEDEST")
    private Character indiedest;
    @Column(name = "IDENTIDADE")
    private String identidade;
    @Column(name = "RAZAOSOCIAL")
    private String razaosocial;
    @Column(name = "FLAGTRANSFER")
    private Character flagtransfer;
    @Column(name = "CODCHAMADADEVEDORA")
    private String codchamadadevedora;
    @Column(name = "CODHISTORICOPADRAO")
    private String codhistoricopadrao;
    @Column(name = "CODIGOINTEGRACAOFISCALDEV")
    private String codigointegracaofiscaldev;
    @OneToMany(mappedBy = "codforn")
    private Collection<Chequesfirma> chequesfirmaCollection;
    @OneToMany(mappedBy = "codforn")
    private Collection<Contapagar> contapagarCollection;
    @OneToMany(mappedBy = "codforn")
    private Collection<Cheques> chequesCollection;
    @OneToMany(mappedBy = "codforn")
    private Collection<Contatosforn> contatosfornCollection;
    @OneToMany(mappedBy = "codforn")
    private Collection<Contapagarfixa> contapagarfixaCollection;
    @JoinColumn(name = "CODFP", referencedColumnName = "CODFP")
    @ManyToOne
    private Formapag codfp;
    @JoinColumn(name = "CODTRANS", referencedColumnName = "CODTRANS")
    @ManyToOne
    private Transportadora codtrans;
    @OneToMany(mappedBy = "codforn")
    private Collection<Produto> produtoCollection;
    @OneToMany(mappedBy = "codforn")
    private Collection<Cotacaofornecedor> cotacaofornecedorCollection;
    @OneToMany(mappedBy = "codforn")
    private Collection<Movendaproddevolucaocompra> movendaproddevolucaocompraCollection;

    public Fornecedor() {
    }

    public Fornecedor(String codforn) {
        this.codforn = codforn;
    }

    public Fornecedor(String codforn, String codigo, String nomeforn) {
        this.codforn = codforn;
        this.codigo = codigo;
        this.nomeforn = nomeforn;
    }

    public String getCodforn() {
        return codforn;
    }

    public void setCodforn(String codforn) {
        this.codforn = codforn;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomeforn() {
        return nomeforn;
    }

    public void setNomeforn(String nomeforn) {
        this.nomeforn = nomeforn;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getInscr() {
        return inscr;
    }

    public void setInscr(String inscr) {
        this.inscr = inscr;
    }

    public String getRefban() {
        return refban;
    }

    public void setRefban(String refban) {
        this.refban = refban;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public Date getDatcad() {
        return datcad;
    }

    public void setDatcad(Date datcad) {
        this.datcad = datcad;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Character getMicro() {
        return micro;
    }

    public void setMicro(Character micro) {
        this.micro = micro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public Character getFlagfisica() {
        return flagfisica;
    }

    public void setFlagfisica(Character flagfisica) {
        this.flagfisica = flagfisica;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Character getFlagusaaliqicmsdiferenciada() {
        return flagusaaliqicmsdiferenciada;
    }

    public void setFlagusaaliqicmsdiferenciada(Character flagusaaliqicmsdiferenciada) {
        this.flagusaaliqicmsdiferenciada = flagusaaliqicmsdiferenciada;
    }

    public String getNumerologradouro() {
        return numerologradouro;
    }

    public void setNumerologradouro(String numerologradouro) {
        this.numerologradouro = numerologradouro;
    }

    public String getComplementologradouro() {
        return complementologradouro;
    }

    public void setComplementologradouro(String complementologradouro) {
        this.complementologradouro = complementologradouro;
    }

    public String getInscrmun() {
        return inscrmun;
    }

    public void setInscrmun(String inscrmun) {
        this.inscrmun = inscrmun;
    }

    public String getCodigointegracaofiscal() {
        return codigointegracaofiscal;
    }

    public void setCodigointegracaofiscal(String codigointegracaofiscal) {
        this.codigointegracaofiscal = codigointegracaofiscal;
    }

    public String getEmaildanfe() {
        return emaildanfe;
    }

    public void setEmaildanfe(String emaildanfe) {
        this.emaildanfe = emaildanfe;
    }

    public Character getBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(Character bloqueado) {
        this.bloqueado = bloqueado;
    }

    public String getMotivobloqueio() {
        return motivobloqueio;
    }

    public void setMotivobloqueio(String motivobloqueio) {
        this.motivobloqueio = motivobloqueio;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getEmailccdanfe() {
        return emailccdanfe;
    }

    public void setEmailccdanfe(String emailccdanfe) {
        this.emailccdanfe = emailccdanfe;
    }

    public Character getFlagfrete() {
        return flagfrete;
    }

    public void setFlagfrete(Character flagfrete) {
        this.flagfrete = flagfrete;
    }

    public Character getIndiedest() {
        return indiedest;
    }

    public void setIndiedest(Character indiedest) {
        this.indiedest = indiedest;
    }

    public String getIdentidade() {
        return identidade;
    }

    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }

    public String getRazaosocial() {
        return razaosocial;
    }

    public void setRazaosocial(String razaosocial) {
        this.razaosocial = razaosocial;
    }

    public Character getFlagtransfer() {
        return flagtransfer;
    }

    public void setFlagtransfer(Character flagtransfer) {
        this.flagtransfer = flagtransfer;
    }

    public String getCodchamadadevedora() {
        return codchamadadevedora;
    }

    public void setCodchamadadevedora(String codchamadadevedora) {
        this.codchamadadevedora = codchamadadevedora;
    }

    public String getCodhistoricopadrao() {
        return codhistoricopadrao;
    }

    public void setCodhistoricopadrao(String codhistoricopadrao) {
        this.codhistoricopadrao = codhistoricopadrao;
    }

    public String getCodigointegracaofiscaldev() {
        return codigointegracaofiscaldev;
    }

    public void setCodigointegracaofiscaldev(String codigointegracaofiscaldev) {
        this.codigointegracaofiscaldev = codigointegracaofiscaldev;
    }

    @XmlTransient
    public Collection<Chequesfirma> getChequesfirmaCollection() {
        return chequesfirmaCollection;
    }

    public void setChequesfirmaCollection(Collection<Chequesfirma> chequesfirmaCollection) {
        this.chequesfirmaCollection = chequesfirmaCollection;
    }

    @XmlTransient
    public Collection<Contapagar> getContapagarCollection() {
        return contapagarCollection;
    }

    public void setContapagarCollection(Collection<Contapagar> contapagarCollection) {
        this.contapagarCollection = contapagarCollection;
    }

    @XmlTransient
    public Collection<Cheques> getChequesCollection() {
        return chequesCollection;
    }

    public void setChequesCollection(Collection<Cheques> chequesCollection) {
        this.chequesCollection = chequesCollection;
    }

    @XmlTransient
    public Collection<Contatosforn> getContatosfornCollection() {
        return contatosfornCollection;
    }

    public void setContatosfornCollection(Collection<Contatosforn> contatosfornCollection) {
        this.contatosfornCollection = contatosfornCollection;
    }

    @XmlTransient
    public Collection<Contapagarfixa> getContapagarfixaCollection() {
        return contapagarfixaCollection;
    }

    public void setContapagarfixaCollection(Collection<Contapagarfixa> contapagarfixaCollection) {
        this.contapagarfixaCollection = contapagarfixaCollection;
    }

    public Formapag getCodfp() {
        return codfp;
    }

    public void setCodfp(Formapag codfp) {
        this.codfp = codfp;
    }

    public Transportadora getCodtrans() {
        return codtrans;
    }

    public void setCodtrans(Transportadora codtrans) {
        this.codtrans = codtrans;
    }

    @XmlTransient
    public Collection<Produto> getProdutoCollection() {
        return produtoCollection;
    }

    public void setProdutoCollection(Collection<Produto> produtoCollection) {
        this.produtoCollection = produtoCollection;
    }

    @XmlTransient
    public Collection<Cotacaofornecedor> getCotacaofornecedorCollection() {
        return cotacaofornecedorCollection;
    }

    public void setCotacaofornecedorCollection(Collection<Cotacaofornecedor> cotacaofornecedorCollection) {
        this.cotacaofornecedorCollection = cotacaofornecedorCollection;
    }

    @XmlTransient
    public Collection<Movendaproddevolucaocompra> getMovendaproddevolucaocompraCollection() {
        return movendaproddevolucaocompraCollection;
    }

    public void setMovendaproddevolucaocompraCollection(Collection<Movendaproddevolucaocompra> movendaproddevolucaocompraCollection) {
        this.movendaproddevolucaocompraCollection = movendaproddevolucaocompraCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codforn != null ? codforn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fornecedor)) {
            return false;
        }
        Fornecedor other = (Fornecedor) object;
        if ((this.codforn == null && other.codforn != null) || (this.codforn != null && !this.codforn.equals(other.codforn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Fornecedor[ codforn=" + codforn + " ]";
    }
    
}
