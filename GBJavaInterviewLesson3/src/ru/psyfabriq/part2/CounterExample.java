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
			for (int i = 0; i < 10; i++) {
				counter.increment();
				System.out.println("Thread # " + threadId + " count : " + counter.print());

			}
		}
	}

	class Decrement implements Runnable {
		public void run() {
			long threadId = Thread.currentThread().getId();
			for (int i = 0; i < 10; i++) {
				counter.decrement();
				System.out.println("Thread # " + threadId + " count : " + counter.print());
			}
		}
	}

}
