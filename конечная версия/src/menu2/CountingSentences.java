package menu2;

import java.io.*;
import java.util.Scanner;

public class CountingSentences {

    public int CounterSentences(File file) throws Exception {
        Scanner scan = new Scanner(file);
        int i = 0;
        String w;
        while (scan.hasNext()) {
            w = scan.next();
            if (w.endsWith(".")||w.endsWith("!")||w.endsWith("?")){
                i++;
            }
        }
        scan.close();
        return i;
    }

    public static void main(String[] args) throws Exception {

        File file = new File("temp.txt");
        if (!file.exists()) {
            file.createNewFile();
        }


    }
}
