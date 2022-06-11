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
@Table(name = "SISTEMA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sistema.findAll", query = "SELECT s FROM Sistema s")
    , @NamedQuery(name = "Sistema.findByCodsistema", query = "SELECT s FROM Sistema s WHERE s.codsistema = :codsistema")
    , @NamedQuery(name = "Sistema.findByNomesistema", query = "SELECT s FROM Sistema s WHERE s.nomesistema = :nomesistema")
    , @NamedQuery(name = "Sistema.findByArquivo", query = "SELECT s FROM Sistema s WHERE s.arquivo = :arquivo")
    , @NamedQuery(name = "Sistema.findByUltimaversao", query = "SELECT s FROM Sistema s WHERE s.ultimaversao = :ultimaversao")
    , @NamedQuery(name = "Sistema.findByFlagbloqueiaversao", query = "SELECT s FROM Sistema s WHERE s.flagbloqueiaversao = :flagbloqueiaversao")})
public class Sistema implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODSISTEMA")
    private String codsistema;
    @Column(name = "NOMESISTEMA")
    private String nomesistema;
    @Column(name = "ARQUIVO")
    private String arquivo;
    @Column(name = "ULTIMAVERSAO")
    private String ultimaversao;
    @Column(name = "FLAGBLOQUEIAVERSAO")
    private Character flagbloqueiaversao;
    @OneToMany(mappedBy = "codsistema")
    private Collection<Cfgcenariogrid> cfgcenariogridCollection;
    @OneToMany(mappedBy = "codsistema")
    private Collection<Sistemaacesso> sistemaacessoCollection;
    @OneToMany(mappedBy = "codsistema")
    private Collection<Caixausuario> caixausuarioCollection;
    @OneToMany(mappedBy = "codsistema")
    private Collection<Relatorio> relatorioCollection;

    public Sistema() {
    }

    public Sistema(String codsistema) {
        this.codsistema = codsistema;
    }

    public String getCodsistema() {
        return codsistema;
    }

    public void setCodsistema(String codsistema) {
        this.codsistema = codsistema;
    }

    public String getNomesistema() {
        return nomesistema;
    }

    public void setNomesistema(String nomesistema) {
        this.nomesistema = nomesistema;
    }

    public String getArquivo() {
        return arquivo;
    }

    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
    }

    public String getUltimaversao() {
        return ultimaversao;
    }

    public void setUltimaversao(String ultimaversao) {
        this.ultimaversao = ultimaversao;
    }

    public Character getFlagbloqueiaversao() {
        return flagbloqueiaversao;
    }

    public void setFlagbloqueiaversao(Character flagbloqueiaversao) {
        this.flagbloqueiaversao = flagbloqueiaversao;
    }

    @XmlTransient
    public Collection<Cfgcenariogrid> getCfgcenariogridCollection() {
        return cfgcenariogridCollection;
    }

    public void setCfgcenariogridCollection(Collection<Cfgcenariogrid> cfgcenariogridCollection) {
        this.cfgcenariogridCollection = cfgcenariogridCollection;
    }

    @XmlTransient
    public Collection<Sistemaacesso> getSistemaacessoCollection() {
        return sistemaacessoCollection;
    }

    public void setSistemaacessoCollection(Collection<Sistemaacesso> sistemaacessoCollection) {
        this.sistemaacessoCollection = sistemaacessoCollection;
    }

    @XmlTransient
    public Collection<Caixausuario> getCaixausuarioCollection() {
        return caixausuarioCollection;
    }

    public void setCaixausuarioCollection(Collection<Caixausuario> caixausuarioCollection) {
        this.caixausuarioCollection = caixausuarioCollection;
    }

    @XmlTransient
    public Collection<Relatorio> getRelatorioCollection() {
        return relatorioCollection;
    }

    public void setRelatorioCollection(Collection<Relatorio> relatorioCollection) {
        this.relatorioCollection = relatorioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codsistema != null ? codsistema.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sistema)) {
            return false;
        }
        Sistema other = (Sistema) object;
        if ((this.codsistema == null && other.codsistema != null) || (this.codsistema != null && !this.codsistema.equals(other.codsistema))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Sistema[ codsistema=" + codsistema + " ]";
    }
    
}
