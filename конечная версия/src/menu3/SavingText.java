package menu3;

import javax.swing.*;
import java.io.File;
import java.io.PrintWriter;

public class SavingText {

    private File file;

    public SavingText(File file){
        this.file = file;
    }

    public void SaveFile(JTextArea jTextArea) throws Exception{
        file.createNewFile();
        PrintWriter pw = new PrintWriter(file);
        pw.print(jTextArea.getText());
        pw.close();
    }
}
