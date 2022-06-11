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
@Table(name = "USUARIO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByCoduser", query = "SELECT u FROM Usuario u WHERE u.coduser = :coduser")
    , @NamedQuery(name = "Usuario.findByCodigo", query = "SELECT u FROM Usuario u WHERE u.codigo = :codigo")
    , @NamedQuery(name = "Usuario.findByNome", query = "SELECT u FROM Usuario u WHERE u.nome = :nome")
    , @NamedQuery(name = "Usuario.findByLogin", query = "SELECT u FROM Usuario u WHERE u.login = :login")
    , @NamedQuery(name = "Usuario.findBySenha", query = "SELECT u FROM Usuario u WHERE u.senha = :senha")
    , @NamedQuery(name = "Usuario.findByDescmax", query = "SELECT u FROM Usuario u WHERE u.descmax = :descmax")
    , @NamedQuery(name = "Usuario.findByDescmaxtab2", query = "SELECT u FROM Usuario u WHERE u.descmaxtab2 = :descmaxtab2")
    , @NamedQuery(name = "Usuario.findByCodprecopadrao", query = "SELECT u FROM Usuario u WHERE u.codprecopadrao = :codprecopadrao")
    , @NamedQuery(name = "Usuario.findByAssinaturaemail", query = "SELECT u FROM Usuario u WHERE u.assinaturaemail = :assinaturaemail")
    , @NamedQuery(name = "Usuario.findByProgramaemail", query = "SELECT u FROM Usuario u WHERE u.programaemail = :programaemail")
    , @NamedQuery(name = "Usuario.findByEmailretorno", query = "SELECT u FROM Usuario u WHERE u.emailretorno = :emailretorno")
    , @NamedQuery(name = "Usuario.findByEmailnome", query = "SELECT u FROM Usuario u WHERE u.emailnome = :emailnome")
    , @NamedQuery(name = "Usuario.findByEmailservidorsmtp", query = "SELECT u FROM Usuario u WHERE u.emailservidorsmtp = :emailservidorsmtp")
    , @NamedQuery(name = "Usuario.findByEmailservidorpop", query = "SELECT u FROM Usuario u WHERE u.emailservidorpop = :emailservidorpop")
    , @NamedQuery(name = "Usuario.findByEmailnomeusuario", query = "SELECT u FROM Usuario u WHERE u.emailnomeusuario = :emailnomeusuario")
    , @NamedQuery(name = "Usuario.findByEmailsenhausuario", query = "SELECT u FROM Usuario u WHERE u.emailsenhausuario = :emailsenhausuario")
    , @NamedQuery(name = "Usuario.findByEmailusassl", query = "SELECT u FROM Usuario u WHERE u.emailusassl = :emailusassl")
    , @NamedQuery(name = "Usuario.findByCodsetorestoquepadrao", query = "SELECT u FROM Usuario u WHERE u.codsetorestoquepadrao = :codsetorestoquepadrao")
    , @NamedQuery(name = "Usuario.findByPermitealterarsetorestoque", query = "SELECT u FROM Usuario u WHERE u.permitealterarsetorestoque = :permitealterarsetorestoque")
    , @NamedQuery(name = "Usuario.findByFlagadministrador", query = "SELECT u FROM Usuario u WHERE u.flagadministrador = :flagadministrador")
    , @NamedQuery(name = "Usuario.findByCodcaixas", query = "SELECT u FROM Usuario u WHERE u.codcaixas = :codcaixas")
    , @NamedQuery(name = "Usuario.findByCodperfilusuario", query = "SELECT u FROM Usuario u WHERE u.codperfilusuario = :codperfilusuario")
    , @NamedQuery(name = "Usuario.findByListacaixa", query = "SELECT u FROM Usuario u WHERE u.listacaixa = :listacaixa")
    , @NamedQuery(name = "Usuario.findByFlagativo", query = "SELECT u FROM Usuario u WHERE u.flagativo = :flagativo")
    , @NamedQuery(name = "Usuario.findByFlagusuarioafv", query = "SELECT u FROM Usuario u WHERE u.flagusuarioafv = :flagusuarioafv")
    , @NamedQuery(name = "Usuario.findByFlagusasslpop", query = "SELECT u FROM Usuario u WHERE u.flagusasslpop = :flagusasslpop")
    , @NamedQuery(name = "Usuario.findByPortapop", query = "SELECT u FROM Usuario u WHERE u.portapop = :portapop")
    , @NamedQuery(name = "Usuario.findByFlagautenticasmtp", query = "SELECT u FROM Usuario u WHERE u.flagautenticasmtp = :flagautenticasmtp")
    , @NamedQuery(name = "Usuario.findByPortasmtp", query = "SELECT u FROM Usuario u WHERE u.portasmtp = :portasmtp")
    , @NamedQuery(name = "Usuario.findByTipocriptografiasmtp", query = "SELECT u FROM Usuario u WHERE u.tipocriptografiasmtp = :tipocriptografiasmtp")
    , @NamedQuery(name = "Usuario.findByFlagtodosorcamentos", query = "SELECT u FROM Usuario u WHERE u.flagtodosorcamentos = :flagtodosorcamentos")
    , @NamedQuery(name = "Usuario.findByLimitecredito", query = "SELECT u FROM Usuario u WHERE u.limitecredito = :limitecredito")
    , @NamedQuery(name = "Usuario.findByLimitefaturamento", query = "SELECT u FROM Usuario u WHERE u.limitefaturamento = :limitefaturamento")
    , @NamedQuery(name = "Usuario.findByListaoperacao", query = "SELECT u FROM Usuario u WHERE u.listaoperacao = :listaoperacao")
    , @NamedQuery(name = "Usuario.findByListaorcamentostatus", query = "SELECT u FROM Usuario u WHERE u.listaorcamentostatus = :listaorcamentostatus")
    , @NamedQuery(name = "Usuario.findByFlagpodealterarsa", query = "SELECT u FROM Usuario u WHERE u.flagpodealterarsa = :flagpodealterarsa")
    , @NamedQuery(name = "Usuario.findByGuid", query = "SELECT u FROM Usuario u WHERE u.guid = :guid")
    , @NamedQuery(name = "Usuario.findByNaopermitealterarcaixa", query = "SELECT u FROM Usuario u WHERE u.naopermitealterarcaixa = :naopermitealterarcaixa")
    , @NamedQuery(name = "Usuario.findByListatabelaprecoafv", query = "SELECT u FROM Usuario u WHERE u.listatabelaprecoafv = :listatabelaprecoafv")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODUSER")
    private String coduser;
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "NOME")
    private String nome;
    @Basic(optional = false)
    @Column(name = "LOGIN")
    private String login;
    @Basic(optional = false)
    @Column(name = "SENHA")
    private String senha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DESCMAX")
    private BigDecimal descmax;
    @Column(name = "DESCMAXTAB2")
    private BigDecimal descmaxtab2;
    @Column(name = "CODPRECOPADRAO")
    private String codprecopadrao;
    @Column(name = "ASSINATURAEMAIL")
    private String assinaturaemail;
    @Column(name = "PROGRAMAEMAIL")
    private Character programaemail;
    @Column(name = "EMAILRETORNO")
    private String emailretorno;
    @Column(name = "EMAILNOME")
    private String emailnome;
    @Column(name = "EMAILSERVIDORSMTP")
    private String emailservidorsmtp;
    @Column(name = "EMAILSERVIDORPOP")
    private String emailservidorpop;
    @Column(name = "EMAILNOMEUSUARIO")
    private String emailnomeusuario;
    @Column(name = "EMAILSENHAUSUARIO")
    private String emailsenhausuario;
    @Column(name = "EMAILUSASSL")
    private Character emailusassl;
    @Column(name = "CODSETORESTOQUEPADRAO")
    private String codsetorestoquepadrao;
    @Column(name = "PERMITEALTERARSETORESTOQUE")
    private Character permitealterarsetorestoque;
    @Column(name = "FLAGADMINISTRADOR")
    private Character flagadministrador;
    @Column(name = "CODCAIXAS")
    private String codcaixas;
    @Column(name = "CODPERFILUSUARIO")
    private String codperfilusuario;
    @Column(name = "LISTACAIXA")
    private String listacaixa;
    @Column(name = "FLAGATIVO")
    private Character flagativo;
    @Column(name = "FLAGUSUARIOAFV")
    private Character flagusuarioafv;
    @Column(name = "FLAGUSASSLPOP")
    private Character flagusasslpop;
    @Column(name = "PORTAPOP")
    private Integer portapop;
    @Column(name = "FLAGAUTENTICASMTP")
    private Character flagautenticasmtp;
    @Column(name = "PORTASMTP")
    private Integer portasmtp;
    @Column(name = "TIPOCRIPTOGRAFIASMTP")
    private String tipocriptografiasmtp;
    @Column(name = "FLAGTODOSORCAMENTOS")
    private Character flagtodosorcamentos;
    @Column(name = "LIMITECREDITO")
    private BigDecimal limitecredito;
    @Column(name = "LIMITEFATURAMENTO")
    private BigDecimal limitefaturamento;
    @Column(name = "LISTAOPERACAO")
    private String listaoperacao;
    @Column(name = "LISTAORCAMENTOSTATUS")
    private String listaorcamentostatus;
    @Column(name = "FLAGPODEALTERARSA")
    private Character flagpodealterarsa;
    @Column(name = "GUID")
    private String guid;
    @Column(name = "NAOPERMITEALTERARCAIXA")
    private Character naopermitealterarcaixa;
    @Column(name = "LISTATABELAPRECOAFV")
    private String listatabelaprecoafv;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coduser")
    private Collection<Producaohistorico> producaohistoricoCollection;
    @OneToMany(mappedBy = "coduser")
    private Collection<Documento> documentoCollection;
    @OneToMany(mappedBy = "coduser")
    private Collection<Rma> rmaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coduser")
    private Collection<Etiquetaendereco> etiquetaenderecoCollection;
    @JoinColumn(name = "CODEMPRESA", referencedColumnName = "CODEMPRESA")
    @ManyToOne
    private Empresa codempresa;
    @JoinColumn(name = "CODFUNCIONARIO", referencedColumnName = "CODFUNCIONARIO")
    @ManyToOne
    private Funcionario codfuncionario;
    @JoinColumn(name = "CODSITUACAOADMINISTRATIVA", referencedColumnName = "CODSITUACAOADMINISTRATIVA")
    @ManyToOne
    private Situacaoadministrativa codsituacaoadministrativa;
    @JoinColumn(name = "CODVENDED", referencedColumnName = "CODVENDED")
    @ManyToOne
    private Vendedor codvended;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coduser")
    private Collection<Usuariopreco> usuarioprecoCollection;
    @OneToMany(mappedBy = "coduser")
    private Collection<Pedido> pedidoCollection;
    @OneToMany(mappedBy = "coduser")
    private Collection<Movendaproddevolucaocompra> movendaproddevolucaocompraCollection;
    @OneToMany(mappedBy = "coduser")
    private Collection<Cliente> clienteCollection;

    public Usuario() {
    }

    public Usuario(String coduser) {
        this.coduser = coduser;
    }

    public Usuario(String coduser, String codigo, String login, String senha) {
        this.coduser = coduser;
        this.codigo = codigo;
        this.login = login;
        this.senha = senha;
    }

    public String getCoduser() {
        return coduser;
    }

    public void setCoduser(String coduser) {
        this.coduser = coduser;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public BigDecimal getDescmax() {
        return descmax;
    }

    public void setDescmax(BigDecimal descmax) {
        this.descmax = descmax;
    }

    public BigDecimal getDescmaxtab2() {
        return descmaxtab2;
    }

    public void setDescmaxtab2(BigDecimal descmaxtab2) {
        this.descmaxtab2 = descmaxtab2;
    }

    public String getCodprecopadrao() {
        return codprecopadrao;
    }

    public void setCodprecopadrao(String codprecopadrao) {
        this.codprecopadrao = codprecopadrao;
    }

    public String getAssinaturaemail() {
        return assinaturaemail;
    }

    public void setAssinaturaemail(String assinaturaemail) {
        this.assinaturaemail = assinaturaemail;
    }

    public Character getProgramaemail() {
        return programaemail;
    }

    public void setProgramaemail(Character programaemail) {
        this.programaemail = programaemail;
    }

    public String getEmailretorno() {
        return emailretorno;
    }

    public void setEmailretorno(String emailretorno) {
        this.emailretorno = emailretorno;
    }

    public String getEmailnome() {
        return emailnome;
    }

    public void setEmailnome(String emailnome) {
        this.emailnome = emailnome;
    }

    public String getEmailservidorsmtp() {
        return emailservidorsmtp;
    }

    public void setEmailservidorsmtp(String emailservidorsmtp) {
        this.emailservidorsmtp = emailservidorsmtp;
    }

    public String getEmailservidorpop() {
        return emailservidorpop;
    }

    public void setEmailservidorpop(String emailservidorpop) {
        this.emailservidorpop = emailservidorpop;
    }

    public String getEmailnomeusuario() {
        return emailnomeusuario;
    }

    public void setEmailnomeusuario(String emailnomeusuario) {
        this.emailnomeusuario = emailnomeusuario;
    }

    public String getEmailsenhausuario() {
        return emailsenhausuario;
    }

    public void setEmailsenhausuario(String emailsenhausuario) {
        this.emailsenhausuario = emailsenhausuario;
    }

    public Character getEmailusassl() {
        return emailusassl;
    }

    public void setEmailusassl(Character emailusassl) {
        this.emailusassl = emailusassl;
    }

    public String getCodsetorestoquepadrao() {
        return codsetorestoquepadrao;
    }

    public void setCodsetorestoquepadrao(String codsetorestoquepadrao) {
        this.codsetorestoquepadrao = codsetorestoquepadrao;
    }

    public Character getPermitealterarsetorestoque() {
        return permitealterarsetorestoque;
    }

    public void setPermitealterarsetorestoque(Character permitealterarsetorestoque) {
        this.permitealterarsetorestoque = permitealterarsetorestoque;
    }

    public Character getFlagadministrador() {
        return flagadministrador;
    }

    public void setFlagadministrador(Character flagadministrador) {
        this.flagadministrador = flagadministrador;
    }

    public String getCodcaixas() {
        return codcaixas;
    }

    public void setCodcaixas(String codcaixas) {
        this.codcaixas = codcaixas;
    }

    public String getCodperfilusuario() {
        return codperfilusuario;
    }

    public void setCodperfilusuario(String codperfilusuario) {
        this.codperfilusuario = codperfilusuario;
    }

    public String getListacaixa() {
        return listacaixa;
    }

    public void setListacaixa(String listacaixa) {
        this.listacaixa = listacaixa;
    }

    public Character getFlagativo() {
        return flagativo;
    }

    public void setFlagativo(Character flagativo) {
        this.flagativo = flagativo;
    }

    public Character getFlagusuarioafv() {
        return flagusuarioafv;
    }

    public void setFlagusuarioafv(Character flagusuarioafv) {
        this.flagusuarioafv = flagusuarioafv;
    }

    public Character getFlagusasslpop() {
        return flagusasslpop;
    }

    public void setFlagusasslpop(Character flagusasslpop) {
        this.flagusasslpop = flagusasslpop;
    }

    public Integer getPortapop() {
        return portapop;
    }

    public void setPortapop(Integer portapop) {
        this.portapop = portapop;
    }

    public Character getFlagautenticasmtp() {
        return flagautenticasmtp;
    }

    public void setFlagautenticasmtp(Character flagautenticasmtp) {
        this.flagautenticasmtp = flagautenticasmtp;
    }

    public Integer getPortasmtp() {
        return portasmtp;
    }

    public void setPortasmtp(Integer portasmtp) {
        this.portasmtp = portasmtp;
    }

    public String getTipocriptografiasmtp() {
        return tipocriptografiasmtp;
    }

    public void setTipocriptografiasmtp(String tipocriptografiasmtp) {
        this.tipocriptografiasmtp = tipocriptografiasmtp;
    }

    public Character getFlagtodosorcamentos() {
        return flagtodosorcamentos;
    }

    public void setFlagtodosorcamentos(Character flagtodosorcamentos) {
        this.flagtodosorcamentos = flagtodosorcamentos;
    }

    public BigDecimal getLimitecredito() {
        return limitecredito;
    }

    public void setLimitecredito(BigDecimal limitecredito) {
        this.limitecredito = limitecredito;
    }

    public BigDecimal getLimitefaturamento() {
        return limitefaturamento;
    }

    public void setLimitefaturamento(BigDecimal limitefaturamento) {
        this.limitefaturamento = limitefaturamento;
    }

    public String getListaoperacao() {
        return listaoperacao;
    }

    public void setListaoperacao(String listaoperacao) {
        this.listaoperacao = listaoperacao;
    }

    public String getListaorcamentostatus() {
        return listaorcamentostatus;
    }

    public void setListaorcamentostatus(String listaorcamentostatus) {
        this.listaorcamentostatus = listaorcamentostatus;
    }

    public Character getFlagpodealterarsa() {
        return flagpodealterarsa;
    }

    public void setFlagpodealterarsa(Character flagpodealterarsa) {
        this.flagpodealterarsa = flagpodealterarsa;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Character getNaopermitealterarcaixa() {
        return naopermitealterarcaixa;
    }

    public void setNaopermitealterarcaixa(Character naopermitealterarcaixa) {
        this.naopermitealterarcaixa = naopermitealterarcaixa;
    }

    public String getListatabelaprecoafv() {
        return listatabelaprecoafv;
    }

    public void setListatabelaprecoafv(String listatabelaprecoafv) {
        this.listatabelaprecoafv = listatabelaprecoafv;
    }

    @XmlTransient
    public Collection<Producaohistorico> getProducaohistoricoCollection() {
        return producaohistoricoCollection;
    }

    public void setProducaohistoricoCollection(Collection<Producaohistorico> producaohistoricoCollection) {
        this.producaohistoricoCollection = producaohistoricoCollection;
    }

    @XmlTransient
    public Collection<Documento> getDocumentoCollection() {
        return documentoCollection;
    }

    public void setDocumentoCollection(Collection<Documento> documentoCollection) {
        this.documentoCollection = documentoCollection;
    }

    @XmlTransient
    public Collection<Rma> getRmaCollection() {
        return rmaCollection;
    }

    public void setRmaCollection(Collection<Rma> rmaCollection) {
        this.rmaCollection = rmaCollection;
    }

    @XmlTransient
    public Collection<Etiquetaendereco> getEtiquetaenderecoCollection() {
        return etiquetaenderecoCollection;
    }

    public void setEtiquetaenderecoCollection(Collection<Etiquetaendereco> etiquetaenderecoCollection) {
        this.etiquetaenderecoCollection = etiquetaenderecoCollection;
    }

    public Empresa getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Empresa codempresa) {
        this.codempresa = codempresa;
    }

    public Funcionario getCodfuncionario() {
        return codfuncionario;
    }

    public void setCodfuncionario(Funcionario codfuncionario) {
        this.codfuncionario = codfuncionario;
    }

    public Situacaoadministrativa getCodsituacaoadministrativa() {
        return codsituacaoadministrativa;
    }

    public void setCodsituacaoadministrativa(Situacaoadministrativa codsituacaoadministrativa) {
        this.codsituacaoadministrativa = codsituacaoadministrativa;
    }

    public Vendedor getCodvended() {
        return codvended;
    }

    public void setCodvended(Vendedor codvended) {
        this.codvended = codvended;
    }

    @XmlTransient
    public Collection<Usuariopreco> getUsuarioprecoCollection() {
        return usuarioprecoCollection;
    }

    public void setUsuarioprecoCollection(Collection<Usuariopreco> usuarioprecoCollection) {
        this.usuarioprecoCollection = usuarioprecoCollection;
    }

    @XmlTransient
    public Collection<Pedido> getPedidoCollection() {
        return pedidoCollection;
    }

    public void setPedidoCollection(Collection<Pedido> pedidoCollection) {
        this.pedidoCollection = pedidoCollection;
    }

    @XmlTransient
    public Collection<Movendaproddevolucaocompra> getMovendaproddevolucaocompraCollection() {
        return movendaproddevolucaocompraCollection;
    }

    public void setMovendaproddevolucaocompraCollection(Collection<Movendaproddevolucaocompra> movendaproddevolucaocompraCollection) {
        this.movendaproddevolucaocompraCollection = movendaproddevolucaocompraCollection;
    }

    @XmlTransient
    public Collection<Cliente> getClienteCollection() {
        return clienteCollection;
    }

    public void setClienteCollection(Collection<Cliente> clienteCollection) {
        this.clienteCollection = clienteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coduser != null ? coduser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.coduser == null && other.coduser != null) || (this.coduser != null && !this.coduser.equals(other.coduser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Usuario[ coduser=" + coduser + " ]";
    }
    
}
