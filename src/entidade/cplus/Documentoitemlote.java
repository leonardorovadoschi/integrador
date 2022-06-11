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
@Table(name = "DOCUMENTOITEMLOTE", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Documentoitemlote.findAll", query = "SELECT d FROM Documentoitemlote d")
    , @NamedQuery(name = "Documentoitemlote.findByCoddocumentoitemlote", query = "SELECT d FROM Documentoitemlote d WHERE d.coddocumentoitemlote = :coddocumentoitemlote")
    , @NamedQuery(name = "Documentoitemlote.findByCoddocumento", query = "SELECT d FROM Documentoitemlote d WHERE d.coddocumento = :coddocumento")
    , @NamedQuery(name = "Documentoitemlote.findByLote", query = "SELECT d FROM Documentoitemlote d WHERE d.lote = :lote")
    , @NamedQuery(name = "Documentoitemlote.findByQuantidade", query = "SELECT d FROM Documentoitemlote d WHERE d.quantidade = :quantidade")
    , @NamedQuery(name = "Documentoitemlote.findByDatafabricacao", query = "SELECT d FROM Documentoitemlote d WHERE d.datafabricacao = :datafabricacao")
    , @NamedQuery(name = "Documentoitemlote.findByDatavalidade", query = "SELECT d FROM Documentoitemlote d WHERE d.datavalidade = :datavalidade")
    , @NamedQuery(name = "Documentoitemlote.findByPmc", query = "SELECT d FROM Documentoitemlote d WHERE d.pmc = :pmc")
    , @NamedQuery(name = "Documentoitemlote.findByCodigoanvisa", query = "SELECT d FROM Documentoitemlote d WHERE d.codigoanvisa = :codigoanvisa")})
public class Documentoitemlote implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODDOCUMENTOITEMLOTE")
    private String coddocumentoitemlote;
    @Basic(optional = false)
    @Column(name = "CODDOCUMENTO")
    private String coddocumento;
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
    @JoinColumn(name = "CODDOCUMENTOITEM", referencedColumnName = "CODDOCUMENTOITEM")
    @ManyToOne(optional = false)
    private Documentoitem coddocumentoitem;

    public Documentoitemlote() {
    }

    public Documentoitemlote(String coddocumentoitemlote) {
        this.coddocumentoitemlote = coddocumentoitemlote;
    }

    public Documentoitemlote(String coddocumentoitemlote, String coddocumento) {
        this.coddocumentoitemlote = coddocumentoitemlote;
        this.coddocumento = coddocumento;
    }

    public String getCoddocumentoitemlote() {
        return coddocumentoitemlote;
    }

    public void setCoddocumentoitemlote(String coddocumentoitemlote) {
        this.coddocumentoitemlote = coddocumentoitemlote;
    }

    public String getCoddocumento() {
        return coddocumento;
    }

    public void setCoddocumento(String coddocumento) {
        this.coddocumento = coddocumento;
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

    public Documentoitem getCoddocumentoitem() {
        return coddocumentoitem;
    }

    public void setCoddocumentoitem(Documentoitem coddocumentoitem) {
        this.coddocumentoitem = coddocumentoitem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coddocumentoitemlote != null ? coddocumentoitemlote.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documentoitemlote)) {
            return false;
        }
        Documentoitemlote other = (Documentoitemlote) object;
        if ((this.coddocumentoitemlote == null && other.coddocumentoitemlote != null) || (this.coddocumentoitemlote != null && !this.coddocumentoitemlote.equals(other.coddocumentoitemlote))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Documentoitemlote[ coddocumentoitemlote=" + coddocumentoitemlote + " ]";
    }
    
}
