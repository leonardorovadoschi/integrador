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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "VFPE", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vfpe.findAll", query = "SELECT v FROM Vfpe v")
    , @NamedQuery(name = "Vfpe.findByCodvfpe", query = "SELECT v FROM Vfpe v WHERE v.codvfpe = :codvfpe")
    , @NamedQuery(name = "Vfpe.findByCodmovendarec", query = "SELECT v FROM Vfpe v WHERE v.codmovendarec = :codmovendarec")
    , @NamedQuery(name = "Vfpe.findByGuid", query = "SELECT v FROM Vfpe v WHERE v.guid = :guid")
    , @NamedQuery(name = "Vfpe.findByGuidmovendarec", query = "SELECT v FROM Vfpe v WHERE v.guidmovendarec = :guidmovendarec")
    , @NamedQuery(name = "Vfpe.findByCodpos", query = "SELECT v FROM Vfpe v WHERE v.codpos = :codpos")
    , @NamedQuery(name = "Vfpe.findByCodigoautorizacao", query = "SELECT v FROM Vfpe v WHERE v.codigoautorizacao = :codigoautorizacao")
    , @NamedQuery(name = "Vfpe.findByBincartao", query = "SELECT v FROM Vfpe v WHERE v.bincartao = :bincartao")
    , @NamedQuery(name = "Vfpe.findByUltimosquatrodigitos", query = "SELECT v FROM Vfpe v WHERE v.ultimosquatrodigitos = :ultimosquatrodigitos")
    , @NamedQuery(name = "Vfpe.findByMesanoexpiracao", query = "SELECT v FROM Vfpe v WHERE v.mesanoexpiracao = :mesanoexpiracao")
    , @NamedQuery(name = "Vfpe.findByInstituicaofinanceira", query = "SELECT v FROM Vfpe v WHERE v.instituicaofinanceira = :instituicaofinanceira")
    , @NamedQuery(name = "Vfpe.findByDonocartao", query = "SELECT v FROM Vfpe v WHERE v.donocartao = :donocartao")
    , @NamedQuery(name = "Vfpe.findByParcelas", query = "SELECT v FROM Vfpe v WHERE v.parcelas = :parcelas")
    , @NamedQuery(name = "Vfpe.findByValorpagamento", query = "SELECT v FROM Vfpe v WHERE v.valorpagamento = :valorpagamento")
    , @NamedQuery(name = "Vfpe.findByCodigopagamento", query = "SELECT v FROM Vfpe v WHERE v.codigopagamento = :codigopagamento")
    , @NamedQuery(name = "Vfpe.findByTipobandeira", query = "SELECT v FROM Vfpe v WHERE v.tipobandeira = :tipobandeira")
    , @NamedQuery(name = "Vfpe.findByIdpagamento", query = "SELECT v FROM Vfpe v WHERE v.idpagamento = :idpagamento")
    , @NamedQuery(name = "Vfpe.findByIdrespostafiscal", query = "SELECT v FROM Vfpe v WHERE v.idrespostafiscal = :idrespostafiscal")
    , @NamedQuery(name = "Vfpe.findByFlagidprovisorio", query = "SELECT v FROM Vfpe v WHERE v.flagidprovisorio = :flagidprovisorio")
    , @NamedQuery(name = "Vfpe.findBySerialpos", query = "SELECT v FROM Vfpe v WHERE v.serialpos = :serialpos")})
public class Vfpe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODVFPE")
    private String codvfpe;
    @Basic(optional = false)
    @Column(name = "CODMOVENDAREC")
    private String codmovendarec;
    @Column(name = "GUID")
    private String guid;
    @Column(name = "GUIDMOVENDAREC")
    private String guidmovendarec;
    @Column(name = "CODPOS")
    private String codpos;
    @Column(name = "CODIGOAUTORIZACAO")
    private String codigoautorizacao;
    @Column(name = "BINCARTAO")
    private String bincartao;
    @Column(name = "ULTIMOSQUATRODIGITOS")
    private String ultimosquatrodigitos;
    @Column(name = "MESANOEXPIRACAO")
    private String mesanoexpiracao;
    @Column(name = "INSTITUICAOFINANCEIRA")
    private String instituicaofinanceira;
    @Column(name = "DONOCARTAO")
    private String donocartao;
    @Column(name = "PARCELAS")
    private String parcelas;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALORPAGAMENTO")
    private BigDecimal valorpagamento;
    @Column(name = "CODIGOPAGAMENTO")
    private String codigopagamento;
    @Column(name = "TIPOBANDEIRA")
    private String tipobandeira;
    @Column(name = "IDPAGAMENTO")
    private String idpagamento;
    @Column(name = "IDRESPOSTAFISCAL")
    private String idrespostafiscal;
    @Column(name = "FLAGIDPROVISORIO")
    private Character flagidprovisorio;
    @Column(name = "SERIALPOS")
    private String serialpos;

    public Vfpe() {
    }

    public Vfpe(String codvfpe) {
        this.codvfpe = codvfpe;
    }

    public Vfpe(String codvfpe, String codmovendarec) {
        this.codvfpe = codvfpe;
        this.codmovendarec = codmovendarec;
    }

    public String getCodvfpe() {
        return codvfpe;
    }

    public void setCodvfpe(String codvfpe) {
        this.codvfpe = codvfpe;
    }

    public String getCodmovendarec() {
        return codmovendarec;
    }

    public void setCodmovendarec(String codmovendarec) {
        this.codmovendarec = codmovendarec;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getGuidmovendarec() {
        return guidmovendarec;
    }

    public void setGuidmovendarec(String guidmovendarec) {
        this.guidmovendarec = guidmovendarec;
    }

    public String getCodpos() {
        return codpos;
    }

    public void setCodpos(String codpos) {
        this.codpos = codpos;
    }

    public String getCodigoautorizacao() {
        return codigoautorizacao;
    }

    public void setCodigoautorizacao(String codigoautorizacao) {
        this.codigoautorizacao = codigoautorizacao;
    }

    public String getBincartao() {
        return bincartao;
    }

    public void setBincartao(String bincartao) {
        this.bincartao = bincartao;
    }

    public String getUltimosquatrodigitos() {
        return ultimosquatrodigitos;
    }

    public void setUltimosquatrodigitos(String ultimosquatrodigitos) {
        this.ultimosquatrodigitos = ultimosquatrodigitos;
    }

    public String getMesanoexpiracao() {
        return mesanoexpiracao;
    }

    public void setMesanoexpiracao(String mesanoexpiracao) {
        this.mesanoexpiracao = mesanoexpiracao;
    }

    public String getInstituicaofinanceira() {
        return instituicaofinanceira;
    }

    public void setInstituicaofinanceira(String instituicaofinanceira) {
        this.instituicaofinanceira = instituicaofinanceira;
    }

    public String getDonocartao() {
        return donocartao;
    }

    public void setDonocartao(String donocartao) {
        this.donocartao = donocartao;
    }

    public String getParcelas() {
        return parcelas;
    }

    public void setParcelas(String parcelas) {
        this.parcelas = parcelas;
    }

    public BigDecimal getValorpagamento() {
        return valorpagamento;
    }

    public void setValorpagamento(BigDecimal valorpagamento) {
        this.valorpagamento = valorpagamento;
    }

    public String getCodigopagamento() {
        return codigopagamento;
    }

    public void setCodigopagamento(String codigopagamento) {
        this.codigopagamento = codigopagamento;
    }

    public String getTipobandeira() {
        return tipobandeira;
    }

    public void setTipobandeira(String tipobandeira) {
        this.tipobandeira = tipobandeira;
    }

    public String getIdpagamento() {
        return idpagamento;
    }

    public void setIdpagamento(String idpagamento) {
        this.idpagamento = idpagamento;
    }

    public String getIdrespostafiscal() {
        return idrespostafiscal;
    }

    public void setIdrespostafiscal(String idrespostafiscal) {
        this.idrespostafiscal = idrespostafiscal;
    }

    public Character getFlagidprovisorio() {
        return flagidprovisorio;
    }

    public void setFlagidprovisorio(Character flagidprovisorio) {
        this.flagidprovisorio = flagidprovisorio;
    }

    public String getSerialpos() {
        return serialpos;
    }

    public void setSerialpos(String serialpos) {
        this.serialpos = serialpos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codvfpe != null ? codvfpe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vfpe)) {
            return false;
        }
        Vfpe other = (Vfpe) object;
        if ((this.codvfpe == null && other.codvfpe != null) || (this.codvfpe != null && !this.codvfpe.equals(other.codvfpe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Vfpe[ codvfpe=" + codvfpe + " ]";
    }
    
}
