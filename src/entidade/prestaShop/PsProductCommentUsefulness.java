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
 * @author leo-note
 */
@Entity
@Table(name = "ps_product_comment_usefulness")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsProductCommentUsefulness.findAll", query = "SELECT p FROM PsProductCommentUsefulness p")})
public class PsProductCommentUsefulness implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsProductCommentUsefulnessPK psProductCommentUsefulnessPK;
    @Basic(optional = false)
    @Column(name = "usefulness")
    private short usefulness;

    public PsProductCommentUsefulness() {
    }

    public PsProductCommentUsefulness(PsProductCommentUsefulnessPK psProductCommentUsefulnessPK) {
        this.psProductCommentUsefulnessPK = psProductCommentUsefulnessPK;
    }

    public PsProductCommentUsefulness(PsProductCommentUsefulnessPK psProductCommentUsefulnessPK, short usefulness) {
        this.psProductCommentUsefulnessPK = psProductCommentUsefulnessPK;
        this.usefulness = usefulness;
    }

    public PsProductCommentUsefulness(int idProductComment, int idCustomer) {
        this.psProductCommentUsefulnessPK = new PsProductCommentUsefulnessPK(idProductComment, idCustomer);
    }

    public PsProductCommentUsefulnessPK getPsProductCommentUsefulnessPK() {
        return psProductCommentUsefulnessPK;
    }

    public void setPsProductCommentUsefulnessPK(PsProductCommentUsefulnessPK psProductCommentUsefulnessPK) {
        this.psProductCommentUsefulnessPK = psProductCommentUsefulnessPK;
    }

    public short getUsefulness() {
        return usefulness;
    }

    public void setUsefulness(short usefulness) {
        this.usefulness = usefulness;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psProductCommentUsefulnessPK != null ? psProductCommentUsefulnessPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsProductCommentUsefulness)) {
            return false;
        }
        PsProductCommentUsefulness other = (PsProductCommentUsefulness) object;
        if ((this.psProductCommentUsefulnessPK == null && other.psProductCommentUsefulnessPK != null) || (this.psProductCommentUsefulnessPK != null && !this.psProductCommentUsefulnessPK.equals(other.psProductCommentUsefulnessPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsProductCommentUsefulness[ psProductCommentUsefulnessPK=" + psProductCommentUsefulnessPK + " ]";
    }
    
}
