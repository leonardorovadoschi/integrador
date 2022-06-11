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
@Table(name = "OS_LOCALEQUIPAMENTO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OsLocalequipamento.findAll", query = "SELECT o FROM OsLocalequipamento o")
    , @NamedQuery(name = "OsLocalequipamento.findByCodle", query = "SELECT o FROM OsLocalequipamento o WHERE o.codle = :codle")
    , @NamedQuery(name = "OsLocalequipamento.findByLocal", query = "SELECT o FROM OsLocalequipamento o WHERE o.local = :local")
    , @NamedQuery(name = "OsLocalequipamento.findByCodigo", query = "SELECT o FROM OsLocalequipamento o WHERE o.codigo = :codigo")})
public class OsLocalequipamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODLE")
    private String codle;
    @Column(name = "LOCAL")
    private String local;
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private String codigo;

    public OsLocalequipamento() {
    }

    public OsLocalequipamento(String codle) {
        this.codle = codle;
    }

    public OsLocalequipamento(String codle, String codigo) {
        this.codle = codle;
        this.codigo = codigo;
    }

    public String getCodle() {
        return codle;
    }

    public void setCodle(String codle) {
        this.codle = codle;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
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
        hash += (codle != null ? codle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OsLocalequipamento)) {
            return false;
        }
        OsLocalequipamento other = (OsLocalequipamento) object;
        if ((this.codle == null && other.codle != null) || (this.codle != null && !this.codle.equals(other.codle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.OsLocalequipamento[ codle=" + codle + " ]";
    }
    
}
