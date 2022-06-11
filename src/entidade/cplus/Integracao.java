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
@Table(name = "INTEGRACAO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Integracao.findAll", query = "SELECT i FROM Integracao i")
    , @NamedQuery(name = "Integracao.findByCodintegracao", query = "SELECT i FROM Integracao i WHERE i.codintegracao = :codintegracao")
    , @NamedQuery(name = "Integracao.findByEntidadeorigem", query = "SELECT i FROM Integracao i WHERE i.entidadeorigem = :entidadeorigem")
    , @NamedQuery(name = "Integracao.findByIdentidadeorigem", query = "SELECT i FROM Integracao i WHERE i.identidadeorigem = :identidadeorigem")
    , @NamedQuery(name = "Integracao.findByEntidadedestino", query = "SELECT i FROM Integracao i WHERE i.entidadedestino = :entidadedestino")
    , @NamedQuery(name = "Integracao.findByIdentidadedestino", query = "SELECT i FROM Integracao i WHERE i.identidadedestino = :identidadedestino")})
public class Integracao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODINTEGRACAO")
    private String codintegracao;
    @Column(name = "ENTIDADEORIGEM")
    private String entidadeorigem;
    @Column(name = "IDENTIDADEORIGEM")
    private String identidadeorigem;
    @Column(name = "ENTIDADEDESTINO")
    private String entidadedestino;
    @Column(name = "IDENTIDADEDESTINO")
    private String identidadedestino;

    public Integracao() {
    }

    public Integracao(String codintegracao) {
        this.codintegracao = codintegracao;
    }

    public String getCodintegracao() {
        return codintegracao;
    }

    public void setCodintegracao(String codintegracao) {
        this.codintegracao = codintegracao;
    }

    public String getEntidadeorigem() {
        return entidadeorigem;
    }

    public void setEntidadeorigem(String entidadeorigem) {
        this.entidadeorigem = entidadeorigem;
    }

    public String getIdentidadeorigem() {
        return identidadeorigem;
    }

    public void setIdentidadeorigem(String identidadeorigem) {
        this.identidadeorigem = identidadeorigem;
    }

    public String getEntidadedestino() {
        return entidadedestino;
    }

    public void setEntidadedestino(String entidadedestino) {
        this.entidadedestino = entidadedestino;
    }

    public String getIdentidadedestino() {
        return identidadedestino;
    }

    public void setIdentidadedestino(String identidadedestino) {
        this.identidadedestino = identidadedestino;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codintegracao != null ? codintegracao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Integracao)) {
            return false;
        }
        Integracao other = (Integracao) object;
        if ((this.codintegracao == null && other.codintegracao != null) || (this.codintegracao != null && !this.codintegracao.equals(other.codintegracao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Integracao[ codintegracao=" + codintegracao + " ]";
    }
    
}
