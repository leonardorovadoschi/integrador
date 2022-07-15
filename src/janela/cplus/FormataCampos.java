/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package janela.cplus;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author LEO
 */
public class FormataCampos {

    /**
     * Função que converte data do BD para uma string, usada em pesquisas WebService
     * formato yyyy-MM-dd%20HH:mm:ss %20 substitui o espaço em branco
     * @param dataBancoDados
     * @param alterarDia
     * @return 
     */
    public String dataStringWebService(Date dataBancoDados, int alterarDia) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar fimExecucao = Calendar.getInstance();
        fimExecucao.setTime(dataBancoDados);
        fimExecucao.add(Calendar.DAY_OF_MONTH, alterarDia);
        String dataFormat = sdf.format(fimExecucao.getTime());
        return dataFormat;
    }
    /**
     * Função que transforma data do banco de dados em String formatada tambem
     * incrementa ou decrementa o dia
     *
     * @param dataBancoDados
     * @param alterarDia
     * @return data Formatada "dd/MM/yyyy"
     */
    public String dataStringSoData(Date dataBancoDados, int alterarDia) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar fimExecucao = Calendar.getInstance();
        fimExecucao.setTime(dataBancoDados);
        fimExecucao.add(Calendar.DAY_OF_MONTH, alterarDia);
        String dataFormat = sdf.format(fimExecucao.getTime());
        return dataFormat;
    }

    public Date primeiroDiaMes(int alteraMes) {
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(dataAtual());
        int mes = cal.get(Calendar.MONTH);
        cal.set(Calendar.MONTH, mes - alteraMes);
        int dia = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, dia);
        return cal.getTime();
    }

    public Date ultimoDiaMes(int alteraMes) {
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(dataAtual());
        int mes = cal.get(Calendar.MONTH);
        cal.set(Calendar.MONTH, mes - alteraMes);
        int dia = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, dia);
        return cal.getTime();
    }

    /**
     * Função que altera o numero de dias para reduzir utilize inteiros
     * negativos
     *
     * @param data
     * @param alterarDia
     * @return
     */
    public Date alteraDiaData(Date data, int alterarDia) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        calendar.add(Calendar.DAY_OF_MONTH, alterarDia);
        return calendar.getTime();
    }

    /**
     * Função que transforma dada no banco em String Formatada e Hora tambem
     * incrementa ou decrementa a hora
     *
     * @param dataBancoDados
     * @param alterarHota
     * @return
     */
    public String dataStringSoHora(Date dataBancoDados, int alterarHota) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Calendar fimExecucao = Calendar.getInstance();
        fimExecucao.setTime(dataBancoDados);
        fimExecucao.add(Calendar.HOUR, alterarHota);
        String dataFormat = sdf.format(fimExecucao.getTime());
        return dataFormat;
    }

    /**
     * Função que altera as HORAS e os MINUTOS para 23:58
     *
     * @param data
     * @return
     */
    public Date alteraHoraData(Date data) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        cal.set(Calendar.HOUR_OF_DAY, 22);
        cal.set(Calendar.MINUTE, 58);
        return cal.getTime();
    }

    /**
     * Função que transforma data do banco de dados em String formatada tambem
     * incrementa ou decrementa o dia
     *
     * @param dataBancoDados
     * @param alterarDia
     * @return data Formatada "dd/MM/yyyy HH:mm:ss"
     */
    public String dataStringDataCompleta(Date dataBancoDados, int alterarDia) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Calendar fimExecucao = Calendar.getInstance();
        fimExecucao.setTime(dataBancoDados);
        fimExecucao.add(Calendar.DAY_OF_MONTH, alterarDia);
        String dataFormat = sdf.format(fimExecucao.getTime());
        return dataFormat;
    }

    public Date dataAtual() {
        Date data = new Date(System.currentTimeMillis());
        return data;
    }

    /**
     * Função que retorna a data no formato "ddMMyyyy"
     *
     * @param dataString
     * @return
     */
    public Date dataBanco(String dataString) {
        Date data;
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
        try {
            data = sdf.parse(dataString.replace("/", ""));
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Alguns dos campos de datas\n Não São Válidos" + ex);
            data = dataAtual();
        }
        return data;
    }

    /**
     * Função que controla a entrada pelo usuario faz a inversão de virgura
     * acrecenta e decimais
     *
     * @param valorTextField
     * @param casasDecimais
     * @return
     */
    public BigDecimal stringParaDecimal(String valorTextField, Integer casasDecimais) {
        String textValue = valorTextField.trim();
        int virgula = valorTextField.split(",").length;
        int ponto = valorTextField.split(".").length;
        if (virgula > 1) {
            textValue = textValue.replace(".", "");
            textValue = textValue.replaceAll(",", ".");
        }
        if (virgula == 1 && ponto == 0) {
            double valor = new Double(textValue);
            textValue = String.valueOf(valor);
        }
        if (textValue.equals("")) {
            return BigDecimal.ZERO;
        } else {
            BigDecimal bdValue = BigDecimal.ZERO;
            try {
                bdValue = new BigDecimal(textValue);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Alguns dos campos de valores\n Não São Válidos" + ex);
            }
            bdValue = bdValue.setScale(casasDecimais, BigDecimal.ROUND_HALF_UP);
            return bdValue;
        }
    }

    public String bigDecimalParaString(BigDecimal numeroBigDecimal, int digitosDecimais) {
        String formato;
        switch (digitosDecimais) {
            case 2:
                formato = "##,###,###,##0.00";
                break;
            case 3:
                formato = "##,###,###,##0.000";
                break;
            case 4:
                formato = "##,###,###,##0.0000";
                break;
            default:
                formato = "##,###,###,##0.00";
        }
        DecimalFormat df = new DecimalFormat(formato, new DecimalFormatSymbols(new Locale("pt", "BR")));
        df.setMinimumFractionDigits(digitosDecimais);
        df.setParseBigDecimal(true);
        String valor;
        if (numeroBigDecimal == null) {
            valor = df.format(new BigDecimal(BigInteger.ZERO));
        } else {
            valor = df.format(numeroBigDecimal);
        }
        return valor;
    }

    /**
     * Função que compara duas Datas sendo que será comparado somente DIA
     * MES ANO sendo que se a PRIMEIRA DATA for MENOR ou IGUAL a SEGUNDA DATA
     * vai retornar FALSE caso contrario TRUE
     *
     * @param primeiraData
     * @param segundaData
     * @return booleano
     */
    public boolean comparaDuasDatas(Date primeiraData, Date segundaData) {
        boolean condicao;
        Calendar primeiraDataCal = Calendar.getInstance();
        primeiraDataCal.setTime(primeiraData);
        String diaPrimeiraData = String.format("%02d", primeiraDataCal.get(Calendar.DAY_OF_MONTH));
        String mesPrimeiraData = String.format("%02d", primeiraDataCal.get(Calendar.MONTH));
        String anoPrimeiraData = String.format("%04d", primeiraDataCal.get(Calendar.YEAR));
        Calendar segundaDataCal = Calendar.getInstance();
        int totalPrimeiraData = Integer.valueOf(anoPrimeiraData + mesPrimeiraData + diaPrimeiraData);

        segundaDataCal.setTime(segundaData);
        String diaSegundaData = String.format("%02d", segundaDataCal.get(Calendar.DAY_OF_MONTH));
        String mesSegundaData = String.format("%02d", segundaDataCal.get(Calendar.MONTH));
        String anoSegundaData = String.format("%04d", segundaDataCal.get(Calendar.YEAR));
        int totalSegundaData = Integer.valueOf(anoSegundaData + mesSegundaData + diaSegundaData);
        if (totalPrimeiraData <= totalSegundaData) {
            condicao = false;
        } else {
            condicao = true;
        }
        return condicao;
    }

    /**
     * retorna o ano atual com 2 digitos da direita para esquerda Ex.: xx18
     *
     * @return
     */
    public String anoAtualDoisDigitos() {
        Date data = dataAtual();
        SimpleDateFormat sdf = new SimpleDateFormat("yy");
        Calendar fimExecucao = Calendar.getInstance();
        fimExecucao.setTime(data);
        String dataFormat = sdf.format(fimExecucao.getTime());
        return dataFormat;
    }

    public String mascaraCNPJouCPF(String cNPJouCPF) {
        MaskFormatter mask = null;
        String txt = "";
        String doc = cNPJouCPF.replaceAll("[^0-9]", "");
        if (doc.length() == 14) {
            try {
                mask = new MaskFormatter("##.###.###/####-##");
                mask.setValueContainsLiteralCharacters(false);
                txt = mask.valueToString(doc);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "O CNPJ errado\n Não é Válido" + ex);
            }
        } else {
            try {
                mask = new MaskFormatter("###.###.###-##");
                mask.setValueContainsLiteralCharacters(false);
                txt = mask.valueToString(doc);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "O CPF errado\n Não é Válido" + ex);
            }
        }

        return txt;
    }

    public String mascaraCNPJ(String cNPJ) {
        MaskFormatter mask = null;
        String txt = "";
        try {
            mask = new MaskFormatter("##.###.###/####-##");
            mask.setValueContainsLiteralCharacters(false);
            txt = mask.valueToString(cNPJ);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "O CNPJ errado\n Não é Válido" + ex);
        }
        return txt;
    }

    public String mascaraNCM(String nCM) {
        MaskFormatter mask = null;
        String txt = "";
        try {
            mask = new MaskFormatter("####.##.##");
            mask.setValueContainsLiteralCharacters(false);
            txt = mask.valueToString(nCM);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "O NCM errado\n Não é Válido" + ex);
        }
        return txt;
    }

    public String mascaraCPF(String cCPF) {
        MaskFormatter mask = null;
        String txt = "";
        try {
            mask = new MaskFormatter("###.###.###-##");
            mask.setValueContainsLiteralCharacters(false);
            txt = mask.valueToString(cCPF);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "O CPF errado\n Não é Válido" + ex);
        }
        return txt;
    }

    public String stringParaStringMoeda(String valorTextField, int digitosDecimais) {
        return bigDecimalParaString(stringParaDecimal(valorTextField, digitosDecimais), digitosDecimais);
    }
    /**
     * Função que retorna Valores formatados em jText para xml WebService
     * @param jTextField
     * @return 
     */
    public String webServiceMoeda(String jTextField){
        String textValue = jTextField;
        textValue = textValue.replace(".", "");
        textValue = textValue.replaceAll(",", ".");
        return textValue;
    }
    
    public String webServiceMoeda(BigDecimal bigDecimal){
        String text;
        DecimalFormat df =  new DecimalFormat();
        df.setMaximumFractionDigits(6);
        df.setMaximumFractionDigits(4);
        text = String.valueOf(df.format(bigDecimal.doubleValue()));
        text = text.replace(".", "");
       text = text.replaceAll(",", ".");
        return text;
    }
}
