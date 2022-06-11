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
@Table(name = "DOCUMENTOENTIDADE", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Documentoentidade.findAll", query = "SELECT d FROM Documentoentidade d")
    , @NamedQuery(name = "Documentoentidade.findByCoddocumentoentidade", query = "SELECT d FROM Documentoentidade d WHERE d.coddocumentoentidade = :coddocumentoentidade")
    , @NamedQuery(name = "Documentoentidade.findByNomeentidadeorigem", query = "SELECT d FROM Documentoentidade d WHERE d.nomeentidadeorigem = :nomeentidadeorigem")
    , @NamedQuery(name = "Documentoentidade.findByIdentidadeorigem", query = "SELECT d FROM Documentoentidade d WHERE d.identidadeorigem = :identidadeorigem")})
public class Documentoentidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODDOCUMENTOENTIDADE")
    private String coddocumentoentidade;
    @Basic(optional = false)
    @Column(name = "NOMEENTIDADEORIGEM")
    private String nomeentidadeorigem;
    @Basic(optional = false)
    @Column(name = "IDENTIDADEORIGEM")
    private String identidadeorigem;
    @JoinColumn(name = "CODDOCUMENTO", referencedColumnName = "CODDOCUMENTO")
    @ManyToOne(optional = false)
    private Documento coddocumento;

    public Documentoentidade() {
    }

    public Documentoentidade(String coddocumentoentidade) {
        this.coddocumentoentidade = coddocumentoentidade;
    }

    public Documentoentidade(String coddocumentoentidade, String nomeentidadeorigem, String identidadeorigem) {
        this.coddocumentoentidade = coddocumentoentidade;
        this.nomeentidadeorigem = nomeentidadeorigem;
        this.identidadeorigem = identidadeorigem;
    }

    public String getCoddocumentoentidade() {
        return coddocumentoentidade;
    }

    public void setCoddocumentoentidade(String coddocumentoentidade) {
        this.coddocumentoentidade = coddocumentoentidade;
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

    public Documento getCoddocumento() {
        return coddocumento;
    }

    public void setCoddocumento(Documento coddocumento) {
        this.coddocumento = coddocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coddocumentoentidade != null ? coddocumentoentidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documentoentidade)) {
            return false;
        }
        Documentoentidade other = (Documentoentidade) object;
        if ((this.coddocumentoentidade == null && other.coddocumentoentidade != null) || (this.coddocumentoentidade != null && !this.coddocumentoentidade.equals(other.coddocumentoentidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Documentoentidade[ coddocumentoentidade=" + coddocumentoentidade + " ]";
    }
    
}
