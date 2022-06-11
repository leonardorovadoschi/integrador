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
import javax.persistence.Lob;
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
@Table(name = "CFGCENARIOGRID", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cfgcenariogrid.findAll", query = "SELECT c FROM Cfgcenariogrid c")
    , @NamedQuery(name = "Cfgcenariogrid.findByCodcfgcenariogrid", query = "SELECT c FROM Cfgcenariogrid c WHERE c.codcfgcenariogrid = :codcfgcenariogrid")
    , @NamedQuery(name = "Cfgcenariogrid.findByCoduser", query = "SELECT c FROM Cfgcenariogrid c WHERE c.coduser = :coduser")
    , @NamedQuery(name = "Cfgcenariogrid.findByNomegrid", query = "SELECT c FROM Cfgcenariogrid c WHERE c.nomegrid = :nomegrid")
    , @NamedQuery(name = "Cfgcenariogrid.findByDataultimoacesso", query = "SELECT c FROM Cfgcenariogrid c WHERE c.dataultimoacesso = :dataultimoacesso")})
public class Cfgcenariogrid implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCFGCENARIOGRID")
    private String codcfgcenariogrid;
    @Column(name = "CODUSER")
    private String coduser;
    @Column(name = "NOMEGRID")
    private String nomegrid;
    @Lob
    @Column(name = "CONTEUDOARQUIVOINI")
    private byte[] conteudoarquivoini;
    @Column(name = "DATAULTIMOACESSO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataultimoacesso;
    @Lob
    @Column(name = "CONTEUDOARQUIVOINIFILTRO")
    private String conteudoarquivoinifiltro;
    @JoinColumn(name = "CODSISTEMA", referencedColumnName = "CODSISTEMA")
    @ManyToOne
    private Sistema codsistema;

    public Cfgcenariogrid() {
    }

    public Cfgcenariogrid(String codcfgcenariogrid) {
        this.codcfgcenariogrid = codcfgcenariogrid;
    }

    public String getCodcfgcenariogrid() {
        return codcfgcenariogrid;
    }

    public void setCodcfgcenariogrid(String codcfgcenariogrid) {
        this.codcfgcenariogrid = codcfgcenariogrid;
    }

    public String getCoduser() {
        return coduser;
    }

    public void setCoduser(String coduser) {
        this.coduser = coduser;
    }

    public String getNomegrid() {
        return nomegrid;
    }

    public void setNomegrid(String nomegrid) {
        this.nomegrid = nomegrid;
    }

    public byte[] getConteudoarquivoini() {
        return conteudoarquivoini;
    }

    public void setConteudoarquivoini(byte[] conteudoarquivoini) {
        this.conteudoarquivoini = conteudoarquivoini;
    }

    public Date getDataultimoacesso() {
        return dataultimoacesso;
    }

    public void setDataultimoacesso(Date dataultimoacesso) {
        this.dataultimoacesso = dataultimoacesso;
    }

    public String getConteudoarquivoinifiltro() {
        return conteudoarquivoinifiltro;
    }

    public void setConteudoarquivoinifiltro(String conteudoarquivoinifiltro) {
        this.conteudoarquivoinifiltro = conteudoarquivoinifiltro;
    }

    public Sistema getCodsistema() {
        return codsistema;
    }

    public void setCodsistema(Sistema codsistema) {
        this.codsistema = codsistema;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcfgcenariogrid != null ? codcfgcenariogrid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cfgcenariogrid)) {
            return false;
        }
        Cfgcenariogrid other = (Cfgcenariogrid) object;
        if ((this.codcfgcenariogrid == null && other.codcfgcenariogrid != null) || (this.codcfgcenariogrid != null && !this.codcfgcenariogrid.equals(other.codcfgcenariogrid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Cfgcenariogrid[ codcfgcenariogrid=" + codcfgcenariogrid + " ]";
    }
    
}
