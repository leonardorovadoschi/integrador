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
@Table(name = "TMP_SPED_C420", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TmpSpedC420.findAll", query = "SELECT t FROM TmpSpedC420 t")
    , @NamedQuery(name = "TmpSpedC420.findByCodtmpSpedC420", query = "SELECT t FROM TmpSpedC420 t WHERE t.codtmpSpedC420 = :codtmpSpedC420")
    , @NamedQuery(name = "TmpSpedC420.findByCooinicial", query = "SELECT t FROM TmpSpedC420 t WHERE t.cooinicial = :cooinicial")
    , @NamedQuery(name = "TmpSpedC420.findByCoofinal", query = "SELECT t FROM TmpSpedC420 t WHERE t.coofinal = :coofinal")
    , @NamedQuery(name = "TmpSpedC420.findByCodAliquota", query = "SELECT t FROM TmpSpedC420 t WHERE t.codAliquota = :codAliquota")
    , @NamedQuery(name = "TmpSpedC420.findByValortotal", query = "SELECT t FROM TmpSpedC420 t WHERE t.valortotal = :valortotal")
    , @NamedQuery(name = "TmpSpedC420.findByNumerototalizador", query = "SELECT t FROM TmpSpedC420 t WHERE t.numerototalizador = :numerototalizador")
    , @NamedQuery(name = "TmpSpedC420.findByDescr", query = "SELECT t FROM TmpSpedC420 t WHERE t.descr = :descr")
    , @NamedQuery(name = "TmpSpedC420.findByNumeroserie", query = "SELECT t FROM TmpSpedC420 t WHERE t.numeroserie = :numeroserie")
    , @NamedQuery(name = "TmpSpedC420.findByDatamovimento", query = "SELECT t FROM TmpSpedC420 t WHERE t.datamovimento = :datamovimento")})
public class TmpSpedC420 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODTMP_SPED_C420")
    private Integer codtmpSpedC420;
    @Basic(optional = false)
    @Column(name = "COOINICIAL")
    private int cooinicial;
    @Basic(optional = false)
    @Column(name = "COOFINAL")
    private int coofinal;
    @Basic(optional = false)
    @Column(name = "COD_ALIQUOTA")
    private String codAliquota;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "VALORTOTAL")
    private BigDecimal valortotal;
    @Basic(optional = false)
    @Column(name = "NUMEROTOTALIZADOR")
    private String numerototalizador;
    @Basic(optional = false)
    @Column(name = "DESCR")
    private String descr;
    @Basic(optional = false)
    @Column(name = "NUMEROSERIE")
    private String numeroserie;
    @Basic(optional = false)
    @Column(name = "DATAMOVIMENTO")
    @Temporal(TemporalType.DATE)
    private Date datamovimento;

    public TmpSpedC420() {
    }

    public TmpSpedC420(Integer codtmpSpedC420) {
        this.codtmpSpedC420 = codtmpSpedC420;
    }

    public TmpSpedC420(Integer codtmpSpedC420, int cooinicial, int coofinal, String codAliquota, BigDecimal valortotal, String numerototalizador, String descr, String numeroserie, Date datamovimento) {
        this.codtmpSpedC420 = codtmpSpedC420;
        this.cooinicial = cooinicial;
        this.coofinal = coofinal;
        this.codAliquota = codAliquota;
        this.valortotal = valortotal;
        this.numerototalizador = numerototalizador;
        this.descr = descr;
        this.numeroserie = numeroserie;
        this.datamovimento = datamovimento;
    }

    public Integer getCodtmpSpedC420() {
        return codtmpSpedC420;
    }

    public void setCodtmpSpedC420(Integer codtmpSpedC420) {
        this.codtmpSpedC420 = codtmpSpedC420;
    }

    public int getCooinicial() {
        return cooinicial;
    }

    public void setCooinicial(int cooinicial) {
        this.cooinicial = cooinicial;
    }

    public int getCoofinal() {
        return coofinal;
    }

    public void setCoofinal(int coofinal) {
        this.coofinal = coofinal;
    }

    public String getCodAliquota() {
        return codAliquota;
    }

    public void setCodAliquota(String codAliquota) {
        this.codAliquota = codAliquota;
    }

    public BigDecimal getValortotal() {
        return valortotal;
    }

    public void setValortotal(BigDecimal valortotal) {
        this.valortotal = valortotal;
    }

    public String getNumerototalizador() {
        return numerototalizador;
    }

    public void setNumerototalizador(String numerototalizador) {
        this.numerototalizador = numerototalizador;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getNumeroserie() {
        return numeroserie;
    }

    public void setNumeroserie(String numeroserie) {
        this.numeroserie = numeroserie;
    }

    public Date getDatamovimento() {
        return datamovimento;
    }

    public void setDatamovimento(Date datamovimento) {
        this.datamovimento = datamovimento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codtmpSpedC420 != null ? codtmpSpedC420.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TmpSpedC420)) {
            return false;
        }
        TmpSpedC420 other = (TmpSpedC420) object;
        if ((this.codtmpSpedC420 == null && other.codtmpSpedC420 != null) || (this.codtmpSpedC420 != null && !this.codtmpSpedC420.equals(other.codtmpSpedC420))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.TmpSpedC420[ codtmpSpedC420=" + codtmpSpedC420 + " ]";
    }
    
}
