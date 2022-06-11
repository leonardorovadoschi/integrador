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
@Table(name = "LANCAFINANCEIRA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lancafinanceira.findAll", query = "SELECT l FROM Lancafinanceira l")
    , @NamedQuery(name = "Lancafinanceira.findByCodlfin", query = "SELECT l FROM Lancafinanceira l WHERE l.codlfin = :codlfin")
    , @NamedQuery(name = "Lancafinanceira.findByCodfin", query = "SELECT l FROM Lancafinanceira l WHERE l.codfin = :codfin")
    , @NamedQuery(name = "Lancafinanceira.findByCodpc", query = "SELECT l FROM Lancafinanceira l WHERE l.codpc = :codpc")
    , @NamedQuery(name = "Lancafinanceira.findByCodcr", query = "SELECT l FROM Lancafinanceira l WHERE l.codcr = :codcr")
    , @NamedQuery(name = "Lancafinanceira.findByCodresumofin", query = "SELECT l FROM Lancafinanceira l WHERE l.codresumofin = :codresumofin")
    , @NamedQuery(name = "Lancafinanceira.findByCodmovenda", query = "SELECT l FROM Lancafinanceira l WHERE l.codmovenda = :codmovenda")
    , @NamedQuery(name = "Lancafinanceira.findByValor", query = "SELECT l FROM Lancafinanceira l WHERE l.valor = :valor")
    , @NamedQuery(name = "Lancafinanceira.findByNumparc", query = "SELECT l FROM Lancafinanceira l WHERE l.numparc = :numparc")
    , @NamedQuery(name = "Lancafinanceira.findByDatlan", query = "SELECT l FROM Lancafinanceira l WHERE l.datlan = :datlan")
    , @NamedQuery(name = "Lancafinanceira.findByData", query = "SELECT l FROM Lancafinanceira l WHERE l.data = :data")
    , @NamedQuery(name = "Lancafinanceira.findByAutoriza", query = "SELECT l FROM Lancafinanceira l WHERE l.autoriza = :autoriza")
    , @NamedQuery(name = "Lancafinanceira.findByNumresumo", query = "SELECT l FROM Lancafinanceira l WHERE l.numresumo = :numresumo")
    , @NamedQuery(name = "Lancafinanceira.findByFlaglanc", query = "SELECT l FROM Lancafinanceira l WHERE l.flaglanc = :flaglanc")
    , @NamedQuery(name = "Lancafinanceira.findByFlagresumo", query = "SELECT l FROM Lancafinanceira l WHERE l.flagresumo = :flagresumo")
    , @NamedQuery(name = "Lancafinanceira.findByDatrec", query = "SELECT l FROM Lancafinanceira l WHERE l.datrec = :datrec")
    , @NamedQuery(name = "Lancafinanceira.findByTac", query = "SELECT l FROM Lancafinanceira l WHERE l.tac = :tac")
    , @NamedQuery(name = "Lancafinanceira.findBySeguro", query = "SELECT l FROM Lancafinanceira l WHERE l.seguro = :seguro")})
public class Lancafinanceira implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODLFIN")
    private String codlfin;
    @Basic(optional = false)
    @Column(name = "CODFIN")
    private String codfin;
    @Column(name = "CODPC")
    private String codpc;
    @Column(name = "CODCR")
    private String codcr;
    @Column(name = "CODRESUMOFIN")
    private String codresumofin;
    @Column(name = "CODMOVENDA")
    private String codmovenda;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "VALOR")
    private BigDecimal valor;
    @Column(name = "NUMPARC")
    private Short numparc;
    @Column(name = "DATLAN")
    @Temporal(TemporalType.DATE)
    private Date datlan;
    @Column(name = "DATA")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "AUTORIZA")
    private String autoriza;
    @Column(name = "NUMRESUMO")
    private String numresumo;
    @Column(name = "FLAGLANC")
    private Character flaglanc;
    @Column(name = "FLAGRESUMO")
    private Character flagresumo;
    @Column(name = "DATREC")
    @Temporal(TemporalType.DATE)
    private Date datrec;
    @Column(name = "TAC")
    private BigDecimal tac;
    @Column(name = "SEGURO")
    private BigDecimal seguro;
    @JoinColumn(name = "CODCLI", referencedColumnName = "CODCLI")
    @ManyToOne
    private Cliente codcli;
    @JoinColumn(name = "CODEMPRESA", referencedColumnName = "CODEMPRESA")
    @ManyToOne(optional = false)
    private Empresa codempresa;

    public Lancafinanceira() {
    }

    public Lancafinanceira(String codlfin) {
        this.codlfin = codlfin;
    }

    public Lancafinanceira(String codlfin, String codfin, BigDecimal valor) {
        this.codlfin = codlfin;
        this.codfin = codfin;
        this.valor = valor;
    }

    public String getCodlfin() {
        return codlfin;
    }

    public void setCodlfin(String codlfin) {
        this.codlfin = codlfin;
    }

    public String getCodfin() {
        return codfin;
    }

    public void setCodfin(String codfin) {
        this.codfin = codfin;
    }

    public String getCodpc() {
        return codpc;
    }

    public void setCodpc(String codpc) {
        this.codpc = codpc;
    }

    public String getCodcr() {
        return codcr;
    }

    public void setCodcr(String codcr) {
        this.codcr = codcr;
    }

    public String getCodresumofin() {
        return codresumofin;
    }

    public void setCodresumofin(String codresumofin) {
        this.codresumofin = codresumofin;
    }

    public String getCodmovenda() {
        return codmovenda;
    }

    public void setCodmovenda(String codmovenda) {
        this.codmovenda = codmovenda;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Short getNumparc() {
        return numparc;
    }

    public void setNumparc(Short numparc) {
        this.numparc = numparc;
    }

    public Date getDatlan() {
        return datlan;
    }

    public void setDatlan(Date datlan) {
        this.datlan = datlan;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getAutoriza() {
        return autoriza;
    }

    public void setAutoriza(String autoriza) {
        this.autoriza = autoriza;
    }

    public String getNumresumo() {
        return numresumo;
    }

    public void setNumresumo(String numresumo) {
        this.numresumo = numresumo;
    }

    public Character getFlaglanc() {
        return flaglanc;
    }

    public void setFlaglanc(Character flaglanc) {
        this.flaglanc = flaglanc;
    }

    public Character getFlagresumo() {
        return flagresumo;
    }

    public void setFlagresumo(Character flagresumo) {
        this.flagresumo = flagresumo;
    }

    public Date getDatrec() {
        return datrec;
    }

    public void setDatrec(Date datrec) {
        this.datrec = datrec;
    }

    public BigDecimal getTac() {
        return tac;
    }

    public void setTac(BigDecimal tac) {
        this.tac = tac;
    }

    public BigDecimal getSeguro() {
        return seguro;
    }

    public void setSeguro(BigDecimal seguro) {
        this.seguro = seguro;
    }

    public Cliente getCodcli() {
        return codcli;
    }

    public void setCodcli(Cliente codcli) {
        this.codcli = codcli;
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
        hash += (codlfin != null ? codlfin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lancafinanceira)) {
            return false;
        }
        Lancafinanceira other = (Lancafinanceira) object;
        if ((this.codlfin == null && other.codlfin != null) || (this.codlfin != null && !this.codlfin.equals(other.codlfin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Lancafinanceira[ codlfin=" + codlfin + " ]";
    }
    
}
