package menu2;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class LineNumbering {

    public void NumberOfString(File file) throws Exception {
        ArrayList<String> arrayList = new ArrayList<>();

        Scanner scan = new Scanner(file);
        String w = "";
        int i=0;
        while (scan.hasNext()) {
            i++;
            w = i + ")" + scan.nextLine();

            arrayList.add(w);
        }
        scan.close();

        PrintWriter pw = new PrintWriter(file);


        for ( i =0;i<arrayList.size();i++){
            pw.println(arrayList.get(i));
        }
        pw.close();
    }

}
