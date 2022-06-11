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
@Table(name = "EMPRESAUF", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresauf.findAll", query = "SELECT e FROM Empresauf e")
    , @NamedQuery(name = "Empresauf.findByCodempresauf", query = "SELECT e FROM Empresauf e WHERE e.codempresauf = :codempresauf")
    , @NamedQuery(name = "Empresauf.findByInscricaoestadual", query = "SELECT e FROM Empresauf e WHERE e.inscricaoestadual = :inscricaoestadual")})
public class Empresauf implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODEMPRESAUF")
    private String codempresauf;
    @Basic(optional = false)
    @Column(name = "INSCRICAOESTADUAL")
    private String inscricaoestadual;
    @JoinColumn(name = "CODEMPRESA", referencedColumnName = "CODEMPRESA")
    @ManyToOne(optional = false)
    private Empresa codempresa;
    @JoinColumn(name = "CODUF", referencedColumnName = "CODUF")
    @ManyToOne(optional = false)
    private Uf coduf;

    public Empresauf() {
    }

    public Empresauf(String codempresauf) {
        this.codempresauf = codempresauf;
    }

    public Empresauf(String codempresauf, String inscricaoestadual) {
        this.codempresauf = codempresauf;
        this.inscricaoestadual = inscricaoestadual;
    }

    public String getCodempresauf() {
        return codempresauf;
    }

    public void setCodempresauf(String codempresauf) {
        this.codempresauf = codempresauf;
    }

    public String getInscricaoestadual() {
        return inscricaoestadual;
    }

    public void setInscricaoestadual(String inscricaoestadual) {
        this.inscricaoestadual = inscricaoestadual;
    }

    public Empresa getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Empresa codempresa) {
        this.codempresa = codempresa;
    }

    public Uf getCoduf() {
        return coduf;
    }

    public void setCoduf(Uf coduf) {
        this.coduf = coduf;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codempresauf != null ? codempresauf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresauf)) {
            return false;
        }
        Empresauf other = (Empresauf) object;
        if ((this.codempresauf == null && other.codempresauf != null) || (this.codempresauf != null && !this.codempresauf.equals(other.codempresauf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Empresauf[ codempresauf=" + codempresauf + " ]";
    }
    
}
