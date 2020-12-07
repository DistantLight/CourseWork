package menu1;

import java.io.File;

public class CreatingFile{

    private File file;

    CreatingFile(File file){
        this.file = file;
    }



     public void CreateFile () throws Exception{     //ф-ия создания файла
        this.file.createNewFile();
    }

}
