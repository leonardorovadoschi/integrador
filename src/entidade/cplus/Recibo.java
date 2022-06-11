/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "RECIBO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recibo.findAll", query = "SELECT r FROM Recibo r")
    , @NamedQuery(name = "Recibo.findById", query = "SELECT r FROM Recibo r WHERE r.id = :id")
    , @NamedQuery(name = "Recibo.findByData", query = "SELECT r FROM Recibo r WHERE r.data = :data")
    , @NamedQuery(name = "Recibo.findByNome", query = "SELECT r FROM Recibo r WHERE r.nome = :nome")
    , @NamedQuery(name = "Recibo.findByValor", query = "SELECT r FROM Recibo r WHERE r.valor = :valor")
    , @NamedQuery(name = "Recibo.findByStatus", query = "SELECT r FROM Recibo r WHERE r.status = :status")
    , @NamedQuery(name = "Recibo.findByIdentidadeorigem", query = "SELECT r FROM Recibo r WHERE r.identidadeorigem = :identidadeorigem")
    , @NamedQuery(name = "Recibo.findByNomeentidadeorigem", query = "SELECT r FROM Recibo r WHERE r.nomeentidadeorigem = :nomeentidadeorigem")
    , @NamedQuery(name = "Recibo.findByCoduser", query = "SELECT r FROM Recibo r WHERE r.coduser = :coduser")
    , @NamedQuery(name = "Recibo.findByFlagtipo", query = "SELECT r FROM Recibo r WHERE r.flagtipo = :flagtipo")})
public class Recibo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Column(name = "DATA")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "NOME")
    private String nome;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALOR")
    private BigDecimal valor;
    @Lob
    @Column(name = "REFERENTE")
    private String referente;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "IDENTIDADEORIGEM")
    private String identidadeorigem;
    @Column(name = "NOMEENTIDADEORIGEM")
    private String nomeentidadeorigem;
    @Column(name = "CODUSER")
    private String coduser;
    @Column(name = "FLAGTIPO")
    private Character flagtipo;
    @JoinColumn(name = "CODEMPRESA", referencedColumnName = "CODEMPRESA")
    @ManyToOne
    private Empresa codempresa;

    public Recibo() {
    }

    public Recibo(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getReferente() {
        return referente;
    }

    public void setReferente(String referente) {
        this.referente = referente;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIdentidadeorigem() {
        return identidadeorigem;
    }

    public void setIdentidadeorigem(String identidadeorigem) {
        this.identidadeorigem = identidadeorigem;
    }

    public String getNomeentidadeorigem() {
        return nomeentidadeorigem;
    }

    public void setNomeentidadeorigem(String nomeentidadeorigem) {
        this.nomeentidadeorigem = nomeentidadeorigem;
    }

    public String getCoduser() {
        return coduser;
    }

    public void setCoduser(String coduser) {
        this.coduser = coduser;
    }

    public Character getFlagtipo() {
        return flagtipo;
    }

    public void setFlagtipo(Character flagtipo) {
        this.flagtipo = flagtipo;
    }

    public Empresa getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Empresa codempresa) {
        this.codempresa = codempresa;
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
        if (!(object instanceof Recibo)) {
            return false;
        }
        Recibo other = (Recibo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Recibo[ id=" + id + " ]";
    }
    
}
