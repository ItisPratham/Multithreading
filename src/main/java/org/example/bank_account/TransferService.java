package org.example.bank_account;

import java.awt.image.TileObserver;
import java.util.concurrent.TimeUnit;

public class TransferService {


    void transfer(Account from, Account to, int amount) throws InterruptedException {

        //Account firstLock =  from.getId() < to.getId() ? from: to;
        //Account secondLock = from.getId() < to.getId() ? to: from;


        from.lock.tryLock(2, TimeUnit.SECONDS);
        to.lock.tryLock(2, TimeUnit.SECONDS);
        try {
            if (from.balance < amount) {
                throw new IllegalStateException("Not enough funds");
            }
            from.balance -= amount;
            to.balance   += amount;
        } finally {
            to.lock.unlock();
            from.lock.unlock();
        }

    }
}

/**
 * T1
 * A -> B
 *
 * T2
 * B -> A
 *
 */







