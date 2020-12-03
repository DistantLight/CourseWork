import java.io.*;
import java.util.Scanner;

public class Main {

    String OutputSentence(File file,int var) throws Exception {
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

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        File file = new File("temp.txt");
        if (!file.exists()) {
            file.createNewFile();
        }


        System.out.println("Введите номер предложения, которое надо вывести");
        int var = sc.nextInt();
        Main main = new Main();
        System.out.println(main.OutputSentence(file,var-1));
    }
}