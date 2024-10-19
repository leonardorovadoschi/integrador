/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package integrador.rma;

import acesso.ConexaoDB;
import entidade.cplus.Cliente;
import entidade.cplus.Movenda;
import entidade.cplus.Moventrada;
import entidade.cplus.Moventradaprod;
import entidade.cplus.Vale;
import janela.cplus.FormataCampos;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import jpa.cplus.ValeJpaController;
import prestashop.ConfiguracaoNoBD;
import prestashop.Manager;
import query.cplus.QueryCplus;

/**
 *
 * @author leonardo
 */
public class LancamentoVale {
    QueryCplus querySerial;
    public void lancamentoVale( Cliente cliente, Movenda saidaCliente, Moventrada entrada){
        querySerial = new QueryCplus();
        List<Vale> listVale = querySerial.listagemValePorDevolucao(entrada.getCodmoventr(), cliente.getCodcli());
        if(listVale.isEmpty()){
            criaVale(cliente, saidaCliente, entrada);
        }else if(listVale.size() == 1){
            for(Vale vale : listVale){
            editaVale(vale, saidaCliente, entrada);
            }
        }
        
    }
    
    private BigDecimal valorVale (Moventrada entrada ){
        BigDecimal val = BigDecimal.ZERO;
        for(Moventradaprod prod : new QueryCplus().listagemMovEntradaProdPorEntrada(entrada.getCodmoventr())){
            val = val.add(prod.getValortotal());
        }
        return val;
    }

    private void criaVale(Cliente cliente, Movenda saidaCliente, Moventrada entrada) {
        Vale val = new Vale();               
       int numVale = new ConexaoDB().ultimoCodigo("VALE", "NUMVALE");
       int codVale = new ConexaoDB().ultimoCodigo("VALE", "CODVALE");
        val.setNumvale(numVale);
        val.setCodmovenda(saidaCliente.getCodmovenda());
        val.setValor(valorVale(entrada));
        val.setDatvale(new Date(System.currentTimeMillis()));
        val.setObs(entrada.getObs());
        val.setCodcli(cliente);
        val.setCodmoventr(entrada.getCodmoventr());
        val.setCoduser(ConfiguracaoNoBD.getUsuario().getCoduser());
        val.setHoravale(new Date(System.currentTimeMillis()));
        val.setFlagdesconto('N');
        val.setCodvale(String.format("%09d", codVale));
        val.setFlagtipo('D');
        try {
            new ValeJpaController(Manager.getManagerCplus()).create(val);
            numVale ++;
            new ConexaoDB().atualizarCodigo("VALE", "NUMVALE", numVale);
            codVale++;
            new ConexaoDB().atualizarCodigo("VALE", "CODVALE", codVale);
            JOptionPane.showMessageDialog(null, "vale Gerado com Sucesso!!!\n Numero vale: " +val.getNumvale()+" Valor: "+ new FormataCampos().bigDecimalParaString(val.getValor(), 2));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Houve um erro ao Gravar Vave!!!\n " + ex);
        }        
    }

    private void editaVale(Vale val, Movenda saidaCliente, Moventrada entrada) {       
        val.setCodmovenda(saidaCliente.getCodmovenda());
        val.setValor(valorVale(entrada));       
        val.setObs(entrada.getObs());      
        val.setCoduser(ConfiguracaoNoBD.getUsuario().getCoduser());
        val.setHoravale(new Date(System.currentTimeMillis()));
        try {            
            new ValeJpaController(Manager.getManagerCplus()).edit(val);
            JOptionPane.showMessageDialog(null, "vale Editado com Sucesso!!!\n Numero vale: " +val.getNumvale()+" Valor: "+val.getValor());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Houve um erro ao Editar Vave!!!\n " + ex);
        }
    }
}
