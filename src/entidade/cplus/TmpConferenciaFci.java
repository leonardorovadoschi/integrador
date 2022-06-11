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
@Table(name = "TMP_CONFERENCIA_FCI", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TmpConferenciaFci.findAll", query = "SELECT t FROM TmpConferenciaFci t")
    , @NamedQuery(name = "TmpConferenciaFci.findByCodtmpConferencia", query = "SELECT t FROM TmpConferenciaFci t WHERE t.codtmpConferencia = :codtmpConferencia")
    , @NamedQuery(name = "TmpConferenciaFci.findByCodprod", query = "SELECT t FROM TmpConferenciaFci t WHERE t.codprod = :codprod")
    , @NamedQuery(name = "TmpConferenciaFci.findByEstatu", query = "SELECT t FROM TmpConferenciaFci t WHERE t.estatu = :estatu")
    , @NamedQuery(name = "TmpConferenciaFci.findByQuantidade", query = "SELECT t FROM TmpConferenciaFci t WHERE t.quantidade = :quantidade")
    , @NamedQuery(name = "TmpConferenciaFci.findByFci", query = "SELECT t FROM TmpConferenciaFci t WHERE t.fci = :fci")
    , @NamedQuery(name = "TmpConferenciaFci.findByDataentrada", query = "SELECT t FROM TmpConferenciaFci t WHERE t.dataentrada = :dataentrada")})
public class TmpConferenciaFci implements Serializable {

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
    @Column(name = "FCI")
    private String fci;
    @Column(name = "DATAENTRADA")
    @Temporal(TemporalType.DATE)
    private Date dataentrada;

    public TmpConferenciaFci() {
    }

    public TmpConferenciaFci(Integer codtmpConferencia) {
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

    public String getFci() {
        return fci;
    }

    public void setFci(String fci) {
        this.fci = fci;
    }

    public Date getDataentrada() {
        return dataentrada;
    }

    public void setDataentrada(Date dataentrada) {
        this.dataentrada = dataentrada;
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
        if (!(object instanceof TmpConferenciaFci)) {
            return false;
        }
        TmpConferenciaFci other = (TmpConferenciaFci) object;
        if ((this.codtmpConferencia == null && other.codtmpConferencia != null) || (this.codtmpConferencia != null && !this.codtmpConferencia.equals(other.codtmpConferencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.TmpConferenciaFci[ codtmpConferencia=" + codtmpConferencia + " ]";
    }
    
}
