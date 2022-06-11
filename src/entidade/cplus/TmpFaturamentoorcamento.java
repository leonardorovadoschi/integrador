/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "TMP_FATURAMENTOORCAMENTO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TmpFaturamentoorcamento.findAll", query = "SELECT t FROM TmpFaturamentoorcamento t")
    , @NamedQuery(name = "TmpFaturamentoorcamento.findByCodorc", query = "SELECT t FROM TmpFaturamentoorcamento t WHERE t.tmpFaturamentoorcamentoPK.codorc = :codorc")
    , @NamedQuery(name = "TmpFaturamentoorcamento.findByCodorcprod", query = "SELECT t FROM TmpFaturamentoorcamento t WHERE t.tmpFaturamentoorcamentoPK.codorcprod = :codorcprod")
    , @NamedQuery(name = "TmpFaturamentoorcamento.findByQuantidade", query = "SELECT t FROM TmpFaturamentoorcamento t WHERE t.quantidade = :quantidade")})
public class TmpFaturamentoorcamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TmpFaturamentoorcamentoPK tmpFaturamentoorcamentoPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "QUANTIDADE")
    private BigDecimal quantidade;

    public TmpFaturamentoorcamento() {
    }

    public TmpFaturamentoorcamento(TmpFaturamentoorcamentoPK tmpFaturamentoorcamentoPK) {
        this.tmpFaturamentoorcamentoPK = tmpFaturamentoorcamentoPK;
    }

    public TmpFaturamentoorcamento(String codorc, String codorcprod) {
        this.tmpFaturamentoorcamentoPK = new TmpFaturamentoorcamentoPK(codorc, codorcprod);
    }

    public TmpFaturamentoorcamentoPK getTmpFaturamentoorcamentoPK() {
        return tmpFaturamentoorcamentoPK;
    }

    public void setTmpFaturamentoorcamentoPK(TmpFaturamentoorcamentoPK tmpFaturamentoorcamentoPK) {
        this.tmpFaturamentoorcamentoPK = tmpFaturamentoorcamentoPK;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tmpFaturamentoorcamentoPK != null ? tmpFaturamentoorcamentoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TmpFaturamentoorcamento)) {
            return false;
        }
        TmpFaturamentoorcamento other = (TmpFaturamentoorcamento) object;
        if ((this.tmpFaturamentoorcamentoPK == null && other.tmpFaturamentoorcamentoPK != null) || (this.tmpFaturamentoorcamentoPK != null && !this.tmpFaturamentoorcamentoPK.equals(other.tmpFaturamentoorcamentoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.TmpFaturamentoorcamento[ tmpFaturamentoorcamentoPK=" + tmpFaturamentoorcamentoPK + " ]";
    }
    
}
