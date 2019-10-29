package Assignment6;

import java.time.Year;
import java.util.Scanner;

public class AutomatedTellerMachine {

    public void greetingToUser(Atm atm){
        Scanner scanner = new Scanner(System.in);
        User loginUser = null;

        while (true){
            System.out.println("Current user or New user?");

            String lineCommand = scanner.nextLine();

            if (lineCommand.equals("new")){
                loginUser = atm.createNewUser(scanner);

                operationWithAccount(scanner, loginUser, atm);
            }else if (lineCommand.equals("current user")){
                loginUser = atm.login(scanner);

                operationWithAccount(scanner, loginUser, atm);
            }

            System.out.println("\nDo you finish your operation? If Yes, please click EXIT. If No, please click CONTINUE");
            lineCommand = scanner.nextLine();

            if (lineCommand.equals("EXIT")){
                loginUser.setLoggedIn(false);
                break;
            }
        }
    }

    private void operationWithAccount(Scanner scanner, User loginUser, Atm atm) {
        while (true){
            System.out.println( "\n" + "Enter what you want to do " +
                    "( 0 - deposit |" +
                    " 1 - withdraw |" +
                    " 2 - changePassword |" +
                    " 3 - checkRecentTransaction |" +
                    " 4 - exit)");

            String line = scanner.nextLine();
            int line2Code = Integer.parseInt(line);

            if (line2Code == AtmOperationCodeEnum.exit.operationCode)
                break;
            else if (line2Code == AtmOperationCodeEnum.deposit.operationCode){
                atm.deposit(scanner, loginUser);
            }else if (line2Code == AtmOperationCodeEnum.withdraw.operationCode){
                try {
                    atm.withdraw(scanner, loginUser);
                }catch (IllegalArgumentException e){
                    e.printStackTrace();
                }
            }else if (line2Code == AtmOperationCodeEnum.changePassword.operationCode){
                atm.changePassword(scanner, loginUser);
            }else if (line2Code == AtmOperationCodeEnum.checkRecentTransaction.operationCode){
                atm.checkRecentTransaction(scanner, loginUser);
            }
        }
    }

    // main test
    public static void main(String[] args) {
        Atm atm = new Atm(10000.0, 2.0);

        AutomatedTellerMachine automatedTellerMachine = new AutomatedTellerMachine();

        System.out.println("Welcome to the AutomatedTeller");
        boolean atmTurnOff = false;

        Scanner scanner = new Scanner(System.in);

        while (!atmTurnOff){
            automatedTellerMachine.greetingToUser(atm);

            System.out.println("Are you done with your business? Yes or No");
            String done = scanner.nextLine();

            atmTurnOff = done.equals("Yes")? true : false;
        }
    }

}
