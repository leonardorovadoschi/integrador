/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package janela.cplus;

import entidade.cplus.Tipomovimento;
import java.awt.Toolkit;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.swing.JOptionPane;
import jpa.cplus.TipomovimentoJpaController;
import prestashop.Manager;
import query.cplus.QueryCplus;

/**
 *
 * @author leonardo
 */
public class ListagemOperacaoJDialog extends javax.swing.JDialog {

    /**
     * Creates new form ListagemOperacaoJDialog
     * @param parent
     * @param modal
     */
    public ListagemOperacaoJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //managerCplus = managerCplus1;
        queryCplus = new QueryCplus();
        colunaCodMovimento = jTableListagemMovimento.getColumnModel().getColumnIndex("Codtipomovimento");
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icones/logo.png")));
    }
    
    public void pesquisas(){
        switch (jComboBoxTipoPesquisa.getSelectedIndex()){
            case 0:
                char devolucao;
                char inativo;
                char tipoMovimento;
                char fornCli;
                if(jCheckBoxDevolucao.isSelected()){
                    devolucao = 'Y';
                }else{
                    devolucao = 'N';
                }
                if(jCheckBoxInativo.isSelected()){
                    inativo = 'Y';
                }else{
                    inativo = 'N';
                }
                if(jRadioButtonCliente.isSelected()){
                    fornCli = 'C';
                }else {
                    fornCli = 'F';
                }
                if(jRadioButtonCompra.isSelected()){
                    tipoMovimento = 'C';
                }else if(jRadioButtonEntrada.isSelected()){
                    tipoMovimento = 'E';
                }else if(jRadioButtonSaida.isSelected()){
                    tipoMovimento = 'S';
                }else{
                    tipoMovimento = 'V';
                }               
               List <Tipomovimento> listMovimento = queryCplus.listagemOperacao(devolucao, inativo, tipoMovimento, fornCli, jTextFieldTermoPesquisa.getText(), true);
                tipomovimentoList.clear();
                for(Tipomovimento mov : listMovimento){
                    tipomovimentoList.add(mov);
                }
          
        }
    }
    
    private void cancelamento(){
        int cancelar = JOptionPane.showConfirmDialog(null, " Deseja realmente cancelar? \n O processo serï¿½ encerrado!!", "Cancelar", JOptionPane.YES_NO_CANCEL_OPTION);
            if (cancelar == JOptionPane.YES_OPTION) {
                setCancelamento(true);
                dispose();
            }
    }

    private void finalizacao(){
        colunaCodMovimento = jTableListagemMovimento.getColumnModel().getColumnIndex("Codtipomovimento");
        if (jTableListagemMovimento.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Você deve selecionar uma linha na tabela!!! ");
        } else {
            String cod = jTableListagemMovimento.getValueAt(jTableListagemMovimento.getSelectedRow(), colunaCodMovimento).toString();
            if (cod != null) {
                setMovimento(new TipomovimentoJpaController(Manager.getManagerCplus()).findTipomovimento(cod));               
                setCancelamento(false);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "O Codigo está nullo por favor verifique!!! ");
            }
        }
    }
    
    public Tipomovimento getMovimento() {
        return tipoMovimentoObjeto;
    }

    public void setMovimento(Tipomovimento movimento) {
        this.tipoMovimentoObjeto = movimento;
    }

    public boolean isInativo() {
        return inativo;
    }

    public void setInativo(boolean inativo) {
        jCheckBoxInativo.setSelected(inativo);
        this.inativo = inativo;
    }

    public boolean isDevolucao() {
       
        return devolucao;
    }

    public void setDevolucao(boolean devolucao) {
         jCheckBoxDevolucao.setSelected(devolucao);
        this.devolucao = devolucao;
    }

    public String getTipoMovimento() {
        return tipoMovimentoString;
    }

    public void setTipoMovimento(String tipoMovimento) {
        if (null != tipoMovimento) switch (tipoMovimento) {
            case "C":
                jRadioButtonCompra.setSelected(true);
                jRadioButtonVenda.setSelected(false);
                jRadioButtonEntrada.setSelected(false);
                jRadioButtonSaida.setSelected(false);
                break;
            case "V":
                jRadioButtonVenda.setSelected(true);
                jRadioButtonCompra.setSelected(false);
                jRadioButtonEntrada.setSelected(false);
                jRadioButtonSaida.setSelected(false);
                break;
            case "E":
                jRadioButtonEntrada.setSelected(true);
                jRadioButtonVenda.setSelected(false);
                jRadioButtonCompra.setSelected(false);
                jRadioButtonSaida.setSelected(false);
                break;
            default:
                jRadioButtonSaida.setSelected(true);
                jRadioButtonVenda.setSelected(false);
                jRadioButtonCompra.setSelected(false);
                jRadioButtonEntrada.setSelected(false);
                break;
        }
        this.tipoMovimentoString = tipoMovimento;
    }

    /**
     * Função que retorna boolean
     * @return true se for cancelado, false se não for cancelado
     */
    public boolean isCancelamento() {
        return cancelamento;
    }

    public void setCancelamento(boolean cancelamento) {
        this.cancelamento = cancelamento;
    }

    public boolean isCliente() {
        return cliente;
    }

    public void setCliente(boolean cliente) {
        if(cliente){
            jRadioButtonCliente.setSelected(true);
            jRadioButtonFornecedor.setSelected(false);
        }else{
            jRadioButtonFornecedor.setSelected(true);
            jRadioButtonCliente.setSelected(false);
        }
        this.cliente = cliente;
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

        buttonGroupClienteFornecedor = new javax.swing.ButtonGroup();
        buttonGroupTipoOperacao = new javax.swing.ButtonGroup();
        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("cplusPU").createEntityManager();
        tipomovimentoQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT t FROM Tipomovimento t where t.codigo =\"999999\"");
        tipomovimentoList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(tipomovimentoQuery.getResultList());
        jPanelPesquisa = new javax.swing.JPanel();
        jComboBoxTipoPesquisa = new javax.swing.JComboBox();
        jTextFieldTermoPesquisa = new javax.swing.JTextField();
        jButtonPesquisar = new javax.swing.JButton();
        jRadioButtonCliente = new javax.swing.JRadioButton();
        jRadioButtonFornecedor = new javax.swing.JRadioButton();
        jRadioButtonSaida = new javax.swing.JRadioButton();
        jRadioButtonEntrada = new javax.swing.JRadioButton();
        jRadioButtonVenda = new javax.swing.JRadioButton();
        jRadioButtonCompra = new javax.swing.JRadioButton();
        jCheckBoxDevolucao = new javax.swing.JCheckBox();
        jCheckBoxInativo = new javax.swing.JCheckBox();
        jButtonCancelar = new javax.swing.JButton();
        jButtonOK = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableListagemMovimento = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Listagem de Operações");

        jPanelPesquisa.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisa"));
        jPanelPesquisa.setToolTipText("");

        jComboBoxTipoPesquisa.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jComboBoxTipoPesquisa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Descrição", "Código", "Item 3", "Item 4" }));
        jComboBoxTipoPesquisa.setToolTipText("Escolha o tipo de pesquisa");

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

        buttonGroupClienteFornecedor.add(jRadioButtonCliente);
        jRadioButtonCliente.setText("Cliente");

        buttonGroupClienteFornecedor.add(jRadioButtonFornecedor);
        jRadioButtonFornecedor.setSelected(true);
        jRadioButtonFornecedor.setText("Fornecedor");

        buttonGroupTipoOperacao.add(jRadioButtonSaida);
        jRadioButtonSaida.setSelected(true);
        jRadioButtonSaida.setText("Saída");

        buttonGroupTipoOperacao.add(jRadioButtonEntrada);
        jRadioButtonEntrada.setText("Entrada");

        buttonGroupTipoOperacao.add(jRadioButtonVenda);
        jRadioButtonVenda.setText("Venda");

        buttonGroupTipoOperacao.add(jRadioButtonCompra);
        jRadioButtonCompra.setText("Compra");

        jCheckBoxDevolucao.setText("Devolução");
        jCheckBoxDevolucao.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCheckBoxDevolucaoStateChanged(evt);
            }
        });

        jCheckBoxInativo.setText("Inativo");

        jButtonCancelar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/cancelar.png"))); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonOK.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/ok.png"))); // NOI18N
        jButtonOK.setText("OK!");
        jButtonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelPesquisaLayout = new javax.swing.GroupLayout(jPanelPesquisa);
        jPanelPesquisa.setLayout(jPanelPesquisaLayout);
        jPanelPesquisaLayout.setHorizontalGroup(
            jPanelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPesquisaLayout.createSequentialGroup()
                .addGroup(jPanelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPesquisaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jRadioButtonCliente)
                        .addGap(10, 10, 10)
                        .addComponent(jRadioButtonFornecedor))
                    .addComponent(jComboBoxTipoPesquisa, 0, 177, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPesquisaLayout.createSequentialGroup()
                        .addComponent(jTextFieldTermoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonOK, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
                    .addGroup(jPanelPesquisaLayout.createSequentialGroup()
                        .addComponent(jRadioButtonSaida)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButtonEntrada)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButtonVenda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButtonCompra)))
                .addContainerGap())
            .addGroup(jPanelPesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckBoxDevolucao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBoxInativo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelPesquisaLayout.setVerticalGroup(
            jPanelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPesquisaLayout.createSequentialGroup()
                .addGroup(jPanelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxTipoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTermoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisar)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonOK))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonCliente)
                    .addComponent(jRadioButtonFornecedor)
                    .addComponent(jRadioButtonSaida)
                    .addComponent(jRadioButtonEntrada)
                    .addComponent(jRadioButtonVenda)
                    .addComponent(jRadioButtonCompra))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxDevolucao)
                    .addComponent(jCheckBoxInativo))
                .addContainerGap())
        );

        jTableListagemMovimento.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tipomovimentoList, jTableListagemMovimento);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codigo}"));
        columnBinding.setColumnName("Codigo");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nometipomovimento}"));
        columnBinding.setColumnName("Nome Operação");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${flagcalculacofins}"));
        columnBinding.setColumnName("Flagcalculacofins");
        columnBinding.setColumnClass(Character.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${flagcalculapis}"));
        columnBinding.setColumnName("Flagcalculapis");
        columnBinding.setColumnClass(Character.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${flagprioridadecfop}"));
        columnBinding.setColumnName("Flagprioridadecfop");
        columnBinding.setColumnClass(Character.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codtipomovimentodevolucao}"));
        columnBinding.setColumnName("Codtipomovimentodevolucao");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${flaginativo}"));
        columnBinding.setColumnName("Flaginativo");
        columnBinding.setColumnClass(Character.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${flagcalculasubsttribcusto}"));
        columnBinding.setColumnName("Flagcalculasubsttribcusto");
        columnBinding.setColumnClass(Character.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${flagcalculaicms}"));
        columnBinding.setColumnName("Flagcalculaicms");
        columnBinding.setColumnClass(Character.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${flagcalculaipi}"));
        columnBinding.setColumnName("Flagcalculaipi");
        columnBinding.setColumnClass(Character.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codcfopforauf}"));
        columnBinding.setColumnName("CFOP for UF");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codcfopdentrouf}"));
        columnBinding.setColumnName("CFOP dentro UF");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${flagdevolucao}"));
        columnBinding.setColumnName("Devolução");
        columnBinding.setColumnClass(Character.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${flagtipomovimento}"));
        columnBinding.setColumnName("Flagtipomovimento");
        columnBinding.setColumnClass(Character.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${flagforncli}"));
        columnBinding.setColumnName("Flagforncli");
        columnBinding.setColumnClass(Character.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${naturezaoperacao}"));
        columnBinding.setColumnName("Natureza Operação");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codtipomovimento}"));
        columnBinding.setColumnName("Codtipomovimento");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(jTableListagemMovimento);
        if (jTableListagemMovimento.getColumnModel().getColumnCount() > 0) {
            jTableListagemMovimento.getColumnModel().getColumn(1).setMinWidth(150);
            jTableListagemMovimento.getColumnModel().getColumn(1).setPreferredWidth(350);
            jTableListagemMovimento.getColumnModel().getColumn(1).setMaxWidth(500);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanelPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldTermoPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTermoPesquisaActionPerformed
       pesquisas();
    }//GEN-LAST:event_jTextFieldTermoPesquisaActionPerformed

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
       pesquisas();
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
       cancelamento();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOKActionPerformed
        finalizacao();
    }//GEN-LAST:event_jButtonOKActionPerformed

    private void jCheckBoxDevolucaoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCheckBoxDevolucaoStateChanged
        pesquisas();
    }//GEN-LAST:event_jCheckBoxDevolucaoStateChanged

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
            java.util.logging.Logger.getLogger(ListagemOperacaoJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListagemOperacaoJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListagemOperacaoJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListagemOperacaoJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ListagemOperacaoJDialog dialog = new ListagemOperacaoJDialog(new javax.swing.JFrame(), true);
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
    Tipomovimento tipoMovimentoObjeto;
    boolean inativo;
    boolean devolucao;
    boolean cliente;
    String tipoMovimentoString;
    QueryCplus queryCplus;
    private int colunaCodMovimento;
    //static EntityManagerFactory managerCplus;
    boolean cancelamento;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupClienteFornecedor;
    private javax.swing.ButtonGroup buttonGroupTipoOperacao;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonOK;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JCheckBox jCheckBoxDevolucao;
    private javax.swing.JCheckBox jCheckBoxInativo;
    private javax.swing.JComboBox jComboBoxTipoPesquisa;
    private javax.swing.JPanel jPanelPesquisa;
    private javax.swing.JRadioButton jRadioButtonCliente;
    private javax.swing.JRadioButton jRadioButtonCompra;
    private javax.swing.JRadioButton jRadioButtonEntrada;
    private javax.swing.JRadioButton jRadioButtonFornecedor;
    private javax.swing.JRadioButton jRadioButtonSaida;
    private javax.swing.JRadioButton jRadioButtonVenda;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableListagemMovimento;
    private javax.swing.JTextField jTextFieldTermoPesquisa;
    private java.util.List<entidade.cplus.Tipomovimento> tipomovimentoList;
    private javax.persistence.Query tipomovimentoQuery;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
