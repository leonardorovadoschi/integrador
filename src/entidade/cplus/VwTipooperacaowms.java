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
@Table(name = "VW_TIPOOPERACAOWMS", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwTipooperacaowms.findAll", query = "SELECT v FROM VwTipooperacaowms v")
    , @NamedQuery(name = "VwTipooperacaowms.findByTipooperacao", query = "SELECT v FROM VwTipooperacaowms v WHERE v.tipooperacao = :tipooperacao")})
public class VwTipooperacaowms implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "TIPOOPERACAO")
    private String tipooperacao;

    public VwTipooperacaowms() {
    }

    public String getTipooperacao() {
        return tipooperacao;
    }

    public void setTipooperacao(String tipooperacao) {
        this.tipooperacao = tipooperacao;
    }
    
}
