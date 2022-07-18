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
import java.awt.Color;

import java.awt.Toolkit;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.swing.JOptionPane;
import jpa.prestaShop.PsGroupJpaController;
import jpa.prestaShop.PsProductJpaController;
import query.integrador.QueryIntegrador;
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
     * @param managerIntegrador1
     * @param managerPrestaShop1
     * @param managerCplus1
     * @param usuario1
     */
    public ListPsProductJDialog(java.awt.Frame parent, boolean modal, EntityManagerFactory managerIntegrador1, EntityManagerFactory managerPrestaShop1, EntityManagerFactory managerCplus1, Usuario usuario1) {
        super(parent, modal);
        managerPrestaShop = managerPrestaShop1;
        managerCplus = managerCplus1;
        managerIntegrador = managerIntegrador1;

        initComponents();

        formataCampos = new FormataCampos();
        //shopUrl = new QueryIntegrador(managerIntegrador).valorConfiguracao("shopURL");
        //key = new QueryIntegrador(managerIntegrador).valorConfiguracao("shopKEY");
        usuario = usuario1;
        queryPrestaShop = new QueryPrestaShop(managerPrestaShop);
        ControleAcesso acesso = new ControleAcesso(managerCplus);
        colunaEntityId = jTablePsProduct.getColumnModel().getColumnIndex("Id Product");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icones/logo.png")));
        //new RenderPsProductName(managerPrestaShop);
        //new RenderPsStockDisponivel(managerPrestaShop);
        //new RenderPreco();
        //new RenderPsProductPeso();
        
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
        jButtonCancelar = new javax.swing.JButton();
        jButtonOk = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePsProduct = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaPrecoNormal = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaPrecoSemIe = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextAreaPrecoRuim = new javax.swing.JTextArea();

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

        jButtonCancelar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/cancelar.png"))); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonOk.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/ok.png"))); // NOI18N
        jButtonOk.setText("OK!");
        jButtonOk.setEnabled(false);
        jButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOkActionPerformed(evt);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                .addComponent(jButtonOk)
                .addGap(27, 27, 27)
                .addComponent(jButtonCancelar))
        );
        jPanelPesquisaLayout.setVerticalGroup(
            jPanelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPesquisaLayout.createSequentialGroup()
                .addGroup(jPanelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxTipoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTermoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisar)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonOk))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTablePsProduct.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);

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
            jTablePsProduct.getColumnModel().getColumn(1).setPreferredWidth(350);
            jTablePsProduct.getColumnModel().getColumn(1).setCellRenderer(new RenderPsProductName(managerPrestaShop));
            jTablePsProduct.getColumnModel().getColumn(2).setCellRenderer(new RenderPsStockDisponivel(managerPrestaShop));
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4))
                .addContainerGap(40, Short.MAX_VALUE))
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
    }

    private void carregaCampos() {
        colunaEntityId = jTablePsProduct.getColumnModel().getColumnIndex("Id Product");
        int idProduto = Integer.valueOf(jTablePsProduct.getValueAt(jTablePsProduct.getSelectedRow(), colunaEntityId).toString());
        psProduct = new PsProductJpaController(managerPrestaShop).findPsProduct(idProduto);
        if(estoqueDisponivel() > 0){
            jButtonOk.setEnabled(true);
        }else{
            jButtonOk.setEnabled(false);
        }
        
        String txtNormal = "Quant.\t  % \tValor\n";        
        PsGroup psGroup = new PsGroupJpaController(managerPrestaShop).findPsGroup(4);
        BigDecimal redGrup = psGroup.getReduction().divide(new BigDecimal("100.00"), BigDecimal.ROUND_HALF_UP);
        BigDecimal valRedGrupo = psProduct.getPrice().multiply(BigDecimal.ONE.subtract(redGrup));
        txtNormal = txtNormal + " 1" + " \t" + "0.00% \t" + formataCampos.bigDecimalParaString(valRedGrupo, 2) + "  \n";
        for (PsSpecificPrice sp : queryPrestaShop.listPsSpecificPrice(psProduct.getIdProduct(), 4)) {
            if ("amount".equals(sp.getReductionType())) {
                valRedGrupo = sp.getPrice().multiply(BigDecimal.ONE.subtract(redGrup));
                txtNormal = "";
                txtNormal = "Quant.\t  % \tValor\n";
                txtNormal = txtNormal + " 1" + " \t" + "0.00% \t" + formataCampos.bigDecimalParaString(valRedGrupo, 2) + "  \n";
            }else{
            txtNormal = txtNormal + " " + sp.getFromQuantity() + " \t" + formataCampos.bigDecimalParaString(sp.getReduction().multiply(new BigDecimal("100.00")), 2) + "% \t"
                    + formataCampos.bigDecimalParaString((BigDecimal.ONE.subtract(sp.getReduction())).multiply(valRedGrupo), 2) + "  \n";
        }
        }
        jTextAreaPrecoNormal.setText(txtNormal);
        // jTextAreaPrecoNormal.setForeground(Color.GREEN);

        psGroup = new PsGroupJpaController(managerPrestaShop).findPsGroup(7);
        redGrup = psGroup.getReduction().divide(new BigDecimal("100.00"), BigDecimal.ROUND_HALF_UP);
        valRedGrupo = psProduct.getPrice().multiply(BigDecimal.ONE.subtract(redGrup));
        txtNormal = "Quant.\t  % \tValor\n";
        txtNormal = txtNormal + " 1" + " \t" + "0.00% \t" + formataCampos.bigDecimalParaString(valRedGrupo, 2) + "  \n";
        for (PsSpecificPrice sp : queryPrestaShop.listPsSpecificPrice(psProduct.getIdProduct(), 7)) {
            if ("amount".equals(sp.getReductionType())) {
                valRedGrupo = sp.getPrice().multiply(BigDecimal.ONE.subtract(redGrup));
                txtNormal = "";
                txtNormal = "Quant.\t  % \tValor\n";
                txtNormal = txtNormal + " 1" + " \t" + "0.00% \t" + formataCampos.bigDecimalParaString(valRedGrupo, 2) + "  \n";
            }else{
            txtNormal = txtNormal + " " + sp.getFromQuantity() + " \t" + formataCampos.bigDecimalParaString(sp.getReduction().multiply(new BigDecimal("100.00")), 2) + "% \t"
                    + formataCampos.bigDecimalParaString((BigDecimal.ONE.subtract(sp.getReduction())).multiply(valRedGrupo), 2) + "  \n";
            }
            }

        jTextAreaPrecoSemIe.setText(txtNormal);
        //jTextAreaPrecoSemIe.setForeground(Color.BLUE);
        psGroup = new PsGroupJpaController(managerPrestaShop).findPsGroup(5);
        redGrup = psGroup.getReduction().divide(new BigDecimal("100.00"), BigDecimal.ROUND_HALF_UP);
        valRedGrupo = psProduct.getPrice().multiply(BigDecimal.ONE.subtract(redGrup));
        txtNormal = "Quant.\t  % \tValor\n";
        txtNormal = txtNormal + "  1" + " \t" + "0.00% \t" + formataCampos.bigDecimalParaString(valRedGrupo, 2) + "  \n";
        for (PsSpecificPrice sp : queryPrestaShop.listPsSpecificPrice(psProduct.getIdProduct(), 5)) {
            if ("amount".equals(sp.getReductionType())) {
                valRedGrupo = sp.getPrice().multiply(BigDecimal.ONE.subtract(redGrup));
                txtNormal = "";
                txtNormal = "Quant.\t  % \tValor\n";
                txtNormal = txtNormal + " 1" + " \t" + "0.00% \t" + formataCampos.bigDecimalParaString(valRedGrupo, 2) + "  \n";
            }else{
            txtNormal = txtNormal + " " + sp.getFromQuantity() + "  \t" + formataCampos.bigDecimalParaString(sp.getReduction().multiply(new BigDecimal("100.00")), 2) + "% \t"
                    + formataCampos.bigDecimalParaString((BigDecimal.ONE.subtract(sp.getReduction())).multiply(valRedGrupo), 2) + "  \n";
        }
        }
        jTextAreaPrecoRuim.setText(txtNormal);
        //jTextAreaPrecoRuim.setForeground(Color.RED);
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
        psProduct = new PsProductJpaController(managerPrestaShop).findPsProduct(idProduto);
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
                        psProductList.add(entity);
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
                ListPsProductJDialog dialog = new ListPsProductJDialog(new javax.swing.JFrame(), true, managerIntegrador, managerPrestaShop, managerCplus, usuario);
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
    static EntityManagerFactory managerPrestaShop;
    static EntityManagerFactory managerCplus;
    int colunaEntityId;
    //private SalesFlatOrder flatOrder;
    FormataCampos formataCampos;
    QueryPrestaShop queryPrestaShop;
    private boolean cancelamento;
    //private BigDecimal quantidadeAntiga;
    PsProduct psProduct;
    //private short groupId;
    static Usuario usuario;
    //private final String shopUrl ;
    //private final String key;
    static EntityManagerFactory managerIntegrador;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonOk;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JComboBox jComboBoxTipoPesquisa;
    private javax.swing.JPanel jPanelPesquisa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTablePsProduct;
    private javax.swing.JTextArea jTextAreaPrecoNormal;
    private javax.swing.JTextArea jTextAreaPrecoRuim;
    private javax.swing.JTextArea jTextAreaPrecoSemIe;
    private javax.swing.JTextField jTextFieldTermoPesquisa;
    private java.util.List<entidade.prestaShop.PsProduct> psProductList;
    private javax.persistence.Query psProductQuery;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
