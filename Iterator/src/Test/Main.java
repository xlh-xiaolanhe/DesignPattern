package Test;

import java.io.IOException;

/**
 *@author: xiaolanhe
 *@createDate: 2023/3/30 15:50
 */
public class Main {
    public static void main(String[] args) {
        FileIO f=new FileProperties();
        try {
            f.readFromFile("D:\\Code File\\file.txt");
            f.setValue("year", "2004");
            f.setValue("month", "4");
            f.setValue("day", "21");
            f.writeToFile("D:\\Code File\\newFile.txt");
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
