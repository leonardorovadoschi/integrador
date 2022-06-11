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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "MOENTREGA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Moentrega.findAll", query = "SELECT m FROM Moentrega m")
    , @NamedQuery(name = "Moentrega.findByCodmovenda", query = "SELECT m FROM Moentrega m WHERE m.codmovenda = :codmovenda")
    , @NamedQuery(name = "Moentrega.findByDestinatario", query = "SELECT m FROM Moentrega m WHERE m.destinatario = :destinatario")
    , @NamedQuery(name = "Moentrega.findByTelefone", query = "SELECT m FROM Moentrega m WHERE m.telefone = :telefone")
    , @NamedQuery(name = "Moentrega.findByEndereco", query = "SELECT m FROM Moentrega m WHERE m.endereco = :endereco")
    , @NamedQuery(name = "Moentrega.findByBairro", query = "SELECT m FROM Moentrega m WHERE m.bairro = :bairro")
    , @NamedQuery(name = "Moentrega.findByReferencia", query = "SELECT m FROM Moentrega m WHERE m.referencia = :referencia")
    , @NamedQuery(name = "Moentrega.findByCidade", query = "SELECT m FROM Moentrega m WHERE m.cidade = :cidade")
    , @NamedQuery(name = "Moentrega.findByEstado", query = "SELECT m FROM Moentrega m WHERE m.estado = :estado")
    , @NamedQuery(name = "Moentrega.findByDatentr", query = "SELECT m FROM Moentrega m WHERE m.datentr = :datentr")
    , @NamedQuery(name = "Moentrega.findByObs", query = "SELECT m FROM Moentrega m WHERE m.obs = :obs")
    , @NamedQuery(name = "Moentrega.findByStatus", query = "SELECT m FROM Moentrega m WHERE m.status = :status")
    , @NamedQuery(name = "Moentrega.findByHora", query = "SELECT m FROM Moentrega m WHERE m.hora = :hora")
    , @NamedQuery(name = "Moentrega.findByCep", query = "SELECT m FROM Moentrega m WHERE m.cep = :cep")
    , @NamedQuery(name = "Moentrega.findByNumerologradouro", query = "SELECT m FROM Moentrega m WHERE m.numerologradouro = :numerologradouro")
    , @NamedQuery(name = "Moentrega.findByComplementologradouro", query = "SELECT m FROM Moentrega m WHERE m.complementologradouro = :complementologradouro")
    , @NamedQuery(name = "Moentrega.findByNometrans", query = "SELECT m FROM Moentrega m WHERE m.nometrans = :nometrans")
    , @NamedQuery(name = "Moentrega.findByMotivoestorno", query = "SELECT m FROM Moentrega m WHERE m.motivoestorno = :motivoestorno")})
public class Moentrega implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODMOVENDA")
    private String codmovenda;
    @Column(name = "DESTINATARIO")
    private String destinatario;
    @Column(name = "TELEFONE")
    private String telefone;
    @Column(name = "ENDERECO")
    private String endereco;
    @Column(name = "BAIRRO")
    private String bairro;
    @Column(name = "REFERENCIA")
    private String referencia;
    @Column(name = "CIDADE")
    private String cidade;
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "DATENTR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datentr;
    @Column(name = "OBS")
    private String obs;
    @Column(name = "STATUS")
    private Character status;
    @Column(name = "HORA")
    private String hora;
    @Column(name = "CEP")
    private String cep;
    @Column(name = "NUMEROLOGRADOURO")
    private String numerologradouro;
    @Column(name = "COMPLEMENTOLOGRADOURO")
    private String complementologradouro;
    @Column(name = "NOMETRANS")
    private String nometrans;
    @Column(name = "MOTIVOESTORNO")
    private String motivoestorno;
    @JoinColumn(name = "CODMOVENDA", referencedColumnName = "CODMOVENDA", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Movenda movenda;
    @JoinColumn(name = "CODTRANS", referencedColumnName = "CODTRANS")
    @ManyToOne
    private Transportadora codtrans;

    public Moentrega() {
    }

    public Moentrega(String codmovenda) {
        this.codmovenda = codmovenda;
    }

    public String getCodmovenda() {
        return codmovenda;
    }

    public void setCodmovenda(String codmovenda) {
        this.codmovenda = codmovenda;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getDatentr() {
        return datentr;
    }

    public void setDatentr(Date datentr) {
        this.datentr = datentr;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumerologradouro() {
        return numerologradouro;
    }

    public void setNumerologradouro(String numerologradouro) {
        this.numerologradouro = numerologradouro;
    }

    public String getComplementologradouro() {
        return complementologradouro;
    }

    public void setComplementologradouro(String complementologradouro) {
        this.complementologradouro = complementologradouro;
    }

    public String getNometrans() {
        return nometrans;
    }

    public void setNometrans(String nometrans) {
        this.nometrans = nometrans;
    }

    public String getMotivoestorno() {
        return motivoestorno;
    }

    public void setMotivoestorno(String motivoestorno) {
        this.motivoestorno = motivoestorno;
    }

    public Movenda getMovenda() {
        return movenda;
    }

    public void setMovenda(Movenda movenda) {
        this.movenda = movenda;
    }

    public Transportadora getCodtrans() {
        return codtrans;
    }

    public void setCodtrans(Transportadora codtrans) {
        this.codtrans = codtrans;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codmovenda != null ? codmovenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Moentrega)) {
            return false;
        }
        Moentrega other = (Moentrega) object;
        if ((this.codmovenda == null && other.codmovenda != null) || (this.codmovenda != null && !this.codmovenda.equals(other.codmovenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Moentrega[ codmovenda=" + codmovenda + " ]";
    }
    
}
