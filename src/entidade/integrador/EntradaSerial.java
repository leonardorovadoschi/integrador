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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leonardo
 */
@Entity
@Table(name = "entrada_serial")
@XmlRootElement

public class EntradaSerial implements Serializable {
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
        this.idEntradaSerial = idEntradaSerial;
    }

    public String getCodEntrada() {
        return codEntrada;
    }

    public void setCodEntrada(String codEntrada) {
        this.codEntrada = codEntrada;
    }

    public String getCodEntradaProd() {
        return codEntradaProd;
    }

    public void setCodEntradaProd(String codEntradaProd) {
        this.codEntradaProd = codEntradaProd;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Boolean getDevolvido() {
        return devolvido;
    }

    public void setDevolvido(Boolean devolvido) {
        this.devolvido = devolvido;
    }

    public SerialProduto getIdSerial() {
        return idSerial;
    }

    public void setIdSerial(SerialProduto idSerial) {
        this.idSerial = idSerial;
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
    
}
