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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "OS_REQUISICAO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OsRequisicao.findAll", query = "SELECT o FROM OsRequisicao o")
    , @NamedQuery(name = "OsRequisicao.findByCodrequisicao", query = "SELECT o FROM OsRequisicao o WHERE o.codrequisicao = :codrequisicao")
    , @NamedQuery(name = "OsRequisicao.findByCodprodserv", query = "SELECT o FROM OsRequisicao o WHERE o.codprodserv = :codprodserv")
    , @NamedQuery(name = "OsRequisicao.findByCodorcprod", query = "SELECT o FROM OsRequisicao o WHERE o.codorcprod = :codorcprod")
    , @NamedQuery(name = "OsRequisicao.findByCoduserrequisicao", query = "SELECT o FROM OsRequisicao o WHERE o.coduserrequisicao = :coduserrequisicao")
    , @NamedQuery(name = "OsRequisicao.findByCoduserliberacao", query = "SELECT o FROM OsRequisicao o WHERE o.coduserliberacao = :coduserliberacao")
    , @NamedQuery(name = "OsRequisicao.findByStatus", query = "SELECT o FROM OsRequisicao o WHERE o.status = :status")
    , @NamedQuery(name = "OsRequisicao.findByDataliberacao", query = "SELECT o FROM OsRequisicao o WHERE o.dataliberacao = :dataliberacao")
    , @NamedQuery(name = "OsRequisicao.findByDatarequisicao", query = "SELECT o FROM OsRequisicao o WHERE o.datarequisicao = :datarequisicao")
    , @NamedQuery(name = "OsRequisicao.findByTipo", query = "SELECT o FROM OsRequisicao o WHERE o.tipo = :tipo")
    , @NamedQuery(name = "OsRequisicao.findByLoterequisicao", query = "SELECT o FROM OsRequisicao o WHERE o.loterequisicao = :loterequisicao")})
public class OsRequisicao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODREQUISICAO")
    private String codrequisicao;
    @Column(name = "CODPRODSERV")
    private String codprodserv;
    @Column(name = "CODORCPROD")
    private String codorcprod;
    @Column(name = "CODUSERREQUISICAO")
    private String coduserrequisicao;
    @Column(name = "CODUSERLIBERACAO")
    private String coduserliberacao;
    @Column(name = "STATUS")
    private Character status;
    @Column(name = "DATALIBERACAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataliberacao;
    @Column(name = "DATAREQUISICAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datarequisicao;
    @Column(name = "TIPO")
    private Character tipo;
    @Column(name = "LOTEREQUISICAO")
    private String loterequisicao;
    @JoinColumn(name = "CODPROD", referencedColumnName = "CODPROD")
    @ManyToOne
    private Produto codprod;

    public OsRequisicao() {
    }

    public OsRequisicao(String codrequisicao) {
        this.codrequisicao = codrequisicao;
    }

    public String getCodrequisicao() {
        return codrequisicao;
    }

    public void setCodrequisicao(String codrequisicao) {
        this.codrequisicao = codrequisicao;
    }

    public String getCodprodserv() {
        return codprodserv;
    }

    public void setCodprodserv(String codprodserv) {
        this.codprodserv = codprodserv;
    }

    public String getCodorcprod() {
        return codorcprod;
    }

    public void setCodorcprod(String codorcprod) {
        this.codorcprod = codorcprod;
    }

    public String getCoduserrequisicao() {
        return coduserrequisicao;
    }

    public void setCoduserrequisicao(String coduserrequisicao) {
        this.coduserrequisicao = coduserrequisicao;
    }

    public String getCoduserliberacao() {
        return coduserliberacao;
    }

    public void setCoduserliberacao(String coduserliberacao) {
        this.coduserliberacao = coduserliberacao;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public Date getDataliberacao() {
        return dataliberacao;
    }

    public void setDataliberacao(Date dataliberacao) {
        this.dataliberacao = dataliberacao;
    }

    public Date getDatarequisicao() {
        return datarequisicao;
    }

    public void setDatarequisicao(Date datarequisicao) {
        this.datarequisicao = datarequisicao;
    }

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

    public String getLoterequisicao() {
        return loterequisicao;
    }

    public void setLoterequisicao(String loterequisicao) {
        this.loterequisicao = loterequisicao;
    }

    public Produto getCodprod() {
        return codprod;
    }

    public void setCodprod(Produto codprod) {
        this.codprod = codprod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codrequisicao != null ? codrequisicao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OsRequisicao)) {
            return false;
        }
        OsRequisicao other = (OsRequisicao) object;
        if ((this.codrequisicao == null && other.codrequisicao != null) || (this.codrequisicao != null && !this.codrequisicao.equals(other.codrequisicao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.OsRequisicao[ codrequisicao=" + codrequisicao + " ]";
    }
    
}
