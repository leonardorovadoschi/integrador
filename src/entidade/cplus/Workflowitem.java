/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
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
@Table(name = "WORKFLOWITEM", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Workflowitem.findAll", query = "SELECT w FROM Workflowitem w")
    , @NamedQuery(name = "Workflowitem.findByCodworkflowitem", query = "SELECT w FROM Workflowitem w WHERE w.codworkflowitem = :codworkflowitem")
    , @NamedQuery(name = "Workflowitem.findByOrdem", query = "SELECT w FROM Workflowitem w WHERE w.ordem = :ordem")
    , @NamedQuery(name = "Workflowitem.findByFlagtipoinformacao", query = "SELECT w FROM Workflowitem w WHERE w.flagtipoinformacao = :flagtipoinformacao")
    , @NamedQuery(name = "Workflowitem.findByDescricaopergunta", query = "SELECT w FROM Workflowitem w WHERE w.descricaopergunta = :descricaopergunta")
    , @NamedQuery(name = "Workflowitem.findByDescricaoresposta1", query = "SELECT w FROM Workflowitem w WHERE w.descricaoresposta1 = :descricaoresposta1")
    , @NamedQuery(name = "Workflowitem.findByDescricaoresposta2", query = "SELECT w FROM Workflowitem w WHERE w.descricaoresposta2 = :descricaoresposta2")
    , @NamedQuery(name = "Workflowitem.findByDescricaoresposta3", query = "SELECT w FROM Workflowitem w WHERE w.descricaoresposta3 = :descricaoresposta3")
    , @NamedQuery(name = "Workflowitem.findByDescricaoresposta4", query = "SELECT w FROM Workflowitem w WHERE w.descricaoresposta4 = :descricaoresposta4")
    , @NamedQuery(name = "Workflowitem.findByDescricaoresposta5", query = "SELECT w FROM Workflowitem w WHERE w.descricaoresposta5 = :descricaoresposta5")
    , @NamedQuery(name = "Workflowitem.findByDescricaoresposta6", query = "SELECT w FROM Workflowitem w WHERE w.descricaoresposta6 = :descricaoresposta6")
    , @NamedQuery(name = "Workflowitem.findByOrdem1", query = "SELECT w FROM Workflowitem w WHERE w.ordem1 = :ordem1")
    , @NamedQuery(name = "Workflowitem.findByOrdem2", query = "SELECT w FROM Workflowitem w WHERE w.ordem2 = :ordem2")
    , @NamedQuery(name = "Workflowitem.findByOrdem3", query = "SELECT w FROM Workflowitem w WHERE w.ordem3 = :ordem3")
    , @NamedQuery(name = "Workflowitem.findByOrdem4", query = "SELECT w FROM Workflowitem w WHERE w.ordem4 = :ordem4")
    , @NamedQuery(name = "Workflowitem.findByOrdem5", query = "SELECT w FROM Workflowitem w WHERE w.ordem5 = :ordem5")
    , @NamedQuery(name = "Workflowitem.findByOrdem6", query = "SELECT w FROM Workflowitem w WHERE w.ordem6 = :ordem6")
    , @NamedQuery(name = "Workflowitem.findByFlagusuarioobrigatorio", query = "SELECT w FROM Workflowitem w WHERE w.flagusuarioobrigatorio = :flagusuarioobrigatorio")
    , @NamedQuery(name = "Workflowitem.findByProximaordem", query = "SELECT w FROM Workflowitem w WHERE w.proximaordem = :proximaordem")})
public class Workflowitem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODWORKFLOWITEM")
    private String codworkflowitem;
    @Column(name = "ORDEM")
    private String ordem;
    @Column(name = "FLAGTIPOINFORMACAO")
    private Character flagtipoinformacao;
    @Column(name = "DESCRICAOPERGUNTA")
    private String descricaopergunta;
    @Column(name = "DESCRICAORESPOSTA1")
    private String descricaoresposta1;
    @Column(name = "DESCRICAORESPOSTA2")
    private String descricaoresposta2;
    @Column(name = "DESCRICAORESPOSTA3")
    private String descricaoresposta3;
    @Column(name = "DESCRICAORESPOSTA4")
    private String descricaoresposta4;
    @Column(name = "DESCRICAORESPOSTA5")
    private String descricaoresposta5;
    @Column(name = "DESCRICAORESPOSTA6")
    private String descricaoresposta6;
    @Column(name = "ORDEM1")
    private String ordem1;
    @Column(name = "ORDEM2")
    private String ordem2;
    @Column(name = "ORDEM3")
    private String ordem3;
    @Column(name = "ORDEM4")
    private String ordem4;
    @Column(name = "ORDEM5")
    private String ordem5;
    @Column(name = "ORDEM6")
    private String ordem6;
    @Column(name = "FLAGUSUARIOOBRIGATORIO")
    private Character flagusuarioobrigatorio;
    @Column(name = "PROXIMAORDEM")
    private String proximaordem;
    @JoinColumn(name = "CODCENTRORESPONSABILIDADE", referencedColumnName = "CODCENTRORESPONSABILIDADE")
    @ManyToOne
    private Centroresponsabilidade codcentroresponsabilidade;
    @JoinColumn(name = "CODWORKFLOW", referencedColumnName = "CODWORKFLOW")
    @ManyToOne
    private Workflow codworkflow;
    @JoinColumn(name = "CODWORKFLOWENCADEADO", referencedColumnName = "CODWORKFLOW")
    @ManyToOne
    private Workflow codworkflowencadeado;

    public Workflowitem() {
    }

    public Workflowitem(String codworkflowitem) {
        this.codworkflowitem = codworkflowitem;
    }

    public String getCodworkflowitem() {
        return codworkflowitem;
    }

    public void setCodworkflowitem(String codworkflowitem) {
        this.codworkflowitem = codworkflowitem;
    }

    public String getOrdem() {
        return ordem;
    }

    public void setOrdem(String ordem) {
        this.ordem = ordem;
    }

    public Character getFlagtipoinformacao() {
        return flagtipoinformacao;
    }

    public void setFlagtipoinformacao(Character flagtipoinformacao) {
        this.flagtipoinformacao = flagtipoinformacao;
    }

    public String getDescricaopergunta() {
        return descricaopergunta;
    }

    public void setDescricaopergunta(String descricaopergunta) {
        this.descricaopergunta = descricaopergunta;
    }

    public String getDescricaoresposta1() {
        return descricaoresposta1;
    }

    public void setDescricaoresposta1(String descricaoresposta1) {
        this.descricaoresposta1 = descricaoresposta1;
    }

    public String getDescricaoresposta2() {
        return descricaoresposta2;
    }

    public void setDescricaoresposta2(String descricaoresposta2) {
        this.descricaoresposta2 = descricaoresposta2;
    }

    public String getDescricaoresposta3() {
        return descricaoresposta3;
    }

    public void setDescricaoresposta3(String descricaoresposta3) {
        this.descricaoresposta3 = descricaoresposta3;
    }

    public String getDescricaoresposta4() {
        return descricaoresposta4;
    }

    public void setDescricaoresposta4(String descricaoresposta4) {
        this.descricaoresposta4 = descricaoresposta4;
    }

    public String getDescricaoresposta5() {
        return descricaoresposta5;
    }

    public void setDescricaoresposta5(String descricaoresposta5) {
        this.descricaoresposta5 = descricaoresposta5;
    }

    public String getDescricaoresposta6() {
        return descricaoresposta6;
    }

    public void setDescricaoresposta6(String descricaoresposta6) {
        this.descricaoresposta6 = descricaoresposta6;
    }

    public String getOrdem1() {
        return ordem1;
    }

    public void setOrdem1(String ordem1) {
        this.ordem1 = ordem1;
    }

    public String getOrdem2() {
        return ordem2;
    }

    public void setOrdem2(String ordem2) {
        this.ordem2 = ordem2;
    }

    public String getOrdem3() {
        return ordem3;
    }

    public void setOrdem3(String ordem3) {
        this.ordem3 = ordem3;
    }

    public String getOrdem4() {
        return ordem4;
    }

    public void setOrdem4(String ordem4) {
        this.ordem4 = ordem4;
    }

    public String getOrdem5() {
        return ordem5;
    }

    public void setOrdem5(String ordem5) {
        this.ordem5 = ordem5;
    }

    public String getOrdem6() {
        return ordem6;
    }

    public void setOrdem6(String ordem6) {
        this.ordem6 = ordem6;
    }

    public Character getFlagusuarioobrigatorio() {
        return flagusuarioobrigatorio;
    }

    public void setFlagusuarioobrigatorio(Character flagusuarioobrigatorio) {
        this.flagusuarioobrigatorio = flagusuarioobrigatorio;
    }

    public String getProximaordem() {
        return proximaordem;
    }

    public void setProximaordem(String proximaordem) {
        this.proximaordem = proximaordem;
    }

    public Centroresponsabilidade getCodcentroresponsabilidade() {
        return codcentroresponsabilidade;
    }

    public void setCodcentroresponsabilidade(Centroresponsabilidade codcentroresponsabilidade) {
        this.codcentroresponsabilidade = codcentroresponsabilidade;
    }

    public Workflow getCodworkflow() {
        return codworkflow;
    }

    public void setCodworkflow(Workflow codworkflow) {
        this.codworkflow = codworkflow;
    }

    public Workflow getCodworkflowencadeado() {
        return codworkflowencadeado;
    }

    public void setCodworkflowencadeado(Workflow codworkflowencadeado) {
        this.codworkflowencadeado = codworkflowencadeado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codworkflowitem != null ? codworkflowitem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Workflowitem)) {
            return false;
        }
        Workflowitem other = (Workflowitem) object;
        if ((this.codworkflowitem == null && other.codworkflowitem != null) || (this.codworkflowitem != null && !this.codworkflowitem.equals(other.codworkflowitem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Workflowitem[ codworkflowitem=" + codworkflowitem + " ]";
    }
    
}
