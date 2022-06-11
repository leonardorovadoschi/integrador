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
@Table(name = "REGISTROEXCLUIR", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Registroexcluir.findAll", query = "SELECT r FROM Registroexcluir r")
    , @NamedQuery(name = "Registroexcluir.findByCodregistroexcluir", query = "SELECT r FROM Registroexcluir r WHERE r.codregistroexcluir = :codregistroexcluir")
    , @NamedQuery(name = "Registroexcluir.findByNometabela", query = "SELECT r FROM Registroexcluir r WHERE r.nometabela = :nometabela")
    , @NamedQuery(name = "Registroexcluir.findByValorcampos", query = "SELECT r FROM Registroexcluir r WHERE r.valorcampos = :valorcampos")
    , @NamedQuery(name = "Registroexcluir.findByFlagexp", query = "SELECT r FROM Registroexcluir r WHERE r.flagexp = :flagexp")})
public class Registroexcluir implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODREGISTROEXCLUIR")
    private Integer codregistroexcluir;
    @Basic(optional = false)
    @Column(name = "NOMETABELA")
    private String nometabela;
    @Basic(optional = false)
    @Column(name = "VALORCAMPOS")
    private String valorcampos;
    @Column(name = "FLAGEXP")
    private Character flagexp;

    public Registroexcluir() {
    }

    public Registroexcluir(Integer codregistroexcluir) {
        this.codregistroexcluir = codregistroexcluir;
    }

    public Registroexcluir(Integer codregistroexcluir, String nometabela, String valorcampos) {
        this.codregistroexcluir = codregistroexcluir;
        this.nometabela = nometabela;
        this.valorcampos = valorcampos;
    }

    public Integer getCodregistroexcluir() {
        return codregistroexcluir;
    }

    public void setCodregistroexcluir(Integer codregistroexcluir) {
        this.codregistroexcluir = codregistroexcluir;
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
        hash += (codregistroexcluir != null ? codregistroexcluir.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Registroexcluir)) {
            return false;
        }
        Registroexcluir other = (Registroexcluir) object;
        if ((this.codregistroexcluir == null && other.codregistroexcluir != null) || (this.codregistroexcluir != null && !this.codregistroexcluir.equals(other.codregistroexcluir))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Registroexcluir[ codregistroexcluir=" + codregistroexcluir + " ]";
    }
    
}
