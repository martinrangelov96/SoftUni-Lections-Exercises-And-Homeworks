package lec02_bankAccount;

public class BankAccount {
    private int id;
    private double balance;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return this.balance;
    }

    public void deposit (double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        if (this.getBalance() < amount) {
            throw new IllegalArgumentException("Insufficient balance");
        }

        this.balance -= amount;
    }

    @Override
    public String toString() {
        return String.format("Account ID%d, balance %.2f",
                this.getId(), this.getBalance());
    }

}
