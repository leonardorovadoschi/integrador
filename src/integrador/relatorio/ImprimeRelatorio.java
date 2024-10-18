/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package integrador.relatorio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author leonardo
 */
public class ImprimeRelatorio {
    /**
     * Imprime relatorio pelo jar, 
     * para cada mudança tem que gerar um jar novo,
     * ex. do caminho /integrador/relatorio/etiquetaEntrada.jrxml
     * @param caminhoArquivo
     * @param lista
     * @return 
     */
    public boolean imprimeRelatorioPeloJar(String caminhoArquivo, List lista){
        boolean condicao = true;
         try {
        InputStream inputStream = new FileInputStream(caminhoArquivo);      
            JasperReport report = JasperCompileManager.compileReport(inputStream);
            JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(lista));  
            //JasperPrint print = JasperFillManager.fillReport(caminhoArquivo, null, new JRBeanCollectionDataSource(lista));  
            JasperViewer.viewReport(print, false);
        } catch (JRException e) {
            condicao = false;
            //Logger.getLogger(ImprimeRelatorio.class.getName()).log(Level.SEVERE, null, e);
           JOptionPane.showMessageDialog(null, "HOUVE UM ERRO AO IMPRIMIR RELATÓRIO, Verifique!! \n" + e, "Erro Imprimir", JOptionPane.ERROR_MESSAGE);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "HOUVE UM ERRO AO ABRIR ARQUIVO, Verifique!! \n" + ex, "Erro Imprimir", JOptionPane.ERROR_MESSAGE);
            //Logger.getLogger(ImprimeRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return condicao;
    }
    /**
     * NÃO FUNCIONA DIREITO
     * Imprime relatorio fora do jar, é preciso usar a extensão "jasper"
     * ex. do caminho C:\\lista_integrador\\relatorio\\etiquetaEntrada.jasper
     * @param caminhoArquivo
     * @param lista
     * @return 
     */
    private boolean imprimeRelatorioPeloArquivo(String caminhoArquivo, List lista){
        boolean condicao = true;
        //InputStream inputStream = EspelhoRmaJFrame.class.getResourceAsStream(caminhoArquivo);
        try {
           // JasperReport report = JasperCompileManager.compileReport(inputStream);
            //JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(lista));  
            JasperPrint print = JasperFillManager.fillReport(caminhoArquivo, null, new JRBeanCollectionDataSource(lista));  
            JasperViewer.viewReport(print, false);
        } catch (JRException e) {
            condicao = false;
            JOptionPane.showMessageDialog(null, "HOUVE UM ERRO AO IMPRIMIR RELATÓRIO, Verifique!! \n" + e, "Erro Imprimir", JOptionPane.ERROR_MESSAGE);
        }
        return condicao;
    }
       
}
