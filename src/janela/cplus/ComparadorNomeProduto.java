/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package janela.cplus;

import entidade.cplus.Produtoestoque;
import java.util.Comparator;

/**
 *
 * @author leonardo
 */
public class ComparadorNomeProduto implements Comparator<Produtoestoque>{

    @Override
    public int compare(Produtoestoque o1, Produtoestoque o2) {
        return o1.getProduto().getNomeprod().compareTo(o2.getProduto().getNomeprod()); 
    }
  
    
}
