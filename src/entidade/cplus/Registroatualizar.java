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
@Table(name = "REGISTROATUALIZAR", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Registroatualizar.findAll", query = "SELECT r FROM Registroatualizar r")
    , @NamedQuery(name = "Registroatualizar.findByCodregistroatualizar", query = "SELECT r FROM Registroatualizar r WHERE r.codregistroatualizar = :codregistroatualizar")
    , @NamedQuery(name = "Registroatualizar.findByNometabela", query = "SELECT r FROM Registroatualizar r WHERE r.nometabela = :nometabela")
    , @NamedQuery(name = "Registroatualizar.findByValorcampos", query = "SELECT r FROM Registroatualizar r WHERE r.valorcampos = :valorcampos")
    , @NamedQuery(name = "Registroatualizar.findByFlagexp", query = "SELECT r FROM Registroatualizar r WHERE r.flagexp = :flagexp")})
public class Registroatualizar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODREGISTROATUALIZAR")
    private Integer codregistroatualizar;
    @Basic(optional = false)
    @Column(name = "NOMETABELA")
    private String nometabela;
    @Basic(optional = false)
    @Column(name = "VALORCAMPOS")
    private String valorcampos;
    @Column(name = "FLAGEXP")
    private Character flagexp;

    public Registroatualizar() {
    }

    public Registroatualizar(Integer codregistroatualizar) {
        this.codregistroatualizar = codregistroatualizar;
    }

    public Registroatualizar(Integer codregistroatualizar, String nometabela, String valorcampos) {
        this.codregistroatualizar = codregistroatualizar;
        this.nometabela = nometabela;
        this.valorcampos = valorcampos;
    }

    public Integer getCodregistroatualizar() {
        return codregistroatualizar;
    }

    public void setCodregistroatualizar(Integer codregistroatualizar) {
        this.codregistroatualizar = codregistroatualizar;
    }

    public String getNometabela() {
        return nometabela;
    }

    public void setNometabela(String nometabela) {
        this.nometabela = nometabela;
    }

    public String getValorcampos() {
        return valorcampos;
    }

    public void setValorcampos(String valorcampos) {
        this.valorcampos = valorcampos;
    }

    public Character getFlagexp() {
        return flagexp;
    }

    public void setFlagexp(Character flagexp) {
        this.flagexp = flagexp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codregistroatualizar != null ? codregistroatualizar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Registroatualizar)) {
            return false;
        }
        Registroatualizar other = (Registroatualizar) object;
        if ((this.codregistroatualizar == null && other.codregistroatualizar != null) || (this.codregistroatualizar != null && !this.codregistroatualizar.equals(other.codregistroatualizar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Registroatualizar[ codregistroatualizar=" + codregistroatualizar + " ]";
    }
    
}
