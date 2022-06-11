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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "CONTAPAGARPAG", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contapagarpag.findAll", query = "SELECT c FROM Contapagarpag c")
    , @NamedQuery(name = "Contapagarpag.findById", query = "SELECT c FROM Contapagarpag c WHERE c.id = :id")
    , @NamedQuery(name = "Contapagarpag.findByValor", query = "SELECT c FROM Contapagarpag c WHERE c.valor = :valor")
    , @NamedQuery(name = "Contapagarpag.findByData", query = "SELECT c FROM Contapagarpag c WHERE c.data = :data")
    , @NamedQuery(name = "Contapagarpag.findByTipo", query = "SELECT c FROM Contapagarpag c WHERE c.tipo = :tipo")
    , @NamedQuery(name = "Contapagarpag.findByLote", query = "SELECT c FROM Contapagarpag c WHERE c.lote = :lote")})
public class Contapagarpag implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALOR")
    private BigDecimal valor;
    @Column(name = "DATA")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "TIPO")
    private String tipo;
    @Column(name = "LOTE")
    private Integer lote;
    @JoinColumn(name = "CODCAIXA", referencedColumnName = "CODCAIXA")
    @ManyToOne
    private Caixa codcaixa;
    @JoinColumn(name = "CODCHEQUEFIRMA", referencedColumnName = "CODCHEQUEFIRMA")
    @ManyToOne
    private Chequesfirma codchequefirma;
    @JoinColumn(name = "CODCONTABANCARIA", referencedColumnName = "CODCONTABANCARIA")
    @ManyToOne
    private Contabancaria codcontabancaria;
    @JoinColumn(name = "CODCP", referencedColumnName = "CODCP")
    @ManyToOne
    private Contapagar codcp;
    @JoinColumn(name = "CODEMPRESA", referencedColumnName = "CODEMPRESA")
    @ManyToOne(optional = false)
    private Empresa codempresa;

    public Contapagarpag() {
    }

    public Contapagarpag(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getLote() {
        return lote;
    }

    public void setLote(Integer lote) {
        this.lote = lote;
    }

    public Caixa getCodcaixa() {
        return codcaixa;
    }

    public void setCodcaixa(Caixa codcaixa) {
        this.codcaixa = codcaixa;
    }

    public Chequesfirma getCodchequefirma() {
        return codchequefirma;
    }

    public void setCodchequefirma(Chequesfirma codchequefirma) {
        this.codchequefirma = codchequefirma;
    }

    public Contabancaria getCodcontabancaria() {
        return codcontabancaria;
    }

    public void setCodcontabancaria(Contabancaria codcontabancaria) {
        this.codcontabancaria = codcontabancaria;
    }

    public Contapagar getCodcp() {
        return codcp;
    }

    public void setCodcp(Contapagar codcp) {
        this.codcp = codcp;
    }

    public Empresa getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Empresa codempresa) {
        this.codempresa = codempresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contapagarpag)) {
            return false;
        }
        Contapagarpag other = (Contapagarpag) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Contapagarpag[ id=" + id + " ]";
    }
    
}
