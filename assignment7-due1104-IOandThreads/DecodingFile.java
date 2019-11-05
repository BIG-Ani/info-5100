package Assignment7;

import java.util.Stack;

public class DecodingFile {

    private StreamImp streamIO = new StreamImp();

    public String decoding(String s){
        Stack<String> stack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();

        String res = "";
        int i = 0;
        while (i < s.length()){
            if (Character.isDigit(s.charAt(i))){
                int count = 0;

                while (i < s.length() && Character.isDigit(s.charAt(i))){
                    count = 10 * count + s.charAt(i) - '0';
                    i++;
                }

                numStack.push(count);
            } else if (s.charAt(i) == '['){
                stack.push(res);
                res = "";

                i++;
            } else if (s.charAt(i) == ']'){
                StringBuilder sb = new StringBuilder(stack.pop());

                int repeatTime = numStack.pop();
                for (int j = 0; j < repeatTime; j++) {
                    sb.append(res);
                }

                res = sb.toString();
                i++;
            } else {
                res += s.charAt(i++);
            }
        }

        return res;
    }

    //@Test
    public static void main(String[] args) {
        DecodingFile decodingFile = new DecodingFile();
        decodingFile.streamIO.setInPath("/Users/leichenzhou/Documents/Fall2019 Semester/info-5100/info-5100-assignments/assignment7-due1104/EncodedFile.txt");
        decodingFile.streamIO.setOutPath("/Users/leichenzhou/Documents/Fall2019 Semester/info-5100/info-5100-assignments/assignment7-due1104/DecodedFile.txt");

        String encodedContent = decodingFile.streamIO.reading();
        System.out.println("Encoded file is");
        System.out.println(encodedContent);

        String decodedContent = decodingFile.decoding(encodedContent);
        decodingFile.streamIO.writing(decodedContent);
        decodingFile.streamIO.setInPath("/Users/leichenzhou/Documents/Fall2019 Semester/info-5100/info-5100-assignments/assignment7-due1104/DecodedFile.txt");
        System.out.println("decoded content in the decoded file is : " + decodingFile.streamIO.reading());
    }
}
