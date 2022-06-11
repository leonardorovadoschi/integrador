/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "VW_TIPOCOBRANCACONTA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwTipocobrancaconta.findAll", query = "SELECT v FROM VwTipocobrancaconta v")
    , @NamedQuery(name = "VwTipocobrancaconta.findByCodigo", query = "SELECT v FROM VwTipocobrancaconta v WHERE v.codigo = :codigo")
    , @NamedQuery(name = "VwTipocobrancaconta.findByTipocobranca", query = "SELECT v FROM VwTipocobrancaconta v WHERE v.tipocobranca = :tipocobranca")})
public class VwTipocobrancaconta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "TIPOCOBRANCA")
    private String tipocobranca;

    public VwTipocobrancaconta() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipocobranca() {
        return tipocobranca;
    }

    public void setTipocobranca(String tipocobranca) {
        this.tipocobranca = tipocobranca;
    }
    
}
