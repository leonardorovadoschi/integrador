/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package janela.integrador;

import acesso.ConexaoDB;
import entidade.cplus.Cliente;
import entidade.cplus.Clientecaracteristica;
import entidade.cplus.Usuario;
import entidade.integrador.IntLogs;
import entidade.prestaShop.PsAddress;
import entidade.prestaShop.PsCustomer;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.CaracteristicapessoaJpaController;
import jpa.cplus.ClienteJpaController;
import jpa.cplus.ClientecaracteristicaJpaController;
import jpa.cplus.PlanocontaJpaController;
import jpa.cplus.UsuarioJpaController;
import jpa.cplus.VendedorJpaController;
import jpa.integrador.IntLogsJpaController;
import jpa.prestaShop.PsStateJpaController;
import query.integrador.QueryIntegrador;
import query.prestaShop.QueryPrestaShop;

/**
 *
 * @author leonardo
 */
public class ClienteDigimacroCplus {

    public void criaClienteCplus(EntityManagerFactory managerPrestaShop, EntityManagerFactory managerIntegrador, EntityManagerFactory managerCplus, PsCustomer psCustomer, Usuario usuario) {
        // List<Cliente> listClienteCplus = new ClienteJpaController(managerCplus).resultPorCodigoCliente(customer.getIncrementId());
        // if (listClienteCplus.isEmpty()) {          

       // Integer configCont = Integer.valueOf(new ConexaoDB().ultimoCodigo("CLIENTE", "CODCLI"));
        Cliente cli = new Cliente();
        List<PsAddress> listCustomer = new QueryPrestaShop(managerPrestaShop).listAddress(false, psCustomer.getIdCustomer());
        for (PsAddress psAddress : listCustomer) {
            // String[] address = psAddress.getAddress1().split("\n");
            // String[] address = psAddress.getAddress1().split(" ");
            // if (campo.length > 1) {
            //     bairro = campo[1].toUpperCase();
            // } else {
            //   bairro = "";
            //  }
          //  if (address.length > 3) {
          //  cli.setComplementologradouro(tamanhoString(address[3].toUpperCase(), 50));
          //  }else{
                cli.setComplementologradouro("");
          //  }
           //  if (address.length > 1) {
             //cli.setEndereco(tamanhoString(address[1].toUpperCase(), 55));
             cli.setEndereco(tamanhoString(psAddress.getAddress1(), 55));
           //  }else{
            //     cli.setEndereco("");
           //  }
           //  if (address.length > 2) {
             cli.setNumerologradouro(tamanhoString(psAddress.getAddress1().replaceAll("[^0-9]", ""), 10));
          //   }else{
          //       cli.setNumerologradouro("");
         //    }
            cli.setBairro(tamanhoString(psAddress.getAddress2().toUpperCase(), 30));
            cli.setCep(tamanhoString(psAddress.getPostcode().replaceAll("[^0-9]", ""), 8));
            cli.setCidade(tamanhoString(psAddress.getCity().toUpperCase(), 40));
            cli.setEstado(nomeEstado(managerPrestaShop, psAddress));
            
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
            //cli.setBairro(tamanhoString(nomeBairro(managerPrestaShop, psCustomer).toUpperCase(), 30));
            //cli.setCep(tamanhoString(valorEnderecoVarchar(managerPrestaShop, psCustomer).replaceAll("[^0-9]", ""), 8));
            //cli.setCidade(tamanhoString(valorEnderecoVarchar(managerPrestaShop, psCustomer, var.EavAttribute_ENDERECO_CITY, var).toUpperCase(), 40));
            //  String ieInsc = "";
            //  if (valorEnderecoVarchar(managerPrestaShop, psCustomer, var.EavAttribute_ENDERECO_VAT_ID, var) != null) {
            //      ieInsc = tamanhoString(valorEnderecoVarchar(managerPrestaShop, psCustomer, var.EavAttribute_ENDERECO_VAT_ID, var).replaceAll("[^0-9]", "").trim(), 20);
            //  }
            // if ("Y".equals(tipoFisica(managerPrestaShop, psCustomer, var))) {
            //    cli.setCpf(tamanhoString(valorVarchar(managerPrestaShop, psCustomer, var.EavAttribute_TAXVAT).replaceAll("[^0-9]", ""), 14));
            //     if (!"".equals(ieInsc)) {
            //          cli.setIdentidade(ieInsc);
            //       }
            //        cli.setNomecli(tamanhoString(valorVarchar(managerPrestaShop, psCustomer, var.EavAttribute_FRISTNAME).toUpperCase().trim() + " " + valorVarchar(managerPrestaShop, psCustomer, var.EavAttribute_LASTNAME).toUpperCase().trim(), 50));
            //    } else {
            //        cli.setCnpj(tamanhoString(valorVarchar(managerPrestaShop, psCustomer, var.EavAttribute_TAXVAT).replaceAll("[^0-9]", ""), 18));
            //       if (!"".equals(ieInsc)) {
            //         cli.setInscr(ieInsc);
            //     }
            //  cli.setContato(tamanhoString(valorVarchar(managerPrestaShop, psCustomer, var.EavAttribute_FRISTNAME).toUpperCase(), 40));
            // if (!"".equals(valorEnderecoVarchar(managerPrestaShop, psCustomer, var.EavAttribute_ENDERECO_COMPANY, var))) {
            //      cli.setConjfantasia(tamanhoString(valorEnderecoVarchar(managerPrestaShop, psCustomer, var.EavAttribute_ENDERECO_COMPANY, var).toUpperCase().trim(), 100));
            //      cli.setNomecli(tamanhoString(valorEnderecoVarchar(managerPrestaShop, psCustomer, var.EavAttribute_ENDERECO_COMPANY, var).toUpperCase().trim(), 50));
            //   } else {
            //       cli.setNomecli(tamanhoString(valorVarchar(managerPrestaShop, psCustomer, var.EavAttribute_FRISTNAME).toUpperCase().trim() + " " + valorVarchar(managerPrestaShop, psCustomer, var.EavAttribute_LASTNAME).toUpperCase().trim(), 50));
            //   }
        }
        cli.setNomecli(tamanhoString(psCustomer.getFirstname().toUpperCase().trim() + " " + psCustomer.getLastname().toUpperCase().trim(), 50));

        //cli.setComplementologradouro(tamanhoString(nomeComplemento(managerPrestaShop, psCustomer, var).toUpperCase(), 50));
        cli.setEmail(tamanhoString(psCustomer.getEmail().toLowerCase().trim(), 100));
        //cli.setEndereco(tamanhoString(nomeRua(managerPrestaShop, psCustomer, var), 55));
       // cli.setEstado(nomeEstado(managerPrestaShop, psCustomer, var));
        //cli.setFlagfisica(flagFisica(tipoFisica(managerPrestaShop, psCustomer, var)));       
       // cli.setNumerologradouro(tamanhoString(numeroLogradouro(managerPrestaShop, psCustomer, var), 10));
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
        cli.setCoduser(new UsuarioJpaController(managerCplus).findUsuario(usuario.getCoduser()));
        cli.setFlagrevenda('N');
        cli.setBloqtablet('N');
        cli.setFlagtransfer('N');
        cli.setFlagrevendamaster('N');
        //cli.setIndiedest(tipoContribuinte(managerPrestaShop, psCustomer, var.EavAttribute_TAXVAT));

        cli.setCodpc(new PlanocontaJpaController(managerCplus).findPlanoconta("000000002"));
        cli.setCodvended(new VendedorJpaController(managerCplus).findVendedor("000000004"));
        try {
            new ClienteJpaController(managerCplus).create(cli);
            new ConexaoDB().atualizarCodigo("CLIENTE", "CODIGO", codig ++);
            new ConexaoDB().atualizarCodigo("CLIENTE", "CODCLI", codCl ++);
            //cria caracteristica da loja
            Clientecaracteristica caracteristica = new Clientecaracteristica();
            caracteristica.setCodcaracteristicapessoa(new CaracteristicapessoaJpaController(managerCplus).findCaracteristicapessoa(new QueryIntegrador(managerIntegrador).valorConfiguracao("cliente_CARACTERISTICA_CPLUS_DIGIMACRO")));
            caracteristica.setCodcli(new ClienteJpaController(managerCplus).findCliente(cli.getCodcli()));

            caracteristica.setDatacaracteristica(new Date(System.currentTimeMillis()));
            int codCarac = new ConexaoDB().ultimoCodigo("CLIENTECARACTERISTICA", "CODCLIENTECARACTERISTICA");
            caracteristica.setCodclientecaracteristica(String.format("%09d", codCarac));
            try {
                new ClientecaracteristicaJpaController(managerCplus).create(caracteristica);
                new ConexaoDB().atualizarCodigo("CLIENTECARACTERISTICA", "CODCLIENTECARACTERISTICA", codCarac ++);
                
                criaLog(new Date(System.currentTimeMillis()), "Cliente criado no C-Plus \n" + cli.getNomecli(), "Criação", managerIntegrador);
            } catch (Exception ex) {
                criaLog(new Date(System.currentTimeMillis()), "Houve um erro ao criar Caracteristica Cliente no C-Plus \n" + ex, "Erro Criação", managerIntegrador);
            }

        } catch (Exception ex) {
            criaLog(new Date(System.currentTimeMillis()), "Houve um erro ao criar Cliente no C-Plus \n" + ex, "Erro Criação", managerIntegrador);
        }
    }

    private String nomeEstado(EntityManagerFactory managerMagento, PsAddress psAddress) {
        String regiao = "";       
        regiao = new PsStateJpaController(managerMagento).findPsState(psAddress.getIdState()).getIsoCode();          
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

    private void criaLog(Date dataExecucao, String mensagem, String tipoLog, EntityManagerFactory managerIntegrador) {
        IntLogs log = new IntLogs();
        log.setDataExecucao(dataExecucao);     
        log.setMensagem(mensagem);
        log.setTipoLog(tipoLog);
        new IntLogsJpaController(managerIntegrador).create(log);
    }
}
