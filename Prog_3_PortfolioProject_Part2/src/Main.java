/* Portfolio Project Part 2
 *  1. create main class
 *  	a. Initialize counter 
 *  	b. initialize count up and count down
 *  2. Create counter class
 *  	a. increment method
 *  	b. decrement method
 *  3. count up class
 *  	a. implement increment up to 20
 *  3. Count up class
 *  	a. implement decrement down to 0
 */	



public class Main {
    public static void main(String[] args) {
        Counter Counter = new Counter();

        Thread countUp = new Thread(new CountUp(Counter));
        Thread countDown = new Thread(new CountDown(Counter));
        
        countUp.start();
        
        try {
            countUp.join();
        } catch (InterruptedException e) {
            e.printStackTrace();}

        countDown.start();
        
        try {
            countDown.join();
        } catch (InterruptedException e) {
            e.printStackTrace();}
        
    System.out.println("");    
    System.out.println("end of program");}
}

class Counter {
    private int counter = 0;

    public synchronized void increment() {
        counter++;
        System.out.println("Count up: " + counter);}

    public synchronized void decrement() {
        counter--;
        System.out.println("Count down: " + counter);}
}

class CountUp implements Runnable {
    private final Counter Counter;

    public CountUp(Counter Counter) {
        this.Counter = Counter;}

    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            Counter.increment();
            try {
                Thread.sleep(300); 
            } catch (InterruptedException e) {
                e.printStackTrace();}
        }
    }
}

class CountDown implements Runnable {
    private final Counter Counter;

    public CountDown(Counter Counter) {
        this.Counter = Counter;}

    @Override
    public void run() {
        for (int i = 20; i >= 1; i--) {
            Counter.decrement();
            try {
                Thread.sleep(300); 
            } catch (InterruptedException e) {
                e.printStackTrace();}
        }
    }
}
