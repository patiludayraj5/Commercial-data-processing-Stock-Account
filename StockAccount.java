import java.io.*;
import java.util.ArrayList;
import java.util.List;

class CompanyShares {
    public String getSymbol() {
        return symbol;
    }

    public int getNumberOfShares() {
        return numberOfShares;
    }

    public String symbol;
    public int numberOfShares;

    public CompanyShares(String symbol, int numberOfShares) {
        this.symbol = symbol;
        this.numberOfShares = numberOfShares;
    }

    // Getter methods for symbol and numberOfShares

    // Additional methods as needed
}

public class StockAccount {
    String filename;
    private final List<CompanyShares> transactionHistory;

    public StockAccount(String filename) {
        this.filename=filename;
        // Initialization logic from file (loading existing data if any)
        this.transactionHistory = new ArrayList<>();
    }

    public double valueOf() {
        // Calculate and return the total value of the account in dollars
        // (Implementation would depend on how the stocks are valued)
        return 0.0; // Placeholder value
    }

    public void buy(int amount, String symbol) {
        // Add shares of stock to the account
        // Check if CompanyShares are available, update or create an object accordingly
        transactionHistory.add(new CompanyShares(symbol, amount));
    }

    public void sell(int amount, String symbol) {
        // Subtract shares of stock from the account
        // Check if CompanyShares are available, update or create an object accordingly
        transactionHistory.add(new CompanyShares(symbol, -amount));
    }

    public void save(String filename) {
        // Save the account to the specified file
        this.filename=filename;
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(transactionHistory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printReport() {
        // Print a report containing information about stocks and their values in the account
        for (CompanyShares transaction : transactionHistory) {
            System.out.println("Symbol: " + transaction.getSymbol() +
                    ", Number of Shares: " + transaction.getNumberOfShares());
        }
    }

    public static void main(String[] args) {
        // Example usage
        StockAccount stockAccount = new StockAccount("accountData.dat");

        stockAccount.buy(10, "AAPL");
        stockAccount.buy(5, "GOOGL");

        stockAccount.sell(3, "AAPL");

        stockAccount.printReport();

        stockAccount.save("accountData.dat");
    }
}
