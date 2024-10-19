/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package janela.prestaShop;

import acesso.ControleAcesso;
import entidade.cplus.Usuario;
import entidade.prestaShop.PsGroup;
import entidade.prestaShop.PsProduct;
import entidade.prestaShop.PsSpecificPrice;
import entidade.prestaShop.PsStockAvailable;
import integrador.render.RenderPreco;
import integrador.render.produto.RenderPsProductName;
import integrador.render.produto.RenderPsProductPeso;
import integrador.render.produto.RenderPsStockDisponivel;
import janela.cplus.FormataCampos;
import java.awt.Toolkit;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import jpa.prestaShop.PsGroupJpaController;
import jpa.prestaShop.PsProductJpaController;
import prestashop.Manager;
import produto.PedidoCompra;
import query.prestaShop.QueryPrestaShop;

/**
 *
 * @author leonardo
 */
public class ListPsProductJDialog extends javax.swing.JDialog {

    /**
     * Creates new form ListagemProdutoMagentoJDialog
     *
     * @param parent
     * @param modal
     */
    public ListPsProductJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);      
        initComponents();

        formataCampos = new FormataCampos();     
        queryPrestaShop = new QueryPrestaShop();
        ControleAcesso acesso = new ControleAcesso();
        colunaEntityId = jTablePsProduct.getColumnModel().getColumnIndex("Id Product");
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

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("PrestaShopPU").createEntityManager();
        psProductQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT c FROM PsProduct c WHERE c.reference =\"2\"");
        psProductList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(new java.util.LinkedList(psProductQuery.getResultList()));
        jPanelPesquisa = new javax.swing.JPanel();
        jComboBoxTipoPesquisa = new javax.swing.JComboBox();
        jTextFieldTermoPesquisa = new javax.swing.JTextField();
        jButtonPesquisar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePsProduct = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaPrecoNormal = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaPrecoSemIe = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextAreaPrecoRuim = new javax.swing.JTextArea();
        jButtonOk = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextAreaProdutoComprado = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Pesquisa Produtos");

        jPanelPesquisa.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisas:"));

        jComboBoxTipoPesquisa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nome", "Item 2", "Item 3", "Item 4" }));

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

        javax.swing.GroupLayout jPanelPesquisaLayout = new javax.swing.GroupLayout(jPanelPesquisa);
        jPanelPesquisa.setLayout(jPanelPesquisaLayout);
        jPanelPesquisaLayout.setHorizontalGroup(
            jPanelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPesquisaLayout.createSequentialGroup()
                .addComponent(jComboBoxTipoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldTermoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonPesquisar)
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanelPesquisaLayout.setVerticalGroup(
            jPanelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPesquisaLayout.createSequentialGroup()
                .addGroup(jPanelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxTipoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTermoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTablePsProduct.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTablePsProduct.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTablePsProduct.setRowHeight(20);
        jTablePsProduct.setRowMargin(2);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, psProductList, jTablePsProduct);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${ean13}"));
        columnBinding.setColumnName("Ean13");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idProduct}"));
        columnBinding.setColumnName("Nome");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idProduct}"));
        columnBinding.setColumnName("Quan. Disp.");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${price}"));
        columnBinding.setColumnName("Pre�o Normal");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${active}"));
        columnBinding.setColumnName("Active");
        columnBinding.setColumnClass(Boolean.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${weight}"));
        columnBinding.setColumnName("Pego g");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${height}"));
        columnBinding.setColumnName("Altura");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${depth}"));
        columnBinding.setColumnName("Profundidade");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${width}"));
        columnBinding.setColumnName("Largura");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${dateUpd}"));
        columnBinding.setColumnName("Date Upd");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${dateAdd}"));
        columnBinding.setColumnName("Date Add");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${reference}"));
        columnBinding.setColumnName("Reference");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idProduct}"));
        columnBinding.setColumnName("Id Product");
        columnBinding.setColumnClass(Integer.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jTablePsProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePsProductMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTablePsProduct);
        if (jTablePsProduct.getColumnModel().getColumnCount() > 0) {
            jTablePsProduct.getColumnModel().getColumn(0).setPreferredWidth(100);
            jTablePsProduct.getColumnModel().getColumn(1).setPreferredWidth(450);
            jTablePsProduct.getColumnModel().getColumn(1).setCellRenderer(new RenderPsProductName(Manager.getManagerPrestaShop()));
            jTablePsProduct.getColumnModel().getColumn(2).setCellRenderer(new RenderPsStockDisponivel(Manager.getManagerPrestaShop()));
            jTablePsProduct.getColumnModel().getColumn(3).setPreferredWidth(80);
            jTablePsProduct.getColumnModel().getColumn(3).setCellRenderer(new RenderPreco());
            jTablePsProduct.getColumnModel().getColumn(5).setCellRenderer(new RenderPsProductPeso());
            jTablePsProduct.getColumnModel().getColumn(6).setCellRenderer(new RenderPsProductPeso());
            jTablePsProduct.getColumnModel().getColumn(7).setCellRenderer(new RenderPsProductPeso());
            jTablePsProduct.getColumnModel().getColumn(8).setCellRenderer(new RenderPsProductPeso());
        }

        jTextAreaPrecoNormal.setEditable(false);
        jTextAreaPrecoNormal.setColumns(20);
        jTextAreaPrecoNormal.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextAreaPrecoNormal.setForeground(new java.awt.Color(0, 153, 0));
        jTextAreaPrecoNormal.setRows(6);
        jTextAreaPrecoNormal.setTabSize(6);
        jScrollPane1.setViewportView(jTextAreaPrecoNormal);

        jTextAreaPrecoSemIe.setEditable(false);
        jTextAreaPrecoSemIe.setColumns(20);
        jTextAreaPrecoSemIe.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextAreaPrecoSemIe.setForeground(new java.awt.Color(0, 0, 204));
        jTextAreaPrecoSemIe.setRows(6);
        jTextAreaPrecoSemIe.setTabSize(6);
        jScrollPane3.setViewportView(jTextAreaPrecoSemIe);

        jTextAreaPrecoRuim.setEditable(false);
        jTextAreaPrecoRuim.setColumns(20);
        jTextAreaPrecoRuim.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextAreaPrecoRuim.setForeground(new java.awt.Color(204, 0, 0));
        jTextAreaPrecoRuim.setRows(6);
        jTextAreaPrecoRuim.setTabSize(6);
        jScrollPane4.setViewportView(jTextAreaPrecoRuim);

        jButtonOk.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/ok.png"))); // NOI18N
        jButtonOk.setText("OK!");
        jButtonOk.setEnabled(false);
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

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 51));
        jLabel1.setText("Cliente com I.E.");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 204));
        jLabel2.setText("Cliente sem I.E.");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 0, 51));
        jLabel3.setText("Cliente Ruim");

        jTextAreaProdutoComprado.setColumns(20);
        jTextAreaProdutoComprado.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jTextAreaProdutoComprado.setRows(5);
        jTextAreaProdutoComprado.setBorder(javax.swing.BorderFactory.createTitledBorder("Compras"));
        jTextAreaProdutoComprado.setCaretColor(new java.awt.Color(255, 51, 51));
        jScrollPane5.setViewportView(jTextAreaProdutoComprado);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanelPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(229, 229, 229))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(112, 112, 112)
                                .addComponent(jLabel2)
                                .addGap(112, 112, 112)
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButtonOk)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButtonCancelar))))))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonOk)
                            .addComponent(jButtonCancelar))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        pesquisa();
        limpaCampos();
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        cancelamento();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jTextFieldTermoPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTermoPesquisaActionPerformed
        pesquisa();
        limpaCampos();
    }//GEN-LAST:event_jTextFieldTermoPesquisaActionPerformed

    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOkActionPerformed
        retornaObjeto();
        setCancelamento(false);
    }//GEN-LAST:event_jButtonOkActionPerformed

    private void jTablePsProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePsProductMouseClicked

        carregaCampos();
    }//GEN-LAST:event_jTablePsProductMouseClicked

    private void limpaCampos() {
        jTextAreaPrecoNormal.setText("");
        jTextAreaPrecoRuim.setText("");
        jTextAreaPrecoSemIe.setText("");
        jTextAreaProdutoComprado.setText("");
    }

    private void carregaCampos() {
        colunaEntityId = jTablePsProduct.getColumnModel().getColumnIndex("Id Product");
        int idProduto = Integer.valueOf(jTablePsProduct.getValueAt(jTablePsProduct.getSelectedRow(), colunaEntityId).toString());
        psProduct = new PsProductJpaController(Manager.getManagerPrestaShop()).findPsProduct(idProduto);
        if (estoqueDisponivel() > 0) {
            jButtonOk.setEnabled(true);
        } else {
            jButtonOk.setEnabled(false);
        }
       jTextAreaProdutoComprado.setText(new PedidoCompra().produtoComprado( psProduct.getReference()));
        jTextAreaPrecoRuim.setText(textPreco(5));
        jTextAreaPrecoNormal.setText(textPreco(4));
        jTextAreaPrecoSemIe.setText(textPreco(7));
        //jTextAreaPrecoRuim.setForeground(Color.RED);
    }

    private String textPreco(Integer idGroup) {
        //String txtNormal = " Quant.\t  % \tValor\n";
        //PsGroup psGroup = new PsGroupJpaController(managerPrestaShop).findPsGroup(idGroup);
        //BigDecimal redGrup = psGroup.getReduction().divide(new BigDecimal("100.00"), RoundingMode.HALF_UP);
       // BigDecimal valRedGrupo = psProduct.getPrice().multiply(BigDecimal.ONE.subtract(redGrup));
        PsGroup psGroup = new PsGroupJpaController(Manager.getManagerPrestaShop()).findPsGroup(idGroup);
        BigDecimal redGrup = psGroup.getReduction().divide(new BigDecimal("100.00"), RoundingMode.HALF_UP);
        BigDecimal valRedGrupo = psProduct.getPrice().multiply(BigDecimal.ONE.subtract(redGrup));
        String txtNormal = "Quant.\t  % \tValor\n";
        txtNormal = txtNormal + "  1" + " \t" + "0.00% \t" + formataCampos.bigDecimalParaString(valRedGrupo, 2) + "  \n";
        for (PsSpecificPrice sp : queryPrestaShop.listPsSpecificPriceAllGroup(psProduct.getIdProduct(), "amount", idGroup)) {
            if (sp.getTo() == null) {
                //valRedGrupo = valRedGrupo.subtract(sp.getReduction());
                txtNormal = txtNormal + " - " + sp.getFromQuantity() + " \t" + formataCampos.bigDecimalParaString(sp.getReduction(), 2) + " \t"
                        + formataCampos.bigDecimalParaString(valRedGrupo.subtract(sp.getReduction()), 2) + "\n";
            } else {
                Calendar dataAtual = Calendar.getInstance();
                dataAtual.setTime(new Date(System.currentTimeMillis()));
                Calendar dataBanco = Calendar.getInstance();
                dataBanco.setTime(sp.getTo());
                if (dataAtual.before(dataBanco)) {
                    if ("amount".equals(sp.getReductionType())) {
                        //valRedGrupo = valRedGrupo.subtract(sp.getReduction());
                        txtNormal = txtNormal + " " + sp.getFromQuantity() + " \t - " + formataCampos.bigDecimalParaString(sp.getReduction(), 2) + " \t"
                                + formataCampos.bigDecimalParaString(valRedGrupo.subtract(sp.getReduction()), 2) + "\n";
                    }
                }
            }
        }
        for (PsSpecificPrice sp : queryPrestaShop.listPsSpecificPriceAllGroup(psProduct.getIdProduct(), "percentage", idGroup)) {
            txtNormal = txtNormal + " " + sp.getFromQuantity() + " \t" + formataCampos.bigDecimalParaString(sp.getReduction().multiply(new BigDecimal("100.00")), 2) + "% \t"
                    + formataCampos.bigDecimalParaString(valRedGrupo.multiply(BigDecimal.ONE.subtract(sp.getReduction())).setScale(2, RoundingMode.HALF_UP), 2) + "\n";
        }
        return txtNormal;
    }

    private int estoqueDisponivel() {
        int quantidadeDisponivel = 0;
        for (PsStockAvailable e : queryPrestaShop.listEstoqueProduto(psProduct.getIdProduct())) {
            //tok = e;
            quantidadeDisponivel = e.getQuantity();
        }
        return quantidadeDisponivel;
    }

    private void retornaObjeto() {
        colunaEntityId = jTablePsProduct.getColumnModel().getColumnIndex("Id Product");
        int idProduto = Integer.valueOf(jTablePsProduct.getValueAt(jTablePsProduct.getSelectedRow(), colunaEntityId).toString());
        psProduct = new PsProductJpaController(Manager.getManagerPrestaShop()).findPsProduct(idProduto);
        jButtonOk.setEnabled(false);
        dispose();
    }

    private void pesquisa() {
        jButtonOk.setEnabled(false);
        if ("".equals(jTextFieldTermoPesquisa.getText())) {
            JOptionPane.showMessageDialog(null, "Voce deve digitar algo! ");
        } else {
            switch (jComboBoxTipoPesquisa.getSelectedIndex()) {
                case 0:
                    psProductList.clear();
                    List<PsProduct> listProductEntity = queryPrestaShop.listProductNomeOuEan(jTextFieldTermoPesquisa.getText());
                    for (PsProduct entity : listProductEntity) {
                        if (!"none".equals(entity.getVisibility()) || entity.getAvailableForOrder() == true) {
                            psProductList.add(entity);
                        }
                    }
                    break;
                case 1:

            }
        }
    }

    private void cancelamento() {
        int cancelar = JOptionPane.showConfirmDialog(null, " Deseja realmente cancelar? \n O processo ser� encerrado!!", "Cancelar", JOptionPane.YES_NO_CANCEL_OPTION);
        if (cancelar == JOptionPane.YES_OPTION) {
            setCancelamento(true);
            dispose();
        }
    }

    public PsProduct getProductEntity() {
        return psProduct;
    }

    /**
     * Retorna True se foi cancelado
     *
     * @return
     */
    public boolean isCancelamento() {
        return cancelamento;
    }

    /**
     * True para cancelado
     *
     * @param cancelamento
     */
    private void setCancelamento(boolean cancelamento) {
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListPsProductJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ListPsProductJDialog dialog = new ListPsProductJDialog(new javax.swing.JFrame(), true);
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
    //static EntityManagerFactory managerPrestaShop;
    //static EntityManagerFactory managerCplus;
    private int colunaEntityId;
    //private SalesFlatOrder flatOrder;
    private FormataCampos formataCampos;
    private QueryPrestaShop queryPrestaShop;
    private boolean cancelamento;
    //private BigDecimal quantidadeAntiga;
    PsProduct psProduct;
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonOk;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JComboBox jComboBoxTipoPesquisa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanelPesquisa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTablePsProduct;
    private javax.swing.JTextArea jTextAreaPrecoNormal;
    private javax.swing.JTextArea jTextAreaPrecoRuim;
    private javax.swing.JTextArea jTextAreaPrecoSemIe;
    private javax.swing.JTextArea jTextAreaProdutoComprado;
    private javax.swing.JTextField jTextFieldTermoPesquisa;
    private java.util.List<entidade.prestaShop.PsProduct> psProductList;
    private javax.persistence.Query psProductQuery;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
