/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador.fornecedores;

import java.util.Comparator;

/**
 *
 * @author leo
 */
public class OrdenaNomeAll implements Comparator<ProdutoAll>{
    @Override
    public int compare(ProdutoAll o1, ProdutoAll o2) {
        return o1.getDESCRICAO().compareTo(o2.getDESCRICAO()); 
    }
}
