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
@Table(name = "REGIAO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Regiao.findAll", query = "SELECT r FROM Regiao r")
    , @NamedQuery(name = "Regiao.findByCodregiao", query = "SELECT r FROM Regiao r WHERE r.codregiao = :codregiao")
    , @NamedQuery(name = "Regiao.findByNomeregiao", query = "SELECT r FROM Regiao r WHERE r.nomeregiao = :nomeregiao")
    , @NamedQuery(name = "Regiao.findByCodigo", query = "SELECT r FROM Regiao r WHERE r.codigo = :codigo")
    , @NamedQuery(name = "Regiao.findByPlaca", query = "SELECT r FROM Regiao r WHERE r.placa = :placa")})
public class Regiao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODREGIAO")
    private String codregiao;
    @Basic(optional = false)
    @Column(name = "NOMEREGIAO")
    private String nomeregiao;
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "PLACA")
    private String placa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codregiao")
    private Collection<Regiaocidade> regiaocidadeCollection;

    public Regiao() {
    }

    public Regiao(String codregiao) {
        this.codregiao = codregiao;
    }

    public Regiao(String codregiao, String nomeregiao) {
        this.codregiao = codregiao;
        this.nomeregiao = nomeregiao;
    }

    public String getCodregiao() {
        return codregiao;
    }

    public void setCodregiao(String codregiao) {
        this.codregiao = codregiao;
    }

    public String getNomeregiao() {
        return nomeregiao;
    }

    public void setNomeregiao(String nomeregiao) {
        this.nomeregiao = nomeregiao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @XmlTransient
    public Collection<Regiaocidade> getRegiaocidadeCollection() {
        return regiaocidadeCollection;
    }

    public void setRegiaocidadeCollection(Collection<Regiaocidade> regiaocidadeCollection) {
        this.regiaocidadeCollection = regiaocidadeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codregiao != null ? codregiao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Regiao)) {
            return false;
        }
        Regiao other = (Regiao) object;
        if ((this.codregiao == null && other.codregiao != null) || (this.codregiao != null && !this.codregiao.equals(other.codregiao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Regiao[ codregiao=" + codregiao + " ]";
    }
    
}
