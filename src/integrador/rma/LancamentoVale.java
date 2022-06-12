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
import entidade.cplus.Usuario;
import entidade.cplus.Vale;
import janela.cplus.FormataCampos;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.swing.JOptionPane;
import jpa.cplus.ValeJpaController;
import query.cplus.QueryCplus;

/**
 *
 * @author leonardo
 */
public class LancamentoVale {
    QueryCplus querySerial;
    public void lancamentoVale(Usuario usuario, Cliente cliente, Movenda saidaCliente, Moventrada entrada, BigDecimal valor, EntityManagerFactory managerCplus, EntityManagerFactory managerIntegrador){
        querySerial = new QueryCplus(managerCplus);
        List<Vale> listVale = querySerial.listagemValePorDevolucao(entrada.getCodmoventr(), cliente.getCodcli());
        if(listVale.isEmpty()){
            criaVale(usuario, cliente, saidaCliente, entrada, valor, managerCplus, managerIntegrador);
        }else if(listVale.size() == 1){
            for(Vale vale : listVale){
            editaVale(vale, usuario, saidaCliente, entrada, valor, managerCplus);
            }
        }
        
    }

    private void criaVale(Usuario usuario, Cliente cliente, Movenda saidaCliente, Moventrada entrada, BigDecimal valor, EntityManagerFactory managerCplus, EntityManagerFactory managerIntegrador) {
        Vale val = new Vale();        
        //Configuracao configuracao = new ConfiguracaoJpaController(managerIntegrador).findConfiguracao("increment_tabela_vale");
       // Integer numVale= Integer.valueOf(configuracao.getValorConfiguracao());
       // numVale--;
       // configuracao.setValorConfiguracao(Integer.toString(numVale));
        //try {
       //     new ConfiguracaoJpaController(managerIntegrador).edit(configuracao);
       //     } catch (Exception ex) {//fim catch da tabela configuração
        //    JOptionPane.showMessageDialog(null, "Houve um erro ao Gravar Configuração de Vale!!!\n " + ex);
       // }
       int numVale = new ConexaoDB().ultimoCodigo("VALE", "NUMVALE");
       int codVale = new ConexaoDB().ultimoCodigo("VALE", "CODVALE");
        val.setNumvale(numVale);
        val.setCodmovenda(saidaCliente.getCodmovenda());
        val.setValor(valor);
        val.setDatvale(new Date(System.currentTimeMillis()));
        val.setObs(entrada.getObs());
        val.setCodcli(cliente);
        val.setCodmoventr(entrada.getCodmoventr());
        val.setCoduser(usuario.getCoduser());
        val.setHoravale(new Date(System.currentTimeMillis()));
        val.setFlagdesconto('N');
        val.setCodvale(String.format("%09d", codVale));
        val.setFlagtipo('D');
        try {
            new ValeJpaController(managerCplus).create(val);
            numVale ++;
            new ConexaoDB().atualizarCodigo("VALE", "NUMVALE", numVale);
            codVale++;
            new ConexaoDB().atualizarCodigo("VALE", "CODVALE", codVale);
            JOptionPane.showMessageDialog(null, "vale Gerado com Sucesso!!!\n Numero vale: " +val.getNumvale()+" Valor: "+ new FormataCampos().bigDecimalParaString(valor, 2));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Houve um erro ao Gravar Vave!!!\n " + ex);
        }        
    }

    private void editaVale(Vale val, Usuario usuario, Movenda saidaCliente, Moventrada entrada, BigDecimal valor,  EntityManagerFactory managerCplus) {       
        val.setCodmovenda(saidaCliente.getCodmovenda());
        val.setValor(val.getValor().add(valor));       
        val.setObs(entrada.getObs());      
        val.setCoduser(usuario.getCoduser());
        val.setHoravale(new Date(System.currentTimeMillis()));
        try {            
            new ValeJpaController(managerCplus).edit(val);
            JOptionPane.showMessageDialog(null, "vale Editado com Sucesso!!!\n Numero vale: " +val.getNumvale()+" Valor: "+val.getValor());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Houve um erro ao Editar Vave!!!\n " + ex);
        }
    }
}
