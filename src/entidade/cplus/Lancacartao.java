/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "LANCACARTAO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lancacartao.findAll", query = "SELECT l FROM Lancacartao l")
    , @NamedQuery(name = "Lancacartao.findByCodlcar", query = "SELECT l FROM Lancacartao l WHERE l.codlcar = :codlcar")
    , @NamedQuery(name = "Lancacartao.findByCodpc", query = "SELECT l FROM Lancacartao l WHERE l.codpc = :codpc")
    , @NamedQuery(name = "Lancacartao.findByCodresumo", query = "SELECT l FROM Lancacartao l WHERE l.codresumo = :codresumo")
    , @NamedQuery(name = "Lancacartao.findByIdrec", query = "SELECT l FROM Lancacartao l WHERE l.idrec = :idrec")
    , @NamedQuery(name = "Lancacartao.findByData", query = "SELECT l FROM Lancacartao l WHERE l.data = :data")
    , @NamedQuery(name = "Lancacartao.findByValor", query = "SELECT l FROM Lancacartao l WHERE l.valor = :valor")
    , @NamedQuery(name = "Lancacartao.findByNumcar", query = "SELECT l FROM Lancacartao l WHERE l.numcar = :numcar")
    , @NamedQuery(name = "Lancacartao.findByNomeimp", query = "SELECT l FROM Lancacartao l WHERE l.nomeimp = :nomeimp")
    , @NamedQuery(name = "Lancacartao.findByAutoriza", query = "SELECT l FROM Lancacartao l WHERE l.autoriza = :autoriza")
    , @NamedQuery(name = "Lancacartao.findByFlagcli", query = "SELECT l FROM Lancacartao l WHERE l.flagcli = :flagcli")
    , @NamedQuery(name = "Lancacartao.findByParcelas", query = "SELECT l FROM Lancacartao l WHERE l.parcelas = :parcelas")
    , @NamedQuery(name = "Lancacartao.findByFlaglanc", query = "SELECT l FROM Lancacartao l WHERE l.flaglanc = :flaglanc")
    , @NamedQuery(name = "Lancacartao.findByDatquit", query = "SELECT l FROM Lancacartao l WHERE l.datquit = :datquit")
    , @NamedQuery(name = "Lancacartao.findByDatrec", query = "SELECT l FROM Lancacartao l WHERE l.datrec = :datrec")
    , @NamedQuery(name = "Lancacartao.findByValorrec", query = "SELECT l FROM Lancacartao l WHERE l.valorrec = :valorrec")
    , @NamedQuery(name = "Lancacartao.findByParcloja", query = "SELECT l FROM Lancacartao l WHERE l.parcloja = :parcloja")
    , @NamedQuery(name = "Lancacartao.findByNumresumo", query = "SELECT l FROM Lancacartao l WHERE l.numresumo = :numresumo")
    , @NamedQuery(name = "Lancacartao.findByFlagresumo", query = "SELECT l FROM Lancacartao l WHERE l.flagresumo = :flagresumo")
    , @NamedQuery(name = "Lancacartao.findByValidade", query = "SELECT l FROM Lancacartao l WHERE l.validade = :validade")})
public class Lancacartao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODLCAR")
    private String codlcar;
    @Column(name = "CODPC")
    private String codpc;
    @Column(name = "CODRESUMO")
    private String codresumo;
    @Column(name = "IDREC")
    private Integer idrec;
    @Basic(optional = false)
    @Column(name = "DATA")
    @Temporal(TemporalType.DATE)
    private Date data;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "VALOR")
    private BigDecimal valor;
    @Basic(optional = false)
    @Column(name = "NUMCAR")
    private String numcar;
    @Basic(optional = false)
    @Column(name = "NOMEIMP")
    private String nomeimp;
    @Basic(optional = false)
    @Column(name = "AUTORIZA")
    private String autoriza;
    @Column(name = "FLAGCLI")
    private Character flagcli;
    @Basic(optional = false)
    @Column(name = "PARCELAS")
    private short parcelas;
    @Column(name = "FLAGLANC")
    private Character flaglanc;
    @Column(name = "DATQUIT")
    @Temporal(TemporalType.DATE)
    private Date datquit;
    @Column(name = "DATREC")
    @Temporal(TemporalType.DATE)
    private Date datrec;
    @Column(name = "VALORREC")
    private BigDecimal valorrec;
    @Column(name = "PARCLOJA")
    private Character parcloja;
    @Column(name = "NUMRESUMO")
    private String numresumo;
    @Column(name = "FLAGRESUMO")
    private Character flagresumo;
    @Column(name = "VALIDADE")
    private String validade;
    @JoinColumn(name = "CODCLI", referencedColumnName = "CODCLI")
    @ManyToOne
    private Cliente codcli;
    @JoinColumn(name = "CODCR", referencedColumnName = "CODCR")
    @ManyToOne
    private Contareceber codcr;
    @JoinColumn(name = "CODEMPRESA", referencedColumnName = "CODEMPRESA")
    @ManyToOne(optional = false)
    private Empresa codempresa;
    @JoinColumn(name = "CODMOVENDA", referencedColumnName = "CODMOVENDA")
    @ManyToOne
    private Movenda codmovenda;
    @JoinColumn(name = "CODCAR", referencedColumnName = "CODCAR")
    @ManyToOne(optional = false)
    private Tipocartao codcar;

    public Lancacartao() {
    }

    public Lancacartao(String codlcar) {
        this.codlcar = codlcar;
    }

    public Lancacartao(String codlcar, Date data, BigDecimal valor, String numcar, String nomeimp, String autoriza, short parcelas) {
        this.codlcar = codlcar;
        this.data = data;
        this.valor = valor;
        this.numcar = numcar;
        this.nomeimp = nomeimp;
        this.autoriza = autoriza;
        this.parcelas = parcelas;
    }

    public String getCodlcar() {
        return codlcar;
    }

    public void setCodlcar(String codlcar) {
        this.codlcar = codlcar;
    }

    public String getCodpc() {
        return codpc;
    }

    public void setCodpc(String codpc) {
        this.codpc = codpc;
    }

    public String getCodresumo() {
        return codresumo;
    }

    public void setCodresumo(String codresumo) {
        this.codresumo = codresumo;
    }

    public Integer getIdrec() {
        return idrec;
    }

    public void setIdrec(Integer idrec) {
        this.idrec = idrec;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getNumcar() {
        return numcar;
    }

    public void setNumcar(String numcar) {
        this.numcar = numcar;
    }

    public String getNomeimp() {
        return nomeimp;
    }

    public void setNomeimp(String nomeimp) {
        this.nomeimp = nomeimp;
    }

    public String getAutoriza() {
        return autoriza;
    }

    public void setAutoriza(String autoriza) {
        this.autoriza = autoriza;
    }

    public Character getFlagcli() {
        return flagcli;
    }

    public void setFlagcli(Character flagcli) {
        this.flagcli = flagcli;
    }

    public short getParcelas() {
        return parcelas;
    }

    public void setParcelas(short parcelas) {
        this.parcelas = parcelas;
    }

    public Character getFlaglanc() {
        return flaglanc;
    }

    public void setFlaglanc(Character flaglanc) {
        this.flaglanc = flaglanc;
    }

    public Date getDatquit() {
        return datquit;
    }

    public void setDatquit(Date datquit) {
        this.datquit = datquit;
    }

    public Date getDatrec() {
        return datrec;
    }

    public void setDatrec(Date datrec) {
        this.datrec = datrec;
    }

    public BigDecimal getValorrec() {
        return valorrec;
    }

    public void setValorrec(BigDecimal valorrec) {
        this.valorrec = valorrec;
    }

    public Character getParcloja() {
        return parcloja;
    }

    public void setParcloja(Character parcloja) {
        this.parcloja = parcloja;
    }

    public String getNumresumo() {
        return numresumo;
    }

    public void setNumresumo(String numresumo) {
        this.numresumo = numresumo;
    }

    public Character getFlagresumo() {
        return flagresumo;
    }

    public void setFlagresumo(Character flagresumo) {
        this.flagresumo = flagresumo;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public Cliente getCodcli() {
        return codcli;
    }

    public void setCodcli(Cliente codcli) {
        this.codcli = codcli;
    }

    public Contareceber getCodcr() {
        return codcr;
    }

    public void setCodcr(Contareceber codcr) {
        this.codcr = codcr;
    }

    public Empresa getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Empresa codempresa) {
        this.codempresa = codempresa;
    }

    public Movenda getCodmovenda() {
        return codmovenda;
    }

    public void setCodmovenda(Movenda codmovenda) {
        this.codmovenda = codmovenda;
    }

    public Tipocartao getCodcar() {
        return codcar;
    }

    public void setCodcar(Tipocartao codcar) {
        this.codcar = codcar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codlcar != null ? codlcar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lancacartao)) {
            return false;
        }
        Lancacartao other = (Lancacartao) object;
        if ((this.codlcar == null && other.codlcar != null) || (this.codlcar != null && !this.codlcar.equals(other.codlcar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Lancacartao[ codlcar=" + codlcar + " ]";
    }
    
}
