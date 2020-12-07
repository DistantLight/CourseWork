package menu1;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class CreateCopyFile{

    public void CopyFile(File file1,File file2) throws Exception{
        Scanner scanner = new Scanner(file1);
        PrintWriter pw = new PrintWriter(file2);
        int i =0;
        String w;
        while (scanner.hasNext()){
            i++;
            w = scanner.nextLine();
            pw.println(w);
        }
        pw.close();
        scanner.close();
    }
}
