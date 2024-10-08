/*vers�o 1.100
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package janela.cplus;

import entidade.cplus.Auditoria;
import entidade.cplus.Calculoicmsestado;
import entidade.cplus.Campocustomvalor;
import entidade.cplus.Fornproduto;
import entidade.cplus.Localizacao;
import entidade.cplus.Movenda;
import entidade.cplus.Movendaprod;
import entidade.cplus.Moventrada;
import entidade.cplus.Moventradaprod;
import entidade.cplus.Produto;
import entidade.cplus.Produtocaracteristica;
import entidade.cplus.Produtocodigo;
import entidade.cplus.Produtoestoque;
import entidade.cplus.Produtopreco;
import entidade.integrador.IntLogs;
import entidade.integrador.ProdFornecedor;
import entidade.prestaShop.PsProduct;
import integrador.render.RenderNomeFornecedor;
import integrador.render.RenderNumeroInteiro;
import integrador.render.RenderPorcentagem;
import integrador.render.produto.RenderAllAtivo;
import integrador.render.produto.RenderAllDisponivel;
import integrador.render.produto.RenderCodigoEan;
import integrador.render.produto.RenderEstoqueAtual;
import integrador.render.produto.RenderEstoqueDisponivel;
import integrador.render.produto.RenderEstoqueReservaOrcamento;
import integrador.render.produto.RenderEstoqueReservaOs;
import integrador.render.produto.RenderLocalizacao;
import integrador.render.produto.RenderMargemVenda;
import integrador.separacao.ColorirLinhaImpar;
import java.awt.Color;
import java.awt.Toolkit;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.swing.JOptionPane;
import javax.swing.table.TableCellRenderer;
import jpa.cplus.AuditoriaJpaController;
import jpa.cplus.CampocustommasterJpaController;
import jpa.cplus.CampocustomvalorJpaController;
import jpa.cplus.ProdutoJpaController;
import jpa.cplus.ProdutocaracteristicaJpaController;
import jpa.cplus.ProdutoprecoJpaController;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.integrador.IntLogsJpaController;
import jpa.integrador.ProdFornecedorJpaController;
import produto.PedidoCompra;
import query.cplus.QueryCplus;
import query.integrador.QueryIntegrador;
import query.prestaShop.QueryPrestaShop;
//import jpa.integracao.ConfiguracaoJpaController;
//import jpa.integracao.LogsDeExecucaoJpaController;
//import jpa.integracao.ProdutoIntegracaoJpaController;
//import jpa.integracao.ProdutosAllnationsJpaController;

/**
 *
 * @author leonardo
 */
public class ProdutoJFrame extends javax.swing.JFrame {

    /**
     * Creates new form AlteracaoPrecoProdutoJFrame
     *
     * @param managerCplus1
     * @param managerIntegracao1
     * @param managerPrestaShop1
     */
    public ProdutoJFrame(EntityManagerFactory managerCplus1, EntityManagerFactory managerIntegracao1, EntityManagerFactory managerPrestaShop1) {
        formataCampo = new FormataCampos();
        managerIntegrador = managerIntegracao1;
        managerPrestaShop = managerPrestaShop1;
        managerCplus = managerCplus1;
        queryCplus = new QueryCplus(managerCplus);
        queryPrestaShop = new QueryPrestaShop(managerPrestaShop);
        queryIntegrador = new QueryIntegrador(managerIntegrador);
        initComponents();
        jTextFieldTermoPesquisa.requestFocus();
        if (jRadioButtonDuasDecimais.isSelected()) {
            casasDecimais = 2;
        } else if (jRadioButtonUmaDecimal.isSelected()) {
            casasDecimais = 1;
        } else if (jRadioButtonTresDecimais.isSelected()) {
            casasDecimais = 3;
        } else {
            casasDecimais = 4;
        }
        colunaCodprod = jTableListagemProdutos.getColumnModel().getColumnIndex("Codprod");
        colunaProdutoFornecedor = jTableProdutoFornecedor.getColumnModel().getColumnIndex("Id Produtos");
        //colunaCodigo = jTableListagemProdutos.getColumnModel().getColumnIndex("Codigo");
        // colunaCodmoventradaprod = jTableListagemEntradas.getColumnModel().getColumnIndex("Codmoveprod");
        jTextFieldMaximoResultadosSaida.setText(queryIntegrador.valorConfiguracao("maximo_resultados_listagem_saidas"));
        //jTextFieldMaximoDeResultadosEntradas.setText(queryIntegrador.valorConfiguracao("maximo_resultados_listagem_entradas"));
        this.listagemEntradasJDialog = new ListagemEntradasJDialog(this, true, managerCplus);
        jTextFieldNomeCplus.setDocument(new LimiteDigitos(50));//limite de digitos no campo
        jTextFieldNomeSite.setDocument(new LimiteDigitos(100));//limite digitos no campo
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icones/logo.png")));
        decimaisArredondamento = Integer.valueOf(queryIntegrador.valorConfiguracao("casas_decimais_ARREDONDAMENTO"));
        //new RenderLocalizacao(managerCplus);
        this.listagemLocalizacaoJDialog = new ListagemLocalizacaoJDialog(this, true, managerCplus);
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

        cplusPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("cplusPU").createEntityManager();
        produtoQuery = java.beans.Beans.isDesignTime() ? null : cplusPUEntityManager.createQuery("SELECT p FROM Produto p where p.codprod ='888888'");
        produtoList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(new java.util.LinkedList(produtoQuery.getResultList()));
        integradorPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("integradorPU").createEntityManager();
        produtoFornecedorQuery = java.beans.Beans.isDesignTime() ? null : integradorPUEntityManager.createQuery("SELECT p FROM ProdFornecedor p WHERE p.ean = '88888888'");
        produtoFornecedorList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(new java.util.LinkedList(produtoFornecedorQuery.getResultList()));
        buttonGroupComparaPreco = new javax.swing.ButtonGroup();
        buttonGroupCasasDecimais = new javax.swing.ButtonGroup();
        buttonGroupCustoProduto = new javax.swing.ButtonGroup();
        buttonGroupTiposDeMargem = new javax.swing.ButtonGroup();
        buttonGroupArredondamentoPrecoVenda = new javax.swing.ButtonGroup();
        movendaprodQuery = java.beans.Beans.isDesignTime() ? null : cplusPUEntityManager.createQuery("SELECT m FROM Movendaprod m where m.codmovprod =\"999999\"");
        movendaprodList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(new java.util.LinkedList(movendaprodQuery.getResultList()));
        moventradaprodQuery = java.beans.Beans.isDesignTime() ? null : cplusPUEntityManager.createQuery("SELECT prod FROM Moventradaprod prod WHERE prod.codmoventr.codmoventr =\"009999999\"");
        moventradaprodList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(moventradaprodQuery.getResultList());
        jTabbedPaneAlteracaoPrecoProdutoCplus = new javax.swing.JTabbedPane();
        jPanelAbaListaProdutos = new javax.swing.JPanel();
        jScrollPaneListagemProdutos = new javax.swing.JScrollPane();
        jTableListagemProdutos = new javax.swing.JTable();
        jPanelComparacaoProdutosAllnations = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableProdutoFornecedor = new javax.swing.JTable();
        jPanelControleFornecedor = new javax.swing.JPanel();
        jButtonRelacionarProdutoFornecedor = new javax.swing.JButton();
        jButtonAtivarNoSite = new javax.swing.JButton();
        jButtonDesativarSite = new javax.swing.JButton();
        jButtonExcluirregistroFornecedor = new javax.swing.JButton();
        jPanelconfiguracoesAba = new javax.swing.JPanel();
        jPanelCasasDecimais = new javax.swing.JPanel();
        jRadioButtonDuasDecimais = new javax.swing.JRadioButton();
        jRadioButtonUmaDecimal = new javax.swing.JRadioButton();
        jRadioButtonTresDecimais = new javax.swing.JRadioButton();
        jRadioButtonQuatroDecimais = new javax.swing.JRadioButton();
        jRadioButtonCustoUltimaCompra = new javax.swing.JRadioButton();
        jRadioButtonCustoSystema = new javax.swing.JRadioButton();
        jPanelTiposdecalculos = new javax.swing.JPanel();
        jRadioButtonMargemCustoCplus = new javax.swing.JRadioButton();
        jRadioButtonMargemSobreCustoMedioCplus = new javax.swing.JRadioButton();
        jRadioButtonMargemSobreCustoUltimaCompra = new javax.swing.JRadioButton();
        jPanelInformacaoEstoque = new javax.swing.JPanel();
        jCheckBoxMostrarItensCarrinhoMagento = new javax.swing.JCheckBox();
        jPanelListagemDeVendas = new javax.swing.JPanel();
        jButtonAtualizaListagemSaidas = new javax.swing.JButton();
        jTextFieldMaximoResultadosSaida = new javax.swing.JTextField();
        jLabelMaximoDeResultadosSaida = new javax.swing.JLabel();
        jCheckBoxSomenteVendas = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableListagemDeVendas = new javax.swing.JTable();
        jPanelListagemEntradas = new javax.swing.JPanel();
        jButtonAtualizaListagemEntradas = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jCheckBoxSomenteCompras = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldMaximoResultadoEntrada = new javax.swing.JTextField();
        jPanelControles = new javax.swing.JPanel();
        jPanelEstoque = new javax.swing.JPanel();
        jTextFieldEstoqueAtual = new javax.swing.JTextField();
        jTextFieldReservaOrcamento = new javax.swing.JTextField();
        jTextFieldReservaOs = new javax.swing.JTextField();
        jTextFieldEstoqueDisponivel = new javax.swing.JTextField();
        jLabelEstoqueAtual = new javax.swing.JLabel();
        jLabelReservasOrcemento = new javax.swing.JLabel();
        jLabelReservasOs = new javax.swing.JLabel();
        jLabelEstoqueDisponivel = new javax.swing.JLabel();
        jPanelCustos = new javax.swing.JPanel();
        jLabelPrecoCusto = new javax.swing.JLabel();
        jLabelCustoReal = new javax.swing.JLabel();
        jLabelValorIpi = new javax.swing.JLabel();
        jLabelValorSt = new javax.swing.JLabel();
        jLabelValorOutrasDespesas = new javax.swing.JLabel();
        jLabelValorOutrosCustos = new javax.swing.JLabel();
        jLabelPrecoPutrosCustos = new javax.swing.JLabel();
        jLabelCustoMedio = new javax.swing.JLabel();
        jTextFieldPrecoCusto = new javax.swing.JTextField();
        jTextFieldCustoReal = new javax.swing.JTextField();
        jTextFieldValorIpi = new javax.swing.JTextField();
        jTextFieldValorSubstituicaoTributaria = new javax.swing.JTextField();
        jTextFieldValorOutrasDes = new javax.swing.JTextField();
        jTextFieldValorOutrosCustos = new javax.swing.JTextField();
        jTextFieldPercOutrosCustos = new javax.swing.JTextField();
        jTextFieldCustoMedio = new javax.swing.JTextField();
        jLabelTotalOutrosCustos = new javax.swing.JLabel();
        jTextFieldTotalOutrasDespesas = new javax.swing.JTextField();
        jPanelPesquisa = new javax.swing.JPanel();
        jComboBoxTermoPesquisa = new javax.swing.JComboBox();
        jTextFieldTermoPesquisa = new javax.swing.JTextField();
        jButtonPesquisar = new javax.swing.JButton();
        jCheckBoxSomenteItensAtivosCplus = new javax.swing.JCheckBox();
        jButtonAtualizarCarregaCampos = new javax.swing.JButton();
        jPanelPreco = new javax.swing.JPanel();
        jTextFieldMargemNormal = new javax.swing.JTextField();
        jLabelMargemNormal = new javax.swing.JLabel();
        jTextFieldPrecoNormal = new javax.swing.JTextField();
        jLabelPrecoNormal = new javax.swing.JLabel();
        jButtonGravar = new javax.swing.JButton();
        jButtonAtualizaMargemCusto = new javax.swing.JButton();
        jPanelOutros = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldNomeCplus = new javax.swing.JTextField();
        jTextFieldNomeSite = new javax.swing.JTextField();
        jLabelFornecedor = new javax.swing.JLabel();
        jTextFieldFornecedor = new javax.swing.JTextField();
        jLabelPartNumberSistema = new javax.swing.JLabel();
        jTextFieldPartNumberSistema = new javax.swing.JTextField();
        jLabelComplementoFiscal = new javax.swing.JLabel();
        jLabelCodigoInterno = new javax.swing.JLabel();
        jTextFieldCodigoInterno = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabelAltura = new javax.swing.JLabel();
        jTextFieldAltura = new javax.swing.JTextField();
        jLabelLargura = new javax.swing.JLabel();
        jTextFieldLargura = new javax.swing.JTextField();
        jLabelComprimento = new javax.swing.JLabel();
        jTextFieldComprimento = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldUnidade = new javax.swing.JTextField();
        jLabelOrigemProduto = new javax.swing.JLabel();
        jComboBoxOrigemProduto = new javax.swing.JComboBox();
        jTextFieldComplementoFiscal = new javax.swing.JTextField();
        jLabelSetor = new javax.swing.JLabel();
        jTextFieldSetor = new javax.swing.JTextField();
        jPanelDataMovimento = new javax.swing.JPanel();
        jLabelDataultimaCompra = new javax.swing.JLabel();
        jTextFieldDataUltimaCompra = new javax.swing.JTextField();
        jLabelDataUltimaVenda = new javax.swing.JLabel();
        jTextFieldDataUltimaVenda = new javax.swing.JTextField();
        jLabelDataUltimoReajuste = new javax.swing.JLabel();
        jTextFieldDataUltimoReajuste = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldUltimaQuantidadeComprada = new javax.swing.JTextField();
        jPanelArredondamentoVenda = new javax.swing.JPanel();
        jRadioButtonArredondamentoUmDecimal = new javax.swing.JRadioButton();
        jRadioButtonArredondamentoDoisDecimal = new javax.swing.JRadioButton();
        jRadioButtonArredondamentoTresDecimal = new javax.swing.JRadioButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextAreaEan = new javax.swing.JTextArea();
        jCheckBoxAtivo = new javax.swing.JCheckBox();
        jCheckBoxNoSite = new javax.swing.JCheckBox();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextAreaProdutoComprado = new javax.swing.JTextArea();
        jButtonEditarSetorEstoque = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Altera��o de Pre�o ");

        jTableListagemProdutos.setAutoCreateRowSorter(true);
        jTableListagemProdutos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTableListagemProdutos.setColumnSelectionAllowed(true);
        jTableListagemProdutos.setFocusable(false);
        jTableListagemProdutos.setRowHeight(25);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, produtoList, jTableListagemProdutos);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${lastChange}"));
        columnBinding.setColumnName("Ultima Atualiza��o");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${datreaj}"));
        columnBinding.setColumnName("Data Reajuste");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codigo}"));
        columnBinding.setColumnName("Codigo");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nomeprodweb}"));
        columnBinding.setColumnName("Nome Site");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${produtoprecoCollection}"));
        columnBinding.setColumnName("Pre�o Normal");
        columnBinding.setColumnClass(java.util.Collection.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${produtoprecoCollection}"));
        columnBinding.setColumnName("Margem");
        columnBinding.setColumnClass(java.util.Collection.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${produtoestoqueCollection}"));
        columnBinding.setColumnName("Estoque Dispon�vel");
        columnBinding.setColumnClass(java.util.Collection.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codloc}"));
        columnBinding.setColumnName("Localiza��o");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nomeprod}"));
        columnBinding.setColumnName("Nome C-plus");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${totoutroscustos}"));
        columnBinding.setColumnName("Total Outros Custos");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${valoutroscustos}"));
        columnBinding.setColumnName("val. Outros Custos");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${custoreal}"));
        columnBinding.setColumnName("Custo Real");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${customedio}"));
        columnBinding.setColumnName("Custo M�dio");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${precusto}"));
        columnBinding.setColumnName("Pre�o Custo");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${produtoestoqueCollection}"));
        columnBinding.setColumnName("Estoque Atual");
        columnBinding.setColumnClass(java.util.Collection.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${produtoestoqueCollection}"));
        columnBinding.setColumnName("Reser. O.S");
        columnBinding.setColumnClass(java.util.Collection.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${produtoestoqueCollection}"));
        columnBinding.setColumnName("Reser. Or�amento");
        columnBinding.setColumnClass(java.util.Collection.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nomeprod}"));
        columnBinding.setColumnName("Nome C-Plus");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codprod}"));
        columnBinding.setColumnName("Codprod");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${produtocodigoCollection}"));
        columnBinding.setColumnName("EAN");
        columnBinding.setColumnClass(java.util.Collection.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jTableListagemProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableListagemProdutosMouseClicked(evt);
            }
        });
        jScrollPaneListagemProdutos.setViewportView(jTableListagemProdutos);
        jTableListagemProdutos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTableListagemProdutos.getColumnModel().getColumnCount() > 0) {
            jTableListagemProdutos.getColumnModel().getColumn(0).setPreferredWidth(80);
            jTableListagemProdutos.getColumnModel().getColumn(1).setPreferredWidth(80);
            jTableListagemProdutos.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTableListagemProdutos.getColumnModel().getColumn(3).setPreferredWidth(350);
            jTableListagemProdutos.getColumnModel().getColumn(4).setCellRenderer(new integrador.render.produto.RenderPrecoVenda());
            jTableListagemProdutos.getColumnModel().getColumn(5).setMinWidth(70);
            jTableListagemProdutos.getColumnModel().getColumn(5).setPreferredWidth(70);
            jTableListagemProdutos.getColumnModel().getColumn(5).setMaxWidth(200);
            jTableListagemProdutos.getColumnModel().getColumn(5).setCellRenderer(new RenderMargemVenda());
            jTableListagemProdutos.getColumnModel().getColumn(6).setCellRenderer(new RenderEstoqueDisponivel());
            jTableListagemProdutos.getColumnModel().getColumn(7).setCellRenderer(new RenderLocalizacao(managerCplus));
            jTableListagemProdutos.getColumnModel().getColumn(8).setMinWidth(300);
            jTableListagemProdutos.getColumnModel().getColumn(8).setPreferredWidth(200);
            jTableListagemProdutos.getColumnModel().getColumn(8).setMaxWidth(500);
            jTableListagemProdutos.getColumnModel().getColumn(9).setCellRenderer(new integrador.render.RenderPreco());
            jTableListagemProdutos.getColumnModel().getColumn(10).setCellRenderer(new integrador.render.RenderPreco());
            jTableListagemProdutos.getColumnModel().getColumn(11).setCellRenderer(new integrador.render.RenderPreco());
            jTableListagemProdutos.getColumnModel().getColumn(12).setCellRenderer(new integrador.render.RenderPreco());
            jTableListagemProdutos.getColumnModel().getColumn(13).setCellRenderer(new integrador.render.RenderPreco());
            jTableListagemProdutos.getColumnModel().getColumn(14).setCellRenderer(new RenderEstoqueAtual());
            jTableListagemProdutos.getColumnModel().getColumn(15).setCellRenderer(new RenderEstoqueReservaOs());
            jTableListagemProdutos.getColumnModel().getColumn(16).setCellRenderer(new RenderEstoqueReservaOrcamento());
            jTableListagemProdutos.getColumnModel().getColumn(19).setPreferredWidth(90);
            jTableListagemProdutos.getColumnModel().getColumn(19).setCellRenderer(new RenderCodigoEan());
        }

        javax.swing.GroupLayout jPanelAbaListaProdutosLayout = new javax.swing.GroupLayout(jPanelAbaListaProdutos);
        jPanelAbaListaProdutos.setLayout(jPanelAbaListaProdutosLayout);
        jPanelAbaListaProdutosLayout.setHorizontalGroup(
            jPanelAbaListaProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPaneListagemProdutos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1375, Short.MAX_VALUE)
        );
        jPanelAbaListaProdutosLayout.setVerticalGroup(
            jPanelAbaListaProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPaneListagemProdutos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
        );

        jTabbedPaneAlteracaoPrecoProdutoCplus.addTab("Listagem Produtos C-Plus", jPanelAbaListaProdutos);

        jTableProdutoFornecedor.setAutoCreateRowSorter(true);
        jTableProdutoFornecedor.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTableProdutoFornecedor.getTableHeader().setReorderingAllowed(false);

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, produtoFornecedorList, jTableProdutoFornecedor);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idProdutos}"));
        columnBinding.setColumnName("Id Produtos");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${ean}"));
        columnBinding.setColumnName("EAN");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${descricao}"));
        columnBinding.setColumnName("Descricao");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${departamento}"));
        columnBinding.setColumnName("Fornecedor");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${disponivel}"));
        columnBinding.setColumnName("Disponivel");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${ativo}"));
        columnBinding.setColumnName("Ativo");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${ultimaImportacao}"));
        columnBinding.setColumnName("Ultima Importa��o");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${valorCustoRs}"));
        columnBinding.setColumnName("Valor Custo RS");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${precoCustoComSt}"));
        columnBinding.setColumnName("Custo Com ST");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${precoCusto}"));
        columnBinding.setColumnName("Custo Sem ST");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${estoque}"));
        columnBinding.setColumnName("Estoque");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${partNumber}"));
        columnBinding.setColumnName("Part Number");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${origemProduto}"));
        columnBinding.setColumnName("Origem Produto");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fabricante}"));
        columnBinding.setColumnName("Fabricante");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codigo}"));
        columnBinding.setColumnName("Codigo");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${ncm}"));
        columnBinding.setColumnName("Ncm");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${porcentagemOutrosCustos}"));
        columnBinding.setColumnName("Aliq. Outros Custos");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${porcentagemStRs}"));
        columnBinding.setColumnName("Aliq. ST RS");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${valorStRs}"));
        columnBinding.setColumnName("Valor ST RS");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jTableProdutoFornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProdutoFornecedorMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableProdutoFornecedor);
        if (jTableProdutoFornecedor.getColumnModel().getColumnCount() > 0) {
            jTableProdutoFornecedor.getColumnModel().getColumn(1).setPreferredWidth(90);
            jTableProdutoFornecedor.getColumnModel().getColumn(2).setPreferredWidth(350);
            jTableProdutoFornecedor.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTableProdutoFornecedor.getColumnModel().getColumn(4).setCellRenderer(new RenderAllDisponivel());
            jTableProdutoFornecedor.getColumnModel().getColumn(5).setCellRenderer(new RenderAllAtivo());
            jTableProdutoFornecedor.getColumnModel().getColumn(7).setCellRenderer(new integrador.render.RenderPreco());
            jTableProdutoFornecedor.getColumnModel().getColumn(8).setCellRenderer(new integrador.render.RenderPreco());
            jTableProdutoFornecedor.getColumnModel().getColumn(9).setCellRenderer(new integrador.render.RenderPreco());
            jTableProdutoFornecedor.getColumnModel().getColumn(11).setPreferredWidth(90);
            jTableProdutoFornecedor.getColumnModel().getColumn(15).setPreferredWidth(90);
            jTableProdutoFornecedor.getColumnModel().getColumn(18).setCellRenderer(new integrador.render.RenderPreco());
        }

        jButtonRelacionarProdutoFornecedor.setText("Relacionar Produto Com Fornecedor");
        jButtonRelacionarProdutoFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRelacionarProdutoFornecedorActionPerformed(evt);
            }
        });

        jButtonAtivarNoSite.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jButtonAtivarNoSite.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/play.png"))); // NOI18N
        jButtonAtivarNoSite.setText("Ativar no Site");
        jButtonAtivarNoSite.setEnabled(false);
        jButtonAtivarNoSite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtivarNoSiteActionPerformed(evt);
            }
        });

        jButtonDesativarSite.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jButtonDesativarSite.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/stop.png"))); // NOI18N
        jButtonDesativarSite.setText("Desativar no Site");
        jButtonDesativarSite.setEnabled(false);
        jButtonDesativarSite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDesativarSiteActionPerformed(evt);
            }
        });

        jButtonExcluirregistroFornecedor.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jButtonExcluirregistroFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/delete.png"))); // NOI18N
        jButtonExcluirregistroFornecedor.setText("Excluir Registro");
        jButtonExcluirregistroFornecedor.setEnabled(false);
        jButtonExcluirregistroFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirregistroFornecedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelControleFornecedorLayout = new javax.swing.GroupLayout(jPanelControleFornecedor);
        jPanelControleFornecedor.setLayout(jPanelControleFornecedorLayout);
        jPanelControleFornecedorLayout.setHorizontalGroup(
            jPanelControleFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelControleFornecedorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonRelacionarProdutoFornecedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 461, Short.MAX_VALUE)
                .addComponent(jButtonAtivarNoSite)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonDesativarSite)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonExcluirregistroFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelControleFornecedorLayout.setVerticalGroup(
            jPanelControleFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelControleFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButtonRelacionarProdutoFornecedor)
                .addComponent(jButtonAtivarNoSite)
                .addComponent(jButtonDesativarSite)
                .addComponent(jButtonExcluirregistroFornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelComparacaoProdutosAllnationsLayout = new javax.swing.GroupLayout(jPanelComparacaoProdutosAllnations);
        jPanelComparacaoProdutosAllnations.setLayout(jPanelComparacaoProdutosAllnationsLayout);
        jPanelComparacaoProdutosAllnationsLayout.setHorizontalGroup(
            jPanelComparacaoProdutosAllnationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelComparacaoProdutosAllnationsLayout.createSequentialGroup()
                .addComponent(jPanelControleFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelComparacaoProdutosAllnationsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2))
        );
        jPanelComparacaoProdutosAllnationsLayout.setVerticalGroup(
            jPanelComparacaoProdutosAllnationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelComparacaoProdutosAllnationsLayout.createSequentialGroup()
                .addComponent(jPanelControleFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPaneAlteracaoPrecoProdutoCplus.addTab("Rela��o Pre�os Fornecedores", jPanelComparacaoProdutosAllnations);

        jPanelCasasDecimais.setBorder(javax.swing.BorderFactory.createTitledBorder("Padr�es"));

        buttonGroupCasasDecimais.add(jRadioButtonDuasDecimais);
        jRadioButtonDuasDecimais.setSelected(true);
        jRadioButtonDuasDecimais.setText("Duas (0,00)");

        buttonGroupCasasDecimais.add(jRadioButtonUmaDecimal);
        jRadioButtonUmaDecimal.setText("Uma (0,0)");

        buttonGroupCasasDecimais.add(jRadioButtonTresDecimais);
        jRadioButtonTresDecimais.setText("Tr�s (0,000)");

        buttonGroupCasasDecimais.add(jRadioButtonQuatroDecimais);
        jRadioButtonQuatroDecimais.setText("Quatro (0,0000)");

        buttonGroupCustoProduto.add(jRadioButtonCustoUltimaCompra);
        jRadioButtonCustoUltimaCompra.setText("Custos Ulima Compra");

        buttonGroupCustoProduto.add(jRadioButtonCustoSystema);
        jRadioButtonCustoSystema.setSelected(true);
        jRadioButtonCustoSystema.setText("Custos Sistema");

        javax.swing.GroupLayout jPanelCasasDecimaisLayout = new javax.swing.GroupLayout(jPanelCasasDecimais);
        jPanelCasasDecimais.setLayout(jPanelCasasDecimaisLayout);
        jPanelCasasDecimaisLayout.setHorizontalGroup(
            jPanelCasasDecimaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jRadioButtonQuatroDecimais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jRadioButtonTresDecimais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jRadioButtonDuasDecimais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jRadioButtonUmaDecimal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jRadioButtonCustoUltimaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jRadioButtonCustoSystema, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelCasasDecimaisLayout.setVerticalGroup(
            jPanelCasasDecimaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCasasDecimaisLayout.createSequentialGroup()
                .addComponent(jRadioButtonUmaDecimal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonDuasDecimais)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonTresDecimais)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonQuatroDecimais)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonCustoUltimaCompra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButtonCustoSystema)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanelTiposdecalculos.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipos de Margem"));

        buttonGroupTiposDeMargem.add(jRadioButtonMargemCustoCplus);
        jRadioButtonMargemCustoCplus.setSelected(true);
        jRadioButtonMargemCustoCplus.setText("Margem sobre custo C-Plus");

        buttonGroupTiposDeMargem.add(jRadioButtonMargemSobreCustoMedioCplus);
        jRadioButtonMargemSobreCustoMedioCplus.setText("Margem sobre custo m�dio C-Plus");

        buttonGroupTiposDeMargem.add(jRadioButtonMargemSobreCustoUltimaCompra);
        jRadioButtonMargemSobreCustoUltimaCompra.setText("Margem sobre custo Ultima Compra");

        javax.swing.GroupLayout jPanelTiposdecalculosLayout = new javax.swing.GroupLayout(jPanelTiposdecalculos);
        jPanelTiposdecalculos.setLayout(jPanelTiposdecalculosLayout);
        jPanelTiposdecalculosLayout.setHorizontalGroup(
            jPanelTiposdecalculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTiposdecalculosLayout.createSequentialGroup()
                .addGroup(jPanelTiposdecalculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButtonMargemCustoCplus)
                    .addComponent(jRadioButtonMargemSobreCustoMedioCplus)
                    .addComponent(jRadioButtonMargemSobreCustoUltimaCompra))
                .addGap(0, 10, Short.MAX_VALUE))
        );
        jPanelTiposdecalculosLayout.setVerticalGroup(
            jPanelTiposdecalculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTiposdecalculosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButtonMargemCustoCplus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonMargemSobreCustoMedioCplus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonMargemSobreCustoUltimaCompra)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelInformacaoEstoque.setBorder(javax.swing.BorderFactory.createTitledBorder("Informa��o de Estoque"));

        jCheckBoxMostrarItensCarrinhoMagento.setSelected(true);
        jCheckBoxMostrarItensCarrinhoMagento.setText("Mostrar Itens Carrinho Magento");

        javax.swing.GroupLayout jPanelInformacaoEstoqueLayout = new javax.swing.GroupLayout(jPanelInformacaoEstoque);
        jPanelInformacaoEstoque.setLayout(jPanelInformacaoEstoqueLayout);
        jPanelInformacaoEstoqueLayout.setHorizontalGroup(
            jPanelInformacaoEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInformacaoEstoqueLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckBoxMostrarItensCarrinhoMagento, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(146, Short.MAX_VALUE))
        );
        jPanelInformacaoEstoqueLayout.setVerticalGroup(
            jPanelInformacaoEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInformacaoEstoqueLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckBoxMostrarItensCarrinhoMagento)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelconfiguracoesAbaLayout = new javax.swing.GroupLayout(jPanelconfiguracoesAba);
        jPanelconfiguracoesAba.setLayout(jPanelconfiguracoesAbaLayout);
        jPanelconfiguracoesAbaLayout.setHorizontalGroup(
            jPanelconfiguracoesAbaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelconfiguracoesAbaLayout.createSequentialGroup()
                .addGap(223, 223, 223)
                .addComponent(jPanelCasasDecimais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelTiposdecalculos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelInformacaoEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 306, Short.MAX_VALUE))
        );
        jPanelconfiguracoesAbaLayout.setVerticalGroup(
            jPanelconfiguracoesAbaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelconfiguracoesAbaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelconfiguracoesAbaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelCasasDecimais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelconfiguracoesAbaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPanelInformacaoEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanelTiposdecalculos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPaneAlteracaoPrecoProdutoCplus.addTab("Configura��es De Calculos", jPanelconfiguracoesAba);

        jButtonAtualizaListagemSaidas.setText("Atualiza Listagem de Saidas");
        jButtonAtualizaListagemSaidas.setEnabled(false);
        jButtonAtualizaListagemSaidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtualizaListagemSaidasActionPerformed(evt);
            }
        });

        jLabelMaximoDeResultadosSaida.setText("M�ximo de resultados:");

        jCheckBoxSomenteVendas.setSelected(true);
        jCheckBoxSomenteVendas.setText("Somente Vendas:");

        jTableListagemDeVendas.setAutoCreateRowSorter(true);
        jTableListagemDeVendas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTableListagemDeVendas.setColumnSelectionAllowed(true);
        jTableListagemDeVendas.getTableHeader().setReorderingAllowed(false);

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, movendaprodList, jTableListagemDeVendas);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codmovenda.data}"));
        columnBinding.setColumnName("Data");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codmovenda.hora}"));
        columnBinding.setColumnName("Hora");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${quantidade}"));
        columnBinding.setColumnName("Quantidade");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codmovenda.codcli.nomecli}"));
        columnBinding.setColumnName("Cliente");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codmovenda.codcli.cnpj}"));
        columnBinding.setColumnName("CNPJ");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codmovenda.codcli.cidade}"));
        columnBinding.setColumnName("Cidade");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codmovenda.numnota}"));
        columnBinding.setColumnName("N�mero Nota");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codmovenda.numped}"));
        columnBinding.setColumnName("N�mero Pedido");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${valorunitario}"));
        columnBinding.setColumnName("Valor Unit�rio");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${valortotal}"));
        columnBinding.setColumnName("Valor Total");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${customedio}"));
        columnBinding.setColumnName("Custo M�dio");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${custoreal}"));
        columnBinding.setColumnName("Custo Real");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${valorcofins}"));
        columnBinding.setColumnName("Valor COFINS");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${aliqcofins}"));
        columnBinding.setColumnName("Aliq. COFINS");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${basecofins}"));
        columnBinding.setColumnName("Base Cofins");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${aliqpis}"));
        columnBinding.setColumnName("Aliq. Pis");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${basepis}"));
        columnBinding.setColumnName("Base Pis");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${quantidadedevolvida}"));
        columnBinding.setColumnName("Qua. Devolvida");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${aliqicms}"));
        columnBinding.setColumnName("Aliq Icms");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${baseicms}"));
        columnBinding.setColumnName("Base Icms");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${valorsubsttributaria}"));
        columnBinding.setColumnName("Valor ST");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${valoricms}"));
        columnBinding.setColumnName("Valor Icms");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${basesubsttributaria}"));
        columnBinding.setColumnName("Base ST");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(jTableListagemDeVendas);
        jTableListagemDeVendas.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTableListagemDeVendas.getColumnModel().getColumnCount() > 0) {
            jTableListagemDeVendas.getColumnModel().getColumn(1).setCellRenderer(new integrador.render.RenderHora());
            jTableListagemDeVendas.getColumnModel().getColumn(2).setCellRenderer(new RenderNumeroInteiro());
            jTableListagemDeVendas.getColumnModel().getColumn(3).setPreferredWidth(250);
            jTableListagemDeVendas.getColumnModel().getColumn(4).setPreferredWidth(120);
            jTableListagemDeVendas.getColumnModel().getColumn(5).setPreferredWidth(120);
            jTableListagemDeVendas.getColumnModel().getColumn(8).setCellRenderer(new integrador.render.RenderPreco());
            jTableListagemDeVendas.getColumnModel().getColumn(9).setCellRenderer(new integrador.render.RenderPreco());
            jTableListagemDeVendas.getColumnModel().getColumn(10).setCellRenderer(new integrador.render.RenderPreco());
            jTableListagemDeVendas.getColumnModel().getColumn(11).setCellRenderer(new integrador.render.RenderPreco());
            jTableListagemDeVendas.getColumnModel().getColumn(12).setCellRenderer(new integrador.render.RenderPreco());
            jTableListagemDeVendas.getColumnModel().getColumn(13).setCellRenderer( new RenderPorcentagem());
            jTableListagemDeVendas.getColumnModel().getColumn(14).setCellRenderer(new integrador.render.RenderPreco());
            jTableListagemDeVendas.getColumnModel().getColumn(15).setCellRenderer( new RenderPorcentagem());
            jTableListagemDeVendas.getColumnModel().getColumn(16).setCellRenderer(new integrador.render.RenderPreco());
            jTableListagemDeVendas.getColumnModel().getColumn(17).setCellRenderer(new RenderNumeroInteiro());
            jTableListagemDeVendas.getColumnModel().getColumn(18).setCellRenderer( new RenderPorcentagem());
            jTableListagemDeVendas.getColumnModel().getColumn(19).setCellRenderer(new integrador.render.RenderPreco());
            jTableListagemDeVendas.getColumnModel().getColumn(20).setCellRenderer(new integrador.render.RenderPreco());
            jTableListagemDeVendas.getColumnModel().getColumn(21).setCellRenderer(new integrador.render.RenderPreco());
            jTableListagemDeVendas.getColumnModel().getColumn(22).setCellRenderer(new integrador.render.RenderPreco());
        }

        javax.swing.GroupLayout jPanelListagemDeVendasLayout = new javax.swing.GroupLayout(jPanelListagemDeVendas);
        jPanelListagemDeVendas.setLayout(jPanelListagemDeVendasLayout);
        jPanelListagemDeVendasLayout.setHorizontalGroup(
            jPanelListagemDeVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelListagemDeVendasLayout.createSequentialGroup()
                .addGroup(jPanelListagemDeVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelListagemDeVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButtonAtualizaListagemSaidas)
                        .addGroup(jPanelListagemDeVendasLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabelMaximoDeResultadosSaida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jTextFieldMaximoResultadosSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelListagemDeVendasLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jCheckBoxSomenteVendas)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1131, Short.MAX_VALUE))
        );
        jPanelListagemDeVendasLayout.setVerticalGroup(
            jPanelListagemDeVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelListagemDeVendasLayout.createSequentialGroup()
                .addComponent(jButtonAtualizaListagemSaidas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelListagemDeVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldMaximoResultadosSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMaximoDeResultadosSaida))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBoxSomenteVendas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jTabbedPaneAlteracaoPrecoProdutoCplus.addTab("Listagem de Vendas", jPanelListagemDeVendas);

        jButtonAtualizaListagemEntradas.setText("Atualiza Entradas");
        jButtonAtualizaListagemEntradas.setEnabled(false);
        jButtonAtualizaListagemEntradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtualizaListagemEntradasActionPerformed(evt);
            }
        });

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, moventradaprodList, jTable1);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codmoventr.data}"));
        columnBinding.setColumnName("Data");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${valorunitario}"));
        columnBinding.setColumnName("Valor Unitario");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${quantidade}"));
        columnBinding.setColumnName("Quantidade");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${complemento}"));
        columnBinding.setColumnName("Codigo Fornecedor");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${aliqicms}"));
        columnBinding.setColumnName("Aliq ICMS");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${aliqipi}"));
        columnBinding.setColumnName("Aliq IPI");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codmoventr.codForn.nomeforn}"));
        columnBinding.setColumnName("Fornecedor");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane3.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(60);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(60);
            jTable1.getColumnModel().getColumn(1).setCellRenderer(new integrador.render.RenderPreco());
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(40);
            jTable1.getColumnModel().getColumn(2).setCellRenderer(new RenderNumeroInteiro());
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(120);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(40);
            jTable1.getColumnModel().getColumn(4).setCellRenderer(new RenderPorcentagem());
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(40);
            jTable1.getColumnModel().getColumn(5).setCellRenderer(new RenderPorcentagem());
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(240);
        }

        jCheckBoxSomenteCompras.setSelected(true);
        jCheckBoxSomenteCompras.setText("Somente Compras");

        jLabel5.setText("Max. Resul.");

        jTextFieldMaximoResultadoEntrada.setText("20");

        javax.swing.GroupLayout jPanelListagemEntradasLayout = new javax.swing.GroupLayout(jPanelListagemEntradas);
        jPanelListagemEntradas.setLayout(jPanelListagemEntradasLayout);
        jPanelListagemEntradasLayout.setHorizontalGroup(
            jPanelListagemEntradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelListagemEntradasLayout.createSequentialGroup()
                .addGroup(jPanelListagemEntradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonAtualizaListagemEntradas)
                    .addGroup(jPanelListagemEntradasLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelListagemEntradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxSomenteCompras)
                            .addGroup(jPanelListagemEntradasLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldMaximoResultadoEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1186, Short.MAX_VALUE))
        );
        jPanelListagemEntradasLayout.setVerticalGroup(
            jPanelListagemEntradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelListagemEntradasLayout.createSequentialGroup()
                .addComponent(jButtonAtualizaListagemEntradas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBoxSomenteCompras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelListagemEntradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldMaximoResultadoEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(339, Short.MAX_VALUE))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jTabbedPaneAlteracaoPrecoProdutoCplus.addTab("Listagem de Entradas", jPanelListagemEntradas);

        jPanelControles.setBorder(javax.swing.BorderFactory.createTitledBorder("Controles"));

        jPanelEstoque.setBorder(javax.swing.BorderFactory.createTitledBorder("Estoque"));

        jTextFieldEstoqueAtual.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldEstoqueAtual.setToolTipText("");
        jTextFieldEstoqueAtual.setEnabled(false);
        jTextFieldEstoqueAtual.setFocusable(false);
        jTextFieldEstoqueAtual.setRequestFocusEnabled(false);

        jTextFieldReservaOrcamento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldReservaOrcamento.setToolTipText("");
        jTextFieldReservaOrcamento.setEnabled(false);
        jTextFieldReservaOrcamento.setFocusable(false);
        jTextFieldReservaOrcamento.setRequestFocusEnabled(false);

        jTextFieldReservaOs.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldReservaOs.setToolTipText("");
        jTextFieldReservaOs.setEnabled(false);
        jTextFieldReservaOs.setFocusable(false);
        jTextFieldReservaOs.setRequestFocusEnabled(false);

        jTextFieldEstoqueDisponivel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jTextFieldEstoqueDisponivel.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldEstoqueDisponivel.setToolTipText("");
        jTextFieldEstoqueDisponivel.setEnabled(false);
        jTextFieldEstoqueDisponivel.setFocusable(false);
        jTextFieldEstoqueDisponivel.setRequestFocusEnabled(false);

        jLabelEstoqueAtual.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelEstoqueAtual.setText("Estoque Atual:");
        jLabelEstoqueAtual.setFocusable(false);
        jLabelEstoqueAtual.setRequestFocusEnabled(false);

        jLabelReservasOrcemento.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelReservasOrcemento.setText("Reservas Or�amento:");
        jLabelReservasOrcemento.setFocusable(false);
        jLabelReservasOrcemento.setRequestFocusEnabled(false);

        jLabelReservasOs.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelReservasOs.setText("Reservas O.S.:");
        jLabelReservasOs.setFocusable(false);
        jLabelReservasOs.setRequestFocusEnabled(false);

        jLabelEstoqueDisponivel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelEstoqueDisponivel.setText("Estoque Dispon�vel:");
        jLabelEstoqueDisponivel.setFocusable(false);
        jLabelEstoqueDisponivel.setRequestFocusEnabled(false);

        javax.swing.GroupLayout jPanelEstoqueLayout = new javax.swing.GroupLayout(jPanelEstoque);
        jPanelEstoque.setLayout(jPanelEstoqueLayout);
        jPanelEstoqueLayout.setHorizontalGroup(
            jPanelEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEstoqueLayout.createSequentialGroup()
                .addGroup(jPanelEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelEstoqueAtual, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelReservasOrcemento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelReservasOs, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelEstoqueDisponivel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTextFieldReservaOrcamento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(jTextFieldReservaOs, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldEstoqueDisponivel, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldEstoqueAtual)))
        );

        jPanelEstoqueLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabelEstoqueAtual, jLabelEstoqueDisponivel, jLabelReservasOrcemento, jLabelReservasOs});

        jPanelEstoqueLayout.setVerticalGroup(
            jPanelEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEstoqueLayout.createSequentialGroup()
                .addGroup(jPanelEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldEstoqueAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEstoqueAtual))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldReservaOrcamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelReservasOrcemento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldReservaOs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelReservasOs))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldEstoqueDisponivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEstoqueDisponivel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelCustos.setBorder(javax.swing.BorderFactory.createTitledBorder("Custos"));

        jLabelPrecoCusto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelPrecoCusto.setText("Pre�o Custo: R$");
        jLabelPrecoCusto.setFocusable(false);
        jLabelPrecoCusto.setMaximumSize(new java.awt.Dimension(100, 14));
        jLabelPrecoCusto.setMinimumSize(new java.awt.Dimension(100, 14));

        jLabelCustoReal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelCustoReal.setText("Custo Real: R$");
        jLabelCustoReal.setFocusable(false);
        jLabelCustoReal.setMaximumSize(new java.awt.Dimension(100, 14));
        jLabelCustoReal.setMinimumSize(new java.awt.Dimension(100, 14));

        jLabelValorIpi.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelValorIpi.setText("Valor IPI: R$");
        jLabelValorIpi.setFocusable(false);
        jLabelValorIpi.setMaximumSize(new java.awt.Dimension(100, 14));
        jLabelValorIpi.setMinimumSize(new java.awt.Dimension(100, 14));

        jLabelValorSt.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelValorSt.setText("Valor S.T.: R$");
        jLabelValorSt.setFocusable(false);
        jLabelValorSt.setMaximumSize(new java.awt.Dimension(100, 14));
        jLabelValorSt.setMinimumSize(new java.awt.Dimension(100, 14));

        jLabelValorOutrasDespesas.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelValorOutrasDespesas.setText("Outras Despesas: R$");
        jLabelValorOutrasDespesas.setFocusable(false);
        jLabelValorOutrasDespesas.setMaximumSize(new java.awt.Dimension(100, 14));
        jLabelValorOutrasDespesas.setMinimumSize(new java.awt.Dimension(100, 14));

        jLabelValorOutrosCustos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelValorOutrosCustos.setText("Outros Custos: R$");
        jLabelValorOutrosCustos.setFocusable(false);
        jLabelValorOutrosCustos.setMaximumSize(new java.awt.Dimension(100, 14));
        jLabelValorOutrosCustos.setMinimumSize(new java.awt.Dimension(100, 14));

        jLabelPrecoPutrosCustos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelPrecoPutrosCustos.setText("Custo Opera. : %");
        jLabelPrecoPutrosCustos.setFocusable(false);
        jLabelPrecoPutrosCustos.setMaximumSize(new java.awt.Dimension(100, 14));
        jLabelPrecoPutrosCustos.setMinimumSize(new java.awt.Dimension(100, 14));

        jLabelCustoMedio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelCustoMedio.setText("Custo M�dio: R$");
        jLabelCustoMedio.setFocusable(false);
        jLabelCustoMedio.setMaximumSize(new java.awt.Dimension(100, 14));
        jLabelCustoMedio.setMinimumSize(new java.awt.Dimension(100, 14));

        jTextFieldPrecoCusto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldPrecoCusto.setEnabled(false);
        jTextFieldPrecoCusto.setFocusable(false);
        jTextFieldPrecoCusto.setRequestFocusEnabled(false);

        jTextFieldCustoReal.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jTextFieldCustoReal.setForeground(new java.awt.Color(204, 51, 0));
        jTextFieldCustoReal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldCustoReal.setToolTipText("� o Custo Final do Produto");
        jTextFieldCustoReal.setDisabledTextColor(new java.awt.Color(204, 0, 0));
        jTextFieldCustoReal.setEnabled(false);
        jTextFieldCustoReal.setFocusable(false);
        jTextFieldCustoReal.setRequestFocusEnabled(false);

        jTextFieldValorIpi.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldValorIpi.setEnabled(false);
        jTextFieldValorIpi.setFocusable(false);
        jTextFieldValorIpi.setRequestFocusEnabled(false);

        jTextFieldValorSubstituicaoTributaria.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldValorSubstituicaoTributaria.setEnabled(false);
        jTextFieldValorSubstituicaoTributaria.setFocusable(false);
        jTextFieldValorSubstituicaoTributaria.setRequestFocusEnabled(false);

        jTextFieldValorOutrasDes.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldValorOutrasDes.setEnabled(false);
        jTextFieldValorOutrasDes.setFocusable(false);
        jTextFieldValorOutrasDes.setRequestFocusEnabled(false);

        jTextFieldValorOutrosCustos.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldValorOutrosCustos.setEnabled(false);
        jTextFieldValorOutrosCustos.setFocusable(false);
        jTextFieldValorOutrosCustos.setRequestFocusEnabled(false);

        jTextFieldPercOutrosCustos.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldPercOutrosCustos.setFocusable(false);
        jTextFieldPercOutrosCustos.setRequestFocusEnabled(false);
        jTextFieldPercOutrosCustos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldPercOutrosCustosFocusLost(evt);
            }
        });
        jTextFieldPercOutrosCustos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPercOutrosCustosActionPerformed(evt);
            }
        });

        jTextFieldCustoMedio.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jTextFieldCustoMedio.setForeground(new java.awt.Color(0, 0, 204));
        jTextFieldCustoMedio.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldCustoMedio.setToolTipText("Custo mais impostos");
        jTextFieldCustoMedio.setDisabledTextColor(new java.awt.Color(0, 0, 153));
        jTextFieldCustoMedio.setEnabled(false);
        jTextFieldCustoMedio.setFocusable(false);
        jTextFieldCustoMedio.setRequestFocusEnabled(false);

        jLabelTotalOutrosCustos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTotalOutrosCustos.setText("Total Tributo:");

        jTextFieldTotalOutrasDespesas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldTotalOutrasDespesas.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldTotalOutrasDespesas.setToolTipText("� a soma da ST IPI e o Custo Operacional:");
        jTextFieldTotalOutrasDespesas.setEnabled(false);

        javax.swing.GroupLayout jPanelCustosLayout = new javax.swing.GroupLayout(jPanelCustos);
        jPanelCustos.setLayout(jPanelCustosLayout);
        jPanelCustosLayout.setHorizontalGroup(
            jPanelCustosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCustosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCustosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPrecoCusto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelCustoReal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelValorSt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelValorOutrosCustos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelCustoMedio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelValorIpi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelValorOutrasDespesas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                    .addComponent(jLabelPrecoPutrosCustos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelTotalOutrosCustos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelCustosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldPrecoCusto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(jTextFieldCustoReal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(jTextFieldValorSubstituicaoTributaria, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(jTextFieldValorOutrosCustos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCustoMedio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldValorIpi, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldValorOutrasDes, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldPercOutrosCustos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTotalOutrasDespesas, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        jPanelCustosLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jTextFieldCustoMedio, jTextFieldCustoReal, jTextFieldPrecoCusto, jTextFieldValorSubstituicaoTributaria});

        jPanelCustosLayout.setVerticalGroup(
            jPanelCustosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCustosLayout.createSequentialGroup()
                .addGroup(jPanelCustosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPrecoCusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPrecoCusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCustosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCustoReal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCustoReal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCustosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelValorSt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldValorSubstituicaoTributaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCustosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelValorOutrosCustos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldValorOutrosCustos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCustosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCustoMedio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCustoMedio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCustosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelValorIpi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldValorIpi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCustosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelValorOutrasDespesas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldValorOutrasDes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCustosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPrecoPutrosCustos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPercOutrosCustos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCustosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTotalOutrosCustos)
                    .addComponent(jTextFieldTotalOutrasDespesas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanelPesquisa.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisas"));

        jComboBoxTermoPesquisa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nome Produto", "Nota Entrada", "Origem", "% Legiao Menor que" }));
        jComboBoxTermoPesquisa.setToolTipText("");

        jTextFieldTermoPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTermoPesquisaActionPerformed(evt);
            }
        });

        jButtonPesquisar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/pesquisar.png"))); // NOI18N
        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        jCheckBoxSomenteItensAtivosCplus.setSelected(true);
        jCheckBoxSomenteItensAtivosCplus.setText("Ativos:");
        jCheckBoxSomenteItensAtivosCplus.setFocusable(false);
        jCheckBoxSomenteItensAtivosCplus.setRequestFocusEnabled(false);

        jButtonAtualizarCarregaCampos.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jButtonAtualizarCarregaCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/atualizar.png"))); // NOI18N
        jButtonAtualizarCarregaCampos.setText("Atualizar Calculos");
        jButtonAtualizarCarregaCampos.setEnabled(false);
        jButtonAtualizarCarregaCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtualizarCarregaCamposActionPerformed(evt);
            }
        });

        jPanelPreco.setBorder(javax.swing.BorderFactory.createTitledBorder("Pre�os Digimacro"));

        jTextFieldMargemNormal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldMargemNormal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldMargemNormal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldMargemNormalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldMargemNormalFocusLost(evt);
            }
        });
        jTextFieldMargemNormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMargemNormalActionPerformed(evt);
            }
        });

        jLabelMargemNormal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelMargemNormal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelMargemNormal.setText("Margem %:");
        jLabelMargemNormal.setFocusable(false);
        jLabelMargemNormal.setRequestFocusEnabled(false);

        jTextFieldPrecoNormal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldPrecoNormal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldPrecoNormal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldPrecoNormalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldPrecoNormalFocusLost(evt);
            }
        });
        jTextFieldPrecoNormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPrecoNormalActionPerformed(evt);
            }
        });

        jLabelPrecoNormal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelPrecoNormal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelPrecoNormal.setText("Pre�o Normal: R$");
        jLabelPrecoNormal.setFocusable(false);
        jLabelPrecoNormal.setMaximumSize(new java.awt.Dimension(70, 14));
        jLabelPrecoNormal.setMinimumSize(new java.awt.Dimension(70, 14));
        jLabelPrecoNormal.setName(""); // NOI18N
        jLabelPrecoNormal.setRequestFocusEnabled(false);
        jLabelPrecoNormal.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout jPanelPrecoLayout = new javax.swing.GroupLayout(jPanelPreco);
        jPanelPreco.setLayout(jPanelPrecoLayout);
        jPanelPrecoLayout.setHorizontalGroup(
            jPanelPrecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrecoLayout.createSequentialGroup()
                .addComponent(jLabelPrecoNormal, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldPrecoNormal, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelMargemNormal, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldMargemNormal, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelPrecoLayout.setVerticalGroup(
            jPanelPrecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrecoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPrecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPrecoNormal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPrecoNormal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelMargemNormal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldMargemNormal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jButtonGravar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonGravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/salvar.png"))); // NOI18N
        jButtonGravar.setText("Gravar");
        jButtonGravar.setEnabled(false);
        jButtonGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGravarActionPerformed(evt);
            }
        });

        jButtonAtualizaMargemCusto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonAtualizaMargemCusto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/atualizar.png"))); // NOI18N
        jButtonAtualizaMargemCusto.setText("Atualiza Margem Custo");
        jButtonAtualizaMargemCusto.setEnabled(false);
        jButtonAtualizaMargemCusto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtualizaMargemCustoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelPesquisaLayout = new javax.swing.GroupLayout(jPanelPesquisa);
        jPanelPesquisa.setLayout(jPanelPesquisaLayout);
        jPanelPesquisaLayout.setHorizontalGroup(
            jPanelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPreco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelPesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPesquisaLayout.createSequentialGroup()
                        .addComponent(jButtonGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonAtualizaMargemCusto, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanelPesquisaLayout.createSequentialGroup()
                        .addGroup(jPanelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxTermoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBoxSomenteItensAtivosCplus))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelPesquisaLayout.createSequentialGroup()
                                .addComponent(jButtonAtualizarCarregaCampos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                                .addComponent(jButtonPesquisar)
                                .addGap(8, 8, 8))
                            .addComponent(jTextFieldTermoPesquisa)))))
        );
        jPanelPesquisaLayout.setVerticalGroup(
            jPanelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPesquisaLayout.createSequentialGroup()
                .addGroup(jPanelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxTermoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTermoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonPesquisar)
                    .addGroup(jPanelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCheckBoxSomenteItensAtivosCplus)
                        .addComponent(jButtonAtualizarCarregaCampos)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGravar)
                    .addComponent(jButtonAtualizaMargemCusto)))
        );

        jPanelOutros.setBorder(javax.swing.BorderFactory.createTitledBorder("Outros"));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Nome C-Plus:");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Nome Site:");

        jTextFieldNomeCplus.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldNomeCplusFocusLost(evt);
            }
        });

        jTextFieldNomeSite.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldNomeSiteFocusLost(evt);
            }
        });

        jLabelFornecedor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelFornecedor.setText("Fornecedor:");
        jLabelFornecedor.setFocusable(false);
        jLabelFornecedor.setRequestFocusEnabled(false);

        jTextFieldFornecedor.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextFieldFornecedor.setEnabled(false);
        jTextFieldFornecedor.setFocusable(false);
        jTextFieldFornecedor.setRequestFocusEnabled(false);

        jLabelPartNumberSistema.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelPartNumberSistema.setText("Part Number:");

        jTextFieldPartNumberSistema.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldPartNumberSistemaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldPartNumberSistemaFocusLost(evt);
            }
        });
        jTextFieldPartNumberSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPartNumberSistemaActionPerformed(evt);
            }
        });

        jLabelComplementoFiscal.setText("Complemento Fiscal:");

        jLabelCodigoInterno.setText("Cod. Interno:");

        jLabelAltura.setText("Altura:");

        jTextFieldAltura.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldAlturaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldAlturaFocusLost(evt);
            }
        });
        jTextFieldAltura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAlturaActionPerformed(evt);
            }
        });

        jLabelLargura.setText("Lergura:");

        jTextFieldLargura.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldLarguraFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldLarguraFocusLost(evt);
            }
        });
        jTextFieldLargura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldLarguraActionPerformed(evt);
            }
        });

        jLabelComprimento.setText("Compr:");

        jTextFieldComprimento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldComprimentoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldComprimentoFocusLost(evt);
            }
        });
        jTextFieldComprimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldComprimentoActionPerformed(evt);
            }
        });

        jLabel1.setText("Unidade:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabelAltura)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelLargura)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldLargura, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelComprimento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldComprimento, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabelAltura)
                .addComponent(jTextFieldAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabelLargura)
                .addComponent(jTextFieldLargura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabelComprimento)
                .addComponent(jTextFieldComprimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel1)
                .addComponent(jTextFieldUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabelOrigemProduto.setText("Origem:");

        jComboBoxOrigemProduto.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jComboBoxOrigemProduto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0 - Nacional - Exceto 3 a 5", "1 - Estrangeira - Importa��o direta", "2 - Estrangeiro - Adquirida no mercado interno", "3 - Nacional - Importa��o superior 40%", "4 - Nacional - Produ��o com PPB", "5 - Nacional - Importa��o inferior 40%", "6 - Estrangeira - Importa��o direta sem similar Nacional", "7 - Estrangeira - Adquirida no mercado interno sem similar nacional", "8 - Nacional - Conteudo de importa��o superior a 70%", "N�o Selecionado" }));
        jComboBoxOrigemProduto.setSelectedIndex(9);
        jComboBoxOrigemProduto.setToolTipText("Escolha aqui a origem do produto");

        jTextFieldComplementoFiscal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldComplementoFiscalFocusGained(evt);
            }
        });

        jLabelSetor.setText("Setor:");

        javax.swing.GroupLayout jPanelOutrosLayout = new javax.swing.GroupLayout(jPanelOutros);
        jPanelOutros.setLayout(jPanelOutrosLayout);
        jPanelOutrosLayout.setHorizontalGroup(
            jPanelOutrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOutrosLayout.createSequentialGroup()
                .addGroup(jPanelOutrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelOutrosLayout.createSequentialGroup()
                        .addGroup(jPanelOutrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelComplementoFiscal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelFornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelPartNumberSistema, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelOutrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldFornecedor)
                            .addComponent(jTextFieldNomeCplus)
                            .addComponent(jTextFieldNomeSite)
                            .addGroup(jPanelOutrosLayout.createSequentialGroup()
                                .addComponent(jTextFieldPartNumberSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelCodigoInterno)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldCodigoInterno))
                            .addComponent(jTextFieldComplementoFiscal)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelOutrosLayout.createSequentialGroup()
                        .addComponent(jLabelSetor, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldSetor, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelOrigemProduto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxOrigemProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelOutrosLayout.setVerticalGroup(
            jPanelOutrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOutrosLayout.createSequentialGroup()
                .addGroup(jPanelOutrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldNomeCplus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelOutrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNomeSite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelOutrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelFornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(9, 9, 9)
                .addGroup(jPanelOutrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelComplementoFiscal)
                    .addComponent(jTextFieldComplementoFiscal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelOutrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPartNumberSistema)
                    .addComponent(jTextFieldPartNumberSistema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCodigoInterno)
                    .addComponent(jTextFieldCodigoInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelOutrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxOrigemProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelOrigemProduto)
                    .addComponent(jLabelSetor)
                    .addComponent(jTextFieldSetor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanelDataMovimento.setBorder(javax.swing.BorderFactory.createTitledBorder("Ultimo Movimento"));

        jLabelDataultimaCompra.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelDataultimaCompra.setText("Data Ultima Compra:");
        jLabelDataultimaCompra.setFocusable(false);
        jLabelDataultimaCompra.setRequestFocusEnabled(false);

        jTextFieldDataUltimaCompra.setEnabled(false);
        jTextFieldDataUltimaCompra.setFocusable(false);
        jTextFieldDataUltimaCompra.setRequestFocusEnabled(false);

        jLabelDataUltimaVenda.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelDataUltimaVenda.setText("Data Ultima Venda:");
        jLabelDataUltimaVenda.setFocusable(false);
        jLabelDataUltimaVenda.setRequestFocusEnabled(false);

        jTextFieldDataUltimaVenda.setEnabled(false);
        jTextFieldDataUltimaVenda.setFocusable(false);
        jTextFieldDataUltimaVenda.setRequestFocusEnabled(false);

        jLabelDataUltimoReajuste.setText("Data Ultimo Reajuste:");

        jTextFieldDataUltimoReajuste.setEnabled(false);

        jLabel2.setText("Ultima Qtd. Com.:");

        jTextFieldUltimaQuantidadeComprada.setEnabled(false);

        javax.swing.GroupLayout jPanelDataMovimentoLayout = new javax.swing.GroupLayout(jPanelDataMovimento);
        jPanelDataMovimento.setLayout(jPanelDataMovimentoLayout);
        jPanelDataMovimentoLayout.setHorizontalGroup(
            jPanelDataMovimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDataMovimentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDataMovimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDataMovimentoLayout.createSequentialGroup()
                        .addGroup(jPanelDataMovimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDataMovimentoLayout.createSequentialGroup()
                                .addComponent(jLabelDataultimaCompra)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldDataUltimaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelDataMovimentoLayout.createSequentialGroup()
                                .addGroup(jPanelDataMovimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelDataUltimoReajuste)
                                    .addComponent(jLabelDataUltimaVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelDataMovimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldDataUltimaVenda, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                    .addComponent(jTextFieldDataUltimoReajuste))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelDataMovimentoLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldUltimaQuantidadeComprada, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanelDataMovimentoLayout.setVerticalGroup(
            jPanelDataMovimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDataMovimentoLayout.createSequentialGroup()
                .addGroup(jPanelDataMovimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDataUltimoReajuste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDataUltimoReajuste, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDataMovimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDataUltimaVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldDataUltimaVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDataMovimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDataultimaCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldDataUltimaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDataMovimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldUltimaQuantidadeComprada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanelDataMovimentoLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jTextFieldDataUltimaCompra, jTextFieldDataUltimaVenda, jTextFieldDataUltimoReajuste});

        jPanelArredondamentoVenda.setBorder(javax.swing.BorderFactory.createTitledBorder("Arredondamento pre�o de venda"));

        buttonGroupArredondamentoPrecoVenda.add(jRadioButtonArredondamentoUmDecimal);
        jRadioButtonArredondamentoUmDecimal.setText("Decimal Um (xx,x00)");

        buttonGroupArredondamentoPrecoVenda.add(jRadioButtonArredondamentoDoisDecimal);
        jRadioButtonArredondamentoDoisDecimal.setSelected(true);
        jRadioButtonArredondamentoDoisDecimal.setText("Decimal Dois (xx,xx0)");

        buttonGroupArredondamentoPrecoVenda.add(jRadioButtonArredondamentoTresDecimal);
        jRadioButtonArredondamentoTresDecimal.setText("Decimal Tr�s (xx,xxx)");

        javax.swing.GroupLayout jPanelArredondamentoVendaLayout = new javax.swing.GroupLayout(jPanelArredondamentoVenda);
        jPanelArredondamentoVenda.setLayout(jPanelArredondamentoVendaLayout);
        jPanelArredondamentoVendaLayout.setHorizontalGroup(
            jPanelArredondamentoVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelArredondamentoVendaLayout.createSequentialGroup()
                .addGroup(jPanelArredondamentoVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButtonArredondamentoUmDecimal)
                    .addComponent(jRadioButtonArredondamentoDoisDecimal)
                    .addComponent(jRadioButtonArredondamentoTresDecimal))
                .addGap(0, 57, Short.MAX_VALUE))
        );
        jPanelArredondamentoVendaLayout.setVerticalGroup(
            jPanelArredondamentoVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelArredondamentoVendaLayout.createSequentialGroup()
                .addComponent(jRadioButtonArredondamentoUmDecimal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonArredondamentoDoisDecimal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonArredondamentoTresDecimal))
        );

        jTextAreaEan.setColumns(20);
        jTextAreaEan.setRows(5);
        jScrollPane4.setViewportView(jTextAreaEan);

        jCheckBoxAtivo.setText("Ativo:");
        jCheckBoxAtivo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jCheckBoxAtivoFocusLost(evt);
            }
        });
        jCheckBoxAtivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxAtivoActionPerformed(evt);
            }
        });

        jCheckBoxNoSite.setText("No Site");
        jCheckBoxNoSite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxNoSiteActionPerformed(evt);
            }
        });

        jTextAreaProdutoComprado.setColumns(20);
        jTextAreaProdutoComprado.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jTextAreaProdutoComprado.setRows(5);
        jTextAreaProdutoComprado.setBorder(javax.swing.BorderFactory.createTitledBorder("Compras"));
        jTextAreaProdutoComprado.setCaretColor(new java.awt.Color(255, 51, 51));
        jScrollPane5.setViewportView(jTextAreaProdutoComprado);

        jButtonEditarSetorEstoque.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonEditarSetorEstoque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Edit.png"))); // NOI18N
        jButtonEditarSetorEstoque.setText("Editar Setor Estoque");
        jButtonEditarSetorEstoque.setEnabled(false);
        jButtonEditarSetorEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarSetorEstoqueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelControlesLayout = new javax.swing.GroupLayout(jPanelControles);
        jPanelControles.setLayout(jPanelControlesLayout);
        jPanelControlesLayout.setHorizontalGroup(
            jPanelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelControlesLayout.createSequentialGroup()
                .addGroup(jPanelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelControlesLayout.createSequentialGroup()
                        .addComponent(jPanelOutros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelControlesLayout.createSequentialGroup()
                        .addGroup(jPanelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelControlesLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jCheckBoxAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBoxNoSite))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelArredondamentoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonEditarSetorEstoque))))
                .addGroup(jPanelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelControlesLayout.createSequentialGroup()
                        .addComponent(jPanelEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelDataMovimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanelPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelCustos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane5))
                .addContainerGap())
        );
        jPanelControlesLayout.setVerticalGroup(
            jPanelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelControlesLayout.createSequentialGroup()
                .addGroup(jPanelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelControlesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanelCustos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelControlesLayout.createSequentialGroup()
                        .addGroup(jPanelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanelControlesLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanelDataMovimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanelEstoque, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelControlesLayout.createSequentialGroup()
                        .addComponent(jPanelOutros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelControlesLayout.createSequentialGroup()
                                .addGroup(jPanelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jCheckBoxAtivo)
                                    .addComponent(jCheckBoxNoSite))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelControlesLayout.createSequentialGroup()
                                .addComponent(jPanelArredondamentoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonEditarSetorEstoque)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelControles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jTabbedPaneAlteracaoPrecoProdutoCplus)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelControles, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPaneAlteracaoPrecoProdutoCplus, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableListagemProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListagemProdutosMouseClicked
        jButtonAtualizarCarregaCampos.setEnabled(true);
        jButtonAtualizaListagemSaidas.setEnabled(true);
        jButtonAtualizaListagemEntradas.setEnabled(true);
        //jTabbedPaneAlteracaoPrecoProdutoCplus.setSelectedIndex(1);
        jButtonAtualizaMargemCusto.setEnabled(true);
        carregarCampos();
    }//GEN-LAST:event_jTableListagemProdutosMouseClicked

    private void jTextFieldTermoPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTermoPesquisaActionPerformed
        jButtonAtualizarCarregaCampos.setEnabled(false);
        jButtonAtualizaListagemSaidas.setEnabled(false);
        jButtonAtualizaListagemEntradas.setEnabled(false);
        jButtonAtualizaMargemCusto.setEnabled(false);

        limpaCampos();

        switch (jComboBoxTermoPesquisa.getSelectedIndex()) {
            case 0:
                pesquisaNomeProduto();
                jTextFieldTermoPesquisa.requestFocus();
                jTextFieldTermoPesquisa.selectAll();
                break;
            case 1:
                pesquisaNumeroNota();
                jTextFieldTermoPesquisa.requestFocus();
                jTextFieldTermoPesquisa.selectAll();
                break;
            case 2:
                pesquisaOrigemProduto();
                jTextFieldTermoPesquisa.requestFocus();
                jTextFieldTermoPesquisa.selectAll();
                break;
        }
        jTabbedPaneAlteracaoPrecoProdutoCplus.setSelectedIndex(0);
        jButtonGravar.setEnabled(false);

    }//GEN-LAST:event_jTextFieldTermoPesquisaActionPerformed

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        jButtonAtualizarCarregaCampos.setEnabled(false);
        jButtonAtualizaListagemSaidas.setEnabled(false);
        jButtonAtualizaListagemEntradas.setEnabled(false);
        jButtonAtualizaMargemCusto.setEnabled(false);

        limpaCampos();

        switch (jComboBoxTermoPesquisa.getSelectedIndex()) {
            case 0:
                pesquisaNomeProduto();
                jTextFieldTermoPesquisa.requestFocus();
                jTextFieldTermoPesquisa.selectAll();
                break;
            case 1:
                pesquisaNumeroNota();
                jTextFieldTermoPesquisa.requestFocus();
                jTextFieldTermoPesquisa.selectAll();
                break;
            case 2:
                pesquisaOrigemProduto();
                jTextFieldTermoPesquisa.requestFocus();
                jTextFieldTermoPesquisa.selectAll();
            case 3:
                pesquisaPorcentagemMenorQue("000000006");
                jTextFieldTermoPesquisa.requestFocus();
                jTextFieldTermoPesquisa.selectAll();

        }

        jTabbedPaneAlteracaoPrecoProdutoCplus.setSelectedIndex(0);
        jButtonGravar.setEnabled(false);
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jTextFieldPrecoNormalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldPrecoNormalFocusLost
        String precoFormatado;
        precoFormatado = formataCampo.bigDecimalParaString(calculaMargemVendaCusto(formataCampo.stringParaDecimal(jTextFieldPrecoNormal.getText(), decimaisArredondamento)), casasDecimais);
        jTextFieldMargemNormal.setText(precoFormatado);
        jButtonGravar.setEnabled(true);
    }//GEN-LAST:event_jTextFieldPrecoNormalFocusLost

    private void jTextFieldMargemNormalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldMargemNormalFocusLost
        String precoFormatado;
        precoFormatado = formataCampo.bigDecimalParaString(calculaValorVenda(formataCampo.stringParaDecimal(jTextFieldMargemNormal.getText(), 4)), casasDecimais);
        jTextFieldPrecoNormal.setText(precoFormatado);
        precoFormatado = formataCampo.bigDecimalParaString(calculaMargemVendaCusto(formataCampo.stringParaDecimal(jTextFieldPrecoNormal.getText(), decimaisArredondamento)), casasDecimais);
        jTextFieldMargemNormal.setText(precoFormatado);
        jButtonGravar.setEnabled(true);
    }//GEN-LAST:event_jTextFieldMargemNormalFocusLost

    private void jTextFieldPrecoNormalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldPrecoNormalFocusGained
        jTextFieldPrecoNormal.selectAll();
        jButtonGravar.setEnabled(true);
    }//GEN-LAST:event_jTextFieldPrecoNormalFocusGained

    private void jTextFieldMargemNormalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldMargemNormalFocusGained
        jTextFieldMargemNormal.selectAll();
        jButtonGravar.setEnabled(true);
    }//GEN-LAST:event_jTextFieldMargemNormalFocusGained

    private void jButtonAtualizarCarregaCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtualizarCarregaCamposActionPerformed
        carregarCampos();
    }//GEN-LAST:event_jButtonAtualizarCarregaCamposActionPerformed

    private void jButtonGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGravarActionPerformed
        gravaValores();
        jTabbedPaneAlteracaoPrecoProdutoCplus.setSelectedIndex(0);
    }//GEN-LAST:event_jButtonGravarActionPerformed

    private void jTextFieldPrecoNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPrecoNormalActionPerformed
        String precoFormatado;
        precoFormatado = formataCampo.bigDecimalParaString(calculaMargemVendaCusto(formataCampo.stringParaDecimal(jTextFieldPrecoNormal.getText(), decimaisArredondamento)), casasDecimais);
        jTextFieldMargemNormal.setText(precoFormatado);
        jButtonGravar.setEnabled(true);
        jTextFieldMargemNormal.requestFocus();
    }//GEN-LAST:event_jTextFieldPrecoNormalActionPerformed

    private void jTextFieldMargemNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMargemNormalActionPerformed
        String precoFormatado;
        precoFormatado = formataCampo.bigDecimalParaString(calculaValorVenda(formataCampo.stringParaDecimal(jTextFieldMargemNormal.getText(), 4)), casasDecimais);
        jTextFieldPrecoNormal.setText(precoFormatado);
        precoFormatado = formataCampo.bigDecimalParaString(calculaMargemVendaCusto(formataCampo.stringParaDecimal(jTextFieldPrecoNormal.getText(), decimaisArredondamento)), casasDecimais);
        jTextFieldMargemNormal.setText(precoFormatado);
        jButtonGravar.setEnabled(true);
        // jTextFieldPrecoTierPriceUm.requestFocus();
    }//GEN-LAST:event_jTextFieldMargemNormalActionPerformed

    private void jButtonAtualizaListagemSaidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtualizaListagemSaidasActionPerformed
        movendaprodList.clear();
        for (Movendaprod movProd : queryCplus.resultProdutoVenda(produtoCplus.getCodprod(), jCheckBoxSomenteVendas.isSelected(), Integer.valueOf(jTextFieldMaximoResultadosSaida.getText()))) {
            movendaprodList.add(movProd);
        }
    }//GEN-LAST:event_jButtonAtualizaListagemSaidasActionPerformed

    private void jTextFieldPartNumberSistemaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldPartNumberSistemaFocusGained
        jButtonGravar.setEnabled(true);
    }//GEN-LAST:event_jTextFieldPartNumberSistemaFocusGained

    private void jTextFieldPartNumberSistemaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldPartNumberSistemaFocusLost
        jButtonGravar.setEnabled(true);
    }//GEN-LAST:event_jTextFieldPartNumberSistemaFocusLost

    private void jTextFieldPartNumberSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPartNumberSistemaActionPerformed
        jButtonGravar.setEnabled(true);
        jButtonGravar.requestFocus();
    }//GEN-LAST:event_jTextFieldPartNumberSistemaActionPerformed

    private void jButtonExcluirregistroFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirregistroFornecedorActionPerformed
        if (jTableProdutoFornecedor.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Voce deve selecional uma linha na tabela!!!");
        } else {
            List<ProdFornecedor> listProdAllNations = queryIntegrador.listProdFornecedor(jTableProdutoFornecedor.getValueAt(jTableProdutoFornecedor.getSelectedRow(), colunaProdutoFornecedor).toString());
            for (ProdFornecedor produtoFornecedor : listProdAllNations) {
                try {
                    new ProdFornecedorJpaController(managerIntegrador).destroy(produtoFornecedor.getIdProdutos());
                    produtoFornecedorList.clear();
                    for (ProdFornecedor proall : queryIntegrador.listProdFornecedor(produtoCplus.getCodprod())) {
                        produtoFornecedorList.add(proall);
                    }
                } catch (jpa.integrador.exceptions.NonexistentEntityException ex) {
                    JOptionPane.showMessageDialog(null, "Houve um erro ao excluir produtoFornecedor!! \n" + ex);
                }
            }
        }
    }//GEN-LAST:event_jButtonExcluirregistroFornecedorActionPerformed

    private void jTextFieldNomeCplusFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNomeCplusFocusLost
        jButtonGravar.setEnabled(true);
        jTextFieldNomeCplus.setText(jTextFieldNomeCplus.getText().toUpperCase());
    }//GEN-LAST:event_jTextFieldNomeCplusFocusLost

    private void jTextFieldNomeSiteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNomeSiteFocusLost
        jButtonGravar.setEnabled(true);
        jTextFieldNomeSite.setText(jTextFieldNomeSite.getText().toUpperCase());
    }//GEN-LAST:event_jTextFieldNomeSiteFocusLost

    private void jTextFieldPercOutrosCustosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPercOutrosCustosActionPerformed
        calculoTotalOutrosCustos();
    }//GEN-LAST:event_jTextFieldPercOutrosCustosActionPerformed

    private void jTextFieldPercOutrosCustosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldPercOutrosCustosFocusLost
        calculoTotalOutrosCustos();
    }//GEN-LAST:event_jTextFieldPercOutrosCustosFocusLost

    private void jButtonAtualizaMargemCustoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtualizaMargemCustoActionPerformed
        calculaPorcentagemCusto();
        gravaValores();
        //new CalculoDeCusto().custoMediouUniComIpi(produtoCplus, managerCplus);
        jTabbedPaneAlteracaoPrecoProdutoCplus.setSelectedIndex(0);
    }//GEN-LAST:event_jButtonAtualizaMargemCustoActionPerformed

    private void jButtonRelacionarProdutoFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRelacionarProdutoFornecedorActionPerformed
        //List<ProdutoIntegracao> listProdIntegracao = queryIntegrador.resultCodigoProdutosCplus(produtoCplus.getCodprod());
        // for(ProdutoIntegracao proIntegracao : listProdIntegracao){
        String codigoFornecedor = JOptionPane.showInputDialog("Digite o C�digo do Fornecedor").toUpperCase();
        String nomeFornecedor = JOptionPane.showInputDialog("Digite o Nome do Fornecedor").toUpperCase();
        List<ProdFornecedor> listProdAll = queryIntegrador.listProdFornecedor(codigoFornecedor, nomeFornecedor);
        if (listProdAll.isEmpty()) {
            try {
                ProdFornecedor proFor = new ProdFornecedor();
                proFor.setCodigoFornecedor(codigoFornecedor);
                proFor.setReferenceCplus(produtoCplus.getCodprod());
                proFor.setAtivo(0);
                proFor.setEan(produtoCplus.getCodigo());
                proFor.setFabricante(produtoCplus.getCodfabricante().getNomefabricante());
                proFor.setOrigemProduto(produtoCplus.getFlagorigemproduto().toString());
                proFor.setPartNumber(partNumber());
                new ProdFornecedorJpaController(managerIntegrador).create(proFor);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Houve um erro ao fazer a rela��o com fornecedor!! \n" + ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Esse c�digo j� est� cadastrado!!");
        }
        //   }
    }//GEN-LAST:event_jButtonRelacionarProdutoFornecedorActionPerformed

    private void jButtonAtivarNoSiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtivarNoSiteActionPerformed
        String cod = jTableProdutoFornecedor.getValueAt(jTableProdutoFornecedor.getSelectedRow(), colunaProdutoFornecedor).toString();
        //List<ProdutosAllnations> lisProAll = queryIntegrador.resultIdProdutoAllNationsIntegrador(Integer.valueOf(cod));
        for (ProdFornecedor proAll : queryIntegrador.listProdFornecedorId(Integer.valueOf(cod))) {
            try {
                proAll.setAtivo(1);
                new ProdFornecedorJpaController(managerIntegrador).edit(proAll);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Houve um erro ao editar!! \n" + ex);
            }
        }
        produtoFornecedorList.clear();
        for (ProdFornecedor proall : queryIntegrador.listProdFornecedor(produtoCplus.getCodprod())) {
            produtoFornecedorList.add(proall);
        }
        jButtonAtivarNoSite.setEnabled(false);
        jButtonExcluirregistroFornecedor.setEnabled(false);
        jButtonDesativarSite.setEnabled(false);
    }//GEN-LAST:event_jButtonAtivarNoSiteActionPerformed

    private void jButtonDesativarSiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDesativarSiteActionPerformed
        String cod = jTableProdutoFornecedor.getValueAt(jTableProdutoFornecedor.getSelectedRow(), colunaProdutoFornecedor).toString();
        //List<ProdutosAllnations> lisProAll = queryIntegrador.resultIdProdutoAllNationsIntegrador(Integer.valueOf(cod));
        for (ProdFornecedor proAll : queryIntegrador.listProdFornecedorId(Integer.valueOf(cod))) {
            try {
                proAll.setAtivo(0);
                new ProdFornecedorJpaController(managerIntegrador).edit(proAll);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Houve um erro ao editar!! \n" + ex);
            }
        }
        produtoFornecedorList.clear();
        for (ProdFornecedor proall : queryIntegrador.listProdFornecedor(produtoCplus.getCodprod())) {
            produtoFornecedorList.add(proall);
        }
        jButtonAtivarNoSite.setEnabled(false);
        jButtonExcluirregistroFornecedor.setEnabled(false);
        jButtonDesativarSite.setEnabled(false);
    }//GEN-LAST:event_jButtonDesativarSiteActionPerformed

    private void jCheckBoxAtivoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jCheckBoxAtivoFocusLost
        jButtonGravar.setEnabled(true);
    }//GEN-LAST:event_jCheckBoxAtivoFocusLost

    private void jTextFieldAlturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAlturaActionPerformed
        String precoFormatado;
        precoFormatado = formataCampo.bigDecimalParaString(formataCampo.stringParaDecimal(jTextFieldAltura.getText(), 4), 4);
        jTextFieldAltura.setText(precoFormatado);
        jButtonGravar.setEnabled(true);
        jTextFieldLargura.requestFocus();
    }//GEN-LAST:event_jTextFieldAlturaActionPerformed

    private void jTextFieldAlturaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldAlturaFocusLost
        String precoFormatado;
        precoFormatado = formataCampo.bigDecimalParaString(formataCampo.stringParaDecimal(jTextFieldAltura.getText(), 4), 4);
        jTextFieldAltura.setText(precoFormatado);
        jButtonGravar.setEnabled(true);
        jTextFieldLargura.requestFocus();
    }//GEN-LAST:event_jTextFieldAlturaFocusLost

    private void jTextFieldAlturaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldAlturaFocusGained
        jTextFieldAltura.selectAll();
        jButtonGravar.setEnabled(true);
    }//GEN-LAST:event_jTextFieldAlturaFocusGained

    private void jTextFieldLarguraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldLarguraActionPerformed
        String precoFormatado;
        precoFormatado = formataCampo.bigDecimalParaString(formataCampo.stringParaDecimal(jTextFieldLargura.getText(), 4), 4);
        jTextFieldLargura.setText(precoFormatado);
        jButtonGravar.setEnabled(true);
        jTextFieldComprimento.requestFocus();
    }//GEN-LAST:event_jTextFieldLarguraActionPerformed

    private void jTextFieldLarguraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldLarguraFocusLost
        String precoFormatado;
        precoFormatado = formataCampo.bigDecimalParaString(formataCampo.stringParaDecimal(jTextFieldLargura.getText(), 4), 4);
        jTextFieldLargura.setText(precoFormatado);
        jButtonGravar.setEnabled(true);
        jTextFieldComprimento.requestFocus();
    }//GEN-LAST:event_jTextFieldLarguraFocusLost

    private void jTextFieldLarguraFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldLarguraFocusGained
        jTextFieldLargura.selectAll();
        jButtonGravar.setEnabled(true);
    }//GEN-LAST:event_jTextFieldLarguraFocusGained

    private void jTextFieldComprimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldComprimentoActionPerformed
        String precoFormatado;
        precoFormatado = formataCampo.bigDecimalParaString(formataCampo.stringParaDecimal(jTextFieldComprimento.getText(), 4), 4);
        jTextFieldComprimento.setText(precoFormatado);
        jButtonGravar.setEnabled(true);
        jButtonGravar.requestFocus();
    }//GEN-LAST:event_jTextFieldComprimentoActionPerformed

    private void jTextFieldComprimentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldComprimentoFocusLost
        String precoFormatado;
        precoFormatado = formataCampo.bigDecimalParaString(formataCampo.stringParaDecimal(jTextFieldComprimento.getText(), 4), 4);
        jTextFieldComprimento.setText(precoFormatado);
        jButtonGravar.setEnabled(true);
        jButtonGravar.requestFocus();
    }//GEN-LAST:event_jTextFieldComprimentoFocusLost

    private void jTextFieldComprimentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldComprimentoFocusGained
        jTextFieldComprimento.selectAll();
        jButtonGravar.setEnabled(true);
    }//GEN-LAST:event_jTextFieldComprimentoFocusGained

    private void jTextFieldComplementoFiscalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldComplementoFiscalFocusGained
        jButtonGravar.setEnabled(true);
    }//GEN-LAST:event_jTextFieldComplementoFiscalFocusGained

    private void jTableProdutoFornecedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProdutoFornecedorMouseClicked
        jButtonAtivarNoSite.setEnabled(true);
        jButtonExcluirregistroFornecedor.setEnabled(true);
        jButtonDesativarSite.setEnabled(true);
    }//GEN-LAST:event_jTableProdutoFornecedorMouseClicked

    private void jCheckBoxNoSiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxNoSiteActionPerformed
        jButtonGravar.setEnabled(true);
    }//GEN-LAST:event_jCheckBoxNoSiteActionPerformed

    private void jCheckBoxAtivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxAtivoActionPerformed
        jButtonGravar.setEnabled(true);
    }//GEN-LAST:event_jCheckBoxAtivoActionPerformed

    private void jButtonAtualizaListagemEntradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtualizaListagemEntradasActionPerformed
        moventradaprodList.clear();
        for (Moventradaprod f : queryCplus.resultProdutoEntrada(produtoCplus.getCodprod(), jCheckBoxSomenteVendas.isSelected(), Integer.valueOf(jTextFieldMaximoResultadoEntrada.getText()))) {
            for (Fornproduto p : queryCplus.resultForProduto(produtoCplus.getCodprod(), f.getCodmoventr().getCodForn().getCodforn())) {
                f.setComplemento(p.getCodigoproduto());
            }
            moventradaprodList.add(f);
        }
    }//GEN-LAST:event_jButtonAtualizaListagemEntradasActionPerformed

    private void jButtonEditarSetorEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarSetorEstoqueActionPerformed
        this.listagemLocalizacaoJDialog.setVisible(true);
        if (this.listagemLocalizacaoJDialog.isCancelamento() == false) {
            for(Produto p : queryCplus.listProduto(produtoCplus.getCodprod())){
                try {
                    p.setCodloc(this.listagemLocalizacaoJDialog.getLocalizacao().getCodloc());
                    new ProdutoJpaController(managerCplus).edit(p);  
                    jButtonEditarSetorEstoque.setEnabled(false);
                    //carregarTabela();
                } catch (jpa.cplus.exceptions.NonexistentEntityException ex) {
                    JOptionPane.showMessageDialog(null, "Houve um ero ao editar produto! \n"+ex);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Houve um ero ao editar produto! \n"+ex);
                }
            }
            carregarCampos();
        }// TODO add your handling code here:
    }//GEN-LAST:event_jButtonEditarSetorEstoqueActionPerformed

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

    private void calculaPorcentagemCusto() {
        int quantidadeEstoque = 0;
        double aliqPisCofins = 9.25;
        //double aliqIcmsEntrada;
        //double aliqIcmsSaida = 0.00;
        double custoProdutoUnitario;
        // double custoMedioProdutoUnitario;
        double creditoUnitarioPisCofins;
        double creditoUnitarioIcms;
        double valorIpiUnitario;
        double valorStUnitario;
        double debitoUnitarioPisCofins;
        //double debitoUnitarioIcms;
        double porcentagemLugro = 1.10;//porcentagem com multiplicas�o de soma
        double valorUnitarioComTributosComLucro;
        double diferencaPisCofins;
        //double diferencaIcms;
        double porcentagemCusto;
        boolean condicaoSt = false;
        boolean condicaoIcms = false;

        for (Produtoestoque estoque : listEstoqueProduto) {
            quantidadeEstoque = estoque.getEstatu().subtract(estoque.getReservadoorcamento().subtract(estoque.getReservadoos())).intValue();
        }
        if (quantidadeEstoque > 0) {
            //int quantidadeEntrada = 0;
            double valorProdutoEntrada = 0.00;
            double valorTotalCreditoIcms = 0.00;
            double valorTotalCreditoPisCofins = 0.00;
            double valorTotalIpi = 0.00;
            double valorTotalSt = 0.00;
            int estoqueCompra = 0;
            int incremetEstoque = 0;
            for (Moventradaprod movProd : queryCplus.resultProdutoEntrada(produtoCplus.getCodprod(), true, 10)) {
                estoqueCompra = estoqueCompra + movProd.getQuantidade().intValue();
                if (quantidadeEstoque >= estoqueCompra) {
                    valorProdutoEntrada = valorProdutoEntrada + movProd.getValortotal().doubleValue();
                    valorTotalCreditoIcms = valorTotalCreditoIcms + movProd.getValoricms().doubleValue();
                    valorTotalCreditoPisCofins = valorTotalCreditoPisCofins + movProd.getValorpis().doubleValue() + movProd.getValorcofins().doubleValue();
                    if (movProd.getValorsubsttributaria() != null) {
                        valorTotalSt = valorTotalSt + movProd.getValorsubsttributaria().doubleValue();
                    }
                    if (movProd.getValoripi() != null) {
                        valorTotalIpi = valorTotalIpi + movProd.getValoripi().doubleValue();
                    }
                    incremetEstoque = incremetEstoque + movProd.getQuantidade().intValue();
                } else {
                    valorProdutoEntrada = valorProdutoEntrada + ((quantidadeEstoque - incremetEstoque) * movProd.getValorunitario().doubleValue());
                    double valorRestanteIcmsUnitario = movProd.getValoricms().doubleValue() / movProd.getQuantidade().doubleValue();
                    valorTotalCreditoIcms = valorTotalCreditoIcms + (valorRestanteIcmsUnitario * (quantidadeEstoque - incremetEstoque));
                    double valorRestantePisCofinsUnitario = (movProd.getValorpis().doubleValue() + movProd.getValorcofins().doubleValue()) / (movProd.getQuantidade().doubleValue());
                    valorTotalCreditoPisCofins = valorTotalCreditoPisCofins + (valorRestantePisCofinsUnitario * (quantidadeEstoque - incremetEstoque));
                    if (movProd.getValorsubsttributaria() != null) {
                        double valorRestanteStUnitario = movProd.getValorsubsttributaria().doubleValue() / movProd.getQuantidade().doubleValue();
                        valorTotalSt = valorTotalSt + (valorRestanteStUnitario * (quantidadeEstoque - incremetEstoque));
                    }
                    if (movProd.getValoripi() != null) {
                        double valorRestanteIpi = movProd.getValoripi().doubleValue() / movProd.getQuantidade().doubleValue();
                        valorTotalIpi = valorTotalIpi + (valorRestanteIpi * (quantidadeEstoque - incremetEstoque));
                    }
                    break;
                } //             
            } //fim for listagem entrada de compra
            
            custoProdutoUnitario = valorProdutoEntrada / quantidadeEstoque;
            creditoUnitarioIcms = valorTotalCreditoIcms / quantidadeEstoque;
            creditoUnitarioPisCofins = valorTotalCreditoPisCofins / quantidadeEstoque;
            valorIpiUnitario = valorTotalIpi / quantidadeEstoque;
            valorStUnitario = valorTotalSt / quantidadeEstoque;
            List<Calculoicmsestado> listIcmsEstado = queryCplus.listcalculoIcmsEstadol("RS", "RS", "5405", produtoCplus.getCodcalculoicms().getCodcalculoicms());
            if (listIcmsEstado.size() == 1) {
                //creditoPisCofins = (custoProdutoUnitario * aliqPisCofins) / 100.00;
                //valorIpiUnitario = produtoCplus.getValoripi().doubleValue();
                //valorStUnitario = produtoCplus.getValorsubsttributaria().doubleValue();
                valorUnitarioComTributosComLucro = (valorIpiUnitario + valorStUnitario + custoProdutoUnitario) * porcentagemLugro;
                debitoUnitarioPisCofins = (valorUnitarioComTributosComLucro * aliqPisCofins) / 100.00;
               // debitoUnitarioIcms = (valorUnitarioComTributosComLucro * aliqPisCofins) / 100.00;
                diferencaPisCofins = debitoUnitarioPisCofins - creditoUnitarioPisCofins;
                //diferencaIcms = debitoUnitarioIcms - creditoUnitarioIcms;
                //soma valor tributos com lucro
                valorUnitarioComTributosComLucro = (valorIpiUnitario + valorStUnitario + custoProdutoUnitario + diferencaPisCofins) * porcentagemLugro;
                debitoUnitarioPisCofins = (valorUnitarioComTributosComLucro * aliqPisCofins) / 100.00;
                diferencaPisCofins = debitoUnitarioPisCofins - creditoUnitarioPisCofins;
                porcentagemCusto = (diferencaPisCofins / custoProdutoUnitario) * 100.00;
                jTextFieldPercOutrosCustos.setText(formataCampo.bigDecimalParaString(new BigDecimal(porcentagemCusto), casasDecimais));
            } else {
                condicaoSt = true;
            }
            listIcmsEstado = queryCplus.listcalculoIcmsEstadol("RS", "RS", "5102", produtoCplus.getCodcalculoicms().getCodcalculoicms());
            if (listIcmsEstado.size() == 1) {
                jTextFieldPercOutrosCustos.setText(formataCampo.bigDecimalParaString(new CalculoDeCusto().custoMediouUniComIpi(listIcmsEstado, produtoCplus, managerCplus), casasDecimais));
            } else {
                condicaoIcms = true;
                //JOptionPane.showMessageDialog(null, "N�o foi possi encontrar o calculo de ICMS verifique no C-Plus!!!\n lista de resultados: " + listIcmsEstado.size());
            }
        } 
        if (condicaoIcms == true && condicaoSt == true) {
            JOptionPane.showMessageDialog(null, "N�o foi possi encontrar o calculo de ICMS verifique no C-Plus!!!\n ");
        }
        calculoTotalOutrosCustos();
    }

    private void calculoTotalOutrosCustos() {
        double aliqCusto = formataCampo.stringParaDecimal(jTextFieldPercOutrosCustos.getText(), 4).doubleValue();
        jTextFieldPercOutrosCustos.setText(formataCampo.bigDecimalParaString(new BigDecimal(aliqCusto), 4));
        double custo = produtoCplus.getPrecusto().doubleValue();
        double valorPercentualCusto = (custo * aliqCusto) / 100.00;
        double outros = valorPercentualCusto + produtoCplus.getOutros().doubleValue();
        jTextFieldTotalOutrasDespesas.setText(formataCampo.bigDecimalParaString(new BigDecimal(outros), casasDecimais));
        jButtonGravar.setEnabled(true);
    }

    private void gravaValores() {
        try {
            gerarAuditoria();
            for (Produtopreco preco : listPrecoProduto) {
                switch (preco.getCodpreco().getCodpreco()) {
                    case "000000001":
                        preco.setPreco(formataCampo.stringParaDecimal(jTextFieldPrecoNormal.getText(), decimaisArredondamento));
                        preco.setMargem(calculaMargemPraGravarBanco(jTextFieldPrecoNormal.getText()));
                        new ProdutoprecoJpaController(managerCplus).edit(preco);
                        break;
                }
            }
            produtoCplus.setLastChange(formataCampo.dataAtual());
            produtoCplus.setDatreaj(formataCampo.dataAtual());
            produtoCplus.setNomeprod(jTextFieldNomeCplus.getText().trim());
            produtoCplus.setNomeprodweb(jTextFieldNomeSite.getText().trim());
            produtoCplus.setCodigointerno(tamanhoString(jTextFieldCodigoInterno.getText(), 20));
            produtoCplus.setPercoutroscustos(formataCampo.stringParaDecimal(jTextFieldPercOutrosCustos.getText(), casasDecimais));
            produtoCplus.setTotoutroscustos(formataCampo.stringParaDecimal(jTextFieldTotalOutrasDespesas.getText(), casasDecimais));
            produtoCplus.setAltura(formataCampo.stringParaDecimal(jTextFieldAltura.getText(), 4));
            produtoCplus.setLargura(formataCampo.stringParaDecimal(jTextFieldLargura.getText(), 4));
            produtoCplus.setComprimento(formataCampo.stringParaDecimal(jTextFieldComprimento.getText(), 4));
            if (jCheckBoxAtivo.isSelected()) {
                produtoCplus.setFlaginativo('N');
            } else {
                produtoCplus.setFlaginativo('Y');
            }
            List<Produtocaracteristica> listProdCaracteristica = queryCplus.listProdutoCaracteristicaDoProduto(produtoCplus.getCodprod());
            if (jCheckBoxNoSite.isSelected()) {
                // List<Produtocaracteristica> listProdCaracteristica = queryCplus.listProdutoCaracteristicaDoProduto(produtoCplus.getCodprod());
                if (listProdCaracteristica.size() == 1) {
                    for (Produtocaracteristica prodCar : listProdCaracteristica) {
                        prodCar.setCodcaracteristica("000000005");
                        new ProdutocaracteristicaJpaController(managerCplus).edit(prodCar);
                    }
                }
            } else {
                if (listProdCaracteristica.size() == 1) {
                    for (Produtocaracteristica prodCar : listProdCaracteristica) {
                        prodCar.setCodcaracteristica("000000001");
                        new ProdutocaracteristicaJpaController(managerCplus).edit(prodCar);
                    }
                }
            }
            if (jComboBoxOrigemProduto.getSelectedIndex() != 9) {
                char origem;
                switch (jComboBoxOrigemProduto.getSelectedIndex()) {
                    case 0:
                        origem = '0';
                        break;
                    case 1:
                        origem = '1';
                        break;
                    case 2:
                        origem = '2';
                        break;
                    case 3:
                        origem = '3';
                        break;
                    case 4:
                        origem = '4';
                        break;
                    case 5:
                        origem = '5';
                        break;
                    case 6:
                        origem = '6';
                        break;
                    case 7:
                        origem = '7';
                        break;
                    case 8:
                        origem = '8';
                        break;
                    default:
                        origem = '0';
                }
                produtoCplus.setFlagorigemproduto(origem);
            }
            new ProdutoJpaController(managerCplus).edit(produtoCplus);

            // List<ProdutoIntegracao> listProdIntegracao = queryIntegrador.resultCodigoProdutosCplus(produtoCplus.getCodprod());
            // if(listProdIntegracao.size() == 1){
            //       for (ProdutoIntegracao produtoIntegracao : listProdIntegracao) {
            if (!"".equals(jTextFieldPartNumberSistema.getText())) {
                gravaPartNumber(jTextFieldPartNumberSistema.getText().toUpperCase());
                // for (Campocustomvalor campo : queryCplus.listCampoMaster(produtoCplus.getCodprod(), "000000004")) {
                //     campo.setValor(jTextFieldPartNumberSistema.getText().toUpperCase());
                // }
            }
            //if (!"".equals(jTextFieldComplementoFiscal.getText())) {               
            gravaComplementoFiscal(jTextFieldComplementoFiscal.getText());
            //}                           
            jButtonGravar.setEnabled(false);
        } catch (Exception ex) {
            criaLog(new Date(System.currentTimeMillis()), "Erro ao editar Pre�o no C-plus no Frame Alteracao de pre�o \n" + ex, "Erro Editar");
        }
        carregarCampos();
    }

    private void gerarAuditoria() {
        try {
            InetAddress addr = InetAddress.getLocalHost();
            // Configuracao configuracao = new ConfiguracaoJpaController(managerIntegrador).findConfiguracao("increment_tabela_auditoria");      
            int cont = Integer.valueOf(queryIntegrador.valorConfiguracao("increment_tabela_auditoria"));
            cont++;
            Auditoria auditoria = new Auditoria();
            auditoria.setCodauditoria(String.format("%09d", cont));
            //auditoria.setCodauditoria(queryCplus.incrementAuditoria());
            auditoria.setCoduser("000000006");
            auditoria.setCodsistema("000000001");
            auditoria.setData(new Date(System.currentTimeMillis()));
            auditoria.setFlagcategoria(2);
            auditoria.setDescricao("Altera��o no cadastro de produtos");
            auditoria.setDetalhelog(mensagemLog(produtoCplus));
            auditoria.setNomemoduloorigem("Cadastro de Produto");
            auditoria.setNomecomputador(addr.getHostName());
            auditoria.setIpcomputador(addr.getHostAddress());
            auditoria.setNomeentidadeorigem("PRODUTO");
            auditoria.setIdentidadeorigem(produtoCplus.getCodprod());
            auditoria.setCodacesso("000033241");
            if (!"".equals(auditoria.getDetalhelog())) {
                new AuditoriaJpaController(managerCplus).create(auditoria);
            }
            queryIntegrador.atualizaValorConfiguracao("increment_tabela_auditoria", String.valueOf(cont));

        } catch (UnknownHostException ex) {
            criaLog(new Date(System.currentTimeMillis()), "Erro ao Criar Auditoria no C-plus no Frame Alteracao de pre�o \n" + ex, "Erro Criar");
        } catch (Exception ex) {
            criaLog(new Date(System.currentTimeMillis()), "Erro ao Criar Auditoria no C-plus no Frame Alteracao de pre��o \n" + ex, "Erro Criar");
        }
    }

    private String mensagemLog(Produto prod) {
        String mensagem = "";
        for (Produtopreco preco : listPrecoProduto) {
            switch (preco.getCodpreco().getCodpreco()) {
                case "000000001":
                    double precoNovo = formataCampo.stringParaDecimal(jTextFieldPrecoNormal.getText(), decimaisArredondamento).doubleValue();
                    if (preco.getPreco().doubleValue() != precoNovo) {
                        mensagem = "Altera��o no cadastro de produtos " + prod.getNomeprod() + "\n";
                        mensagem = mensagem + preco.getCodpreco().getNomepreco() + " Margem de " + formataCampo.bigDecimalParaString(preco.getMargem(), 4) + " Para " + formataCampo.bigDecimalParaString(calculaMargemPraGravarBanco(jTextFieldPrecoNormal.getText()), 4)
                                + " Pre�o de " + formataCampo.bigDecimalParaString(preco.getPreco(), 2) + " Para " + jTextFieldPrecoNormal.getText() + "\n";
                    }
                    break;

            }
        }
        return mensagem;
    }
    
     
    private String setor(Produto codProd){
        String text = "";
        for(Localizacao loc : queryCplus.listLocalizacao(codProd.getCodloc())){
           text =  loc.getDescricao();
       }
        return text;
    }

    private void carregarCampos() {
        if (jRadioButtonDuasDecimais.isSelected()) {
            casasDecimais = 2;
        } else if (jRadioButtonUmaDecimal.isSelected()) {
            casasDecimais = 1;
        } else if (jRadioButtonTresDecimais.isSelected()) {
            casasDecimais = 3;
        } else {
            casasDecimais = 4;
        }
        String codProdutoTabela = jTableListagemProdutos.getValueAt(jTableListagemProdutos.getSelectedRow(), colunaCodprod).toString();
        produtoCplus = new ProdutoJpaController(managerCplus).findProduto(codProdutoTabela);
        if (produtoCplus.getDatreaj() != null) {
            jTextFieldDataUltimoReajuste.setText(formataCampo.dataStringSoData(produtoCplus.getDatreaj(), 0));
        }
        precoCustoRealSistema = produtoCplus.getCustoreal();
        if (produtoCplus.getCustomedio().doubleValue() <= 0.0001) {
            produtoCplus.setCustomedio(produtoCplus.getCustoreal());
            try {
                new ProdutoJpaController(managerCplus).edit(produtoCplus);
            } catch (NonexistentEntityException ex) {
                criaLog(new Date(System.currentTimeMillis()), "Erro ao editar custo m�dio no C-plus no Frame Alteracao de pre�o \n" + ex, "Erro Editar");
            } catch (Exception ex) {
                criaLog(new Date(System.currentTimeMillis()), "Erro ao editar custo m�dio no C-plus no Frame Alteracao de pre�o \n" + ex, "Erro Editar");
            }
        } else {
            precoCustoMedioSistema = produtoCplus.getCustomedio();
        }
        if (jRadioButtonCustoSystema.isSelected()) {
            jTextFieldPrecoCusto.setText(formataCampo.bigDecimalParaString(produtoCplus.getPrecusto(), casasDecimais));
            jTextFieldCustoReal.setText(formataCampo.bigDecimalParaString(produtoCplus.getCustoreal(), casasDecimais));
            jTextFieldValorIpi.setText(formataCampo.bigDecimalParaString(produtoCplus.getValoripi(), casasDecimais));
            jTextFieldValorSubstituicaoTributaria.setText(formataCampo.bigDecimalParaString(produtoCplus.getValorsubsttributaria(), casasDecimais));
        }
        jTextFieldValorOutrasDes.setText(formataCampo.bigDecimalParaString(produtoCplus.getOutros(), casasDecimais));
        jTextFieldValorOutrosCustos.setText(formataCampo.bigDecimalParaString(produtoCplus.getValoutroscustos(), casasDecimais));
        jTextFieldPercOutrosCustos.setText(formataCampo.bigDecimalParaString(produtoCplus.getPercoutroscustos(), casasDecimais));
        jTextFieldCustoMedio.setText(formataCampo.bigDecimalParaString(produtoCplus.getCustomedio(), casasDecimais));
        jTextFieldTotalOutrasDespesas.setText(formataCampo.bigDecimalParaString(produtoCplus.getTotoutroscustos(), casasDecimais));
        jTextFieldNomeCplus.setText(produtoCplus.getNomeprod());
        jTextFieldCodigoInterno.setText(produtoCplus.getCodigointerno());
        jTextFieldNomeSite.setText(produtoCplus.getNomeprodweb());
        jTextFieldUnidade.setText(produtoCplus.getUnidade());
        char compra = 'C';
        List<Moventrada> listMovEntrada = queryCplus.resultUltimaCompra(codProdutoTabela, compra, 1);
        for (Moventrada movEnt : listMovEntrada) {
            jTextFieldDataUltimaCompra.setText(formataCampo.dataStringSoData(movEnt.getData(), 0));
            if (movEnt.getCodForn() != null) {
                jTextFieldFornecedor.setText(movEnt.getCodForn().getNomeforn());
            }
            for (Moventradaprod movPro : queryCplus.resultProdutoEntrada(codProdutoTabela, movEnt.getCodmoventr())) {
                double valorUnitario = movPro.getValorunitario().doubleValue();
                double valorST = movPro.getValorsubsttributaria().doubleValue();
                double quantidade = movPro.getQuantidade().doubleValue();
                double valorIpi = movPro.getValoripi().doubleValue();
                double valorComImpostos;
                valorComImpostos = valorUnitario + (valorST / quantidade) + (valorIpi / quantidade);
                BigDecimal totalCusto = new BigDecimal(valorComImpostos);

                jTextFieldUltimaQuantidadeComprada.setText(formataCampo.bigDecimalParaString(movPro.getQuantidade(), 0));
                precoCustoUltimaCompra = totalCusto;

                if (jRadioButtonCustoUltimaCompra.isSelected()) {
                    jTextFieldPrecoCusto.setText(formataCampo.bigDecimalParaString(movPro.getValorunitario(), casasDecimais));
                    jTextFieldValorSubstituicaoTributaria.setText(formataCampo.bigDecimalParaString(new BigDecimal(valorST / quantidade), casasDecimais));
                    jTextFieldValorIpi.setText(formataCampo.bigDecimalParaString(new BigDecimal(valorIpi / quantidade), casasDecimais));
                    jTextFieldCustoReal.setText(formataCampo.bigDecimalParaString(totalCusto, casasDecimais));
                }
            }
        }
        char venda = 'V';
        List<Movenda> listMovVenda = queryCplus.resultUltimaVenda(codProdutoTabela, venda, 1);
        for (Movenda movVen : listMovVenda) {
            jTextFieldDataUltimaVenda.setText(formataCampo.dataStringSoData(movVen.getData(), 0));
        }
        listEstoqueProduto = queryCplus.listEstoquesPorProd(codProdutoTabela);
        listPrecoProduto = queryCplus.resultTodosPrecos(codProdutoTabela);
        for (Produtopreco preco : listPrecoProduto) {
            BigDecimal margem = BigDecimal.ZERO;
            switch (preco.getCodpreco().getCodpreco()) {
                case "000000001":
                    margem = calculaMargemVendaCusto(preco.getPreco());
                    if (margem.intValue() > 10) {
                        jTextFieldPrecoNormal.setForeground(Color.BLUE);
                        jTextFieldMargemNormal.setForeground(Color.BLUE);
                    } else if (margem.intValue() < 1) {
                        jTextFieldPrecoNormal.setForeground(Color.RED);
                        jTextFieldMargemNormal.setForeground(Color.RED);
                    } else {
                        jTextFieldPrecoNormal.setForeground(Color.BLACK);
                        jTextFieldMargemNormal.setForeground(Color.BLACK);
                    }
                    jTextFieldPrecoNormal.setText(formataCampo.bigDecimalParaString(preco.getPreco(), casasDecimais));
                    jTextFieldMargemNormal.setText(formataCampo.bigDecimalParaString(margem, 4));
                    break;
            }
        }
        for (Produtoestoque estoque : queryCplus.listEstoquesPorProd(codProdutoTabela)) {
            if ("000000001".equals(estoque.getSetorestoque().getCodsetorestoque())) {
                jTextFieldEstoqueAtual.setText(formataCampo.bigDecimalParaString(estoque.getEstatu(), 0));
                jTextFieldReservaOrcamento.setText(formataCampo.bigDecimalParaString(estoque.getReservadoorcamento(), 0));
                jTextFieldReservaOs.setText(formataCampo.bigDecimalParaString(estoque.getReservadoos(), 0));
                BigDecimal estoqueDisponivel = estoque.getEstatu().subtract(estoque.getReservadoorcamento()).subtract(estoque.getReservadoos());
                if (estoqueDisponivel.intValue() > 0) {
                    jTextFieldEstoqueDisponivel.setDisabledTextColor(Color.BLACK);
                } else {
                    jTextFieldEstoqueDisponivel.setDisabledTextColor(Color.RED);
                }
                jTextFieldEstoqueDisponivel.setText(formataCampo.bigDecimalParaString(estoqueDisponivel, 0));
            }
        }
        produtoFornecedorList.clear();
        for (ProdFornecedor proall : queryIntegrador.listProdFornecedor(produtoCplus.getCodprod())) {
            produtoFornecedorList.add(proall);
        }
        List<PsProduct> listPp = queryPrestaShop.listPsProduct(codProdutoTabela);
        if (listPp.isEmpty()) {
            jTextFieldPartNumberSistema.setForeground(Color.red);
            jTextFieldComplementoFiscal.setForeground(Color.red);
            //jTextFieldComplementoFiscal.setText("Produto n�o existe no S");
        } else {
            jTextFieldPartNumberSistema.setForeground(Color.blue);
            jTextFieldComplementoFiscal.setForeground(Color.blue);
        }
        jTextFieldPartNumberSistema.setText(partNumber());
        jTextFieldComplementoFiscal.setText(complemantoFiscal());
        jTextFieldAltura.setText(formataCampo.bigDecimalParaString(produtoCplus.getAltura(), 4));
        jTextFieldLargura.setText(formataCampo.bigDecimalParaString(produtoCplus.getLargura(), 4));
        jTextFieldComprimento.setText(formataCampo.bigDecimalParaString(produtoCplus.getComprimento(), 4));
        if ("N".equals(produtoCplus.getFlaginativo().toString())) {
            jCheckBoxAtivo.setSelected(true);
        } else {
            jCheckBoxAtivo.setSelected(false);
        }
        List<Produtocaracteristica> lisCar = queryCplus.listCaracteristicaProduto(produtoCplus.getCodprod());
        if (lisCar.size() == 1) {
            jCheckBoxNoSite.setSelected(true);
        } else {
            jCheckBoxNoSite.setSelected(false);
        }
        lisCar = queryCplus.listProdutoCaracteristicaDoProduto(produtoCplus.getCodprod());
        if (lisCar.size() != 1) {
            JOptionPane.showMessageDialog(null, "O produto: " + produtoCplus.getNomeprod() + " possui Erro nas caracteristicas, Favor Corrigir");
        }
        if (produtoCplus.getFlagorigemproduto() != null) {
            switch (produtoCplus.getFlagorigemproduto().toString()) {
                case "0":
                    jComboBoxOrigemProduto.setSelectedIndex(0);
                    break;
                case "1":
                    jComboBoxOrigemProduto.setSelectedIndex(1);
                    break;
                case "2":
                    jComboBoxOrigemProduto.setSelectedIndex(2);
                    break;
                case "3":
                    jComboBoxOrigemProduto.setSelectedIndex(3);
                    break;
                case "4":
                    jComboBoxOrigemProduto.setSelectedIndex(4);
                    break;
                case "5":
                    jComboBoxOrigemProduto.setSelectedIndex(5);
                    break;
                case "6":
                    jComboBoxOrigemProduto.setSelectedIndex(6);
                    break;
                case "7":
                    jComboBoxOrigemProduto.setSelectedIndex(7);
                    break;
                case "8":
                    jComboBoxOrigemProduto.setSelectedIndex(8);
                    break;
                default:
                    jComboBoxOrigemProduto.setSelectedIndex(9);
            }
        } else {
            jComboBoxOrigemProduto.setSelectedIndex(9);
        }
        String txt = "";
        for (Produtocodigo ean : produtoCplus.getProdutocodigoCollection()) {
            txt = txt + ean.getCodigo() + "\n";
        }
        jTextAreaProdutoComprado.setText(new PedidoCompra().produtoComprado(managerCplus, produtoCplus.getCodprod()));
        jTextAreaEan.setText(txt);
        jButtonGravar.setEnabled(false);
        jButtonEditarSetorEstoque.setEnabled(true);
        jTextFieldSetor.setText(setor(produtoCplus));
    }

    private void limpaCampos() {
        jTextAreaEan.setText("");
        jTextAreaProdutoComprado.setText("");
        jTextFieldCustoMedio.setText("");
        jTextFieldCustoReal.setText("");
        jTextFieldDataUltimaCompra.setText("");
        jTextFieldDataUltimaVenda.setText("");
        jTextFieldDataUltimoReajuste.setText("");
        jTextFieldEstoqueAtual.setText("");
        jTextFieldEstoqueDisponivel.setText("");
        jTextFieldFornecedor.setText("");
        //     jTextFieldMargemLegiao.setText("");
        //      jTextFieldMargemTierPriceQuatro.setText("");
        jTextFieldMargemNormal.setText("");
        //      jTextFieldMargemTierPriceDois.setText("");
        //      jTextFieldMargemTierPriceTres.setText("");
        //      jTextFieldMargemTierPriceUm.setText("");
        jTextFieldPartNumberSistema.setText("");
        jTextFieldComplementoFiscal.setText("");
        jTextFieldPartNumberSistema.setForeground(Color.black);
        jTextFieldComplementoFiscal.setForeground(Color.black);
        jTextFieldPercOutrosCustos.setText("");
        //      jTextFieldPrecoLegiao.setText("");
        //      jTextFieldTierPriceQuatro.setText("");
        jTextFieldPrecoNormal.setText("");
        //      jTextFieldPrecoTierPriceDois.setText("");
        //      jTextFieldPrecoTierPriceTres.setText("");
        //      jTextFieldPrecoTierPriceUm.setText("");
        jTextFieldPrecoCusto.setText("");
        jTextFieldReservaOrcamento.setText("");
        jTextFieldReservaOs.setText("");
        jTextFieldUltimaQuantidadeComprada.setText("");
        jTextFieldValorIpi.setText("");
        jTextFieldValorOutrasDes.setText("");
        jTextFieldValorOutrosCustos.setText("");
        jTextFieldValorSubstituicaoTributaria.setText("");
        //  jTextFieldQuntItensCarrinhoMagento.setText("");
        jTextFieldNomeCplus.setText("");
        jTextFieldCodigoInterno.setText("");
        jTextFieldNomeSite.setText("");
        jTextFieldUnidade.setText("");
        jTextFieldAltura.setText("");
        jTextFieldLargura.setText("");
        jTextFieldComprimento.setText("");
        jComboBoxOrigemProduto.setSelectedIndex(9);
        movendaprodList.clear();
        jTextFieldSetor.setText("");
        jButtonEditarSetorEstoque.setEnabled(false);
                
    }

    private BigDecimal calculaValorVenda(BigDecimal margemLucro) {
        double precoCustoProduto;
        int arredondamento;
        if (jRadioButtonMargemCustoCplus.isSelected()) {
            precoCustoProduto = precoCustoRealSistema.doubleValue();
        } else if (jRadioButtonMargemSobreCustoMedioCplus.isSelected()) {
            precoCustoProduto = precoCustoMedioSistema.doubleValue();
        } else {
            precoCustoProduto = precoCustoUltimaCompra.doubleValue();
        }
        if (jRadioButtonArredondamentoUmDecimal.isSelected()) {
            arredondamento = 1;
        } else if (jRadioButtonArredondamentoDoisDecimal.isSelected()) {
            arredondamento = 2;
        } else {
            arredondamento = 3;
        }

        double margemLucroTexto = margemLucro.doubleValue();
        double valorVendaCalculado = ((precoCustoProduto * margemLucroTexto) / 100) + precoCustoProduto;
        BigDecimal resultado = new BigDecimal(valorVendaCalculado).setScale(arredondamento, RoundingMode.HALF_UP);
        return resultado;
    }

    private BigDecimal calculaMargemVendaCusto(BigDecimal precoVenda) {
        double precoCustoProduto;
        if (jRadioButtonMargemCustoCplus.isSelected()) {
            precoCustoProduto = precoCustoRealSistema.doubleValue();
        } else if (jRadioButtonMargemSobreCustoMedioCplus.isSelected()) {
            precoCustoProduto = precoCustoMedioSistema.doubleValue();
        } else {
            precoCustoProduto = precoCustoUltimaCompra.doubleValue();
        }

        double precoVendaProduto = precoVenda.doubleValue();

        double margemLucro = ((precoVendaProduto - precoCustoProduto) / precoCustoProduto) * 100;
        BigDecimal resultado = new BigDecimal(margemLucro).setScale(4, RoundingMode.HALF_UP);
        return resultado;
    }

    private BigDecimal calculaMargemPraGravarBanco(String precoVendaTextField) {
        double precoCustoProduto = precoCustoRealSistema.doubleValue();
        double precoVendaProduto = formataCampo.stringParaDecimal(precoVendaTextField, decimaisArredondamento).doubleValue();

        double margemLucro = ((precoVendaProduto - precoCustoProduto) / precoCustoProduto) * 100;

        BigDecimal resultado = new BigDecimal(margemLucro);
        resultado.setScale(4, RoundingMode.HALF_UP);
        return resultado;
    }

    private void pesquisaNumeroNota() {
        if ("".equals(jTextFieldTermoPesquisa.getText())) {
            JOptionPane.showMessageDialog(null, "voc� deve informar o n�mero da Nota!!!");
        } else {
            produtoList.clear();
            this.listagemEntradasJDialog.setTermoPesquisa(jTextFieldTermoPesquisa.getText(), 0);
            this.listagemEntradasJDialog.setVisible(true);
            Moventrada movEntrada = this.listagemEntradasJDialog.getMovEntrada();
            if (movEntrada.getCodmoventr() != null) {
                for (Produto prod : queryCplus.resultProdutosPorCodigoEntrada(movEntrada.getCodmoventr())) {
                    produtoList.add(prod);
                    coloreLinhasImpars();
                }
            }
        }
    }

    private void pesquisaOrigemProduto() {
        if ("".equals(jTextFieldTermoPesquisa.getText())) {
            JOptionPane.showMessageDialog(null, "voc� deve informar a Origem do Produto em Numerico!!!");
        } else {
            produtoList.clear();
            Character ch = jTextFieldTermoPesquisa.getText().charAt(0);
            for (Produto prod : queryCplus.resultPorOrigemProduto(ch)) {
                produtoList.add(prod);
                coloreLinhasImpars();
            }
        }
    }

    private void pesquisaNomeProduto() {
        if ("".equals(jTextFieldTermoPesquisa.getText())) {
            JOptionPane.showMessageDialog(null, "voc� deve informar o nome do Produto!!!");
        } else {
            produtoList.clear();
            for (Produto prod : queryCplus.resultPorNomeProdutoOuCodigo(jTextFieldTermoPesquisa.getText(), jCheckBoxSomenteItensAtivosCplus.isSelected())) {
                produtoList.add(prod);
                coloreLinhasImpars();
            }
        }
    }

    private void coloreLinhasImpars(){
        //colore as linhas da tabela
           // TableCellRenderer rendererSeparado = new ColorirLinhaImpar();
            //for (int c = 0; c < jTableListagemProdutos.getColumnCount(); c++) {
            //    jTableListagemProdutos.setDefaultRenderer(jTableListagemProdutos.getColumnClass(c), rendererSeparado);
           // }
            //**********************
    }
    private void criaLog(Date dataExecucao, String mensagem, String tipoLog) {
        IntLogs log = new IntLogs();
        log.setDataExecucao(dataExecucao);
        log.setMensagem(mensagem);
        log.setTipoLog(tipoLog);
        new IntLogsJpaController(managerIntegrador).create(log);
    }

    private void pesquisaPorcentagemMenorQue(String codigoPreco) {
        if ("".equals(jTextFieldTermoPesquisa.getText())) {
            JOptionPane.showMessageDialog(null, "voc� deve informar o nome do Produto!!!");
        } else {
            produtoList.clear();
            for (Produto prod : queryCplus.resultProPorcentagem(codigoPreco, formataCampo.stringParaDecimal(jTextFieldTermoPesquisa.getText(), casasDecimais))) {
                produtoList.add(prod);
            }
        }
    }

    private String partNumber() {
        //part Number 000000004
        //complemento Fiscal 000000003
        String codCampoCustomMaster = "000000004";
        String retorno = "";
        for (Campocustomvalor campo : queryCplus.listCampoMaster(produtoCplus.getCodprod(), codCampoCustomMaster)) {
            if (campo.getValor() != null) {
                retorno = campo.getValor();
            }
        }
        return retorno;
    }

    private void gravaComplementoFiscal(String valor) {
        String codCampoCustomMaster = "000000003";
        List<Campocustomvalor> listCampo = (List<Campocustomvalor>) queryCplus.listCampoMaster(produtoCplus.getCodprod(), codCampoCustomMaster);
        if (listCampo.isEmpty()) {
            if (!"".equals(valor)) {
                Integer configCont = Integer.valueOf(queryIntegrador.valorConfiguracao("increment_tabela_campo_valor"));
                Campocustomvalor ca = new Campocustomvalor();
                ca.setCodcampocustomvalor(String.format("%09d", configCont));
                ca.setCodcampocustommaster(new CampocustommasterJpaController(managerCplus).findCampocustommaster(codCampoCustomMaster));
                ca.setCodcampocustomlista("");
                ca.setIdentidadeorigem(produtoCplus.getCodprod());
                ca.setNomeentidadeorigem("PRODUTO");
                ca.setValor(valor);
                try {
                    new CampocustomvalorJpaController(managerCplus).create(ca);
                    /////////////////////////////////////////////////////////////
                    configCont--;
                    queryIntegrador.atualizaValorConfiguracao("increment_tabela_campo_valor", String.valueOf(configCont));
                    ///////////////////////////////////////////////////////////////////////////////////////
                } catch (Exception ex) {
                    criaLog(new Date(System.currentTimeMillis()), "Erro ao criar campo personalizado COMPLEMENTO FISCAL no C-plus no Frame Alteracao de pre�o \n" + ex, "Erro Criar");
                }
            }
        } else {
            for (Campocustomvalor campo : listCampo) {
                campo.setValor(valor);
                try {
                    new CampocustomvalorJpaController(managerCplus).edit(campo);
                } catch (Exception ex) {
                    criaLog(new Date(System.currentTimeMillis()), "Erro ao editar campo personalizado COMPLEMENTO FISCAL no C-plus no Frame Alteracao de pre�o \n" + ex, "Erro Editar");
                }
            }
        }
    }

    private void gravaPartNumber(String valor) {
        String codCampoCustomMaster = "000000004";
        List<Campocustomvalor> listCampo = (List<Campocustomvalor>) queryCplus.listCampoMaster(produtoCplus.getCodprod(), codCampoCustomMaster);
        if (listCampo.isEmpty()) {
            Integer configCont = Integer.valueOf(queryIntegrador.valorConfiguracao("increment_tabela_campo_valor"));
            Campocustomvalor ca = new Campocustomvalor();
            ca.setCodcampocustomvalor(String.format("%09d", configCont));
            ca.setCodcampocustommaster(new CampocustommasterJpaController(managerCplus).findCampocustommaster(codCampoCustomMaster));
            ca.setCodcampocustomlista("");
            ca.setIdentidadeorigem(produtoCplus.getCodprod());
            ca.setNomeentidadeorigem("PRODUTO");
            ca.setValor(valor);
            configCont--;
            try {
                queryIntegrador.atualizaValorConfiguracao("increment_tabela_campo_valor", String.valueOf(configCont));

                new CampocustomvalorJpaController(managerCplus).create(ca);

            } catch (Exception ex) {
                criaLog(new Date(System.currentTimeMillis()), "Erro ao criar campo personalizado PART NUMBER no C-plus no Frame Alteracao de pre�o \n" + ex, "Erro Criar");
            }
        } else {
            for (Campocustomvalor campo : listCampo) {
                campo.setValor(valor);
                try {
                    new CampocustomvalorJpaController(managerCplus).edit(campo);
                } catch (Exception ex) {
                    criaLog(new Date(System.currentTimeMillis()), "Erro ao editar campo personalizado PART NUMBER no C-plus no Frame Alteracao de pre�o \n" + ex, "Erro Editar");
                }
            }
        }
    }

    private String complemantoFiscal() {
        //part Number 000000004
        //complemento Fiscal 000000003
        String codCampoCustomMaster = "000000003";
        String retorno = "";
        for (Campocustomvalor campo : queryCplus.listCampoMaster(produtoCplus.getCodprod(), codCampoCustomMaster)) {
            if (campo.getValor() != null) {
                retorno = campo.getValor();
            }
        }
        return retorno;
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
            java.util.logging.Logger.getLogger(ProdutoJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProdutoJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProdutoJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProdutoJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProdutoJFrame(managerCplus, managerIntegrador, managerPrestaShop).setVisible(true);
            }
        });
    }

    private static EntityManagerFactory managerIntegrador;
    private static EntityManagerFactory managerPrestaShop;
    private static EntityManagerFactory managerCplus;
    private final QueryCplus queryCplus;
    private final QueryIntegrador queryIntegrador;
    private final QueryPrestaShop queryPrestaShop;
    private final FormataCampos formataCampo;
    private final int colunaCodprod;
    private int casasDecimais;
    private final int colunaProdutoFornecedor;

    private Produto produtoCplus;
    private BigDecimal precoCustoRealSistema;
    private BigDecimal precoCustoMedioSistema;
    private BigDecimal precoCustoUltimaCompra;
    private List<Produtopreco> listPrecoProduto;
    private List<Produtoestoque> listEstoqueProduto;
    private final ListagemEntradasJDialog listagemEntradasJDialog;
    private final int decimaisArredondamento;
    private final ListagemLocalizacaoJDialog listagemLocalizacaoJDialog;


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupArredondamentoPrecoVenda;
    private javax.swing.ButtonGroup buttonGroupCasasDecimais;
    private javax.swing.ButtonGroup buttonGroupComparaPreco;
    private javax.swing.ButtonGroup buttonGroupCustoProduto;
    private javax.swing.ButtonGroup buttonGroupTiposDeMargem;
    private javax.persistence.EntityManager cplusPUEntityManager;
    private javax.persistence.EntityManager integradorPUEntityManager;
    private javax.swing.JButton jButtonAtivarNoSite;
    private javax.swing.JButton jButtonAtualizaListagemEntradas;
    private javax.swing.JButton jButtonAtualizaListagemSaidas;
    private javax.swing.JButton jButtonAtualizaMargemCusto;
    private javax.swing.JButton jButtonAtualizarCarregaCampos;
    private javax.swing.JButton jButtonDesativarSite;
    private javax.swing.JButton jButtonEditarSetorEstoque;
    private javax.swing.JButton jButtonExcluirregistroFornecedor;
    private javax.swing.JButton jButtonGravar;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JButton jButtonRelacionarProdutoFornecedor;
    private javax.swing.JCheckBox jCheckBoxAtivo;
    private javax.swing.JCheckBox jCheckBoxMostrarItensCarrinhoMagento;
    private javax.swing.JCheckBox jCheckBoxNoSite;
    private javax.swing.JCheckBox jCheckBoxSomenteCompras;
    private javax.swing.JCheckBox jCheckBoxSomenteItensAtivosCplus;
    private javax.swing.JCheckBox jCheckBoxSomenteVendas;
    private javax.swing.JComboBox jComboBoxOrigemProduto;
    private javax.swing.JComboBox jComboBoxTermoPesquisa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelAltura;
    private javax.swing.JLabel jLabelCodigoInterno;
    private javax.swing.JLabel jLabelComplementoFiscal;
    private javax.swing.JLabel jLabelComprimento;
    private javax.swing.JLabel jLabelCustoMedio;
    private javax.swing.JLabel jLabelCustoReal;
    private javax.swing.JLabel jLabelDataUltimaVenda;
    private javax.swing.JLabel jLabelDataUltimoReajuste;
    private javax.swing.JLabel jLabelDataultimaCompra;
    private javax.swing.JLabel jLabelEstoqueAtual;
    private javax.swing.JLabel jLabelEstoqueDisponivel;
    private javax.swing.JLabel jLabelFornecedor;
    private javax.swing.JLabel jLabelLargura;
    private javax.swing.JLabel jLabelMargemNormal;
    private javax.swing.JLabel jLabelMaximoDeResultadosSaida;
    private javax.swing.JLabel jLabelOrigemProduto;
    private javax.swing.JLabel jLabelPartNumberSistema;
    private javax.swing.JLabel jLabelPrecoCusto;
    private javax.swing.JLabel jLabelPrecoNormal;
    private javax.swing.JLabel jLabelPrecoPutrosCustos;
    private javax.swing.JLabel jLabelReservasOrcemento;
    private javax.swing.JLabel jLabelReservasOs;
    private javax.swing.JLabel jLabelSetor;
    private javax.swing.JLabel jLabelTotalOutrosCustos;
    private javax.swing.JLabel jLabelValorIpi;
    private javax.swing.JLabel jLabelValorOutrasDespesas;
    private javax.swing.JLabel jLabelValorOutrosCustos;
    private javax.swing.JLabel jLabelValorSt;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelAbaListaProdutos;
    private javax.swing.JPanel jPanelArredondamentoVenda;
    private javax.swing.JPanel jPanelCasasDecimais;
    private javax.swing.JPanel jPanelComparacaoProdutosAllnations;
    private javax.swing.JPanel jPanelControleFornecedor;
    private javax.swing.JPanel jPanelControles;
    private javax.swing.JPanel jPanelCustos;
    private javax.swing.JPanel jPanelDataMovimento;
    private javax.swing.JPanel jPanelEstoque;
    private javax.swing.JPanel jPanelInformacaoEstoque;
    private javax.swing.JPanel jPanelListagemDeVendas;
    private javax.swing.JPanel jPanelListagemEntradas;
    private javax.swing.JPanel jPanelOutros;
    private javax.swing.JPanel jPanelPesquisa;
    private javax.swing.JPanel jPanelPreco;
    private javax.swing.JPanel jPanelTiposdecalculos;
    private javax.swing.JPanel jPanelconfiguracoesAba;
    private javax.swing.JRadioButton jRadioButtonArredondamentoDoisDecimal;
    private javax.swing.JRadioButton jRadioButtonArredondamentoTresDecimal;
    private javax.swing.JRadioButton jRadioButtonArredondamentoUmDecimal;
    private javax.swing.JRadioButton jRadioButtonCustoSystema;
    private javax.swing.JRadioButton jRadioButtonCustoUltimaCompra;
    private javax.swing.JRadioButton jRadioButtonDuasDecimais;
    private javax.swing.JRadioButton jRadioButtonMargemCustoCplus;
    private javax.swing.JRadioButton jRadioButtonMargemSobreCustoMedioCplus;
    private javax.swing.JRadioButton jRadioButtonMargemSobreCustoUltimaCompra;
    private javax.swing.JRadioButton jRadioButtonQuatroDecimais;
    private javax.swing.JRadioButton jRadioButtonTresDecimais;
    private javax.swing.JRadioButton jRadioButtonUmaDecimal;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPaneListagemProdutos;
    private javax.swing.JTabbedPane jTabbedPaneAlteracaoPrecoProdutoCplus;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableListagemDeVendas;
    private javax.swing.JTable jTableListagemProdutos;
    private javax.swing.JTable jTableProdutoFornecedor;
    private javax.swing.JTextArea jTextAreaEan;
    private javax.swing.JTextArea jTextAreaProdutoComprado;
    private javax.swing.JTextField jTextFieldAltura;
    private javax.swing.JTextField jTextFieldCodigoInterno;
    private javax.swing.JTextField jTextFieldComplementoFiscal;
    private javax.swing.JTextField jTextFieldComprimento;
    private javax.swing.JTextField jTextFieldCustoMedio;
    private javax.swing.JTextField jTextFieldCustoReal;
    private javax.swing.JTextField jTextFieldDataUltimaCompra;
    private javax.swing.JTextField jTextFieldDataUltimaVenda;
    private javax.swing.JTextField jTextFieldDataUltimoReajuste;
    private javax.swing.JTextField jTextFieldEstoqueAtual;
    private javax.swing.JTextField jTextFieldEstoqueDisponivel;
    private javax.swing.JTextField jTextFieldFornecedor;
    private javax.swing.JTextField jTextFieldLargura;
    private javax.swing.JTextField jTextFieldMargemNormal;
    private javax.swing.JTextField jTextFieldMaximoResultadoEntrada;
    private javax.swing.JTextField jTextFieldMaximoResultadosSaida;
    private javax.swing.JTextField jTextFieldNomeCplus;
    private javax.swing.JTextField jTextFieldNomeSite;
    private javax.swing.JTextField jTextFieldPartNumberSistema;
    private javax.swing.JTextField jTextFieldPercOutrosCustos;
    private javax.swing.JTextField jTextFieldPrecoCusto;
    private javax.swing.JTextField jTextFieldPrecoNormal;
    private javax.swing.JTextField jTextFieldReservaOrcamento;
    private javax.swing.JTextField jTextFieldReservaOs;
    private javax.swing.JTextField jTextFieldSetor;
    private javax.swing.JTextField jTextFieldTermoPesquisa;
    private javax.swing.JTextField jTextFieldTotalOutrasDespesas;
    private javax.swing.JTextField jTextFieldUltimaQuantidadeComprada;
    private javax.swing.JTextField jTextFieldUnidade;
    private javax.swing.JTextField jTextFieldValorIpi;
    private javax.swing.JTextField jTextFieldValorOutrasDes;
    private javax.swing.JTextField jTextFieldValorOutrosCustos;
    private javax.swing.JTextField jTextFieldValorSubstituicaoTributaria;
    private java.util.List<entidade.cplus.Movendaprod> movendaprodList;
    private javax.persistence.Query movendaprodQuery;
    private java.util.List<entidade.cplus.Moventradaprod> moventradaprodList;
    private javax.persistence.Query moventradaprodQuery;
    private java.util.List<entidade.integrador.ProdFornecedor> produtoFornecedorList;
    private javax.persistence.Query produtoFornecedorQuery;
    private java.util.List<entidade.cplus.Produto> produtoList;
    private javax.persistence.Query produtoQuery;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

}
