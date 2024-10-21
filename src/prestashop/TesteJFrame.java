/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prestashop;

import entidade.integrador.EntradaSerial;
import entidade.integrador.IntConfiguracao;
import entidade.integrador.SerialProduto;
import integrador.relatorio.ImprimeRelatorio;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import jpa.integrador.IntConfiguracaoJpaController;
import query.cplus.QueryCplus;
import query.integrador.QueryIntegrador;

/**
 *
 * @author leo-note
 */
public class TesteJFrame extends javax.swing.JFrame {

    /**
     * Creates new form TesteJFrame
     */
    public TesteJFrame() {
        initComponents();
        managerCplus = Persistence.createEntityManagerFactory("cplusPU");
        //managerIntegrador = Persistence.createEntityManagerFactory("integradorPU");
        managerPrestaShop = Persistence.createEntityManagerFactory("PrestaShopPU");
        queryIntegrador = new QueryIntegrador();
        this.configuracoesJDialog = new ConfiguracoesJDialog(this, true);
        carregaConfiguracoes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chooser = new javax.swing.JFileChooser();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        chooser.setCurrentDirectory(new java.io.File("C:\\lista_integrador\\relatorio\\etiquetaEntrada.jrxml"));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton2.setText("Imprimir por jar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(338, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(516, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.configuracoesJDialog.setCarregaCampos();
        this.configuracoesJDialog.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void carregaConfiguracoes() {
        for (IntConfiguracao c : new IntConfiguracaoJpaController(Manager.getManagerIntegrador()).findIntConfiguracaoEntities()) {
            switch (c.getTipo()) {
                case "caminho_ARQUIVO_AUDIO_FINALIZADO":
                    ConfiguracaoNoBD.setValorAudioFinalizado(c.getValor());
                    ConfiguracaoNoBD.setTipoAudioFinalizado(c.getTipo());
                    break;
                case "caminho_ARQUIVO_AUDIO_ERRO":
                    ConfiguracaoNoBD.setValorAudioErro(c.getValor());
                    ConfiguracaoNoBD.setTipoAudioErro(c.getTipo());
                    break;
                case "caminho_RELATORIO_ROMANEIO_SERIAIS":
                    ConfiguracaoNoBD.setValorRomaneioSeriais(c.getValor());
                    ConfiguracaoNoBD.setTipoRomaneioSeriais(c.getTipo());
                    break;
                case "caminho_RELATORIO_ESPELHO_RMA":
                    ConfiguracaoNoBD.setValorEspelhoRma(c.getValor());
                    ConfiguracaoNoBD.setTipoEspelhoRma(c.getTipo());
                    break;
                case "caminho_ENTRADA_SERIAL":
                    ConfiguracaoNoBD.setValorEtiquetaSerial(c.getValor());
                    ConfiguracaoNoBD.setTipoEtiquetaSerial(c.getTipo());
                    break;
            }
        }
    }

    private void imprimirArquivo() {
        List<SerialProduto> listText = new ArrayList<>();
        for (EntradaSerial s : queryIntegrador.listPorEntradaProd("001042711")) {
            s.getIdSerial().setNomeProduto(s.getIdSerial().getCodigoProduto() + "-" + s.getIdSerial().getNomeProduto());
            listText.add(s.getIdSerial());
        }
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Selecione apenas JRXML e JASPER", "jrxml", "jasper");
        //JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Selecione os arquivos");
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int retorno = chooser.showOpenDialog(this);
        if (retorno == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            new ImprimeRelatorio().imprimeRelatorioPeloJar(file.getPath().replace("\\", "/"), listText);
            jTextField1.setText(file.getPath().replace("\\", "/"));
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
            java.util.logging.Logger.getLogger(TesteJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TesteJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TesteJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TesteJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TesteJFrame().setVisible(true);
            }
        });
    }

    //private final EntityManagerFactory managerIntegrador;
    private final EntityManagerFactory managerPrestaShop;
    private final EntityManagerFactory managerCplus;
    private final QueryIntegrador queryIntegrador;
    private final ConfiguracoesJDialog configuracoesJDialog;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser chooser;
    private javax.swing.JButton jButton2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
