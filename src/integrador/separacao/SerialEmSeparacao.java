/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package integrador.separacao;

/**
 *
 * @author leonardo
 */
public class SerialEmSeparacao {
    private String codProduto;
    private String codprodutoSerial;
    private String codMovProduto;
    private String serial;
    private int quanProduto;
    private int quanProdutoSeparado;
    private int idLista;
    private boolean separado;

    public boolean isSeparado() {
        return separado;
    }

    public void setSeparado(boolean separado) {
        this.separado = separado;
    }
    
    public int getIdLista() {
        return idLista;
    }

    public void setIdLista(int idLista) {
        this.idLista = idLista;
    }
   
    public String getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(String codProduto) {
        this.codProduto = codProduto;
    }

    public String getCodprodutoSerial() {
        return codprodutoSerial;
    }

    public void setCodprodutoSerial(String codprodutoSerial) {
        this.codprodutoSerial = codprodutoSerial;
    }

    public String getCodMovProduto() {
        return codMovProduto;
    }

    public void setCodMovProduto(String codMovProduto) {
        this.codMovProduto = codMovProduto;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public int getQuanProduto() {
        return quanProduto;
    }

    public void setQuanProduto(int quanProduto) {
        this.quanProduto = quanProduto;
    }

    public int getQuanProdutoSeparado() {
        return quanProdutoSeparado;
    }

    public void setQuanProdutoSeparado(int quanProdutoSeparado) {
        this.quanProdutoSeparado = quanProdutoSeparado;
    }
    
    
}
