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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "CONTACORRENTE", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contacorrente.findAll", query = "SELECT c FROM Contacorrente c")
    , @NamedQuery(name = "Contacorrente.findByCodcontacorrente", query = "SELECT c FROM Contacorrente c WHERE c.codcontacorrente = :codcontacorrente")
    , @NamedQuery(name = "Contacorrente.findByCodigo", query = "SELECT c FROM Contacorrente c WHERE c.codigo = :codigo")
    , @NamedQuery(name = "Contacorrente.findByNome", query = "SELECT c FROM Contacorrente c WHERE c.nome = :nome")
    , @NamedQuery(name = "Contacorrente.findByEmitente", query = "SELECT c FROM Contacorrente c WHERE c.emitente = :emitente")
    , @NamedQuery(name = "Contacorrente.findByBanco", query = "SELECT c FROM Contacorrente c WHERE c.banco = :banco")
    , @NamedQuery(name = "Contacorrente.findByAgencia", query = "SELECT c FROM Contacorrente c WHERE c.agencia = :agencia")})
public class Contacorrente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCONTACORRENTE")
    private String codcontacorrente;
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private String codigo;
    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;
    @Column(name = "EMITENTE")
    private String emitente;
    @Column(name = "BANCO")
    private String banco;
    @Column(name = "AGENCIA")
    private String agencia;

    public Contacorrente() {
    }

    public Contacorrente(String codcontacorrente) {
        this.codcontacorrente = codcontacorrente;
    }

    public Contacorrente(String codcontacorrente, String codigo, String nome) {
        this.codcontacorrente = codcontacorrente;
        this.codigo = codigo;
        this.nome = nome;
    }

    public String getCodcontacorrente() {
        return codcontacorrente;
    }

    public void setCodcontacorrente(String codcontacorrente) {
        this.codcontacorrente = codcontacorrente;
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

    public String getEmitente() {
        return emitente;
    }

    public void setEmitente(String emitente) {
        this.emitente = emitente;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcontacorrente != null ? codcontacorrente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contacorrente)) {
            return false;
        }
        Contacorrente other = (Contacorrente) object;
        if ((this.codcontacorrente == null && other.codcontacorrente != null) || (this.codcontacorrente != null && !this.codcontacorrente.equals(other.codcontacorrente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Contacorrente[ codcontacorrente=" + codcontacorrente + " ]";
    }
    
}
