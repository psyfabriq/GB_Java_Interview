package ru.psyfabriq.part1;

public class PingPong extends Thread {
	private static final Object lock = new Object();

	private final String printOut;

	public PingPong(String printOut) {
		super();
		this.printOut = printOut;
		
	}
	
    public void run(){
        while (true){
            synchronized(lock){
                System.out.println(this.printOut +" -->"+this.getId()); 
                lock.notifyAll();
                try {
                    lock.wait();
                } catch (InterruptedException e) {}
            }
        }
    }

}
