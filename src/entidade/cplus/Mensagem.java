/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "MENSAGEM", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mensagem.findAll", query = "SELECT m FROM Mensagem m")
    , @NamedQuery(name = "Mensagem.findByCodmensagem", query = "SELECT m FROM Mensagem m WHERE m.codmensagem = :codmensagem")
    , @NamedQuery(name = "Mensagem.findByCodigo", query = "SELECT m FROM Mensagem m WHERE m.codigo = :codigo")
    , @NamedQuery(name = "Mensagem.findByMensagem", query = "SELECT m FROM Mensagem m WHERE m.mensagem = :mensagem")
    , @NamedQuery(name = "Mensagem.findByListauf", query = "SELECT m FROM Mensagem m WHERE m.listauf = :listauf")
    , @NamedQuery(name = "Mensagem.findByFlagafv", query = "SELECT m FROM Mensagem m WHERE m.flagafv = :flagafv")})
public class Mensagem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODMENSAGEM")
    private String codmensagem;
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "MENSAGEM")
    private String mensagem;
    @Column(name = "LISTAUF")
    private String listauf;
    @Column(name = "FLAGAFV")
    private Character flagafv;
    @OneToMany(mappedBy = "codmensagem")
    private Collection<Calculoicmsestado> calculoicmsestadoCollection;
    @OneToMany(mappedBy = "codmensagem")
    private Collection<Produto> produtoCollection;

    public Mensagem() {
    }

    public Mensagem(String codmensagem) {
        this.codmensagem = codmensagem;
    }

    public String getCodmensagem() {
        return codmensagem;
    }

    public void setCodmensagem(String codmensagem) {
        this.codmensagem = codmensagem;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getListauf() {
        return listauf;
    }

    public void setListauf(String listauf) {
        this.listauf = listauf;
    }

    public Character getFlagafv() {
        return flagafv;
    }

    public void setFlagafv(Character flagafv) {
        this.flagafv = flagafv;
    }

    @XmlTransient
    public Collection<Calculoicmsestado> getCalculoicmsestadoCollection() {
        return calculoicmsestadoCollection;
    }

    public void setCalculoicmsestadoCollection(Collection<Calculoicmsestado> calculoicmsestadoCollection) {
        this.calculoicmsestadoCollection = calculoicmsestadoCollection;
    }

    @XmlTransient
    public Collection<Produto> getProdutoCollection() {
        return produtoCollection;
    }

    public void setProdutoCollection(Collection<Produto> produtoCollection) {
        this.produtoCollection = produtoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codmensagem != null ? codmensagem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mensagem)) {
            return false;
        }
        Mensagem other = (Mensagem) object;
        if ((this.codmensagem == null && other.codmensagem != null) || (this.codmensagem != null && !this.codmensagem.equals(other.codmensagem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Mensagem[ codmensagem=" + codmensagem + " ]";
    }
    
}
