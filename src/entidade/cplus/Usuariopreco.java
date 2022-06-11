/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "USUARIOPRECO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuariopreco.findAll", query = "SELECT u FROM Usuariopreco u")
    , @NamedQuery(name = "Usuariopreco.findByCodusuariopreco", query = "SELECT u FROM Usuariopreco u WHERE u.codusuariopreco = :codusuariopreco")
    , @NamedQuery(name = "Usuariopreco.findByDescontomaximo", query = "SELECT u FROM Usuariopreco u WHERE u.descontomaximo = :descontomaximo")
    , @NamedQuery(name = "Usuariopreco.findByFlagnaoutilizar", query = "SELECT u FROM Usuariopreco u WHERE u.flagnaoutilizar = :flagnaoutilizar")})
public class Usuariopreco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODUSUARIOPRECO")
    private String codusuariopreco;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DESCONTOMAXIMO")
    private BigDecimal descontomaximo;
    @Column(name = "FLAGNAOUTILIZAR")
    private Character flagnaoutilizar;
    @JoinColumn(name = "CODPRECO", referencedColumnName = "CODPRECO")
    @ManyToOne
    private Preco codpreco;
    @JoinColumn(name = "CODUSER", referencedColumnName = "CODUSER")
    @ManyToOne(optional = false)
    private Usuario coduser;

    public Usuariopreco() {
    }

    public Usuariopreco(String codusuariopreco) {
        this.codusuariopreco = codusuariopreco;
    }

    public String getCodusuariopreco() {
        return codusuariopreco;
    }

    public void setCodusuariopreco(String codusuariopreco) {
        this.codusuariopreco = codusuariopreco;
    }

    public BigDecimal getDescontomaximo() {
        return descontomaximo;
    }

    public void setDescontomaximo(BigDecimal descontomaximo) {
        this.descontomaximo = descontomaximo;
    }

    public Character getFlagnaoutilizar() {
        return flagnaoutilizar;
    }

    public void setFlagnaoutilizar(Character flagnaoutilizar) {
        this.flagnaoutilizar = flagnaoutilizar;
    }

    public Preco getCodpreco() {
        return codpreco;
    }

    public void setCodpreco(Preco codpreco) {
        this.codpreco = codpreco;
    }

    public Usuario getCoduser() {
        return coduser;
    }

    public void setCoduser(Usuario coduser) {
        this.coduser = coduser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codusuariopreco != null ? codusuariopreco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuariopreco)) {
            return false;
        }
        Usuariopreco other = (Usuariopreco) object;
        if ((this.codusuariopreco == null && other.codusuariopreco != null) || (this.codusuariopreco != null && !this.codusuariopreco.equals(other.codusuariopreco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Usuariopreco[ codusuariopreco=" + codusuariopreco + " ]";
    }
    
}
