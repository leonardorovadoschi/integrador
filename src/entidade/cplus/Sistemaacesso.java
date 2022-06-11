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
@Table(name = "SISTEMAACESSO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sistemaacesso.findAll", query = "SELECT s FROM Sistemaacesso s")
    , @NamedQuery(name = "Sistemaacesso.findByCodsistemaacesso", query = "SELECT s FROM Sistemaacesso s WHERE s.codsistemaacesso = :codsistemaacesso")
    , @NamedQuery(name = "Sistemaacesso.findByDescricao", query = "SELECT s FROM Sistemaacesso s WHERE s.descricao = :descricao")
    , @NamedQuery(name = "Sistemaacesso.findByFlagacessopadrao", query = "SELECT s FROM Sistemaacesso s WHERE s.flagacessopadrao = :flagacessopadrao")
    , @NamedQuery(name = "Sistemaacesso.findByArvore", query = "SELECT s FROM Sistemaacesso s WHERE s.arvore = :arvore")
    , @NamedQuery(name = "Sistemaacesso.findByLastChange", query = "SELECT s FROM Sistemaacesso s WHERE s.lastChange = :lastChange")
    , @NamedQuery(name = "Sistemaacesso.findByGuid", query = "SELECT s FROM Sistemaacesso s WHERE s.guid = :guid")})
public class Sistemaacesso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODSISTEMAACESSO")
    private Integer codsistemaacesso;
    @Column(name = "DESCRICAO")
    private String descricao;
    @Column(name = "FLAGACESSOPADRAO")
    private Character flagacessopadrao;
    @Column(name = "ARVORE")
    private String arvore;
    @Column(name = "LAST_CHANGE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastChange;
    @Column(name = "GUID")
    private String guid;
    @JoinColumn(name = "CODSISTEMA", referencedColumnName = "CODSISTEMA")
    @ManyToOne
    private Sistema codsistema;

    public Sistemaacesso() {
    }

    public Sistemaacesso(Integer codsistemaacesso) {
        this.codsistemaacesso = codsistemaacesso;
    }

    public Integer getCodsistemaacesso() {
        return codsistemaacesso;
    }

    public void setCodsistemaacesso(Integer codsistemaacesso) {
        this.codsistemaacesso = codsistemaacesso;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Character getFlagacessopadrao() {
        return flagacessopadrao;
    }

    public void setFlagacessopadrao(Character flagacessopadrao) {
        this.flagacessopadrao = flagacessopadrao;
    }

    public String getArvore() {
        return arvore;
    }

    public void setArvore(String arvore) {
        this.arvore = arvore;
    }

    public Date getLastChange() {
        return lastChange;
    }

    public void setLastChange(Date lastChange) {
        this.lastChange = lastChange;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
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
        hash += (codsistemaacesso != null ? codsistemaacesso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sistemaacesso)) {
            return false;
        }
        Sistemaacesso other = (Sistemaacesso) object;
        if ((this.codsistemaacesso == null && other.codsistemaacesso != null) || (this.codsistemaacesso != null && !this.codsistemaacesso.equals(other.codsistemaacesso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Sistemaacesso[ codsistemaacesso=" + codsistemaacesso + " ]";
    }
    
}
