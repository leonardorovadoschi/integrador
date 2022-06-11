/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "RELATORIOITEM", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Relatorioitem.findAll", query = "SELECT r FROM Relatorioitem r")
    , @NamedQuery(name = "Relatorioitem.findByCodrelatorioitem", query = "SELECT r FROM Relatorioitem r WHERE r.codrelatorioitem = :codrelatorioitem")
    , @NamedQuery(name = "Relatorioitem.findByCodrelatoriopasta", query = "SELECT r FROM Relatorioitem r WHERE r.relatorioitemPK.codrelatoriopasta = :codrelatoriopasta")
    , @NamedQuery(name = "Relatorioitem.findByNomeitem", query = "SELECT r FROM Relatorioitem r WHERE r.relatorioitemPK.nomeitem = :nomeitem")
    , @NamedQuery(name = "Relatorioitem.findByTamanho", query = "SELECT r FROM Relatorioitem r WHERE r.tamanho = :tamanho")
    , @NamedQuery(name = "Relatorioitem.findByTipo", query = "SELECT r FROM Relatorioitem r WHERE r.relatorioitemPK.tipo = :tipo")
    , @NamedQuery(name = "Relatorioitem.findByFlagmodificado", query = "SELECT r FROM Relatorioitem r WHERE r.relatorioitemPK.flagmodificado = :flagmodificado")
    , @NamedQuery(name = "Relatorioitem.findByFlagexcluido", query = "SELECT r FROM Relatorioitem r WHERE r.flagexcluido = :flagexcluido")})
public class Relatorioitem implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RelatorioitemPK relatorioitemPK;
    @Column(name = "CODRELATORIOITEM")
    private Integer codrelatorioitem;
    @Column(name = "TAMANHO")
    private Integer tamanho;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "FLAGEXCLUIDO")
    private Double flagexcluido;
    @Lob
    @Column(name = "TEMPLATE")
    private byte[] template;

    public Relatorioitem() {
    }

    public Relatorioitem(RelatorioitemPK relatorioitemPK) {
        this.relatorioitemPK = relatorioitemPK;
    }

    public Relatorioitem(int codrelatoriopasta, String nomeitem, int tipo, double flagmodificado) {
        this.relatorioitemPK = new RelatorioitemPK(codrelatoriopasta, nomeitem, tipo, flagmodificado);
    }

    public RelatorioitemPK getRelatorioitemPK() {
        return relatorioitemPK;
    }

    public void setRelatorioitemPK(RelatorioitemPK relatorioitemPK) {
        this.relatorioitemPK = relatorioitemPK;
    }

    public Integer getCodrelatorioitem() {
        return codrelatorioitem;
    }

    public void setCodrelatorioitem(Integer codrelatorioitem) {
        this.codrelatorioitem = codrelatorioitem;
    }

    public Integer getTamanho() {
        return tamanho;
    }

    public void setTamanho(Integer tamanho) {
        this.tamanho = tamanho;
    }

    public Double getFlagexcluido() {
        return flagexcluido;
    }

    public void setFlagexcluido(Double flagexcluido) {
        this.flagexcluido = flagexcluido;
    }

    public byte[] getTemplate() {
        return template;
    }

    public void setTemplate(byte[] template) {
        this.template = template;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (relatorioitemPK != null ? relatorioitemPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Relatorioitem)) {
            return false;
        }
        Relatorioitem other = (Relatorioitem) object;
        if ((this.relatorioitemPK == null && other.relatorioitemPK != null) || (this.relatorioitemPK != null && !this.relatorioitemPK.equals(other.relatorioitemPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Relatorioitem[ relatorioitemPK=" + relatorioitemPK + " ]";
    }
    
}
