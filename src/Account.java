public class Account {

    private String accountNo;
    private Bank bankName;
    private AccountType accountType;
    private double balance;

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public Bank getBankName() {
        return bankName;
    }

    public void setBankName(Bank bankName) {
        this.bankName = bankName;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid deposit amount!");
        }
        this.balance += amount;
    }

    public void transfer(Account recipientAccount, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid transfer amount!");
        }
        if (this.balance < amount) {
            throw new IllegalArgumentException("Insufficient balance!");
        }
        this.balance -= amount;
        recipientAccount.deposit(amount);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid withdrawal amount!");
        }
        if (this.balance < amount) {
            throw new IllegalArgumentException("Insufficient balance!");
        }
        this.balance -= amount;
    }
}
