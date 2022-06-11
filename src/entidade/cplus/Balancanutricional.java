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
@Table(name = "BALANCANUTRICIONAL", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Balancanutricional.findAll", query = "SELECT b FROM Balancanutricional b")
    , @NamedQuery(name = "Balancanutricional.findByCodbalancanutricional", query = "SELECT b FROM Balancanutricional b WHERE b.codbalancanutricional = :codbalancanutricional")
    , @NamedQuery(name = "Balancanutricional.findByCodigo", query = "SELECT b FROM Balancanutricional b WHERE b.codigo = :codigo")
    , @NamedQuery(name = "Balancanutricional.findByNomebalancanutricional", query = "SELECT b FROM Balancanutricional b WHERE b.nomebalancanutricional = :nomebalancanutricional")
    , @NamedQuery(name = "Balancanutricional.findByFlagmarca", query = "SELECT b FROM Balancanutricional b WHERE b.flagmarca = :flagmarca")})
public class Balancanutricional implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODBALANCANUTRICIONAL")
    private String codbalancanutricional;
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "NOMEBALANCANUTRICIONAL")
    private String nomebalancanutricional;
    @Basic(optional = false)
    @Column(name = "FLAGMARCA")
    private Character flagmarca;

    public Balancanutricional() {
    }

    public Balancanutricional(String codbalancanutricional) {
        this.codbalancanutricional = codbalancanutricional;
    }

    public Balancanutricional(String codbalancanutricional, Character flagmarca) {
        this.codbalancanutricional = codbalancanutricional;
        this.flagmarca = flagmarca;
    }

    public String getCodbalancanutricional() {
        return codbalancanutricional;
    }

    public void setCodbalancanutricional(String codbalancanutricional) {
        this.codbalancanutricional = codbalancanutricional;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomebalancanutricional() {
        return nomebalancanutricional;
    }

    public void setNomebalancanutricional(String nomebalancanutricional) {
        this.nomebalancanutricional = nomebalancanutricional;
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
        hash += (codbalancanutricional != null ? codbalancanutricional.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Balancanutricional)) {
            return false;
        }
        Balancanutricional other = (Balancanutricional) object;
        if ((this.codbalancanutricional == null && other.codbalancanutricional != null) || (this.codbalancanutricional != null && !this.codbalancanutricional.equals(other.codbalancanutricional))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Balancanutricional[ codbalancanutricional=" + codbalancanutricional + " ]";
    }
    
}
