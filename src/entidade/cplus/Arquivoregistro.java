/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "ARQUIVOREGISTRO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Arquivoregistro.findAll", query = "SELECT a FROM Arquivoregistro a")
    , @NamedQuery(name = "Arquivoregistro.findByCodarquivoregistro", query = "SELECT a FROM Arquivoregistro a WHERE a.codarquivoregistro = :codarquivoregistro")
    , @NamedQuery(name = "Arquivoregistro.findByCodbanco", query = "SELECT a FROM Arquivoregistro a WHERE a.codbanco = :codbanco")
    , @NamedQuery(name = "Arquivoregistro.findByCodigo", query = "SELECT a FROM Arquivoregistro a WHERE a.codigo = :codigo")
    , @NamedQuery(name = "Arquivoregistro.findByTiporegistro", query = "SELECT a FROM Arquivoregistro a WHERE a.tiporegistro = :tiporegistro")
    , @NamedQuery(name = "Arquivoregistro.findByFinalidade", query = "SELECT a FROM Arquivoregistro a WHERE a.finalidade = :finalidade")
    , @NamedQuery(name = "Arquivoregistro.findByObservacao", query = "SELECT a FROM Arquivoregistro a WHERE a.observacao = :observacao")})
public class Arquivoregistro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODARQUIVOREGISTRO")
    private String codarquivoregistro;
    @Basic(optional = false)
    @Column(name = "CODBANCO")
    private String codbanco;
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "TIPOREGISTRO")
    private String tiporegistro;
    @Column(name = "FINALIDADE")
    private String finalidade;
    @Column(name = "OBSERVACAO")
    private String observacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codarquivoregistro")
    private Collection<Arquivovariavel> arquivovariavelCollection;
    @OneToMany(mappedBy = "codarquivoregistro")
    private Collection<Montagemarquivoitem> montagemarquivoitemCollection;

    public Arquivoregistro() {
    }

    public Arquivoregistro(String codarquivoregistro) {
        this.codarquivoregistro = codarquivoregistro;
    }

    public Arquivoregistro(String codarquivoregistro, String codbanco, String codigo) {
        this.codarquivoregistro = codarquivoregistro;
        this.codbanco = codbanco;
        this.codigo = codigo;
    }

    public String getCodarquivoregistro() {
        return codarquivoregistro;
    }

    public void setCodarquivoregistro(String codarquivoregistro) {
        this.codarquivoregistro = codarquivoregistro;
    }

    public String getCodbanco() {
        return codbanco;
    }

    public void setCodbanco(String codbanco) {
        this.codbanco = codbanco;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTiporegistro() {
        return tiporegistro;
    }

    public void setTiporegistro(String tiporegistro) {
        this.tiporegistro = tiporegistro;
    }

    public String getFinalidade() {
        return finalidade;
    }

    public void setFinalidade(String finalidade) {
        this.finalidade = finalidade;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @XmlTransient
    public Collection<Arquivovariavel> getArquivovariavelCollection() {
        return arquivovariavelCollection;
    }

    public void setArquivovariavelCollection(Collection<Arquivovariavel> arquivovariavelCollection) {
        this.arquivovariavelCollection = arquivovariavelCollection;
    }

    @XmlTransient
    public Collection<Montagemarquivoitem> getMontagemarquivoitemCollection() {
        return montagemarquivoitemCollection;
    }

    public void setMontagemarquivoitemCollection(Collection<Montagemarquivoitem> montagemarquivoitemCollection) {
        this.montagemarquivoitemCollection = montagemarquivoitemCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codarquivoregistro != null ? codarquivoregistro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Arquivoregistro)) {
            return false;
        }
        Arquivoregistro other = (Arquivoregistro) object;
        if ((this.codarquivoregistro == null && other.codarquivoregistro != null) || (this.codarquivoregistro != null && !this.codarquivoregistro.equals(other.codarquivoregistro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Arquivoregistro[ codarquivoregistro=" + codarquivoregistro + " ]";
    }
    
}
