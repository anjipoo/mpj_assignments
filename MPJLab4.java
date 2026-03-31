import java.io.*;
import java.util.*;

// Custom Exceptions
class MinBalanceException extends Exception {
    MinBalanceException(String msg) {
        super(msg);
    }
}

class InvalidCIDException extends Exception {
    InvalidCIDException(String msg) {
        super(msg);
    }
}

class NegativeAmountException extends Exception {
    NegativeAmountException(String msg) {
        super(msg);
    }
}

// Customer class
class Customer implements Serializable {
    int cid;
    String cname;
    double amount;

    Customer(int cid, String cname, double amount) {
        this.cid = cid;
        this.cname = cname;
        this.amount = amount;
    }

    public String toString() {
        return cid + " " + cname + " " + amount;
    }
}

// Main class name same as file name
public class MPJLab4 {
    static Scanner sc = new Scanner(System.in);
    static final String FILE_NAME = "customers.dat";

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n1. Create Account");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Records");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        createAccount();
                        break;
                    case 2:
                        withdrawAmount();
                        break;
                    case 3:
                        displayRecords();
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 4);
    }

    static void createAccount() throws Exception {
        System.out.print("Enter CID (1-20): ");
        int cid = sc.nextInt();
        if (cid < 1 || cid > 20)
            throw new InvalidCIDException("CID must be between 1 and 20");

        System.out.print("Enter Name: ");
        String name = sc.next();

        System.out.print("Enter Amount: ");
        double amt = sc.nextDouble();

        if (amt < 0)
            throw new NegativeAmountException("Amount must be positive");

        if (amt < 1000)
            throw new MinBalanceException("Minimum balance is 1000");

        Customer c = new Customer(cid, name, amt);

        FileOutputStream fos = new FileOutputStream(FILE_NAME, true);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(c);
        oos.close();

        System.out.println("Account created successfully!");
    }

    static void withdrawAmount() throws Exception {
        System.out.print("Enter CID: ");
        int cid = sc.nextInt();

        System.out.print("Enter Withdraw Amount: ");
        double wamt = sc.nextDouble();

        if (wamt < 0)
            throw new NegativeAmountException("Amount must be positive");

        FileInputStream fis = new FileInputStream(FILE_NAME);
        ObjectInputStream ois = new ObjectInputStream(fis);

        ArrayList<Customer> list = new ArrayList<>();
        boolean found = false;

        try {
            while (true) {
                Customer c = (Customer) ois.readObject();
                if (c.cid == cid) {
                    found = true;
                    if (wamt > c.amount)
                        throw new ArithmeticException("Insufficient balance");
                    else
                        c.amount -= wamt;
                }
                list.add(c);
            }
        } catch (EOFException e) {
        }

        ois.close();

        if (!found) {
            System.out.println("Customer not found");
            return;
        }

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
        for (Customer c : list) {
            oos.writeObject(c);
        }
        oos.close();

        System.out.println("Withdrawal successful!");
    }

    static void displayRecords() throws Exception {
        FileInputStream fis = new FileInputStream(FILE_NAME);
        ObjectInputStream ois = new ObjectInputStream(fis);

        try {
            while (true) {
                Customer c = (Customer) ois.readObject();
                System.out.println(c);
            }
        } catch (EOFException e) {
        }

        ois.close();
    }
}
