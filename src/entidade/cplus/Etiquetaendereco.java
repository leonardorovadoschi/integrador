/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ETIQUETAENDERECO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Etiquetaendereco.findAll", query = "SELECT e FROM Etiquetaendereco e")
    , @NamedQuery(name = "Etiquetaendereco.findById", query = "SELECT e FROM Etiquetaendereco e WHERE e.id = :id")
    , @NamedQuery(name = "Etiquetaendereco.findByNomecli", query = "SELECT e FROM Etiquetaendereco e WHERE e.nomecli = :nomecli")
    , @NamedQuery(name = "Etiquetaendereco.findByEndereco", query = "SELECT e FROM Etiquetaendereco e WHERE e.endereco = :endereco")
    , @NamedQuery(name = "Etiquetaendereco.findByBairro", query = "SELECT e FROM Etiquetaendereco e WHERE e.bairro = :bairro")
    , @NamedQuery(name = "Etiquetaendereco.findByCidade", query = "SELECT e FROM Etiquetaendereco e WHERE e.cidade = :cidade")
    , @NamedQuery(name = "Etiquetaendereco.findByEstado", query = "SELECT e FROM Etiquetaendereco e WHERE e.estado = :estado")
    , @NamedQuery(name = "Etiquetaendereco.findByCep", query = "SELECT e FROM Etiquetaendereco e WHERE e.cep = :cep")
    , @NamedQuery(name = "Etiquetaendereco.findByNumero", query = "SELECT e FROM Etiquetaendereco e WHERE e.numero = :numero")
    , @NamedQuery(name = "Etiquetaendereco.findByComplemento", query = "SELECT e FROM Etiquetaendereco e WHERE e.complemento = :complemento")
    , @NamedQuery(name = "Etiquetaendereco.findByQuantidade", query = "SELECT e FROM Etiquetaendereco e WHERE e.quantidade = :quantidade")
    , @NamedQuery(name = "Etiquetaendereco.findByCodetiquetaendereco", query = "SELECT e FROM Etiquetaendereco e WHERE e.codetiquetaendereco = :codetiquetaendereco")})
public class Etiquetaendereco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Column(name = "NOMECLI")
    private String nomecli;
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
    @Column(name = "NUMERO")
    private String numero;
    @Column(name = "COMPLEMENTO")
    private String complemento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "QUANTIDADE")
    private BigDecimal quantidade;
    @Id
    @Basic(optional = false)
    @Column(name = "CODETIQUETAENDERECO")
    private String codetiquetaendereco;
    @JoinColumn(name = "CODUSER", referencedColumnName = "CODUSER")
    @ManyToOne(optional = false)
    private Usuario coduser;

    public Etiquetaendereco() {
    }

    public Etiquetaendereco(String codetiquetaendereco) {
        this.codetiquetaendereco = codetiquetaendereco;
    }

    public Etiquetaendereco(String codetiquetaendereco, String id) {
        this.codetiquetaendereco = codetiquetaendereco;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomecli() {
        return nomecli;
    }

    public void setNomecli(String nomecli) {
        this.nomecli = nomecli;
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

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public String getCodetiquetaendereco() {
        return codetiquetaendereco;
    }

    public void setCodetiquetaendereco(String codetiquetaendereco) {
        this.codetiquetaendereco = codetiquetaendereco;
    }

    public Usuario getCoduser() {
        return coduser;
    }

    public void setCoduser(Usuario coduser) {
        this.coduser = coduser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codetiquetaendereco != null ? codetiquetaendereco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Etiquetaendereco)) {
            return false;
        }
        Etiquetaendereco other = (Etiquetaendereco) object;
        if ((this.codetiquetaendereco == null && other.codetiquetaendereco != null) || (this.codetiquetaendereco != null && !this.codetiquetaendereco.equals(other.codetiquetaendereco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Etiquetaendereco[ codetiquetaendereco=" + codetiquetaendereco + " ]";
    }
    
}
