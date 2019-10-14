package Assignment5;

public class FullTime extends Employee {
    public FullTime() {
    }

    public FullTime(String name, int paymentPerHour) {
        super(name, paymentPerHour);
    }

    @Override
    public int calculateSalary() throws MyIndexOutOfBoundException {
        int paymentPerHour = getPaymentPerHour();

        if (paymentPerHour < SalaryBound.LowerBound.number || paymentPerHour > SalaryBound.UpperBound.number)
            throw new MyIndexOutOfBoundException(SalaryBound.LowerBound.number, SalaryBound.UpperBound.number, paymentPerHour);

        return 8 * getPaymentPerHour();
    }
}
