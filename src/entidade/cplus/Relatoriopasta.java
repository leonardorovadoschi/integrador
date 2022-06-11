/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import javax.persistence.Column;
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
@Table(name = "RELATORIOPASTA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Relatoriopasta.findAll", query = "SELECT r FROM Relatoriopasta r")
    , @NamedQuery(name = "Relatoriopasta.findByCodrelatoriopasta", query = "SELECT r FROM Relatoriopasta r WHERE r.codrelatoriopasta = :codrelatoriopasta")
    , @NamedQuery(name = "Relatoriopasta.findByNomepasta", query = "SELECT r FROM Relatoriopasta r WHERE r.relatoriopastaPK.nomepasta = :nomepasta")
    , @NamedQuery(name = "Relatoriopasta.findByCodrelatoriopastapai", query = "SELECT r FROM Relatoriopasta r WHERE r.relatoriopastaPK.codrelatoriopastapai = :codrelatoriopastapai")})
public class Relatoriopasta implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RelatoriopastaPK relatoriopastaPK;
    @Column(name = "CODRELATORIOPASTA")
    private Integer codrelatoriopasta;

    public Relatoriopasta() {
    }

    public Relatoriopasta(RelatoriopastaPK relatoriopastaPK) {
        this.relatoriopastaPK = relatoriopastaPK;
    }

    public Relatoriopasta(String nomepasta, int codrelatoriopastapai) {
        this.relatoriopastaPK = new RelatoriopastaPK(nomepasta, codrelatoriopastapai);
    }

    public RelatoriopastaPK getRelatoriopastaPK() {
        return relatoriopastaPK;
    }

    public void setRelatoriopastaPK(RelatoriopastaPK relatoriopastaPK) {
        this.relatoriopastaPK = relatoriopastaPK;
    }

    public Integer getCodrelatoriopasta() {
        return codrelatoriopasta;
    }

    public void setCodrelatoriopasta(Integer codrelatoriopasta) {
        this.codrelatoriopasta = codrelatoriopasta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (relatoriopastaPK != null ? relatoriopastaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Relatoriopasta)) {
            return false;
        }
        Relatoriopasta other = (Relatoriopasta) object;
        if ((this.relatoriopastaPK == null && other.relatoriopastaPK != null) || (this.relatoriopastaPK != null && !this.relatoriopastaPK.equals(other.relatoriopastaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Relatoriopasta[ relatoriopastaPK=" + relatoriopastaPK + " ]";
    }
    
}
