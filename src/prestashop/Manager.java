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

    public static EntityManagerFactory getManagerIntegrador() {
        return managerIntegrador;
    } 
    
}
