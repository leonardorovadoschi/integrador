/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package integrador.relatorio;

import integrador.rma.EspelhoRmaJFrame;
import java.io.InputStream;
import java.util.Collection;
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
    
    public boolean imprimeRelatorio(String caminhoArquivo, List lista){
        boolean condicao = true;
        InputStream inputStream = EspelhoRmaJFrame.class.getResourceAsStream(caminhoArquivo);
        try {
            JasperReport report = JasperCompileManager.compileReport(inputStream);
            JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(lista));  
            JasperViewer.viewReport(print, false);
        } catch (JRException e) {
            condicao = false;
            JOptionPane.showMessageDialog(null, "HOUVE UM ERRO AO IMPRIMIR RELATÓRIO, Verifique!! \n" + e, "Erro Imprimir", JOptionPane.ERROR_MESSAGE);
        }
        return condicao;
    }
    
    public boolean imprimeRelatorioColection(String caminhoArquivo, Collection lista){
        boolean condicao = true;
        InputStream inputStream = EspelhoRmaJFrame.class.getResourceAsStream(caminhoArquivo);
        try {
            JasperReport report = JasperCompileManager.compileReport(inputStream);
            JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(lista));  
            JasperViewer.viewReport(print, false);
        } catch (JRException e) {
            condicao = false;
            JOptionPane.showMessageDialog(null, "HOUVE UM ERRO AO IMPRIMIR RELATÓRIO, Verifique!! \n" + e, "Erro Imprimir", JOptionPane.ERROR_MESSAGE);
        }
        return condicao;
    }
}
