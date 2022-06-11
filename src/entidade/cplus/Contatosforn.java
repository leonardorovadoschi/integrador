/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
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
@Table(name = "CONTATOSFORN", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contatosforn.findAll", query = "SELECT c FROM Contatosforn c")
    , @NamedQuery(name = "Contatosforn.findByCodcf", query = "SELECT c FROM Contatosforn c WHERE c.codcf = :codcf")
    , @NamedQuery(name = "Contatosforn.findByNome", query = "SELECT c FROM Contatosforn c WHERE c.nome = :nome")
    , @NamedQuery(name = "Contatosforn.findByTelefone", query = "SELECT c FROM Contatosforn c WHERE c.telefone = :telefone")
    , @NamedQuery(name = "Contatosforn.findBySetor", query = "SELECT c FROM Contatosforn c WHERE c.setor = :setor")
    , @NamedQuery(name = "Contatosforn.findByEmail", query = "SELECT c FROM Contatosforn c WHERE c.email = :email")})
public class Contatosforn implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCF")
    private String codcf;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "TELEFONE")
    private String telefone;
    @Column(name = "SETOR")
    private String setor;
    @Column(name = "EMAIL")
    private String email;
    @JoinColumn(name = "CODFORN", referencedColumnName = "CODFORN")
    @ManyToOne
    private Fornecedor codforn;

    public Contatosforn() {
    }

    public Contatosforn(String codcf) {
        this.codcf = codcf;
    }

    public String getCodcf() {
        return codcf;
    }

    public void setCodcf(String codcf) {
        this.codcf = codcf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Fornecedor getCodforn() {
        return codforn;
    }

    public void setCodforn(Fornecedor codforn) {
        this.codforn = codforn;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcf != null ? codcf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contatosforn)) {
            return false;
        }
        Contatosforn other = (Contatosforn) object;
        if ((this.codcf == null && other.codcf != null) || (this.codcf != null && !this.codcf.equals(other.codcf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Contatosforn[ codcf=" + codcf + " ]";
    }
    
}
