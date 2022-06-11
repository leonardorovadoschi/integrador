/*
 * www.zydor.pl
 *
 *
 *
 */
package integrador.webservice;

/**
 *
 * @author www.zydor.pl
 */

public class PrestaShopWebserviceException extends Exception {
    
    public PrestaShopWebserviceException(String massage){
        super(massage);
    }
    
    public PrestaShopWebserviceException(String massage,ClienteWebService ws) {
        super(massage + '\n'+ws.obterConteudoResposta());
    }
}