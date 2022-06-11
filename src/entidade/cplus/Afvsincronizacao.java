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
@Table(name = "AFVSINCRONIZACAO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Afvsincronizacao.findAll", query = "SELECT a FROM Afvsincronizacao a")
    , @NamedQuery(name = "Afvsincronizacao.findById", query = "SELECT a FROM Afvsincronizacao a WHERE a.id = :id")
    , @NamedQuery(name = "Afvsincronizacao.findByEntidadesincronizacao", query = "SELECT a FROM Afvsincronizacao a WHERE a.entidadesincronizacao = :entidadesincronizacao")
    , @NamedQuery(name = "Afvsincronizacao.findByIdentidade", query = "SELECT a FROM Afvsincronizacao a WHERE a.identidade = :identidade")
    , @NamedQuery(name = "Afvsincronizacao.findByIdentidaderemota", query = "SELECT a FROM Afvsincronizacao a WHERE a.identidaderemota = :identidaderemota")
    , @NamedQuery(name = "Afvsincronizacao.findByAcaosincronia", query = "SELECT a FROM Afvsincronizacao a WHERE a.acaosincronia = :acaosincronia")
    , @NamedQuery(name = "Afvsincronizacao.findByDatahoraultimaalteracaoremota", query = "SELECT a FROM Afvsincronizacao a WHERE a.datahoraultimaalteracaoremota = :datahoraultimaalteracaoremota")
    , @NamedQuery(name = "Afvsincronizacao.findByCodigoambiente", query = "SELECT a FROM Afvsincronizacao a WHERE a.codigoambiente = :codigoambiente")})
public class Afvsincronizacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "ENTIDADESINCRONIZACAO")
    private int entidadesincronizacao;
    @Basic(optional = false)
    @Column(name = "IDENTIDADE")
    private String identidade;
    @Column(name = "IDENTIDADEREMOTA")
    private String identidaderemota;
    @Column(name = "ACAOSINCRONIA")
    private Short acaosincronia;
    @Column(name = "DATAHORAULTIMAALTERACAOREMOTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datahoraultimaalteracaoremota;
    @Column(name = "CODIGOAMBIENTE")
    private Integer codigoambiente;

    public Afvsincronizacao() {
    }

    public Afvsincronizacao(Integer id) {
        this.id = id;
    }

    public Afvsincronizacao(Integer id, int entidadesincronizacao, String identidade) {
        this.id = id;
        this.entidadesincronizacao = entidadesincronizacao;
        this.identidade = identidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getEntidadesincronizacao() {
        return entidadesincronizacao;
    }

    public void setEntidadesincronizacao(int entidadesincronizacao) {
        this.entidadesincronizacao = entidadesincronizacao;
    }

    public String getIdentidade() {
        return identidade;
    }

    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }

    public String getIdentidaderemota() {
        return identidaderemota;
    }

    public void setIdentidaderemota(String identidaderemota) {
        this.identidaderemota = identidaderemota;
    }

    public Short getAcaosincronia() {
        return acaosincronia;
    }

    public void setAcaosincronia(Short acaosincronia) {
        this.acaosincronia = acaosincronia;
    }

    public Date getDatahoraultimaalteracaoremota() {
        return datahoraultimaalteracaoremota;
    }

    public void setDatahoraultimaalteracaoremota(Date datahoraultimaalteracaoremota) {
        this.datahoraultimaalteracaoremota = datahoraultimaalteracaoremota;
    }

    public Integer getCodigoambiente() {
        return codigoambiente;
    }

    public void setCodigoambiente(Integer codigoambiente) {
        this.codigoambiente = codigoambiente;
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
        if (!(object instanceof Afvsincronizacao)) {
            return false;
        }
        Afvsincronizacao other = (Afvsincronizacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Afvsincronizacao[ id=" + id + " ]";
    }
    
}
