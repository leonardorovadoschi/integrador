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
@Table(name = "ACERTO_PRODLOTE", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AcertoProdlote.findAll", query = "SELECT a FROM AcertoProdlote a")
    , @NamedQuery(name = "AcertoProdlote.findByCodacertoProdlote", query = "SELECT a FROM AcertoProdlote a WHERE a.codacertoProdlote = :codacertoProdlote")
    , @NamedQuery(name = "AcertoProdlote.findByCoduser", query = "SELECT a FROM AcertoProdlote a WHERE a.coduser = :coduser")
    , @NamedQuery(name = "AcertoProdlote.findByData", query = "SELECT a FROM AcertoProdlote a WHERE a.data = :data")
    , @NamedQuery(name = "AcertoProdlote.findByHora", query = "SELECT a FROM AcertoProdlote a WHERE a.hora = :hora")
    , @NamedQuery(name = "AcertoProdlote.findByDescricao", query = "SELECT a FROM AcertoProdlote a WHERE a.descricao = :descricao")
    , @NamedQuery(name = "AcertoProdlote.findByStatus", query = "SELECT a FROM AcertoProdlote a WHERE a.status = :status")
    , @NamedQuery(name = "AcertoProdlote.findByDataacerto", query = "SELECT a FROM AcertoProdlote a WHERE a.dataacerto = :dataacerto")})
public class AcertoProdlote implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODACERTO_PRODLOTE")
    private String codacertoProdlote;
    @Column(name = "CODUSER")
    private Integer coduser;
    @Basic(optional = false)
    @Column(name = "DATA")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "HORA")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @Column(name = "DESCRICAO")
    private String descricao;
    @Column(name = "STATUS")
    private Character status;
    @Column(name = "DATAACERTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataacerto;
    @JoinColumn(name = "CODEMPRESA", referencedColumnName = "CODEMPRESA")
    @ManyToOne
    private Empresa codempresa;
    @JoinColumn(name = "CODSETORESTOQUE", referencedColumnName = "CODSETORESTOQUE")
    @ManyToOne(optional = false)
    private Setorestoque codsetorestoque;

    public AcertoProdlote() {
    }

    public AcertoProdlote(String codacertoProdlote) {
        this.codacertoProdlote = codacertoProdlote;
    }

    public AcertoProdlote(String codacertoProdlote, Date data) {
        this.codacertoProdlote = codacertoProdlote;
        this.data = data;
    }

    public String getCodacertoProdlote() {
        return codacertoProdlote;
    }

    public void setCodacertoProdlote(String codacertoProdlote) {
        this.codacertoProdlote = codacertoProdlote;
    }

    public Integer getCoduser() {
        return coduser;
    }

    public void setCoduser(Integer coduser) {
        this.coduser = coduser;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public Date getDataacerto() {
        return dataacerto;
    }

    public void setDataacerto(Date dataacerto) {
        this.dataacerto = dataacerto;
    }

    public Empresa getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Empresa codempresa) {
        this.codempresa = codempresa;
    }

    public Setorestoque getCodsetorestoque() {
        return codsetorestoque;
    }

    public void setCodsetorestoque(Setorestoque codsetorestoque) {
        this.codsetorestoque = codsetorestoque;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codacertoProdlote != null ? codacertoProdlote.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AcertoProdlote)) {
            return false;
        }
        AcertoProdlote other = (AcertoProdlote) object;
        if ((this.codacertoProdlote == null && other.codacertoProdlote != null) || (this.codacertoProdlote != null && !this.codacertoProdlote.equals(other.codacertoProdlote))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.AcertoProdlote[ codacertoProdlote=" + codacertoProdlote + " ]";
    }
    
}
