import java.util.Date;

class Account {
    private int id = 0;
    private double balance = 0;
    private double annualInterestRate = 0;
    private Date dateCreated;
    
    public Account() {
        dateCreated = new Date();
    }
    
    public Account(int id, double balance) {
        this();
        this.id = id;
        this.balance = balance;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }
    
    public double getMonthlyInterestRate() {
        return annualInterestRate / 12;
    }
    
    public void withdraw(double amount) {
        if(amount > balance) {
            System.out.println("Insufficient balance!");
            return;
        }
        balance -= amount;
    }
    
    public void deposit(double amount) {
        balance += amount;
    }
}

 class TestAccount {
    public static void main(String[] args) {
        Account account = new Account(1234, 100);
        account.setAnnualInterestRate(6.7);

        // Try to withdraw more than the account balance
        account.withdraw(150);
        
        // Withdraw $50 from the account
        account.withdraw(50);
        
        // Deposit $1000 in the account
        account.deposit(1000);

        // Print the balance, annual interest rate, and the date that the account was created
        System.out.println("Balance: " + account.getBalance());
        System.out.println("Annual Interest Rate: " + account.getAnnualInterestRate() + "%");
        System.out.println("Date Created: " + account.getDateCreated());
    }
}
