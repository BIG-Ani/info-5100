package Assignment7;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class LineCounter {

    private StreamImp streamImp = new StreamImp();
    private Map<String, Integer> lineCntMap = new HashMap<>();
    /*
    * inPath: path of file
    * return: fileName - lineNumber
    * */
    public void getLineNumber(String inPath){
        int count = 0;
        try {
            String fileName = getFileName(inPath);

            FileReader fr = new FileReader(inPath);
            BufferedReader fbr = new BufferedReader(fr);

            while (fbr.readLine() != null){
                count++;
            }

            lineCntMap.put(fileName, count);
        } catch (IllegalArgumentException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getFileName(String inPath) throws IllegalArgumentException{
        if (inPath == null || inPath.length() == 0)
            throw new IllegalArgumentException("No file founded");

        String[] paths = inPath.split("/");
        String fileName = paths[paths.length - 1];

        if (!fileName.contains(".txt"))
            throw new IllegalArgumentException("No file founded");

        return fileName;
    }

    /*
    * write line data to file
    * */
    public void writeLineNumberToFile(){
        String lineStat = "";
        streamImp.setOutPath("/Users/leichenzhou/Documents/Fall2019Semester/info-5100/info-5100-assignments/assignment7-due1104/LineCheck.txt");
        for (Map.Entry<String, Integer> entry : lineCntMap.entrySet()){
            lineStat = entry.getKey() + " - " + entry.getValue();

            streamImp.writing(lineStat);
        }
    }

    //@Test
    public static void main(String[] args) {
        String files = "java /Users/leichenzhou/Documents/Fall2019Semester/info-5100/info-5100-assignments/assignment7-due1104/EncodedFile.txt" +
                " /Users/leichenzhou/Documents/Fall2019Semester/info-5100/info-5100-assignments/assignment7-due1104/DecodedFile.txt" +
                " /Users/leichenzhou/Documents/Fall2019Semester/info-5100/info-5100-assignments/assignment7-due1104/InputFile.txt" +
                " /Users/leichenzhou/Documents/Fall2019Semester/info-5100/info-5100-assignments/assignment7-due1104/OutputFile.txt";

        String[] fileList = files.split(" ");

        LineCounter lineCounter = new LineCounter();
        for (int i = 1; i < fileList.length; i++) {
            lineCounter.getLineNumber(fileList[i]);
        }
        for (Map.Entry<String, Integer> entry : lineCounter.lineCntMap.entrySet()){
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        lineCounter.writeLineNumberToFile();
    }
}
