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
@Table(name = "BALANCAINFOEXTRA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Balancainfoextra.findAll", query = "SELECT b FROM Balancainfoextra b")
    , @NamedQuery(name = "Balancainfoextra.findByCodbalancainfoextra", query = "SELECT b FROM Balancainfoextra b WHERE b.codbalancainfoextra = :codbalancainfoextra")
    , @NamedQuery(name = "Balancainfoextra.findByCodigo", query = "SELECT b FROM Balancainfoextra b WHERE b.codigo = :codigo")
    , @NamedQuery(name = "Balancainfoextra.findByNomebalancainfoextra", query = "SELECT b FROM Balancainfoextra b WHERE b.nomebalancainfoextra = :nomebalancainfoextra")
    , @NamedQuery(name = "Balancainfoextra.findByFlagmarca", query = "SELECT b FROM Balancainfoextra b WHERE b.flagmarca = :flagmarca")})
public class Balancainfoextra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODBALANCAINFOEXTRA")
    private String codbalancainfoextra;
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "NOMEBALANCAINFOEXTRA")
    private String nomebalancainfoextra;
    @Basic(optional = false)
    @Column(name = "FLAGMARCA")
    private Character flagmarca;

    public Balancainfoextra() {
    }

    public Balancainfoextra(String codbalancainfoextra) {
        this.codbalancainfoextra = codbalancainfoextra;
    }

    public Balancainfoextra(String codbalancainfoextra, Character flagmarca) {
        this.codbalancainfoextra = codbalancainfoextra;
        this.flagmarca = flagmarca;
    }

    public String getCodbalancainfoextra() {
        return codbalancainfoextra;
    }

    public void setCodbalancainfoextra(String codbalancainfoextra) {
        this.codbalancainfoextra = codbalancainfoextra;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomebalancainfoextra() {
        return nomebalancainfoextra;
    }

    public void setNomebalancainfoextra(String nomebalancainfoextra) {
        this.nomebalancainfoextra = nomebalancainfoextra;
    }

    public Character getFlagmarca() {
        return flagmarca;
    }

    public void setFlagmarca(Character flagmarca) {
        this.flagmarca = flagmarca;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codbalancainfoextra != null ? codbalancainfoextra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Balancainfoextra)) {
            return false;
        }
        Balancainfoextra other = (Balancainfoextra) object;
        if ((this.codbalancainfoextra == null && other.codbalancainfoextra != null) || (this.codbalancainfoextra != null && !this.codbalancainfoextra.equals(other.codbalancainfoextra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Balancainfoextra[ codbalancainfoextra=" + codbalancainfoextra + " ]";
    }
    
}
