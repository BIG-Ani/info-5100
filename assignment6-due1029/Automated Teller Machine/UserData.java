package Assignment6;

import java.util.List;

public class UserData {

    private User user;
    private String password;
    private List<Transaction> transactions;

    public UserData() {
    }

    public UserData(User user, String password, List<Transaction> transactions) {
        this.user = user;
        this.password = password;
        this.transactions = transactions;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
