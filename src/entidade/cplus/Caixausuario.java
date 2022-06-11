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
@Table(name = "CAIXAUSUARIO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Caixausuario.findAll", query = "SELECT c FROM Caixausuario c")
    , @NamedQuery(name = "Caixausuario.findByCodcaixausuario", query = "SELECT c FROM Caixausuario c WHERE c.codcaixausuario = :codcaixausuario")
    , @NamedQuery(name = "Caixausuario.findByCoduser", query = "SELECT c FROM Caixausuario c WHERE c.coduser = :coduser")
    , @NamedQuery(name = "Caixausuario.findByLotecaixausuario", query = "SELECT c FROM Caixausuario c WHERE c.lotecaixausuario = :lotecaixausuario")
    , @NamedQuery(name = "Caixausuario.findByData", query = "SELECT c FROM Caixausuario c WHERE c.data = :data")
    , @NamedQuery(name = "Caixausuario.findByHora", query = "SELECT c FROM Caixausuario c WHERE c.hora = :hora")
    , @NamedQuery(name = "Caixausuario.findByValor", query = "SELECT c FROM Caixausuario c WHERE c.valor = :valor")
    , @NamedQuery(name = "Caixausuario.findByFlagtipo", query = "SELECT c FROM Caixausuario c WHERE c.flagtipo = :flagtipo")
    , @NamedQuery(name = "Caixausuario.findByNomeentidadeorigem", query = "SELECT c FROM Caixausuario c WHERE c.nomeentidadeorigem = :nomeentidadeorigem")
    , @NamedQuery(name = "Caixausuario.findByIdentidadeorigem", query = "SELECT c FROM Caixausuario c WHERE c.identidadeorigem = :identidadeorigem")
    , @NamedQuery(name = "Caixausuario.findByDescricao", query = "SELECT c FROM Caixausuario c WHERE c.descricao = :descricao")
    , @NamedQuery(name = "Caixausuario.findByCancelado", query = "SELECT c FROM Caixausuario c WHERE c.cancelado = :cancelado")})
public class Caixausuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCAIXAUSUARIO")
    private String codcaixausuario;
    @Column(name = "CODUSER")
    private String coduser;
    @Basic(optional = false)
    @Column(name = "LOTECAIXAUSUARIO")
    private String lotecaixausuario;
    @Column(name = "DATA")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "HORA")
    @Temporal(TemporalType.TIME)
    private Date hora;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALOR")
    private BigDecimal valor;
    @Column(name = "FLAGTIPO")
    private Integer flagtipo;
    @Column(name = "NOMEENTIDADEORIGEM")
    private String nomeentidadeorigem;
    @Column(name = "IDENTIDADEORIGEM")
    private String identidadeorigem;
    @Column(name = "DESCRICAO")
    private String descricao;
    @Column(name = "CANCELADO")
    private Character cancelado;
    @JoinColumn(name = "CODREC", referencedColumnName = "CODREC")
    @ManyToOne
    private Recebimento codrec;
    @JoinColumn(name = "CODSISTEMA", referencedColumnName = "CODSISTEMA")
    @ManyToOne
    private Sistema codsistema;

    public Caixausuario() {
    }

    public Caixausuario(String codcaixausuario) {
        this.codcaixausuario = codcaixausuario;
    }

    public Caixausuario(String codcaixausuario, String lotecaixausuario) {
        this.codcaixausuario = codcaixausuario;
        this.lotecaixausuario = lotecaixausuario;
    }

    public String getCodcaixausuario() {
        return codcaixausuario;
    }

    public void setCodcaixausuario(String codcaixausuario) {
        this.codcaixausuario = codcaixausuario;
    }

    public String getCoduser() {
        return coduser;
    }

    public void setCoduser(String coduser) {
        this.coduser = coduser;
    }

    public String getLotecaixausuario() {
        return lotecaixausuario;
    }

    public void setLotecaixausuario(String lotecaixausuario) {
        this.lotecaixausuario = lotecaixausuario;
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

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Integer getFlagtipo() {
        return flagtipo;
    }

    public void setFlagtipo(Integer flagtipo) {
        this.flagtipo = flagtipo;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Character getCancelado() {
        return cancelado;
    }

    public void setCancelado(Character cancelado) {
        this.cancelado = cancelado;
    }

    public Recebimento getCodrec() {
        return codrec;
    }

    public void setCodrec(Recebimento codrec) {
        this.codrec = codrec;
    }

    public Sistema getCodsistema() {
        return codsistema;
    }

    public void setCodsistema(Sistema codsistema) {
        this.codsistema = codsistema;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcaixausuario != null ? codcaixausuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Caixausuario)) {
            return false;
        }
        Caixausuario other = (Caixausuario) object;
        if ((this.codcaixausuario == null && other.codcaixausuario != null) || (this.codcaixausuario != null && !this.codcaixausuario.equals(other.codcaixausuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Caixausuario[ codcaixausuario=" + codcaixausuario + " ]";
    }
    
}
