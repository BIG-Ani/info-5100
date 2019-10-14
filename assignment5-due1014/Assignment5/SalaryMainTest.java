package Assignment5;

public class SalaryMainTest {

    public static void main(String[] args) {
        Employee contractor = new Contractor("kai", 20, 12);
        Employee fullTime = new FullTime("zhou", 60);

        try {
            int contractorSalary = contractor.calculateSalary();
            System.out.println("The salary for contractor " + contractor.getName() + " is: " + contractorSalary);
        } catch (MyIndexOutOfBoundException e) {
            e.printStackTrace();
            System.out.println(e);
        }

        try {
            int fullTimeSalary = fullTime.calculateSalary();
            System.out.println("The salary for full time employee " + fullTime.getName() + " is: " + fullTimeSalary);
        } catch (MyIndexOutOfBoundException e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }
}
