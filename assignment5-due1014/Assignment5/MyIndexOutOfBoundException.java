package Assignment5;

public class MyIndexOutOfBoundException extends Throwable {
    private int lowerBound;
    private int upperBound;

    private int index;

    public MyIndexOutOfBoundException(int lowerBound, int upperBound, int index) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.index = index;
    }

    @Override
    public String toString() {
        return "Error message: index: " + index + ", but lower bound: " + lowerBound + ", upper bount: " + upperBound;
    }
}
