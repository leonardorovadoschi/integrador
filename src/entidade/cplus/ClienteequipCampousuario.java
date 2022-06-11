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
@Table(name = "CLIENTEEQUIP_CAMPOUSUARIO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClienteequipCampousuario.findAll", query = "SELECT c FROM ClienteequipCampousuario c")
    , @NamedQuery(name = "ClienteequipCampousuario.findByCodclienteequipCampousuario", query = "SELECT c FROM ClienteequipCampousuario c WHERE c.codclienteequipCampousuario = :codclienteequipCampousuario")
    , @NamedQuery(name = "ClienteequipCampousuario.findByValorcampo", query = "SELECT c FROM ClienteequipCampousuario c WHERE c.valorcampo = :valorcampo")
    , @NamedQuery(name = "ClienteequipCampousuario.findByObservacao", query = "SELECT c FROM ClienteequipCampousuario c WHERE c.observacao = :observacao")
    , @NamedQuery(name = "ClienteequipCampousuario.findByOrdem", query = "SELECT c FROM ClienteequipCampousuario c WHERE c.ordem = :ordem")})
public class ClienteequipCampousuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCLIENTEEQUIP_CAMPOUSUARIO")
    private String codclienteequipCampousuario;
    @Column(name = "VALORCAMPO")
    private String valorcampo;
    @Column(name = "OBSERVACAO")
    private String observacao;
    @Column(name = "ORDEM")
    private Integer ordem;
    @JoinColumn(name = "CODCAMPOUSUARIO", referencedColumnName = "CODCAMPOUSUARIO")
    @ManyToOne(optional = false)
    private Campousuario codcampousuario;
    @JoinColumn(name = "CODCLIENTEEQUIPAMENTO", referencedColumnName = "CODCLIENTEEQUIPAMENTO")
    @ManyToOne(optional = false)
    private Clienteequipamento codclienteequipamento;

    public ClienteequipCampousuario() {
    }

    public ClienteequipCampousuario(String codclienteequipCampousuario) {
        this.codclienteequipCampousuario = codclienteequipCampousuario;
    }

    public String getCodclienteequipCampousuario() {
        return codclienteequipCampousuario;
    }

    public void setCodclienteequipCampousuario(String codclienteequipCampousuario) {
        this.codclienteequipCampousuario = codclienteequipCampousuario;
    }

    public String getValorcampo() {
        return valorcampo;
    }

    public void setValorcampo(String valorcampo) {
        this.valorcampo = valorcampo;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Integer getOrdem() {
        return ordem;
    }

    public void setOrdem(Integer ordem) {
        this.ordem = ordem;
    }

    public Campousuario getCodcampousuario() {
        return codcampousuario;
    }

    public void setCodcampousuario(Campousuario codcampousuario) {
        this.codcampousuario = codcampousuario;
    }

    public Clienteequipamento getCodclienteequipamento() {
        return codclienteequipamento;
    }

    public void setCodclienteequipamento(Clienteequipamento codclienteequipamento) {
        this.codclienteequipamento = codclienteequipamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codclienteequipCampousuario != null ? codclienteequipCampousuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienteequipCampousuario)) {
            return false;
        }
        ClienteequipCampousuario other = (ClienteequipCampousuario) object;
        if ((this.codclienteequipCampousuario == null && other.codclienteequipCampousuario != null) || (this.codclienteequipCampousuario != null && !this.codclienteequipCampousuario.equals(other.codclienteequipCampousuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.ClienteequipCampousuario[ codclienteequipCampousuario=" + codclienteequipCampousuario + " ]";
    }
    
}
