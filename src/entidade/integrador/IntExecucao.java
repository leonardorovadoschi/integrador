/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.integrador;

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
@Table(name = "int_execucao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IntExecucao.findAll", query = "SELECT i FROM IntExecucao i")
    , @NamedQuery(name = "IntExecucao.findByIdExecucao", query = "SELECT i FROM IntExecucao i WHERE i.idExecucao = :idExecucao")
    , @NamedQuery(name = "IntExecucao.findByTempo", query = "SELECT i FROM IntExecucao i WHERE i.tempo = :tempo")
    , @NamedQuery(name = "IntExecucao.findByUltimaExecucao", query = "SELECT i FROM IntExecucao i WHERE i.ultimaExecucao = :ultimaExecucao")
    , @NamedQuery(name = "IntExecucao.findByCondicao", query = "SELECT i FROM IntExecucao i WHERE i.condicao = :condicao")})
public class IntExecucao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_execucao")
    private String idExecucao;
    @Basic(optional = false)
    @Column(name = "tempo")
    private int tempo;
    @Basic(optional = false)
    @Column(name = "ultima_execucao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimaExecucao;
    @Basic(optional = false)
    @Column(name = "condicao")
    private int condicao;

    public IntExecucao() {
    }

    public IntExecucao(String idExecucao) {
        this.idExecucao = idExecucao;
    }

    public IntExecucao(String idExecucao, int tempo, Date ultimaExecucao, int condicao) {
        this.idExecucao = idExecucao;
        this.tempo = tempo;
        this.ultimaExecucao = ultimaExecucao;
        this.condicao = condicao;
    }

    public String getIdExecucao() {
        return idExecucao;
    }

    public void setIdExecucao(String idExecucao) {
        this.idExecucao = idExecucao;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public Date getUltimaExecucao() {
        return ultimaExecucao;
    }

    public void setUltimaExecucao(Date ultimaExecucao) {
        this.ultimaExecucao = ultimaExecucao;
    }

    public int getCondicao() {
        return condicao;
    }

    public void setCondicao(int condicao) {
        this.condicao = condicao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idExecucao != null ? idExecucao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IntExecucao)) {
            return false;
        }
        IntExecucao other = (IntExecucao) object;
        if ((this.idExecucao == null && other.idExecucao != null) || (this.idExecucao != null && !this.idExecucao.equals(other.idExecucao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.integrador.IntExecucao[ idExecucao=" + idExecucao + " ]";
    }
    
}
