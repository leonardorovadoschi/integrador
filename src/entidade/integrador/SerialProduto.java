/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade.integrador;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author leonardo
 */
@Entity
@Table(name = "serial_produto")
@XmlRootElement
public class SerialProduto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_serial")
    private Integer idSerial;
    @Column(name = "cod_produto")
    private String codProduto;
    @Column(name = "codigo_produto")
    private String codigoProduto;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "nome_produto")
    private String nomeProduto;
    @Column(name = "serial")
    private String serial;
    @OneToMany(mappedBy = "idSerial")
    private Collection<SaidaSerial> saidaSerialCollection;
    @OneToMany(mappedBy = "idSerial")
    private Collection<EntradaSerial> entradaSerialCollection;

    public SerialProduto() {
    }

    public SerialProduto(Integer idSerial) {
        this.idSerial = idSerial;
    }

    public Integer getIdSerial() {
        return idSerial;
    }

    public void setIdSerial(Integer idSerial) {
        this.idSerial = idSerial;
    }

    public String getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(String codProduto) {
        this.codProduto = codProduto;
    }

    public String getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    @XmlTransient
    public Collection<SaidaSerial> getSaidaSerialCollection() {
        return saidaSerialCollection;
    }

    public void setSaidaSerialCollection(Collection<SaidaSerial> saidaSerialCollection) {
        this.saidaSerialCollection = saidaSerialCollection;
    }

    @XmlTransient
    public Collection<EntradaSerial> getEntradaSerialCollection() {
        return entradaSerialCollection;
    }

    public void setEntradaSerialCollection(Collection<EntradaSerial> entradaSerialCollection) {
        this.entradaSerialCollection = entradaSerialCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSerial != null ? idSerial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SerialProduto)) {
            return false;
        }
        SerialProduto other = (SerialProduto) object;
        if ((this.idSerial == null && other.idSerial != null) || (this.idSerial != null && !this.idSerial.equals(other.idSerial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.integrador.SerialProduto[ idSerial=" + idSerial + " ]";
    }
    
}
