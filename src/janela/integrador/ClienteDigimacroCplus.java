/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package janela.integrador;

import acesso.ConexaoDB;
import entidade.cplus.Cliente;
import entidade.cplus.Clientecaracteristica;
import entidade.integrador.IntLogs;
import entidade.prestaShop.PsAddress;
import entidade.prestaShop.PsCustomer;
import java.util.Date;
import java.util.List;
import jpa.cplus.CaracteristicapessoaJpaController;
import jpa.cplus.ClienteJpaController;
import jpa.cplus.ClientecaracteristicaJpaController;
import jpa.cplus.PlanocontaJpaController;
import jpa.cplus.VendedorJpaController;
import jpa.integrador.IntLogsJpaController;
import jpa.prestaShop.PsStateJpaController;
import prestashop.ConfiguracaoNoBD;
import prestashop.Manager;
import query.prestaShop.QueryPrestaShop;

/**
 *
 * @author leonardo
 */
public class ClienteDigimacroCplus {

    public void criaClienteCplus(PsCustomer psCustomer) {     
        Cliente cli = new Cliente();
        List<PsAddress> listCustomer = new QueryPrestaShop().listAddress(false, psCustomer.getIdCustomer());
        for (PsAddress psAddress : listCustomer) {           
                cli.setComplementologradouro("");        
             cli.setEndereco(tamanhoString(psAddress.getAddress1(), 55));          
             cli.setNumerologradouro(tamanhoString(psAddress.getAddress1().replaceAll("[^0-9]", ""), 10));        
            cli.setBairro(tamanhoString(psAddress.getAddress2().toUpperCase(), 30));
            cli.setCep(tamanhoString(psAddress.getPostcode().replaceAll("[^0-9]", ""), 8));
            cli.setCidade(tamanhoString(psAddress.getCity().toUpperCase(), 40));
            cli.setEstado(nomeEstado(psAddress));
            
            String ieInsc = "";
            if (!"".equals(psAddress.getVatNumber()) || psAddress.getVatNumber() != null) {
                ieInsc = tamanhoString(psAddress.getVatNumber().replaceAll("[^0-9]", "").trim(), 20);
                if ("Y".equals(tipoFisica(psCustomer))) {
                    cli.setCpf(tamanhoString(psCustomer.getSiret().replaceAll("[^0-9]", ""), 14));
                    cli.setFlagfisica('Y');
                     cli.setIndiedest('9');
                    if (!"".equals(ieInsc)) {
                        cli.setIdentidade(ieInsc);
                    }
                    //cli.setNomecli(tamanhoString(psCustomer.getFirstname().toUpperCase().trim() + " " + psCustomer.getLastname().toUpperCase().trim(), 50));
                } else {
                    cli.setCnpj(tamanhoString(psCustomer.getSiret().replaceAll("[^0-9]", ""), 18));
                    cli.setFlagfisica('N');
                     cli.setIndiedest('2');
                    if (!"".equals(psCustomer.getCompany())) {
                        cli.setConjfantasia(tamanhoString(psCustomer.getCompany(), 100));
                    }
                    if (!"".equals(ieInsc)) {
                        cli.setInscr(ieInsc);
                         cli.setIndiedest('1');
                    }
                }
            }
            //cli.setIndiedest(tipoContribuinte(managerPrestaShop, psCustomer, var.EavAttribute_TAXVAT));
            
            cli.setTelefone(tamanhoString( psAddress.getPhoneMobile(), 45));
            cli.setFax(tamanhoString( psAddress.getPhone(), 45));
            cli.setFlagusaaliqicmsdiferenciada(aliquotaDiferenciada(psCustomer));
            
        }
        cli.setNomecli(tamanhoString(psCustomer.getFirstname().toUpperCase().trim() + " " + psCustomer.getLastname().toUpperCase().trim(), 50));
        cli.setEmail(tamanhoString(psCustomer.getEmail().toLowerCase().trim(), 100));
     
       int codCl = new ConexaoDB().ultimoCodigo("CLIENTE", "CODCLI");
        cli.setCodcli(String.format("%08d", codCl));
        int codig = new ConexaoDB().ultimoCodigo("CLIENTE", "CODIGO");
        cli.setCodigo(String.format("%08d", codig));
        cli.setDatcad(new Date(System.currentTimeMillis()));

        cli.setLastChange(new Date(System.currentTimeMillis()));
        if (psCustomer.getBirthday()!= null) {
            cli.setDatnasc(psCustomer.getBirthday());
        }
        cli.setFlagnaovender('N');
        cli.setBloqueado('N');
        cli.setFlaglojavirtual('Y');
        cli.setFlagfrete('P');
        cli.setCoduser(ConfiguracaoNoBD.getUsuario());
        cli.setFlagrevenda('N');
        cli.setBloqtablet('N');
        cli.setFlagtransfer('N');
        cli.setFlagrevendamaster('N');
        //cli.setIndiedest(tipoContribuinte(managerPrestaShop, psCustomer, var.EavAttribute_TAXVAT));

        cli.setCodpc(new PlanocontaJpaController(Manager.getManagerCplus()).findPlanoconta("000000002"));
        cli.setCodvended(new VendedorJpaController(Manager.getManagerCplus()).findVendedor("000000004"));
        try {
            new ClienteJpaController(Manager.getManagerCplus()).create(cli);
            new ConexaoDB().atualizarCodigo("CLIENTE", "CODIGO", codig ++);
            new ConexaoDB().atualizarCodigo("CLIENTE", "CODCLI", codCl ++);
            //cria caracteristica da loja
            Clientecaracteristica caracteristica = new Clientecaracteristica();
            caracteristica.setCodcaracteristicapessoa(new CaracteristicapessoaJpaController(Manager.getManagerCplus()).findCaracteristicapessoa(ConfiguracaoNoBD.getValorCaracteristicaCliente()));
            caracteristica.setCodcli(new ClienteJpaController(Manager.getManagerCplus()).findCliente(cli.getCodcli()));

            caracteristica.setDatacaracteristica(new Date(System.currentTimeMillis()));
            int codCarac = new ConexaoDB().ultimoCodigo("CLIENTECARACTERISTICA", "CODCLIENTECARACTERISTICA");
            caracteristica.setCodclientecaracteristica(String.format("%09d", codCarac));
            try {
                new ClientecaracteristicaJpaController(Manager.getManagerCplus()).create(caracteristica);
                new ConexaoDB().atualizarCodigo("CLIENTECARACTERISTICA", "CODCLIENTECARACTERISTICA", codCarac ++);
                
                criaLog(new Date(System.currentTimeMillis()), "Cliente criado no C-Plus \n" + cli.getNomecli(), "Criação");
            } catch (Exception ex) {
                criaLog(new Date(System.currentTimeMillis()), "Houve um erro ao criar Caracteristica Cliente no C-Plus \n" + ex, "Erro Criação");
            }

        } catch (Exception ex) {
            criaLog(new Date(System.currentTimeMillis()), "Houve um erro ao criar Cliente no C-Plus \n" + ex, "Erro Criação");
        }
    }

    private String nomeEstado(PsAddress psAddress) {
        String regiao = "";       
        regiao = new PsStateJpaController(Manager.getManagerPrestaShop()).findPsState(psAddress.getIdState()).getIsoCode();          
        return regiao;
    }

    private String tipoFisica(PsCustomer customer) {
        String valor = "";
        // cus.setValue(cus.getValue().replaceAll("[^0-9]", ""));
        if (customer.getSiret().replaceAll("[^0-9]", "").length() == 14) {
            valor = "N";
        } else {
            valor = "Y";
        }
        return valor;
    }

    private String tamanhoString(String str, int tamanhoString) {
        String str2 = "";
        if (str != null) {
            for (int cont = 0; cont < str.length(); cont++) {
                if (cont < tamanhoString) {
                    str2 = str2 + str.charAt(cont);
                }
            }
        }
        return str2;
    }

    private Character aliquotaDiferenciada(PsCustomer customer) {
        Character valor;
        //  if (customer.getGroupId() == 1) {
        valor = 'N';
        //   } else /*if(customer.getGroupId() == 2 || customer.getGroupId() == 3)*/ {
        //      valor = 'Y';
        //   }
        return valor;
    }

    private void criaLog(Date dataExecucao, String mensagem, String tipoLog) {
        IntLogs log = new IntLogs();
        log.setDataExecucao(dataExecucao);     
        log.setMensagem(mensagem);
        log.setTipoLog(tipoLog);
        new IntLogsJpaController(Manager.getManagerIntegrador()).create(log);
    }
}
