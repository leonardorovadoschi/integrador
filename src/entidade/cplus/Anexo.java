/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "ANEXO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Anexo.findAll", query = "SELECT a FROM Anexo a")
    , @NamedQuery(name = "Anexo.findByCodanexo", query = "SELECT a FROM Anexo a WHERE a.codanexo = :codanexo")
    , @NamedQuery(name = "Anexo.findByNomeentidade", query = "SELECT a FROM Anexo a WHERE a.nomeentidade = :nomeentidade")
    , @NamedQuery(name = "Anexo.findByIdentidade", query = "SELECT a FROM Anexo a WHERE a.identidade = :identidade")
    , @NamedQuery(name = "Anexo.findByCoduser", query = "SELECT a FROM Anexo a WHERE a.coduser = :coduser")
    , @NamedQuery(name = "Anexo.findByCoduserultimoacesso", query = "SELECT a FROM Anexo a WHERE a.coduserultimoacesso = :coduserultimoacesso")
    , @NamedQuery(name = "Anexo.findByDescricao", query = "SELECT a FROM Anexo a WHERE a.descricao = :descricao")
    , @NamedQuery(name = "Anexo.findByComplemento", query = "SELECT a FROM Anexo a WHERE a.complemento = :complemento")
    , @NamedQuery(name = "Anexo.findByDatainclusao", query = "SELECT a FROM Anexo a WHERE a.datainclusao = :datainclusao")
    , @NamedQuery(name = "Anexo.findByTamanhoconteudo", query = "SELECT a FROM Anexo a WHERE a.tamanhoconteudo = :tamanhoconteudo")
    , @NamedQuery(name = "Anexo.findByConfidencial", query = "SELECT a FROM Anexo a WHERE a.confidencial = :confidencial")
    , @NamedQuery(name = "Anexo.findByUltimoacesso", query = "SELECT a FROM Anexo a WHERE a.ultimoacesso = :ultimoacesso")
    , @NamedQuery(name = "Anexo.findByNomearquivo", query = "SELECT a FROM Anexo a WHERE a.nomearquivo = :nomearquivo")})
public class Anexo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODANEXO")
    private String codanexo;
    @Basic(optional = false)
    @Column(name = "NOMEENTIDADE")
    private String nomeentidade;
    @Column(name = "IDENTIDADE")
    private String identidade;
    @Column(name = "CODUSER")
    private String coduser;
    @Column(name = "CODUSERULTIMOACESSO")
    private String coduserultimoacesso;
    @Lob
    @Column(name = "CONTEUDO")
    private byte[] conteudo;
    @Column(name = "DESCRICAO")
    private String descricao;
    @Column(name = "COMPLEMENTO")
    private String complemento;
    @Column(name = "DATAINCLUSAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datainclusao;
    @Column(name = "TAMANHOCONTEUDO")
    private BigInteger tamanhoconteudo;
    @Column(name = "CONFIDENCIAL")
    private Character confidencial;
    @Column(name = "ULTIMOACESSO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimoacesso;
    @Column(name = "NOMEARQUIVO")
    private String nomearquivo;

    public Anexo() {
    }

    public Anexo(String codanexo) {
        this.codanexo = codanexo;
    }

    public Anexo(String codanexo, String nomeentidade) {
        this.codanexo = codanexo;
        this.nomeentidade = nomeentidade;
    }

    public String getCodanexo() {
        return codanexo;
    }

    public void setCodanexo(String codanexo) {
        this.codanexo = codanexo;
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

    public String getCoduser() {
        return coduser;
    }

    public void setCoduser(String coduser) {
        this.coduser = coduser;
    }

    public String getCoduserultimoacesso() {
        return coduserultimoacesso;
    }

    public void setCoduserultimoacesso(String coduserultimoacesso) {
        this.coduserultimoacesso = coduserultimoacesso;
    }

    public byte[] getConteudo() {
        return conteudo;
    }

    public void setConteudo(byte[] conteudo) {
        this.conteudo = conteudo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Date getDatainclusao() {
        return datainclusao;
    }

    public void setDatainclusao(Date datainclusao) {
        this.datainclusao = datainclusao;
    }

    public BigInteger getTamanhoconteudo() {
        return tamanhoconteudo;
    }

    public void setTamanhoconteudo(BigInteger tamanhoconteudo) {
        this.tamanhoconteudo = tamanhoconteudo;
    }

    public Character getConfidencial() {
        return confidencial;
    }

    public void setConfidencial(Character confidencial) {
        this.confidencial = confidencial;
    }

    public Date getUltimoacesso() {
        return ultimoacesso;
    }

    public void setUltimoacesso(Date ultimoacesso) {
        this.ultimoacesso = ultimoacesso;
    }

    public String getNomearquivo() {
        return nomearquivo;
    }

    public void setNomearquivo(String nomearquivo) {
        this.nomearquivo = nomearquivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codanexo != null ? codanexo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Anexo)) {
            return false;
        }
        Anexo other = (Anexo) object;
        if ((this.codanexo == null && other.codanexo != null) || (this.codanexo != null && !this.codanexo.equals(other.codanexo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Anexo[ codanexo=" + codanexo + " ]";
    }
    
}
