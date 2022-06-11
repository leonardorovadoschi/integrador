/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "RELATORIOACESSO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Relatorioacesso.findAll", query = "SELECT r FROM Relatorioacesso r")
    , @NamedQuery(name = "Relatorioacesso.findById", query = "SELECT r FROM Relatorioacesso r WHERE r.id = :id")
    , @NamedQuery(name = "Relatorioacesso.findByNomeentidade", query = "SELECT r FROM Relatorioacesso r WHERE r.nomeentidade = :nomeentidade")
    , @NamedQuery(name = "Relatorioacesso.findByIdentidade", query = "SELECT r FROM Relatorioacesso r WHERE r.identidade = :identidade")
    , @NamedQuery(name = "Relatorioacesso.findByFlagacesso", query = "SELECT r FROM Relatorioacesso r WHERE r.flagacesso = :flagacesso")})
public class Relatorioacesso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "NOMEENTIDADE")
    private String nomeentidade;
    @Basic(optional = false)
    @Column(name = "IDENTIDADE")
    private String identidade;
    @Basic(optional = false)
    @Column(name = "FLAGACESSO")
    private Character flagacesso;
    @JoinColumn(name = "IDRELATORIO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Relatorio idrelatorio;

    public Relatorioacesso() {
    }

    public Relatorioacesso(Integer id) {
        this.id = id;
    }

    public Relatorioacesso(Integer id, String nomeentidade, String identidade, Character flagacesso) {
        this.id = id;
        this.nomeentidade = nomeentidade;
        this.identidade = identidade;
        this.flagacesso = flagacesso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeentidade() {
        return nomeentidade;
    }

    public void setNomeentidade(String nomeentidade) {
        this.nomeentidade = nomeentidade;
    }

    public String getIdentidade() {
        return identidade;
    }

    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }

    public Character getFlagacesso() {
        return flagacesso;
    }

    public void setFlagacesso(Character flagacesso) {
        this.flagacesso = flagacesso;
    }

    public Relatorio getIdrelatorio() {
        return idrelatorio;
    }

    public void setIdrelatorio(Relatorio idrelatorio) {
        this.idrelatorio = idrelatorio;
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
        if (!(object instanceof Relatorioacesso)) {
            return false;
        }
        Relatorioacesso other = (Relatorioacesso) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Relatorioacesso[ id=" + id + " ]";
    }
    
}
