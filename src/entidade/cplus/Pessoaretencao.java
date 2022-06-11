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
@Table(name = "PESSOARETENCAO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pessoaretencao.findAll", query = "SELECT p FROM Pessoaretencao p")
    , @NamedQuery(name = "Pessoaretencao.findByCodpessoaretencao", query = "SELECT p FROM Pessoaretencao p WHERE p.codpessoaretencao = :codpessoaretencao")
    , @NamedQuery(name = "Pessoaretencao.findByCodempresa", query = "SELECT p FROM Pessoaretencao p WHERE p.codempresa = :codempresa")
    , @NamedQuery(name = "Pessoaretencao.findByIdentidadepessoa", query = "SELECT p FROM Pessoaretencao p WHERE p.identidadepessoa = :identidadepessoa")
    , @NamedQuery(name = "Pessoaretencao.findByNomeentidadepessoa", query = "SELECT p FROM Pessoaretencao p WHERE p.nomeentidadepessoa = :nomeentidadepessoa")
    , @NamedQuery(name = "Pessoaretencao.findByData", query = "SELECT p FROM Pessoaretencao p WHERE p.data = :data")
    , @NamedQuery(name = "Pessoaretencao.findByValorbaseretencao", query = "SELECT p FROM Pessoaretencao p WHERE p.valorbaseretencao = :valorbaseretencao")
    , @NamedQuery(name = "Pessoaretencao.findByAliqpis", query = "SELECT p FROM Pessoaretencao p WHERE p.aliqpis = :aliqpis")
    , @NamedQuery(name = "Pessoaretencao.findByValorpis", query = "SELECT p FROM Pessoaretencao p WHERE p.valorpis = :valorpis")
    , @NamedQuery(name = "Pessoaretencao.findByAliqcofins", query = "SELECT p FROM Pessoaretencao p WHERE p.aliqcofins = :aliqcofins")
    , @NamedQuery(name = "Pessoaretencao.findByValorcofins", query = "SELECT p FROM Pessoaretencao p WHERE p.valorcofins = :valorcofins")
    , @NamedQuery(name = "Pessoaretencao.findByAliqcsll", query = "SELECT p FROM Pessoaretencao p WHERE p.aliqcsll = :aliqcsll")
    , @NamedQuery(name = "Pessoaretencao.findByValorcsll", query = "SELECT p FROM Pessoaretencao p WHERE p.valorcsll = :valorcsll")
    , @NamedQuery(name = "Pessoaretencao.findByCoddocumento", query = "SELECT p FROM Pessoaretencao p WHERE p.coddocumento = :coddocumento")})
public class Pessoaretencao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODPESSOARETENCAO")
    private String codpessoaretencao;
    @Column(name = "CODEMPRESA")
    private Integer codempresa;
    @Column(name = "IDENTIDADEPESSOA")
    private String identidadepessoa;
    @Column(name = "NOMEENTIDADEPESSOA")
    private String nomeentidadepessoa;
    @Column(name = "DATA")
    @Temporal(TemporalType.DATE)
    private Date data;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALORBASERETENCAO")
    private BigDecimal valorbaseretencao;
    @Column(name = "ALIQPIS")
    private BigDecimal aliqpis;
    @Column(name = "VALORPIS")
    private BigDecimal valorpis;
    @Column(name = "ALIQCOFINS")
    private BigDecimal aliqcofins;
    @Column(name = "VALORCOFINS")
    private Integer valorcofins;
    @Column(name = "ALIQCSLL")
    private BigDecimal aliqcsll;
    @Column(name = "VALORCSLL")
    private BigDecimal valorcsll;
    @Column(name = "CODDOCUMENTO")
    private BigDecimal coddocumento;

    public Pessoaretencao() {
    }

    public Pessoaretencao(String codpessoaretencao) {
        this.codpessoaretencao = codpessoaretencao;
    }

    public String getCodpessoaretencao() {
        return codpessoaretencao;
    }

    public void setCodpessoaretencao(String codpessoaretencao) {
        this.codpessoaretencao = codpessoaretencao;
    }

    public Integer getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Integer codempresa) {
        this.codempresa = codempresa;
    }

    public String getIdentidadepessoa() {
        return identidadepessoa;
    }

    public void setIdentidadepessoa(String identidadepessoa) {
        this.identidadepessoa = identidadepessoa;
    }

    public String getNomeentidadepessoa() {
        return nomeentidadepessoa;
    }

    public void setNomeentidadepessoa(String nomeentidadepessoa) {
        this.nomeentidadepessoa = nomeentidadepessoa;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public BigDecimal getValorbaseretencao() {
        return valorbaseretencao;
    }

    public void setValorbaseretencao(BigDecimal valorbaseretencao) {
        this.valorbaseretencao = valorbaseretencao;
    }

    public BigDecimal getAliqpis() {
        return aliqpis;
    }

    public void setAliqpis(BigDecimal aliqpis) {
        this.aliqpis = aliqpis;
    }

    public BigDecimal getValorpis() {
        return valorpis;
    }

    public void setValorpis(BigDecimal valorpis) {
        this.valorpis = valorpis;
    }

    public BigDecimal getAliqcofins() {
        return aliqcofins;
    }

    public void setAliqcofins(BigDecimal aliqcofins) {
        this.aliqcofins = aliqcofins;
    }

    public Integer getValorcofins() {
        return valorcofins;
    }

    public void setValorcofins(Integer valorcofins) {
        this.valorcofins = valorcofins;
    }

    public BigDecimal getAliqcsll() {
        return aliqcsll;
    }

    public void setAliqcsll(BigDecimal aliqcsll) {
        this.aliqcsll = aliqcsll;
    }

    public BigDecimal getValorcsll() {
        return valorcsll;
    }

    public void setValorcsll(BigDecimal valorcsll) {
        this.valorcsll = valorcsll;
    }

    public BigDecimal getCoddocumento() {
        return coddocumento;
    }

    public void setCoddocumento(BigDecimal coddocumento) {
        this.coddocumento = coddocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codpessoaretencao != null ? codpessoaretencao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pessoaretencao)) {
            return false;
        }
        Pessoaretencao other = (Pessoaretencao) object;
        if ((this.codpessoaretencao == null && other.codpessoaretencao != null) || (this.codpessoaretencao != null && !this.codpessoaretencao.equals(other.codpessoaretencao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Pessoaretencao[ codpessoaretencao=" + codpessoaretencao + " ]";
    }
    
}
