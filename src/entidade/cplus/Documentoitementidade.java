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
@Table(name = "DOCUMENTOITEMENTIDADE", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Documentoitementidade.findAll", query = "SELECT d FROM Documentoitementidade d")
    , @NamedQuery(name = "Documentoitementidade.findByCoddocumentoitementidade", query = "SELECT d FROM Documentoitementidade d WHERE d.coddocumentoitementidade = :coddocumentoitementidade")
    , @NamedQuery(name = "Documentoitementidade.findByNomeentidadeorigem", query = "SELECT d FROM Documentoitementidade d WHERE d.nomeentidadeorigem = :nomeentidadeorigem")
    , @NamedQuery(name = "Documentoitementidade.findByIdentidadeorigem", query = "SELECT d FROM Documentoitementidade d WHERE d.identidadeorigem = :identidadeorigem")})
public class Documentoitementidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODDOCUMENTOITEMENTIDADE")
    private String coddocumentoitementidade;
    @Basic(optional = false)
    @Column(name = "NOMEENTIDADEORIGEM")
    private String nomeentidadeorigem;
    @Basic(optional = false)
    @Column(name = "IDENTIDADEORIGEM")
    private String identidadeorigem;
    @JoinColumn(name = "CODDOCUMENTOITEM", referencedColumnName = "CODDOCUMENTOITEM")
    @ManyToOne(optional = false)
    private Documentoitem coddocumentoitem;

    public Documentoitementidade() {
    }

    public Documentoitementidade(String coddocumentoitementidade) {
        this.coddocumentoitementidade = coddocumentoitementidade;
    }

    public Documentoitementidade(String coddocumentoitementidade, String nomeentidadeorigem, String identidadeorigem) {
        this.coddocumentoitementidade = coddocumentoitementidade;
        this.nomeentidadeorigem = nomeentidadeorigem;
        this.identidadeorigem = identidadeorigem;
    }

    public String getCoddocumentoitementidade() {
        return coddocumentoitementidade;
    }

    public void setCoddocumentoitementidade(String coddocumentoitementidade) {
        this.coddocumentoitementidade = coddocumentoitementidade;
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

    public Documentoitem getCoddocumentoitem() {
        return coddocumentoitem;
    }

    public void setCoddocumentoitem(Documentoitem coddocumentoitem) {
        this.coddocumentoitem = coddocumentoitem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coddocumentoitementidade != null ? coddocumentoitementidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documentoitementidade)) {
            return false;
        }
        Documentoitementidade other = (Documentoitementidade) object;
        if ((this.coddocumentoitementidade == null && other.coddocumentoitementidade != null) || (this.coddocumentoitementidade != null && !this.coddocumentoitementidade.equals(other.coddocumentoitementidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Documentoitementidade[ coddocumentoitementidade=" + coddocumentoitementidade + " ]";
    }
    
}
