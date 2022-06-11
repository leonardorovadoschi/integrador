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
@Table(name = "MOVECFNOTAMANUAL", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movecfnotamanual.findAll", query = "SELECT m FROM Movecfnotamanual m")
    , @NamedQuery(name = "Movecfnotamanual.findByCodmovecfnotamanual", query = "SELECT m FROM Movecfnotamanual m WHERE m.codmovecfnotamanual = :codmovecfnotamanual")
    , @NamedQuery(name = "Movecfnotamanual.findByGuid", query = "SELECT m FROM Movecfnotamanual m WHERE m.guid = :guid")
    , @NamedQuery(name = "Movecfnotamanual.findByCodcfop", query = "SELECT m FROM Movecfnotamanual m WHERE m.codcfop = :codcfop")
    , @NamedQuery(name = "Movecfnotamanual.findByDataemissao", query = "SELECT m FROM Movecfnotamanual m WHERE m.dataemissao = :dataemissao")
    , @NamedQuery(name = "Movecfnotamanual.findByModelonota", query = "SELECT m FROM Movecfnotamanual m WHERE m.modelonota = :modelonota")
    , @NamedQuery(name = "Movecfnotamanual.findBySerienota", query = "SELECT m FROM Movecfnotamanual m WHERE m.serienota = :serienota")
    , @NamedQuery(name = "Movecfnotamanual.findBySubserie", query = "SELECT m FROM Movecfnotamanual m WHERE m.subserie = :subserie")
    , @NamedQuery(name = "Movecfnotamanual.findByNumnota", query = "SELECT m FROM Movecfnotamanual m WHERE m.numnota = :numnota")
    , @NamedQuery(name = "Movecfnotamanual.findByFlagr61", query = "SELECT m FROM Movecfnotamanual m WHERE m.flagr61 = :flagr61")
    , @NamedQuery(name = "Movecfnotamanual.findByCodempresa", query = "SELECT m FROM Movecfnotamanual m WHERE m.codempresa = :codempresa")
    , @NamedQuery(name = "Movecfnotamanual.findByFlagaltpaf", query = "SELECT m FROM Movecfnotamanual m WHERE m.flagaltpaf = :flagaltpaf")})
public class Movecfnotamanual implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODMOVECFNOTAMANUAL")
    private String codmovecfnotamanual;
    @Column(name = "GUID")
    private String guid;
    @Column(name = "CODCFOP")
    private String codcfop;
    @Column(name = "DATAEMISSAO")
    @Temporal(TemporalType.DATE)
    private Date dataemissao;
    @Column(name = "MODELONOTA")
    private String modelonota;
    @Column(name = "SERIENOTA")
    private String serienota;
    @Column(name = "SUBSERIE")
    private String subserie;
    @Column(name = "NUMNOTA")
    private Integer numnota;
    @Column(name = "FLAGR61")
    private Character flagr61;
    @Column(name = "CODEMPRESA")
    private Integer codempresa;
    @Column(name = "FLAGALTPAF")
    private Character flagaltpaf;
    @JoinColumn(name = "CODMOVENDA", referencedColumnName = "CODMOVENDA")
    @ManyToOne
    private Movenda codmovenda;

    public Movecfnotamanual() {
    }

    public Movecfnotamanual(String codmovecfnotamanual) {
        this.codmovecfnotamanual = codmovecfnotamanual;
    }

    public String getCodmovecfnotamanual() {
        return codmovecfnotamanual;
    }

    public void setCodmovecfnotamanual(String codmovecfnotamanual) {
        this.codmovecfnotamanual = codmovecfnotamanual;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getCodcfop() {
        return codcfop;
    }

    public void setCodcfop(String codcfop) {
        this.codcfop = codcfop;
    }

    public Date getDataemissao() {
        return dataemissao;
    }

    public void setDataemissao(Date dataemissao) {
        this.dataemissao = dataemissao;
    }

    public String getModelonota() {
        return modelonota;
    }

    public void setModelonota(String modelonota) {
        this.modelonota = modelonota;
    }

    public String getSerienota() {
        return serienota;
    }

    public void setSerienota(String serienota) {
        this.serienota = serienota;
    }

    public String getSubserie() {
        return subserie;
    }

    public void setSubserie(String subserie) {
        this.subserie = subserie;
    }

    public Integer getNumnota() {
        return numnota;
    }

    public void setNumnota(Integer numnota) {
        this.numnota = numnota;
    }

    public Character getFlagr61() {
        return flagr61;
    }

    public void setFlagr61(Character flagr61) {
        this.flagr61 = flagr61;
    }

    public Integer getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Integer codempresa) {
        this.codempresa = codempresa;
    }

    public Character getFlagaltpaf() {
        return flagaltpaf;
    }

    public void setFlagaltpaf(Character flagaltpaf) {
        this.flagaltpaf = flagaltpaf;
    }

    public Movenda getCodmovenda() {
        return codmovenda;
    }

    public void setCodmovenda(Movenda codmovenda) {
        this.codmovenda = codmovenda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codmovecfnotamanual != null ? codmovecfnotamanual.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movecfnotamanual)) {
            return false;
        }
        Movecfnotamanual other = (Movecfnotamanual) object;
        if ((this.codmovecfnotamanual == null && other.codmovecfnotamanual != null) || (this.codmovecfnotamanual != null && !this.codmovecfnotamanual.equals(other.codmovecfnotamanual))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Movecfnotamanual[ codmovecfnotamanual=" + codmovecfnotamanual + " ]";
    }
    
}
