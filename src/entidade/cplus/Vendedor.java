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
import javax.persistence.CascadeType;
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
@Table(name = "VENDEDOR", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vendedor.findAll", query = "SELECT v FROM Vendedor v")
    , @NamedQuery(name = "Vendedor.findByCodvended", query = "SELECT v FROM Vendedor v WHERE v.codvended = :codvended")
    , @NamedQuery(name = "Vendedor.findByCodigo", query = "SELECT v FROM Vendedor v WHERE v.codigo = :codigo")
    , @NamedQuery(name = "Vendedor.findByNomevended", query = "SELECT v FROM Vendedor v WHERE v.nomevended = :nomevended")
    , @NamedQuery(name = "Vendedor.findByComissao", query = "SELECT v FROM Vendedor v WHERE v.comissao = :comissao")
    , @NamedQuery(name = "Vendedor.findByInativo", query = "SELECT v FROM Vendedor v WHERE v.inativo = :inativo")
    , @NamedQuery(name = "Vendedor.findByTipo", query = "SELECT v FROM Vendedor v WHERE v.tipo = :tipo")
    , @NamedQuery(name = "Vendedor.findByLimitecheque", query = "SELECT v FROM Vendedor v WHERE v.limitecheque = :limitecheque")
    , @NamedQuery(name = "Vendedor.findByRazaosocial", query = "SELECT v FROM Vendedor v WHERE v.razaosocial = :razaosocial")
    , @NamedQuery(name = "Vendedor.findByTelefone", query = "SELECT v FROM Vendedor v WHERE v.telefone = :telefone")
    , @NamedQuery(name = "Vendedor.findByEndereco", query = "SELECT v FROM Vendedor v WHERE v.endereco = :endereco")
    , @NamedQuery(name = "Vendedor.findByBairro", query = "SELECT v FROM Vendedor v WHERE v.bairro = :bairro")
    , @NamedQuery(name = "Vendedor.findByCidade", query = "SELECT v FROM Vendedor v WHERE v.cidade = :cidade")
    , @NamedQuery(name = "Vendedor.findByEstado", query = "SELECT v FROM Vendedor v WHERE v.estado = :estado")
    , @NamedQuery(name = "Vendedor.findByCep", query = "SELECT v FROM Vendedor v WHERE v.cep = :cep")
    , @NamedQuery(name = "Vendedor.findByEmail", query = "SELECT v FROM Vendedor v WHERE v.email = :email")
    , @NamedQuery(name = "Vendedor.findByComissao2", query = "SELECT v FROM Vendedor v WHERE v.comissao2 = :comissao2")
    , @NamedQuery(name = "Vendedor.findByFlagcomacresitem", query = "SELECT v FROM Vendedor v WHERE v.flagcomacresitem = :flagcomacresitem")
    , @NamedQuery(name = "Vendedor.findByFlagcomdescitem", query = "SELECT v FROM Vendedor v WHERE v.flagcomdescitem = :flagcomdescitem")
    , @NamedQuery(name = "Vendedor.findByFlagcomacresbase", query = "SELECT v FROM Vendedor v WHERE v.flagcomacresbase = :flagcomacresbase")
    , @NamedQuery(name = "Vendedor.findByFlagcomdescbase", query = "SELECT v FROM Vendedor v WHERE v.flagcomdescbase = :flagcomdescbase")
    , @NamedQuery(name = "Vendedor.findByFlagcomfretebase", query = "SELECT v FROM Vendedor v WHERE v.flagcomfretebase = :flagcomfretebase")
    , @NamedQuery(name = "Vendedor.findByFlagcomsegbase", query = "SELECT v FROM Vendedor v WHERE v.flagcomsegbase = :flagcomsegbase")
    , @NamedQuery(name = "Vendedor.findByFlagcomoutdespbase", query = "SELECT v FROM Vendedor v WHERE v.flagcomoutdespbase = :flagcomoutdespbase")
    , @NamedQuery(name = "Vendedor.findByFlagcomipibasecalc", query = "SELECT v FROM Vendedor v WHERE v.flagcomipibasecalc = :flagcomipibasecalc")
    , @NamedQuery(name = "Vendedor.findByFlagcomsubstribasecalc", query = "SELECT v FROM Vendedor v WHERE v.flagcomsubstribasecalc = :flagcomsubstribasecalc")
    , @NamedQuery(name = "Vendedor.findByFlagcombasecalc", query = "SELECT v FROM Vendedor v WHERE v.flagcombasecalc = :flagcombasecalc")
    , @NamedQuery(name = "Vendedor.findByFlagcomcalcular", query = "SELECT v FROM Vendedor v WHERE v.flagcomcalcular = :flagcomcalcular")
    , @NamedQuery(name = "Vendedor.findByFlagcomregradif", query = "SELECT v FROM Vendedor v WHERE v.flagcomregradif = :flagcomregradif")
    , @NamedQuery(name = "Vendedor.findByIdrelatorio", query = "SELECT v FROM Vendedor v WHERE v.idrelatorio = :idrelatorio")
    , @NamedQuery(name = "Vendedor.findByGuid", query = "SELECT v FROM Vendedor v WHERE v.guid = :guid")
    , @NamedQuery(name = "Vendedor.findByCpf", query = "SELECT v FROM Vendedor v WHERE v.cpf = :cpf")
    , @NamedQuery(name = "Vendedor.findByValorbonusdisp", query = "SELECT v FROM Vendedor v WHERE v.valorbonusdisp = :valorbonusdisp")
    , @NamedQuery(name = "Vendedor.findByValorbonussaldo", query = "SELECT v FROM Vendedor v WHERE v.valorbonussaldo = :valorbonussaldo")
    , @NamedQuery(name = "Vendedor.findByDatavalidadebonus", query = "SELECT v FROM Vendedor v WHERE v.datavalidadebonus = :datavalidadebonus")})
public class Vendedor implements Serializable {

    @Column(name = "FLAGFISICA")
    private Character flagfisica;
    @JoinColumn(name = "CODINTERMEDIADOR", referencedColumnName = "CODINTERMEDIADOR")
    @ManyToOne
    private Intermediador codintermediador;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODVENDED")
    private String codvended;
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private String codigo;
    @Basic(optional = false)
    @Column(name = "NOMEVENDED")
    private String nomevended;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "COMISSAO")
    private BigDecimal comissao;
    @Column(name = "INATIVO")
    private Character inativo;
    @Column(name = "TIPO")
    private Character tipo;
    @Column(name = "LIMITECHEQUE")
    private BigDecimal limitecheque;
    @Column(name = "RAZAOSOCIAL")
    private String razaosocial;
    @Column(name = "TELEFONE")
    private String telefone;
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
    @Column(name = "EMAIL")
    private String email;
    @Lob
    @Column(name = "OBSERVACAO")
    private String observacao;
    @Column(name = "COMISSAO2")
    private BigDecimal comissao2;
    @Column(name = "FLAGCOMACRESITEM")
    private Character flagcomacresitem;
    @Column(name = "FLAGCOMDESCITEM")
    private Character flagcomdescitem;
    @Column(name = "FLAGCOMACRESBASE")
    private Character flagcomacresbase;
    @Column(name = "FLAGCOMDESCBASE")
    private Character flagcomdescbase;
    @Column(name = "FLAGCOMFRETEBASE")
    private Character flagcomfretebase;
    @Column(name = "FLAGCOMSEGBASE")
    private Character flagcomsegbase;
    @Column(name = "FLAGCOMOUTDESPBASE")
    private Character flagcomoutdespbase;
    @Column(name = "FLAGCOMIPIBASECALC")
    private Character flagcomipibasecalc;
    @Column(name = "FLAGCOMSUBSTRIBASECALC")
    private Character flagcomsubstribasecalc;
    @Column(name = "FLAGCOMBASECALC")
    private Character flagcombasecalc;
    @Column(name = "FLAGCOMCALCULAR")
    private Character flagcomcalcular;
    @Column(name = "FLAGCOMREGRADIF")
    private Character flagcomregradif;
    @Column(name = "IDRELATORIO")
    private String idrelatorio;
    @Column(name = "GUID")
    private String guid;
    @Column(name = "CPF")
    private String cpf;
    @Column(name = "VALORBONUSDISP")
    private BigDecimal valorbonusdisp;
    @Column(name = "VALORBONUSSALDO")
    private BigDecimal valorbonussaldo;
    @Column(name = "DATAVALIDADEBONUS")
    @Temporal(TemporalType.DATE)
    private Date datavalidadebonus;
    @OneToMany(mappedBy = "codvended")
    private Collection<Moventrada> moventradaCollection;
    @OneToMany(mappedBy = "codvended")
    private Collection<Moventradaprod> moventradaprodCollection;
    @OneToMany(mappedBy = "codvendedsupervisor")
    private Collection<Vendedor> vendedorCollection;
    @JoinColumn(name = "CODVENDEDSUPERVISOR", referencedColumnName = "CODVENDED")
    @ManyToOne
    private Vendedor codvendedsupervisor;
    @OneToMany(mappedBy = "codvended")
    private Collection<OsTecnico> osTecnicoCollection;
    @OneToMany(mappedBy = "codvended")
    private Collection<Documento> documentoCollection;
    @OneToMany(mappedBy = "codvendedext")
    private Collection<Documento> documentoCollection1;
    @OneToMany(mappedBy = "codvendedrenegociacao")
    private Collection<Cheques> chequesCollection;
    @OneToMany(mappedBy = "codvended")
    private Collection<Rma> rmaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codvended")
    private Collection<Vendedorsecao> vendedorsecaoCollection;
    @OneToMany(mappedBy = "codvended")
    private Collection<Usuario> usuarioCollection;
    @OneToMany(mappedBy = "codvended")
    private Collection<Movendaprod> movendaprodCollection;
    @OneToMany(mappedBy = "codvendedrenegociacao")
    private Collection<Chequeshistorico> chequeshistoricoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codvended")
    private Collection<Vendedorcaracteristica> vendedorcaracteristicaCollection;
    @OneToMany(mappedBy = "codvended")
    private Collection<Orcamento> orcamentoCollection;
    @OneToMany(mappedBy = "codvendedext")
    private Collection<Orcamento> orcamentoCollection1;
    @OneToMany(mappedBy = "codvended")
    private Collection<Movenda> movendaCollection;
    @OneToMany(mappedBy = "codvendedext")
    private Collection<Movenda> movendaCollection1;
    @OneToMany(mappedBy = "codvended")
    private Collection<Orcamentoprod> orcamentoprodCollection;
    @OneToMany(mappedBy = "codvended")
    private Collection<Cliente> clienteCollection;
    @OneToMany(mappedBy = "codvendedext")
    private Collection<Cliente> clienteCollection1;

    public Vendedor() {
    }

    public Vendedor(String codvended) {
        this.codvended = codvended;
    }

    public Vendedor(String codvended, String codigo, String nomevended) {
        this.codvended = codvended;
        this.codigo = codigo;
        this.nomevended = nomevended;
    }

    public String getCodvended() {
        return codvended;
    }

    public void setCodvended(String codvended) {
        this.codvended = codvended;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomevended() {
        return nomevended;
    }

    public void setNomevended(String nomevended) {
        this.nomevended = nomevended;
    }

    public BigDecimal getComissao() {
        return comissao;
    }

    public void setComissao(BigDecimal comissao) {
        this.comissao = comissao;
    }

    public Character getInativo() {
        return inativo;
    }

    public void setInativo(Character inativo) {
        this.inativo = inativo;
    }

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getLimitecheque() {
        return limitecheque;
    }

    public void setLimitecheque(BigDecimal limitecheque) {
        this.limitecheque = limitecheque;
    }

    public String getRazaosocial() {
        return razaosocial;
    }

    public void setRazaosocial(String razaosocial) {
        this.razaosocial = razaosocial;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public BigDecimal getComissao2() {
        return comissao2;
    }

    public void setComissao2(BigDecimal comissao2) {
        this.comissao2 = comissao2;
    }

    public Character getFlagcomacresitem() {
        return flagcomacresitem;
    }

    public void setFlagcomacresitem(Character flagcomacresitem) {
        this.flagcomacresitem = flagcomacresitem;
    }

    public Character getFlagcomdescitem() {
        return flagcomdescitem;
    }

    public void setFlagcomdescitem(Character flagcomdescitem) {
        this.flagcomdescitem = flagcomdescitem;
    }

    public Character getFlagcomacresbase() {
        return flagcomacresbase;
    }

    public void setFlagcomacresbase(Character flagcomacresbase) {
        this.flagcomacresbase = flagcomacresbase;
    }

    public Character getFlagcomdescbase() {
        return flagcomdescbase;
    }

    public void setFlagcomdescbase(Character flagcomdescbase) {
        this.flagcomdescbase = flagcomdescbase;
    }

    public Character getFlagcomfretebase() {
        return flagcomfretebase;
    }

    public void setFlagcomfretebase(Character flagcomfretebase) {
        this.flagcomfretebase = flagcomfretebase;
    }

    public Character getFlagcomsegbase() {
        return flagcomsegbase;
    }

    public void setFlagcomsegbase(Character flagcomsegbase) {
        this.flagcomsegbase = flagcomsegbase;
    }

    public Character getFlagcomoutdespbase() {
        return flagcomoutdespbase;
    }

    public void setFlagcomoutdespbase(Character flagcomoutdespbase) {
        this.flagcomoutdespbase = flagcomoutdespbase;
    }

    public Character getFlagcomipibasecalc() {
        return flagcomipibasecalc;
    }

    public void setFlagcomipibasecalc(Character flagcomipibasecalc) {
        this.flagcomipibasecalc = flagcomipibasecalc;
    }

    public Character getFlagcomsubstribasecalc() {
        return flagcomsubstribasecalc;
    }

    public void setFlagcomsubstribasecalc(Character flagcomsubstribasecalc) {
        this.flagcomsubstribasecalc = flagcomsubstribasecalc;
    }

    public Character getFlagcombasecalc() {
        return flagcombasecalc;
    }

    public void setFlagcombasecalc(Character flagcombasecalc) {
        this.flagcombasecalc = flagcombasecalc;
    }

    public Character getFlagcomcalcular() {
        return flagcomcalcular;
    }

    public void setFlagcomcalcular(Character flagcomcalcular) {
        this.flagcomcalcular = flagcomcalcular;
    }

    public Character getFlagcomregradif() {
        return flagcomregradif;
    }

    public void setFlagcomregradif(Character flagcomregradif) {
        this.flagcomregradif = flagcomregradif;
    }

    public String getIdrelatorio() {
        return idrelatorio;
    }

    public void setIdrelatorio(String idrelatorio) {
        this.idrelatorio = idrelatorio;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public BigDecimal getValorbonusdisp() {
        return valorbonusdisp;
    }

    public void setValorbonusdisp(BigDecimal valorbonusdisp) {
        this.valorbonusdisp = valorbonusdisp;
    }

    public BigDecimal getValorbonussaldo() {
        return valorbonussaldo;
    }

    public void setValorbonussaldo(BigDecimal valorbonussaldo) {
        this.valorbonussaldo = valorbonussaldo;
    }

    public Date getDatavalidadebonus() {
        return datavalidadebonus;
    }

    public void setDatavalidadebonus(Date datavalidadebonus) {
        this.datavalidadebonus = datavalidadebonus;
    }

    @XmlTransient
    public Collection<Moventrada> getMoventradaCollection() {
        return moventradaCollection;
    }

    public void setMoventradaCollection(Collection<Moventrada> moventradaCollection) {
        this.moventradaCollection = moventradaCollection;
    }

    @XmlTransient
    public Collection<Moventradaprod> getMoventradaprodCollection() {
        return moventradaprodCollection;
    }

    public void setMoventradaprodCollection(Collection<Moventradaprod> moventradaprodCollection) {
        this.moventradaprodCollection = moventradaprodCollection;
    }

    @XmlTransient
    public Collection<Vendedor> getVendedorCollection() {
        return vendedorCollection;
    }

    public void setVendedorCollection(Collection<Vendedor> vendedorCollection) {
        this.vendedorCollection = vendedorCollection;
    }

    public Vendedor getCodvendedsupervisor() {
        return codvendedsupervisor;
    }

    public void setCodvendedsupervisor(Vendedor codvendedsupervisor) {
        this.codvendedsupervisor = codvendedsupervisor;
    }

    @XmlTransient
    public Collection<OsTecnico> getOsTecnicoCollection() {
        return osTecnicoCollection;
    }

    public void setOsTecnicoCollection(Collection<OsTecnico> osTecnicoCollection) {
        this.osTecnicoCollection = osTecnicoCollection;
    }

    @XmlTransient
    public Collection<Documento> getDocumentoCollection() {
        return documentoCollection;
    }

    public void setDocumentoCollection(Collection<Documento> documentoCollection) {
        this.documentoCollection = documentoCollection;
    }

    @XmlTransient
    public Collection<Documento> getDocumentoCollection1() {
        return documentoCollection1;
    }

    public void setDocumentoCollection1(Collection<Documento> documentoCollection1) {
        this.documentoCollection1 = documentoCollection1;
    }

    @XmlTransient
    public Collection<Cheques> getChequesCollection() {
        return chequesCollection;
    }

    public void setChequesCollection(Collection<Cheques> chequesCollection) {
        this.chequesCollection = chequesCollection;
    }

    @XmlTransient
    public Collection<Rma> getRmaCollection() {
        return rmaCollection;
    }

    public void setRmaCollection(Collection<Rma> rmaCollection) {
        this.rmaCollection = rmaCollection;
    }

    @XmlTransient
    public Collection<Vendedorsecao> getVendedorsecaoCollection() {
        return vendedorsecaoCollection;
    }

    public void setVendedorsecaoCollection(Collection<Vendedorsecao> vendedorsecaoCollection) {
        this.vendedorsecaoCollection = vendedorsecaoCollection;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @XmlTransient
    public Collection<Movendaprod> getMovendaprodCollection() {
        return movendaprodCollection;
    }

    public void setMovendaprodCollection(Collection<Movendaprod> movendaprodCollection) {
        this.movendaprodCollection = movendaprodCollection;
    }

    @XmlTransient
    public Collection<Chequeshistorico> getChequeshistoricoCollection() {
        return chequeshistoricoCollection;
    }

    public void setChequeshistoricoCollection(Collection<Chequeshistorico> chequeshistoricoCollection) {
        this.chequeshistoricoCollection = chequeshistoricoCollection;
    }

    @XmlTransient
    public Collection<Vendedorcaracteristica> getVendedorcaracteristicaCollection() {
        return vendedorcaracteristicaCollection;
    }

    public void setVendedorcaracteristicaCollection(Collection<Vendedorcaracteristica> vendedorcaracteristicaCollection) {
        this.vendedorcaracteristicaCollection = vendedorcaracteristicaCollection;
    }

    @XmlTransient
    public Collection<Orcamento> getOrcamentoCollection() {
        return orcamentoCollection;
    }

    public void setOrcamentoCollection(Collection<Orcamento> orcamentoCollection) {
        this.orcamentoCollection = orcamentoCollection;
    }

    @XmlTransient
    public Collection<Orcamento> getOrcamentoCollection1() {
        return orcamentoCollection1;
    }

    public void setOrcamentoCollection1(Collection<Orcamento> orcamentoCollection1) {
        this.orcamentoCollection1 = orcamentoCollection1;
    }

    @XmlTransient
    public Collection<Movenda> getMovendaCollection() {
        return movendaCollection;
    }

    public void setMovendaCollection(Collection<Movenda> movendaCollection) {
        this.movendaCollection = movendaCollection;
    }

    @XmlTransient
    public Collection<Movenda> getMovendaCollection1() {
        return movendaCollection1;
    }

    public void setMovendaCollection1(Collection<Movenda> movendaCollection1) {
        this.movendaCollection1 = movendaCollection1;
    }

    @XmlTransient
    public Collection<Orcamentoprod> getOrcamentoprodCollection() {
        return orcamentoprodCollection;
    }

    public void setOrcamentoprodCollection(Collection<Orcamentoprod> orcamentoprodCollection) {
        this.orcamentoprodCollection = orcamentoprodCollection;
    }

    @XmlTransient
    public Collection<Cliente> getClienteCollection() {
        return clienteCollection;
    }

    public void setClienteCollection(Collection<Cliente> clienteCollection) {
        this.clienteCollection = clienteCollection;
    }

    @XmlTransient
    public Collection<Cliente> getClienteCollection1() {
        return clienteCollection1;
    }

    public void setClienteCollection1(Collection<Cliente> clienteCollection1) {
        this.clienteCollection1 = clienteCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codvended != null ? codvended.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendedor)) {
            return false;
        }
        Vendedor other = (Vendedor) object;
        if ((this.codvended == null && other.codvended != null) || (this.codvended != null && !this.codvended.equals(other.codvended))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Vendedor[ codvended=" + codvended + " ]";
    }

    public Character getFlagfisica() {
        return flagfisica;
    }

    public void setFlagfisica(Character flagfisica) {
        this.flagfisica = flagfisica;
    }

    public Intermediador getCodintermediador() {
        return codintermediador;
    }

    public void setCodintermediador(Intermediador codintermediador) {
        this.codintermediador = codintermediador;
    }
    
}
