package lec03_interestRate;

public class BankAccount {
    private static final double DEFAULT_INTEREST_RATE = 0.02;
    private static int idSequence;
    private static double interestRate;

    private int id;
    private double balance;

    public BankAccount() {
        interestRate = DEFAULT_INTEREST_RATE;
        this.id = ++idSequence;
    }

    public int getId() {
        return this.id;
    }

    public static void setInterest(double interest) {
        interestRate = interest;
    }

    public double getInterestRate(int years) {
        return this.balance * interestRate * years;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

}
