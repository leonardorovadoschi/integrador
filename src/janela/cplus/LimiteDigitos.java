/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package janela.cplus;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *classe recebe o numero de digitos maximo a ser colocado pelo usuario
 * serve para Jtextfield
 * @author leonardo
 */
public class LimiteDigitos extends PlainDocument{
    private int quantidadeMax;
    public LimiteDigitos(int maxLen){
        super();
        if(maxLen <=0)
            throw new IllegalArgumentException("Especifique a quantidade!");
        quantidadeMax = maxLen;
    }
    @Override
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException{
        if(str == null || getLength() == quantidadeMax)
            return;
        int totalQuantia = (getLength() + str.length());
        if(totalQuantia <= quantidadeMax){
            super.insertString(offset, str, attr);
            return;
        }
        String nova = str.substring(0, getLength() - quantidadeMax);
        super.insertString(offset, nova, attr);
    }
}
