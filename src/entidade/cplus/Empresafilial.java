/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "EMPRESAFILIAL", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresafilial.findAll", query = "SELECT e FROM Empresafilial e")
    , @NamedQuery(name = "Empresafilial.findByCodempresamatriz", query = "SELECT e FROM Empresafilial e WHERE e.empresafilialPK.codempresamatriz = :codempresamatriz")
    , @NamedQuery(name = "Empresafilial.findByCodempresafilial", query = "SELECT e FROM Empresafilial e WHERE e.empresafilialPK.codempresafilial = :codempresafilial")})
public class Empresafilial implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EmpresafilialPK empresafilialPK;

    public Empresafilial() {
    }

    public Empresafilial(EmpresafilialPK empresafilialPK) {
        this.empresafilialPK = empresafilialPK;
    }

    public Empresafilial(int codempresamatriz, int codempresafilial) {
        this.empresafilialPK = new EmpresafilialPK(codempresamatriz, codempresafilial);
    }

    public EmpresafilialPK getEmpresafilialPK() {
        return empresafilialPK;
    }

    public void setEmpresafilialPK(EmpresafilialPK empresafilialPK) {
        this.empresafilialPK = empresafilialPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empresafilialPK != null ? empresafilialPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresafilial)) {
            return false;
        }
        Empresafilial other = (Empresafilial) object;
        if ((this.empresafilialPK == null && other.empresafilialPK != null) || (this.empresafilialPK != null && !this.empresafilialPK.equals(other.empresafilialPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Empresafilial[ empresafilialPK=" + empresafilialPK + " ]";
    }
    
}
