/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "TAREFAAGENDADA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tarefaagendada.findAll", query = "SELECT t FROM Tarefaagendada t")
    , @NamedQuery(name = "Tarefaagendada.findByCodtarefaagendada", query = "SELECT t FROM Tarefaagendada t WHERE t.codtarefaagendada = :codtarefaagendada")
    , @NamedQuery(name = "Tarefaagendada.findByCodigo", query = "SELECT t FROM Tarefaagendada t WHERE t.codigo = :codigo")
    , @NamedQuery(name = "Tarefaagendada.findByNometarefaagendada", query = "SELECT t FROM Tarefaagendada t WHERE t.nometarefaagendada = :nometarefaagendada")
    , @NamedQuery(name = "Tarefaagendada.findByCoduser", query = "SELECT t FROM Tarefaagendada t WHERE t.coduser = :coduser")
    , @NamedQuery(name = "Tarefaagendada.findByComando", query = "SELECT t FROM Tarefaagendada t WHERE t.comando = :comando")
    , @NamedQuery(name = "Tarefaagendada.findByFlagativo", query = "SELECT t FROM Tarefaagendada t WHERE t.flagativo = :flagativo")
    , @NamedQuery(name = "Tarefaagendada.findByFlagtipoocorrencia", query = "SELECT t FROM Tarefaagendada t WHERE t.flagtipoocorrencia = :flagtipoocorrencia")
    , @NamedQuery(name = "Tarefaagendada.findByFlagtipofrequencia", query = "SELECT t FROM Tarefaagendada t WHERE t.flagtipofrequencia = :flagtipofrequencia")
    , @NamedQuery(name = "Tarefaagendada.findByHoraexecucao", query = "SELECT t FROM Tarefaagendada t WHERE t.horaexecucao = :horaexecucao")
    , @NamedQuery(name = "Tarefaagendada.findByHorainicialfrequencia", query = "SELECT t FROM Tarefaagendada t WHERE t.horainicialfrequencia = :horainicialfrequencia")
    , @NamedQuery(name = "Tarefaagendada.findByHorafinalfrequencia", query = "SELECT t FROM Tarefaagendada t WHERE t.horafinalfrequencia = :horafinalfrequencia")
    , @NamedQuery(name = "Tarefaagendada.findByFlagtipohorariofrequecia", query = "SELECT t FROM Tarefaagendada t WHERE t.flagtipohorariofrequecia = :flagtipohorariofrequecia")
    , @NamedQuery(name = "Tarefaagendada.findByDatainicialtarefa", query = "SELECT t FROM Tarefaagendada t WHERE t.datainicialtarefa = :datainicialtarefa")
    , @NamedQuery(name = "Tarefaagendada.findByDatafinaltarefa", query = "SELECT t FROM Tarefaagendada t WHERE t.datafinaltarefa = :datafinaltarefa")})
public class Tarefaagendada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODTAREFAAGENDADA")
    private String codtarefaagendada;
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "NOMETAREFAAGENDADA")
    private String nometarefaagendada;
    @Column(name = "CODUSER")
    private String coduser;
    @Column(name = "COMANDO")
    private String comando;
    @Column(name = "FLAGATIVO")
    private Character flagativo;
    @Column(name = "FLAGTIPOOCORRENCIA")
    private Character flagtipoocorrencia;
    @Column(name = "FLAGTIPOFREQUENCIA")
    private Character flagtipofrequencia;
    @Column(name = "HORAEXECUCAO")
    private String horaexecucao;
    @Column(name = "HORAINICIALFREQUENCIA")
    private String horainicialfrequencia;
    @Column(name = "HORAFINALFREQUENCIA")
    private String horafinalfrequencia;
    @Column(name = "FLAGTIPOHORARIOFREQUECIA")
    private Character flagtipohorariofrequecia;
    @Column(name = "DATAINICIALTAREFA")
    @Temporal(TemporalType.DATE)
    private Date datainicialtarefa;
    @Column(name = "DATAFINALTAREFA")
    @Temporal(TemporalType.DATE)
    private Date datafinaltarefa;
    @Lob
    @Column(name = "OBSERVACAO")
    private String observacao;

    public Tarefaagendada() {
    }

    public Tarefaagendada(String codtarefaagendada) {
        this.codtarefaagendada = codtarefaagendada;
    }

    public String getCodtarefaagendada() {
        return codtarefaagendada;
    }

    public void setCodtarefaagendada(String codtarefaagendada) {
        this.codtarefaagendada = codtarefaagendada;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNometarefaagendada() {
        return nometarefaagendada;
    }

    public void setNometarefaagendada(String nometarefaagendada) {
        this.nometarefaagendada = nometarefaagendada;
    }

    public String getCoduser() {
        return coduser;
    }

    public void setCoduser(String coduser) {
        this.coduser = coduser;
    }

    public String getComando() {
        return comando;
    }

    public void setComando(String comando) {
        this.comando = comando;
    }

    public Character getFlagativo() {
        return flagativo;
    }

    public void setFlagativo(Character flagativo) {
        this.flagativo = flagativo;
    }

    public Character getFlagtipoocorrencia() {
        return flagtipoocorrencia;
    }

    public void setFlagtipoocorrencia(Character flagtipoocorrencia) {
        this.flagtipoocorrencia = flagtipoocorrencia;
    }

    public Character getFlagtipofrequencia() {
        return flagtipofrequencia;
    }

    public void setFlagtipofrequencia(Character flagtipofrequencia) {
        this.flagtipofrequencia = flagtipofrequencia;
    }

    public String getHoraexecucao() {
        return horaexecucao;
    }

    public void setHoraexecucao(String horaexecucao) {
        this.horaexecucao = horaexecucao;
    }

    public String getHorainicialfrequencia() {
        return horainicialfrequencia;
    }

    public void setHorainicialfrequencia(String horainicialfrequencia) {
        this.horainicialfrequencia = horainicialfrequencia;
    }

    public String getHorafinalfrequencia() {
        return horafinalfrequencia;
    }

    public void setHorafinalfrequencia(String horafinalfrequencia) {
        this.horafinalfrequencia = horafinalfrequencia;
    }

    public Character getFlagtipohorariofrequecia() {
        return flagtipohorariofrequecia;
    }

    public void setFlagtipohorariofrequecia(Character flagtipohorariofrequecia) {
        this.flagtipohorariofrequecia = flagtipohorariofrequecia;
    }

    public Date getDatainicialtarefa() {
        return datainicialtarefa;
    }

    public void setDatainicialtarefa(Date datainicialtarefa) {
        this.datainicialtarefa = datainicialtarefa;
    }

    public Date getDatafinaltarefa() {
        return datafinaltarefa;
    }

    public void setDatafinaltarefa(Date datafinaltarefa) {
        this.datafinaltarefa = datafinaltarefa;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codtarefaagendada != null ? codtarefaagendada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tarefaagendada)) {
            return false;
        }
        Tarefaagendada other = (Tarefaagendada) object;
        if ((this.codtarefaagendada == null && other.codtarefaagendada != null) || (this.codtarefaagendada != null && !this.codtarefaagendada.equals(other.codtarefaagendada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Tarefaagendada[ codtarefaagendada=" + codtarefaagendada + " ]";
    }
    
}
