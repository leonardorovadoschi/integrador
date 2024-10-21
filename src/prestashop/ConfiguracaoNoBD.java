/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prestashop;

import entidade.cplus.Usuario;
import entidade.integrador.IntConfiguracao;
import jpa.integrador.IntConfiguracaoJpaController;

/**
 *
 * @author leo-note
 */
public class ConfiguracaoNoBD {

    private static String valorCasasDecimais;
    private static String tipoCasasDecimais;
    private static String valorAudioFinalizado;
    private static String valorAudioErro;
    private static String tipoAudioFinalizado;
    private static String tipoAudioErro;
    private static String valorRomaneioSeriais;
    private static String tipoRomaneioSeriais;
    private static String valorEspelhoRma;

    public static String getValorCasasDecimais() {
        return valorCasasDecimais;
    }

    public static void setValorCasasDecimais(String valorCasasDecimais) {
        ConfiguracaoNoBD.valorCasasDecimais = valorCasasDecimais;
    }

    public static String getValorAudioFinalizado() {
        return valorAudioFinalizado;
    }

    public static void setValorAudioFinalizado(String valorAudioFinalizado) {
        ConfiguracaoNoBD.valorAudioFinalizado = valorAudioFinalizado;
    }

    public static String getValorAudioErro() {
        return valorAudioErro;
    }

    public static void setValorAudioErro(String valorAudioErro) {
        ConfiguracaoNoBD.valorAudioErro = valorAudioErro;
    }

    public static String getValorRomaneioSeriais() {
        return valorRomaneioSeriais;
    }

    public static void setValorRomaneioSeriais(String valorRomaneioSeriais) {
        ConfiguracaoNoBD.valorRomaneioSeriais = valorRomaneioSeriais;
    }

    public static String getValorEspelhoRma() {
        return valorEspelhoRma;
    }

    public static void setValorEspelhoRma(String valorEspelhoRma) {
        ConfiguracaoNoBD.valorEspelhoRma = valorEspelhoRma;
    }

    public static String getValorEtiquetaSerial() {
        return valorEtiquetaSerial;
    }

    public static void setValorEtiquetaSerial(String valorEtiquetaSerial) {
        ConfiguracaoNoBD.valorEtiquetaSerial = valorEtiquetaSerial;
    }

    public static String getValorCaracteristicaCliente() {
        return valorCaracteristicaCliente;
    }

    public static void setValorCaracteristicaCliente(String valorCaracteristicaCliente) {
        ConfiguracaoNoBD.valorCaracteristicaCliente = valorCaracteristicaCliente;
    }

    public static String getValorCaracteristicaClienteRuim() {
        return valorCaracteristicaClienteRuim;
    }

    public static void setValorCaracteristicaClienteRuim(String valorCaracteristicaClienteRuim) {
        ConfiguracaoNoBD.valorCaracteristicaClienteRuim = valorCaracteristicaClienteRuim;
    }
    private static String tipoEspelhoRma;
    private static String valorEtiquetaSerial;
    private static String tipoEtiquetaSerial;
    private static Usuario usuario;
    private static String valorCaracteristicaCliente;
    private static String tipoCaracteristicaCliente;
    private static String valorCaracteristicaClienteRuim;
    private static String tipoCaracteristicaClienteRuim;

    public static String getTipoCaracteristicaCliente() {
        return tipoCaracteristicaCliente;
    }

    public static void setTipoCaracteristicaCliente(String tipoCaracteristicaCliente) {
        ConfiguracaoNoBD.tipoCaracteristicaCliente = tipoCaracteristicaCliente;
    }

    public static String getTipoCaracteristicaClienteRuim() {
        return tipoCaracteristicaClienteRuim;
    }

    public static void setTipoCaracteristicaClienteRuim(String tipoCaracteristicaClienteRuim) {
        ConfiguracaoNoBD.tipoCaracteristicaClienteRuim = tipoCaracteristicaClienteRuim;
    }

    public static Usuario getUsuario() {
        return usuario;
    }

    public static void setUsuario(Usuario usuario) {
        ConfiguracaoNoBD.usuario = usuario;
    }

    public static String getTipoCasasDecimais() {
        return tipoCasasDecimais;
    }

    public static void setTipoCasasDecimais(String tipoCasasDecimais) {
        ConfiguracaoNoBD.tipoCasasDecimais = tipoCasasDecimais;
    }

    public static String getTipoAudioFinalizado() {
        return tipoAudioFinalizado;
    }

    public static void setTipoAudioFinalizado(String tipoAudioFinalizado) {
        ConfiguracaoNoBD.tipoAudioFinalizado = tipoAudioFinalizado;
    }

    public static String getTipoAudioErro() {
        return tipoAudioErro;
    }

    public static void setTipoAudioErro(String tipoAudioErro) {
        ConfiguracaoNoBD.tipoAudioErro = tipoAudioErro;
    }

    public static String getTipoRomaneioSeriais() {
        return tipoRomaneioSeriais;
    }

    public static void setTipoRomaneioSeriais(String tipoRomaneioSeriais) {
        ConfiguracaoNoBD.tipoRomaneioSeriais = tipoRomaneioSeriais;
    }

    public static String getTipoEspelhoRma() {
        return tipoEspelhoRma;
    }

    public static void setTipoEspelhoRma(String tipoEspelhoRma) {
        ConfiguracaoNoBD.tipoEspelhoRma = tipoEspelhoRma;
    }

    public static String getTipoEtiquetaSerial() {
        return tipoEtiquetaSerial;
    }

    public static void setTipoEtiquetaSerial(String tipoEtiquetaSerial) {
        ConfiguracaoNoBD.tipoEtiquetaSerial = tipoEtiquetaSerial;
    }

    public void carregaConfiguracoes() {
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
                case "cliente_CARACTERISTICA_CPLUS_DIGIMACRO":
                    ConfiguracaoNoBD.setValorCaracteristicaCliente(c.getValor());
                    ConfiguracaoNoBD.setTipoCaracteristicaCliente(c.getTipo());
                    break;
                case "cliente_CARACTERISTICA_CPLUS_DIGIMACRO_RUIM":
                    ConfiguracaoNoBD.setValorCaracteristicaCliente(c.getValor());
                    ConfiguracaoNoBD.setTipoCaracteristicaCliente(c.getTipo());
                    break;
            }
        }
    }

}