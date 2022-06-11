/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.prestaShop;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ps_layered_filter_block")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsLayeredFilterBlock.findAll", query = "SELECT p FROM PsLayeredFilterBlock p")
    , @NamedQuery(name = "PsLayeredFilterBlock.findByHash", query = "SELECT p FROM PsLayeredFilterBlock p WHERE p.hash = :hash")})
public class PsLayeredFilterBlock implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "hash")
    private String hash;
    @Lob
    @Column(name = "data")
    private String data;

    public PsLayeredFilterBlock() {
    }

    public PsLayeredFilterBlock(String hash) {
        this.hash = hash;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsLayeredFilterBlock)) {
            return false;
        }
        PsLayeredFilterBlock other = (PsLayeredFilterBlock) object;
        if ((this.hash == null && other.hash != null) || (this.hash != null && !this.hash.equals(other.hash))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsLayeredFilterBlock[ hash=" + hash + " ]";
    }
    
}
