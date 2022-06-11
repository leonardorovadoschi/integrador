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
@Table(name = "TMP_DOCUMENTOITEMLOTE", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TmpDocumentoitemlote.findAll", query = "SELECT t FROM TmpDocumentoitemlote t")
    , @NamedQuery(name = "TmpDocumentoitemlote.findByCodtmpDocumentoitemlote", query = "SELECT t FROM TmpDocumentoitemlote t WHERE t.codtmpDocumentoitemlote = :codtmpDocumentoitemlote")
    , @NamedQuery(name = "TmpDocumentoitemlote.findByCodtmpDocumentoitem", query = "SELECT t FROM TmpDocumentoitemlote t WHERE t.codtmpDocumentoitem = :codtmpDocumentoitem")
    , @NamedQuery(name = "TmpDocumentoitemlote.findByCodtmpDocumento", query = "SELECT t FROM TmpDocumentoitemlote t WHERE t.codtmpDocumento = :codtmpDocumento")
    , @NamedQuery(name = "TmpDocumentoitemlote.findByLote", query = "SELECT t FROM TmpDocumentoitemlote t WHERE t.lote = :lote")
    , @NamedQuery(name = "TmpDocumentoitemlote.findByQuantidade", query = "SELECT t FROM TmpDocumentoitemlote t WHERE t.quantidade = :quantidade")
    , @NamedQuery(name = "TmpDocumentoitemlote.findByDatafabricacao", query = "SELECT t FROM TmpDocumentoitemlote t WHERE t.datafabricacao = :datafabricacao")
    , @NamedQuery(name = "TmpDocumentoitemlote.findByDatavalidade", query = "SELECT t FROM TmpDocumentoitemlote t WHERE t.datavalidade = :datavalidade")
    , @NamedQuery(name = "TmpDocumentoitemlote.findByPmc", query = "SELECT t FROM TmpDocumentoitemlote t WHERE t.pmc = :pmc")
    , @NamedQuery(name = "TmpDocumentoitemlote.findByCodigoanvisa", query = "SELECT t FROM TmpDocumentoitemlote t WHERE t.codigoanvisa = :codigoanvisa")})
public class TmpDocumentoitemlote implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODTMP_DOCUMENTOITEMLOTE")
    private Integer codtmpDocumentoitemlote;
    @Column(name = "CODTMP_DOCUMENTOITEM")
    private Integer codtmpDocumentoitem;
    @Column(name = "CODTMP_DOCUMENTO")
    private Integer codtmpDocumento;
    @Column(name = "LOTE")
    private String lote;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "QUANTIDADE")
    private BigDecimal quantidade;
    @Column(name = "DATAFABRICACAO")
    @Temporal(TemporalType.DATE)
    private Date datafabricacao;
    @Column(name = "DATAVALIDADE")
    @Temporal(TemporalType.DATE)
    private Date datavalidade;
    @Column(name = "PMC")
    private BigDecimal pmc;
    @Column(name = "CODIGOANVISA")
    private String codigoanvisa;

    public TmpDocumentoitemlote() {
    }

    public TmpDocumentoitemlote(Integer codtmpDocumentoitemlote) {
        this.codtmpDocumentoitemlote = codtmpDocumentoitemlote;
    }

    public Integer getCodtmpDocumentoitemlote() {
        return codtmpDocumentoitemlote;
    }

    public void setCodtmpDocumentoitemlote(Integer codtmpDocumentoitemlote) {
        this.codtmpDocumentoitemlote = codtmpDocumentoitemlote;
    }

    public Integer getCodtmpDocumentoitem() {
        return codtmpDocumentoitem;
    }

    public void setCodtmpDocumentoitem(Integer codtmpDocumentoitem) {
        this.codtmpDocumentoitem = codtmpDocumentoitem;
    }

    public Integer getCodtmpDocumento() {
        return codtmpDocumento;
    }

    public void setCodtmpDocumento(Integer codtmpDocumento) {
        this.codtmpDocumento = codtmpDocumento;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
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

    public BigDecimal getPmc() {
        return pmc;
    }

    public void setPmc(BigDecimal pmc) {
        this.pmc = pmc;
    }

    public String getCodigoanvisa() {
        return codigoanvisa;
    }

    public void setCodigoanvisa(String codigoanvisa) {
        this.codigoanvisa = codigoanvisa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codtmpDocumentoitemlote != null ? codtmpDocumentoitemlote.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TmpDocumentoitemlote)) {
            return false;
        }
        TmpDocumentoitemlote other = (TmpDocumentoitemlote) object;
        if ((this.codtmpDocumentoitemlote == null && other.codtmpDocumentoitemlote != null) || (this.codtmpDocumentoitemlote != null && !this.codtmpDocumentoitemlote.equals(other.codtmpDocumentoitemlote))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.TmpDocumentoitemlote[ codtmpDocumentoitemlote=" + codtmpDocumentoitemlote + " ]";
    }
    
}
