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
@Table(name = "NUTRICIONAL", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nutricional.findAll", query = "SELECT n FROM Nutricional n")
    , @NamedQuery(name = "Nutricional.findByCodnutricional", query = "SELECT n FROM Nutricional n WHERE n.codnutricional = :codnutricional")
    , @NamedQuery(name = "Nutricional.findByCodigo", query = "SELECT n FROM Nutricional n WHERE n.codigo = :codigo")
    , @NamedQuery(name = "Nutricional.findByNomenutricional", query = "SELECT n FROM Nutricional n WHERE n.nomenutricional = :nomenutricional")
    , @NamedQuery(name = "Nutricional.findByQuantidade", query = "SELECT n FROM Nutricional n WHERE n.quantidade = :quantidade")
    , @NamedQuery(name = "Nutricional.findByFlagunidadeporcao", query = "SELECT n FROM Nutricional n WHERE n.flagunidadeporcao = :flagunidadeporcao")
    , @NamedQuery(name = "Nutricional.findByInteiromedidacaseira", query = "SELECT n FROM Nutricional n WHERE n.inteiromedidacaseira = :inteiromedidacaseira")
    , @NamedQuery(name = "Nutricional.findByDecimalmedidacaseira", query = "SELECT n FROM Nutricional n WHERE n.decimalmedidacaseira = :decimalmedidacaseira")
    , @NamedQuery(name = "Nutricional.findByMedidacaseira", query = "SELECT n FROM Nutricional n WHERE n.medidacaseira = :medidacaseira")
    , @NamedQuery(name = "Nutricional.findByValorcalorico", query = "SELECT n FROM Nutricional n WHERE n.valorcalorico = :valorcalorico")
    , @NamedQuery(name = "Nutricional.findByPercvalorcalorico", query = "SELECT n FROM Nutricional n WHERE n.percvalorcalorico = :percvalorcalorico")
    , @NamedQuery(name = "Nutricional.findByValorcarboidratos", query = "SELECT n FROM Nutricional n WHERE n.valorcarboidratos = :valorcarboidratos")
    , @NamedQuery(name = "Nutricional.findByPerccarboidratos", query = "SELECT n FROM Nutricional n WHERE n.perccarboidratos = :perccarboidratos")
    , @NamedQuery(name = "Nutricional.findByValorproteinas", query = "SELECT n FROM Nutricional n WHERE n.valorproteinas = :valorproteinas")
    , @NamedQuery(name = "Nutricional.findByPercproteinas", query = "SELECT n FROM Nutricional n WHERE n.percproteinas = :percproteinas")
    , @NamedQuery(name = "Nutricional.findByValorgordurastotais", query = "SELECT n FROM Nutricional n WHERE n.valorgordurastotais = :valorgordurastotais")
    , @NamedQuery(name = "Nutricional.findByPercgordurastotais", query = "SELECT n FROM Nutricional n WHERE n.percgordurastotais = :percgordurastotais")
    , @NamedQuery(name = "Nutricional.findByValorgordurassaturadas", query = "SELECT n FROM Nutricional n WHERE n.valorgordurassaturadas = :valorgordurassaturadas")
    , @NamedQuery(name = "Nutricional.findByPercgordurassaturadas", query = "SELECT n FROM Nutricional n WHERE n.percgordurassaturadas = :percgordurassaturadas")
    , @NamedQuery(name = "Nutricional.findByValorgordurastrans", query = "SELECT n FROM Nutricional n WHERE n.valorgordurastrans = :valorgordurastrans")
    , @NamedQuery(name = "Nutricional.findByPercgordurastrans", query = "SELECT n FROM Nutricional n WHERE n.percgordurastrans = :percgordurastrans")
    , @NamedQuery(name = "Nutricional.findByValorcolesterol", query = "SELECT n FROM Nutricional n WHERE n.valorcolesterol = :valorcolesterol")
    , @NamedQuery(name = "Nutricional.findByPerccolesterol", query = "SELECT n FROM Nutricional n WHERE n.perccolesterol = :perccolesterol")
    , @NamedQuery(name = "Nutricional.findByValorfibras", query = "SELECT n FROM Nutricional n WHERE n.valorfibras = :valorfibras")
    , @NamedQuery(name = "Nutricional.findByPercfibras", query = "SELECT n FROM Nutricional n WHERE n.percfibras = :percfibras")
    , @NamedQuery(name = "Nutricional.findByValorcalcio", query = "SELECT n FROM Nutricional n WHERE n.valorcalcio = :valorcalcio")
    , @NamedQuery(name = "Nutricional.findByPerccalcio", query = "SELECT n FROM Nutricional n WHERE n.perccalcio = :perccalcio")
    , @NamedQuery(name = "Nutricional.findByValorferro", query = "SELECT n FROM Nutricional n WHERE n.valorferro = :valorferro")
    , @NamedQuery(name = "Nutricional.findByPercferro", query = "SELECT n FROM Nutricional n WHERE n.percferro = :percferro")
    , @NamedQuery(name = "Nutricional.findByValorsodio", query = "SELECT n FROM Nutricional n WHERE n.valorsodio = :valorsodio")
    , @NamedQuery(name = "Nutricional.findByPercsodio", query = "SELECT n FROM Nutricional n WHERE n.percsodio = :percsodio")})
public class Nutricional implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODNUTRICIONAL")
    private String codnutricional;
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "NOMENUTRICIONAL")
    private String nomenutricional;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "QUANTIDADE")
    private BigDecimal quantidade;
    @Column(name = "FLAGUNIDADEPORCAO")
    private Character flagunidadeporcao;
    @Column(name = "INTEIROMEDIDACASEIRA")
    private Integer inteiromedidacaseira;
    @Column(name = "DECIMALMEDIDACASEIRA")
    private Integer decimalmedidacaseira;
    @Column(name = "MEDIDACASEIRA")
    private Integer medidacaseira;
    @Column(name = "VALORCALORICO")
    private BigDecimal valorcalorico;
    @Column(name = "PERCVALORCALORICO")
    private BigDecimal percvalorcalorico;
    @Column(name = "VALORCARBOIDRATOS")
    private BigDecimal valorcarboidratos;
    @Column(name = "PERCCARBOIDRATOS")
    private BigDecimal perccarboidratos;
    @Column(name = "VALORPROTEINAS")
    private BigDecimal valorproteinas;
    @Column(name = "PERCPROTEINAS")
    private BigDecimal percproteinas;
    @Column(name = "VALORGORDURASTOTAIS")
    private BigDecimal valorgordurastotais;
    @Column(name = "PERCGORDURASTOTAIS")
    private BigDecimal percgordurastotais;
    @Column(name = "VALORGORDURASSATURADAS")
    private BigDecimal valorgordurassaturadas;
    @Column(name = "PERCGORDURASSATURADAS")
    private BigDecimal percgordurassaturadas;
    @Column(name = "VALORGORDURASTRANS")
    private BigDecimal valorgordurastrans;
    @Column(name = "PERCGORDURASTRANS")
    private BigDecimal percgordurastrans;
    @Column(name = "VALORCOLESTEROL")
    private BigDecimal valorcolesterol;
    @Column(name = "PERCCOLESTEROL")
    private BigDecimal perccolesterol;
    @Column(name = "VALORFIBRAS")
    private BigDecimal valorfibras;
    @Column(name = "PERCFIBRAS")
    private BigDecimal percfibras;
    @Column(name = "VALORCALCIO")
    private BigDecimal valorcalcio;
    @Column(name = "PERCCALCIO")
    private BigDecimal perccalcio;
    @Column(name = "VALORFERRO")
    private BigDecimal valorferro;
    @Column(name = "PERCFERRO")
    private BigDecimal percferro;
    @Column(name = "VALORSODIO")
    private BigDecimal valorsodio;
    @Column(name = "PERCSODIO")
    private BigDecimal percsodio;

    public Nutricional() {
    }

    public Nutricional(String codnutricional) {
        this.codnutricional = codnutricional;
    }

    public Nutricional(String codnutricional, String codigo) {
        this.codnutricional = codnutricional;
        this.codigo = codigo;
    }

    public String getCodnutricional() {
        return codnutricional;
    }

    public void setCodnutricional(String codnutricional) {
        this.codnutricional = codnutricional;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomenutricional() {
        return nomenutricional;
    }

    public void setNomenutricional(String nomenutricional) {
        this.nomenutricional = nomenutricional;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public Character getFlagunidadeporcao() {
        return flagunidadeporcao;
    }

    public void setFlagunidadeporcao(Character flagunidadeporcao) {
        this.flagunidadeporcao = flagunidadeporcao;
    }

    public Integer getInteiromedidacaseira() {
        return inteiromedidacaseira;
    }

    public void setInteiromedidacaseira(Integer inteiromedidacaseira) {
        this.inteiromedidacaseira = inteiromedidacaseira;
    }

    public Integer getDecimalmedidacaseira() {
        return decimalmedidacaseira;
    }

    public void setDecimalmedidacaseira(Integer decimalmedidacaseira) {
        this.decimalmedidacaseira = decimalmedidacaseira;
    }

    public Integer getMedidacaseira() {
        return medidacaseira;
    }

    public void setMedidacaseira(Integer medidacaseira) {
        this.medidacaseira = medidacaseira;
    }

    public BigDecimal getValorcalorico() {
        return valorcalorico;
    }

    public void setValorcalorico(BigDecimal valorcalorico) {
        this.valorcalorico = valorcalorico;
    }

    public BigDecimal getPercvalorcalorico() {
        return percvalorcalorico;
    }

    public void setPercvalorcalorico(BigDecimal percvalorcalorico) {
        this.percvalorcalorico = percvalorcalorico;
    }

    public BigDecimal getValorcarboidratos() {
        return valorcarboidratos;
    }

    public void setValorcarboidratos(BigDecimal valorcarboidratos) {
        this.valorcarboidratos = valorcarboidratos;
    }

    public BigDecimal getPerccarboidratos() {
        return perccarboidratos;
    }

    public void setPerccarboidratos(BigDecimal perccarboidratos) {
        this.perccarboidratos = perccarboidratos;
    }

    public BigDecimal getValorproteinas() {
        return valorproteinas;
    }

    public void setValorproteinas(BigDecimal valorproteinas) {
        this.valorproteinas = valorproteinas;
    }

    public BigDecimal getPercproteinas() {
        return percproteinas;
    }

    public void setPercproteinas(BigDecimal percproteinas) {
        this.percproteinas = percproteinas;
    }

    public BigDecimal getValorgordurastotais() {
        return valorgordurastotais;
    }

    public void setValorgordurastotais(BigDecimal valorgordurastotais) {
        this.valorgordurastotais = valorgordurastotais;
    }

    public BigDecimal getPercgordurastotais() {
        return percgordurastotais;
    }

    public void setPercgordurastotais(BigDecimal percgordurastotais) {
        this.percgordurastotais = percgordurastotais;
    }

    public BigDecimal getValorgordurassaturadas() {
        return valorgordurassaturadas;
    }

    public void setValorgordurassaturadas(BigDecimal valorgordurassaturadas) {
        this.valorgordurassaturadas = valorgordurassaturadas;
    }

    public BigDecimal getPercgordurassaturadas() {
        return percgordurassaturadas;
    }

    public void setPercgordurassaturadas(BigDecimal percgordurassaturadas) {
        this.percgordurassaturadas = percgordurassaturadas;
    }

    public BigDecimal getValorgordurastrans() {
        return valorgordurastrans;
    }

    public void setValorgordurastrans(BigDecimal valorgordurastrans) {
        this.valorgordurastrans = valorgordurastrans;
    }

    public BigDecimal getPercgordurastrans() {
        return percgordurastrans;
    }

    public void setPercgordurastrans(BigDecimal percgordurastrans) {
        this.percgordurastrans = percgordurastrans;
    }

    public BigDecimal getValorcolesterol() {
        return valorcolesterol;
    }

    public void setValorcolesterol(BigDecimal valorcolesterol) {
        this.valorcolesterol = valorcolesterol;
    }

    public BigDecimal getPerccolesterol() {
        return perccolesterol;
    }

    public void setPerccolesterol(BigDecimal perccolesterol) {
        this.perccolesterol = perccolesterol;
    }

    public BigDecimal getValorfibras() {
        return valorfibras;
    }

    public void setValorfibras(BigDecimal valorfibras) {
        this.valorfibras = valorfibras;
    }

    public BigDecimal getPercfibras() {
        return percfibras;
    }

    public void setPercfibras(BigDecimal percfibras) {
        this.percfibras = percfibras;
    }

    public BigDecimal getValorcalcio() {
        return valorcalcio;
    }

    public void setValorcalcio(BigDecimal valorcalcio) {
        this.valorcalcio = valorcalcio;
    }

    public BigDecimal getPerccalcio() {
        return perccalcio;
    }

    public void setPerccalcio(BigDecimal perccalcio) {
        this.perccalcio = perccalcio;
    }

    public BigDecimal getValorferro() {
        return valorferro;
    }

    public void setValorferro(BigDecimal valorferro) {
        this.valorferro = valorferro;
    }

    public BigDecimal getPercferro() {
        return percferro;
    }

    public void setPercferro(BigDecimal percferro) {
        this.percferro = percferro;
    }

    public BigDecimal getValorsodio() {
        return valorsodio;
    }

    public void setValorsodio(BigDecimal valorsodio) {
        this.valorsodio = valorsodio;
    }

    public BigDecimal getPercsodio() {
        return percsodio;
    }

    public void setPercsodio(BigDecimal percsodio) {
        this.percsodio = percsodio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codnutricional != null ? codnutricional.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nutricional)) {
            return false;
        }
        Nutricional other = (Nutricional) object;
        if ((this.codnutricional == null && other.codnutricional != null) || (this.codnutricional != null && !this.codnutricional.equals(other.codnutricional))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Nutricional[ codnutricional=" + codnutricional + " ]";
    }
    
}
