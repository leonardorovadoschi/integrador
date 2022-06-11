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
@Table(name = "CONSULTASPCENTIDADES", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consultaspcentidades.findAll", query = "SELECT c FROM Consultaspcentidades c")
    , @NamedQuery(name = "Consultaspcentidades.findByCodentidades", query = "SELECT c FROM Consultaspcentidades c WHERE c.codentidades = :codentidades")
    , @NamedQuery(name = "Consultaspcentidades.findByCodigo", query = "SELECT c FROM Consultaspcentidades c WHERE c.codigo = :codigo")
    , @NamedQuery(name = "Consultaspcentidades.findByDescricao", query = "SELECT c FROM Consultaspcentidades c WHERE c.descricao = :descricao")})
public class Consultaspcentidades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODENTIDADES")
    private String codentidades;
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "DESCRICAO")
    private String descricao;

    public Consultaspcentidades() {
    }

    public Consultaspcentidades(String codentidades) {
        this.codentidades = codentidades;
    }

    public String getCodentidades() {
        return codentidades;
    }

    public void setCodentidades(String codentidades) {
        this.codentidades = codentidades;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codentidades != null ? codentidades.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consultaspcentidades)) {
            return false;
        }
        Consultaspcentidades other = (Consultaspcentidades) object;
        if ((this.codentidades == null && other.codentidades != null) || (this.codentidades != null && !this.codentidades.equals(other.codentidades))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Consultaspcentidades[ codentidades=" + codentidades + " ]";
    }
    
}
