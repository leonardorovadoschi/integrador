/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "FILAINTEGRACAO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Filaintegracao.findAll", query = "SELECT f FROM Filaintegracao f")
    , @NamedQuery(name = "Filaintegracao.findById", query = "SELECT f FROM Filaintegracao f WHERE f.id = :id")
    , @NamedQuery(name = "Filaintegracao.findByDatahora", query = "SELECT f FROM Filaintegracao f WHERE f.datahora = :datahora")
    , @NamedQuery(name = "Filaintegracao.findByEntidade", query = "SELECT f FROM Filaintegracao f WHERE f.entidade = :entidade")
    , @NamedQuery(name = "Filaintegracao.findByStatus", query = "SELECT f FROM Filaintegracao f WHERE f.status = :status")
    , @NamedQuery(name = "Filaintegracao.findByDatastatus", query = "SELECT f FROM Filaintegracao f WHERE f.datastatus = :datastatus")
    , @NamedQuery(name = "Filaintegracao.findByNumeroambiente", query = "SELECT f FROM Filaintegracao f WHERE f.numeroambiente = :numeroambiente")
    , @NamedQuery(name = "Filaintegracao.findByGuid", query = "SELECT f FROM Filaintegracao f WHERE f.guid = :guid")
    , @NamedQuery(name = "Filaintegracao.findByGuidpedido", query = "SELECT f FROM Filaintegracao f WHERE f.guidpedido = :guidpedido")})
public class Filaintegracao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "DATAHORA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datahora;
    @Basic(optional = false)
    @Column(name = "ENTIDADE")
    private int entidade;
    @Column(name = "STATUS")
    private Integer status;
    @Column(name = "DATASTATUS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datastatus;
    @Lob
    @Column(name = "DADOS")
    private String dados;
    @Lob
    @Column(name = "OCORRENCIAS")
    private String ocorrencias;
    @Column(name = "NUMEROAMBIENTE")
    private Integer numeroambiente;
    @Column(name = "GUID")
    private String guid;
    @Column(name = "GUIDPEDIDO")
    private String guidpedido;

    public Filaintegracao() {
    }

    public Filaintegracao(Integer id) {
        this.id = id;
    }

    public Filaintegracao(Integer id, Date datahora, int entidade) {
        this.id = id;
        this.datahora = datahora;
        this.entidade = entidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDatahora() {
        return datahora;
    }

    public void setDatahora(Date datahora) {
        this.datahora = datahora;
    }

    public int getEntidade() {
        return entidade;
    }

    public void setEntidade(int entidade) {
        this.entidade = entidade;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getDatastatus() {
        return datastatus;
    }

    public void setDatastatus(Date datastatus) {
        this.datastatus = datastatus;
    }

    public String getDados() {
        return dados;
    }

    public void setDados(String dados) {
        this.dados = dados;
    }

    public String getOcorrencias() {
        return ocorrencias;
    }

    public void setOcorrencias(String ocorrencias) {
        this.ocorrencias = ocorrencias;
    }

    public Integer getNumeroambiente() {
        return numeroambiente;
    }

    public void setNumeroambiente(Integer numeroambiente) {
        this.numeroambiente = numeroambiente;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getGuidpedido() {
        return guidpedido;
    }

    public void setGuidpedido(String guidpedido) {
        this.guidpedido = guidpedido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Filaintegracao)) {
            return false;
        }
        Filaintegracao other = (Filaintegracao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Filaintegracao[ id=" + id + " ]";
    }
    
}
