/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package integrador.fornecedores;

import java.util.Objects;

/**
 *
 * @author leonardo
 */
public class EntidadeSnd {
    private String partNumber;
    private String segmento;
    private String fabricante;
    private String descricao;
    private String unitarioSP;
    private String acimaSP;
    private String multiploSP;
    private String validadeSP;
    private String unitarioRJ;
    private String acimaRJ;
    private String multiploRJ;
    private String validadeRJ;
    private String unitarioRS;
    private String acimaRS;
    private String multiploRS;
    private String validadeRS;
    private String unitarioES;
    private String acimaES;
    private String multiploES;
    private String validadeES;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.partNumber);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EntidadeSnd other = (EntidadeSnd) obj;
        if (!Objects.equals(this.partNumber, other.partNumber)) {
            return false;
        }
        return true;
    }
    
    

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getSegmento() {
        return segmento;
    }

    public void setSegmento(String segmento) {
        this.segmento = segmento;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUnitarioSP() {
        return unitarioSP;
    }

    public void setUnitarioSP(String unitarioSP) {
        this.unitarioSP = unitarioSP;
    }

    public String getAcimaSP() {
        return acimaSP;
    }

    public void setAcimaSP(String acimaSP) {
        this.acimaSP = acimaSP;
    }

    public String getMultiploSP() {
        return multiploSP;
    }

    public void setMultiploSP(String multiploSP) {
        this.multiploSP = multiploSP;
    }

    public String getValidadeSP() {
        return validadeSP;
    }

    public void setValidadeSP(String validadeSP) {
        this.validadeSP = validadeSP;
    }

    public String getUnitarioRJ() {
        return unitarioRJ;
    }

    public void setUnitarioRJ(String unitarioRJ) {
        this.unitarioRJ = unitarioRJ;
    }

    public String getAcimaRJ() {
        return acimaRJ;
    }

    public void setAcimaRJ(String acimaRJ) {
        this.acimaRJ = acimaRJ;
    }

    public String getMultiploRJ() {
        return multiploRJ;
    }

    public void setMultiploRJ(String multiploRJ) {
        this.multiploRJ = multiploRJ;
    }

    public String getValidadeRJ() {
        return validadeRJ;
    }

    public void setValidadeRJ(String validadeRJ) {
        this.validadeRJ = validadeRJ;
    }

    public String getUnitarioRS() {
        return unitarioRS;
    }

    public void setUnitarioRS(String unitarioRS) {
        this.unitarioRS = unitarioRS;
    }

    public String getAcimaRS() {
        return acimaRS;
    }

    public void setAcimaRS(String acimaRS) {
        this.acimaRS = acimaRS;
    }

    public String getMultiploRS() {
        return multiploRS;
    }

    public void setMultiploRS(String multiploRS) {
        this.multiploRS = multiploRS;
    }

    public String getValidadeRS() {
        return validadeRS;
    }

    public void setValidadeRS(String validadeRS) {
        this.validadeRS = validadeRS;
    }

    public String getUnitarioES() {
        return unitarioES;
    }

    public void setUnitarioES(String unitarioES) {
        this.unitarioES = unitarioES;
    }

    public String getAcimaES() {
        return acimaES;
    }

    public void setAcimaES(String acimaES) {
        this.acimaES = acimaES;
    }

    public String getMultiploES() {
        return multiploES;
    }

    public void setMultiploES(String multiploES) {
        this.multiploES = multiploES;
    }

    public String getValidadeES() {
        return validadeES;
    }

    public void setValidadeES(String validadeES) {
        this.validadeES = validadeES;
    }
    
    
}
