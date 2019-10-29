package Assignment6;

public enum AtmOperationCodeEnum {

    deposit                 ("deposit", 0),
    withdraw                ("withdraw", 1),
    changePassword          ("changePassword", 2),
    checkRecentTransaction  ("checkRecentTransaction", 3),
    exit                    ("exit", 4);

    public String operationName;
    public int operationCode;

    AtmOperationCodeEnum(String operationName, int operationCode) {
        this.operationName = operationName;
        this.operationCode = operationCode;
    }
}
