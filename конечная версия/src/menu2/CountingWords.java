package menu2;

import java.io.*;
import java.util.Scanner;

public class CountingWords {

    public int CounterWords(File file) throws Exception {
        Scanner scan = new Scanner(file);
        int i = 0;
        String w;
        while (scan.hasNext()) {
            w = scan.next();
            i++;
        }
        scan.close();
        return i;
    }

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        File file = new File("temp.txt");
        if (!file.exists()) {
            file.createNewFile();
        }


    }
}
