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
@Table(name = "ACERTO_PRODFCI", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AcertoProdfci.findAll", query = "SELECT a FROM AcertoProdfci a")
    , @NamedQuery(name = "AcertoProdfci.findByCodacertoProdfci", query = "SELECT a FROM AcertoProdfci a WHERE a.codacertoProdfci = :codacertoProdfci")
    , @NamedQuery(name = "AcertoProdfci.findByCoduser", query = "SELECT a FROM AcertoProdfci a WHERE a.coduser = :coduser")
    , @NamedQuery(name = "AcertoProdfci.findByData", query = "SELECT a FROM AcertoProdfci a WHERE a.data = :data")
    , @NamedQuery(name = "AcertoProdfci.findByHora", query = "SELECT a FROM AcertoProdfci a WHERE a.hora = :hora")
    , @NamedQuery(name = "AcertoProdfci.findByDescricao", query = "SELECT a FROM AcertoProdfci a WHERE a.descricao = :descricao")
    , @NamedQuery(name = "AcertoProdfci.findByStatus", query = "SELECT a FROM AcertoProdfci a WHERE a.status = :status")
    , @NamedQuery(name = "AcertoProdfci.findByDataacerto", query = "SELECT a FROM AcertoProdfci a WHERE a.dataacerto = :dataacerto")})
public class AcertoProdfci implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODACERTO_PRODFCI")
    private String codacertoProdfci;
    @Column(name = "CODUSER")
    private String coduser;
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

    public AcertoProdfci() {
    }

    public AcertoProdfci(String codacertoProdfci) {
        this.codacertoProdfci = codacertoProdfci;
    }

    public AcertoProdfci(String codacertoProdfci, Date data) {
        this.codacertoProdfci = codacertoProdfci;
        this.data = data;
    }

    public String getCodacertoProdfci() {
        return codacertoProdfci;
    }

    public void setCodacertoProdfci(String codacertoProdfci) {
        this.codacertoProdfci = codacertoProdfci;
    }

    public String getCoduser() {
        return coduser;
    }

    public void setCoduser(String coduser) {
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
        hash += (codacertoProdfci != null ? codacertoProdfci.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AcertoProdfci)) {
            return false;
        }
        AcertoProdfci other = (AcertoProdfci) object;
        if ((this.codacertoProdfci == null && other.codacertoProdfci != null) || (this.codacertoProdfci != null && !this.codacertoProdfci.equals(other.codacertoProdfci))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.AcertoProdfci[ codacertoProdfci=" + codacertoProdfci + " ]";
    }
    
}
