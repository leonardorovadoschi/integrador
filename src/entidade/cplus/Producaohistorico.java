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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "PRODUCAOHISTORICO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producaohistorico.findAll", query = "SELECT p FROM Producaohistorico p")
    , @NamedQuery(name = "Producaohistorico.findByCodproducaohistorico", query = "SELECT p FROM Producaohistorico p WHERE p.codproducaohistorico = :codproducaohistorico")
    , @NamedQuery(name = "Producaohistorico.findByDatahora", query = "SELECT p FROM Producaohistorico p WHERE p.datahora = :datahora")})
public class Producaohistorico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODPRODUCAOHISTORICO")
    private String codproducaohistorico;
    @Column(name = "DATAHORA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datahora;
    @JoinColumn(name = "CODORDEMPRODUCAO", referencedColumnName = "CODORDEMPRODUCAO")
    @ManyToOne(optional = false)
    private Ordemproducao codordemproducao;
    @JoinColumn(name = "CODPRODUCAOSTATUS", referencedColumnName = "CODPRODUCAOSTATUS")
    @ManyToOne(optional = false)
    private Producaostatus codproducaostatus;
    @JoinColumn(name = "CODUSER", referencedColumnName = "CODUSER")
    @ManyToOne(optional = false)
    private Usuario coduser;

    public Producaohistorico() {
    }

    public Producaohistorico(String codproducaohistorico) {
        this.codproducaohistorico = codproducaohistorico;
    }

    public String getCodproducaohistorico() {
        return codproducaohistorico;
    }

    public void setCodproducaohistorico(String codproducaohistorico) {
        this.codproducaohistorico = codproducaohistorico;
    }

    public Date getDatahora() {
        return datahora;
    }

    public void setDatahora(Date datahora) {
        this.datahora = datahora;
    }

    public Ordemproducao getCodordemproducao() {
        return codordemproducao;
    }

    public void setCodordemproducao(Ordemproducao codordemproducao) {
        this.codordemproducao = codordemproducao;
    }

    public Producaostatus getCodproducaostatus() {
        return codproducaostatus;
    }

    public void setCodproducaostatus(Producaostatus codproducaostatus) {
        this.codproducaostatus = codproducaostatus;
    }

    public Usuario getCoduser() {
        return coduser;
    }

    public void setCoduser(Usuario coduser) {
        this.coduser = coduser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codproducaohistorico != null ? codproducaohistorico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producaohistorico)) {
            return false;
        }
        Producaohistorico other = (Producaohistorico) object;
        if ((this.codproducaohistorico == null && other.codproducaohistorico != null) || (this.codproducaohistorico != null && !this.codproducaohistorico.equals(other.codproducaohistorico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Producaohistorico[ codproducaohistorico=" + codproducaohistorico + " ]";
    }
    
}
