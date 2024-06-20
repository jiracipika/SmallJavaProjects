import java.util.Date;

public class BankAccountProgram {
    
    public static class Account {
        private int id;
        private double balance;
        private static double annualInterestRate;
        private Date dateCreated;

        public Account() {
            dateCreated = new Date();
        }

        public Account(int newId, double newBalance) {
            id = newId;
            balance = newBalance;
            dateCreated = new Date();
        }

        public int getId() {
            return id;
        }

        public double getBalance() {
            return balance;
        }

        public static double getAnnualInterestRate() {
            return annualInterestRate;
        }

        public void setId(int newId) {
            id = newId;
        }

        public void setBalance(double newBalance) {
            balance = newBalance;
        }

        public static void setAnnualInterestRate(double newAnnualInterestRate) {
            annualInterestRate = newAnnualInterestRate;
        }

        public double getMonthlyInterest() {
            return balance * (annualInterestRate / 1200);
        }

        public Date getDateCreated() {
            return dateCreated;
        }

        public void withdraw(double amount) {
            balance -= amount;
        }

        public void deposit(double amount) {
            balance += amount;
        }

        @Override
        public String toString() {
            return "Account{" +
                    "id=" + id +
                    ", balance=" + balance +
                    ", dateCreated=" + dateCreated +
                    '}';
        }
    }

    public static class SavingsAccount extends Account {

        public SavingsAccount() {
            super();
        }

        public SavingsAccount(int newId, double newBalance) {
            super(newId, newBalance);
        }

        @Override
        public void withdraw(double amount) {
            if (getBalance() - amount >= 0) {
                super.withdraw(amount);
            } else {
                System.out.println("Error: Insufficient funds for withdrawal from savings account");
            }
        }

        @Override
        public String toString() {
            return "Savings" + super.toString();
        }
    }

    public static class CheckingAccount extends Account {
        private double overdraftLimit;

        public CheckingAccount() {
            super();
            overdraftLimit = 0;
        }

        public CheckingAccount(int newId, double newBalance, double overdraftLimit) {
            super(newId, newBalance);
            this.overdraftLimit = overdraftLimit;
        }

        @Override
        public void withdraw(double amount) {
            if (getBalance() - amount >= -overdraftLimit) {
                super.withdraw(amount);
            } else {
                System.out.println("Error: Overdraft limit exceeded for checking account");
            }
        }

        @Override
        public String toString() {
            return "Checking" + super.toString() + ", overdraftLimit=" + overdraftLimit + '}';
        }
    }

    public static void main(String[] args) {
        Account acc = new Account(1, 1000);
        CheckingAccount checkAcc = new CheckingAccount(2, 2000, 500);
        SavingsAccount saveAcc = new SavingsAccount(3, 3000);

        System.out.println(acc.toString());
        acc.deposit(500);
        acc.withdraw(100);
        System.out.println(acc.toString());

        System.out.println(checkAcc.toString());
        checkAcc.deposit(500);
        checkAcc.withdraw(2600);
        System.out.println(checkAcc.toString());

        System.out.println(saveAcc.toString());
        saveAcc.deposit(500);
        saveAcc.withdraw(3500);
        System.out.println(saveAcc.toString());
    }
}
