package ru.psyfabriq.part2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {

	private final ReentrantLock lock;
	private final Condition cond;
	private final int max;

	public Counter(int max) {
		this.lock = new ReentrantLock();
		this.cond = lock.newCondition();
		this.max = max;
	}

	private int count = 0;

	public void increment() {
		lock.lock();

		try {
			while (count >= max)
				cond.await();

			count++;
			cond.signalAll();

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void decrement() {

		lock.lock();

		try {
			while (count < 1)
				cond.await();

			count--;
			cond.signalAll();

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public int print() {
		return count;
	}

}
