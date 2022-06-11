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
@Table(name = "CARACTERISTICA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Caracteristica.findAll", query = "SELECT c FROM Caracteristica c")
    , @NamedQuery(name = "Caracteristica.findByCodcaracteristica", query = "SELECT c FROM Caracteristica c WHERE c.codcaracteristica = :codcaracteristica")
    , @NamedQuery(name = "Caracteristica.findByCodigo", query = "SELECT c FROM Caracteristica c WHERE c.codigo = :codigo")
    , @NamedQuery(name = "Caracteristica.findByNomecaracteristica", query = "SELECT c FROM Caracteristica c WHERE c.nomecaracteristica = :nomecaracteristica")
    , @NamedQuery(name = "Caracteristica.findByClassificacao", query = "SELECT c FROM Caracteristica c WHERE c.classificacao = :classificacao")
    , @NamedQuery(name = "Caracteristica.findByTipo", query = "SELECT c FROM Caracteristica c WHERE c.tipo = :tipo")
    , @NamedQuery(name = "Caracteristica.findByGuid", query = "SELECT c FROM Caracteristica c WHERE c.guid = :guid")})
public class Caracteristica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCARACTERISTICA")
    private String codcaracteristica;
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "NOMECARACTERISTICA")
    private String nomecaracteristica;
    @Column(name = "CLASSIFICACAO")
    private String classificacao;
    @Column(name = "TIPO")
    private Character tipo;
    @Column(name = "GUID")
    private String guid;

    public Caracteristica() {
    }

    public Caracteristica(String codcaracteristica) {
        this.codcaracteristica = codcaracteristica;
    }

    public Caracteristica(String codcaracteristica, String codigo) {
        this.codcaracteristica = codcaracteristica;
        this.codigo = codigo;
    }

    public String getCodcaracteristica() {
        return codcaracteristica;
    }

    public void setCodcaracteristica(String codcaracteristica) {
        this.codcaracteristica = codcaracteristica;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomecaracteristica() {
        return nomecaracteristica;
    }

    public void setNomecaracteristica(String nomecaracteristica) {
        this.nomecaracteristica = nomecaracteristica;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcaracteristica != null ? codcaracteristica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Caracteristica)) {
            return false;
        }
        Caracteristica other = (Caracteristica) object;
        if ((this.codcaracteristica == null && other.codcaracteristica != null) || (this.codcaracteristica != null && !this.codcaracteristica.equals(other.codcaracteristica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Caracteristica[ codcaracteristica=" + codcaracteristica + " ]";
    }
    
}
