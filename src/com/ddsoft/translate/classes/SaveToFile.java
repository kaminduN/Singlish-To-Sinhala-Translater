
package com.ddsoft.translate.classes;

import java.io.*;


import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author kam
 */
public class SaveToFile {

    public static void saveFile(String content) {
        JFileChooser saveFile = new JFileChooser();


        saveFile.addChoosableFileFilter(new FileNameExtensionFilter("Text File (*.txt)", "txt"));

        int opt = saveFile.showSaveDialog(null);

        if (opt == JFileChooser.APPROVE_OPTION) {
            try {
                File file = new File(saveFile.getSelectedFile() + ".txt");
                file.createNewFile();

                // FileWriter fout=new FileWriter(file);


                PrintWriter pwout = new PrintWriter(file);
                pwout.print(content);
                pwout.flush();

                pwout.close();
                JOptionPane.showMessageDialog(null, "Text savinf to file complete", "Saved", 1);
            } catch (IOException ex) {
                System.out.println("errer writing to file " + ex);
                JOptionPane.showMessageDialog(null, "Eror Writing to file", "Error0", 0);
            }
        }

    }

   
}
