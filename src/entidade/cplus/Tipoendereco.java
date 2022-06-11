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
@Table(name = "TIPOENDERECO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipoendereco.findAll", query = "SELECT t FROM Tipoendereco t")
    , @NamedQuery(name = "Tipoendereco.findByCodtipoendereco", query = "SELECT t FROM Tipoendereco t WHERE t.codtipoendereco = :codtipoendereco")
    , @NamedQuery(name = "Tipoendereco.findByCodigo", query = "SELECT t FROM Tipoendereco t WHERE t.codigo = :codigo")
    , @NamedQuery(name = "Tipoendereco.findByNometipoendereco", query = "SELECT t FROM Tipoendereco t WHERE t.nometipoendereco = :nometipoendereco")})
public class Tipoendereco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODTIPOENDERECO")
    private String codtipoendereco;
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "NOMETIPOENDERECO")
    private String nometipoendereco;
    @OneToMany(mappedBy = "codtipoendereco")
    private Collection<Clienteendereco> clienteenderecoCollection;

    public Tipoendereco() {
    }

    public Tipoendereco(String codtipoendereco) {
        this.codtipoendereco = codtipoendereco;
    }

    public String getCodtipoendereco() {
        return codtipoendereco;
    }

    public void setCodtipoendereco(String codtipoendereco) {
        this.codtipoendereco = codtipoendereco;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNometipoendereco() {
        return nometipoendereco;
    }

    public void setNometipoendereco(String nometipoendereco) {
        this.nometipoendereco = nometipoendereco;
    }

    @XmlTransient
    public Collection<Clienteendereco> getClienteenderecoCollection() {
        return clienteenderecoCollection;
    }

    public void setClienteenderecoCollection(Collection<Clienteendereco> clienteenderecoCollection) {
        this.clienteenderecoCollection = clienteenderecoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codtipoendereco != null ? codtipoendereco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoendereco)) {
            return false;
        }
        Tipoendereco other = (Tipoendereco) object;
        if ((this.codtipoendereco == null && other.codtipoendereco != null) || (this.codtipoendereco != null && !this.codtipoendereco.equals(other.codtipoendereco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Tipoendereco[ codtipoendereco=" + codtipoendereco + " ]";
    }
    
}
