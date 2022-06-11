/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "MOVECFRZ", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movecfrz.findAll", query = "SELECT m FROM Movecfrz m")
    , @NamedQuery(name = "Movecfrz.findByCodmovecfrz", query = "SELECT m FROM Movecfrz m WHERE m.codmovecfrz = :codmovecfrz")
    , @NamedQuery(name = "Movecfrz.findByCodecf", query = "SELECT m FROM Movecfrz m WHERE m.codecf = :codecf")
    , @NamedQuery(name = "Movecfrz.findByCrz", query = "SELECT m FROM Movecfrz m WHERE m.crz = :crz")
    , @NamedQuery(name = "Movecfrz.findByCro", query = "SELECT m FROM Movecfrz m WHERE m.cro = :cro")
    , @NamedQuery(name = "Movecfrz.findByCoo", query = "SELECT m FROM Movecfrz m WHERE m.coo = :coo")
    , @NamedQuery(name = "Movecfrz.findByCooinicial", query = "SELECT m FROM Movecfrz m WHERE m.cooinicial = :cooinicial")
    , @NamedQuery(name = "Movecfrz.findByCoofinal", query = "SELECT m FROM Movecfrz m WHERE m.coofinal = :coofinal")
    , @NamedQuery(name = "Movecfrz.findByNumeroserieecf", query = "SELECT m FROM Movecfrz m WHERE m.numeroserieecf = :numeroserieecf")
    , @NamedQuery(name = "Movecfrz.findByDatamovimento", query = "SELECT m FROM Movecfrz m WHERE m.datamovimento = :datamovimento")
    , @NamedQuery(name = "Movecfrz.findByDataemissao", query = "SELECT m FROM Movecfrz m WHERE m.dataemissao = :dataemissao")
    , @NamedQuery(name = "Movecfrz.findByHoraemissao", query = "SELECT m FROM Movecfrz m WHERE m.horaemissao = :horaemissao")
    , @NamedQuery(name = "Movecfrz.findByVendabrutadiaria", query = "SELECT m FROM Movecfrz m WHERE m.vendabrutadiaria = :vendabrutadiaria")
    , @NamedQuery(name = "Movecfrz.findByGtfinal", query = "SELECT m FROM Movecfrz m WHERE m.gtfinal = :gtfinal")
    , @NamedQuery(name = "Movecfrz.findByCodempresa", query = "SELECT m FROM Movecfrz m WHERE m.codempresa = :codempresa")
    , @NamedQuery(name = "Movecfrz.findByGuid", query = "SELECT m FROM Movecfrz m WHERE m.guid = :guid")
    , @NamedQuery(name = "Movecfrz.findByCcf", query = "SELECT m FROM Movecfrz m WHERE m.ccf = :ccf")
    , @NamedQuery(name = "Movecfrz.findByModeloecf", query = "SELECT m FROM Movecfrz m WHERE m.modeloecf = :modeloecf")
    , @NamedQuery(name = "Movecfrz.findByNumerousuario", query = "SELECT m FROM Movecfrz m WHERE m.numerousuario = :numerousuario")
    , @NamedQuery(name = "Movecfrz.findByFlagdescontoissqn", query = "SELECT m FROM Movecfrz m WHERE m.flagdescontoissqn = :flagdescontoissqn")
    , @NamedQuery(name = "Movecfrz.findByFlagaltpaf", query = "SELECT m FROM Movecfrz m WHERE m.flagaltpaf = :flagaltpaf")})
public class Movecfrz implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODMOVECFRZ")
    private String codmovecfrz;
    @Column(name = "CODECF")
    private String codecf;
    @Column(name = "CRZ")
    private Integer crz;
    @Column(name = "CRO")
    private Integer cro;
    @Column(name = "COO")
    private Integer coo;
    @Column(name = "COOINICIAL")
    private Integer cooinicial;
    @Column(name = "COOFINAL")
    private Integer coofinal;
    @Column(name = "NUMEROSERIEECF")
    private String numeroserieecf;
    @Column(name = "DATAMOVIMENTO")
    @Temporal(TemporalType.DATE)
    private Date datamovimento;
    @Column(name = "DATAEMISSAO")
    @Temporal(TemporalType.DATE)
    private Date dataemissao;
    @Column(name = "HORAEMISSAO")
    @Temporal(TemporalType.TIME)
    private Date horaemissao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VENDABRUTADIARIA")
    private BigDecimal vendabrutadiaria;
    @Column(name = "GTFINAL")
    private BigDecimal gtfinal;
    @Column(name = "CODEMPRESA")
    private Integer codempresa;
    @Column(name = "GUID")
    private String guid;
    @Column(name = "CCF")
    private Integer ccf;
    @Column(name = "MODELOECF")
    private String modeloecf;
    @Column(name = "NUMEROUSUARIO")
    private Short numerousuario;
    @Column(name = "FLAGDESCONTOISSQN")
    private Character flagdescontoissqn;
    @Column(name = "FLAGALTPAF")
    private Character flagaltpaf;
    @OneToMany(mappedBy = "codmovecfrz")
    private Collection<Movecfrzitem> movecfrzitemCollection;

    public Movecfrz() {
    }

    public Movecfrz(String codmovecfrz) {
        this.codmovecfrz = codmovecfrz;
    }

    public String getCodmovecfrz() {
        return codmovecfrz;
    }

    public void setCodmovecfrz(String codmovecfrz) {
        this.codmovecfrz = codmovecfrz;
    }

    public String getCodecf() {
        return codecf;
    }

    public void setCodecf(String codecf) {
        this.codecf = codecf;
    }

    public Integer getCrz() {
        return crz;
    }

    public void setCrz(Integer crz) {
        this.crz = crz;
    }

    public Integer getCro() {
        return cro;
    }

    public void setCro(Integer cro) {
        this.cro = cro;
    }

    public Integer getCoo() {
        return coo;
    }

    public void setCoo(Integer coo) {
        this.coo = coo;
    }

    public Integer getCooinicial() {
        return cooinicial;
    }

    public void setCooinicial(Integer cooinicial) {
        this.cooinicial = cooinicial;
    }

    public Integer getCoofinal() {
        return coofinal;
    }

    public void setCoofinal(Integer coofinal) {
        this.coofinal = coofinal;
    }

    public String getNumeroserieecf() {
        return numeroserieecf;
    }

    public void setNumeroserieecf(String numeroserieecf) {
        this.numeroserieecf = numeroserieecf;
    }

    public Date getDatamovimento() {
        return datamovimento;
    }

    public void setDatamovimento(Date datamovimento) {
        this.datamovimento = datamovimento;
    }

    public Date getDataemissao() {
        return dataemissao;
    }

    public void setDataemissao(Date dataemissao) {
        this.dataemissao = dataemissao;
    }

    public Date getHoraemissao() {
        return horaemissao;
    }

    public void setHoraemissao(Date horaemissao) {
        this.horaemissao = horaemissao;
    }

    public BigDecimal getVendabrutadiaria() {
        return vendabrutadiaria;
    }

    public void setVendabrutadiaria(BigDecimal vendabrutadiaria) {
        this.vendabrutadiaria = vendabrutadiaria;
    }

    public BigDecimal getGtfinal() {
        return gtfinal;
    }

    public void setGtfinal(BigDecimal gtfinal) {
        this.gtfinal = gtfinal;
    }

    public Integer getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Integer codempresa) {
        this.codempresa = codempresa;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Integer getCcf() {
        return ccf;
    }

    public void setCcf(Integer ccf) {
        this.ccf = ccf;
    }

    public String getModeloecf() {
        return modeloecf;
    }

    public void setModeloecf(String modeloecf) {
        this.modeloecf = modeloecf;
    }

    public Short getNumerousuario() {
        return numerousuario;
    }

    public void setNumerousuario(Short numerousuario) {
        this.numerousuario = numerousuario;
    }

    public Character getFlagdescontoissqn() {
        return flagdescontoissqn;
    }

    public void setFlagdescontoissqn(Character flagdescontoissqn) {
        this.flagdescontoissqn = flagdescontoissqn;
    }

    public Character getFlagaltpaf() {
        return flagaltpaf;
    }

    public void setFlagaltpaf(Character flagaltpaf) {
        this.flagaltpaf = flagaltpaf;
    }

    @XmlTransient
    public Collection<Movecfrzitem> getMovecfrzitemCollection() {
        return movecfrzitemCollection;
    }

    public void setMovecfrzitemCollection(Collection<Movecfrzitem> movecfrzitemCollection) {
        this.movecfrzitemCollection = movecfrzitemCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codmovecfrz != null ? codmovecfrz.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movecfrz)) {
            return false;
        }
        Movecfrz other = (Movecfrz) object;
        if ((this.codmovecfrz == null && other.codmovecfrz != null) || (this.codmovecfrz != null && !this.codmovecfrz.equals(other.codmovecfrz))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Movecfrz[ codmovecfrz=" + codmovecfrz + " ]";
    }
    
}
