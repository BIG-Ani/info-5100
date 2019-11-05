package Assignment7;

import java.util.concurrent.Callable;

public class RangeSumValueCallable implements Callable<Long> {
    private RangeSum rangeSum;

    private int[] arr;
    private int start;
    private int end;

    public RangeSumValueCallable(RangeSum rangeSum, int[] arr, int start, int end) {
        this.rangeSum = rangeSum;
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    public Long call() throws Exception {
        Long result = rangeSum.getSum(arr, start, end);
        return result;
    }
}
