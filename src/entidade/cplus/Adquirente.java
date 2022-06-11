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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ADQUIRENTE", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adquirente.findAll", query = "SELECT a FROM Adquirente a")
    , @NamedQuery(name = "Adquirente.findByCodadquirente", query = "SELECT a FROM Adquirente a WHERE a.codadquirente = :codadquirente")
    , @NamedQuery(name = "Adquirente.findByCodempresa", query = "SELECT a FROM Adquirente a WHERE a.codempresa = :codempresa")
    , @NamedQuery(name = "Adquirente.findByCodigo", query = "SELECT a FROM Adquirente a WHERE a.codigo = :codigo")
    , @NamedQuery(name = "Adquirente.findByNomeadquirente", query = "SELECT a FROM Adquirente a WHERE a.nomeadquirente = :nomeadquirente")
    , @NamedQuery(name = "Adquirente.findByMerchantid", query = "SELECT a FROM Adquirente a WHERE a.merchantid = :merchantid")
    , @NamedQuery(name = "Adquirente.findByChaverequisicao", query = "SELECT a FROM Adquirente a WHERE a.chaverequisicao = :chaverequisicao")})
public class Adquirente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODADQUIRENTE")
    private String codadquirente;
    @Column(name = "CODEMPRESA")
    private Integer codempresa;
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "NOMEADQUIRENTE")
    private String nomeadquirente;
    @Column(name = "MERCHANTID")
    private String merchantid;
    @Basic(optional = false)
    @Column(name = "CHAVEREQUISICAO")
    private String chaverequisicao;

    public Adquirente() {
    }

    public Adquirente(String codadquirente) {
        this.codadquirente = codadquirente;
    }

    public Adquirente(String codadquirente, String chaverequisicao) {
        this.codadquirente = codadquirente;
        this.chaverequisicao = chaverequisicao;
    }

    public String getCodadquirente() {
        return codadquirente;
    }

    public void setCodadquirente(String codadquirente) {
        this.codadquirente = codadquirente;
    }

    public Integer getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Integer codempresa) {
        this.codempresa = codempresa;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomeadquirente() {
        return nomeadquirente;
    }

    public void setNomeadquirente(String nomeadquirente) {
        this.nomeadquirente = nomeadquirente;
    }

    public String getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(String merchantid) {
        this.merchantid = merchantid;
    }

    public String getChaverequisicao() {
        return chaverequisicao;
    }

    public void setChaverequisicao(String chaverequisicao) {
        this.chaverequisicao = chaverequisicao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codadquirente != null ? codadquirente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Adquirente)) {
            return false;
        }
        Adquirente other = (Adquirente) object;
        if ((this.codadquirente == null && other.codadquirente != null) || (this.codadquirente != null && !this.codadquirente.equals(other.codadquirente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Adquirente[ codadquirente=" + codadquirente + " ]";
    }
    
}
