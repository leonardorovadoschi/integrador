/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package janela.cplus;


import entidade.cplus.Movenda;
import integrador.render.RenderDataEHora;
import integrador.render.RenderHora;
import integrador.render.RenderPreco;
import integrador.render.RenderStatusPedido;
import java.awt.Color;
import java.awt.Toolkit;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.swing.JOptionPane;
import jpa.cplus.MovendaJpaController;
import query.cplus.QueryCplus;

/**
 *
 * @author leonardo
 */
public class ListagemSaidasJDialog extends javax.swing.JDialog {

    /**
     * Creates new form ListagemSaidasJDialog
     * @param parent
     * @param modal
     * @param managerCplus1
     */
    public ListagemSaidasJDialog(java.awt.Frame parent, boolean modal, EntityManagerFactory managerCplus1) {
        super(parent, modal);
        initComponents();
        managerCplus = managerCplus1;
        queryCplus = new QueryCplus(managerCplus);
        colunaCodMoVenda = jTableListagemSaidas.getColumnModel().getColumnIndex("codmovenda");
        colunaStatus = jTableListagemSaidas.getColumnModel().getColumnIndex("Status");
        indexComboBox = 0;
        formatacaoCampos = new FormataCampos();       
        jDateChooserDataFinal.setDate(formatacaoCampos.alteraDiaData(formatacaoCampos.dataAtual(), 0));
        jDateChooserDataInicial.setDate(formatacaoCampos.alteraDiaData(formatacaoCampos.dataAtual(), -2));
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icones/logo.png")));
        //this.listagemClientesJDialog = new ListagemClientesJDialog(parent, true, managerCplus1);
        //new RenderStatusPedido();
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
        movendaQuery = java.beans.Beans.isDesignTime() ? null : cplusPUEntityManager.createQuery("SELECT ven FROM Movenda ven WHERE ven.numped = 99999");
        movendaList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(movendaQuery.getResultList());
        jPanelPesquisas = new javax.swing.JPanel();
        jComboBoxTipoPesquisa = new javax.swing.JComboBox();
        jTextFieldTermoPesquisa = new javax.swing.JTextField();
        jButtonPesquisar = new javax.swing.JButton();
        jLabelDataInicial = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jCheckBoxCupom = new javax.swing.JCheckBox();
        jLabelMensagem = new javax.swing.JLabel();
        jDateChooserDataInicial = new com.toedter.calendar.JDateChooser();
        jDateChooserDataFinal = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableListagemSaidas = new javax.swing.JTable();
        jButtonOk = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Listagem de Sa�das");

        jPanelPesquisas.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisa"));

        jComboBoxTipoPesquisa.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jComboBoxTipoPesquisa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Numero Pedido", "Numero Nota", "Numero Cupom", "Por Data", "Entrega Telefone", "Numero NFC-e", "Observa��es" }));
        jComboBoxTipoPesquisa.setToolTipText("Selecione o que quer pesquisar!");
        jComboBoxTipoPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipoPesquisaActionPerformed(evt);
            }
        });

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

        jLabelDataInicial.setText("Data Inicial:");

        jLabel1.setText("Data Final:");

        jCheckBoxCupom.setText("Somente Cupom");

        javax.swing.GroupLayout jPanelPesquisasLayout = new javax.swing.GroupLayout(jPanelPesquisas);
        jPanelPesquisas.setLayout(jPanelPesquisasLayout);
        jPanelPesquisasLayout.setHorizontalGroup(
            jPanelPesquisasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPesquisasLayout.createSequentialGroup()
                .addGroup(jPanelPesquisasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelPesquisasLayout.createSequentialGroup()
                        .addComponent(jLabelDataInicial)
                        .addGap(1, 1, 1)
                        .addComponent(jDateChooserDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooserDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBoxCupom))
                    .addGroup(jPanelPesquisasLayout.createSequentialGroup()
                        .addComponent(jComboBoxTipoPesquisa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldTermoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jButtonPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelPesquisasLayout.setVerticalGroup(
            jPanelPesquisasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPesquisasLayout.createSequentialGroup()
                .addGroup(jPanelPesquisasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPesquisasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPesquisasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonPesquisar)
                            .addComponent(jTextFieldTermoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jComboBoxTipoPesquisa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelPesquisasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooserDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelPesquisasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jDateChooserDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanelPesquisasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelDataInicial)
                            .addComponent(jLabel1)
                            .addComponent(jCheckBoxCupom))))
                .addGap(0, 7, Short.MAX_VALUE))
        );

        jTableListagemSaidas.setAutoCreateRowSorter(true);
        jTableListagemSaidas.setToolTipText("Listagem de Saidas");
        jTableListagemSaidas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, movendaList, jTableListagemSaidas);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nomecli}"));
        columnBinding.setColumnName("Nome Cliente");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codForn.nomeforn}"));
        columnBinding.setColumnName("Nome Fornecedor");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codtipomovimento.nometipomovimento}"));
        columnBinding.setColumnName("Opera��o");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${flagcancelada}"));
        columnBinding.setColumnName("Status");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${numped}"));
        columnBinding.setColumnName("Num. Pedido");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codcli.estado}"));
        columnBinding.setColumnName("Estado UF");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codcfop.codcfop}"));
        columnBinding.setColumnName("CFOP");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${numnota}"));
        columnBinding.setColumnName("Num. Nota");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${entregatelefone}"));
        columnBinding.setColumnName("Entrega Telefone");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${numcupom}"));
        columnBinding.setColumnName("Num. Cupom");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${valortotalnota}"));
        columnBinding.setColumnName("Valor Total Nota");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${valortotalprodutos}"));
        columnBinding.setColumnName("Valor Total Produtos");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${valortotalpis}"));
        columnBinding.setColumnName("Valor Total PIS");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${valortotalcofins}"));
        columnBinding.setColumnName("ValorTotal COFINS");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${valortotalipi}"));
        columnBinding.setColumnName("Valor Total IPI");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${quantidadevolumes}"));
        columnBinding.setColumnName("Quan. Volumes");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${basesubsttributaria}"));
        columnBinding.setColumnName("Base S.T.");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${valoricms}"));
        columnBinding.setColumnName("Valor ICMS");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${baseicms}"));
        columnBinding.setColumnName("Base ICMS");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${obsnotafiscal}"));
        columnBinding.setColumnName("Observa��es");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${hora}"));
        columnBinding.setColumnName("Hora");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${data}"));
        columnBinding.setColumnName("Data");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${valorsubsttributaria}"));
        columnBinding.setColumnName("Valor S.T.");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${pesoliquido}"));
        columnBinding.setColumnName("Peso Liquido");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${pesobruto}"));
        columnBinding.setColumnName("Peso Bruto");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${datalancamento}"));
        columnBinding.setColumnName("Data Lan�amento");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codmovenda}"));
        columnBinding.setColumnName("codmovenda");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jTableListagemSaidas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableListagemSaidasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableListagemSaidas);
        if (jTableListagemSaidas.getColumnModel().getColumnCount() > 0) {
            jTableListagemSaidas.getColumnModel().getColumn(0).setMinWidth(150);
            jTableListagemSaidas.getColumnModel().getColumn(0).setPreferredWidth(250);
            jTableListagemSaidas.getColumnModel().getColumn(0).setMaxWidth(450);
            jTableListagemSaidas.getColumnModel().getColumn(2).setMinWidth(120);
            jTableListagemSaidas.getColumnModel().getColumn(2).setPreferredWidth(180);
            jTableListagemSaidas.getColumnModel().getColumn(2).setMaxWidth(350);
            jTableListagemSaidas.getColumnModel().getColumn(3).setCellRenderer(new RenderStatusPedido());
            jTableListagemSaidas.getColumnModel().getColumn(10).setCellRenderer(new RenderPreco());
            jTableListagemSaidas.getColumnModel().getColumn(11).setCellRenderer(new RenderPreco());
            jTableListagemSaidas.getColumnModel().getColumn(12).setCellRenderer(new RenderPreco());
            jTableListagemSaidas.getColumnModel().getColumn(13).setCellRenderer(new RenderPreco());
            jTableListagemSaidas.getColumnModel().getColumn(14).setCellRenderer(new RenderPreco());
            jTableListagemSaidas.getColumnModel().getColumn(16).setCellRenderer(new RenderPreco());
            jTableListagemSaidas.getColumnModel().getColumn(17).setCellRenderer(new RenderPreco());
            jTableListagemSaidas.getColumnModel().getColumn(18).setCellRenderer(new RenderPreco());
            jTableListagemSaidas.getColumnModel().getColumn(20).setCellRenderer(new RenderHora());
            jTableListagemSaidas.getColumnModel().getColumn(22).setCellRenderer(new RenderPreco());
            jTableListagemSaidas.getColumnModel().getColumn(25).setCellRenderer(new RenderDataEHora());
        }

        jButtonOk.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/ok.png"))); // NOI18N
        jButtonOk.setText("OK!");
        jButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOkActionPerformed(evt);
            }
        });

        jButtonCancelar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/cancelar.png"))); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPesquisas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 795, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonOk)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonCancelar)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelPesquisas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonOk)
                    .addComponent(jButtonCancelar))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOkActionPerformed
        finalizacao();
    }//GEN-LAST:event_jButtonOkActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        cancelamento();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jTextFieldTermoPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTermoPesquisaActionPerformed
        pesquisas();
    }//GEN-LAST:event_jTextFieldTermoPesquisaActionPerformed

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
       pesquisas();
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jComboBoxTipoPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipoPesquisaActionPerformed
        setIndexComboBox(jComboBoxTipoPesquisa.getSelectedIndex());
    }//GEN-LAST:event_jComboBoxTipoPesquisaActionPerformed

    private void jTableListagemSaidasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListagemSaidasMouseClicked
        colunaStatus = jTableListagemSaidas.getColumnModel().getColumnIndex("Status");
        String status = jTableListagemSaidas.getValueAt(jTableListagemSaidas.getSelectedRow(), colunaStatus).toString();
        if("Y".equals(status)){
            jLabelMensagem.setForeground(Color.red);
            jLabelMensagem.setText("Saida Cancelada");
            
        }else{
            jLabelMensagem.setForeground(Color.black);
             jLabelMensagem.setText("");
        }
    }//GEN-LAST:event_jTableListagemSaidasMouseClicked

    
    private void cancelamento(){
        int cancelar = JOptionPane.showConfirmDialog(null, " Deseja realmente cancelar? \n O processo ser� encerrado!!", "Cancelar", JOptionPane.YES_NO_CANCEL_OPTION);
            if (cancelar == JOptionPane.YES_OPTION) {
                setCancelamento(true);
                dispose();
            }
    }
    
    private void pesquisas(){           
        jLabelMensagem.setText("");
        List<Movenda> listMovenda;
         switch (jComboBoxTipoPesquisa.getSelectedIndex()) {
            case 0://por numero do pedido 
                movendaList.clear();
                if (!"".equals(jTextFieldTermoPesquisa.getText())) {
                    listMovenda = queryCplus.listaMovendaPorNumeroPedido(Integer.parseInt(jTextFieldTermoPesquisa.getText()));
                     
                    if (listMovenda.size() < 1) {
                        JOptionPane.showMessageDialog(null, "N�o foi encontrado resultado para essa pesquisa!!! ");
                    } else {                       
                        for (Movenda sai : listMovenda) {
                            movendaList.add(sai);
                        }
                    }  
                }
                break;
            case 1://por numero da nota
                movendaList.clear();
                 if (!"".equals(jTextFieldTermoPesquisa.getText())) {
                listMovenda = queryCplus.listaMovendaPorNumeroNota(Integer.parseInt(jTextFieldTermoPesquisa.getText()));
                
                    if (listMovenda.size() < 1) {
                        JOptionPane.showMessageDialog(null, "N�o foi encontrado resultado para essa pesquisa!!! ");
                    } else {                       
                        for (Movenda sai : listMovenda) {
                            movendaList.add(sai);
                        }
                    } 
                 }
                break;
            case 2://pro numero cupom fiscal
                movendaList.clear();
                 if (!"".equals(jTextFieldTermoPesquisa.getText())) {
                listMovenda = queryCplus.listaMovendaPorNumeroCupom(Integer.parseInt(jTextFieldTermoPesquisa.getText()));
                
                    if (listMovenda.size() < 1) {
                        JOptionPane.showMessageDialog(null, "N�o foi encontrado resultado para essa pesquisa!!! ");
                    } else {                       
                        for (Movenda sai : listMovenda) {
                            movendaList.add(sai);
                        }
                    }    
                 }
                break;
            case 3://por formatacaoCampos
                if(jCheckBoxCupom.isSelected()){
                  pesquisaPorDataECupom();
              }else{
              pesquisaPorData();
              }
                break;
            case 4 :
                pesquisaEntregaTelefone();
                break;
            case 5 :
                pesquisaNumeroNFCe();
                break;
            case 6 :
                pesquisaObservacoes();
                break;
        }
    }
    
     private void pesquisaObservacoes() {
         movendaList.clear();
        if (!"".equals(jTextFieldTermoPesquisa.getText())) {
            String i = jTextFieldTermoPesquisa.getText();
            for (Movenda ven : queryCplus.listaMovendaObservacao(i)) {
                movendaList.add(ven);
            }
        }
    }
       
    
    private void pesquisaNumeroNFCe(){
        movendaList.clear();
        if (!"".equals(jTextFieldTermoPesquisa.getText())) {
            int i = Integer.parseInt( jTextFieldTermoPesquisa.getText());
            for (Movenda ven : queryCplus.listaMovendaPorNumeroNFCe(String.format("%09d", i))) {
                movendaList.add(ven);
            }
        }
    }
    
    private void pesquisaEntregaTelefone() {
        movendaList.clear();
        if (!"".equals(jTextFieldTermoPesquisa.getText())) {
            for (Movenda ven : queryCplus.resultMovendaPorEntregaTelefone(jTextFieldTermoPesquisa.getText())) {
                movendaList.add(ven);
            }
        }
    }
    /**
     * fun��o que pesquisa pela data da saida e se for cupom fiscal
     */
    private void pesquisaPorDataECupom(){
        movendaList.clear();
        for(Movenda ven : queryCplus.listaMovendaPorDataECupomPedido(jDateChooserDataInicial.getDate(), jDateChooserDataFinal.getDate())){
            movendaList.add(ven);       
         }
    }
    /**
     * Fun��o que pesquisa pela datas da saida
     */
     private void pesquisaPorData(){
        movendaList.clear();        
        for(Movenda ven : queryCplus.listaMovendaPorDataPedido(jDateChooserDataInicial.getDate(), jDateChooserDataFinal.getDate())){
            movendaList.add(ven);
        }
    }
    
    private void finalizacao(){
        colunaCodMoVenda = jTableListagemSaidas.getColumnModel().getColumnIndex("codmovenda");
        if (jTableListagemSaidas.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Voc� deve selecionar uma linha na tabela!!! ");
        } else {
            String cod = jTableListagemSaidas.getValueAt(jTableListagemSaidas.getSelectedRow(), colunaCodMoVenda).toString();
            if (cod != null) {
                setMoVenda(new MovendaJpaController(managerCplus).findMovenda(cod));
                setCancelamento(false);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "O Cdigo est� nullo por favor verifique!!! ");
            }
        }
    }

    public void setTermoPesquisa(String termo) {
        jComboBoxTipoPesquisa.setSelectedIndex(getIndexComboBox());
        jComboBoxTipoPesquisa.setSelectedIndex(getIndexComboBox());  
        jTextFieldTermoPesquisa.setText(termo);
       
        pesquisas();      
    }
  
    /**
     * Fun��o que retorna listagem cancelada pelo usuario
     * @return true se estiver cancelado false se n�o for cancelado
     */
    public boolean isCancelamento() {
        return cancelamento;
    }

    public void setCancelamento(boolean cancelamento) {
        this.cancelamento = cancelamento;
    }

    public Movenda getMoVenda() {
        return moVenda;
    }

    public void setMoVenda(Movenda moVenda) {
        this.moVenda = moVenda;
    }

    public int getIndexComboBox() {
        return indexComboBox;
    }

    public void setIndexComboBox(int indexComboBox) {
        this.indexComboBox = indexComboBox;
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
            java.util.logging.Logger.getLogger(ListagemSaidasJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListagemSaidasJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListagemSaidasJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListagemSaidasJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ListagemSaidasJDialog dialog = new ListagemSaidasJDialog(new javax.swing.JFrame(), true, managerCplus);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
        
    //private String codMoVenda;
    private final QueryCplus queryCplus;
    private static EntityManagerFactory managerCplus;
    private int colunaCodMoVenda;
    int colunaStatus;
    private boolean cancelamento;
    private Movenda moVenda;
    private int indexComboBox;
    private final FormataCampos formatacaoCampos;
   // ListagemClientesJDialog listagemClientesJDialog;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager cplusPUEntityManager;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonOk;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JCheckBox jCheckBoxCupom;
    private javax.swing.JComboBox jComboBoxTipoPesquisa;
    private com.toedter.calendar.JDateChooser jDateChooserDataFinal;
    private com.toedter.calendar.JDateChooser jDateChooserDataInicial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelDataInicial;
    private javax.swing.JLabel jLabelMensagem;
    private javax.swing.JPanel jPanelPesquisas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableListagemSaidas;
    private javax.swing.JTextField jTextFieldTermoPesquisa;
    private java.util.List<entidade.cplus.Movenda> movendaList;
    private javax.persistence.Query movendaQuery;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

   

   
}
