package org.tony.java.jdk8.statement.lambda.example4;

/**
 */
public class Transaction {

    private final Traders traders;

    private final int year;

    private final int value;

    public Transaction(Traders traders, int year, int value) {
        this.traders = traders;
        this.year = year;
        this.value = value;
    }

    public Traders getTraders() {
        return traders;
    }

    public int getYear() {
        return year;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "traders=" + traders +
                ", year=" + year +
                ", value=" + value +
                '}';
    }
}
