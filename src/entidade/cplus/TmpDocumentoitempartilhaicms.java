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
@Table(name = "TMP_DOCUMENTOITEMPARTILHAICMS", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TmpDocumentoitempartilhaicms.findAll", query = "SELECT t FROM TmpDocumentoitempartilhaicms t")
    , @NamedQuery(name = "TmpDocumentoitempartilhaicms.findByCodtmpDocumentoitempartilha", query = "SELECT t FROM TmpDocumentoitempartilhaicms t WHERE t.codtmpDocumentoitempartilha = :codtmpDocumentoitempartilha")
    , @NamedQuery(name = "TmpDocumentoitempartilhaicms.findByCodtmpDocumentoitem", query = "SELECT t FROM TmpDocumentoitempartilhaicms t WHERE t.codtmpDocumentoitem = :codtmpDocumentoitem")
    , @NamedQuery(name = "TmpDocumentoitempartilhaicms.findByCodtmpDocumento", query = "SELECT t FROM TmpDocumentoitempartilhaicms t WHERE t.codtmpDocumento = :codtmpDocumento")
    , @NamedQuery(name = "TmpDocumentoitempartilhaicms.findByBaseicms", query = "SELECT t FROM TmpDocumentoitempartilhaicms t WHERE t.baseicms = :baseicms")
    , @NamedQuery(name = "TmpDocumentoitempartilhaicms.findByAliqfcp", query = "SELECT t FROM TmpDocumentoitempartilhaicms t WHERE t.aliqfcp = :aliqfcp")
    , @NamedQuery(name = "TmpDocumentoitempartilhaicms.findByAliqicms", query = "SELECT t FROM TmpDocumentoitempartilhaicms t WHERE t.aliqicms = :aliqicms")
    , @NamedQuery(name = "TmpDocumentoitempartilhaicms.findByAliqicmsinter", query = "SELECT t FROM TmpDocumentoitempartilhaicms t WHERE t.aliqicmsinter = :aliqicmsinter")
    , @NamedQuery(name = "TmpDocumentoitempartilhaicms.findByAliqpartilha", query = "SELECT t FROM TmpDocumentoitempartilhaicms t WHERE t.aliqpartilha = :aliqpartilha")
    , @NamedQuery(name = "TmpDocumentoitempartilhaicms.findByValorfcp", query = "SELECT t FROM TmpDocumentoitempartilhaicms t WHERE t.valorfcp = :valorfcp")
    , @NamedQuery(name = "TmpDocumentoitempartilhaicms.findByValoricmsdestino", query = "SELECT t FROM TmpDocumentoitempartilhaicms t WHERE t.valoricmsdestino = :valoricmsdestino")
    , @NamedQuery(name = "TmpDocumentoitempartilhaicms.findByValoricmsorigem", query = "SELECT t FROM TmpDocumentoitempartilhaicms t WHERE t.valoricmsorigem = :valoricmsorigem")
    , @NamedQuery(name = "TmpDocumentoitempartilhaicms.findByBaseicmsfcpdestino", query = "SELECT t FROM TmpDocumentoitempartilhaicms t WHERE t.baseicmsfcpdestino = :baseicmsfcpdestino")})
public class TmpDocumentoitempartilhaicms implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODTMP_DOCUMENTOITEMPARTILHA")
    private Integer codtmpDocumentoitempartilha;
    @Basic(optional = false)
    @Column(name = "CODTMP_DOCUMENTOITEM")
    private int codtmpDocumentoitem;
    @Basic(optional = false)
    @Column(name = "CODTMP_DOCUMENTO")
    private int codtmpDocumento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "BASEICMS")
    private BigDecimal baseicms;
    @Basic(optional = false)
    @Column(name = "ALIQFCP")
    private BigDecimal aliqfcp;
    @Basic(optional = false)
    @Column(name = "ALIQICMS")
    private BigDecimal aliqicms;
    @Basic(optional = false)
    @Column(name = "ALIQICMSINTER")
    private BigDecimal aliqicmsinter;
    @Basic(optional = false)
    @Column(name = "ALIQPARTILHA")
    private BigDecimal aliqpartilha;
    @Basic(optional = false)
    @Column(name = "VALORFCP")
    private BigDecimal valorfcp;
    @Basic(optional = false)
    @Column(name = "VALORICMSDESTINO")
    private BigDecimal valoricmsdestino;
    @Basic(optional = false)
    @Column(name = "VALORICMSORIGEM")
    private BigDecimal valoricmsorigem;
    @Column(name = "BASEICMSFCPDESTINO")
    private BigDecimal baseicmsfcpdestino;

    public TmpDocumentoitempartilhaicms() {
    }

    public TmpDocumentoitempartilhaicms(Integer codtmpDocumentoitempartilha) {
        this.codtmpDocumentoitempartilha = codtmpDocumentoitempartilha;
    }

    public TmpDocumentoitempartilhaicms(Integer codtmpDocumentoitempartilha, int codtmpDocumentoitem, int codtmpDocumento, BigDecimal baseicms, BigDecimal aliqfcp, BigDecimal aliqicms, BigDecimal aliqicmsinter, BigDecimal aliqpartilha, BigDecimal valorfcp, BigDecimal valoricmsdestino, BigDecimal valoricmsorigem) {
        this.codtmpDocumentoitempartilha = codtmpDocumentoitempartilha;
        this.codtmpDocumentoitem = codtmpDocumentoitem;
        this.codtmpDocumento = codtmpDocumento;
        this.baseicms = baseicms;
        this.aliqfcp = aliqfcp;
        this.aliqicms = aliqicms;
        this.aliqicmsinter = aliqicmsinter;
        this.aliqpartilha = aliqpartilha;
        this.valorfcp = valorfcp;
        this.valoricmsdestino = valoricmsdestino;
        this.valoricmsorigem = valoricmsorigem;
    }

    public Integer getCodtmpDocumentoitempartilha() {
        return codtmpDocumentoitempartilha;
    }

    public void setCodtmpDocumentoitempartilha(Integer codtmpDocumentoitempartilha) {
        this.codtmpDocumentoitempartilha = codtmpDocumentoitempartilha;
    }

    public int getCodtmpDocumentoitem() {
        return codtmpDocumentoitem;
    }

    public void setCodtmpDocumentoitem(int codtmpDocumentoitem) {
        this.codtmpDocumentoitem = codtmpDocumentoitem;
    }

    public int getCodtmpDocumento() {
        return codtmpDocumento;
    }

    public void setCodtmpDocumento(int codtmpDocumento) {
        this.codtmpDocumento = codtmpDocumento;
    }

    public BigDecimal getBaseicms() {
        return baseicms;
    }

    public void setBaseicms(BigDecimal baseicms) {
        this.baseicms = baseicms;
    }

    public BigDecimal getAliqfcp() {
        return aliqfcp;
    }

    public void setAliqfcp(BigDecimal aliqfcp) {
        this.aliqfcp = aliqfcp;
    }

    public BigDecimal getAliqicms() {
        return aliqicms;
    }

    public void setAliqicms(BigDecimal aliqicms) {
        this.aliqicms = aliqicms;
    }

    public BigDecimal getAliqicmsinter() {
        return aliqicmsinter;
    }

    public void setAliqicmsinter(BigDecimal aliqicmsinter) {
        this.aliqicmsinter = aliqicmsinter;
    }

    public BigDecimal getAliqpartilha() {
        return aliqpartilha;
    }

    public void setAliqpartilha(BigDecimal aliqpartilha) {
        this.aliqpartilha = aliqpartilha;
    }

    public BigDecimal getValorfcp() {
        return valorfcp;
    }

    public void setValorfcp(BigDecimal valorfcp) {
        this.valorfcp = valorfcp;
    }

    public BigDecimal getValoricmsdestino() {
        return valoricmsdestino;
    }

    public void setValoricmsdestino(BigDecimal valoricmsdestino) {
        this.valoricmsdestino = valoricmsdestino;
    }

    public BigDecimal getValoricmsorigem() {
        return valoricmsorigem;
    }

    public void setValoricmsorigem(BigDecimal valoricmsorigem) {
        this.valoricmsorigem = valoricmsorigem;
    }

    public BigDecimal getBaseicmsfcpdestino() {
        return baseicmsfcpdestino;
    }

    public void setBaseicmsfcpdestino(BigDecimal baseicmsfcpdestino) {
        this.baseicmsfcpdestino = baseicmsfcpdestino;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codtmpDocumentoitempartilha != null ? codtmpDocumentoitempartilha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TmpDocumentoitempartilhaicms)) {
            return false;
        }
        TmpDocumentoitempartilhaicms other = (TmpDocumentoitempartilhaicms) object;
        if ((this.codtmpDocumentoitempartilha == null && other.codtmpDocumentoitempartilha != null) || (this.codtmpDocumentoitempartilha != null && !this.codtmpDocumentoitempartilha.equals(other.codtmpDocumentoitempartilha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.TmpDocumentoitempartilhaicms[ codtmpDocumentoitempartilha=" + codtmpDocumentoitempartilha + " ]";
    }
    
}
