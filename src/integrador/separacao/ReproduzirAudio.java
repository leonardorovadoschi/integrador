/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package integrador.separacao;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
public class ReproduzirAudio {
  /**
   * Objeto para nosso arquivo ReproduzirAudio a ser tocado
   */
  private File mp3;
  /**
   * Objeto Player da biblioteca jLayer. Ele tocará o arquivo
 ReproduzirAudio
   */
  private Player player;
  /**
   * Construtor que recebe o objeto File referenciando o arquivo
   * MP3 a ser tocado e atribui ao atributo MP3 da classe.
   *
   * @param mp3
   */
  public ReproduzirAudio(File mp3) {
    this.mp3 = mp3;
  }
  /**
   * Método que toca o ReproduzirAudio
   */
  public void play() {
      try {
                FileInputStream fis     = new FileInputStream(mp3);
                BufferedInputStream bis = new BufferedInputStream(fis);
                this.player = new Player(bis);
               // System.out.println("Tocando!");
                this.player.play();
                //System.out.println("Terminado!");
            }
            catch (FileNotFoundException | JavaLayerException e) {
                JOptionPane.showMessageDialog(null, "houve um problema ao executar Audio !!! \n " + e);
            }
     }
}
