/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "CHEQUESHISTORICO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chequeshistorico.findAll", query = "SELECT c FROM Chequeshistorico c")
    , @NamedQuery(name = "Chequeshistorico.findByCodchequeshistorico", query = "SELECT c FROM Chequeshistorico c WHERE c.codchequeshistorico = :codchequeshistorico")
    , @NamedQuery(name = "Chequeshistorico.findByOperacao", query = "SELECT c FROM Chequeshistorico c WHERE c.operacao = :operacao")
    , @NamedQuery(name = "Chequeshistorico.findByData", query = "SELECT c FROM Chequeshistorico c WHERE c.data = :data")
    , @NamedQuery(name = "Chequeshistorico.findByCodalinea", query = "SELECT c FROM Chequeshistorico c WHERE c.codalinea = :codalinea")
    , @NamedQuery(name = "Chequeshistorico.findByDatacadastro", query = "SELECT c FROM Chequeshistorico c WHERE c.datacadastro = :datacadastro")
    , @NamedQuery(name = "Chequeshistorico.findByValor", query = "SELECT c FROM Chequeshistorico c WHERE c.valor = :valor")
    , @NamedQuery(name = "Chequeshistorico.findByCoduser", query = "SELECT c FROM Chequeshistorico c WHERE c.coduser = :coduser")})
public class Chequeshistorico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCHEQUESHISTORICO")
    private String codchequeshistorico;
    @Column(name = "OPERACAO")
    private Character operacao;
    @Column(name = "DATA")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "CODALINEA")
    private String codalinea;
    @Column(name = "DATACADASTRO")
    @Temporal(TemporalType.DATE)
    private Date datacadastro;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALOR")
    private BigDecimal valor;
    @Column(name = "CODUSER")
    private String coduser;
    @JoinColumn(name = "CODCHEQUE", referencedColumnName = "CODCHEQUE")
    @ManyToOne(optional = false)
    private Cheques codcheque;
    @JoinColumn(name = "CODVENDEDRENEGOCIACAO", referencedColumnName = "CODVENDED")
    @ManyToOne
    private Vendedor codvendedrenegociacao;

    public Chequeshistorico() {
    }

    public Chequeshistorico(String codchequeshistorico) {
        this.codchequeshistorico = codchequeshistorico;
    }

    public String getCodchequeshistorico() {
        return codchequeshistorico;
    }

    public void setCodchequeshistorico(String codchequeshistorico) {
        this.codchequeshistorico = codchequeshistorico;
    }

    public Character getOperacao() {
        return operacao;
    }

    public void setOperacao(Character operacao) {
        this.operacao = operacao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getCodalinea() {
        return codalinea;
    }

    public void setCodalinea(String codalinea) {
        this.codalinea = codalinea;
    }

    public Date getDatacadastro() {
        return datacadastro;
    }

    public void setDatacadastro(Date datacadastro) {
        this.datacadastro = datacadastro;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getCoduser() {
        return coduser;
    }

    public void setCoduser(String coduser) {
        this.coduser = coduser;
    }

    public Cheques getCodcheque() {
        return codcheque;
    }

    public void setCodcheque(Cheques codcheque) {
        this.codcheque = codcheque;
    }

    public Vendedor getCodvendedrenegociacao() {
        return codvendedrenegociacao;
    }

    public void setCodvendedrenegociacao(Vendedor codvendedrenegociacao) {
        this.codvendedrenegociacao = codvendedrenegociacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codchequeshistorico != null ? codchequeshistorico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chequeshistorico)) {
            return false;
        }
        Chequeshistorico other = (Chequeshistorico) object;
        if ((this.codchequeshistorico == null && other.codchequeshistorico != null) || (this.codchequeshistorico != null && !this.codchequeshistorico.equals(other.codchequeshistorico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Chequeshistorico[ codchequeshistorico=" + codchequeshistorico + " ]";
    }
    
}
