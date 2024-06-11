/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package produto;

import entidade.cplus.Pedidoitem;
import java.util.Comparator;

/**
 *
 * @author leonardo
 */
public class ComparadorNomeProdCompra implements Comparator<Pedidoitem>{

    @Override
    public int compare(Pedidoitem o1, Pedidoitem o2) {
        return o1.getCodprod().getNomeprod().compareTo(o2.getCodprod().getNomeprod()); 
    }   
}

