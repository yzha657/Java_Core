package LMS;

import java.io.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Assignment4 {
    public static void main(String[] args) {
        BlockingQueue<String> bq = new ArrayBlockingQueue<String>(1024);
        Reader r = new Reader(bq);
        Writer w = new Writer(bq);

        new Thread(r).start();
        new Thread(w).start();
    }
}

class Reader implements Runnable{
    protected BlockingQueue<String> bq;

    public Reader(BlockingQueue<String> bq){
        this.bq = bq;
    }

    private String calculate(String s){
        String[] ops = s.split(" ");
        int i = 0;
        int sign = 1;
        for(String op : ops){
            if(op.equals("")) return op;
            if(op.equals("+")) sign = 1;
            else if(op.equals("-")) sign = -1;
            else{
                i += sign * Integer.parseInt(op);
            }
        }
        return s + " = " + i;
    }

    @Override
    public void run() {
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(new File("./src/main/java/LMS/input.txt")));
            String buffer = null;
            while((buffer=br.readLine())!= null){
                bq.put(calculate(buffer));
            }
            bq.put("EOF");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class Writer implements Runnable{

    BlockingQueue<String> bq;

    public Writer(BlockingQueue<String> bq){
        this.bq = bq;
    }

    @Override
    public void run() {
        PrintWriter writer = null;
        try{
            writer = new PrintWriter(new File("./src/main/java/LMS/output.txt"));

            while(true){
                String buffer = bq.take();
                if(buffer.equals("EOF")) break;
                writer.println(buffer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }
}