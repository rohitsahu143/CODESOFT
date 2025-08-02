
import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("✅ Deposited: ₹" + amount);
        } else {
            System.out.println("⚠️ Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("✅ Withdrawn: ₹" + amount);
        } else {
            System.out.println("❌ Insufficient balance or invalid amount.");
        }
    }

    public double getBalance() {
        return balance;
    }
}

class ATM {
    private BankAccount account;
    private Scanner sc;

    public ATM(BankAccount account) {
        this.account = account;
        this.sc = new Scanner(System.in);
    }

    public void start() {
        System.out.println("💳 Welcome to the ATM Interface!");

        while (true) {
            System.out.println("\n🔘 Choose an option:");
            System.out.println("1️⃣ Check Balance");
            System.out.println("2️⃣ Deposit");
            System.out.println("3️⃣ Withdraw");
            System.out.println("4️⃣ Exit");
            System.out.print("👉 Your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("💰 Current Balance: ₹" + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ₹");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("👋 Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("⚠️ Invalid choice. Please try again.");
            }
        }
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(10000); // Initial balance ₹10,000
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}
