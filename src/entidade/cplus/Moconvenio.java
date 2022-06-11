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
@Table(name = "MOCONVENIO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Moconvenio.findAll", query = "SELECT m FROM Moconvenio m")
    , @NamedQuery(name = "Moconvenio.findByCodmoconvenio", query = "SELECT m FROM Moconvenio m WHERE m.codmoconvenio = :codmoconvenio")
    , @NamedQuery(name = "Moconvenio.findByEntidadeorigem", query = "SELECT m FROM Moconvenio m WHERE m.entidadeorigem = :entidadeorigem")
    , @NamedQuery(name = "Moconvenio.findByIdentidadeorigem", query = "SELECT m FROM Moconvenio m WHERE m.identidadeorigem = :identidadeorigem")
    , @NamedQuery(name = "Moconvenio.findByValor", query = "SELECT m FROM Moconvenio m WHERE m.valor = :valor")
    , @NamedQuery(name = "Moconvenio.findByNumparcelas", query = "SELECT m FROM Moconvenio m WHERE m.numparcelas = :numparcelas")
    , @NamedQuery(name = "Moconvenio.findByNumparcelasrecebimento", query = "SELECT m FROM Moconvenio m WHERE m.numparcelasrecebimento = :numparcelasrecebimento")
    , @NamedQuery(name = "Moconvenio.findByNumdiasprimeiraparcelavenda", query = "SELECT m FROM Moconvenio m WHERE m.numdiasprimeiraparcelavenda = :numdiasprimeiraparcelavenda")
    , @NamedQuery(name = "Moconvenio.findByNumdiasrecebimento", query = "SELECT m FROM Moconvenio m WHERE m.numdiasrecebimento = :numdiasrecebimento")
    , @NamedQuery(name = "Moconvenio.findByNumdiasintervalo", query = "SELECT m FROM Moconvenio m WHERE m.numdiasintervalo = :numdiasintervalo")
    , @NamedQuery(name = "Moconvenio.findByValortac", query = "SELECT m FROM Moconvenio m WHERE m.valortac = :valortac")
    , @NamedQuery(name = "Moconvenio.findByAliquotatac", query = "SELECT m FROM Moconvenio m WHERE m.aliquotatac = :aliquotatac")
    , @NamedQuery(name = "Moconvenio.findByAliquota", query = "SELECT m FROM Moconvenio m WHERE m.aliquota = :aliquota")
    , @NamedQuery(name = "Moconvenio.findByCodcli", query = "SELECT m FROM Moconvenio m WHERE m.codcli = :codcli")
    , @NamedQuery(name = "Moconvenio.findByCodforn", query = "SELECT m FROM Moconvenio m WHERE m.codforn = :codforn")})
public class Moconvenio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODMOCONVENIO")
    private String codmoconvenio;
    @Column(name = "ENTIDADEORIGEM")
    private String entidadeorigem;
    @Column(name = "IDENTIDADEORIGEM")
    private String identidadeorigem;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALOR")
    private BigDecimal valor;
    @Column(name = "NUMPARCELAS")
    private Integer numparcelas;
    @Column(name = "NUMPARCELASRECEBIMENTO")
    private Integer numparcelasrecebimento;
    @Column(name = "NUMDIASPRIMEIRAPARCELAVENDA")
    private Integer numdiasprimeiraparcelavenda;
    @Column(name = "NUMDIASRECEBIMENTO")
    private Integer numdiasrecebimento;
    @Column(name = "NUMDIASINTERVALO")
    private Integer numdiasintervalo;
    @Column(name = "VALORTAC")
    private BigDecimal valortac;
    @Column(name = "ALIQUOTATAC")
    private BigDecimal aliquotatac;
    @Column(name = "ALIQUOTA")
    private BigDecimal aliquota;
    @Column(name = "CODCLI")
    private String codcli;
    @Column(name = "CODFORN")
    private String codforn;
    @JoinColumn(name = "CODEMPRESA", referencedColumnName = "CODEMPRESA")
    @ManyToOne
    private Empresa codempresa;

    public Moconvenio() {
    }

    public Moconvenio(String codmoconvenio) {
        this.codmoconvenio = codmoconvenio;
    }

    public String getCodmoconvenio() {
        return codmoconvenio;
    }

    public void setCodmoconvenio(String codmoconvenio) {
        this.codmoconvenio = codmoconvenio;
    }

    public String getEntidadeorigem() {
        return entidadeorigem;
    }

    public void setEntidadeorigem(String entidadeorigem) {
        this.entidadeorigem = entidadeorigem;
    }

    public String getIdentidadeorigem() {
        return identidadeorigem;
    }

    public void setIdentidadeorigem(String identidadeorigem) {
        this.identidadeorigem = identidadeorigem;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Integer getNumparcelas() {
        return numparcelas;
    }

    public void setNumparcelas(Integer numparcelas) {
        this.numparcelas = numparcelas;
    }

    public Integer getNumparcelasrecebimento() {
        return numparcelasrecebimento;
    }

    public void setNumparcelasrecebimento(Integer numparcelasrecebimento) {
        this.numparcelasrecebimento = numparcelasrecebimento;
    }

    public Integer getNumdiasprimeiraparcelavenda() {
        return numdiasprimeiraparcelavenda;
    }

    public void setNumdiasprimeiraparcelavenda(Integer numdiasprimeiraparcelavenda) {
        this.numdiasprimeiraparcelavenda = numdiasprimeiraparcelavenda;
    }

    public Integer getNumdiasrecebimento() {
        return numdiasrecebimento;
    }

    public void setNumdiasrecebimento(Integer numdiasrecebimento) {
        this.numdiasrecebimento = numdiasrecebimento;
    }

    public Integer getNumdiasintervalo() {
        return numdiasintervalo;
    }

    public void setNumdiasintervalo(Integer numdiasintervalo) {
        this.numdiasintervalo = numdiasintervalo;
    }

    public BigDecimal getValortac() {
        return valortac;
    }

    public void setValortac(BigDecimal valortac) {
        this.valortac = valortac;
    }

    public BigDecimal getAliquotatac() {
        return aliquotatac;
    }

    public void setAliquotatac(BigDecimal aliquotatac) {
        this.aliquotatac = aliquotatac;
    }

    public BigDecimal getAliquota() {
        return aliquota;
    }

    public void setAliquota(BigDecimal aliquota) {
        this.aliquota = aliquota;
    }

    public String getCodcli() {
        return codcli;
    }

    public void setCodcli(String codcli) {
        this.codcli = codcli;
    }

    public String getCodforn() {
        return codforn;
    }

    public void setCodforn(String codforn) {
        this.codforn = codforn;
    }

    public Empresa getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Empresa codempresa) {
        this.codempresa = codempresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codmoconvenio != null ? codmoconvenio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Moconvenio)) {
            return false;
        }
        Moconvenio other = (Moconvenio) object;
        if ((this.codmoconvenio == null && other.codmoconvenio != null) || (this.codmoconvenio != null && !this.codmoconvenio.equals(other.codmoconvenio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Moconvenio[ codmoconvenio=" + codmoconvenio + " ]";
    }
    
}
