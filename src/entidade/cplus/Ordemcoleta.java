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
@Table(name = "ORDEMCOLETA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordemcoleta.findAll", query = "SELECT o FROM Ordemcoleta o")
    , @NamedQuery(name = "Ordemcoleta.findByCodordcoleta", query = "SELECT o FROM Ordemcoleta o WHERE o.codordcoleta = :codordcoleta")
    , @NamedQuery(name = "Ordemcoleta.findByNumordcoleta", query = "SELECT o FROM Ordemcoleta o WHERE o.numordcoleta = :numordcoleta")
    , @NamedQuery(name = "Ordemcoleta.findByCodcli", query = "SELECT o FROM Ordemcoleta o WHERE o.codcli = :codcli")
    , @NamedQuery(name = "Ordemcoleta.findByCodvended", query = "SELECT o FROM Ordemcoleta o WHERE o.codvended = :codvended")
    , @NamedQuery(name = "Ordemcoleta.findByCodempresa", query = "SELECT o FROM Ordemcoleta o WHERE o.codempresa = :codempresa")
    , @NamedQuery(name = "Ordemcoleta.findByDatacadastro", query = "SELECT o FROM Ordemcoleta o WHERE o.datacadastro = :datacadastro")
    , @NamedQuery(name = "Ordemcoleta.findByDataprevisao", query = "SELECT o FROM Ordemcoleta o WHERE o.dataprevisao = :dataprevisao")
    , @NamedQuery(name = "Ordemcoleta.findByAtualizaestoque", query = "SELECT o FROM Ordemcoleta o WHERE o.atualizaestoque = :atualizaestoque")
    , @NamedQuery(name = "Ordemcoleta.findByStatus", query = "SELECT o FROM Ordemcoleta o WHERE o.status = :status")
    , @NamedQuery(name = "Ordemcoleta.findBySituacao", query = "SELECT o FROM Ordemcoleta o WHERE o.situacao = :situacao")
    , @NamedQuery(name = "Ordemcoleta.findByGuid", query = "SELECT o FROM Ordemcoleta o WHERE o.guid = :guid")})
public class Ordemcoleta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODORDCOLETA")
    private String codordcoleta;
    @Basic(optional = false)
    @Column(name = "NUMORDCOLETA")
    private int numordcoleta;
    @Column(name = "CODCLI")
    private String codcli;
    @Column(name = "CODVENDED")
    private String codvended;
    @Column(name = "CODEMPRESA")
    private Integer codempresa;
    @Column(name = "DATACADASTRO")
    @Temporal(TemporalType.DATE)
    private Date datacadastro;
    @Column(name = "DATAPREVISAO")
    @Temporal(TemporalType.DATE)
    private Date dataprevisao;
    @Column(name = "ATUALIZAESTOQUE")
    private Character atualizaestoque;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "SITUACAO")
    private String situacao;
    @Lob
    @Column(name = "OBSERVACAO")
    private String observacao;
    @Basic(optional = false)
    @Column(name = "GUID")
    private String guid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codordcoleta")
    private Collection<Ordemcoletaprod> ordemcoletaprodCollection;

    public Ordemcoleta() {
    }

    public Ordemcoleta(String codordcoleta) {
        this.codordcoleta = codordcoleta;
    }

    public Ordemcoleta(String codordcoleta, int numordcoleta, String guid) {
        this.codordcoleta = codordcoleta;
        this.numordcoleta = numordcoleta;
        this.guid = guid;
    }

    public String getCodordcoleta() {
        return codordcoleta;
    }

    public void setCodordcoleta(String codordcoleta) {
        this.codordcoleta = codordcoleta;
    }

    public int getNumordcoleta() {
        return numordcoleta;
    }

    public void setNumordcoleta(int numordcoleta) {
        this.numordcoleta = numordcoleta;
    }

    public String getCodcli() {
        return codcli;
    }

    public void setCodcli(String codcli) {
        this.codcli = codcli;
    }

    public String getCodvended() {
        return codvended;
    }

    public void setCodvended(String codvended) {
        this.codvended = codvended;
    }

    public Integer getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Integer codempresa) {
        this.codempresa = codempresa;
    }

    public Date getDatacadastro() {
        return datacadastro;
    }

    public void setDatacadastro(Date datacadastro) {
        this.datacadastro = datacadastro;
    }

    public Date getDataprevisao() {
        return dataprevisao;
    }

    public void setDataprevisao(Date dataprevisao) {
        this.dataprevisao = dataprevisao;
    }

    public Character getAtualizaestoque() {
        return atualizaestoque;
    }

    public void setAtualizaestoque(Character atualizaestoque) {
        this.atualizaestoque = atualizaestoque;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    @XmlTransient
    public Collection<Ordemcoletaprod> getOrdemcoletaprodCollection() {
        return ordemcoletaprodCollection;
    }

    public void setOrdemcoletaprodCollection(Collection<Ordemcoletaprod> ordemcoletaprodCollection) {
        this.ordemcoletaprodCollection = ordemcoletaprodCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codordcoleta != null ? codordcoleta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordemcoleta)) {
            return false;
        }
        Ordemcoleta other = (Ordemcoleta) object;
        if ((this.codordcoleta == null && other.codordcoleta != null) || (this.codordcoleta != null && !this.codordcoleta.equals(other.codordcoleta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Ordemcoleta[ codordcoleta=" + codordcoleta + " ]";
    }
    
}
