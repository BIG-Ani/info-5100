package Assignment6;

import sun.jvm.hotspot.debugger.InputLexer;

import java.util.*;

public class Atm {

    private double availableAmountInMachine;
    private double transactionFee;
    private Map<User, UserData> userDataMap = new HashMap<>();

    public Atm() {
    }

    public Atm(double availableAmountInMachine, double transactionFee) {
        this.availableAmountInMachine = availableAmountInMachine;
        this.transactionFee = transactionFee;
    }

    // Create a new user
    public User createNewUser(Scanner scanner){
        // create a new bank account with 6 digits
        System.out.println("Please provide your info - name>>>");
        String name = scanner.nextLine();

        System.out.println("Please provide your info - phoneNumber>>>");
        String phoneNumber = scanner.nextLine();

        System.out.println("Please provide your info - address>>>");
        String address = scanner.nextLine();

        System.out.println("Please provide your info - password>>>");
        String password = scanner.nextLine();

        System.out.println("Please provide your info - age>>>");
        int age = Integer.parseInt(scanner.nextLine());

        Integer newBankAccount = null;

        while (true){
            newBankAccount = (int)(100000 + Math.random() * 10000);
            boolean duplicate = false;
            if (userDataMap.size() == 0)
                duplicate = false;
            else {
                for(User user : userDataMap.keySet()){
                    if (user.getBankAccountNumber().equals(String.valueOf(newBankAccount))){
                        duplicate = true;
                        break;
                    }
                }
            }

            if (!duplicate)
                break;;
        }


//        User newUser = new User(name, age, false, address, password, phoneNumber, String.valueOf(newBankAccount));
        User newUser = new User(0, name, age, false, address, password, phoneNumber, String.valueOf(newBankAccount), 0.0);
        UserData newUserData = new UserData(newUser, newUser.getPassword(), new ArrayList<Transaction>());

        userDataMap.put(newUser, newUserData);

        return confirmLogin(newUser.getBankAccountNumber(), newUser.getPassword());
    }

    // find current user
    public User findUser(User user) throws IllegalArgumentException {
        for (User foundedUser : userDataMap.keySet()){
            if (foundedUser.getBankAccountNumber().equals(user.getBankAccountNumber()) &&
            foundedUser.getPassword().equals(user.getPassword())){
                return foundedUser;
            }
        }

        throw new IllegalArgumentException("Sorry, we have no record on this account");
    }

    // log in
    public User login(Scanner scanner){
        System.out.println("Do you forget your account password? Yes or No?");
        String remember = scanner.nextLine();

        boolean rememberPassword = false;
        while (true){
            if (remember.equals("Yes")){
                rememberPassword = false;
                break;
            }
            else if (remember.equals("No")){
                rememberPassword = true;
                break;
            }
        }

        System.out.println("Please provide your account number>>>");
        String bankAccountNumber = scanner.nextLine();

        User currentUser = null;
        if (rememberPassword){
            try {
                System.out.println("Please input your account password>>>");
                String password =  scanner.nextLine();

                currentUser = confirmLogin(bankAccountNumber, password);
            }catch (IllegalArgumentException e){
                e.printStackTrace();
            }
        }else{
            currentUser = resetPassword(scanner, bankAccountNumber);
        }

        return currentUser;
    }

    private User resetPassword(Scanner sc, String bankAccountNumber) {
        User currentUser = null;
        System.out.println("Please provide your info - name>>>");
        String name = sc.nextLine();
        System.out.println("Please provide your info - age>>>");
        int age = Integer.parseInt(sc.nextLine());
        System.out.println("Please provide your info - phoneNumber>>>");
        String phoneNumber = sc.nextLine();


        for (User user : userDataMap.keySet()){
            if (bankAccountNumber.equals(user.getBankAccountNumber()) &&
            age == user.getAge() &&
            phoneNumber.equals(user.getPhoneNumber())){
                currentUser = user;
                String newPassword = "0";
                String secPassword = "1";

                while (!newPassword.equals(secPassword)){
                    if (user.getName().equals(name) && user.getAge() == age && user.getPhoneNumber().equals(phoneNumber)){
                        System.out.println("Please input your new password>>>");
                        newPassword = sc.nextLine();

                        System.out.println("Please input your new password, again>>>");
                        secPassword = sc.nextLine();
                    }
                }

                user.setPassword(newPassword);
            }
        }

        return currentUser;
    }

    private User confirmLogin(String bankAccountNumber, String password) throws IllegalArgumentException{
        for (User user : userDataMap.keySet()){
            if (user.getBankAccountNumber().equals(bankAccountNumber)){
                if (user.getPassword().equals(password)){
                    user.setLoggedIn(true);
                    return user;
                }
                else
                    throw new IllegalArgumentException("Password is wrong...");
            }
        }

        throw new IllegalArgumentException("Sorry, there is no bank account record");
    }

    // change password
    public void changePassword(Scanner scanner, User user){
        while (!user.isLoggedIn()){
            System.out.println("Please log in>>>");
            login(scanner);
        }

        resetPassword(scanner, user.getBankAccountNumber());
    }

    // deposit
    public void deposit(Scanner scanner, User user){
        while (!user.isLoggedIn()){
            System.out.println("Please log in>>>");
            login(scanner);
        }

        System.out.println("Please input the amount you want to deposit>>>");
        double depositAmount = Double.parseDouble(scanner.nextLine());
        user.setAvailableBalance(user.getAvailableBalance() + depositAmount - transactionFee);

        // update transaction record
        Transaction depositTransaction = new Transaction(user.getTransactionNumber(), "deposit", user.getAvailableBalance(), depositAmount);
        user.setTransactionNumber(user.getTransactionNumber() + 1);

        userDataMap.get(user).getTransactions().add(depositTransaction);

        availableAmountInMachine += depositAmount;
    }

    // withdraw
    public void withdraw(Scanner scanner, User user) throws IllegalArgumentException{
        while (!user.isLoggedIn()){
            System.out.println("Please log in>>>");
            login(scanner);
        }

        System.out.println("Your account balance is : " + user.getAvailableBalance());

        System.out.println("Please input the amount you want to withdraw>>>");
        double withdrawAmount = Double.parseDouble(scanner.nextLine());

        if (withdrawAmount > user.getAvailableBalance())
            throw new IllegalArgumentException("Sorry, your balance is not enough");
        if (withdrawAmount > availableAmountInMachine)
            throw new IllegalArgumentException("There is not enough money in this machine");
        else{
            // update transaction record
            user.setAvailableBalance(user.getAvailableBalance() - withdrawAmount - transactionFee);

            Transaction withdrawTransaction = new Transaction(user.getTransactionNumber(),"withdraw", user.getAvailableBalance(), withdrawAmount);
            user.setTransactionNumber(user.getTransactionNumber() + 1);

            userDataMap.get(user).getTransactions().add(withdrawTransaction);

            availableAmountInMachine -= withdrawAmount;
        }
    }

    // show recent transaction
    public void checkRecentTransaction(Scanner scanner, User user){
        while (!user.isLoggedIn()){
            System.out.println("Please log in>>>");
            login(scanner);
        }

        System.out.println("Your available balance is -> " + user.getAvailableBalance());

        // print transaction records
        List<Transaction> transactionsList = userDataMap.get(user).getTransactions();
        int size = transactionsList.size();

        if (size > 10)
            size = 10;

        System.out.println("\nHere are your recent 10 transaction records>>>\n");
        for (int i = 0; i < size; i++){
            System.out.println(transactionsList.get(i).toString() + "\n");
        }

    }

}
