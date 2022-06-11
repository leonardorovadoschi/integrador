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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "CESTICMSCLASSIFICACAOFISCAL", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cesticmsclassificacaofiscal.findAll", query = "SELECT c FROM Cesticmsclassificacaofiscal c")
    , @NamedQuery(name = "Cesticmsclassificacaofiscal.findByCodcesticms", query = "SELECT c FROM Cesticmsclassificacaofiscal c WHERE c.cesticmsclassificacaofiscalPK.codcesticms = :codcesticms")
    , @NamedQuery(name = "Cesticmsclassificacaofiscal.findByCodigoclassificacaofiscal", query = "SELECT c FROM Cesticmsclassificacaofiscal c WHERE c.cesticmsclassificacaofiscalPK.codigoclassificacaofiscal = :codigoclassificacaofiscal")
    , @NamedQuery(name = "Cesticmsclassificacaofiscal.findBySistema", query = "SELECT c FROM Cesticmsclassificacaofiscal c WHERE c.sistema = :sistema")
    , @NamedQuery(name = "Cesticmsclassificacaofiscal.findByFlagativo", query = "SELECT c FROM Cesticmsclassificacaofiscal c WHERE c.flagativo = :flagativo")
    , @NamedQuery(name = "Cesticmsclassificacaofiscal.findByDataatualizacao", query = "SELECT c FROM Cesticmsclassificacaofiscal c WHERE c.dataatualizacao = :dataatualizacao")})
public class Cesticmsclassificacaofiscal implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CesticmsclassificacaofiscalPK cesticmsclassificacaofiscalPK;
    @Basic(optional = false)
    @Column(name = "SISTEMA")
    private Character sistema;
    @Column(name = "FLAGATIVO")
    private Character flagativo;
    @Column(name = "DATAATUALIZACAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataatualizacao;
    @JoinColumn(name = "CODCESTICMS", referencedColumnName = "CODCESTICMS", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cesticms cesticms;

    public Cesticmsclassificacaofiscal() {
    }

    public Cesticmsclassificacaofiscal(CesticmsclassificacaofiscalPK cesticmsclassificacaofiscalPK) {
        this.cesticmsclassificacaofiscalPK = cesticmsclassificacaofiscalPK;
    }

    public Cesticmsclassificacaofiscal(CesticmsclassificacaofiscalPK cesticmsclassificacaofiscalPK, Character sistema) {
        this.cesticmsclassificacaofiscalPK = cesticmsclassificacaofiscalPK;
        this.sistema = sistema;
    }

    public Cesticmsclassificacaofiscal(String codcesticms, String codigoclassificacaofiscal) {
        this.cesticmsclassificacaofiscalPK = new CesticmsclassificacaofiscalPK(codcesticms, codigoclassificacaofiscal);
    }

    public CesticmsclassificacaofiscalPK getCesticmsclassificacaofiscalPK() {
        return cesticmsclassificacaofiscalPK;
    }

    public void setCesticmsclassificacaofiscalPK(CesticmsclassificacaofiscalPK cesticmsclassificacaofiscalPK) {
        this.cesticmsclassificacaofiscalPK = cesticmsclassificacaofiscalPK;
    }

    public Character getSistema() {
        return sistema;
    }

    public void setSistema(Character sistema) {
        this.sistema = sistema;
    }

    public Character getFlagativo() {
        return flagativo;
    }

    public void setFlagativo(Character flagativo) {
        this.flagativo = flagativo;
    }

    public Date getDataatualizacao() {
        return dataatualizacao;
    }

    public void setDataatualizacao(Date dataatualizacao) {
        this.dataatualizacao = dataatualizacao;
    }

    public Cesticms getCesticms() {
        return cesticms;
    }

    public void setCesticms(Cesticms cesticms) {
        this.cesticms = cesticms;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cesticmsclassificacaofiscalPK != null ? cesticmsclassificacaofiscalPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cesticmsclassificacaofiscal)) {
            return false;
        }
        Cesticmsclassificacaofiscal other = (Cesticmsclassificacaofiscal) object;
        if ((this.cesticmsclassificacaofiscalPK == null && other.cesticmsclassificacaofiscalPK != null) || (this.cesticmsclassificacaofiscalPK != null && !this.cesticmsclassificacaofiscalPK.equals(other.cesticmsclassificacaofiscalPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Cesticmsclassificacaofiscal[ cesticmsclassificacaofiscalPK=" + cesticmsclassificacaofiscalPK + " ]";
    }
    
}
