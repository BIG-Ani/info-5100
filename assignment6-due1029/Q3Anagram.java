package Assignment6;

public class Question3Anagram {

    public boolean isAnagram(String s, String t) {
        if (s == null && t == null)
            return true;

        if (s.length() == 0 && t.length() == 0)
            return true;

        if (s.length() != t.length())
            return false;
        else {
            int[] freq = new int[26];

            // get all freq from s
            for(int i = 0; i < s.length(); i++){
                freq[s.charAt(i) - 'a']++;
            }

            // remove freq by visiting t
            for (int i = 0; i < t.length(); i++) {
                freq[t.charAt(i) - 'a']--;
            }

            if (validAnagram(freq))
                return true;
            else
                return false;
        }
    }

    private boolean validAnagram(int[] freq) {
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0)
                return false;
        }

        return true;
    }

    // main test
    public static void main(String[] args) {
        Question3Anagram question3Anagram = new Question3Anagram();

        String s = "rat";
        String t = "car";

        if(question3Anagram.isAnagram(s, t))
            System.out.println("Yes, this pair is an anagram");
        else
            System.out.println("No, this pair is not an anagram");
    }

}
