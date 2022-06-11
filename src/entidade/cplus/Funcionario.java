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
@Table(name = "FUNCIONARIO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f")
    , @NamedQuery(name = "Funcionario.findByCodfuncionario", query = "SELECT f FROM Funcionario f WHERE f.codfuncionario = :codfuncionario")
    , @NamedQuery(name = "Funcionario.findByCodigo", query = "SELECT f FROM Funcionario f WHERE f.codigo = :codigo")
    , @NamedQuery(name = "Funcionario.findByNomefuncionario", query = "SELECT f FROM Funcionario f WHERE f.nomefuncionario = :nomefuncionario")
    , @NamedQuery(name = "Funcionario.findByEndereco", query = "SELECT f FROM Funcionario f WHERE f.endereco = :endereco")
    , @NamedQuery(name = "Funcionario.findByBairro", query = "SELECT f FROM Funcionario f WHERE f.bairro = :bairro")
    , @NamedQuery(name = "Funcionario.findByCidade", query = "SELECT f FROM Funcionario f WHERE f.cidade = :cidade")
    , @NamedQuery(name = "Funcionario.findByEstado", query = "SELECT f FROM Funcionario f WHERE f.estado = :estado")
    , @NamedQuery(name = "Funcionario.findByCep", query = "SELECT f FROM Funcionario f WHERE f.cep = :cep")
    , @NamedQuery(name = "Funcionario.findByTelefone", query = "SELECT f FROM Funcionario f WHERE f.telefone = :telefone")
    , @NamedQuery(name = "Funcionario.findByIdentidade", query = "SELECT f FROM Funcionario f WHERE f.identidade = :identidade")
    , @NamedQuery(name = "Funcionario.findByCpf", query = "SELECT f FROM Funcionario f WHERE f.cpf = :cpf")
    , @NamedQuery(name = "Funcionario.findByNascimento", query = "SELECT f FROM Funcionario f WHERE f.nascimento = :nascimento")
    , @NamedQuery(name = "Funcionario.findByCargo", query = "SELECT f FROM Funcionario f WHERE f.cargo = :cargo")
    , @NamedQuery(name = "Funcionario.findBySalario", query = "SELECT f FROM Funcionario f WHERE f.salario = :salario")
    , @NamedQuery(name = "Funcionario.findByAdmissao", query = "SELECT f FROM Funcionario f WHERE f.admissao = :admissao")
    , @NamedQuery(name = "Funcionario.findByDiapg", query = "SELECT f FROM Funcionario f WHERE f.diapg = :diapg")
    , @NamedQuery(name = "Funcionario.findByInativo", query = "SELECT f FROM Funcionario f WHERE f.inativo = :inativo")
    , @NamedQuery(name = "Funcionario.findByCelular", query = "SELECT f FROM Funcionario f WHERE f.celular = :celular")
    , @NamedQuery(name = "Funcionario.findByEmail", query = "SELECT f FROM Funcionario f WHERE f.email = :email")
    , @NamedQuery(name = "Funcionario.findByFlaggestor", query = "SELECT f FROM Funcionario f WHERE f.flaggestor = :flaggestor")})
public class Funcionario implements Serializable {

    @Lob
    @Column(name = "FOTO")
    private byte[] foto;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODFUNCIONARIO")
    private String codfuncionario;
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "NOMEFUNCIONARIO")
    private String nomefuncionario;
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
    @Column(name = "IDENTIDADE")
    private String identidade;
    @Column(name = "CPF")
    private String cpf;
    @Column(name = "NASCIMENTO")
    @Temporal(TemporalType.DATE)
    private Date nascimento;
    @Column(name = "CARGO")
    private String cargo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SALARIO")
    private BigDecimal salario;
    @Column(name = "ADMISSAO")
    @Temporal(TemporalType.DATE)
    private Date admissao;
    @Column(name = "DIAPG")
    private Short diapg;
    @Lob
    @Column(name = "OBS")
    private String obs;
    @Column(name = "INATIVO")
    private Character inativo;
    @Column(name = "CELULAR")
    private String celular;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "FLAGGESTOR")
    private Character flaggestor;
    @OneToMany(mappedBy = "codfunc")
    private Collection<Cargo> cargoCollection;
    @JoinColumn(name = "CODCARGO", referencedColumnName = "CODCARGO")
    @ManyToOne
    private Cargo codcargo;
    @OneToMany(mappedBy = "codfunc")
    private Collection<Especializacao> especializacaoCollection;
    @OneToMany(mappedBy = "codfuncionario")
    private Collection<Usuario> usuarioCollection;
    @OneToMany(mappedBy = "codfunc")
    private Collection<Advertencia> advertenciaCollection;
    @OneToMany(mappedBy = "codfuncadvertencia")
    private Collection<Advertencia> advertenciaCollection1;
    @OneToMany(mappedBy = "codfuncionario")
    private Collection<Funcionariodesconto> funcionariodescontoCollection;
    @OneToMany(mappedBy = "codfunc")
    private Collection<Avaliacao> avaliacaoCollection;

    public Funcionario() {
    }

    public Funcionario(String codfuncionario) {
        this.codfuncionario = codfuncionario;
    }

    public Funcionario(String codfuncionario, String codigo) {
        this.codfuncionario = codfuncionario;
        this.codigo = codigo;
    }

    public String getCodfuncionario() {
        return codfuncionario;
    }

    public void setCodfuncionario(String codfuncionario) {
        this.codfuncionario = codfuncionario;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomefuncionario() {
        return nomefuncionario;
    }

    public void setNomefuncionario(String nomefuncionario) {
        this.nomefuncionario = nomefuncionario;
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

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public Date getAdmissao() {
        return admissao;
    }

    public void setAdmissao(Date admissao) {
        this.admissao = admissao;
    }

    public Short getDiapg() {
        return diapg;
    }

    public void setDiapg(Short diapg) {
        this.diapg = diapg;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Character getInativo() {
        return inativo;
    }

    public void setInativo(Character inativo) {
        this.inativo = inativo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Character getFlaggestor() {
        return flaggestor;
    }

    public void setFlaggestor(Character flaggestor) {
        this.flaggestor = flaggestor;
    }

    @XmlTransient
    public Collection<Cargo> getCargoCollection() {
        return cargoCollection;
    }

    public void setCargoCollection(Collection<Cargo> cargoCollection) {
        this.cargoCollection = cargoCollection;
    }

    public Cargo getCodcargo() {
        return codcargo;
    }

    public void setCodcargo(Cargo codcargo) {
        this.codcargo = codcargo;
    }

    @XmlTransient
    public Collection<Especializacao> getEspecializacaoCollection() {
        return especializacaoCollection;
    }

    public void setEspecializacaoCollection(Collection<Especializacao> especializacaoCollection) {
        this.especializacaoCollection = especializacaoCollection;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @XmlTransient
    public Collection<Advertencia> getAdvertenciaCollection() {
        return advertenciaCollection;
    }

    public void setAdvertenciaCollection(Collection<Advertencia> advertenciaCollection) {
        this.advertenciaCollection = advertenciaCollection;
    }

    @XmlTransient
    public Collection<Advertencia> getAdvertenciaCollection1() {
        return advertenciaCollection1;
    }

    public void setAdvertenciaCollection1(Collection<Advertencia> advertenciaCollection1) {
        this.advertenciaCollection1 = advertenciaCollection1;
    }

    @XmlTransient
    public Collection<Funcionariodesconto> getFuncionariodescontoCollection() {
        return funcionariodescontoCollection;
    }

    public void setFuncionariodescontoCollection(Collection<Funcionariodesconto> funcionariodescontoCollection) {
        this.funcionariodescontoCollection = funcionariodescontoCollection;
    }

    @XmlTransient
    public Collection<Avaliacao> getAvaliacaoCollection() {
        return avaliacaoCollection;
    }

    public void setAvaliacaoCollection(Collection<Avaliacao> avaliacaoCollection) {
        this.avaliacaoCollection = avaliacaoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codfuncionario != null ? codfuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.codfuncionario == null && other.codfuncionario != null) || (this.codfuncionario != null && !this.codfuncionario.equals(other.codfuncionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Funcionario[ codfuncionario=" + codfuncionario + " ]";
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
    
}
