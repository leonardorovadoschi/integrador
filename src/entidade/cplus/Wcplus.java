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
@Table(name = "WCPLUS", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Wcplus.findAll", query = "SELECT w FROM Wcplus w")
    , @NamedQuery(name = "Wcplus.findById", query = "SELECT w FROM Wcplus w WHERE w.id = :id")
    , @NamedQuery(name = "Wcplus.findByComando", query = "SELECT w FROM Wcplus w WHERE w.comando = :comando")
    , @NamedQuery(name = "Wcplus.findByChave", query = "SELECT w FROM Wcplus w WHERE w.chave = :chave")
    , @NamedQuery(name = "Wcplus.findByParametro", query = "SELECT w FROM Wcplus w WHERE w.parametro = :parametro")
    , @NamedQuery(name = "Wcplus.findByExecucao", query = "SELECT w FROM Wcplus w WHERE w.execucao = :execucao")})
public class Wcplus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "COMANDO")
    private Integer comando;
    @Column(name = "CHAVE")
    private String chave;
    @Column(name = "PARAMETRO")
    private String parametro;
    @Column(name = "EXECUCAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date execucao;

    public Wcplus() {
    }

    public Wcplus(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getComando() {
        return comando;
    }

    public void setComando(Integer comando) {
        this.comando = comando;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    public Date getExecucao() {
        return execucao;
    }

    public void setExecucao(Date execucao) {
        this.execucao = execucao;
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
        if (!(object instanceof Wcplus)) {
            return false;
        }
        Wcplus other = (Wcplus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Wcplus[ id=" + id + " ]";
    }
    
}
