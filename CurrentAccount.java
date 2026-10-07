public class CurrentAccount extends Account {
    private double overdraftLimit;
    private double maintenanceFee;

    public CurrentAccount(String accountNumber, double balance,
                          double overdraftLimit, double maintenanceFee) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
        this.maintenanceFee = maintenanceFee;
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount < -overdraftLimit) {
            System.out.println("Withdrawal rejected: exceeds overdraft limit of " + overdraftLimit);
            return;
        }
        balance -= amount;
        System.out.println("Withdrew " + amount + " from CurrentAccount " + accountNumber);
    }

    @Override
    public void endOfMonth() {
        balance -= maintenanceFee;
        System.out.println("Maintenance fee of " + maintenanceFee + " deducted from CurrentAccount " + accountNumber);
    }
}
