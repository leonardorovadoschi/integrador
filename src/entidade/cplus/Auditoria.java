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
@Table(name = "AUDITORIA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Auditoria.findAll", query = "SELECT a FROM Auditoria a")
    , @NamedQuery(name = "Auditoria.findByCodauditoria", query = "SELECT a FROM Auditoria a WHERE a.codauditoria = :codauditoria")
    , @NamedQuery(name = "Auditoria.findByCoduser", query = "SELECT a FROM Auditoria a WHERE a.coduser = :coduser")
    , @NamedQuery(name = "Auditoria.findByCodsistema", query = "SELECT a FROM Auditoria a WHERE a.codsistema = :codsistema")
    , @NamedQuery(name = "Auditoria.findByData", query = "SELECT a FROM Auditoria a WHERE a.data = :data")
    , @NamedQuery(name = "Auditoria.findByFlagcategoria", query = "SELECT a FROM Auditoria a WHERE a.flagcategoria = :flagcategoria")
    , @NamedQuery(name = "Auditoria.findByDescricao", query = "SELECT a FROM Auditoria a WHERE a.descricao = :descricao")
    , @NamedQuery(name = "Auditoria.findByNomemoduloorigem", query = "SELECT a FROM Auditoria a WHERE a.nomemoduloorigem = :nomemoduloorigem")
    , @NamedQuery(name = "Auditoria.findByNomecomputador", query = "SELECT a FROM Auditoria a WHERE a.nomecomputador = :nomecomputador")
    , @NamedQuery(name = "Auditoria.findByIpcomputador", query = "SELECT a FROM Auditoria a WHERE a.ipcomputador = :ipcomputador")
    , @NamedQuery(name = "Auditoria.findByNomeentidadeorigem", query = "SELECT a FROM Auditoria a WHERE a.nomeentidadeorigem = :nomeentidadeorigem")
    , @NamedQuery(name = "Auditoria.findByIdentidadeorigem", query = "SELECT a FROM Auditoria a WHERE a.identidadeorigem = :identidadeorigem")
    , @NamedQuery(name = "Auditoria.findByCodacesso", query = "SELECT a FROM Auditoria a WHERE a.codacesso = :codacesso")
    , @NamedQuery(name = "Auditoria.findByVersaoexe", query = "SELECT a FROM Auditoria a WHERE a.versaoexe = :versaoexe")})
public class Auditoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODAUDITORIA")
    private String codauditoria;
    @Column(name = "CODUSER")
    private String coduser;
    @Column(name = "CODSISTEMA")
    private String codsistema;
    @Column(name = "DATA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Column(name = "FLAGCATEGORIA")
    private Integer flagcategoria;
    @Column(name = "DESCRICAO")
    private String descricao;
    @Lob
    @Column(name = "DETALHELOG")
    private String detalhelog;
    @Column(name = "NOMEMODULOORIGEM")
    private String nomemoduloorigem;
    @Column(name = "NOMECOMPUTADOR")
    private String nomecomputador;
    @Column(name = "IPCOMPUTADOR")
    private String ipcomputador;
    @Column(name = "NOMEENTIDADEORIGEM")
    private String nomeentidadeorigem;
    @Column(name = "IDENTIDADEORIGEM")
    private String identidadeorigem;
    @Column(name = "CODACESSO")
    private String codacesso;
    @Column(name = "VERSAOEXE")
    private String versaoexe;

    public Auditoria() {
    }

    public Auditoria(String codauditoria) {
        this.codauditoria = codauditoria;
    }

    public String getCodauditoria() {
        return codauditoria;
    }

    public void setCodauditoria(String codauditoria) {
        this.codauditoria = codauditoria;
    }

    public String getCoduser() {
        return coduser;
    }

    public void setCoduser(String coduser) {
        this.coduser = coduser;
    }

    public String getCodsistema() {
        return codsistema;
    }

    public void setCodsistema(String codsistema) {
        this.codsistema = codsistema;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getFlagcategoria() {
        return flagcategoria;
    }

    public void setFlagcategoria(Integer flagcategoria) {
        this.flagcategoria = flagcategoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDetalhelog() {
        return detalhelog;
    }

    public void setDetalhelog(String detalhelog) {
        this.detalhelog = detalhelog;
    }

    public String getNomemoduloorigem() {
        return nomemoduloorigem;
    }

    public void setNomemoduloorigem(String nomemoduloorigem) {
        this.nomemoduloorigem = nomemoduloorigem;
    }

    public String getNomecomputador() {
        return nomecomputador;
    }

    public void setNomecomputador(String nomecomputador) {
        this.nomecomputador = nomecomputador;
    }

    public String getIpcomputador() {
        return ipcomputador;
    }

    public void setIpcomputador(String ipcomputador) {
        this.ipcomputador = ipcomputador;
    }

    public String getNomeentidadeorigem() {
        return nomeentidadeorigem;
    }

    public void setNomeentidadeorigem(String nomeentidadeorigem) {
        this.nomeentidadeorigem = nomeentidadeorigem;
    }

    public String getIdentidadeorigem() {
        return identidadeorigem;
    }

    public void setIdentidadeorigem(String identidadeorigem) {
        this.identidadeorigem = identidadeorigem;
    }

    public String getCodacesso() {
        return codacesso;
    }

    public void setCodacesso(String codacesso) {
        this.codacesso = codacesso;
    }

    public String getVersaoexe() {
        return versaoexe;
    }

    public void setVersaoexe(String versaoexe) {
        this.versaoexe = versaoexe;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codauditoria != null ? codauditoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Auditoria)) {
            return false;
        }
        Auditoria other = (Auditoria) object;
        if ((this.codauditoria == null && other.codauditoria != null) || (this.codauditoria != null && !this.codauditoria.equals(other.codauditoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Auditoria[ codauditoria=" + codauditoria + " ]";
    }
    
}
