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
@Table(name = "TIPOCODIGO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipocodigo.findAll", query = "SELECT t FROM Tipocodigo t")
    , @NamedQuery(name = "Tipocodigo.findByCodtipocodigo", query = "SELECT t FROM Tipocodigo t WHERE t.codtipocodigo = :codtipocodigo")
    , @NamedQuery(name = "Tipocodigo.findByNometipocodigo", query = "SELECT t FROM Tipocodigo t WHERE t.nometipocodigo = :nometipocodigo")
    , @NamedQuery(name = "Tipocodigo.findByCodigo", query = "SELECT t FROM Tipocodigo t WHERE t.codigo = :codigo")})
public class Tipocodigo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODTIPOCODIGO")
    private String codtipocodigo;
    @Column(name = "NOMETIPOCODIGO")
    private String nometipocodigo;
    @Column(name = "CODIGO")
    private String codigo;

    public Tipocodigo() {
    }

    public Tipocodigo(String codtipocodigo) {
        this.codtipocodigo = codtipocodigo;
    }

    public String getCodtipocodigo() {
        return codtipocodigo;
    }

    public void setCodtipocodigo(String codtipocodigo) {
        this.codtipocodigo = codtipocodigo;
    }

    public String getNometipocodigo() {
        return nometipocodigo;
    }

    public void setNometipocodigo(String nometipocodigo) {
        this.nometipocodigo = nometipocodigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codtipocodigo != null ? codtipocodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipocodigo)) {
            return false;
        }
        Tipocodigo other = (Tipocodigo) object;
        if ((this.codtipocodigo == null && other.codtipocodigo != null) || (this.codtipocodigo != null && !this.codtipocodigo.equals(other.codtipocodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Tipocodigo[ codtipocodigo=" + codtipocodigo + " ]";
    }
    
}
