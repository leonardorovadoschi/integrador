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
@Table(name = "PRODUCAO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producao.findAll", query = "SELECT p FROM Producao p")
    , @NamedQuery(name = "Producao.findByCodproducao", query = "SELECT p FROM Producao p WHERE p.codproducao = :codproducao")
    , @NamedQuery(name = "Producao.findByCodigo", query = "SELECT p FROM Producao p WHERE p.codigo = :codigo")
    , @NamedQuery(name = "Producao.findByNomeproducao", query = "SELECT p FROM Producao p WHERE p.nomeproducao = :nomeproducao")
    , @NamedQuery(name = "Producao.findByFlagproduzido", query = "SELECT p FROM Producao p WHERE p.flagproduzido = :flagproduzido")})
public class Producao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODPRODUCAO")
    private String codproducao;
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "NOMEPRODUCAO")
    private String nomeproducao;
    @Column(name = "FLAGPRODUZIDO")
    private Character flagproduzido;

    public Producao() {
    }

    public Producao(String codproducao) {
        this.codproducao = codproducao;
    }

    public String getCodproducao() {
        return codproducao;
    }

    public void setCodproducao(String codproducao) {
        this.codproducao = codproducao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomeproducao() {
        return nomeproducao;
    }

    public void setNomeproducao(String nomeproducao) {
        this.nomeproducao = nomeproducao;
    }

    public Character getFlagproduzido() {
        return flagproduzido;
    }

    public void setFlagproduzido(Character flagproduzido) {
        this.flagproduzido = flagproduzido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codproducao != null ? codproducao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producao)) {
            return false;
        }
        Producao other = (Producao) object;
        if ((this.codproducao == null && other.codproducao != null) || (this.codproducao != null && !this.codproducao.equals(other.codproducao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Producao[ codproducao=" + codproducao + " ]";
    }
    
}
