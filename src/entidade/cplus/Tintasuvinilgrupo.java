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
@Table(name = "TINTASUVINILGRUPO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tintasuvinilgrupo.findAll", query = "SELECT t FROM Tintasuvinilgrupo t")
    , @NamedQuery(name = "Tintasuvinilgrupo.findByCodtintasuvinilgrupo", query = "SELECT t FROM Tintasuvinilgrupo t WHERE t.codtintasuvinilgrupo = :codtintasuvinilgrupo")
    , @NamedQuery(name = "Tintasuvinilgrupo.findByNomegrupo", query = "SELECT t FROM Tintasuvinilgrupo t WHERE t.nomegrupo = :nomegrupo")})
public class Tintasuvinilgrupo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODTINTASUVINILGRUPO")
    private Integer codtintasuvinilgrupo;
    @Column(name = "NOMEGRUPO")
    private String nomegrupo;

    public Tintasuvinilgrupo() {
    }

    public Tintasuvinilgrupo(Integer codtintasuvinilgrupo) {
        this.codtintasuvinilgrupo = codtintasuvinilgrupo;
    }

    public Integer getCodtintasuvinilgrupo() {
        return codtintasuvinilgrupo;
    }

    public void setCodtintasuvinilgrupo(Integer codtintasuvinilgrupo) {
        this.codtintasuvinilgrupo = codtintasuvinilgrupo;
    }

    public String getNomegrupo() {
        return nomegrupo;
    }

    public void setNomegrupo(String nomegrupo) {
        this.nomegrupo = nomegrupo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codtintasuvinilgrupo != null ? codtintasuvinilgrupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tintasuvinilgrupo)) {
            return false;
        }
        Tintasuvinilgrupo other = (Tintasuvinilgrupo) object;
        if ((this.codtintasuvinilgrupo == null && other.codtintasuvinilgrupo != null) || (this.codtintasuvinilgrupo != null && !this.codtintasuvinilgrupo.equals(other.codtintasuvinilgrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Tintasuvinilgrupo[ codtintasuvinilgrupo=" + codtintasuvinilgrupo + " ]";
    }
    
}
