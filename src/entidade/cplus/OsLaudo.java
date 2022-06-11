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
@Table(name = "OS_LAUDO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OsLaudo.findAll", query = "SELECT o FROM OsLaudo o")
    , @NamedQuery(name = "OsLaudo.findByCodlaudo", query = "SELECT o FROM OsLaudo o WHERE o.codlaudo = :codlaudo")
    , @NamedQuery(name = "OsLaudo.findByData", query = "SELECT o FROM OsLaudo o WHERE o.data = :data")
    , @NamedQuery(name = "OsLaudo.findByInicial", query = "SELECT o FROM OsLaudo o WHERE o.inicial = :inicial")
    , @NamedQuery(name = "OsLaudo.findByHorafinal", query = "SELECT o FROM OsLaudo o WHERE o.horafinal = :horafinal")
    , @NamedQuery(name = "OsLaudo.findByDatahorainicial", query = "SELECT o FROM OsLaudo o WHERE o.datahorainicial = :datahorainicial")
    , @NamedQuery(name = "OsLaudo.findByDatahorafinal", query = "SELECT o FROM OsLaudo o WHERE o.datahorafinal = :datahorafinal")})
public class OsLaudo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODLAUDO")
    private String codlaudo;
    @Column(name = "DATA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Lob
    @Column(name = "LAUDO")
    private String laudo;
    @Column(name = "INICIAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date inicial;
    @Column(name = "HORAFINAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horafinal;
    @Column(name = "DATAHORAINICIAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datahorainicial;
    @Column(name = "DATAHORAFINAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datahorafinal;
    @JoinColumn(name = "CODOS", referencedColumnName = "CODOS")
    @ManyToOne
    private OsOrdemservico codos;
    @JoinColumn(name = "CODSTATUS", referencedColumnName = "CODSTATUS")
    @ManyToOne
    private OsStatus codstatus;
    @JoinColumn(name = "CODTEC", referencedColumnName = "CODTEC")
    @ManyToOne
    private OsTecnico codtec;

    public OsLaudo() {
    }

    public OsLaudo(String codlaudo) {
        this.codlaudo = codlaudo;
    }

    public String getCodlaudo() {
        return codlaudo;
    }

    public void setCodlaudo(String codlaudo) {
        this.codlaudo = codlaudo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getLaudo() {
        return laudo;
    }

    public void setLaudo(String laudo) {
        this.laudo = laudo;
    }

    public Date getInicial() {
        return inicial;
    }

    public void setInicial(Date inicial) {
        this.inicial = inicial;
    }

    public Date getHorafinal() {
        return horafinal;
    }

    public void setHorafinal(Date horafinal) {
        this.horafinal = horafinal;
    }

    public Date getDatahorainicial() {
        return datahorainicial;
    }

    public void setDatahorainicial(Date datahorainicial) {
        this.datahorainicial = datahorainicial;
    }

    public Date getDatahorafinal() {
        return datahorafinal;
    }

    public void setDatahorafinal(Date datahorafinal) {
        this.datahorafinal = datahorafinal;
    }

    public OsOrdemservico getCodos() {
        return codos;
    }

    public void setCodos(OsOrdemservico codos) {
        this.codos = codos;
    }

    public OsStatus getCodstatus() {
        return codstatus;
    }

    public void setCodstatus(OsStatus codstatus) {
        this.codstatus = codstatus;
    }

    public OsTecnico getCodtec() {
        return codtec;
    }

    public void setCodtec(OsTecnico codtec) {
        this.codtec = codtec;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codlaudo != null ? codlaudo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OsLaudo)) {
            return false;
        }
        OsLaudo other = (OsLaudo) object;
        if ((this.codlaudo == null && other.codlaudo != null) || (this.codlaudo != null && !this.codlaudo.equals(other.codlaudo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.OsLaudo[ codlaudo=" + codlaudo + " ]";
    }
    
}
