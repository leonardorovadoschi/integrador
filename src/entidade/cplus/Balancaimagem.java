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
@Table(name = "BALANCAIMAGEM", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Balancaimagem.findAll", query = "SELECT b FROM Balancaimagem b")
    , @NamedQuery(name = "Balancaimagem.findByCodbalancaimagem", query = "SELECT b FROM Balancaimagem b WHERE b.codbalancaimagem = :codbalancaimagem")
    , @NamedQuery(name = "Balancaimagem.findByCodigo", query = "SELECT b FROM Balancaimagem b WHERE b.codigo = :codigo")
    , @NamedQuery(name = "Balancaimagem.findByNomebalancaimagem", query = "SELECT b FROM Balancaimagem b WHERE b.nomebalancaimagem = :nomebalancaimagem")
    , @NamedQuery(name = "Balancaimagem.findByFlagmarca", query = "SELECT b FROM Balancaimagem b WHERE b.flagmarca = :flagmarca")})
public class Balancaimagem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODBALANCAIMAGEM")
    private String codbalancaimagem;
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "NOMEBALANCAIMAGEM")
    private String nomebalancaimagem;
    @Basic(optional = false)
    @Column(name = "FLAGMARCA")
    private Character flagmarca;

    public Balancaimagem() {
    }

    public Balancaimagem(String codbalancaimagem) {
        this.codbalancaimagem = codbalancaimagem;
    }

    public Balancaimagem(String codbalancaimagem, Character flagmarca) {
        this.codbalancaimagem = codbalancaimagem;
        this.flagmarca = flagmarca;
    }

    public String getCodbalancaimagem() {
        return codbalancaimagem;
    }

    public void setCodbalancaimagem(String codbalancaimagem) {
        this.codbalancaimagem = codbalancaimagem;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomebalancaimagem() {
        return nomebalancaimagem;
    }

    public void setNomebalancaimagem(String nomebalancaimagem) {
        this.nomebalancaimagem = nomebalancaimagem;
    }

    public Character getFlagmarca() {
        return flagmarca;
    }

    public void setFlagmarca(Character flagmarca) {
        this.flagmarca = flagmarca;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codbalancaimagem != null ? codbalancaimagem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Balancaimagem)) {
            return false;
        }
        Balancaimagem other = (Balancaimagem) object;
        if ((this.codbalancaimagem == null && other.codbalancaimagem != null) || (this.codbalancaimagem != null && !this.codbalancaimagem.equals(other.codbalancaimagem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Balancaimagem[ codbalancaimagem=" + codbalancaimagem + " ]";
    }
    
}
