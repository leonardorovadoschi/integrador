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
@Table(name = "TIPOCONTATO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipocontato.findAll", query = "SELECT t FROM Tipocontato t")
    , @NamedQuery(name = "Tipocontato.findByCodtipocontato", query = "SELECT t FROM Tipocontato t WHERE t.codtipocontato = :codtipocontato")
    , @NamedQuery(name = "Tipocontato.findByCodigo", query = "SELECT t FROM Tipocontato t WHERE t.codigo = :codigo")
    , @NamedQuery(name = "Tipocontato.findByNometipocontato", query = "SELECT t FROM Tipocontato t WHERE t.nometipocontato = :nometipocontato")
    , @NamedQuery(name = "Tipocontato.findByOrdem", query = "SELECT t FROM Tipocontato t WHERE t.ordem = :ordem")
    , @NamedQuery(name = "Tipocontato.findByGuid", query = "SELECT t FROM Tipocontato t WHERE t.guid = :guid")})
public class Tipocontato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODTIPOCONTATO")
    private String codtipocontato;
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "NOMETIPOCONTATO")
    private String nometipocontato;
    @Column(name = "ORDEM")
    private String ordem;
    @Column(name = "GUID")
    private String guid;

    public Tipocontato() {
    }

    public Tipocontato(String codtipocontato) {
        this.codtipocontato = codtipocontato;
    }

    public Tipocontato(String codtipocontato, String codigo) {
        this.codtipocontato = codtipocontato;
        this.codigo = codigo;
    }

    public String getCodtipocontato() {
        return codtipocontato;
    }

    public void setCodtipocontato(String codtipocontato) {
        this.codtipocontato = codtipocontato;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNometipocontato() {
        return nometipocontato;
    }

    public void setNometipocontato(String nometipocontato) {
        this.nometipocontato = nometipocontato;
    }

    public String getOrdem() {
        return ordem;
    }

    public void setOrdem(String ordem) {
        this.ordem = ordem;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codtipocontato != null ? codtipocontato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipocontato)) {
            return false;
        }
        Tipocontato other = (Tipocontato) object;
        if ((this.codtipocontato == null && other.codtipocontato != null) || (this.codtipocontato != null && !this.codtipocontato.equals(other.codtipocontato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Tipocontato[ codtipocontato=" + codtipocontato + " ]";
    }
    
}
