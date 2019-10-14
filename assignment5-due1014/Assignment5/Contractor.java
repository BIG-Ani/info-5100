package Assignment5;

public class Contractor extends Employee {
    private int workingHours;

    public Contractor() {
    }

    public Contractor(String name, int paymentPerHour, int workingHours) {
        super(name, paymentPerHour);
        this.workingHours = workingHours;
    }

    @Override
    public int calculateSalary() throws MyIndexOutOfBoundException{
        int paymentPerHour = getPaymentPerHour();

        if (paymentPerHour < SalaryBound.LowerBound.number || paymentPerHour > SalaryBound.UpperBound.number)
            throw new MyIndexOutOfBoundException(SalaryBound.LowerBound.number, SalaryBound.UpperBound.number, paymentPerHour);

        return workingHours * getPaymentPerHour();
    }
}
