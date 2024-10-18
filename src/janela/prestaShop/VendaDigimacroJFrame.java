/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package janela.prestaShop;

import acesso.ConexaoPrestaShop;
import entidade.cplus.Cliente;
import entidade.cplus.Clientecaracteristica;
import entidade.cplus.Produtoestoque;
import entidade.cplus.Usuario;
import entidade.integrador.IntExecucao;
import entidade.prestaShop.PsAddress;
import entidade.prestaShop.PsCarrier;
import entidade.prestaShop.PsCartProduct;
import entidade.prestaShop.PsCartProductPK;
import entidade.prestaShop.PsCartRule;
import entidade.prestaShop.PsCartRuleLang;
import entidade.prestaShop.PsCartRuleLangPK;
import entidade.prestaShop.PsCustomPaymentMethodLang;
import entidade.prestaShop.PsCustomer;
import entidade.prestaShop.PsOrderCarrier;
import entidade.prestaShop.PsOrderCartRule;
import entidade.prestaShop.PsOrderCommission;
import entidade.prestaShop.PsOrderDetail;
import entidade.prestaShop.PsOrderHistory;
import entidade.prestaShop.PsOrderStateLang;
import entidade.prestaShop.PsOrders;
import entidade.prestaShop.PsPack;
import entidade.prestaShop.PsProduct;
import entidade.prestaShop.PsStockAvailable;
import integrador.render.ConfTabelaOrderDetail;
import integrador.separacao.ColorirLinhaImpar;
import janela.cplus.FormataCampos;
import janela.integrador.AtualizaExecucaoIntegrador;
import janela.integrador.ClienteCplusDigimacro;
import janela.integrador.ClienteDigimacroCplus;
import java.awt.Toolkit;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.EntityManagerFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import jpa.cplus.ProdutoestoqueJpaController;
import jpa.integrador.IntExecucaoJpaController;
import jpa.prestaShop.PsCartProductJpaController;
import jpa.prestaShop.PsCartRuleJpaController;
import jpa.prestaShop.PsCartRuleLangJpaController;
import jpa.prestaShop.PsCustomerJpaController;
import jpa.prestaShop.PsOrderCarrierJpaController;
import jpa.prestaShop.PsOrderCartRuleJpaController;
import jpa.prestaShop.PsOrderDetailJpaController;
import jpa.prestaShop.PsOrderHistoryJpaController;
import jpa.prestaShop.PsOrdersJpaController;
import jpa.prestaShop.PsProductJpaController;
import jpa.prestaShop.PsStockAvailableJpaController;
import pedido.PedidoDigimacroCplus;
import produto.PedidoCompra;
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
        format = new FormataCampos();
        managerPrestaShop = managerPrestaShop1;
        managerIntegrador = managerIntegrador1;
        managerCplus = managerCplus1;
        usuario = usuario1;
        queryPrestaShop = new QueryPrestaShop(managerPrestaShop);
        initComponents();
        codCaracteristicaCliente = new QueryIntegrador().valorConfiguracao("cliente_CARACTERISTICA_CPLUS_DIGIMACRO");
        queryCplus = new QueryCplus(managerCplus);
        this.listagemSaidasMagentoJDialog = new SaidasPrestaShopJDialog(this, true, managerPrestaShop, managerIntegrador);
        this.editOrderDetailsJDialog = new EditOrderDetailsJDialog(this, true, managerPrestaShop, managerCplus, usuario);
        this.listPsProductJDialog = new ListPsProductJDialog(this, true, managerIntegrador, managerPrestaShop, managerCplus, usuario);
        this.adicionarOrderDetailJDialog = new AdicionarOrderDetailJDialog(this, true, managerPrestaShop, managerCplus, usuario);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icones/logo.png")));
        jDateChooserDataInicialCustomer.setDate(format.alteraDiaData(format.dataAtual(), -2));
        jDateChooserDataFinalCustomer.setDate(format.alteraDiaData(format.dataAtual(), 1));
        colunaCustomerId = jTableCustomer.getColumnModel().getColumnIndex("Id Customer");
        colunaOrderDetail = jTableOrderDetail.getColumnModel().getColumnIndex("Id Order Detail");
        for (PsCustomPaymentMethodLang mp : queryPrestaShop.listCustomPagament()) {
            ((DefaultComboBoxModel) jComboBoxPagamento.getModel()).addElement(mp.getName()); // Adiciona o Objeto
        }
        for (PsOrderStateLang st : queryPrestaShop.listPsOrderStateLang(2)) {
            ((DefaultComboBoxModel) jComboBoxState.getModel()).addElement(st.getName()); // Adiciona o Objeto
        }
        for (PsCarrier st : queryPrestaShop.listPsCarrier(true, false)) {
            ((DefaultComboBoxModel) jComboBoxShipping.getModel()).addElement(st.getName()); // Adiciona o Objeto
        }
        valDescontoAvulso = BigDecimal.ZERO;
        psCustomerList = new ArrayList<>();
        psOrderDetailList = new ArrayList<>();
        //new RenderHorizontalAlinhamentoDireita();
        jTableOrderDetail.setDefaultRenderer(Object.class, new ConfTabelaOrderDetail());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPaneVendasMagento = new javax.swing.JTabbedPane();
        jPanelVendasMagento = new javax.swing.JPanel();
        jPanelPesquisa = new javax.swing.JPanel();
        jButtonPesquisar = new javax.swing.JButton();
        jButtonImportarPedido = new javax.swing.JButton();
        jButtonAtualizaCliente = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
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
        jTextFieldTotalProdutos = new javax.swing.JTextField();
        jTextFieldTaxa = new javax.swing.JTextField();
        jButtonAlteraPagamento = new javax.swing.JButton();
        jComboBoxPagamento = new javax.swing.JComboBox<>();
        jComboBoxState = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldDescontoAvulso = new javax.swing.JTextField();
        jButtonDescontoAvulso = new javax.swing.JButton();
        jButtonCancelarOrders = new javax.swing.JButton();
        jComboBoxShipping = new javax.swing.JComboBox();
        jButtonShipping = new javax.swing.JButton();
        jTextFieldValorFrete = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButtonProdutosComprados = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableOrderDetail = new javax.swing.JTable();
        jPanelClienteDigimacro = new javax.swing.JPanel();
        jPanelControleClienteDigimacro = new javax.swing.JPanel();
        jComboBoxTermoPesquisa = new javax.swing.JComboBox();
        jTextFieldPesquisaCustomer = new javax.swing.JTextField();
        jButtonPesquisarCustomer = new javax.swing.JButton();
        jButtonImportarCliente = new javax.swing.JButton();
        jDateChooserDataInicialCustomer = new com.toedter.calendar.JDateChooser();
        jLabelDataInicialCustomer = new javax.swing.JLabel();
        jLabelDataFinalCustomer = new javax.swing.JLabel();
        jDateChooserDataFinalCustomer = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableCustomer = new javax.swing.JTable();
        jButtonAdicionar = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonRemover = new javax.swing.JButton();

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
        jButtonAtualizaCliente.setEnabled(false);
        jButtonAtualizaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtualizaClienteActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/pesquisar.png"))); // NOI18N
        jButton1.setText("Pesquisa Produtos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonAtualizaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelPesquisaLayout.setVerticalGroup(
            jPanelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButtonPesquisar)
                .addComponent(jButtonImportarPedido)
                .addComponent(jButtonAtualizaCliente)
                .addComponent(jButton1))
        );

        jPanelInformacoes.setBorder(javax.swing.BorderFactory.createTitledBorder("Informa��es"));

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

        jTextFieldNome.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jTextFieldCpfCnpj.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jTextFieldRgIe.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jTextFieldStatus.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jTextFieldEmail.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabelValorTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelValorTotal.setText("Valor Total:");

        jLabelDesconto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelDesconto.setText("Desconto:");

        jLabelFrete.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelFrete.setText("Total Produtos:");

        jLabelTaxa.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTaxa.setText("Taxa:");

        jTextFieldValorTotal.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextFieldValorTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jTextFieldDesconto.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextFieldDesconto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jTextFieldTotalProdutos.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextFieldTotalProdutos.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jTextFieldTaxa.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextFieldTaxa.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jButtonAlteraPagamento.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonAlteraPagamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Edit.png"))); // NOI18N
        jButtonAlteraPagamento.setText("Alterar Meio de Pagamento");
        jButtonAlteraPagamento.setEnabled(false);
        jButtonAlteraPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlteraPagamentoActionPerformed(evt);
            }
        });

        jComboBoxPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        jComboBoxPagamento.setFocusable(false);
        jComboBoxPagamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxPagamentoMouseClicked(evt);
            }
        });

        jComboBoxState.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        jComboBoxState.setFocusable(false);

        jLabel1.setText("Desc Avulso:");

        jTextFieldDescontoAvulso.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextFieldDescontoAvulso.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jButtonDescontoAvulso.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonDescontoAvulso.setText("Dar Desconto Avuso");
        jButtonDescontoAvulso.setEnabled(false);
        jButtonDescontoAvulso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDescontoAvulsoActionPerformed(evt);
            }
        });

        jButtonCancelarOrders.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonCancelarOrders.setText("Cancelar Pedido");
        jButtonCancelarOrders.setEnabled(false);
        jButtonCancelarOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarOrdersActionPerformed(evt);
            }
        });

        jComboBoxShipping.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        jComboBoxShipping.setFocusable(false);
        jComboBoxShipping.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxShippingMouseClicked(evt);
            }
        });

        jButtonShipping.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonShipping.setText("Mudar Entrega");
        jButtonShipping.setEnabled(false);
        jButtonShipping.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonShippingActionPerformed(evt);
            }
        });

        jTextFieldValorFrete.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextFieldValorFrete.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Valor Frete:");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

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
                .addGroup(jPanelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTaxa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelFrete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelValorTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelDesconto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldValorFrete, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                    .addComponent(jTextFieldDesconto, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldTaxa, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldTotalProdutos, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldValorTotal, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldDescontoAvulso))
                .addGap(18, 18, 18)
                .addGroup(jPanelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxPagamento, 0, 323, Short.MAX_VALUE)
                    .addComponent(jComboBoxState, 0, 323, Short.MAX_VALUE)
                    .addComponent(jComboBoxShipping, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonAlteraPagamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonDescontoAvulso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonCancelarOrders, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonShipping, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanelInformacoesLayout.setVerticalGroup(
            jPanelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInformacoesLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelInformacoesLayout.createSequentialGroup()
                        .addGroup(jPanelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonAlteraPagamento))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxShipping, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonShipping))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelInformacoesLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jButtonDescontoAvulso)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonCancelarOrders))
                            .addComponent(jComboBoxState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelInformacoesLayout.createSequentialGroup()
                        .addGroup(jPanelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelNome)
                            .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelCpfCnpj)
                            .addComponent(jTextFieldCpfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelRgIe)
                            .addComponent(jTextFieldRgIe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelStaus)
                            .addComponent(jTextFieldStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelEmail)
                            .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelInformacoesLayout.createSequentialGroup()
                .addGroup(jPanelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelValorTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTotalProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelFrete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTaxa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTaxa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDesconto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDescontoAvulso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldValorFrete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jButtonProdutosComprados.setText("Produtos Comprados");
        jButtonProdutosComprados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProdutosCompradosActionPerformed(evt);
            }
        });

        jTableOrderDetail.setAutoCreateRowSorter(true);
        jTableOrderDetail.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTableOrderDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "EAN", "Produto Nome", "Quant", "Valor", "Val. Unit.", "Val. Total", "Desc. %", "Desc. Grupo", "Peso", "Reference", "Id Order", "Id Order Detail"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableOrderDetail.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTableOrderDetail.getTableHeader().setReorderingAllowed(false);
        jTableOrderDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableOrderDetailMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableOrderDetail);
        if (jTableOrderDetail.getColumnModel().getColumnCount() > 0) {
            jTableOrderDetail.getColumnModel().getColumn(0).setPreferredWidth(120);
            jTableOrderDetail.getColumnModel().getColumn(1).setPreferredWidth(350);
            jTableOrderDetail.getColumnModel().getColumn(3).setPreferredWidth(80);
            jTableOrderDetail.getColumnModel().getColumn(4).setPreferredWidth(80);
        }

        javax.swing.GroupLayout jPanelVendasMagentoLayout = new javax.swing.GroupLayout(jPanelVendasMagento);
        jPanelVendasMagento.setLayout(jPanelVendasMagentoLayout);
        jPanelVendasMagentoLayout.setHorizontalGroup(
            jPanelVendasMagentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVendasMagentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelVendasMagentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelVendasMagentoLayout.createSequentialGroup()
                        .addComponent(jPanelPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                        .addComponent(jButtonProdutosComprados, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanelInformacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        jPanelVendasMagentoLayout.setVerticalGroup(
            jPanelVendasMagentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelVendasMagentoLayout.createSequentialGroup()
                .addGroup(jPanelVendasMagentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonProdutosComprados))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelInformacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114))
        );

        jTabbedPaneVendasMagento.addTab("Vendas Site", jPanelVendasMagento);

        jComboBoxTermoPesquisa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Data Atualiza��o", "E-mail Principal", "Data Cria��o" }));
        jComboBoxTermoPesquisa.setToolTipText("Seleciona , qual o tipo de pesquisa que deseja fazer!");

        jButtonPesquisarCustomer.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonPesquisarCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/pesquisar.png"))); // NOI18N
        jButtonPesquisarCustomer.setText("Pesquizar");
        jButtonPesquisarCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarCustomerActionPerformed(evt);
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

        jDateChooserDataInicialCustomer.setDateFormatString("dd/MM/yyyy");

        jLabelDataInicialCustomer.setText("Data Inicial:");

        jLabelDataFinalCustomer.setText("Data Final:");

        jDateChooserDataFinalCustomer.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout jPanelControleClienteDigimacroLayout = new javax.swing.GroupLayout(jPanelControleClienteDigimacro);
        jPanelControleClienteDigimacro.setLayout(jPanelControleClienteDigimacroLayout);
        jPanelControleClienteDigimacroLayout.setHorizontalGroup(
            jPanelControleClienteDigimacroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelControleClienteDigimacroLayout.createSequentialGroup()
                .addComponent(jComboBoxTermoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelControleClienteDigimacroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelControleClienteDigimacroLayout.createSequentialGroup()
                        .addComponent(jTextFieldPesquisaCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonPesquisarCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
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
                    .addComponent(jTextFieldPesquisaCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisarCustomer)
                    .addComponent(jButtonImportarCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelControleClienteDigimacroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDataInicialCustomer)
                    .addGroup(jPanelControleClienteDigimacroLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanelControleClienteDigimacroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDateChooserDataInicialCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelControleClienteDigimacroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jDateChooserDataFinalCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelDataFinalCustomer))))))
        );

        jTableCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "E-Mail", "Empresa", "CPF/CNPJ", "Data Atual.", "Data Add", "Ativo", "Nota", "Limite cr�dito", "Newsletter", "Id Group", "Id Customer"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCustomer.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTableCustomer);
        if (jTableCustomer.getColumnModel().getColumnCount() > 0) {
            jTableCustomer.getColumnModel().getColumn(0).setPreferredWidth(400);
            jTableCustomer.getColumnModel().getColumn(1).setPreferredWidth(350);
            jTableCustomer.getColumnModel().getColumn(2).setPreferredWidth(350);
            jTableCustomer.getColumnModel().getColumn(3).setPreferredWidth(200);
        }

        javax.swing.GroupLayout jPanelClienteDigimacroLayout = new javax.swing.GroupLayout(jPanelClienteDigimacro);
        jPanelClienteDigimacro.setLayout(jPanelClienteDigimacroLayout);
        jPanelClienteDigimacroLayout.setHorizontalGroup(
            jPanelClienteDigimacroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelClienteDigimacroLayout.createSequentialGroup()
                .addGroup(jPanelClienteDigimacroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addComponent(jPanelControleClienteDigimacro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelClienteDigimacroLayout.setVerticalGroup(
            jPanelClienteDigimacroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelClienteDigimacroLayout.createSequentialGroup()
                .addComponent(jPanelControleClienteDigimacro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPaneVendasMagento.addTab("Cliente Site", jPanelClienteDigimacro);

        jButtonAdicionar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/adicionar.png"))); // NOI18N
        jButtonAdicionar.setText("Adicionar");
        jButtonAdicionar.setEnabled(false);
        jButtonAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarActionPerformed(evt);
            }
        });

        jButtonEditar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Edit.png"))); // NOI18N
        jButtonEditar.setText("Editar");
        jButtonEditar.setEnabled(false);
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonRemover.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/delete.png"))); // NOI18N
        jButtonRemover.setText("Remover");
        jButtonRemover.setEnabled(false);
        jButtonRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneVendasMagento, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonAdicionar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonRemover)
                .addGap(251, 251, 251))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPaneVendasMagento, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAdicionar)
                    .addComponent(jButtonEditar)
                    .addComponent(jButtonRemover))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        pesquisarOrders();
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jButtonImportarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImportarPedidoActionPerformed
        psOrders = new PsOrdersJpaController(managerPrestaShop).findPsOrders(psOrders.getIdOrder());
        new PedidoDigimacroCplus().criaPedidoCplus(managerIntegrador, managerCplus, psOrders, managerPrestaShop);
        jButtonImportarPedido.setEnabled(false);
        limpaCampos();
        JOptionPane.showMessageDialog(null, "Pedido importado com sucesso!!!");

    }//GEN-LAST:event_jButtonImportarPedidoActionPerformed

    private void jButtonPesquisarCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarCustomerActionPerformed
        switch (jComboBoxTermoPesquisa.getSelectedIndex()) {
            case 0:
                pesquisaDataCustomerUpdete();
                break;
            case 1:
                pesquisaPorEmail();
                break;
            case 2:
                pesquisaDataCustomerCreate();
                break;
        }
        carregaTabelaCustomer();
    }//GEN-LAST:event_jButtonPesquisarCustomerActionPerformed

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
            if (jComboBoxPagamento.getSelectedIndex() == 1) {
                psOrders.setModule("custompaymentmethod_1");
                psOrders.setPayment("Cupom");
            }
            if (jComboBoxPagamento.getSelectedIndex() == 2) {
                psOrders.setModule("custompaymentmethod_3");
                psOrders.setPayment("� vista ou Transfer�ncia");
            }
            if (jComboBoxPagamento.getSelectedIndex() == 3) {
                psOrders.setModule("custompaymentmethod_4");
                psOrders.setPayment("� vista");
            }
            if (jComboBoxPagamento.getSelectedIndex() == 4) {
                psOrders.setModule("custompaymentmethod_5");
                psOrders.setPayment("Boleto (R$300,00 Min.)");
            }
            if (jComboBoxPagamento.getSelectedIndex() == 5) {
                psOrders.setModule("custompaymentmethod_6");
                psOrders.setPayment("Cart�o de Cr�dito");
            }
            //new PsOrdersJpaController(managerPrestaShop).edit(psOrders);
            //editaOrders();
            desativarDescontoAvulso();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Houve um erro ao trocar meio de pagamento\n VERIFIQUE!!! \n" + ex);
        }
        //limpaCampos();
        //carregaCampos();
        jButtonAlteraPagamento.setEnabled(false);
        jButtonImportarPedido.setEnabled(true);

    }//GEN-LAST:event_jButtonAlteraPagamentoActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        if (condicaoPedido()) {
//this.editOrderDetailsJDialog.setVisible(true);
            Integer cod = Integer.valueOf(jTableOrderDetail.getValueAt(jTableOrderDetail.getSelectedRow(), colunaOrderDetail).toString());
            this.editOrderDetailsJDialog.setObjetos(new PsOrderDetailJpaController(managerPrestaShop).findPsOrderDetail(cod), psOrders);
            this.editOrderDetailsJDialog.setVisible(true);
            if (this.editOrderDetailsJDialog.isCancelamento() == false) {
                //atualizaListOrderDetail(); //atualizar o list para garantir que valores atulizados sejam retornados                    
                //editaOrders(); //editar orders com valores atualizados
                desativarDescontoAvulso();
                //carregaCampos();
            }
        }
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarActionPerformed
        if (condicaoPedido()) {
            this.listPsProductJDialog.setVisible(true);
            if (this.listPsProductJDialog.isCancelamento() == false) {
                boolean jaExiste = false;
                for (PsOrderDetail item : queryPrestaShop.listPsOrderDetail(psOrders.getIdOrder())) {
                    if (Objects.equals(item.getProductId(), this.listPsProductJDialog.getProductEntity().getIdProduct())) {
                        jaExiste = true;
                    }
                }
                if (jaExiste) {
                    JOptionPane.showMessageDialog(null, "O produto j� est� no pedido verifique!!! ");
                } else {
                    this.adicionarOrderDetailJDialog.setObjetos(this.listPsProductJDialog.getProductEntity(), psOrders);
                    this.adicionarOrderDetailJDialog.setVisible(true);
                    //editaOrders();
                    desativarDescontoAvulso();
                    //carregaCampos();
                    // carregaCamposSalesFlatOrder();
                }
            }
        }
    }//GEN-LAST:event_jButtonAdicionarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.listPsProductJDialog.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverActionPerformed
        if (condicaoPedido()) {
            removePsOrderDetail();
            desativarDescontoAvulso();
            //carregaCampos();
        }
    }//GEN-LAST:event_jButtonRemoverActionPerformed

    private void jButtonDescontoAvulsoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDescontoAvulsoActionPerformed
        String msg = JOptionPane.showInputDialog("Digite o Valor!");
        if (msg != null) {
            valDescontoAvulso = format.stringParaDecimal(msg, 2);
            descontoAvulso();
        }
    }//GEN-LAST:event_jButtonDescontoAvulsoActionPerformed

    private void jComboBoxPagamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxPagamentoMouseClicked
        jButtonAlteraPagamento.setEnabled(true);
    }//GEN-LAST:event_jComboBoxPagamentoMouseClicked

    private void jButtonCancelarOrdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarOrdersActionPerformed
        int cancelar = JOptionPane.showConfirmDialog(null, " Deseja realmente cancelar? \n A a��o n�o pode ser revertida!!", "Cancelar", JOptionPane.YES_NO_CANCEL_OPTION);
        if (cancelar == JOptionPane.YES_OPTION) {
            cancelarStateOrders();
            jButtonCancelarOrders.setEnabled(false);
        }
    }//GEN-LAST:event_jButtonCancelarOrdersActionPerformed

    private void jButtonShippingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonShippingActionPerformed

        for (PsCarrier c : queryPrestaShop.listCarrier((String) jComboBoxShipping.getSelectedItem())) {
            psOrders.setIdCarrier(c.getIdCarrier());
        }
        editaOrders();
        carregaCampos();
        jButtonShipping.setEnabled(false);
        jButtonImportarPedido.setEnabled(true);
    }//GEN-LAST:event_jButtonShippingActionPerformed

    private void jComboBoxShippingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxShippingMouseClicked
        jButtonShipping.setEnabled(true);
    }//GEN-LAST:event_jComboBoxShippingMouseClicked

    private void jButtonProdutosCompradosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProdutosCompradosActionPerformed
        new PedidoCompra().produtosComprados(managerCplus);
    }//GEN-LAST:event_jButtonProdutosCompradosActionPerformed

    private void jTableOrderDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableOrderDetailMouseClicked
        jButtonEditar.setEnabled(true);
        jButtonRemover.setEnabled(true);
    }//GEN-LAST:event_jTableOrderDetailMouseClicked

    private void pesquisarOrders() {
        limpaCampos();
        this.listagemSaidasMagentoJDialog.pesquisas();
        this.listagemSaidasMagentoJDialog.setVisible(true);
        if (this.listagemSaidasMagentoJDialog.isCancelamento() == false) {
            psOrders = this.listagemSaidasMagentoJDialog.getSalesFlatOrder();
        }
        if (psOrders != null) {
            valDescontoAvulso = psOrders.getTotalDiscountsTaxIncl();
            carregaCampos();
            jButtonImportarPedido.setEnabled(true);
            jButtonAdicionar.setEnabled(true);
        }
    }

    private boolean condicaoPedido() {
        boolean condicao = false;
        if (psOrders.getCurrentState() == 1 || psOrders.getCurrentState() == 2 || psOrders.getCurrentState() == 10) {
            condicao = true;
        } else {
            JOptionPane.showMessageDialog(null, "N�o pode ser feito altera��es com pedidos neste Status!! \n Tente outra op��o!");
        }
        return condicao;
    }

    private void cancelarStateOrders() {
        // if(psOrders.getCurrentState() == jComboBoxState.getSelectedIndex()){
        for (PsOrderDetail item : queryPrestaShop.listOrderDetail(psOrders.getIdOrder())) {
            int qn = item.getProductQuantity();
            for (PsStockAvailable s : queryPrestaShop.listEstoqueProduto(item.getProductId())) {
                s.setQuantity(s.getQuantity() + qn);
                s.setReservedQuantity(s.getReservedQuantity() - qn);
                s.setPhysicalQuantity(s.getQuantity() + s.getReservedQuantity());
                try {
                    new PsStockAvailableJpaController(managerPrestaShop).edit(s);
                    atualizaCplus(new PsProductJpaController(managerPrestaShop).findPsProduct(s.getIdProduct()));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Houve um erro ao Atualizar Estoque PrestaShop!!!\n " + ex);
                }
            }
        }
        PsOrderHistory history = new PsOrderHistory();
        history.setIdEmployee(0);
        history.setIdOrder(psOrders.getIdOrder());
        history.setIdOrderState(6);
        history.setDateAdd(format.dataAtual());
        new PsOrderHistoryJpaController(managerPrestaShop).create(history);
        psOrders.setCurrentState(6);
        try {
            new PsOrdersJpaController(managerPrestaShop).edit(psOrders);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Houve um erro ao cancelar orders !!!\n " + ex);
        }
        carregaCampos();
        //  }
    }

    private void removePsOrderDetail() {
        if (psOrderDetailList.size() == 1) {
            JOptionPane.showMessageDialog(null, "N�o pode ser removido o ultimo produto do pedido!! \n Tente outra op��o!");
        } else {
            int cancelar = JOptionPane.showConfirmDialog(null, " Deseja realmente excluir este item?", "Excluir", JOptionPane.YES_NO_CANCEL_OPTION);
            if (cancelar == JOptionPane.YES_OPTION) {
                Integer cod = Integer.valueOf(jTableOrderDetail.getValueAt(jTableOrderDetail.getSelectedRow(), colunaOrderDetail).toString());
                PsOrderDetail item = new PsOrderDetailJpaController(managerPrestaShop).findPsOrderDetail(cod);
                int qn = item.getProductQuantity();
                for (PsStockAvailable s : queryPrestaShop.listEstoqueProduto(item.getProductId())) {
                    //qn = s.getQuantity() + qn;              
                    s.setQuantity(s.getQuantity() + qn);
                    s.setReservedQuantity(s.getReservedQuantity() - qn);
                    s.setPhysicalQuantity(s.getQuantity() + s.getReservedQuantity());
                    try {
                        new PsStockAvailableJpaController(managerPrestaShop).edit(s);

                        List<PsCartProduct> listCartProduct = queryPrestaShop.listCarProduct(psOrders.getIdCart(), item.getProductId());
                        for (PsCartProduct cartProd : listCartProduct) {
                            new PsCartProductJpaController(managerPrestaShop).destroy(new PsCartProductPK(cartProd.getPsCartProductPK().getIdCart(), cartProd.getPsCartProductPK().getIdProduct(), cartProd.getPsCartProductPK().getIdAddressDelivery(), 0, 0));
                        }
                        new PsOrderDetailJpaController(managerPrestaShop).destroy(item.getIdOrderDetail());
                        atualizaCplus(new PsProductJpaController(managerPrestaShop).findPsProduct(s.getIdProduct()));
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Houve um erro ao Atualizar Estoque PrestaShop!!!\n " + ex);
                    }
                }
            }
        }
    }

    private void atualizaCplus(PsProduct pp) {
        List<Produtoestoque> listestoque = new ArrayList<>();
        if (pp.getCacheIsPack()) {
            for (PsPack psP : new QueryPrestaShop(managerPrestaShop).listPack(pp.getIdProduct())) {
                listestoque = new QueryCplus(managerCplus).listEstoquesPorProd(new PsProductJpaController(managerPrestaShop).findPsProduct(psP.getPsPackPK().getIdProductItem()).getReference());
            }
        } else {
            listestoque = new QueryCplus(managerCplus).listEstoquesPorProd(pp.getReference());
        }
        for (Produtoestoque estoque : listestoque) {
            estoque.setLastChange(format.dataAtual());
            try {
                new ProdutoestoqueJpaController(managerCplus).edit(estoque);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Houve um erro ao Atualizar Estoque C-Plus!!!\n " + ex);
            }
        }
    }

    private void editaOrders() {
        BigDecimal totProd = BigDecimal.ZERO;
        BigDecimal totPeso = BigDecimal.ZERO;
        for (PsOrderDetail od : queryPrestaShop.listOrderDetail(psOrders.getIdOrder())) {
            totProd = totProd.add(od.getTotalPriceTaxIncl());
            totPeso = totPeso.add(od.getProductWeight());
        }
        psOrders.setTotalProducts(totProd);
        psOrders.setTotalProductsWt(totProd);
        BigDecimal valTotal;
        double desFormaPagamento = 0.0;
        BigDecimal valDesconto = BigDecimal.ZERO;
        BigDecimal valAcrecimo = BigDecimal.ZERO;
        Connection conn = new ConexaoPrestaShop().getConnection();
        List<PsOrderCommission> lisyOrderCommissions = new ConexaoPrestaShop().listPsOrderCommission(conn, psOrders.getIdOrder());
        if ("custompaymentmethod_3".equals(psOrders.getModule())) { //se o metodo de pagamento for com desconto           
            //valTotal = totProd.multiply(new BigDecimal("0.985")).setScale(2, RoundingMode.HALF_UP);
            valDesconto = totProd.multiply(new BigDecimal("0.015")).setScale(2, RoundingMode.HALF_UP);
            desFormaPagamento = valDesconto.doubleValue();
            if (lisyOrderCommissions.isEmpty()) {
                new ConexaoPrestaShop().criaPsOrderCommission(conn, psOrders.getIdOrder(), 1, 0.0, 0.0, desFormaPagamento, desFormaPagamento);
            } else {
                new ConexaoPrestaShop().editaDescontoPsOrderCommission(conn, psOrders.getIdOrder(), 0.00, desFormaPagamento);
            }
        } else if ("custompaymentmethod_6".equals(psOrders.getModule())) { //se o metodo de pagamento for com acr�cimo           
            valAcrecimo = totProd.multiply(new BigDecimal("0.0379")).setScale(2, RoundingMode.HALF_UP);
            if (lisyOrderCommissions.isEmpty()) {
                new ConexaoPrestaShop().criaPsOrderCommission(conn, psOrders.getIdOrder(), 1, valAcrecimo.doubleValue(), valAcrecimo.doubleValue(), 0.00, 0.00);
            } else {
                new ConexaoPrestaShop().editaDescontoPsOrderCommission(conn, psOrders.getIdOrder(), valAcrecimo.doubleValue(), 0.00);
            }
        } else {
            if (lisyOrderCommissions.size() > 0) {
                new ConexaoPrestaShop().editaDescontoPsOrderCommission(conn, psOrders.getIdOrder(), 0.00, 0.00);
            }
        }
        new ConexaoPrestaShop().closeConnection();
        valDesconto = valDesconto.add(psOrders.getTotalDiscountsTaxIncl()).setScale(2, RoundingMode.HALF_UP);
        valTotal = totProd.subtract(valDesconto);
        valTotal = valTotal.add(valAcrecimo);
        BigDecimal valFrete = valorFrete(valTotal);
        psOrders.setTotalShipping(valFrete);
        psOrders.setTotalShippingTaxExcl(valFrete);
        psOrders.setTotalShippingTaxIncl(valFrete);
        psOrders.setTotalPaid(valTotal.add(valFrete));
        psOrders.setTotalPaidTaxIncl(valTotal.add(valFrete));
        psOrders.setTotalPaidTaxExcl(valTotal.add(valFrete));
        try {
            new PsOrdersJpaController(managerPrestaShop).edit(psOrders);
            for (PsOrderCarrier orderCarrier : queryPrestaShop.listPsOrderCarrier(psOrders.getIdOrder())) {
                orderCarrier.setWeight(totPeso);
                orderCarrier.setShippingCostTaxExcl(valFrete);
                orderCarrier.setShippingCostTaxIncl(valFrete);
                try {
                    new PsOrderCarrierJpaController(managerPrestaShop).edit(orderCarrier);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "N�o foi poss�vel editar PsOrderCarrier" + ex);
                }
            }

            carregaCampos();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao editar psOrders \n" + ex);
        }
    }

    private BigDecimal valorFrete(BigDecimal valTotal) {
        BigDecimal val = BigDecimal.ZERO;
        for (PsCarrier c : queryPrestaShop.listCarrier(psOrders.getIdCarrier())) {
            if ("Pela Digimacro".equals(c.getName())) {
                if (valTotal.doubleValue() < 2500.00) {
                    val = new BigDecimal("10.00");
                }
                if (valTotal.doubleValue() < 2000.00) {
                    val = new BigDecimal("20.00");
                }
                if (valTotal.doubleValue() < 1000.00) {
                    val = new BigDecimal("30.00");
                }
                if (valTotal.doubleValue() < 500.00) {
                    val = new BigDecimal("45.00");
                }
            }
            if ("S�o Miguel".equals(c.getName())) {
                if (valTotal.doubleValue() < 3000.00) {
                    val = new BigDecimal("20.00");
                }
                if (valTotal.doubleValue() < 2000.00) {
                    val = new BigDecimal("40.00");
                }
                if (valTotal.doubleValue() < 1000.00) {
                    val = new BigDecimal("50.00");
                }
                if (valTotal.doubleValue() < 500.00) {
                    val = new BigDecimal("60.00");
                }
            }
        }
        return val;
    }

    private void desativarDescontoAvulso() {
        List<PsOrderCartRule> listOrderCartRule = queryPrestaShop.listPsOrderCartRule(psOrders.getIdOrder());
        for (PsOrderCartRule ocr : listOrderCartRule) {
            ocr.setDeleted((short) 1);
            try {
                new PsOrderCartRuleJpaController(managerPrestaShop).edit(ocr);
                valDescontoAvulso = BigDecimal.ZERO;
                psOrders.setTotalDiscounts(valDescontoAvulso);
                psOrders.setTotalDiscountsTaxExcl(valDescontoAvulso);
                psOrders.setTotalDiscountsTaxIncl(valDescontoAvulso);
                new PsOrdersJpaController(managerPrestaShop).edit(psOrders);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao editar psOrders \n" + ex);
            }
        }
        editaOrders();
    }

    private void descontoAvulso() {
        List<PsOrderCartRule> listOrderCartRule = queryPrestaShop.listPsOrderCartRule(psOrders.getIdOrder());
        if (listOrderCartRule.isEmpty()) {
            PsCartRule cr = new PsCartRule();
            cr.setIdCustomer(psOrders.getIdCustomer());
            cr.setDateFrom(format.dataAtual());
            cr.setDateTo(format.alteraDiaData(format.dataAtual(), 2));
            cr.setDescription(String.valueOf(psOrders.getIdOrder()));
            cr.setQuantity(1);
            cr.setQuantityPerUser(1);
            cr.setPriority(1);
            cr.setPartialUse(true);
            cr.setMinimumAmount(BigDecimal.ZERO);
            cr.setMinimumAmountTax(false);
            cr.setMinimumAmountCurrency(0);
            cr.setMinimumAmountShipping(false);
            cr.setCountryRestriction(false);
            cr.setCarrierRestriction(false);
            cr.setGroupRestriction(false);
            cr.setCartRuleRestriction(false);
            cr.setProductRestriction(false);
            cr.setShopRestriction(false);
            cr.setFreeShipping(false);
            cr.setReductionPercent(BigDecimal.ZERO);
            cr.setReductionAmount(valDescontoAvulso);
            cr.setReductionTax(false);
            cr.setReductionCurrency(1);
            cr.setReductionProduct(0);
            cr.setReductionExcludeSpecial(false);
            cr.setGiftProduct(0);
            cr.setGiftProductAttribute(0);
            cr.setHighlight(false);
            cr.setActive(false);
            cr.setDateAdd(format.dataAtual());
            cr.setDateUpd(format.dataAtual());
            cr.setCode("");
            new PsCartRuleJpaController(managerPrestaShop).create(cr);

            List<PsCartRule> listCartRule = queryPrestaShop.listCartRule(String.valueOf(psOrders.getIdOrder()));
            for (PsCartRule cartR : listCartRule) {
                PsOrderCartRule ocr = new PsOrderCartRule();
                ocr.setIdOrder(psOrders.getIdOrder());
                ocr.setIdCartRule(cartR.getIdCartRule());
                ocr.setIdOrderInvoice(0);
                ocr.setName("Desconto Avulso feito por: " + usuario.getNome());
                ocr.setValue(valDescontoAvulso);
                ocr.setValueTaxExcl(valDescontoAvulso);
                ocr.setFreeShipping(false);
                ocr.setDeleted((short) 0);
                new PsOrderCartRuleJpaController(managerPrestaShop).create(ocr);

                try {
                    PsCartRuleLang g = new PsCartRuleLang();
                    g.setName("Desconto Avulso feito por: " + usuario.getNome());
                    g.setPsCartRuleLangPK(new PsCartRuleLangPK(cartR.getIdCartRule(), 2));
                    new PsCartRuleLangJpaController(managerPrestaShop).create(g);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao criar PsCartRuleLang \n" + ex);
                }
            }
        } else {
            for (PsOrderCartRule ocr : listOrderCartRule) {
                ocr.setName("Desconto Avulso feito por: " + usuario.getNome());
                ocr.setValue(valDescontoAvulso);
                ocr.setValueTaxExcl(valDescontoAvulso);
                ocr.setDeleted((short) 0);
                try {
                    new PsOrderCartRuleJpaController(managerPrestaShop).edit(ocr);

                    List<PsCartRule> listCartRule = queryPrestaShop.listCartRule(ocr.getIdCartRule());
                    for (PsCartRule cr : listCartRule) {
                        cr.setDateTo(format.alteraDiaData(format.dataAtual(), 2));
                        cr.setDescription(String.valueOf(psOrders.getIdOrder()));
                        cr.setReductionAmount(valDescontoAvulso);
                        cr.setDateUpd(format.dataAtual());
                        new PsCartRuleJpaController(managerPrestaShop).edit(cr);
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao editar PsOrderCartRule \n" + ex);
                }
            }
        }
        psOrders.setTotalDiscounts(valDescontoAvulso);
        psOrders.setTotalDiscountsTaxExcl(valDescontoAvulso);
        psOrders.setTotalDiscountsTaxIncl(valDescontoAvulso);

        psOrders.setTotalPaid(psOrders.getTotalPaid().subtract(valDescontoAvulso));
        psOrders.setTotalPaidTaxIncl(psOrders.getTotalPaidTaxIncl().subtract(valDescontoAvulso));
        psOrders.setTotalPaidTaxExcl(psOrders.getTotalPaidTaxExcl().subtract(valDescontoAvulso));

        try {
            new PsOrdersJpaController(managerPrestaShop).edit(psOrders);
            editaOrders();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao editar PsOrders \n" + ex);
        }
    }

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
                    JOptionPane.showMessageDialog(null, "O cliente n�o possui numero documento v�lido\n VERIFIQUE!!!");
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

    private void pesquisaDataCustomerUpdete() {
        psCustomerList.clear();
        for (PsCustomer psCustomer : queryPrestaShop.listCustomerDataUpd(jDateChooserDataInicialCustomer.getDate(), jDateChooserDataFinalCustomer.getDate())) {
            psCustomerList.add(psCustomer);
        }
    }

    private void pesquisaDataCustomerCreate() {
        psCustomerList.clear();
        for (PsCustomer psCustomer : queryPrestaShop.listCustomerDataAdd(jDateChooserDataInicialCustomer.getDate(), jDateChooserDataFinalCustomer.getDate())) {
            psCustomerList.add(psCustomer);
        }
    }

    private void pesquisaPorEmail() {
        psCustomerList.clear();
        for (PsCustomer cliMagento : queryPrestaShop.listClienteEmail(jTextFieldPesquisaCustomer.getText())) {
            psCustomerList.add(cliMagento);
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
        }//if que verifica se est� em execu��o
    }

    private void carregaCampos() {
        PsCustomer psCustomer = new PsCustomerJpaController(managerPrestaShop).findPsCustomer(psOrders.getIdCustomer());
        jTextFieldEmail.setText(psCustomer.getEmail());
        jTextFieldTotalProdutos.setText(format.bigDecimalParaString(psOrders.getTotalProducts(), 2));
        jTextFieldNome.setText(psCustomer.getFirstname() + " " + psCustomer.getLastname());

        for (PsAddress psAddress : queryPrestaShop.listAddress(false, psCustomer.getIdCustomer())) {
            jTextFieldCpfCnpj.setText(format.mascaraCNPJouCPF(psAddress.getVatNumber()));
            jTextFieldRgIe.setText(psAddress.getDni());
        }
        for (PsOrderStateLang psOSL : queryPrestaShop.lisPsOrderStateLang(psOrders.getCurrentState(), 2)) {
            jTextFieldStatus.setText(psOSL.getName());
        }
        Connection conn = new ConexaoPrestaShop().getConnection();
        List<PsOrderCommission> lisyOrderCommissions = new ConexaoPrestaShop().listPsOrderCommission(conn, psOrders.getIdOrder());
        for (PsOrderCommission com : lisyOrderCommissions) {
            jTextFieldTaxa.setText(format.bigDecimalParaString(new BigDecimal(com.getCommissionTaxExcl()), 2));
            jTextFieldDesconto.setText(format.bigDecimalParaString(new BigDecimal(com.getDiscountTaxExcl()), 2));
        }
        new ConexaoPrestaShop().closeConnection();
        jTextFieldValorTotal.setText(format.bigDecimalParaString(psOrders.getTotalPaidTaxIncl(), 2));
        jComboBoxPagamento.setSelectedItem(psOrders.getPayment());

        if (null != psOrders.getModule()) {
            switch (psOrders.getModule()) {
                case "custompaymentmethod_1":
                    jComboBoxPagamento.setSelectedIndex(1);
                    break;
                case "custompaymentmethod_3":
                    jComboBoxPagamento.setSelectedIndex(2);
                    break;
                case "custompaymentmethod_4":
                    jComboBoxPagamento.setSelectedIndex(3);
                    break;
                case "custompaymentmethod_5":
                    jComboBoxPagamento.setSelectedIndex(4);
                    break;
                case "custompaymentmethod_6":
                    jComboBoxPagamento.setSelectedIndex(5);
                    break;
            }
        }

        switch (psOrders.getIdCarrier()) {
            case 19:
                jComboBoxShipping.setSelectedIndex(1);
                break;
            case 32:
                jComboBoxShipping.setSelectedIndex(2);
                break;

        }

        switch (psOrders.getCurrentState()) {
            case 1:
                jComboBoxState.setSelectedIndex(1);
                break;
            case 2:
                jComboBoxState.setSelectedIndex(2);
                break;
            case 3:
                jComboBoxState.setSelectedIndex(3);
                break;
            case 4:
                jComboBoxState.setSelectedIndex(4);
                break;
            case 5:
                jComboBoxState.setSelectedIndex(5);
                break;
            case 6:
                jComboBoxState.setSelectedIndex(6);
                break;
            case 7:
                jComboBoxState.setSelectedIndex(7);
                break;
            case 8:
                jComboBoxState.setSelectedIndex(8);
                break;
            case 9:
                jComboBoxState.setSelectedIndex(9);
                break;
            case 10:
                jComboBoxState.setSelectedIndex(10);
                break;
            case 11:
                jComboBoxState.setSelectedIndex(11);
                break;
            case 12:
                jComboBoxState.setSelectedIndex(12);
                break;
            case 13:
                jComboBoxState.setSelectedIndex(13);
                break;
        }
        jButtonAtualizaCliente.setEnabled(true);
        jButtonEditar.setEnabled(false);
        jButtonRemover.setEnabled(false);
        jButtonDescontoAvulso.setEnabled(true);
        if (psOrders.getCurrentState() != 6) {
            jButtonCancelarOrders.setEnabled(true);
        }
        psOrderDetailList.clear();
        for (PsOrderDetail orDetail : queryPrestaShop.listPsOrderDetail(psOrders.getIdOrder())) {
            psOrderDetailList.add(orDetail);
        }
        jTextFieldDescontoAvulso.setText(format.bigDecimalParaString(psOrders.getTotalDiscountsTaxIncl(), 2));
        jTextFieldValorFrete.setText(format.bigDecimalParaString(psOrders.getTotalShippingTaxIncl(), 2));
        carregaTabelaOrderDetail();
    }

    private void carregaTabelaCustomer() {
        DefaultTableModel tab = (DefaultTableModel) jTableCustomer.getModel();      
        while (jTableCustomer.getModel().getRowCount() > 0) {
            ((DefaultTableModel) jTableCustomer.getModel()).removeRow(0);
        }
        for (PsCustomer e : psCustomerList) {
            //"Nome", "E-Mail", "Empresa", "CPF/CNPJ", "Data Atual.", 
            //"Data Add", "Ativo", "Nota", "Limite cr�dito", "Newsletter", 
            //"Id Group", "Id Customer"
            tab.addRow(new Object[]{nomeCliente(e.getIdCustomer()), e.getCompany(), e.getEmail(), format.mascaraCNPJouCPF(e.getSiret()), format.dataStringDataCompleta(e.getDateUpd(), 0),
                format.dataStringDataCompleta(e.getDateAdd(), 0), e.getActive(), e.getNote(), format.bigDecimalParaString(e.getOutstandingAllowAmount(), 2), e.getNewsletter(),
                e.getIdDefaultGroup(), e.getIdCustomer()});
        }
        TableCellRenderer renderer = new ColorirLinhaImpar();
        for (int c = 0; c < jTableCustomer.getColumnCount(); c++) {
            jTableCustomer.setDefaultRenderer(jTableCustomer.getColumnClass(c), renderer);
        }
    }

    private String nomeCliente(Integer idCustomer) {
        String nome = "";
        for (PsCustomer valor : queryPrestaShop.listCustomer(idCustomer)) {
            nome = valor.getFirstname() + " " + valor.getLastname();
        }
        return nome;
    }

    private void carregaTabelaOrderDetail() {
        DefaultTableModel tab = (DefaultTableModel) jTableOrderDetail.getModel();
        while (jTableOrderDetail.getModel().getRowCount() > 0) {
            ((DefaultTableModel) jTableOrderDetail.getModel()).removeRow(0);
        }
        for (PsOrderDetail e : psOrderDetailList) {
            //"EAN", "Produto Nome", "Quant", "Valor", 
            //"Val. Unit.", "Val. Total", "Desc. %", "Desc. Grupo", "Peso", "Reference",
            //"Id Order", "Id Order Detail"
            tab.addRow(new Object[]{e.getProductEan13(), e.getProductName(), e.getProductQuantity(), format.bigDecimalParaString(e.getOriginalProductPrice(), 2),
                format.bigDecimalParaString(e.getUnitPriceTaxIncl(), 2), format.bigDecimalParaString(e.getTotalPriceTaxIncl(), 2), format.bigDecimalParaPorcentagem(e.getReductionPercent()),
                format.bigDecimalParaPorcentagem(e.getGroupReduction()), e.getProductWeight(), e.getProductReference(), e.getIdOrder(), e.getIdOrderDetail()});
        }
  
    }

    private void limpaCampos() {
        jButtonImportarPedido.setEnabled(false);
        //jButtonAtualizaCliente.setEnabled(false);
        jButtonAlteraPagamento.setEnabled(false);
        jButtonAdicionar.setEnabled(false);
        jButtonAtualizaCliente.setEnabled(false);
        jTextFieldNome.setText("");
        jTextFieldCpfCnpj.setText("");
        jTextFieldRgIe.setText("");
        jTextFieldStatus.setText("");
        jTextFieldEmail.setText("");
        jTextFieldValorTotal.setText("0,00");
        jTextFieldDesconto.setText("0,00");
        jTextFieldTotalProdutos.setText("0.00");
        jTextFieldTaxa.setText("0,00");
        psCustomerList.clear();
        jButtonImportarCliente.setEnabled(false);
        jComboBoxPagamento.setSelectedIndex(0);
        jComboBoxState.setSelectedIndex(0);
        jComboBoxShipping.setSelectedIndex(0);
        psOrderDetailList.clear();
        jTextFieldDescontoAvulso.setText("0,00");
        jButtonDescontoAvulso.setEnabled(false);
        jButtonCancelarOrders.setEnabled(false);
        jTextFieldValorFrete.setText("0,00");
        while (jTableOrderDetail.getModel().getRowCount() > 0) {
            ((DefaultTableModel) jTableOrderDetail.getModel()).removeRow(0);
        }
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VendaDigimacroJFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new VendaDigimacroJFrame(managerIntegrador, managerPrestaShop, managerCplus, usuario).setVisible(true);
        });
    }

    static EntityManagerFactory managerPrestaShop;
    static EntityManagerFactory managerIntegrador;
    static EntityManagerFactory managerCplus;
    private final String codCaracteristicaCliente;
    private final FormataCampos format;
    private PsOrders psOrders;
    private final SaidasPrestaShopJDialog listagemSaidasMagentoJDialog;
    private final ListPsProductJDialog listPsProductJDialog;
    private final QueryPrestaShop queryPrestaShop;
    private final QueryCplus queryCplus;
    private final EditOrderDetailsJDialog editOrderDetailsJDialog;
    private final AdicionarOrderDetailJDialog adicionarOrderDetailJDialog;
    private static Usuario usuario;
    private final int colunaCustomerId;
    private final int colunaOrderDetail;
    private BigDecimal valDescontoAvulso;
    private final List<PsOrderDetail> psOrderDetailList;
    private final List<PsCustomer> psCustomerList;
    // private BigDecimal valorComissao;


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAdicionar;
    private javax.swing.JButton jButtonAlteraPagamento;
    private javax.swing.JButton jButtonAtualizaCliente;
    private javax.swing.JButton jButtonCancelarOrders;
    private javax.swing.JButton jButtonDescontoAvulso;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonImportarCliente;
    private javax.swing.JButton jButtonImportarPedido;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JButton jButtonPesquisarCustomer;
    private javax.swing.JButton jButtonProdutosComprados;
    private javax.swing.JButton jButtonRemover;
    private javax.swing.JButton jButtonShipping;
    private javax.swing.JComboBox<String> jComboBoxPagamento;
    private javax.swing.JComboBox jComboBoxShipping;
    private javax.swing.JComboBox jComboBoxState;
    private javax.swing.JComboBox jComboBoxTermoPesquisa;
    private com.toedter.calendar.JDateChooser jDateChooserDataFinalCustomer;
    private com.toedter.calendar.JDateChooser jDateChooserDataInicialCustomer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPaneVendasMagento;
    private javax.swing.JTable jTableCustomer;
    private javax.swing.JTable jTableOrderDetail;
    private javax.swing.JTextField jTextFieldCpfCnpj;
    private javax.swing.JTextField jTextFieldDesconto;
    private javax.swing.JTextField jTextFieldDescontoAvulso;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldPesquisaCustomer;
    private javax.swing.JTextField jTextFieldRgIe;
    private javax.swing.JTextField jTextFieldStatus;
    private javax.swing.JTextField jTextFieldTaxa;
    private javax.swing.JTextField jTextFieldTotalProdutos;
    private javax.swing.JTextField jTextFieldValorFrete;
    private javax.swing.JTextField jTextFieldValorTotal;
    // End of variables declaration//GEN-END:variables

}
