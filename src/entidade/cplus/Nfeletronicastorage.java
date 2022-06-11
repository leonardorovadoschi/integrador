/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "NFELETRONICASTORAGE", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nfeletronicastorage.findAll", query = "SELECT n FROM Nfeletronicastorage n")
    , @NamedQuery(name = "Nfeletronicastorage.findByChaveacesso", query = "SELECT n FROM Nfeletronicastorage n WHERE n.chaveacesso = :chaveacesso")
    , @NamedQuery(name = "Nfeletronicastorage.findByFlagtipo", query = "SELECT n FROM Nfeletronicastorage n WHERE n.flagtipo = :flagtipo")
    , @NamedQuery(name = "Nfeletronicastorage.findByDatacadastro", query = "SELECT n FROM Nfeletronicastorage n WHERE n.datacadastro = :datacadastro")})
public class Nfeletronicastorage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CHAVEACESSO")
    private String chaveacesso;
    @Column(name = "FLAGTIPO")
    private Character flagtipo;
    @Column(name = "DATACADASTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datacadastro;

    public Nfeletronicastorage() {
    }

    public Nfeletronicastorage(String chaveacesso) {
        this.chaveacesso = chaveacesso;
    }

    public String getChaveacesso() {
        return chaveacesso;
    }

    public void setChaveacesso(String chaveacesso) {
        this.chaveacesso = chaveacesso;
    }

    public Character getFlagtipo() {
        return flagtipo;
    }

    public void setFlagtipo(Character flagtipo) {
        this.flagtipo = flagtipo;
    }

    public Date getDatacadastro() {
        return datacadastro;
    }

    public void setDatacadastro(Date datacadastro) {
        this.datacadastro = datacadastro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chaveacesso != null ? chaveacesso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nfeletronicastorage)) {
            return false;
        }
        Nfeletronicastorage other = (Nfeletronicastorage) object;
        if ((this.chaveacesso == null && other.chaveacesso != null) || (this.chaveacesso != null && !this.chaveacesso.equals(other.chaveacesso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Nfeletronicastorage[ chaveacesso=" + chaveacesso + " ]";
    }
    
}
