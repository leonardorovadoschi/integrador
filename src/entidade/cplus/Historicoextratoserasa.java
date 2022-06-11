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
@Table(name = "HISTORICOEXTRATOSERASA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Historicoextratoserasa.findAll", query = "SELECT h FROM Historicoextratoserasa h")
    , @NamedQuery(name = "Historicoextratoserasa.findByCodhistoricoextratoserasa", query = "SELECT h FROM Historicoextratoserasa h WHERE h.codhistoricoextratoserasa = :codhistoricoextratoserasa")
    , @NamedQuery(name = "Historicoextratoserasa.findByCodusuario", query = "SELECT h FROM Historicoextratoserasa h WHERE h.codusuario = :codusuario")
    , @NamedQuery(name = "Historicoextratoserasa.findByDatahistorico", query = "SELECT h FROM Historicoextratoserasa h WHERE h.datahistorico = :datahistorico")
    , @NamedQuery(name = "Historicoextratoserasa.findByQtde", query = "SELECT h FROM Historicoextratoserasa h WHERE h.qtde = :qtde")
    , @NamedQuery(name = "Historicoextratoserasa.findByValortotal", query = "SELECT h FROM Historicoextratoserasa h WHERE h.valortotal = :valortotal")
    , @NamedQuery(name = "Historicoextratoserasa.findByValorcomissao", query = "SELECT h FROM Historicoextratoserasa h WHERE h.valorcomissao = :valorcomissao")
    , @NamedQuery(name = "Historicoextratoserasa.findByMes", query = "SELECT h FROM Historicoextratoserasa h WHERE h.mes = :mes")
    , @NamedQuery(name = "Historicoextratoserasa.findByAno", query = "SELECT h FROM Historicoextratoserasa h WHERE h.ano = :ano")})
public class Historicoextratoserasa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODHISTORICOEXTRATOSERASA")
    private String codhistoricoextratoserasa;
    @Column(name = "CODUSUARIO")
    private String codusuario;
    @Column(name = "DATAHISTORICO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datahistorico;
    @Column(name = "QTDE")
    private Integer qtde;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALORTOTAL")
    private BigDecimal valortotal;
    @Column(name = "VALORCOMISSAO")
    private BigDecimal valorcomissao;
    @Column(name = "MES")
    private String mes;
    @Column(name = "ANO")
    private String ano;

    public Historicoextratoserasa() {
    }

    public Historicoextratoserasa(String codhistoricoextratoserasa) {
        this.codhistoricoextratoserasa = codhistoricoextratoserasa;
    }

    public String getCodhistoricoextratoserasa() {
        return codhistoricoextratoserasa;
    }

    public void setCodhistoricoextratoserasa(String codhistoricoextratoserasa) {
        this.codhistoricoextratoserasa = codhistoricoextratoserasa;
    }

    public String getCodusuario() {
        return codusuario;
    }

    public void setCodusuario(String codusuario) {
        this.codusuario = codusuario;
    }

    public Date getDatahistorico() {
        return datahistorico;
    }

    public void setDatahistorico(Date datahistorico) {
        this.datahistorico = datahistorico;
    }

    public Integer getQtde() {
        return qtde;
    }

    public void setQtde(Integer qtde) {
        this.qtde = qtde;
    }

    public BigDecimal getValortotal() {
        return valortotal;
    }

    public void setValortotal(BigDecimal valortotal) {
        this.valortotal = valortotal;
    }

    public BigDecimal getValorcomissao() {
        return valorcomissao;
    }

    public void setValorcomissao(BigDecimal valorcomissao) {
        this.valorcomissao = valorcomissao;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codhistoricoextratoserasa != null ? codhistoricoextratoserasa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Historicoextratoserasa)) {
            return false;
        }
        Historicoextratoserasa other = (Historicoextratoserasa) object;
        if ((this.codhistoricoextratoserasa == null && other.codhistoricoextratoserasa != null) || (this.codhistoricoextratoserasa != null && !this.codhistoricoextratoserasa.equals(other.codhistoricoextratoserasa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Historicoextratoserasa[ codhistoricoextratoserasa=" + codhistoricoextratoserasa + " ]";
    }
    
}
