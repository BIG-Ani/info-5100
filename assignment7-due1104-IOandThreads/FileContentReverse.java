package Assignment7;

import java.io.*;
import java.util.Scanner;

public class FileContentReverse {

    private StreamImp streamImp = new StreamImp();

    /*
    * Reverse string content
    * */
    public String reverseString(String s){
        String[] words = s.split("\\s+");
        String res = "";
        for (int i = words.length - 1; i >= 0; i--){
            res += words[i] + " ";
        }

        return res.trim();
    }

    // === main test
    public static void main(String[] args) {
        FileContentReverse fin = new FileContentReverse();

        System.out.println("==================");
        fin.streamImp.setInPath("/Users/leichenzhou/Documents/Fall2019 Semester/info-5100/info-5100-assignments/assignment7-due1104/InputFile.txt");
        String contentInFile = fin.streamImp.reading();
        System.out.println(contentInFile);

        fin.streamImp.setOutPath("/Users/leichenzhou/Documents/Fall2019 Semester/info-5100/info-5100-assignments/assignment7-due1104/OutputFile.txt");
        System.out.println(fin.reverseString(contentInFile));
        fin.streamImp.writing(fin.reverseString(contentInFile));

        fin.streamImp.setInPath("/Users/leichenzhou/Documents/Fall2019 Semester/info-5100/info-5100-assignments/assignment7-due1104/OutputFile.txt");
        contentInFile = fin.streamImp.reading();
        System.out.println(contentInFile);
    }

}
