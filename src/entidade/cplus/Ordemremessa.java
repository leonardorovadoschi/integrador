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
@Table(name = "ORDEMREMESSA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordemremessa.findAll", query = "SELECT o FROM Ordemremessa o")
    , @NamedQuery(name = "Ordemremessa.findByCodordremessa", query = "SELECT o FROM Ordemremessa o WHERE o.codordremessa = :codordremessa")
    , @NamedQuery(name = "Ordemremessa.findByNumordremessa", query = "SELECT o FROM Ordemremessa o WHERE o.numordremessa = :numordremessa")
    , @NamedQuery(name = "Ordemremessa.findByCodcli", query = "SELECT o FROM Ordemremessa o WHERE o.codcli = :codcli")
    , @NamedQuery(name = "Ordemremessa.findByCodvended", query = "SELECT o FROM Ordemremessa o WHERE o.codvended = :codvended")
    , @NamedQuery(name = "Ordemremessa.findByCodempresa", query = "SELECT o FROM Ordemremessa o WHERE o.codempresa = :codempresa")
    , @NamedQuery(name = "Ordemremessa.findByDatacadastro", query = "SELECT o FROM Ordemremessa o WHERE o.datacadastro = :datacadastro")
    , @NamedQuery(name = "Ordemremessa.findByDataprevisao", query = "SELECT o FROM Ordemremessa o WHERE o.dataprevisao = :dataprevisao")
    , @NamedQuery(name = "Ordemremessa.findByAtualizaestoque", query = "SELECT o FROM Ordemremessa o WHERE o.atualizaestoque = :atualizaestoque")
    , @NamedQuery(name = "Ordemremessa.findByStatus", query = "SELECT o FROM Ordemremessa o WHERE o.status = :status")
    , @NamedQuery(name = "Ordemremessa.findByGuid", query = "SELECT o FROM Ordemremessa o WHERE o.guid = :guid")})
public class Ordemremessa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODORDREMESSA")
    private String codordremessa;
    @Basic(optional = false)
    @Column(name = "NUMORDREMESSA")
    private int numordremessa;
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
    @Lob
    @Column(name = "OBSERVACAO")
    private String observacao;
    @Basic(optional = false)
    @Column(name = "GUID")
    private String guid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codordremessa")
    private Collection<Ordemremessaprod> ordemremessaprodCollection;

    public Ordemremessa() {
    }

    public Ordemremessa(String codordremessa) {
        this.codordremessa = codordremessa;
    }

    public Ordemremessa(String codordremessa, int numordremessa, String guid) {
        this.codordremessa = codordremessa;
        this.numordremessa = numordremessa;
        this.guid = guid;
    }

    public String getCodordremessa() {
        return codordremessa;
    }

    public void setCodordremessa(String codordremessa) {
        this.codordremessa = codordremessa;
    }

    public int getNumordremessa() {
        return numordremessa;
    }

    public void setNumordremessa(int numordremessa) {
        this.numordremessa = numordremessa;
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
    public Collection<Ordemremessaprod> getOrdemremessaprodCollection() {
        return ordemremessaprodCollection;
    }

    public void setOrdemremessaprodCollection(Collection<Ordemremessaprod> ordemremessaprodCollection) {
        this.ordemremessaprodCollection = ordemremessaprodCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codordremessa != null ? codordremessa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordemremessa)) {
            return false;
        }
        Ordemremessa other = (Ordemremessa) object;
        if ((this.codordremessa == null && other.codordremessa != null) || (this.codordremessa != null && !this.codordremessa.equals(other.codordremessa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Ordemremessa[ codordremessa=" + codordremessa + " ]";
    }
    
}
