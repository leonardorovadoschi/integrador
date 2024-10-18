/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prestashop;

import javax.swing.JFrame;

/**
 *
 * @author leo
 */
public class PrestaShop {

    static PrincipalJFrame frameIntegracao;
    //static TesteJFrame frameIntegracao;
    //static VendaDigimacroJFrame siteJFrame;
    //static RelatorioEstoqueJFrame relatorioEstoqueJFrame;
      
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(() -> {
            if (frameIntegracao == null || !frameIntegracao.isDisplayable()) {
                frameIntegracao = new PrincipalJFrame();
                //frameIntegracao.setLocationRelativeTo(this); //opcional
            } else {
                frameIntegracao.setExtendedState(JFrame.NORMAL);
                frameIntegracao.toFront();
            }
            frameIntegracao.setVisible(true);
        });
    }

}
