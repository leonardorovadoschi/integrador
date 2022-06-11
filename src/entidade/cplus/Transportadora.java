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
@Table(name = "TRANSPORTADORA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transportadora.findAll", query = "SELECT t FROM Transportadora t")
    , @NamedQuery(name = "Transportadora.findByCodtrans", query = "SELECT t FROM Transportadora t WHERE t.codtrans = :codtrans")
    , @NamedQuery(name = "Transportadora.findByNometrans", query = "SELECT t FROM Transportadora t WHERE t.nometrans = :nometrans")
    , @NamedQuery(name = "Transportadora.findByEndereco", query = "SELECT t FROM Transportadora t WHERE t.endereco = :endereco")
    , @NamedQuery(name = "Transportadora.findByBairro", query = "SELECT t FROM Transportadora t WHERE t.bairro = :bairro")
    , @NamedQuery(name = "Transportadora.findByCidade", query = "SELECT t FROM Transportadora t WHERE t.cidade = :cidade")
    , @NamedQuery(name = "Transportadora.findByEstado", query = "SELECT t FROM Transportadora t WHERE t.estado = :estado")
    , @NamedQuery(name = "Transportadora.findByCep", query = "SELECT t FROM Transportadora t WHERE t.cep = :cep")
    , @NamedQuery(name = "Transportadora.findByTelefone", query = "SELECT t FROM Transportadora t WHERE t.telefone = :telefone")
    , @NamedQuery(name = "Transportadora.findByFax", query = "SELECT t FROM Transportadora t WHERE t.fax = :fax")
    , @NamedQuery(name = "Transportadora.findByInscr", query = "SELECT t FROM Transportadora t WHERE t.inscr = :inscr")
    , @NamedQuery(name = "Transportadora.findByRefban", query = "SELECT t FROM Transportadora t WHERE t.refban = :refban")
    , @NamedQuery(name = "Transportadora.findByCnpj", query = "SELECT t FROM Transportadora t WHERE t.cnpj = :cnpj")
    , @NamedQuery(name = "Transportadora.findByRespons", query = "SELECT t FROM Transportadora t WHERE t.respons = :respons")
    , @NamedQuery(name = "Transportadora.findByDatcad", query = "SELECT t FROM Transportadora t WHERE t.datcad = :datcad")
    , @NamedQuery(name = "Transportadora.findByEmail", query = "SELECT t FROM Transportadora t WHERE t.email = :email")
    , @NamedQuery(name = "Transportadora.findByCodigo", query = "SELECT t FROM Transportadora t WHERE t.codigo = :codigo")
    , @NamedQuery(name = "Transportadora.findByAntt", query = "SELECT t FROM Transportadora t WHERE t.antt = :antt")
    , @NamedQuery(name = "Transportadora.findByFlagfisica", query = "SELECT t FROM Transportadora t WHERE t.flagfisica = :flagfisica")
    , @NamedQuery(name = "Transportadora.findByCodigointegracaofiscal", query = "SELECT t FROM Transportadora t WHERE t.codigointegracaofiscal = :codigointegracaofiscal")
    , @NamedQuery(name = "Transportadora.findByGuid", query = "SELECT t FROM Transportadora t WHERE t.guid = :guid")
    , @NamedQuery(name = "Transportadora.findByFlagativo", query = "SELECT t FROM Transportadora t WHERE t.flagativo = :flagativo")
    , @NamedQuery(name = "Transportadora.findByTipoproprietario", query = "SELECT t FROM Transportadora t WHERE t.tipoproprietario = :tipoproprietario")
    , @NamedQuery(name = "Transportadora.findByCategoria", query = "SELECT t FROM Transportadora t WHERE t.categoria = :categoria")
    , @NamedQuery(name = "Transportadora.findByNumerologradouro", query = "SELECT t FROM Transportadora t WHERE t.numerologradouro = :numerologradouro")
    , @NamedQuery(name = "Transportadora.findByComplementologradouro", query = "SELECT t FROM Transportadora t WHERE t.complementologradouro = :complementologradouro")})
public class Transportadora implements Serializable {

    @Column(name = "RAZAOSOCIAL")
    private String razaosocial;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODTRANS")
    private String codtrans;
    @Basic(optional = false)
    @Column(name = "NOMETRANS")
    private String nometrans;
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
    @Column(name = "RESPONS")
    private String respons;
    @Column(name = "DATCAD")
    @Temporal(TemporalType.DATE)
    private Date datcad;
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "ANTT")
    private String antt;
    @Column(name = "FLAGFISICA")
    private Character flagfisica;
    @Column(name = "CODIGOINTEGRACAOFISCAL")
    private String codigointegracaofiscal;
    @Column(name = "GUID")
    private String guid;
    @Basic(optional = false)
    @Column(name = "FLAGATIVO")
    private Character flagativo;
    @Column(name = "TIPOPROPRIETARIO")
    private Character tipoproprietario;
    @Column(name = "CATEGORIA")
    private String categoria;
    @Column(name = "NUMEROLOGRADOURO")
    private String numerologradouro;
    @Column(name = "COMPLEMENTOLOGRADOURO")
    private String complementologradouro;
    @OneToMany(mappedBy = "codtrans")
    private Collection<Documento> documentoCollection;
    @OneToMany(mappedBy = "codtrans")
    private Collection<Veiculos> veiculosCollection;
    @OneToMany(mappedBy = "codtrans")
    private Collection<Fornecedor> fornecedorCollection;
    @OneToMany(mappedBy = "codtrans")
    private Collection<Moentrega> moentregaCollection;
    @OneToMany(mappedBy = "codtrans")
    private Collection<Orcamento> orcamentoCollection;
    @OneToMany(mappedBy = "codtrans")
    private Collection<Movenda> movendaCollection;
    @OneToMany(mappedBy = "codtrans")
    private Collection<Pedido> pedidoCollection;
    @OneToMany(mappedBy = "codtrans")
    private Collection<Cliente> clienteCollection;

    public Transportadora() {
    }

    public Transportadora(String codtrans) {
        this.codtrans = codtrans;
    }

    public Transportadora(String codtrans, String nometrans, String codigo, Character flagativo) {
        this.codtrans = codtrans;
        this.nometrans = nometrans;
        this.codigo = codigo;
        this.flagativo = flagativo;
    }

    public String getCodtrans() {
        return codtrans;
    }

    public void setCodtrans(String codtrans) {
        this.codtrans = codtrans;
    }

    public String getNometrans() {
        return nometrans;
    }

    public void setNometrans(String nometrans) {
        this.nometrans = nometrans;
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

    public String getRespons() {
        return respons;
    }

    public void setRespons(String respons) {
        this.respons = respons;
    }

    public Date getDatcad() {
        return datcad;
    }

    public void setDatcad(Date datcad) {
        this.datcad = datcad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getAntt() {
        return antt;
    }

    public void setAntt(String antt) {
        this.antt = antt;
    }

    public Character getFlagfisica() {
        return flagfisica;
    }

    public void setFlagfisica(Character flagfisica) {
        this.flagfisica = flagfisica;
    }

    public String getCodigointegracaofiscal() {
        return codigointegracaofiscal;
    }

    public void setCodigointegracaofiscal(String codigointegracaofiscal) {
        this.codigointegracaofiscal = codigointegracaofiscal;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Character getFlagativo() {
        return flagativo;
    }

    public void setFlagativo(Character flagativo) {
        this.flagativo = flagativo;
    }

    public Character getTipoproprietario() {
        return tipoproprietario;
    }

    public void setTipoproprietario(Character tipoproprietario) {
        this.tipoproprietario = tipoproprietario;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
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

    @XmlTransient
    public Collection<Documento> getDocumentoCollection() {
        return documentoCollection;
    }

    public void setDocumentoCollection(Collection<Documento> documentoCollection) {
        this.documentoCollection = documentoCollection;
    }

    @XmlTransient
    public Collection<Veiculos> getVeiculosCollection() {
        return veiculosCollection;
    }

    public void setVeiculosCollection(Collection<Veiculos> veiculosCollection) {
        this.veiculosCollection = veiculosCollection;
    }

    @XmlTransient
    public Collection<Fornecedor> getFornecedorCollection() {
        return fornecedorCollection;
    }

    public void setFornecedorCollection(Collection<Fornecedor> fornecedorCollection) {
        this.fornecedorCollection = fornecedorCollection;
    }

    @XmlTransient
    public Collection<Moentrega> getMoentregaCollection() {
        return moentregaCollection;
    }

    public void setMoentregaCollection(Collection<Moentrega> moentregaCollection) {
        this.moentregaCollection = moentregaCollection;
    }

    @XmlTransient
    public Collection<Orcamento> getOrcamentoCollection() {
        return orcamentoCollection;
    }

    public void setOrcamentoCollection(Collection<Orcamento> orcamentoCollection) {
        this.orcamentoCollection = orcamentoCollection;
    }

    @XmlTransient
    public Collection<Movenda> getMovendaCollection() {
        return movendaCollection;
    }

    public void setMovendaCollection(Collection<Movenda> movendaCollection) {
        this.movendaCollection = movendaCollection;
    }

    @XmlTransient
    public Collection<Pedido> getPedidoCollection() {
        return pedidoCollection;
    }

    public void setPedidoCollection(Collection<Pedido> pedidoCollection) {
        this.pedidoCollection = pedidoCollection;
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
        hash += (codtrans != null ? codtrans.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transportadora)) {
            return false;
        }
        Transportadora other = (Transportadora) object;
        if ((this.codtrans == null && other.codtrans != null) || (this.codtrans != null && !this.codtrans.equals(other.codtrans))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Transportadora[ codtrans=" + codtrans + " ]";
    }

    public String getRazaosocial() {
        return razaosocial;
    }

    public void setRazaosocial(String razaosocial) {
        this.razaosocial = razaosocial;
    }
    
}
