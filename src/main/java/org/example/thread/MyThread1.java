package org.example.thread;

import org.example.model.Account;

public class MyThread1 extends  Thread {

    private Account account;
    public MyThread1(Account account) {
        super();
        this.account = account;
    }

    @Override
    public void run() {

        //int curBalance = account.getBalance();

        //for(int i=0;i<1000000000;i++);

        account.setBalance(account.getBalance() + 100);

        System.out.println("Executing in " + Thread.currentThread().getName() + ", bakance: " + account.getBalance());


//        System.out.println("Executing in " + Thread.currentThread().getName() + ", bakance: " + account.getBalance());



        //System.out.println(account.getBalance());

    }
}
