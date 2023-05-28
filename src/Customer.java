import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Customer {

    private String name;
    private String ssn;
    private Address address;
    private LinkedList<Account> accounts;

    public Customer(String name,String ssn,String hNo, String streetAddress, String city, String state, String country, int zipCode)
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
        System.out.println("1.SBI,\n" +
                "    2. HDFC,\n" +
                "    3. ICIC,\n" +
                "    4. CHASE,\n" +
                "    5. MIDFIRST,\n" +
                "    6. BOA,\n" +
                "    7. AmericanExpress");
        System.out.println("Enter one of the available Bank options: ");
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
        System.out.println("Choose 1.Savings or 2.Checkings account type");
        System.out.println("Enter either 1 or 2 to select AccountType");
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
}
