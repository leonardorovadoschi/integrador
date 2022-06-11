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
@Table(name = "WCPLUS_FORMAPAG", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WcplusFormapag.findAll", query = "SELECT w FROM WcplusFormapag w")
    , @NamedQuery(name = "WcplusFormapag.findByCodwcplus", query = "SELECT w FROM WcplusFormapag w WHERE w.wcplusFormapagPK.codwcplus = :codwcplus")
    , @NamedQuery(name = "WcplusFormapag.findByCodfp", query = "SELECT w FROM WcplusFormapag w WHERE w.codfp = :codfp")
    , @NamedQuery(name = "WcplusFormapag.findByChavepagamento", query = "SELECT w FROM WcplusFormapag w WHERE w.wcplusFormapagPK.chavepagamento = :chavepagamento")})
public class WcplusFormapag implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected WcplusFormapagPK wcplusFormapagPK;
    @Basic(optional = false)
    @Column(name = "CODFP")
    private String codfp;

    public WcplusFormapag() {
    }

    public WcplusFormapag(WcplusFormapagPK wcplusFormapagPK) {
        this.wcplusFormapagPK = wcplusFormapagPK;
    }

    public WcplusFormapag(WcplusFormapagPK wcplusFormapagPK, String codfp) {
        this.wcplusFormapagPK = wcplusFormapagPK;
        this.codfp = codfp;
    }

    public WcplusFormapag(int codwcplus, String chavepagamento) {
        this.wcplusFormapagPK = new WcplusFormapagPK(codwcplus, chavepagamento);
    }

    public WcplusFormapagPK getWcplusFormapagPK() {
        return wcplusFormapagPK;
    }

    public void setWcplusFormapagPK(WcplusFormapagPK wcplusFormapagPK) {
        this.wcplusFormapagPK = wcplusFormapagPK;
    }

    public String getCodfp() {
        return codfp;
    }

    public void setCodfp(String codfp) {
        this.codfp = codfp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (wcplusFormapagPK != null ? wcplusFormapagPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WcplusFormapag)) {
            return false;
        }
        WcplusFormapag other = (WcplusFormapag) object;
        if ((this.wcplusFormapagPK == null && other.wcplusFormapagPK != null) || (this.wcplusFormapagPK != null && !this.wcplusFormapagPK.equals(other.wcplusFormapagPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.WcplusFormapag[ wcplusFormapagPK=" + wcplusFormapagPK + " ]";
    }
    
}
