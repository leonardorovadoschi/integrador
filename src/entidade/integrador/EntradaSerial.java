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
@Table(name = "entrada_serial")
@XmlRootElement

public class EntradaSerial implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_entrada_serial")
    private Integer idEntradaSerial;
    @Column(name = "cod_entrada")
    private String codEntrada;
    @Column(name = "cod_entrada_prod")
    private String codEntradaProd;
    @Column(name = "data_entrada")
    @Temporal(TemporalType.DATE)
    private Date dataEntrada;
    @Column(name = "devolvido")
    private Boolean devolvido;
    @JoinColumn(name = "id_serial", referencedColumnName = "id_serial")
    @ManyToOne
    private SerialProduto idSerial;

    public EntradaSerial() {
    }

    public EntradaSerial(Integer idEntradaSerial) {
        this.idEntradaSerial = idEntradaSerial;
    }

    public Integer getIdEntradaSerial() {
        return idEntradaSerial;
    }

    public void setIdEntradaSerial(Integer idEntradaSerial) {
        Integer oldIdEntradaSerial = this.idEntradaSerial;
        this.idEntradaSerial = idEntradaSerial;
        changeSupport.firePropertyChange("idEntradaSerial", oldIdEntradaSerial, idEntradaSerial);
    }

    public String getCodEntrada() {
        return codEntrada;
    }

    public void setCodEntrada(String codEntrada) {
        String oldCodEntrada = this.codEntrada;
        this.codEntrada = codEntrada;
        changeSupport.firePropertyChange("codEntrada", oldCodEntrada, codEntrada);
    }

    public String getCodEntradaProd() {
        return codEntradaProd;
    }

    public void setCodEntradaProd(String codEntradaProd) {
        String oldCodEntradaProd = this.codEntradaProd;
        this.codEntradaProd = codEntradaProd;
        changeSupport.firePropertyChange("codEntradaProd", oldCodEntradaProd, codEntradaProd);
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        Date oldDataEntrada = this.dataEntrada;
        this.dataEntrada = dataEntrada;
        changeSupport.firePropertyChange("dataEntrada", oldDataEntrada, dataEntrada);
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
        hash += (idEntradaSerial != null ? idEntradaSerial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntradaSerial)) {
            return false;
        }
        EntradaSerial other = (EntradaSerial) object;
        if ((this.idEntradaSerial == null && other.idEntradaSerial != null) || (this.idEntradaSerial != null && !this.idEntradaSerial.equals(other.idEntradaSerial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.integrador.EntradaSerial[ idEntradaSerial=" + idEntradaSerial + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
