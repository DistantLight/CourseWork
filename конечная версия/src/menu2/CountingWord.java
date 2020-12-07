package menu2;

import java.io.*;
import java.util.Scanner;

public class CountingWord {

    public int CounterWord(File file,String var) throws Exception {
        Scanner scan = new Scanner(file);
        int i = 0;
        String w,str = "";
        while (scan.hasNext()) {
            w = scan.next();
            w = w.replaceAll("[().,]","");
            if (w.equalsIgnoreCase(var)){
                i++;
            }
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


        System.out.println("Введите слово которое нужно посчитать");
        String str = sc.nextLine();

    }
}