package menu2;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class WordReplacement {

    public void ChangeWords(File file,String str,String str2) throws Exception {
        ArrayList<String> arrayList = new ArrayList<>();

        Scanner scan = new Scanner(file);
        String w = "";
        while (scan.hasNext()) {
            w = scan.nextLine();
            w = w.replaceAll(str,str2);

            arrayList.add(w);
        }
        scan.close();

        PrintWriter pw = new PrintWriter(file);


        for (int i =0;i<arrayList.size();i++){
            pw.println(arrayList.get(i));
        }
        pw.close();
    }

}
