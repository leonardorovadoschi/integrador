/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "MOVECFRZITEM", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movecfrzitem.findAll", query = "SELECT m FROM Movecfrzitem m")
    , @NamedQuery(name = "Movecfrzitem.findByCodmovecfrzitem", query = "SELECT m FROM Movecfrzitem m WHERE m.codmovecfrzitem = :codmovecfrzitem")
    , @NamedQuery(name = "Movecfrzitem.findByNumeroserieecf", query = "SELECT m FROM Movecfrzitem m WHERE m.numeroserieecf = :numeroserieecf")
    , @NamedQuery(name = "Movecfrzitem.findByCodecf", query = "SELECT m FROM Movecfrzitem m WHERE m.codecf = :codecf")
    , @NamedQuery(name = "Movecfrzitem.findByNumerousuario", query = "SELECT m FROM Movecfrzitem m WHERE m.numerousuario = :numerousuario")
    , @NamedQuery(name = "Movecfrzitem.findByCrz", query = "SELECT m FROM Movecfrzitem m WHERE m.crz = :crz")
    , @NamedQuery(name = "Movecfrzitem.findByCodigototalizadorparcial", query = "SELECT m FROM Movecfrzitem m WHERE m.codigototalizadorparcial = :codigototalizadorparcial")
    , @NamedQuery(name = "Movecfrzitem.findByAliquota", query = "SELECT m FROM Movecfrzitem m WHERE m.aliquota = :aliquota")
    , @NamedQuery(name = "Movecfrzitem.findByStAliquota", query = "SELECT m FROM Movecfrzitem m WHERE m.stAliquota = :stAliquota")
    , @NamedQuery(name = "Movecfrzitem.findByValoracumulado", query = "SELECT m FROM Movecfrzitem m WHERE m.valoracumulado = :valoracumulado")
    , @NamedQuery(name = "Movecfrzitem.findByGuid", query = "SELECT m FROM Movecfrzitem m WHERE m.guid = :guid")
    , @NamedQuery(name = "Movecfrzitem.findByModeloecf", query = "SELECT m FROM Movecfrzitem m WHERE m.modeloecf = :modeloecf")
    , @NamedQuery(name = "Movecfrzitem.findByFlagaltpaf", query = "SELECT m FROM Movecfrzitem m WHERE m.flagaltpaf = :flagaltpaf")})
public class Movecfrzitem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODMOVECFRZITEM")
    private String codmovecfrzitem;
    @Column(name = "NUMEROSERIEECF")
    private String numeroserieecf;
    @Column(name = "CODECF")
    private String codecf;
    @Column(name = "NUMEROUSUARIO")
    private Integer numerousuario;
    @Column(name = "CRZ")
    private Integer crz;
    @Column(name = "CODIGOTOTALIZADORPARCIAL")
    private String codigototalizadorparcial;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ALIQUOTA")
    private BigDecimal aliquota;
    @Column(name = "ST_ALIQUOTA")
    private String stAliquota;
    @Column(name = "VALORACUMULADO")
    private BigDecimal valoracumulado;
    @Column(name = "GUID")
    private String guid;
    @Column(name = "MODELOECF")
    private String modeloecf;
    @Column(name = "FLAGALTPAF")
    private Character flagaltpaf;
    @JoinColumn(name = "CODEMPRESA", referencedColumnName = "CODEMPRESA")
    @ManyToOne
    private Empresa codempresa;
    @JoinColumn(name = "CODMOVECFRZ", referencedColumnName = "CODMOVECFRZ")
    @ManyToOne
    private Movecfrz codmovecfrz;

    public Movecfrzitem() {
    }

    public Movecfrzitem(String codmovecfrzitem) {
        this.codmovecfrzitem = codmovecfrzitem;
    }

    public String getCodmovecfrzitem() {
        return codmovecfrzitem;
    }

    public void setCodmovecfrzitem(String codmovecfrzitem) {
        this.codmovecfrzitem = codmovecfrzitem;
    }

    public String getNumeroserieecf() {
        return numeroserieecf;
    }

    public void setNumeroserieecf(String numeroserieecf) {
        this.numeroserieecf = numeroserieecf;
    }

    public String getCodecf() {
        return codecf;
    }

    public void setCodecf(String codecf) {
        this.codecf = codecf;
    }

    public Integer getNumerousuario() {
        return numerousuario;
    }

    public void setNumerousuario(Integer numerousuario) {
        this.numerousuario = numerousuario;
    }

    public Integer getCrz() {
        return crz;
    }

    public void setCrz(Integer crz) {
        this.crz = crz;
    }

    public String getCodigototalizadorparcial() {
        return codigototalizadorparcial;
    }

    public void setCodigototalizadorparcial(String codigototalizadorparcial) {
        this.codigototalizadorparcial = codigototalizadorparcial;
    }

    public BigDecimal getAliquota() {
        return aliquota;
    }

    public void setAliquota(BigDecimal aliquota) {
        this.aliquota = aliquota;
    }

    public String getStAliquota() {
        return stAliquota;
    }

    public void setStAliquota(String stAliquota) {
        this.stAliquota = stAliquota;
    }

    public BigDecimal getValoracumulado() {
        return valoracumulado;
    }

    public void setValoracumulado(BigDecimal valoracumulado) {
        this.valoracumulado = valoracumulado;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getModeloecf() {
        return modeloecf;
    }

    public void setModeloecf(String modeloecf) {
        this.modeloecf = modeloecf;
    }

    public Character getFlagaltpaf() {
        return flagaltpaf;
    }

    public void setFlagaltpaf(Character flagaltpaf) {
        this.flagaltpaf = flagaltpaf;
    }

    public Empresa getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Empresa codempresa) {
        this.codempresa = codempresa;
    }

    public Movecfrz getCodmovecfrz() {
        return codmovecfrz;
    }

    public void setCodmovecfrz(Movecfrz codmovecfrz) {
        this.codmovecfrz = codmovecfrz;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codmovecfrzitem != null ? codmovecfrzitem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movecfrzitem)) {
            return false;
        }
        Movecfrzitem other = (Movecfrzitem) object;
        if ((this.codmovecfrzitem == null && other.codmovecfrzitem != null) || (this.codmovecfrzitem != null && !this.codmovecfrzitem.equals(other.codmovecfrzitem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Movecfrzitem[ codmovecfrzitem=" + codmovecfrzitem + " ]";
    }
    
}
