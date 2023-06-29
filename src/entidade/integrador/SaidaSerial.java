/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade.integrador;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leonardo
 */
@Entity
@Table(name = "saida_serial")
@XmlRootElement

public class SaidaSerial implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_saida_serial")
    private Integer idSaidaSerial;
    @Column(name = "cod_saida")
    private String codSaida;
    @Column(name = "cod_saida_prod")
    private String codSaidaProd;
    @Column(name = "data_saida")
    @Temporal(TemporalType.DATE)
    private Date dataSaida;
    @Column(name = "devolvido")
    private Boolean devolvido;
    @JoinColumn(name = "id_serial", referencedColumnName = "id_serial")
    @ManyToOne
    private SerialProduto idSerial;

    public SaidaSerial() {
    }

    public SaidaSerial(Integer idSaidaSerial) {
        this.idSaidaSerial = idSaidaSerial;
    }

    public Integer getIdSaidaSerial() {
        return idSaidaSerial;
    }

    public void setIdSaidaSerial(Integer idSaidaSerial) {
        Integer oldIdSaidaSerial = this.idSaidaSerial;
        this.idSaidaSerial = idSaidaSerial;
        changeSupport.firePropertyChange("idSaidaSerial", oldIdSaidaSerial, idSaidaSerial);
    }

    public String getCodSaida() {
        return codSaida;
    }

    public void setCodSaida(String codSaida) {
        String oldCodSaida = this.codSaida;
        this.codSaida = codSaida;
        changeSupport.firePropertyChange("codSaida", oldCodSaida, codSaida);
    }

    public String getCodSaidaProd() {
        return codSaidaProd;
    }

    public void setCodSaidaProd(String codSaidaProd) {
        String oldCodSaidaProd = this.codSaidaProd;
        this.codSaidaProd = codSaidaProd;
        changeSupport.firePropertyChange("codSaidaProd", oldCodSaidaProd, codSaidaProd);
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        Date oldDataSaida = this.dataSaida;
        this.dataSaida = dataSaida;
        changeSupport.firePropertyChange("dataSaida", oldDataSaida, dataSaida);
    }

    public Boolean getDevolvido() {
        return devolvido;
    }

    public void setDevolvido(Boolean devolvido) {
        Boolean oldDevolvido = this.devolvido;
        this.devolvido = devolvido;
        changeSupport.firePropertyChange("devolvido", oldDevolvido, devolvido);
    }

    public SerialProduto getIdSerial() {
        return idSerial;
    }

    public void setIdSerial(SerialProduto idSerial) {
        SerialProduto oldIdSerial = this.idSerial;
        this.idSerial = idSerial;
        changeSupport.firePropertyChange("idSerial", oldIdSerial, idSerial);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSaidaSerial != null ? idSaidaSerial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SaidaSerial)) {
            return false;
        }
        SaidaSerial other = (SaidaSerial) object;
        if ((this.idSaidaSerial == null && other.idSaidaSerial != null) || (this.idSaidaSerial != null && !this.idSaidaSerial.equals(other.idSaidaSerial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.integrador.SaidaSerial[ idSaidaSerial=" + idSaidaSerial + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
