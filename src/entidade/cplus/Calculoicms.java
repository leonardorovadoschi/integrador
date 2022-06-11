/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "CALCULOICMS", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calculoicms.findAll", query = "SELECT c FROM Calculoicms c")
    , @NamedQuery(name = "Calculoicms.findByCodcalculoicms", query = "SELECT c FROM Calculoicms c WHERE c.codcalculoicms = :codcalculoicms")
    , @NamedQuery(name = "Calculoicms.findByCodigo", query = "SELECT c FROM Calculoicms c WHERE c.codigo = :codigo")
    , @NamedQuery(name = "Calculoicms.findByNomecalculoicms", query = "SELECT c FROM Calculoicms c WHERE c.nomecalculoicms = :nomecalculoicms")
    , @NamedQuery(name = "Calculoicms.findByClassificacao", query = "SELECT c FROM Calculoicms c WHERE c.classificacao = :classificacao")})
public class Calculoicms implements Serializable {

    @Column(name = "GUID")
    private String guid;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCALCULOICMS")
    private String codcalculoicms;
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "NOMECALCULOICMS")
    private String nomecalculoicms;
    @Column(name = "CLASSIFICACAO")
    private String classificacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codcalculoicms")
    private Collection<Calculoicmsestado> calculoicmsestadoCollection;
    @OneToMany(mappedBy = "codcalculoicms")
    private Collection<Produto> produtoCollection;

    public Calculoicms() {
    }

    public Calculoicms(String codcalculoicms) {
        this.codcalculoicms = codcalculoicms;
    }

    public Calculoicms(String codcalculoicms, String codigo) {
        this.codcalculoicms = codcalculoicms;
        this.codigo = codigo;
    }

    public String getCodcalculoicms() {
        return codcalculoicms;
    }

    public void setCodcalculoicms(String codcalculoicms) {
        this.codcalculoicms = codcalculoicms;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomecalculoicms() {
        return nomecalculoicms;
    }

    public void setNomecalculoicms(String nomecalculoicms) {
        this.nomecalculoicms = nomecalculoicms;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    @XmlTransient
    public Collection<Calculoicmsestado> getCalculoicmsestadoCollection() {
        return calculoicmsestadoCollection;
    }

    public void setCalculoicmsestadoCollection(Collection<Calculoicmsestado> calculoicmsestadoCollection) {
        this.calculoicmsestadoCollection = calculoicmsestadoCollection;
    }

    @XmlTransient
    public Collection<Produto> getProdutoCollection() {
        return produtoCollection;
    }

    public void setProdutoCollection(Collection<Produto> produtoCollection) {
        this.produtoCollection = produtoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcalculoicms != null ? codcalculoicms.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calculoicms)) {
            return false;
        }
        Calculoicms other = (Calculoicms) object;
        if ((this.codcalculoicms == null && other.codcalculoicms != null) || (this.codcalculoicms != null && !this.codcalculoicms.equals(other.codcalculoicms))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Calculoicms[ codcalculoicms=" + codcalculoicms + " ]";
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }
    
}
