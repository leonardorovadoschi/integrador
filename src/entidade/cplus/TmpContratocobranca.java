/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "TMP_CONTRATOCOBRANCA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TmpContratocobranca.findAll", query = "SELECT t FROM TmpContratocobranca t")
    , @NamedQuery(name = "TmpContratocobranca.findByCodcontratocobranca", query = "SELECT t FROM TmpContratocobranca t WHERE t.tmpContratocobrancaPK.codcontratocobranca = :codcontratocobranca")
    , @NamedQuery(name = "TmpContratocobranca.findByCodcontratocobrancaproduto", query = "SELECT t FROM TmpContratocobranca t WHERE t.tmpContratocobrancaPK.codcontratocobrancaproduto = :codcontratocobrancaproduto")
    , @NamedQuery(name = "TmpContratocobranca.findByCodempresa", query = "SELECT t FROM TmpContratocobranca t WHERE t.codempresa = :codempresa")
    , @NamedQuery(name = "TmpContratocobranca.findByCodclifinanceiro", query = "SELECT t FROM TmpContratocobranca t WHERE t.codclifinanceiro = :codclifinanceiro")
    , @NamedQuery(name = "TmpContratocobranca.findByDatavencimento", query = "SELECT t FROM TmpContratocobranca t WHERE t.datavencimento = :datavencimento")
    , @NamedQuery(name = "TmpContratocobranca.findByCodcentrocusto", query = "SELECT t FROM TmpContratocobranca t WHERE t.codcentrocusto = :codcentrocusto")
    , @NamedQuery(name = "TmpContratocobranca.findByCodpc", query = "SELECT t FROM TmpContratocobranca t WHERE t.codpc = :codpc")
    , @NamedQuery(name = "TmpContratocobranca.findByCodcontabancaria", query = "SELECT t FROM TmpContratocobranca t WHERE t.codcontabancaria = :codcontabancaria")
    , @NamedQuery(name = "TmpContratocobranca.findByValortotal", query = "SELECT t FROM TmpContratocobranca t WHERE t.valortotal = :valortotal")
    , @NamedQuery(name = "TmpContratocobranca.findByFlagaglutinarcobrancas", query = "SELECT t FROM TmpContratocobranca t WHERE t.flagaglutinarcobrancas = :flagaglutinarcobrancas")
    , @NamedQuery(name = "TmpContratocobranca.findByStatus", query = "SELECT t FROM TmpContratocobranca t WHERE t.status = :status")
    , @NamedQuery(name = "TmpContratocobranca.findByFlagdestino", query = "SELECT t FROM TmpContratocobranca t WHERE t.flagdestino = :flagdestino")})
public class TmpContratocobranca implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TmpContratocobrancaPK tmpContratocobrancaPK;
    @Column(name = "CODEMPRESA")
    private Integer codempresa;
    @Column(name = "CODCLIFINANCEIRO")
    private String codclifinanceiro;
    @Column(name = "DATAVENCIMENTO")
    @Temporal(TemporalType.DATE)
    private Date datavencimento;
    @Column(name = "CODCENTROCUSTO")
    private String codcentrocusto;
    @Column(name = "CODPC")
    private String codpc;
    @Column(name = "CODCONTABANCARIA")
    private String codcontabancaria;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALORTOTAL")
    private BigDecimal valortotal;
    @Column(name = "FLAGAGLUTINARCOBRANCAS")
    private Character flagaglutinarcobrancas;
    @Column(name = "STATUS")
    private Character status;
    @Column(name = "FLAGDESTINO")
    private Character flagdestino;

    public TmpContratocobranca() {
    }

    public TmpContratocobranca(TmpContratocobrancaPK tmpContratocobrancaPK) {
        this.tmpContratocobrancaPK = tmpContratocobrancaPK;
    }

    public TmpContratocobranca(String codcontratocobranca, String codcontratocobrancaproduto) {
        this.tmpContratocobrancaPK = new TmpContratocobrancaPK(codcontratocobranca, codcontratocobrancaproduto);
    }

    public TmpContratocobrancaPK getTmpContratocobrancaPK() {
        return tmpContratocobrancaPK;
    }

    public void setTmpContratocobrancaPK(TmpContratocobrancaPK tmpContratocobrancaPK) {
        this.tmpContratocobrancaPK = tmpContratocobrancaPK;
    }

    public Integer getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Integer codempresa) {
        this.codempresa = codempresa;
    }

    public String getCodclifinanceiro() {
        return codclifinanceiro;
    }

    public void setCodclifinanceiro(String codclifinanceiro) {
        this.codclifinanceiro = codclifinanceiro;
    }

    public Date getDatavencimento() {
        return datavencimento;
    }

    public void setDatavencimento(Date datavencimento) {
        this.datavencimento = datavencimento;
    }

    public String getCodcentrocusto() {
        return codcentrocusto;
    }

    public void setCodcentrocusto(String codcentrocusto) {
        this.codcentrocusto = codcentrocusto;
    }

    public String getCodpc() {
        return codpc;
    }

    public void setCodpc(String codpc) {
        this.codpc = codpc;
    }

    public String getCodcontabancaria() {
        return codcontabancaria;
    }

    public void setCodcontabancaria(String codcontabancaria) {
        this.codcontabancaria = codcontabancaria;
    }

    public BigDecimal getValortotal() {
        return valortotal;
    }

    public void setValortotal(BigDecimal valortotal) {
        this.valortotal = valortotal;
    }

    public Character getFlagaglutinarcobrancas() {
        return flagaglutinarcobrancas;
    }

    public void setFlagaglutinarcobrancas(Character flagaglutinarcobrancas) {
        this.flagaglutinarcobrancas = flagaglutinarcobrancas;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public Character getFlagdestino() {
        return flagdestino;
    }

    public void setFlagdestino(Character flagdestino) {
        this.flagdestino = flagdestino;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tmpContratocobrancaPK != null ? tmpContratocobrancaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TmpContratocobranca)) {
            return false;
        }
        TmpContratocobranca other = (TmpContratocobranca) object;
        if ((this.tmpContratocobrancaPK == null && other.tmpContratocobrancaPK != null) || (this.tmpContratocobrancaPK != null && !this.tmpContratocobrancaPK.equals(other.tmpContratocobrancaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.TmpContratocobranca[ tmpContratocobrancaPK=" + tmpContratocobrancaPK + " ]";
    }
    
}
