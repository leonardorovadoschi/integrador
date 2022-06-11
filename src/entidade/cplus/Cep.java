/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
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
@Table(name = "CEP", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cep.findAll", query = "SELECT c FROM Cep c")
    , @NamedQuery(name = "Cep.findByCodcep", query = "SELECT c FROM Cep c WHERE c.codcep = :codcep")
    , @NamedQuery(name = "Cep.findByNomelogradouro", query = "SELECT c FROM Cep c WHERE c.nomelogradouro = :nomelogradouro")
    , @NamedQuery(name = "Cep.findByDnecodlog", query = "SELECT c FROM Cep c WHERE c.dnecodlog = :dnecodlog")
    , @NamedQuery(name = "Cep.findByDnecodloc", query = "SELECT c FROM Cep c WHERE c.dnecodloc = :dnecodloc")
    , @NamedQuery(name = "Cep.findByDnecodbai", query = "SELECT c FROM Cep c WHERE c.dnecodbai = :dnecodbai")
    , @NamedQuery(name = "Cep.findByCoduf", query = "SELECT c FROM Cep c WHERE c.coduf = :coduf")
    , @NamedQuery(name = "Cep.findByLogNoAbrev", query = "SELECT c FROM Cep c WHERE c.logNoAbrev = :logNoAbrev")})
public class Cep implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCEP")
    private String codcep;
    @Column(name = "NOMELOGRADOURO")
    private String nomelogradouro;
    @Column(name = "DNECODLOG")
    private Integer dnecodlog;
    @Column(name = "DNECODLOC")
    private Integer dnecodloc;
    @Column(name = "DNECODBAI")
    private Integer dnecodbai;
    @Column(name = "CODUF")
    private String coduf;
    @Column(name = "LOG_NO_ABREV")
    private String logNoAbrev;
    @JoinColumn(name = "CODBAIRRO", referencedColumnName = "CODBAIRRO")
    @ManyToOne
    private Bairro codbairro;
    @JoinColumn(name = "CODCIDADE", referencedColumnName = "CODCIDADE")
    @ManyToOne
    private Cidade codcidade;
    @JoinColumn(name = "CODTIPOLOGRADOURO", referencedColumnName = "CODTIPOLOGRADOURO")
    @ManyToOne
    private Tipologradouro codtipologradouro;

    public Cep() {
    }

    public Cep(String codcep) {
        this.codcep = codcep;
    }

    public String getCodcep() {
        return codcep;
    }

    public void setCodcep(String codcep) {
        this.codcep = codcep;
    }

    public String getNomelogradouro() {
        return nomelogradouro;
    }

    public void setNomelogradouro(String nomelogradouro) {
        this.nomelogradouro = nomelogradouro;
    }

    public Integer getDnecodlog() {
        return dnecodlog;
    }

    public void setDnecodlog(Integer dnecodlog) {
        this.dnecodlog = dnecodlog;
    }

    public Integer getDnecodloc() {
        return dnecodloc;
    }

    public void setDnecodloc(Integer dnecodloc) {
        this.dnecodloc = dnecodloc;
    }

    public Integer getDnecodbai() {
        return dnecodbai;
    }

    public void setDnecodbai(Integer dnecodbai) {
        this.dnecodbai = dnecodbai;
    }

    public String getCoduf() {
        return coduf;
    }

    public void setCoduf(String coduf) {
        this.coduf = coduf;
    }

    public String getLogNoAbrev() {
        return logNoAbrev;
    }

    public void setLogNoAbrev(String logNoAbrev) {
        this.logNoAbrev = logNoAbrev;
    }

    public Bairro getCodbairro() {
        return codbairro;
    }

    public void setCodbairro(Bairro codbairro) {
        this.codbairro = codbairro;
    }

    public Cidade getCodcidade() {
        return codcidade;
    }

    public void setCodcidade(Cidade codcidade) {
        this.codcidade = codcidade;
    }

    public Tipologradouro getCodtipologradouro() {
        return codtipologradouro;
    }

    public void setCodtipologradouro(Tipologradouro codtipologradouro) {
        this.codtipologradouro = codtipologradouro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcep != null ? codcep.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cep)) {
            return false;
        }
        Cep other = (Cep) object;
        if ((this.codcep == null && other.codcep != null) || (this.codcep != null && !this.codcep.equals(other.codcep))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Cep[ codcep=" + codcep + " ]";
    }
    
}
