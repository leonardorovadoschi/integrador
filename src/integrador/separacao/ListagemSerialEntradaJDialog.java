/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador.separacao;

//import entidade.cplus.Movendaprodserial;
import entidade.cplus.Moventrada;
import entidade.cplus.Moventradaprod;
import entidade.integrador.EntradaSerial;
import entidade.integrador.SerialProduto;
import integrador.relatorio.ImprimeRelatorio;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jpa.cplus.MoventradaJpaController;
import jpa.integrador.EntradaSerialJpaController;
import jpa.integrador.SerialProdutoJpaController;
import jpa.integrador.exceptions.NonexistentEntityException;
import prestashop.ConfiguracaoNoBD;
import prestashop.Manager;
import query.cplus.QueryCplus;
import query.integrador.QueryIntegrador;

/**
 *
 * @author leonardo
 */
public class ListagemSerialEntradaJDialog extends javax.swing.JDialog {

    /**
     * Creates new form ListagemSerialEntradaJDialog
     *
     * @param parent
     * @param modal
     */
    public ListagemSerialEntradaJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
       // managerCplus = managerCplus1;
        //managerIntegrador = managerIntegrador1;
        queryCplus = new QueryCplus();
        queryIntegrador = new QueryIntegrador();
        //this.entradaSerialJFrame= new EntradaSerialJFrame(managerCplus, managerIntegrador);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icones/logo.png")));
        //colunaIdEntradaSerial = jTableEntradaSerial.getColumnModel().getColumnIndex("ID Entrada Serial");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTableEntradaSerial = new javax.swing.JTable();
        jPanelPrincipal = new javax.swing.JPanel();
        jButtonExcluirSerial = new javax.swing.JButton();
        jButtonEditarSerial = new javax.swing.JButton();
        jTextFieldSerial = new javax.swing.JTextField();
        jButtonAtualizarTabela = new javax.swing.JButton();
        jButtonImprimirEtiqueta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listagem de Entradas Seriais");

        jTableEntradaSerial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "C�digo", "Serial", "ID Entrada Serial"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableEntradaSerial.setColumnSelectionAllowed(true);
        jTableEntradaSerial.getTableHeader().setReorderingAllowed(false);
        jTableEntradaSerial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEntradaSerialMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableEntradaSerial);
        jTableEntradaSerial.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTableEntradaSerial.getColumnModel().getColumnCount() > 0) {
            jTableEntradaSerial.getColumnModel().getColumn(0).setPreferredWidth(80);
            jTableEntradaSerial.getColumnModel().getColumn(1).setPreferredWidth(200);
        }

        jButtonExcluirSerial.setText("Excluir Serial");
        jButtonExcluirSerial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirSerialActionPerformed(evt);
            }
        });

        jButtonEditarSerial.setText("Editar Serial");
        jButtonEditarSerial.setEnabled(false);
        jButtonEditarSerial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarSerialActionPerformed(evt);
            }
        });

        jButtonAtualizarTabela.setText("Atualizar Tabela");
        jButtonAtualizarTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtualizarTabelaActionPerformed(evt);
            }
        });

        jButtonImprimirEtiqueta.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonImprimirEtiqueta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/imprimir.png"))); // NOI18N
        jButtonImprimirEtiqueta.setText("Imprimir Seriais");
        jButtonImprimirEtiqueta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImprimirEtiquetaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelPrincipalLayout = new javax.swing.GroupLayout(jPanelPrincipal);
        jPanelPrincipal.setLayout(jPanelPrincipalLayout);
        jPanelPrincipalLayout.setHorizontalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonExcluirSerial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonEditarSerial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldSerial)
                    .addComponent(jButtonAtualizarTabela, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                    .addComponent(jButtonImprimirEtiqueta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelPrincipalLayout.setVerticalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jButtonAtualizarTabela)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldSerial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonEditarSerial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonExcluirSerial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonImprimirEtiqueta)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAtualizarTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtualizarTabelaActionPerformed
        atualizaTabela();
    }//GEN-LAST:event_jButtonAtualizarTabelaActionPerformed

    private void jButtonEditarSerialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarSerialActionPerformed
        int cancelar = JOptionPane.showConfirmDialog(null, "DESEJA EDITAR O SERIAL??", "Editar", JOptionPane.YES_NO_CANCEL_OPTION);
        if (cancelar == JOptionPane.YES_NO_OPTION) {//Verifica se ha uma linha selecionada         
                editaSerial();
                jButtonEditarSerial.setEnabled(false);           
        }
    }//GEN-LAST:event_jButtonEditarSerialActionPerformed

    private void jButtonExcluirSerialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirSerialActionPerformed
        if (jTableEntradaSerial.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Voc� deve selecionar o serial para Excluir!!");
        } else {
            int cancelar = JOptionPane.showConfirmDialog(null, " Deseja realmente Excluir o Serial Selecionado\n A A��O N�O PODE SER DISFEITA!!!", "Excluir", JOptionPane.YES_NO_CANCEL_OPTION);
            if (cancelar == JOptionPane.YES_OPTION) {
                excluiSerial();
            }
        }
    }//GEN-LAST:event_jButtonExcluirSerialActionPerformed

    private void jTableEntradaSerialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableEntradaSerialMouseClicked
        jButtonEditarSerial.setEnabled(true);
        jButtonExcluirSerial.setEnabled(true);
    }//GEN-LAST:event_jTableEntradaSerialMouseClicked

    private void jButtonImprimirEtiquetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImprimirEtiquetaActionPerformed
        List<SerialProduto> listText = new ArrayList<>();
        for (EntradaSerial s : queryIntegrador.listPorEntradaProd(getCodMovProd())) {
            s.getIdSerial().setNomeProduto(s.getIdSerial().getCodigoProduto() + "-" + s.getIdSerial().getNomeProduto());
            listText.add(s.getIdSerial());
        }
        new ImprimeRelatorio().imprimeRelatorioPeloJar(ConfiguracaoNoBD.getCaminhoEtiquetaSerial(), listText);
        dispose();
        setVisible(false);
    }//GEN-LAST:event_jButtonImprimirEtiquetaActionPerformed

    private void excluiSerial() {
        colunaSerial = jTableEntradaSerial.getColumnModel().getColumnIndex("Serial");
        String ser = jTableEntradaSerial.getValueAt(jTableEntradaSerial.getSelectedRow(), colunaSerial).toString();
        List<SerialProduto> listProdSerial = queryIntegrador.listSerialExato(ser);
        if (listProdSerial.size() < 1) {
            JOptionPane.showMessageDialog(null, "O serial " + ser + " N�o existe, Verifique!!!");
        } else {
            for (SerialProduto proSer : listProdSerial) {
                proSer.getSaidaSerialCollection();
                if (proSer.getSaidaSerialCollection().isEmpty()) {
                    for (EntradaSerial entSer : proSer.getEntradaSerialCollection()) {
                        try {
                            new EntradaSerialJpaController(Manager.getManagerIntegrador()).destroy(entSer.getIdEntradaSerial());
                        } catch (NonexistentEntityException ex) {
                            JOptionPane.showMessageDialog(null, "Houve um Erro ao Excluir Entrada Serial \n" + ex);
                        }
                    }//for                   
                    try {
                        new SerialProdutoJpaController(Manager.getManagerIntegrador()).destroy(proSer.getIdSerial());
                        atualizaTabela();
                    } catch (NonexistentEntityException ex) {
                        JOptionPane.showMessageDialog(null, "Houve um Erro ao Excluir Produto Serial \n" + ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "O serial " + ser + " N�o pode ser Excluido pois j� tem Saida, Verifique!!!");
                }//else
            }//for
        }//else
    }

    private void editaSerial() {
        String textoDigitado = JOptionPane.showInputDialog("Digite o Serial novo! ").toUpperCase().trim();
        if(!"".equals(textoDigitado)){
        List<SerialProduto> produtoSerial = queryIntegrador.listSerialExato(textoDigitado);
        if (produtoSerial.isEmpty()) {
            //colunaIdEntradaSerial = jTableEntradaSerial.getColumnModel().getColumnIndex("ID Entrada Serial");
            int row = jTableEntradaSerial.getSelectedRow();
            int coluna = jTableEntradaSerial.getColumnModel().getColumnIndex("ID Entrada Serial");
            EntradaSerial prodSerial = new EntradaSerialJpaController(Manager.getManagerIntegrador()).findEntradaSerial((Integer) jTableEntradaSerial.getValueAt(row, coluna));
            SerialProduto serial = new SerialProdutoJpaController(Manager.getManagerIntegrador()).findSerialProduto(prodSerial.getIdSerial().getIdSerial());
            serial.setSerial(textoDigitado);
            try {
                new SerialProdutoJpaController(Manager.getManagerIntegrador()).edit(serial);               
                atualizaTabela();
                jTextFieldSerial.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "HOUVE UM ERRO AO EDITAR SERIAL, Verifique!! \n" + ex, "Erro Editar", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "ESTE SERIAL J� ESTA CADASTRADO!! \n, Verifique!! \n", "Erro Editar", JOptionPane.ERROR_MESSAGE);
        }
        }else{
         JOptionPane.showMessageDialog(null, "O campo serial deve estar preenchido!! \n, Verifique!! \n", "Erro Editar", JOptionPane.ERROR_MESSAGE);   
        }
    }

    private void atualizaTabela() {
        jButtonEditarSerial.setEnabled(false);
        jButtonExcluirSerial.setEnabled(false);
        //moventradaprodserialList.clear();
        List<Moventradaprod> listSerial = queryCplus.listagemMovEntradaProdPorEntrada(movEntrada.getCodmoventr());
        DefaultTableModel tab = (DefaultTableModel) jTableEntradaSerial.getModel();
        while (jTableEntradaSerial.getModel().getRowCount() > 0) {  
           ((DefaultTableModel) jTableEntradaSerial.getModel()).removeRow(0);  
       } 
        for (Moventradaprod movProd : listSerial) {
            for (EntradaSerial ent : queryIntegrador.listPorEntradaProd(movProd.getCodmoveprod())) {
                tab.addRow(new Object[]{movProd.getCodprod().getCodigo(), ent.getIdSerial().getSerial(), ent.getIdEntradaSerial()});
            }
        }
    }

    public void setMovEntrada(Moventrada movEntrada) {
        this.movEntrada = movEntrada;
        atualizaTabela();
    }
    
    
    void setMovEntradaProd(String codMovProd) {
         jButtonEditarSerial.setEnabled(false);
        jButtonExcluirSerial.setEnabled(false);
        this.codMovProd = codMovProd;
        //moventradaprodserialList.clear();
        DefaultTableModel tab = (DefaultTableModel) jTableEntradaSerial.getModel();
        while (jTableEntradaSerial.getModel().getRowCount() > 0) {  
           ((DefaultTableModel) jTableEntradaSerial.getModel()).removeRow(0);  
       }        
            for (EntradaSerial ent : queryIntegrador.listPorEntradaProd(codMovProd)) {
                this.movEntrada = new MoventradaJpaController(Manager.getManagerCplus()).findMoventrada(ent.getCodEntrada());
                tab.addRow(new Object[]{ent.getIdSerial().getCodigoProduto(), ent.getIdSerial().getNomeProduto(), ent.getIdSerial().getSerial(), ent.getIdEntradaSerial()});
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListagemSerialEntradaJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListagemSerialEntradaJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListagemSerialEntradaJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListagemSerialEntradaJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ListagemSerialEntradaJDialog dialog = new ListagemSerialEntradaJDialog(new javax.swing.JFrame(), true);
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
    private String codMovProd;

    public String getCodMovProd() {
        return codMovProd;
    }
    //private static EntityManagerFactory managerCplus;
    //private static EntityManagerFactory managerIntegrador;
    private final QueryCplus queryCplus;
    private final QueryIntegrador queryIntegrador;
    //private final EntradaSerialJFrame entradaSerialJFrame;
    private Moventrada movEntrada;
    //private int colunaIdEntradaSerial;
    private int colunaSerial;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAtualizarTabela;
    private javax.swing.JButton jButtonEditarSerial;
    private javax.swing.JButton jButtonExcluirSerial;
    private javax.swing.JButton jButtonImprimirEtiqueta;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableEntradaSerial;
    private javax.swing.JTextField jTextFieldSerial;
    // End of variables declaration//GEN-END:variables

  

}
