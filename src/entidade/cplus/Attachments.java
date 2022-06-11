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
@Table(name = "ATTACHMENTS", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Attachments.findAll", query = "SELECT a FROM Attachments a")
    , @NamedQuery(name = "Attachments.findById", query = "SELECT a FROM Attachments a WHERE a.id = :id")
    , @NamedQuery(name = "Attachments.findByCoduser", query = "SELECT a FROM Attachments a WHERE a.coduser = :coduser")
    , @NamedQuery(name = "Attachments.findByNomecomputador", query = "SELECT a FROM Attachments a WHERE a.nomecomputador = :nomecomputador")
    , @NamedQuery(name = "Attachments.findByUsuariowindows", query = "SELECT a FROM Attachments a WHERE a.usuariowindows = :usuariowindows")
    , @NamedQuery(name = "Attachments.findByLastChange", query = "SELECT a FROM Attachments a WHERE a.lastChange = :lastChange")
    , @NamedQuery(name = "Attachments.findByIdglobal", query = "SELECT a FROM Attachments a WHERE a.idglobal = :idglobal")
    , @NamedQuery(name = "Attachments.findByCodsistema", query = "SELECT a FROM Attachments a WHERE a.codsistema = :codsistema")
    , @NamedQuery(name = "Attachments.findByFlagaltpaf", query = "SELECT a FROM Attachments a WHERE a.flagaltpaf = :flagaltpaf")
    , @NamedQuery(name = "Attachments.findByVersaoexe", query = "SELECT a FROM Attachments a WHERE a.versaoexe = :versaoexe")})
public class Attachments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "CODUSER")
    private String coduser;
    @Column(name = "NOMECOMPUTADOR")
    private String nomecomputador;
    @Column(name = "USUARIOWINDOWS")
    private String usuariowindows;
    @Column(name = "LAST_CHANGE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastChange;
    @Column(name = "IDGLOBAL")
    private Integer idglobal;
    @Column(name = "CODSISTEMA")
    private Integer codsistema;
    @Column(name = "FLAGALTPAF")
    private Character flagaltpaf;
    @Column(name = "VERSAOEXE")
    private String versaoexe;

    public Attachments() {
    }

    public Attachments(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCoduser() {
        return coduser;
    }

    public void setCoduser(String coduser) {
        this.coduser = coduser;
    }

    public String getNomecomputador() {
        return nomecomputador;
    }

    public void setNomecomputador(String nomecomputador) {
        this.nomecomputador = nomecomputador;
    }

    public String getUsuariowindows() {
        return usuariowindows;
    }

    public void setUsuariowindows(String usuariowindows) {
        this.usuariowindows = usuariowindows;
    }

    public Date getLastChange() {
        return lastChange;
    }

    public void setLastChange(Date lastChange) {
        this.lastChange = lastChange;
    }

    public Integer getIdglobal() {
        return idglobal;
    }

    public void setIdglobal(Integer idglobal) {
        this.idglobal = idglobal;
    }

    public Integer getCodsistema() {
        return codsistema;
    }

    public void setCodsistema(Integer codsistema) {
        this.codsistema = codsistema;
    }

    public Character getFlagaltpaf() {
        return flagaltpaf;
    }

    public void setFlagaltpaf(Character flagaltpaf) {
        this.flagaltpaf = flagaltpaf;
    }

    public String getVersaoexe() {
        return versaoexe;
    }

    public void setVersaoexe(String versaoexe) {
        this.versaoexe = versaoexe;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Attachments)) {
            return false;
        }
        Attachments other = (Attachments) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Attachments[ id=" + id + " ]";
    }
    
}
