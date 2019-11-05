package Assignment7;

import org.w3c.dom.ranges.Range;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class SumValue {

    private static RangeSum rangeSum = new RangeSum();

    /*generate array of random numbers*/
    static void generateRandomArray(int[] arr){
        Random r = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(9);
        }
    }

    /*get sum of an array using 4 threads*/
    static long sum(int[] arr){
        int fourDivide = arr.length / 4;

//        new Thread(new RangeSumValueThread(rangeSum, arr, 0, fourDivide - 1)).start();
//        new Thread(new RangeSumValueThread(rangeSum, arr, fourDivide, 2 * fourDivide - 1)).start();
//        new Thread(new RangeSumValueThread(rangeSum, arr, 2 * fourDivide, 3 * fourDivide - 1)).start();
//        new Thread(new RangeSumValueThread(rangeSum, arr, 3 * fourDivide, 4 * fourDivide - 1)).start();

        long sum = 0;
        Callable<Long> c1 = new RangeSumValueCallable(rangeSum, arr, 0, fourDivide - 1);
        Callable<Long> c2 = new RangeSumValueCallable(rangeSum, arr, fourDivide, 2 * fourDivide - 1);
        Callable<Long> c3 = new RangeSumValueCallable(rangeSum, arr, 2 * fourDivide, 3 * fourDivide - 1);
        Callable<Long> c4 = new RangeSumValueCallable(rangeSum, arr, 3 * fourDivide, 4 * fourDivide - 1);

        FutureTask<Long> ft1 = new FutureTask<Long>(c1);
        FutureTask<Long> ft2 = new FutureTask<Long>(c2);
        FutureTask<Long> ft3 = new FutureTask<Long>(c3);
        FutureTask<Long> ft4 = new FutureTask<Long>(c4);

        Thread th1 = new Thread(ft1);
        Thread th2 = new Thread(ft2);
        Thread th3 = new Thread(ft3);
        Thread th4 = new Thread(ft4);
        th1.start();
        th2.start();
        th3.start();
        th4.start();
        try {
            th1.join();
            th2.join();
            th3.join();
            th4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (ft1.isDone() && ft2.isDone() && ft3.isDone() && ft4.isDone()) {
            try {
                sum = ft1.get() + ft2.get() + ft3.get() + ft4.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        return sum;
    }

    // main test
    public static void main(String[] args){
        int[] arr = new int[40];
        generateRandomArray(arr);

        System.out.println("=== generate function test>>>");
        int s = 0;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            s += arr[i];
        }

        System.out.println("\nsum is : " + s);

        System.out.println("\n=== sum function test>>>");
        long sum = sum(arr);
        System.out.println("Sum: " + sum);
    }
}
