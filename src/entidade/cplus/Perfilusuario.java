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
@Table(name = "PERFILUSUARIO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Perfilusuario.findAll", query = "SELECT p FROM Perfilusuario p")
    , @NamedQuery(name = "Perfilusuario.findByCodperfilusuario", query = "SELECT p FROM Perfilusuario p WHERE p.codperfilusuario = :codperfilusuario")
    , @NamedQuery(name = "Perfilusuario.findByCodigo", query = "SELECT p FROM Perfilusuario p WHERE p.codigo = :codigo")
    , @NamedQuery(name = "Perfilusuario.findByNomeperfilusuario", query = "SELECT p FROM Perfilusuario p WHERE p.nomeperfilusuario = :nomeperfilusuario")
    , @NamedQuery(name = "Perfilusuario.findByGuid", query = "SELECT p FROM Perfilusuario p WHERE p.guid = :guid")})
public class Perfilusuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODPERFILUSUARIO")
    private String codperfilusuario;
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "NOMEPERFILUSUARIO")
    private String nomeperfilusuario;
    @Column(name = "GUID")
    private String guid;

    public Perfilusuario() {
    }

    public Perfilusuario(String codperfilusuario) {
        this.codperfilusuario = codperfilusuario;
    }

    public Perfilusuario(String codperfilusuario, String codigo) {
        this.codperfilusuario = codperfilusuario;
        this.codigo = codigo;
    }

    public String getCodperfilusuario() {
        return codperfilusuario;
    }

    public void setCodperfilusuario(String codperfilusuario) {
        this.codperfilusuario = codperfilusuario;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomeperfilusuario() {
        return nomeperfilusuario;
    }

    public void setNomeperfilusuario(String nomeperfilusuario) {
        this.nomeperfilusuario = nomeperfilusuario;
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
        hash += (codperfilusuario != null ? codperfilusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perfilusuario)) {
            return false;
        }
        Perfilusuario other = (Perfilusuario) object;
        if ((this.codperfilusuario == null && other.codperfilusuario != null) || (this.codperfilusuario != null && !this.codperfilusuario.equals(other.codperfilusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Perfilusuario[ codperfilusuario=" + codperfilusuario + " ]";
    }
    
}
