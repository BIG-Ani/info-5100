package Assignment7;

public class RangeSumValueThread implements Runnable {
    private RangeSum rangeSum;
    private static long rangeResult;

    private int[] arr;
    private int start;
    private int end;

    public RangeSumValueThread(RangeSum rangeSum, int[] arr, int start, int end) {
        this.rangeSum = rangeSum;
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        rangeResult = rangeSum.getSum(arr, start, end);
    }
}
