/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pedido;

import entidade.cplus.Contareceber;
//import integrador.boleto.sicredi.CobrancaBancariaJFrame;
import janela.cplus.FormatacaoDeCampos;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author leonardo
 */
public class CalculoBoletoSicredi {
    private String anoAtual;
    private String DVNossoNumero;
    private String DVLivre;
    private String DVGeral;
    private String DVPrimeiroCampo;
    private String DVSegundoCampo;
    private String DVTerceiroCampo;
    private String fatorDeVencimento;
    private String valorTitulo;
    //FormatacaoDeCampos formataCampo;
    //static EntityManagerFactory managerCplus ;
    private final String codigoDoBanco = "748";
    private final String uaPosto = "09";
    private final String cedente = "48170";
    private final String tipoCobranca = "1";
    private final String bite = "2";
    private final String carteira = "1";
    private final String agencia = "0179";
    private String nossoNumeroCplus;
    
    public String getNossoNumeroCompleto(){
        String nnc = anoAtual + "/" + bite + nossoNumeroCplus + "-" +DVNossoNumero;
        return nnc;
    }
    
    public String getCodigoDeBarras(){
        String linha = codigoDoBanco + "9" + DVGeral + fatorDeVencimento + valorTitulo + tipoCobranca +
                carteira + anoAtual + bite + nossoNumeroCplus + DVNossoNumero + agencia +
                uaPosto + cedente + "10" + DVLivre;
        return linha;
    }
    public String getLinhaDigitalizavel(){
        String linha = codigoDoBanco + "9" + tipoCobranca + 
                "."+ carteira + anoAtual + bite + DVPrimeiroCampo +
                " " + nossoNumeroCplus + "." + DVNossoNumero + agencia + DVSegundoCampo +
                " " + uaPosto + tresPrimeirosDigitosCedente() + "." + doisUltimosDigitosCedente() + "10" + DVLivre + DVTerceiroCampo +
                " " + DVGeral + " " + fatorDeVencimento + valorTitulo;
        return linha;               
    }
    
    private String doisUltimosDigitosCedente() {
        String digi = "";
        //String cedente = cedente;
        for (int i = 0; i < cedente.length(); i++) {
            switch (i) {
                case 3:
                    digi = String.valueOf(cedente.charAt(i));
                    break;
                case 4:
                    digi = digi + String.valueOf(cedente.charAt(i));
                    break;                
            }
        }
        return digi;
    }
    
    private String tresPrimeirosDigitosCedente() {
        String digi = "";
        //String cedente = cedente;
        for (int i = 0; i < cedente.length(); i++) {
            switch (i) {
                case 0:
                    digi = String.valueOf(cedente.charAt(i));
                    break;
                case 1:
                    digi = digi + String.valueOf(cedente.charAt(i));
                    break;
                case 2:
                    digi = digi + String.valueOf(cedente.charAt(i));
                    break;
            }
        }
        return digi;
    }
    /**
     * Função para calcular codigos do boleto deve ser usado por primeiro para carregar todos os calculos
     * 
     * @param contaReceber 
     */
    public void atualizandoCalculos(Contareceber contaReceber){
       // nossoNumeroCplus = contaReceber.getNossonumero().toString();
        String numeroCplus = contaReceber.getNossonumero().toString();
        String nNumero ="";
        for(int i = 0; i < numeroCplus.length(); i++){
            if(i > 0 && i < 6){
                nNumero = nNumero + String.valueOf(numeroCplus.charAt(i));
            }
        }
        nossoNumeroCplus = nNumero;
        anoAtual = new FormatacaoDeCampos().anoAtualDoisDigitos();
        DVNossoNumero = calculoDVNossoNumero();      
       // System.out.println("Digito Nosso Numero: " + DVNossoNumero);
        DVLivre = calculoDVLivre();
        // System.out.println("Digito Livre: " + DVLivre);
        fatorDeVencimento = fatorDeVencimento( contaReceber.getDatvenc());
        // System.out.println("Fator de Vencimento: " + fatorDeVencimento);
        valorTitulo = calculoValorTitulo(contaReceber);
        // System.out.println("Valor do Titulo: " + valorTitulo);
        DVGeral = calculoDVGeral();
        // System.out.println("Digito Geral: " + DVGeral);
        DVPrimeiroCampo = calculoDVPrimeiroCampo();
        //System.out.println("Digito Primeiro Campo " + DVPrimeiroCampo);
        DVSegundoCampo =  calculoDVSegundoCampo();
        //System.out.println("Digito Segundo Campo " + DVSegundoCampo);
        DVTerceiroCampo =  calculoDVTerceiroCampo();
        //System.out.println("Digito Terceiro Campo " + DVTerceiroCampo);
    }
    
    private String calculoDVTerceiroCampo() {
        String montagemBloco = uaPosto + cedente + "10" + DVLivre;
        int acumulador = 0;
        String segundoBloco;
        int primeiroResultado = 0;
        for (int i = 0; i < montagemBloco.length(); i++) {
            switch (i) {
                case 0:
                    acumulador = acumulador + Integer.parseInt(String.valueOf(montagemBloco.charAt(i)));
                    break;
                case 1:
                    primeiroResultado = 2 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i)));
                    segundoBloco = Integer.toString(primeiroResultado);
                    for (int a = 0; a < segundoBloco.length(); a++) {
                        acumulador = acumulador + Integer.parseInt(String.valueOf(segundoBloco.charAt(a)));
                    }
                    break;
                case 2:
                    acumulador = acumulador + Integer.parseInt(String.valueOf(montagemBloco.charAt(i)));
                    break;
                case 3:
                    primeiroResultado = 2 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i)));
                    segundoBloco = Integer.toString(primeiroResultado);
                    for (int a = 0; a < segundoBloco.length(); a++) {
                        acumulador = acumulador + Integer.parseInt(String.valueOf(segundoBloco.charAt(a)));
                    }
                    break;
                case 4:
                     acumulador = acumulador + Integer.parseInt(String.valueOf(montagemBloco.charAt(i)));
                    break;
                case 5:
                    primeiroResultado = 2 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i)));
                    segundoBloco = Integer.toString(primeiroResultado);
                    for (int a = 0; a < segundoBloco.length(); a++) {
                        acumulador = acumulador + Integer.parseInt(String.valueOf(segundoBloco.charAt(a)));
                    }
                    break;
                case 6:
                     acumulador = acumulador + Integer.parseInt(String.valueOf(montagemBloco.charAt(i)));
                    break;
                case 7:
                    primeiroResultado = 2 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i)));
                    segundoBloco = Integer.toString(primeiroResultado);
                    for (int a = 0; a < segundoBloco.length(); a++) {
                        acumulador = acumulador + Integer.parseInt(String.valueOf(segundoBloco.charAt(a)));
                    }
                    break;
                case 8:                   
                        acumulador = acumulador + Integer.parseInt(String.valueOf(montagemBloco.charAt(i)));                   
                    break;
                case 9:
                    primeiroResultado = 2 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i)));
                    segundoBloco = Integer.toString(primeiroResultado);
                    for (int a = 0; a < segundoBloco.length(); a++) {
                        acumulador = acumulador + Integer.parseInt(String.valueOf(segundoBloco.charAt(a)));
                    }
                    break;
            }
        }
        int resultadoFinal = 0;
        if(acumulador % 10 == 0){
            resultadoFinal = 0;
        }else{
            resultadoFinal = (acumulador / 10) + 1;
            resultadoFinal = resultadoFinal * 10;
            resultadoFinal =  resultadoFinal - acumulador;
        }
        return Integer.toString(resultadoFinal);
    }
    /**
     * Função que calcula o digito do segundo campo
     * Formato do calculo
     * NOSSO NUMEREO (sequencial) + DV NOSSO NUMERO + CODIGO CEDENTE
     * @param contaReceber conta receber c-plus
     * @return 
     */
    
    private String calculoDVSegundoCampo() {
        String montagemBloco = nossoNumeroCplus + DVNossoNumero + agencia;
        int acumulador = 0;
        String segundoBloco;
        int primeiroResultado = 0;
        for (int i = 0; i < montagemBloco.length(); i++) {
            switch (i) {
                case 0:
                    acumulador = acumulador + Integer.parseInt(String.valueOf(montagemBloco.charAt(i)));
                    break;
                case 1:
                    primeiroResultado = 2 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i)));
                    segundoBloco = Integer.toString(primeiroResultado);
                    for (int a = 0; a < segundoBloco.length(); a++) {
                        acumulador = acumulador + Integer.parseInt(String.valueOf(segundoBloco.charAt(a)));
                    }
                    break;
                case 2:
                    acumulador = acumulador + Integer.parseInt(String.valueOf(montagemBloco.charAt(i)));
                    break;
                case 3:
                    primeiroResultado = 2 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i)));
                    segundoBloco = Integer.toString(primeiroResultado);
                    for (int a = 0; a < segundoBloco.length(); a++) {
                        acumulador = acumulador + Integer.parseInt(String.valueOf(segundoBloco.charAt(a)));
                    }
                    break;
                case 4:
                     acumulador = acumulador + Integer.parseInt(String.valueOf(montagemBloco.charAt(i)));
                    break;
                case 5:
                    primeiroResultado = 2 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i)));
                    segundoBloco = Integer.toString(primeiroResultado);
                    for (int a = 0; a < segundoBloco.length(); a++) {
                        acumulador = acumulador + Integer.parseInt(String.valueOf(segundoBloco.charAt(a)));
                    }
                    break;
                case 6:
                     acumulador = acumulador + Integer.parseInt(String.valueOf(montagemBloco.charAt(i)));
                    break;
                case 7:
                    primeiroResultado = 2 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i)));
                    segundoBloco = Integer.toString(primeiroResultado);
                    for (int a = 0; a < segundoBloco.length(); a++) {
                        acumulador = acumulador + Integer.parseInt(String.valueOf(segundoBloco.charAt(a)));
                    }
                    break;
                case 8:                   
                        acumulador = acumulador + Integer.parseInt(String.valueOf(montagemBloco.charAt(i)));                   
                    break;
                case 9:
                    primeiroResultado = 2 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i)));
                    segundoBloco = Integer.toString(primeiroResultado);
                    for (int a = 0; a < segundoBloco.length(); a++) {
                        acumulador = acumulador + Integer.parseInt(String.valueOf(segundoBloco.charAt(a)));
                    }
                    break;
            }
        }
        int resultadoFinal = 0;
        if(acumulador % 10 == 0){
            resultadoFinal = 0;
        }else{
            resultadoFinal = (acumulador / 10) + 1;
            resultadoFinal = resultadoFinal * 10;
            resultadoFinal =  resultadoFinal - acumulador;
        }
        return Integer.toString(resultadoFinal);
    }
    
    /**
     * Função que calcula o digito do primeiro campo
     * Formato do calculo
     * CODIGO DO BANCO + FIXO(9) + TIPO COBRANÇA + CARTEIRA + ANO + BYTE
     * @return digito do primeiro campo
     */
    private String calculoDVPrimeiroCampo() {
        String montagemBloco = codigoDoBanco + "9" + tipoCobranca + carteira + anoAtual + bite;
        int acumulador = 0;
        String segundoBloco;
        int primeiroResultado = 0;
        for (int i = 0; i < montagemBloco.length(); i++) {
            switch (i) {
                case 0:
                    primeiroResultado = 2 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i)));
                    segundoBloco = Integer.toString(primeiroResultado);
                    for (int a = 0; a < segundoBloco.length(); a++) {
                        acumulador = acumulador + Integer.parseInt(String.valueOf(segundoBloco.charAt(a)));
                    }
                    break;
                case 1:
                    acumulador = acumulador + Integer.parseInt(String.valueOf(montagemBloco.charAt(i)));
                    break;
                case 2:
                    primeiroResultado = 2 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i)));
                    segundoBloco = Integer.toString(primeiroResultado);
                    for (int a = 0; a < segundoBloco.length(); a++) {
                        acumulador = acumulador + Integer.parseInt(String.valueOf(segundoBloco.charAt(a)));
                    }
                    break;
                case 3:
                     acumulador = acumulador + Integer.parseInt(String.valueOf(montagemBloco.charAt(i)));
                    break;
                case 4:
                    primeiroResultado = 2 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i)));
                    segundoBloco = Integer.toString(primeiroResultado);
                    for (int a = 0; a < segundoBloco.length(); a++) {
                        acumulador = acumulador + Integer.parseInt(String.valueOf(segundoBloco.charAt(a)));
                    }
                    break;
                case 5:
                     acumulador = acumulador + Integer.parseInt(String.valueOf(montagemBloco.charAt(i)));
                    break;
                case 6:
                    primeiroResultado = 2 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i)));
                    segundoBloco = Integer.toString(primeiroResultado);
                    for (int a = 0; a < segundoBloco.length(); a++) {
                        acumulador = acumulador + Integer.parseInt(String.valueOf(segundoBloco.charAt(a)));
                    }
                    break;
                case 7:                   
                        acumulador = acumulador + Integer.parseInt(String.valueOf(montagemBloco.charAt(i)));                   
                    break;
                case 8:
                    primeiroResultado = 2 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i)));
                    segundoBloco = Integer.toString(primeiroResultado);
                    for (int a = 0; a < segundoBloco.length(); a++) {
                        acumulador = acumulador + Integer.parseInt(String.valueOf(segundoBloco.charAt(a)));
                    }
                    break;
            }
        }
        int resultadoFinal = 0;
        if(acumulador % 10 == 0){
            resultadoFinal = 0;
        }else{
            resultadoFinal = (acumulador / 10) + 1;
            resultadoFinal = resultadoFinal * 10;
            resultadoFinal =  resultadoFinal - acumulador;
        }
        return Integer.toString(resultadoFinal);
    }
    
    /**
     * Função que retorna o digito verificador geral
     * Formato do calculo
     * CODIGO DO BANCO + FIXO(9) + FATOR DE VANCIMENTO + VALOR DO TITULO + TIPO DE COBRANÇA + TIPO DE CARTEIRA (sempre 1) + NOSSO NUMERO COMPLETO 
     * + AGENCIA + POSTO + CODIGO CEDENTE + CONDIÇÃO DE VALOR (1 com valor 0 sem valor) + fixo (0) + DIGITO VERIFICADOR DO CAMPO LIVRE
     * @param contaReceber conta receber c-plus
     * @param cb conta bancaria c-plus
     * @return Digito Verificador Geral
     */
    private String calculoDVGeral(){
        String montagemBloco = codigoDoBanco + "9" + fatorDeVencimento + valorTitulo + tipoCobranca + "1" + anoAtual + bite
                + nossoNumeroCplus + DVNossoNumero + agencia + uaPosto + cedente + "10" + DVLivre;                
        int acumulador = 0;
        for(int i = 0; i < montagemBloco.length(); i++){
            switch (i){
                case 0:
                    acumulador = acumulador + (4 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 1:
                    acumulador = acumulador + (3 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 2:
                    acumulador = acumulador + (2 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 3:
                    acumulador = acumulador + (9 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 4:
                    acumulador = acumulador + (8 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 5:
                    acumulador = acumulador + (7 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 6:
                    acumulador = acumulador + (6 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 7:
                    acumulador = acumulador + (5 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 8:
                    acumulador = acumulador + (4 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 9:
                    acumulador = acumulador + (3 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 10:
                    acumulador = acumulador + (2 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 11:
                    acumulador = acumulador + (9 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 12:
                    acumulador = acumulador + (8 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 13:
                    acumulador = acumulador + (7 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 14:
                    acumulador = acumulador + (6 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 15:
                    acumulador = acumulador + (5 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 16:
                    acumulador = acumulador + (4 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 17:
                    acumulador = acumulador + (3 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 18:
                    acumulador = acumulador + (2 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 19:
                    acumulador = acumulador + (9 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 20:
                    acumulador = acumulador + (8 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 21:
                    acumulador = acumulador + (7 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 22:
                    acumulador = acumulador + (6 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 23:
                    acumulador = acumulador + (5 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 24:
                    acumulador = acumulador + (4 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 25:
                    acumulador = acumulador + (3 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 26:
                    acumulador = acumulador + (2 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 27:
                    acumulador = acumulador + (9 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 28:
                    acumulador = acumulador + (8 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 29:
                    acumulador = acumulador + (7 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 30:
                    acumulador = acumulador + (6 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 31:
                    acumulador = acumulador + (5 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 32:
                    acumulador = acumulador + (4 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 33:
                    acumulador = acumulador + (3 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 34:
                    acumulador = acumulador + (2 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 35:
                    acumulador = acumulador + (9 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 36:
                    acumulador = acumulador + (8 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 37:
                    acumulador = acumulador + (7 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 38:
                    acumulador = acumulador + (6 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 39:
                    acumulador = acumulador + (5 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 40:
                    acumulador = acumulador + (4 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 41:
                    acumulador = acumulador + (3 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 42:
                    acumulador = acumulador + (2 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;                       
            }
            }
        int multipicacoes = acumulador;
            acumulador = acumulador / 11;
            //System.out.println("Acumulador Dividido: "+ acumulador);
            acumulador = acumulador * 11;
            //System.out.println("Acumulador Multiplicado: "+ acumulador);
            multipicacoes = multipicacoes - acumulador;
            if(multipicacoes < 3){
                multipicacoes = 1;
                //System.out.println("If Multiplicação: "+ acumulador);
            } else {
                multipicacoes = 11 - multipicacoes;
            }
            //System.out.println("DV: "+ Integer.toString(multipicacoes));
        return Integer.toString(multipicacoes);
    }
    
    /**
     * Função que retiva a virgula do valor 
     * @param contaReceber
     * @return 
     */
    private String calculoValorTitulo (Contareceber contaReceber){
        String formato;
        formato = "########0.00";  
        DecimalFormat df = new DecimalFormat(formato);
        df.setMinimumFractionDigits(2);
        df.setParseBigDecimal(true);
        String valor;       
        valor = df.format(contaReceber.getValor()).replaceAll(",", "");  
        while (valor.length() < 10) {
           valor = "0" + valor;            
        }
        return valor ;
    }
    
    /**
     * Função para calcular o numero de dias É o resultado da subtração entre a
     * data do vencimento do título e a data base, fixada em 07.10.1997
     * (03.07.2000 retrocedidos 1000 dias do início do processo). Trata-se de um
     * referencial numérico de 4 dígitos, situado nas quatro primeiras posições
     * do campo ?valor?, que representa a quantidade de dias decorridos da data
     * base à data de vencimento do título. Os boletos de cobrança devem conter
     * essas características, para que, quando capturados pela rede bancária, os
     * sistemas façam a operação inversa. Ou seja, somar à data base com o fator
     * de vencimento capturado, obtendo, dessa forma, a data do vencimento do
     * boleto. Para obter o fator de vencimento podem ser utilizadas duas
     * fórmulas: 1 - Data base de 07.10.1997, calculando o número de dias entre
     * essa data e a do vencimento (data de vencimento menos data base = fator)
     * Vencimento 20.12.2007 Data base - 07.10.1997 Fator de vencimento 3726
     *
     * @param vencimento
     * @return numero de dias em 4 digitos
     */
    private String fatorDeVencimento(Date vencimento) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String numeroDias = "1000";
        Date d1;
        try {
            d1 = df.parse("07/10/1997");
            Long dt = (vencimento.getTime() - d1.getTime()) + 3600000;
            dt = dt / 86400000L;
            if (dt > 9999) {
                dt = dt - 9000;
            }
            numeroDias = dt.toString();
        } catch (ParseException ex) {
           // Logger.getLogger(CobrancaBancariaJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numeroDias;
    }
    
    /**
     * Função responsável para calcular o Digito Verificador Livre
     * Formação do calculo 
     * TIPO COBRANÇA (1 com reg 3 sem reg) + TIPO CARTEIRA (1) + NOSSO NUMERO (9 digitos)
     * + COOPERATIVA (0179) + POSTO (09) + BENEFICIARIO (48170) + COM VALOR (1 com 0 sem)+ FIXO (0)
     * @param cb Contabancaria do C-Plus
     * @param sequenciaNossoNumero é o Nosso Número sem o ano, byte e DV 
     * @return 
     */
    private String calculoDVLivre(){
        String montagemBloco = tipoCobranca + carteira + anoAtual + bite + nossoNumeroCplus + DVNossoNumero + 
                agencia + uaPosto + cedente + "10"; // "10" é 1=com valor 0=sem valor, 0 valor fixo
        int acumulador = 0;
        for(int i = 0; i < montagemBloco.length(); i++){
            switch (i){
                case 0:
                    acumulador = acumulador + (9 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 1:
                    acumulador = acumulador + (8 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 2:
                    acumulador = acumulador + (7 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 3:
                    acumulador = acumulador + (6 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 4:
                    acumulador = acumulador + (5 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 5:
                    acumulador = acumulador + (4 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 6:
                    acumulador = acumulador + (3 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 7:
                    acumulador = acumulador + (2 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 8:
                    acumulador = acumulador + (9 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 9:
                    acumulador = acumulador + (8 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 10:
                    acumulador = acumulador + (7 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 11:
                    acumulador = acumulador + (6 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 12:
                    acumulador = acumulador + (5 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 13:
                    acumulador = acumulador + (4 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 14:
                    acumulador = acumulador + (3 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 15:
                    acumulador = acumulador + (2 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 16:
                    acumulador = acumulador + (9 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 17:
                    acumulador = acumulador + (8 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 18:
                    acumulador = acumulador + (7 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 19:
                    acumulador = acumulador + (6 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 20:
                    acumulador = acumulador + (5 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 21:
                    acumulador = acumulador + (4 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 22:
                    acumulador = acumulador + (3 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 23:
                    acumulador = acumulador + (2 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
            }
        }
        int multipicacoes = acumulador;
            acumulador = acumulador / 11;
            //System.out.println("Acumulador Dividido: "+ acumulador);
            acumulador = acumulador * 11;
            //System.out.println("Acumulador Multiplicado: "+ acumulador);
            multipicacoes = multipicacoes - acumulador;
            if(multipicacoes == 0 || multipicacoes == 1){
                multipicacoes = 0;
                //System.out.println("If Multiplicação: "+ acumulador);
            }else{
            multipicacoes = 11 - multipicacoes;
            }
            //System.out.println("DV: "+ Integer.toString(multipicacoes));
        return Integer.toString(multipicacoes);
    }
    
    /**
     * Função que calcula o Nosso Numero
     * Formação do calculo
     * AGENCIA (0179) + POSTO (09) + CEDENTE (48170) + ANO (2 digitos) + BYTE (DE 2 A 9) + SEQUENCIAL (5 digitos)
     * @param cb Contabancaria do C-Plus
     * @param sequenciaNossoNumero é o Nosso Número sem o ano, byte e DV 
     * @return 
     */
    private String calculoDVNossoNumero(){       
        String montagemBloco;
        montagemBloco = agencia + uaPosto + cedente + anoAtual + bite + nossoNumeroCplus ;
        int acumulador = 0;
        anoAtual = new FormatacaoDeCampos().anoAtualDoisDigitos();
        for (int i = 0; i < montagemBloco.length(); i++) {
            switch (i) {
                case 0:
                    acumulador = acumulador + (4 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 1:
                    acumulador = acumulador + (3 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 2:
                    acumulador = acumulador + (2 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 3:
                    acumulador = acumulador + (9 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 4:
                    acumulador = acumulador + (8 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 5:
                    acumulador = acumulador + (7 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 6:
                    acumulador = acumulador + (6 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 7:
                    acumulador = acumulador + (5 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 8:
                    acumulador = acumulador + (4 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 9:
                    acumulador = acumulador + (3 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 10:
                    acumulador = acumulador + (2 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 11:
                    acumulador = acumulador + (9 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 12:
                    acumulador = acumulador + (8 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 13:
                    acumulador = acumulador + (7 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 14:
                    acumulador = acumulador + (6 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 15:
                    acumulador = acumulador + (5 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 16:
                    acumulador = acumulador + (4 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 17:
                    acumulador = acumulador + (3 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
                case 18: //
                    acumulador = acumulador + (2 * Integer.parseInt(String.valueOf(montagemBloco.charAt(i))));
                    break;
            }                                  
        }
        int multipicacoes = acumulador;
            acumulador = acumulador / 11;
            //System.out.println("Acumulador Dividido: "+ acumulador);
            acumulador = acumulador * 11;
            //System.out.println("Acumulador Multiplicado: "+ acumulador);
            multipicacoes = multipicacoes - acumulador;
            multipicacoes = 11 - multipicacoes;
            if(multipicacoes > 9){
                multipicacoes = 0;
                //System.out.println("If Multiplicação: "+ acumulador);
            }
        return Integer.toString(multipicacoes);
    }
  
    
}
