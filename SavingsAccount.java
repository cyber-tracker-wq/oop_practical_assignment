public class SavingsAccount extends Account {
    private double minimumBalance;
    private double interestRate;

    public SavingsAccount(String accountNumber, double balance,
                          double minimumBalance, double interestRate) {
        super(accountNumber, balance);
        this.minimumBalance = minimumBalance;
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount < minimumBalance) {
            System.out.println("Withdrawal rejected: balance cannot go below minimum balance of " + minimumBalance);
            return;
        }
        balance -= amount;
        System.out.println("Withdrew " + amount + " from SavingsAccount " + accountNumber);
    }

    @Override
    public void endOfMonth() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.println("Interest of " + interest + " applied to SavingsAccount " + accountNumber);
    }
}
