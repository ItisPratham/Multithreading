package org.example.thread;

import org.example.model.Account;

public class MyThread2 implements Runnable {

    private Account account;
    public MyThread2(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        //int curBalance = account.getBalance();
        //for(int i=0;i<1000;i++);
        account.setBalance(account.getBalance()-50);
        //System.out.println(account.getBalance());
        System.out.println("Executing in " + Thread.currentThread().getName() + ", bakance: " + account.getBalance());

    }
}
