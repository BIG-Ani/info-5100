package Assignment7;

public class RangeSum {

    /*
    * sum up the arr with bound
    * */
    public long getSum(int[] arr, int start, int end){
        long sum = 0;

        for (int i = start; i <= end; i++) {
            sum += arr[i];
        }

        return sum;
    }
}
