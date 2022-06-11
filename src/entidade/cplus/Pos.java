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
@Table(name = "POS", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pos.findAll", query = "SELECT p FROM Pos p")
    , @NamedQuery(name = "Pos.findByCodpos", query = "SELECT p FROM Pos p WHERE p.codpos = :codpos")
    , @NamedQuery(name = "Pos.findByCodempresa", query = "SELECT p FROM Pos p WHERE p.codempresa = :codempresa")
    , @NamedQuery(name = "Pos.findByCodigo", query = "SELECT p FROM Pos p WHERE p.codigo = :codigo")
    , @NamedQuery(name = "Pos.findByNomepos", query = "SELECT p FROM Pos p WHERE p.nomepos = :nomepos")
    , @NamedQuery(name = "Pos.findBySerialpos", query = "SELECT p FROM Pos p WHERE p.serialpos = :serialpos")
    , @NamedQuery(name = "Pos.findByCodadquirente", query = "SELECT p FROM Pos p WHERE p.codadquirente = :codadquirente")
    , @NamedQuery(name = "Pos.findByInativo", query = "SELECT p FROM Pos p WHERE p.inativo = :inativo")})
public class Pos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODPOS")
    private String codpos;
    @Column(name = "CODEMPRESA")
    private Integer codempresa;
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "NOMEPOS")
    private String nomepos;
    @Column(name = "SERIALPOS")
    private String serialpos;
    @Basic(optional = false)
    @Column(name = "CODADQUIRENTE")
    private String codadquirente;
    @Column(name = "INATIVO")
    private Character inativo;

    public Pos() {
    }

    public Pos(String codpos) {
        this.codpos = codpos;
    }

    public Pos(String codpos, String codadquirente) {
        this.codpos = codpos;
        this.codadquirente = codadquirente;
    }

    public String getCodpos() {
        return codpos;
    }

    public void setCodpos(String codpos) {
        this.codpos = codpos;
    }

    public Integer getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Integer codempresa) {
        this.codempresa = codempresa;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomepos() {
        return nomepos;
    }

    public void setNomepos(String nomepos) {
        this.nomepos = nomepos;
    }

    public String getSerialpos() {
        return serialpos;
    }

    public void setSerialpos(String serialpos) {
        this.serialpos = serialpos;
    }

    public String getCodadquirente() {
        return codadquirente;
    }

    public void setCodadquirente(String codadquirente) {
        this.codadquirente = codadquirente;
    }

    public Character getInativo() {
        return inativo;
    }

    public void setInativo(Character inativo) {
        this.inativo = inativo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codpos != null ? codpos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pos)) {
            return false;
        }
        Pos other = (Pos) object;
        if ((this.codpos == null && other.codpos != null) || (this.codpos != null && !this.codpos.equals(other.codpos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Pos[ codpos=" + codpos + " ]";
    }
    
}
