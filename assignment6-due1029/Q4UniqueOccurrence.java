package Assignment6;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class UniqueOccurrence {

    public boolean uniqueOccurrences(int[] arr) {
        if (arr.length == 1)
            return true;

        Map<Integer, Integer> freq = new HashMap<>();
        int[] freqSort = new int[arr.length + 1];
        Arrays.fill(freqSort, 2000);

        for (int i = 0; i < arr.length; i++)
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);

//        for (int i = 0; i < arr.length; i++) {
//            int occurrenceTime = freq.get(arr[i]);
//
//            if(freqSort[occurrenceTime] != 2000)
//                return false;
//            else{
//                freqSort[occurrenceTime] = arr[i];
//            }
//        }

        for (int key : freq.keySet()){
            int occurrenceTime = freq.get(key);

            if(freqSort[occurrenceTime] != 2000)
                return false;
            else{
                freqSort[occurrenceTime] = key;
            }
        }

        return true;
    }

    // main test
    public static void main(String[] args) {
        UniqueOccurrence uniqueOccurrence = new UniqueOccurrence();

//        int[] arr = {1,2,2,1,1,3};
//        int[] arr = {1,2};
        int[] arr = {-3,0,1,-3,1,1,1,-3,10,0};
        if (uniqueOccurrence.uniqueOccurrences(arr))
            System.out.println("Yes, all occurrences are unique");
        else
            System.out.println("No, there are some elements which have the same occurrence");
    }

}
