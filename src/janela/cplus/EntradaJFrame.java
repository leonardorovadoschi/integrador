/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package janela.cplus;

import entidade.cplus.Moventrada;
import java.awt.Toolkit;

import java.util.Date;
import javax.persistence.EntityManagerFactory;
import javax.swing.table.DefaultTableModel;
import jpa.cplus.FormapagJpaController;
import jpa.cplus.TransportadoraJpaController;
import query.cplus.QueryCplus;

/**
 *
 * @author leonardo
 */
public class EntradaJFrame extends javax.swing.JFrame {

    /**
     * Creates new form EntradasCplusJFrame
     */
    public EntradaJFrame() {
        initComponents();
        //var = var1;
        //managerCplus = managerCplus1; 
        // jFormattedTextFieldDataFim.setValue(new Date(System.currentTimeMillis()));
        // jFormattedTextFieldDataInicio.setValue(new Date(System.currentTimeMillis()));
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/integrador/icones/logo.png")));
        //new RenderPreco();
        //new RenderHora();
        queryCplus = new QueryCplus();
        format = new FormataCampos();
    }

    public void movEntrada(Moventrada entrada) {
        ent = entrada;
    }

    private void carregaCampos() {
        jButtonPesquisarCfop.setEnabled(true);
        jButtonPesquisarFormaPagamento.setEnabled(true);
        jButtonPesquisarFornecedor.setEnabled(true);
        jButtonPesquisarOperacao.setEnabled(true);
        jButtonPesquisarTransportadora.setEnabled(true);
        if (ent.getFlagnfajuste() == 'N' && ent.getFlagnfcomplementar() == 'N' && ent.getFlagnfdevolucao() == 'N') {
            jComboBoxFinalidadeNfe.setSelectedIndex(0);
        } else if (ent.getFlagnfcomplementar() == 'Y') {
            jComboBoxFinalidadeNfe.setSelectedIndex(1);
        } else if (ent.getFlagnfajuste() == 'Y') {
            jComboBoxFinalidadeNfe.setSelectedIndex(2);
        } else if (ent.getFlagnfdevolucao() == 'Y') {
            jComboBoxFinalidadeNfe.setSelectedIndex(3);
        }
        switch (ent.getIdentificadordestino().toString()) {
            case "1":
                jComboBoxIdentificadorDeDestino.setSelectedIndex(0);
                break;
            case "2":
                jComboBoxIdentificadorDeDestino.setSelectedIndex(1);
                break;
            case "3":
                jComboBoxIdentificadorDeDestino.setSelectedIndex(2);
                break;
        }
        switch (ent.getIndpresenca().toString()) {
            case "0":
                jComboBoxIdentificadorDePresenca.setSelectedIndex(0);
                break;
            case "1":
                jComboBoxIdentificadorDePresenca.setSelectedIndex(1);
                break;
            case "2":
                jComboBoxIdentificadorDePresenca.setSelectedIndex(2);
                break;
            case "3":
                jComboBoxIdentificadorDePresenca.setSelectedIndex(3);
                break;
            case "4":
                jComboBoxIdentificadorDePresenca.setSelectedIndex(4);
                break;
            case "5":
                jComboBoxIdentificadorDePresenca.setSelectedIndex(5);
                break;
            case "9":
                jComboBoxIdentificadorDePresenca.setSelectedIndex(6);
                break;
        }
        //jComboBoxTipoConsumidor;
        if (ent.getDataemissao() != null) {
            jDateChooserDataDeEmissao.setDate(ent.getDataemissao());
        }
        if (ent.getData() != null) {
            jDateChooserDataDeEntrada.setDate(ent.getData());
        }
        if (ent.getFlagfrete() == 'E') {
            jRadioButtonFreteDestinatario.setSelected(false);
            jRadioButtonFreteEmitente.setSelected(true);
        } else {
            jRadioButtonFreteDestinatario.setSelected(true);
            jRadioButtonFreteEmitente.setSelected(false);
        }
        jTextAreaObsNotaFiscal.setText(ent.getObsnotafiscal());
        jTextAreaObservacoes.setText(ent.getObs());
        if (ent.getBaseicms() != null) {
            jTextFieldBaseIcms.setText(format.bigDecimalParaString(ent.getBaseicms(), 2));
        } else {
            jTextFieldBaseIcms.setText("");
        }
        if (ent.getNumerochavenfe() != null) {
            jTextFieldChaveNfe.setText(ent.getNumerochavenfe());
        } else {
            jTextFieldChaveNfe.setText("");
        }
        if (ent.getCodcfop() != null) {
            jTextFieldCodCfop.setText(ent.getCodcfop().getCodcfop());
        } else {
            jTextFieldCodCfop.setText("");
        }
        if (ent.getCodfp() != null) {
            jTextFieldCodFormaPagamento.setText(ent.getCodfp());
            jTextFieldNomeFormaPagamento.setText(new FormapagJpaController(managerCplus).findFormapag(ent.getCodfp()).getDescricao());
        } else {
            jTextFieldCodFormaPagamento.setText("");
            jTextFieldNomeFormaPagamento.setText("");
        }
        if (ent.getFlagforncli() == 'F') {
            if (ent.getCodForn() != null) {
                jTextFieldCodFornecedor.setText(ent.getCodForn().getCodforn());
                jTextFieldNomeFornecedor.setText(ent.getCodForn().getNomeforn());
            } else {
                jTextFieldCodFornecedor.setText("");
                jTextFieldNomeFornecedor.setText("");
            }
        } else {
            if (ent.getCodcli() != null) {
                jTextFieldCodFornecedor.setText(ent.getCodcli().getCodcli());
                jTextFieldNomeFornecedor.setText(ent.getCodcli().getNomecli());
            } else {
                jTextFieldCodFornecedor.setText("");
                jTextFieldNomeFornecedor.setText("");
            }
        }
        if (ent.getCodtipomovimento() != null) {
            jTextFieldCodTipoMovimento.setText(ent.getCodtipomovimento().getCodtipomovimento());
            jTextFieldDescricaoTipoMovimento.setText(ent.getCodtipomovimento().getNometipomovimento());
        }else{
        jTextFieldCodTipoMovimento.setText("");
        jTextFieldDescricaoTipoMovimento.setText("");
        }
        if (ent.getCodtrans() != null) {
            jTextFieldCodTransportadora.setText(ent.getCodtrans());
            jTextFieldNomeTransportadora.setText(new TransportadoraJpaController(managerCplus).findTransportadora(ent.getCodtrans()).getNometrans());
        }else{
        jTextFieldCodTransportadora.setText("");
        jTextFieldNomeTransportadora.setText("");
        }  
       // if (ent.getModelonota() != null) {
       //     jTextFieldDescrisaoModelo.setText(ent.getModelonota());
        //}else{
       // jTextFieldDescrisaoModelo.setText("");
        //}
        if (ent.getModelonota() != null) {
            jTextFieldModelo.setText(ent.getModelonota());
           // jTextFieldDescrisaoModelo.setText(new nf);
        }else{
        jTextFieldModelo.setText("");
        jTextFieldDescrisaoModelo.setText("");
        }  
        
        jTextFieldNumDaNota.setText("");
        jTextFieldSerie.setText("");
        jTextFieldValorAcrescimo.setText("");
        jTextFieldValorCofins.setText("");
        jTextFieldValorDesconto.setText("");
        jTextFieldValorDoFrete.setText("");
        jTextFieldValorIcms.setText("");
        jTextFieldValorOutrasDespesas.setText("");
        jTextFieldValorPis.setText("");
        jTextFieldValorTotalIpi.setText("");
        jTextFieldValorTotalNota.setText("");
        jTextFieldValorTotalProdutos.setText("");
        while (jTableMovEntradaProd.getModel().getRowCount() > 0) {
            ((DefaultTableModel) jTableMovEntradaProd.getModel()).removeRow(0);
        }
    }

    private void limpacampos() {
        jButtonPesquisarCfop.setEnabled(false);
        jButtonPesquisarFormaPagamento.setEnabled(false);
        jButtonPesquisarFornecedor.setEnabled(false);
        jButtonPesquisarOperacao.setEnabled(false);
        jButtonPesquisarTransportadora.setEnabled(false);
        //jComboBoxFinalidadeNfe;
        //jComboBoxIdentificadorDeDestino;
        //jComboBoxIdentificadorDePresenca;
        //jComboBoxTipoConsumidor;
        //jDateChooserDataDeEmissao;
        //jDateChooserDataDeEntrada;  
        //jRadioButtonFreteDestinatario;
        //jRadioButtonFreteEmitente;   
        jTextAreaObsNotaFiscal.setText("");
        jTextAreaObservacoes.setText("");
        jTextFieldBaseIcms.setText("");
        jTextFieldChaveNfe.setText("");
        jTextFieldCodCfop.setText("");
        jTextFieldCodFormaPagamento.setText("");
        jTextFieldCodFornecedor.setText("");
        jTextFieldCodTipoMovimento.setText("");
        jTextFieldCodTransportadora.setText("");
        jTextFieldDescricaoTipoMovimento.setText("");
        jTextFieldDescrisaoModelo.setText("");
        jTextFieldModelo.setText("");
        jTextFieldNomeFormaPagamento.setText("");
        jTextFieldNomeFornecedor.setText("");
        jTextFieldNomeTransportadora.setText("");
        jTextFieldNumDaNota.setText("");
        jTextFieldSerie.setText("");
        jTextFieldValorAcrescimo.setText("");
        jTextFieldValorCofins.setText("");
        jTextFieldValorDesconto.setText("");
        jTextFieldValorDoFrete.setText("");
        jTextFieldValorIcms.setText("");
        jTextFieldValorOutrasDespesas.setText("");
        jTextFieldValorPis.setText("");
        jTextFieldValorTotalIpi.setText("");
        jTextFieldValorTotalNota.setText("");
        jTextFieldValorTotalProdutos.setText("");
        while (jTableMovEntradaProd.getModel().getRowCount() > 0) {
            ((DefaultTableModel) jTableMovEntradaProd.getModel()).removeRow(0);
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

        moventradaList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(((javax.persistence.Query)null).getResultList());
        fabricanteList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : ((javax.persistence.Query)null).getResultList();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMovEntradaProd = new javax.swing.JTable();
        jDateChooserDataDeEmissao = new com.toedter.calendar.JDateChooser();
        jLabelDataDeEmissao = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jDateChooserDataDeEntrada = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldCodTipoMovimento = new javax.swing.JTextField();
        jButtonPesquisarOperacao = new javax.swing.JButton();
        jTextFieldDescricaoTipoMovimento = new javax.swing.JTextField();
        jLabelNDaNota = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldNumDaNota = new javax.swing.JTextField();
        jTextFieldSerie = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldModelo = new javax.swing.JTextField();
        jTextFieldDescrisaoModelo = new javax.swing.JTextField();
        jLabelCfop = new javax.swing.JLabel();
        jTextFieldCodCfop = new javax.swing.JTextField();
        jButtonPesquisarCfop = new javax.swing.JButton();
        jLabelCodFornecedor = new javax.swing.JLabel();
        jTextFieldCodFornecedor = new javax.swing.JTextField();
        jButtonPesquisarFornecedor = new javax.swing.JButton();
        jTextFieldNomeFornecedor = new javax.swing.JTextField();
        jLabelBaseIcms = new javax.swing.JLabel();
        jTextFieldBaseIcms = new javax.swing.JTextField();
        jLabelValorIcms = new javax.swing.JLabel();
        jTextFieldValorIcms = new javax.swing.JTextField();
        jLabelValorDesconto = new javax.swing.JLabel();
        jTextFieldValorDesconto = new javax.swing.JTextField();
        jLabelValorAcrescimo = new javax.swing.JLabel();
        jTextFieldValorAcrescimo = new javax.swing.JTextField();
        jLabelValorDoFrete = new javax.swing.JLabel();
        jTextFieldValorDoFrete = new javax.swing.JTextField();
        jLabelValorOutrasDespesas = new javax.swing.JLabel();
        jTextFieldValorOutrasDespesas = new javax.swing.JTextField();
        jLabelValorPis = new javax.swing.JLabel();
        jTextFieldValorPis = new javax.swing.JTextField();
        jLabelValorCofins = new javax.swing.JLabel();
        jTextFieldValorCofins = new javax.swing.JTextField();
        jTextFieldValorTotalIpi = new javax.swing.JTextField();
        jLabelValorIpi = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldValorTotalProdutos = new javax.swing.JTextField();
        jLabelFormaDePagamento = new javax.swing.JLabel();
        jTextFieldCodFormaPagamento = new javax.swing.JTextField();
        jButtonPesquisarFormaPagamento = new javax.swing.JButton();
        jTextFieldNomeFormaPagamento = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldValorTotalNota = new javax.swing.JTextField();
        jTabbedPaneObservacoes = new javax.swing.JTabbedPane();
        jPanelObservacoes = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaObservacoes = new javax.swing.JTextArea();
        jPanelObsNotaFiscal = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaObsNotaFiscal = new javax.swing.JTextArea();
        jPanelOutrosDados = new javax.swing.JPanel();
        jLabelChaveNfe = new javax.swing.JLabel();
        jTextFieldChaveNfe = new javax.swing.JTextField();
        jLabelTransportadora = new javax.swing.JLabel();
        jTextFieldCodTransportadora = new javax.swing.JTextField();
        jButtonPesquisarTransportadora = new javax.swing.JButton();
        jTextFieldNomeTransportadora = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jRadioButtonFreteEmitente = new javax.swing.JRadioButton();
        jRadioButtonFreteDestinatario = new javax.swing.JRadioButton();
        jPanelFinalidadeNfe = new javax.swing.JPanel();
        jLabelFinalidadeNfe = new javax.swing.JLabel();
        jComboBoxFinalidadeNfe = new javax.swing.JComboBox();
        jLabelTipoConsumidor = new javax.swing.JLabel();
        jComboBoxTipoConsumidor = new javax.swing.JComboBox();
        jLabelIndentificadorDePresença = new javax.swing.JLabel();
        jComboBoxIdentificadorDePresenca = new javax.swing.JComboBox();
        jLabelIdentificadorDeDestino = new javax.swing.JLabel();
        jComboBoxIdentificadorDeDestino = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTableMovEntradaProd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome Produto", "Quantidade", "Val. Unitário", "Val Desconto", "Val Acréscimo", "CFOP", "S.T.", "Val Total", "Aliq. IPI", "Val IPI", "Base ICMS", "Aliq. ICMS", "Val. ICMS", "CST PIS", "Base PIS", "Val. PIS", "CST COFINS", "Base COFINS", "Val. COFINS", "NCM", "Codmoventradaprod"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableMovEntradaProd.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTableMovEntradaProd.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableMovEntradaProd);
        if (jTableMovEntradaProd.getColumnModel().getColumnCount() > 0) {
            jTableMovEntradaProd.getColumnModel().getColumn(1).setPreferredWidth(250);
        }

        jLabelDataDeEmissao.setText("Dara da Emissão");

        jLabel1.setText("Data da Entrada");

        jLabel2.setText("Operação");

        jButtonPesquisarOperacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/lupa.png"))); // NOI18N

        jLabelNDaNota.setText("Nº da Nota");

        jLabel4.setText("Série");

        jLabel3.setText("Modelo");

        jLabelCfop.setText("CFOP");

        jButtonPesquisarCfop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/lupa.png"))); // NOI18N

        jLabelCodFornecedor.setText("Fornecedor");

        jButtonPesquisarFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/lupa.png"))); // NOI18N

        jLabelBaseIcms.setText("Base ICMS");

        jLabelValorIcms.setText("Valor ICMS");

        jLabelValorDesconto.setText("Valor Desconto");

        jLabelValorAcrescimo.setText("Valor Acréscimo");

        jLabelValorDoFrete.setText("Valor do Frete");

        jLabelValorOutrasDespesas.setText("Valor Outras desp.");

        jLabelValorPis.setText("Valor PIS");

        jLabelValorCofins.setText("Valor COFINS");

        jLabelValorIpi.setText("Valor IPI");

        jLabel5.setText("Valor Total Produtos");

        jLabelFormaDePagamento.setText("Forma de Pagamento");

        jButtonPesquisarFormaPagamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/lupa.png"))); // NOI18N

        jLabel6.setText("Valor Total da Nota");

        jTabbedPaneObservacoes.setBorder(javax.swing.BorderFactory.createTitledBorder("Observações"));

        jTextAreaObservacoes.setColumns(20);
        jTextAreaObservacoes.setRows(5);
        jScrollPane2.setViewportView(jTextAreaObservacoes);

        javax.swing.GroupLayout jPanelObservacoesLayout = new javax.swing.GroupLayout(jPanelObservacoes);
        jPanelObservacoes.setLayout(jPanelObservacoesLayout);
        jPanelObservacoesLayout.setHorizontalGroup(
            jPanelObservacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
        );
        jPanelObservacoesLayout.setVerticalGroup(
            jPanelObservacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
        );

        jTabbedPaneObservacoes.addTab("Observações", jPanelObservacoes);

        jTextAreaObsNotaFiscal.setColumns(20);
        jTextAreaObsNotaFiscal.setRows(5);
        jScrollPane3.setViewportView(jTextAreaObsNotaFiscal);

        javax.swing.GroupLayout jPanelObsNotaFiscalLayout = new javax.swing.GroupLayout(jPanelObsNotaFiscal);
        jPanelObsNotaFiscal.setLayout(jPanelObsNotaFiscalLayout);
        jPanelObsNotaFiscalLayout.setHorizontalGroup(
            jPanelObsNotaFiscalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
        );
        jPanelObsNotaFiscalLayout.setVerticalGroup(
            jPanelObsNotaFiscalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
        );

        jTabbedPaneObservacoes.addTab("Obs. Nota Fiscal", jPanelObsNotaFiscal);

        jLabelChaveNfe.setText("Chave de Acesso NF-e");

        jLabelTransportadora.setText("Transportadora");

        jButtonPesquisarTransportadora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/lupa.png"))); // NOI18N

        jLabel7.setText("Frete Por Conta");

        jRadioButtonFreteEmitente.setText("Emitente");

        jRadioButtonFreteDestinatario.setText("Destinatário");

        javax.swing.GroupLayout jPanelOutrosDadosLayout = new javax.swing.GroupLayout(jPanelOutrosDados);
        jPanelOutrosDados.setLayout(jPanelOutrosDadosLayout);
        jPanelOutrosDadosLayout.setHorizontalGroup(
            jPanelOutrosDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOutrosDadosLayout.createSequentialGroup()
                .addGroup(jPanelOutrosDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelChaveNfe, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addComponent(jTextFieldChaveNfe)
                    .addComponent(jLabelTransportadora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelOutrosDadosLayout.createSequentialGroup()
                        .addGroup(jPanelOutrosDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jRadioButtonFreteDestinatario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jRadioButtonFreteEmitente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelOutrosDadosLayout.createSequentialGroup()
                                .addComponent(jTextFieldCodTransportadora, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonPesquisarTransportadora, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNomeTransportadora)))
                .addContainerGap())
        );
        jPanelOutrosDadosLayout.setVerticalGroup(
            jPanelOutrosDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOutrosDadosLayout.createSequentialGroup()
                .addComponent(jLabelChaveNfe)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldChaveNfe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTransportadora)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelOutrosDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldCodTransportadora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisarTransportadora, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNomeTransportadora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonFreteEmitente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonFreteDestinatario)
                .addGap(0, 45, Short.MAX_VALUE))
        );

        jTabbedPaneObservacoes.addTab("Outros Dados", jPanelOutrosDados);

        jLabelFinalidadeNfe.setText("Finalidade NF-e");

        jComboBoxFinalidadeNfe.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1- NF-e Normal", "2- NF-e Complementar", "3- NF-e Ajuste", "4- NF-e Devolução" }));

        jLabelTipoConsumidor.setText("Tipo de Consumidor");

        jComboBoxTipoConsumidor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1-Normal", "2-Consumidor Final" }));

        jLabelIndentificadorDePresença.setText("Identificador de Presença");

        jComboBoxIdentificadorDePresenca.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0 - Não se aplica", "1 - Operação presencial", "2 - Operação não presencial (internet)", "3 - Operação não presencial (teleatendimento)", "4 - NFC-e em operação com entrega em domicílio", "5 - Operação presencial, fora do estabelecimento", "6 - Operação não presencial (outros)" }));

        jLabelIdentificadorDeDestino.setText("Identificador de Destino");

        jComboBoxIdentificadorDeDestino.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1 - Operação Interna", "2 - Operação Interestadual", "3 - Operação com Exterior", " " }));

        javax.swing.GroupLayout jPanelFinalidadeNfeLayout = new javax.swing.GroupLayout(jPanelFinalidadeNfe);
        jPanelFinalidadeNfe.setLayout(jPanelFinalidadeNfeLayout);
        jPanelFinalidadeNfeLayout.setHorizontalGroup(
            jPanelFinalidadeNfeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFinalidadeNfeLayout.createSequentialGroup()
                .addGroup(jPanelFinalidadeNfeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelFinalidadeNfe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxFinalidadeNfe, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelTipoConsumidor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxTipoConsumidor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelIndentificadorDePresença, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxIdentificadorDePresenca, 0, 388, Short.MAX_VALUE)
                    .addComponent(jLabelIdentificadorDeDestino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxIdentificadorDeDestino, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelFinalidadeNfeLayout.setVerticalGroup(
            jPanelFinalidadeNfeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFinalidadeNfeLayout.createSequentialGroup()
                .addComponent(jLabelFinalidadeNfe)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxFinalidadeNfe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTipoConsumidor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxTipoConsumidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelIndentificadorDePresença)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxIdentificadorDePresenca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelIdentificadorDeDestino)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxIdentificadorDeDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 21, Short.MAX_VALUE))
        );

        jTabbedPaneObservacoes.addTab("Dados Fiscais", jPanelFinalidadeNfe);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextFieldNumDaNota)
                            .addComponent(jLabelNDaNota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateChooserDataDeEmissao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelDataDeEmissao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jDateChooserDataDeEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jTextFieldCodTipoMovimento))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonPesquisarOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextFieldSerie, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextFieldModelo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldDescrisaoModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextFieldCodCfop, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelCfop, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonPesquisarCfop, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextFieldDescricaoTipoMovimento, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextFieldCodFornecedor, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelCodFornecedor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonPesquisarFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jTextFieldNomeFornecedor))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jTextFieldCodFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonPesquisarFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldNomeFormaPagamento))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jTextFieldValorOutrasDespesas, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelValorOutrasDespesas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabelValorPis, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                            .addComponent(jTextFieldValorPis))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelValorCofins, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jTextFieldValorCofins)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabelBaseIcms, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                            .addComponent(jTextFieldBaseIcms, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabelValorIcms, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextFieldValorIcms, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabelValorDesconto, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                            .addComponent(jTextFieldValorDesconto)))
                                    .addComponent(jLabelFormaDePagamento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabelValorAcrescimo, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(jTextFieldValorAcrescimo)
                                    .addComponent(jTextFieldValorTotalIpi)
                                    .addComponent(jLabelValorIpi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelValorDoFrete, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(jTextFieldValorDoFrete)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldValorTotalProdutos)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldValorTotalNota))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPaneObservacoes)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelDataDeEmissao)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDateChooserDataDeEmissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jDateChooserDataDeEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldCodTipoMovimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jTextFieldDescricaoTipoMovimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButtonPesquisarOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelNDaNota)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextFieldNumDaNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldDescrisaoModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelCfop)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldCodCfop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonPesquisarCfop, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelCodFornecedor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextFieldCodFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButtonPesquisarFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabelBaseIcms)
                                            .addComponent(jLabelValorIcms)
                                            .addComponent(jLabelValorDesconto)
                                            .addComponent(jLabelValorAcrescimo)
                                            .addComponent(jLabelValorDoFrete))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jTextFieldBaseIcms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextFieldValorIcms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextFieldValorDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextFieldValorAcrescimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextFieldValorDoFrete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jTextFieldNomeFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelValorOutrasDespesas)
                                    .addComponent(jLabelValorPis)
                                    .addComponent(jLabelValorCofins)
                                    .addComponent(jLabelValorIpi)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextFieldValorOutrasDespesas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldValorPis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldValorCofins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldValorTotalIpi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldValorTotalProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelFormaDePagamento)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jTextFieldCodFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonPesquisarFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTextFieldValorTotalNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jTextFieldNomeFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jTabbedPaneObservacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(EntradaJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EntradaJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EntradaJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EntradaJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EntradaJFrame().setVisible(true);
            }
        });
    }

    private final FormataCampos format;
    private final QueryCplus queryCplus;
    private Moventrada ent;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.util.List<entidade.cplus.Fabricante> fabricanteList;
    private javax.swing.JButton jButtonPesquisarCfop;
    private javax.swing.JButton jButtonPesquisarFormaPagamento;
    private javax.swing.JButton jButtonPesquisarFornecedor;
    private javax.swing.JButton jButtonPesquisarOperacao;
    private javax.swing.JButton jButtonPesquisarTransportadora;
    private javax.swing.JComboBox jComboBoxFinalidadeNfe;
    private javax.swing.JComboBox jComboBoxIdentificadorDeDestino;
    private javax.swing.JComboBox jComboBoxIdentificadorDePresenca;
    private javax.swing.JComboBox jComboBoxTipoConsumidor;
    private com.toedter.calendar.JDateChooser jDateChooserDataDeEmissao;
    private com.toedter.calendar.JDateChooser jDateChooserDataDeEntrada;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelBaseIcms;
    private javax.swing.JLabel jLabelCfop;
    private javax.swing.JLabel jLabelChaveNfe;
    private javax.swing.JLabel jLabelCodFornecedor;
    private javax.swing.JLabel jLabelDataDeEmissao;
    private javax.swing.JLabel jLabelFinalidadeNfe;
    private javax.swing.JLabel jLabelFormaDePagamento;
    private javax.swing.JLabel jLabelIdentificadorDeDestino;
    private javax.swing.JLabel jLabelIndentificadorDePresença;
    private javax.swing.JLabel jLabelNDaNota;
    private javax.swing.JLabel jLabelTipoConsumidor;
    private javax.swing.JLabel jLabelTransportadora;
    private javax.swing.JLabel jLabelValorAcrescimo;
    private javax.swing.JLabel jLabelValorCofins;
    private javax.swing.JLabel jLabelValorDesconto;
    private javax.swing.JLabel jLabelValorDoFrete;
    private javax.swing.JLabel jLabelValorIcms;
    private javax.swing.JLabel jLabelValorIpi;
    private javax.swing.JLabel jLabelValorOutrasDespesas;
    private javax.swing.JLabel jLabelValorPis;
    private javax.swing.JPanel jPanelFinalidadeNfe;
    private javax.swing.JPanel jPanelObsNotaFiscal;
    private javax.swing.JPanel jPanelObservacoes;
    private javax.swing.JPanel jPanelOutrosDados;
    private javax.swing.JRadioButton jRadioButtonFreteDestinatario;
    private javax.swing.JRadioButton jRadioButtonFreteEmitente;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPaneObservacoes;
    private javax.swing.JTable jTableMovEntradaProd;
    private javax.swing.JTextArea jTextAreaObsNotaFiscal;
    private javax.swing.JTextArea jTextAreaObservacoes;
    private javax.swing.JTextField jTextFieldBaseIcms;
    private javax.swing.JTextField jTextFieldChaveNfe;
    private javax.swing.JTextField jTextFieldCodCfop;
    private javax.swing.JTextField jTextFieldCodFormaPagamento;
    private javax.swing.JTextField jTextFieldCodFornecedor;
    private javax.swing.JTextField jTextFieldCodTipoMovimento;
    private javax.swing.JTextField jTextFieldCodTransportadora;
    private javax.swing.JTextField jTextFieldDescricaoTipoMovimento;
    private javax.swing.JTextField jTextFieldDescrisaoModelo;
    private javax.swing.JTextField jTextFieldModelo;
    private javax.swing.JTextField jTextFieldNomeFormaPagamento;
    private javax.swing.JTextField jTextFieldNomeFornecedor;
    private javax.swing.JTextField jTextFieldNomeTransportadora;
    private javax.swing.JTextField jTextFieldNumDaNota;
    private javax.swing.JTextField jTextFieldSerie;
    private javax.swing.JTextField jTextFieldValorAcrescimo;
    private javax.swing.JTextField jTextFieldValorCofins;
    private javax.swing.JTextField jTextFieldValorDesconto;
    private javax.swing.JTextField jTextFieldValorDoFrete;
    private javax.swing.JTextField jTextFieldValorIcms;
    private javax.swing.JTextField jTextFieldValorOutrasDespesas;
    private javax.swing.JTextField jTextFieldValorPis;
    private javax.swing.JTextField jTextFieldValorTotalIpi;
    private javax.swing.JTextField jTextFieldValorTotalNota;
    private javax.swing.JTextField jTextFieldValorTotalProdutos;
    private java.util.List<entidade.cplus.Moventrada> moventradaList;
    // End of variables declaration//GEN-END:variables
    static EntityManagerFactory managerCplus;
   // static VariavelStatica var;
}
