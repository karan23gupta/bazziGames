import java.util.*;

interface OnlineAccount {
    int basePrice = 10;
    int regularMoviePrice = 5;
    int exclusiveMoviePrice = 10;
}

class Account implements OnlineAccount, Comparable<Account> {
    private String ownerName;
    private int numberOfRegularMovies;
    private int numberOfExclusiveMovies;

    public Account(String ownerName, int numberOfRegularMovies, int numberOfExclusiveMovies) {
        this.ownerName = ownerName;
        this.numberOfRegularMovies = numberOfRegularMovies;
        this.numberOfExclusiveMovies = numberOfExclusiveMovies;
    }

    public int monthlyCost() {
        return basePrice + (numberOfRegularMovies * regularMoviePrice) + (numberOfExclusiveMovies * exclusiveMoviePrice);
    }

    @Override
    public int compareTo(Account other) {
        return this.monthlyCost() - other.monthlyCost();
    }

    @Override
    public String toString() {
        return "Owner is " + ownerName + " and monthly cost is " + monthlyCost() + " USD.";
    }
}

class Main {
    public static void main(String[] args) {
        Account account1 = new Account("John", 5, 2);
        Account account2 = new Account("Alice", 3, 1);

        System.out.println(account1.toString());
        System.out.println(account2.toString());

        int comparisonResult = account1.compareTo(account2);
        System.out.println("Comparison result: " + comparisonResult);
    }
}
