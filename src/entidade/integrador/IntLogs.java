/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.integrador;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "int_logs")

public class IntLogs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "entity_id")
    private Integer entityId;
    @Basic(optional = false)
    @Column(name = "data_execucao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataExecucao;
    @Basic(optional = false)
    @Column(name = "mensagem")
    private String mensagem;
    @Basic(optional = false)
    @Column(name = "tipo_log")
    private String tipoLog;

    public IntLogs() {
    }

    public IntLogs(Integer entityId) {
        this.entityId = entityId;
    }

    public IntLogs(Integer entityId, Date dataExecucao, String mensagem, String tipoLog) {
        this.entityId = entityId;
        this.dataExecucao = dataExecucao;
        this.mensagem = mensagem;
        this.tipoLog = tipoLog;
    }

    public Integer getEntityId() {
        return entityId;
    }

    public void setEntityId(Integer entityId) {
        this.entityId = entityId;
    }

    public Date getDataExecucao() {
        return dataExecucao;
    }

    public void setDataExecucao(Date dataExecucao) {
        this.dataExecucao = dataExecucao;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getTipoLog() {
        return tipoLog;
    }

    public void setTipoLog(String tipoLog) {
        this.tipoLog = tipoLog;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (entityId != null ? entityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IntLogs)) {
            return false;
        }
        IntLogs other = (IntLogs) object;
        if ((this.entityId == null && other.entityId != null) || (this.entityId != null && !this.entityId.equals(other.entityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.integrador.IntLogs[ entityId=" + entityId + " ]";
    }
    
}
