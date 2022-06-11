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
@Table(name = "MOVIMENTOPDVERRO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movimentopdverro.findAll", query = "SELECT m FROM Movimentopdverro m")
    , @NamedQuery(name = "Movimentopdverro.findByCodmovimentopdverro", query = "SELECT m FROM Movimentopdverro m WHERE m.codmovimentopdverro = :codmovimentopdverro")
    , @NamedQuery(name = "Movimentopdverro.findByCodmovimentopdv", query = "SELECT m FROM Movimentopdverro m WHERE m.codmovimentopdv = :codmovimentopdv")
    , @NamedQuery(name = "Movimentopdverro.findByDataerro", query = "SELECT m FROM Movimentopdverro m WHERE m.dataerro = :dataerro")
    , @NamedQuery(name = "Movimentopdverro.findByPacote", query = "SELECT m FROM Movimentopdverro m WHERE m.pacote = :pacote")})
public class Movimentopdverro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODMOVIMENTOPDVERRO")
    private String codmovimentopdverro;
    @Column(name = "CODMOVIMENTOPDV")
    private String codmovimentopdv;
    @Column(name = "DATAERRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataerro;
    @Lob
    @Column(name = "ERRO")
    private String erro;
    @Column(name = "PACOTE")
    private String pacote;

    public Movimentopdverro() {
    }

    public Movimentopdverro(String codmovimentopdverro) {
        this.codmovimentopdverro = codmovimentopdverro;
    }

    public String getCodmovimentopdverro() {
        return codmovimentopdverro;
    }

    public void setCodmovimentopdverro(String codmovimentopdverro) {
        this.codmovimentopdverro = codmovimentopdverro;
    }

    public String getCodmovimentopdv() {
        return codmovimentopdv;
    }

    public void setCodmovimentopdv(String codmovimentopdv) {
        this.codmovimentopdv = codmovimentopdv;
    }

    public Date getDataerro() {
        return dataerro;
    }

    public void setDataerro(Date dataerro) {
        this.dataerro = dataerro;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }

    public String getPacote() {
        return pacote;
    }

    public void setPacote(String pacote) {
        this.pacote = pacote;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codmovimentopdverro != null ? codmovimentopdverro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movimentopdverro)) {
            return false;
        }
        Movimentopdverro other = (Movimentopdverro) object;
        if ((this.codmovimentopdverro == null && other.codmovimentopdverro != null) || (this.codmovimentopdverro != null && !this.codmovimentopdverro.equals(other.codmovimentopdverro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Movimentopdverro[ codmovimentopdverro=" + codmovimentopdverro + " ]";
    }
    
}
