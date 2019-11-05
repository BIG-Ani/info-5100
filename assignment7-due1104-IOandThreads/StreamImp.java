package Assignment7;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StreamImp implements StreamIntf {
    private String inPath = "";
    private String outPath = "";
    private List<String> list = new ArrayList<>();

    public String getInPath() {
        return inPath;
    }

    public void setInPath(String inPath) {
        this.inPath = inPath;
    }

    public String getOutPath() {
        return outPath;
    }

    public void setOutPath(String outPath) {
        this.outPath = outPath;
    }

    @Override
    public String reading() {
        String fileContent = "";

        try {
            File file = new File(this.getInPath());

            InputStream in = new FileInputStream(file);
            while (true){
                int x = in.read();

                if (x == -1)
                    break;

                fileContent += (char)x;
            }

            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileContent;
    }

    @Override
    public void writing(String s) {
        String outFilePath = this.getOutPath();

        try {
            File file = new File(outFilePath);
            FileOutputStream fileOutputStream = new FileOutputStream(file, true);
            PrintStream fout = new PrintStream(fileOutputStream);
            fout.println(s);

            fout.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // @Test
    public static void main(String[] args) {
        StreamImp streamImp = new StreamImp();
        streamImp.setInPath("/Users/leichenzhou/Documents/Fall2019 Semester/info-5100/info-5100-assignments/assignment7-due1104/EncodedFile.txt");
        streamImp.setOutPath("/Users/leichenzhou/Documents/Fall2019 Semester/info-5100/info-5100-assignments/assignment7-due1104/DecodedFile.txt");

        System.out.println(streamImp.reading());
        streamImp.writing(streamImp.reading());
        streamImp.setOutPath("/Users/leichenzhou/Documents/Fall2019 Semester/info-5100/info-5100-assignments/assignment7-due1104/DecodedFile.txt");
        System.out.println(streamImp.reading());
    }
}
