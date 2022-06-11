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
@Table(name = "NFELETRONICAEXCECAO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nfeletronicaexcecao.findAll", query = "SELECT n FROM Nfeletronicaexcecao n")
    , @NamedQuery(name = "Nfeletronicaexcecao.findByCodigo", query = "SELECT n FROM Nfeletronicaexcecao n WHERE n.codigo = :codigo")
    , @NamedQuery(name = "Nfeletronicaexcecao.findByExcecao", query = "SELECT n FROM Nfeletronicaexcecao n WHERE n.excecao = :excecao")})
public class Nfeletronicaexcecao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "EXCECAO")
    private String excecao;

    public Nfeletronicaexcecao() {
    }

    public Nfeletronicaexcecao(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getExcecao() {
        return excecao;
    }

    public void setExcecao(String excecao) {
        this.excecao = excecao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nfeletronicaexcecao)) {
            return false;
        }
        Nfeletronicaexcecao other = (Nfeletronicaexcecao) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Nfeletronicaexcecao[ codigo=" + codigo + " ]";
    }
    
}
