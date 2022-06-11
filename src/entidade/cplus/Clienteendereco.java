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
@Table(name = "CLIENTEENDERECO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clienteendereco.findAll", query = "SELECT c FROM Clienteendereco c")
    , @NamedQuery(name = "Clienteendereco.findByCodclienteendereco", query = "SELECT c FROM Clienteendereco c WHERE c.codclienteendereco = :codclienteendereco")
    , @NamedQuery(name = "Clienteendereco.findByCodigo", query = "SELECT c FROM Clienteendereco c WHERE c.codigo = :codigo")
    , @NamedQuery(name = "Clienteendereco.findByEndereco", query = "SELECT c FROM Clienteendereco c WHERE c.endereco = :endereco")
    , @NamedQuery(name = "Clienteendereco.findByBairro", query = "SELECT c FROM Clienteendereco c WHERE c.bairro = :bairro")
    , @NamedQuery(name = "Clienteendereco.findByCidade", query = "SELECT c FROM Clienteendereco c WHERE c.cidade = :cidade")
    , @NamedQuery(name = "Clienteendereco.findByEstado", query = "SELECT c FROM Clienteendereco c WHERE c.estado = :estado")
    , @NamedQuery(name = "Clienteendereco.findByCep", query = "SELECT c FROM Clienteendereco c WHERE c.cep = :cep")
    , @NamedQuery(name = "Clienteendereco.findByCnpjcpf", query = "SELECT c FROM Clienteendereco c WHERE c.cnpjcpf = :cnpjcpf")
    , @NamedQuery(name = "Clienteendereco.findByTelefone", query = "SELECT c FROM Clienteendereco c WHERE c.telefone = :telefone")
    , @NamedQuery(name = "Clienteendereco.findByContato", query = "SELECT c FROM Clienteendereco c WHERE c.contato = :contato")
    , @NamedQuery(name = "Clienteendereco.findByNumerologradouro", query = "SELECT c FROM Clienteendereco c WHERE c.numerologradouro = :numerologradouro")
    , @NamedQuery(name = "Clienteendereco.findByComplementologradouro", query = "SELECT c FROM Clienteendereco c WHERE c.complementologradouro = :complementologradouro")
    , @NamedQuery(name = "Clienteendereco.findByReferencia", query = "SELECT c FROM Clienteendereco c WHERE c.referencia = :referencia")
    , @NamedQuery(name = "Clienteendereco.findByCodcaracteristicapessoa", query = "SELECT c FROM Clienteendereco c WHERE c.codcaracteristicapessoa = :codcaracteristicapessoa")
    , @NamedQuery(name = "Clienteendereco.findByHorariofuncini", query = "SELECT c FROM Clienteendereco c WHERE c.horariofuncini = :horariofuncini")
    , @NamedQuery(name = "Clienteendereco.findByHorariofuncintervaloini", query = "SELECT c FROM Clienteendereco c WHERE c.horariofuncintervaloini = :horariofuncintervaloini")
    , @NamedQuery(name = "Clienteendereco.findByHorariofuncintervalofin", query = "SELECT c FROM Clienteendereco c WHERE c.horariofuncintervalofin = :horariofuncintervalofin")
    , @NamedQuery(name = "Clienteendereco.findByHorariofuncfin", query = "SELECT c FROM Clienteendereco c WHERE c.horariofuncfin = :horariofuncfin")})
public class Clienteendereco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCLIENTEENDERECO")
    private String codclienteendereco;
    @Column(name = "CODIGO")
    private String codigo;
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
    @Column(name = "CNPJCPF")
    private String cnpjcpf;
    @Column(name = "TELEFONE")
    private String telefone;
    @Column(name = "CONTATO")
    private String contato;
    @Column(name = "NUMEROLOGRADOURO")
    private String numerologradouro;
    @Column(name = "COMPLEMENTOLOGRADOURO")
    private String complementologradouro;
    @Column(name = "REFERENCIA")
    private String referencia;
    @Column(name = "CODCARACTERISTICAPESSOA")
    private String codcaracteristicapessoa;
    @Column(name = "HORARIOFUNCINI")
    @Temporal(TemporalType.TIME)
    private Date horariofuncini;
    @Column(name = "HORARIOFUNCINTERVALOINI")
    @Temporal(TemporalType.TIME)
    private Date horariofuncintervaloini;
    @Column(name = "HORARIOFUNCINTERVALOFIN")
    @Temporal(TemporalType.TIME)
    private Date horariofuncintervalofin;
    @Column(name = "HORARIOFUNCFIN")
    @Temporal(TemporalType.TIME)
    private Date horariofuncfin;
    @JoinColumn(name = "CODCLI", referencedColumnName = "CODCLI")
    @ManyToOne
    private Cliente codcli;
    @JoinColumn(name = "CODTIPOENDERECO", referencedColumnName = "CODTIPOENDERECO")
    @ManyToOne
    private Tipoendereco codtipoendereco;
    @OneToMany(mappedBy = "codclienteendereco")
    private Collection<OsOrdemservico> osOrdemservicoCollection;

    public Clienteendereco() {
    }

    public Clienteendereco(String codclienteendereco) {
        this.codclienteendereco = codclienteendereco;
    }

    public String getCodclienteendereco() {
        return codclienteendereco;
    }

    public void setCodclienteendereco(String codclienteendereco) {
        this.codclienteendereco = codclienteendereco;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public String getCnpjcpf() {
        return cnpjcpf;
    }

    public void setCnpjcpf(String cnpjcpf) {
        this.cnpjcpf = cnpjcpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
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

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getCodcaracteristicapessoa() {
        return codcaracteristicapessoa;
    }

    public void setCodcaracteristicapessoa(String codcaracteristicapessoa) {
        this.codcaracteristicapessoa = codcaracteristicapessoa;
    }

    public Date getHorariofuncini() {
        return horariofuncini;
    }

    public void setHorariofuncini(Date horariofuncini) {
        this.horariofuncini = horariofuncini;
    }

    public Date getHorariofuncintervaloini() {
        return horariofuncintervaloini;
    }

    public void setHorariofuncintervaloini(Date horariofuncintervaloini) {
        this.horariofuncintervaloini = horariofuncintervaloini;
    }

    public Date getHorariofuncintervalofin() {
        return horariofuncintervalofin;
    }

    public void setHorariofuncintervalofin(Date horariofuncintervalofin) {
        this.horariofuncintervalofin = horariofuncintervalofin;
    }

    public Date getHorariofuncfin() {
        return horariofuncfin;
    }

    public void setHorariofuncfin(Date horariofuncfin) {
        this.horariofuncfin = horariofuncfin;
    }

    public Cliente getCodcli() {
        return codcli;
    }

    public void setCodcli(Cliente codcli) {
        this.codcli = codcli;
    }

    public Tipoendereco getCodtipoendereco() {
        return codtipoendereco;
    }

    public void setCodtipoendereco(Tipoendereco codtipoendereco) {
        this.codtipoendereco = codtipoendereco;
    }

    @XmlTransient
    public Collection<OsOrdemservico> getOsOrdemservicoCollection() {
        return osOrdemservicoCollection;
    }

    public void setOsOrdemservicoCollection(Collection<OsOrdemservico> osOrdemservicoCollection) {
        this.osOrdemservicoCollection = osOrdemservicoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codclienteendereco != null ? codclienteendereco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clienteendereco)) {
            return false;
        }
        Clienteendereco other = (Clienteendereco) object;
        if ((this.codclienteendereco == null && other.codclienteendereco != null) || (this.codclienteendereco != null && !this.codclienteendereco.equals(other.codclienteendereco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Clienteendereco[ codclienteendereco=" + codclienteendereco + " ]";
    }
    
}
