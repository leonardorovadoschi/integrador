/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prestashop;

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

  
   
   
}
