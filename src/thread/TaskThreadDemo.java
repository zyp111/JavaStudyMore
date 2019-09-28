package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskThreadDemo {
    public static void main(String[] args) {
//        Runnable printA = new PrintChar('a',100);
//        Runnable printB = new PrintChar('b',100);
//        Runnable printC = new PrintNum(100);
//        Thread thread1 = new Thread(printA);
//        Thread thread2 = new Thread(printB);
//        Thread thread3 = new Thread(printC);
//        thread3.setPriority(Thread.MAX_PRIORITY);
//        thread1.start();
//        thread2.start();
//        thread3.start();
//        ExecutorService executor = Executors.newCachedThreadPool();
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.execute(new PrintChar('a',100));
        executor.execute(new PrintChar('b',100));
        executor.execute(new PrintNum(100));

        executor.shutdown();
    }
}
class PrintChar implements Runnable {
    private char charToPrint;
    private int times;

    public PrintChar(char c, int t) {
        charToPrint = c;
        times = t;
    }

    @Override
    public void run() {
        for(int i = 0; i < times; i++) {
            System.out.print(charToPrint);
//            Thread.yield();
        }
    }
}
class PrintNum implements Runnable {
    private int lastNum;
    public PrintNum(int n) {
        lastNum = n;
    }
    @Override
    public void run() {
//        Thread thread = new Thread(new PrintChar('c',40));
//        thread.start();
//        try {
            for (int i = 1; i <= lastNum; i++) {
                System.out.print(" " + i);
//                if (i == 50) {
//                    thread.join();
//                }
            }
//        } catch (InterruptedException e) {
//
//        }
    }
}
