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
@Table(name = "DOCUMENTOITEMPARTILHAICMS", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Documentoitempartilhaicms.findAll", query = "SELECT d FROM Documentoitempartilhaicms d")
    , @NamedQuery(name = "Documentoitempartilhaicms.findByCoddocumentoitempartilhaicms", query = "SELECT d FROM Documentoitempartilhaicms d WHERE d.coddocumentoitempartilhaicms = :coddocumentoitempartilhaicms")
    , @NamedQuery(name = "Documentoitempartilhaicms.findByCoddocumentoitem", query = "SELECT d FROM Documentoitempartilhaicms d WHERE d.coddocumentoitem = :coddocumentoitem")
    , @NamedQuery(name = "Documentoitempartilhaicms.findByBaseicms", query = "SELECT d FROM Documentoitempartilhaicms d WHERE d.baseicms = :baseicms")
    , @NamedQuery(name = "Documentoitempartilhaicms.findByAliqfcp", query = "SELECT d FROM Documentoitempartilhaicms d WHERE d.aliqfcp = :aliqfcp")
    , @NamedQuery(name = "Documentoitempartilhaicms.findByAliqicms", query = "SELECT d FROM Documentoitempartilhaicms d WHERE d.aliqicms = :aliqicms")
    , @NamedQuery(name = "Documentoitempartilhaicms.findByAliqicmsinter", query = "SELECT d FROM Documentoitempartilhaicms d WHERE d.aliqicmsinter = :aliqicmsinter")
    , @NamedQuery(name = "Documentoitempartilhaicms.findByAliqpartilha", query = "SELECT d FROM Documentoitempartilhaicms d WHERE d.aliqpartilha = :aliqpartilha")
    , @NamedQuery(name = "Documentoitempartilhaicms.findByValorfcp", query = "SELECT d FROM Documentoitempartilhaicms d WHERE d.valorfcp = :valorfcp")
    , @NamedQuery(name = "Documentoitempartilhaicms.findByValoricmsdestino", query = "SELECT d FROM Documentoitempartilhaicms d WHERE d.valoricmsdestino = :valoricmsdestino")
    , @NamedQuery(name = "Documentoitempartilhaicms.findByValoricmsorigem", query = "SELECT d FROM Documentoitempartilhaicms d WHERE d.valoricmsorigem = :valoricmsorigem")
    , @NamedQuery(name = "Documentoitempartilhaicms.findByFlagmodificado", query = "SELECT d FROM Documentoitempartilhaicms d WHERE d.flagmodificado = :flagmodificado")
    , @NamedQuery(name = "Documentoitempartilhaicms.findByBaseicmsfcpdestino", query = "SELECT d FROM Documentoitempartilhaicms d WHERE d.baseicmsfcpdestino = :baseicmsfcpdestino")})
public class Documentoitempartilhaicms implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODDOCUMENTOITEMPARTILHAICMS")
    private String coddocumentoitempartilhaicms;
    @Basic(optional = false)
    @Column(name = "CODDOCUMENTOITEM")
    private String coddocumentoitem;
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
    @Column(name = "FLAGMODIFICADO")
    private Character flagmodificado;
    @Column(name = "BASEICMSFCPDESTINO")
    private BigDecimal baseicmsfcpdestino;

    public Documentoitempartilhaicms() {
    }

    public Documentoitempartilhaicms(String coddocumentoitempartilhaicms) {
        this.coddocumentoitempartilhaicms = coddocumentoitempartilhaicms;
    }

    public Documentoitempartilhaicms(String coddocumentoitempartilhaicms, String coddocumentoitem, BigDecimal baseicms, BigDecimal aliqfcp, BigDecimal aliqicms, BigDecimal aliqicmsinter, BigDecimal aliqpartilha, BigDecimal valorfcp, BigDecimal valoricmsdestino, BigDecimal valoricmsorigem) {
        this.coddocumentoitempartilhaicms = coddocumentoitempartilhaicms;
        this.coddocumentoitem = coddocumentoitem;
        this.baseicms = baseicms;
        this.aliqfcp = aliqfcp;
        this.aliqicms = aliqicms;
        this.aliqicmsinter = aliqicmsinter;
        this.aliqpartilha = aliqpartilha;
        this.valorfcp = valorfcp;
        this.valoricmsdestino = valoricmsdestino;
        this.valoricmsorigem = valoricmsorigem;
    }

    public String getCoddocumentoitempartilhaicms() {
        return coddocumentoitempartilhaicms;
    }

    public void setCoddocumentoitempartilhaicms(String coddocumentoitempartilhaicms) {
        this.coddocumentoitempartilhaicms = coddocumentoitempartilhaicms;
    }

    public String getCoddocumentoitem() {
        return coddocumentoitem;
    }

    public void setCoddocumentoitem(String coddocumentoitem) {
        this.coddocumentoitem = coddocumentoitem;
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

    public Character getFlagmodificado() {
        return flagmodificado;
    }

    public void setFlagmodificado(Character flagmodificado) {
        this.flagmodificado = flagmodificado;
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
        hash += (coddocumentoitempartilhaicms != null ? coddocumentoitempartilhaicms.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documentoitempartilhaicms)) {
            return false;
        }
        Documentoitempartilhaicms other = (Documentoitempartilhaicms) object;
        if ((this.coddocumentoitempartilhaicms == null && other.coddocumentoitempartilhaicms != null) || (this.coddocumentoitempartilhaicms != null && !this.coddocumentoitempartilhaicms.equals(other.coddocumentoitempartilhaicms))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Documentoitempartilhaicms[ coddocumentoitempartilhaicms=" + coddocumentoitempartilhaicms + " ]";
    }
    
}
