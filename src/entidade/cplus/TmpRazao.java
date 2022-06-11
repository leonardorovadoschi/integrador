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
@Table(name = "TMP_RAZAO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TmpRazao.findAll", query = "SELECT t FROM TmpRazao t")
    , @NamedQuery(name = "TmpRazao.findByCodcli", query = "SELECT t FROM TmpRazao t WHERE t.codcli = :codcli")
    , @NamedQuery(name = "TmpRazao.findBySaldoanterior", query = "SELECT t FROM TmpRazao t WHERE t.saldoanterior = :saldoanterior")
    , @NamedQuery(name = "TmpRazao.findByJurosanterior", query = "SELECT t FROM TmpRazao t WHERE t.jurosanterior = :jurosanterior")})
public class TmpRazao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCLI")
    private String codcli;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SALDOANTERIOR")
    private BigDecimal saldoanterior;
    @Column(name = "JUROSANTERIOR")
    private BigDecimal jurosanterior;

    public TmpRazao() {
    }

    public TmpRazao(String codcli) {
        this.codcli = codcli;
    }

    public String getCodcli() {
        return codcli;
    }

    public void setCodcli(String codcli) {
        this.codcli = codcli;
    }

    public BigDecimal getSaldoanterior() {
        return saldoanterior;
    }

    public void setSaldoanterior(BigDecimal saldoanterior) {
        this.saldoanterior = saldoanterior;
    }

    public BigDecimal getJurosanterior() {
        return jurosanterior;
    }

    public void setJurosanterior(BigDecimal jurosanterior) {
        this.jurosanterior = jurosanterior;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcli != null ? codcli.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TmpRazao)) {
            return false;
        }
        TmpRazao other = (TmpRazao) object;
        if ((this.codcli == null && other.codcli != null) || (this.codcli != null && !this.codcli.equals(other.codcli))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.TmpRazao[ codcli=" + codcli + " ]";
    }
    
}
