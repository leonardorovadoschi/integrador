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
@Table(name = "CAMPOUSUARIO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Campousuario.findAll", query = "SELECT c FROM Campousuario c")
    , @NamedQuery(name = "Campousuario.findByCodcampousuario", query = "SELECT c FROM Campousuario c WHERE c.codcampousuario = :codcampousuario")
    , @NamedQuery(name = "Campousuario.findByCodigo", query = "SELECT c FROM Campousuario c WHERE c.codigo = :codigo")
    , @NamedQuery(name = "Campousuario.findByNomecampousuario", query = "SELECT c FROM Campousuario c WHERE c.nomecampousuario = :nomecampousuario")
    , @NamedQuery(name = "Campousuario.findByTipocampo", query = "SELECT c FROM Campousuario c WHERE c.tipocampo = :tipocampo")})
public class Campousuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCAMPOUSUARIO")
    private String codcampousuario;
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "NOMECAMPOUSUARIO")
    private String nomecampousuario;
    @Column(name = "TIPOCAMPO")
    private Character tipocampo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codcampousuario")
    private Collection<ClienteequipCampousuario> clienteequipCampousuarioCollection;

    public Campousuario() {
    }

    public Campousuario(String codcampousuario) {
        this.codcampousuario = codcampousuario;
    }

    public Campousuario(String codcampousuario, String codigo) {
        this.codcampousuario = codcampousuario;
        this.codigo = codigo;
    }

    public String getCodcampousuario() {
        return codcampousuario;
    }

    public void setCodcampousuario(String codcampousuario) {
        this.codcampousuario = codcampousuario;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomecampousuario() {
        return nomecampousuario;
    }

    public void setNomecampousuario(String nomecampousuario) {
        this.nomecampousuario = nomecampousuario;
    }

    public Character getTipocampo() {
        return tipocampo;
    }

    public void setTipocampo(Character tipocampo) {
        this.tipocampo = tipocampo;
    }

    @XmlTransient
    public Collection<ClienteequipCampousuario> getClienteequipCampousuarioCollection() {
        return clienteequipCampousuarioCollection;
    }

    public void setClienteequipCampousuarioCollection(Collection<ClienteequipCampousuario> clienteequipCampousuarioCollection) {
        this.clienteequipCampousuarioCollection = clienteequipCampousuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcampousuario != null ? codcampousuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Campousuario)) {
            return false;
        }
        Campousuario other = (Campousuario) object;
        if ((this.codcampousuario == null && other.codcampousuario != null) || (this.codcampousuario != null && !this.codcampousuario.equals(other.codcampousuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Campousuario[ codcampousuario=" + codcampousuario + " ]";
    }
    
}
