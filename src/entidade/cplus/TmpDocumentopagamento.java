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
@Table(name = "TMP_DOCUMENTOPAGAMENTO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TmpDocumentopagamento.findAll", query = "SELECT t FROM TmpDocumentopagamento t")
    , @NamedQuery(name = "TmpDocumentopagamento.findByCodtmpDocumentopagamento", query = "SELECT t FROM TmpDocumentopagamento t WHERE t.codtmpDocumentopagamento = :codtmpDocumentopagamento")
    , @NamedQuery(name = "TmpDocumentopagamento.findByCodtmpDocumento", query = "SELECT t FROM TmpDocumentopagamento t WHERE t.codtmpDocumento = :codtmpDocumento")
    , @NamedQuery(name = "TmpDocumentopagamento.findByFlagtipopagamento", query = "SELECT t FROM TmpDocumentopagamento t WHERE t.flagtipopagamento = :flagtipopagamento")
    , @NamedQuery(name = "TmpDocumentopagamento.findByCodmeiopagamento", query = "SELECT t FROM TmpDocumentopagamento t WHERE t.codmeiopagamento = :codmeiopagamento")
    , @NamedQuery(name = "TmpDocumentopagamento.findByValorpagamento", query = "SELECT t FROM TmpDocumentopagamento t WHERE t.valorpagamento = :valorpagamento")
    , @NamedQuery(name = "TmpDocumentopagamento.findByFlagintegracaocartao", query = "SELECT t FROM TmpDocumentopagamento t WHERE t.flagintegracaocartao = :flagintegracaocartao")
    , @NamedQuery(name = "TmpDocumentopagamento.findByCnpjcredenciadoracartao", query = "SELECT t FROM TmpDocumentopagamento t WHERE t.cnpjcredenciadoracartao = :cnpjcredenciadoracartao")
    , @NamedQuery(name = "TmpDocumentopagamento.findByCodbandeiracartao", query = "SELECT t FROM TmpDocumentopagamento t WHERE t.codbandeiracartao = :codbandeiracartao")
    , @NamedQuery(name = "TmpDocumentopagamento.findByNumeroautorizacaocartao", query = "SELECT t FROM TmpDocumentopagamento t WHERE t.numeroautorizacaocartao = :numeroautorizacaocartao")
    , @NamedQuery(name = "TmpDocumentopagamento.findByFlagtipo", query = "SELECT t FROM TmpDocumentopagamento t WHERE t.flagtipo = :flagtipo")})
public class TmpDocumentopagamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODTMP_DOCUMENTOPAGAMENTO")
    private Integer codtmpDocumentopagamento;
    @Basic(optional = false)
    @Column(name = "CODTMP_DOCUMENTO")
    private int codtmpDocumento;
    @Column(name = "FLAGTIPOPAGAMENTO")
    private Character flagtipopagamento;
    @Column(name = "CODMEIOPAGAMENTO")
    private String codmeiopagamento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALORPAGAMENTO")
    private BigDecimal valorpagamento;
    @Column(name = "FLAGINTEGRACAOCARTAO")
    private Character flagintegracaocartao;
    @Column(name = "CNPJCREDENCIADORACARTAO")
    private String cnpjcredenciadoracartao;
    @Column(name = "CODBANDEIRACARTAO")
    private String codbandeiracartao;
    @Column(name = "NUMEROAUTORIZACAOCARTAO")
    private String numeroautorizacaocartao;
    @Column(name = "FLAGTIPO")
    private Character flagtipo;

    public TmpDocumentopagamento() {
    }

    public TmpDocumentopagamento(Integer codtmpDocumentopagamento) {
        this.codtmpDocumentopagamento = codtmpDocumentopagamento;
    }

    public TmpDocumentopagamento(Integer codtmpDocumentopagamento, int codtmpDocumento) {
        this.codtmpDocumentopagamento = codtmpDocumentopagamento;
        this.codtmpDocumento = codtmpDocumento;
    }

    public Integer getCodtmpDocumentopagamento() {
        return codtmpDocumentopagamento;
    }

    public void setCodtmpDocumentopagamento(Integer codtmpDocumentopagamento) {
        this.codtmpDocumentopagamento = codtmpDocumentopagamento;
    }

    public int getCodtmpDocumento() {
        return codtmpDocumento;
    }

    public void setCodtmpDocumento(int codtmpDocumento) {
        this.codtmpDocumento = codtmpDocumento;
    }

    public Character getFlagtipopagamento() {
        return flagtipopagamento;
    }

    public void setFlagtipopagamento(Character flagtipopagamento) {
        this.flagtipopagamento = flagtipopagamento;
    }

    public String getCodmeiopagamento() {
        return codmeiopagamento;
    }

    public void setCodmeiopagamento(String codmeiopagamento) {
        this.codmeiopagamento = codmeiopagamento;
    }

    public BigDecimal getValorpagamento() {
        return valorpagamento;
    }

    public void setValorpagamento(BigDecimal valorpagamento) {
        this.valorpagamento = valorpagamento;
    }

    public Character getFlagintegracaocartao() {
        return flagintegracaocartao;
    }

    public void setFlagintegracaocartao(Character flagintegracaocartao) {
        this.flagintegracaocartao = flagintegracaocartao;
    }

    public String getCnpjcredenciadoracartao() {
        return cnpjcredenciadoracartao;
    }

    public void setCnpjcredenciadoracartao(String cnpjcredenciadoracartao) {
        this.cnpjcredenciadoracartao = cnpjcredenciadoracartao;
    }

    public String getCodbandeiracartao() {
        return codbandeiracartao;
    }

    public void setCodbandeiracartao(String codbandeiracartao) {
        this.codbandeiracartao = codbandeiracartao;
    }

    public String getNumeroautorizacaocartao() {
        return numeroautorizacaocartao;
    }

    public void setNumeroautorizacaocartao(String numeroautorizacaocartao) {
        this.numeroautorizacaocartao = numeroautorizacaocartao;
    }

    public Character getFlagtipo() {
        return flagtipo;
    }

    public void setFlagtipo(Character flagtipo) {
        this.flagtipo = flagtipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codtmpDocumentopagamento != null ? codtmpDocumentopagamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TmpDocumentopagamento)) {
            return false;
        }
        TmpDocumentopagamento other = (TmpDocumentopagamento) object;
        if ((this.codtmpDocumentopagamento == null && other.codtmpDocumentopagamento != null) || (this.codtmpDocumentopagamento != null && !this.codtmpDocumentopagamento.equals(other.codtmpDocumentopagamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.TmpDocumentopagamento[ codtmpDocumentopagamento=" + codtmpDocumentopagamento + " ]";
    }
    
}
