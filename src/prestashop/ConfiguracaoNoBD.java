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
   private static String caminhoCasasDecimais;
   private static String tipoCasasDecimais;
   private static String caminhoAudioFinalizado;
   private static String caminhoAudioErro;
   private static String tipoAudioFinalizado;
   private static String tipoAudioErro;
   private static String caminhoRomaneioSeriais;
   private static String tipoRomaneioSeriais;
   private static String caminhoEspelhoRma;
   private static String tipoEspelhoRma;
   private static String caminhoEtiquetaSerial;
   private static String tipoEtiquetaSerial;
   private static Usuario usuario;
   private static String caminhoCaracteristicaCliente;
   private static String tipoCaracteristicaCliente;
   private static String caminhoCaracteristicaClienteRuim;
   private static String tipoCaracteristicaClienteRuim;

    public static String getCaminhoCaracteristicaCliente() {
        return caminhoCaracteristicaCliente;
    }

    public static void setCaminhoCaracteristicaCliente(String caminhoCaracteristicaCliente) {
        ConfiguracaoNoBD.caminhoCaracteristicaCliente = caminhoCaracteristicaCliente;
    }

    public static String getTipoCaracteristicaCliente() {
        return tipoCaracteristicaCliente;
    }

    public static void setTipoCaracteristicaCliente(String tipoCaracteristicaCliente) {
        ConfiguracaoNoBD.tipoCaracteristicaCliente = tipoCaracteristicaCliente;
    }

    public static String getCaminhoCaracteristicaClienteRuim() {
        return caminhoCaracteristicaClienteRuim;
    }

    public static void setCaminhoCaracteristicaClienteRuim(String caminhoCaracteristicaClienteRuim) {
        ConfiguracaoNoBD.caminhoCaracteristicaClienteRuim = caminhoCaracteristicaClienteRuim;
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

    public static String getCaminhoCasasDecimais() {
        return caminhoCasasDecimais;
    }

    public static void setCaminhoCasasDecimais(String caminhoCasasDecimais) {
        ConfiguracaoNoBD.caminhoCasasDecimais = caminhoCasasDecimais;
    }

    /**
     * TIPO > caminho_ARQUIVO_AUDIO_FINALIZADO
     * DESCRI플O > String para o caminho do audio finalizado 
     * @return 
     */
    public static String getCaminhoAudioFinalizado() {
        return caminhoAudioFinalizado;
    }

    /**
     * TIPO > caminho_ARQUIVO_AUDIO_FINALIZADO
     * DESCRI플O > String para o caminho do audio finalizado
     * @param caminhoAudioFinalizado 
     */
    public static void setCaminhoAudioFinalizado(String caminhoAudioFinalizado) {
        ConfiguracaoNoBD.caminhoAudioFinalizado = caminhoAudioFinalizado;
    }
    
     /**
     * TIPO > caminho_ARQUIVO_AUDIO_ERRO
     * DESCRI플O > String para o caminho do audiocom erro
     * @return 
     */
    public static String getCaminhoAudioErro() {
        return caminhoAudioErro;
    }

    /**
     * TIPO > caminho_ARQUIVO_AUDIO_ERRO
     * DESCRI플O > String para o caminho do audiocom erro
     * @param caminhoAudioErro
     */
    public static void setCaminhoAudioErro(String caminhoAudioErro) {
        ConfiguracaoNoBD.caminhoAudioErro = caminhoAudioErro;
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

    public static String getCaminhoRomaneioSeriais() {
        return caminhoRomaneioSeriais;
    }

    public static void setCaminhoRomaneioSeriais(String caminhoRomaneioSeriais) {
        ConfiguracaoNoBD.caminhoRomaneioSeriais = caminhoRomaneioSeriais;
    }

    public static String getTipoRomaneioSeriais() {
        return tipoRomaneioSeriais;
    }

    public static void setTipoRomaneioSeriais(String tipoRomaneioSeriais) {
        ConfiguracaoNoBD.tipoRomaneioSeriais = tipoRomaneioSeriais;
    }

    public static String getCaminhoEspelhoRma() {
        return caminhoEspelhoRma;
    }

    public static void setCaminhoEspelhoRma(String caminhoEspelhoRma) {
        ConfiguracaoNoBD.caminhoEspelhoRma = caminhoEspelhoRma;
    }

    public static String getTipoEspelhoRma() {
        return tipoEspelhoRma;
    }

    public static void setTipoEspelhoRma(String tipoEspelhoRma) {
        ConfiguracaoNoBD.tipoEspelhoRma = tipoEspelhoRma;
    }

    public static String getCaminhoEtiquetaSerial() {
        return caminhoEtiquetaSerial;
    }

    public static void setCaminhoEtiquetaSerial(String caminhoEtiquetaSerial) {
        ConfiguracaoNoBD.caminhoEtiquetaSerial = caminhoEtiquetaSerial;
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
                    ConfiguracaoNoBD.setCaminhoAudioFinalizado(c.getValor());
                    ConfiguracaoNoBD.setTipoAudioFinalizado(c.getTipo());
                    break;
                case "caminho_ARQUIVO_AUDIO_ERRO":
                    ConfiguracaoNoBD.setCaminhoAudioErro(c.getValor());
                    ConfiguracaoNoBD.setTipoAudioErro(c.getTipo());
                    break;
                case "caminho_RELATORIO_ROMANEIO_SERIAIS":
                    ConfiguracaoNoBD.setCaminhoRomaneioSeriais(c.getValor());
                    ConfiguracaoNoBD.setTipoRomaneioSeriais(c.getTipo());
                    break;
                case "caminho_RELATORIO_ESPELHO_RMA":
                    ConfiguracaoNoBD.setCaminhoEspelhoRma(c.getValor());
                    ConfiguracaoNoBD.setTipoEspelhoRma(c.getTipo());
                    break;
                case "caminho_ENTRADA_SERIAL":
                    ConfiguracaoNoBD.setCaminhoEtiquetaSerial(c.getValor());
                    ConfiguracaoNoBD.setTipoEtiquetaSerial(c.getTipo());
                    break;
            }
        }
    }
   
   
}
