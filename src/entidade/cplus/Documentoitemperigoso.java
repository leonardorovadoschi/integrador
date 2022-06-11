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
@Table(name = "DOCUMENTOITEMPERIGOSO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Documentoitemperigoso.findAll", query = "SELECT d FROM Documentoitemperigoso d")
    , @NamedQuery(name = "Documentoitemperigoso.findByCoddocumentoitemperigoso", query = "SELECT d FROM Documentoitemperigoso d WHERE d.coddocumentoitemperigoso = :coddocumentoitemperigoso")
    , @NamedQuery(name = "Documentoitemperigoso.findByCodigoonu", query = "SELECT d FROM Documentoitemperigoso d WHERE d.codigoonu = :codigoonu")
    , @NamedQuery(name = "Documentoitemperigoso.findByDescricaoprodutoperigosoclasse", query = "SELECT d FROM Documentoitemperigoso d WHERE d.descricaoprodutoperigosoclasse = :descricaoprodutoperigosoclasse")
    , @NamedQuery(name = "Documentoitemperigoso.findByNomeprodembarque", query = "SELECT d FROM Documentoitemperigoso d WHERE d.nomeprodembarque = :nomeprodembarque")
    , @NamedQuery(name = "Documentoitemperigoso.findByCodigogrupoembalagem", query = "SELECT d FROM Documentoitemperigoso d WHERE d.codigogrupoembalagem = :codigogrupoembalagem")})
public class Documentoitemperigoso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODDOCUMENTOITEMPERIGOSO")
    private String coddocumentoitemperigoso;
    @Column(name = "CODIGOONU")
    private String codigoonu;
    @Column(name = "DESCRICAOPRODUTOPERIGOSOCLASSE")
    private String descricaoprodutoperigosoclasse;
    @Column(name = "NOMEPRODEMBARQUE")
    private String nomeprodembarque;
    @Column(name = "CODIGOGRUPOEMBALAGEM")
    private String codigogrupoembalagem;
    @JoinColumn(name = "CODDOCUMENTOITEM", referencedColumnName = "CODDOCUMENTOITEM")
    @ManyToOne(optional = false)
    private Documentoitem coddocumentoitem;

    public Documentoitemperigoso() {
    }

    public Documentoitemperigoso(String coddocumentoitemperigoso) {
        this.coddocumentoitemperigoso = coddocumentoitemperigoso;
    }

    public String getCoddocumentoitemperigoso() {
        return coddocumentoitemperigoso;
    }

    public void setCoddocumentoitemperigoso(String coddocumentoitemperigoso) {
        this.coddocumentoitemperigoso = coddocumentoitemperigoso;
    }

    public String getCodigoonu() {
        return codigoonu;
    }

    public void setCodigoonu(String codigoonu) {
        this.codigoonu = codigoonu;
    }

    public String getDescricaoprodutoperigosoclasse() {
        return descricaoprodutoperigosoclasse;
    }

    public void setDescricaoprodutoperigosoclasse(String descricaoprodutoperigosoclasse) {
        this.descricaoprodutoperigosoclasse = descricaoprodutoperigosoclasse;
    }

    public String getNomeprodembarque() {
        return nomeprodembarque;
    }

    public void setNomeprodembarque(String nomeprodembarque) {
        this.nomeprodembarque = nomeprodembarque;
    }

    public String getCodigogrupoembalagem() {
        return codigogrupoembalagem;
    }

    public void setCodigogrupoembalagem(String codigogrupoembalagem) {
        this.codigogrupoembalagem = codigogrupoembalagem;
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
        hash += (coddocumentoitemperigoso != null ? coddocumentoitemperigoso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documentoitemperigoso)) {
            return false;
        }
        Documentoitemperigoso other = (Documentoitemperigoso) object;
        if ((this.coddocumentoitemperigoso == null && other.coddocumentoitemperigoso != null) || (this.coddocumentoitemperigoso != null && !this.coddocumentoitemperigoso.equals(other.coddocumentoitemperigoso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Documentoitemperigoso[ coddocumentoitemperigoso=" + coddocumentoitemperigoso + " ]";
    }
    
}
