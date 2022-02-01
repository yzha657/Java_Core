package day5;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    /*
    ReentrantLock allows threads to enter into the lock on a resource more than once.
    When the thread first enters into the lock, a hold count is set to one.
    Before unlocking the thread can re-enter into lock again and every time hold count is incremented by one.
    For every unlock requests, hold count is decremented by one and when hold count is 0, the resource is unlocked.
    */

    static final int MAX_T = 2;
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        ExecutorService pool = Executors.newFixedThreadPool(MAX_T);
        Runnable[] ws = new Runnable[4];
        for(int i = 0; i < ws.length; i++){
            ws[i] = new Worker(lock, "Job"+ i);
            pool.execute(ws[i]);
        }
//        for(Runnable wi : ws){
//            pool.execute((Worker)wi);
//        }
        pool.shutdown();
    }


}

class Worker implements Runnable{
    String name;
    ReentrantLock lock;

    public Worker (ReentrantLock lock, String name){
        this.lock = lock;
        this.name = name;
    }

    @Override
    public void run() {
        boolean done = false;
        while(!done){
            boolean ans = lock.tryLock();

            if(ans){
                try{
                    Date d = new Date();
                    SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
                    System.out.println("task name - " + name + " outer lock acquired at " + ft.format(d) + " Doing outer work");

                    System.out.println("Lock Hold Count - " + lock.getHoldCount());
                    Thread.sleep(1500);

                    lock.lock();
                    try{
                        d = new Date();
                        System.out.println("task name - " + name + " inner lock acquired at " + ft.format(d) + " Doing inner work");
                        System.out.println("Lock Hold count - " + lock.getHoldCount());
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        System.out.println("task name - " + name + " releasing inner lock");
                        lock.unlock();
                    }

                    System.out.println("Lock Hold count - " + lock.getHoldCount());
                    System.out.println("task name - " + name + " work done");

                    done = true;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("task name - " + name + " releasing outer lock");
                    lock.unlock();
                }
                System.out.println("Lock Hold count - " + lock.getHoldCount());

            } else {
                System.out.println("task name - " + name + " waiting for lock");

                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
