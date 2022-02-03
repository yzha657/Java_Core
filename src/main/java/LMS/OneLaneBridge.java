package LMS;

public class OneLaneBridge {
    public static void main(String[] args) {
        Vehicle[] ve = new Vehicle[4];
        for(int i = 0; i < ve.length; i++){
            ve[i] = new Vehicle("East "+i);
        }

        Vehicle[] vw = new Vehicle[4];
        for(int i = 0; i < vw.length; i++){
            vw[i] = new Vehicle("West "+i);
        }

        for(int i = 0; i < 4; i++){
            ve[i].start();
            vw[i].start();
        }
    }
}



class Vehicle extends Thread{
    private String name;

    public Vehicle(String name){
        this.name = name;
    }

    @Override
    public void run() {
        synchronized (Vehicle.class){
            try {
                Thread.sleep(100);
                System.out.println("Vehicle " + name + " start passing bridge.");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Vehicle " + name + " passed the bridge.");
        }
    }
}
