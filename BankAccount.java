public class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double initialBalance) {
        if (!verify(accountNumber)) {
            throw new BankException("Invalid account number format or check digits.");
        }
        if (initialBalance < 0) {
            throw new BankException("Initial balance must be greater than or equal to zero.");
        }
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount < 0) {
            throw new BankException("Deposit amount cannot be negative.");
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount < 0) {
            throw new BankException("Withdrawal amount cannot be negative.");
        }
        if (balance < amount) {
            throw new BankException("Insufficient funds :(");
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    private boolean verify(String accountNumber) {
        if (accountNumber.length() != 8) {
            return false;
        }

        String modifiedAccountNumber = accountNumber.substring(4) + accountNumber.substring(0, 4);

        StringBuilder numericAccountNumber = new StringBuilder();
        for (char character : modifiedAccountNumber.toCharArray()) {
            if (Character.isLetter(character)) {
                numericAccountNumber.append((int) character - 55);
            } else {
                numericAccountNumber.append(character);
            }
        }

        long accountNumberValue = Long.parseLong(numericAccountNumber.toString());
        return accountNumberValue % 11 == 1;
    }

    @Override
    public String toString() {
        return String.format("BankAccount[accountNumber=%s, balance=$%.2f]", accountNumber, balance);
    }
}
