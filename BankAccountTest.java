public class BankAccountTest {
    public static void main(String[] args) {
        try {
            BankAccount account = new BankAccount("GB821234", 1000.00);
            System.out.println(account);
        } catch (BankException e) {
            System.err.println(e.getMessage());
            System.err.flush();
        }

        try {
        } catch (BankException e) {
            System.err.println(e.getMessage());
            System.err.flush();
        }

        try {
            BankAccount account = new BankAccount("GB821234", 500.00);
            account.deposit(200.00);
            System.out.println(account);
            account.deposit(-50.00); 
        } catch (BankException e) {
            System.err.println(e.getMessage());
            System.err.flush();
        }

        try {
            BankAccount account = new BankAccount("GB821234", 300.00);
            account.withdraw(100.00);
            System.out.println(account);
            account.withdraw(250.00);
        } catch (BankException e) {
            System.err.println(e.getMessage());
            System.err.flush();
        }

        try {
            BankAccount account = new BankAccount("GB821234", 300.00);
            account.withdraw(-100.00);
        } catch (BankException e) {
            System.err.println(e.getMessage());
            System.err.flush();
        }
    }
}
