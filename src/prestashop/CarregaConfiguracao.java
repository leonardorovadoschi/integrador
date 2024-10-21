/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prestashop;

import entidade.cplus.Caracteristica;
import entidade.integrador.IntConfiguracao;
import jpa.cplus.CaracteristicaJpaController;
import jpa.integrador.IntConfiguracaoJpaController;

/**
 *
 * @author leonardo
 */
public class CarregaConfiguracao {

    public void carregar() {
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
                    ConfiguracaoNoBD.setValorCaracteristicaClienteRuim(c.getValor());
                    ConfiguracaoNoBD.setTipoCaracteristicaClienteRuim(c.getTipo());
                    break;
            }
        }
    }
}
