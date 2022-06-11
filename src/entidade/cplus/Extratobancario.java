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
@Table(name = "EXTRATOBANCARIO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Extratobancario.findAll", query = "SELECT e FROM Extratobancario e")
    , @NamedQuery(name = "Extratobancario.findByCodextratobancario", query = "SELECT e FROM Extratobancario e WHERE e.codextratobancario = :codextratobancario")
    , @NamedQuery(name = "Extratobancario.findByCodempresa", query = "SELECT e FROM Extratobancario e WHERE e.codempresa = :codempresa")
    , @NamedQuery(name = "Extratobancario.findByDatamovimento", query = "SELECT e FROM Extratobancario e WHERE e.datamovimento = :datamovimento")
    , @NamedQuery(name = "Extratobancario.findByValormovimento", query = "SELECT e FROM Extratobancario e WHERE e.valormovimento = :valormovimento")
    , @NamedQuery(name = "Extratobancario.findByDescricaomovimento", query = "SELECT e FROM Extratobancario e WHERE e.descricaomovimento = :descricaomovimento")
    , @NamedQuery(name = "Extratobancario.findByFlagtipomovimento", query = "SELECT e FROM Extratobancario e WHERE e.flagtipomovimento = :flagtipomovimento")
    , @NamedQuery(name = "Extratobancario.findByCodcontabancaria", query = "SELECT e FROM Extratobancario e WHERE e.codcontabancaria = :codcontabancaria")
    , @NamedQuery(name = "Extratobancario.findByFlagdesprezado", query = "SELECT e FROM Extratobancario e WHERE e.flagdesprezado = :flagdesprezado")
    , @NamedQuery(name = "Extratobancario.findByFlagconciliado", query = "SELECT e FROM Extratobancario e WHERE e.flagconciliado = :flagconciliado")
    , @NamedQuery(name = "Extratobancario.findByFitid", query = "SELECT e FROM Extratobancario e WHERE e.fitid = :fitid")
    , @NamedQuery(name = "Extratobancario.findByCodpessoa", query = "SELECT e FROM Extratobancario e WHERE e.codpessoa = :codpessoa")
    , @NamedQuery(name = "Extratobancario.findByNomeentidadepessoa", query = "SELECT e FROM Extratobancario e WHERE e.nomeentidadepessoa = :nomeentidadepessoa")
    , @NamedQuery(name = "Extratobancario.findByNumerodocumento", query = "SELECT e FROM Extratobancario e WHERE e.numerodocumento = :numerodocumento")})
public class Extratobancario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODEXTRATOBANCARIO")
    private String codextratobancario;
    @Column(name = "CODEMPRESA")
    private Integer codempresa;
    @Column(name = "DATAMOVIMENTO")
    @Temporal(TemporalType.DATE)
    private Date datamovimento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALORMOVIMENTO")
    private BigDecimal valormovimento;
    @Column(name = "DESCRICAOMOVIMENTO")
    private String descricaomovimento;
    @Column(name = "FLAGTIPOMOVIMENTO")
    private Character flagtipomovimento;
    @Column(name = "CODCONTABANCARIA")
    private String codcontabancaria;
    @Column(name = "FLAGDESPREZADO")
    private Character flagdesprezado;
    @Column(name = "FLAGCONCILIADO")
    private Character flagconciliado;
    @Column(name = "FITID")
    private String fitid;
    @Column(name = "CODPESSOA")
    private String codpessoa;
    @Column(name = "NOMEENTIDADEPESSOA")
    private String nomeentidadepessoa;
    @Column(name = "NUMERODOCUMENTO")
    private String numerodocumento;

    public Extratobancario() {
    }

    public Extratobancario(String codextratobancario) {
        this.codextratobancario = codextratobancario;
    }

    public String getCodextratobancario() {
        return codextratobancario;
    }

    public void setCodextratobancario(String codextratobancario) {
        this.codextratobancario = codextratobancario;
    }

    public Integer getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Integer codempresa) {
        this.codempresa = codempresa;
    }

    public Date getDatamovimento() {
        return datamovimento;
    }

    public void setDatamovimento(Date datamovimento) {
        this.datamovimento = datamovimento;
    }

    public BigDecimal getValormovimento() {
        return valormovimento;
    }

    public void setValormovimento(BigDecimal valormovimento) {
        this.valormovimento = valormovimento;
    }

    public String getDescricaomovimento() {
        return descricaomovimento;
    }

    public void setDescricaomovimento(String descricaomovimento) {
        this.descricaomovimento = descricaomovimento;
    }

    public Character getFlagtipomovimento() {
        return flagtipomovimento;
    }

    public void setFlagtipomovimento(Character flagtipomovimento) {
        this.flagtipomovimento = flagtipomovimento;
    }

    public String getCodcontabancaria() {
        return codcontabancaria;
    }

    public void setCodcontabancaria(String codcontabancaria) {
        this.codcontabancaria = codcontabancaria;
    }

    public Character getFlagdesprezado() {
        return flagdesprezado;
    }

    public void setFlagdesprezado(Character flagdesprezado) {
        this.flagdesprezado = flagdesprezado;
    }

    public Character getFlagconciliado() {
        return flagconciliado;
    }

    public void setFlagconciliado(Character flagconciliado) {
        this.flagconciliado = flagconciliado;
    }

    public String getFitid() {
        return fitid;
    }

    public void setFitid(String fitid) {
        this.fitid = fitid;
    }

    public String getCodpessoa() {
        return codpessoa;
    }

    public void setCodpessoa(String codpessoa) {
        this.codpessoa = codpessoa;
    }

    public String getNomeentidadepessoa() {
        return nomeentidadepessoa;
    }

    public void setNomeentidadepessoa(String nomeentidadepessoa) {
        this.nomeentidadepessoa = nomeentidadepessoa;
    }

    public String getNumerodocumento() {
        return numerodocumento;
    }

    public void setNumerodocumento(String numerodocumento) {
        this.numerodocumento = numerodocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codextratobancario != null ? codextratobancario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Extratobancario)) {
            return false;
        }
        Extratobancario other = (Extratobancario) object;
        if ((this.codextratobancario == null && other.codextratobancario != null) || (this.codextratobancario != null && !this.codextratobancario.equals(other.codextratobancario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Extratobancario[ codextratobancario=" + codextratobancario + " ]";
    }
    
}
