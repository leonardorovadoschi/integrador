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
@Table(name = "RECEBIMENTOITEM", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recebimentoitem.findAll", query = "SELECT r FROM Recebimentoitem r")
    , @NamedQuery(name = "Recebimentoitem.findByCodrec", query = "SELECT r FROM Recebimentoitem r WHERE r.codrec = :codrec")
    , @NamedQuery(name = "Recebimentoitem.findByCodempresa", query = "SELECT r FROM Recebimentoitem r WHERE r.codempresa = :codempresa")
    , @NamedQuery(name = "Recebimentoitem.findByNumparcelas", query = "SELECT r FROM Recebimentoitem r WHERE r.numparcelas = :numparcelas")
    , @NamedQuery(name = "Recebimentoitem.findByNumparcelasrecebimento", query = "SELECT r FROM Recebimentoitem r WHERE r.numparcelasrecebimento = :numparcelasrecebimento")
    , @NamedQuery(name = "Recebimentoitem.findByNumdiasprimeiraparcelavenda", query = "SELECT r FROM Recebimentoitem r WHERE r.numdiasprimeiraparcelavenda = :numdiasprimeiraparcelavenda")
    , @NamedQuery(name = "Recebimentoitem.findByNumdiasrecebimento", query = "SELECT r FROM Recebimentoitem r WHERE r.numdiasrecebimento = :numdiasrecebimento")
    , @NamedQuery(name = "Recebimentoitem.findByNumdiasintervalo", query = "SELECT r FROM Recebimentoitem r WHERE r.numdiasintervalo = :numdiasintervalo")
    , @NamedQuery(name = "Recebimentoitem.findByAliqconvenio", query = "SELECT r FROM Recebimentoitem r WHERE r.aliqconvenio = :aliqconvenio")
    , @NamedQuery(name = "Recebimentoitem.findByValortacconvenio", query = "SELECT r FROM Recebimentoitem r WHERE r.valortacconvenio = :valortacconvenio")
    , @NamedQuery(name = "Recebimentoitem.findByAliqtacconvenio", query = "SELECT r FROM Recebimentoitem r WHERE r.aliqtacconvenio = :aliqtacconvenio")
    , @NamedQuery(name = "Recebimentoitem.findByCodrecebimentoitem", query = "SELECT r FROM Recebimentoitem r WHERE r.codrecebimentoitem = :codrecebimentoitem")})
public class Recebimentoitem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "CODREC")
    private String codrec;
    @Basic(optional = false)
    @Column(name = "CODEMPRESA")
    private int codempresa;
    @Basic(optional = false)
    @Column(name = "NUMPARCELAS")
    private int numparcelas;
    @Basic(optional = false)
    @Column(name = "NUMPARCELASRECEBIMENTO")
    private int numparcelasrecebimento;
    @Basic(optional = false)
    @Column(name = "NUMDIASPRIMEIRAPARCELAVENDA")
    private int numdiasprimeiraparcelavenda;
    @Column(name = "NUMDIASRECEBIMENTO")
    private Integer numdiasrecebimento;
    @Column(name = "NUMDIASINTERVALO")
    private Integer numdiasintervalo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ALIQCONVENIO")
    private BigDecimal aliqconvenio;
    @Column(name = "VALORTACCONVENIO")
    private BigDecimal valortacconvenio;
    @Column(name = "ALIQTACCONVENIO")
    private BigDecimal aliqtacconvenio;
    @Id
    @Basic(optional = false)
    @Column(name = "CODRECEBIMENTOITEM")
    private String codrecebimentoitem;

    public Recebimentoitem() {
    }

    public Recebimentoitem(String codrecebimentoitem) {
        this.codrecebimentoitem = codrecebimentoitem;
    }

    public Recebimentoitem(String codrecebimentoitem, String codrec, int codempresa, int numparcelas, int numparcelasrecebimento, int numdiasprimeiraparcelavenda) {
        this.codrecebimentoitem = codrecebimentoitem;
        this.codrec = codrec;
        this.codempresa = codempresa;
        this.numparcelas = numparcelas;
        this.numparcelasrecebimento = numparcelasrecebimento;
        this.numdiasprimeiraparcelavenda = numdiasprimeiraparcelavenda;
    }

    public String getCodrec() {
        return codrec;
    }

    public void setCodrec(String codrec) {
        this.codrec = codrec;
    }

    public int getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(int codempresa) {
        this.codempresa = codempresa;
    }

    public int getNumparcelas() {
        return numparcelas;
    }

    public void setNumparcelas(int numparcelas) {
        this.numparcelas = numparcelas;
    }

    public int getNumparcelasrecebimento() {
        return numparcelasrecebimento;
    }

    public void setNumparcelasrecebimento(int numparcelasrecebimento) {
        this.numparcelasrecebimento = numparcelasrecebimento;
    }

    public int getNumdiasprimeiraparcelavenda() {
        return numdiasprimeiraparcelavenda;
    }

    public void setNumdiasprimeiraparcelavenda(int numdiasprimeiraparcelavenda) {
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

    public BigDecimal getAliqconvenio() {
        return aliqconvenio;
    }

    public void setAliqconvenio(BigDecimal aliqconvenio) {
        this.aliqconvenio = aliqconvenio;
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

    public String getCodrecebimentoitem() {
        return codrecebimentoitem;
    }

    public void setCodrecebimentoitem(String codrecebimentoitem) {
        this.codrecebimentoitem = codrecebimentoitem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codrecebimentoitem != null ? codrecebimentoitem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recebimentoitem)) {
            return false;
        }
        Recebimentoitem other = (Recebimentoitem) object;
        if ((this.codrecebimentoitem == null && other.codrecebimentoitem != null) || (this.codrecebimentoitem != null && !this.codrecebimentoitem.equals(other.codrecebimentoitem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Recebimentoitem[ codrecebimentoitem=" + codrecebimentoitem + " ]";
    }
    
}
