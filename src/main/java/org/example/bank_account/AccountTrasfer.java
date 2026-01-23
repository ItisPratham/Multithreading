package org.example.bank_account;

public class AccountTrasfer {


    public static void main(String[] args) throws InterruptedException {
        Account from = new Account(1, 1000);
        Account to = new Account(2, 1000);


        TransferService transferService = new TransferService();

        Runnable task1 = () -> {
            for(int i=0;i<1000;i++) {
                try {
                    transferService.transfer(from, to, 1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Runnable task2 = () -> {
            for(int i=0;i<1000;i++) {
                try {
                    transferService.transfer(to, from, 1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Account from has balance: "+from.getBalance());
        System.out.println("Account to has balance: "+to.getBalance());








    }
}

//t1
//1000 -> 999
//1000 -> 1001
//
//
//
//t2
//1000 -> 10001
//1000 -> 999