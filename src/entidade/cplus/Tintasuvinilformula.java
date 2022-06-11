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
@Table(name = "TINTASUVINILFORMULA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tintasuvinilformula.findAll", query = "SELECT t FROM Tintasuvinilformula t")
    , @NamedQuery(name = "Tintasuvinilformula.findByCodtintasuvinilformula", query = "SELECT t FROM Tintasuvinilformula t WHERE t.codtintasuvinilformula = :codtintasuvinilformula")
    , @NamedQuery(name = "Tintasuvinilformula.findByCodtintasuvinilproduto", query = "SELECT t FROM Tintasuvinilformula t WHERE t.codtintasuvinilproduto = :codtintasuvinilproduto")
    , @NamedQuery(name = "Tintasuvinilformula.findByNomegrupo", query = "SELECT t FROM Tintasuvinilformula t WHERE t.nomegrupo = :nomegrupo")
    , @NamedQuery(name = "Tintasuvinilformula.findByCodtintasuvinilcorrgb", query = "SELECT t FROM Tintasuvinilformula t WHERE t.codtintasuvinilcorrgb = :codtintasuvinilcorrgb")
    , @NamedQuery(name = "Tintasuvinilformula.findByBase", query = "SELECT t FROM Tintasuvinilformula t WHERE t.base = :base")
    , @NamedQuery(name = "Tintasuvinilformula.findByVolume", query = "SELECT t FROM Tintasuvinilformula t WHERE t.volume = :volume")
    , @NamedQuery(name = "Tintasuvinilformula.findBySiglacolorante01", query = "SELECT t FROM Tintasuvinilformula t WHERE t.siglacolorante01 = :siglacolorante01")
    , @NamedQuery(name = "Tintasuvinilformula.findBySiglacolorante02", query = "SELECT t FROM Tintasuvinilformula t WHERE t.siglacolorante02 = :siglacolorante02")
    , @NamedQuery(name = "Tintasuvinilformula.findBySiglacolorante03", query = "SELECT t FROM Tintasuvinilformula t WHERE t.siglacolorante03 = :siglacolorante03")
    , @NamedQuery(name = "Tintasuvinilformula.findBySiglacolorante04", query = "SELECT t FROM Tintasuvinilformula t WHERE t.siglacolorante04 = :siglacolorante04")
    , @NamedQuery(name = "Tintasuvinilformula.findBySiglacolorante05", query = "SELECT t FROM Tintasuvinilformula t WHERE t.siglacolorante05 = :siglacolorante05")
    , @NamedQuery(name = "Tintasuvinilformula.findByQtdecolorante01", query = "SELECT t FROM Tintasuvinilformula t WHERE t.qtdecolorante01 = :qtdecolorante01")
    , @NamedQuery(name = "Tintasuvinilformula.findByQtdecolorante02", query = "SELECT t FROM Tintasuvinilformula t WHERE t.qtdecolorante02 = :qtdecolorante02")
    , @NamedQuery(name = "Tintasuvinilformula.findByQtdecolorante03", query = "SELECT t FROM Tintasuvinilformula t WHERE t.qtdecolorante03 = :qtdecolorante03")
    , @NamedQuery(name = "Tintasuvinilformula.findByQtdecolorante04", query = "SELECT t FROM Tintasuvinilformula t WHERE t.qtdecolorante04 = :qtdecolorante04")
    , @NamedQuery(name = "Tintasuvinilformula.findByQtdecolorante05", query = "SELECT t FROM Tintasuvinilformula t WHERE t.qtdecolorante05 = :qtdecolorante05")
    , @NamedQuery(name = "Tintasuvinilformula.findByDescricaoproduto", query = "SELECT t FROM Tintasuvinilformula t WHERE t.descricaoproduto = :descricaoproduto")
    , @NamedQuery(name = "Tintasuvinilformula.findByComplementoproduto", query = "SELECT t FROM Tintasuvinilformula t WHERE t.complementoproduto = :complementoproduto")
    , @NamedQuery(name = "Tintasuvinilformula.findByDescricaocompleta", query = "SELECT t FROM Tintasuvinilformula t WHERE t.descricaocompleta = :descricaocompleta")
    , @NamedQuery(name = "Tintasuvinilformula.findByFatorcolorante01", query = "SELECT t FROM Tintasuvinilformula t WHERE t.fatorcolorante01 = :fatorcolorante01")
    , @NamedQuery(name = "Tintasuvinilformula.findByFatorcolorante02", query = "SELECT t FROM Tintasuvinilformula t WHERE t.fatorcolorante02 = :fatorcolorante02")
    , @NamedQuery(name = "Tintasuvinilformula.findByFatorcolorante03", query = "SELECT t FROM Tintasuvinilformula t WHERE t.fatorcolorante03 = :fatorcolorante03")
    , @NamedQuery(name = "Tintasuvinilformula.findByFatorcolorante04", query = "SELECT t FROM Tintasuvinilformula t WHERE t.fatorcolorante04 = :fatorcolorante04")
    , @NamedQuery(name = "Tintasuvinilformula.findByFatorcolorante05", query = "SELECT t FROM Tintasuvinilformula t WHERE t.fatorcolorante05 = :fatorcolorante05")
    , @NamedQuery(name = "Tintasuvinilformula.findByCodprodcolorante01", query = "SELECT t FROM Tintasuvinilformula t WHERE t.codprodcolorante01 = :codprodcolorante01")
    , @NamedQuery(name = "Tintasuvinilformula.findByCodprodcolorante02", query = "SELECT t FROM Tintasuvinilformula t WHERE t.codprodcolorante02 = :codprodcolorante02")
    , @NamedQuery(name = "Tintasuvinilformula.findByCodprodcolorante03", query = "SELECT t FROM Tintasuvinilformula t WHERE t.codprodcolorante03 = :codprodcolorante03")
    , @NamedQuery(name = "Tintasuvinilformula.findByCodprodcolorante04", query = "SELECT t FROM Tintasuvinilformula t WHERE t.codprodcolorante04 = :codprodcolorante04")
    , @NamedQuery(name = "Tintasuvinilformula.findByCodprodcolorante05", query = "SELECT t FROM Tintasuvinilformula t WHERE t.codprodcolorante05 = :codprodcolorante05")
    , @NamedQuery(name = "Tintasuvinilformula.findByCodprodbase", query = "SELECT t FROM Tintasuvinilformula t WHERE t.codprodbase = :codprodbase")})
public class Tintasuvinilformula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODTINTASUVINILFORMULA")
    private Integer codtintasuvinilformula;
    @Column(name = "CODTINTASUVINILPRODUTO")
    private Integer codtintasuvinilproduto;
    @Column(name = "NOMEGRUPO")
    private String nomegrupo;
    @Column(name = "CODTINTASUVINILCORRGB")
    private String codtintasuvinilcorrgb;
    @Column(name = "BASE")
    private String base;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VOLUME")
    private BigDecimal volume;
    @Column(name = "SIGLACOLORANTE01")
    private String siglacolorante01;
    @Column(name = "SIGLACOLORANTE02")
    private String siglacolorante02;
    @Column(name = "SIGLACOLORANTE03")
    private String siglacolorante03;
    @Column(name = "SIGLACOLORANTE04")
    private String siglacolorante04;
    @Column(name = "SIGLACOLORANTE05")
    private String siglacolorante05;
    @Column(name = "QTDECOLORANTE01")
    private Integer qtdecolorante01;
    @Column(name = "QTDECOLORANTE02")
    private Integer qtdecolorante02;
    @Column(name = "QTDECOLORANTE03")
    private Integer qtdecolorante03;
    @Column(name = "QTDECOLORANTE04")
    private Integer qtdecolorante04;
    @Column(name = "QTDECOLORANTE05")
    private Integer qtdecolorante05;
    @Column(name = "DESCRICAOPRODUTO")
    private String descricaoproduto;
    @Column(name = "COMPLEMENTOPRODUTO")
    private String complementoproduto;
    @Column(name = "DESCRICAOCOMPLETA")
    private String descricaocompleta;
    @Column(name = "FATORCOLORANTE01")
    private BigDecimal fatorcolorante01;
    @Column(name = "FATORCOLORANTE02")
    private BigDecimal fatorcolorante02;
    @Column(name = "FATORCOLORANTE03")
    private BigDecimal fatorcolorante03;
    @Column(name = "FATORCOLORANTE04")
    private BigDecimal fatorcolorante04;
    @Column(name = "FATORCOLORANTE05")
    private BigDecimal fatorcolorante05;
    @Column(name = "CODPRODCOLORANTE01")
    private String codprodcolorante01;
    @Column(name = "CODPRODCOLORANTE02")
    private String codprodcolorante02;
    @Column(name = "CODPRODCOLORANTE03")
    private String codprodcolorante03;
    @Column(name = "CODPRODCOLORANTE04")
    private String codprodcolorante04;
    @Column(name = "CODPRODCOLORANTE05")
    private String codprodcolorante05;
    @Column(name = "CODPRODBASE")
    private String codprodbase;

    public Tintasuvinilformula() {
    }

    public Tintasuvinilformula(Integer codtintasuvinilformula) {
        this.codtintasuvinilformula = codtintasuvinilformula;
    }

    public Integer getCodtintasuvinilformula() {
        return codtintasuvinilformula;
    }

    public void setCodtintasuvinilformula(Integer codtintasuvinilformula) {
        this.codtintasuvinilformula = codtintasuvinilformula;
    }

    public Integer getCodtintasuvinilproduto() {
        return codtintasuvinilproduto;
    }

    public void setCodtintasuvinilproduto(Integer codtintasuvinilproduto) {
        this.codtintasuvinilproduto = codtintasuvinilproduto;
    }

    public String getNomegrupo() {
        return nomegrupo;
    }

    public void setNomegrupo(String nomegrupo) {
        this.nomegrupo = nomegrupo;
    }

    public String getCodtintasuvinilcorrgb() {
        return codtintasuvinilcorrgb;
    }

    public void setCodtintasuvinilcorrgb(String codtintasuvinilcorrgb) {
        this.codtintasuvinilcorrgb = codtintasuvinilcorrgb;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public String getSiglacolorante01() {
        return siglacolorante01;
    }

    public void setSiglacolorante01(String siglacolorante01) {
        this.siglacolorante01 = siglacolorante01;
    }

    public String getSiglacolorante02() {
        return siglacolorante02;
    }

    public void setSiglacolorante02(String siglacolorante02) {
        this.siglacolorante02 = siglacolorante02;
    }

    public String getSiglacolorante03() {
        return siglacolorante03;
    }

    public void setSiglacolorante03(String siglacolorante03) {
        this.siglacolorante03 = siglacolorante03;
    }

    public String getSiglacolorante04() {
        return siglacolorante04;
    }

    public void setSiglacolorante04(String siglacolorante04) {
        this.siglacolorante04 = siglacolorante04;
    }

    public String getSiglacolorante05() {
        return siglacolorante05;
    }

    public void setSiglacolorante05(String siglacolorante05) {
        this.siglacolorante05 = siglacolorante05;
    }

    public Integer getQtdecolorante01() {
        return qtdecolorante01;
    }

    public void setQtdecolorante01(Integer qtdecolorante01) {
        this.qtdecolorante01 = qtdecolorante01;
    }

    public Integer getQtdecolorante02() {
        return qtdecolorante02;
    }

    public void setQtdecolorante02(Integer qtdecolorante02) {
        this.qtdecolorante02 = qtdecolorante02;
    }

    public Integer getQtdecolorante03() {
        return qtdecolorante03;
    }

    public void setQtdecolorante03(Integer qtdecolorante03) {
        this.qtdecolorante03 = qtdecolorante03;
    }

    public Integer getQtdecolorante04() {
        return qtdecolorante04;
    }

    public void setQtdecolorante04(Integer qtdecolorante04) {
        this.qtdecolorante04 = qtdecolorante04;
    }

    public Integer getQtdecolorante05() {
        return qtdecolorante05;
    }

    public void setQtdecolorante05(Integer qtdecolorante05) {
        this.qtdecolorante05 = qtdecolorante05;
    }

    public String getDescricaoproduto() {
        return descricaoproduto;
    }

    public void setDescricaoproduto(String descricaoproduto) {
        this.descricaoproduto = descricaoproduto;
    }

    public String getComplementoproduto() {
        return complementoproduto;
    }

    public void setComplementoproduto(String complementoproduto) {
        this.complementoproduto = complementoproduto;
    }

    public String getDescricaocompleta() {
        return descricaocompleta;
    }

    public void setDescricaocompleta(String descricaocompleta) {
        this.descricaocompleta = descricaocompleta;
    }

    public BigDecimal getFatorcolorante01() {
        return fatorcolorante01;
    }

    public void setFatorcolorante01(BigDecimal fatorcolorante01) {
        this.fatorcolorante01 = fatorcolorante01;
    }

    public BigDecimal getFatorcolorante02() {
        return fatorcolorante02;
    }

    public void setFatorcolorante02(BigDecimal fatorcolorante02) {
        this.fatorcolorante02 = fatorcolorante02;
    }

    public BigDecimal getFatorcolorante03() {
        return fatorcolorante03;
    }

    public void setFatorcolorante03(BigDecimal fatorcolorante03) {
        this.fatorcolorante03 = fatorcolorante03;
    }

    public BigDecimal getFatorcolorante04() {
        return fatorcolorante04;
    }

    public void setFatorcolorante04(BigDecimal fatorcolorante04) {
        this.fatorcolorante04 = fatorcolorante04;
    }

    public BigDecimal getFatorcolorante05() {
        return fatorcolorante05;
    }

    public void setFatorcolorante05(BigDecimal fatorcolorante05) {
        this.fatorcolorante05 = fatorcolorante05;
    }

    public String getCodprodcolorante01() {
        return codprodcolorante01;
    }

    public void setCodprodcolorante01(String codprodcolorante01) {
        this.codprodcolorante01 = codprodcolorante01;
    }

    public String getCodprodcolorante02() {
        return codprodcolorante02;
    }

    public void setCodprodcolorante02(String codprodcolorante02) {
        this.codprodcolorante02 = codprodcolorante02;
    }

    public String getCodprodcolorante03() {
        return codprodcolorante03;
    }

    public void setCodprodcolorante03(String codprodcolorante03) {
        this.codprodcolorante03 = codprodcolorante03;
    }

    public String getCodprodcolorante04() {
        return codprodcolorante04;
    }

    public void setCodprodcolorante04(String codprodcolorante04) {
        this.codprodcolorante04 = codprodcolorante04;
    }

    public String getCodprodcolorante05() {
        return codprodcolorante05;
    }

    public void setCodprodcolorante05(String codprodcolorante05) {
        this.codprodcolorante05 = codprodcolorante05;
    }

    public String getCodprodbase() {
        return codprodbase;
    }

    public void setCodprodbase(String codprodbase) {
        this.codprodbase = codprodbase;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codtintasuvinilformula != null ? codtintasuvinilformula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tintasuvinilformula)) {
            return false;
        }
        Tintasuvinilformula other = (Tintasuvinilformula) object;
        if ((this.codtintasuvinilformula == null && other.codtintasuvinilformula != null) || (this.codtintasuvinilformula != null && !this.codtintasuvinilformula.equals(other.codtintasuvinilformula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Tintasuvinilformula[ codtintasuvinilformula=" + codtintasuvinilformula + " ]";
    }
    
}
