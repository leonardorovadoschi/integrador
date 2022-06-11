/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade.cplus;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "TMP_SEPARACAOORCAMENTO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TmpSeparacaoorcamento.findAll", query = "SELECT t FROM TmpSeparacaoorcamento t")
    , @NamedQuery(name = "TmpSeparacaoorcamento.findByCodorcprod", query = "SELECT t FROM TmpSeparacaoorcamento t WHERE t.codorcprod = :codorcprod")
    , @NamedQuery(name = "TmpSeparacaoorcamento.findByQuantidadeconferida", query = "SELECT t FROM TmpSeparacaoorcamento t WHERE t.quantidadeconferida = :quantidadeconferida")})
public class TmpSeparacaoorcamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODORCPROD")
    private String codorcprod;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "QUANTIDADECONFERIDA")
    private BigDecimal quantidadeconferida;

    public TmpSeparacaoorcamento() {
    }

    public TmpSeparacaoorcamento(String codorcprod) {
        this.codorcprod = codorcprod;
    }

    public String getCodorcprod() {
        return codorcprod;
    }

    public void setCodorcprod(String codorcprod) {
        this.codorcprod = codorcprod;
    }

    public BigDecimal getQuantidadeconferida() {
        return quantidadeconferida;
    }

    public void setQuantidadeconferida(BigDecimal quantidadeconferida) {
        this.quantidadeconferida = quantidadeconferida;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codorcprod != null ? codorcprod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TmpSeparacaoorcamento)) {
            return false;
        }
        TmpSeparacaoorcamento other = (TmpSeparacaoorcamento) object;
        if ((this.codorcprod == null && other.codorcprod != null) || (this.codorcprod != null && !this.codorcprod.equals(other.codorcprod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.TmpSeparacaoorcamento[ codorcprod=" + codorcprod + " ]";
    }

}
