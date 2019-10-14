package Assignment5;

public class Number {

    // get quotient of x / y
    public int count(int x, int y) throws ZeroDividedException {
        if (y == 0.0)
            throw new ZeroDividedException("can not be divided by zero");

        return x / y;
    }

}
