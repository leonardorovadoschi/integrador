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
@Table(name = "CREDENCIADASCARTAO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Credenciadascartao.findAll", query = "SELECT c FROM Credenciadascartao c")
    , @NamedQuery(name = "Credenciadascartao.findByCodcredenciadascartao", query = "SELECT c FROM Credenciadascartao c WHERE c.codcredenciadascartao = :codcredenciadascartao")
    , @NamedQuery(name = "Credenciadascartao.findByCodigosat", query = "SELECT c FROM Credenciadascartao c WHERE c.codigosat = :codigosat")
    , @NamedQuery(name = "Credenciadascartao.findByCnpj", query = "SELECT c FROM Credenciadascartao c WHERE c.cnpj = :cnpj")
    , @NamedQuery(name = "Credenciadascartao.findByNomeempresa", query = "SELECT c FROM Credenciadascartao c WHERE c.nomeempresa = :nomeempresa")})
public class Credenciadascartao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCREDENCIADASCARTAO")
    private String codcredenciadascartao;
    @Column(name = "CODIGOSAT")
    private String codigosat;
    @Column(name = "CNPJ")
    private String cnpj;
    @Column(name = "NOMEEMPRESA")
    private String nomeempresa;

    public Credenciadascartao() {
    }

    public Credenciadascartao(String codcredenciadascartao) {
        this.codcredenciadascartao = codcredenciadascartao;
    }

    public String getCodcredenciadascartao() {
        return codcredenciadascartao;
    }

    public void setCodcredenciadascartao(String codcredenciadascartao) {
        this.codcredenciadascartao = codcredenciadascartao;
    }

    public String getCodigosat() {
        return codigosat;
    }

    public void setCodigosat(String codigosat) {
        this.codigosat = codigosat;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeempresa() {
        return nomeempresa;
    }

    public void setNomeempresa(String nomeempresa) {
        this.nomeempresa = nomeempresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcredenciadascartao != null ? codcredenciadascartao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Credenciadascartao)) {
            return false;
        }
        Credenciadascartao other = (Credenciadascartao) object;
        if ((this.codcredenciadascartao == null && other.codcredenciadascartao != null) || (this.codcredenciadascartao != null && !this.codcredenciadascartao.equals(other.codcredenciadascartao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Credenciadascartao[ codcredenciadascartao=" + codcredenciadascartao + " ]";
    }
    
}
