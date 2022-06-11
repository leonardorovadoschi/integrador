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
@Table(name = "VW_MODELONOTA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwModelonota.findAll", query = "SELECT v FROM VwModelonota v")
    , @NamedQuery(name = "VwModelonota.findByCodmod", query = "SELECT v FROM VwModelonota v WHERE v.codmod = :codmod")
    , @NamedQuery(name = "VwModelonota.findByDescricao", query = "SELECT v FROM VwModelonota v WHERE v.descricao = :descricao")
    , @NamedQuery(name = "VwModelonota.findByFlagmodeloreferenciavel", query = "SELECT v FROM VwModelonota v WHERE v.flagmodeloreferenciavel = :flagmodeloreferenciavel")})
public class VwModelonota implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "CODMOD")
    private String codmod;
    @Column(name = "DESCRICAO")
    private String descricao;
    @Column(name = "FLAGMODELOREFERENCIAVEL")
    private String flagmodeloreferenciavel;

    public VwModelonota() {
    }

    public String getCodmod() {
        return codmod;
    }

    public void setCodmod(String codmod) {
        this.codmod = codmod;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFlagmodeloreferenciavel() {
        return flagmodeloreferenciavel;
    }

    public void setFlagmodeloreferenciavel(String flagmodeloreferenciavel) {
        this.flagmodeloreferenciavel = flagmodeloreferenciavel;
    }
    
}
