package day5;

public class SynchronizedTest {

    public static void main(String[] args) {
        Sender sender = new Sender();
        Sending s1 = new Sending("Message 1", sender);
        Sending s2 = new Sending("Message 2", sender);

        Sender sender2 = new Sender();
        Sending s3 = new Sending("Message 3", sender);

        s1.start();
        s2.start();
        s3.start();

        try{
            s1.join();
            s2.join();
            s3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}

class Sender{
    static int count = 0;

    //Class level lock on static variable count
    public synchronized static void addCount(){
        System.out.println("Number of sending requests: " + ++count);
    }

    public void send(String msg){
        System.out.println("Sending " + msg);
        try{
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(msg + " Sent");
    }
}

class Sending extends Thread{
    private String msg;
    Sender sender;

    Sending(String msg, Sender sender){
        this.msg = msg;
        this.sender = sender;
    }


    @Override
    public void run(){
        Sender.addCount();
        //Object level lock on sender;
        synchronized (sender){
            sender.send(msg);
        }
    }
}
