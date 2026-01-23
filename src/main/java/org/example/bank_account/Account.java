package org.example.bank_account;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {

    int id;
    int balance;
    final Lock lock = new ReentrantLock();

    public int getBalance() {
        return balance;
    }

    public int getId() {
        return id;
    }

    public Account(int id, int balance) {
        this.id = id;
        this.balance = balance;

    }

    void withdraw(int amount) {
        balance-= amount;
    }

    void deposit(int amount) {
        balance+=amount;
    }

}
