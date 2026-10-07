import java.util.ArrayList;
import java.util.List;

public class BankDemo {
    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        accounts.add(new SavingsAccount("SAV001", 500.0, 100.0, 0.05));
        accounts.add(new CurrentAccount("CUR001", 200.0, 300.0, 10.0));

        System.out.println("--- Deposits ---");
        accounts.get(0).deposit(150.0);
        accounts.get(1).deposit(50.0);

        System.out.println("--- Withdrawals ---");
        accounts.get(0).withdraw(600.0); // rejected: would go below minimum
        accounts.get(1).withdraw(400.0); // allowed: within overdraft limit

        System.out.println("--- End of Month Processing ---");
        for (Account acc : accounts) {
            acc.endOfMonth();
            System.out.println("New balance: " + acc.getBalance());
        }
    }
}
