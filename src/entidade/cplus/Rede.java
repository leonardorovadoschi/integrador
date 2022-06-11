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
@Table(name = "REDE", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rede.findAll", query = "SELECT r FROM Rede r")
    , @NamedQuery(name = "Rede.findByIdrede", query = "SELECT r FROM Rede r WHERE r.idrede = :idrede")
    , @NamedQuery(name = "Rede.findByNomeestacao", query = "SELECT r FROM Rede r WHERE r.nomeestacao = :nomeestacao")
    , @NamedQuery(name = "Rede.findByIpestacao", query = "SELECT r FROM Rede r WHERE r.ipestacao = :ipestacao")
    , @NamedQuery(name = "Rede.findByCoduser", query = "SELECT r FROM Rede r WHERE r.coduser = :coduser")
    , @NamedQuery(name = "Rede.findByAcao", query = "SELECT r FROM Rede r WHERE r.acao = :acao")
    , @NamedQuery(name = "Rede.findById", query = "SELECT r FROM Rede r WHERE r.id = :id")
    , @NamedQuery(name = "Rede.findByIdtransacao", query = "SELECT r FROM Rede r WHERE r.idtransacao = :idtransacao")
    , @NamedQuery(name = "Rede.findByIdconexao", query = "SELECT r FROM Rede r WHERE r.idconexao = :idconexao")})
public class Rede implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDREDE")
    private Integer idrede;
    @Column(name = "NOMEESTACAO")
    private String nomeestacao;
    @Column(name = "IPESTACAO")
    private String ipestacao;
    @Column(name = "CODUSER")
    private String coduser;
    @Column(name = "ACAO")
    private String acao;
    @Column(name = "ID")
    private Integer id;
    @Column(name = "IDTRANSACAO")
    private Integer idtransacao;
    @Column(name = "IDCONEXAO")
    private Integer idconexao;

    public Rede() {
    }

    public Rede(Integer idrede) {
        this.idrede = idrede;
    }

    public Integer getIdrede() {
        return idrede;
    }

    public void setIdrede(Integer idrede) {
        this.idrede = idrede;
    }

    public String getNomeestacao() {
        return nomeestacao;
    }

    public void setNomeestacao(String nomeestacao) {
        this.nomeestacao = nomeestacao;
    }

    public String getIpestacao() {
        return ipestacao;
    }

    public void setIpestacao(String ipestacao) {
        this.ipestacao = ipestacao;
    }

    public String getCoduser() {
        return coduser;
    }

    public void setCoduser(String coduser) {
        this.coduser = coduser;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdtransacao() {
        return idtransacao;
    }

    public void setIdtransacao(Integer idtransacao) {
        this.idtransacao = idtransacao;
    }

    public Integer getIdconexao() {
        return idconexao;
    }

    public void setIdconexao(Integer idconexao) {
        this.idconexao = idconexao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrede != null ? idrede.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rede)) {
            return false;
        }
        Rede other = (Rede) object;
        if ((this.idrede == null && other.idrede != null) || (this.idrede != null && !this.idrede.equals(other.idrede))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Rede[ idrede=" + idrede + " ]";
    }
    
}
