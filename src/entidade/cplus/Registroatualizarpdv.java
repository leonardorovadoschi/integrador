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
@Table(name = "REGISTROATUALIZARPDV", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Registroatualizarpdv.findAll", query = "SELECT r FROM Registroatualizarpdv r")
    , @NamedQuery(name = "Registroatualizarpdv.findByCodregistroatualizarpdv", query = "SELECT r FROM Registroatualizarpdv r WHERE r.codregistroatualizarpdv = :codregistroatualizarpdv")
    , @NamedQuery(name = "Registroatualizarpdv.findByNometabela", query = "SELECT r FROM Registroatualizarpdv r WHERE r.nometabela = :nometabela")
    , @NamedQuery(name = "Registroatualizarpdv.findByValorcampos", query = "SELECT r FROM Registroatualizarpdv r WHERE r.valorcampos = :valorcampos")
    , @NamedQuery(name = "Registroatualizarpdv.findByFlagexp", query = "SELECT r FROM Registroatualizarpdv r WHERE r.flagexp = :flagexp")})
public class Registroatualizarpdv implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODREGISTROATUALIZARPDV")
    private Integer codregistroatualizarpdv;
    @Basic(optional = false)
    @Column(name = "NOMETABELA")
    private String nometabela;
    @Basic(optional = false)
    @Column(name = "VALORCAMPOS")
    private String valorcampos;
    @Column(name = "FLAGEXP")
    private Character flagexp;

    public Registroatualizarpdv() {
    }

    public Registroatualizarpdv(Integer codregistroatualizarpdv) {
        this.codregistroatualizarpdv = codregistroatualizarpdv;
    }

    public Registroatualizarpdv(Integer codregistroatualizarpdv, String nometabela, String valorcampos) {
        this.codregistroatualizarpdv = codregistroatualizarpdv;
        this.nometabela = nometabela;
        this.valorcampos = valorcampos;
    }

    public Integer getCodregistroatualizarpdv() {
        return codregistroatualizarpdv;
    }

    public void setCodregistroatualizarpdv(Integer codregistroatualizarpdv) {
        this.codregistroatualizarpdv = codregistroatualizarpdv;
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
        hash += (codregistroatualizarpdv != null ? codregistroatualizarpdv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Registroatualizarpdv)) {
            return false;
        }
        Registroatualizarpdv other = (Registroatualizarpdv) object;
        if ((this.codregistroatualizarpdv == null && other.codregistroatualizarpdv != null) || (this.codregistroatualizarpdv != null && !this.codregistroatualizarpdv.equals(other.codregistroatualizarpdv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Registroatualizarpdv[ codregistroatualizarpdv=" + codregistroatualizarpdv + " ]";
    }
    
}
