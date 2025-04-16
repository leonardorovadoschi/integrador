/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade.prestaShop;

import java.io.Serializable;
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
@Table(name = "ps_product_comment_report")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsProductCommentReport.findAll", query = "SELECT p FROM PsProductCommentReport p")})
public class PsProductCommentReport implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsProductCommentReportPK psProductCommentReportPK;

    public PsProductCommentReport() {
    }

    public PsProductCommentReport(PsProductCommentReportPK psProductCommentReportPK) {
        this.psProductCommentReportPK = psProductCommentReportPK;
    }

    public PsProductCommentReport(int idProductComment, int idCustomer) {
        this.psProductCommentReportPK = new PsProductCommentReportPK(idProductComment, idCustomer);
    }

    public PsProductCommentReportPK getPsProductCommentReportPK() {
        return psProductCommentReportPK;
    }

    public void setPsProductCommentReportPK(PsProductCommentReportPK psProductCommentReportPK) {
        this.psProductCommentReportPK = psProductCommentReportPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psProductCommentReportPK != null ? psProductCommentReportPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsProductCommentReport)) {
            return false;
        }
        PsProductCommentReport other = (PsProductCommentReport) object;
        if ((this.psProductCommentReportPK == null && other.psProductCommentReportPK != null) || (this.psProductCommentReportPK != null && !this.psProductCommentReportPK.equals(other.psProductCommentReportPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsProductCommentReport[ psProductCommentReportPK=" + psProductCommentReportPK + " ]";
    }
    
}
