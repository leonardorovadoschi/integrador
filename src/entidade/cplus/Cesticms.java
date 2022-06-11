/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "CESTICMS", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cesticms.findAll", query = "SELECT c FROM Cesticms c")
    , @NamedQuery(name = "Cesticms.findByCodcesticms", query = "SELECT c FROM Cesticms c WHERE c.codcesticms = :codcesticms")
    , @NamedQuery(name = "Cesticms.findByFlagativo", query = "SELECT c FROM Cesticms c WHERE c.flagativo = :flagativo")
    , @NamedQuery(name = "Cesticms.findByDataatualizacao", query = "SELECT c FROM Cesticms c WHERE c.dataatualizacao = :dataatualizacao")})
public class Cesticms implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCESTICMS")
    private String codcesticms;
    @Basic(optional = false)
    @Lob
    @Column(name = "DESCRICAO")
    private String descricao;
    @Column(name = "FLAGATIVO")
    private Character flagativo;
    @Column(name = "DATAATUALIZACAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataatualizacao;
    @OneToMany(mappedBy = "codcesticms")
    private Collection<Classificacaofiscal> classificacaofiscalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cesticms")
    private Collection<Cesticmsclassificacaofiscal> cesticmsclassificacaofiscalCollection;

    public Cesticms() {
    }

    public Cesticms(String codcesticms) {
        this.codcesticms = codcesticms;
    }

    public Cesticms(String codcesticms, String descricao) {
        this.codcesticms = codcesticms;
        this.descricao = descricao;
    }

    public String getCodcesticms() {
        return codcesticms;
    }

    public void setCodcesticms(String codcesticms) {
        this.codcesticms = codcesticms;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Character getFlagativo() {
        return flagativo;
    }

    public void setFlagativo(Character flagativo) {
        this.flagativo = flagativo;
    }

    public Date getDataatualizacao() {
        return dataatualizacao;
    }

    public void setDataatualizacao(Date dataatualizacao) {
        this.dataatualizacao = dataatualizacao;
    }

    @XmlTransient
    public Collection<Classificacaofiscal> getClassificacaofiscalCollection() {
        return classificacaofiscalCollection;
    }

    public void setClassificacaofiscalCollection(Collection<Classificacaofiscal> classificacaofiscalCollection) {
        this.classificacaofiscalCollection = classificacaofiscalCollection;
    }

    @XmlTransient
    public Collection<Cesticmsclassificacaofiscal> getCesticmsclassificacaofiscalCollection() {
        return cesticmsclassificacaofiscalCollection;
    }

    public void setCesticmsclassificacaofiscalCollection(Collection<Cesticmsclassificacaofiscal> cesticmsclassificacaofiscalCollection) {
        this.cesticmsclassificacaofiscalCollection = cesticmsclassificacaofiscalCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcesticms != null ? codcesticms.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cesticms)) {
            return false;
        }
        Cesticms other = (Cesticms) object;
        if ((this.codcesticms == null && other.codcesticms != null) || (this.codcesticms != null && !this.codcesticms.equals(other.codcesticms))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Cesticms[ codcesticms=" + codcesticms + " ]";
    }
    
}
