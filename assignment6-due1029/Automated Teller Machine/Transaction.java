package Assignment6;

public class Transaction {

    private int number;
    private String operation;
    private double balance;
    private double amount;

    public Transaction(String operation, double amount) {
        this.operation = operation;
        this.amount = amount;
    }

    public Transaction(String operation, double balance, double amount) {
        this.operation = operation;
        this.balance = balance;
        this.amount = amount;
    }

    public Transaction(int number, String operation, double balance, double amount) {
        this.number = number;
        this.operation = operation;
        this.balance = balance;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return number + " - " + operation + " -> " + amount + ". Now your account balance is : " + balance;
    }
}
