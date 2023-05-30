import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Customer {

    private String name;
    private String ssn;
    private Address address;
    private LinkedList<Account> accounts;

    public String getName() {
        return name;
    }

    public String getSsn() {
        return ssn;
    }

    public Address getAddress() {
        return address;
    }

    public LinkedList<Account> getAccounts() {
        return accounts;
    }

    public Customer(String name, String ssn, String hNo, String streetAddress, String city, String state, String country, int zipCode)
    {
        this.name = name;
        this.ssn = ssn;
        this. address = new Address(hNo, streetAddress, city, state, country, zipCode);
        this.accounts = new LinkedList<>();
    }

    public void createAccount()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Account number: ");
        String accountNo = sc.next();
        Bank bankName = null;
        AccountType accountType;
        System.out.println("Select one of the available Banks:");
        System.out.println("1. SBI");
        System.out.println("2. HDFC");
        System.out.println("3. ICIC");
        System.out.println("4. CHASE");
        System.out.println("5. MIDFIRST");
        System.out.println("6. BOA");
        System.out.println("7. AmericanExpress");
        System.out.print("Enter the corresponding number for the Bank: ");
        int bankNo = sc.nextInt();
        switch(bankNo)
        {
            case 1:
                bankName = Bank.SBI;
                break;
            case 2:
                bankName = Bank.HDFC;
                break;
            case 3:
                bankName = Bank.ICIC;
                break;
            case 4:
                bankName = Bank.CHASE;
                break;
            case 5:
                bankName = Bank.MIDFIRST;
                break;
            case 6:
                bankName = Bank.BOA;
                break;
            case 7:
                bankName = Bank.AmericanExpress;
                break;
            default:
                throw new IllegalArgumentException("Invalid Bank Name!");
        }
        System.out.println("Select the account type:");
        System.out.println("1. Savings");
        System.out.println("2. Checkings");
        System.out.print("Enter either 1 or 2 to choose the AccountType: ");
        int type = sc.nextInt();
        if(type==1)
            accountType = AccountType.SAVINGS;
        else if(type==2)
            accountType = AccountType.CHECKING;
        else throw new IllegalArgumentException("AccountType is Invalid!");
        Account account = new Account();
        for(Account act: accounts)
        {
            if(act.getAccountNo()==accountNo)
                throw new IllegalArgumentException("Account with that");
        }
        account.setAccountNo(accountNo);
        account.setBankName(bankName);
        account.setAccountType(accountType);
        account.setBalance(0.00);
        this.accounts.add(account);
    }

    public String deleteAccount(String accountNo) {
        int idx = -1;
        for (Account act : accounts) {
            if (act.getAccountNo() == accountNo)
                break;
        }
        if (idx != -1){
            accounts.remove(idx);
            return "Successfully deleted Account having AccountNo as " + accountNo;
        }else return "No account present with given AccountNo!";
    }

    public void transferMoney(String senderAccountNo, String recipientAccountNo, double amount) {
        Account senderAccount = findAccount(senderAccountNo);
        Account recipientAccount = findAccount(recipientAccountNo);
        if (senderAccount == null || recipientAccount == null) {
            throw new IllegalArgumentException("Invalid account numbers!");
        }
        senderAccount.transfer(recipientAccount, amount);
    }

    public void depositMoney(String accountNo, double amount) {
        Account account = findAccount(accountNo);
        if (account == null) {
            throw new IllegalArgumentException("Invalid account number!");
        }
        account.deposit(amount);
    }

    private Account findAccount(String accountNo) {
        for (Account account : accounts) {
            if (account.getAccountNo().equals(accountNo)) {
                return account;
            }
        }
        return null;
    }

    public void withdrawMoney(String accountNo, double amount) {
        Account account = findAccount(accountNo);
        if (account == null) {
            throw new IllegalArgumentException("Invalid account number!");
        }
        account.withdraw(amount);
    }

    public double showBalance(String accountNo)
    {
        Account account = findAccount(accountNo);
        if (account == null) {
            throw new IllegalArgumentException("Invalid account number!");
        }
        return account.getBalance();
    }
}
