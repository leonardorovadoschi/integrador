/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package janela.integrador;

import entidade.cplus.Cliente;
import entidade.integrador.IntLogs;
import entidade.prestaShop.PsAddress;
import entidade.prestaShop.PsCustomer;
import entidade.prestaShop.PsCustomerGroup;
import entidade.prestaShop.PsCustomerGroupPK;
import entidade.prestaShop.PsState;
import janela.cplus.FormataCampos;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.EntityManagerFactory;
import javax.swing.JOptionPane;
import jpa.integrador.IntLogsJpaController;
import jpa.prestaShop.PsAddressJpaController;
import jpa.prestaShop.PsCustomerGroupJpaController;
import jpa.prestaShop.PsCustomerJpaController;
import jpa.prestaShop.exceptions.NonexistentEntityException;
import prestashop.ConfiguracaoNoBD;
import prestashop.Manager;
import query.cplus.QueryCplus;
import query.integrador.QueryIntegrador;
import query.prestaShop.QueryPrestaShop;

/**
 *
 * @author leo
 */
public class ClienteCplusDigimacro {

    boolean condicaoErro;

    private boolean isCondicaoErro() {
        return condicaoErro;
    }

    private void setCondicaoErro(boolean condicaoErro) {
        this.condicaoErro = condicaoErro;
    }

    /**
     * Função que atualiza cliente no magento na loja DIGIMACRO os parametro e
     * valores devem ser modificados nessa função
     * @param cliente Objeto ClienteIntegrador
     * @return se houver erro vai retornar false
     */
    public boolean atualizaClienteDigimacro(Cliente cliente) {
        setCondicaoErro(true);
        List<PsCustomer> listCustomer = new QueryPrestaShop().listClienteEmail(cliente.getEmail().trim());
        // if (verificaEmailDuplicado(managerPrestaShop, listCustomer, cliente)) {
        if (listCustomer.isEmpty()) {//SE NAO EXISTIR VAI CRIAR
            PsCustomer pc = new PsCustomer();
            pc.setIdShopGroup(1);
            pc.setIdShop(1);
            if (cliente.getSexo() != null) {
                pc.setIdGender(sexo(cliente.getSexo().toString()));
            }
            pc.setIdDefaultGroup(grupoId(cliente));
            pc.setIdLang(2);
            pc.setIdRisk(1);
            if (!"".equals(cliente.getConjfantasia())) {
                pc.setCompany(cliente.getConjfantasia());
            } else {
                pc.setCompany(firstName(cliente.getNomecli()));
            }
            pc.setSiret(cpfCnpj(cliente));
            pc.setFirstname(firstName(cliente.getNomecli()));
            pc.setLastname(lastName(cliente.getNomecli()));
            pc.setEmail(cliente.getEmail().toLowerCase().trim());
            pc.setPasswd("$2y$10$GYuAOlc5IShnSKdeM5r53eawvO/74elEjc9MlrydSPLNk4FgJHflq");//digi2012 é a senha
            pc.setLastPasswdGen(new Date(System.currentTimeMillis()));
            pc.setBirthday(cliente.getDatcad());
            pc.setNewsletter(true);
            pc.setIpRegistrationNewsletter(null);
            pc.setNewsletterDateAdd(new Date(System.currentTimeMillis()));
            pc.setOptin(false);
            pc.setWebsite(cliente.getWeb());
            if (cliente.getLimitecred() != null) {
                pc.setOutstandingAllowAmount(cliente.getLimitecred());
            } else {
                pc.setOutstandingAllowAmount(BigDecimal.ZERO);
            }
            pc.setShowPublicPrices(false);
            pc.setMaxPaymentDays(0);
            pc.setSecureKey("2a4c16f26e944cb993cb31a9e9875bf8");

            pc.setNote(cliente.getObs());

            pc.setActive(ativo(cliente));
            pc.setIsGuest(false);
            pc.setDeleted(false);
            pc.setDateAdd(new Date(System.currentTimeMillis()));
            pc.setDateUpd(new Date(System.currentTimeMillis()));
            pc.setTipo(cliente.getFlagfisica().toString());
            new PsCustomerJpaController(Manager.getManagerPrestaShop()).create(pc);

            criaCustomerGroup(pc);
            criarAdderess( pc, cliente);

        } else if (listCustomer.size() == 1) {//EDITA CASO HAJA UM REGISTRO
            for (PsCustomer pc : listCustomer) {
                boolean condicao = true;
                if (verificaEndereco(cliente, pc) == false) {
                    int cancelar = JOptionPane.showConfirmDialog(null, " O endereço do C-plus está diferente do entereço do Site "
                            + "\n Cliente: " + cliente.getNomecli()
                            + "\n Cpf/Cnpj: " + cpfCnpj(cliente)
                            + "\n ATUALIZAR O ENDEREÇO??? "
                            + "\n Data Atualização Cplus: "
                            + new FormataCampos().dataStringDataCompleta(cliente.getLastChange(), 0) + "\n Data Atualização Site: "
                            + new FormataCampos().dataStringDataCompleta(pc.getDateUpd(), 0), "Atualizar", JOptionPane.YES_NO_CANCEL_OPTION);
                    if (cancelar == JOptionPane.NO_OPTION) {
                        condicao = false;
                    }
                }
                if (condicao) {
                    // pc.setIdShopGroup(1);
                    // pc.setIdShop(1);
                    if (cliente.getSexo() != null) {
                        pc.setIdGender(sexo(cliente.getSexo().toString()));
                    }
                    pc.setIdDefaultGroup(grupoId(cliente));
                    pc.setIdLang(2);
                    pc.setIdRisk(1);
                    if (!"".equals(cliente.getConjfantasia())) {
                        pc.setCompany(cliente.getConjfantasia());
                    } else {
                        pc.setCompany(firstName(cliente.getNomecli()));
                    }
                    pc.setSiret(cpfCnpj(cliente));
                    pc.setFirstname(firstName(cliente.getNomecli()));
                    pc.setLastname(lastName(cliente.getNomecli()));
                    pc.setEmail(cliente.getEmail().toLowerCase().trim());
                    //pc.setPasswd(new IntConfiguracaoJpaController(managerIntegrador).valor("PASSWD_MD5"));
                    //pc.setLastPasswdGen(new Date(System.currentTimeMillis()));
                    //pc.setBirthday(cliente.getDatcad());
                    //pc.setNewsletter(true);
                    // pc.setIpRegistrationNewsletter(null);
                    //pc.setNewsletterDateAdd(new Date(System.currentTimeMillis()));
                    // pc.setOptin(false);
                    pc.setWebsite(cliente.getWeb());
                    if (cliente.getLimitecred() != null) {
                        pc.setOutstandingAllowAmount(cliente.getLimitecred());
                    } else {
                        pc.setOutstandingAllowAmount(BigDecimal.ZERO);
                    }
                    // pc.setShowPublicPrices(false);
                    // pc.setMaxPaymentDays(0);
                    //pc.setSecureKey(new IntConfiguracaoJpaController(managerIntegrador).valor("SECURE_KEY"));
                    // pc.setNote(fC.converter_ISO8859_UTF8(cliente.getObs()));
                    pc.setActive(ativo(cliente));
                    //pc.setIsGuest(false);
                    //pc.setDeleted(false);
                    //pc.setDateAdd(new Date(System.currentTimeMillis()));
                    pc.setDateUpd(new Date(System.currentTimeMillis()));
                    pc.setTipo(cliente.getFlagfisica().toString());

                    try {
                        new PsCustomerJpaController(Manager.getManagerPrestaShop()).edit(pc);
                    } catch (Exception ex) {
                        criaLog(" Erro ao Editar Customer Group: \n " + ex, "ERRO EDITAR");
                    }
                    //Customer Group/////
                    List<PsCustomerGroup> pcgList = new QueryPrestaShop().listCustomerGroup(pc.getIdCustomer());
                    switch (pcgList.size()) {
                        case 0:
                            criaCustomerGroup( pc);
                            break;
                        case 1:
                            editaCustomerGroup(pcgList, pc);
                            break;
                        default:
                            excluiCustomerGroup(pcgList, pc);
                            criaCustomerGroup( pc);
                            break;
                    }
                    ///Endereço//////
                    List<PsAddress> paList = new QueryPrestaShop().listAddress(false, pc.getIdCustomer());
                    if (paList.isEmpty()) {
                        criarAdderess( pc, cliente);
                    } else if (paList.size() == 1) {
                        editarAdderess( paList, pc, cliente);
                    } else if (paList.size() > 1) {
                        JOptionPane.showMessageDialog(null, "O cliente: " + cliente.getNomecli() + " Possui mais que um endereço");
                    }
                }//if endereço diferente                
            }//for
        }
        // } else {//fim if que fverifica duplicidade de e-mail no site
        //     setCondicaoErro(false);
        // }

        return isCondicaoErro();
    }

    /**
     * Funcao que cria CustomerGroup caso nao exista
     *
     * @param managerIntegrador
     * @param managerPrestaShop
     * @param pc
     */
    private void criaCustomerGroup(PsCustomer pc) {
        PsCustomerGroup pcg = new PsCustomerGroup();
        pcg.setPsCustomerGroupPK(new PsCustomerGroupPK(pc.getIdCustomer(), pc.getIdDefaultGroup()));
        try {
            new PsCustomerGroupJpaController(Manager.getManagerPrestaShop()).create(pcg);
        } catch (Exception ex) {
            criaLog(" Erro ao Criar Customer Group: \n " + ex, "ERRO CRIAR");
        }
    }

    /**
     * Funcaoo responsavel por formatar o campo CEP
     *
     * @param cep
     * @return
     */
    private String cepFormatado(String cep) {
        String txt = "";
        if (cep != null) {
            if (cep.length() == 8) {
                txt = cep.substring(0, 5) + "-" + cep.substring(5, cep.length());
            }
        }
        return txt;
    }

    private boolean verificaEndereco(Cliente cliente, PsCustomer customer) {
        boolean condicao = false;
        String ende = cliente.getEndereco();
        //String bairro = cliente.getBairro();
        String numero;
        if (cliente.getNumerologradouro() == null) {
            numero = "";
        } else {
            numero = cliente.getNumerologradouro();
        }
        String complemento;
        if (cliente.getComplementologradouro() == null) {
            complemento = "";
        } else {
            complemento = cliente.getComplementologradouro();
        }
        List<PsAddress> listText = new QueryPrestaShop().listEndereco(false, customer.getIdCustomer(), endereco(ende, numero, complemento));
        if (listText.size() > 0) {
            condicao = true;
        } else {
            //JOptionPane.showMessageDialog(null, "ENDEREÇO DO SITE DIFERENTE DO C-PLUS, Verifique!!! \n Cliente: " + cliente.getNomecli());
        }
        return condicao;
    }

    private int idEstado(Cliente cli, int id_pais) {
        int id = 0;
        List<PsState> listEstado = new QueryPrestaShop().listEstado(id_pais, cli.getEstado());
        for (PsState ps : listEstado) {
            id = ps.getIdState();
        }
        return id;
    }

    /**
     * Função que verifica qual é o grupo de clientes baseado na
     * caracteristica do c-plus
     *
     * @param managerIntegrador
     * @param managerCplus
     * @param cliente
     * @return
     */
    private Integer grupoId(Cliente cliente) {
        Integer valor;
        List<Cliente> listCliCplus = new QueryCplus().listCaracteristicaCliente(ConfiguracaoNoBD.getValorCaracteristicaClienteRuim(), cliente.getCodcli());
        if (listCliCplus.size() == 1) {
            valor = 5; //cliente ruim         
        } else {
            if ("Y".equals(cliente.getFlagusaaliqicmsdiferenciada().toString())) {
                valor = 7; //grupo aliq diferenciada
            } else {
                valor = 4; //grupo juridica normal
            }
        }
        return valor;
    }

    /**
     * Função que verifica se cliente estÃ¡ ativo no c-plus
     *
     * @param cliente
     * @return
     */
    private boolean ativo(Cliente cliente) {
        boolean valor = true;
        if ("Y".equals(String.valueOf(cliente.getFlagnaovender()))) {
            valor = false;
        }
        return valor;
    }

    /**
     * Função que retorna o numero do documento
     *
     * @param clienteCplus
     * @return
     */
    private String rgIe(Cliente clienteCplus) {
        String str;
        if ("N".equals(clienteCplus.getFlagfisica().toString())) {
            str = clienteCplus.getInscr();
        } else {
            str = clienteCplus.getIdentidade();
        }
        if ("".equals(str)) {
            str = "Isento";
        }
        return str;
    }

    /**
     * Função que retorna o genero
     *
     * @param s
     * @return
     */
    private Integer sexo(String s) {
        int num;
        if ("M".equals(s)) {
            num = 1;
        } else {
            num = 2;
        }
        return num;
    }

    /**
     * Função que retorna o numero do documento
     *
     * @param clienteCplus
     * @return
     */
    private String cpfCnpj(Cliente clienteCplus) {
        String str;
        if ("N".equals(clienteCplus.getFlagfisica().toString())) {
            str = clienteCplus.getCnpj();
            //  str = new FormataCampos().mascaraCNPJ(clienteCplus.getCnpj());
        } else {
            //  str = new FormataCampos().mascaraCPF(clienteCplus.getCpf());
            str = clienteCplus.getCpf();
        }
        return str;
    }

    /**
     * Função que descarta a primeira palavra e usa o restante
     *
     * @param name
     * @return
     */
    private String lastName(String name) {
        String[] names = name.split(" ");
        String str = "";
        if (names.length > 1) {
            for (int count = 1; count < names.length; count++) {
                str = str + " " + names[count];
            }
            str = str.trim();
            str = str.replace("#", "");
            str = str.replace("\\*", "");
            str = str.replace("\\[", "");
            str = str.replace("\\]", "");
            str = str.replace("%", "");
            str = str.replace("@", "");
            str = str.replace("\\+", "");
            str = str.replace(")", "");
            str = str.replace("(", "");
            str = str.replace("\\/", "");
            str = str.replace("-", "");
            str = str.replace("\\,", "");
            str = str.replace("\\.", "");
            str = str.replaceAll("[0-9]", "");//remove numeros 
        } else {
            str = "Info";
        }
        return str;
    }

    /**
     * Função que separa a primeira palavra do nome
     *
     * @param name
     * @return
     */
    private String firstName(String name) {
        String str = name.split(" ")[0];
        str = str.trim();
        //str = str.replaceAll("[^a-zZ-Z1-9 ]", "");//somente alfanumericos
        str = str.replace("#", "");
        str = str.replace("\\*", "");
        str = str.replace("\\[", "");
        str = str.replace("\\]", "");
        str = str.replace("%", "");
        str = str.replace("@", "");
        str = str.replace("\\+", "");
        str = str.replace(")", "");
        str = str.replace("(", "");
        str = str.replace("\\/", "");
        str = str.replace("-", "");
        str = str.replace("\\,", "");
        str = str.replace("\\.", "");
        str = str.replaceAll("[0-9]", "");//remove numeros     
        return str;
    }

    private String endereco(String nomeRua, String numeroRua, String complemento) {

        String stringSeparada = nomeRua + " " + numeroRua + " " + complemento;
        return stringSeparada;
    }

    /**
     * FunÃ§Ã£o para gravar Logs no banco do integrador
     *
     * @param managerIntegracao
     * @param mensagem
     * @param tipoLog
     */
    private void criaLog(String mensagem, String tipoLog) {
        IntLogs log = new IntLogs();
        log.setDataExecucao(new Date(System.currentTimeMillis()));
        log.setMensagem(mensagem);
        log.setTipoLog(tipoLog);
        new IntLogsJpaController(Manager.getManagerIntegrador()).create(log);
    }

    private void editaCustomerGroup(List<PsCustomerGroup> pcgList, PsCustomer pc) {
        for (PsCustomerGroup pcg : pcgList) {
            pcg.setPsCustomerGroupPK(new PsCustomerGroupPK(pc.getIdCustomer(), pc.getIdDefaultGroup()));
            try {
                new PsCustomerGroupJpaController(Manager.getManagerPrestaShop()).edit(pcg);
            } catch (Exception ex) {
                criaLog(" Erro ao Editar Customer Group: \n " + ex, "ERRO EDITAR");
            }
        }
    }

    private void excluiCustomerGroup(List<PsCustomerGroup> pcgList, PsCustomer pc) {
        for (PsCustomerGroup pcg : pcgList) {
            try {
                new PsCustomerGroupJpaController(Manager.getManagerPrestaShop()).destroy(new PsCustomerGroupPK(pc.getIdCustomer(), pcg.getPsCustomerGroupPK().getIdGroup()));
            } catch (NonexistentEntityException ex) {
                criaLog( " Erro ao Excluir Customer Group: \n " + ex, "ERRO EXCLUIR");
            }
        }
    }

    private void criarAdderess(PsCustomer pc, Cliente cliente) {
        int id_country = 58; //Brasil no caso
        //= Integer.parseInt(new IntConfiguracaoJpaController(managerIntegrador).valor("COUNTRY_ID"));
        PsAddress pa = new PsAddress();
        pa.setIdCountry(id_country);
        pa.setIdState(idEstado(cliente, id_country));
        pa.setIdCustomer(pc.getIdCustomer());
        pa.setIdManufacturer(0);
        pa.setIdSupplier(0);
        pa.setIdWarehouse(0);
        if (cliente.getContato() == null || "".equals(cliente.getContato())) {
            pa.setAlias("Meu Endereço");
        } else {
            pa.setAlias(tamanhoString(cliente.getContato(), 31));
        }
        if (!"".equals(cliente.getConjfantasia())) {
            pa.setCompany(cliente.getConjfantasia());
        } else {
            pa.setCompany(cliente.getNomecli());
        }
        pa.setLastname(lastName(cliente.getNomecli()));
        pa.setFirstname(firstName(cliente.getNomecli()));
        String ende;
        String bairro = "";
        String numero = "";
        String complemento = "";
        ende = cliente.getEndereco();
        if (cliente.getBairro() != null) {
            bairro = cliente.getBairro();
        }
        if (cliente.getNumerologradouro() != null) {
            numero = cliente.getNumerologradouro();
        }
        if (cliente.getComplementologradouro() != null) {
            complemento = cliente.getComplementologradouro();
        }
        pa.setAddress1(endereco(ende, numero, complemento));
        pa.setAddress2(bairro);
        pa.setPostcode(cepFormatado(cliente.getCep()));
        pa.setCity(cliente.getCidade());
        pa.setPhone(tamanhoString(cliente.getFax(), 31).replaceAll("[^0-9]", "").trim());
        pa.setPhoneMobile(tamanhoString(cliente.getTelefone(), 31).replaceAll("[^0-9]", "").trim());
        pa.setVatNumber(cpfCnpj(cliente));
        pa.setDni(rgIe(cliente));

       // pa.setVatNumber(rgIe(cliente));
        //pa.setDni(cpfCnpj(cliente));

        pa.setDateAdd(new Date(System.currentTimeMillis()));
        pa.setDateUpd(new Date(System.currentTimeMillis()));
        pa.setActive(true);
        pa.setDeleted(false);
        pa.setOther("");

        new PsAddressJpaController(Manager.getManagerPrestaShop()).create(pa);
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

    private void editarAdderess(List<PsAddress> paList, PsCustomer pc, Cliente cliente) {
        int id_country = 58; //Brasil no caso
        //   Integer.parseInt(new IntConfiguracaoJpaController(managerIntegrador).valor("COUNTRY_ID"));
        for (PsAddress pa : paList) {
            pa.setIdCountry(id_country);
            pa.setIdState(idEstado( cliente, id_country));
            pa.setIdCustomer(pc.getIdCustomer());
            //pa.setIdManufacturer(0);
            //pa.setIdSupplier(0);
            // pa.setIdWarehouse(0);
            if (cliente.getContato() == null || "".equals(cliente.getContato())) {
                pa.setAlias("Meu Endereço");
            } else {
                pa.setAlias(tamanhoString(cliente.getContato(), 31));
            }
            if (!"".equals(cliente.getConjfantasia())) {
                pa.setCompany(cliente.getConjfantasia());
            } else {
                pa.setCompany(firstName(cliente.getNomecli()));
            }
            // pa.setCompany(cliente.getConjfantasia());
            pa.setLastname(lastName(cliente.getNomecli()));
            pa.setFirstname(firstName(cliente.getNomecli()));
            String ende;
            String bairro = "";
            String numero = "";
            String complemento = "";
            ende = cliente.getEndereco();
            if (cliente.getBairro() != null) {
                bairro = cliente.getBairro();
            }
            if (cliente.getNumerologradouro() != null) {
                numero = cliente.getNumerologradouro();
            }
            if (cliente.getComplementologradouro() != null) {
                complemento = cliente.getComplementologradouro();
            }
            pa.setAddress1(endereco(ende, numero, complemento));
            pa.setAddress2(bairro);
            pa.setPostcode(cepFormatado(cliente.getCep()));
            pa.setCity(cliente.getCidade());
            pa.setPhone(tamanhoString(cliente.getFax(), 31).replaceAll("[^0-9]", "").trim());
            pa.setPhoneMobile(tamanhoString(cliente.getTelefone(), 31).replaceAll("[^0-9]", "").trim());
            pa.setVatNumber(cpfCnpj(cliente));
             pa.setDni(rgIe(cliente));

            //pa.setVatNumber(rgIe(cliente));
            //pa.setDni(cpfCnpj(cliente));

            pa.setDateUpd(new Date(System.currentTimeMillis()));
            pa.setActive(true);
            pa.setOther("");
            try {
                //pa.setDeleted(false);
                new PsAddressJpaController(Manager.getManagerPrestaShop()).edit(pa);
            } catch (Exception ex) {
                criaLog( " Erro ao Editar Address: \n " + ex, "ERRO EDITAR");
            }
        }
    }

    private void excluirAdderess(List<PsAddress> paList) {
        for (PsAddress pa : paList) {
            try {
                new PsAddressJpaController(Manager.getManagerPrestaShop()).destroy(pa.getIdAddress());
            } catch (NonexistentEntityException ex) {
                criaLog( " Erro ao Excluir Address: \n " + ex, "ERRO EXCLUIR");
            }
        }
    }

}
