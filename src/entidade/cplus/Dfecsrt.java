/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

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
@Table(name = "DFECSRT", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dfecsrt.findAll", query = "SELECT d FROM Dfecsrt d")
    , @NamedQuery(name = "Dfecsrt.findByUf", query = "SELECT d FROM Dfecsrt d WHERE d.dfecsrtPK.uf = :uf")
    , @NamedQuery(name = "Dfecsrt.findByIdhash", query = "SELECT d FROM Dfecsrt d WHERE d.dfecsrtPK.idhash = :idhash")
    , @NamedQuery(name = "Dfecsrt.findByHash", query = "SELECT d FROM Dfecsrt d WHERE d.hash = :hash")
    , @NamedQuery(name = "Dfecsrt.findByModelodfe", query = "SELECT d FROM Dfecsrt d WHERE d.modelodfe = :modelodfe")
    , @NamedQuery(name = "Dfecsrt.findByInativo", query = "SELECT d FROM Dfecsrt d WHERE d.inativo = :inativo")})
public class Dfecsrt implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DfecsrtPK dfecsrtPK;
    @Basic(optional = false)
    @Column(name = "HASH")
    private String hash;
    @Basic(optional = false)
    @Column(name = "MODELODFE")
    private String modelodfe;
    @Basic(optional = false)
    @Column(name = "INATIVO")
    private Character inativo;

    public Dfecsrt() {
    }

    public Dfecsrt(DfecsrtPK dfecsrtPK) {
        this.dfecsrtPK = dfecsrtPK;
    }

    public Dfecsrt(DfecsrtPK dfecsrtPK, String hash, String modelodfe, Character inativo) {
        this.dfecsrtPK = dfecsrtPK;
        this.hash = hash;
        this.modelodfe = modelodfe;
        this.inativo = inativo;
    }

    public Dfecsrt(String uf, short idhash) {
        this.dfecsrtPK = new DfecsrtPK(uf, idhash);
    }

    public DfecsrtPK getDfecsrtPK() {
        return dfecsrtPK;
    }

    public void setDfecsrtPK(DfecsrtPK dfecsrtPK) {
        this.dfecsrtPK = dfecsrtPK;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getModelodfe() {
        return modelodfe;
    }

    public void setModelodfe(String modelodfe) {
        this.modelodfe = modelodfe;
    }

    public Character getInativo() {
        return inativo;
    }

    public void setInativo(Character inativo) {
        this.inativo = inativo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dfecsrtPK != null ? dfecsrtPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dfecsrt)) {
            return false;
        }
        Dfecsrt other = (Dfecsrt) object;
        if ((this.dfecsrtPK == null && other.dfecsrtPK != null) || (this.dfecsrtPK != null && !this.dfecsrtPK.equals(other.dfecsrtPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Dfecsrt[ dfecsrtPK=" + dfecsrtPK + " ]";
    }
    
}
