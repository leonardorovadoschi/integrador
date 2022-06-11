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
@Table(name = "ARQUIVOVARIAVEL", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Arquivovariavel.findAll", query = "SELECT a FROM Arquivovariavel a")
    , @NamedQuery(name = "Arquivovariavel.findByCodarquivovariavel", query = "SELECT a FROM Arquivovariavel a WHERE a.codarquivovariavel = :codarquivovariavel")
    , @NamedQuery(name = "Arquivovariavel.findByConteudo", query = "SELECT a FROM Arquivovariavel a WHERE a.conteudo = :conteudo")
    , @NamedQuery(name = "Arquivovariavel.findByFormatodata", query = "SELECT a FROM Arquivovariavel a WHERE a.formatodata = :formatodata")
    , @NamedQuery(name = "Arquivovariavel.findByNomevariavel", query = "SELECT a FROM Arquivovariavel a WHERE a.nomevariavel = :nomevariavel")
    , @NamedQuery(name = "Arquivovariavel.findByNumposde", query = "SELECT a FROM Arquivovariavel a WHERE a.numposde = :numposde")
    , @NamedQuery(name = "Arquivovariavel.findByNumposate", query = "SELECT a FROM Arquivovariavel a WHERE a.numposate = :numposate")
    , @NamedQuery(name = "Arquivovariavel.findByFlagtipovariavel", query = "SELECT a FROM Arquivovariavel a WHERE a.flagtipovariavel = :flagtipovariavel")
    , @NamedQuery(name = "Arquivovariavel.findByDescricao", query = "SELECT a FROM Arquivovariavel a WHERE a.descricao = :descricao")})
public class Arquivovariavel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODARQUIVOVARIAVEL")
    private String codarquivovariavel;
    @Column(name = "CONTEUDO")
    private String conteudo;
    @Column(name = "FORMATODATA")
    private String formatodata;
    @Column(name = "NOMEVARIAVEL")
    private String nomevariavel;
    @Column(name = "NUMPOSDE")
    private Integer numposde;
    @Column(name = "NUMPOSATE")
    private Integer numposate;
    @Column(name = "FLAGTIPOVARIAVEL")
    private Character flagtipovariavel;
    @Column(name = "DESCRICAO")
    private String descricao;
    @JoinColumn(name = "CODARQUIVOREGISTRO", referencedColumnName = "CODARQUIVOREGISTRO")
    @ManyToOne(optional = false)
    private Arquivoregistro codarquivoregistro;

    public Arquivovariavel() {
    }

    public Arquivovariavel(String codarquivovariavel) {
        this.codarquivovariavel = codarquivovariavel;
    }

    public String getCodarquivovariavel() {
        return codarquivovariavel;
    }

    public void setCodarquivovariavel(String codarquivovariavel) {
        this.codarquivovariavel = codarquivovariavel;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getFormatodata() {
        return formatodata;
    }

    public void setFormatodata(String formatodata) {
        this.formatodata = formatodata;
    }

    public String getNomevariavel() {
        return nomevariavel;
    }

    public void setNomevariavel(String nomevariavel) {
        this.nomevariavel = nomevariavel;
    }

    public Integer getNumposde() {
        return numposde;
    }

    public void setNumposde(Integer numposde) {
        this.numposde = numposde;
    }

    public Integer getNumposate() {
        return numposate;
    }

    public void setNumposate(Integer numposate) {
        this.numposate = numposate;
    }

    public Character getFlagtipovariavel() {
        return flagtipovariavel;
    }

    public void setFlagtipovariavel(Character flagtipovariavel) {
        this.flagtipovariavel = flagtipovariavel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Arquivoregistro getCodarquivoregistro() {
        return codarquivoregistro;
    }

    public void setCodarquivoregistro(Arquivoregistro codarquivoregistro) {
        this.codarquivoregistro = codarquivoregistro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codarquivovariavel != null ? codarquivovariavel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Arquivovariavel)) {
            return false;
        }
        Arquivovariavel other = (Arquivovariavel) object;
        if ((this.codarquivovariavel == null && other.codarquivovariavel != null) || (this.codarquivovariavel != null && !this.codarquivovariavel.equals(other.codarquivovariavel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Arquivovariavel[ codarquivovariavel=" + codarquivovariavel + " ]";
    }
    
}
