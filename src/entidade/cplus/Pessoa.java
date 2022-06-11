/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
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
@Table(name = "PESSOA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pessoa.findAll", query = "SELECT p FROM Pessoa p")
    , @NamedQuery(name = "Pessoa.findByCodpessoa", query = "SELECT p FROM Pessoa p WHERE p.codpessoa = :codpessoa")
    , @NamedQuery(name = "Pessoa.findByCodigo", query = "SELECT p FROM Pessoa p WHERE p.codigo = :codigo")
    , @NamedQuery(name = "Pessoa.findByNomepessoa", query = "SELECT p FROM Pessoa p WHERE p.nomepessoa = :nomepessoa")
    , @NamedQuery(name = "Pessoa.findByFlagtipopessoa", query = "SELECT p FROM Pessoa p WHERE p.flagtipopessoa = :flagtipopessoa")
    , @NamedQuery(name = "Pessoa.findByCpf", query = "SELECT p FROM Pessoa p WHERE p.cpf = :cpf")
    , @NamedQuery(name = "Pessoa.findByCnpj", query = "SELECT p FROM Pessoa p WHERE p.cnpj = :cnpj")
    , @NamedQuery(name = "Pessoa.findByInscricaocrc", query = "SELECT p FROM Pessoa p WHERE p.inscricaocrc = :inscricaocrc")
    , @NamedQuery(name = "Pessoa.findByCep", query = "SELECT p FROM Pessoa p WHERE p.cep = :cep")
    , @NamedQuery(name = "Pessoa.findByLogradouro", query = "SELECT p FROM Pessoa p WHERE p.logradouro = :logradouro")
    , @NamedQuery(name = "Pessoa.findByNumero", query = "SELECT p FROM Pessoa p WHERE p.numero = :numero")
    , @NamedQuery(name = "Pessoa.findByComplemento", query = "SELECT p FROM Pessoa p WHERE p.complemento = :complemento")
    , @NamedQuery(name = "Pessoa.findByBairro", query = "SELECT p FROM Pessoa p WHERE p.bairro = :bairro")
    , @NamedQuery(name = "Pessoa.findByCidade", query = "SELECT p FROM Pessoa p WHERE p.cidade = :cidade")
    , @NamedQuery(name = "Pessoa.findByTelefone", query = "SELECT p FROM Pessoa p WHERE p.telefone = :telefone")
    , @NamedQuery(name = "Pessoa.findByFax", query = "SELECT p FROM Pessoa p WHERE p.fax = :fax")
    , @NamedQuery(name = "Pessoa.findByEmail", query = "SELECT p FROM Pessoa p WHERE p.email = :email")
    , @NamedQuery(name = "Pessoa.findByNumerocrf", query = "SELECT p FROM Pessoa p WHERE p.numerocrf = :numerocrf")
    , @NamedQuery(name = "Pessoa.findByCodufconselho", query = "SELECT p FROM Pessoa p WHERE p.codufconselho = :codufconselho")
    , @NamedQuery(name = "Pessoa.findByNomeconselho", query = "SELECT p FROM Pessoa p WHERE p.nomeconselho = :nomeconselho")
    , @NamedQuery(name = "Pessoa.findByCnpjescritorio", query = "SELECT p FROM Pessoa p WHERE p.cnpjescritorio = :cnpjescritorio")
    , @NamedQuery(name = "Pessoa.findByFlaginativa", query = "SELECT p FROM Pessoa p WHERE p.flaginativa = :flaginativa")})
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODPESSOA")
    private String codpessoa;
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "NOMEPESSOA")
    private String nomepessoa;
    @Column(name = "FLAGTIPOPESSOA")
    private Character flagtipopessoa;
    @Column(name = "CPF")
    private String cpf;
    @Column(name = "CNPJ")
    private String cnpj;
    @Column(name = "INSCRICAOCRC")
    private String inscricaocrc;
    @Column(name = "CEP")
    private String cep;
    @Column(name = "LOGRADOURO")
    private String logradouro;
    @Column(name = "NUMERO")
    private String numero;
    @Column(name = "COMPLEMENTO")
    private String complemento;
    @Column(name = "BAIRRO")
    private String bairro;
    @Column(name = "CIDADE")
    private String cidade;
    @Column(name = "TELEFONE")
    private String telefone;
    @Column(name = "FAX")
    private String fax;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "NUMEROCRF")
    private String numerocrf;
    @Column(name = "CODUFCONSELHO")
    private String codufconselho;
    @Column(name = "NOMECONSELHO")
    private String nomeconselho;
    @Column(name = "CNPJESCRITORIO")
    private String cnpjescritorio;
    @Lob
    @Column(name = "OBS")
    private String obs;
    @Column(name = "FLAGINATIVA")
    private Character flaginativa;
    @OneToMany(mappedBy = "codpessoa")
    private Collection<Pessoacategoria> pessoacategoriaCollection;
    @JoinColumn(name = "CODUF", referencedColumnName = "CODUF")
    @ManyToOne
    private Uf coduf;

    public Pessoa() {
    }

    public Pessoa(String codpessoa) {
        this.codpessoa = codpessoa;
    }

    public String getCodpessoa() {
        return codpessoa;
    }

    public void setCodpessoa(String codpessoa) {
        this.codpessoa = codpessoa;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomepessoa() {
        return nomepessoa;
    }

    public void setNomepessoa(String nomepessoa) {
        this.nomepessoa = nomepessoa;
    }

    public Character getFlagtipopessoa() {
        return flagtipopessoa;
    }

    public void setFlagtipopessoa(Character flagtipopessoa) {
        this.flagtipopessoa = flagtipopessoa;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaocrc() {
        return inscricaocrc;
    }

    public void setInscricaocrc(String inscricaocrc) {
        this.inscricaocrc = inscricaocrc;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumerocrf() {
        return numerocrf;
    }

    public void setNumerocrf(String numerocrf) {
        this.numerocrf = numerocrf;
    }

    public String getCodufconselho() {
        return codufconselho;
    }

    public void setCodufconselho(String codufconselho) {
        this.codufconselho = codufconselho;
    }

    public String getNomeconselho() {
        return nomeconselho;
    }

    public void setNomeconselho(String nomeconselho) {
        this.nomeconselho = nomeconselho;
    }

    public String getCnpjescritorio() {
        return cnpjescritorio;
    }

    public void setCnpjescritorio(String cnpjescritorio) {
        this.cnpjescritorio = cnpjescritorio;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Character getFlaginativa() {
        return flaginativa;
    }

    public void setFlaginativa(Character flaginativa) {
        this.flaginativa = flaginativa;
    }

    @XmlTransient
    public Collection<Pessoacategoria> getPessoacategoriaCollection() {
        return pessoacategoriaCollection;
    }

    public void setPessoacategoriaCollection(Collection<Pessoacategoria> pessoacategoriaCollection) {
        this.pessoacategoriaCollection = pessoacategoriaCollection;
    }

    public Uf getCoduf() {
        return coduf;
    }

    public void setCoduf(Uf coduf) {
        this.coduf = coduf;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codpessoa != null ? codpessoa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pessoa)) {
            return false;
        }
        Pessoa other = (Pessoa) object;
        if ((this.codpessoa == null && other.codpessoa != null) || (this.codpessoa != null && !this.codpessoa.equals(other.codpessoa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Pessoa[ codpessoa=" + codpessoa + " ]";
    }
    
}
