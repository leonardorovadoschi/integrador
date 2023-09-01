/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador.separacao;

import acesso.ListagemUsuarioJDialog;
import entidade.cplus.Moventradaprod;
import entidade.cplus.Produto;
import entidade.cplus.Produtocodigo;
import entidade.cplus.Unidade;
import entidade.integrador.EntradaSerial;
import entidade.integrador.SerialProduto;
import integrador.relatorio.ImprimeRelatorio;
import java.awt.Toolkit;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jpa.integrador.EntradaSerialJpaController;
import jpa.integrador.SerialProdutoJpaController;
import jpa.integrador.exceptions.NonexistentEntityException;
import query.cplus.QueryCplus;
import query.integrador.QueryIntegrador;

/**
 *
 * @author leonardo
 */
public class EntradaSerialJDialog extends javax.swing.JDialog {

    /**
     * Creates new form EntradaSerialJDialog
     *
     * @param parent
     * @param modal
     * @param managerCplus1
     * @param managerIntegrador1
     */
    public EntradaSerialJDialog(java.awt.Frame parent, boolean modal, EntityManagerFactory managerCplus1, EntityManagerFactory managerIntegrador1) {
        super(parent, modal);
        initComponents();
        managerCplus = managerCplus1;
        managerIntegrador = managerIntegrador1;
        queryIntegrador = new QueryIntegrador(managerIntegrador);
        queryCplus = new QueryCplus(managerCplus);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icones/logo.png")));
        listagemUsuarioJDialog = new ListagemUsuarioJDialog(parent, true, managerCplus);
        colunaSerial = jTableSerialDigitado.getColumnModel().getColumnIndex("Serial");
        //var = var1;
        //produto = new ProdutoJpaController(managerCplus).findProduto(movEntradaProd.getCodprod().getCodprod());
        //listCodigo = querySerial.listagemProdutoCodigo(produto.getCodprod());
        //confereQuantidadeDigitada();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSerialDigitado = new javax.swing.JTable();
        jPanelControle = new javax.swing.JPanel();
        jTextFieldSerial = new javax.swing.JTextField();
        jLabelDigiteSerial = new javax.swing.JLabel();
        jLabelQuantidadeFaltando = new javax.swing.JLabel();
        jTextFieldQuantidadeFaltando = new javax.swing.JTextField();
        jButtonGerarSeriais = new javax.swing.JButton();
        jButtonGravar = new javax.swing.JButton();
        jButtonCancelarEntrada = new javax.swing.JButton();
        jPanelInformacoes = new javax.swing.JPanel();
        jButtonExcluirSerialSelecionado = new javax.swing.JButton();
        jButtonImprimirEtiqueta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Processo de Entrada de Seriais");

        jTableSerialDigitado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Serial"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableSerialDigitado.getTableHeader().setReorderingAllowed(false);
        jTableSerialDigitado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableSerialDigitadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableSerialDigitado);
        if (jTableSerialDigitado.getColumnModel().getColumnCount() > 0) {
            jTableSerialDigitado.getColumnModel().getColumn(0).setMinWidth(100);
            jTableSerialDigitado.getColumnModel().getColumn(0).setPreferredWidth(250);
            jTableSerialDigitado.getColumnModel().getColumn(0).setMaxWidth(500);
        }

        jTextFieldSerial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSerialActionPerformed(evt);
            }
        });

        jLabelDigiteSerial.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelDigiteSerial.setText("Digite o Serial aqui:");

        jLabelQuantidadeFaltando.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelQuantidadeFaltando.setText("Quantidade Faltando:");

        jTextFieldQuantidadeFaltando.setEditable(false);
        jTextFieldQuantidadeFaltando.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jTextFieldQuantidadeFaltando.setForeground(new java.awt.Color(204, 51, 0));
        jTextFieldQuantidadeFaltando.setFocusable(false);

        jButtonGerarSeriais.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonGerarSeriais.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/play.png"))); // NOI18N
        jButtonGerarSeriais.setText("Gerar Seriais");
        jButtonGerarSeriais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGerarSeriaisActionPerformed(evt);
            }
        });

        jButtonGravar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonGravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/salvar.png"))); // NOI18N
        jButtonGravar.setText("Gravar");
        jButtonGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGravarActionPerformed(evt);
            }
        });

        jButtonCancelarEntrada.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonCancelarEntrada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/cancelar.png"))); // NOI18N
        jButtonCancelarEntrada.setText("Cancelar Entrada");
        jButtonCancelarEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarEntradaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelControleLayout = new javax.swing.GroupLayout(jPanelControle);
        jPanelControle.setLayout(jPanelControleLayout);
        jPanelControleLayout.setHorizontalGroup(
            jPanelControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelControleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelControleLayout.createSequentialGroup()
                        .addGroup(jPanelControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelDigiteSerial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelQuantidadeFaltando, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldSerial)
                            .addGroup(jPanelControleLayout.createSequentialGroup()
                                .addComponent(jTextFieldQuantidadeFaltando, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanelControleLayout.createSequentialGroup()
                        .addComponent(jButtonCancelarEntrada)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonGerarSeriais)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonGravar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanelControleLayout.setVerticalGroup(
            jPanelControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelControleLayout.createSequentialGroup()
                .addGroup(jPanelControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldSerial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDigiteSerial))
                .addGroup(jPanelControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelControleLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelQuantidadeFaltando)
                            .addComponent(jTextFieldQuantidadeFaltando, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelControleLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addGroup(jPanelControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonGravar)
                            .addComponent(jButtonGerarSeriais)
                            .addComponent(jButtonCancelarEntrada))
                        .addContainerGap())))
        );

        jPanelInformacoes.setBorder(javax.swing.BorderFactory.createTitledBorder("Manuten��o"));

        jButtonExcluirSerialSelecionado.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonExcluirSerialSelecionado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/delete.png"))); // NOI18N
        jButtonExcluirSerialSelecionado.setText("Excluir Serial Selecionado");
        jButtonExcluirSerialSelecionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirSerialSelecionadoActionPerformed(evt);
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

        javax.swing.GroupLayout jPanelInformacoesLayout = new javax.swing.GroupLayout(jPanelInformacoes);
        jPanelInformacoes.setLayout(jPanelInformacoesLayout);
        jPanelInformacoesLayout.setHorizontalGroup(
            jPanelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInformacoesLayout.createSequentialGroup()
                .addGroup(jPanelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonExcluirSerialSelecionado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                    .addComponent(jButtonImprimirEtiqueta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelInformacoesLayout.setVerticalGroup(
            jPanelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInformacoesLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jButtonImprimirEtiqueta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonExcluirSerialSelecionado)
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelControle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelInformacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelControle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelInformacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGravarActionPerformed
        //if (gravarProdutoSerial() == false) {
        //    DefaultTableModel tabelaEntradaSerial = (DefaultTableModel) jTableSerialDigitado.getModel();
        //   int cont = jTableSerialDigitado.getRowCount();
        //   for (int a = 0; a < cont; a++) {
        //       tabelaEntradaSerial.removeRow(0);
        //   }
        dispose();
        setVisible(false);
        // }
    }//GEN-LAST:event_jButtonGravarActionPerformed

    private void jTextFieldSerialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSerialActionPerformed
        verificaSerial();

    }//GEN-LAST:event_jTextFieldSerialActionPerformed

    private void jButtonGerarSeriaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGerarSeriaisActionPerformed
        gerarSeriais();
    }//GEN-LAST:event_jButtonGerarSeriaisActionPerformed

    private void jButtonExcluirSerialSelecionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirSerialSelecionadoActionPerformed
        int cancelar = JOptionPane.showConfirmDialog(null, "DESEJA EXCLUIR A LINHA SELECIONADA??", "Excluir", JOptionPane.YES_NO_CANCEL_OPTION);
        if (cancelar == JOptionPane.YES_NO_OPTION) {//Verifica se ha uma linha selecionada
            excluirSerialSelecionado();
        }
    }//GEN-LAST:event_jButtonExcluirSerialSelecionadoActionPerformed

    private void jTableSerialDigitadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableSerialDigitadoMouseClicked
        jButtonExcluirSerialSelecionado.setEnabled(true);
    }//GEN-LAST:event_jTableSerialDigitadoMouseClicked

    private void jButtonCancelarEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarEntradaActionPerformed
        int cancelar = JOptionPane.showConfirmDialog(null, "CUIDADO!! \n SER� EXCLUIDO TODOS OS SERIAIS", "Cancelar", JOptionPane.YES_NO_CANCEL_OPTION);
        if (cancelar == JOptionPane.YES_NO_OPTION) {
            excluirSeriaisDoBanco();
            dispose();
            setVisible(false);
        }
    }//GEN-LAST:event_jButtonCancelarEntradaActionPerformed

    private void jButtonImprimirEtiquetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImprimirEtiquetaActionPerformed
        List<SerialProduto> listText = new ArrayList<>();
        for (EntradaSerial s : queryIntegrador.listPorEntradaProd(movEntradaProd.getCodmoveprod())) {
            s.getIdSerial().setNomeProduto(movEntradaProd.getCodprod().getCodigo() + "-" + s.getIdSerial().getNomeProduto());
            listText.add(s.getIdSerial());
        }
        new ImprimeRelatorio().imprimeRelatorio(queryIntegrador.valorConfiguracao("caminho_ENTRADA_SERIAL"), listText);
    }//GEN-LAST:event_jButtonImprimirEtiquetaActionPerformed

    private void excluirSerialSelecionado() {
        DefaultTableModel tabelaEntradaSerial = (DefaultTableModel) jTableSerialDigitado.getModel();
        int row = jTableSerialDigitado.getSelectedRow();
        int coluna = jTableSerialDigitado.getColumnModel().getColumnIndex("Serial");
        tabelaEntradaSerial.removeRow(row);
        for (SerialProduto sp : queryIntegrador.listSerialExato((String) jTableSerialDigitado.getValueAt(row, coluna))) {
            if (sp.getSaidaSerialCollection().size() > 0) {
                JOptionPane.showMessageDialog(null, "\n O serial j� possui uma saida.\n A mesma deve ser excluida antes de prosseguir! " );
            } else {
                for (EntradaSerial es : sp.getEntradaSerialCollection()) {
                    try {
                        new EntradaSerialJpaController(managerIntegrador).destroy(es.getIdEntradaSerial());
                    } catch (NonexistentEntityException ex) {
                        tocarSomErro();
                        JOptionPane.showMessageDialog(null, "\n Erro ao Excluir Entrada Serial.\n " + ex);
                    }
                }
                try {
                    new SerialProdutoJpaController(managerIntegrador).destroy(sp.getIdSerial());
                } catch (NonexistentEntityException ex) {
                    tocarSomErro();
                    JOptionPane.showMessageDialog(null, "\n Erro ao Excluir Serial Produto.\n " + ex);
                }
            }
        }
        jButtonExcluirSerialSelecionado.setEnabled(false);
        confereQuantidadeDigitada();
    }

    private void criarTabela(List<String> listTex) {
        DefaultTableModel tabelaEntradaSerial = (DefaultTableModel) jTableSerialDigitado.getModel();
        int cont = jTableSerialDigitado.getRowCount();
        for (int a = 0; a < cont; a++) {
            tabelaEntradaSerial.removeRow(0);
        }
        for (String s : listTex) {
            tabelaEntradaSerial.addRow(new Object[]{String.valueOf(s)});
        }
        if (jTableSerialDigitado.getRowCount() != 0) {
            jTableSerialDigitado.setRowSelectionInterval(jTableSerialDigitado.getRowCount() - 1, jTableSerialDigitado.getRowCount() - 1);//seleciona ultima linha   
        }
    }

    private void gerarSeriais() {
        if (queryIntegrador.listPorEntradaProd(movEntradaProd.getCodmoveprod()).isEmpty()) {
            String gerarSerialPorData = new SimpleDateFormat("ddMMyyHHmmss").format(new Date());
            gerarSerialPorData = gerarSerialPorData + "001";
            int quantidadeEntrada = quantidadePacote;
            queryIntegrador.listPorEntradaProd(movEntradaProd.getCodmoveprod());
            List<String> listTex = new ArrayList<>();
            long cont = Long.parseLong(gerarSerialPorData);
            for (int increment = 0; increment < quantidadeEntrada; increment++) {
                cont++;
                jTableSerialDigitado.clearSelection(); //Tira linha selecionada      
                listTex.add(String.valueOf(cont));
                gravarProdutoSerial(String.valueOf(cont));
            }
            criarTabela(listTex);
            confereQuantidadeDigitada();
            tocarSomFinalizado();
        } else {
            tocarSomErro();
            JOptionPane.showMessageDialog(null, "J� EXISTEM ALGUNS SERIAIS GRAVADOS IMPOSSIVEL EXECUTAR A TAREFA!!");
        }
    }

    public void confereQuantidadeDigitada() {
        if (jTableSerialDigitado.getRowCount() == quantidadePacote) {
            jButtonGravar.setEnabled(true);
            jTextFieldSerial.setEnabled(false);
            jTextFieldSerial.setText("");
            jButtonGerarSeriais.setEnabled(false);
            jTextFieldQuantidadeFaltando.setText("0");
         //   jButtonExcluirTodosSeriaisDigitados.setEnabled(true);
        } else {
            int quantFaltando = quantidadePacote - jTableSerialDigitado.getRowCount();
            jTextFieldQuantidadeFaltando.setText(String.valueOf(quantFaltando));
            if (jTableSerialDigitado.getRowCount() < 1) {
                jButtonGerarSeriais.setEnabled(true);
                jButtonExcluirSerialSelecionado.setEnabled(false);
              //  jButtonExcluirTodosSeriaisDigitados.setEnabled(false);
            } else {
              //  jButtonExcluirTodosSeriaisDigitados.setEnabled(true);
                jButtonGerarSeriais.setEnabled(false);
            }
            jButtonGravar.setEnabled(false);
            jTextFieldSerial.setEnabled(true);
            jTextFieldSerial.selectAll();
            jTextFieldSerial.requestFocus();
        }
    }

    private boolean gravarProdutoSerial(String serial) {
        boolean condicao = false;
        //int contTabela = jTableSerialDigitado.getRowCount();
        //int contProdSerial = queryCplus.incrementProdutoSerial();
        //int contMovProdSerial = queryCplus.incrementMovEntradaProdSerial();
        //for (int cont = 0; cont < contTabela; cont++) {//Percore todos os registros da tabela
        //contProdSerial++;
        //contMovProdSerial++;
        // jTableSerialDigitado.setRowSelectionInterval(cont, cont);
        SerialProduto serialProd = new SerialProduto();//instancia classe
        serialProd.setCodProduto(produto.getCodprod());
        serialProd.setSerial(serial);//pega valor de jTable Serial
        //produtoSerial.setCodprodutoserial(String.format("%09d", contProdSerial));
        serialProd.setCodigoProduto(produto.getCodigo());
        serialProd.setNomeProduto(produto.getNomeprod());
        serialProd.setData(new Date(System.currentTimeMillis()));
        try {
            new SerialProdutoJpaController(managerIntegrador).create(serialProd);//Cria objeto no banco de dados
            if (gravarEntradaSerial(new SerialProdutoJpaController(managerIntegrador).findSerialProduto(serialProd.getIdSerial()))) {
                // condicao = true;
            }
        } catch (Exception ex) {
            tocarSomErro();
            JOptionPane.showMessageDialog(null, "\n Erro ao gravar produto Serial.\n " + ex);
            // condicao = true;
        }
        //if (condicao) {
        //    excluirEntradaSerialBanco();
        //   JOptionPane.showMessageDialog(null, "OS REGISTROS FORAM EXCLUIDOS TENTE NOVAMENTE!!");
        //break;
        // }
        // }
        //jButtonGravar.setEnabled(false);
        return condicao;
    }

    private boolean gravarEntradaSerial(SerialProduto produtoSerial) {
        boolean condicao = false;
        EntradaSerial ent = new EntradaSerial();
        ent.setIdSerial(produtoSerial);
        ent.setCodEntradaProd(movEntradaProd.getCodmoveprod());
        ent.setCodEntrada(movEntradaProd.getCodmoventr().getCodmoventr());
        ent.setDevolvido(false);
        ent.setDataEntrada(new Date(System.currentTimeMillis()));
        try {
            new EntradaSerialJpaController(managerIntegrador).create(ent);
        } catch (Exception ex) {
            tocarSomErro();
            JOptionPane.showMessageDialog(null, "\n Erro ao gravar Entrada Serial.\n " + ex);
            condicao = true;
        }
        return condicao;
    }

    private void excluirSeriaisDoBanco() {
        List<EntradaSerial> listMovProdSerial = queryIntegrador.listPorEntradaProd(movEntradaProd.getCodmoveprod());
        for (EntradaSerial ent : listMovProdSerial) {
            try {
                new EntradaSerialJpaController(managerIntegrador).destroy(ent.getIdEntradaSerial());
                new SerialProdutoJpaController(managerIntegrador).destroy(ent.getIdSerial().getIdSerial());
            } catch (NonexistentEntityException ex) {
                tocarSomErro();
                JOptionPane.showMessageDialog(null, "\n Erro ao Excluir Entrada Serial.\n " + ex);
            }
        }
        jButtonGravar.setEnabled(true);
    }

    private void verificaSerial() {
        String textoDigitado = jTextFieldSerial.getText().toUpperCase().trim();
        List<SerialProduto> produtoSerial = queryIntegrador.listSerialExato(textoDigitado);
        if (produtoSerial.isEmpty()) {//if que verifica se o serial j� existe no banco
            if (serialCadastroEntrada(textoDigitado)) {//if que verifica se o serial j� est� na tabela
                if (verificaQuantidade()) {//if que verifica se a quantidade digitada foi exedida
                    if (verificaCodigos(textoDigitado)) {
                        DefaultTableModel tabelaEntradaSerial = (DefaultTableModel) jTableSerialDigitado.getModel();
                        jTableSerialDigitado.clearSelection(); //Tira linha selecionada
                        tabelaEntradaSerial.addRow(new Object[]{textoDigitado});
                        gravarProdutoSerial(textoDigitado);
                        jTableSerialDigitado.setRowSelectionInterval(jTableSerialDigitado.getRowCount() - 1, jTableSerialDigitado.getRowCount() - 1);//seleciona ultima linha                        
                    } else {
                        tocarSomErro();
                        JOptionPane.showMessageDialog(null, "N�o pode ser EAN ou outros C�digos!!!");
                        this.listagemUsuarioJDialog.setVisible(true);
                    }
                } else {
                    tocarSomErro();
                    JOptionPane.showMessageDialog(null, "A Entrada de Serial desse Produto j� est� completa!!!!!");
                    this.listagemUsuarioJDialog.setVisible(true);
                }
            } else {
                tocarSomErro();
                JOptionPane.showMessageDialog(null, "O Serial j� est� na tabela!!! \n Serial: " + textoDigitado);
                this.listagemUsuarioJDialog.setVisible(true);
            }
        } else {//else que verifica se ha serial cadastrado
            tocarSomErro();
            JOptionPane.showMessageDialog(null, "O Serial digitado j� est� cadastrado!!! \n" + produtoSerial.size() + " Resultados encontrados");
            this.listagemUsuarioJDialog.setVisible(true);
        }
        confereQuantidadeDigitada();
    }

    private boolean verificaCodigos(String textoDigitado) {
        boolean condicao = true;
        if (produto.getCodigo() == null ? textoDigitado == null : produto.getCodigo().equals(textoDigitado)) {
            condicao = false;
        } else {
            for (Produtocodigo cod : listCodigo) {
                if (cod.getCodigo() == null ? textoDigitado == null : cod.getCodigo().equals(textoDigitado)) {
                    condicao = false;
                }
            }
        }
        return condicao;
    }

    private boolean verificaQuantidade() {
        boolean condicao = true;
        // int cont = jTableSerialDigitado.getRowCount();
        if (jTableSerialDigitado.getRowCount() > quantidadePacote) {
            condicao = false;
        }
        return condicao;
    }

    private boolean serialCadastroEntrada(String textoDigitado) {
        boolean condicao = true;
        int totalLinhaSerial = jTableSerialDigitado.getRowCount();
        String serialTabela;
        colunaSerial = jTableSerialDigitado.getColumnModel().getColumnIndex("Serial");
        for (int linhaSerial = 0; linhaSerial < totalLinhaSerial; linhaSerial++) {
            serialTabela = jTableSerialDigitado.getValueAt(linhaSerial, colunaSerial).toString();
            if (serialTabela.equals(textoDigitado)) {
                jTableSerialDigitado.setRowSelectionInterval(linhaSerial, linhaSerial);
                condicao = false;
                break;
            }
        }
        return condicao;
    }

    private int quantidadePacote(Moventradaprod prodEnt) {
        int quantidade = prodEnt.getQuantidade().intValue();
        List<Unidade> listUn = queryCplus.resultPorUnidadeProduto(prodEnt.getCodprod().getUnidade());
        for (Unidade un : listUn) {
            if (un.getFatorconversao().intValue() > 1) {
                quantidade = quantidade / un.getFatorconversao().intValue();
            }
        }
        //quantidade = quantidade - queryCplus.listagemSerialEntradaProd(prodEnt.getCodmoveprod()).size();
        return quantidade;
    }

    private void tocarSomErro() {
        String path = queryIntegrador.valorConfiguracao("caminho_ARQUIVO_AUDIO_ERRO");
        File mp3File = new File(path);
        ReproduzirAudio musica = new ReproduzirAudio(mp3File);
        musica.play();
    }

    private void tocarSomFinalizado() {
        String path = queryIntegrador.valorConfiguracao("caminho_ARQUIVO_AUDIO_FINALIZADO");
        File mp3File = new File(path);
        ReproduzirAudio musica = new ReproduzirAudio(mp3File);
        musica.play();
    }

    public void setMovEntradaProd(Moventradaprod movEntradaProd) {
        this.quantidadePacote = quantidadePacote(movEntradaProd);
        this.movEntradaProd = movEntradaProd;
        List<String> listTex = new ArrayList<>();
        for (EntradaSerial s : queryIntegrador.listPorEntradaProd(movEntradaProd.getCodmoveprod())) {
            listTex.add(s.getIdSerial().getSerial());
        }
        criarTabela(listTex);
    }

    public void setListCodigo(List<Produtocodigo> listCodigo) {
        this.listCodigo = listCodigo;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
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
            java.util.logging.Logger.getLogger(EntradaSerialJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EntradaSerialJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EntradaSerialJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EntradaSerialJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EntradaSerialJDialog dialog = new EntradaSerialJDialog(new javax.swing.JFrame(), true, managerCplus, managerIntegrador);
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

    private final QueryCplus queryCplus;
    private final QueryIntegrador queryIntegrador;
    private static EntityManagerFactory managerCplus;
    private static EntityManagerFactory managerIntegrador;
    private Moventradaprod movEntradaProd;
    private final ListagemUsuarioJDialog listagemUsuarioJDialog;
    private int colunaSerial;
    private List<Produtocodigo> listCodigo;
    private Produto produto;
    private int quantidadePacote;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelarEntrada;
    private javax.swing.JButton jButtonExcluirSerialSelecionado;
    private javax.swing.JButton jButtonGerarSeriais;
    private javax.swing.JButton jButtonGravar;
    private javax.swing.JButton jButtonImprimirEtiqueta;
    private javax.swing.JLabel jLabelDigiteSerial;
    private javax.swing.JLabel jLabelQuantidadeFaltando;
    private javax.swing.JPanel jPanelControle;
    private javax.swing.JPanel jPanelInformacoes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableSerialDigitado;
    private javax.swing.JTextField jTextFieldQuantidadeFaltando;
    private javax.swing.JTextField jTextFieldSerial;
    // End of variables declaration//GEN-END:variables
}
