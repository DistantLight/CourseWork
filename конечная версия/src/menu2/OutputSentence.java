package menu2;

import java.io.*;
import java.util.Scanner;

public class OutputSentence {

    public String DisplaySentence(File file,int var) throws Exception {
        Scanner scan = new Scanner(file);
        int i = 0;
        String w,str = "";
        while (scan.hasNext()) {
            w = scan.next();
            if (w.endsWith(".")||w.endsWith("!")||w.endsWith("?")){
                i++;
            }
            if (i==var){
                while (!str.endsWith(".")&&!str.endsWith("!")&&!str.endsWith("?")) {                        //пока последний символ до пробела не точка
                    str = str + " " + scan.next();
                }
                break;
            }
        }
        scan.close();
        return str;
    }

}
