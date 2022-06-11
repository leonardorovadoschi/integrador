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
@Table(name = "VW_CSTICMS", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwCsticms.findAll", query = "SELECT v FROM VwCsticms v")
    , @NamedQuery(name = "VwCsticms.findByCsticms", query = "SELECT v FROM VwCsticms v WHERE v.csticms = :csticms")
    , @NamedQuery(name = "VwCsticms.findByDescricao", query = "SELECT v FROM VwCsticms v WHERE v.descricao = :descricao")})
public class VwCsticms implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "CSTICMS")
    private String csticms;
    @Column(name = "DESCRICAO")
    private String descricao;

    public VwCsticms() {
    }

    public String getCsticms() {
        return csticms;
    }

    public void setCsticms(String csticms) {
        this.csticms = csticms;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
