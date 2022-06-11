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
@Table(name = "EMPRESACLASSIFICACAOFISCAL", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresaclassificacaofiscal.findAll", query = "SELECT e FROM Empresaclassificacaofiscal e")
    , @NamedQuery(name = "Empresaclassificacaofiscal.findByCodempresaclassificacaofiscal", query = "SELECT e FROM Empresaclassificacaofiscal e WHERE e.codempresaclassificacaofiscal = :codempresaclassificacaofiscal")
    , @NamedQuery(name = "Empresaclassificacaofiscal.findByCodempresa", query = "SELECT e FROM Empresaclassificacaofiscal e WHERE e.codempresa = :codempresa")
    , @NamedQuery(name = "Empresaclassificacaofiscal.findByCodclassificacaofiscal", query = "SELECT e FROM Empresaclassificacaofiscal e WHERE e.codclassificacaofiscal = :codclassificacaofiscal")})
public class Empresaclassificacaofiscal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODEMPRESACLASSIFICACAOFISCAL")
    private String codempresaclassificacaofiscal;
    @Column(name = "CODEMPRESA")
    private Integer codempresa;
    @Column(name = "CODCLASSIFICACAOFISCAL")
    private String codclassificacaofiscal;

    public Empresaclassificacaofiscal() {
    }

    public Empresaclassificacaofiscal(String codempresaclassificacaofiscal) {
        this.codempresaclassificacaofiscal = codempresaclassificacaofiscal;
    }

    public String getCodempresaclassificacaofiscal() {
        return codempresaclassificacaofiscal;
    }

    public void setCodempresaclassificacaofiscal(String codempresaclassificacaofiscal) {
        this.codempresaclassificacaofiscal = codempresaclassificacaofiscal;
    }

    public Integer getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Integer codempresa) {
        this.codempresa = codempresa;
    }

    public String getCodclassificacaofiscal() {
        return codclassificacaofiscal;
    }

    public void setCodclassificacaofiscal(String codclassificacaofiscal) {
        this.codclassificacaofiscal = codclassificacaofiscal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codempresaclassificacaofiscal != null ? codempresaclassificacaofiscal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresaclassificacaofiscal)) {
            return false;
        }
        Empresaclassificacaofiscal other = (Empresaclassificacaofiscal) object;
        if ((this.codempresaclassificacaofiscal == null && other.codempresaclassificacaofiscal != null) || (this.codempresaclassificacaofiscal != null && !this.codempresaclassificacaofiscal.equals(other.codempresaclassificacaofiscal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Empresaclassificacaofiscal[ codempresaclassificacaofiscal=" + codempresaclassificacaofiscal + " ]";
    }
    
}
