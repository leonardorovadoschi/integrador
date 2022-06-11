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
@Table(name = "VW_SAT", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwSat.findAll", query = "SELECT v FROM VwSat v")
    , @NamedQuery(name = "VwSat.findByCodsat", query = "SELECT v FROM VwSat v WHERE v.codsat = :codsat")
    , @NamedQuery(name = "VwSat.findByCodigo", query = "SELECT v FROM VwSat v WHERE v.codigo = :codigo")
    , @NamedQuery(name = "VwSat.findByNumeroserie", query = "SELECT v FROM VwSat v WHERE v.numeroserie = :numeroserie")
    , @NamedQuery(name = "VwSat.findByMarca", query = "SELECT v FROM VwSat v WHERE v.marca = :marca")
    , @NamedQuery(name = "VwSat.findByDisplay", query = "SELECT v FROM VwSat v WHERE v.display = :display")})
public class VwSat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "CODSAT")
    private String codsat;
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "NUMEROSERIE")
    private String numeroserie;
    @Column(name = "MARCA")
    private String marca;
    @Column(name = "DISPLAY")
    private String display;

    public VwSat() {
    }

    public String getCodsat() {
        return codsat;
    }

    public void setCodsat(String codsat) {
        this.codsat = codsat;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNumeroserie() {
        return numeroserie;
    }

    public void setNumeroserie(String numeroserie) {
        this.numeroserie = numeroserie;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }
    
}
