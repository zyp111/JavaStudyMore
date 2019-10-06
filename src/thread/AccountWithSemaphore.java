package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class AccountWithSemaphore {
    private static Account account = new Account();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0; i < 100; i++)
            executorService.execute(new AddTask());
        executorService.shutdown();
        while (!executorService.isTerminated()) {

        }
        System.out.println(account.getBalance());
    }
    public static class AddTask implements Runnable {

        @Override
        public void run() {
            account.deposit(1);
        }
    }
    private static class Account {
        private static Semaphore semaphore = new Semaphore(1);
        private int balance = 0;

        public int getBalance() {
            return balance;
        }

        public void deposit(int amount) {
            try {
                semaphore.acquire();
                int newBalance = balance + amount;
                Thread.sleep(5);
                balance = newBalance;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                semaphore.release();
            }
        }
    }
}
