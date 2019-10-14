package Assignment5;

public enum SalaryBound {

    LowerBound          (20),
    UpperBound          (60);

    protected final int number;

    SalaryBound(int number) {
        this.number = number;
    }

//    //@Test
//    public static void main(String[] args) {
//        System.out.println(SalaryBound.LowerBound.number);
//        System.out.println(SalaryBound.UpperBound.number);
//    }
}
