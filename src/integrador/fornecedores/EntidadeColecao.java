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
public class EntidadeColecao {
    private String referencia;
    private String descricao;
    private String modelo_comercial;
    private String ncm;
    private String ean;
    private String marca;
    //private String caixa_master;
    //private String tipo_giro;
    private String disponivel;
    private String porcentagemIPI;
    private String precoSemIPI;
    private String precoComIPI;
    private String quantidade;
    private String stRs;
    private String precoComSt;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.referencia);
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
        final EntidadeColecao other = (EntidadeColecao) obj;
        if (!Objects.equals(this.referencia, other.referencia)) {
            return false;
        }
        return true;
    }

    public String getStRs() {
        return stRs;
    }

    public void setStRs(String stRs) {
        this.stRs = stRs;
    }

    public String getPrecoComSt() {
        return precoComSt;
    }

    public void setPrecoComSt(String precoComSt) {
        this.precoComSt = precoComSt;
    }
    
    

    public String getModelo_comercial() {
        return modelo_comercial;
    }

    public void setModelo_comercial(String modelo_comercial) {
        this.modelo_comercial = modelo_comercial;
    }

    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        this.ncm = ncm;
    }
     
    

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(String disponivel) {
        this.disponivel = disponivel;
    }

    public String getPorcentagemIPI() {
        return porcentagemIPI;
    }

    public void setPorcentagemIPI(String porcentagemIPI) {
        this.porcentagemIPI = porcentagemIPI;
    }

    public String getPrecoSemIPI() {
        return precoSemIPI;
    }

    public void setPrecoSemIPI(String precoSemIPI) {
        this.precoSemIPI = precoSemIPI;
    }

    public String getPrecoComIPI() {
        return precoComIPI;
    }

    public void setPrecoComIPI(String precoComIPI) {
        this.precoComIPI = precoComIPI;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }
    
    
}
