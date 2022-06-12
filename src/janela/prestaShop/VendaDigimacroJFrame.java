/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package janela.prestaShop;

import entidade.cplus.Cliente;
import entidade.cplus.Clientecaracteristica;
import entidade.cplus.Usuario;
import entidade.integrador.IntExecucao;
import entidade.prestaShop.PsAddress;
import entidade.prestaShop.PsCustomPaymentMethod;
import entidade.prestaShop.PsCustomPaymentMethodLang;
import entidade.prestaShop.PsCustomer;
import entidade.prestaShop.PsOrderDetail;
import entidade.prestaShop.PsOrderStateLang;
import entidade.prestaShop.PsOrders;
import integrador.render.RenderCnpjCpf;
import integrador.render.RenderDataEHora;
import integrador.render.RenderPorcentagem;
import integrador.render.RenderPreco;
import integrador.webservice.ClienteWebService;
import integrador.webservice.PrestaShopWebserviceException;
import integrador.webservice.WebCustomer;
import integrador.webservice.WebOrderDetails;
import integrador.webservice.WebOrders;
//import integrador.cliente.MagentoIntegradorCliente;
import janela.cplus.FormataCampos;
import janela.integrador.AtualizaExecucaoIntegrador;
import janela.integrador.ClienteCplusDigimacro;
import janela.integrador.ClienteDigimacroCplus;
import static janela.prestaShop.ListPsProductJDialog.managerIntegrador;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import jpa.integrador.IntExecucaoJpaController;
import jpa.prestaShop.PsCustomerJpaController;
import jpa.prestaShop.PsOrdersJpaController;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import pedido.PedidoDigimacroCplus;
import query.cplus.QueryCplus;
import query.integrador.QueryIntegrador;
import query.prestaShop.QueryPrestaShop;

/**
 *
 * @author leonardo
 */
public class VendaDigimacroJFrame extends javax.swing.JFrame {

    /**
     * Creates new form VendaMagentoJFrame
     *
     * @param managerIntegrador1
     * @param managerPrestaShop1
     * @param managerCplus1
     * @param usuario1
     */
    public VendaDigimacroJFrame(EntityManagerFactory managerIntegrador1, EntityManagerFactory managerPrestaShop1, EntityManagerFactory managerCplus1, Usuario usuario1) {

        //new RenderCnpjCpf();
        //new RenderDataEHora();
        //new RenderCustomerNome();
        formataCampos = new FormataCampos();
        managerPrestaShop = managerPrestaShop1;
        managerIntegrador = managerIntegrador1;
        new RenderPreco();
        new RenderPorcentagem();

        managerCplus = managerCplus1;
        usuario = usuario1;
        queryPrestaShop = new QueryPrestaShop(managerPrestaShop);
        initComponents();
        
        
        
        shopUrl = new QueryIntegrador(managerIntegrador).valorConfiguracao("shopURL");
        key = new QueryIntegrador(managerIntegrador).valorConfiguracao("shopKEY");

        this.ws = new ClienteWebService(shopUrl, key, false);

        codCaracteristicaCliente = new QueryIntegrador(managerIntegrador).valorConfiguracao("cliente_CARACTERISTICA_CPLUS_DIGIMACRO");
        queryCplus = new QueryCplus(managerCplus);
        //acesso = new ControleAcesso(managerCplus);
        this.listagemSaidasMagentoJDialog = new SaidasPrestaShopJDialog(this, true, managerPrestaShop, managerIntegrador);
        //this.editSalesFlatOrderItemJDialog = new EditSalesFlatOrderItemJDialog(this, true, managerPrestaShop, managerCplus, usuario);
        this.listagemProdutoMagentoJDialog = new ListPsProductJDialog(this, true, managerIntegrador, managerPrestaShop, managerCplus, usuario);
        this.insereSalesFlatOrderItemJDialog = new InsereSalesFlatOrderItemJDialog(this, true, managerPrestaShop, managerCplus, usuario);
        // colunaItemId = jTableProdutosPedido.getColumnModel().getColumnIndex("Item Id");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icones/logo.png")));
        jDateChooserDataInicialCustomer.setDate(formataCampos.alteraDiaData(formataCampos.dataAtual(), -2));
        jDateChooserDataFinalCustomer.setDate(formataCampos.alteraDiaData(formataCampos.dataAtual(), 1));
        colunaCustomerId = jTableCustomer.getColumnModel().getColumnIndex("Id Customer");
        jComboBoxPagamento.setModel(new DefaultComboBoxModel());
        for( PsCustomPaymentMethodLang mp : queryPrestaShop.listCustomPagament()){
            ((DefaultComboBoxModel) jComboBoxPagamento.getModel()).addElement(mp.getName()); // Adiciono o Objeto
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        PrestaShopPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("PrestaShopPU").createEntityManager();
        psCustomerQuery = java.beans.Beans.isDesignTime() ? null : PrestaShopPUEntityManager.createQuery("SELECT c FROM PsCustomer c WHERE c.idCustomer = 11").setMaxResults(10);
        psCustomerList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(new java.util.LinkedList(psCustomerQuery.getResultList()));
        psOrderDetailQuery = java.beans.Beans.isDesignTime() ? null : PrestaShopPUEntityManager.createQuery("SELECT c FROM PsOrderDetail c WHERE c.idOrder =1");
        psOrderDetailList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(new java.util.LinkedList(psOrderDetailQuery.getResultList()));
        jTabbedPaneVendasMagento = new javax.swing.JTabbedPane();
        jPanelVendasMagento = new javax.swing.JPanel();
        jPanelPesquisa = new javax.swing.JPanel();
        jButtonPesquisar = new javax.swing.JButton();
        jButtonImportarPedido = new javax.swing.JButton();
        jButtonAtualizaCliente = new javax.swing.JButton();
        jPanelInformacoes = new javax.swing.JPanel();
        jLabelNome = new javax.swing.JLabel();
        jLabelCpfCnpj = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jLabelStaus = new javax.swing.JLabel();
        jLabelRgIe = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jTextFieldCpfCnpj = new javax.swing.JTextField();
        jTextFieldRgIe = new javax.swing.JTextField();
        jTextFieldStatus = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabelValorTotal = new javax.swing.JLabel();
        jLabelDesconto = new javax.swing.JLabel();
        jLabelFrete = new javax.swing.JLabel();
        jLabelTaxa = new javax.swing.JLabel();
        jTextFieldValorTotal = new javax.swing.JTextField();
        jTextFieldDesconto = new javax.swing.JTextField();
        jTextFieldFrete = new javax.swing.JTextField();
        jTextFieldTaxa = new javax.swing.JTextField();
        jButtonAlteraPagamento = new javax.swing.JButton();
        jComboBoxPagamento = new javax.swing.JComboBox<>();
        jButtonInserir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanelClienteDigimacro = new javax.swing.JPanel();
        jPanelControleClienteDigimacro = new javax.swing.JPanel();
        jComboBoxTermoPesquisa = new javax.swing.JComboBox();
        jTextFieldStringPesquisa = new javax.swing.JTextField();
        jButtonPesquisar1 = new javax.swing.JButton();
        jButtonImportarCliente = new javax.swing.JButton();
        jCheckBoxNaoIntegrado = new javax.swing.JCheckBox();
        jDateChooserDataInicialCustomer = new com.toedter.calendar.JDateChooser();
        jLabelDataInicialCustomer = new javax.swing.JLabel();
        jLabelDataFinalCustomer = new javax.swing.JLabel();
        jDateChooserDataFinalCustomer = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCustomer = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Venda no Site");

        jPanelPesquisa.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisa:"));

        jButtonPesquisar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/pesquisar.png"))); // NOI18N
        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        jButtonImportarPedido.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonImportarPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/daow.png"))); // NOI18N
        jButtonImportarPedido.setText("Importar Pedido");
        jButtonImportarPedido.setEnabled(false);
        jButtonImportarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImportarPedidoActionPerformed(evt);
            }
        });

        jButtonAtualizaCliente.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonAtualizaCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/atualizar.png"))); // NOI18N
        jButtonAtualizaCliente.setText("Atualizar Cliente");
        jButtonAtualizaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtualizaClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelPesquisaLayout = new javax.swing.GroupLayout(jPanelPesquisa);
        jPanelPesquisa.setLayout(jPanelPesquisaLayout);
        jPanelPesquisaLayout.setHorizontalGroup(
            jPanelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButtonImportarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                .addComponent(jButtonAtualizaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelPesquisaLayout.setVerticalGroup(
            jPanelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButtonPesquisar)
                .addComponent(jButtonImportarPedido)
                .addComponent(jButtonAtualizaCliente))
        );

        jPanelInformacoes.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações"));

        jLabelNome.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelNome.setText("Nome:");

        jLabelCpfCnpj.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelCpfCnpj.setText("CPF/CNPJ:");

        jLabelEmail.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelEmail.setText("E-mail:");

        jLabelStaus.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelStaus.setText("Status:");

        jLabelRgIe.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelRgIe.setText("RG/IE:");

        jLabelValorTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelValorTotal.setText("Valor Total:");

        jLabelDesconto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelDesconto.setText("Desconto:");

        jLabelFrete.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelFrete.setText("Frete:");

        jLabelTaxa.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTaxa.setText("Taxa:");

        jButtonAlteraPagamento.setText("Alterar Meio de Pagamento");
        jButtonAlteraPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlteraPagamentoActionPerformed(evt);
            }
        });

        jComboBoxPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Prazo (Boleto)", "À vista", "Cupom", "" }));
        jComboBoxPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPagamentoActionPerformed(evt);
            }
        });

        jButtonInserir.setText("Inserir");
        jButtonInserir.setEnabled(false);
        jButtonInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInserirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelInformacoesLayout = new javax.swing.GroupLayout(jPanelInformacoes);
        jPanelInformacoes.setLayout(jPanelInformacoesLayout);
        jPanelInformacoesLayout.setHorizontalGroup(
            jPanelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInformacoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelCpfCnpj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelRgIe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelStaus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldNome)
                    .addComponent(jTextFieldCpfCnpj)
                    .addComponent(jTextFieldRgIe)
                    .addComponent(jTextFieldStatus)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelValorTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelDesconto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelFrete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelTaxa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldValorTotal)
                    .addComponent(jTextFieldDesconto)
                    .addComponent(jTextFieldFrete)
                    .addComponent(jTextFieldTaxa, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonAlteraPagamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxPagamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelInformacoesLayout.createSequentialGroup()
                        .addComponent(jButtonInserir)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelInformacoesLayout.setVerticalGroup(
            jPanelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInformacoesLayout.createSequentialGroup()
                .addGroup(jPanelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNome)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelValorTotal)
                    .addComponent(jTextFieldValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCpfCnpj)
                    .addComponent(jTextFieldCpfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDesconto)
                    .addComponent(jTextFieldDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAlteraPagamento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelRgIe)
                    .addComponent(jTextFieldRgIe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelFrete)
                    .addComponent(jTextFieldFrete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonInserir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelStaus)
                    .addComponent(jTextFieldStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTaxa)
                    .addComponent(jTextFieldTaxa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEmail)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, psOrderDetailList, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${productEan13}"));
        columnBinding.setColumnName("Product Ean13");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${productQuantity}"));
        columnBinding.setColumnName("Quant");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${productName}"));
        columnBinding.setColumnName("Produto Nome");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${productQuantityDiscount}"));
        columnBinding.setColumnName("Prod Qnt Desc");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${unitPriceTaxIncl}"));
        columnBinding.setColumnName("Unit Price Tax Incl");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${totalPriceTaxIncl}"));
        columnBinding.setColumnName("Total Price Tax Incl");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idOrder}"));
        columnBinding.setColumnName("Id Order");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idOrderInvoice}"));
        columnBinding.setColumnName("Id Order Invoice");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idOrderDetail}"));
        columnBinding.setColumnName("Id Order Detail");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${groupReduction}"));
        columnBinding.setColumnName("Group Reduction");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${originalProductPrice}"));
        columnBinding.setColumnName("Original Product Price");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${productWeight}"));
        columnBinding.setColumnName("Peso");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${productId}"));
        columnBinding.setColumnName("Product Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${productReference}"));
        columnBinding.setColumnName("Product Reference");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(120);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(120);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(300);
            jTable1.getColumnModel().getColumn(2).setMinWidth(350);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(350);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(500);
            jTable1.getColumnModel().getColumn(3).setMinWidth(80);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(3).setCellRenderer(new RenderPreco());
            jTable1.getColumnModel().getColumn(4).setCellRenderer(new RenderPreco());
            jTable1.getColumnModel().getColumn(5).setCellRenderer(new RenderPreco());
            jTable1.getColumnModel().getColumn(9).setCellRenderer(new RenderPorcentagem());
            jTable1.getColumnModel().getColumn(10).setMinWidth(100);
            jTable1.getColumnModel().getColumn(10).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(10).setMaxWidth(200);
            jTable1.getColumnModel().getColumn(13).setMinWidth(100);
            jTable1.getColumnModel().getColumn(13).setPreferredWidth(100);
        }

        javax.swing.GroupLayout jPanelVendasMagentoLayout = new javax.swing.GroupLayout(jPanelVendasMagento);
        jPanelVendasMagento.setLayout(jPanelVendasMagentoLayout);
        jPanelVendasMagentoLayout.setHorizontalGroup(
            jPanelVendasMagentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVendasMagentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelVendasMagentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelVendasMagentoLayout.createSequentialGroup()
                        .addGroup(jPanelVendasMagentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanelPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelInformacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 234, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanelVendasMagentoLayout.setVerticalGroup(
            jPanelVendasMagentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelVendasMagentoLayout.createSequentialGroup()
                .addComponent(jPanelPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelInformacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPaneVendasMagento.addTab("Vendas Site", jPanelVendasMagento);

        jComboBoxTermoPesquisa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Data Cadastro", "E-mail Principal", "Item 3", "Item 4" }));
        jComboBoxTermoPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTermoPesquisaActionPerformed(evt);
            }
        });

        jButtonPesquisar1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonPesquisar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/pesquisar.png"))); // NOI18N
        jButtonPesquisar1.setText("Pesquizar");
        jButtonPesquisar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisar1ActionPerformed(evt);
            }
        });

        jButtonImportarCliente.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonImportarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/daow.png"))); // NOI18N
        jButtonImportarCliente.setText("Importar Cliente");
        jButtonImportarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImportarClienteActionPerformed(evt);
            }
        });

        jCheckBoxNaoIntegrado.setSelected(true);
        jCheckBoxNaoIntegrado.setText("Cliente não Integrado");

        jLabelDataInicialCustomer.setText("Data Inicial:");

        jLabelDataFinalCustomer.setText("Data Final:");

        javax.swing.GroupLayout jPanelControleClienteDigimacroLayout = new javax.swing.GroupLayout(jPanelControleClienteDigimacro);
        jPanelControleClienteDigimacro.setLayout(jPanelControleClienteDigimacroLayout);
        jPanelControleClienteDigimacroLayout.setHorizontalGroup(
            jPanelControleClienteDigimacroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelControleClienteDigimacroLayout.createSequentialGroup()
                .addGroup(jPanelControleClienteDigimacroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jCheckBoxNaoIntegrado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                    .addComponent(jComboBoxTermoPesquisa, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelControleClienteDigimacroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelControleClienteDigimacroLayout.createSequentialGroup()
                        .addComponent(jTextFieldStringPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonPesquisar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonImportarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelControleClienteDigimacroLayout.createSequentialGroup()
                        .addComponent(jLabelDataInicialCustomer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooserDataInicialCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelDataFinalCustomer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDateChooserDataFinalCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(230, 230, 230))
        );
        jPanelControleClienteDigimacroLayout.setVerticalGroup(
            jPanelControleClienteDigimacroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelControleClienteDigimacroLayout.createSequentialGroup()
                .addGroup(jPanelControleClienteDigimacroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxTermoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldStringPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisar1)
                    .addComponent(jButtonImportarCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 5, Short.MAX_VALUE)
                .addGroup(jPanelControleClienteDigimacroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelControleClienteDigimacroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCheckBoxNaoIntegrado)
                        .addComponent(jLabelDataInicialCustomer))
                    .addGroup(jPanelControleClienteDigimacroLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanelControleClienteDigimacroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDateChooserDataInicialCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelControleClienteDigimacroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jDateChooserDataFinalCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelDataFinalCustomer))))))
        );

        jTableCustomer.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTableCustomer.setColumnSelectionAllowed(true);

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, psCustomerList, jTableCustomer);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${firstname}"));
        columnBinding.setColumnName("Firstname");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${lastname}"));
        columnBinding.setColumnName("Lastname");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${email}"));
        columnBinding.setColumnName("Email");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${company}"));
        columnBinding.setColumnName("Company");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${siret}"));
        columnBinding.setColumnName("Siret");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${dateUpd}"));
        columnBinding.setColumnName("Date Atualização");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${dateAdd}"));
        columnBinding.setColumnName("Date Cadastro");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${active}"));
        columnBinding.setColumnName("Active");
        columnBinding.setColumnClass(Boolean.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${note}"));
        columnBinding.setColumnName("Note");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${outstandingAllowAmount}"));
        columnBinding.setColumnName("Outstanding Allow Amount");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${website}"));
        columnBinding.setColumnName("Website");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${newsletterDateAdd}"));
        columnBinding.setColumnName("Newsletter Date Add");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${ipRegistrationNewsletter}"));
        columnBinding.setColumnName("Ip Registration Newsletter");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${newsletter}"));
        columnBinding.setColumnName("Newsletter");
        columnBinding.setColumnClass(Boolean.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${birthday}"));
        columnBinding.setColumnName("Birthday");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${ape}"));
        columnBinding.setColumnName("Ape");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idRisk}"));
        columnBinding.setColumnName("Id Risk");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idDefaultGroup}"));
        columnBinding.setColumnName("Id Default Group");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idGender}"));
        columnBinding.setColumnName("Id Gender");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idShopGroup}"));
        columnBinding.setColumnName("Id Shop Group");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idCustomer}"));
        columnBinding.setColumnName("Id Customer");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(jTableCustomer);
        jTableCustomer.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTableCustomer.getColumnModel().getColumnCount() > 0) {
            jTableCustomer.getColumnModel().getColumn(0).setMinWidth(100);
            jTableCustomer.getColumnModel().getColumn(0).setPreferredWidth(150);
            jTableCustomer.getColumnModel().getColumn(0).setMaxWidth(500);
            jTableCustomer.getColumnModel().getColumn(1).setMinWidth(200);
            jTableCustomer.getColumnModel().getColumn(1).setPreferredWidth(250);
            jTableCustomer.getColumnModel().getColumn(1).setMaxWidth(500);
            jTableCustomer.getColumnModel().getColumn(2).setMinWidth(250);
            jTableCustomer.getColumnModel().getColumn(2).setPreferredWidth(400);
            jTableCustomer.getColumnModel().getColumn(2).setMaxWidth(800);
            jTableCustomer.getColumnModel().getColumn(3).setMinWidth(300);
            jTableCustomer.getColumnModel().getColumn(3).setPreferredWidth(400);
            jTableCustomer.getColumnModel().getColumn(3).setMaxWidth(800);
            jTableCustomer.getColumnModel().getColumn(4).setMinWidth(120);
            jTableCustomer.getColumnModel().getColumn(4).setPreferredWidth(200);
            jTableCustomer.getColumnModel().getColumn(4).setMaxWidth(500);
            jTableCustomer.getColumnModel().getColumn(4).setCellRenderer(new RenderCnpjCpf());
            jTableCustomer.getColumnModel().getColumn(5).setMinWidth(150);
            jTableCustomer.getColumnModel().getColumn(5).setPreferredWidth(200);
            jTableCustomer.getColumnModel().getColumn(5).setMaxWidth(500);
            jTableCustomer.getColumnModel().getColumn(5).setCellRenderer(new RenderDataEHora());
            jTableCustomer.getColumnModel().getColumn(6).setMinWidth(150);
            jTableCustomer.getColumnModel().getColumn(6).setPreferredWidth(200);
            jTableCustomer.getColumnModel().getColumn(6).setMaxWidth(500);
            jTableCustomer.getColumnModel().getColumn(6).setCellRenderer(new RenderDataEHora());
            jTableCustomer.getColumnModel().getColumn(8).setMinWidth(50);
            jTableCustomer.getColumnModel().getColumn(8).setPreferredWidth(100);
            jTableCustomer.getColumnModel().getColumn(8).setMaxWidth(200);
            jTableCustomer.getColumnModel().getColumn(9).setMinWidth(50);
            jTableCustomer.getColumnModel().getColumn(9).setPreferredWidth(100);
            jTableCustomer.getColumnModel().getColumn(9).setMaxWidth(200);
            jTableCustomer.getColumnModel().getColumn(10).setMinWidth(100);
            jTableCustomer.getColumnModel().getColumn(10).setPreferredWidth(150);
            jTableCustomer.getColumnModel().getColumn(10).setMaxWidth(500);
            jTableCustomer.getColumnModel().getColumn(11).setMinWidth(100);
            jTableCustomer.getColumnModel().getColumn(11).setPreferredWidth(150);
            jTableCustomer.getColumnModel().getColumn(11).setMaxWidth(500);
            jTableCustomer.getColumnModel().getColumn(12).setMinWidth(50);
            jTableCustomer.getColumnModel().getColumn(12).setPreferredWidth(150);
            jTableCustomer.getColumnModel().getColumn(12).setMaxWidth(300);
            jTableCustomer.getColumnModel().getColumn(13).setMinWidth(50);
            jTableCustomer.getColumnModel().getColumn(13).setPreferredWidth(50);
            jTableCustomer.getColumnModel().getColumn(13).setMaxWidth(100);
            jTableCustomer.getColumnModel().getColumn(14).setMinWidth(100);
            jTableCustomer.getColumnModel().getColumn(14).setPreferredWidth(150);
            jTableCustomer.getColumnModel().getColumn(14).setMaxWidth(200);
            jTableCustomer.getColumnModel().getColumn(16).setPreferredWidth(50);
            jTableCustomer.getColumnModel().getColumn(17).setMinWidth(50);
            jTableCustomer.getColumnModel().getColumn(17).setPreferredWidth(50);
            jTableCustomer.getColumnModel().getColumn(17).setMaxWidth(100);
            jTableCustomer.getColumnModel().getColumn(18).setMinWidth(50);
            jTableCustomer.getColumnModel().getColumn(18).setPreferredWidth(50);
            jTableCustomer.getColumnModel().getColumn(18).setMaxWidth(100);
            jTableCustomer.getColumnModel().getColumn(19).setMinWidth(50);
            jTableCustomer.getColumnModel().getColumn(19).setPreferredWidth(50);
            jTableCustomer.getColumnModel().getColumn(19).setMaxWidth(100);
            jTableCustomer.getColumnModel().getColumn(20).setMinWidth(50);
            jTableCustomer.getColumnModel().getColumn(20).setPreferredWidth(50);
            jTableCustomer.getColumnModel().getColumn(20).setMaxWidth(100);
        }

        javax.swing.GroupLayout jPanelClienteDigimacroLayout = new javax.swing.GroupLayout(jPanelClienteDigimacro);
        jPanelClienteDigimacro.setLayout(jPanelClienteDigimacroLayout);
        jPanelClienteDigimacroLayout.setHorizontalGroup(
            jPanelClienteDigimacroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelClienteDigimacroLayout.createSequentialGroup()
                .addGroup(jPanelClienteDigimacroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelControleClienteDigimacro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanelClienteDigimacroLayout.setVerticalGroup(
            jPanelClienteDigimacroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelClienteDigimacroLayout.createSequentialGroup()
                .addComponent(jPanelControleClienteDigimacro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE))
        );

        jTabbedPaneVendasMagento.addTab("Cliente Site", jPanelClienteDigimacro);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneVendasMagento, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneVendasMagento, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        limpaCampos();
        this.listagemSaidasMagentoJDialog.pesquisas();
        this.listagemSaidasMagentoJDialog.setVisible(true);
        if (this.listagemSaidasMagentoJDialog.isCancelamento() == false) {
            psOrders = this.listagemSaidasMagentoJDialog.getSalesFlatOrder();
        }
        if (psOrders != null) {
            carregaCampos();
            jButtonImportarPedido.setEnabled(true);
        }
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jButtonImportarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImportarPedidoActionPerformed
        psOrders = new PsOrdersJpaController(managerPrestaShop).findPsOrders(psOrders.getIdOrder());
        new PedidoDigimacroCplus().criaPedidoCplus(managerIntegrador, managerCplus, psOrders, managerPrestaShop);
        jButtonImportarPedido.setEnabled(false);
        limpaCampos();

    }//GEN-LAST:event_jButtonImportarPedidoActionPerformed

    private void jButtonPesquisar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisar1ActionPerformed
        switch (jComboBoxTermoPesquisa.getSelectedIndex()) {
            case 0:
                pesquisaDataCustomer();
                break;
            case 1:
                pesquisaPorEmail();
                break;
            case 2:

                break;
        }
    }//GEN-LAST:event_jButtonPesquisar1ActionPerformed

    private void jButtonImportarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImportarClienteActionPerformed
        if (jTableCustomer.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "voce deve selecionar uma linha na tabela antes de importar!!!");
        } else {
            importarClienteMagentoParaCplus();
        }
    }//GEN-LAST:event_jButtonImportarClienteActionPerformed

    private void jButtonAtualizaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtualizaClienteActionPerformed
        if (psOrders != null) {
            for (Cliente cliente : queryCplus.listClientCpfCnpj(new PsCustomerJpaController(managerPrestaShop).findPsCustomer(psOrders.getIdCustomer()).getSiret())) {
                new ClienteCplusDigimacro().atualizaClienteDigimacro(managerCplus, managerIntegrador, cliente, managerPrestaShop);
            }
        }
        integrarCliente();
    }//GEN-LAST:event_jButtonAtualizaClienteActionPerformed

    private void jButtonAlteraPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlteraPagamentoActionPerformed
        try {

            if (jComboBoxPagamento.getSelectedIndex() == 0) {
                psOrders.setModule("ps_checkpayment");
                psOrders.setPayment("Pagamentos em cheque (boleto)");
            }
            if (jComboBoxPagamento.getSelectedIndex() == 1) {
                psOrders.setModule("ps_wirepayment");
                psOrders.setPayment("Pagamento por transferência bancária");
            }
            if (jComboBoxPagamento.getSelectedIndex() == 2) {
                psOrders.setModule("custompaymentmethod_1");
                psOrders.setPayment("Pagamento na Entrega (Cupom)");
            }
            new PsOrdersJpaController(managerPrestaShop).edit(psOrders);
            if ("ps_checkpayment".equals(psOrders.getModule())) {
                jComboBoxPagamento.setSelectedIndex(0);
            }
            if ("ps_wirepayment".equals(psOrders.getModule())) {
                jComboBoxPagamento.setSelectedIndex(1);
            }
            if ("custompaymentmethod_1".equals(psOrders.getModule())) {
                jComboBoxPagamento.setSelectedIndex(2);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Houve um erro ao trocar meio de pagamento\n VERIFIQUE!!! \n" + ex);
        }
        limpaCampos();
        carregaCampos();

    }//GEN-LAST:event_jButtonAlteraPagamentoActionPerformed

    private void jButtonInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInserirActionPerformed
        this.listagemProdutoMagentoJDialog.setVisible(true);
        if (this.listagemProdutoMagentoJDialog.isCancelamento() == false) {
            boolean jaExiste = false;
            for (PsOrderDetail item : queryPrestaShop.listPsOrderDetail(psOrders.getIdOrder())) {
                if (Objects.equals(item.getProductId(), this.listagemProdutoMagentoJDialog.getProductEntity().getIdProduct())) {
                    jaExiste = true;
                }
            }
            if (jaExiste) {
                JOptionPane.showMessageDialog(null, "O produto já está no pedido verifique!!! ");
            } else {
                this.insereSalesFlatOrderItemJDialog.setProduct(this.listagemProdutoMagentoJDialog.getProductEntity(), psOrders);
                this.insereSalesFlatOrderItemJDialog.setVisible(true);
                // carregaCamposSalesFlatOrder();
            }
        }
    }//GEN-LAST:event_jButtonInserirActionPerformed

    private void jComboBoxPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPagamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxPagamentoActionPerformed

    private void jComboBoxTermoPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTermoPesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxTermoPesquisaActionPerformed

    private void importarClienteMagentoParaCplus() {
        Integer idCustomer = Integer.valueOf(jTableCustomer.getValueAt(jTableCustomer.getSelectedRow(), colunaCustomerId).toString());
        List<PsCustomer> listClienteMagento = queryPrestaShop.listCustomer(idCustomer);
        if (listClienteMagento.size() == 1) {
            for (PsCustomer psCustomer : listClienteMagento) {
                if (documentoValido(psCustomer.getSiret())) {
                    List<Cliente> listemailCplus = queryCplus.resultPortCnpjOuCpf(cpfCnpj(psCustomer.getSiret()));
                    //new QueryIntegrador(managerIntegrador).valorConfiguracao("cliente_CARACTERISTICA_CPLUS_DIGIMACRO"), cliMagento.getEmail());
                    if (listemailCplus.isEmpty()) {
                        new ClienteDigimacroCplus().criaClienteCplus(managerPrestaShop, managerIntegrador, managerCplus, psCustomer, usuario);

                    } else {
                        JOptionPane.showMessageDialog(null, "Esse cadastro possui um CPF ou CNPJ cadastrado no C-Plus\nVERIFIQUE!!!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "O cliente não possui numero documento válido\n VERIFIQUE!!!");
                }
            }
        }
    }

    private String cpfCnpj(String documento) {
        return documento.replaceAll("[^0-9]", "");
    }

    private boolean documentoValido(String documento) {
        boolean condicao = false;
        if (documento.replaceAll("[^0-9]", "").length() == 14) {
            condicao = true;
        } else if (documento.replaceAll("[^0-9]", "").length() == 11) {
            condicao = true;
        }
        return condicao;
    }

    private void pesquisaPorEmail() {
        psCustomerList.clear();
        for (PsCustomer cliMagento : queryPrestaShop.listClienteEmail(jTextFieldStringPesquisa.getText())) {
            psCustomerList.add(cliMagento);
        }
    }

    private void pesquisaDataCustomer() {
        psCustomerList.clear();
        for (PsCustomer psCustomer : queryPrestaShop.listCustomerData(jDateChooserDataInicialCustomer.getDate(), jDateChooserDataFinalCustomer.getDate())) {
            if (jCheckBoxNaoIntegrado.isSelected()) {
                List<Cliente> listemailCplus = queryCplus.resultPortCnpjOuCpf(cpfCnpj(psCustomer.getSiret()));
                if (listemailCplus.isEmpty()) {
                    psCustomerList.add(psCustomer);
                }
            } else {
                psCustomerList.add(psCustomer);
            }
        }
    }

    private void integrarCliente() {
        IntExecucao exeProduto = new IntExecucaoJpaController(managerIntegrador).findIntExecucao("cliente_integrador");
        if (exeProduto.getCondicao() == 1) {
            new AtualizaExecucaoIntegrador().atualizaExecucaoIntegradorCondicao(exeProduto, 0, managerIntegrador);
            boolean condicaoErro = true;
            Calendar inicioExecucao = Calendar.getInstance();
            inicioExecucao.setTime(exeProduto.getUltimaExecucao());
            inicioExecucao.add(Calendar.MINUTE, -10);
            Date dataAtual = new Date(System.currentTimeMillis());
            Calendar fimExecucao = Calendar.getInstance();
            fimExecucao.setTime(dataAtual);
            List<Cliente> listClienteCplusDigi = queryCplus.listClienteData(inicioExecucao);

            for (Cliente cliCplus : listClienteCplusDigi) {
                List<Clientecaracteristica> lisCar = queryCplus.listClienteCaracteristica(codCaracteristicaCliente, cliCplus.getCodcli());
                if (lisCar.size() == 1) {
                    new ClienteCplusDigimacro().atualizaClienteDigimacro(managerCplus, managerIntegrador, cliCplus, managerPrestaShop);
                }
            }
            if (condicaoErro == true) {
                fimExecucao.add(Calendar.MINUTE, -1);
                new AtualizaExecucaoIntegrador().atualizaExecucaoIntegradorData(exeProduto, fimExecucao.getTime(), managerIntegrador);
            }
            new AtualizaExecucaoIntegrador().atualizaExecucaoIntegradorCondicao(exeProduto, 1, managerIntegrador);
            // jProgressBarIntegrador.setString("");
            //  jProgressBarIntegrador.setMinimum(0);
        }//if que verifica se estÃ¡ em execuÃ§Ã£o
    }

    private void carregaCampos() {
        //PsCustomer psCustomer = new PsCustomerJpaController(managerPrestaShop).findPsCustomer(psOrders.getIdCustomer());
        PsCustomer psCustomer = null;
        Document document;
        try {
            HashMap<String, Object> getSchemaOpt = new HashMap();
            getSchemaOpt.put("url", shopUrl + "/api/customers/" + psOrders.getIdCustomer());
            document = ws.getFuncao(getSchemaOpt);
            psCustomer = new WebCustomer().xmlParaEntidade(document, ws);
        } catch (PrestaShopWebserviceException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar Web Service: \n" + ex);
        }

        //PsAddress psAddress = new PsAddressJpaController(managerPrestaShop).findPsAddress(psCustomer.get)
        //jTextFieldCpfCnpj.setText(psCustomer.getSiret());
        jTextFieldDesconto.setText(formataCampos.bigDecimalParaString(psOrders.getTotalDiscountsTaxIncl(), 3));
        jTextFieldEmail.setText(psCustomer.getEmail());
        jTextFieldFrete.setText(formataCampos.bigDecimalParaString(psOrders.getTotalShippingTaxIncl(), 3));
        jTextFieldNome.setText(psCustomer.getFirstname() + " " + psCustomer.getLastname());
        for (PsAddress psAddress : queryPrestaShop.listAddress(false, psCustomer.getIdCustomer())) {
            jTextFieldCpfCnpj.setText(psAddress.getVatNumber());
            jTextFieldRgIe.setText(psAddress.getDni());
        }
        for (PsOrderStateLang psOSL : queryPrestaShop.lisPsOrderStateLang(psOrders.getCurrentState(), 2)) {
            jTextFieldStatus.setText(psOSL.getName());
        }
        jTextFieldTaxa.setText(formataCampos.bigDecimalParaString(psOrders.getTotalPaidTaxIncl().subtract(psOrders.getTotalPaidTaxExcl()), 3));
        jTextFieldValorTotal.setText(formataCampos.bigDecimalParaString(psOrders.getTotalPaidTaxIncl(), 3));
        
        //String produto= (String)((DefaultComboBoxModel) jComboBoxPagamento.getModel()).getSelectedItem();
        jComboBoxPagamento.setSelectedItem(psOrders.getPayment());
        /**if ("ps_checkpayment".equals(psOrders.getModule())) {
            jComboBoxPagamento.setSelectedIndex(0);
        }
        if ("ps_wirepayment".equals(psOrders.getModule())) {
            jComboBoxPagamento.setSelectedIndex(1);
        }
        if ("custompaymentmethod_1".equals(psOrders.getModule())) {
            jComboBoxPagamento.setSelectedIndex(2);
        }
        */
        
        jButtonAtualizaCliente.setEnabled(true);
        jButtonAlteraPagamento.setEnabled(true);

        //listPsOrders = new ArrayList<>();
        try {
            HashMap<String, Object> getSchemaOpt = new HashMap();
            getSchemaOpt.put("url", shopUrl + "/api/order_details?filter[id_order]=" + psOrders.getIdOrder());
            // Document document;
            document = ws.getFuncao(getSchemaOpt);
            NodeList nList = document.getElementsByTagName("order_detail");
            for (String id : ws.retornaListaId(nList)) {
                getSchemaOpt.put("url", shopUrl + "/api/order_details/" + id);
                document = ws.getFuncao(getSchemaOpt);
                psOrderDetailList.add(new WebOrderDetails().xmlParaEntidade(document, ws));
            }
        } catch (PrestaShopWebserviceException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar Web Service: \n" + ex);
        }

        //for (PsOrderDetail orDetail : queryPrestaShop.listPsOrderDetail(psOrders.getIdOrder())) {
      //      psOrderDetailList.add(orDetail);
      //  }
    }

    private void limpaCampos() {
        jButtonImportarPedido.setEnabled(false);
        //jButtonAtualizaCliente.setEnabled(false);
        jButtonAlteraPagamento.setEnabled(false);
        psCustomerList.clear();
        jComboBoxPagamento.setSelectedIndex(3);
        psOrderDetailList.clear();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VendaDigimacroJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VendaDigimacroJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VendaDigimacroJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VendaDigimacroJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VendaDigimacroJFrame(managerIntegrador, managerPrestaShop, managerCplus, usuario).setVisible(true);
            }
        });
    }

    static EntityManagerFactory managerPrestaShop;
    static EntityManagerFactory managerIntegrador;
    static EntityManagerFactory managerCplus;
    private final String codCaracteristicaCliente;
    private final FormataCampos formataCampos;
    private PsOrders psOrders;
    private final SaidasPrestaShopJDialog listagemSaidasMagentoJDialog;
    private final ListPsProductJDialog listagemProdutoMagentoJDialog;
    private final QueryPrestaShop queryPrestaShop;
    private final QueryCplus queryCplus;
    //private final EditSalesFlatOrderItemJDialog editSalesFlatOrderItemJDialog;
    private final InsereSalesFlatOrderItemJDialog insereSalesFlatOrderItemJDialog;
    private static Usuario usuario;
    //private final ControleAcesso acesso;
    private final int colunaCustomerId;
    //private int colunaCarrinhoId;
    private final String shopUrl;
    private final String key;
    private ClienteWebService ws;


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager PrestaShopPUEntityManager;
    private javax.swing.JButton jButtonAlteraPagamento;
    private javax.swing.JButton jButtonAtualizaCliente;
    private javax.swing.JButton jButtonImportarCliente;
    private javax.swing.JButton jButtonImportarPedido;
    private javax.swing.JButton jButtonInserir;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JButton jButtonPesquisar1;
    private javax.swing.JCheckBox jCheckBoxNaoIntegrado;
    private javax.swing.JComboBox<String> jComboBoxPagamento;
    private javax.swing.JComboBox jComboBoxTermoPesquisa;
    private com.toedter.calendar.JDateChooser jDateChooserDataFinalCustomer;
    private com.toedter.calendar.JDateChooser jDateChooserDataInicialCustomer;
    private javax.swing.JLabel jLabelCpfCnpj;
    private javax.swing.JLabel jLabelDataFinalCustomer;
    private javax.swing.JLabel jLabelDataInicialCustomer;
    private javax.swing.JLabel jLabelDesconto;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelFrete;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelRgIe;
    private javax.swing.JLabel jLabelStaus;
    private javax.swing.JLabel jLabelTaxa;
    private javax.swing.JLabel jLabelValorTotal;
    private javax.swing.JPanel jPanelClienteDigimacro;
    private javax.swing.JPanel jPanelControleClienteDigimacro;
    private javax.swing.JPanel jPanelInformacoes;
    private javax.swing.JPanel jPanelPesquisa;
    private javax.swing.JPanel jPanelVendasMagento;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPaneVendasMagento;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableCustomer;
    private javax.swing.JTextField jTextFieldCpfCnpj;
    private javax.swing.JTextField jTextFieldDesconto;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldFrete;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldRgIe;
    private javax.swing.JTextField jTextFieldStatus;
    private javax.swing.JTextField jTextFieldStringPesquisa;
    private javax.swing.JTextField jTextFieldTaxa;
    private javax.swing.JTextField jTextFieldValorTotal;
    private java.util.List<entidade.prestaShop.PsCustomer> psCustomerList;
    private javax.persistence.Query psCustomerQuery;
    private java.util.List<entidade.prestaShop.PsOrderDetail> psOrderDetailList;
    private javax.persistence.Query psOrderDetailQuery;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

}
