package Assignment5;

import java.util.Scanner;

public class MainTest {

    public static void main(String[] args) {
        Number number = new Number();

        Scanner sc = new Scanner(System.in);

        int quotient, x, y;
        while(true){
            System.out.println("Please input x >>");
            x = sc.nextInt();
            System.out.println("Please input y >>");
            y = sc.nextInt();

            try {
                quotient = number.count(x, y);

                System.out.println("If x, y are valid, the result of x / y >>");
                System.out.println(quotient);
            } catch (ZeroDividedException e) {
                e.printStackTrace();
                e.getMessage();
                break;
            }
        }
    }
}
