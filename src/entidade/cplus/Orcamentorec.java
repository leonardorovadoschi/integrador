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
@Table(name = "ORCAMENTOREC", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orcamentorec.findAll", query = "SELECT o FROM Orcamentorec o")
    , @NamedQuery(name = "Orcamentorec.findByCodorcamentorec", query = "SELECT o FROM Orcamentorec o WHERE o.codorcamentorec = :codorcamentorec")
    , @NamedQuery(name = "Orcamentorec.findByValor", query = "SELECT o FROM Orcamentorec o WHERE o.valor = :valor")
    , @NamedQuery(name = "Orcamentorec.findByNumparcelas", query = "SELECT o FROM Orcamentorec o WHERE o.numparcelas = :numparcelas")
    , @NamedQuery(name = "Orcamentorec.findByNumparcelasrecebimento", query = "SELECT o FROM Orcamentorec o WHERE o.numparcelasrecebimento = :numparcelasrecebimento")
    , @NamedQuery(name = "Orcamentorec.findByNumdiasprimeiraparcelavenda", query = "SELECT o FROM Orcamentorec o WHERE o.numdiasprimeiraparcelavenda = :numdiasprimeiraparcelavenda")
    , @NamedQuery(name = "Orcamentorec.findByNumdiasrecebimento", query = "SELECT o FROM Orcamentorec o WHERE o.numdiasrecebimento = :numdiasrecebimento")
    , @NamedQuery(name = "Orcamentorec.findByNumdiasintervalo", query = "SELECT o FROM Orcamentorec o WHERE o.numdiasintervalo = :numdiasintervalo")
    , @NamedQuery(name = "Orcamentorec.findByValortacconvenio", query = "SELECT o FROM Orcamentorec o WHERE o.valortacconvenio = :valortacconvenio")
    , @NamedQuery(name = "Orcamentorec.findByAliqtacconvenio", query = "SELECT o FROM Orcamentorec o WHERE o.aliqtacconvenio = :aliqtacconvenio")
    , @NamedQuery(name = "Orcamentorec.findByAliqconvenio", query = "SELECT o FROM Orcamentorec o WHERE o.aliqconvenio = :aliqconvenio")
    , @NamedQuery(name = "Orcamentorec.findByCodcli", query = "SELECT o FROM Orcamentorec o WHERE o.codcli = :codcli")})
public class Orcamentorec implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODORCAMENTOREC")
    private String codorcamentorec;
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
    @Column(name = "VALORTACCONVENIO")
    private BigDecimal valortacconvenio;
    @Column(name = "ALIQTACCONVENIO")
    private BigDecimal aliqtacconvenio;
    @Column(name = "ALIQCONVENIO")
    private BigDecimal aliqconvenio;
    @Column(name = "CODCLI")
    private String codcli;
    @JoinColumn(name = "CODORC", referencedColumnName = "CODORC")
    @ManyToOne(optional = false)
    private Orcamento codorc;
    @JoinColumn(name = "CODREC", referencedColumnName = "CODREC")
    @ManyToOne(optional = false)
    private Recebimento codrec;

    public Orcamentorec() {
    }

    public Orcamentorec(String codorcamentorec) {
        this.codorcamentorec = codorcamentorec;
    }

    public String getCodorcamentorec() {
        return codorcamentorec;
    }

    public void setCodorcamentorec(String codorcamentorec) {
        this.codorcamentorec = codorcamentorec;
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

    public BigDecimal getValortacconvenio() {
        return valortacconvenio;
    }

    public void setValortacconvenio(BigDecimal valortacconvenio) {
        this.valortacconvenio = valortacconvenio;
    }

    public BigDecimal getAliqtacconvenio() {
        return aliqtacconvenio;
    }

    public void setAliqtacconvenio(BigDecimal aliqtacconvenio) {
        this.aliqtacconvenio = aliqtacconvenio;
    }

    public BigDecimal getAliqconvenio() {
        return aliqconvenio;
    }

    public void setAliqconvenio(BigDecimal aliqconvenio) {
        this.aliqconvenio = aliqconvenio;
    }

    public String getCodcli() {
        return codcli;
    }

    public void setCodcli(String codcli) {
        this.codcli = codcli;
    }

    public Orcamento getCodorc() {
        return codorc;
    }

    public void setCodorc(Orcamento codorc) {
        this.codorc = codorc;
    }

    public Recebimento getCodrec() {
        return codrec;
    }

    public void setCodrec(Recebimento codrec) {
        this.codrec = codrec;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codorcamentorec != null ? codorcamentorec.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orcamentorec)) {
            return false;
        }
        Orcamentorec other = (Orcamentorec) object;
        if ((this.codorcamentorec == null && other.codorcamentorec != null) || (this.codorcamentorec != null && !this.codorcamentorec.equals(other.codorcamentorec))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Orcamentorec[ codorcamentorec=" + codorcamentorec + " ]";
    }
    
}
