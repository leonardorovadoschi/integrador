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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "SENHAREMOTA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Senharemota.findAll", query = "SELECT s FROM Senharemota s")
    , @NamedQuery(name = "Senharemota.findByIdsenharemota", query = "SELECT s FROM Senharemota s WHERE s.idsenharemota = :idsenharemota")
    , @NamedQuery(name = "Senharemota.findByCoduserSolicitante", query = "SELECT s FROM Senharemota s WHERE s.coduserSolicitante = :coduserSolicitante")
    , @NamedQuery(name = "Senharemota.findByCoduserLiberacao", query = "SELECT s FROM Senharemota s WHERE s.coduserLiberacao = :coduserLiberacao")
    , @NamedQuery(name = "Senharemota.findByTipoacao", query = "SELECT s FROM Senharemota s WHERE s.tipoacao = :tipoacao")
    , @NamedQuery(name = "Senharemota.findByAcao", query = "SELECT s FROM Senharemota s WHERE s.acao = :acao")})
public class Senharemota implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDSENHAREMOTA")
    private Integer idsenharemota;
    @Column(name = "CODUSER_SOLICITANTE")
    private String coduserSolicitante;
    @Column(name = "CODUSER_LIBERACAO")
    private String coduserLiberacao;
    @Column(name = "TIPOACAO")
    private Integer tipoacao;
    @Column(name = "ACAO")
    private String acao;
    @Lob
    @Column(name = "OBSERVACAO")
    private String observacao;

    public Senharemota() {
    }

    public Senharemota(Integer idsenharemota) {
        this.idsenharemota = idsenharemota;
    }

    public Integer getIdsenharemota() {
        return idsenharemota;
    }

    public void setIdsenharemota(Integer idsenharemota) {
        this.idsenharemota = idsenharemota;
    }

    public String getCoduserSolicitante() {
        return coduserSolicitante;
    }

    public void setCoduserSolicitante(String coduserSolicitante) {
        this.coduserSolicitante = coduserSolicitante;
    }

    public String getCoduserLiberacao() {
        return coduserLiberacao;
    }

    public void setCoduserLiberacao(String coduserLiberacao) {
        this.coduserLiberacao = coduserLiberacao;
    }

    public Integer getTipoacao() {
        return tipoacao;
    }

    public void setTipoacao(Integer tipoacao) {
        this.tipoacao = tipoacao;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsenharemota != null ? idsenharemota.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Senharemota)) {
            return false;
        }
        Senharemota other = (Senharemota) object;
        if ((this.idsenharemota == null && other.idsenharemota != null) || (this.idsenharemota != null && !this.idsenharemota.equals(other.idsenharemota))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Senharemota[ idsenharemota=" + idsenharemota + " ]";
    }
    
}
