/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "MOTIVODESONERACAO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Motivodesoneracao.findAll", query = "SELECT m FROM Motivodesoneracao m")
    , @NamedQuery(name = "Motivodesoneracao.findByCodigomotivo", query = "SELECT m FROM Motivodesoneracao m WHERE m.codigomotivo = :codigomotivo")
    , @NamedQuery(name = "Motivodesoneracao.findByCodigo", query = "SELECT m FROM Motivodesoneracao m WHERE m.codigo = :codigo")
    , @NamedQuery(name = "Motivodesoneracao.findByDescricao", query = "SELECT m FROM Motivodesoneracao m WHERE m.descricao = :descricao")
    , @NamedQuery(name = "Motivodesoneracao.findByCodsituacaotributaria", query = "SELECT m FROM Motivodesoneracao m WHERE m.codsituacaotributaria = :codsituacaotributaria")})
public class Motivodesoneracao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODIGOMOTIVO")
    private String codigomotivo;
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "DESCRICAO")
    private String descricao;
    @Column(name = "CODSITUACAOTRIBUTARIA")
    private String codsituacaotributaria;
    @OneToMany(mappedBy = "codigomotivodeso")
    private Collection<Calculoicmsestado> calculoicmsestadoCollection;
    @OneToMany(mappedBy = "codigomotivodesodif")
    private Collection<Calculoicmsestado> calculoicmsestadoCollection1;

    public Motivodesoneracao() {
    }

    public Motivodesoneracao(String codigomotivo) {
        this.codigomotivo = codigomotivo;
    }

    public String getCodigomotivo() {
        return codigomotivo;
    }

    public void setCodigomotivo(String codigomotivo) {
        this.codigomotivo = codigomotivo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodsituacaotributaria() {
        return codsituacaotributaria;
    }

    public void setCodsituacaotributaria(String codsituacaotributaria) {
        this.codsituacaotributaria = codsituacaotributaria;
    }

    @XmlTransient
    public Collection<Calculoicmsestado> getCalculoicmsestadoCollection() {
        return calculoicmsestadoCollection;
    }

    public void setCalculoicmsestadoCollection(Collection<Calculoicmsestado> calculoicmsestadoCollection) {
        this.calculoicmsestadoCollection = calculoicmsestadoCollection;
    }

    @XmlTransient
    public Collection<Calculoicmsestado> getCalculoicmsestadoCollection1() {
        return calculoicmsestadoCollection1;
    }

    public void setCalculoicmsestadoCollection1(Collection<Calculoicmsestado> calculoicmsestadoCollection1) {
        this.calculoicmsestadoCollection1 = calculoicmsestadoCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigomotivo != null ? codigomotivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Motivodesoneracao)) {
            return false;
        }
        Motivodesoneracao other = (Motivodesoneracao) object;
        if ((this.codigomotivo == null && other.codigomotivo != null) || (this.codigomotivo != null && !this.codigomotivo.equals(other.codigomotivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Motivodesoneracao[ codigomotivo=" + codigomotivo + " ]";
    }
    
}
