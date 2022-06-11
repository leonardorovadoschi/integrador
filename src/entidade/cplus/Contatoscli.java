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
@Table(name = "CONTATOSCLI", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contatoscli.findAll", query = "SELECT c FROM Contatoscli c")
    , @NamedQuery(name = "Contatoscli.findByCodctc", query = "SELECT c FROM Contatoscli c WHERE c.codctc = :codctc")
    , @NamedQuery(name = "Contatoscli.findByNome", query = "SELECT c FROM Contatoscli c WHERE c.nome = :nome")
    , @NamedQuery(name = "Contatoscli.findByTelefone", query = "SELECT c FROM Contatoscli c WHERE c.telefone = :telefone")
    , @NamedQuery(name = "Contatoscli.findByEmail", query = "SELECT c FROM Contatoscli c WHERE c.email = :email")
    , @NamedQuery(name = "Contatoscli.findBySetor", query = "SELECT c FROM Contatoscli c WHERE c.setor = :setor")
    , @NamedQuery(name = "Contatoscli.findByCodtipocontato", query = "SELECT c FROM Contatoscli c WHERE c.codtipocontato = :codtipocontato")
    , @NamedQuery(name = "Contatoscli.findByGuid", query = "SELECT c FROM Contatoscli c WHERE c.guid = :guid")})
public class Contatoscli implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCTC")
    private String codctc;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "TELEFONE")
    private String telefone;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "SETOR")
    private String setor;
    @Column(name = "CODTIPOCONTATO")
    private String codtipocontato;
    @Column(name = "GUID")
    private String guid;
    @JoinColumn(name = "CODCLI", referencedColumnName = "CODCLI")
    @ManyToOne
    private Cliente codcli;

    public Contatoscli() {
    }

    public Contatoscli(String codctc) {
        this.codctc = codctc;
    }

    public String getCodctc() {
        return codctc;
    }

    public void setCodctc(String codctc) {
        this.codctc = codctc;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getCodtipocontato() {
        return codtipocontato;
    }

    public void setCodtipocontato(String codtipocontato) {
        this.codtipocontato = codtipocontato;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Cliente getCodcli() {
        return codcli;
    }

    public void setCodcli(Cliente codcli) {
        this.codcli = codcli;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codctc != null ? codctc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contatoscli)) {
            return false;
        }
        Contatoscli other = (Contatoscli) object;
        if ((this.codctc == null && other.codctc != null) || (this.codctc != null && !this.codctc.equals(other.codctc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Contatoscli[ codctc=" + codctc + " ]";
    }
    
}
