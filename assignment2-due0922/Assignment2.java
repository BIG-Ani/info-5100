package Assignment2;

/**
 * Submit it on or before 22nd September 2019 , 12:00 pm
 */
public class Assignment2 {
    /*
        This method should return the sum of salaries of employees having salary greater than 5000
        Note: Employee array is passed, not employee
     */
    public double salaryGreaterThanFiveThousand(Employee[] employees) {
        // @TODO
        double sumOf5000Employee = 0;

        for(Employee employee : employees){
            if(employee.getSalary() > 5000)
                sumOf5000Employee += employee.getSalary();
        }
        return sumOf5000Employee;
    }


    /*
        This method should print either "Fizz", "Buzz" or "FizzBuzz"
        "Fizz" - if id of employee is divisible by 3
        "Buzz" - if id of employee is divisible by 5
        "FizzBuzz" - if id of employee is divisible by both 3 and 5
     */
    public void fizzBuzz(Employee employee) {
        // @TODO
        int employeeId = employee.getId();

        if(employeeId % 3 == 0 && employeeId % 5 == 0){
            System.out.println("FizzBuzz");
        }else if (employeeId % 3 == 0){
            System.out.println("Fizz");
        }else if (employeeId % 5 == 0){
            System.out.println("Buzz");
        }
    }


    /*
        This method should calculate tax for an employee in dollars
        If salary of employee is less than or equal to 2500, tax should be 10%
        If salary of employee is greater than 2500 but less than or equal to 5000, tax should be 25%
        If salary of employee is greater than 5000, tax should be 35%
    */
    public double calculateTax(Employee employee) {
        // @TODO
        double tax = 0.0;
        double salary = employee.getSalary();

        if(salary > 5000){
            tax = salary * 0.35;
        }else if(salary > 2500 && salary <= 5000){
            tax = salary * 0.25;
        }else{
            tax = salary * 0.1;
        }

        return tax;
    }


    /*
        We are given two employee objects.
        Implement this method to swap salaries of employees
    */
    public void swap(Employee firstEmployee, Employee secondEmployee) {
        // @TODO

        double temp = firstEmployee.getSalary();
        firstEmployee.setSalary(secondEmployee.getSalary());
        secondEmployee.setSalary(temp);
    }


    /*
        Return number of employees whose age is greater than 50
        Note: Employee array is passed, not employee
     */
    public int employeesAgeGreaterThan50(Employee[] employees) {
        // @TODO
        int numberOfAgeOver50 = 0;

        for(Employee employee : employees)
            if(employee.getAge() > 50)
                numberOfAgeOver50++;

        return numberOfAgeOver50;
    }


    /*
        Implement this method to reverse firstName of employee.
        Ex. Before: employee.getFirstName() -> "John"
        After : employee.getFirstName() -> "nhoJ"
     */
    public void reverseFirstName(Employee employee) {
        // @TODO
        String name = employee.getFirstName();
        StringBuilder stringBuilder = new StringBuilder(name);
        java.lang.String reverseName = stringBuilder.reverse().toString();
        employee.setFirstName(reverseName);
    }


    /*
        Print "true" if employee's first name contain one or more digits
        Print "false" if employee's first name doesn't contain any digit
        Ex: employee.getFirstName() -> "ha8l" == true
        employee.getFirstName() -> "hail" == false
     */
    public void isContainDigit(Employee employee) {
        // @TODO
        char[] name = employee.getFirstName().toCharArray();
        for(char ch : name){
            if(Character.isDigit(ch))
                System.out.println(true);
                break;  //It should be return instead of break
        }

        System.out.println(false);
    }


    /*
       Write a method to raise an employee's salary to three times of his/her original salary.
       Eg: original salary was 1000/month. After using this method, the salary is 3000/month.
       DO NOT change the input in this method.
       Try to add a new method in Employee class: public void raiseSalary(double byPercent)
       Call this new method.
    */
    public void tripleSalary(Employee employee) {
        // @TODO
        employee.raiseSalary(300);
    }


    //Additional question for extra credit
    /*
        Implement this method to convert String[] to employees array.
        Ex: String[] employees = new String[]{"1,John,24,7500", "2,Hail,28,7899.90"};
        This String array of length 2 contains 2 employees in form of string, where
        id = 1
        firstName=John
        age=24
        salary=7500
        convert each string to employee object.
        Hint: Use String methods. Refer : https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
     */
    public Employee[] createEmployees(String[] employeesStr) {
        Employee[] employees = new Employee[employeesStr.length];
        // @TODO

        int ind = 0;
        for (String employeeStr : employeesStr){
            String[] employeeInfo = employeeStr.split(",");
            int id = Integer.valueOf(employeeInfo[0]);
            String firstName = employeeInfo[1];
            int age = Integer.valueOf(employeeInfo[2]);
            double salary = Double.valueOf(employeeInfo[3]);

            Employee employee = new Employee(id,firstName, age, salary);
            employees[ind++] = employee;
        }

        return employees;
    }
}
