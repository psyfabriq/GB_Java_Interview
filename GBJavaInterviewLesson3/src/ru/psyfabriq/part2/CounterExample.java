package ru.psyfabriq.part2;

public class CounterExample {

	Counter counter = new Counter(100);

	public CounterExample() {
		Thread producer = new Thread(new Increment());
		Thread consumer = new Thread(new Decrement());
		producer.start();
		consumer.start();
	}

	class Increment implements Runnable {
		public void run() {
			long threadId = Thread.currentThread().getId();
			for (int i = 0; i < 100; i++) {
				counter.increment();
				System.out.println("Thread # " + threadId + " count : " + counter.print());
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {}
			}
		}
	}

	class Decrement implements Runnable {
		public void run() {
			long threadId = Thread.currentThread().getId();
			for (int i = 0; i < 100; i++) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {}
				counter.decrement();
				System.out.println("Thread # " + threadId + " count : " + counter.print());
			}
		}
	}

}
