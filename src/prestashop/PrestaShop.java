/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prestashop;

import acesso.ConexaoDB;
import integrador.webservice.PrestaShopWebserviceException;
import janela.cplus.RelatorioEstoqueJFrame;

import janela.prestaShop.VendaDigimacroJFrame;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JFrame;
import javax.xml.transform.TransformerException;
import jpa.cplus.UsuarioJpaController;

/**
 *
 * @author leo
 */
public class PrestaShop {

    static PrincipalJFrame frameIntegracao;
    static VendaDigimacroJFrame siteJFrame;
    static RelatorioEstoqueJFrame relatorioEstoqueJFrame;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //EntityManagerFactory managerCplus = Persistence.createEntityManagerFactory("cplusPU");
                //EntityManagerFactory managerIntegrador = Persistence.createEntityManagerFactory("integradorPU");
               // EntityManagerFactory managerPrestaShop = Persistence.createEntityManagerFactory("PrestaShopPU");
                //relatorio estoque
                /**
                 * if (relatorioEstoqueJFrame == null ||
                 * !relatorioEstoqueJFrame.isDisplayable()) {
                 * relatorioEstoqueJFrame = new
                 * RelatorioEstoqueJFrame(managerCplus);
                 * //relatorioEstoqueJFrame.setLocationRelativeTo(this);
                 * //opcional } else {
                 * relatorioEstoqueJFrame.setExtendedState(JFrame.NORMAL);
                 * relatorioEstoqueJFrame.toFront(); }
                 * relatorioEstoqueJFrame.setVisible(true);
                 */

                //From vendas               
                /**
                 * if (siteJFrame == null || !siteJFrame.isDisplayable()) {
                 * siteJFrame = new VendaDigimacroJFrame(managerIntegrador,
                 * managerPrestaShop, managerCplus, new
                 * UsuarioJpaController(managerCplus).findUsuario("001"));
                 * //siteJFrame.setLocationRelativeTo(this); //opcional } else {
                 * siteJFrame.setExtendedState(JFrame.NORMAL);
                 * siteJFrame.toFront(); } siteJFrame.setVisible(true);
                 */
                //From principal
                if (frameIntegracao == null || !frameIntegracao.isDisplayable()) {
                    frameIntegracao = new PrincipalJFrame();
                    //frameIntegracao.setLocationRelativeTo(this); //opcional 
                } else {
                    frameIntegracao.setExtendedState(JFrame.NORMAL);
                    frameIntegracao.toFront();
                }
                frameIntegracao.setVisible(true);

            }
        });

    }

}
