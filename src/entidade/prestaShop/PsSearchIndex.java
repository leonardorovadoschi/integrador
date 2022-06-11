/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.prestaShop;

import java.io.Serializable;
import javax.persistence.Basic;
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
@Table(name = "ps_search_index")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsSearchIndex.findAll", query = "SELECT p FROM PsSearchIndex p")
    , @NamedQuery(name = "PsSearchIndex.findByIdProduct", query = "SELECT p FROM PsSearchIndex p WHERE p.psSearchIndexPK.idProduct = :idProduct")
    , @NamedQuery(name = "PsSearchIndex.findByIdWord", query = "SELECT p FROM PsSearchIndex p WHERE p.psSearchIndexPK.idWord = :idWord")
    , @NamedQuery(name = "PsSearchIndex.findByWeight", query = "SELECT p FROM PsSearchIndex p WHERE p.weight = :weight")})
public class PsSearchIndex implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsSearchIndexPK psSearchIndexPK;
    @Basic(optional = false)
    @Column(name = "weight")
    private short weight;

    public PsSearchIndex() {
    }

    public PsSearchIndex(PsSearchIndexPK psSearchIndexPK) {
        this.psSearchIndexPK = psSearchIndexPK;
    }

    public PsSearchIndex(PsSearchIndexPK psSearchIndexPK, short weight) {
        this.psSearchIndexPK = psSearchIndexPK;
        this.weight = weight;
    }

    public PsSearchIndex(int idProduct, int idWord) {
        this.psSearchIndexPK = new PsSearchIndexPK(idProduct, idWord);
    }

    public PsSearchIndexPK getPsSearchIndexPK() {
        return psSearchIndexPK;
    }

    public void setPsSearchIndexPK(PsSearchIndexPK psSearchIndexPK) {
        this.psSearchIndexPK = psSearchIndexPK;
    }

    public short getWeight() {
        return weight;
    }

    public void setWeight(short weight) {
        this.weight = weight;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psSearchIndexPK != null ? psSearchIndexPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsSearchIndex)) {
            return false;
        }
        PsSearchIndex other = (PsSearchIndex) object;
        if ((this.psSearchIndexPK == null && other.psSearchIndexPK != null) || (this.psSearchIndexPK != null && !this.psSearchIndexPK.equals(other.psSearchIndexPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsSearchIndex[ psSearchIndexPK=" + psSearchIndexPK + " ]";
    }
    
}
