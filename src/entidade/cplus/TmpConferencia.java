/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "TMP_CONFERENCIA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TmpConferencia.findAll", query = "SELECT t FROM TmpConferencia t")
    , @NamedQuery(name = "TmpConferencia.findByCodtmpConferencia", query = "SELECT t FROM TmpConferencia t WHERE t.codtmpConferencia = :codtmpConferencia")
    , @NamedQuery(name = "TmpConferencia.findByCodprod", query = "SELECT t FROM TmpConferencia t WHERE t.codprod = :codprod")
    , @NamedQuery(name = "TmpConferencia.findByEstatu", query = "SELECT t FROM TmpConferencia t WHERE t.estatu = :estatu")
    , @NamedQuery(name = "TmpConferencia.findByQuantidade", query = "SELECT t FROM TmpConferencia t WHERE t.quantidade = :quantidade")
    , @NamedQuery(name = "TmpConferencia.findByLote", query = "SELECT t FROM TmpConferencia t WHERE t.lote = :lote")
    , @NamedQuery(name = "TmpConferencia.findByDatafabricacao", query = "SELECT t FROM TmpConferencia t WHERE t.datafabricacao = :datafabricacao")
    , @NamedQuery(name = "TmpConferencia.findByDatavalidade", query = "SELECT t FROM TmpConferencia t WHERE t.datavalidade = :datavalidade")
    , @NamedQuery(name = "TmpConferencia.findByFlagloteperecivel", query = "SELECT t FROM TmpConferencia t WHERE t.flagloteperecivel = :flagloteperecivel")})
public class TmpConferencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODTMP_CONFERENCIA")
    private Integer codtmpConferencia;
    @Column(name = "CODPROD")
    private String codprod;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ESTATU")
    private BigDecimal estatu;
    @Column(name = "QUANTIDADE")
    private BigDecimal quantidade;
    @Column(name = "LOTE")
    private String lote;
    @Column(name = "DATAFABRICACAO")
    @Temporal(TemporalType.DATE)
    private Date datafabricacao;
    @Column(name = "DATAVALIDADE")
    @Temporal(TemporalType.DATE)
    private Date datavalidade;
    @Column(name = "FLAGLOTEPERECIVEL")
    private Character flagloteperecivel;

    public TmpConferencia() {
    }

    public TmpConferencia(Integer codtmpConferencia) {
        this.codtmpConferencia = codtmpConferencia;
    }

    public Integer getCodtmpConferencia() {
        return codtmpConferencia;
    }

    public void setCodtmpConferencia(Integer codtmpConferencia) {
        this.codtmpConferencia = codtmpConferencia;
    }

    public String getCodprod() {
        return codprod;
    }

    public void setCodprod(String codprod) {
        this.codprod = codprod;
    }

    public BigDecimal getEstatu() {
        return estatu;
    }

    public void setEstatu(BigDecimal estatu) {
        this.estatu = estatu;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public Date getDatafabricacao() {
        return datafabricacao;
    }

    public void setDatafabricacao(Date datafabricacao) {
        this.datafabricacao = datafabricacao;
    }

    public Date getDatavalidade() {
        return datavalidade;
    }

    public void setDatavalidade(Date datavalidade) {
        this.datavalidade = datavalidade;
    }

    public Character getFlagloteperecivel() {
        return flagloteperecivel;
    }

    public void setFlagloteperecivel(Character flagloteperecivel) {
        this.flagloteperecivel = flagloteperecivel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codtmpConferencia != null ? codtmpConferencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TmpConferencia)) {
            return false;
        }
        TmpConferencia other = (TmpConferencia) object;
        if ((this.codtmpConferencia == null && other.codtmpConferencia != null) || (this.codtmpConferencia != null && !this.codtmpConferencia.equals(other.codtmpConferencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.TmpConferencia[ codtmpConferencia=" + codtmpConferencia + " ]";
    }
    
}
