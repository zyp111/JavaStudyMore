package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConsumerProducer {
    private static Buffer buffer = new Buffer();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new ProducerTask());
        executorService.execute(new ConsumerTask());
        executorService.shutdown();
    }
    private  static class ProducerTask implements Runnable {
        @Override
        public void run() {
//            try {
                int i = 1;
                while(true) {
                    System.out.println("Producer writes " + i);
                    buffer.write(i++);
//                    Thread.sleep((int)Math.random() * 10000);
                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
    private static class ConsumerTask implements Runnable {
        @Override
        public void run() {
//            try {
                while(true) {
                    System.out.println("\t\t\tConsumer reads " + buffer.read());
//                    Thread.sleep((int)Math.random() * 10000);
                }
//            } catch(InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
    private static class Buffer {
        private static final int CAPACITY = 1;
        private java.util.LinkedList<Integer> queue = new java.util.LinkedList<>();

        private static Lock lock = new ReentrantLock();

        private static Condition notEmpty = lock.newCondition();
        private static Condition notFull = lock.newCondition();

        public void write(int value) {
            lock.lock();
            try {
                while(queue.size() == CAPACITY) {
                    System.out.println("Wait for notFull Condition");
                    notFull.await();
                }
                queue.offer(value);
                notEmpty.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public int read() {
            int i = 0;
            lock.lock();
            try {
                while (queue.isEmpty()) {
                    System.out.println("\t\t\tWait for notEmpty condition");
                    notEmpty.await();
                }
                i = queue.remove();
                notFull.signal();
            } catch(InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                return i;
            }
        }
    }
}

