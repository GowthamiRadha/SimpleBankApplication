import java.util.Scanner;

public class BankApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Customer customer = createCustomer(); // Create a new customer
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Welcome, " + customer.getName() + "!");
            System.out.println("Please select an option:");
            System.out.println("1. Create Account");
            System.out.println("2. Delete Account");
            System.out.println("3. Account Balance");
            System.out.println("4. Transfer Money");
            System.out.println("5. Deposit Money");
            System.out.println("6. Withdraw Money");
            System.out.println("7. Quit Application");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    customer.createAccount();
                    break;
                case 2:
                    System.out.println("Enter the Account number to delete: ");
                    String accountNoToDelete = scanner.next();
                    String deletionStatus = customer.deleteAccount(accountNoToDelete);
                    System.out.println(deletionStatus);
                    break;
                case 3:
                    System.out.println("Enter the Account number:");
                    String accountNumber = scanner.next();
                    System.out.println("Account Balance: "+customer.showBalance(accountNumber));
                    break;
                case 4:
                    System.out.println("Enter the sender Account number: ");
                    String senderAccountNo = scanner.next();
                    System.out.println("Enter the recipient Account number: ");
                    String recipientAccountNo = scanner.next();
                    System.out.println("Enter the amount to transfer: ");
                    double amountToTransfer = scanner.nextDouble();
                    try {
                        customer.transferMoney(senderAccountNo, recipientAccountNo, amountToTransfer);
                        System.out.println("Transfer successful!");
                    } catch(Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Enter the Account number: ");
                    String depositAccountNo = scanner.next();
                    System.out.println("Enter the amount to deposit: ");
                    double amountToDeposit = scanner.nextDouble();
                    try {
                        customer.depositMoney(depositAccountNo, amountToDeposit);
                        System.out.println("Deposit successful!");
                    } catch(Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    System.out.println("Enter the Account number: ");
                    String withdrawAccountNo = scanner.next();
                    System.out.println("Enter the amount to withdraw: ");
                    double amountToWithdraw = scanner.nextDouble();
                    try {
                        customer.withdrawMoney(withdrawAccountNo, amountToWithdraw);
                        System.out.println("Withdrawal successful!");
                    } catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    isRunning = false;
                    System.out.println("Quitting the application...");
                    break;
                default:
                    System.out.println("Invalid option! Please try again.");
                    break;
            }
            System.out.println();
        }

        scanner.close();
    }

    public static Customer createCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Customer Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Customer SSN: ");
        String ssn = scanner.nextLine();
        System.out.println("Enter Customer House Number: ");
        String hNo = scanner.nextLine();
        System.out.println("Enter Customer Street Address: ");
        String streetAddress = scanner.nextLine();
        System.out.println("Enter Customer City: ");
        String city = scanner.nextLine();
        System.out.println("Enter Customer State: ");
        String state = scanner.nextLine();
        System.out.println("Enter Customer Country: ");
        String country = scanner.nextLine();
        System.out.println("Enter Customer Zip Code: ");
        int zipCode = scanner.nextInt();

        return new Customer(name, ssn, hNo, streetAddress, city, state, country, zipCode);
    }
}