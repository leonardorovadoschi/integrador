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
@Table(name = "MAQUINATINTA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Maquinatinta.findAll", query = "SELECT m FROM Maquinatinta m")
    , @NamedQuery(name = "Maquinatinta.findByCodmaquinatinta", query = "SELECT m FROM Maquinatinta m WHERE m.codmaquinatinta = :codmaquinatinta")
    , @NamedQuery(name = "Maquinatinta.findByCodigo", query = "SELECT m FROM Maquinatinta m WHERE m.codigo = :codigo")
    , @NamedQuery(name = "Maquinatinta.findByNomemaquinatinta", query = "SELECT m FROM Maquinatinta m WHERE m.nomemaquinatinta = :nomemaquinatinta")
    , @NamedQuery(name = "Maquinatinta.findByCodprod", query = "SELECT m FROM Maquinatinta m WHERE m.codprod = :codprod")})
public class Maquinatinta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODMAQUINATINTA")
    private String codmaquinatinta;
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "NOMEMAQUINATINTA")
    private String nomemaquinatinta;
    @Column(name = "CODPROD")
    private String codprod;

    public Maquinatinta() {
    }

    public Maquinatinta(String codmaquinatinta) {
        this.codmaquinatinta = codmaquinatinta;
    }

    public String getCodmaquinatinta() {
        return codmaquinatinta;
    }

    public void setCodmaquinatinta(String codmaquinatinta) {
        this.codmaquinatinta = codmaquinatinta;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomemaquinatinta() {
        return nomemaquinatinta;
    }

    public void setNomemaquinatinta(String nomemaquinatinta) {
        this.nomemaquinatinta = nomemaquinatinta;
    }

    public String getCodprod() {
        return codprod;
    }

    public void setCodprod(String codprod) {
        this.codprod = codprod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codmaquinatinta != null ? codmaquinatinta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Maquinatinta)) {
            return false;
        }
        Maquinatinta other = (Maquinatinta) object;
        if ((this.codmaquinatinta == null && other.codmaquinatinta != null) || (this.codmaquinatinta != null && !this.codmaquinatinta.equals(other.codmaquinatinta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Maquinatinta[ codmaquinatinta=" + codmaquinatinta + " ]";
    }
    
}
