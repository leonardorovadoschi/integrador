/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prestashop;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author leo-note
 */
public class Manager {

    private static final EntityManagerFactory managerIntegrador = Persistence.createEntityManagerFactory("integradorPU");

    /**
     * Retorna conexão com Integrador
     * @return 
     */
    public static EntityManagerFactory getManagerIntegrador() {
        return managerIntegrador;
    }
    
    private static final EntityManagerFactory managerPrestaShop = Persistence.createEntityManagerFactory("PrestaShopPU");

    /**
     * Retorna conexão com PrestaShop
     * @return 
     */
    public static EntityManagerFactory getManagerPrestaShop() {
        return managerPrestaShop;
    }

    private static final EntityManagerFactory managerCplus = Persistence.createEntityManagerFactory("cplusPU");

    /**
     * Retorna conexão com C-Plus
     * @return 
     */
    public static EntityManagerFactory getManagerCplus() {
        return managerCplus;
    }

}
