/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package janela.cplus;

import entidade.cplus.Moventrada;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.swing.JOptionPane;
import java.awt.Toolkit;
import jpa.cplus.MoventradaJpaController;
import query.cplus.QueryCplus;

/**
 *
 * @author leonardo
 */
public class ListagemEntradasJDialog extends javax.swing.JDialog {

    /**
     * Creates new form ListagemEntradasJDialog
     *
     * @param parent
     * @param modal
     * @param managerCplus1
     */
    public ListagemEntradasJDialog(java.awt.Frame parent, boolean modal, EntityManagerFactory managerCplus1) {
        super(parent, modal);
        initComponents();
        colunaCodMovEntrada = jTableListagemEntradas.getColumnModel().getColumnIndex("Codmoventr");
        managerCplus = managerCplus1;
        queryCplus = new QueryCplus(managerCplus);
        formataCampos = new FormataCampos();
        jDateChooserDataFinal.setDate(formataCampos.alteraDiaData(formataCampos.dataAtual(), 0));
        jDateChooserDataInicial.setDate(formataCampos.alteraDiaData(formataCampos.dataAtual(), -2));
        listagemClientesJDialog = new ListagemClientesJDialog(parent, modal, managerCplus);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icones/logo.png")));
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
        moventradaQuery = java.beans.Beans.isDesignTime() ? null : cplusPUEntityManager.createQuery("SELECT mov FROM Moventrada mov WHERE mov.numnota = 999999");
        moventradaList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(moventradaQuery.getResultList());
        jPanelPesquisa = new javax.swing.JPanel();
        jComboBoxTipoPesquisa1 = new javax.swing.JComboBox();
        jTextFieldTermoPesquisa = new javax.swing.JTextField();
        jButtonPesquisar = new javax.swing.JButton();
        jLabelDataInicial = new javax.swing.JLabel();
        jDateChooserDataInicial = new com.toedter.calendar.JDateChooser();
        jLabelDataFinal = new javax.swing.JLabel();
        jDateChooserDataFinal = new com.toedter.calendar.JDateChooser();
        jCheckBoxSomenteCompras = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldMaximoDeResultadosEntradas = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableListagemEntradas = new javax.swing.JTable();
        jButtonOk = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Listagem de Entradas");

        jPanelPesquisa.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisa"));

        jComboBoxTipoPesquisa1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jComboBoxTipoPesquisa1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Num Nota", "Por Cliente", "Data", "C�digo Produto" }));
        jComboBoxTipoPesquisa1.setToolTipText("Selecione a op��o que desejar!");

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

        jLabelDataFinal.setText("Data Final:");

        jCheckBoxSomenteCompras.setSelected(true);
        jCheckBoxSomenteCompras.setText("Somente Vendas");

        jLabel1.setText("Maximo de Resultados:");

        jTextFieldMaximoDeResultadosEntradas.setText("20");

        javax.swing.GroupLayout jPanelPesquisaLayout = new javax.swing.GroupLayout(jPanelPesquisa);
        jPanelPesquisa.setLayout(jPanelPesquisaLayout);
        jPanelPesquisaLayout.setHorizontalGroup(
            jPanelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPesquisaLayout.createSequentialGroup()
                .addGroup(jPanelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPesquisaLayout.createSequentialGroup()
                        .addComponent(jComboBoxTipoPesquisa1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldTermoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelPesquisaLayout.createSequentialGroup()
                        .addComponent(jLabelDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooserDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDateChooserDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBoxSomenteCompras)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldMaximoDeResultadosEntradas, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(223, Short.MAX_VALUE))
        );
        jPanelPesquisaLayout.setVerticalGroup(
            jPanelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPesquisaLayout.createSequentialGroup()
                .addGroup(jPanelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxTipoPesquisa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTermoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelDataInicial)
                    .addComponent(jDateChooserDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDataFinal)
                    .addComponent(jDateChooserDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCheckBoxSomenteCompras)
                        .addComponent(jLabel1)
                        .addComponent(jTextFieldMaximoDeResultadosEntradas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jTableListagemEntradas.setAutoCreateRowSorter(true);
        jTableListagemEntradas.setToolTipText("Listagem de Entradas");
        jTableListagemEntradas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, moventradaList, jTableListagemEntradas);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codForn.nomeforn}"));
        columnBinding.setColumnName("Fornecedor");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${numnota}"));
        columnBinding.setColumnName("Numero Nota");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codForn.estado}"));
        columnBinding.setColumnName("UF For.");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codtipomovimento.nometipomovimento}"));
        columnBinding.setColumnName("Opera��o");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${valortotalnota}"));
        columnBinding.setColumnName("Valor Total Nota");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${data}"));
        columnBinding.setColumnName("Data");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${dataemissao}"));
        columnBinding.setColumnName("Data Emiss�o");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${numeroprotocolonfe}"));
        columnBinding.setColumnName("Protocolo NF-e");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${numerochavenfe}"));
        columnBinding.setColumnName("Numero Chave Nf-e");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${valortotalpis}"));
        columnBinding.setColumnName("Valor PIS");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${valortotalcofins}"));
        columnBinding.setColumnName("Valor COFINS");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${valortotalipi}"));
        columnBinding.setColumnName("Valor IPI");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${valortotalprodutos}"));
        columnBinding.setColumnName("Valor Produtos");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${hora}"));
        columnBinding.setColumnName("Hora");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${valorsubsttributaria}"));
        columnBinding.setColumnName("Valor S.T.");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${basesubsttributaria}"));
        columnBinding.setColumnName("Base S.T.");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${valoricms}"));
        columnBinding.setColumnName("Valor ICMS");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${baseicms}"));
        columnBinding.setColumnName("Base ICMS");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codmoventr}"));
        columnBinding.setColumnName("Codmoventr");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jTableListagemEntradas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableListagemEntradasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableListagemEntradas);
        if (jTableListagemEntradas.getColumnModel().getColumnCount() > 0) {
            jTableListagemEntradas.getColumnModel().getColumn(0).setMinWidth(100);
            jTableListagemEntradas.getColumnModel().getColumn(0).setPreferredWidth(350);
            jTableListagemEntradas.getColumnModel().getColumn(0).setMaxWidth(500);
            jTableListagemEntradas.getColumnModel().getColumn(3).setPreferredWidth(300);
            jTableListagemEntradas.getColumnModel().getColumn(4).setPreferredWidth(120);
            jTableListagemEntradas.getColumnModel().getColumn(4).setCellRenderer(new integrador.render.RenderPreco());
            jTableListagemEntradas.getColumnModel().getColumn(5).setPreferredWidth(130);
            jTableListagemEntradas.getColumnModel().getColumn(6).setCellRenderer(new integrador.render.RenderDataEHora());
            jTableListagemEntradas.getColumnModel().getColumn(8).setMinWidth(150);
            jTableListagemEntradas.getColumnModel().getColumn(8).setPreferredWidth(250);
            jTableListagemEntradas.getColumnModel().getColumn(8).setMaxWidth(450);
            jTableListagemEntradas.getColumnModel().getColumn(9).setCellRenderer(new integrador.render.RenderPreco());
            jTableListagemEntradas.getColumnModel().getColumn(10).setCellRenderer(new integrador.render.RenderPreco());
            jTableListagemEntradas.getColumnModel().getColumn(11).setCellRenderer(new integrador.render.RenderPreco());
            jTableListagemEntradas.getColumnModel().getColumn(12).setCellRenderer(new integrador.render.RenderPreco());
            jTableListagemEntradas.getColumnModel().getColumn(13).setCellRenderer(new integrador.render.RenderHora());
            jTableListagemEntradas.getColumnModel().getColumn(14).setCellRenderer(new integrador.render.RenderPreco());
            jTableListagemEntradas.getColumnModel().getColumn(15).setCellRenderer(new integrador.render.RenderPreco());
            jTableListagemEntradas.getColumnModel().getColumn(16).setCellRenderer(new integrador.render.RenderPreco());
            jTableListagemEntradas.getColumnModel().getColumn(17).setCellRenderer(new integrador.render.RenderPreco());
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
            .addComponent(jPanelPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonOk)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonCancelar))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonOk))
                .addGap(19, 19, 19))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldTermoPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTermoPesquisaActionPerformed
        tipoPesquisa();
    }//GEN-LAST:event_jTextFieldTermoPesquisaActionPerformed

    private void jTableListagemEntradasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListagemEntradasMouseClicked

    }//GEN-LAST:event_jTableListagemEntradasMouseClicked

    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOkActionPerformed

        finalizacao();
    }//GEN-LAST:event_jButtonOkActionPerformed

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        tipoPesquisa();
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        cancelamento();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void cancelamento() {
        int cancelar = JOptionPane.showConfirmDialog(null, " Deseja realmente cancelar? \n O processo ser� encerrado!!", "Cancelar", JOptionPane.YES_NO_CANCEL_OPTION);
        if (cancelar == JOptionPane.YES_OPTION) {
            setCancelamento(true);
            dispose();
        }
    }

    private boolean verificaSeForNumero(String txt) {
        boolean condicao = true;
        if (txt == null || txt.equals("")) {
            return false;
        }
        for (int i = 0; i < txt.length(); i++) {
            char c = txt.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return condicao;
    }

    private void tipoPesquisa() {
        switch (jComboBoxTipoPesquisa1.getSelectedIndex()) {
            case 0:
                if (verificaSeForNumero(jTextFieldTermoPesquisa.getText())) {
                    List<Moventrada> listMoventrada = queryCplus.resultadoPelaNotaEntrada(Integer.parseInt(this.jTextFieldTermoPesquisa.getText()));
                    moventradaList.clear();
                    if (listMoventrada.size() < 1) {
                        JOptionPane.showMessageDialog(null, "N�o foi encontrado resultado para essa pesquisa!!! ");
                    } else {
                        for (Moventrada ent : listMoventrada) {
                            moventradaList.add(ent);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "S�o aceitos apenas numeros!!! ");
                }
                break;
            case 1:
                if (!"".equals(jTextFieldTermoPesquisa.getText())) {
                    this.listagemClientesJDialog.setTermoPesquisa(jTextFieldTermoPesquisa.getText());
                    this.listagemClientesJDialog.listarClientes();
                    this.listagemClientesJDialog.setVisible(true);
                    if (this.listagemClientesJDialog.isCancelamento() == false) {
                        List<Moventrada> listMoventrada = queryCplus.resultadoPeloClienteEntrada(this.listagemClientesJDialog.getCliente().getCodcli());
                        moventradaList.clear();
                        if (listMoventrada.size() < 1) {
                            JOptionPane.showMessageDialog(null, "N�o foi encontrado resultado para essa pesquisa!!! ");
                        } else {
                            for (Moventrada ent : listMoventrada) {
                                moventradaList.add(ent);
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Digite o argumento da pesquisa!!! ");
                }
                break;
            case 2:
                moventradaList.clear();
                for (Moventrada entrada : queryCplus.resultadoPelaDataEntrada(jDateChooserDataInicial.getDate(), jDateChooserDataFinal.getDate())) {
                    moventradaList.add(entrada);
                }
                break;
            case 3:
                moventradaList.clear();
                if (verificaSeForNumero(jTextFieldMaximoDeResultadosEntradas.getText())) {
                    for (Moventrada movProd : queryCplus.resultPorProduto(jTextFieldTermoPesquisa.getText(), jCheckBoxSomenteCompras.isSelected(), Integer.valueOf(jTextFieldMaximoDeResultadosEntradas.getText()))) {
                        moventradaList.add(movProd);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "S�o aceitos apenas numeros!!! ");
                }
        }
    }

    private void finalizacao() {
        colunaCodMovEntrada = jTableListagemEntradas.getColumnModel().getColumnIndex("Codmoventr");
        if (jTableListagemEntradas.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Voc� deve selecionar uma linha na tabela!!! ");
        } else {
            String cod = jTableListagemEntradas.getValueAt(jTableListagemEntradas.getSelectedRow(), colunaCodMovEntrada).toString();
            if (cod != null) {
                setMovEntrada(new MoventradaJpaController(managerCplus).findMoventrada(cod));
                setCancelamento(false);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "O C�digo est� nullo por favor verifique!!! ");
            }
        }
    }

    public void setTermoPesquisa(String termoPesquisa, int indexPesquisa) {
        jComboBoxTipoPesquisa1.setSelectedIndex(indexPesquisa);
        this.jTextFieldTermoPesquisa.setText(termoPesquisa);
        tipoPesquisa();
        this.termoPes = termoPesquisa;
    }

    public Moventrada getMovEntrada() {
        return movEntrada;
    }

    public void setMovEntrada(Moventrada movEntrada) {
        this.movEntrada = movEntrada;
    }

    /**
     * Fun��o que retorna listagem cancelada pelo usuario
     *
     * @return true se estiver cancelado false se n�o for cancelado
     */
    public boolean isCancelamento() {
        return cancelamento;
    }

    public void setCancelamento(boolean cancelamento) {
        this.cancelamento = cancelamento;
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
            java.util.logging.Logger.getLogger(ListagemEntradasJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListagemEntradasJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListagemEntradasJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListagemEntradasJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ListagemEntradasJDialog dialog = new ListagemEntradasJDialog(new javax.swing.JFrame(), true, managerCplus);
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

    private String termoPes;
    private Moventrada movEntrada;
    FormataCampos formataCampos;
    private int colunaCodMovEntrada;
    QueryCplus queryCplus;
    static EntityManagerFactory managerCplus;
    boolean cancelamento;
    ListagemClientesJDialog listagemClientesJDialog;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager cplusPUEntityManager;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonOk;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JCheckBox jCheckBoxSomenteCompras;
    private javax.swing.JComboBox jComboBoxTipoPesquisa1;
    private com.toedter.calendar.JDateChooser jDateChooserDataFinal;
    private com.toedter.calendar.JDateChooser jDateChooserDataInicial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelDataFinal;
    private javax.swing.JLabel jLabelDataInicial;
    private javax.swing.JPanel jPanelPesquisa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableListagemEntradas;
    private javax.swing.JTextField jTextFieldMaximoDeResultadosEntradas;
    private javax.swing.JTextField jTextFieldTermoPesquisa;
    private java.util.List<entidade.cplus.Moventrada> moventradaList;
    private javax.persistence.Query moventradaQuery;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
