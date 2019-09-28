package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AccountWithOutSync {
    private static Account account = new Account();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        for(int i = 0; i < 100; i++) {
            executor.execute(new AddAPennyTask());
        }
        executor.shutdown();
        while(!executor.isTerminated()) {

        }
        System.out.println("What is balance?" + account.getBalance());
    }
    private static class AddAPennyTask implements Runnable {
        public void run() {
//            synchronized (this) {
//            synchronized (account) {
                account.deposit(1);
//            }
        }
    }
    private static class Account {
        private static Lock lock = new ReentrantLock();
        private int balance = 0;
        public int getBalance() {
            return this.balance;
        }
//        public synchronized void deposit(int amount) {
        public void deposit(int amount) {
            lock.lock();
            try {
                int newBalance = balance + amount;
                Thread.sleep(5);
                balance = newBalance;
            } catch (InterruptedException e) {

            }
            finally {
                lock.unlock();
            }
//            balance += amount;
        }
    }
}


