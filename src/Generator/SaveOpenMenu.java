/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Generator;

import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author evgeniy
 */
public class SaveOpenMenu {
    //FileNameExtensionFilter filter = new FileNameExtensionFilter("*.TXT");
    JFileChooser fileChoser = new JFileChooser();
    
    public void saveMenu(){
        //fileChoser.setFileFilter(filter);
        if ( fileChoser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION ) {
            try ( FileWriter fw = new FileWriter(fileChoser.getSelectedFile()) ) {
                fw.write("Blah blah blah...");
            }
            catch (IOException e) {
                System.out.println("Всё погибло!");
            }
        }
    }
    public void openMenu(){
        if ( fileChoser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION ) {
            try ( FileWriter fw = new FileWriter(fileChoser.getSelectedFile()) ) {
                fw.write("Blah blah blah...");
            }
            catch (IOException e) {
                System.out.println("Всё погибло!");
            }
        }
    }
    
}
