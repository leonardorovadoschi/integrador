/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prestashop;

import entidade.cplus.Classificacaofiscal;
import java.math.BigInteger;
import javax.swing.JFrame;
import jpa.cplus.ClassificacaofiscalJpaController;

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
        
       
        

       // java.awt.EventQueue.invokeLater(() -> {
        //    if (frameIntegracao == null
       //             || !frameIntegracao.isDisplayable()) {
       //         frameIntegracao = new PrincipalJFrame(); //frameIntegracao.setLocationRelativeTo(this);
                //opcional } else { frameIntegracao.setExtendedState(JFrame.NORMAL);
       //         frameIntegracao.toFront();
       //     }
       //     frameIntegracao.setVisible(true);
       // });
            
            new Teste().testeQuery();
/**
        int quantidadeSerial = 10;
        int count = 0;
        String serialSequencia
                = "0556ddf6658gg451";
        int caracteres = serialSequencia.length();
        int serialCont = 0;
        serialCont
                = Integer.valueOf(serialSequencia.substring(caracteres - 3,
                        caracteres));
        String txt = "";
        while (Integer.valueOf(quantidadeSerial) > count) {
            //jTextFieldSerial.setText(String.valueOf(serialSequencia));
            //jTableSerialDigitado.clearSelection(); //Tira linha selecionada
            serialCont++;
            txt = serialSequencia.substring(0, caracteres - 3)
                    + serialCont;
            System.out.println(txt);
            count++;

        }
*/
    }

}
