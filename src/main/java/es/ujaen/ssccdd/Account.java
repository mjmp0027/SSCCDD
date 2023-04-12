package es.ujaen.ssccdd;

import java.util.concurrent.atomic.AtomicLong;

public class Account {
    public long getBalance() {
        return balance.get();
    }

    public void setBalance(long balance) {
        this.balance.set(balance);
    }

    private final AtomicLong balance;

    public Account() {
        balance = new AtomicLong();
    }

    public void addAmount(long amount) {
        this.balance.getAndAdd(amount);
    }

    public void subtractAmount(long amount) {
        this.balance.getAndAdd(-amount);
    }
}
