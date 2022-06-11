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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "DOCUMENTOPAGAMENTO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Documentopagamento.findAll", query = "SELECT d FROM Documentopagamento d")
    , @NamedQuery(name = "Documentopagamento.findByCoddocumentopagamento", query = "SELECT d FROM Documentopagamento d WHERE d.coddocumentopagamento = :coddocumentopagamento")
    , @NamedQuery(name = "Documentopagamento.findByFlagtipopagamento", query = "SELECT d FROM Documentopagamento d WHERE d.flagtipopagamento = :flagtipopagamento")
    , @NamedQuery(name = "Documentopagamento.findByCodmeiopagamento", query = "SELECT d FROM Documentopagamento d WHERE d.codmeiopagamento = :codmeiopagamento")
    , @NamedQuery(name = "Documentopagamento.findByValorpagamento", query = "SELECT d FROM Documentopagamento d WHERE d.valorpagamento = :valorpagamento")
    , @NamedQuery(name = "Documentopagamento.findByFlagintegracaocartao", query = "SELECT d FROM Documentopagamento d WHERE d.flagintegracaocartao = :flagintegracaocartao")
    , @NamedQuery(name = "Documentopagamento.findByCnpjcredenciadoracartao", query = "SELECT d FROM Documentopagamento d WHERE d.cnpjcredenciadoracartao = :cnpjcredenciadoracartao")
    , @NamedQuery(name = "Documentopagamento.findByCodbandeiracartao", query = "SELECT d FROM Documentopagamento d WHERE d.codbandeiracartao = :codbandeiracartao")
    , @NamedQuery(name = "Documentopagamento.findByNumeroautorizacaocartao", query = "SELECT d FROM Documentopagamento d WHERE d.numeroautorizacaocartao = :numeroautorizacaocartao")
    , @NamedQuery(name = "Documentopagamento.findByFlagtipo", query = "SELECT d FROM Documentopagamento d WHERE d.flagtipo = :flagtipo")})
public class Documentopagamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODDOCUMENTOPAGAMENTO")
    private String coddocumentopagamento;
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
    @JoinColumn(name = "CODDOCUMENTO", referencedColumnName = "CODDOCUMENTO")
    @ManyToOne(optional = false)
    private Documento coddocumento;

    public Documentopagamento() {
    }

    public Documentopagamento(String coddocumentopagamento) {
        this.coddocumentopagamento = coddocumentopagamento;
    }

    public String getCoddocumentopagamento() {
        return coddocumentopagamento;
    }

    public void setCoddocumentopagamento(String coddocumentopagamento) {
        this.coddocumentopagamento = coddocumentopagamento;
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

    public Documento getCoddocumento() {
        return coddocumento;
    }

    public void setCoddocumento(Documento coddocumento) {
        this.coddocumento = coddocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coddocumentopagamento != null ? coddocumentopagamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documentopagamento)) {
            return false;
        }
        Documentopagamento other = (Documentopagamento) object;
        if ((this.coddocumentopagamento == null && other.coddocumentopagamento != null) || (this.coddocumentopagamento != null && !this.coddocumentopagamento.equals(other.coddocumentopagamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Documentopagamento[ coddocumentopagamento=" + coddocumentopagamento + " ]";
    }
    
}
