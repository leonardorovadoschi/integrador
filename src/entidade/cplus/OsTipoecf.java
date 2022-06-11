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
@Table(name = "OS_TIPOECF", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OsTipoecf.findAll", query = "SELECT o FROM OsTipoecf o")
    , @NamedQuery(name = "OsTipoecf.findByCodtipoecf", query = "SELECT o FROM OsTipoecf o WHERE o.codtipoecf = :codtipoecf")
    , @NamedQuery(name = "OsTipoecf.findByCodigo", query = "SELECT o FROM OsTipoecf o WHERE o.codigo = :codigo")
    , @NamedQuery(name = "OsTipoecf.findByNometipoecf", query = "SELECT o FROM OsTipoecf o WHERE o.nometipoecf = :nometipoecf")})
public class OsTipoecf implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODTIPOECF")
    private String codtipoecf;
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "NOMETIPOECF")
    private String nometipoecf;

    public OsTipoecf() {
    }

    public OsTipoecf(String codtipoecf) {
        this.codtipoecf = codtipoecf;
    }

    public String getCodtipoecf() {
        return codtipoecf;
    }

    public void setCodtipoecf(String codtipoecf) {
        this.codtipoecf = codtipoecf;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNometipoecf() {
        return nometipoecf;
    }

    public void setNometipoecf(String nometipoecf) {
        this.nometipoecf = nometipoecf;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codtipoecf != null ? codtipoecf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OsTipoecf)) {
            return false;
        }
        OsTipoecf other = (OsTipoecf) object;
        if ((this.codtipoecf == null && other.codtipoecf != null) || (this.codtipoecf != null && !this.codtipoecf.equals(other.codtipoecf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.OsTipoecf[ codtipoecf=" + codtipoecf + " ]";
    }
    
}
