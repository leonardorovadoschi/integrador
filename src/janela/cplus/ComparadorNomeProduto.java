/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package janela.cplus;

import entidade.cplus.Produto;
import java.util.Comparator;

/**
 *
 * @author leonardo
 */
public class ComparadorNomeProduto implements Comparator<Produto>{

    @Override
    public int compare(Produto o1, Produto o2) {
        return o1.getNomeprod().compareTo(o2.getNomeprod()); 
    }
  
    
}
