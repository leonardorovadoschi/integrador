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
@Table(name = "TMP_SAIDARMA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TmpSaidarma.findAll", query = "SELECT t FROM TmpSaidarma t")
    , @NamedQuery(name = "TmpSaidarma.findByCodrma", query = "SELECT t FROM TmpSaidarma t WHERE t.codrma = :codrma")
    , @NamedQuery(name = "TmpSaidarma.findByQuantidade", query = "SELECT t FROM TmpSaidarma t WHERE t.quantidade = :quantidade")})
public class TmpSaidarma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODRMA")
    private String codrma;
    @Basic(optional = false)
    @Column(name = "QUANTIDADE")
    private int quantidade;

    public TmpSaidarma() {
    }

    public TmpSaidarma(String codrma) {
        this.codrma = codrma;
    }

    public TmpSaidarma(String codrma, int quantidade) {
        this.codrma = codrma;
        this.quantidade = quantidade;
    }

    public String getCodrma() {
        return codrma;
    }

    public void setCodrma(String codrma) {
        this.codrma = codrma;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codrma != null ? codrma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TmpSaidarma)) {
            return false;
        }
        TmpSaidarma other = (TmpSaidarma) object;
        if ((this.codrma == null && other.codrma != null) || (this.codrma != null && !this.codrma.equals(other.codrma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.TmpSaidarma[ codrma=" + codrma + " ]";
    }
    
}
